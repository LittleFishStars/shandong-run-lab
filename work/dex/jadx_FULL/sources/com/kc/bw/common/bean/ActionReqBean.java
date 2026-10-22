package com.kc.bw.common.bean;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ActionReqBean {
    public int android_scheme_id;
    public String app_version;
    public String brand;
    public boolean dp_success;
    public String imei;
    public String model;
    public String oaid;
    public String os_version;
    public String request_id;
    public int time_interval;

    public int getAndroid_scheme_id() {
        return this.android_scheme_id;
    }

    public String getApp_version() {
        return this.app_version;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getImei() {
        return this.imei;
    }

    public String getModel() {
        return this.model;
    }

    public String getOaid() {
        return this.oaid;
    }

    public String getOs_version() {
        return this.os_version;
    }

    public String getRequest_id() {
        return this.request_id;
    }

    public int getTime_interval() {
        return this.time_interval;
    }

    public boolean isDp_success() {
        return this.dp_success;
    }

    public void setAndroid_scheme_id(int i) {
        this.android_scheme_id = i;
    }

    public void setApp_version(String str) {
        this.app_version = str;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setDp_success(boolean z) {
        this.dp_success = z;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setOs_version(String str) {
        this.os_version = str;
    }

    public void setRequest_id(String str) {
        this.request_id = str;
    }

    public void setTime_interval(int i) {
        this.time_interval = i;
    }
}
