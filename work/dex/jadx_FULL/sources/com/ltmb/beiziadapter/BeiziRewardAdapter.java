package com.ltmb.beiziadapter;

import android.app.Activity;
import android.content.Context;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.rewardvideo.LTAdRewardVideoEventListener;
import com.ltmb.ltsdk.core.load.rewardvideo.LTAdRewardVideoLoadListener;
import com.ltmb.ltsdk.core.load.rewardvideo.LTRewardVideoAd;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import java.util.Map;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdAdapterListener;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class BeiziRewardAdapter extends AMPSRewardAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LTRewardVideoAd f40250a;

    private void initSDK() {
        BeiziInitAdapter.getInstance().initSDK(((AMPSRewardAdapter) this).mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: com.ltmb.beiziadapter.BeiziRewardAdapter.2
            public void failCallBack(AMPSError aMPSError) {
                BeiziRewardAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            public void successCallBack() {
                BeiziRewardAdapter.this.loadAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        LTAdSdk.getInstance().getLTAdRewardVideoLoader(new LTAdSlot.Builder().setAdId(((AMPSRewardAdapter) this).mSpaceId).setAdCount(1).setRequestAdSize(BeiziAdapterSizeUtils.getWidth(((AMPSRewardAdapter) this).mContext), BeiziAdapterSizeUtils.getHeight(((AMPSRewardAdapter) this).mContext)).build(), new LTAdRewardVideoLoadListener() { // from class: com.ltmb.beiziadapter.BeiziRewardAdapter.3
            public void onAdLoadFailed(int i, String str) {
                BeiziRewardAdapter.this.onAdFailed(String.valueOf(i), str);
            }

            public void onLoaded(LTRewardVideoAd lTRewardVideoAd) {
                if (lTRewardVideoAd == null) {
                    BeiziRewardAdapter.this.onAdFailed("0", "加载广告返回广告为空");
                    return;
                }
                BeiziRewardAdapter.this.f40250a = lTRewardVideoAd;
                BeiziRewardAdapter beiziRewardAdapter = BeiziRewardAdapter.this;
                if (((AMPSRewardAdapter) beiziRewardAdapter).isBidding) {
                    beiziRewardAdapter.onC2SBiddingSuccess((int) lTRewardVideoAd.getEcpm());
                } else {
                    beiziRewardAdapter.onAdLoad();
                }
            }
        });
    }

    public boolean isValid() {
        LTRewardVideoAd lTRewardVideoAd = this.f40250a;
        return (lTRewardVideoAd == null || !lTRewardVideoAd.isReady() || this.f40250a.isDestroy()) ? false : true;
    }

    public void showAd(Activity activity) {
        LTRewardVideoAd lTRewardVideoAd = this.f40250a;
        if (lTRewardVideoAd == null || !lTRewardVideoAd.isReady() || this.f40250a.isDestroy()) {
            onAdFailed("0", "激励视频在播放时加载失败");
        } else {
            this.f40250a.setLTAdEventListener(new LTAdRewardVideoEventListener() { // from class: com.ltmb.beiziadapter.BeiziRewardAdapter.1
                public void onAdClicked() {
                    BeiziRewardAdapter.this.onAdClicked();
                }

                public void onAdRenderFail(int i, String str) {
                    BeiziRewardAdapter.this.onAdShowFailed(String.valueOf(i), str);
                }

                public void onAdShow() {
                    BeiziRewardAdapter.this.onAdShow();
                }

                public void onClosed() {
                    BeiziRewardAdapter.this.onAdDismiss();
                }

                public void onRewardVerify(boolean z, Map<String, Object> map) {
                    BeiziRewardAdapter.this.onRewardArrived(z, 0, map);
                }

                public void onSkip() {
                }
            });
            this.f40250a.showAd(activity);
        }
    }

    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }

    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSRewardVideoAdAdapterListener aMPSRewardVideoAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSRewardVideoAdAdapterListener);
        if (((AMPSRewardAdapter) this).isBidding) {
            onAdLoad();
        } else {
            initSDK();
        }
    }
}
