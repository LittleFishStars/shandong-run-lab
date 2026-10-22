package com.bytedance.sdk.openadsdk.mediation.ad;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface IMediationAdSlot {
    @Nullable
    Map<String, Object> getExtraObject();

    @Nullable
    IMediationNativeToBannerListener getMediationNativeToBannerListener();

    @Nullable
    IMediationSplashRequestInfo getMediationSplashRequestInfo();

    int getRewardAmount();

    @Nullable
    String getRewardName();

    @Nullable
    String getScenarioId();

    float getShakeViewHeight();

    float getShakeViewWidth();

    float getVolume();

    @Nullable
    String getWxAppId();

    boolean isAllowShowCloseBtn();

    boolean isBidNotify();

    boolean isMuted();

    boolean isSplashPreLoad();

    boolean isSplashShakeButton();

    boolean isUseSurfaceView();
}
