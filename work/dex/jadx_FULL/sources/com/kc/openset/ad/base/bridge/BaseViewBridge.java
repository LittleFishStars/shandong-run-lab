package com.kc.openset.ad.base.bridge;

import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class BaseViewBridge extends BaseAdBridge {
    static {
        OSETSDKProtected.interface11(3783);
    }

    public native void doAdClick(View view);

    public native void doAdClose(View view);

    public native void doAdDetailViewClosed();

    public native void doAdImp(View view);
}
