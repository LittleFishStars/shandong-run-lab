package com.baidu.mapauto.auth.util;

import androidx.core.view.MotionEventCompat;
import com.alibaba.ariver.resource.parser.a.e;
import com.google.android.exoplayer2.text.cea.a;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.zj.adlib.aq6;
import com.zj.adlib.xd9;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class Base64Util {
    private static final byte[] MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, aq6.f40585a, 121, 122, e.i, e.j, e.k, e.l, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, a.l, 47};

    private Base64Util() {
    }

    public static byte[] decode(byte[] bArr) {
        return decode(bArr, bArr.length);
    }

    public static byte[] decode(byte[] bArr, int i) {
        byte b;
        int i2;
        int i3 = (i / 4) * 3;
        if (i3 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i3];
        int i4 = i;
        int i5 = 0;
        while (true) {
            byte b2 = bArr[i4 - 1];
            b = 10;
            if (b2 != 10 && b2 != 13 && b2 != 32 && b2 != 9) {
                if (b2 != 61) {
                    break;
                }
                i5++;
            }
            i4--;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i6 < i4) {
            byte b3 = bArr[i6];
            if (b3 != b && b3 != 13 && b3 != 32 && b3 != 9) {
                if (b3 >= 65 && b3 <= 90) {
                    i2 = b3 - 65;
                } else if (b3 >= 97 && b3 <= 122) {
                    i2 = b3 - 71;
                } else if (b3 >= 48 && b3 <= 57) {
                    i2 = b3 + 4;
                } else if (b3 == 43) {
                    i2 = 62;
                } else {
                    if (b3 != 47) {
                        return null;
                    }
                    i2 = 63;
                }
                i8 = ((byte) i2) | (i8 << 6);
                if (i9 % 4 == 3) {
                    int i10 = i7 + 1;
                    bArr2[i7] = (byte) ((16711680 & i8) >> 16);
                    int i11 = i10 + 1;
                    bArr2[i10] = (byte) ((65280 & i8) >> 8);
                    bArr2[i11] = (byte) (i8 & 255);
                    i7 = i11 + 1;
                }
                i9++;
            }
            i6++;
            b = 10;
        }
        if (i5 > 0) {
            int i12 = i8 << (i5 * 6);
            int i13 = i7 + 1;
            bArr2[i7] = (byte) ((i12 & xd9.p) >> 16);
            if (i5 == 1) {
                i7 = i13 + 1;
                bArr2[i13] = (byte) ((i12 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
            } else {
                i7 = i13;
            }
        }
        byte[] bArr3 = new byte[i7];
        System.arraycopy(bArr2, 0, bArr3, 0, i7);
        return bArr3;
    }

    public static String encode(byte[] bArr, String str) throws UnsupportedEncodingException {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[(length / 76) + 3 + length];
        int length2 = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length2; i3 += 3) {
            int i4 = i + 1;
            byte[] bArr3 = MAP;
            bArr2[i] = bArr3[(bArr[i3] & 255) >> 2];
            int i5 = i4 + 1;
            int i6 = i3 + 1;
            bArr2[i4] = bArr3[((bArr[i3] & 3) << 4) | ((bArr[i6] & 255) >> 4)];
            int i7 = i5 + 1;
            int i8 = i3 + 2;
            bArr2[i5] = bArr3[((bArr[i6] & com.google.common.base.a.q) << 2) | ((bArr[i8] & 255) >> 6)];
            i = i7 + 1;
            bArr2[i7] = bArr3[bArr[i8] & 63];
            if ((i - i2) % 76 == 0 && i != 0) {
                bArr2[i] = 10;
                i2++;
                i++;
            }
        }
        int length3 = bArr.length % 3;
        if (length3 == 1) {
            int i9 = i + 1;
            byte[] bArr4 = MAP;
            bArr2[i] = bArr4[(bArr[length2] & 255) >> 2];
            int i10 = i9 + 1;
            bArr2[i9] = bArr4[(bArr[length2] & 3) << 4];
            int i11 = i10 + 1;
            bArr2[i10] = 61;
            i = i11 + 1;
            bArr2[i11] = 61;
        } else if (length3 == 2) {
            int i12 = i + 1;
            byte[] bArr5 = MAP;
            bArr2[i] = bArr5[(bArr[length2] & 255) >> 2];
            int i13 = i12 + 1;
            int i14 = (bArr[length2] & 3) << 4;
            int i15 = length2 + 1;
            bArr2[i12] = bArr5[((bArr[i15] & 255) >> 4) | i14];
            int i16 = i13 + 1;
            bArr2[i13] = bArr5[(bArr[i15] & com.google.common.base.a.q) << 2];
            i = i16 + 1;
            bArr2[i16] = 61;
        }
        return new String(bArr2, 0, i, str);
    }

    public static String encodeWithoutLineFeed(byte[] bArr, String str) throws UnsupportedEncodingException {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[(length / 76) + 3 + length];
        int length2 = bArr.length - (bArr.length % 3);
        int i = 0;
        for (int i2 = 0; i2 < length2; i2 += 3) {
            int i3 = i + 1;
            byte[] bArr3 = MAP;
            bArr2[i] = bArr3[(bArr[i2] & 255) >> 2];
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            bArr2[i3] = bArr3[((bArr[i2] & 3) << 4) | ((bArr[i5] & 255) >> 4)];
            int i6 = i4 + 1;
            int i7 = i2 + 2;
            bArr2[i4] = bArr3[((bArr[i5] & com.google.common.base.a.q) << 2) | ((bArr[i7] & 255) >> 6)];
            i = i6 + 1;
            bArr2[i6] = bArr3[bArr[i7] & 63];
        }
        int length3 = bArr.length % 3;
        if (length3 == 1) {
            int i8 = i + 1;
            byte[] bArr4 = MAP;
            bArr2[i] = bArr4[(bArr[length2] & 255) >> 2];
            int i9 = i8 + 1;
            bArr2[i8] = bArr4[(bArr[length2] & 3) << 4];
            int i10 = i9 + 1;
            bArr2[i9] = 61;
            i = i10 + 1;
            bArr2[i10] = 61;
        } else if (length3 == 2) {
            int i11 = i + 1;
            byte[] bArr5 = MAP;
            bArr2[i] = bArr5[(bArr[length2] & 255) >> 2];
            int i12 = i11 + 1;
            int i13 = (bArr[length2] & 3) << 4;
            int i14 = length2 + 1;
            bArr2[i11] = bArr5[((bArr[i14] & 255) >> 4) | i13];
            int i15 = i12 + 1;
            bArr2[i12] = bArr5[(bArr[i14] & com.google.common.base.a.q) << 2];
            i = i15 + 1;
            bArr2[i15] = 61;
        }
        return new String(bArr2, 0, i, str);
    }
}
