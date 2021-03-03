package com.iqiyi.qigsaw.sample.ccode;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.heflash.android.play.core.splitcompat.SplitCompat;
import com.heflash.android.play.core.splitinstall.SplitInstallHelper;


public class NativeSampleActivity extends Activity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        SplitCompat.installActivity(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_sample);
        SplitInstallHelper.loadLibrary(this, "hello-jni");
        ((TextView) (findViewById(R.id.hello_textview))).setText(stringFromJNI());
    }

    public native String stringFromJNI();
}
