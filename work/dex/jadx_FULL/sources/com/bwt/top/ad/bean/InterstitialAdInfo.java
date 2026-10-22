package com.bwt.top.ad.bean;

import android.app.Activity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface InterstitialAdInfo extends AdInfo {
    boolean hasExpired();

    boolean hasShown();

    void showInterstitial(Activity activity);
}
