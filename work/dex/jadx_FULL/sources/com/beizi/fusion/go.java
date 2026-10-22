package com.beizi.fusion;

import com.beizi.ad.internal.splash.SplashUnifiedAdResponse;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface go {
    void a(SplashUnifiedAdResponse splashUnifiedAdResponse);

    void onAdClick();

    void onAdClosed();

    void onAdFailed(int i);

    void onAdShown();
}
