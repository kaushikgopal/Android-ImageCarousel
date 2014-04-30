package com.moriahacky.imgcrslapp.imgcrslmodule;

import android.os.Handler;

import java.lang.ref.WeakReference;

public class BaseHandler {

    /**
     * Use this handler to prevent leaks
     */
    public abstract static class StaticHandler<T> {

        private final static Handler mHandler = new Handler();
        public static Runnable mStaticRunnable;
        private final WeakReference<T> mReference;

        public StaticHandler(WeakReference<T> objectForFutureReference) {
            super();

            mReference = objectForFutureReference;
            mStaticRunnable = new Runnable() {

                @Override
                public void run() {
                    codeToRun();
                }
            };
        }

        protected abstract void codeToRun();

        public void postDelayed(long delayInMillis) {
            mHandler.postDelayed(mStaticRunnable, delayInMillis);
        }

        public T getWeaklyStoredObject() {
            return mReference.get();
        }
    }
}
