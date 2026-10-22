package cn.hzjizhun.admin.ad.adapter;

import cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo;
import cn.hzjizhun.admin.ad.impl.JZUnifiedAD;
import cn.hzjizhun.admin.ad.listener.JZUnifiedADListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AdapterUnifiedADAdLoader extends AdapterAdLoaderImp<JZUnifiedAdInfo, JZUnifiedADListener, JZUnifiedAD> {
    protected String TAG = getClass().getSimpleName();
    protected JZUnifiedAD mJZUnifiedAD;

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp, cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        this.mJZUnifiedAD = null;
        this.mPosInfo = null;
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp, cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void setAd(JZUnifiedAD jZUnifiedAD) {
        super.setAd(jZUnifiedAD);
        this.mJZUnifiedAD = jZUnifiedAD;
    }
}
