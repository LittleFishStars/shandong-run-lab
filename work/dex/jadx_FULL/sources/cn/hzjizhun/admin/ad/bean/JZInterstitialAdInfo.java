package cn.hzjizhun.admin.ad.bean;

import android.app.Activity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface JZInterstitialAdInfo extends JZAdInfo {
    boolean hasExpired();

    boolean hasShown();

    void showInterstitial(Activity activity);
}
