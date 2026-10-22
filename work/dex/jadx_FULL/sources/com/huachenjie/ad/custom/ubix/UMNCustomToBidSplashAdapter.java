package com.huachenjie.ad.custom.ubix;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.czhj.sdk.common.utils.DeviceUtils;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.ubixnow.adtype.splash.api.UMNSplashAd;
import com.ubixnow.adtype.splash.api.UMNSplashInfo;
import com.ubixnow.adtype.splash.api.UMNSplashListener;
import com.ubixnow.adtype.splash.api.UMNSplashParams;
import com.ubixnow.core.api.UMNError;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomSplashAdapter;
import com.windmill.sdk.models.BidPrice;
import com.zj.adlib.u15;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class UMNCustomToBidSplashAdapter extends WMCustomSplashAdapter {
    private final String TAG = getClass().getSimpleName();
    private UMNSplashAd splashAd;

    public void destroyAd() {
        UMNSplashAd uMNSplashAd = this.splashAd;
        if (uMNSplashAd != null) {
            uMNSplashAd.destroy();
        }
    }

    public boolean isReady() {
        UMNSplashAd uMNSplashAd = this.splashAd;
        if (uMNSplashAd != null) {
            return uMNSplashAd.isValid();
        }
        return false;
    }

    public void loadAd(Context context, ViewGroup viewGroup, Map<String, Object> map, Map<String, Object> map2) {
        if (context != null) {
            try {
                if (context instanceof Activity) {
                    String str = (String) map2.get(TradPlusInitManager.PLACEMENTID);
                    int i = DeviceUtils.getRealMetrics(context).widthPixels;
                    int i2 = DeviceUtils.getRealMetrics(context).heightPixels;
                    float fPx2dp = Utils.px2dp(i);
                    float fPx2dp2 = Utils.px2dp(i2);
                    try {
                        Object obj = map.get("ad_key_width");
                        if (obj != null && ((Integer) obj).intValue() != 0) {
                            fPx2dp = Utils.px2dp(Integer.parseInt(String.valueOf(obj)));
                        }
                        Object obj2 = map.get("ad_key_height");
                        if (obj2 != null && ((Integer) obj2).intValue() != 0) {
                            fPx2dp2 = Utils.px2dp(Integer.parseInt(String.valueOf(obj2)));
                        }
                    } catch (Exception e) {
                        Log.e(this.TAG, "loadAd: " + e);
                    }
                    UMNSplashAd uMNSplashAd = new UMNSplashAd((Activity) context, new UMNSplashParams.Builder().setSlotId(str).setSplashHeight((int) fPx2dp2).setSplashWidth((int) fPx2dp).build(), new UMNSplashListener() { // from class: com.huachenjie.ad.custom.ubix.UMNCustomToBidSplashAdapter.1
                        public void onAdClicked() {
                            Log.e(UMNCustomToBidSplashAdapter.this.TAG, "onAdClicked: ");
                            UMNCustomToBidSplashAdapter.this.callSplashAdClick();
                        }

                        public void onAdDismiss(boolean z) {
                            Log.e(UMNCustomToBidSplashAdapter.this.TAG, "onAdDismiss: ");
                            if (z) {
                                UMNCustomToBidSplashAdapter.this.callSplashAdSkipped();
                            }
                            UMNCustomToBidSplashAdapter.this.callSplashAdClosed();
                        }

                        public void onAdExposure() {
                            Log.e(UMNCustomToBidSplashAdapter.this.TAG, "onAdExposure: ");
                            UMNCustomToBidSplashAdapter.this.callSplashAdShow();
                        }

                        public void onAdLoadSuccess(UMNSplashInfo uMNSplashInfo) {
                            Log.e(UMNCustomToBidSplashAdapter.this.TAG, "onAdLoadSuccess: ");
                            if (UMNCustomToBidSplashAdapter.this.getBiddingType() == 1) {
                                UMNCustomToBidSplashAdapter.this.callLoadBiddingSuccess(new BidPrice(UMNCustomToBidSplashAdapter.this.splashAd.getEcpmInfo().getEcpm()));
                            }
                            UMNCustomToBidSplashAdapter.this.callLoadSuccess();
                        }

                        public void onError(UMNError uMNError) {
                            Log.e(UMNCustomToBidSplashAdapter.this.TAG, "onError: " + uMNError.getCode() + u15.f19942b + uMNError.getDesc());
                            UMNCustomToBidSplashAdapter.this.callLoadFail(new WMAdapterError(Integer.parseInt(uMNError.getCode()), uMNError.getDesc()));
                        }

                        public void showError(UMNError uMNError) {
                            Log.e(UMNCustomToBidSplashAdapter.this.TAG, "showError: " + uMNError.getCode() + u15.f19942b + uMNError.getDesc());
                            UMNCustomToBidSplashAdapter.this.callSplashAdShowError(new WMAdapterError(Integer.parseInt(uMNError.getCode()), uMNError.getDesc()));
                        }
                    });
                    this.splashAd = uMNSplashAd;
                    uMNSplashAd.loadAd();
                    return;
                }
            } catch (Exception e2) {
                callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e2.getMessage()));
                return;
            }
        }
        callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null"));
    }

    public void showAd(Activity activity, ViewGroup viewGroup, Map<String, Object> map) {
        UMNSplashAd uMNSplashAd = this.splashAd;
        if (uMNSplashAd == null || viewGroup == null) {
            return;
        }
        uMNSplashAd.show(viewGroup);
    }
}
