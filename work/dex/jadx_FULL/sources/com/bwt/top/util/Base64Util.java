package com.bwt.top.util;

import com.alibaba.ariver.resource.parser.a.e;
import com.google.common.base.a;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Base64Util {
    private static final char[] base64EncodeChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] base64DecodeChars = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, a.p, a.q, a.r, 17, a.u, 19, a.x, a.y, a.z, a.A, a.B, a.C, -1, -1, -1, -1, -1, -1, a.D, a.E, a.F, a.G, a.H, 31, 32, com.google.android.exoplayer2.text.cea.a.e, 34, 35, 36, com.google.android.exoplayer2.text.cea.a.g, com.google.android.exoplayer2.text.cea.a.h, com.google.android.exoplayer2.text.cea.a.i, MaterialProgressDrawable.c, com.google.android.exoplayer2.text.cea.a.j, 42, com.google.android.exoplayer2.text.cea.a.l, com.google.android.exoplayer2.text.cea.a.m, com.google.android.exoplayer2.text.cea.a.n, com.google.android.exoplayer2.text.cea.a.o, 47, e.i, e.j, e.k, e.l, -1, -1, -1, -1, -1};

    private Base64Util() {
    }

    public static byte[] decode(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        int i = 0;
        while (i < length) {
            byte b = -1;
            while (i < length && b == -1) {
                b = base64DecodeChars[bytes[i]];
                i++;
            }
            if (b == -1) {
                break;
            }
            byte b2 = -1;
            while (i < length && b2 == -1) {
                b2 = base64DecodeChars[bytes[i]];
                i++;
            }
            if (b2 == -1) {
                break;
            }
            byteArrayOutputStream.write((b << 2) | ((b2 & e.i) >>> 4));
            byte b3 = -1;
            while (i < length && b3 == -1) {
                int i2 = i + 1;
                byte b4 = bytes[i];
                if (b4 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b3 = base64DecodeChars[b4];
                i = i2;
            }
            if (b3 == -1) {
                break;
            }
            byteArrayOutputStream.write(((b2 & a.q) << 4) | ((b3 & 60) >>> 2));
            byte b5 = -1;
            while (i < length && b5 == -1) {
                int i3 = i + 1;
                byte b6 = bytes[i];
                if (b6 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b5 = base64DecodeChars[b6];
                i = i3;
            }
            if (b5 == -1) {
                break;
            }
            byteArrayOutputStream.write(((b3 & 3) << 6) | b5);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String encode(byte[] bArr) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                char[] cArr = base64EncodeChars;
                stringBuffer.append(cArr[i3 >>> 2]);
                stringBuffer.append(cArr[(i3 & 3) << 4]);
                str = "==";
            } else {
                int i4 = i2 + 1;
                int i5 = bArr[i2] & 255;
                if (i4 == length) {
                    char[] cArr2 = base64EncodeChars;
                    stringBuffer.append(cArr2[i3 >>> 2]);
                    stringBuffer.append(cArr2[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                    stringBuffer.append(cArr2[(i5 & 15) << 2]);
                    str = "=";
                } else {
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255;
                    char[] cArr3 = base64EncodeChars;
                    stringBuffer.append(cArr3[i3 >>> 2]);
                    stringBuffer.append(cArr3[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                    stringBuffer.append(cArr3[((i5 & 15) << 2) | ((i7 & 192) >>> 6)]);
                    stringBuffer.append(cArr3[i7 & 63]);
                    i = i6;
                }
            }
            stringBuffer.append(str);
            break;
        }
        return stringBuffer.toString();
    }
}
