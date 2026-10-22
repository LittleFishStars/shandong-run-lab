package com.bwt.top.api.bean;

import com.easyjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ReportInfoBean implements Serializable {
    private String appId;
    private String id;

    @JSONField(name = "type")
    private String platformType;

    @JSONField(name = "url")
    private String reportUrl;

    public String getAppId() {
        return this.appId;
    }

    public String getId() {
        return this.id;
    }

    public String getPlatformType() {
        return this.platformType;
    }

    public String getReportUrl() {
        return this.reportUrl;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setPlatformType(String str) {
        this.platformType = str;
    }

    public void setReportUrl(String str) {
        this.reportUrl = str;
    }

    public String toString() {
        return "ReportInfoBean{reportUrl='" + this.reportUrl + "', platformType='" + this.platformType + "', appId='" + this.appId + "', id='" + this.id + "'}";
    }
}
