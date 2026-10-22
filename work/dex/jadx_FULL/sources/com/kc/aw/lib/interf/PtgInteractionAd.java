package com.kc.aw.lib.interf;

import android.app.Activity;
import com.kc.aw.lib.model.AdError;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface PtgInteractionAd extends PtgAd {

    @Keep
    public interface AdInteractionListener {
        void onAdClicked();

        void onAdDismiss();

        void onAdShow();

        void onRenderError(AdError adError);
    }

    void closureInterstitialAd();

    NativeAdvertData getAdvertData();

    Map<String, Object> getMediaExtraInfo();

    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener);

    void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener);

    void showInteractionAd(Activity activity);
}
