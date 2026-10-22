package com.kc.openset.sdk.apiad.tools;

import android.view.MotionEvent;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public abstract class OnAdTouchListener implements View.OnTouchListener {
    private i downEvent;
    private i upEvent;

    static {
        OSETSDKProtected.interface11(4878);
    }

    public native void clear();

    @Override // android.view.View.OnTouchListener
    public native boolean onTouch(View view, MotionEvent motionEvent);

    public abstract void touchAd(View view, i iVar, i iVar2);
}
