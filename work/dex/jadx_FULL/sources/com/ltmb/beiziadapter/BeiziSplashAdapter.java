package com.ltmb.beiziadapter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import com.ltmb.ltsdk.core.load.splash.LTAdSplashEventListener;
import com.ltmb.ltsdk.core.load.splash.LTAdSplashLoadListener;
import com.ltmb.ltsdk.core.load.splash.LTSplashAd;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class BeiziSplashAdapter extends AMPSSplashAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LTSplashAd f40254a;
    public boolean b = false;

    private void initSDK() {
        BeiziInitAdapter.getInstance().initSDK(((AMPSSplashAdapter) this).mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: com.ltmb.beiziadapter.BeiziSplashAdapter.2
            public void failCallBack(AMPSError aMPSError) {
                Log.e("beiziadapter-splash", "初始化失败， " + aMPSError.getCode() + "," + aMPSError.getMessage());
            }

            public void successCallBack() {
                Log.e("beiziadapter-splash", "初始化成功");
                BeiziSplashAdapter.this.loadAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        Log.e("beiziadapter-splash", "加载广告");
        LTAdSdk.getInstance().getLTAdSplashLoader(new LTAdSlot.Builder().setAdId(((AMPSSplashAdapter) this).mSpaceId).setAdCount(1).setRequestAdSize(BeiziAdapterSizeUtils.getWidth(((AMPSSplashAdapter) this).mContext), BeiziAdapterSizeUtils.getHeight(((AMPSSplashAdapter) this).mContext)).build(), new LTAdSplashLoadListener() { // from class: com.ltmb.beiziadapter.BeiziSplashAdapter.3
            public void onAdLoadFailed(int i, String str) {
                BeiziSplashAdapter.this.onAdFailed(String.valueOf(i), str);
                Log.e("beiziadapter-splash", "广告加载失败, " + i + ", " + str);
            }

            public void onLoaded(LTSplashAd lTSplashAd) {
                if (lTSplashAd == null) {
                    Log.e("beiziadapter-splash", "广告为空");
                    BeiziSplashAdapter.this.onAdFailed("0", "广告为空");
                    return;
                }
                BeiziSplashAdapter.this.f40254a = lTSplashAd;
                BeiziSplashAdapter beiziSplashAdapter = BeiziSplashAdapter.this;
                if (!((AMPSSplashAdapter) beiziSplashAdapter).isBidding) {
                    beiziSplashAdapter.onAdLoad();
                    Log.e("beiziadapter-splash", "广告加载成功");
                    return;
                }
                beiziSplashAdapter.onC2SBiddingSuccess((int) lTSplashAd.getEcpm());
                Log.e("beiziadapter-splash", "广告竞价成功，ecpm=" + lTSplashAd.getEcpm());
            }
        });
    }

    public boolean isValid() {
        LTSplashAd lTSplashAd = this.f40254a;
        return (lTSplashAd == null || lTSplashAd.isDestroy() || !this.f40254a.isReady()) ? false : true;
    }

    public void showAd(ViewGroup viewGroup) {
        LTSplashAd lTSplashAd = this.f40254a;
        if (lTSplashAd == null) {
            onAdShowFailed("0", "广告展示错误, 广告为空");
            return;
        }
        lTSplashAd.setLTAdEventListener(new LTAdSplashEventListener() { // from class: com.ltmb.beiziadapter.BeiziSplashAdapter.1
            public void onAdClicked() {
                BeiziSplashAdapter.this.onAdClicked();
            }

            public void onAdRenderFail(int i, String str) {
                BeiziSplashAdapter.this.onAdShowFailed(String.valueOf(i), str);
            }

            public void onAdShow() {
                BeiziSplashAdapter.this.onAdShow();
            }

            public void onAdSkip() {
                if (BeiziSplashAdapter.this.b) {
                    return;
                }
                BeiziSplashAdapter.this.b = true;
                BeiziSplashAdapter.this.onAdDismiss();
            }

            public void onClosed() {
                if (BeiziSplashAdapter.this.b) {
                    return;
                }
                BeiziSplashAdapter.this.b = true;
                BeiziSplashAdapter.this.onAdDismiss();
            }
        });
        try {
            this.f40254a.showAd(viewGroup);
        } catch (Exception e) {
            onAdShowFailed("0", "广告展示错误, 请检查广告addView逻辑，是否重复添加布局");
            e.printStackTrace();
        }
    }

    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }

    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSSplashAdAdapterListener aMPSSplashAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSSplashAdAdapterListener);
        if (((AMPSSplashAdapter) this).isBidding) {
            onAdLoad();
        } else {
            initSDK();
        }
    }
}
