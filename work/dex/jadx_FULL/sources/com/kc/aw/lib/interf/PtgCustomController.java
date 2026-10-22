package com.kc.aw.lib.interf;

import com.kc.aw.lib.model.AdLocation;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class PtgCustomController {
    public String getAliBoot() {
        return "";
    }

    public String getAliUpdate() {
        return "";
    }

    public String getMediaAndroidId() {
        return "";
    }

    public String getMediaDeviceImei() {
        return "";
    }

    public String getMediaDeviceOaId() {
        return "";
    }

    public List<String> getMediaInstalledPackages() {
        return null;
    }

    @Deprecated
    public String getMediaIp() {
        return null;
    }

    public AdLocation getMediaLocation() {
        return null;
    }

    public String getMediaMacAddress() {
        return "";
    }

    public int getPersonalizedState() {
        return 0;
    }

    public boolean getProgrammaticRecommendState() {
        return false;
    }

    public boolean isAllowSDKInstallList() {
        return true;
    }

    public boolean isAllowSDKObtainAndroidId() {
        return true;
    }

    public boolean isAllowSDKObtainIp() {
        return true;
    }

    public boolean isAllowSDKObtainLocation() {
        return false;
    }

    public boolean isAllowSDKObtainMacAddress() {
        return true;
    }

    @Deprecated
    public boolean isAllowSDKObtainNetworkState() {
        return true;
    }

    public boolean isAllowSDKObtainOaId() {
        return true;
    }

    public boolean isAllowSDKObtainPhoneInfo() {
        return true;
    }

    @Deprecated
    public boolean isAllowSDKObtainStoragePermission() {
        return true;
    }

    public boolean isAllowSDKObtainWifiState() {
        return true;
    }

    public boolean isAllowSDKObtainWriteExternal() {
        return true;
    }
}
