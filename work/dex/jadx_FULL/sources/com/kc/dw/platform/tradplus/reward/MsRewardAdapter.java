package com.kc.dw.platform.tradplus.reward;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.kc.dw.ad.w;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.reward.RewardAdLoadListener;
import com.kc.dw.core.ad.reward.RewardAdMediaListener;
import com.kc.dw.core.ad.reward.RewardInteractionListener;
import com.kc.dw.core.ad.reward.RewardVideoAd;
import com.kc.dw.core.ad.reward.RewardVideoCommonLoader;
import com.kc.dw.core.ad.reward.RewardVideoEventLoader;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.tradplus.ads.base.adapter.TPBaseAdapter;
import com.tradplus.ads.base.adapter.TPLoadAdapterListener;
import com.tradplus.ads.base.adapter.TPShowAdapterListener;
import com.tradplus.ads.base.adapter.reward.TPRewardAdapter;
import com.tradplus.ads.base.bean.TPBaseAd;
import com.tradplus.ads.base.common.TPError;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsRewardAdapter extends TPRewardAdapter {
    private static final String TAG = w.a("TradPlus_", "MsRewardAdapter");
    private Context context;
    private boolean isBiddingLoaded;
    private TPBaseAdapter.OnC2STokenListener onC2STokenListener;
    private String placementId;
    private RewardVideoAd rewardVideoAd;
    private RewardVideoCommonLoader rewardVideoLoader;

    /* JADX INFO: renamed from: com.kc.dw.platform.tradplus.reward.MsRewardAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements RewardAdLoadListener {
        public final MsRewardAdapter this$0;
        public final TPBaseAdapter.OnC2STokenListener val$onC2STokenListener;

        public AnonymousClass2(MsRewardAdapter msRewardAdapter, TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
            this.this$0 = msRewardAdapter;
            this.val$onC2STokenListener = onC2STokenListener;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(RewardVideoAd rewardVideoAd, AdError adError, int i) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            TPBaseAdapter.OnC2STokenListener onC2STokenListener = this.val$onC2STokenListener;
            if (onC2STokenListener != null) {
                onC2STokenListener.onC2SBiddingFailed(String.valueOf(adError.getCode()), adError.getMessage());
            }
            if (((TPRewardAdapter) this.this$0).mLoadAdapterListener != null) {
                TPError tPError = new TPError("Third-party network failed to provide an ad.");
                tPError.setErrorCode(String.valueOf(adError.getCode()));
                tPError.setErrorMessage(adError.getMessage());
                ((TPRewardAdapter) this.this$0).mLoadAdapterListener.loadAdapterLoadFailed(tPError);
            }
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(RewardVideoAd rewardVideoAd) {
        }

        /* JADX WARN: Code duplicated, block: B:15:0x004c A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:2:0x0000, B:4:0x000d, B:6:0x0019, B:8:0x002c, B:13:0x0048, B:15:0x004c, B:11:0x0043, B:16:0x005f, B:18:0x0089, B:20:0x008f), top: B:25:0x0000, inners: #1 }] */
        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(RewardVideoAd rewardVideoAd) {
            TPLoadAdapterListener tPLoadAdapterListener;
            double d;
            try {
                this.this$0.rewardVideoAd = rewardVideoAd;
                if (this.this$0.rewardVideoAd != null) {
                    if (this.this$0.rewardVideoAd.getData() != null) {
                        UUID.randomUUID().toString();
                        if (this.this$0.rewardVideoAd.getData() != null) {
                            try {
                                d = Double.parseDouble(this.this$0.rewardVideoAd.getData().getEcpm()) / 100.0d;
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                d = AudioStats.AUDIO_AMPLITUDE_NONE;
                            }
                            if (this.val$onC2STokenListener != null) {
                                HashMap map = new HashMap();
                                map.put("ecpm", Double.valueOf(d));
                                this.val$onC2STokenListener.onC2SBiddingResult(map);
                            }
                        } else {
                            d = AudioStats.AUDIO_AMPLITUDE_NONE;
                            if (this.val$onC2STokenListener != null) {
                                HashMap map2 = new HashMap();
                                map2.put("ecpm", Double.valueOf(d));
                                this.val$onC2STokenListener.onC2SBiddingResult(map2);
                            }
                        }
                    }
                    this.this$0.rewardVideoAd.setMediaListener(new RewardAdMediaListener(this) { // from class: com.kc.dw.platform.tradplus.reward.MsRewardAdapter.2.1
                        public final AnonymousClass2 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
                        public void onSkippedVideo() {
                            TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onRewardSkip();
                            }
                        }

                        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
                        public void onVideoCompleted() {
                            TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onAdVideoEnd();
                            }
                        }

                        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
                        public void onVideoError() {
                            TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onAdVideoError(new TPError());
                            }
                        }

                        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
                        public void onVideoLoaded() {
                        }

                        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
                        public void onVideoPause() {
                        }

                        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
                        public void onVideoResume() {
                        }

                        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
                        public void onVideoStart() {
                            TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onAdVideoStart();
                            }
                        }
                    });
                    this.this$0.rewardVideoAd.setInteractionListener(new RewardInteractionListener(this) { // from class: com.kc.dw.platform.tradplus.reward.MsRewardAdapter.2.2
                        public final AnonymousClass2 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClicked() {
                            TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onAdClicked();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClosed() {
                            TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onAdClosed();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdExposure() {
                            TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onAdShown();
                            }
                        }

                        @Override // com.kc.dw.core.ad.reward.RewardInteractionListener
                        public void onReward(Map<String, Object> map3) {
                            TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onReward();
                            }
                        }
                    });
                    this.this$0.isBiddingLoaded = true;
                    if (this.this$0.isC2SBidding() || (tPLoadAdapterListener = ((TPRewardAdapter) this.this$0).mLoadAdapterListener) == null) {
                        return;
                    }
                    tPLoadAdapterListener.loadAdapterLoaded((TPBaseAd) null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isC2SBidding() {
        return this.onC2STokenListener != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, String> map, TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        if (isC2SBidding() && this.isBiddingLoaded) {
            TPLoadAdapterListener tPLoadAdapterListener = ((TPRewardAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener != null) {
                tPLoadAdapterListener.loadAdapterLoaded((TPBaseAd) null);
                return;
            }
            return;
        }
        String str = map.containsKey("appId") ? map.get("appId") : null;
        this.placementId = map.containsKey(TradPlusInitManager.PLACEMENTID) ? map.get(TradPlusInitManager.PLACEMENTID) : null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.placementId)) {
            RewardVideoEventLoader rewardVideoEventLoader = new RewardVideoEventLoader(context, new SsdAdSlot.Builder().setPid(this.placementId).build(), new AnonymousClass2(this, onC2STokenListener));
            this.rewardVideoLoader = rewardVideoEventLoader;
            rewardVideoEventLoader.loadAd();
        } else {
            if (onC2STokenListener != null) {
                onC2STokenListener.onC2SBiddingFailed("", "appId or placementId is empty!");
            }
            TPLoadAdapterListener tPLoadAdapterListener2 = ((TPRewardAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener2 != null) {
                tPLoadAdapterListener2.loadAdapterLoadFailed(new TPError("", "appId or placementId is empty!"));
            }
        }
    }

    public void clean() {
        super.clean();
        this.rewardVideoAd = null;
        RewardVideoCommonLoader rewardVideoCommonLoader = this.rewardVideoLoader;
        if (rewardVideoCommonLoader != null) {
            rewardVideoCommonLoader.destroy();
            this.rewardVideoLoader = null;
        }
    }

    public void getC2SBidding(Context context, Map<String, Object> map, Map<String, String> map2, TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        this.onC2STokenListener = onC2STokenListener;
        loadCustomAd(context, map, map2);
    }

    public String getNetworkName() {
        return TradPlusInitManager.getInstance().getNetworkName();
    }

    public String getNetworkVersion() {
        return AdSdk.getVersionName();
    }

    public boolean isReady() {
        return this.rewardVideoAd != null;
    }

    public void loadCustomAd(Context context, Map<String, Object> map, Map<String, String> map2) {
        this.context = context;
        TradPlusInitManager.getInstance().initSDK(context, map2, new TradPlusInitManager.InitCallback(this, context, map2) { // from class: com.kc.dw.platform.tradplus.reward.MsRewardAdapter.1
            public final MsRewardAdapter this$0;
            public final Context val$context;
            public final Map val$tpParams;

            {
                this.this$0 = this;
                this.val$context = context;
                this.val$tpParams = map2;
            }

            @Override // com.kc.dw.platform.tradplus.TradPlusInitManager.InitCallback
            public void onError() {
                if (this.this$0.onC2STokenListener != null) {
                    this.this$0.onC2STokenListener.onC2SBiddingFailed("", "Configuration Error Occurred. Please check your appID and placementIDs.");
                }
                TPLoadAdapterListener tPLoadAdapterListener = ((TPRewardAdapter) this.this$0).mLoadAdapterListener;
                if (tPLoadAdapterListener != null) {
                    tPLoadAdapterListener.loadAdapterLoadFailed(new TPError("", "Configuration Error Occurred. Please check your appID and placementIDs."));
                }
            }

            @Override // com.kc.dw.platform.tradplus.TradPlusInitManager.InitCallback
            public void onSuccess() {
                MsRewardAdapter msRewardAdapter = this.this$0;
                msRewardAdapter.loadAd(this.val$context, this.val$tpParams, msRewardAdapter.onC2STokenListener);
            }
        });
    }

    public void showAd() {
        try {
            RewardVideoAd rewardVideoAd = this.rewardVideoAd;
            if (rewardVideoAd != null) {
                rewardVideoAd.showAd((Activity) this.context);
            } else {
                TPShowAdapterListener tPShowAdapterListener = ((TPRewardAdapter) this).mShowListener;
                if (tPShowAdapterListener != null) {
                    tPShowAdapterListener.onAdVideoError(new TPError("Didn't find valid adv.Show Failed"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
