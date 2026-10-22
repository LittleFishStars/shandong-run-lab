package com.aliyun.credentials;

import com.aliyun.credentials.models.Config;
import com.aliyun.credentials.models.CredentialModel;
import com.aliyun.credentials.provider.AlibabaCloudCredentialsProvider;
import com.aliyun.credentials.provider.DefaultCredentialsProvider;
import com.aliyun.credentials.provider.EcsRamRoleCredentialProvider;
import com.aliyun.credentials.provider.OIDCRoleArnCredentialProvider;
import com.aliyun.credentials.provider.RamRoleArnCredentialProvider;
import com.aliyun.credentials.provider.RsaKeyPairCredentialProvider;
import com.aliyun.credentials.provider.StaticCredentialsProvider;
import com.aliyun.credentials.provider.URLCredentialProvider;
import com.aliyun.tea.utils.Validate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Client {
    private final AlibabaCloudCredentialsProvider credentialsProvider;

    public Client() {
        this.credentialsProvider = new DefaultCredentialsProvider();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x005c  */
    private AlibabaCloudCredentialsProvider getProvider(Config config) {
        try {
            switch (config.type) {
                case "access_key":
                    return StaticCredentialsProvider.builder().credential(CredentialModel.builder().accessKeyId((String) Validate.notNull(config.accessKeyId, "AccessKeyId must not be null.", new Object[0])).accessKeySecret((String) Validate.notNull(config.accessKeySecret, "AccessKeySecret must not be null.", new Object[0])).type(config.type).build()).build();
                case "sts":
                    return StaticCredentialsProvider.builder().credential(CredentialModel.builder().accessKeyId((String) Validate.notNull(config.accessKeyId, "AccessKeyId must not be null.", new Object[0])).accessKeySecret((String) Validate.notNull(config.accessKeySecret, "AccessKeySecret must not be null.", new Object[0])).securityToken((String) Validate.notNull(config.securityToken, "SecurityToken must not be null.", new Object[0])).type(config.type).build()).build();
                case "bearer":
                    return StaticCredentialsProvider.builder().credential(CredentialModel.builder().bearerToken((String) Validate.notNull(config.bearerToken, "BearerToken must not be null.", new Object[0])).type(config.type).build()).build();
                case "ecs_ram_role":
                    return EcsRamRoleCredentialProvider.builder().roleName(config.roleName).connectionTimeout(config.connectTimeout).readTimeout(config.timeout).build();
                case "ram_role_arn":
                    return RamRoleArnCredentialProvider.builder().accessKeyId(config.accessKeyId).accessKeySecret(config.accessKeySecret).durationSeconds(config.roleSessionExpiration.intValue()).roleArn(config.roleArn).roleSessionName(config.roleSessionName).policy(config.policy).STSEndpoint(config.STSEndpoint).externalId(config.externalId).connectionTimeout(config.connectTimeout).readTimeout(config.timeout).build();
                case "rsa_key_pair":
                    return RsaKeyPairCredentialProvider.builder().publicKeyId(config.publicKeyId).privateKeyFile(config.privateKeyFile).durationSeconds(config.roleSessionExpiration.intValue()).STSEndpoint(config.STSEndpoint).connectionTimeout(config.connectTimeout).readTimeout(config.timeout).build();
                case "oidc_role_arn":
                    return OIDCRoleArnCredentialProvider.builder().durationSeconds(config.roleSessionExpiration.intValue()).roleArn(config.roleArn).roleSessionName(config.roleSessionName).oidcProviderArn(config.oidcProviderArn).oidcTokenFilePath(config.oidcTokenFilePath).policy(config.policy).STSEndpoint(config.STSEndpoint).connectionTimeout(config.connectTimeout).readTimeout(config.timeout).build();
                case "credentials_uri":
                    return URLCredentialProvider.builder().credentialsURI(config.credentialsURI).connectionTimeout(config.connectTimeout).readTimeout(config.timeout).build();
                default:
                    return new DefaultCredentialsProvider();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAccessKeyId() {
        return this.credentialsProvider.getCredentials().getAccessKeyId();
    }

    public String getAccessKeySecret() {
        return this.credentialsProvider.getCredentials().getAccessKeySecret();
    }

    public String getBearerToken() {
        return this.credentialsProvider.getCredentials().getBearerToken();
    }

    public CredentialModel getCredential() {
        return this.credentialsProvider.getCredentials();
    }

    public String getSecurityToken() {
        return this.credentialsProvider.getCredentials().getSecurityToken();
    }

    public String getType() {
        return this.credentialsProvider.getCredentials().getType();
    }

    public Client(Config config) {
        if (config == null) {
            this.credentialsProvider = new DefaultCredentialsProvider();
        } else {
            this.credentialsProvider = getProvider(config);
        }
    }

    public Client(AlibabaCloudCredentialsProvider alibabaCloudCredentialsProvider) {
        this.credentialsProvider = alibabaCloudCredentialsProvider;
    }
}
