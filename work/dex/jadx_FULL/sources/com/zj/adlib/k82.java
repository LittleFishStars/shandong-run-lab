package com.zj.adlib;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class k82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42760a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final char[] f17604a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42761a;

        static {
            int[] iArr = new int[Mode.values().length];
            f42761a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42761a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f42761a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f42761a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f42761a[Mode.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f42761a[Mode.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f42761a[Mode.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f42761a[Mode.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f42761a[Mode.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f42761a[Mode.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:41:0x00ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:48:0x0100 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0102  */
    /* JADX WARN: Code duplicated, block: B:51:0x0105  */
    /* JADX WARN: Code duplicated, block: B:54:0x0112  */
    /* JADX WARN: Code duplicated, block: B:55:0x0114  */
    /* JADX WARN: Code duplicated, block: B:58:0x0118  */
    /* JADX WARN: Code duplicated, block: B:61:0x0129 A[LOOP:0: B:64:0x0022->B:61:0x0129, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v5 */
    public static q82 a(byte[] bArr, lm9 lm9Var, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        ?? r13;
        int i2;
        int i3;
        ArrayList arrayList;
        wv0 wv0Var = new wv0(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i4 = 1;
        ArrayList arrayList2 = new ArrayList(1);
        boolean z5 = 0;
        boolean z6 = false;
        boolean z7 = false;
        int i5 = -1;
        int iD = -1;
        CharacterSetECI characterSetECIByValue = null;
        while (true) {
            try {
                int i6 = 4;
                Mode modeForBits = wv0Var.a() < 4 ? Mode.TERMINATOR : Mode.forBits(wv0Var.d(4));
                int[] iArr = a.f42761a;
                int i7 = 2;
                int i8 = 3;
                switch (iArr[modeForBits.ordinal()]) {
                    case 5:
                        i8 = 3;
                        i7 = 2;
                        i6 = 4;
                        r13 = z5;
                        z4 = z6;
                        z3 = z7;
                        if (modeForBits == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z4) {
                                    i2 = i6;
                                } else if (z3) {
                                    i3 = 6;
                                    i2 = i3;
                                } else {
                                    i2 = i7;
                                }
                            } else if (z4) {
                                i2 = i8;
                            } else if (z3) {
                                i3 = 5;
                                i2 = i3;
                            } else {
                                i2 = 1;
                            }
                            String string = sb.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            return new q82(bArr, string, arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, i5, iD, i2);
                        }
                        i4 = 1;
                        z5 = r13;
                        z6 = z4;
                        z7 = z3;
                        break;
                    case 6:
                        int i9 = i4;
                        z = i9 == true ? 1 : 0;
                        i = i9;
                        z2 = z7;
                        r13 = i;
                        z4 = z;
                        z3 = z2;
                        if (modeForBits == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z4) {
                                    i2 = i6;
                                } else if (z3) {
                                    i3 = 6;
                                    i2 = i3;
                                } else {
                                    i2 = i7;
                                }
                            } else if (z4) {
                                i2 = i8;
                            } else if (z3) {
                                i3 = 5;
                                i2 = i3;
                            } else {
                                i2 = 1;
                            }
                            String string2 = sb.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            return new q82(bArr, string2, arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, i5, iD, i2);
                        }
                        i4 = 1;
                        z5 = r13;
                        z6 = z4;
                        z7 = z3;
                        break;
                    case 7:
                        int i10 = i4;
                        z2 = i10 == true ? 1 : 0;
                        i = i10;
                        z = z6;
                        r13 = i;
                        z4 = z;
                        z3 = z2;
                        if (modeForBits == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z4) {
                                    i2 = i6;
                                } else if (z3) {
                                    i3 = 6;
                                    i2 = i3;
                                } else {
                                    i2 = i7;
                                }
                            } else if (z4) {
                                i2 = i8;
                            } else if (z3) {
                                i3 = 5;
                                i2 = i3;
                            } else {
                                i2 = 1;
                            }
                            String string3 = sb.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            return new q82(bArr, string3, arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, i5, iD, i2);
                        }
                        i4 = 1;
                        z5 = r13;
                        z6 = z4;
                        z7 = z3;
                        break;
                    case 8:
                        if (wv0Var.a() < 16) {
                            throw FormatException.getFormatInstance();
                        }
                        int iD2 = wv0Var.d(8);
                        iD = wv0Var.d(8);
                        i5 = iD2;
                        i8 = 3;
                        i7 = 2;
                        i6 = 4;
                        r13 = z5;
                        z4 = z6;
                        z3 = z7;
                        if (modeForBits == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z4) {
                                    i2 = i6;
                                } else if (z3) {
                                    i3 = 6;
                                    i2 = i3;
                                } else {
                                    i2 = i7;
                                }
                            } else if (z4) {
                                i2 = i8;
                            } else if (z3) {
                                i3 = 5;
                                i2 = i3;
                            } else {
                                i2 = 1;
                            }
                            String string4 = sb.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            return new q82(bArr, string4, arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, i5, iD, i2);
                        }
                        i4 = 1;
                        z5 = r13;
                        z6 = z4;
                        z7 = z3;
                        break;
                        break;
                    case 9:
                        characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(g(wv0Var));
                        if (characterSetECIByValue == null) {
                            throw FormatException.getFormatInstance();
                        }
                        i8 = 3;
                        i7 = 2;
                        i6 = 4;
                        r13 = z5;
                        z4 = z6;
                        z3 = z7;
                        if (modeForBits == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z4) {
                                    i2 = i6;
                                } else if (z3) {
                                    i3 = 6;
                                    i2 = i3;
                                } else {
                                    i2 = i7;
                                }
                            } else if (z4) {
                                i2 = i8;
                            } else if (z3) {
                                i3 = 5;
                                i2 = i3;
                            } else {
                                i2 = 1;
                            }
                            String string5 = sb.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            return new q82(bArr, string5, arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, i5, iD, i2);
                        }
                        i4 = 1;
                        z5 = r13;
                        z6 = z4;
                        z7 = z3;
                        break;
                    case 10:
                        int iD3 = wv0Var.d(4);
                        int iD4 = wv0Var.d(modeForBits.getCharacterCountBits(lm9Var));
                        if (iD3 == i4) {
                            d(wv0Var, sb, iD4);
                        }
                        i8 = 3;
                        i7 = 2;
                        i6 = 4;
                        r13 = z5;
                        z4 = z6;
                        z3 = z7;
                        if (modeForBits == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z4) {
                                    i2 = i6;
                                } else if (z3) {
                                    i3 = 6;
                                    i2 = i3;
                                } else {
                                    i2 = i7;
                                }
                            } else if (z4) {
                                i2 = i8;
                            } else if (z3) {
                                i3 = 5;
                                i2 = i3;
                            } else {
                                i2 = 1;
                            }
                            String string6 = sb.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            return new q82(bArr, string6, arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, i5, iD, i2);
                        }
                        i4 = 1;
                        z5 = r13;
                        z6 = z4;
                        z7 = z3;
                        break;
                    default:
                        int iD5 = wv0Var.d(modeForBits.getCharacterCountBits(lm9Var));
                        int i11 = iArr[modeForBits.ordinal()];
                        if (i11 == i4) {
                            i8 = 3;
                            i7 = 2;
                            i6 = 4;
                            f(wv0Var, sb, iD5);
                            r13 = z5;
                            z4 = z6;
                            z3 = z7;
                        } else if (i11 == 2) {
                            i8 = 3;
                            i7 = 2;
                            i6 = 4;
                            b(wv0Var, sb, iD5, z5);
                            r13 = z5;
                            z4 = z6;
                            z3 = z7;
                        } else if (i11 == 3) {
                            i8 = 3;
                            i7 = 2;
                            i6 = 4;
                            c(wv0Var, sb, iD5, characterSetECIByValue, arrayList2, map);
                            r13 = z5;
                            z4 = z6;
                            z3 = z7;
                        } else {
                            if (i11 != 4) {
                                throw FormatException.getFormatInstance();
                            }
                            e(wv0Var, sb, iD5);
                            i8 = 3;
                            i7 = 2;
                            i6 = 4;
                            r13 = z5;
                            z4 = z6;
                            z3 = z7;
                        }
                        if (modeForBits == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z4) {
                                    i2 = i6;
                                } else if (z3) {
                                    i3 = 6;
                                    i2 = i3;
                                } else {
                                    i2 = i7;
                                }
                            } else if (z4) {
                                i2 = i8;
                            } else if (z3) {
                                i3 = 5;
                                i2 = i3;
                            } else {
                                i2 = 1;
                            }
                            String string7 = sb.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            return new q82(bArr, string7, arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, i5, iD, i2);
                        }
                        i4 = 1;
                        z5 = r13;
                        z6 = z4;
                        z7 = z3;
                        break;
                }
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    public static void b(wv0 wv0Var, StringBuilder sb, int i, boolean z) throws FormatException {
        while (i > 1) {
            if (wv0Var.a() < 11) {
                throw FormatException.getFormatInstance();
            }
            int iD = wv0Var.d(11);
            sb.append(h(iD / 45));
            sb.append(h(iD % 45));
            i -= 2;
        }
        if (i == 1) {
            if (wv0Var.a() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(wv0Var.d(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        } else {
                            sb.setCharAt(length, l82.o);
                        }
                    } else {
                        sb.setCharAt(length, l82.o);
                    }
                }
            }
        }
    }

    public static void c(wv0 wv0Var, StringBuilder sb, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        if (i * 8 > wv0Var.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) wv0Var.d(8);
        }
        sb.append(new String(bArr, characterSetECI == null ? ws8.a(bArr, map) : characterSetECI.getCharset()));
        collection.add(bArr);
    }

    public static void d(wv0 wv0Var, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > wv0Var.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iD = wv0Var.d(13);
            int i3 = (iD % 96) | ((iD / 96) << 8);
            int i4 = i3 + (i3 < 2560 ? 41377 : 42657);
            bArr[i2] = (byte) ((i4 >> 8) & 255);
            bArr[i2 + 1] = (byte) (i4 & 255);
            i2 += 2;
            i--;
        }
        sb.append(new String(bArr, ws8.c));
    }

    public static void e(wv0 wv0Var, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > wv0Var.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iD = wv0Var.d(13);
            int i3 = (iD % 192) | ((iD / 192) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        sb.append(new String(bArr, ws8.f20534b));
    }

    public static void f(wv0 wv0Var, StringBuilder sb, int i) throws FormatException {
        while (i >= 3) {
            if (wv0Var.a() < 10) {
                throw FormatException.getFormatInstance();
            }
            int iD = wv0Var.d(10);
            if (iD >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(iD / 100));
            sb.append(h((iD / 10) % 10));
            sb.append(h(iD % 10));
            i -= 3;
        }
        if (i == 2) {
            if (wv0Var.a() < 7) {
                throw FormatException.getFormatInstance();
            }
            int iD2 = wv0Var.d(7);
            if (iD2 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(iD2 / 10));
            sb.append(h(iD2 % 10));
            return;
        }
        if (i == 1) {
            if (wv0Var.a() < 4) {
                throw FormatException.getFormatInstance();
            }
            int iD3 = wv0Var.d(4);
            if (iD3 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(iD3));
        }
    }

    public static int g(wv0 wv0Var) throws FormatException {
        int iD = wv0Var.d(8);
        if ((iD & 128) == 0) {
            return iD & 127;
        }
        if ((iD & 192) == 128) {
            return wv0Var.d(8) | ((iD & 63) << 8);
        }
        if ((iD & 224) == 192) {
            return wv0Var.d(16) | ((iD & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    public static char h(int i) throws FormatException {
        char[] cArr = f17604a;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw FormatException.getFormatInstance();
    }
}
