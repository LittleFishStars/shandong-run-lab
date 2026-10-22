package com.bwt.top.ad.loader;

import com.bwt.top.ad.kdsksdda;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface AdLoader<T extends kdsksdda> {
    T getAd();

    void loadAd(String str);

    void onPaused();

    void onResumed();

    void release();

    void showAd();
}
