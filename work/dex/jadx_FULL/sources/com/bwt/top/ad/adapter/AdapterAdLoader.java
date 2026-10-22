package com.bwt.top.ad.adapter;

import com.bwt.top.ad.kdsksdda;
import com.bwt.top.api.bean.PosInfoBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface AdapterAdLoader<T extends kdsksdda> {
    void loadAdObject(PosInfoBean posInfoBean, AdapterAdLoaderCallback adapterAdLoaderCallback);

    void onPaused();

    void onResumed();

    void release();

    void setAd(T t);

    void showAdObject();
}
