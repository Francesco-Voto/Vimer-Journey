package com.example.francescovoto.vimer_test.ui.city.interactor;


import com.example.francescovoto.vimer_test.data.entities.City;
import com.example.francescovoto.vimer_test.data.network.DefaultWrapperSubscriber;

public interface CityInteractionInput {
    void getCity(DefaultWrapperSubscriber<City[]> subscriber);
}
