package com.bwt.top;

import com.bwt.top.ad.AdListener;
import com.bwt.top.ad.bean.UnifiedAdInfo;
import com.bwt.top.exception.AdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class UnifiedADListener implements AdListener<UnifiedAdInfo> {
    public abstract void onADLoaded(UnifiedAdInfo unifiedAdInfo);

    @Override // com.bwt.top.ad.AdListener
    public void onAdClick(UnifiedAdInfo unifiedAdInfo) {
    }

    public abstract void onAdClick(UnifiedAdInfo unifiedAdInfo, String str);

    @Override // com.bwt.top.ad.AdListener
    public void onAdFailed(AdError adError) {
    }

    @Override // com.bwt.top.ad.AdListener
    public void onAdReady(UnifiedAdInfo unifiedAdInfo) {
    }

    @Override // com.bwt.top.ad.AdListener
    public void onAdReceive(UnifiedAdInfo unifiedAdInfo) {
    }
}
