package com.alipay.android.phone.mrpc.core;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p extends v {
    private int c;
    private String d;
    private long e;
    private long f;
    private String g;
    private HttpUrlHeader h;

    public p(HttpUrlHeader httpUrlHeader, int i, String str, byte[] bArr) {
        this.h = httpUrlHeader;
        this.c = i;
        this.d = str;
        this.f25335a = bArr;
    }

    public HttpUrlHeader a() {
        return this.h;
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(String str) {
        this.g = str;
    }

    public void b(long j) {
        this.f = j;
    }
}
