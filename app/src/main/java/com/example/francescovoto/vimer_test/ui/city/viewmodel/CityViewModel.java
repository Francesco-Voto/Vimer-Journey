package com.example.francescovoto.vimer_test.ui.city.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;

import com.example.francescovoto.vimer_test.ui.common.rv.RecyclerViewViewModel;


public abstract class CityViewModel extends RecyclerViewViewModel {

    public final ObservableBoolean mLoading;
    public final ObservableInt mStatus;
    public final ObservableBoolean mStatusVisibility;

    public abstract void onRefresh();

    CityViewModel() {
        mLoading = new ObservableBoolean();
        mStatus = new ObservableInt();
        mStatusVisibility = new ObservableBoolean();
    }
}
