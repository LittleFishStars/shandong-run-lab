package com.bwt.top.ad.bean;

import androidx.annotation.DrawableRes;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface AdInfo {
    String getPlatform();

    @DrawableRes
    int getPlatformIcon();

    String getPlatformPosId();

    boolean isReleased();

    void release();
}
