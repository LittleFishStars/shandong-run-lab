package com.aliyun.credentials;

import com.aliyun.credentials.utils.AuthConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class AccessKeyCredential implements AlibabaCloudCredentials {
    private final String accessKeyId;
    private final String accessKeySecret;

    public AccessKeyCredential(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Access key ID cannot be null.");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("Access key secret cannot be null.");
        }
        this.accessKeyId = str;
        this.accessKeySecret = str2;
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
        return null;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getType() {
        return AuthConstant.ACCESS_KEY;
    }
}
