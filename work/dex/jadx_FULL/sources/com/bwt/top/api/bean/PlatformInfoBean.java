package com.bwt.top.api.bean;

import com.easyjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PlatformInfoBean implements Serializable {

    @JSONField(name = "appid")
    private String appId;

    @JSONField(name = "download")
    private String download;
    private String expand;
    private String id;

    @JSONField(name = "name")
    private String platformName;

    @JSONField(name = "type")
    private String platformType;
    private int sort;

    @JSONField(name = "thirdappid")
    private String thirdAppId;

    public String getAppId() {
        return this.appId;
    }

    public String getDownload() {
        return this.download;
    }

    public String getExpand() {
        return this.expand;
    }

    public String getId() {
        return this.id;
    }

    public String getPlatformName() {
        return this.platformName;
    }

    public String getPlatformType() {
        return this.platformType;
    }

    public int getSort() {
        return this.sort;
    }

    public String getThirdAppId() {
        return this.thirdAppId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setDownload(String str) {
        this.download = str;
    }

    public void setExpand(String str) {
        this.expand = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setPlatformName(String str) {
        this.platformName = str;
    }

    public void setPlatformType(String str) {
        this.platformType = str;
    }

    public void setSort(int i) {
        this.sort = i;
    }

    public void setThirdAppId(String str) {
        this.thirdAppId = str;
    }

    public String toString() {
        return "PlatformInfoBean{platformName='" + this.platformName + "', platformType='" + this.platformType + "', appId='" + this.appId + "', thirdAppId='" + this.thirdAppId + "', id='" + this.id + "', sort=" + this.sort + ", expand='" + this.expand + "'}";
    }
}
