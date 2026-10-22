package com.kc.dw.platform.topon.intertitial;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.interstitial.InterstitialAd;
import com.kc.dw.core.ad.interstitial.InterstitialAdEventLoader;
import com.kc.dw.core.ad.interstitial.InterstitialAdLoadListener;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.platform.topon.TopOnInitManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsIntertitialAdapter extends CustomInterstitialAdapter {
    private InterstitialAd interstitialAd;
    private String slotId;

    /* JADX INFO: renamed from: com.kc.dw.platform.topon.intertitial.MsIntertitialAdapter$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 implements InterstitialAdLoadListener {
        public final MsIntertitialAdapter this$0;
        public final ATBiddingListener val$biddingListener;

        public AnonymousClass3(MsIntertitialAdapter msIntertitialAdapter, ATBiddingListener aTBiddingListener) {
            this.this$0 = msIntertitialAdapter;
            this.val$biddingListener = aTBiddingListener;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(InterstitialAd interstitialAd, AdError adError, int i) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            ATBiddingListener aTBiddingListener = this.val$biddingListener;
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(adError.getMessage()), (BaseAd) null);
            }
            if (((CustomInterstitialAdapter) this.this$0).mLoadListener != null) {
                ((CustomInterstitialAdapter) this.this$0).mLoadListener.onAdLoadError(String.valueOf(adError.getCode()), adError.getMessage());
            }
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(InterstitialAd interstitialAd) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(InterstitialAd interstitialAd) {
            try {
                this.this$0.interstitialAd = interstitialAd;
                if (interstitialAd != null) {
                    if (interstitialAd.getData() != null) {
                        String string = UUID.randomUUID().toString();
                        ResultBean data = interstitialAd.getData();
                        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
                        if (data != null) {
                            try {
                                d = Double.parseDouble(interstitialAd.getData().getEcpm()) / 100.0d;
                                LogUtil.d("hrsdk", "price=" + d);
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                        ATBiddingListener aTBiddingListener = this.val$biddingListener;
                        if (aTBiddingListener != null) {
                            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, string, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), (BaseAd) null);
                        }
                    }
                    interstitialAd.setInteractionListener(new InteractionListener(this) { // from class: com.kc.dw.platform.topon.intertitial.MsIntertitialAdapter.3.1
                        public final AnonymousClass3 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClicked() {
                            if (((CustomInterstitialAdapter) this.this$1.this$0).mImpressListener != null) {
                                ((CustomInterstitialAdapter) this.this$1.this$0).mImpressListener.onInterstitialAdClicked();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClosed() {
                            if (((CustomInterstitialAdapter) this.this$1.this$0).mImpressListener != null) {
                                ((CustomInterstitialAdapter) this.this$1.this$0).mImpressListener.onInterstitialAdClose();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdExposure() {
                            if (((CustomInterstitialAdapter) this.this$1.this$0).mImpressListener != null) {
                                ((CustomInterstitialAdapter) this.this$1.this$0).mImpressListener.onInterstitialAdShow();
                            }
                        }
                    });
                    if (((CustomInterstitialAdapter) this.this$0).mLoadListener != null) {
                        ((CustomInterstitialAdapter) this.this$0).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, Object> map, ATBiddingListener aTBiddingListener) {
        String str = (String) map.get("app_id");
        this.slotId = (String) map.get("slot_id");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.slotId)) {
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
            }
            ATCustomLoadListener aTCustomLoadListener = ((CustomInterstitialAdapter) this).mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("", "app_id or slot_id is empty!");
                return;
            }
            return;
        }
        if (context instanceof Activity) {
            new InterstitialAdEventLoader((Activity) context, new SsdAdSlot.Builder().setPid(this.slotId).setIsClickToClose(false).build(), new AnonymousClass3(this, aTBiddingListener)).loadAd();
            return;
        }
        if (aTBiddingListener != null) {
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
        }
        ATCustomLoadListener aTCustomLoadListener2 = ((CustomInterstitialAdapter) this).mLoadListener;
        if (aTCustomLoadListener2 != null) {
            aTCustomLoadListener2.onAdLoadError("", "app_id or slot_id is empty!");
        }
    }

    public void destory() {
        this.interstitialAd = null;
    }

    public String getNetworkName() {
        return TopOnInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.slotId;
    }

    public String getNetworkSDKVersion() {
        return AdSdk.getVersionName();
    }

    public boolean isAdReady() {
        InterstitialAd interstitialAd = this.interstitialAd;
        return interstitialAd != null && interstitialAd.isAdValid();
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback(this, context, map) { // from class: com.kc.dw.platform.topon.intertitial.MsIntertitialAdapter.1
            public final MsIntertitialAdapter this$0;
            public final Context val$context;
            public final Map val$serverExtra;

            {
                this.this$0 = this;
                this.val$context = context;
                this.val$serverExtra = map;
            }

            public void onFail(String str) {
            }

            public void onSuccess() {
                this.this$0.loadAd(this.val$context, this.val$serverExtra, null);
            }
        });
    }

    public void show(Activity activity) {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.showAd(activity);
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback(this, context, map, aTBiddingListener) { // from class: com.kc.dw.platform.topon.intertitial.MsIntertitialAdapter.2
            public final MsIntertitialAdapter this$0;
            public final ATBiddingListener val$biddingListener;
            public final Context val$context;
            public final Map val$serverExtra;

            {
                this.this$0 = this;
                this.val$context = context;
                this.val$serverExtra = map;
                this.val$biddingListener = aTBiddingListener;
            }

            public void onFail(String str) {
                ATBiddingListener aTBiddingListener2 = this.val$biddingListener;
                if (aTBiddingListener2 != null) {
                    aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail(str), (BaseAd) null);
                }
            }

            public void onSuccess() {
                this.this$0.loadAd(this.val$context, this.val$serverExtra, this.val$biddingListener);
            }
        });
        return true;
    }
}
