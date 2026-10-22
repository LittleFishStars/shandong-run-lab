package com.kc.dw.platform.topon.splash;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.splash.ISplashAd;
import com.kc.dw.core.ad.splash.SplashAdEventLoader;
import com.kc.dw.core.ad.splash.SplashAdLoadListener;
import com.kc.dw.core.ad.splash.SplashInteractionListener;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.platform.topon.TopOnInitManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsSplashAdapter extends CustomSplashAdapter {
    private static final String TAG = "MsSplashAdapter";
    private String slotId;
    private ISplashAd splashAd;

    /* JADX INFO: renamed from: com.kc.dw.platform.topon.splash.MsSplashAdapter$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 implements SplashAdLoadListener {
        public final MsSplashAdapter this$0;
        public final ATBiddingListener val$biddingListener;

        public AnonymousClass3(MsSplashAdapter msSplashAdapter, ATBiddingListener aTBiddingListener) {
            this.this$0 = msSplashAdapter;
            this.val$biddingListener = aTBiddingListener;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(ISplashAd iSplashAd, AdError adError, int i) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            ATBiddingListener aTBiddingListener = this.val$biddingListener;
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(adError.getMessage()), (BaseAd) null);
            }
            if (((CustomSplashAdapter) this.this$0).mLoadListener != null) {
                ((CustomSplashAdapter) this.this$0).mLoadListener.onAdLoadError(String.valueOf(adError.getCode()), adError.getMessage());
            }
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(ISplashAd iSplashAd) {
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0030 A[Catch: all -> 0x005c, TryCatch #1 {all -> 0x005c, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:12:0x002c, B:14:0x0030, B:10:0x0027, B:15:0x003a, B:17:0x004f), top: B:24:0x0002, inners: #0 }] */
        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(ISplashAd iSplashAd) {
            double d;
            ATBiddingListener aTBiddingListener;
            if (iSplashAd != null) {
                try {
                    if (iSplashAd.getData() != null) {
                        String string = UUID.randomUUID().toString();
                        if (iSplashAd.getData() != null) {
                            try {
                                d = Double.parseDouble(iSplashAd.getData().getEcpm()) / 100.0d;
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                d = AudioStats.AUDIO_AMPLITUDE_NONE;
                            }
                            aTBiddingListener = this.val$biddingListener;
                            if (aTBiddingListener != null) {
                                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, string, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), (BaseAd) null);
                            }
                        } else {
                            d = AudioStats.AUDIO_AMPLITUDE_NONE;
                            aTBiddingListener = this.val$biddingListener;
                            if (aTBiddingListener != null) {
                                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, string, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), (BaseAd) null);
                            }
                        }
                    }
                    iSplashAd.setInteractionListener(new SplashInteractionListener(this) { // from class: com.kc.dw.platform.topon.splash.MsSplashAdapter.3.1
                        public final AnonymousClass3 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClicked() {
                            if (((CustomSplashAdapter) this.this$1.this$0).mImpressionListener != null) {
                                ((CustomSplashAdapter) this.this$1.this$0).mImpressionListener.onSplashAdClicked();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClosed() {
                            if (((CustomSplashAdapter) this.this$1.this$0).mImpressionListener != null) {
                                ((CustomSplashAdapter) this.this$1.this$0).mImpressionListener.onSplashAdDismiss();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdExposure() {
                            if (((CustomSplashAdapter) this.this$1.this$0).mImpressionListener != null) {
                                ((CustomSplashAdapter) this.this$1.this$0).mImpressionListener.onSplashAdShow();
                            }
                        }

                        @Override // com.kc.dw.core.ad.splash.SplashInteractionListener
                        public void onSkip() {
                            ((CustomSplashAdapter) this.this$1.this$0).mDismissType = 2;
                        }

                        @Override // com.kc.dw.core.ad.splash.SplashInteractionListener
                        public void onTick(long j) {
                        }

                        @Override // com.kc.dw.core.ad.splash.SplashInteractionListener
                        public void onTimeOver() {
                            ((CustomSplashAdapter) this.this$1.this$0).mDismissType = 3;
                        }
                    });
                    this.this$0.splashAd = iSplashAd;
                    if (((CustomSplashAdapter) this.this$0).mLoadListener != null) {
                        ((CustomSplashAdapter) this.this$0).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, Object> map, ATBiddingListener aTBiddingListener) {
        if (map.containsKey("app_id") && map.containsKey("slot_id")) {
            this.slotId = (String) map.get("slot_id");
            context.getResources().getDisplayMetrics();
            new SplashAdEventLoader(context, new SsdAdSlot.Builder().setPid(this.slotId).setFetchCount(1).build(), new AnonymousClass3(this, aTBiddingListener), 5000).loadAd();
        } else {
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
            }
            ATCustomLoadListener aTCustomLoadListener = ((CustomSplashAdapter) this).mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("", "app_id or slot_id is empty!");
            }
        }
    }

    public void destory() {
        this.splashAd = null;
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
        ISplashAd iSplashAd = this.splashAd;
        return iSplashAd != null && iSplashAd.isAdValid();
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback(this, context, map) { // from class: com.kc.dw.platform.topon.splash.MsSplashAdapter.1
            public final MsSplashAdapter this$0;
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

    public void show(Activity activity, ViewGroup viewGroup) {
        ISplashAd iSplashAd = this.splashAd;
        if (iSplashAd != null) {
            iSplashAd.showAd(viewGroup);
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback(this, context, map, aTBiddingListener) { // from class: com.kc.dw.platform.topon.splash.MsSplashAdapter.2
            public final MsSplashAdapter this$0;
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
