package com.aliyun.credentials.utils;

import com.aliyun.credentials.exception.CredentialException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AuthUtils {
    private static volatile String OIDCToken;
    private static volatile String clientType = System.getenv("ALIBABA_CLOUD_PROFILE");
    private static volatile String environmentAccessKeyId;
    private static volatile String environmentAccesskeySecret;
    private static volatile String environmentCredentialsFile;
    private static volatile String environmentECSMetaData;
    private static volatile String environmentOIDCProviderArn;
    private static volatile String environmentOIDCTokenFilePath;
    private static volatile String environmentRoleArn;
    private static volatile String environmentSecurityToken;
    private static volatile String privateKey;

    public static boolean environmentEnableOIDC() {
        return (StringUtils.isEmpty(getEnvironmentRoleArn()) || StringUtils.isEmpty(getEnvironmentOIDCProviderArn()) || StringUtils.isEmpty(getEnvironmentOIDCTokenFilePath())) ? false : true;
    }

    public static String getClientType() {
        if (clientType != null) {
            return clientType;
        }
        clientType = "default";
        return clientType;
    }

    public static String getEnvironmentAccessKeyId() {
        return environmentAccessKeyId == null ? System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID") : environmentAccessKeyId;
    }

    public static String getEnvironmentAccessKeySecret() {
        return environmentAccesskeySecret == null ? System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET") : environmentAccesskeySecret;
    }

    public static String getEnvironmentCredentialsFile() {
        return environmentCredentialsFile == null ? System.getenv("ALIBABA_CLOUD_CREDENTIALS_FILE") : environmentCredentialsFile;
    }

    public static String getEnvironmentECSMetaData() {
        return environmentECSMetaData == null ? System.getenv("ALIBABA_CLOUD_ECS_METADATA") : environmentECSMetaData;
    }

    public static String getEnvironmentOIDCProviderArn() {
        return environmentOIDCProviderArn == null ? System.getenv("ALIBABA_CLOUD_OIDC_PROVIDER_ARN") : environmentOIDCProviderArn;
    }

    public static String getEnvironmentOIDCTokenFilePath() {
        return environmentOIDCTokenFilePath == null ? System.getenv("ALIBABA_CLOUD_OIDC_TOKEN_FILE") : environmentOIDCTokenFilePath;
    }

    public static String getEnvironmentRoleArn() {
        return environmentRoleArn == null ? System.getenv("ALIBABA_CLOUD_ROLE_ARN") : environmentRoleArn;
    }

    public static String getEnvironmentSecurityToken() {
        return environmentSecurityToken == null ? System.getenv("ALIBABA_CLOUD_SECURITY_TOKEN") : environmentSecurityToken;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static String getOIDCToken(String str) throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        IOException e;
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            throw new CredentialException("OIDCTokenFilePath " + str + " is not exists.");
        }
        ?? CanRead = file.canRead();
        if (CanRead == 0) {
            throw new CredentialException("OIDCTokenFilePath " + str + " cannot be read.");
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    OIDCToken = new String(bArr, "UTF-8");
                    try {
                        fileInputStream.close();
                        CanRead = fileInputStream;
                    } catch (IOException e2) {
                        throw new CredentialException(e2.getMessage(), e2);
                    }
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    CanRead = fileInputStream;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            CanRead = fileInputStream;
                        } catch (IOException e4) {
                            throw new CredentialException(e4.getMessage(), e4);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (CanRead != 0) {
                    try {
                        CanRead.close();
                    } catch (IOException e5) {
                        throw new CredentialException(e5.getMessage(), e5);
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            fileInputStream = null;
            e = e6;
        } catch (Throwable th3) {
            CanRead = 0;
            th = th3;
            if (CanRead != 0) {
                CanRead.close();
            }
            throw th;
        }
        return OIDCToken;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static String getPrivateKey(String str) throws Throwable {
        ?? r0 = 0;
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(str));
                try {
                    byte[] bArr = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr);
                    String str2 = new String(bArr, "UTF-8");
                    privateKey = str2;
                    try {
                        fileInputStream2.close();
                        r0 = str2;
                    } catch (IOException e) {
                        throw new CredentialException(e.getMessage(), e);
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    r0 = fileInputStream;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            r0 = fileInputStream;
                        } catch (IOException e3) {
                            throw new CredentialException(e3.getMessage(), e3);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r0 = fileInputStream2;
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (IOException e4) {
                            throw new CredentialException(e4.getMessage(), e4);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        }
        return privateKey;
    }

    public static void setClientType(String str) {
        clientType = str;
    }

    public static void setEnvironmentAccessKeyId(String str) {
        environmentAccessKeyId = str;
    }

    public static void setEnvironmentAccessKeySecret(String str) {
        environmentAccesskeySecret = str;
    }

    public static void setEnvironmentCredentialsFile(String str) {
        environmentCredentialsFile = str;
    }

    public static void setEnvironmentECSMetaData(String str) {
        environmentECSMetaData = str;
    }

    public static void setEnvironmentOIDCProviderArn(String str) {
        environmentOIDCProviderArn = str;
    }

    public static void setEnvironmentOIDCTokenFilePath(String str) {
        environmentOIDCTokenFilePath = str;
    }

    public static void setEnvironmentRoleArn(String str) {
        environmentRoleArn = str;
    }

    public static void setEnvironmentSecurityToken(String str) {
        environmentSecurityToken = str;
    }

    public static void setPrivateKey(String str) {
        privateKey = str;
    }
}
