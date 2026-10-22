package com.kc.dw.platform.custom;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CustomInfo {
    private String app_id;
    private String app_key;
    private String custom_ext;
    private String pid;
    private String reqId;
    private boolean isExpress = true;
    private int fetchCount = 1;

    public String getApp_id() {
        return this.app_id;
    }

    public String getApp_key() {
        return this.app_key;
    }

    public String getCustom_ext() {
        return this.custom_ext;
    }

    public int getFetchCount() {
        return this.fetchCount;
    }

    public String getPid() {
        return this.pid;
    }

    public String getReqId() {
        return this.reqId;
    }

    public boolean isExpress() {
        return this.isExpress;
    }

    public void setApp_id(String str) {
        this.app_id = str;
    }

    public void setApp_key(String str) {
        this.app_key = str;
    }

    public void setCustom_ext(String str) {
        this.custom_ext = str;
    }

    public void setExpress(boolean z) {
        this.isExpress = z;
    }

    public void setFetchCount(int i) {
        this.fetchCount = i;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setReqId(String str) {
        this.reqId = str;
    }
}
