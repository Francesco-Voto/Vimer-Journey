package com.example.francescovoto.vimer_test.ui.details.viewmodel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.francescovoto.vimer_test.data.Constants;
import com.example.francescovoto.vimer_test.data.entities.City;
import com.example.francescovoto.vimer_test.data.entities.CityDetails;
import com.example.francescovoto.vimer_test.ui.details.interactor.DetailsInteractionInput;

import rx.Subscriber;

public class DetailsViewModelImpl extends DetailsViewModel {

    private final DetailsInteractionInput mInteractionInput;
    private String mCode;

    public DetailsViewModelImpl(DetailsInteractionInput interactionInput){
        this.mInteractionInput = interactionInput;
    }

    @Override
    public void onCreate(@Nullable State savedInstanceState, @Nullable Bundle extras) {
        if(extras != null)
            mCode = extras.getString(Constants.KEY);

    }

    @Override
    public void onStart() {

        mLoading.set(true);
        mInteractionInput.getDetails(new Subscriber<CityDetails>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                mLoading.set(false);
                Log.e(getClass().getName(), e.getMessage());
            }

            @Override
            public void onNext(CityDetails city) {

                mLoading.set(false);
                mCityDetailsObservableField.set(city);
            }
        },mCode);
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }
    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Nullable
    @Override
    public State onSaveInstanceState() {
        return null;
    }
}
