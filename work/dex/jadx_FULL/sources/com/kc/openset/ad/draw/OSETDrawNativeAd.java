package com.kc.openset.ad.draw;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.BaseOSETAdImp;
import com.kc.openset.ad.d;
import com.kc.openset.ad.listener.OSETDrawNativeListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OSETDrawNativeAd extends BaseOSETAdImp {
    static {
        OSETSDKProtected.interface11(3852);
    }

    public OSETDrawNativeAd(d dVar, d dVar2) {
        super(dVar, dVar2);
    }

    public native void render(Activity activity, OSETDrawNativeListener oSETDrawNativeListener);
}
