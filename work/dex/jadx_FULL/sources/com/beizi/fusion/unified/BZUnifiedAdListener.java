package com.beizi.fusion.unified;

import com.beizi.fusion.i3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface BZUnifiedAdListener extends i3 {
    void onAdClick();

    void onAdFailed(int i);

    void onAdLoaded(BZUnifiedAdResponse bZUnifiedAdResponse);

    void onAdShown();
}
