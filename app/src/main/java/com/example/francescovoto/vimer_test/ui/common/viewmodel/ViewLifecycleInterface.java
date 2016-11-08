package com.example.francescovoto.vimer_test.ui.common.viewmodel;

import android.os.Bundle;
import android.support.annotation.Nullable;

public interface ViewLifecycleInterface {

    void onCreate(@Nullable ViewModel.State savedInstanceState, @Nullable Bundle extras);

    void onStart();

    void onStop();

    void onDestroy();

    @Nullable ViewModel.State onSaveInstanceState();

}