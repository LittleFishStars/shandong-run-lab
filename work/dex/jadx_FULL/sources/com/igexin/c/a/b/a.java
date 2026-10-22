package com.igexin.c.a.b;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InputStream f37810a;
    private int[] b;
    private int c = 0;
    private boolean d = false;

    public a(InputStream inputStream) {
        this.f37810a = inputStream;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0076 A[PHI: r3
      0x0076: PHI (r3v7 int) = (r3v6 int), (r3v13 int) binds: [B:35:0x005e, B:39:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    private void a() throws IOException {
        int i;
        char[] cArr = new char[4];
        int i2 = 0;
        do {
            int i3 = this.f37810a.read();
            if (i3 == -1) {
                if (i2 != 0) {
                    throw new IOException("Bad base64 stream");
                }
                this.b = new int[0];
                this.d = true;
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
            if (this.f37810a.read() != -1) {
                throw new IOException("Bad base64 stream");
            }
            this.d = true;
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
        this.b = new int[i];
        for (int i7 = 0; i7 < i; i7++) {
            this.b[i7] = (iIndexOf >>> ((2 - i7) * 8)) & 255;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f37810a.close();
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0085 A[PHI: r4
      0x0085: PHI (r4v7 int) = (r4v6 int), (r4v17 int) binds: [B:41:0x006d, B:45:0x007c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.io.InputStream
    public final int read() throws IOException {
        int i;
        int[] iArr = this.b;
        if (iArr == null || this.c == iArr.length) {
            if (this.d) {
                return -1;
            }
            char[] cArr = new char[4];
            int i2 = 0;
            while (true) {
                int i3 = this.f37810a.read();
                if (i3 == -1) {
                    if (i2 != 0) {
                        throw new IOException("Bad base64 stream");
                    }
                    this.b = new int[0];
                    this.d = true;
                    break;
                }
                char c = (char) i3;
                if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(c) != -1 || c == '=') {
                    cArr[i2] = c;
                    i2++;
                } else if (c != '\r' && c != '\n') {
                    throw new IOException("Bad base64 stream");
                }
                if (i2 >= 4) {
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
                        if (this.f37810a.read() != -1) {
                            throw new IOException("Bad base64 stream");
                        }
                        this.d = true;
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
                    this.b = new int[i];
                    for (int i7 = 0; i7 < i; i7++) {
                        this.b[i7] = (iIndexOf >>> ((2 - i7) * 8)) & 255;
                    }
                    break;
                }
            }
            if (this.b.length == 0) {
                this.b = null;
                return -1;
            }
            this.c = 0;
        }
        int[] iArr2 = this.b;
        int i8 = this.c;
        this.c = i8 + 1;
        return iArr2[i8];
    }
}
