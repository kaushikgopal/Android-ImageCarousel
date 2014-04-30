package com.moriahacky.imgcrslapp.imgcrslmodule;

import android.app.Application;

import timber.log.Timber;

public class BaseApplication
        extends Application {

    private static BaseApplication _instance;

    public static BaseApplication getInstance() {
        return _instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new CrashReportingTree());
    }
}
