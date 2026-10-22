package com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model;

import androidx.annotation.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public interface PbKwaishopResourceLivePendantInfo {
    int getAction();

    String getAreaCode();

    String getCallbackApi();

    String getCallbackPath();

    String getEventData();

    String getPendantCode();

    long getPendantResourceId();

    long getRandomRangeMillis();

    Map<String, String> getThroughInfo();

    boolean isNeedBusinessHandle();

    boolean isNeedRandomCall();

    boolean isNeedServerProcess();

    boolean isNeedSignalFallback();
}
