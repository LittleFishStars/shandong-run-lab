package com.ipd.dsp.ad;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import com.ipd.dsp.api.IBid;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface DspSplashAd extends IBid {

    @Keep
    public interface InteractionListener {
        @Keep
        void onSplashAdClick();

        @Keep
        void onSplashAdDismiss();

        @Keep
        void onSplashAdShow();

        @Keep
        void onSplashAdShowError(int i, String str);

        @Keep
        void onSplashAdSkip();
    }

    @Keep
    String getRequestId();

    @Keep
    void setInteractionListener(InteractionListener interactionListener);

    @Keep
    void show(Context context, ViewGroup viewGroup);
}
