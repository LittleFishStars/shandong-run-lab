package cn.hzjizhun.admin.ad.adapter;

import cn.hzjizhun.admin.ad.bean.JZAdInfo;
import cn.hzjizhun.admin.ad.impl.JZSplashAd;
import cn.hzjizhun.admin.ad.listener.JZSplashAdListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AdapterSplashAdLoader extends AdapterAdLoaderImp<JZAdInfo, JZSplashAdListener, JZSplashAd> {
    protected String TAG = getClass().getSimpleName();
    protected JZSplashAd mJZSplashAd;

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp, cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        this.mJZSplashAd = null;
        this.mPosInfo = null;
        this.mAdLoaderCallback = null;
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp, cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void setAd(JZSplashAd jZSplashAd) {
        super.setAd(jZSplashAd);
        this.mJZSplashAd = jZSplashAd;
    }
}
