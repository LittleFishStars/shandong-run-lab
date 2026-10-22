package com.igexin.push.f.a;

import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class d extends com.igexin.c.a.d.b {
    public static final String e = "HttpPlugin";
    public String f;
    public byte[] g;
    public InputStream h;
    public long i;
    public boolean j = true;
    public boolean k = true;
    public boolean l = true;
    public boolean m;

    public d(String str) {
        com.igexin.c.a.c.a.a("HttpPluginhttp url:".concat(String.valueOf(str)), new Object[0]);
        this.f = str;
    }

    private void a(InputStream inputStream, long j) {
        this.h = inputStream;
        this.i = j;
    }

    private String b() {
        return this.f;
    }

    private void b(byte[] bArr) {
        this.g = bArr;
    }

    private byte[] d() {
        return this.g;
    }

    private InputStream e() {
        return this.h;
    }

    private long f() {
        return this.i;
    }

    @Override // com.igexin.c.a.d.a.a
    public final void a() {
    }

    public void a(Exception exc) {
    }

    public void a(byte[] bArr) throws Exception {
        this.m = false;
        if (bArr == null) {
            return;
        }
        new String(bArr);
        com.igexin.c.a.c.a.a("HttpPluginhttp:responseData: " + new String(bArr), new Object[0]);
        if (bArr.length >= 7 && bArr[5] == 111 && bArr[6] == 107) {
            this.m = true;
        }
    }
}
