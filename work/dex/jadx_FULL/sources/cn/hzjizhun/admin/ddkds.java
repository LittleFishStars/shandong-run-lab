package cn.hzjizhun.admin;

import cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp;
import cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo;
import cn.hzjizhun.admin.api.bean.PosInfoBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class ddkds implements JZUnifiedAdInfo {
    private AdapterAdLoaderImp mAdAdapter;
    private PosInfoBean mPosInfo;

    public ddkds(PosInfoBean posInfoBean, AdapterAdLoaderImp adapterAdLoaderImp) {
        this.mPosInfo = posInfoBean;
        this.mAdAdapter = adapterAdLoaderImp;
    }

    @Override // cn.hzjizhun.admin.ad.bean.JZAdInfo
    public String getPlatform() {
        PosInfoBean posInfoBean = this.mPosInfo;
        if (posInfoBean != null) {
            return posInfoBean.getPosPlatform();
        }
        return null;
    }

    @Override // cn.hzjizhun.admin.ad.bean.JZAdInfo
    public int getPlatformIcon() {
        return 0;
    }

    @Override // cn.hzjizhun.admin.ad.bean.JZAdInfo
    public String getPlatformPosId() {
        PosInfoBean posInfoBean = this.mPosInfo;
        if (posInfoBean != null) {
            return posInfoBean.getThirdPosId();
        }
        return null;
    }

    @Override // cn.hzjizhun.admin.ad.bean.JZAdInfo
    public boolean isReleased() {
        AdapterAdLoaderImp adapterAdLoaderImp = this.mAdAdapter;
        if (adapterAdLoaderImp != null) {
            return adapterAdLoaderImp.isReleased();
        }
        return false;
    }

    @Override // cn.hzjizhun.admin.ad.bean.JZAdInfo
    public void release() {
        AdapterAdLoaderImp adapterAdLoaderImp = this.mAdAdapter;
        if (adapterAdLoaderImp != null) {
            adapterAdLoaderImp.release();
        }
    }
}
