package com.iqiyi.qigsaw.sample

import android.content.Context
import android.content.res.Resources
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitinstall.SplitInstallHelper

/**
 * @author LiuKe(Lynn)
 * @date 2021/2/9
 */
class DynamicImpl:IDynamic {
    override fun attachBaseContext(context: Context) {
        SplitCompat.install(context)
    }

    override fun onCreate() {

    }

    override fun onGetResources(resources: Resources) {

    }
}