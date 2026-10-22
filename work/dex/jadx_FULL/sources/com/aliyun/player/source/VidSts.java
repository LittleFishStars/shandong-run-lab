package com.aliyun.player.source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VidSts extends VidSourceBase {
    private String mAccessKeyId;
    private String mAccessKeySecret;
    private String mRegion;
    private String mSecurityToken;
    private String mVid;

    public String getAccessKeyId() {
        return this.mAccessKeyId;
    }

    public String getAccessKeySecret() {
        return this.mAccessKeySecret;
    }

    public String getRegion() {
        return this.mRegion;
    }

    public String getSecurityToken() {
        return this.mSecurityToken;
    }

    public String getVid() {
        return this.mVid;
    }

    public void setAccessKeyId(String str) {
        this.mAccessKeyId = str;
    }

    public void setAccessKeySecret(String str) {
        this.mAccessKeySecret = str;
    }

    public void setQuality(String str, boolean z) {
        this.mQuality = str;
        this.mForceQuality = z;
    }

    public void setRegion(String str) {
        this.mRegion = str;
    }

    public void setSecurityToken(String str) {
        this.mSecurityToken = str;
    }

    public void setVid(String str) {
        this.mVid = str;
    }
}
