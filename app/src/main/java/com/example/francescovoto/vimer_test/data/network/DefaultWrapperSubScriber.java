package com.example.francescovoto.vimer_test.data.network;


import static com.example.francescovoto.vimer_test.data.network.NetworkStatus.NO_INTERNET;
import static com.example.francescovoto.vimer_test.data.network.NetworkStatus.SERVER_ERROR;
import static com.example.francescovoto.vimer_test.data.network.NetworkStatus.SERVER_UNKNOWN;
import static com.example.francescovoto.vimer_test.data.network.NetworkStatus.SERVER_UNREACHABLE;

/**
 * Default wrapper implementing {@link WrapperSubscriber} to map errors in right place.
 * {@link NetworkStatus} is read and basing on the error return one of the following methods is called:
 *
 *  - {@link #onErrorServerUnreachable}
 *  - {@link #onErrorNoInternet}
 *  - {@link #onErrorInternalServerError}
 *  - {@link #onErrorServerUnknown}
 *
 *  In a way to allow an easy implementation avoiding boiling plate the {@link #onErrorCompleted}
 *  is called after one of the other, so common actions can be put just in one place
 *
 *  <p>
 *  This Wrapper should be as {@link rx.Subscriber}
 *  </p>
 *
 * @param <T> the class to pass for wrapper
 */

public abstract class DefaultWrapperSubscriber<T> extends WrapperSubscriber<T>{

    @Override
    public void onStatusError(@NetworkStatus.Status int networkStatus) {
        switch (networkStatus) {
            case NO_INTERNET:
                onErrorNoInternet();
                break;
            case SERVER_UNREACHABLE:
                onErrorServerUnreachable();
                break;
            case SERVER_ERROR:
                onErrorInternalServerError();
                break;
            case SERVER_UNKNOWN:
            default:
                onErrorServerUnknown();
                break;
        }
        onErrorCompleted();
    }

    public abstract void onErrorServerUnreachable();
    public abstract void onErrorServerUnknown();
    public abstract void onErrorNoInternet();
    public abstract void onErrorInternalServerError();

    public abstract void onErrorCompleted();
}
