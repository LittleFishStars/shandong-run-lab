package com.kc.openset.ad.base;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.listener.OSETBaseListener;
import com.kc.openset.ad.listener.OSETInterstitialListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class e extends BaseAdLoad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AdType f39631a;
    private OSETInterstitialListener b;

    /* JADX INFO: renamed from: $r8$lambda$-4wXklt_q7cTBep9ftw_K9PBwEI, reason: not valid java name */
    public static native /* synthetic */ void m1018$r8$lambda$4wXklt_q7cTBep9ftw_K9PBwEI(e eVar);

    /* JADX INFO: renamed from: $r8$lambda$-wlCVv2hClfq1dABUDLlkOaojbo, reason: not valid java name */
    public static native /* synthetic */ void m1019$r8$lambda$wlCVv2hClfq1dABUDLlkOaojbo(e eVar);

    public static native /* synthetic */ void $r8$lambda$r3r12FY8KSmHENezyfYPwgNiOVk(e eVar);

    static {
        OSETSDKProtected.interface11(3811);
        f39631a = AdType.AD_INTERSTITIAL_TYPE_HORIZONTAL;
    }

    private native /* synthetic */ void a();

    private native /* synthetic */ void b();

    private native /* synthetic */ void c();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void bindListener(OSETBaseListener oSETBaseListener);

    @Override // com.kc.openset.ad.base.BaseAdLoad, com.kc.openset.ad.base.AdCoreAction
    public native void destroy();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void doAdClick(View view);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void doAdClose(View view);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void doAdImp(View view);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void doBidFail(String str);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void doBidSuccess(String str);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native AdType getAdType();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void showFailNotifyClient(String str, String str2);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void skipNotifyClient();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void toShowAd(Activity activity, ViewGroup viewGroup);
}
