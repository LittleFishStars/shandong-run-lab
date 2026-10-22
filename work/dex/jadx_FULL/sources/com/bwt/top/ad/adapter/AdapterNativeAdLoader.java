package com.bwt.top.ad.adapter;

import com.bwt.top.NativeAd;
import com.bwt.top.NativeAdListener;
import com.bwt.top.ad.bean.NativeAdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class AdapterNativeAdLoader extends AdapterAdLoaderImp<NativeAdInfo, NativeAdListener, NativeAd> {
    protected String TAG = AdapterNativeAdLoader.class.getSimpleName();
    protected NativeAd mNativeAd;

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp, com.bwt.top.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        this.mNativeAd = null;
        this.mPosInfo = null;
        this.mAdLoaderCallback = null;
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp, com.bwt.top.ad.adapter.AdapterAdLoader
    public void setAd(NativeAd nativeAd) {
        super.setAd(nativeAd);
        this.mNativeAd = nativeAd;
    }
}
