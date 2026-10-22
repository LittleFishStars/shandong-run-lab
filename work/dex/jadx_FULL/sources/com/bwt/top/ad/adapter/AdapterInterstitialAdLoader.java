package com.bwt.top.ad.adapter;

import com.bwt.top.InterstitialAd;
import com.bwt.top.InterstitialAdListener;
import com.bwt.top.ad.bean.InterstitialAdInfo;
import com.bwt.top.api.bean.PosInfoBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class AdapterInterstitialAdLoader extends AdapterAdLoaderImp<InterstitialAdInfo, InterstitialAdListener, InterstitialAd> {
    protected String TAG = AdapterInterstitialAdLoader.class.getSimpleName();
    protected InterstitialAd mInterstitialAd;
    protected PosInfoBean mPosInfo;

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public InterstitialAdInfo createAdInfo() {
        return null;
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp, com.bwt.top.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        this.mInterstitialAd = null;
        this.mPosInfo = null;
        this.mAdLoaderCallback = null;
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp, com.bwt.top.ad.adapter.AdapterAdLoader
    public void setAd(InterstitialAd interstitialAd) {
        super.setAd(interstitialAd);
        this.mInterstitialAd = interstitialAd;
    }
}
