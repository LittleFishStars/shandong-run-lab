package com.kc.dw.core.ad.banner;

import android.app.Activity;
import android.view.ViewGroup;
import com.kc.dw.core.ad.IAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IBannerAd extends IAd {
    void render();

    void setCloseButtonVisible(boolean z);

    void setWidthAndHeight(int i, int i2);

    void showAd(Activity activity, ViewGroup viewGroup);

    void showAd(ViewGroup viewGroup);
}
