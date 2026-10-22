package cn.hzjizhun.admin.ad.listener;

import cn.hzjizhun.admin.ad.AdListener;
import cn.hzjizhun.admin.ad.bean.JZAdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class JZSplashAdListener implements AdListener<JZAdInfo> {
    @Override // cn.hzjizhun.admin.ad.AdListener
    public void onAdReady(JZAdInfo jZAdInfo) {
    }

    public abstract void onAdSkip(JZAdInfo jZAdInfo);

    public abstract void onAdTick(long j);
}
