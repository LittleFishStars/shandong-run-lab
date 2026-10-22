package com.aliyun.credentials;

import com.aliyun.credentials.provider.AlibabaCloudCredentialsProvider;
import com.aliyun.credentials.provider.DefaultCredentialsProvider;
import com.aliyun.credentials.provider.EcsRamRoleCredentialProvider;
import com.aliyun.credentials.provider.OIDCRoleArnCredentialProvider;
import com.aliyun.credentials.provider.RamRoleArnCredentialProvider;
import com.aliyun.credentials.provider.RsaKeyPairCredentialProvider;
import com.aliyun.credentials.utils.AuthConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class Credential {
    private AlibabaCloudCredentials cloudCredential;

    public Credential(Configuration configuration) {
        if (configuration == null) {
            this.cloudCredential = new DefaultCredentialsProvider().getCredentials();
        } else {
            this.cloudCredential = getCredential(configuration);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0037  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private AlibabaCloudCredentialsProvider getProvider(Configuration configuration) {
        byte b;
        try {
            String type = configuration.getType();
            switch (type.hashCode()) {
                case -795952619:
                    if (!type.equals("ram_role_arn")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 49127385:
                    if (!type.equals("rsa_key_pair")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 703555770:
                    if (!type.equals("oidc_role_arn")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 1826440545:
                    if (!type.equals("ecs_ram_role")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                return new EcsRamRoleCredentialProvider(configuration);
            }
            if (b == 1) {
                return new RamRoleArnCredentialProvider(configuration);
            }
            if (b != 2) {
                return b != 3 ? new DefaultCredentialsProvider() : new OIDCRoleArnCredentialProvider(configuration);
            }
            return new RsaKeyPairCredentialProvider(configuration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAccessKeyId() {
        return this.cloudCredential.getAccessKeyId();
    }

    public String getAccessKeySecret() {
        return this.cloudCredential.getAccessKeySecret();
    }

    public AlibabaCloudCredentials getCredential(Configuration configuration) {
        String type = configuration.getType();
        type.hashCode();
        if (type.equals(AuthConstant.ACCESS_KEY)) {
            return new AccessKeyCredential(configuration.getAccessKeyId(), configuration.getAccessKeySecret());
        }
        return !type.equals(AuthConstant.STS) ? getProvider(configuration).getCredentials() : new StsCredential(configuration.getAccessKeyId(), configuration.getAccessKeySecret(), configuration.getSecurityToken());
    }

    public String getSecurityToken() {
        return this.cloudCredential.getSecurityToken();
    }

    public String getType() {
        return this.cloudCredential.getType();
    }
}
