package com.kc.dw.core.ad.splash;

import android.view.ViewGroup;
import com.kc.dw.core.ad.IAd;
import com.kc.dw.core.loader.InteractionListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface ISplashAd<T extends InteractionListener> extends IAd<T> {
    void render();

    void setDownloadDialogListener(ISplashDownloadDialogListener iSplashDownloadDialogListener);

    void setSplashFinishingTouchListener(ISplashFinishingTouchListener iSplashFinishingTouchListener);

    void showAd(ViewGroup viewGroup);

    void splashAnimationFinish();
}
