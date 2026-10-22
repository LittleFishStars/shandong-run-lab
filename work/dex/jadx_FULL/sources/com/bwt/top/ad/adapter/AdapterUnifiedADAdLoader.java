package com.bwt.top.ad.adapter;

import com.bwt.top.UnifiedAD;
import com.bwt.top.UnifiedADListener;
import com.bwt.top.ad.bean.UnifiedAdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class AdapterUnifiedADAdLoader extends AdapterAdLoaderImp<UnifiedAdInfo, UnifiedADListener, UnifiedAD> {
    protected String TAG = AdapterUnifiedADAdLoader.class.getSimpleName();
    protected UnifiedAD mUnifiedAD;

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp, com.bwt.top.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        this.mUnifiedAD = null;
        this.mPosInfo = null;
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp, com.bwt.top.ad.adapter.AdapterAdLoader
    public void setAd(UnifiedAD unifiedAD) {
        super.setAd(unifiedAD);
        this.mUnifiedAD = unifiedAD;
    }
}
