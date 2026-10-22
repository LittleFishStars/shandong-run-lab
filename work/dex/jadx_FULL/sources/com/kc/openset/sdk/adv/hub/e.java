package com.kc.openset.sdk.adv.hub;

import android.app.Activity;
import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.sdk.adv.listener.ADVBaseListener;
import com.kc.openset.sdk.adv.listener.ADVRewardListener;
import com.kc.openset.sdk.adv.listener.OSETADVRewardListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class e extends ADVAdObject {

    @Keep
    public class a implements ADVRewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ADVBaseListener f39855a;
        final e b;

        static {
            OSETSDKProtected.interface11(4754);
        }

        public a(e eVar, ADVBaseListener aDVBaseListener) {
            this.b = eVar;
            this.f39855a = aDVBaseListener;
        }

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native String getUserId();

        @Override // com.kc.openset.sdk.adv.listener.ADVRewardListener
        public native void onAdClick();

        @Override // com.kc.openset.sdk.adv.listener.ADVRewardListener
        public native void onAdClosed();

        @Override // com.kc.openset.sdk.adv.listener.ADVEventListener
        public native void onAdEvent(com.kc.openset.sdk.adv.report.b bVar);

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadFailure(String str, String str2);

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadSuccess();

        @Override // com.kc.openset.sdk.adv.listener.ADVRewardListener
        public native void onAdShow();

        @Override // com.kc.openset.sdk.adv.listener.ADVRewardListener
        public native void onAdSkip();

        @Override // com.kc.openset.sdk.adv.listener.ADVRewardListener
        public native void onReward();

        @Override // com.kc.openset.sdk.adv.listener.ADVRewardListener
        public native void onVideoComplete();

        @Override // com.kc.openset.sdk.adv.listener.ADVRewardListener
        public native void onVideoError(String str, String str2);
    }

    static {
        OSETSDKProtected.interface11(4755);
    }

    public e(Context context, String str, String str2) {
        super(context, str, str2, AdType.AD_TYPE_REWARD);
    }

    public native void a(Activity activity);

    public native void a(OSETADVRewardListener oSETADVRewardListener);

    @Override // com.kc.openset.sdk.adv.hub.ADVAdObject
    public native ADVBaseListener initADVListener(ADVBaseListener aDVBaseListener);
}
