package com.heflash.android.play.core.remote;

import androidx.annotation.RestrictTo;

import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;

@RestrictTo(LIBRARY_GROUP)
public interface OnBinderDiedListener {

    void onBinderDied();

}
