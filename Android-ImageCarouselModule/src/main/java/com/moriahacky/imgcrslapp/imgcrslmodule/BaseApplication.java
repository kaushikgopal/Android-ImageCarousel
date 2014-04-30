package com.moriahacky.imgcrslapp.imgcrslmodule;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import com.moriahacky.imgcrslapp.imgcrslmodule.data.modules.Modules;
import dagger.ObjectGraph;
import timber.log.Timber;

public class BaseApplication
        extends Application {

    private static BaseApplication _instance;
    private ObjectGraph _objectGraph;

    public static BaseApplication getInstance() {
        return _instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new CrashReportingTree());
        Crashlytics.start(this);

        _objectGraph = ObjectGraph.create(Modules.list(this));
    }
}
