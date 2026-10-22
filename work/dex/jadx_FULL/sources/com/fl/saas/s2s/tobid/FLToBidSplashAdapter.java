package com.fl.saas.s2s.tobid;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.YdSpread;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomSplashAdapter;
import com.windmill.sdk.models.BidPrice;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLToBidSplashAdapter extends WMCustomSplashAdapter {
    private static final String TAG = CommConstant.getClassTag("FLToBid", FLToBidSplashAdapter.class);
    private SpreadLoadListener.SpreadAd mSpreadAd;
    private YdSpread ydSpread;

    public void destroyAd() {
        YdSpread ydSpread = this.ydSpread;
        if (ydSpread != null) {
            ydSpread.destroy();
            this.ydSpread = null;
            this.mSpreadAd = null;
        }
    }

    public boolean isReady() {
        SpreadLoadListener.SpreadAd spreadAd = this.mSpreadAd;
        return spreadAd != null && spreadAd.isAdReady();
    }

    public void loadAd(Context context, ViewGroup viewGroup, Map<String, Object> map, Map<String, Object> map2) {
        String str = (String) map2.get(TradPlusInitManager.PLACEMENTID);
        float f = 1.0f;
        try {
            Object obj = map.get("ad_key_height");
            float f2 = obj != null ? Float.parseFloat(String.valueOf(obj)) : 0.0f;
            float mobileHeight = DeviceUtil.getMobileHeight();
            if (mobileHeight > 0.0f) {
                float f3 = f2 / mobileHeight;
                if (f3 >= 0.75d && f3 < 1.0f) {
                    f = f3;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        YdSpread ydSpreadBuild = new YdSpread.Builder(context).setKey(str).setScreenPercentage(f).setSpreadLoadListener(new SpreadLoadListener() { // from class: com.fl.saas.s2s.tobid.FLToBidSplashAdapter.2
            @Override // com.fl.saas.base.interfaces.SpreadLoadListener
            public void onADLoaded(SpreadLoadListener.SpreadAd spreadAd) {
                LogcatUtil.d(FLToBidSplashAdapter.TAG, "onADLoaded");
                FLToBidSplashAdapter.this.mSpreadAd = spreadAd;
                if (FLToBidSplashAdapter.this.getBiddingType() == 1 && FLToBidSplashAdapter.this.mSpreadAd != null) {
                    FLToBidSplashAdapter.this.callLoadBiddingSuccess(new BidPrice(String.valueOf(FLToBidSplashAdapter.this.mSpreadAd.getEcpm())));
                }
                FLToBidSplashAdapter.this.callLoadSuccess();
            }
        }).setSpreadListener(new AdViewSpreadListener() { // from class: com.fl.saas.s2s.tobid.FLToBidSplashAdapter.1
            @Override // com.fl.saas.base.base.listener.InnerSpreadListener
            public void onAdClick(String str2) {
                FLToBidSplashAdapter.this.callSplashAdClick();
            }

            @Override // com.fl.saas.base.base.listener.InnerSpreadListener
            public void onAdClose() {
                FLToBidSplashAdapter.this.callSplashAdClosed();
            }

            @Override // com.fl.saas.base.base.listener.InnerSpreadListener
            public void onAdDisplay() {
                FLToBidSplashAdapter.this.callSplashAdShow();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                FLToBidSplashAdapter.this.callLoadFail(new WMAdapterError(ydError.getCode(), ydError.getMsg()));
            }
        }).build();
        this.ydSpread = ydSpreadBuild;
        ydSpreadBuild.requestSpread();
    }

    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        super/*com.windmill.sdk.custom.WMAdBaseAdapter*/.notifyBiddingResult(z, str, map);
        try {
            YdSpread ydSpread = this.ydSpread;
            if (ydSpread != null) {
                ydSpread.biddingResultUpload(z, (int) Float.parseFloat(str), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAd(Activity activity, ViewGroup viewGroup, Map<String, Object> map) {
        SpreadLoadListener.SpreadAd spreadAd = this.mSpreadAd;
        if (spreadAd != null) {
            spreadAd.show(viewGroup);
        }
    }
}
