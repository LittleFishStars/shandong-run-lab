package com.kwad.sdk.api;

import android.app.Activity;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.api.model.KsExtraRewardType;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@KsAdSdkApi
@Keep
public interface KsRewardVideoAd extends BaseKSAd {

    @KsAdSdkApi
    @Keep
    public interface KSAdRewardRetryTaskListener {
        @KsAdSdkApi
        @Keep
        void onAdRewardRetryTaskNotify(KSAdInfoData kSAdInfoData);
    }

    @KsAdSdkApi
    @Keep
    public interface RewardAdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onExtraRewardVerify(@KsExtraRewardType int i);

        @KsAdSdkApi
        @Keep
        void onPageDismiss();

        @KsAdSdkApi
        @Keep
        void onRewardStepVerify(int i, int i2);

        @KsAdSdkApi
        @Keep
        void onRewardVerify();

        @KsAdSdkApi
        @Keep
        void onRewardVerify(Map<String, Object> map);

        @KsAdSdkApi
        @Keep
        void onVideoPlayEnd();

        @KsAdSdkApi
        @Keep
        void onVideoPlayError(int i, int i2);

        @KsAdSdkApi
        @Keep
        void onVideoPlayStart();

        @KsAdSdkApi
        @Keep
        void onVideoSkipToEnd(long j);
    }

    @KsAdSdkApi
    @Keep
    int getECPM();

    @KsAdSdkApi
    @Keep
    int getInteractionType();

    @KsAdSdkApi
    @Keep
    List<KSAdInfoData> getKSAdInfoDatas();

    @KsAdSdkApi
    @Keep
    int getMaterialType();

    @KsAdSdkApi
    @Keep
    boolean isAdEnable();

    @KsAdSdkApi
    @Keep
    void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    @Keep
    @Deprecated
    void setBidEcpm(int i);

    @KsAdSdkApi
    @Keep
    void setBidEcpm(long j, long j2);

    @KsAdSdkApi
    @Keep
    void setInnerAdInteractionListener(KsInnerAd.KsInnerAdInteractionListener ksInnerAdInteractionListener);

    @KsAdSdkApi
    @Keep
    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    @KsAdSdkApi
    @Keep
    void setRewardAdRetryTaskCallback(KSAdRewardRetryTaskListener kSAdRewardRetryTaskListener);

    @KsAdSdkApi
    @Keep
    void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig);
}
