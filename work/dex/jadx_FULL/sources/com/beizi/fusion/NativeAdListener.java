package com.beizi.fusion;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface NativeAdListener extends i3 {
    void onAdClick();

    void onAdClosed();

    void onAdClosed(View view);

    void onAdFailed(int i);

    void onAdLoaded(View view);

    void onAdShown();
}
