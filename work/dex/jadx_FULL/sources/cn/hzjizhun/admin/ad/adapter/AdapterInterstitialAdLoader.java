package cn.hzjizhun.admin.ad.adapter;

import cn.hzjizhun.admin.ad.bean.JZInterstitialAdInfo;
import cn.hzjizhun.admin.ad.impl.JZInterstitialAd;
import cn.hzjizhun.admin.ad.listener.JZInterstitialAdListener;
import cn.hzjizhun.admin.api.bean.PosInfoBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AdapterInterstitialAdLoader extends AdapterAdLoaderImp<JZInterstitialAdInfo, JZInterstitialAdListener, JZInterstitialAd> {
    protected String TAG = getClass().getSimpleName();
    protected JZInterstitialAd mJZInterstitialAd;
    protected PosInfoBean mPosInfo;

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public JZInterstitialAdInfo createAdInfo() {
        return null;
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp, cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        this.mJZInterstitialAd = null;
        this.mPosInfo = null;
        this.mAdLoaderCallback = null;
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp, cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void setAd(JZInterstitialAd jZInterstitialAd) {
        super.setAd(jZInterstitialAd);
        this.mJZInterstitialAd = jZInterstitialAd;
    }
}
