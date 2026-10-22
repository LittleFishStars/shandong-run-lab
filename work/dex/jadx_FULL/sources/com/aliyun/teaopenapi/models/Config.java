package com.aliyun.teaopenapi.models;

import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.aliyun.credentials.Client;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Config extends TeaModel {

    @NameInMap("accessKeyId")
    public String accessKeyId;

    @NameInMap("accessKeySecret")
    public String accessKeySecret;

    @NameInMap("ca")
    public String ca;

    @NameInMap("cert")
    public String cert;

    @NameInMap("connectTimeout")
    public Integer connectTimeout;

    @NameInMap("credential")
    public Client credential;

    @NameInMap("disableHttp2")
    public Boolean disableHttp2;

    @NameInMap("endpoint")
    public String endpoint;

    @NameInMap("endpointType")
    public String endpointType;

    @NameInMap("globalParameters")
    public GlobalParameters globalParameters;

    @NameInMap("httpProxy")
    public String httpProxy;

    @NameInMap("httpsProxy")
    public String httpsProxy;

    @NameInMap(CachedContentIndex.a.e)
    public String key;

    @NameInMap("maxIdleConns")
    public Integer maxIdleConns;

    @NameInMap("method")
    public String method;

    @NameInMap("network")
    public String network;

    @NameInMap("noProxy")
    public String noProxy;

    @NameInMap("openPlatformEndpoint")
    public String openPlatformEndpoint;

    @NameInMap("protocol")
    public String protocol;

    @NameInMap("readTimeout")
    public Integer readTimeout;

    @NameInMap("regionId")
    public String regionId;

    @NameInMap("securityToken")
    public String securityToken;

    @NameInMap("signatureAlgorithm")
    public String signatureAlgorithm;

    @NameInMap("signatureVersion")
    public String signatureVersion;

    @NameInMap("socks5NetWork")
    public String socks5NetWork;

    @NameInMap("socks5Proxy")
    public String socks5Proxy;

    @NameInMap("suffix")
    public String suffix;

    @NameInMap("type")
    @Deprecated
    public String type;

    @NameInMap(TRiverConstants.KEY_ENVIRONMENT_USERAGENT)
    public String userAgent;

    public static Config build(Map<String, ?> map) throws Exception {
        return (Config) TeaModel.build(map, new Config());
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public String getCa() {
        return this.ca;
    }

    public String getCert() {
        return this.cert;
    }

    public Integer getConnectTimeout() {
        return this.connectTimeout;
    }

    public Client getCredential() {
        return this.credential;
    }

    public Boolean getDisableHttp2() {
        return this.disableHttp2;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getEndpointType() {
        return this.endpointType;
    }

    public GlobalParameters getGlobalParameters() {
        return this.globalParameters;
    }

    public String getHttpProxy() {
        return this.httpProxy;
    }

    public String getHttpsProxy() {
        return this.httpsProxy;
    }

    public String getKey() {
        return this.key;
    }

    public Integer getMaxIdleConns() {
        return this.maxIdleConns;
    }

    public String getMethod() {
        return this.method;
    }

    public String getNetwork() {
        return this.network;
    }

    public String getNoProxy() {
        return this.noProxy;
    }

    public String getOpenPlatformEndpoint() {
        return this.openPlatformEndpoint;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public Integer getReadTimeout() {
        return this.readTimeout;
    }

    public String getRegionId() {
        return this.regionId;
    }

    public String getSecurityToken() {
        return this.securityToken;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public String getSignatureVersion() {
        return this.signatureVersion;
    }

    public String getSocks5NetWork() {
        return this.socks5NetWork;
    }

    public String getSocks5Proxy() {
        return this.socks5Proxy;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public String getType() {
        return this.type;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public Config setAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }

    public Config setAccessKeySecret(String str) {
        this.accessKeySecret = str;
        return this;
    }

    public Config setCa(String str) {
        this.ca = str;
        return this;
    }

    public Config setCert(String str) {
        this.cert = str;
        return this;
    }

    public Config setConnectTimeout(Integer num) {
        this.connectTimeout = num;
        return this;
    }

    public Config setCredential(Client client) {
        this.credential = client;
        return this;
    }

    public Config setDisableHttp2(Boolean bool) {
        this.disableHttp2 = bool;
        return this;
    }

    public Config setEndpoint(String str) {
        this.endpoint = str;
        return this;
    }

    public Config setEndpointType(String str) {
        this.endpointType = str;
        return this;
    }

    public Config setGlobalParameters(GlobalParameters globalParameters) {
        this.globalParameters = globalParameters;
        return this;
    }

    public Config setHttpProxy(String str) {
        this.httpProxy = str;
        return this;
    }

    public Config setHttpsProxy(String str) {
        this.httpsProxy = str;
        return this;
    }

    public Config setKey(String str) {
        this.key = str;
        return this;
    }

    public Config setMaxIdleConns(Integer num) {
        this.maxIdleConns = num;
        return this;
    }

    public Config setMethod(String str) {
        this.method = str;
        return this;
    }

    public Config setNetwork(String str) {
        this.network = str;
        return this;
    }

    public Config setNoProxy(String str) {
        this.noProxy = str;
        return this;
    }

    public Config setOpenPlatformEndpoint(String str) {
        this.openPlatformEndpoint = str;
        return this;
    }

    public Config setProtocol(String str) {
        this.protocol = str;
        return this;
    }

    public Config setReadTimeout(Integer num) {
        this.readTimeout = num;
        return this;
    }

    public Config setRegionId(String str) {
        this.regionId = str;
        return this;
    }

    public Config setSecurityToken(String str) {
        this.securityToken = str;
        return this;
    }

    public Config setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
        return this;
    }

    public Config setSignatureVersion(String str) {
        this.signatureVersion = str;
        return this;
    }

    public Config setSocks5NetWork(String str) {
        this.socks5NetWork = str;
        return this;
    }

    public Config setSocks5Proxy(String str) {
        this.socks5Proxy = str;
        return this;
    }

    public Config setSuffix(String str) {
        this.suffix = str;
        return this;
    }

    public Config setType(String str) {
        this.type = str;
        return this;
    }

    public Config setUserAgent(String str) {
        this.userAgent = str;
        return this;
    }
}
