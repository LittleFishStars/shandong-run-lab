package com.kc.dw.platform.custom.ca.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface ISplashChangeAd<T> {
    void createSplashAd(Context context, T t);

    void render();

    void showAd(ViewGroup viewGroup);
}
