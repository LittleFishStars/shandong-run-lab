package com.ltmb.beiziadapter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.banner.LTAdBannerEventListener;
import com.ltmb.ltsdk.core.load.banner.LTAdBannerLoadListener;
import com.ltmb.ltsdk.core.load.banner.LTBannerAd;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdAdapterListener;
import xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class BeiziBannerAdapter extends AMPSBannerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LTBannerAd f40235a;

    private void initSDK() {
        Log.d("beiziadapter-banner", "加载广告");
        BeiziInitAdapter.getInstance().initSDK(((AMPSBannerAdapter) this).mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: com.ltmb.beiziadapter.BeiziBannerAdapter.2
            public void failCallBack(AMPSError aMPSError) {
                BeiziBannerAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            public void successCallBack() {
                BeiziBannerAdapter.this.loadAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        LTAdSdk.getInstance().getLTAdBannerLoader(new LTAdSlot.Builder().setAdId(((AMPSBannerAdapter) this).mSpaceId).setAdCount(1).setRequestAdSize(BeiziAdapterSizeUtils.getWidth(((AMPSBannerAdapter) this).mContext), BeiziAdapterSizeUtils.getHeight(((AMPSBannerAdapter) this).mContext)).build(), new LTAdBannerLoadListener() { // from class: com.ltmb.beiziadapter.BeiziBannerAdapter.3
            public void onAdLoadFailed(int i, String str) {
                BeiziBannerAdapter.this.onAdFailed(String.valueOf(i), str);
                Log.e("beiziadapter-banner", "广告加载失败, " + i + ", " + str);
            }

            public void onLoaded(LTBannerAd lTBannerAd) {
                if (lTBannerAd == null) {
                    Log.e("beiziadapter-banner", "广告为空");
                    BeiziBannerAdapter.this.onAdFailed("0", "广告为空");
                    return;
                }
                BeiziBannerAdapter.this.f40235a = lTBannerAd;
                BeiziBannerAdapter beiziBannerAdapter = BeiziBannerAdapter.this;
                if (!((AMPSBannerAdapter) beiziBannerAdapter).isBidding) {
                    beiziBannerAdapter.onAdLoad();
                    Log.e("beiziadapter-banner", "广告加载成功");
                    return;
                }
                beiziBannerAdapter.onC2SBiddingSuccess((int) lTBannerAd.getEcpm());
                Log.e("beiziadapter-banner", "广告竞价成功，ecpm=" + lTBannerAd.getEcpm());
            }
        });
    }

    public void destroy() {
        super/*xyz.adscope.amps.base.AMPSBaseAdapter*/.destroy();
        try {
            LTBannerAd lTBannerAd = this.f40235a;
            if (lTBannerAd != null) {
                lTBannerAd.destroy();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isValid() {
        LTBannerAd lTBannerAd = this.f40235a;
        return (lTBannerAd == null || lTBannerAd.isDestroy() || !this.f40235a.isReady()) ? false : true;
    }

    public void showAd(ViewGroup viewGroup) {
        LTBannerAd lTBannerAd = this.f40235a;
        if (lTBannerAd == null) {
            onAdShowFailed("0", "广告展示错误, 广告为空");
            return;
        }
        lTBannerAd.setLTAdEventListener(new LTAdBannerEventListener() { // from class: com.ltmb.beiziadapter.BeiziBannerAdapter.1
            public void onAdClicked() {
                BeiziBannerAdapter.this.onAdClicked();
            }

            public void onAdRenderFail(int i, String str) {
                BeiziBannerAdapter.this.onAdShowFailed(String.valueOf(i), str);
            }

            public void onAdShow() {
                BeiziBannerAdapter.this.onAdShow();
            }

            public void onClosed() {
                BeiziBannerAdapter.this.onAdDismiss();
            }
        });
        try {
            this.f40235a.showAd(viewGroup);
        } catch (Exception e) {
            onAdShowFailed("0", "广告展示错误, 请检查广告addView逻辑，是否重复添加布局");
            e.printStackTrace();
        }
    }

    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }

    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSBannerAdAdapterListener aMPSBannerAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSBannerAdAdapterListener);
        if (((AMPSBannerAdapter) this).isBidding) {
            onAdLoad();
        } else {
            initSDK();
        }
    }
}
