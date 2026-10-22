package com.beizi.ad.lance;

import com.beizi.fusion.x1;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ApkBean implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26877a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private boolean o;
    private String p;
    private x1.b.C0333b q;

    public ApkBean() {
        this.f26877a = "";
        this.b = "";
        this.c = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.p = "";
    }

    public String getApkDesc() {
        return this.f;
    }

    public String getApkName() {
        return this.b;
    }

    public String getApkTittleName() {
        return this.e;
    }

    public String getApkUrl() {
        return this.f26877a;
    }

    public String getAppDeveloper() {
        return this.h;
    }

    public String getAppIconURL() {
        return this.l;
    }

    public String getAppPermissionsDesc() {
        return this.i;
    }

    public String getAppPermissionsUrl() {
        return this.j;
    }

    public String getAppPrivacyUrl() {
        return this.k;
    }

    public String getAppVersion() {
        return this.g;
    }

    public String getAppintro() {
        return this.m;
    }

    public String getAuthorities() {
        return this.p;
    }

    public String getDownloadPath() {
        return this.d;
    }

    public String getFileMD5() {
        return this.n;
    }

    public String getPkgName() {
        return this.c;
    }

    public x1.b.C0333b getmFollowTrackExt() {
        return this.q;
    }

    public boolean isSendLocalBroadcast() {
        return this.o;
    }

    public void setApkDesc(String str) {
        this.f = str;
    }

    public void setApkName(String str) {
        this.b = str;
    }

    public void setApkTittleName(String str) {
        this.e = str;
    }

    public void setApkUrl(String str) {
        this.f26877a = str;
    }

    public void setAppDeveloper(String str) {
        this.h = str;
    }

    public void setAppIconURL(String str) {
        this.l = str;
    }

    public void setAppPermissionsDesc(String str) {
        this.i = str;
    }

    public void setAppPermissionsUrl(String str) {
        this.j = str;
    }

    public void setAppPrivacyUrl(String str) {
        this.k = str;
    }

    public void setAppVersion(String str) {
        this.g = str;
    }

    public void setAppintro(String str) {
        this.m = str;
    }

    public void setAuthorities(String str) {
        this.p = str;
    }

    public void setDownloadPath(String str) {
        this.d = str;
    }

    public void setFileMD5(String str) {
        this.n = str;
    }

    public void setPkgName(String str) {
        this.c = str;
    }

    public void setSendLocalBroadcast(boolean z) {
        this.o = z;
    }

    public void setmFollowTrackExt(x1.b.C0333b c0333b) {
        this.q = c0333b;
    }

    public ApkBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, x1.b.C0333b c0333b, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.f26877a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.p = str7;
        this.q = c0333b;
        this.g = str8;
        this.h = str9;
        this.i = str10;
        this.j = str11;
        this.k = str12;
        this.l = str13;
        this.m = str14;
    }
}
