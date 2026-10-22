package com.aliyun.credentials.provider;

import com.aliyun.credentials.exception.CredentialException;
import com.aliyun.credentials.models.CredentialModel;
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.credentials.utils.AuthUtils;
import com.aliyun.credentials.utils.StringUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EnvironmentVariableCredentialsProvider implements AlibabaCloudCredentialsProvider {
    @Override // com.aliyun.credentials.provider.AlibabaCloudCredentialsProvider
    public CredentialModel getCredentials() {
        if (!"default".equals(AuthUtils.getClientType())) {
            return null;
        }
        String environmentAccessKeyId = AuthUtils.getEnvironmentAccessKeyId();
        String environmentAccessKeySecret = AuthUtils.getEnvironmentAccessKeySecret();
        String environmentSecurityToken = AuthUtils.getEnvironmentSecurityToken();
        if (environmentAccessKeyId == null || environmentAccessKeySecret == null) {
            return null;
        }
        if (environmentAccessKeyId.length() == 0) {
            throw new CredentialException("Environment variable accessKeyId cannot be empty");
        }
        if (environmentAccessKeySecret.length() != 0) {
            return !StringUtils.isEmpty(environmentSecurityToken) ? CredentialModel.builder().accessKeyId(environmentAccessKeyId).accessKeySecret(environmentAccessKeySecret).securityToken(environmentSecurityToken).type(AuthConstant.STS).build() : CredentialModel.builder().accessKeyId(environmentAccessKeyId).accessKeySecret(environmentAccessKeySecret).type(AuthConstant.ACCESS_KEY).build();
        }
        throw new CredentialException("Environment variable accessKeySecret cannot be empty");
    }
}
