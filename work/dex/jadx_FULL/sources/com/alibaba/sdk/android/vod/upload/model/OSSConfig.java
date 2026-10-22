package com.alibaba.sdk.android.vod.upload.model;

import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OSSConfig {
    private String accessKeyId;
    private String accessKeyIdToVOD;
    private String accessKeySecret;
    private String accessKeySecretToVOD;
    private String expireTime;
    private String expireTimeToVOD;
    private long partSize;
    private String secrityToken;
    private String secrityTokenToVOD;
    private String uploadAddress;
    private String videoId;

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getAccessKeyIdToVOD() {
        return this.accessKeyIdToVOD;
    }

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public String getAccessKeySecretToVOD() {
        return this.accessKeySecretToVOD;
    }

    public String getExpireTime() {
        return this.expireTime;
    }

    public String getExpireTimeToVOD() {
        return this.expireTimeToVOD;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public OSSCredentialProvider getProvider() {
        if (this.secrityToken != null && this.expireTime != null) {
            return new OSSFederationCredentialProvider() { // from class: com.alibaba.sdk.android.vod.upload.model.OSSConfig.1
                @Override // com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider, com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider
                public OSSFederationToken getFederationToken() {
                    return new OSSFederationToken(OSSConfig.this.accessKeyId, OSSConfig.this.accessKeySecret, OSSConfig.this.secrityToken, OSSConfig.this.expireTime);
                }
            };
        }
        String str = this.accessKeyId;
        if (str == null) {
            str = "";
        }
        String str2 = this.accessKeySecret;
        return new OSSPlainTextAKSKCredentialProvider(str, str2 != null ? str2 : "");
    }

    public String getSecrityToken() {
        return this.secrityToken;
    }

    public String getSecrityTokenToVOD() {
        return this.secrityTokenToVOD;
    }

    public String getUploadAddress() {
        return this.uploadAddress;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setAccessKeyIdToVOD(String str) {
        this.accessKeyIdToVOD = str;
    }

    public void setAccessKeySecret(String str) {
        this.accessKeySecret = str;
    }

    public void setAccessKeySecretToVOD(String str) {
        this.accessKeySecretToVOD = str;
    }

    public void setExpireTime(String str) {
        this.expireTime = str;
    }

    public void setExpireTimeToVOD(String str) {
        this.expireTimeToVOD = str;
    }

    public void setPartSize(long j) {
        this.partSize = j;
    }

    public void setSecrityToken(String str) {
        this.secrityToken = str;
    }

    public void setSecrityTokenToVOD(String str) {
        this.secrityTokenToVOD = str;
    }

    public void setUploadAddress(String str) {
        this.uploadAddress = str;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }
}
