package com.aliyun.credentials.utils;

import com.alipay.sdk.m.p.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Base64Helper {
    private static final String BASE64_CODE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static synchronized String encode(byte[] bArr) {
        StringBuilder sb;
        sb = new StringBuilder("");
        int length = (3 - (bArr.length % 3)) % 3;
        byte[] bArrZeroPad = zeroPad(bArr.length + length, bArr);
        for (int i = 0; i < bArrZeroPad.length; i += 3) {
            int i2 = ((bArrZeroPad[i] & 255) << 16) + ((bArrZeroPad[i + 1] & 255) << 8) + (bArrZeroPad[i + 2] & 255);
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i2 >> 18) & 63));
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i2 >> 12) & 63));
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i2 >> 6) & 63));
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(i2 & 63));
        }
        int length2 = sb.length();
        while (length > 0) {
            sb.setCharAt(length2 - length, a.h);
            length--;
        }
        return sb.toString();
    }

    private static byte[] zeroPad(int i, byte[] bArr) {
        new Base64Helper();
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
