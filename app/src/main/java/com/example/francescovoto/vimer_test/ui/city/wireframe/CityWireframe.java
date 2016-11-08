package com.example.francescovoto.vimer_test.ui.city.wireframe;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import com.example.francescovoto.vimer_test.R;
import com.example.francescovoto.vimer_test.data.Constants;
import com.example.francescovoto.vimer_test.ui.common.wireframe.Wireframe;
import com.example.francescovoto.vimer_test.ui.details.view.DetailsActivity;


public class CityWireframe extends Wireframe {

    public CityWireframe(Activity activity) {
        super(activity);
    }

    public void launchDetails(String name, View v) {
        Intent intent = new Intent(mActivity, DetailsActivity.class);
        intent.putExtra(Constants.KEY, name);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(mActivity, v, mActivity.getString(R.string.transition_image));
        mActivity.startActivity(intent,options.toBundle());
    }
}
