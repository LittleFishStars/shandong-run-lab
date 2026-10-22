package com.efs.sdk.memoryinfo;

import android.app.Activity;
import android.content.Context;
import com.efs.sdk.base.EfsReporter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface UMMemoryMonitorApi {
    String getCurrentActivity();

    boolean isEnable();

    boolean isForeground();

    void onActivityResumed(Activity activity);

    void onActivityStarted(Activity activity);

    void onActivityStopped(Activity activity);

    void setEnable(boolean z);

    void start(Context context, EfsReporter efsReporter);
}
