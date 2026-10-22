package com.kc.dw.gather.csj.intertitial;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.byazt.nys.PluginConstants;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CSJIntertitialAdapter extends MsCustomInterstitialAdapter {
    private static final String TAG = "CSJIntertitialAdapter";
    private boolean enableInterstitialAutoClose;
    private TTFullScreenVideoAd intertitialAd;
    private boolean isClick;
    private Application.ActivityLifecycleCallbacks lifecycleCallbacks = new Application.ActivityLifecycleCallbacks(this) { // from class: com.kc.dw.gather.csj.intertitial.CSJIntertitialAdapter.2
        public final CSJIntertitialAdapter this$0;

        {
            this.this$0 = this;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            try {
                LogUtil.e(CSJIntertitialAdapter.TAG, "onActivityPaused,className=" + activity.getComponentName().getClassName() + ",isClick=" + this.this$0.isClick);
                if (!activity.getComponentName().getClassName().equals(PluginConstants.STUB_STANDARD_PORTRAIT_ACTIVITY_T) || this.this$0.isClick) {
                    this.this$0.isClick = false;
                } else {
                    activity.finish();
                    activity.getApplication().unregisterActivityLifecycleCallbacks(this.this$0.lifecycleCallbacks);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    };

    /* JADX INFO: renamed from: com.kc.dw.gather.csj.intertitial.CSJIntertitialAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements TTAdNative.FullScreenVideoAdListener {
        public final CSJIntertitialAdapter this$0;

        public AnonymousClass1(CSJIntertitialAdapter cSJIntertitialAdapter) {
            this.this$0 = cSJIntertitialAdapter;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onError(int i, String str) {
            LogUtil.d(CSJIntertitialAdapter.TAG, "onError code=" + i + ",msg=" + str);
            this.this$0.callLoadedError(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            try {
                LogUtil.d(CSJIntertitialAdapter.TAG, "onFullScreenVideoAdLoad");
                if (tTFullScreenVideoAd != null) {
                    this.this$0.intertitialAd = tTFullScreenVideoAd;
                    tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener(this) { // from class: com.kc.dw.gather.csj.intertitial.CSJIntertitialAdapter.1.1
                        public final AnonymousClass1 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onAdClose() {
                            this.this$1.this$0.callAdClosed();
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onAdShow() {
                            this.this$1.this$0.callAdExposure();
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onAdVideoBarClick() {
                            this.this$1.this$0.isClick = true;
                            this.this$1.this$0.callAdClicked();
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onSkippedVideo() {
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onVideoComplete() {
                        }
                    });
                    this.this$0.callLoadedSuccess();
                    this.this$0.callRenderSuccess();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
        }
    }

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        if (ssdAdSlot != null) {
            this.enableInterstitialAutoClose = ssdAdSlot.isEnableInterstitialAutoClose();
        }
        TTAdSdk.getAdManager().createAdNative(context).loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(customInfo.getPid()).setSupportDeepLink(true).build(), new AnonymousClass1(this));
    }

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void showAd(Activity activity) {
        if (this.intertitialAd == null || activity == null) {
            return;
        }
        if (this.enableInterstitialAutoClose) {
            activity.getApplication().registerActivityLifecycleCallbacks(this.lifecycleCallbacks);
        }
        this.intertitialAd.showFullScreenVideoAd(activity);
    }
}
