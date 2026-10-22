package com.kc.dw.core.loader;

import com.google.gson.GsonBuilder;
import com.kc.dw.core.domain.SdkAdInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AdPlatformError {
    public SdkAdInfo adInfo;
    public Integer code;
    public String message;
    public String platform;

    public AdPlatformError() {
        this.code = -1;
    }

    public AdPlatformError(String str, Integer num) {
        this.message = str;
        this.code = num;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPlatform() {
        return this.platform;
    }

    public SdkAdInfo getSdkInfo() {
        return this.adInfo;
    }

    public void post(IAdLoadListener iAdLoadListener) {
        if (iAdLoadListener != null) {
            iAdLoadListener.onAdPlatformError(this);
            iAdLoadListener.onAdError();
        }
    }

    public String toString() {
        return new GsonBuilder().serializeNulls().create().toJson(this);
    }
}
