package com.alibaba.baichuan.trade.common.network;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HttpException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24557a;
    private String b;
    private HttpResponse c;

    public HttpException(int i, String str) {
        this.f24557a = i;
        this.b = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b;
    }

    public HttpResponse getResponse() {
        return this.c;
    }

    public int getStatusCode() {
        return this.f24557a;
    }

    public HttpException(int i, String str, HttpResponse httpResponse) {
        this.f24557a = i;
        this.b = str;
        this.c = httpResponse;
    }

    public HttpException() {
    }

    public HttpException(String str) {
        this.b = str;
    }
}
