package com.kc.cw.ad;

import com.kc.cw.ad.model.ShakeValue;
import com.kc.cw.ad.model.SsLocation;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class SSAdSdkController {
    public String getAuthorities() {
        return "";
    }

    public String getImei() {
        return "";
    }

    public SsLocation getLocation() {
        return null;
    }

    public String getOaid() {
        return "";
    }

    public ShakeValue getShakeValue() {
        return null;
    }

    public boolean isCanShake() {
        return true;
    }

    public boolean isCanUseAppList() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUseOaid() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isUseHttps() {
        return false;
    }
}
