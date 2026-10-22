package com.fl.saas.common.pojo;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class YdDownloadAppInfo implements NativeADAppMiitInfo {
    private String appName;
    private long appSize;
    private String appVersion;
    private String developers;
    private String functionUrl;
    private String permissionProtocolUrl;
    private Map<String, String> permissionsMap;
    private String privacyProtocolUrl;

    @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
    public String getAppName() {
        return this.appName;
    }

    @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
    public String getAuthorName() {
        return this.developers;
    }

    @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
    public String getFunctionUrl() {
        return this.functionUrl;
    }

    @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
    public long getPackageSizeBytes() {
        return this.appSize;
    }

    @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
    public Map<String, String> getPermissionsMap() {
        return this.permissionsMap;
    }

    @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
    public String getPermissionsUrl() {
        return this.permissionProtocolUrl;
    }

    @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
    public String getPrivacyAgreement() {
        return this.privacyProtocolUrl;
    }

    @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
    public String getVersionName() {
        return this.appVersion;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppSize(long j) {
        this.appSize = j;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setDevelopers(String str) {
        this.developers = str;
    }

    public void setFunctionUrl(String str) {
        this.functionUrl = str;
    }

    public void setPermissionProtocolUrl(String str) {
        this.permissionProtocolUrl = str;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.permissionsMap = map;
    }

    public void setPrivacyProtocolUrl(String str) {
        this.privacyProtocolUrl = str;
    }
}
