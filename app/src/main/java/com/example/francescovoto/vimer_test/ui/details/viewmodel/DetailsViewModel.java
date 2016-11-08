package com.example.francescovoto.vimer_test.ui.details.viewmodel;


import android.databinding.ObservableField;

import com.example.francescovoto.vimer_test.data.entities.CityDetails;
import com.example.francescovoto.vimer_test.ui.common.viewmodel.ViewModel;

public abstract class DetailsViewModel extends ViewModel{

    public final ObservableField<CityDetails> mCityDetailsObservableField;

    DetailsViewModel(){
        mCityDetailsObservableField = new ObservableField<>();
    }
}
