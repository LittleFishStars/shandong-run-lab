package com.kc.openset.ad._native;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.BaseOSETAdImp;
import com.kc.openset.ad.d;
import com.kc.openset.ad.listener.OSETNativeListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OSETNativeAd extends BaseOSETAdImp {
    static {
        OSETSDKProtected.interface11(3723);
    }

    public OSETNativeAd(d dVar, d dVar2) {
        super(dVar, dVar2);
    }

    public native void render(Activity activity, OSETNativeListener oSETNativeListener);
}
