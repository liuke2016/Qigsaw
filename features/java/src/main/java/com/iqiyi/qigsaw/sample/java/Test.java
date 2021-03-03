package com.iqiyi.qigsaw.sample.java;

import android.util.Log;

/**
 * @author LiuKe(Lynn)
 * @date 2021/3/2
 */
class Test {
    public void test(){
        Runnable runnable = ()-> Log.d("JavaSampleActivity","run:"+Test.this.toString());
        new Thread(runnable).start();
    }
}
