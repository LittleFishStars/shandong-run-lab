package com.bwt.top.api.bean;

import com.easyjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ChannelUrlBean implements Serializable {

    @JSONField(name = "baseUrl")
    private String baseUrl;

    @JSONField(name = "name")
    private String name;

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getName() {
        return this.name;
    }

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "ChannelUrlBean{name='" + this.name + "', baseUrl='" + this.baseUrl + "'}";
    }
}
