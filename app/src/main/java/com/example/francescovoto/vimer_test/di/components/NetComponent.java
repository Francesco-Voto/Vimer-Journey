package com.example.francescovoto.vimer_test.di.components;

import com.example.francescovoto.vimer_test.data.network.NetworkStatus;
import com.example.francescovoto.vimer_test.di.modules.AppModule;
import com.example.francescovoto.vimer_test.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules={NetModule.class, AppModule.class})
public interface NetComponent {

    Retrofit provideRetrofit();
    NetworkStatus provideNetworkManager();
}
