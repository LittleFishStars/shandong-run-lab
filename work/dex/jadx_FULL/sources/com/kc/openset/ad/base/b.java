package com.kc.openset.ad.base;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.listener.OSETBaseListener;
import com.kc.openset.ad.listener.OSETDrawNativeListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class b extends BaseAdLoad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AdType f39628a;
    private OSETDrawNativeListener b;

    public static native /* synthetic */ void $r8$lambda$BhyLcGkKNolSlUp63NGM17tyTZg(b bVar, View view);

    public static native /* synthetic */ void $r8$lambda$Ixn_hAEi36SASdmgwrGxrxpTdME(b bVar, View view);

    public static native /* synthetic */ void $r8$lambda$Kwz4NF21Qq3xE_v5ustG9rIwfVA(b bVar, View view);

    public static native /* synthetic */ void $r8$lambda$NKNpdYY2A9FnGZN7KZmSIUCt7gE(b bVar, View view);

    public static native /* synthetic */ void $r8$lambda$gnPLiaEKOcra_wN80zlZsDV1YQg(b bVar, View view);

    public static native /* synthetic */ void $r8$lambda$n2J3vdzJLF0F5xQCNmHxlxVLIjI(b bVar, View view);

    public static native /* synthetic */ void $r8$lambda$pdMF9Y7KYnGlXZmjYaCkI3AunAs(b bVar, View view);

    static {
        OSETSDKProtected.interface11(3771);
        f39628a = AdType.AD_TYPE_DRAW_NATIVE;
    }

    private native /* synthetic */ void a(View view);

    private native /* synthetic */ void b(View view);

    private native /* synthetic */ void c(View view);

    private native /* synthetic */ void d(View view);

    private native /* synthetic */ void e(View view);

    private native /* synthetic */ void f(View view);

    private native /* synthetic */ void g(View view);

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
    public native void doAdVideoComplete(View view);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void doAdVideoContinuePlay(View view);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void doAdVideoPause(View view);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void doAdVideoStart(View view);

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
