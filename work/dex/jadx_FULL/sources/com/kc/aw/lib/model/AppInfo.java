package com.kc.aw.lib.model;

import com.kc.aw._jf;
import com.kc.aw._mm;
import com.kc.aw._od;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AppInfo implements Serializable {
    public String appVersion;
    public String developers;
    public String functionDescUrl;
    private String icon_url;
    private String name;
    private String package_name;
    public String permissionProtocolUrl;
    public String privacyProtocolUrl;
    private _od wechatExt;

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getDevelopers() {
        return this.developers;
    }

    public String getFunctionDescUrl() {
        return this.functionDescUrl;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public String getName() {
        return this.name;
    }

    public String getPackage_name() {
        return this.package_name;
    }

    public String getPermissionProtocolUrl() {
        return this.permissionProtocolUrl;
    }

    public String getPrivacyProtocolUrl() {
        return this.privacyProtocolUrl;
    }

    public _od getWechatExt() {
        return this.wechatExt;
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

    public void setIcon_url(String str) {
        this.icon_url = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPackage_name(String str) {
        this.package_name = str;
    }

    public void setPermissionProtocolUrl(String str) {
        this.permissionProtocolUrl = str;
    }

    public void setPrivacyProtocolUrl(String str) {
        this.privacyProtocolUrl = str;
    }

    public void setWechatExt(_od _odVar) {
        this.wechatExt = _odVar;
    }

    public String toString() {
        StringBuilder sb_a = _mm._a(_mm._a(_mm._a(_mm._a(_mm._a(_mm._a(_mm._a(_jf._a("AppInfo{icon_url='"), this.icon_url, '\'', ", name='"), this.name, '\'', ", package_name='"), this.package_name, '\'', ", appVersion='"), this.appVersion, '\'', ", developers='"), this.developers, '\'', ", privacyProtocolUrl='"), this.privacyProtocolUrl, '\'', ", permissionProtocolUrl='"), this.permissionProtocolUrl, '\'', ", functionDescUrl='");
        sb_a.append(this.functionDescUrl);
        sb_a.append('\'');
        sb_a.append('}');
        return sb_a.toString();
    }
}
