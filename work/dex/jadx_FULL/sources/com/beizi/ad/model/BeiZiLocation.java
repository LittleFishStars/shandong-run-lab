package com.beizi.ad.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BeiZiLocation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26878a;
    private String b;
    private String c;
    private long d;

    public BeiZiLocation() {
    }

    public String getLatitude() {
        return this.b;
    }

    public String getLongitude() {
        return this.f26878a;
    }

    public long getTime() {
        return this.d;
    }

    public String getType() {
        return this.c;
    }

    public void setLatitude(String str) {
        this.b = str;
    }

    public void setLongitude(String str) {
        this.f26878a = str;
    }

    public void setTime(long j) {
        this.d = j;
    }

    public void setType(String str) {
        this.c = str;
    }

    public BeiZiLocation(String str, String str2, String str3, long j) {
        this.f26878a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
    }
}
