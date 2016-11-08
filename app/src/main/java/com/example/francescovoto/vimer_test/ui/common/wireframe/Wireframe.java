package com.example.francescovoto.vimer_test.ui.common.wireframe;

import android.app.Activity;
import android.content.Intent;

import com.example.francescovoto.vimer_test.data.Constants;
import com.example.francescovoto.vimer_test.ui.details.view.DetailsActivity;


public abstract class Wireframe {

    protected final Activity mActivity;

    protected Wireframe(Activity activity) {
        mActivity = activity;
    }
}
