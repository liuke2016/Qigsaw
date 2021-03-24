package com.heflash.android.play.core.splitcompat;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.heflash.android.play.core.splitinstall.SplitSessionStatusChanger;
import com.heflash.android.play.core.splitinstall.model.SplitInstallErrorCode;
import com.heflash.android.play.core.splitinstall.model.SplitInstallSessionStatus;
import com.iqiyi.android.qigsaw.core.common.ProcessUtil;
import com.iqiyi.android.qigsaw.core.splitload.SplitLoadManager;
import com.iqiyi.android.qigsaw.core.splitload.SplitLoadManagerService;
import com.iqiyi.android.qigsaw.core.splitload.listener.OnSplitLoadListener;

import java.util.List;

final class SplitLoadSessionTask implements Runnable, OnSplitLoadListener {

    private final List<Intent> splitFileIntents;

    private final SplitSessionStatusChanger changer;

    SplitLoadSessionTask(List<Intent> splitFileIntents, SplitSessionStatusChanger changer) {
        this.splitFileIntents = splitFileIntents;
        this.changer = changer;
    }

    @Override
    public void run() {
        if (splitFileIntents == null) {
            onFailed(SplitInstallErrorCode.INTERNAL_ERROR);
            return;
        }
        //load installed splits
        SplitLoadManager loadManager = SplitLoadManagerService.getInstance();
        if (loadManager != null) {
            Runnable splitLoadTask = loadManager.createSplitLoadTask(splitFileIntents, this);
            splitLoadTask.run();
        }
    }

    @Override
    public void onCompleted() {
        for (Intent splitFileIntent : splitFileIntents) {
            final String splitName = splitFileIntent.getStringExtra("splitName");
            SplitLoadManager loadManager = SplitLoadManagerService.getInstance();
            if(loadManager!=null){
                Context context = loadManager.getContext();
                context.getContentResolver().insert(Uri.parse("content://" + context.getPackageName() + ".IPCContentProvider/" + splitName+"#"+ ProcessUtil.getProcessName(context)), new ContentValues());
            }
        }
        changer.changeStatus(SplitInstallSessionStatus.INSTALLED);
    }

    @Override
    public void onFailed(int errorCode) {
        changer.changeStatus(SplitInstallSessionStatus.FAILED, errorCode);
    }
}
