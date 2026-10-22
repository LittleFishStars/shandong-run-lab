package com.aliyun.credentials.provider;

import com.aliyun.credentials.exception.CredentialException;
import com.aliyun.credentials.models.CredentialModel;
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.credentials.utils.AuthUtils;
import com.aliyun.credentials.utils.StringUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.ini4j.Profile;
import org.ini4j.Wini;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ProfileCredentialsProvider implements AlibabaCloudCredentialsProvider {
    private static volatile Wini ini;

    private CredentialModel createCredential(Map<String, String> map, CredentialsProviderFactory credentialsProviderFactory) {
        String str = map.get("type");
        if (StringUtils.isEmpty(str)) {
            throw new CredentialException("The configured client type is empty");
        }
        if ("ram_role_arn".equals(str)) {
            return getSTSAssumeRoleSessionCredentials(map, credentialsProviderFactory);
        }
        if ("rsa_key_pair".equals(str)) {
            return getSTSGetSessionAccessKeyCredentials(map, credentialsProviderFactory);
        }
        if ("ecs_ram_role".equals(str)) {
            return getInstanceProfileCredentials(map, credentialsProviderFactory);
        }
        if ("oidc_role_arn".equals(str)) {
            return getSTSOIDCRoleSessionCredentials(map, credentialsProviderFactory);
        }
        String str2 = map.get(AuthConstant.INI_ACCESS_KEY_ID);
        String str3 = map.get(AuthConstant.INI_ACCESS_KEY_IDSECRET);
        if (StringUtils.isEmpty(str2) || StringUtils.isEmpty(str3)) {
            return null;
        }
        return CredentialModel.builder().accessKeyId(str2).accessKeySecret(str3).type(AuthConstant.ACCESS_KEY).build();
    }

    private static Wini getIni(String str) throws IOException {
        if (ini == null) {
            ini = new Wini(new File(str));
        }
        return ini;
    }

    private CredentialModel getInstanceProfileCredentials(Map<String, String> map, CredentialsProviderFactory credentialsProviderFactory) {
        String str = map.get(AuthConstant.INI_ROLE_NAME);
        if (StringUtils.isEmpty(str)) {
            throw new CredentialException("The configured role_name is empty");
        }
        return ((EcsRamRoleCredentialProvider) credentialsProviderFactory.createCredentialsProvider(EcsRamRoleCredentialProvider.builder().roleName(str).build())).getCredentials();
    }

    private CredentialModel getSTSAssumeRoleSessionCredentials(Map<String, String> map, CredentialsProviderFactory credentialsProviderFactory) {
        String str = map.get(AuthConstant.INI_ACCESS_KEY_ID);
        String str2 = map.get(AuthConstant.INI_ACCESS_KEY_IDSECRET);
        String str3 = map.get(AuthConstant.INI_ROLE_SESSION_NAME);
        String str4 = map.get(AuthConstant.INI_ROLE_ARN);
        String str5 = map.get(AuthConstant.DEFAULT_REGION);
        String str6 = map.get(AuthConstant.INI_POLICY);
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
            throw new CredentialException("The configured access_key_id or access_key_secret is empty");
        }
        if (StringUtils.isEmpty(str3) || StringUtils.isEmpty(str4)) {
            throw new CredentialException("The configured role_session_name or role_arn is empty");
        }
        return ((RamRoleArnCredentialProvider) credentialsProviderFactory.createCredentialsProvider(RamRoleArnCredentialProvider.builder().accessKeyId(str).accessKeySecret(str2).roleArn(str4).roleSessionName(str3).regionId(str5).policy(str6).build())).getCredentials();
    }

    private CredentialModel getSTSGetSessionAccessKeyCredentials(Map<String, String> map, CredentialsProviderFactory credentialsProviderFactory) throws Throwable {
        String str = map.get(AuthConstant.INI_PUBLIC_KEY_ID);
        String str2 = map.get(AuthConstant.INI_PRIVATE_KEY_FILE);
        if (StringUtils.isEmpty(str2)) {
            throw new CredentialException("The configured private_key_file is empty");
        }
        String privateKey = AuthUtils.getPrivateKey(str2);
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(privateKey)) {
            throw new CredentialException("The configured public_key_id or private_key_file content is empty");
        }
        return ((RsaKeyPairCredentialProvider) credentialsProviderFactory.createCredentialsProvider(RsaKeyPairCredentialProvider.builder().publicKeyId(str).privateKeyFile(privateKey).build())).getCredentials();
    }

    private CredentialModel getSTSOIDCRoleSessionCredentials(Map<String, String> map, CredentialsProviderFactory credentialsProviderFactory) {
        String str = map.get(AuthConstant.INI_ROLE_SESSION_NAME);
        String str2 = map.get(AuthConstant.INI_ROLE_ARN);
        String str3 = map.get(AuthConstant.INI_OIDC_PROVIDER_ARN);
        String str4 = map.get(AuthConstant.INI_OIDC_TOKEN_FILE_PATH);
        String str5 = map.get(AuthConstant.DEFAULT_REGION);
        String str6 = map.get(AuthConstant.INI_POLICY);
        if (StringUtils.isEmpty(str2)) {
            throw new CredentialException("The configured role_arn is empty");
        }
        if (StringUtils.isEmpty(str3)) {
            throw new CredentialException("The configured oidc_provider_arn is empty");
        }
        return ((OIDCRoleArnCredentialProvider) credentialsProviderFactory.createCredentialsProvider(OIDCRoleArnCredentialProvider.builder().roleArn(str2).roleSessionName(str).oidcProviderArn(str3).oidcTokenFilePath(str4).regionId(str5).policy(str6).build())).getCredentials();
    }

    private Map<String, Map<String, String>> loadIni(Wini wini) {
        HashMap map = new HashMap(16);
        for (Map.Entry entry : wini.entrySet()) {
            if (((Boolean) ((Profile.Section) entry.getValue()).get(AuthConstant.INI_ENABLE, Boolean.TYPE)).booleanValue()) {
                HashMap map2 = new HashMap(16);
                for (Map.Entry entry2 : ((Profile.Section) entry.getValue()).entrySet()) {
                    map2.put(entry2.getKey(), entry2.getValue());
                }
                map.put(entry.getKey(), map2);
            }
        }
        return map;
    }

    @Override // com.aliyun.credentials.provider.AlibabaCloudCredentialsProvider
    public CredentialModel getCredentials() {
        String environmentCredentialsFile = AuthUtils.getEnvironmentCredentialsFile();
        if (environmentCredentialsFile == null) {
            environmentCredentialsFile = AuthConstant.DEFAULT_CREDENTIALS_FILE_PATH;
        }
        if (environmentCredentialsFile.length() == 0) {
            throw new CredentialException("The specified credentials file is empty");
        }
        try {
            Map<String, String> map = loadIni(getIni(environmentCredentialsFile)).get(AuthUtils.getClientType());
            if (map != null) {
                return createCredential(map, new CredentialsProviderFactory());
            }
            throw new CredentialException("Client is not open in the specified credentials file");
        } catch (IOException unused) {
            return null;
        }
    }
}
