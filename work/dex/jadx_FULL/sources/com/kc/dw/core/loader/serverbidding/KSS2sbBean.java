package com.kc.dw.core.loader.serverbidding;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class KSS2sbBean implements IS2SBInterface {
    private String app_id;
    private String pid;
    private String sdk;
    private String token;

    public String getApp_id() {
        return this.app_id;
    }

    public String getPid() {
        return this.pid;
    }

    public String getSdk() {
        return this.sdk;
    }

    public String getToken() {
        return this.token;
    }

    public void setApp_id(String str) {
        this.app_id = str;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setSdk(String str) {
        this.sdk = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
