package com.kc.openset.ad.reward;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.BaseOSETAdImp;
import com.kc.openset.ad.d;
import com.kc.openset.ad.listener.OSETRewardListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OSETRewardAd extends BaseOSETAdImp {
    static {
        OSETSDKProtected.interface11(3895);
    }

    public OSETRewardAd(d dVar, d dVar2) {
        super(dVar, dVar2);
    }

    public native void showAd(Activity activity, OSETRewardListener oSETRewardListener);
}
