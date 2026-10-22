package com.kc.openset.ad.draw;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class c extends a<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f39645a;

    static {
        OSETSDKProtected.interface11(3855);
    }

    private c() {
    }

    public static native c a();

    public native c a(Context context);

    @Override // com.kc.openset.ad.base.BaseAd
    public native void startLoad();
}
