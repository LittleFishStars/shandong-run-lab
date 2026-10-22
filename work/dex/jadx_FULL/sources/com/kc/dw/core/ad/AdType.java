package com.kc.dw.core.ad;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public enum AdType {
    FEED(1),
    FEED_PRE_RENDER(2),
    FEED_MIX(10),
    BANNER(3),
    SPLASH(4),
    INTERSTITIAL(5),
    PASTER(6),
    REWARD(7),
    DRAW(8),
    FULL_SCREEN_VIDEO(9);

    private int value;

    AdType(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }
}
