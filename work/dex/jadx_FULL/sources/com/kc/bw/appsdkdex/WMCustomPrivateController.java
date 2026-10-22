package com.kc.bw.appsdkdex;

import com.kc.bw.common.bean.WMLocation;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class WMCustomPrivateController {
    public String getDevImei() {
        return null;
    }

    public String getDevMacAddress() {
        return null;
    }

    public String getDevOaid() {
        return null;
    }

    public WMLocation getLocation() {
        return null;
    }

    public boolean isCanUseAppList() {
        return true;
    }

    public boolean isCanUseBootId() {
        return true;
    }

    public boolean isCanUseInstallPackages() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUseNetworkState() {
        return true;
    }

    public boolean isCanUseOaid() {
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
}
