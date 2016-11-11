package com.example.francescovoto.vimer_test.ui.city.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.example.francescovoto.vimer_test.ui.common.rv.RecyclerViewViewModel;


abstract class CityViewModel extends RecyclerViewViewModel {

    public final ObservableBoolean mLoading;
    public final ObservableInt mStatus;

    CityViewModel() {
        mLoading = new ObservableBoolean();
        mStatus = new ObservableInt();
    }
}
