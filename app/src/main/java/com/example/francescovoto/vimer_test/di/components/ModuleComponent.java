package com.example.francescovoto.vimer_test.di.components;


import com.example.francescovoto.vimer_test.di.modules.APIModule;
import com.example.francescovoto.vimer_test.di.modules.FlowModule;
import com.example.francescovoto.vimer_test.di.scopes.PerModule;
import com.example.francescovoto.vimer_test.ui.city.view.MainActivity;
import com.example.francescovoto.vimer_test.ui.details.view.DetailsActivity;

import dagger.Component;

@PerModule
@Component(dependencies = AppComponent.class, modules = {APIModule.class, FlowModule.class})
public interface ModuleComponent {

    void inject(MainActivity mainActivity);
    void inject(DetailsActivity detailsActivity);

}