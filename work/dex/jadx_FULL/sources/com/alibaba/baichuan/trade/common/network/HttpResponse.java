package com.alibaba.baichuan.trade.common.network;

import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HttpResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24559a;
    private int b;
    private InputStream c;

    public HttpResponse(String str, int i) {
        this.f24559a = str;
        this.b = i;
    }

    public String getData() {
        return this.f24559a;
    }

    public InputStream getInputStream() {
        return this.c;
    }

    public int getStatusCode() {
        return this.b;
    }

    public void setData(String str) {
        this.f24559a = str;
    }

    public void setInputStream(InputStream inputStream) {
        this.c = inputStream;
    }

    public void setStatusCode(int i) {
        this.b = i;
    }

    public HttpResponse(int i, InputStream inputStream) {
        this.b = i;
        this.c = inputStream;
    }

    public HttpResponse(int i, InputStream inputStream, String str) {
        this(i, inputStream);
        this.f24559a = str;
    }
}
