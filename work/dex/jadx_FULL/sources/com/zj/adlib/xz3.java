package com.zj.adlib;

import com.alibaba.ariver.resource.parser.a.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class xz3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f45925a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final char[] f20754a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final char[] b = new char[256];
    public static final char[] c = new char[256];

    static {
        for (int i = 0; i < 256; i++) {
            char[] cArr = b;
            char[] cArr2 = f20754a;
            cArr[i] = cArr2[(i >> 4) & 15];
            c[i] = cArr2[i & 15];
        }
        f45925a = new byte[103];
        for (int i2 = 0; i2 <= 70; i2++) {
            f45925a[i2] = -1;
        }
        for (byte b2 = 0; b2 < 10; b2 = (byte) (b2 + 1)) {
            f45925a[b2 + e.i] = b2;
        }
        for (byte b3 = 0; b3 < 6; b3 = (byte) (b3 + 1)) {
            byte[] bArr = f45925a;
            byte b4 = (byte) (b3 + 10);
            bArr[b3 + 65] = b4;
            bArr[b3 + 97] = b4;
        }
    }

    public static String a(int i) {
        if (i > 255 || i < 0) {
            throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
        }
        return String.valueOf(b[i]) + String.valueOf(c[i]);
    }

    public static byte[] b(String str) {
        byte[] bArr;
        byte b2;
        byte b3;
        int length = str.length();
        if ((length & 1) != 0) {
            throw new IllegalArgumentException("Odd number of characters.");
        }
        byte[] bArr2 = new byte[length >> 1];
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt <= 'f' && (b2 = (bArr = f45925a)[cCharAt]) != -1) {
                int i4 = i3 + 1;
                char cCharAt2 = str.charAt(i3);
                if (cCharAt2 <= 'f' && (b3 = bArr[cCharAt2]) != -1) {
                    bArr2[i2] = (byte) ((b2 << 4) | b3);
                    i2++;
                    i = i4;
                }
            }
            z = true;
            break;
        }
        if (!z) {
            return bArr2;
        }
        throw new IllegalArgumentException("Invalid hexadecimal digit: " + str);
    }

    public static String c(byte[] bArr, boolean z) {
        int i;
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length && ((i = bArr[i3] & 255) != 0 || !z); i3++) {
            int i4 = i2 + 1;
            cArr[i2] = b[i];
            i2 = i4 + 1;
            cArr[i4] = c[i];
        }
        return new String(cArr, 0, i2);
    }

    public static byte[] d(String str) {
        return b(str.replaceAll(" ", ""));
    }
}
