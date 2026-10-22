package com.getui.gtc.base.util.io;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Base64InputStream extends InputStream {
    private int[] buffer;
    private int bufferCounter = 0;
    private boolean eof = false;
    private InputStream inputStream;

    public Base64InputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0076 A[PHI: r3
      0x0076: PHI (r3v7 int) = (r3v6 int), (r3v13 int) binds: [B:35:0x005e, B:39:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    private void acquire() throws IOException {
        int i;
        char[] cArr = new char[4];
        int i2 = 0;
        do {
            int i3 = this.inputStream.read();
            if (i3 == -1) {
                if (i2 != 0) {
                    throw new IOException("Bad base64 stream");
                }
                this.buffer = new int[0];
                this.eof = true;
                return;
            }
            char c = (char) i3;
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(c) != -1 || c == '=') {
                cArr[i2] = c;
                i2++;
            } else if (c != '\r' && c != '\n') {
                throw new IOException("Bad base64 stream");
            }
        } while (i2 < 4);
        boolean z = false;
        for (int i4 = 0; i4 < 4; i4++) {
            if (cArr[i4] != '=') {
                if (z) {
                    throw new IOException("Bad base64 stream");
                }
            } else if (!z) {
                z = true;
            }
        }
        int i5 = 3;
        if (cArr[3] == '=') {
            if (this.inputStream.read() != -1) {
                throw new IOException("Bad base64 stream");
            }
            this.eof = true;
            i5 = 2;
            i = cArr[2] != '=' ? i5 : 1;
        }
        int iIndexOf = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            char c2 = cArr[i6];
            if (c2 != '=') {
                iIndexOf |= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(c2) << ((3 - i6) * 6);
            }
        }
        this.buffer = new int[i];
        for (int i7 = 0; i7 < i; i7++) {
            this.buffer[i7] = (iIndexOf >>> ((2 - i7) * 8)) & 255;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inputStream.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int[] iArr = this.buffer;
        if (iArr == null || this.bufferCounter == iArr.length) {
            if (this.eof) {
                return -1;
            }
            acquire();
            if (this.buffer.length == 0) {
                this.buffer = null;
                return -1;
            }
            this.bufferCounter = 0;
        }
        int[] iArr2 = this.buffer;
        int i = this.bufferCounter;
        this.bufferCounter = i + 1;
        return iArr2[i];
    }
}
