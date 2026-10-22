package com.kwad.sdk.api.proxy;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Keep
public interface KSLifecycleListener {
    @Keep
    void onActivityCreated(Activity activity, Bundle bundle);

    @Keep
    void onActivityDestroyed(Activity activity);

    @Keep
    void onActivityPaused(Activity activity);

    @Keep
    void onActivityResumed(Activity activity);

    @Keep
    void onActivityStopped(Activity activity);

    @Keep
    void onBackToBackground();

    @Keep
    void onBackToForeground();
}
