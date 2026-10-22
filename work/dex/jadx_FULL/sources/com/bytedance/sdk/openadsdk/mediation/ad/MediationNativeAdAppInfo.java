package com.bytedance.sdk.openadsdk.mediation.ad;

import com.byazt.zqa.c;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@c(c = {0, 80, 81, 82, 83, 686, 1991})
public class MediationNativeAdAppInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29306a;
    private String c;
    private String da;
    private Map<String, Object> i;
    private Map<String, String> n;
    private String sp;
    private String tt;
    private String uj;
    private long ve;
    private String x;

    public Map<String, Object> getAppInfoExtra() {
        return this.i;
    }

    public String getAppName() {
        return this.c;
    }

    public String getAuthorName() {
        return this.tt;
    }

    public String getFunctionDescUrl() {
        return this.x;
    }

    public long getPackageSizeBytes() {
        return this.ve;
    }

    public Map<String, String> getPermissionsMap() {
        return this.n;
    }

    public String getPermissionsUrl() {
        return this.uj;
    }

    public String getPrivacyAgreement() {
        return this.f29306a;
    }

    public String getRegUrl() {
        return this.da;
    }

    public String getVersionName() {
        return this.sp;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.i = map;
    }

    public void setAppName(String str) {
        this.c = str;
    }

    public void setAuthorName(String str) {
        this.tt = str;
    }

    public void setFunctionDescUrl(String str) {
        this.x = str;
    }

    public void setPackageSizeBytes(long j) {
        this.ve = j;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.n = map;
    }

    public void setPermissionsUrl(String str) {
        this.uj = str;
    }

    public void setPrivacyAgreement(String str) {
        this.f29306a = str;
    }

    public void setRegUrl(String str) {
        this.da = str;
    }

    public void setVersionName(String str) {
        this.sp = str;
    }
}
