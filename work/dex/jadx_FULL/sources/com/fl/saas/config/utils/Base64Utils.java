package com.fl.saas.config.utils;

import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.a.e;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Base64Utils {
    private static char[] base64EncodeChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] base64DecodeChars = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, com.google.common.base.a.p, com.google.common.base.a.q, com.google.common.base.a.r, 17, com.google.common.base.a.u, 19, com.google.common.base.a.x, com.google.common.base.a.y, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.B, com.google.common.base.a.C, -1, -1, -1, -1, -1, -1, com.google.common.base.a.D, com.google.common.base.a.E, com.google.common.base.a.F, com.google.common.base.a.G, com.google.common.base.a.H, 31, 32, com.google.android.exoplayer2.text.cea.a.e, 34, 35, 36, com.google.android.exoplayer2.text.cea.a.g, com.google.android.exoplayer2.text.cea.a.h, com.google.android.exoplayer2.text.cea.a.i, MaterialProgressDrawable.c, com.google.android.exoplayer2.text.cea.a.j, 42, com.google.android.exoplayer2.text.cea.a.l, com.google.android.exoplayer2.text.cea.a.m, com.google.android.exoplayer2.text.cea.a.n, com.google.android.exoplayer2.text.cea.a.o, 47, e.i, e.j, e.k, e.l, -1, -1, -1, -1, -1};

    public static byte[] decode(String str) throws UnsupportedEncodingException {
        int i;
        byte b;
        int i2;
        byte b2;
        int i3;
        byte b3;
        int i4;
        byte b4;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.getBytes("US-ASCII");
        int length = bytes.length;
        int i5 = 0;
        loop0: while (i5 < length) {
            while (true) {
                i = i5 + 1;
                b = base64DecodeChars[bytes[i5]];
                if (i >= length || b != -1) {
                    break;
                }
                i5 = i;
            }
            if (b == -1) {
                break;
            }
            while (true) {
                i2 = i + 1;
                b2 = base64DecodeChars[bytes[i]];
                if (i2 >= length || b2 != -1) {
                    break;
                }
                i = i2;
            }
            if (b2 == -1) {
                break;
            }
            stringBuffer.append((char) ((b << 2) | ((b2 & e.i) >>> 4)));
            while (true) {
                i3 = i2 + 1;
                byte b5 = bytes[i2];
                if (b5 == 61) {
                    break loop0;
                }
                b3 = base64DecodeChars[b5];
                if (i3 >= length || b3 != -1) {
                    break;
                }
                i2 = i3;
            }
            if (b3 == -1) {
                break;
            }
            stringBuffer.append((char) (((b2 & com.google.common.base.a.q) << 4) | ((b3 & 60) >>> 2)));
            while (true) {
                i4 = i3 + 1;
                byte b6 = bytes[i3];
                if (b6 == 61) {
                    break loop0;
                }
                b4 = base64DecodeChars[b6];
                if (i4 >= length || b4 != -1) {
                    break;
                }
                i3 = i4;
            }
            if (b4 == -1) {
                break;
            }
            stringBuffer.append((char) (b4 | ((b3 & 3) << 6)));
            i5 = i4;
        }
        return stringBuffer.toString().getBytes("iso8859-1");
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
                stringBuffer.append(base64EncodeChars[i3 >>> 2]);
                stringBuffer.append(base64EncodeChars[(i3 & 3) << 4]);
                str = "==";
            } else {
                int i4 = i2 + 1;
                int i5 = bArr[i2] & 255;
                if (i4 == length) {
                    stringBuffer.append(base64EncodeChars[i3 >>> 2]);
                    stringBuffer.append(base64EncodeChars[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                    stringBuffer.append(base64EncodeChars[(i5 & 15) << 2]);
                    str = "=";
                } else {
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255;
                    stringBuffer.append(base64EncodeChars[i3 >>> 2]);
                    stringBuffer.append(base64EncodeChars[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                    stringBuffer.append(base64EncodeChars[((i5 & 15) << 2) | ((i7 & 192) >>> 6)]);
                    stringBuffer.append(base64EncodeChars[i7 & 63]);
                    i = i6;
                }
            }
            stringBuffer.append(str);
            break;
        }
        return stringBuffer.toString();
    }

    public static String md5(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest((str + str2).getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static byte[] safeUrlBase64Decode(String str) {
        String strReplace = str.replace('-', '+').replace('_', '/');
        int length = strReplace.length() % 4;
        if (length > 0) {
            strReplace = strReplace + "====".substring(length);
        }
        return decode(strReplace);
    }

    public static String safeUrlBase64Encode(byte[] bArr) {
        return encode(bArr).replace('+', '-').replace('/', '_').replaceAll("=", "");
    }
}
