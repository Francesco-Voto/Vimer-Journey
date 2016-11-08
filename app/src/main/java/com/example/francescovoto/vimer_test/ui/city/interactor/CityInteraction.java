package com.example.francescovoto.vimer_test.ui.city.interactor;


import com.example.francescovoto.vimer_test.data.entities.City;
import com.example.francescovoto.vimer_test.data.network.API.ProductAPI;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CityInteraction implements CityInteractionInput {

    private final ProductAPI mProductAPI;
    private Subscriber<City[]> mSubscriber;

    public CityInteraction(ProductAPI productAPI){
        this.mProductAPI = productAPI;

    }

    @Override
    public void getCity(Subscriber<City[]> subscriber) {
        mProductAPI.getCategories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

}
