package com.example.francescovoto.vimer_test.di.modules;

import com.example.francescovoto.vimer_test.data.network.API.ProductAPI;
import com.example.francescovoto.vimer_test.di.scopes.PerModule;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class APIModule {

    @PerModule
    @Provides
    ProductAPI provideRequestAPI(Retrofit retrofit) {
        return retrofit.create(ProductAPI.class);
    }

}