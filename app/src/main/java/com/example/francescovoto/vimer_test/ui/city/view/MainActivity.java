package com.example.francescovoto.vimer_test.ui.city.view;

import android.databinding.DataBindingUtil;

import com.example.francescovoto.vimer_test.R;
import com.example.francescovoto.vimer_test.databinding.ActivityMainBinding;
import com.example.francescovoto.vimer_test.di.components.ModuleComponent;
import com.example.francescovoto.vimer_test.ui.city.viewmodel.CityViewModel;
import com.example.francescovoto.vimer_test.ui.common.view.BaseActivity;
import com.example.francescovoto.vimer_test.ui.common.viewmodel.ViewLifecycleInterface;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    CityViewModel mCategoryViewModel;

    @Override
    protected void doInjection(ModuleComponent moduleComponent) {
        moduleComponent.inject(this);
        final ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        activityMainBinding.setViewModel(mCategoryViewModel);
    }

    @Override
    protected ViewLifecycleInterface getLifeCycleEventDelegate() {
        return mCategoryViewModel;
    }

}