package com.zj.adlib;

import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class te0 {
    public static void a(String str, int i, int i2, float f, float f2) throws IOException {
        float f3 = ((i * 16) / 8) * i2;
        int i3 = (int) (f * f3);
        int i4 = (int) (f3 * f2);
        byte[] bArr = new byte[i3];
        byte[] bArr2 = new byte[i4];
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        randomAccessFile.read(bArr, 0, i3);
        long j = i4;
        randomAccessFile.seek((int) (randomAccessFile.length() - j));
        randomAccessFile.read(bArr2, 0, i4);
        b(bArr);
        c(bArr2);
        randomAccessFile.seek(0L);
        randomAccessFile.write(bArr, 0, i3);
        randomAccessFile.seek((int) (randomAccessFile.length() - j));
        randomAccessFile.write(bArr2, 0, i4);
        randomAccessFile.close();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0022 A[PHI: r5
      0x0022: PHI (r5v7 int) = (r5v3 int), (r5v4 int) binds: [B:6:0x0020, B:9:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    public static void b(byte[] bArr) {
        float length = 1.0f / (bArr.length / 2.0f);
        float f = 0.0f;
        for (int i = 0; i < bArr.length; i += 2) {
            int i2 = i + 1;
            int i3 = (int) (((short) ((bArr[i] & 255) | ((bArr[i2] & 255) << 8))) * f);
            int i4 = 32767;
            if (i3 > 32767) {
                i3 = i4;
            } else {
                i4 = -32768;
                if (i3 < -32768) {
                    i3 = i4;
                }
            }
            bArr[i] = (byte) (i3 & 255);
            bArr[i2] = (byte) ((i3 >>> 8) & 255);
            f += length;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0022 A[PHI: r5
      0x0022: PHI (r5v7 int) = (r5v3 int), (r5v4 int) binds: [B:6:0x0020, B:9:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    public static void c(byte[] bArr) {
        float f = 1.0f;
        float length = 1.0f / (bArr.length / 2.0f);
        for (int i = 0; i < bArr.length; i += 2) {
            int i2 = i + 1;
            int i3 = (int) (((short) ((bArr[i] & 255) | ((bArr[i2] & 255) << 8))) * f);
            int i4 = 32767;
            if (i3 > 32767) {
                i3 = i4;
            } else {
                i4 = -32768;
                if (i3 < -32768) {
                    i3 = i4;
                }
            }
            bArr[i] = (byte) (i3 & 255);
            bArr[i2] = (byte) ((i3 >>> 8) & 255);
            f -= length;
        }
    }
}
