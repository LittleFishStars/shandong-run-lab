package com.aliyun.credentials;

import com.aliyun.credentials.models.CredentialModel;
import com.aliyun.credentials.provider.AlibabaCloudCredentialsProvider;
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.credentials.utils.RefreshUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class URLCredential implements AlibabaCloudCredentials {
    private String accessKeyId;
    private String accessKeySecret;
    private long expiration;
    private AlibabaCloudCredentialsProvider provider;
    private String securityToken;

    public URLCredential(String str, String str2, String str3, long j, AlibabaCloudCredentialsProvider alibabaCloudCredentialsProvider) {
        this.accessKeyId = str;
        this.accessKeySecret = str2;
        this.securityToken = str3;
        this.expiration = j;
        this.provider = alibabaCloudCredentialsProvider;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getAccessKeyId() {
        refreshCredential();
        return this.accessKeyId;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getAccessKeySecret() {
        refreshCredential();
        return this.accessKeySecret;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getBearerToken() {
        return null;
    }

    public long getExpiration() {
        refreshCredential();
        return this.expiration;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getSecurityToken() {
        refreshCredential();
        return this.securityToken;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getType() {
        return AuthConstant.URL_STS;
    }

    public void refreshCredential() {
        if (RefreshUtils.withShouldRefresh(this.expiration)) {
            CredentialModel credentialModel = (CredentialModel) RefreshUtils.getNewCredential(this.provider);
            this.expiration = credentialModel.getExpiration();
            this.accessKeyId = credentialModel.getAccessKeyId();
            this.accessKeySecret = credentialModel.getAccessKeySecret();
            this.securityToken = credentialModel.getSecurityToken();
        }
    }
}
