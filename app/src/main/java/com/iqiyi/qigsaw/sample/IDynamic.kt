package com.iqiyi.qigsaw.sample

import android.content.Context
import android.content.res.Resources

/**
 * @author LiuKe(Lynn)
 * @date 2021/2/9
 */
interface IDynamic {
    fun attachBaseContext(context: Context)

    fun onCreate()

    fun onGetResources(resources: Resources)
}