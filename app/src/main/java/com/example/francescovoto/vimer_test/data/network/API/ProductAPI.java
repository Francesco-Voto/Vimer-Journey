package com.example.francescovoto.vimer_test.data.network.API;

import com.example.francescovoto.vimer_test.data.entities.City;
import com.example.francescovoto.vimer_test.data.entities.CityDetails;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ProductAPI {

    @GET("static.json")
    Observable<City[]> getCategories();

    @GET("{name}")
    Observable<CityDetails> getCityDetails(@Path("name") String name);

}