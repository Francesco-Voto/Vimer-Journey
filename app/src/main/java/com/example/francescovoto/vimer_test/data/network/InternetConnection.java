package com.example.francescovoto.vimer_test.data.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

public class InternetConnection {

    private final Context mContext;

    public InternetConnection(Context context){
        this.mContext = context;
    }

    /**
     * It sends the status once and calls onComplete()
     */
    public Observable<Boolean> isInternetOn() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return Observable.just(activeNetworkInfo != null && activeNetworkInfo.isConnected());
    }

    /**
     * An Observable keeps emitting current state of Network, it has a Broadcast receiver and it will keep sending onNext()
     * when network status changes.

     public Observable<Boolean> isInternetOn() {
     final IntentFilter filter = new IntentFilter();
     filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

     return Observable.create(new Observable.OnSubscribe<Boolean>() {
    @Override
    public void call(final Subscriber<? super Boolean> subscriber) {
    final BroadcastReceiver receiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
    ConnectivityManager cm = (ConnectivityManager)
    context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    subscriber.onNext(netInfo != null && netInfo.isConnected());
    }
    };

    mContext.registerReceiver(receiver, filter);

    subscriber.add(unsubscribeInUiThread(() -> mContext.unregisterReceiver(receiver)));
    }
    }).defaultIfEmpty(false);
     }

     private Subscription unsubscribeInUiThread(final Action0 unsubscribe) {
     return Subscriptions.create(() -> {
     if (Looper.getMainLooper() == Looper.myLooper()) {
     unsubscribe.call();
     } else {
     final Scheduler.Worker inner = AndroidSchedulers.mainThread().createWorker();
     inner.schedule(() -> {
     unsubscribe.call();
     inner.unsubscribe();
     });
     }
     });
     }
     */
}
