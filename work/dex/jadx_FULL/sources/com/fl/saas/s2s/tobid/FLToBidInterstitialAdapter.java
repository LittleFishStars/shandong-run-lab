package com.fl.saas.s2s.tobid;

import android.app.Activity;
import android.content.Context;
import com.fl.saas.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.YdInterstitial;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomInterstitialAdapter;
import com.windmill.sdk.models.BidPrice;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLToBidInterstitialAdapter extends WMCustomInterstitialAdapter {
    private static final String TAG = CommConstant.getClassTag("FLToBid", FLToBidInterstitialAdapter.class);
    private YdInterstitial ydInterstitial;

    public void destroyAd() {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        if (ydInterstitial != null) {
            ydInterstitial.destroy();
            this.ydInterstitial = null;
        }
    }

    public boolean isReady() {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        return ydInterstitial != null && ydInterstitial.isReady();
    }

    public void loadAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        YdInterstitial ydInterstitialBuild = new YdInterstitial.Builder(context).setKey((String) map2.get(TradPlusInitManager.PLACEMENTID)).setInterstitialListener(new AdViewInterstitialListener() { // from class: com.fl.saas.s2s.tobid.FLToBidInterstitialAdapter.1
            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdClick(String str) {
                LogcatUtil.d(FLToBidInterstitialAdapter.TAG, "ydInterstitial onAdClick");
                FLToBidInterstitialAdapter.this.callVideoAdClick();
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdClosed() {
                LogcatUtil.d(FLToBidInterstitialAdapter.TAG, "ydInterstitial onAdClosed");
                FLToBidInterstitialAdapter.this.callVideoAdClosed();
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdDisplay() {
                LogcatUtil.d(FLToBidInterstitialAdapter.TAG, "ydInterstitial onAdDisplay");
                FLToBidInterstitialAdapter.this.callVideoAdShow();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                LogcatUtil.d(FLToBidInterstitialAdapter.TAG, "ydInterstitial onAdFailed:" + ydError.toString());
                FLToBidInterstitialAdapter.this.callLoadFail(new WMAdapterError(ydError.getCode(), ydError.getMsg()));
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdReady() {
                LogcatUtil.d(FLToBidInterstitialAdapter.TAG, "ydInterstitial onAdReady");
                if (FLToBidInterstitialAdapter.this.getBiddingType() == 1 && FLToBidInterstitialAdapter.this.ydInterstitial != null) {
                    FLToBidInterstitialAdapter.this.callLoadBiddingSuccess(new BidPrice(String.valueOf(FLToBidInterstitialAdapter.this.ydInterstitial.getECPM())));
                }
                FLToBidInterstitialAdapter.this.callLoadSuccess();
            }
        }).build();
        this.ydInterstitial = ydInterstitialBuild;
        ydInterstitialBuild.requestInterstitial();
    }

    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        super/*com.windmill.sdk.custom.WMAdBaseAdapter*/.notifyBiddingResult(z, str, map);
        try {
            YdInterstitial ydInterstitial = this.ydInterstitial;
            if (ydInterstitial != null) {
                ydInterstitial.biddingResultUpload(z, (int) Float.parseFloat(str), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAd(Activity activity, HashMap<String, String> map, Map<String, Object> map2) {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        if (ydInterstitial != null) {
            ydInterstitial.show(activity);
        }
    }
}
