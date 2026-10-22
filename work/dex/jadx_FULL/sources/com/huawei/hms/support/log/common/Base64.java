package com.huawei.hms.support.log.common;

import com.alibaba.ariver.resource.parser.a.e;
import com.alipay.sdk.m.p.a;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class Base64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f37666a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', a.h};
    private static final byte[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, com.google.common.base.a.p, com.google.common.base.a.q, com.google.common.base.a.r, 17, com.google.common.base.a.u, 19, com.google.common.base.a.x, com.google.common.base.a.y, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.B, com.google.common.base.a.C, -1, -1, -1, -1, -1, -1, com.google.common.base.a.D, com.google.common.base.a.E, com.google.common.base.a.F, com.google.common.base.a.G, com.google.common.base.a.H, 31, 32, com.google.android.exoplayer2.text.cea.a.e, 34, 35, 36, com.google.android.exoplayer2.text.cea.a.g, com.google.android.exoplayer2.text.cea.a.h, com.google.android.exoplayer2.text.cea.a.i, MaterialProgressDrawable.c, com.google.android.exoplayer2.text.cea.a.j, 42, com.google.android.exoplayer2.text.cea.a.l, com.google.android.exoplayer2.text.cea.a.m, com.google.android.exoplayer2.text.cea.a.n, com.google.android.exoplayer2.text.cea.a.o, 47, e.i, e.j, e.k, e.l, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    private Base64() {
    }

    private static int a(String str) {
        int length = str.length();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt > 255 || b[cCharAt] < 0) {
                length--;
            }
        }
        return length;
    }

    public static byte[] decode(String str) {
        if (str == null) {
            return new byte[0];
        }
        int iA = a(str);
        int i = (iA / 4) * 3;
        int i2 = iA % 4;
        if (i2 == 3) {
            i += 2;
        }
        if (i2 == 2) {
            i++;
        }
        byte[] bArr = new byte[i];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char cCharAt = str.charAt(i6);
            byte b2 = cCharAt > 255 ? (byte) -1 : b[cCharAt];
            if (b2 >= 0) {
                i5 += 6;
                i4 = (i4 << 6) | b2;
                if (i5 >= 8) {
                    i5 -= 8;
                    bArr[i3] = (byte) (255 & (i4 >> i5));
                    i3++;
                }
            }
        }
        return i3 != i ? new byte[0] : bArr;
    }

    public static String encode(byte[] bArr) {
        return bArr == null ? "" : encode(bArr, bArr.length);
    }

    public static String encode(byte[] bArr, int i) {
        boolean z;
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[((i + 2) / 3) * 4];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = (bArr[i2] & 255) << 8;
            int i5 = i2 + 1;
            boolean z2 = true;
            if (i5 < i) {
                i4 |= bArr[i5] & 255;
                z = true;
            } else {
                z = false;
            }
            int i6 = i4 << 8;
            int i7 = i2 + 2;
            if (i7 < i) {
                i6 |= bArr[i7] & 255;
            } else {
                z2 = false;
            }
            int i8 = i3 + 3;
            char[] cArr2 = f37666a;
            int i9 = 64;
            cArr[i8] = cArr2[z2 ? i6 & 63 : 64];
            int i10 = i6 >> 6;
            int i11 = i3 + 2;
            if (z) {
                i9 = i10 & 63;
            }
            cArr[i11] = cArr2[i9];
            int i12 = i10 >> 6;
            cArr[i3 + 1] = cArr2[i12 & 63];
            cArr[i3 + 0] = cArr2[(i12 >> 6) & 63];
            i2 += 3;
            i3 += 4;
        }
        return new String(cArr);
    }
}
