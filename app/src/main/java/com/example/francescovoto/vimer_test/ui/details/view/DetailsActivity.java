package com.example.francescovoto.vimer_test.ui.details.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.francescovoto.vimer_test.R;
import com.example.francescovoto.vimer_test.databinding.ActivityDetailsBinding;
import com.example.francescovoto.vimer_test.di.components.ModuleComponent;
import com.example.francescovoto.vimer_test.ui.common.view.BaseActivity;
import com.example.francescovoto.vimer_test.ui.common.viewmodel.ViewLifecycleInterface;
import com.example.francescovoto.vimer_test.ui.details.viewmodel.DetailsViewModel;

import javax.inject.Inject;

public class DetailsActivity extends BaseActivity {

    @Inject
    DetailsViewModel mDetailsViewModel;


    @Override
    protected void doInjection(ModuleComponent moduleComponent) {
        moduleComponent.inject(this);
        final ActivityDetailsBinding activityDetailsBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_details);
        activityDetailsBinding.setModel(mDetailsViewModel);

        final Toolbar toolbar = activityDetailsBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected ViewLifecycleInterface getLifeCycleEventDelegate() {
        return mDetailsViewModel;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            onBackPressed();
            supportFinishAfterTransition();
            return false;
        }else
            return super.onOptionsItemSelected(item);
    }
}
