package com.example.topon_adapter.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.banner.unitgroup.api.CustomBannerEventListener;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.example.topon_adapter.views.BannerAdKeView;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.banner.LTAdBannerEventListener;
import com.ltmb.ltsdk.core.load.banner.LTAdBannerLoadListener;
import com.ltmb.ltsdk.core.load.banner.LTBannerAd;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LtAdBannerAdapter extends CustomBannerAdapter {
    private Context context;
    private String mAdId;
    private FrameLayout mBannerContainer;
    private LTBannerAd mLTBannerAd;

    private void beforeLoader(final Context context, Map<String, Object> map, final boolean z) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "slot_id");
        this.mAdId = stringFromMap;
        if (TextUtils.isEmpty(stringFromMap)) {
            notifyATLoadFail("0", "LiteMob ad_id is null");
        } else {
            LtAdInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.example.topon_adapter.adapter.LtAdBannerAdapter.1
                public void onFail(String str) {
                    LtAdBannerAdapter.this.notifyATLoadFail("0", str);
                }

                public void onSuccess() {
                    LtAdBannerAdapter.this.startLoadAd(context, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadAd(Context context, final boolean z) {
        this.context = context;
        LTAdSdk.getInstance().getLTAdBannerLoader(new LTAdSlot.Builder().setAdId(this.mAdId).setRequestAdSize(1080, 200).setAdCount(1).build(), new LTAdBannerLoadListener() { // from class: com.example.topon_adapter.adapter.LtAdBannerAdapter.2
            public void onAdLoadFailed(int i, String str) {
                LtAdBannerAdapter.this.notifyATLoadFail(String.valueOf(i), str);
            }

            public void onLoaded(LTBannerAd lTBannerAd) {
                LtAdBannerAdapter.this.mLTBannerAd = lTBannerAd;
                LtAdBannerAdapter.this.mLTBannerAd.setLTAdEventListener(new LTAdBannerEventListener() { // from class: com.example.topon_adapter.adapter.LtAdBannerAdapter.2.1
                    public void onAdClicked() {
                        CustomBannerEventListener customBannerEventListener = ((CustomBannerAdapter) LtAdBannerAdapter.this).mImpressionEventListener;
                        if (customBannerEventListener != null) {
                            customBannerEventListener.onBannerAdClicked();
                        }
                    }

                    public void onAdRenderFail(int i, String str) {
                        LtAdBannerAdapter.this.notifyATLoadFail(String.valueOf(i), str);
                    }

                    public void onAdShow() {
                        CustomBannerEventListener customBannerEventListener = ((CustomBannerAdapter) LtAdBannerAdapter.this).mImpressionEventListener;
                        if (customBannerEventListener != null) {
                            customBannerEventListener.onBannerAdShow();
                        }
                    }

                    public void onClosed() {
                        CustomBannerEventListener customBannerEventListener = ((CustomBannerAdapter) LtAdBannerAdapter.this).mImpressionEventListener;
                        if (customBannerEventListener != null) {
                            customBannerEventListener.onBannerAdClose();
                        }
                        if (LtAdBannerAdapter.this.mLTBannerAd != null) {
                            LtAdBannerAdapter.this.mLTBannerAd.destroy();
                            LtAdBannerAdapter.this.mLTBannerAd = null;
                        }
                    }
                });
                if (!z) {
                    if (((CustomBannerAdapter) LtAdBannerAdapter.this).mLoadListener != null) {
                        ((CustomBannerAdapter) LtAdBannerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    }
                } else {
                    LtAdBannerAdapter ltAdBannerAdapter = LtAdBannerAdapter.this;
                    if (((CustomBannerAdapter) ltAdBannerAdapter).mBiddingListener != null) {
                        ((CustomBannerAdapter) LtAdBannerAdapter.this).mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success((int) ltAdBannerAdapter.mLTBannerAd.getEcpm(), String.valueOf(System.currentTimeMillis()), new LtAdBiddingNotice(LtAdBannerAdapter.this.mLTBannerAd), ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
                    }
                }
            }
        });
    }

    public void destory() {
        LTBannerAd lTBannerAd = this.mLTBannerAd;
        if (lTBannerAd != null) {
            lTBannerAd.destroy();
            this.mLTBannerAd = null;
        }
        FrameLayout frameLayout = this.mBannerContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.mBannerContainer = null;
        }
    }

    public View getBannerView() {
        if (this.mLTBannerAd != null) {
            return new BannerAdKeView(this.context, this.mLTBannerAd);
        }
        return null;
    }

    public ATInitMediation getMediationInitManager() {
        return LtAdInitManager.getInstance();
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

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        beforeLoader(context, map, false);
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        beforeLoader(context, map, true);
        return true;
    }
}
