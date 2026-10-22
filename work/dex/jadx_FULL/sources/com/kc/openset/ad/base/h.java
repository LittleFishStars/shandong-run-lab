package com.kc.openset.ad.base;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.OnServiceRewardListener;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.listener.OSETBaseListener;
import com.kc.openset.ad.listener.OSETRewardListener;
import com.kc.openset.verify.ServiceVerifyResultListener;
import com.kc.openset.verify.ServiceVerifyType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class h extends BaseAdLoad implements OnServiceRewardListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AdType f39634a;
    private OSETRewardListener b;

    @Keep
    public class a implements ServiceVerifyResultListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h f39635a;

        static {
            OSETSDKProtected.interface11(3832);
        }

        public a(h hVar) {
            this.f39635a = hVar;
        }

        @Override // com.kc.openset.verify.ServiceVerifyResultListener
        public native void onServiceVerifyError(String str, String str2, ServiceVerifyType serviceVerifyType);

        @Override // com.kc.openset.verify.ServiceVerifyResultListener
        public native void onServiceVerifySuccess(String str, int i, ServiceVerifyType serviceVerifyType);
    }

    @Keep
    public class b implements ServiceVerifyResultListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h f39636a;

        static {
            OSETSDKProtected.interface11(3833);
        }

        public b(h hVar) {
            this.f39636a = hVar;
        }

        @Override // com.kc.openset.verify.ServiceVerifyResultListener
        public native void onServiceVerifyError(String str, String str2, ServiceVerifyType serviceVerifyType);

        @Override // com.kc.openset.verify.ServiceVerifyResultListener
        public native void onServiceVerifySuccess(String str, int i, ServiceVerifyType serviceVerifyType);
    }

    public static native /* synthetic */ void $r8$lambda$BMkyTEsJos8foXva1xLb6mJkmlU(h hVar);

    /* JADX INFO: renamed from: $r8$lambda$Cfo4IOw-Y0-6eSj_hd5qfbnDATk, reason: not valid java name */
    public static native /* synthetic */ void m1021$r8$lambda$Cfo4IOwY06eSj_hd5qfbnDATk(h hVar);

    public static native /* synthetic */ void $r8$lambda$DV6xgAE1UB4oAmtL2fvB8NRYXyA(h hVar);

    /* JADX INFO: renamed from: $r8$lambda$Jgew74F1MWWEqazUv-1RZwPlij4, reason: not valid java name */
    public static native /* synthetic */ void m1022$r8$lambda$Jgew74F1MWWEqazUv1RZwPlij4(h hVar);

    /* JADX INFO: renamed from: $r8$lambda$aJzkwX0Ve2jPhtzRE-GAyhILSOo, reason: not valid java name */
    public static native /* synthetic */ void m1023$r8$lambda$aJzkwX0Ve2jPhtzREGAyhILSOo(h hVar);

    public static native /* synthetic */ void $r8$lambda$nuHqTIDs2YVJ6GiDbYWegh26ABc(h hVar, int i);

    public static native /* synthetic */ void $r8$lambda$wG_blV4YhBEMMqjeZvekiItDvCY(h hVar);

    static {
        OSETSDKProtected.interface11(3834);
        f39634a = AdType.AD_TYPE_REWARD;
    }

    private native /* synthetic */ void a();

    private native /* synthetic */ void a(int i);

    private native /* synthetic */ void b();

    private native /* synthetic */ void c();

    private native /* synthetic */ void d();

    private native /* synthetic */ void e();

    private native /* synthetic */ void f();

    private native void h();

    private native void i();

    public native void a(String str, String str2, String str3, ServiceVerifyType serviceVerifyType);

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
    public native void doAdReward();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void doAdVideoEnd();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void doAdVideoStart();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void doBidFail(String str);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void doBidSuccess(String str);

    public native void g();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native Map<String, Object> getADNServicesInfo();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native AdType getAdType();

    @Override // com.kc.openset.OnServiceRewardListener
    public native void serviceReward(int i);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void showFailNotifyClient(String str, String str2);

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void skipNotifyClient();

    @Override // com.kc.openset.ad.base.BaseAdLoad
    public native void toShowAd(Activity activity, ViewGroup viewGroup);
}
