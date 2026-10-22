package com.ltmb.beiziadapter;

import android.app.Activity;
import android.content.Context;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.interstitial.LTAdInterstitialEventListener;
import com.ltmb.ltsdk.core.load.interstitial.LTAdInterstitialLoadListener;
import com.ltmb.ltsdk.core.load.interstitial.LTInterstitialAd;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class BeiziInterstitialAdapter extends AMPSInterstitialAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LTInterstitialAd f40241a;

    private void initSDK() {
        BeiziInitAdapter.getInstance().initSDK(((AMPSInterstitialAdapter) this).mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: com.ltmb.beiziadapter.BeiziInterstitialAdapter.2
            public void failCallBack(AMPSError aMPSError) {
                BeiziInterstitialAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            public void successCallBack() {
                BeiziInterstitialAdapter.this.loadAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        LTAdSdk.getInstance().getLTAdInterstitialLoader(new LTAdSlot.Builder().setAdId(((AMPSInterstitialAdapter) this).mSpaceId).setAdCount(1).setRequestAdSize(BeiziAdapterSizeUtils.getWidth(((AMPSInterstitialAdapter) this).mContext), BeiziAdapterSizeUtils.getHeight(((AMPSInterstitialAdapter) this).mContext)).build(), new LTAdInterstitialLoadListener() { // from class: com.ltmb.beiziadapter.BeiziInterstitialAdapter.3
            public void onAdLoadFailed(int i, String str) {
                BeiziInterstitialAdapter.this.onAdFailed(String.valueOf(i), str);
            }

            public void onLoaded(LTInterstitialAd lTInterstitialAd) {
                if (lTInterstitialAd == null) {
                    BeiziInterstitialAdapter.this.onAdFailed("0", "广告为空");
                    return;
                }
                BeiziInterstitialAdapter.this.f40241a = lTInterstitialAd;
                BeiziInterstitialAdapter beiziInterstitialAdapter = BeiziInterstitialAdapter.this;
                if (((AMPSInterstitialAdapter) beiziInterstitialAdapter).isBidding) {
                    beiziInterstitialAdapter.onC2SBiddingSuccess((int) lTInterstitialAd.getEcpm());
                } else {
                    beiziInterstitialAdapter.onAdLoad();
                }
            }
        });
    }

    public void destroy() {
        super/*xyz.adscope.amps.base.AMPSBaseAdapter*/.destroy();
        try {
            LTInterstitialAd lTInterstitialAd = this.f40241a;
            if (lTInterstitialAd != null) {
                lTInterstitialAd.destroy();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isValid() {
        LTInterstitialAd lTInterstitialAd = this.f40241a;
        return (lTInterstitialAd == null || !lTInterstitialAd.isReady() || this.f40241a.isDestroy()) ? false : true;
    }

    public void showAd(Activity activity) {
        LTInterstitialAd lTInterstitialAd = this.f40241a;
        if (lTInterstitialAd == null) {
            onAdShowFailed("0", "广告在播放时为空");
        } else {
            lTInterstitialAd.setLTAdEventListener(new LTAdInterstitialEventListener() { // from class: com.ltmb.beiziadapter.BeiziInterstitialAdapter.1
                public void onAdClicked() {
                    BeiziInterstitialAdapter.this.onAdClicked();
                }

                public void onAdRenderFail(int i, String str) {
                    BeiziInterstitialAdapter.this.onAdShowFailed(String.valueOf(i), str);
                }

                public void onAdShow() {
                    BeiziInterstitialAdapter.this.onAdShow();
                }

                public void onClosed() {
                    BeiziInterstitialAdapter.this.onAdDismiss();
                }
            });
            this.f40241a.showAd(activity);
        }
    }

    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }

    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSInterstitialAdAdapterListener);
        if (((AMPSInterstitialAdapter) this).isBidding) {
            onAdLoad();
        } else {
            initSDK();
        }
    }
}
