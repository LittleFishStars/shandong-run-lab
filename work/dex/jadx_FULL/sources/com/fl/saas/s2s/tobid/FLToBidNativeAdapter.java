package com.fl.saas.s2s.tobid;

import android.content.Context;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.api.YdSDK;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.models.BidPrice;
import com.windmill.sdk.natives.WMNativeAdData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLToBidNativeAdapter extends WMCustomNativeAdapter {
    private static final String TAG = CommConstant.getClassTag("FLToBid", FLToBidNativeAdapter.class);
    private List<WMNativeAdData> list;

    public void destroyAd() {
    }

    public List<WMNativeAdData> getNativeAdDataList() {
        return this.list;
    }

    public boolean isReady() {
        List<WMNativeAdData> list = this.list;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void loadAd(final Context context, Map<String, Object> map, Map<String, Object> map2) {
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
        AdParams.Builder builder = new AdParams.Builder(str);
        if (f > 0.0f) {
            builder.setExpressWidth(f);
        }
        if (f2 > 0.0f) {
            builder.setExpressHeight(f2);
        }
        YdSDK.loadMixNative(context, builder.build(), new NativeLoadListener() { // from class: com.fl.saas.s2s.tobid.FLToBidNativeAdapter.1
            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                FLToBidNativeAdapter.this.callLoadFail(new WMAdapterError(ydError.getCode(), ydError.getMsg()));
            }

            @Override // com.fl.saas.api.mixNative.NativeLoadListener
            public void onNativeAdLoaded(NativeAd nativeAd) {
                FLToBidNativeAdapter.this.list = new ArrayList();
                FLToBidNativeAdapter.this.list.add(new FLToBidNativeAd(nativeAd, FLToBidNativeAdapter.this, context));
                LogcatUtil.d(FLToBidNativeAdapter.TAG, "onNativeAdLoaded");
                if (FLToBidNativeAdapter.this.getBiddingType() == 1 && nativeAd != null) {
                    FLToBidNativeAdapter.this.callLoadBiddingSuccess(new BidPrice(String.valueOf(nativeAd.getECPM())));
                }
                FLToBidNativeAdapter fLToBidNativeAdapter = FLToBidNativeAdapter.this;
                fLToBidNativeAdapter.callLoadSuccess(fLToBidNativeAdapter.list);
            }
        });
    }

    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        super/*com.windmill.sdk.custom.WMAdBaseAdapter*/.notifyBiddingResult(z, str, map);
        try {
            List<WMNativeAdData> list = this.list;
            if (list == null || list.isEmpty()) {
                return;
            }
            ((FLToBidNativeAd) this.list.get(0)).getNativeAd().biddingResultUpload(z, (int) Float.parseFloat(str), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
