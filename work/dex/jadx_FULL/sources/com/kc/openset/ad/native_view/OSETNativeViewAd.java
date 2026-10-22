package com.kc.openset.ad.native_view;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.NativeViewConfig;
import com.kc.openset.ad.base.BaseOSETAdImp;
import com.kc.openset.ad.d;
import com.kc.openset.ad.listener.OSETNativeViewListener;
import com.kc.openset.sdk.adv.OSETQDNativeViewAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OSETNativeViewAd extends BaseOSETAdImp {
    static {
        OSETSDKProtected.interface11(3891);
    }

    public OSETNativeViewAd(d dVar, d dVar2) {
        super(dVar, dVar2);
    }

    public native OSETQDNativeViewAd getQDNativeViewAd();

    public native void render(Activity activity, NativeViewConfig nativeViewConfig, OSETNativeViewListener oSETNativeViewListener);
}
