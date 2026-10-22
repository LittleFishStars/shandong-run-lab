package com.kc.openset.ad.base;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.listener.OSETBannerListener;
import com.kc.openset.ad.listener.OSETBaseListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class a extends BaseAdLoad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AdType f39627a;
    private OSETBannerListener b;

    public static native /* synthetic */ void $r8$lambda$6vtKl87yFxpVzwfTFw2KU1nX87Y(a aVar, View view);

    /* JADX INFO: renamed from: $r8$lambda$cHto5-uFH7iQyNBehoPjfTH749o, reason: not valid java name */
    public static native /* synthetic */ void m1016$r8$lambda$cHto5uFH7iQyNBehoPjfTH749o(a aVar, View view);

    public static native /* synthetic */ void $r8$lambda$r2ov1gcdqoN8xoli5TTo5zBXX9U(a aVar, View view);

    public static native /* synthetic */ void $r8$lambda$vdCDokzIFRZzrIbjDjOF8V4JYfc(a aVar, View view);

    static {
        OSETSDKProtected.interface11(3763);
        f39627a = AdType.AD_TYPE_BANNER;
    }

    private native /* synthetic */ void a(View view);

    private native /* synthetic */ void b(View view);

    private native /* synthetic */ void c(View view);

    private native /* synthetic */ void d(View view);

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
    public native boolean isBindActivityLifeCycle();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void showFailNotifyClient(String str, String str2);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void skipNotifyClient();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void toShowAd(Activity activity, ViewGroup viewGroup);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void viewLoadToShow(View view);
}
