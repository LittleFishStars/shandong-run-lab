package com.ipd.dsp.ad;

import android.app.Activity;
import androidx.annotation.Keep;
import com.ipd.dsp.api.IBid;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface DspInterstitialAd extends IBid {

    @Keep
    public interface InteractionListener {
        @Keep
        void onInterstitialAdClick();

        @Keep
        void onInterstitialAdClose();

        @Keep
        void onInterstitialAdError(int i, String str);

        @Keep
        void onInterstitialAdShow();
    }

    @Keep
    public interface RewardListener {
        void onReward();
    }

    @Keep
    String getRequestId();

    @Keep
    void setInteractionListener(InteractionListener interactionListener);

    @Keep
    void setRewardListener(RewardListener rewardListener);

    @Keep
    void setVolumeOn(boolean z);

    @Keep
    void showInterstitialAd(Activity activity);
}
