package com.example.francescovoto.vimer_test.data.network;


import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ManagerInterceptor implements Interceptor {
    private final NetworkStatus mNetworkStatus;

    public ManagerInterceptor(NetworkStatus networkStatus){
        this.mNetworkStatus = networkStatus;
    }


    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        return response;
    }


}

