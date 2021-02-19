package com.iqiyi.qigsaw.sample;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import androidx.multidex.MultiDex;

public class QigsawApplication extends Application {

    private static final String TAG = "QigsawApplication";


    private final IDynamic mDynamic = new DynamicImpl();
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
        mDynamic.attachBaseContext(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mDynamic.onCreate();
    }

    @Override
    public Resources getResources() {
        mDynamic.onGetResources(super.getResources());
        return super.getResources();
    }
}
