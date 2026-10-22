package com.fl.saas.adx.base.base.listener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface InnerVideoListener {
    void onAdClick(String str);

    void onAdClose();

    void onAdShow();

    void onSkipVideo();

    void onVideoCompleted();

    void onVideoPrepared();

    void onVideoReward(double d);
}
