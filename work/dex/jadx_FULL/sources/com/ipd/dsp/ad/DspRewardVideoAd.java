package com.ipd.dsp.ad;

import android.content.Context;
import androidx.annotation.Keep;
import com.ipd.dsp.api.IBid;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface DspRewardVideoAd extends IBid {

    @Keep
    public interface InteractionListener {
        @Keep
        void onRewardVideoClick();

        @Keep
        void onRewardVideoClose();

        @Keep
        void onRewardVideoError(int i, String str);

        @Keep
        void onRewardVideoShow();

        @Keep
        void onRewardVideoVerify();
    }

    @Keep
    String getRequestId();

    @Keep
    boolean isValid();

    @Keep
    void setInteractionListener(InteractionListener interactionListener);

    @Keep
    void setVolumeOn(boolean z);

    @Keep
    void showRewardVideo(Context context);
}
