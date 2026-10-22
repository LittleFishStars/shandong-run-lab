package com.kc.aw.lib.interf;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.kc.aw.lib.model.AdError;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface PtgNativeExpressAd extends PtgAd {

    @Keep
    public interface AdInteractionListener extends ExpressAdInteractionListener {
    }

    @Keep
    public interface CustomizeVideo {
        String getCoverUrl();

        String getVideoUrl();

        void reportVideoComplete();

        void reportVideoError();

        void reportVideoPause();

        void reportVideoProgress(long j, long j2);

        void reportVideoResume();

        void reportVideoStart();
    }

    @Keep
    public interface ExpressAdInteractionListener {
        void onAdClicked();

        void onAdDismiss();

        void onAdShow();

        void onRenderFail(AdError adError);

        void onRenderSuccess(View view);
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    void destroy();

    NativeAdvertData getAdvertData();

    CustomizeVideo getCustomizeVideo();

    View getExpressAdView();

    List<Object> getFilterWords();

    int getImageMode();

    Map<String, Object> getMediaExtraInfo();

    View getMediaView();

    boolean isSelfRender();

    boolean isVideo();

    void pauseVideo();

    void registerAdvertViews(ViewGroup viewGroup, List<View> list, List<View> list2, View view);

    void render();

    void setCanInterruptVideoPlay(boolean z);

    void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener);

    void setExpressInteractionListener(AdInteractionListener adInteractionListener);

    void setExpressViewColor(String str);

    void setSlideIntervalTime(int i);

    void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener);

    void showInteractionExpressAd(Activity activity);

    void startVideo();
}
