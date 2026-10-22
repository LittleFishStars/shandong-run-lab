package com.kc.openset.ad.full;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.BaseOSETAdImp;
import com.kc.openset.ad.d;
import com.kc.openset.ad.listener.OSETFullVideoListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OSETFullAd extends BaseOSETAdImp {
    static {
        OSETSDKProtected.interface11(3857);
    }

    public OSETFullAd(d dVar, d dVar2) {
        super(dVar, dVar2);
    }

    public native void showAd(Activity activity, OSETFullVideoListener oSETFullVideoListener);
}
