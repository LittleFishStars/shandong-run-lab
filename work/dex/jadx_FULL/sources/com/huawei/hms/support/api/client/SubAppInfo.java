package com.huawei.hms.support.api.client;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SubAppInfo {
    private String subAppID;

    public SubAppInfo(SubAppInfo subAppInfo) {
        if (subAppInfo != null) {
            this.subAppID = subAppInfo.getSubAppID();
        }
    }

    public String getSubAppID() {
        return this.subAppID;
    }

    public void setSubAppInfoID(String str) {
        this.subAppID = str;
    }

    public SubAppInfo(String str) {
        this.subAppID = str;
    }
}
