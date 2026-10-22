package com.example.topon_adapter.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.rewardvideo.LTAdRewardVideoEventListener;
import com.ltmb.ltsdk.core.load.rewardvideo.LTAdRewardVideoLoadListener;
import com.ltmb.ltsdk.core.load.rewardvideo.LTRewardVideoAd;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LtAdRewardVideoAdapter extends CustomRewardVideoAdapter {
    private String mAdId;
    private Map<String, Object> mExtraMap;
    private LTRewardVideoAd mRewardVideoView;

    private void beforeLoader(final Context context, Map<String, Object> map, final boolean z) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "slot_id");
        this.mAdId = stringFromMap;
        if (TextUtils.isEmpty(stringFromMap)) {
            notifyATLoadFail("0", "LTMB adId is empty.");
        } else {
            LtAdInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.example.topon_adapter.adapter.LtAdRewardVideoAdapter.1
                public void onFail(String str) {
                    LtAdRewardVideoAdapter.this.notifyATLoadFail("0", str);
                }

                public void onSuccess() {
                    LtAdRewardVideoAdapter.this.startLoadAd(context, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadAd(Context context, final boolean z) {
        LTAdSdk.getInstance().getLTAdRewardVideoLoader(new LTAdSlot.Builder().setAdId(this.mAdId).setRequestAdSize(1080, 1920).setAdCount(1).build(), new LTAdRewardVideoLoadListener() { // from class: com.example.topon_adapter.adapter.LtAdRewardVideoAdapter.2
            public void onAdLoadFailed(int i, String str) {
                Log.e("onAdLoadFailed%s", str);
                LtAdRewardVideoAdapter.this.notifyATLoadFail(String.valueOf(i), str);
            }

            public void onLoaded(LTRewardVideoAd lTRewardVideoAd) {
                LtAdRewardVideoAdapter.this.mRewardVideoView = lTRewardVideoAd;
                LtAdRewardVideoAdapter.this.mRewardVideoView.setLTAdEventListener(new LTAdRewardVideoEventListener() { // from class: com.example.topon_adapter.adapter.LtAdRewardVideoAdapter.2.1
                    public void onAdClicked() {
                        if (((CustomRewardVideoAdapter) LtAdRewardVideoAdapter.this).mImpressionListener != null) {
                            ((CustomRewardVideoAdapter) LtAdRewardVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
                        }
                    }

                    public void onAdRenderFail(int i, String str) {
                        LtAdRewardVideoAdapter.this.notifyATLoadFail(String.valueOf(i), str);
                    }

                    public void onAdShow() {
                        if (((CustomRewardVideoAdapter) LtAdRewardVideoAdapter.this).mImpressionListener != null) {
                            ((CustomRewardVideoAdapter) LtAdRewardVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
                        }
                    }

                    public void onClosed() {
                        if (((CustomRewardVideoAdapter) LtAdRewardVideoAdapter.this).mImpressionListener != null) {
                            ((CustomRewardVideoAdapter) LtAdRewardVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
                        }
                    }

                    public void onRewardVerify(boolean z2, Map<String, Object> map) {
                        if (((CustomRewardVideoAdapter) LtAdRewardVideoAdapter.this).mImpressionListener != null) {
                            ((CustomRewardVideoAdapter) LtAdRewardVideoAdapter.this).mImpressionListener.onReward();
                        }
                    }

                    public void onSkip() {
                        if (((CustomRewardVideoAdapter) LtAdRewardVideoAdapter.this).mImpressionListener != null) {
                            ((CustomRewardVideoAdapter) LtAdRewardVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
                        }
                    }
                });
                if (!z) {
                    if (((CustomRewardVideoAdapter) LtAdRewardVideoAdapter.this).mLoadListener != null) {
                        ((CustomRewardVideoAdapter) LtAdRewardVideoAdapter.this).mLoadListener.onAdDataLoaded();
                        ((CustomRewardVideoAdapter) LtAdRewardVideoAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                        return;
                    }
                    return;
                }
                LtAdRewardVideoAdapter ltAdRewardVideoAdapter = LtAdRewardVideoAdapter.this;
                if (((CustomRewardVideoAdapter) ltAdRewardVideoAdapter).mBiddingListener != null) {
                    ((CustomRewardVideoAdapter) LtAdRewardVideoAdapter.this).mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success((int) ltAdRewardVideoAdapter.mRewardVideoView.getEcpm(), String.valueOf(System.currentTimeMillis()), new LtAdBiddingNotice(LtAdRewardVideoAdapter.this.mRewardVideoView), ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
                }
            }
        });
    }

    public void destory() {
        LTRewardVideoAd lTRewardVideoAd = this.mRewardVideoView;
        if (lTRewardVideoAd != null) {
            lTRewardVideoAd.destroy();
            this.mRewardVideoView = null;
        }
    }

    public ATInitMediation getMediationInitManager() {
        return LtAdInitManager.getInstance();
    }

    public Map<String, Object> getNetworkInfoMap() {
        if (this.mExtraMap == null) {
            this.mExtraMap = new HashMap();
        }
        LTRewardVideoAd lTRewardVideoAd = this.mRewardVideoView;
        if (lTRewardVideoAd != null) {
            this.mExtraMap.put("ecpm", Double.valueOf(lTRewardVideoAd.getEcpm()));
        }
        return this.mExtraMap;
    }

    public String getNetworkName() {
        return LtAdInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.mAdId;
    }

    public String getNetworkSDKVersion() {
        return LtAdInitManager.getInstance().getNetworkVersion();
    }

    public boolean isAdReady() {
        LTRewardVideoAd lTRewardVideoAd = this.mRewardVideoView;
        return (lTRewardVideoAd == null || lTRewardVideoAd.isDestroy() || this.mRewardVideoView.isExpired() || !this.mRewardVideoView.isReady()) ? false : true;
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        beforeLoader(context, map, false);
    }

    public void show(Activity activity) {
        LTRewardVideoAd lTRewardVideoAd = this.mRewardVideoView;
        if (lTRewardVideoAd == null) {
            CustomRewardedVideoEventListener customRewardedVideoEventListener = ((CustomRewardVideoAdapter) this).mImpressionListener;
            if (customRewardedVideoEventListener != null) {
                customRewardedVideoEventListener.onRewardedVideoAdPlayFailed("0", "reward video ad = null");
                return;
            }
            return;
        }
        try {
            if (activity != null) {
                lTRewardVideoAd.showAd(activity);
                return;
            }
            CustomRewardedVideoEventListener customRewardedVideoEventListener2 = ((CustomRewardVideoAdapter) this).mImpressionListener;
            if (customRewardedVideoEventListener2 != null) {
                customRewardedVideoEventListener2.onRewardedVideoAdPlayFailed("0", "activity = null");
            }
        } catch (Throwable th) {
            CustomRewardedVideoEventListener customRewardedVideoEventListener3 = ((CustomRewardVideoAdapter) this).mImpressionListener;
            if (customRewardedVideoEventListener3 != null) {
                customRewardedVideoEventListener3.onRewardedVideoAdPlayFailed("0", th.getMessage());
            }
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        beforeLoader(context, map, true);
        return true;
    }
}
