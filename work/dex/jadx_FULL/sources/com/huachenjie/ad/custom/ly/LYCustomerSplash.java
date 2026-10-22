package com.huachenjie.ad.custom.ly;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import cj.mobile.CJSplash;
import cj.mobile.listener.CJSplashListener;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomSplashAdapter;
import com.windmill.sdk.models.BidPrice;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class LYCustomerSplash extends WMCustomSplashAdapter {
    CJSplash splash = new CJSplash();

    public void destroyAd() {
        this.splash.destroy();
    }

    public boolean isReady() {
        return this.splash.isValid();
    }

    public void loadAd(Context context, ViewGroup viewGroup, Map<String, Object> map, Map<String, Object> map2) {
        int width;
        int i;
        int i2;
        int height;
        String string = map2.get(TradPlusInitManager.PLACEMENTID).toString();
        int i3 = 0;
        if (viewGroup != null) {
            try {
                width = viewGroup.getWidth();
                try {
                    height = viewGroup.getHeight();
                    i3 = width;
                } catch (Exception unused) {
                    i = 0;
                    i2 = width;
                }
            } catch (Exception unused2) {
                width = 0;
            }
        } else {
            height = 0;
        }
        i = height;
        i2 = i3;
        if (i2 == 0 || i == 0) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "ad_key_width or ad_key_height is null"));
        } else {
            this.splash.loadAd(context, string, i2, i, new CJSplashListener() { // from class: com.huachenjie.ad.custom.ly.LYCustomerSplash.1
                @Override // cj.mobile.listener.CJSplashListener
                public void onClick() {
                    LYCustomerSplash.this.callSplashAdClick();
                }

                @Override // cj.mobile.listener.CJSplashListener
                public void onClose() {
                    LYCustomerSplash.this.callSplashAdClosed();
                }

                @Override // cj.mobile.listener.CJSplashListener
                public void onError(String str, String str2) {
                    LYCustomerSplash.this.callLoadFail(new WMAdapterError(10004, str2));
                }

                @Override // cj.mobile.listener.CJSplashListener
                public void onLoad() {
                    if (LYCustomerSplash.this.getBiddingType() == 1) {
                        LYCustomerSplash.this.callLoadBiddingSuccess(new BidPrice(LYCustomerSplash.this.splash.getEcpm() + "", BidPrice.CNY));
                    }
                    LYCustomerSplash.this.callLoadSuccess();
                }

                @Override // cj.mobile.listener.CJSplashListener
                public void onShow() {
                    LYCustomerSplash.this.callSplashAdShow();
                }
            });
        }
    }

    public void showAd(Activity activity, ViewGroup viewGroup, Map<String, Object> map) {
        this.splash.showAd(activity, viewGroup);
    }
}
