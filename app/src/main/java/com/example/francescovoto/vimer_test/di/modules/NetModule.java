package com.example.francescovoto.vimer_test.di.modules;

import android.content.Context;

import com.example.francescovoto.vimer_test.data.network.InternetConnection;
import com.example.francescovoto.vimer_test.data.network.ManagerInterceptor;
import com.example.francescovoto.vimer_test.data.network.NetworkStatus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

@Module
public class NetModule {

    private static final int CACHE = 200 * 1024 * 1024; // 200 MB
    private static final int TIMEOUT = 60000;
    private static final String BASE_URL = "https://raw.githubusercontent.com/Francesco-Voto/staticComponent/master/";

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    Cache provideOkHttpCache(Context context) {
        return new Cache(context.getCacheDir(), CACHE);
    }

    @Provides
    @Singleton
    Gson provideJsonFactory() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache, NetworkStatus networkStatus) {
        return new OkHttpClient
                .Builder()
                .cache(cache)
                .addInterceptor(new ManagerInterceptor(networkStatus))
                .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
    }

    @Provides
    @Singleton
    NetworkStatus provideNetworkManager() {
        return new NetworkStatus();
    }

    @Provides
    @Singleton
    InternetConnection provideInternetConnection(Context context) {
        return new InternetConnection(context);
    }
}
