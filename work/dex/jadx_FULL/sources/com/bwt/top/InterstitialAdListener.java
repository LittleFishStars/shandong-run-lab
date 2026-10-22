package com.bwt.top;

import com.bwt.top.ad.AdListener;
import com.bwt.top.ad.bean.InterstitialAdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface InterstitialAdListener extends AdListener<InterstitialAdInfo> {
    void onAdClick(InterstitialAdInfo interstitialAdInfo, String str);

    @Override // com.bwt.top.ad.AdListener
    void onAdReady(InterstitialAdInfo interstitialAdInfo);
}
