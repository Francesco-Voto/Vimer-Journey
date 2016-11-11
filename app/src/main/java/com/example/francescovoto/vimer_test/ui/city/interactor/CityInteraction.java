package com.example.francescovoto.vimer_test.ui.city.interactor;


import com.example.francescovoto.vimer_test.data.entities.City;
import com.example.francescovoto.vimer_test.data.network.API.ProductAPI;
import com.example.francescovoto.vimer_test.data.network.DefaultWrapperSubscriber;
import com.example.francescovoto.vimer_test.data.network.InternetConnection;
import com.example.francescovoto.vimer_test.data.network.WrapperSubscriber;

import rx.android.schedulers.AndroidSchedulers;

public class CityInteraction implements CityInteractionInput {

    private final ProductAPI mProductAPI;

    public CityInteraction(ProductAPI productAPI){
        this.mProductAPI = productAPI;

    }

    @Override
    public void getCity(DefaultWrapperSubscriber<City[]> subscriber) {
        mProductAPI.getCategories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

}
