package com.example.topon_adapter.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.interstitial.LTAdInterstitialEventListener;
import com.ltmb.ltsdk.core.load.interstitial.LTAdInterstitialLoadListener;
import com.ltmb.ltsdk.core.load.interstitial.LTInterstitialAd;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LtAdInterstitialAdapter extends CustomInterstitialAdapter {
    private LTInterstitialAd ltInterstitialAd;
    private String mAdId;

    private void beforeLoader(final Context context, Map<String, Object> map, final boolean z) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "slot_id");
        this.mAdId = stringFromMap;
        if (TextUtils.isEmpty(stringFromMap)) {
            notifyATLoadFail("0", "LiteMob ad_id is null");
        } else {
            LtAdInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.example.topon_adapter.adapter.LtAdInterstitialAdapter.2
                public void onFail(String str) {
                    LtAdInterstitialAdapter.this.notifyATLoadFail("0", str);
                }

                public void onSuccess() {
                    LtAdInterstitialAdapter.this.startLoadAd(context, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadAd(Context context, final boolean z) {
        LTAdSdk.getInstance().getLTAdInterstitialLoader(new LTAdSlot.Builder().setAdId(this.mAdId).setAdCount(1).setRequestAdSize(getWidth(context), getWidth(context) / 2).build(), new LTAdInterstitialLoadListener() { // from class: com.example.topon_adapter.adapter.LtAdInterstitialAdapter.3
            public void onAdLoadFailed(int i, String str) {
                if (((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mLoadListener != null) {
                    ((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mLoadListener.onAdLoadError(String.valueOf(i), str);
                }
            }

            public void onLoaded(LTInterstitialAd lTInterstitialAd) {
                if (lTInterstitialAd == null) {
                    if (((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mLoadListener != null) {
                        ((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mLoadListener.onAdLoadError("0", "广告为空");
                        return;
                    }
                    return;
                }
                LtAdInterstitialAdapter.this.ltInterstitialAd = lTInterstitialAd;
                if (!z) {
                    if (((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mLoadListener != null) {
                        ((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    }
                } else if (((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mBiddingListener != null) {
                    ((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success((int) lTInterstitialAd.getEcpm(), String.valueOf(System.currentTimeMillis()), new LtAdBiddingNotice(lTInterstitialAd), ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
                }
            }
        });
    }

    public int getHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public String getNetworkName() {
        return LtAdInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.mAdId;
    }

    public String getNetworkSDKVersion() {
        return "2.9.0";
    }

    public int getWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public boolean isAdReady() {
        LTInterstitialAd lTInterstitialAd = this.ltInterstitialAd;
        return lTInterstitialAd != null && lTInterstitialAd.isReady();
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        beforeLoader(context, map, false);
    }

    public void show(Activity activity) {
        LTInterstitialAd lTInterstitialAd = this.ltInterstitialAd;
        if (lTInterstitialAd != null) {
            lTInterstitialAd.setLTAdEventListener(new LTAdInterstitialEventListener() { // from class: com.example.topon_adapter.adapter.LtAdInterstitialAdapter.1
                public void onAdClicked() {
                    if (((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
                    }
                }

                public void onAdRenderFail(int i, String str) {
                    if (((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoError(String.valueOf(i), str);
                    }
                }

                public void onAdShow() {
                    if (((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
                    }
                }

                public void onClosed() {
                    if (((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) LtAdInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
                    }
                }
            });
            this.ltInterstitialAd.showAd(activity);
        } else {
            CustomInterstitialEventListener customInterstitialEventListener = ((CustomInterstitialAdapter) this).mImpressListener;
            if (customInterstitialEventListener != null) {
                customInterstitialEventListener.onInterstitialAdVideoError(String.valueOf(0), "广告为空");
            }
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        beforeLoader(context, map, true);
        return true;
    }
}
