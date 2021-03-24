package com.iqiyi.qigsaw.sample

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import com.iqiyi.android.qigsaw.core.Qigsaw
import com.iqiyi.android.qigsaw.core.SplitActivityLifecycleCallbacks
import com.iqiyi.android.qigsaw.core.SplitConfiguration
import com.iqiyi.android.qigsaw.core.splitload.SplitLoad
import com.iqiyi.android.qigsaw.core.splitreport.SplitBriefInfo
import com.iqiyi.qigsaw.sample.downloader.SampleDownloader
import com.iqiyi.qigsaw.sample.reporter.*
import com.playit.videoplayer.QigsawConfig

/**
 * @author LiuKe(Lynn)
 * @date 2021/2/9
 */
class DynamicImpl:IDynamic {

    override fun attachBaseContext(context: Context) {
        val configuration = SplitConfiguration.newBuilder()
                .splitLoadMode(SplitLoad.MULTIPLE_CLASSLOADER)
                .logger(SampleLogger())
                .verifySignature(true)
                .loadReporter(SampleSplitLoadReporter(context))
                .installReporter(SampleSplitInstallReporter(context))
                .uninstallReporter(SampleSplitUninstallReporter(context))
                .updateReporter(SampleSplitUpdateReporter(context))
                .obtainUserConfirmationDialogClass(SampleObtainUserConfirmationDialog::class.java)
                .build()
        Qigsaw.install(context, SampleDownloader(), configuration)
    }

    override fun onCreate() {
        Qigsaw.onApplicationCreated()
        Qigsaw.preloadInstalledSplits(listOf(*QigsawConfig.DYNAMIC_FEATURES))
        Qigsaw.registerSplitActivityLifecycleCallbacks(object : SplitActivityLifecycleCallbacks() {
            override fun onSplitActivityCreated(briefInfo: SplitBriefInfo, activity: Activity, savedInstanceState: Bundle?) {}
            override fun onSplitActivityStarted(briefInfo: SplitBriefInfo, activity: Activity) {}
            override fun onSplitActivityResumed(briefInfo: SplitBriefInfo, activity: Activity) {}
            override fun onSplitActivityPaused(briefInfo: SplitBriefInfo, activity: Activity) {}
            override fun onSplitActivityStopped(briefInfo: SplitBriefInfo, activity: Activity) {}
            override fun onSplitActivitySaveInstanceState(briefInfo: SplitBriefInfo, activity: Activity, outState: Bundle) {}
            override fun onSplitActivityDestroyed(briefInfo: SplitBriefInfo, activity: Activity) {}
        })
    }

    override fun onGetResources(resources: Resources) {
        Qigsaw.onApplicationGetResources(resources)
    }
}