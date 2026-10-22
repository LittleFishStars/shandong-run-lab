package cn.hzjizhun.admin.ad.loader;

import cn.hzjizhun.admin.kdsksdda;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AdLoader<T extends kdsksdda> {
    T getAd();

    void loadAd(String str);

    void onPaused();

    void onResumed();

    void release();

    void shakeClick();

    void showAd();
}
