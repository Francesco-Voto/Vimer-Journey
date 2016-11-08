package com.example.francescovoto.vimer_test;

import android.app.Application;
import android.content.Context;

import com.example.francescovoto.vimer_test.di.components.AppComponent;
import com.example.francescovoto.vimer_test.di.components.DaggerAppComponent;
import com.example.francescovoto.vimer_test.di.modules.AppModule;
import com.example.francescovoto.vimer_test.di.modules.NetModule;


public class SessionApplication extends Application {

    public AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .build();

    }

    public static SessionApplication get(Context context) {
        return (SessionApplication) context.getApplicationContext();
    }

}