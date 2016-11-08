package com.example.francescovoto.vimer_test.di.components;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.francescovoto.vimer_test.di.modules.AppModule;
import com.example.francescovoto.vimer_test.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules={NetModule.class, AppModule.class})
public interface NetComponent {

    Context provideContext();
    SharedPreferences provideSharedPreferences();
    Retrofit provideRetrofit();

}
