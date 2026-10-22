package com.kc.openset.ad.base;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.listener.OSETBaseListener;
import com.kc.openset.ad.listener.OSETNativeViewListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class g extends BaseAdLoad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AdType f39633a;
    private OSETNativeViewListener b;

    public static native /* synthetic */ void $r8$lambda$Jgp0TTMMhkepOkw0FEw2_U997iw(g gVar, View view);

    public static native /* synthetic */ void $r8$lambda$MPPIii5jJVOmRW_NJtX0U27zcEM(g gVar, View view);

    public static native /* synthetic */ void $r8$lambda$QV2QIaa2wUzFkutJ7bgZlhgX3kY(g gVar, View view);

    public static native /* synthetic */ void $r8$lambda$mZf4gkHQJHFb2nOnSkKB7Iws8xE(g gVar);

    public static native /* synthetic */ void $r8$lambda$ptJ3YuXHDfbTf6JDZ3h6tOYANaU(g gVar, View view);

    static {
        OSETSDKProtected.interface11(3824);
        f39633a = AdType.AD_TYPE_NATIVE_VIEW;
    }

    private native /* synthetic */ void a(View view);

    private native boolean a();

    private native /* synthetic */ void b();

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
    public native void doAdDetailViewClosed();

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
