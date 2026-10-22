package com.google.zxing.aztec.decoder;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alipay.sdk.m.y.l;
import com.dinuscxj.progressbar.CircleProgressBar;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.b85;
import com.zj.adlib.bv9;
import com.zj.adlib.c49;
import com.zj.adlib.dd7;
import com.zj.adlib.it3;
import com.zj.adlib.l82;
import com.zj.adlib.o61;
import com.zj.adlib.q82;
import com.zj.adlib.tv0;
import com.zj.adlib.u15;
import com.zj.adlib.wi0;
import com.zj.adlib.y6b;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class Decoder {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wi0 f6722a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f6721a = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] b = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", y6b.f, y6b.g, "i", "j", "k", t.d, "m", "n", j.b, "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", j.o, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] c = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", Constants.COOKIE_SPLIT, "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", b85.b, "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", o61.h, "^", LoginConstants.UNDER_LINE, "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    public static final String[] d = {"FLG(n)", b85.b, "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", c49.f40900a, Consts.DOT, WVNativeCallbackUtil.SEPERATER, u15.f19942b, l.b, "<", "=", ">", "?", "[", "]", bv9.b, "}", "CTRL_UL"};
    public static final String[] e = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", PrepareException.ERROR_AUTH_FAIL, "9", ",", Consts.DOT, "CTRL_UL", "CTRL_US"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f32495a = StandardCharsets.ISO_8859_1;

    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32496a;

        static {
            int[] iArr = new int[Table.values().length];
            f32496a = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32496a[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32496a[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32496a[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32496a[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32497a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean[] f6723a;

        public b(boolean[] zArr, int i) {
            this.f6723a = zArr;
            this.f32497a = i;
        }
    }

    public static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = i(zArr, i * 8);
        }
        return bArr;
    }

    public static String e(Table table, int i) {
        int i2 = a.f32496a[table.ordinal()];
        if (i2 == 1) {
            return f6721a[i];
        }
        if (i2 == 2) {
            return b[i];
        }
        if (i2 == 3) {
            return c[i];
        }
        if (i2 == 4) {
            return d[i];
        }
        if (i2 == 5) {
            return e[i];
        }
        throw new IllegalStateException("Bad table");
    }

    public static String f(boolean[] zArr) throws FormatException {
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb = new StringBuilder((zArr.length - 5) / 4);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Charset charset = f32495a;
        int i = 0;
        Table tableG = table;
        while (i < length) {
            if (table != Table.BINARY) {
                int i2 = table == Table.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int iJ = j(zArr, i, i2);
                i += i2;
                String strE = e(table, iJ);
                if ("FLG(n)".equals(strE)) {
                    if (length - i < 3) {
                        break;
                    }
                    int iJ2 = j(zArr, i, 3);
                    i += 3;
                    try {
                        sb.append(byteArrayOutputStream.toString(charset.name()));
                        byteArrayOutputStream.reset();
                        if (iJ2 == 0) {
                            sb.append(l82.o);
                        } else {
                            if (iJ2 == 7) {
                                throw FormatException.getFormatInstance();
                            }
                            if (length - i >= iJ2 * 4) {
                                int i3 = 0;
                                while (true) {
                                    int i4 = iJ2 - 1;
                                    if (iJ2 <= 0) {
                                        CharacterSetECI characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(i3);
                                        if (characterSetECIByValue == null) {
                                            throw FormatException.getFormatInstance();
                                        }
                                        charset = characterSetECIByValue.getCharset();
                                        break;
                                    }
                                    int iJ3 = j(zArr, i, 4);
                                    i += 4;
                                    if (iJ3 < 2 || iJ3 > 11) {
                                        throw FormatException.getFormatInstance();
                                    }
                                    i3 = (i3 * 10) + (iJ3 - 2);
                                    iJ2 = i4;
                                }
                            }
                        }
                    } catch (UnsupportedEncodingException e2) {
                        throw new IllegalStateException(e2);
                    }
                } else if (strE.startsWith("CTRL_")) {
                    tableG = g(strE.charAt(5));
                    if (strE.charAt(6) != 'L') {
                        tableG = table;
                        table = tableG;
                    }
                } else {
                    byte[] bytes = strE.getBytes(StandardCharsets.US_ASCII);
                    byteArrayOutputStream.write(bytes, 0, bytes.length);
                }
                table = tableG;
            } else {
                if (length - i < 5) {
                    break;
                }
                int iJ4 = j(zArr, i, 5);
                i += 5;
                if (iJ4 == 0) {
                    if (length - i < 11) {
                        break;
                    }
                    iJ4 = j(zArr, i, 11) + 31;
                    i += 11;
                }
                for (int i5 = 0; i5 < iJ4; i5++) {
                    if (length - i < 8) {
                        i = length;
                        break;
                    }
                    byteArrayOutputStream.write((byte) j(zArr, i, 8));
                    i += 8;
                }
                table = tableG;
            }
        }
        try {
            sb.append(byteArrayOutputStream.toString(charset.name()));
            return sb.toString();
        } catch (UnsupportedEncodingException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static Table g(char c2) {
        if (c2 == 'B') {
            return Table.BINARY;
        }
        if (c2 == 'D') {
            return Table.DIGIT;
        }
        if (c2 == 'P') {
            return Table.PUNCT;
        }
        if (c2 != 'L') {
            return c2 != 'M' ? Table.UPPER : Table.MIXED;
        }
        return Table.LOWER;
    }

    public static String h(boolean[] zArr) throws FormatException {
        return f(zArr);
    }

    public static byte i(boolean[] zArr, int i) {
        int length = zArr.length - i;
        return (byte) (length >= 8 ? j(zArr, i, 8) : j(zArr, i, length) << (8 - length));
    }

    public static int j(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    public static int k(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    public final b b(boolean[] zArr) throws FormatException {
        int i;
        it3 it3Var;
        if (this.f6722a.d() <= 2) {
            it3Var = it3.c;
            i = 6;
        } else {
            i = 8;
            if (this.f6722a.d() <= 8) {
                it3Var = it3.g;
            } else if (this.f6722a.d() <= 22) {
                it3Var = it3.b;
                i = 10;
            } else {
                it3Var = it3.f42437a;
                i = 12;
            }
        }
        int iC = this.f6722a.c();
        int length = zArr.length / i;
        if (length < iC) {
            throw FormatException.getFormatInstance();
        }
        int length2 = zArr.length % i;
        int[] iArr = new int[length];
        int i2 = 0;
        while (i2 < length) {
            iArr[i2] = j(zArr, length2, i);
            i2++;
            length2 += i;
        }
        try {
            dd7 dd7Var = new dd7(it3Var);
            int i3 = length - iC;
            dd7Var.a(iArr, i3);
            int i4 = (1 << i) - 1;
            int i5 = 0;
            for (int i6 = 0; i6 < iC; i6++) {
                int i7 = iArr[i6];
                if (i7 == 0 || i7 == i4) {
                    throw FormatException.getFormatInstance();
                }
                if (i7 == 1 || i7 == i4 - 1) {
                    i5++;
                }
            }
            boolean[] zArr2 = new boolean[(iC * i) - i5];
            int i8 = 0;
            for (int i9 = 0; i9 < iC; i9++) {
                int i10 = iArr[i9];
                if (i10 == 1 || i10 == i4 - 1) {
                    Arrays.fill(zArr2, i8, (i8 + i) - 1, i10 > 1);
                    i8 += i - 1;
                } else {
                    int i11 = i - 1;
                    while (i11 >= 0) {
                        int i12 = i8 + 1;
                        zArr2[i8] = ((1 << i11) & i10) != 0;
                        i11--;
                        i8 = i12;
                    }
                }
            }
            return new b(zArr2, (i3 * 100) / length);
        } catch (ReedSolomonException e2) {
            throw FormatException.getFormatInstance(e2);
        }
    }

    public q82 c(wi0 wi0Var) throws FormatException {
        this.f6722a = wi0Var;
        b bVarB = b(d(wi0Var.a()));
        q82 q82Var = new q82(a(bVarB.f6723a), f(bVarB.f6723a), null, String.format(CircleProgressBar.b.f29553a, Integer.valueOf(bVarB.f32497a)));
        q82Var.o(bVarB.f6723a.length);
        return q82Var;
    }

    public final boolean[] d(tv0 tv0Var) {
        boolean zE = this.f6722a.e();
        int iD = this.f6722a.d();
        int i = (zE ? 11 : 14) + (iD * 4);
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[k(iD, zE)];
        int i2 = 2;
        if (zE) {
            for (int i3 = 0; i3 < i; i3++) {
                iArr[i3] = i3;
            }
        } else {
            int i4 = i / 2;
            int i5 = ((i + 1) + (((i4 - 1) / 15) * 2)) / 2;
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = (i6 / 15) + i6;
                iArr[(i4 - i6) - 1] = (i5 - i7) - 1;
                iArr[i4 + i6] = i7 + i5 + 1;
            }
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < iD) {
            int i10 = ((iD - i8) * 4) + (zE ? 9 : 12);
            int i11 = i8 * 2;
            int i12 = (i - 1) - i11;
            int i13 = 0;
            while (i13 < i10) {
                int i14 = i13 * 2;
                int i15 = 0;
                while (i15 < i2) {
                    int i16 = i11 + i15;
                    int i17 = i11 + i13;
                    zArr[i9 + i14 + i15] = tv0Var.k(iArr[i16], iArr[i17]);
                    int i18 = iArr[i17];
                    int i19 = i12 - i15;
                    zArr[(i10 * 2) + i9 + i14 + i15] = tv0Var.k(i18, iArr[i19]);
                    int i20 = i12 - i13;
                    zArr[(i10 * 4) + i9 + i14 + i15] = tv0Var.k(iArr[i19], iArr[i20]);
                    zArr[(i10 * 6) + i9 + i14 + i15] = tv0Var.k(iArr[i20], iArr[i16]);
                    i15++;
                    iD = iD;
                    zE = zE;
                    i2 = 2;
                }
                i13++;
                i2 = 2;
            }
            i9 += i10 * 8;
            i8++;
            i2 = 2;
        }
        return zArr;
    }
}
