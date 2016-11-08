package com.example.francescovoto.vimer_test.ui.common.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.francescovoto.vimer_test.SessionApplication;
import com.example.francescovoto.vimer_test.data.Constants;
import com.example.francescovoto.vimer_test.di.components.DaggerModuleComponent;
import com.example.francescovoto.vimer_test.di.components.ModuleComponent;
import com.example.francescovoto.vimer_test.di.modules.APIModule;
import com.example.francescovoto.vimer_test.di.modules.FlowModule;
import com.example.francescovoto.vimer_test.ui.common.viewmodel.ViewLifecycleInterface;
import com.example.francescovoto.vimer_test.ui.common.viewmodel.ViewModel;

import org.parceler.Parcels;

public abstract class BaseActivity extends AppCompatActivity{

    protected ViewLifecycleInterface mLifeCycleEventDelegate;
    protected ViewModel.State mSavedViewModelState;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ModuleComponent moduleComponent = DaggerModuleComponent.builder()
                .appComponent(SessionApplication.get(this).mAppComponent)
                .aPIModule(new APIModule())
                .flowModule(new FlowModule(this))
                .build();

        doInjection(moduleComponent);

        this.mLifeCycleEventDelegate = getLifeCycleEventDelegate();

        this.mSavedViewModelState = null;
        if (savedInstanceState != null)
            mSavedViewModelState = Parcels.unwrap(savedInstanceState.getParcelable(Constants.VIEW_MODEL_STATE));

        mLifeCycleEventDelegate.onCreate(mSavedViewModelState, getIntent().getExtras());
    }

    protected abstract void doInjection(ModuleComponent moduleComponent);

    protected abstract ViewLifecycleInterface getLifeCycleEventDelegate();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(mLifeCycleEventDelegate != null)
            outState.putParcelable(Constants.VIEW_MODEL_STATE, Parcels.wrap(mLifeCycleEventDelegate.onSaveInstanceState()));
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mLifeCycleEventDelegate != null)
            mLifeCycleEventDelegate.onStart();
    }

    @Override
    public void onPause() {
        if(mLifeCycleEventDelegate != null)
            mLifeCycleEventDelegate.onStart();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        if(mLifeCycleEventDelegate != null)
            mLifeCycleEventDelegate.onDestroy();
        super.onDestroy();
    }
}
