package com.moriahacky.imgcrslapp.imgcrslmodule;

import android.support.v4.app.FragmentActivity;

import javax.inject.Inject;

public class BaseActivity extends FragmentActivity {

    @Inject ScopedBus _scopedBus;

    @Override
    protected void onPause() {
        super.onPause();
        if (getBus() != null) {
            getBus().paused();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (getBus() != null) {
            getBus().resumed();
        }
    }

    public ScopedBus getBus() {
        return _scopedBus;
    }

}
