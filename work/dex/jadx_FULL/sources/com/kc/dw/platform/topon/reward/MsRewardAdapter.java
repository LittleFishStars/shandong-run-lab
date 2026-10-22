package com.kc.dw.platform.topon.reward;

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
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.kc.dw.activity.a;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.reward.RewardAdLoadListener;
import com.kc.dw.core.ad.reward.RewardInteractionListener;
import com.kc.dw.core.ad.reward.RewardVideoAd;
import com.kc.dw.core.ad.reward.RewardVideoEventLoader;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.topon.TopOnInitManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsRewardAdapter extends CustomRewardVideoAdapter {
    private static final String TAG = "MsRewardAdapter";
    private RewardVideoAd rewardVideoAd;
    private String slotId;

    /* JADX INFO: renamed from: com.kc.dw.platform.topon.reward.MsRewardAdapter$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 implements RewardAdLoadListener {
        public final MsRewardAdapter this$0;
        public final ATBiddingListener val$biddingListener;

        public AnonymousClass3(MsRewardAdapter msRewardAdapter, ATBiddingListener aTBiddingListener) {
            this.this$0 = msRewardAdapter;
            this.val$biddingListener = aTBiddingListener;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(RewardVideoAd rewardVideoAd, AdError adError, int i) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            ATBiddingListener aTBiddingListener = this.val$biddingListener;
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(adError.getMessage()), (BaseAd) null);
            }
            if (((CustomRewardVideoAdapter) this.this$0).mLoadListener != null) {
                ((CustomRewardVideoAdapter) this.this$0).mLoadListener.onAdLoadError(String.valueOf(adError.getCode()), adError.getMessage());
            }
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(RewardVideoAd rewardVideoAd) {
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0035 A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:2:0x0000, B:4:0x0007, B:6:0x000d, B:8:0x001b, B:13:0x0031, B:15:0x0035, B:11:0x002c, B:16:0x003f, B:18:0x004f, B:19:0x0058, B:21:0x0060), top: B:26:0x0000, inners: #1 }] */
        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(RewardVideoAd rewardVideoAd) {
            double d;
            ATBiddingListener aTBiddingListener;
            try {
                this.this$0.rewardVideoAd = rewardVideoAd;
                if (rewardVideoAd != null) {
                    if (rewardVideoAd.getData() != null) {
                        String string = UUID.randomUUID().toString();
                        if (rewardVideoAd.getData() != null) {
                            try {
                                d = Double.parseDouble(rewardVideoAd.getData().getEcpm()) / 100.0d;
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
                    rewardVideoAd.setInteractionListener(new RewardInteractionListener(this) { // from class: com.kc.dw.platform.topon.reward.MsRewardAdapter.3.1
                        public final AnonymousClass3 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClicked() {
                            if (((CustomRewardVideoAdapter) this.this$1.this$0).mImpressionListener != null) {
                                ((CustomRewardVideoAdapter) this.this$1.this$0).mImpressionListener.onRewardedVideoAdPlayClicked();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClosed() {
                            if (((CustomRewardVideoAdapter) this.this$1.this$0).mImpressionListener != null) {
                                ((CustomRewardVideoAdapter) this.this$1.this$0).mImpressionListener.onRewardedVideoAdClosed();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdExposure() {
                            if (((CustomRewardVideoAdapter) this.this$1.this$0).mImpressionListener != null) {
                                ((CustomRewardVideoAdapter) this.this$1.this$0).mImpressionListener.onRewardedVideoAdPlayStart();
                            }
                        }

                        @Override // com.kc.dw.core.ad.reward.RewardInteractionListener
                        public void onReward(Map<String, Object> map) {
                            if (((CustomRewardVideoAdapter) this.this$1.this$0).mImpressionListener != null) {
                                ((CustomRewardVideoAdapter) this.this$1.this$0).mImpressionListener.onReward();
                            }
                        }
                    });
                    if (((CustomRewardVideoAdapter) this.this$0).mLoadListener != null) {
                        ((CustomRewardVideoAdapter) this.this$0).mLoadListener.onAdDataLoaded();
                    }
                    if (((CustomRewardVideoAdapter) this.this$0).mLoadListener != null) {
                        ((CustomRewardVideoAdapter) this.this$0).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
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
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.slotId)) {
            new RewardVideoEventLoader(context, new SsdAdSlot.Builder().setPid(this.slotId).build(), new AnonymousClass3(this, aTBiddingListener)).loadAd();
            return;
        }
        if (aTBiddingListener != null) {
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
        }
        ATCustomLoadListener aTCustomLoadListener = ((CustomRewardVideoAdapter) this).mLoadListener;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdLoadError("", "app_id or slot_id is empty!");
        }
    }

    public void destory() {
        this.rewardVideoAd = null;
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
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        return rewardVideoAd != null && rewardVideoAd.isAdValid();
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        StringBuilder sbA = a.a("serverExtra=");
        sbA.append(map.get("slot_id"));
        LogUtil.e(TAG, sbA.toString());
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback(this, context, map) { // from class: com.kc.dw.platform.topon.reward.MsRewardAdapter.1
            public final MsRewardAdapter this$0;
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
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.showAd(activity);
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback(this, context, map, aTBiddingListener) { // from class: com.kc.dw.platform.topon.reward.MsRewardAdapter.2
            public final MsRewardAdapter this$0;
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
