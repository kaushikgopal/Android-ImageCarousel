package com.micromobs.pkk;

import com.crashlytics.android.Crashlytics;
import com.crittercism.app.Crittercism;

import timber.log.Timber;

public class CrashReportingTree
    extends Timber.HollowTree {

    @Override
    public void i(String message, Object... args) {
        Crashlytics.log(String.format(message, args));
    }

    @Override
    public void e(String message, Object... args) {
        i("Caught Error: " + message, args);

        PkkTracker.trackAppException(Globals.getGlobalApplicationContext(),
                                     "crash_or_exception",
                                     message);
    }

    @Override
    public void e(Throwable t, String message, Object... args) {
        // TODO: notify user something went wrong
        e(message, args);

        Crashlytics.logException(t);
        Crittercism.logHandledException(t);
    }
}
