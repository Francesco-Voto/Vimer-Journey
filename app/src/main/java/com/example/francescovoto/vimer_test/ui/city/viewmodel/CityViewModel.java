package com.example.francescovoto.vimer_test.ui.city.viewmodel;

import android.databinding.ObservableBoolean;

import com.example.francescovoto.vimer_test.ui.common.rv.RecyclerViewViewModel;


abstract class CityViewModel extends RecyclerViewViewModel {

     public final ObservableBoolean mLoading;

     CityViewModel() {
        mLoading = new ObservableBoolean();
    }
}
