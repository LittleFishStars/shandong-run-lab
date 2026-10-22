package com.byazt.e;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 443, 1860})
public class DeepLink {
    public long id;
    public JSONObject json;
    public String mCloudGameUrl;
    public String mOpenUrl;
    public String mWebTitle;
    public String mWebUrl;
    public String packageName;

    public DeepLink(String str, String str2, String str3) {
        this.mOpenUrl = str;
        this.mWebUrl = str2;
        this.mWebTitle = str3;
    }

    public String getCloudGameUrl() {
        return this.mCloudGameUrl;
    }

    public long getId() {
        return this.id;
    }

    public JSONObject getJson() {
        return this.json;
    }

    public String getOpenUrl() {
        return this.mOpenUrl;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getWebTitle() {
        return this.mWebTitle;
    }

    public String getWebUrl() {
        return this.mWebUrl;
    }

    public void setCloudGameUrl(String str) {
        this.mCloudGameUrl = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setJson(JSONObject jSONObject) {
        this.json = jSONObject;
    }

    public void setOpenUrl(String str) {
        this.mOpenUrl = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setWebTitle(String str) {
        this.mWebTitle = str;
    }

    public void setWebUrl(String str) {
        this.mWebUrl = str;
    }

    public DeepLink() {
    }
}
