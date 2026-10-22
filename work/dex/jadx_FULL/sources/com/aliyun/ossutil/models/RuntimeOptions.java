package com.aliyun.ossutil.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RuntimeOptions extends TeaModel {

    @NameInMap("autoretry")
    public boolean autoretry;

    @NameInMap("backoffPeriod")
    public Integer backoffPeriod;

    @NameInMap("backoffPolicy")
    public String backoffPolicy;

    @NameInMap("connectTimeout")
    public Integer connectTimeout;

    @NameInMap("httpProxy")
    public String httpProxy;

    @NameInMap("httpsProxy")
    public String httpsProxy;

    @NameInMap("ignoreSSL")
    public boolean ignoreSSL;

    @NameInMap(ServiceSpecificExtraArgs.CastExtraArgs.f31291a)
    public Object listener;

    @NameInMap("localAddr")
    public String localAddr;

    @NameInMap("maxAttempts")
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

    @NameInMap("uploadLimitSpeed")
    public Integer uploadLimitSpeed;

    public static RuntimeOptions build(Map<String, ?> map) {
        return (RuntimeOptions) TeaModel.build(map, new RuntimeOptions());
    }

    public boolean getAutoretry() {
        return this.autoretry;
    }

    public Integer getBackoffPeriod() {
        return this.backoffPeriod;
    }

    public String getBackoffPolicy() {
        return this.backoffPolicy;
    }

    public Integer getConnectTimeout() {
        return this.connectTimeout;
    }

    public String getHttpProxy() {
        return this.httpProxy;
    }

    public String getHttpsProxy() {
        return this.httpsProxy;
    }

    public boolean getIgnoreSSL() {
        return this.ignoreSSL;
    }

    public Object getListener() {
        return this.listener;
    }

    public String getLocalAddr() {
        return this.localAddr;
    }

    public Integer getMaxAttempts() {
        return this.maxAttempts;
    }

    public Integer getMaxIdleConns() {
        return this.maxIdleConns;
    }

    public String getNoProxy() {
        return this.noProxy;
    }

    public Integer getReadTimeout() {
        return this.readTimeout;
    }

    public String getSocks5NetWork() {
        return this.socks5NetWork;
    }

    public String getSocks5Proxy() {
        return this.socks5Proxy;
    }

    public Integer getUploadLimitSpeed() {
        return this.uploadLimitSpeed;
    }

    public RuntimeOptions setAutoretry(boolean z) {
        this.autoretry = z;
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

    public RuntimeOptions setIgnoreSSL(boolean z) {
        this.ignoreSSL = z;
        return this;
    }

    public RuntimeOptions setListener(Object obj) {
        this.listener = obj;
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

    public RuntimeOptions setUploadLimitSpeed(Integer num) {
        this.uploadLimitSpeed = num;
        return this;
    }
}
