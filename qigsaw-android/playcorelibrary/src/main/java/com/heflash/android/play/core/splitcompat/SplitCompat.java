package com.heflash.android.play.core.splitcompat;

import android.app.Activity;
import android.content.Context;

import com.heflash.android.play.core.splitinstall.LoadedSplitFetcherSingleton;
import com.heflash.android.play.core.splitinstall.SplitSessionLoaderSingleton;
import com.heflash.android.play.core.tasks.TaskExecutors;
import com.iqiyi.android.qigsaw.core.splitload.SplitLoadManager;
import com.iqiyi.android.qigsaw.core.splitload.SplitLoadManagerService;

import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class SplitCompat {

    private static final AtomicReference<SplitCompat> sSplitCompatReference = new AtomicReference<>(null);

    private SplitCompat() {

    }

    public static boolean install(Context context) {
        return installInternal(context);
    }

    public static void installActivity(Activity activity){
    }

    @SuppressWarnings("unused")
    private static boolean installInternal(final Context context) {
        if (sSplitCompatReference.compareAndSet(null, new SplitCompat())) {
            final SplitCompat compat = sSplitCompatReference.get();
            SplitSessionLoaderSingleton.set(new SplitSessionLoaderImpl(TaskExecutors.MAIN_THREAD));
            LoadedSplitFetcherSingleton.set(new LoadedSplitFetcherImpl(compat));
        }
        return true;
    }

    static boolean hasInstance() {
        return sSplitCompatReference.get() != null;
    }

    final Set<String> getLoadedSplits() {
        SplitLoadManager loadManager = SplitLoadManagerService.getInstance();
        return loadManager.getLoadedSplitNames();
    }

}
