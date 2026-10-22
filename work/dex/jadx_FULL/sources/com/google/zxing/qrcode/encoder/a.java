package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.zj.adlib.b57;
import com.zj.adlib.dy0;
import com.zj.adlib.ed7;
import com.zj.adlib.i85;
import com.zj.adlib.it3;
import com.zj.adlib.lm9;
import com.zj.adlib.qv0;
import com.zj.adlib.r51;
import com.zj.adlib.ue5;
import com.zj.adlib.ws8;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f6797a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f32538a = StandardCharsets.ISO_8859_1;

    /* JADX INFO: renamed from: com.google.zxing.qrcode.encoder.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0764a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32539a;

        static {
            int[] iArr = new int[Mode.values().length];
            f32539a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32539a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32539a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32539a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void a(String str, qv0 qv0Var, Charset charset) {
        for (byte b : str.getBytes(charset)) {
            qv0Var.d(b, 8);
        }
    }

    public static void b(CharSequence charSequence, qv0 qv0Var) throws WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iR = r(charSequence.charAt(i));
            if (iR == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int iR2 = r(charSequence.charAt(i2));
                if (iR2 == -1) {
                    throw new WriterException();
                }
                qv0Var.d((iR * 45) + iR2, 11);
                i += 2;
            } else {
                qv0Var.d(iR, 6);
                i = i2;
            }
        }
    }

    public static void c(String str, Mode mode, qv0 qv0Var, Charset charset) throws WriterException {
        int i = C0764a.f32539a[mode.ordinal()];
        if (i == 1) {
            h(str, qv0Var);
            return;
        }
        if (i == 2) {
            b(str, qv0Var);
            return;
        }
        if (i == 3) {
            a(str, qv0Var, charset);
        } else {
            if (i == 4) {
                e(str, qv0Var);
                return;
            }
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    public static void d(CharacterSetECI characterSetECI, qv0 qv0Var) {
        qv0Var.d(Mode.ECI.getBits(), 4);
        qv0Var.d(characterSetECI.getValue(), 8);
    }

    public static void e(String str, qv0 qv0Var) throws WriterException {
        int i;
        byte[] bytes = str.getBytes(ws8.f20534b);
        if (bytes.length % 2 != 0) {
            throw new WriterException("Kanji byte size not even");
        }
        int length = bytes.length - 1;
        for (int i2 = 0; i2 < length; i2 += 2) {
            int i3 = ((bytes[i2] & 255) << 8) | (bytes[i2 + 1] & 255);
            int i4 = 33088;
            if (i3 >= 33088 && i3 <= 40956) {
                i = i3 - i4;
            } else if (i3 < 57408 || i3 > 60351) {
                i = -1;
            } else {
                i4 = 49472;
                i = i3 - i4;
            }
            if (i == -1) {
                throw new WriterException("Invalid byte sequence");
            }
            qv0Var.d(((i >> 8) * 192) + (i & 255), 13);
        }
    }

    public static void f(int i, lm9 lm9Var, Mode mode, qv0 qv0Var) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(lm9Var);
        int i2 = 1 << characterCountBits;
        if (i < i2) {
            qv0Var.d(i, characterCountBits);
            return;
        }
        throw new WriterException(i + " is bigger than " + (i2 - 1));
    }

    public static void g(Mode mode, qv0 qv0Var) {
        qv0Var.d(mode.getBits(), 4);
    }

    public static void h(CharSequence charSequence, qv0 qv0Var) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iCharAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                qv0Var.d((iCharAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    qv0Var.d((iCharAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    qv0Var.d(iCharAt, 4);
                }
            }
        }
    }

    public static int i(Mode mode, qv0 qv0Var, qv0 qv0Var2, lm9 lm9Var) {
        return qv0Var.s() + mode.getCharacterCountBits(lm9Var) + qv0Var2.s();
    }

    public static int j(r51 r51Var) {
        return i85.a(r51Var) + i85.c(r51Var) + i85.d(r51Var) + i85.e(r51Var);
    }

    public static int k(qv0 qv0Var, ErrorCorrectionLevel errorCorrectionLevel, lm9 lm9Var, r51 r51Var) throws WriterException {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            ue5.a(qv0Var, errorCorrectionLevel, lm9Var, i3, r51Var);
            int iJ = j(r51Var);
            if (iJ < i) {
                i2 = i3;
                i = iJ;
            }
        }
        return i2;
    }

    public static Mode l(String str) {
        return m(str, null);
    }

    public static Mode m(String str, Charset charset) {
        if (ws8.f20534b.equals(charset) && u(str)) {
            return Mode.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (r(cCharAt) == -1) {
                    return Mode.BYTE;
                }
                z = true;
            }
        }
        if (z) {
            return Mode.ALPHANUMERIC;
        }
        return z2 ? Mode.NUMERIC : Mode.BYTE;
    }

    public static lm9 n(int i, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            lm9 lm9VarI = lm9.i(i2);
            if (x(i, lm9VarI, errorCorrectionLevel)) {
                return lm9VarI;
            }
        }
        throw new WriterException("Data too big");
    }

    public static b57 o(String str, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return p(str, errorCorrectionLevel, null);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:61:0x013e  */
    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    public static b57 p(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        boolean z;
        boolean z2;
        lm9 lm9VarV;
        lm9 lm9VarE;
        qv0 qv0Var;
        Mode mode;
        CharacterSetECI characterSetECI;
        int iK;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.GS1_FORMAT;
            if (map.containsKey(encodeHintType) && Boolean.parseBoolean(map.get(encodeHintType).toString())) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (map != null) {
            EncodeHintType encodeHintType2 = EncodeHintType.QR_COMPACT;
            if (map.containsKey(encodeHintType2) && Boolean.parseBoolean(map.get(encodeHintType2).toString())) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        Object obj = f32538a;
        boolean z3 = map != null && map.containsKey(EncodeHintType.CHARACTER_SET);
        Charset charsetForName = z3 ? Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString()) : obj;
        if (z2) {
            mode = Mode.BYTE;
            if (charsetForName.equals(obj)) {
                charsetForName = null;
            }
            MinimalEncoder.c cVarI = MinimalEncoder.i(str, null, charsetForName, z, errorCorrectionLevel);
            qv0Var = new qv0();
            cVarI.b(qv0Var);
            lm9VarE = cVarI.e();
        } else {
            Mode modeM = m(str, charsetForName);
            qv0 qv0Var2 = new qv0();
            Mode mode2 = Mode.BYTE;
            if (modeM == mode2 && z3 && (characterSetECI = CharacterSetECI.getCharacterSetECI(charsetForName)) != null) {
                d(characterSetECI, qv0Var2);
            }
            if (z) {
                g(Mode.FNC1_FIRST_POSITION, qv0Var2);
            }
            g(modeM, qv0Var2);
            qv0 qv0Var3 = new qv0();
            c(str, modeM, qv0Var3, charsetForName);
            if (map != null) {
                EncodeHintType encodeHintType3 = EncodeHintType.QR_VERSION;
                if (map.containsKey(encodeHintType3)) {
                    lm9VarV = lm9.i(Integer.parseInt(map.get(encodeHintType3).toString()));
                    if (!x(i(modeM, qv0Var2, qv0Var3, lm9VarV), lm9VarV, errorCorrectionLevel)) {
                        throw new WriterException("Data too big for requested version");
                    }
                } else {
                    lm9VarV = v(errorCorrectionLevel, modeM, qv0Var2, qv0Var3);
                }
            } else {
                lm9VarV = v(errorCorrectionLevel, modeM, qv0Var2, qv0Var3);
            }
            qv0 qv0Var4 = new qv0();
            qv0Var4.b(qv0Var2);
            f(modeM == mode2 ? qv0Var3.t() : str.length(), lm9VarV, modeM, qv0Var4);
            qv0Var4.b(qv0Var3);
            lm9VarE = lm9VarV;
            qv0Var = qv0Var4;
            mode = modeM;
        }
        lm9.b bVarF = lm9VarE.f(errorCorrectionLevel);
        int iH = lm9VarE.h() - bVarF.d();
        w(iH, qv0Var);
        qv0 qv0VarT = t(qv0Var, lm9VarE.h(), iH, bVarF.c());
        b57 b57Var = new b57();
        b57Var.g(errorCorrectionLevel);
        b57Var.j(mode);
        b57Var.k(lm9VarE);
        int iE = lm9VarE.e();
        r51 r51Var = new r51(iE, iE);
        if (map != null) {
            EncodeHintType encodeHintType4 = EncodeHintType.QR_MASK_PATTERN;
            if (map.containsKey(encodeHintType4)) {
                iK = Integer.parseInt(map.get(encodeHintType4).toString());
                if (!b57.f(iK)) {
                    iK = -1;
                }
            } else {
                iK = -1;
            }
        } else {
            iK = -1;
        }
        if (iK == -1) {
            iK = k(qv0VarT, errorCorrectionLevel, lm9VarE, r51Var);
        }
        b57Var.h(iK);
        ue5.a(qv0VarT, errorCorrectionLevel, lm9VarE, iK, r51Var);
        b57Var.i(r51Var);
        return b57Var;
    }

    public static byte[] q(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new ed7(it3.e).b(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    public static int r(int i) {
        int[] iArr = f6797a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    public static void s(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 >= i3) {
            throw new WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
        } else {
            iArr[0] = i10;
            iArr2[0] = i12;
        }
    }

    public static qv0 t(qv0 qv0Var, int i, int i2, int i3) throws WriterException {
        if (qv0Var.t() != i2) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            s(i, i2, i3, i5, iArr, iArr2);
            int i6 = iArr[0];
            byte[] bArr = new byte[i6];
            qv0Var.B(i4 * 8, bArr, 0, i6);
            byte[] bArrQ = q(bArr, iArr2[0]);
            arrayList.add(new dy0(bArr, bArrQ));
            iMax = Math.max(iMax, i6);
            iMax2 = Math.max(iMax2, bArrQ.length);
            i4 += iArr[0];
        }
        if (i2 != i4) {
            throw new WriterException("Data bytes does not match offset");
        }
        qv0 qv0Var2 = new qv0();
        for (int i7 = 0; i7 < iMax; i7++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] bArrA = ((dy0) it.next()).a();
                if (i7 < bArrA.length) {
                    qv0Var2.d(bArrA[i7], 8);
                }
            }
        }
        for (int i8 = 0; i8 < iMax2; i8++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] bArrB = ((dy0) it2.next()).b();
                if (i8 < bArrB.length) {
                    qv0Var2.d(bArrB[i8], 8);
                }
            }
        }
        if (i == qv0Var2.t()) {
            return qv0Var2;
        }
        throw new WriterException("Interleaving error: " + i + " and " + qv0Var2.t() + " differ.");
    }

    public static boolean u(String str) {
        byte[] bytes = str.getBytes(ws8.f20534b);
        int length = bytes.length;
        if (length % 2 != 0) {
            return false;
        }
        for (int i = 0; i < length; i += 2) {
            int i2 = bytes[i] & 255;
            if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                return false;
            }
        }
        return true;
    }

    public static lm9 v(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, qv0 qv0Var, qv0 qv0Var2) throws WriterException {
        return n(i(mode, qv0Var, qv0Var2, n(i(mode, qv0Var, qv0Var2, lm9.i(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    public static void w(int i, qv0 qv0Var) throws WriterException {
        int i2 = i * 8;
        if (qv0Var.s() > i2) {
            throw new WriterException("data bits cannot fit in the QR Code" + qv0Var.s() + " > " + i2);
        }
        for (int i3 = 0; i3 < 4 && qv0Var.s() < i2; i3++) {
            qv0Var.a(false);
        }
        int iS = qv0Var.s() & 7;
        if (iS > 0) {
            while (iS < 8) {
                qv0Var.a(false);
                iS++;
            }
        }
        int iT = i - qv0Var.t();
        for (int i4 = 0; i4 < iT; i4++) {
            qv0Var.d((i4 & 1) == 0 ? 236 : 17, 8);
        }
        if (qv0Var.s() != i2) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    public static boolean x(int i, lm9 lm9Var, ErrorCorrectionLevel errorCorrectionLevel) {
        return lm9Var.h() - lm9Var.f(errorCorrectionLevel).d() >= (i + 7) / 8;
    }
}
