package com.bwt.top;

import com.bwt.top.ad.AdListener;
import com.bwt.top.ad.bean.NativeAdInfo;
import com.bwt.top.exception.AdError;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class NativeAdListener implements AdListener<NativeAdInfo> {
    public abstract void onAdClick(NativeAdInfo nativeAdInfo, String str);

    @Override // com.bwt.top.ad.AdListener
    public void onAdReady(NativeAdInfo nativeAdInfo) {
    }

    @Override // com.bwt.top.ad.AdListener
    public void onAdReceive(NativeAdInfo nativeAdInfo) {
    }

    public abstract void onAdReceive(List<NativeAdInfo> list);

    public abstract void onRenderFailed(NativeAdInfo nativeAdInfo, AdError adError);
}
