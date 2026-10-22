package cj.mobile.jt.core;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class JuTuiPrivacyController {
    public String getAndroidId() {
        return null;
    }

    public List<String> getAppList() {
        return null;
    }

    public String getDevImei() {
        return null;
    }

    public String getDevImsi() {
        return null;
    }

    public JuTuiLocation getLocation() {
        return null;
    }

    public String getMacAddress() {
        return null;
    }

    public String getOaid() {
        return null;
    }

    public boolean isCanGetAppList() {
        return true;
    }

    public boolean isCanGetMacAddress() {
        return true;
    }

    public boolean isCanGetOaid() {
        return true;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseLocation() {
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
}
