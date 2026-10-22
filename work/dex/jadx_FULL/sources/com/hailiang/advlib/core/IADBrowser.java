package com.hailiang.advlib.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface IADBrowser {
    void doWhenReflect(Activity activity, Bundle bundle);

    void onActivityResultRef(int i, int i2, Intent intent);

    boolean onKeyEvent(int i, KeyEvent keyEvent);

    void whenPermDialogReturns(int i, String[] strArr, int[] iArr);
}
