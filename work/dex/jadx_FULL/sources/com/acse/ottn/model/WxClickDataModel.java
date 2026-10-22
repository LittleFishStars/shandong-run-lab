package com.acse.ottn.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WxClickDataModel {
    private String deeplink;
    private String link;
    private String request_service_state = "0";
    private long toast_ck;
    private long toast_ck_time;
    private long toast_show_time;
    private int toast_times;
    private String toast_type;

    public String getDeeplink() {
        return this.deeplink;
    }

    public String getLink() {
        return this.link;
    }

    public String getRequest_service_state() {
        return this.request_service_state;
    }

    public long getToast_ck() {
        return this.toast_ck;
    }

    public Long getToast_ck_time() {
        return Long.valueOf(this.toast_ck_time);
    }

    public long getToast_show_time() {
        return this.toast_show_time;
    }

    public int getToast_times() {
        return this.toast_times;
    }

    public String getToast_type() {
        return this.toast_type;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setRequest_service_state(String str) {
        this.request_service_state = str;
    }

    public void setToast_ck(long j) {
        this.toast_ck = j;
    }

    public void setToast_ck_time(long j) {
        this.toast_ck_time = j;
    }

    public void setToast_show_time(long j) {
        this.toast_show_time = j;
    }

    public void setToast_times(int i) {
        this.toast_times = i;
    }

    public void setToast_type(String str) {
        this.toast_type = str;
    }

    public String toString() {
        return "WxClickDataModel{toast_type='" + this.toast_type + "', deeplink='" + this.deeplink + "', toast_times=" + this.toast_times + ", link='" + this.link + "', toast_ck=" + this.toast_ck + ", toast_ck_time=" + this.toast_ck_time + ", toast_show_time=" + this.toast_show_time + ", request_service_state='" + this.request_service_state + "'}";
    }
}
