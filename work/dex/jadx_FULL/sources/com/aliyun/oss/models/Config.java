package com.aliyun.oss.models;

import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Config extends TeaModel {

    @NameInMap("accessKeyId")
    @Validation(required = true)
    public String accessKeyId;

    @NameInMap("accessKeySecret")
    @Validation(required = true)
    public String accessKeySecret;

    @NameInMap("addtionalHeaders")
    public List<String> addtionalHeaders;

    @NameInMap("connectTimeout")
    public Integer connectTimeout;

    @NameInMap("endpoint")
    public String endpoint;

    @NameInMap("hostModel")
    public String hostModel;

    @NameInMap("httpProxy")
    public String httpProxy;

    @NameInMap("httpsProxy")
    public String httpsProxy;

    @NameInMap("isEnableCrc")
    public Boolean isEnableCrc;

    @NameInMap("isEnableMD5")
    public Boolean isEnableMD5;

    @NameInMap("localAddr")
    public String localAddr;

    @NameInMap("maxIdleConns")
    public Integer maxIdleConns;

    @NameInMap("noProxy")
    public String noProxy;

    @NameInMap("protocol")
    public String protocol;

    @NameInMap("readTimeout")
    public Integer readTimeout;

    @NameInMap("regionId")
    @Validation(pattern = "[a-zA-Z0-9-_]+")
    public String regionId;

    @NameInMap("securityToken")
    public String securityToken;

    @NameInMap("signatureVersion")
    public String signatureVersion;

    @NameInMap("socks5NetWork")
    public String socks5NetWork;

    @NameInMap("socks5Proxy")
    public String socks5Proxy;

    @NameInMap("type")
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

    public List<String> getAddtionalHeaders() {
        return this.addtionalHeaders;
    }

    public Integer getConnectTimeout() {
        return this.connectTimeout;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getHostModel() {
        return this.hostModel;
    }

    public String getHttpProxy() {
        return this.httpProxy;
    }

    public String getHttpsProxy() {
        return this.httpsProxy;
    }

    public Boolean getIsEnableCrc() {
        return this.isEnableCrc;
    }

    public Boolean getIsEnableMD5() {
        return this.isEnableMD5;
    }

    public String getLocalAddr() {
        return this.localAddr;
    }

    public Integer getMaxIdleConns() {
        return this.maxIdleConns;
    }

    public String getNoProxy() {
        return this.noProxy;
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

    public String getSignatureVersion() {
        return this.signatureVersion;
    }

    public String getSocks5NetWork() {
        return this.socks5NetWork;
    }

    public String getSocks5Proxy() {
        return this.socks5Proxy;
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

    public Config setAddtionalHeaders(List<String> list) {
        this.addtionalHeaders = list;
        return this;
    }

    public Config setConnectTimeout(Integer num) {
        this.connectTimeout = num;
        return this;
    }

    public Config setEndpoint(String str) {
        this.endpoint = str;
        return this;
    }

    public Config setHostModel(String str) {
        this.hostModel = str;
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

    public Config setIsEnableCrc(Boolean bool) {
        this.isEnableCrc = bool;
        return this;
    }

    public Config setIsEnableMD5(Boolean bool) {
        this.isEnableMD5 = bool;
        return this;
    }

    public Config setLocalAddr(String str) {
        this.localAddr = str;
        return this;
    }

    public Config setMaxIdleConns(Integer num) {
        this.maxIdleConns = num;
        return this;
    }

    public Config setNoProxy(String str) {
        this.noProxy = str;
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

    public Config setType(String str) {
        this.type = str;
        return this;
    }

    public Config setUserAgent(String str) {
        this.userAgent = str;
        return this;
    }
}
