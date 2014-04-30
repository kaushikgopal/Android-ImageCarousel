package com.moriahacky.imgcrslapp.imgcrslmodule.data.modules;

import android.content.Context;

import dagger.Module;

@Module
public class BaseModule {
    private final Context mAppContext;

    BaseModule(Context appContext) {
        mAppContext = appContext;
    }
}
