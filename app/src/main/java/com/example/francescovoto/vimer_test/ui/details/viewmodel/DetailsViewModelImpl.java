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

        final Subscriber<CityDetails> subscriber = new Subscriber<CityDetails>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e(getClass().getName(), e.getMessage());
            }

            @Override
            public void onNext(CityDetails city) {
                mCityDetailsObservableField.set(city);
            }
        };

        this.mInteractionInput.setDetailsOutput(subscriber);
    }

    @Override
    public void onStart() {
        mInteractionInput.getDetails(mCode);
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Nullable
    @Override
    public State onSaveInstanceState() {
        return null;
    }
}
