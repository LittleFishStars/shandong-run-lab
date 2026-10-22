package com.fl.saas.base.custom.spread;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface CustomSplashEventListener {
    void onDeeplinkCallback(boolean z);

    void onDownloadConfirm(Context context);

    void onSplashAdClicked();

    void onSplashAdDismiss();

    void onSplashAdShow();
}
