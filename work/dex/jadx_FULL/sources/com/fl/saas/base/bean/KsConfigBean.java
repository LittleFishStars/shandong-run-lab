package com.fl.saas.base.bean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class KsConfigBean {
    private int acceleration;
    private String packageName;
    private int rotateDegree;
    private String sha1;
    private String version;

    public KsConfigBean(int i, int i2) {
        this.acceleration = i;
        this.rotateDegree = i2;
    }

    public KsConfigBean(String str, String str2, String str3) {
        this.packageName = str;
        this.version = str2;
        this.sha1 = str3;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getRotateDegree() {
        return this.rotateDegree;
    }

    public String getSha1() {
        return this.sha1;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAcceleration(int i) {
        this.acceleration = i;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setRotateDegree(int i) {
        this.rotateDegree = i;
    }

    public void setSha1(String str) {
        this.sha1 = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
