package com.iqiyi.qigsaw.sample.java;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.heflash.android.play.core.splitcompat.SplitCompat;

public class JavaSampleActivity extends Activity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        SplitCompat.installActivity(this);
        new Test().test();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_sample);
    }
}
