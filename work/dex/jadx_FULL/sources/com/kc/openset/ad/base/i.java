package com.kc.openset.ad.base;

import android.app.Activity;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.listener.OSETBaseListener;
import com.kc.openset.ad.listener.OSETSplashListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class i extends BaseAdLoad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AdType f39637a;
    private OSETSplashListener b;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;

    public static native /* synthetic */ void $r8$lambda$GV9AH0QCSmX3Yjo0MbjtIKGx4yA(i iVar);

    public static native /* synthetic */ void $r8$lambda$KldEAyH6XIqJJTQYEMkswF2ttX0(i iVar);

    public static native /* synthetic */ void $r8$lambda$KsIoQSpVq5ajBhjURZmYLTEwZZo(i iVar);

    public static native /* synthetic */ void $r8$lambda$QuoYfJhkQnU3jTNxdqF3fZmegxw(i iVar);

    static {
        OSETSDKProtected.interface11(3839);
        f39637a = AdType.AD_TYPE_SPLASH;
    }

    private native /* synthetic */ void a();

    private native /* synthetic */ void b();

    private native /* synthetic */ void c();

    private native /* synthetic */ void d();

    private native void e();

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
    public native int getDefaultLoadTimeout();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void onShowActivityPaused();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void onShowActivityResumed();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void showFailNotifyClient(String str, String str2);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void skipNotifyClient();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void toShowAd(Activity activity);
}
