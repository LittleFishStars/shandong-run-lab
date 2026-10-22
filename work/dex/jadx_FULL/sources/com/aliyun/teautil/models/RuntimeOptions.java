package com.aliyun.teautil.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RuntimeOptions extends TeaModel {

    @NameInMap("backoff_period")
    public Integer backoffPeriod;

    @NameInMap("backoff_policy")
    public String backoffPolicy;

    @NameInMap("ca")
    public String ca;

    @NameInMap("cert")
    public String cert;

    @NameInMap("connectTimeout")
    public Integer connectTimeout;

    @NameInMap("httpProxy")
    public String httpProxy;

    @NameInMap("httpsProxy")
    public String httpsProxy;

    @NameInMap("keepAlive")
    public Boolean keepAlive;

    @NameInMap(CachedContentIndex.a.e)
    public String key;

    @NameInMap("localAddr")
    public String localAddr;

    @NameInMap("max_attempts")
    public Integer maxAttempts;

    @NameInMap("maxIdleConns")
    public Integer maxIdleConns;

    @NameInMap("noProxy")
    public String noProxy;

    @NameInMap("readTimeout")
    public Integer readTimeout;

    @NameInMap("socks5NetWork")
    public String socks5NetWork;

    @NameInMap("socks5Proxy")
    public String socks5Proxy;

    @NameInMap("autoretry")
    public Boolean autoretry = Boolean.FALSE;

    @NameInMap("ignoreSSL")
    public Boolean ignoreSSL = Boolean.TRUE;

    public static RuntimeOptions build(Map<String, ?> map) throws Exception {
        return (RuntimeOptions) TeaModel.build(map, new RuntimeOptions());
    }

    public Boolean getAutoretry() {
        return this.autoretry;
    }

    public Number getBackoffPeriod() {
        return this.backoffPeriod;
    }

    public String getBackoffPolicy() {
        return this.backoffPolicy;
    }

    public String getCa() {
        return this.ca;
    }

    public String getCert() {
        return this.cert;
    }

    public Number getConnectTimeout() {
        return this.connectTimeout;
    }

    public String getHttpProxy() {
        return this.httpProxy;
    }

    public String getHttpsProxy() {
        return this.httpsProxy;
    }

    public Boolean getIgnoreSSL() {
        return this.ignoreSSL;
    }

    public Boolean getKeepAlive() {
        return this.keepAlive;
    }

    public String getKey() {
        return this.key;
    }

    public String getLocalAddr() {
        return this.localAddr;
    }

    public Number getMaxAttempts() {
        return this.maxAttempts;
    }

    public Number getMaxIdleConns() {
        return this.maxIdleConns;
    }

    public String getNoProxy() {
        return this.noProxy;
    }

    public Number getReadTimeout() {
        return this.readTimeout;
    }

    public String getSocks5NetWork() {
        return this.socks5NetWork;
    }

    public String getSocks5Proxy() {
        return this.socks5Proxy;
    }

    public RuntimeOptions setAutoretry(Boolean bool) {
        this.autoretry = bool;
        return this;
    }

    public RuntimeOptions setBackoffPeriod(Integer num) {
        this.backoffPeriod = num;
        return this;
    }

    public RuntimeOptions setBackoffPolicy(String str) {
        this.backoffPolicy = str;
        return this;
    }

    public RuntimeOptions setCa(String str) {
        this.ca = str;
        return this;
    }

    public RuntimeOptions setCert(String str) {
        this.cert = str;
        return this;
    }

    public RuntimeOptions setConnectTimeout(Integer num) {
        this.connectTimeout = num;
        return this;
    }

    public RuntimeOptions setHttpProxy(String str) {
        this.httpProxy = str;
        return this;
    }

    public RuntimeOptions setHttpsProxy(String str) {
        this.httpsProxy = str;
        return this;
    }

    public RuntimeOptions setIgnoreSSL(Boolean bool) {
        this.ignoreSSL = bool;
        return this;
    }

    public RuntimeOptions setKeepAlive(Boolean bool) {
        this.keepAlive = bool;
        return this;
    }

    public RuntimeOptions setKey(String str) {
        this.key = str;
        return this;
    }

    public RuntimeOptions setLocalAddr(String str) {
        this.localAddr = str;
        return this;
    }

    public RuntimeOptions setMaxAttempts(Integer num) {
        this.maxAttempts = num;
        return this;
    }

    public RuntimeOptions setMaxIdleConns(Integer num) {
        this.maxIdleConns = num;
        return this;
    }

    public RuntimeOptions setNoProxy(String str) {
        this.noProxy = str;
        return this;
    }

    public RuntimeOptions setReadTimeout(Integer num) {
        this.readTimeout = num;
        return this;
    }

    public RuntimeOptions setSocks5NetWork(String str) {
        this.socks5NetWork = str;
        return this;
    }

    public RuntimeOptions setSocks5Proxy(String str) {
        this.socks5Proxy = str;
        return this;
    }
}
