package com.fl.saas.base.bean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class PMControlBean {
    private boolean canGetAndroidId = true;
    private boolean canGetMac = true;
    private boolean canGetAppList = true;
    private boolean canGetIMEI = true;
    private boolean canGetOaid = true;
    private boolean canGetBootId = true;
    private boolean canGetSensor = true;

    public boolean isCanGetAndroidId() {
        return this.canGetAndroidId;
    }

    public boolean isCanGetAppList() {
        return this.canGetAppList;
    }

    public boolean isCanGetBootId() {
        return this.canGetBootId;
    }

    public boolean isCanGetIMEI() {
        return this.canGetIMEI;
    }

    public boolean isCanGetMac() {
        return this.canGetMac;
    }

    public boolean isCanGetOaid() {
        return this.canGetOaid;
    }

    public boolean isCanGetSensor() {
        return this.canGetSensor;
    }

    public void setCanGetAndroidId(boolean z) {
        this.canGetAndroidId = z;
    }

    public void setCanGetAppList(boolean z) {
        this.canGetAppList = z;
    }

    public void setCanGetBootId(boolean z) {
        this.canGetBootId = z;
    }

    public void setCanGetIMEI(boolean z) {
        this.canGetIMEI = z;
    }

    public void setCanGetMac(boolean z) {
        this.canGetMac = z;
    }

    public void setCanGetOaid(boolean z) {
        this.canGetOaid = z;
    }

    public void setCanGetSensor(boolean z) {
        this.canGetSensor = z;
    }
}
