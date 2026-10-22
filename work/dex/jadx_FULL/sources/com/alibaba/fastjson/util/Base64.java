package com.alibaba.fastjson.util;

import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Base64 {
    public static final char[] CA;
    public static final int[] IA;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            IA[CA[i]] = i;
        }
        IA[61] = 0;
    }

    public static byte[] decodeFast(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i6 = (i + i2) - 1;
        while (i < i6 && IA[cArr[i]] < 0) {
            i++;
        }
        while (i6 > 0 && IA[cArr[i6]] < 0) {
            i6--;
        }
        if (cArr[i6] == '=') {
            i3 = cArr[i6 + (-1)] == '=' ? 2 : 1;
        } else {
            i3 = 0;
        }
        int i7 = (i6 - i) + 1;
        if (i2 > 76) {
            i4 = (cArr[76] == '\r' ? i7 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i8 = (((i7 - i4) * 6) >> 3) - i3;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int[] iArr = IA;
            int i12 = i + 1;
            int i13 = i12 + 1;
            int i14 = (iArr[cArr[i]] << 18) | (iArr[cArr[i12]] << 12);
            int i15 = i13 + 1;
            int i16 = i14 | (iArr[cArr[i13]] << 6);
            int i17 = i15 + 1;
            int i18 = i16 | iArr[cArr[i15]];
            int i19 = i10 + 1;
            bArr[i10] = (byte) (i18 >> 16);
            int i20 = i19 + 1;
            bArr[i19] = (byte) (i18 >> 8);
            int i21 = i20 + 1;
            bArr[i20] = (byte) i18;
            if (i4 > 0 && (i11 = i11 + 1) == 19) {
                i17 += 2;
                i11 = 0;
            }
            i = i17;
            i10 = i21;
        }
        if (i10 < i8) {
            int i22 = 0;
            while (i <= i6 - i3) {
                i5 |= IA[cArr[i]] << (18 - (i22 * 6));
                i22++;
                i++;
            }
            int i23 = 16;
            while (i10 < i8) {
                bArr[i10] = (byte) (i5 >> i23);
                i23 -= 8;
                i10++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str, int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i6 = (i + i2) - 1;
        while (i < i6 && IA[str.charAt(i)] < 0) {
            i++;
        }
        while (i6 > 0 && IA[str.charAt(i6)] < 0) {
            i6--;
        }
        if (str.charAt(i6) == '=') {
            i3 = str.charAt(i6 + (-1)) == '=' ? 2 : 1;
        } else {
            i3 = 0;
        }
        int i7 = (i6 - i) + 1;
        if (i2 > 76) {
            i4 = (str.charAt(76) == '\r' ? i7 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i8 = (((i7 - i4) * 6) >> 3) - i3;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int[] iArr = IA;
            int i12 = i + 1;
            int i13 = i12 + 1;
            int i14 = (iArr[str.charAt(i)] << 18) | (iArr[str.charAt(i12)] << 12);
            int i15 = i13 + 1;
            int i16 = i14 | (iArr[str.charAt(i13)] << 6);
            int i17 = i15 + 1;
            int i18 = i16 | iArr[str.charAt(i15)];
            int i19 = i10 + 1;
            bArr[i10] = (byte) (i18 >> 16);
            int i20 = i19 + 1;
            bArr[i19] = (byte) (i18 >> 8);
            int i21 = i20 + 1;
            bArr[i20] = (byte) i18;
            if (i4 > 0 && (i11 = i11 + 1) == 19) {
                i17 += 2;
                i11 = 0;
            }
            i = i17;
            i10 = i21;
        }
        if (i10 < i8) {
            int i22 = 0;
            while (i <= i6 - i3) {
                i5 |= IA[str.charAt(i)] << (18 - (i22 * 6));
                i22++;
                i++;
            }
            int i23 = 16;
            while (i10 < i8) {
                bArr[i10] = (byte) (i5 >> i23);
                i23 -= 8;
                i10++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str) {
        int i;
        int i2;
        int length = str.length();
        int i3 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i4 = length - 1;
        int i5 = 0;
        while (i5 < i4 && IA[str.charAt(i5) & 255] < 0) {
            i5++;
        }
        while (i4 > 0 && IA[str.charAt(i4) & 255] < 0) {
            i4--;
        }
        if (str.charAt(i4) == '=') {
            i = str.charAt(i4 + (-1)) == '=' ? 2 : 1;
        } else {
            i = 0;
        }
        int i6 = (i4 - i5) + 1;
        if (length > 76) {
            i2 = (str.charAt(76) == '\r' ? i6 / 78 : 0) << 1;
        } else {
            i2 = 0;
        }
        int i7 = (((i6 - i2) * 6) >> 3) - i;
        byte[] bArr = new byte[i7];
        int i8 = (i7 / 3) * 3;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int[] iArr = IA;
            int i11 = i5 + 1;
            int i12 = i11 + 1;
            int i13 = (iArr[str.charAt(i5)] << 18) | (iArr[str.charAt(i11)] << 12);
            int i14 = i12 + 1;
            int i15 = i13 | (iArr[str.charAt(i12)] << 6);
            int i16 = i14 + 1;
            int i17 = i15 | iArr[str.charAt(i14)];
            int i18 = i9 + 1;
            bArr[i9] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i17 >> 8);
            int i20 = i19 + 1;
            bArr[i19] = (byte) i17;
            if (i2 > 0 && (i10 = i10 + 1) == 19) {
                i16 += 2;
                i10 = 0;
            }
            i5 = i16;
            i9 = i20;
        }
        if (i9 < i7) {
            int i21 = 0;
            while (i5 <= i4 - i) {
                i3 |= IA[str.charAt(i5)] << (18 - (i21 * 6));
                i21++;
                i5++;
            }
            int i22 = 16;
            while (i9 < i7) {
                bArr[i9] = (byte) (i3 >> i22);
                i22 -= 8;
                i9++;
            }
        }
        return bArr;
    }
}
