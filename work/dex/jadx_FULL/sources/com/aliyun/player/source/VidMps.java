package com.aliyun.player.source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VidMps extends VidSourceBase {
    private String mAccessKeyId;
    private String mAccessKeySecret;
    private String mAuthInfo;
    private String mHlsUriToken;
    private String mMediaId;
    private String mPlayDomain;
    private String mRegion;
    private String mSecurityToken;

    public String getAccessKeyId() {
        return this.mAccessKeyId;
    }

    public String getAccessKeySecret() {
        return this.mAccessKeySecret;
    }

    public String getAuthInfo() {
        return this.mAuthInfo;
    }

    public String getHlsUriToken() {
        return this.mHlsUriToken;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public String getPlayDomain() {
        return this.mPlayDomain;
    }

    public String getRegion() {
        return this.mRegion;
    }

    public String getSecurityToken() {
        return this.mSecurityToken;
    }

    public void setAccessKeyId(String str) {
        this.mAccessKeyId = str;
    }

    public void setAccessKeySecret(String str) {
        this.mAccessKeySecret = str;
    }

    public void setAuthInfo(String str) {
        this.mAuthInfo = str;
    }

    public void setHlsUriToken(String str) {
        this.mHlsUriToken = str;
    }

    public void setMediaId(String str) {
        this.mMediaId = str;
    }

    public void setPlayDomain(String str) {
        this.mPlayDomain = str;
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
}
