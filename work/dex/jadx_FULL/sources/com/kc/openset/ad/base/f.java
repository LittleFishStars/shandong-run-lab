package com.kc.openset.ad.base;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.listener.OSETBaseListener;
import com.kc.openset.ad.listener.OSETNativeListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class f extends BaseAdLoad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AdType f39632a;
    private OSETNativeListener b;

    public static native /* synthetic */ void $r8$lambda$1dHavldQMnLjtDiAN8OIDwQ3Uxo(f fVar, View view);

    /* JADX INFO: renamed from: $r8$lambda$XzN4xrauCRkGU7buD0-LzdSmIfQ, reason: not valid java name */
    public static native /* synthetic */ void m1020$r8$lambda$XzN4xrauCRkGU7buD0LzdSmIfQ(f fVar, View view);

    public static native /* synthetic */ void $r8$lambda$dXX7gTtND33FqqjWXaAHqTVhqlU(f fVar, String str, String str2);

    public static native /* synthetic */ void $r8$lambda$dkHQNzU0P_dRYZgnSzgWljy0hkQ(f fVar, View view);

    public static native /* synthetic */ void $r8$lambda$uJdq0knmJmMLFRvbLE6NjsRkxl0(f fVar, View view);

    public static native /* synthetic */ void $r8$lambda$wUbGdTvArZYvTtGAyY30kTEi6uI(f fVar, View view);

    static {
        OSETSDKProtected.interface11(3818);
        f39632a = AdType.AD_TYPE_NATIVE;
    }

    private native /* synthetic */ void a(View view);

    private native /* synthetic */ void a(String str, String str2);

    private native /* synthetic */ void b(View view);

    private native /* synthetic */ void c(View view);

    private native /* synthetic */ void d(View view);

    private native /* synthetic */ void e(View view);

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
    public native void doAdRenderFail(View view, String str, String str2);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void doAdRenderSuccess(View view);

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
