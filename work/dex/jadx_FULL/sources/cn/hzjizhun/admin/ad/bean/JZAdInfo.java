package cn.hzjizhun.admin.ad.bean;

import androidx.annotation.DrawableRes;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface JZAdInfo {
    String getPlatform();

    @DrawableRes
    int getPlatformIcon();

    String getPlatformPosId();

    boolean isReleased();

    void release();
}
