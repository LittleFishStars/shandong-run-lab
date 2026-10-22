package com.baidu.mshield.b.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return c(bArr, bArr2);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return c(bArr, bArr2);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] bArrA = a(bArr2);
        byte[] bArr3 = new byte[bArr.length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte b = bArrA[i];
            i2 = ((b & 255) + i2) & 255;
            bArrA[i] = bArrA[i2];
            bArrA[i2] = b;
            byte b2 = (byte) (bArrA[((bArrA[i] & 255) + (b & 255)) & 255] ^ bArr[i3]);
            bArr3[i3] = b2;
            bArr3[i3] = (byte) (b2 ^ 42);
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = (byte) i;
        }
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int length = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            int i4 = bArr[length] & 255;
            byte b = bArr2[i3];
            i2 = (i4 + (b & 255) + i2) & 255;
            bArr2[i3] = bArr2[i2];
            bArr2[i2] = b;
            length = (length + 1) % bArr.length;
        }
        return bArr2;
    }
}
