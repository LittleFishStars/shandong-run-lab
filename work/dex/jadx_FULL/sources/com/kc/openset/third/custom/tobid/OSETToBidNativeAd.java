package com.kc.openset.third.custom.tobid;

import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.natives.WMNativeAdData;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class OSETToBidNativeAd {

    public interface AdListener {
        void onNativeAdFailToLoad(WMAdapterError wMAdapterError);

        void onNativeAdLoadSuccess(List<WMNativeAdData> list, int i);
    }

    public abstract void destroy();

    public abstract List<WMNativeAdData> getNativeAdDataList();

    public abstract boolean isReady();

    public abstract void loadAd(String str, Map<String, Object> map, Map<String, Object> map2);

    public abstract void notifyBiddingResult(boolean z, String str, Map<String, Object> map);
}
