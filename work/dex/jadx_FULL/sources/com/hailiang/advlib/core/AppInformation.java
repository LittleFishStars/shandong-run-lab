package com.hailiang.advlib.core;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class AppInformation {
    public String appVersion;
    public String developers;
    public String functionDescUrl;
    public String permissionProtocolUrl;
    public String privacyProtocolUrl;

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getDevelopers() {
        return this.developers;
    }

    public String getFunctionDescUrl() {
        return this.functionDescUrl;
    }

    public String getPermissionProtocolUrl() {
        return this.permissionProtocolUrl;
    }

    public String getPrivacyProtocolUrl() {
        return this.privacyProtocolUrl;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setDevelopers(String str) {
        this.developers = str;
    }

    public void setFunctionDescUrl(String str) {
        this.functionDescUrl = str;
    }

    public void setPermissionProtocolUrl(String str) {
        this.permissionProtocolUrl = str;
    }

    public void setPrivacyProtocolUrl(String str) {
        this.privacyProtocolUrl = str;
    }
}
