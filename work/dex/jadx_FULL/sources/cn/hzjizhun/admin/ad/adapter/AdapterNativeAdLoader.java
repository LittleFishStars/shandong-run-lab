package cn.hzjizhun.admin.ad.adapter;

import cn.hzjizhun.admin.ad.bean.JZNativeAdInfo;
import cn.hzjizhun.admin.ad.impl.JZNativeAd;
import cn.hzjizhun.admin.ad.listener.JZNativeAdListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AdapterNativeAdLoader extends AdapterAdLoaderImp<JZNativeAdInfo, JZNativeAdListener, JZNativeAd> {
    protected String TAG = getClass().getSimpleName();
    protected JZNativeAd mJZNativeAd;

    public JZNativeAd getNativeAd() {
        return this.mJZNativeAd;
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp, cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        this.mJZNativeAd = null;
        this.mPosInfo = null;
        this.mAdLoaderCallback = null;
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp, cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void setAd(JZNativeAd jZNativeAd) {
        super.setAd(jZNativeAd);
        this.mJZNativeAd = jZNativeAd;
    }
}
