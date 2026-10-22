package com.huachenjie.ad.custom.ubix;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.czhj.sdk.common.utils.DeviceUtils;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.ubixnow.adtype.interstital.api.UMNInterstitalAd;
import com.ubixnow.adtype.interstital.api.UMNInterstitalListener;
import com.ubixnow.adtype.interstital.api.UMNInterstitalParams;
import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.bean.UMNAdInfo;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomInterstitialAdapter;
import com.windmill.sdk.models.BidPrice;
import com.zj.adlib.u15;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class UMNCustomToBidInterstitialAdapter extends WMCustomInterstitialAdapter {
    private final String TAG = getClass().getSimpleName();
    private UMNInterstitalAd interstitialAd;

    public void destroyAd() {
        UMNInterstitalAd uMNInterstitalAd = this.interstitialAd;
        if (uMNInterstitalAd != null) {
            uMNInterstitalAd.destroy();
        }
    }

    public boolean isReady() {
        UMNInterstitalAd uMNInterstitalAd = this.interstitialAd;
        if (uMNInterstitalAd != null) {
            return uMNInterstitalAd.isValid();
        }
        return false;
    }

    public void loadAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        try {
            String str = (String) map2.get(TradPlusInitManager.PLACEMENTID);
            int i = DeviceUtils.getRealMetrics(context).widthPixels;
            int i2 = DeviceUtils.getRealMetrics(context).heightPixels;
            float f = i;
            float fPx2dp = Utils.px2dp(f);
            float fPx2dp2 = Utils.px2dp(i2);
            try {
                Object obj = map.get("ad_key_width");
                if (obj != null && ((Integer) obj).intValue() != 0) {
                    fPx2dp = Utils.px2dp(f);
                }
                Object obj2 = map.get("ad_key_height");
                if (obj2 != null && ((Integer) obj2).intValue() != 0) {
                    fPx2dp2 = Utils.px2dp(Integer.parseInt(String.valueOf(obj2)));
                }
            } catch (Exception e) {
                Log.e(this.TAG, "loadAd: " + e);
            }
            Log.d(this.TAG, "loadAd:" + str);
            UMNInterstitalAd uMNInterstitalAd = new UMNInterstitalAd(context.getApplicationContext(), new UMNInterstitalParams.Builder().setSlotId(str).setInterstitalHeight((int) fPx2dp2).setInterstitalWidth((int) fPx2dp).build(), new UMNInterstitalListener() { // from class: com.huachenjie.ad.custom.ubix.UMNCustomToBidInterstitialAdapter.1
                public void onAdClicked() {
                    Log.d(UMNCustomToBidInterstitialAdapter.this.TAG, "onAdClicked: ");
                    UMNCustomToBidInterstitialAdapter.this.callVideoAdClick();
                }

                public void onAdDismiss() {
                    Log.d(UMNCustomToBidInterstitialAdapter.this.TAG, "onAdDismiss: ");
                    UMNCustomToBidInterstitialAdapter.this.callVideoAdClosed();
                }

                public void onAdExposure() {
                    Log.d(UMNCustomToBidInterstitialAdapter.this.TAG, "onAdExposure: ");
                    UMNCustomToBidInterstitialAdapter.this.callVideoAdShow();
                }

                public void onAdLoadSuccess(UMNAdInfo uMNAdInfo) {
                    Log.d(UMNCustomToBidInterstitialAdapter.this.TAG, "onAdLoadSuccess: ");
                    if (UMNCustomToBidInterstitialAdapter.this.getBiddingType() == 1) {
                        UMNCustomToBidInterstitialAdapter.this.callLoadBiddingSuccess(new BidPrice(UMNCustomToBidInterstitialAdapter.this.interstitialAd.getEcpmInfo().getEcpm()));
                    }
                    UMNCustomToBidInterstitialAdapter.this.callLoadSuccess();
                }

                public void onError(UMNError uMNError) {
                    Log.d(UMNCustomToBidInterstitialAdapter.this.TAG, "onError: " + uMNError.getCode() + u15.f19942b + uMNError.getDesc());
                    UMNCustomToBidInterstitialAdapter.this.callLoadFail(new WMAdapterError(Integer.parseInt(uMNError.getCode()), uMNError.getDesc()));
                }

                public void showError(UMNError uMNError) {
                    Log.d(UMNCustomToBidInterstitialAdapter.this.TAG, "showError: " + uMNError.getCode() + u15.f19942b + uMNError.getDesc());
                }
            });
            this.interstitialAd = uMNInterstitalAd;
            uMNInterstitalAd.loadAd();
        } catch (Throwable th) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "catch TT loadAd error " + th.getMessage()));
        }
    }

    public void showAd(Activity activity, HashMap<String, String> map, Map<String, Object> map2) {
        try {
            this.interstitialAd.show(activity);
        } catch (Throwable th) {
            callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "catch TT presentVideoAd error " + th.getMessage()));
        }
    }
}
