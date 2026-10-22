package com.kc.openset.ad.reward;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class b extends BaseRewardVideo<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f39659a;

    static {
        OSETSDKProtected.interface11(3898);
    }

    private b() {
    }

    public static native b a();

    public native b a(Context context);

    @Override // com.kc.openset.ad.base.BaseAd
    public native void startLoad();
}
