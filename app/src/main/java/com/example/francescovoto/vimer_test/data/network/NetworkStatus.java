package com.example.francescovoto.vimer_test.data.network;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class NetworkStatus {

    public static final int NETWORK_OK = -1;

    public static final int NO_INTERNET = 0;
    public static final int SERVER_UNREACHABLE = 1;
    public static final int SERVER_ERROR = 2;
    public static final int SERVER_UNKNOWN = 3;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({NO_INTERNET, SERVER_UNKNOWN, SERVER_ERROR, SERVER_UNREACHABLE, NETWORK_OK })
    public @interface Status {}


}