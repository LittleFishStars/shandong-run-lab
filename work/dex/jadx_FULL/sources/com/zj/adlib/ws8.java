package com.zj.adlib;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ws8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45681a = "SJIS";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Charset f20532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final boolean f20533a;
    public static final String b = "GB2312";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Charset f20534b;
    public static final Charset c;
    public static final Charset d;

    static {
        Charset charsetDefaultCharset = Charset.defaultCharset();
        f20532a = charsetDefaultCharset;
        Charset charsetForName = Charset.forName(f45681a);
        f20534b = charsetForName;
        c = Charset.forName(b);
        Charset charsetForName2 = Charset.forName("EUC_JP");
        d = charsetForName2;
        f20533a = charsetForName.equals(charsetDefaultCharset) || charsetForName2.equals(charsetDefaultCharset);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0106  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072 A[PHI: r10
      0x0072: PHI (r10v6 int) = (r10v1 int), (r10v5 int), (r10v1 int) binds: [B:44:0x007d, B:53:0x0096, B:38:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
    public static Charset a(byte[] bArr, Map<DecodeHintType, ?> map) {
        byte b2;
        byte[] bArr2 = bArr;
        if (map != null) {
            DecodeHintType decodeHintType = DecodeHintType.CHARACTER_SET;
            if (map.containsKey(decodeHintType)) {
                return Charset.forName(map.get(decodeHintType).toString());
            }
        }
        boolean z = true;
        int i = 0;
        if (bArr2.length > 2 && (((b2 = bArr2[0]) == -2 && bArr2[1] == -1) || (b2 == -1 && bArr2[1] == -2))) {
            return StandardCharsets.UTF_16;
        }
        int length = bArr2.length;
        boolean z2 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        boolean z3 = true;
        boolean z4 = true;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i3 < length && (z || z3 || z4)) {
            int i13 = bArr2[i3] & 255;
            if (z4) {
                if (i4 > 0) {
                    if ((i13 & 128) == 0) {
                        z4 = false;
                    } else {
                        i4--;
                    }
                } else if ((i13 & 128) != 0) {
                    if ((i13 & 64) == 0) {
                        z4 = false;
                    } else {
                        i4++;
                        if ((i13 & 32) == 0) {
                            i6++;
                        } else {
                            i4++;
                            if ((i13 & 16) == 0) {
                                i7++;
                            } else {
                                i4++;
                                if ((i13 & 8) == 0) {
                                    i8++;
                                } else {
                                    z4 = false;
                                }
                            }
                        }
                    }
                }
            }
            if (z) {
                if (i13 > 127 && i13 < 160) {
                    z = false;
                } else if (i13 > 159 && (i13 < 192 || i13 == 215 || i13 == 247)) {
                    i10++;
                }
            }
            if (z3) {
                if (i5 > 0) {
                    if (i13 < 64 || i13 == 127 || i13 > 252) {
                        z3 = false;
                    } else {
                        i5--;
                    }
                } else if (i13 == 128 || i13 == 160 || i13 > 239) {
                    z3 = false;
                } else if (i13 <= 160 || i13 >= 224) {
                    if (i13 > 127) {
                        i5++;
                        int i14 = i11 + 1;
                        if (i14 > i) {
                            i = i14;
                            i11 = i;
                        } else {
                            i11 = i14;
                        }
                    } else {
                        i11 = 0;
                    }
                    i12 = 0;
                } else {
                    i2++;
                    int i15 = i12 + 1;
                    if (i15 > i9) {
                        i9 = i15;
                        i12 = i9;
                    } else {
                        i12 = i15;
                    }
                    i11 = 0;
                }
            }
            i3++;
            bArr2 = bArr;
        }
        if (z4 && i4 > 0) {
            z4 = false;
        }
        if (z3 && i5 > 0) {
            z3 = false;
        }
        if (z4 && (z2 || i6 + i7 + i8 > 0)) {
            return StandardCharsets.UTF_8;
        }
        if (z3 && (f20533a || i9 >= 3 || i >= 3)) {
            return f20534b;
        }
        if (z && z3) {
            return (!(i9 == 2 && i2 == 2) && i10 * 10 < length) ? StandardCharsets.ISO_8859_1 : f20534b;
        }
        if (z) {
            return StandardCharsets.ISO_8859_1;
        }
        if (z3) {
            return f20534b;
        }
        return z4 ? StandardCharsets.UTF_8 : f20532a;
    }

    public static String b(byte[] bArr, Map<DecodeHintType, ?> map) {
        Charset charsetA = a(bArr, map);
        if (charsetA == f20534b) {
            return f45681a;
        }
        if (charsetA == StandardCharsets.UTF_8) {
            return "UTF8";
        }
        return charsetA == StandardCharsets.ISO_8859_1 ? "ISO8859_1" : charsetA.name();
    }
}
