package com.kc.aw.lib.interf;

import android.app.Activity;
import android.os.Bundle;
import com.kc.aw.lib.model.AdError;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface PtgRewardVideoAd extends PtgAd {

    @Keep
    public interface RewardAdInteractionListener {
        void onAdClose();

        void onAdShow();

        void onAdVideoBarClick();

        void onRenderError(AdError adError);

        void onRewardVerify(boolean z, Bundle bundle);

        void onSkippedVideo();

        void onVideoComplete();

        void onVideoError(int i, String str);

        void onVideoPause();

        void onVideoProgressUpdate(long j, long j2);

        void onVideoResume();

        void onVideoStart();
    }

    NativeAdvertData getAdvertData();

    Map<String, Object> getMediaExtraInfo();

    void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener);

    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    void showRewardVideoAd(Activity activity);
}
