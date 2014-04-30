package com.moriahacky.imgcrslapp.imgcrslmodule;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import java.util.HashSet;
import java.util.Set;

public class ScopedBus {

    private static final Bus _bus = new Bus(ThreadEnforcer.ANY);
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Set<Object> objects = new HashSet<Object>();
    private boolean active;

    public void register(Object obj) {
        objects.add(obj);
        if (active) {
            _bus.register(obj);
        }
    }

    public void unregister(Object obj) {
        objects.remove(obj);
        if (active) {
            _bus.unregister(obj);
        }
    }

    public void paused() {
        active = false;
        for (Object obj : objects) {
            _bus.unregister(obj);
        }
    }

    public void resumed() {
        active = true;
        for (Object obj : objects) {
            _bus.register(obj);
        }
    }

    public void post(Object event) {
        _bus.post(event);
    }

    public void postOnUiThread(final Object event) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            post(event);
        } else {
            mHandler.post(new Runnable() {

                @Override
                public void run() {
                    post(event);
                }
            });
        }
    }
}
