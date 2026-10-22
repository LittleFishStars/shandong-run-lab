package com.kc.openset.ad.splash;

import android.app.Activity;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.BaseOSETAdImp;
import com.kc.openset.ad.d;
import com.kc.openset.ad.listener.OSETSplashListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OSETSplashAd extends BaseOSETAdImp {
    static {
        OSETSDKProtected.interface11(3900);
    }

    public OSETSplashAd(d dVar, d dVar2) {
        super(dVar, dVar2);
    }

    public native void showAd(Activity activity, ViewGroup viewGroup, OSETSplashListener oSETSplashListener);
}
