package com.kc.openset.sdk.adv.hub;

import android.app.Activity;
import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.sdk.adv.listener.ADVBaseListener;
import com.kc.openset.sdk.adv.listener.ADVInterstitialListener;
import com.kc.openset.sdk.adv.listener.OSETADVInterstitialListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class b extends ADVAdObject {

    @Keep
    public class a implements ADVInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ADVBaseListener f39846a;
        final b b;

        static {
            OSETSDKProtected.interface11(4742);
        }

        public a(b bVar, ADVBaseListener aDVBaseListener) {
            this.b = bVar;
            this.f39846a = aDVBaseListener;
        }

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native String getUserId();

        @Override // com.kc.openset.sdk.adv.listener.ADVInterstitialListener
        public native void onAdClick();

        @Override // com.kc.openset.sdk.adv.listener.ADVInterstitialListener
        public native void onAdClosed();

        @Override // com.kc.openset.sdk.adv.listener.ADVEventListener
        public native void onAdEvent(com.kc.openset.sdk.adv.report.b bVar);

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadFailure(String str, String str2);

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadSuccess();

        @Override // com.kc.openset.sdk.adv.listener.ADVInterstitialListener
        public native void onAdShow();

        @Override // com.kc.openset.sdk.adv.listener.ADVInterstitialListener
        public native void onVideoError(String str, String str2);
    }

    static {
        OSETSDKProtected.interface11(4743);
    }

    public b(Context context, String str, String str2) {
        super(context, str, str2, AdType.AD_TYPE_INTERSTITIAL);
    }

    public native void a(Activity activity);

    public native void a(OSETADVInterstitialListener oSETADVInterstitialListener);

    @Override // com.kc.openset.sdk.adv.hub.ADVAdObject
    public native ADVBaseListener initADVListener(ADVBaseListener aDVBaseListener);
}
