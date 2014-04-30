package com.moriahacky.imgcrslapp.imgcrslmodule;

import android.content.Intent;

public abstract class QueueClearableIntentService
    extends BaseIntentService {

    private final ScopedBus mScopedBus = new ScopedBus();
    private boolean mServiceAlreadyRunningInBg = false;

    public QueueClearableIntentService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getBus().register(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        if (!mServiceAlreadyRunningInBg) {
            mServiceAlreadyRunningInBg = true;
        } else {
            if (!intent.getBooleanExtra("isQueued", false)) {
                clearQueue();
            }
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getBus().unregister(this);
    }

    public ScopedBus getBus() {
        return mScopedBus;
    }
}
