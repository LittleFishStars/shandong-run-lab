package com.aliyun.credentials.models;

import com.alipay.sdk.m.n.c;
import com.aliyun.credentials.exception.CredentialException;
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Config extends TeaModel {

    @NameInMap("accessKeyId")
    public String accessKeyId;

    @NameInMap("accessKeySecret")
    public String accessKeySecret;

    @NameInMap("bearerToken")
    public String bearerToken;

    @NameInMap("credentialsURI")
    public String credentialsURI;

    @NameInMap("externalId")
    public String externalId;

    @NameInMap(c.f)
    public String host;

    @NameInMap("oidcProviderArn")
    public String oidcProviderArn;

    @NameInMap("oidcTokenFilePath")
    public String oidcTokenFilePath;

    @NameInMap(AuthConstant.INI_POLICY)
    public String policy;

    @NameInMap("privateKeyFile")
    public String privateKeyFile;

    @NameInMap("proxy")
    public String proxy;

    @NameInMap("publicKeyId")
    public String publicKeyId;

    @NameInMap("roleArn")
    public String roleArn;

    @NameInMap("roleName")
    public String roleName;

    @NameInMap("roleSessionName")
    public String roleSessionName;

    @NameInMap("securityToken")
    public String securityToken;

    @NameInMap("type")
    public String type = "default";

    @NameInMap("readTimeout")
    public int timeout = 1000;

    @NameInMap("connectTimeout")
    public int connectTimeout = 1000;

    @NameInMap("roleSessionExpiration")
    public Integer roleSessionExpiration = 3600;

    @NameInMap("STSEndpoint")
    public String STSEndpoint = "sts.aliyuncs.com";

    public static Config build(Map<String, ?> map) {
        try {
            return (Config) TeaModel.build(map, new Config());
        } catch (Exception e) {
            throw new CredentialException(e.getMessage(), e);
        }
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public String getBearerToken() {
        return this.bearerToken;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public String getCredentialsUri() {
        return this.credentialsURI;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getHost() {
        return this.host;
    }

    public String getOidcProviderArn() {
        return this.oidcProviderArn;
    }

    public String getOidcTokenFilePath() {
        return this.oidcTokenFilePath;
    }

    public String getPolicy() {
        return this.policy;
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

    public String getRoleArn() {
        return this.roleArn;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public Number getRoleSessionExpiration() {
        return this.roleSessionExpiration;
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

    public int getTimeout() {
        return this.timeout;
    }

    public String getType() {
        return this.type;
    }

    public Config setAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }

    public Config setAccessKeySecret(String str) {
        this.accessKeySecret = str;
        return this;
    }

    public Config setBearerToken(String str) {
        this.bearerToken = str;
        return this;
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public Config setCredentialsUri(String str) {
        this.credentialsURI = str;
        return this;
    }

    public Config setExternalId(String str) {
        this.externalId = str;
        return this;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setOidcProviderArn(String str) {
        this.oidcProviderArn = str;
    }

    public void setOidcTokenFilePath(String str) {
        this.oidcTokenFilePath = str;
    }

    public Config setPolicy(String str) {
        this.policy = str;
        return this;
    }

    public Config setPrivateKeyFile(String str) {
        this.privateKeyFile = str;
        return this;
    }

    public void setProxy(String str) {
        this.proxy = str;
    }

    public Config setPublicKeyId(String str) {
        this.publicKeyId = str;
        return this;
    }

    public Config setRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public Config setRoleName(String str) {
        this.roleName = str;
        return this;
    }

    public Config setRoleSessionExpiration(Integer num) {
        this.roleSessionExpiration = num;
        return this;
    }

    public Config setRoleSessionName(String str) {
        this.roleSessionName = str;
        return this;
    }

    public Config setSTSEndpoint(String str) {
        this.STSEndpoint = str;
        return this;
    }

    public Config setSecurityToken(String str) {
        this.securityToken = str;
        return this;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public Config setType(String str) {
        this.type = str;
        return this;
    }
}
