package com.fl.saas;

import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.io.UnsupportedEncodingException;

/* JADX INFO: renamed from: com.fl.saas.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1421m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static char[] f30184a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.o, com.alibaba.ariver.resource.parser.a.e.p, MaterialProgressDrawable.d, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, com.google.common.base.a.p, com.google.common.base.a.q, com.google.common.base.a.r, 17, com.google.common.base.a.u, 19, com.google.common.base.a.x, com.google.common.base.a.y, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.B, com.google.common.base.a.C, -1, -1, -1, -1, -1, -1, com.google.common.base.a.D, com.google.common.base.a.E, com.google.common.base.a.F, com.google.common.base.a.G, com.google.common.base.a.H, 31, 32, com.google.android.exoplayer2.text.cea.a.e, 34, 35, 36, com.google.android.exoplayer2.text.cea.a.g, com.google.android.exoplayer2.text.cea.a.h, com.google.android.exoplayer2.text.cea.a.i, MaterialProgressDrawable.c, com.google.android.exoplayer2.text.cea.a.j, 42, com.google.android.exoplayer2.text.cea.a.l, com.google.android.exoplayer2.text.cea.a.m, com.google.android.exoplayer2.text.cea.a.n, com.google.android.exoplayer2.text.cea.a.o, 47, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.l, -1, -1, -1, -1, -1};

    public static byte[] a(String str) throws UnsupportedEncodingException {
        int i;
        byte b2;
        int i2;
        byte b3;
        int i3;
        byte b4;
        int i4;
        byte b5;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.getBytes("US-ASCII");
        int length = bytes.length;
        int i5 = 0;
        loop0: while (i5 < length) {
            while (true) {
                i = i5 + 1;
                b2 = b[bytes[i5]];
                if (i >= length || b2 != -1) {
                    break;
                }
                i5 = i;
            }
            if (b2 == -1) {
                break;
            }
            while (true) {
                i2 = i + 1;
                b3 = b[bytes[i]];
                if (i2 >= length || b3 != -1) {
                    break;
                }
                i = i2;
            }
            if (b3 == -1) {
                break;
            }
            stringBuffer.append((char) ((b2 << 2) | ((b3 & com.alibaba.ariver.resource.parser.a.e.i) >>> 4)));
            while (true) {
                i3 = i2 + 1;
                byte b6 = bytes[i2];
                if (b6 == 61) {
                    break loop0;
                }
                b4 = b[b6];
                if (i3 >= length || b4 != -1) {
                    break;
                }
                i2 = i3;
            }
            if (b4 == -1) {
                break;
            }
            stringBuffer.append((char) (((b3 & com.google.common.base.a.q) << 4) | ((b4 & 60) >>> 2)));
            while (true) {
                i4 = i3 + 1;
                byte b7 = bytes[i3];
                if (b7 == 61) {
                    break loop0;
                }
                b5 = b[b7];
                if (i4 >= length || b5 != -1) {
                    break;
                }
                i3 = i4;
            }
            if (b5 == -1) {
                break;
            }
            stringBuffer.append((char) (b5 | ((b4 & 3) << 6)));
            i5 = i4;
        }
        return stringBuffer.toString().getBytes("iso8859-1");
    }

    public static byte[] b(String str) {
        String strReplace = str.replace('-', '+').replace('_', '/');
        int length = strReplace.length() % 4;
        if (length > 0) {
            strReplace = strReplace + "====".substring(length);
        }
        return a(strReplace);
    }

    public static String a(byte[] bArr) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            byte b2 = bArr[i];
            int i3 = b2 & 255;
            if (i2 == length) {
                stringBuffer.append(f30184a[i3 >>> 2]);
                stringBuffer.append(f30184a[(b2 & 3) << 4]);
                str = "==";
            } else {
                int i4 = i + 2;
                byte b3 = bArr[i2];
                if (i4 == length) {
                    stringBuffer.append(f30184a[i3 >>> 2]);
                    stringBuffer.append(f30184a[((b2 & 3) << 4) | ((b3 & 240) >>> 4)]);
                    stringBuffer.append(f30184a[(b3 & com.google.common.base.a.q) << 2]);
                    str = "=";
                } else {
                    i += 3;
                    byte b4 = bArr[i4];
                    stringBuffer.append(f30184a[i3 >>> 2]);
                    stringBuffer.append(f30184a[((b2 & 3) << 4) | ((b3 & 240) >>> 4)]);
                    stringBuffer.append(f30184a[((b3 & com.google.common.base.a.q) << 2) | ((b4 & com.ipd.dsp.internal.q.u.n7) >>> 6)]);
                    stringBuffer.append(f30184a[b4 & 63]);
                }
            }
            stringBuffer.append(str);
            break;
        }
        return stringBuffer.toString();
    }

    public static String b(byte[] bArr) {
        return a(bArr).replace('+', '-').replace('/', '_').replaceAll("=", "");
    }
}
