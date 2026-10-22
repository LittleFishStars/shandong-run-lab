package com.kc.aw.lib.interf;

import android.app.Activity;
import android.view.ViewGroup;
import com.kc.aw.lib.model.AdError;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface PtgSplashAd extends PtgAd {

    @Keep
    public interface AdInteractionListener {
        void onAdClicked();

        void onAdShow();

        void onAdSkip();

        void onAdTimeOver();

        default void onDismiss(int i) {
        }

        void onRenderError(AdError adError);

        void onRenderSuccess();
    }

    NativeAdvertData getAdvertData();

    void load();

    void preload();

    void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener);

    void setSplashInteractionListener(AdInteractionListener adInteractionListener);

    void showAd(ViewGroup viewGroup);

    void showAd(ViewGroup viewGroup, Activity activity);
}
