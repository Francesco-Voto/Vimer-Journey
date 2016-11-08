package com.example.francescovoto.vimer_test.ui.details.interactor;


import com.example.francescovoto.vimer_test.data.entities.CityDetails;

import rx.Subscriber;

public interface DetailsInteractionInput {
    void getDetails(Subscriber<CityDetails> subscriber,String name);
}
