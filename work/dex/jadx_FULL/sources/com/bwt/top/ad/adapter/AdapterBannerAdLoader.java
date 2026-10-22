package com.bwt.top.ad.adapter;

import com.bwt.top.BannerAd;
import com.bwt.top.BannerAdListener;
import com.bwt.top.ad.bean.AdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class AdapterBannerAdLoader extends AdapterAdLoaderImp<AdInfo, BannerAdListener, BannerAd> {
    protected String TAG = AdapterBannerAdLoader.class.getSimpleName();
    protected BannerAd mBannerAd;

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public AdInfo createAdInfo() {
        return null;
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp, com.bwt.top.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        this.mBannerAd = null;
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp, com.bwt.top.ad.adapter.AdapterAdLoader
    public void setAd(BannerAd bannerAd) {
        super.setAd(bannerAd);
        this.mBannerAd = bannerAd;
    }
}
