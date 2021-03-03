package com.heflash.android.play.core.splitinstall;

import android.os.Bundle;

import com.heflash.android.play.core.tasks.TaskWrapper;

final class DeferredUninstallCallback extends SplitInstallServiceCallbackImpl<Void> {

    DeferredUninstallCallback(SplitInstallService splitInstallService, TaskWrapper<Void> task) {
        super(splitInstallService, task);
    }

    @Override
    public void onDeferredUninstall(Bundle data) {
        super.onDeferredUninstall(data);
        mTask.setResult(null);
    }
}
