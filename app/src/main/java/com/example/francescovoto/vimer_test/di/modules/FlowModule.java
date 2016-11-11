package com.example.francescovoto.vimer_test.di.modules;

import android.app.Activity;

import com.example.francescovoto.vimer_test.data.network.API.ProductAPI;
import com.example.francescovoto.vimer_test.data.network.InternetConnection;
import com.example.francescovoto.vimer_test.di.scopes.PerModule;
import com.example.francescovoto.vimer_test.ui.city.interactor.CityInteraction;
import com.example.francescovoto.vimer_test.ui.city.interactor.CityInteractionInput;
import com.example.francescovoto.vimer_test.ui.city.viewmodel.CityViewModel;
import com.example.francescovoto.vimer_test.ui.city.viewmodel.CityViewModelImpl;
import com.example.francescovoto.vimer_test.ui.city.wireframe.CityWireframe;
import com.example.francescovoto.vimer_test.ui.details.interactor.DetailsInteraction;
import com.example.francescovoto.vimer_test.ui.details.interactor.DetailsInteractionInput;
import com.example.francescovoto.vimer_test.ui.details.viewmodel.DetailsViewModel;
import com.example.francescovoto.vimer_test.ui.details.viewmodel.DetailsViewModelImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class FlowModule {

    private final Activity mActivity;

    public FlowModule(Activity activity) {
        this.mActivity = activity;
    }

    /**
     *City Module
     */
    @PerModule
    @Provides
    CityInteractionInput provideCategoryInteractor(ProductAPI productAPI) {
        return new CityInteraction(productAPI);
    }

    @PerModule
    @Provides
    CityWireframe provideWireframe() {
        return new CityWireframe(mActivity);
    }

    @PerModule
    @Provides
    CityViewModel provideCategoryViewModel(CityInteractionInput categoryInteractionInput, CityWireframe cityWireframe) {
        return new CityViewModelImpl(categoryInteractionInput, cityWireframe);
    }

    /**
     * Details Module
     */
    @PerModule
    @Provides
    DetailsInteractionInput provideDetailsInteractionInput(ProductAPI productAPI) {
        return new DetailsInteraction(productAPI);
    }

    @PerModule
    @Provides
    DetailsViewModel provideDetailsViewModel(DetailsInteractionInput detailsInteractionInput) {
        return new DetailsViewModelImpl(detailsInteractionInput);
    }

}
