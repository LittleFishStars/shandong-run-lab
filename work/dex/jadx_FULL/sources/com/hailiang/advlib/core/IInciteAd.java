package com.hailiang.advlib.core;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface IInciteAd {
    void ReportBootstrapFeature(int[] iArr);

    void doWhenReflect(Activity activity);

    void onActivityResultRef(int i, int i2, Intent intent);

    void onDestroyRef(Activity activity);

    boolean onKeyEvent(int i, KeyEvent keyEvent);

    void onPauseRef(Activity activity);

    void onResumeRef(Activity activity);

    void onStartRef(Activity activity);

    void onStopRef(Activity activity);

    void whenPermDialogReturns(int i, String[] strArr, int[] iArr);
}
