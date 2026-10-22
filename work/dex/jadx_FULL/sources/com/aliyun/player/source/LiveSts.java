package com.aliyun.player.source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LiveSts extends SourceBase {
    private String mAccessKeyId;
    private String mAccessKeySecret;
    private String mApp;
    private String mDomain;
    private LiveEncryptionType mEncryptionType;
    private String mRegion;
    private String mSecurityToken;
    private String mStream;
    private String mUrl;

    public enum LiveEncryptionType {
        NoEncryption,
        AliEncryption,
        WideVine_FairPlay
    }

    public String getAccessKeyId() {
        return this.mAccessKeyId;
    }

    public String getAccessKeySecret() {
        return this.mAccessKeySecret;
    }

    public String getApp() {
        return this.mApp;
    }

    public String getDomain() {
        return this.mDomain;
    }

    public int getEncryptionTypeValue() {
        LiveEncryptionType liveEncryptionType = this.mEncryptionType;
        return liveEncryptionType == null ? LiveEncryptionType.NoEncryption.ordinal() : liveEncryptionType.ordinal();
    }

    public String getRegion() {
        return this.mRegion;
    }

    public String getSecurityToken() {
        return this.mSecurityToken;
    }

    public String getStream() {
        return this.mStream;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setAccessKeyId(String str) {
        this.mAccessKeyId = str;
    }

    public void setAccessKeySecret(String str) {
        this.mAccessKeySecret = str;
    }

    public void setApp(String str) {
        this.mApp = str;
    }

    public void setDomain(String str) {
        this.mDomain = str;
    }

    public void setEncryptionType(LiveEncryptionType liveEncryptionType) {
        this.mEncryptionType = liveEncryptionType;
    }

    public void setRegion(String str) {
        this.mRegion = str;
    }

    public void setSecurityToken(String str) {
        this.mSecurityToken = str;
    }

    public void setStream(String str) {
        this.mStream = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }
}
