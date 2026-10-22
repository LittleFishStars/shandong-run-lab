package com.kc.openset.ad.reward;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class OSETRewardVideo extends BaseRewardVideo<OSETRewardVideo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile OSETRewardVideo f39657a;

    static {
        OSETSDKProtected.interface11(3896);
    }

    private OSETRewardVideo() {
    }

    public static native OSETRewardVideo getInstance();

    @Override // com.kc.openset.ad.base.BaseAd
    public native void startLoad();
}
