package com.kc.openset.sdk.apiad.tools;

import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public abstract class OnDoubleClickListener implements View.OnClickListener {
    private static final long DEFAULT_INTERVAL = 300;
    private long lastClickTime = 0;

    static {
        OSETSDKProtected.interface11(4879);
    }

    @Override // android.view.View.OnClickListener
    public native void onClick(View view);

    public abstract void onDoubleClick(View view);

    public native void onSingleClick(View view);
}
