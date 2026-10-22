package com.bwt.top.ad.bean;

import com.bwt.top.ad.adapter.AdapterAdLoaderImp;
import com.bwt.top.api.bean.PosInfoBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BasicAdInfoIpl implements AdInfo {
    private AdapterAdLoaderImp mAdAdapter;
    private PosInfoBean mPosInfo;

    public BasicAdInfoIpl(PosInfoBean posInfoBean, AdapterAdLoaderImp adapterAdLoaderImp) {
        this.mPosInfo = posInfoBean;
        this.mAdAdapter = adapterAdLoaderImp;
    }

    @Override // com.bwt.top.ad.bean.AdInfo
    public String getPlatform() {
        PosInfoBean posInfoBean = this.mPosInfo;
        if (posInfoBean != null) {
            return posInfoBean.getPosPlatform();
        }
        return null;
    }

    @Override // com.bwt.top.ad.bean.AdInfo
    public int getPlatformIcon() {
        return 0;
    }

    @Override // com.bwt.top.ad.bean.AdInfo
    public String getPlatformPosId() {
        PosInfoBean posInfoBean = this.mPosInfo;
        if (posInfoBean != null) {
            return posInfoBean.getThirdPosId();
        }
        return null;
    }

    @Override // com.bwt.top.ad.bean.AdInfo
    public boolean isReleased() {
        AdapterAdLoaderImp adapterAdLoaderImp = this.mAdAdapter;
        if (adapterAdLoaderImp != null) {
            return adapterAdLoaderImp.isReleased();
        }
        return false;
    }

    @Override // com.bwt.top.ad.bean.AdInfo
    public void release() {
        AdapterAdLoaderImp adapterAdLoaderImp = this.mAdAdapter;
        if (adapterAdLoaderImp != null) {
            adapterAdLoaderImp.release();
        }
    }
}
