package com.example.francescovoto.vimer_test.data.network;



import com.google.gson.stream.MalformedJsonException;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

public abstract class WrapperSubscriber<T> extends Subscriber<T> {

    @Override
    public void onError(Throwable e) {

        if(e instanceof MalformedJsonException){
            onStatusError(NetworkStatus.SERVER_ERROR);
            return;
        }
        if(e instanceof IOException) {
            onStatusError(NetworkStatus.NO_INTERNET);
            return;
        }
        if(e instanceof HttpException) {
            if(((HttpException)e).code() == 504) {
                onStatusError(NetworkStatus.SERVER_UNREACHABLE);
                return;
            }

            onStatusError(NetworkStatus.SERVER_ERROR);
        }


        onStatusError(NetworkStatus.SERVER_UNKNOWN);
    }

    public abstract void onStatusError(@NetworkStatus.Status int networkStatus);

}
