package com.kwad.sdk.api.model;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@KsAdSdkApi
@Keep
public class KSAdRewardRetryTaskResult {
    public int conversionStatus;
    public KSAdInfoData ksAdInfoData;

    public KSAdRewardRetryTaskResult(KSAdInfoData kSAdInfoData) {
        this.conversionStatus = 0;
        this.ksAdInfoData = kSAdInfoData;
    }

    public KSAdRewardRetryTaskResult(KSAdInfoData kSAdInfoData, int i) {
        this.ksAdInfoData = kSAdInfoData;
        this.conversionStatus = i;
    }
}
