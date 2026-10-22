package com.bwt.top.ad.adapter;

import com.bwt.top.SplashAd;
import com.bwt.top.SplashAdListener;
import com.bwt.top.ad.bean.AdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class AdapterSplashAdLoader extends AdapterAdLoaderImp<AdInfo, SplashAdListener, SplashAd> {
    protected String TAG = AdapterSplashAdLoader.class.getSimpleName();
    protected SplashAd mSplashAd;

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp, com.bwt.top.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        this.mSplashAd = null;
        this.mPosInfo = null;
        this.mAdLoaderCallback = null;
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp, com.bwt.top.ad.adapter.AdapterAdLoader
    public void setAd(SplashAd splashAd) {
        super.setAd(splashAd);
        this.mSplashAd = splashAd;
    }
}
