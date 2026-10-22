package com.bwt.top.ad;

import com.bwt.top.ad.bean.AdInfo;
import com.bwt.top.exception.AdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface AdListener<T extends AdInfo> {
    void onAdClick(T t);

    void onAdClose(T t);

    void onAdExpose(T t);

    void onAdFailed(AdError adError);

    void onAdReady(T t);

    void onAdReceive(T t);
}
