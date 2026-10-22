package com.zj.adlib;

import com.alibaba.ariver.resource.parser.a.e;
import com.google.android.exoplayer2.text.cea.a;
import com.google.zxing.FormatException;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class l82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f43014a = 65520;
    public static final char b = 65521;
    public static final char c = 65522;
    public static final char d = 65523;
    public static final char e = 65524;
    public static final char f = 65525;
    public static final char g = 65526;
    public static final char h = 65527;
    public static final char i = 65528;
    public static final char j = 65529;
    public static final char k = 65530;
    public static final char l = 65531;
    public static final char m = 65532;
    public static final char n = 28;
    public static final char o = 29;
    public static final char p = 30;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f17900a = {e.n, e.o, a.l, a.m, a.n, a.o, 47, e.i, a.g, a.h};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final byte[] f17903b = {e.p, MaterialProgressDrawable.d, 57, 58, 59, 60, e.j, e.k, e.l, e.m};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final byte[] f17904c = {a.i, MaterialProgressDrawable.c, a.j, 42, 31, 32};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final byte[] f17905d = {a.e, 34, 35, 36, com.google.common.base.a.C, com.google.common.base.a.D, com.google.common.base.a.E, com.google.common.base.a.F, com.google.common.base.a.G, com.google.common.base.a.H, 19, com.google.common.base.a.x, com.google.common.base.a.y, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.B, 13, com.google.common.base.a.p, com.google.common.base.a.q, com.google.common.base.a.r, 17, com.google.common.base.a.u, 7, 8, 9, 10, 11, 12, 1, 2};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[][] f17902a = {new byte[]{a.i, MaterialProgressDrawable.c, a.j, 42, 31, 32}, new byte[]{a.e, 34, 35, 36, com.google.common.base.a.C, com.google.common.base.a.D}, new byte[]{com.google.common.base.a.E, com.google.common.base.a.F, com.google.common.base.a.G, com.google.common.base.a.H, 19, com.google.common.base.a.x}, new byte[]{com.google.common.base.a.y, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.B, 13, com.google.common.base.a.p}, new byte[]{com.google.common.base.a.q, com.google.common.base.a.r, 17, com.google.common.base.a.u, 7, 8}, new byte[]{9, 10, 11, 12, 1, 2}};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f17901a = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001e\ufffbÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8"};

    public static q82 a(byte[] bArr, int i2) throws FormatException {
        String strH;
        StringBuilder sb = new StringBuilder(144);
        if (i2 == 2 || i2 == 3) {
            if (i2 == 2) {
                int iF = f(bArr);
                int iG = g(bArr);
                if (iG > 10) {
                    throw FormatException.getFormatInstance();
                }
                strH = new DecimalFormat("0000000000".substring(0, iG)).format(iF);
            } else {
                strH = h(bArr);
            }
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String str = decimalFormat.format(c(bArr));
            String str2 = decimalFormat.format(i(bArr));
            sb.append(e(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, strH + o + str + o + str2 + o);
            } else {
                sb.insert(0, strH + o + str + o + str2 + o);
            }
        } else if (i2 == 4) {
            sb.append(e(bArr, 1, 93));
        } else if (i2 == 5) {
            sb.append(e(bArr, 1, 77));
        }
        return new q82(bArr, sb.toString(), null, String.valueOf(i2));
    }

    public static int b(int i2, byte[] bArr) {
        int i3 = i2 - 1;
        return ((1 << (5 - (i3 % 6))) & bArr[i3 / 6]) == 0 ? 0 : 1;
    }

    public static int c(byte[] bArr) {
        return d(bArr, f17900a);
    }

    public static int d(byte[] bArr, byte[] bArr2) {
        int iB = 0;
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            iB += b(bArr2[i2], bArr) << ((bArr2.length - i2) - 1);
        }
        return iB;
    }

    public static String e(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        int i4 = i2;
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        while (i4 < i2 + i3) {
            char cCharAt = f17901a[i6].charAt(bArr[i4]);
            switch (cCharAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i7 = i6;
                    i6 = cCharAt - f43014a;
                    i5 = 1;
                    break;
                case 65525:
                    i5 = 2;
                    i7 = i6;
                    i6 = 0;
                    break;
                case 65526:
                    i5 = 3;
                    i7 = i6;
                    i6 = 0;
                    break;
                case 65527:
                    i5 = -1;
                    i6 = 0;
                    break;
                case 65528:
                    i5 = -1;
                    i6 = 1;
                    break;
                case 65529:
                    i5 = -1;
                    break;
                case 65530:
                default:
                    sb.append(cCharAt);
                    break;
                case 65531:
                    int i8 = i4 + 1;
                    int i9 = bArr[i8] << com.google.common.base.a.B;
                    int i10 = i8 + 1;
                    int i11 = i9 + (bArr[i10] << com.google.common.base.a.u);
                    int i12 = i10 + 1;
                    int i13 = i11 + (bArr[i12] << 12);
                    int i14 = i12 + 1;
                    int i15 = i13 + (bArr[i14] << 6);
                    i4 = i14 + 1;
                    sb.append(new DecimalFormat("000000000").format(i15 + bArr[i4]));
                    break;
            }
            int i16 = i5 - 1;
            if (i5 == 0) {
                i6 = i7;
            }
            i4++;
            i5 = i16;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 65532) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static int f(byte[] bArr) {
        return d(bArr, f17905d);
    }

    public static int g(byte[] bArr) {
        return d(bArr, f17904c);
    }

    public static String h(byte[] bArr) {
        byte[][] bArr2 = f17902a;
        StringBuilder sb = new StringBuilder(bArr2.length);
        for (byte[] bArr3 : bArr2) {
            sb.append(f17901a[0].charAt(d(bArr, bArr3)));
        }
        return sb.toString();
    }

    public static int i(byte[] bArr) {
        return d(bArr, f17903b);
    }
}
