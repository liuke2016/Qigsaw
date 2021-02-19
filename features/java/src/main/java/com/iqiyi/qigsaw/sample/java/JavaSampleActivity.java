package com.iqiyi.qigsaw.sample.java;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.google.android.play.core.splitcompat.SplitCompat;

public class JavaSampleActivity extends Activity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        SplitCompat.installActivity(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_sample);
    }
}
