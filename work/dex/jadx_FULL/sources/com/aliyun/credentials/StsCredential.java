package com.aliyun.credentials;

import com.aliyun.credentials.utils.AuthConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class StsCredential implements AlibabaCloudCredentials {
    private String accessKeyId;
    private String accessKeySecret;
    private String securityToken;

    public StsCredential() {
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getBearerToken() {
        return null;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getSecurityToken() {
        return this.securityToken;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getType() {
        return AuthConstant.STS;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setAccessKeySecret(String str) {
        this.accessKeySecret = str;
    }

    public void setSecurityToken(String str) {
        this.securityToken = str;
    }

    public StsCredential(String str, String str2, String str3) {
        this.accessKeyId = str;
        this.accessKeySecret = str2;
        this.securityToken = str3;
    }
}
