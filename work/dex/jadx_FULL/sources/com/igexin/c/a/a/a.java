package com.igexin.c.a.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37809a = "RC4Carder";

    private static String a() {
        return null;
    }

    private static void a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    private static boolean a(byte[] bArr) {
        int length = bArr.length;
        if (length <= 0 || length > 256) {
            return false;
        }
        int i = 0;
        for (byte b : bArr) {
            if ((b & 255) == 14 && (i = i + 1) > 3) {
                return false;
            }
        }
        return true;
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, str.getBytes());
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (!a(bArr2)) {
            throw new IllegalArgumentException("key is fail!");
        }
        if (bArr.length <= 0) {
            throw new IllegalArgumentException("data is fail!");
        }
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            iArr[i] = i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            i2 = ((i2 + iArr[i3]) + (bArr2[i3 % bArr2.length] & 255)) % 256;
            a(iArr, i3, i2);
        }
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            i4 = (i4 + 1) % 256;
            i5 = (i5 + iArr[i4]) % 256;
            a(iArr, i4, i5);
            bArr3[i6] = (byte) (iArr[(iArr[i4] + iArr[i5]) % 256] ^ bArr[i6]);
        }
        return bArr3;
    }

    public static byte[] b(byte[] bArr, String str) {
        return a(bArr, str.getBytes());
    }
}
