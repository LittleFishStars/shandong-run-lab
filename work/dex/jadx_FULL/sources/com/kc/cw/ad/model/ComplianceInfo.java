package com.kc.cw.ad.model;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ComplianceInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f39071a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public String getAppIconURL() {
        return this.g;
    }

    public String getAppName() {
        return this.f39071a;
    }

    public String getAppVersion() {
        return this.b;
    }

    public String getDeveloperName() {
        return this.c;
    }

    public String getFunctionDescUrl() {
        return this.f;
    }

    public String getPermissionsUrl() {
        return this.e;
    }

    public String getPrivacyUrl() {
        return this.d;
    }

    public void setAppIconURL(String str) {
        this.g = str;
    }

    public void setAppName(String str) {
        this.f39071a = str;
    }

    public void setAppVersion(String str) {
        this.b = str;
    }

    public void setDeveloperName(String str) {
        this.c = str;
    }

    public void setFunctionDescUrl(String str) {
        this.f = str;
    }

    public void setPermissionsUrl(String str) {
        this.e = str;
    }

    public void setPrivacyUrl(String str) {
        this.d = str;
    }
}
