package com.aliyun.credentials;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class Configuration {
    private String STSEndpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String certFile;
    private String certPassword;
    private int connectTimeout;
    private String credentialsURI;
    private String host;
    private String oidcProviderArn;
    private String oidcTokenFilePath;
    private String privateKeyFile;
    private String proxy;
    private String publicKeyId;
    private int readTimeout;
    private String roleArn;
    private String roleName;
    private String roleSessionName;
    private String securityToken;
    private String type = "default";

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public String getCertFile() {
        return this.certFile;
    }

    public String getCertPassword() {
        return this.certPassword;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public String getCredentialsURI() {
        return this.credentialsURI;
    }

    public String getHost() {
        return this.host;
    }

    public String getOIDCProviderArn() {
        return this.oidcProviderArn;
    }

    public String getOIDCTokenFilePath() {
        return this.oidcTokenFilePath;
    }

    public String getPrivateKeyFile() {
        return this.privateKeyFile;
    }

    public String getProxy() {
        return this.proxy;
    }

    public String getPublicKeyId() {
        return this.publicKeyId;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public String getRoleSessionName() {
        return this.roleSessionName;
    }

    public String getSTSEndpoint() {
        return this.STSEndpoint;
    }

    public String getSecurityToken() {
        return this.securityToken;
    }

    public String getType() {
        return this.type;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setAccessKeySecret(String str) {
        this.accessKeySecret = str;
    }

    public void setCertFile(String str) {
        this.certFile = str;
    }

    public void setCertPassword(String str) {
        this.certPassword = str;
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public void setCredentialsURI(String str) {
        this.credentialsURI = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setOIDCProviderArn(String str) {
        this.oidcProviderArn = str;
    }

    public void setOIDCTokenFilePath(String str) {
        this.oidcTokenFilePath = str;
    }

    public void setPrivateKeyFile(String str) {
        this.privateKeyFile = str;
    }

    public void setProxy(String str) {
        this.proxy = str;
    }

    public void setPublicKeyId(String str) {
        this.publicKeyId = str;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public void setRoleArn(String str) {
        this.roleArn = str;
    }

    public void setRoleName(String str) {
        this.roleName = str;
    }

    public void setRoleSessionName(String str) {
        this.roleSessionName = str;
    }

    public void setSTSEndpoint(String str) {
        this.STSEndpoint = str;
    }

    public void setSecurityToken(String str) {
        this.securityToken = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
