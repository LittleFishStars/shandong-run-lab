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
public class d extends BaseAdLoad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AdType f39630a;
    private OSETInterstitialListener b;

    public static native /* synthetic */ void $r8$lambda$3NQLN6lu8d1_ii9FvNk8CbGUKu8(d dVar);

    public static native /* synthetic */ void $r8$lambda$OtJOsllpx4DZtubLXQyEFmip2Y8(d dVar);

    public static native /* synthetic */ void $r8$lambda$asICB2ZCNlOvWGotLLKXhFEaxHg(d dVar);

    static {
        OSETSDKProtected.interface11(3807);
        f39630a = AdType.AD_TYPE_INTERSTITIAL;
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
