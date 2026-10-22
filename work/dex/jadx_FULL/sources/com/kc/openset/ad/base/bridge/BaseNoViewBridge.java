package com.kc.openset.ad.base.bridge;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class BaseNoViewBridge extends BaseAdBridge {
    static {
        OSETSDKProtected.interface11(3780);
    }

    public native void doAdClick();

    public native void doAdClose();

    public native void doAdDetailViewClosed();

    public native void doAdImp();
}
