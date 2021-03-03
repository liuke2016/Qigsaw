package com.heflash.android.play.core.tasks;

public interface OnCompleteListener<TResult> {

    /**
     * Called when the Task completes.
     */
    void onComplete(Task<TResult> task);
}
