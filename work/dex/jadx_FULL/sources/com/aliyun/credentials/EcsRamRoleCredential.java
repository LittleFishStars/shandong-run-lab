package com.aliyun.credentials;

import com.aliyun.credentials.models.CredentialModel;
import com.aliyun.credentials.provider.AlibabaCloudCredentialsProvider;
import com.aliyun.credentials.utils.ParameterHelper;
import com.aliyun.credentials.utils.RefreshUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class EcsRamRoleCredential implements AlibabaCloudCredentials {
    private String accessKeyId;
    private String accessKeySecret;
    private long expiration;
    private AlibabaCloudCredentialsProvider provider;
    private String securityToken;

    public EcsRamRoleCredential() {
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
        return this.expiration;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getSecurityToken() {
        refreshCredential();
        return this.securityToken;
    }

    @Override // com.aliyun.credentials.AlibabaCloudCredentials
    public String getType() {
        return "ecs_ram_role";
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

    public void setExpiration(long j) {
        this.expiration = j;
    }

    public EcsRamRoleCredential(String str, String str2, String str3, String str4, AlibabaCloudCredentialsProvider alibabaCloudCredentialsProvider) {
        this.accessKeyId = str;
        this.accessKeySecret = str2;
        this.securityToken = str3;
        this.provider = alibabaCloudCredentialsProvider;
        this.expiration = ParameterHelper.getUTCDate(str4).getTime();
    }
}
