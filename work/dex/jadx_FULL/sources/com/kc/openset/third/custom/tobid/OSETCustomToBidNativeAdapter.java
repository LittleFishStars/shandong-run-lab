package com.kc.openset.third.custom.tobid;

import android.app.Activity;
import android.content.Context;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.models.BidPrice;
import com.windmill.sdk.natives.WMNativeAdData;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class OSETCustomToBidNativeAdapter extends WMCustomNativeAdapter implements OSETToBidNativeAd.AdListener {
    private OSETToBidNativeAd mOsetNativeAd;

    public void destroyAd() {
        OSETToBidNativeAd oSETToBidNativeAd = this.mOsetNativeAd;
        if (oSETToBidNativeAd != null) {
            oSETToBidNativeAd.destroy();
            this.mOsetNativeAd = null;
        }
    }

    public List<WMNativeAdData> getNativeAdDataList() {
        OSETToBidNativeAd oSETToBidNativeAd = this.mOsetNativeAd;
        if (oSETToBidNativeAd != null) {
            return oSETToBidNativeAd.getNativeAdDataList();
        }
        return null;
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    public boolean isReady() {
        OSETToBidNativeAd oSETToBidNativeAd = this.mOsetNativeAd;
        if (oSETToBidNativeAd != null) {
            return oSETToBidNativeAd.isReady();
        }
        return false;
    }

    public void loadAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (!(context instanceof Activity)) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "context is not Activity or is nul"));
            return;
        }
        try {
            String str = (String) map2.get(TradPlusInitManager.PLACEMENTID);
            String str2 = (String) map2.get("custom_info");
            this.mOsetNativeAd = str2 != null ? new JSONObject(str2).optBoolean("isExpressAd") : false ? new OSETToBidNativeExpressAd((Activity) context, this, this) : new OSETToBidNativeUnifiedAd((Activity) context, this, this);
            this.mOsetNativeAd.loadAd(str, map, map2);
        } catch (Exception e) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e.getMessage()));
        }
    }

    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        OSETToBidNativeAd oSETToBidNativeAd = this.mOsetNativeAd;
        if (oSETToBidNativeAd != null) {
            oSETToBidNativeAd.notifyBiddingResult(z, str, map);
        }
    }

    @Override // com.kc.openset.third.custom.tobid.OSETToBidNativeAd.AdListener
    public void onNativeAdFailToLoad(WMAdapterError wMAdapterError) {
        callLoadFail(wMAdapterError);
    }

    @Override // com.kc.openset.third.custom.tobid.OSETToBidNativeAd.AdListener
    public void onNativeAdLoadSuccess(List<WMNativeAdData> list, int i) {
        if (isClientBidding()) {
            callLoadBiddingSuccess(new BidPrice(String.valueOf(i)));
        }
        callLoadSuccess(list);
    }
}
