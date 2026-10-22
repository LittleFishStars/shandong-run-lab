package cn.hzjizhun.admin;

import cn.hzjizhun.admin.exception.JZAdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface sads {
    void onAdClick();

    void onAdClose();

    void onAdError(JZAdError jZAdError);

    void onAdExpose();

    void onAdReward();
}
