package com.aliyun.credentials;

import com.aliyun.credentials.models.CredentialModel;
import com.aliyun.credentials.provider.AlibabaCloudCredentialsProvider;
import com.aliyun.credentials.utils.RefreshUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class RsaKeyPairCredential implements AlibabaCloudCredentials {
    private long expiration;
    private String privateKeySecret;
    private AlibabaCloudCredentialsProvider provider;
    private String publicKeyId;

    public RsaKeyPairCredential(String str, String str2, long j, AlibabaCloudCredentialsProvider alibabaCloudCredentialsProvider) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("You must provide a valid pair of Public Key ID and Private Key Secret.");
        }
        this.publicKeyId = str;
        this.privateKeySecret = str2;
        this.expiration = j;
        this.provider = alibabaCloudCredentialsProvider;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getAccessKeyId() {
        refreshCredential();
        return this.publicKeyId;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getAccessKeySecret() {
        refreshCredential();
        return this.privateKeySecret;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getBearerToken() {
        return null;
    }

    public long getExpiration() {
        return this.expiration;
    }

    public AlibabaCloudCredentialsProvider getProvider() {
        return this.provider;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getSecurityToken() {
        return null;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getType() {
        return "rsa_key_pair";
    }

    public void refreshCredential() {
        if (RefreshUtils.withShouldRefresh(this.expiration)) {
            CredentialModel credentialModel = (CredentialModel) RefreshUtils.getNewCredential(this.provider);
            this.publicKeyId = credentialModel.getAccessKeyId();
            this.expiration = credentialModel.getExpiration();
            this.privateKeySecret = credentialModel.getAccessKeySecret();
        }
    }
}
