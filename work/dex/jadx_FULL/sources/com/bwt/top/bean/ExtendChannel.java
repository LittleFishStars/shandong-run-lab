package com.bwt.top.bean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ExtendChannel {
    private String baseUrl;
    private String key;
    private String type;
    private String userid;

    private ExtendChannel() {
    }

    public ExtendChannel(String str, String str2) {
        this.type = str;
        this.userid = str2;
    }

    public ExtendChannel(String str, String str2, String str3, String str4) {
        this.type = str;
        this.baseUrl = str3;
        this.key = str4;
        this.userid = str2;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getKey() {
        return this.key;
    }

    public String getType() {
        return this.type;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUserid(String str) {
        this.userid = str;
    }

    public String toString() {
        return "ExtendChannel{type='" + this.type + "', baseUrl='" + this.baseUrl + "', key='" + this.key + "', userid='" + this.userid + "'}";
    }
}
