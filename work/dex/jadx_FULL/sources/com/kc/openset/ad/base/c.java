package com.kc.openset.ad.base;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.listener.OSETBaseListener;
import com.kc.openset.ad.listener.OSETFullVideoListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class c extends BaseAdLoad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AdType f39629a;
    private OSETFullVideoListener b;

    public static native /* synthetic */ void $r8$lambda$3AOYhwTffS9aePIOR2B77YuIPYo(c cVar);

    public static native /* synthetic */ void $r8$lambda$3ofIJmo5FwsVMf64yCbnQjsJJ2U(c cVar);

    public static native /* synthetic */ void $r8$lambda$4yVzm79EI0LRXuGdwkTO3pyk6Yc(c cVar);

    public static native /* synthetic */ void $r8$lambda$6E9xsdTucNq7Gv2TL9xQg5LbAVE(c cVar);

    /* JADX INFO: renamed from: $r8$lambda$fjcY0nOMBcCiNGnutvvaI-1u7c0, reason: not valid java name */
    public static native /* synthetic */ void m1017$r8$lambda$fjcY0nOMBcCiNGnutvvaI1u7c0(c cVar);

    static {
        OSETSDKProtected.interface11(3803);
        f39629a = AdType.AD_TYPE_FULL_VIDEO;
    }

    private native /* synthetic */ void a();

    private native /* synthetic */ void b();

    private native /* synthetic */ void c();

    private native /* synthetic */ void d();

    private native /* synthetic */ void e();

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
    public native void doAdVideoEnd();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void doAdVideoStart();

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
