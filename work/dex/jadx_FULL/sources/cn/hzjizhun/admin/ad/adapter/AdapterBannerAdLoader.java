package cn.hzjizhun.admin.ad.adapter;

import cn.hzjizhun.admin.ad.bean.JZAdInfo;
import cn.hzjizhun.admin.ad.impl.JZBannerAd;
import cn.hzjizhun.admin.ad.listener.JZBannerAdListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AdapterBannerAdLoader extends AdapterAdLoaderImp<JZAdInfo, JZBannerAdListener, JZBannerAd> {
    protected String TAG = getClass().getSimpleName();
    protected JZBannerAd mJZBannerAd;

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public JZAdInfo createAdInfo() {
        return null;
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp, cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        this.mJZBannerAd = null;
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp, cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void setAd(JZBannerAd jZBannerAd) {
        super.setAd(jZBannerAd);
        this.mJZBannerAd = jZBannerAd;
    }
}
