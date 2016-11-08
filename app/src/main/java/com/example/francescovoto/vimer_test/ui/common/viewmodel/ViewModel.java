package com.example.francescovoto.vimer_test.ui.common.viewmodel;


import android.databinding.BaseObservable;

import org.parceler.Parcel;

/**
 * Base ViewModel class to implement.
 * <p>BR</p>
 * The {@link ViewModel.State} serves to save the current state of wrapped objects.
 * It must be @Parcel to be saved as instanceState by activity
 * <p>BR</p>
 * The calls {@link ViewModel#onStart} and {@link ViewModel#onStop} work to map the viewModel with the lifecycle of Activity/Fragment.
 */
public abstract class ViewModel extends BaseObservable implements ViewLifecycleInterface {

    protected ViewModel(){}

    @Parcel
    public static class State{

        public State(){}
    }
}
