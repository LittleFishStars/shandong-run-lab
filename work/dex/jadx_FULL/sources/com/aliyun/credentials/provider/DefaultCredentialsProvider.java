package com.aliyun.credentials.provider;

import com.aliyun.credentials.exception.CredentialException;
import com.aliyun.credentials.models.CredentialModel;
import com.aliyun.credentials.utils.AuthUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultCredentialsProvider implements AlibabaCloudCredentialsProvider {
    private static final List<AlibabaCloudCredentialsProvider> USER_CONFIGURATION_PROVIDERS = new Vector();
    private List<AlibabaCloudCredentialsProvider> defaultProviders;

    public DefaultCredentialsProvider() {
        ArrayList arrayList = new ArrayList();
        this.defaultProviders = arrayList;
        arrayList.add(new SystemPropertiesCredentialsProvider());
        this.defaultProviders.add(new EnvironmentVariableCredentialsProvider());
        if (AuthUtils.environmentEnableOIDC()) {
            this.defaultProviders.add(new OIDCRoleArnCredentialProvider(AuthUtils.getEnvironmentRoleArn(), AuthUtils.getEnvironmentOIDCProviderArn(), AuthUtils.getEnvironmentOIDCTokenFilePath()));
        }
        this.defaultProviders.add(new ProfileCredentialsProvider());
        String environmentECSMetaData = AuthUtils.getEnvironmentECSMetaData();
        if (environmentECSMetaData != null) {
            this.defaultProviders.add(new EcsRamRoleCredentialProvider(environmentECSMetaData));
        }
    }

    public static boolean addCredentialsProvider(AlibabaCloudCredentialsProvider alibabaCloudCredentialsProvider) {
        return USER_CONFIGURATION_PROVIDERS.add(alibabaCloudCredentialsProvider);
    }

    public static void clearCredentialsProvider() {
        USER_CONFIGURATION_PROVIDERS.clear();
    }

    public static boolean containsCredentialsProvider(AlibabaCloudCredentialsProvider alibabaCloudCredentialsProvider) {
        return USER_CONFIGURATION_PROVIDERS.contains(alibabaCloudCredentialsProvider);
    }

    public static boolean removeCredentialsProvider(AlibabaCloudCredentialsProvider alibabaCloudCredentialsProvider) {
        return USER_CONFIGURATION_PROVIDERS.remove(alibabaCloudCredentialsProvider);
    }

    @Override // com.aliyun.credentials.provider.AlibabaCloudCredentialsProvider
    public CredentialModel getCredentials() {
        List<AlibabaCloudCredentialsProvider> list = USER_CONFIGURATION_PROVIDERS;
        if (list.size() > 0) {
            Iterator<AlibabaCloudCredentialsProvider> it = list.iterator();
            while (it.hasNext()) {
                CredentialModel credentials = it.next().getCredentials();
                if (credentials != null) {
                    return credentials;
                }
            }
        }
        Iterator<AlibabaCloudCredentialsProvider> it2 = this.defaultProviders.iterator();
        while (it2.hasNext()) {
            CredentialModel credentials2 = it2.next().getCredentials();
            if (credentials2 != null) {
                return credentials2;
            }
        }
        throw new CredentialException("not found credentials");
    }
}
