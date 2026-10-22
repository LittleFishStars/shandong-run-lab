package com.igexin.c.a.b;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OutputStream f37826a;
    private int b;
    private int c;
    private int d;
    private int e;

    private b(OutputStream outputStream) {
        this(outputStream, 76);
    }

    public b(OutputStream outputStream, int i) {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.f37826a = outputStream;
        this.e = i;
    }

    public final void a() throws IOException {
        if (this.c > 0) {
            int i = this.e;
            if (i > 0 && this.d == i) {
                this.f37826a.write("\r\n".getBytes());
                this.d = 0;
            }
            char cCharAt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 8) >>> 26);
            char cCharAt2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 14) >>> 26);
            int i2 = this.c;
            char cCharAt3 = com.alipay.sdk.m.p.a.h;
            char cCharAt4 = i2 < 2 ? '=' : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 20) >>> 26);
            if (this.c >= 3) {
                cCharAt3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 26) >>> 26);
            }
            this.f37826a.write(cCharAt);
            this.f37826a.write(cCharAt2);
            this.f37826a.write(cCharAt4);
            this.f37826a.write(cCharAt3);
            this.d += 4;
            this.c = 0;
            this.b = 0;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a();
        this.f37826a.close();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        int i2 = this.c;
        this.b = ((i & 255) << (16 - (i2 * 8))) | this.b;
        int i3 = i2 + 1;
        this.c = i3;
        if (i3 == 3) {
            a();
        }
    }
}
