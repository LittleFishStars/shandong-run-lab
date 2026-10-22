package com.bwt.top;

import com.bwt.top.ad.AdListener;
import com.bwt.top.ad.bean.AdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class SplashAdListener implements AdListener<AdInfo> {
    @Override // com.bwt.top.ad.AdListener
    public void onAdReady(AdInfo adInfo) {
    }

    public abstract void onAdSkip(AdInfo adInfo);

    public abstract void onAdTick(long j);
}
