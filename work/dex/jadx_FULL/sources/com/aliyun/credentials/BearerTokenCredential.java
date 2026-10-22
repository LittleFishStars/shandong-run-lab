package com.aliyun.credentials;

import com.aliyun.credentials.utils.AuthConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class BearerTokenCredential implements AlibabaCloudCredentials {
    private String bearerToken;

    public BearerTokenCredential(String str) {
        this.bearerToken = str;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getAccessKeyId() {
        return null;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getAccessKeySecret() {
        return null;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getBearerToken() {
        return this.bearerToken;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getSecurityToken() {
        return null;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getType() {
        return AuthConstant.BEARER;
    }

    public void setBearerToken(String str) {
        this.bearerToken = str;
    }
}
