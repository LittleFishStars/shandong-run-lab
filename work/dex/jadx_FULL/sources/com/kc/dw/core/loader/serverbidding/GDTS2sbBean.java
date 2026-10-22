package com.kc.dw.core.loader.serverbidding;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GDTS2sbBean implements IS2SBInterface {
    private String app_id;
    private String buyer_id;
    private String opensdk_ver;
    private String pid;
    private String sdk;
    private String sdk_info;
    private boolean support_h265;
    private boolean support_splash_zoomout;
    private boolean wx_installed;

    public String getApp_id() {
        return this.app_id;
    }

    public String getBuyer_id() {
        return this.buyer_id;
    }

    public String getOpensdk_ver() {
        return this.opensdk_ver;
    }

    public String getPid() {
        return this.pid;
    }

    public String getSdk() {
        return this.sdk;
    }

    public String getSdk_info() {
        return this.sdk_info;
    }

    public boolean isSupport_h265() {
        return this.support_h265;
    }

    public boolean isSupport_splash_zoomout() {
        return this.support_splash_zoomout;
    }

    public boolean isWx_installed() {
        return this.wx_installed;
    }

    public void setApp_id(String str) {
        this.app_id = str;
    }

    public void setBuyer_id(String str) {
        this.buyer_id = str;
    }

    public void setOpensdk_ver(String str) {
        this.opensdk_ver = str;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setSdk(String str) {
        this.sdk = str;
    }

    public void setSdk_info(String str) {
        this.sdk_info = str;
    }

    public void setSupport_h265(boolean z) {
        this.support_h265 = z;
    }

    public void setSupport_splash_zoomout(boolean z) {
        this.support_splash_zoomout = z;
    }

    public void setWx_installed(boolean z) {
        this.wx_installed = z;
    }
}
