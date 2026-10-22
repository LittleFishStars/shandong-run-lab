package com.bytedance.sdk.openadsdk;

import androidx.annotation.Nullable;
import com.byazt.zqa.c;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@c(c = {0, 80, 81, 82, SecExceptionCode.SEC_ERROR_AVMP_SAFETOKEN_INVALID_PARAM})
public abstract class TTCustomController {
    public boolean alist() {
        return true;
    }

    @Nullable
    public String getAndroidId() {
        return null;
    }

    @Nullable
    public String getDevImei() {
        return null;
    }

    @Nullable
    public String getDevOaid() {
        return null;
    }

    @Nullable
    public String getMacAddress() {
        return null;
    }

    @Nullable
    public IMediationPrivacyConfig getMediationPrivacyConfig() {
        return null;
    }

    @Nullable
    public LocationProvider getTTLocation() {
        return null;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUseMessage() {
        return true;
    }

    public boolean isCanUsePermissionRecordAudio() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isCanUseWifiState() {
        return true;
    }

    public boolean isCanUseWriteExternal() {
        return true;
    }

    public Map<String, Object> userPrivacyConfig() {
        return null;
    }
}
