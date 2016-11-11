package com.example.francescovoto.vimer_test.ui.details.interactor;


import com.example.francescovoto.vimer_test.data.entities.CityDetails;
import com.example.francescovoto.vimer_test.data.network.API.ProductAPI;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DetailsInteraction implements DetailsInteractionInput{

    private final ProductAPI mProductAPI;

    public DetailsInteraction(ProductAPI productAPI){
        this.mProductAPI = productAPI;
    }

    @Override
    public void getDetails(Subscriber<CityDetails> subscriber, String name) {
        mProductAPI.getCityDetails(name)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
