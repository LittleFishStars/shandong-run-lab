package cn.hzjizhun.admin.ad.listener;

import cn.hzjizhun.admin.ad.AdListener;
import cn.hzjizhun.admin.ad.bean.JZInterstitialAdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface JZInterstitialAdListener extends AdListener<JZInterstitialAdInfo> {
    void onAdClick(JZInterstitialAdInfo jZInterstitialAdInfo, String str);

    @Override // cn.hzjizhun.admin.ad.AdListener
    void onAdReady(JZInterstitialAdInfo jZInterstitialAdInfo);
}
