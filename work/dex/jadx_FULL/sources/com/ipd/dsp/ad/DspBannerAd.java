package com.ipd.dsp.ad;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.ipd.dsp.api.IBid;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface DspBannerAd extends IBid {

    @Keep
    public interface InteractionListener {
        @Keep
        void onBannerAdClick();

        @Keep
        void onBannerAdClose();

        @Keep
        void onBannerAdShow();

        @Keep
        void onBannerAdShowError(int i, String str);
    }

    @Nullable
    @Keep
    View getBannerView(Context context);

    @Keep
    String getRequestId();

    @Keep
    void setInteractionListener(InteractionListener interactionListener);
}
