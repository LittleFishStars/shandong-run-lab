package com.getui.gtc.base.util.io;

import com.alipay.sdk.m.p.a;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Base64OutputStream extends OutputStream {
    private int buffer;
    private int bytecounter;
    private int linecounter;
    private int linelength;
    private OutputStream outputStream;

    public Base64OutputStream(OutputStream outputStream) {
        this(outputStream, 76);
    }

    public Base64OutputStream(OutputStream outputStream, int i) {
        this.buffer = 0;
        this.bytecounter = 0;
        this.linecounter = 0;
        this.outputStream = outputStream;
        this.linelength = i;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        commit();
        this.outputStream.close();
    }

    public void commit() throws IOException {
        if (this.bytecounter > 0) {
            int i = this.linelength;
            if (i > 0 && this.linecounter == i) {
                this.outputStream.write("\r\n".getBytes());
                this.linecounter = 0;
            }
            char cCharAt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.buffer << 8) >>> 26);
            char cCharAt2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.buffer << 14) >>> 26);
            int i2 = this.bytecounter;
            char cCharAt3 = a.h;
            char cCharAt4 = i2 < 2 ? '=' : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.buffer << 20) >>> 26);
            if (this.bytecounter >= 3) {
                cCharAt3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.buffer << 26) >>> 26);
            }
            this.outputStream.write(cCharAt);
            this.outputStream.write(cCharAt2);
            this.outputStream.write(cCharAt4);
            this.outputStream.write(cCharAt3);
            this.linecounter += 4;
            this.bytecounter = 0;
            this.buffer = 0;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        int i2 = this.bytecounter;
        this.buffer = ((i & 255) << (16 - (i2 * 8))) | this.buffer;
        int i3 = i2 + 1;
        this.bytecounter = i3;
        if (i3 == 3) {
            commit();
        }
    }
}
