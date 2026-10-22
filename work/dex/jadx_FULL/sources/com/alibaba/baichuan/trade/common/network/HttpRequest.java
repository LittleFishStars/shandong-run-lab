package com.alibaba.baichuan.trade.common.network;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HttpRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RetryPolicy f24558a;
    private String b;
    private Map<String, String> c;
    private boolean d = false;

    public HttpRequest(RetryPolicy retryPolicy, String str, Map<String, String> map) {
        this.f24558a = retryPolicy;
        this.b = str;
        this.c = map;
    }

    public Map<String, String> getParams() {
        return this.c;
    }

    public RetryPolicy getRetryPolicy() {
        return this.f24558a;
    }

    public String getUrl() {
        return this.b;
    }

    public boolean isShouldRetryServerError() {
        return this.d;
    }

    public void setParams(Map<String, String> map) {
        this.c = map;
    }

    public void setRetryPolicy(RetryPolicy retryPolicy) {
        this.f24558a = retryPolicy;
    }

    public void setShouldRetryServerError(boolean z) {
        this.d = z;
    }

    public void setUrl(String str) {
        this.b = str;
    }
}
