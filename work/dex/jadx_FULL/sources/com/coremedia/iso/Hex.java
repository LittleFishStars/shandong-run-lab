package com.coremedia.iso;

import com.google.common.base.a;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Hex {
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte[] decodeHex(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 2;
            byteArrayOutputStream.write(Integer.parseInt(str.substring(i, i2), 16));
            i = i2;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String encodeHex(byte[] bArr) {
        return encodeHex(bArr, 0);
    }

    public static String encodeHex(byte[] bArr, int i) {
        int length = bArr.length;
        char[] cArr = new char[(length << 1) + (i > 0 ? length / i : 0)];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (i > 0 && i3 % i == 0 && i2 > 0) {
                cArr[i2] = '-';
                i2++;
            }
            int i4 = i2 + 1;
            char[] cArr2 = DIGITS;
            byte b = bArr[i3];
            cArr[i2] = cArr2[(b & 240) >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[b & a.q];
        }
        return new String(cArr);
    }
}
