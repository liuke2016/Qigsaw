package com.heflash.android.play.core.tasks;

interface InvocationListener<TResult> {

    void invoke(Task<TResult> task);

}
