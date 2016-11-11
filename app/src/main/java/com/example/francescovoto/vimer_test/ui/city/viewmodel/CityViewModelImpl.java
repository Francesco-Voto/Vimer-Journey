package com.example.francescovoto.vimer_test.ui.city.viewmodel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.francescovoto.vimer_test.R;
import com.example.francescovoto.vimer_test.data.entities.City;
import com.example.francescovoto.vimer_test.data.network.DefaultWrapperSubscriber;
import com.example.francescovoto.vimer_test.databinding.ActivityMainBinding;
import com.example.francescovoto.vimer_test.ui.city.interactor.CityInteractionInput;
import com.example.francescovoto.vimer_test.ui.city.wireframe.CityWireframe;
import com.example.francescovoto.vimer_test.ui.common.rv.ClickHandler;
import com.example.francescovoto.vimer_test.ui.common.rv.RecyclerAdapter;

public class CityViewModelImpl extends CityViewModel {

    private final CityInteractionInput mInteractionInput;
    private final CityWireframe mCityWireframe;
    private City[] mCities;

    private CategoryRecyclerAdapter mCategoryRecyclerAdapter;

    public CityViewModelImpl(@NonNull CityInteractionInput categoryInteractionInput, @NonNull CityWireframe cityWireframe) {
        this.mInteractionInput = categoryInteractionInput;
        this.mCityWireframe = cityWireframe;

    }

    @Override
    protected RecyclerAdapter getAdapter() {
        return mCategoryRecyclerAdapter = new CategoryRecyclerAdapter(clickHandler(), R.layout.list_item_product);
    }

    @Override
    protected RecyclerView.LayoutManager createLayoutManager(Context context) {
        return new GridLayoutManager(context, context.getResources().getInteger(R.integer.grid_cell_number));
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStart() {
        if(mCities == null) {
            updateView();
        }

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    private void updateView(){
        mStatusVisibility.set(false);
        mLoading.set(true);
        mInteractionInput.getCity(new DefaultWrapperSubscriber<City[]>(){

            @Override
            public void onCompleted() {
                mLoading.set(false);
            }

            @Override
            public void onNext(City[] cities) {
                mStatusVisibility.set(false);
                if (cities.length == 0) {
                    mStatus.set(R.string.empty);
                    return;
                }
                mCategoryRecyclerAdapter.setDataSet(mCities = cities);
            }

            @Override
            public void onErrorServerUnreachable() {
                mStatus.set(R.string.network_error_unreachable);
            }

            @Override
            public void onErrorServerUnknown() {
                mStatus.set(R.string.network_error_unknown);
            }

            @Override
            public void onErrorNoInternet() {
                mStatus.set(R.string.network_error_no_internet);
            }

            @Override
            public void onErrorInternalServerError() {
                mStatus.set(R.string.network_error_error);
            }

            @Override
            public void onErrorCompleted() {
                mStatusVisibility.set(true);
                mLoading.set(false);
            }
        });
    }

    private ClickHandler<City> clickHandler()
    {
        return (category, v) ->{
            mCityWireframe.launchDetails(category.path, v.findViewById(R.id.image_city_list_item));
        };
    }


    @Nullable
    @Override
    public State onSaveInstanceState() {
        return null;
    }

    @Override
    public void onRefresh() {
        updateView();
    }

    private class CategoryRecyclerAdapter extends RecyclerAdapter<City,ActivityMainBinding> {

        CategoryRecyclerAdapter(ClickHandler<City> clickHandler, int layout){
            super(layout,clickHandler);
        }

    }
}
