package com.fl.saas.s2s.tobid;

import android.content.Context;
import android.view.View;
import com.fl.saas.base.interfaces.AdViewBannerListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.YdBanner;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomBannerAdapter;
import com.windmill.sdk.models.BidPrice;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLToBidBannerAdapter extends WMCustomBannerAdapter {
    private static final String TAG = CommConstant.getClassTag("FLToBid", FLToBidBannerAdapter.class);
    private View bannerView;
    private YdBanner ydBanner;

    public void destroyAd() {
        YdBanner ydBanner = this.ydBanner;
        if (ydBanner != null) {
            ydBanner.destroy();
            this.ydBanner = null;
            this.bannerView = null;
        }
    }

    public View getBannerView() {
        return this.bannerView;
    }

    public boolean isReady() {
        return this.bannerView != null;
    }

    public void loadAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        float f;
        float f2;
        String str = (String) map2.get(TradPlusInitManager.PLACEMENTID);
        try {
            Object obj = map.get("ad_key_width");
            f = obj != null ? Float.parseFloat(String.valueOf(obj)) : 0.0f;
            try {
                Object obj2 = map.get("ad_key_height");
                f2 = obj2 != null ? Float.parseFloat(String.valueOf(obj2)) : 0.0f;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
            f = 0.0f;
        }
        YdBanner.Builder builder = new YdBanner.Builder(context);
        if (f > 0.0f && f2 > 0.0f) {
            builder.setExpressWidth((int) f).setExpressHeight((int) f2);
        }
        YdBanner ydBannerBuild = builder.setKey(str).setBannerListener(new AdViewBannerListener() { // from class: com.fl.saas.s2s.tobid.FLToBidBannerAdapter.1
            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onAdClick(String str2) {
                LogcatUtil.d(FLToBidBannerAdapter.TAG, "onAdClick");
                FLToBidBannerAdapter.this.callBannerAdClick();
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onAdExposure() {
                LogcatUtil.d(FLToBidBannerAdapter.TAG, "onAdExposure");
                FLToBidBannerAdapter.this.callBannerAdShow();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                LogcatUtil.d(FLToBidBannerAdapter.TAG, "error:" + ydError.toString());
                FLToBidBannerAdapter.this.callLoadFail(new WMAdapterError(ydError.getCode(), ydError.getMsg()));
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onClosed() {
                LogcatUtil.d(FLToBidBannerAdapter.TAG, "onClosed");
                FLToBidBannerAdapter.this.callBannerAdClosed();
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onReceived(View view) {
                LogcatUtil.d(FLToBidBannerAdapter.TAG, "onReceived");
                FLToBidBannerAdapter.this.bannerView = view;
                if (FLToBidBannerAdapter.this.getBiddingType() == 1 && FLToBidBannerAdapter.this.ydBanner != null) {
                    FLToBidBannerAdapter.this.callLoadBiddingSuccess(new BidPrice(String.valueOf(FLToBidBannerAdapter.this.ydBanner.getECPM())));
                }
                FLToBidBannerAdapter.this.callLoadSuccess();
            }
        }).build();
        this.ydBanner = ydBannerBuild;
        ydBannerBuild.requestBanner();
    }

    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        super/*com.windmill.sdk.custom.WMAdBaseAdapter*/.notifyBiddingResult(z, str, map);
        try {
            YdBanner ydBanner = this.ydBanner;
            if (ydBanner != null) {
                ydBanner.biddingResultUpload(z, (int) Float.parseFloat(str), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
