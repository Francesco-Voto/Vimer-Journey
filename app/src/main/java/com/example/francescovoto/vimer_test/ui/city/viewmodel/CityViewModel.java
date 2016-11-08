package com.example.francescovoto.vimer_test.ui.city.viewmodel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.francescovoto.vimer_test.R;
import com.example.francescovoto.vimer_test.data.entities.City;
import com.example.francescovoto.vimer_test.databinding.ActivityMainBinding;
import com.example.francescovoto.vimer_test.ui.city.interactor.CityInteractionInput;
import com.example.francescovoto.vimer_test.ui.city.wireframe.CityWireframe;
import com.example.francescovoto.vimer_test.ui.common.rv.ClickHandler;
import com.example.francescovoto.vimer_test.ui.common.rv.RecyclerAdapter;
import com.example.francescovoto.vimer_test.ui.common.rv.RecyclerViewViewModel;

import rx.Subscriber;

public class CityViewModel extends RecyclerViewViewModel {

    private final CityInteractionInput mInteractionInput;
    private final CityWireframe mCityWireframe;

    private CategoryRecyclerAdapter mCategoryRecyclerAdapter;

    public CityViewModel(@NonNull CityInteractionInput categoryInteractionInput,@NonNull CityWireframe cityWireframe) {
        this.mInteractionInput = categoryInteractionInput;
        this.mCityWireframe = cityWireframe;

        final Subscriber<City[]> subscriber = new Subscriber<City[]>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e(getClass().getName(), e.getMessage());
            }

            @Override
            public void onNext(City[] cities) {
                mCategoryRecyclerAdapter.setDataSet(cities);
            }
        };

        this.mInteractionInput.setCityOutput(subscriber);
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
    public void onStart() {
        mInteractionInput.getCity();
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

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

    private class CategoryRecyclerAdapter extends RecyclerAdapter<City,ActivityMainBinding> {

        CategoryRecyclerAdapter(ClickHandler<City> clickHandler, int layout){
            super(layout,clickHandler);
        }

    }
}
