package com.example.francescovoto.vimer_test.ui.city.interactor;


import com.example.francescovoto.vimer_test.data.entities.City;

import rx.Subscriber;

public interface CityInteractionInput {
    void getCity(Subscriber<City[]> subscriber);
}
