package com.kc.cw.ad;

import android.app.Activity;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IRewardVideoAd {
    void destroy();

    int getPrice();

    String getTagId();

    boolean isLoaded();

    void loadAd();

    void pause();

    void resume();

    void setAdSlotId(String str);

    void show(Activity activity);
}
