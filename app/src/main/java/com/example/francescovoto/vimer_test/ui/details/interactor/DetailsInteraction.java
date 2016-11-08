package com.example.francescovoto.vimer_test.ui.details.interactor;


import com.example.francescovoto.vimer_test.data.entities.CityDetails;
import com.example.francescovoto.vimer_test.data.network.API.ProductAPI;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DetailsInteraction implements DetailsInteractionInput{

    private final ProductAPI mProductAPI;
    private Subscriber<CityDetails> mSubscriber;

    public DetailsInteraction(ProductAPI productAPI){
        this.mProductAPI = productAPI;
    }

    @Override
    public void getDetails(String name) {
        mProductAPI.getCityDetails(name)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mSubscriber);

    }

    @Override
    public void setDetailsOutput(Subscriber<CityDetails> subscriber) {
        this.mSubscriber = subscriber;
    }
}
