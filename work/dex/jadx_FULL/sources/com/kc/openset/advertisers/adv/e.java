package com.kc.openset.advertisers.adv;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.ViewHolderManager;
import com.kc.openset.ad.base.bridge.BaseNativeViewBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kc.openset.sdk.adv.OSETQDNativeViewAd;
import com.kc.openset.sdk.adv.listener.ADVNativeViewListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class e extends BaseNativeViewBridge implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.kc.openset.sdk.adv.hub.d f39691a;
    private ViewHolderManager.ViewHolder b;
    private String c;
    private String d;
    private String e;
    private String f;

    @Keep
    public class a implements ADVNativeViewListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final e f39692a;

        static {
            OSETSDKProtected.interface11(4237);
        }

        public a(e eVar) {
            this.f39692a = eVar;
        }

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native String getUserId();

        @Override // com.kc.openset.sdk.adv.listener.ADVNativeViewListener
        public native void onAdClick(View view);

        @Override // com.kc.openset.sdk.adv.listener.ADVNativeViewListener
        public native void onAdClosed(View view);

        @Override // com.kc.openset.sdk.adv.listener.ADVNativeViewListener
        public native void onAdDetailViewClosed();

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadFailure(String str, String str2);

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadSuccess();

        @Override // com.kc.openset.sdk.adv.listener.ADVNativeViewListener
        public native void onAdShow(View view);

        @Override // com.kc.openset.sdk.adv.listener.ADVNativeViewListener
        public native void onAdShowFailure(String str, String str2);
    }

    static {
        OSETSDKProtected.interface11(4238);
    }

    public static native /* synthetic */ com.kc.openset.sdk.adv.hub.d a(e eVar);

    private native void a();

    private native void a(Activity activity, ViewHolderManager.ViewHolder viewHolder);

    private native void a(Context context, String str, int i);

    public static native /* synthetic */ void a(e eVar, View view);

    public static native /* synthetic */ void a(e eVar, String str);

    public static native /* synthetic */ void a(e eVar, String str, String str2);

    private native void b();

    private native void b(Activity activity, ViewHolderManager.ViewHolder viewHolder);

    public static native /* synthetic */ void b(e eVar);

    public static native /* synthetic */ void b(e eVar, View view);

    public static native /* synthetic */ void b(e eVar, String str);

    public static native /* synthetic */ void b(e eVar, String str, String str2);

    public static native /* synthetic */ void c(e eVar);

    public static native /* synthetic */ void c(e eVar, View view);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdTitle();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdUserName();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdvertisers();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native int getEcpm();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getLogTag();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getParentAdId();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native OSETQDNativeViewAd getQDNativeViewAd();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // android.view.View.OnClickListener
    public native void onClick(View view);

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void onShowActivityPaused();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void onShowActivityResumed();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadS2SAd(String str);

    @Override // com.kc.openset.ad.base.bridge.BaseNativeViewBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity, ViewHolderManager.ViewHolder viewHolder);
}
