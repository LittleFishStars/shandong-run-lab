package cn.hzjizhun.admin.ad.listener;

import cn.hzjizhun.admin.ad.AdListener;
import cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo;
import cn.hzjizhun.admin.exception.JZAdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class JZUnifiedADListener implements AdListener<JZUnifiedAdInfo> {
    public abstract void onADLoaded(JZUnifiedAdInfo jZUnifiedAdInfo);

    @Override // cn.hzjizhun.admin.ad.AdListener
    public void onAdClick(JZUnifiedAdInfo jZUnifiedAdInfo) {
    }

    public abstract void onAdClick(JZUnifiedAdInfo jZUnifiedAdInfo, String str);

    @Override // cn.hzjizhun.admin.ad.AdListener
    public void onAdFailed(JZAdError jZAdError) {
    }

    @Override // cn.hzjizhun.admin.ad.AdListener
    public void onAdReady(JZUnifiedAdInfo jZUnifiedAdInfo) {
    }

    @Override // cn.hzjizhun.admin.ad.AdListener
    public void onAdReceive(JZUnifiedAdInfo jZUnifiedAdInfo) {
    }
}
