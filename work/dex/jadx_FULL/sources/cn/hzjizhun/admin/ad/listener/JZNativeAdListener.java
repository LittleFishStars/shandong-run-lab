package cn.hzjizhun.admin.ad.listener;

import cn.hzjizhun.admin.ad.AdListener;
import cn.hzjizhun.admin.ad.bean.JZNativeAdInfo;
import cn.hzjizhun.admin.exception.JZAdError;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class JZNativeAdListener implements AdListener<JZNativeAdInfo> {
    public abstract void onAdClick(JZNativeAdInfo jZNativeAdInfo, String str);

    @Override // cn.hzjizhun.admin.ad.AdListener
    public void onAdReady(JZNativeAdInfo jZNativeAdInfo) {
    }

    @Override // cn.hzjizhun.admin.ad.AdListener
    public void onAdReceive(JZNativeAdInfo jZNativeAdInfo) {
    }

    public abstract void onAdReceive(List<JZNativeAdInfo> list);

    public abstract void onRenderFailed(JZNativeAdInfo jZNativeAdInfo, JZAdError jZAdError);
}
