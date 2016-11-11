package com.example.francescovoto.vimer_test.ui.city.interactor;


import com.example.francescovoto.vimer_test.data.entities.City;
import com.example.francescovoto.vimer_test.data.network.API.ProductAPI;
import com.example.francescovoto.vimer_test.data.network.InternetConnection;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class CityInteraction implements CityInteractionInput {

    private final ProductAPI mProductAPI;
    private final InternetConnection mInternetConnection;

    public CityInteraction(ProductAPI productAPI, InternetConnection internetConnection){
        this.mProductAPI = productAPI;
        this.mInternetConnection = internetConnection;

    }

    @Override
    public void getCity(Subscriber<City[]> subscriber) {
        mInternetConnection.isInternetOn()
                .filter(connection -> connection)
                .switchMap(connectionStatus ->
                        mProductAPI.getCategories()
                )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

}
