package com.aliyun.credentials.provider;

import com.aliyun.credentials.models.CredentialModel;
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.credentials.utils.AuthUtils;
import com.aliyun.credentials.utils.StringUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SystemPropertiesCredentialsProvider implements AlibabaCloudCredentialsProvider {
    @Override // com.aliyun.credentials.provider.AlibabaCloudCredentialsProvider
    public CredentialModel getCredentials() {
        if (!"default".equals(AuthUtils.getClientType())) {
            return null;
        }
        String property = System.getProperty(AuthConstant.SYSTEM_ACCESSKEYID);
        String property2 = System.getProperty(AuthConstant.SYSTEM_ACCESSKEYSECRET);
        if (StringUtils.isEmpty(property) || StringUtils.isEmpty(property2)) {
            return null;
        }
        return CredentialModel.builder().accessKeyId(property).accessKeySecret(property2).build();
    }
}
