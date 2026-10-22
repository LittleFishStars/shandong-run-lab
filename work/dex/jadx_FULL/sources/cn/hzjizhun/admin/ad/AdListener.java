package cn.hzjizhun.admin.ad;

import cn.hzjizhun.admin.ad.bean.JZAdInfo;
import cn.hzjizhun.admin.exception.JZAdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AdListener<T extends JZAdInfo> {
    void onAdClick(T t);

    void onAdClose(T t);

    void onAdExpose(T t);

    void onAdFailed(JZAdError jZAdError);

    void onAdReady(T t);

    void onAdReceive(T t);
}
