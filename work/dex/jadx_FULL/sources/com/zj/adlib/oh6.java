package com.zj.adlib;

import com.alibaba.ariver.resource.parser.a.e;
import com.google.common.primitives.SignedBytes;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.ECIInput;
import com.google.zxing.pdf417.encoder.Compaction;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class oh6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f43749a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final /* synthetic */ boolean f18636a = false;
    public static final int b = 1;
    public static final int c = 2;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final byte[] f18639c;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 900;
    public static final int i = 901;
    public static final int j = 902;
    public static final int k = 913;
    public static final int l = 924;
    public static final int m = 925;
    public static final int n = 926;
    public static final int o = 927;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f18637a = {e.i, e.j, e.k, e.l, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, com.google.android.exoplayer2.text.cea.a.h, 13, 9, com.google.android.exoplayer2.text.cea.a.m, 58, 35, com.google.android.exoplayer2.text.cea.a.n, com.google.android.exoplayer2.text.cea.a.o, 36, 47, com.google.android.exoplayer2.text.cea.a.l, com.google.android.exoplayer2.text.cea.a.g, 42, 61, 94, 0, 32, 0, 0, 0};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final byte[] f18638b = {59, 60, 62, SignedBytes.f32242a, 91, 92, 93, 95, 96, 126, com.google.android.exoplayer2.text.cea.a.e, 13, 9, com.google.android.exoplayer2.text.cea.a.m, 58, 10, com.google.android.exoplayer2.text.cea.a.n, com.google.android.exoplayer2.text.cea.a.o, 36, 47, 34, 124, 42, MaterialProgressDrawable.c, com.google.android.exoplayer2.text.cea.a.j, 63, 123, 125, com.google.android.exoplayer2.text.cea.a.i, 0};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final byte[] f18640d = new byte[128];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Charset f18635a = StandardCharsets.ISO_8859_1;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43750a;

        static {
            int[] iArr = new int[Compaction.values().length];
            f43750a = iArr;
            try {
                iArr[Compaction.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43750a[Compaction.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43750a[Compaction.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class b implements ECIInput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f43751a;

        public /* synthetic */ b(String str, a aVar) {
            this(str);
        }

        @Override // com.google.zxing.common.ECIInput
        public boolean a(int i, int i2) {
            return i + i2 <= this.f43751a.length();
        }

        @Override // com.google.zxing.common.ECIInput
        public boolean b(int i) {
            return false;
        }

        @Override // com.google.zxing.common.ECIInput
        public int c(int i) {
            return -1;
        }

        @Override // com.google.zxing.common.ECIInput
        public char charAt(int i) {
            return this.f43751a.charAt(i);
        }

        @Override // com.google.zxing.common.ECIInput
        public int length() {
            return this.f43751a.length();
        }

        @Override // com.google.zxing.common.ECIInput
        public CharSequence subSequence(int i, int i2) {
            return this.f43751a.subSequence(i, i2);
        }

        public String toString() {
            return this.f43751a;
        }

        public b(String str) {
            this.f43751a = str;
        }
    }

    static {
        byte[] bArr = new byte[128];
        f18639c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr2 = f18637a;
            if (i3 >= bArr2.length) {
                break;
            }
            byte b2 = bArr2[i3];
            if (b2 > 0) {
                f18639c[b2] = (byte) i3;
            }
            i3++;
        }
        Arrays.fill(f18640d, (byte) -1);
        while (true) {
            byte[] bArr3 = f18638b;
            if (i2 >= bArr3.length) {
                return;
            }
            byte b3 = bArr3[i2];
            if (b3 > 0) {
                f18640d[b3] = (byte) i2;
            }
            i2++;
        }
    }

    public static int a(ECIInput eCIInput, int i2, Charset charset) throws WriterException {
        CharsetEncoder charsetEncoderNewEncoder = charset == null ? null : charset.newEncoder();
        int length = eCIInput.length();
        int i3 = i2;
        while (i3 < length) {
            int i4 = 0;
            int i5 = i3;
            while (i4 < 13 && !eCIInput.b(i5) && l(eCIInput.charAt(i5)) && (i5 = i3 + (i4 = i4 + 1)) < length) {
            }
            if (i4 >= 13) {
                return i3 - i2;
            }
            if (charsetEncoderNewEncoder != null && !charsetEncoderNewEncoder.canEncode(eCIInput.charAt(i3))) {
                char cCharAt = eCIInput.charAt(i3);
                throw new WriterException("Non-encodable character detected: " + cCharAt + " (Unicode: " + ((int) cCharAt) + ')');
            }
            i3++;
        }
        return i3 - i2;
    }

    public static int b(ECIInput eCIInput, int i2) {
        int length = eCIInput.length();
        int i3 = 0;
        if (i2 < length) {
            while (i2 < length && !eCIInput.b(i2) && l(eCIInput.charAt(i2))) {
                i3++;
                i2++;
            }
        }
        return i3;
    }

    public static int c(ECIInput eCIInput, int i2) {
        int length = eCIInput.length();
        int i3 = i2;
        while (i3 < length) {
            int i4 = 0;
            while (i4 < 13 && i3 < length && !eCIInput.b(i3) && l(eCIInput.charAt(i3))) {
                i4++;
                i3++;
            }
            if (i4 >= 13) {
                return (i3 - i2) - i4;
            }
            if (i4 <= 0) {
                if (eCIInput.b(i3) || !o(eCIInput.charAt(i3))) {
                    break;
                }
                i3++;
            }
        }
        return i3 - i2;
    }

    public static void d(byte[] bArr, int i2, int i3, int i4, StringBuilder sb) {
        int i5;
        if (i3 == 1 && i4 == 0) {
            sb.append((char) 913);
        } else if (i3 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i3 >= 6) {
            char[] cArr = new char[5];
            i5 = i2;
            while ((i2 + i3) - i5 >= 6) {
                long j2 = 0;
                for (int i6 = 0; i6 < 6; i6++) {
                    j2 = (j2 << 8) + ((long) (bArr[i5 + i6] & 255));
                }
                for (int i7 = 0; i7 < 5; i7++) {
                    cArr[i7] = (char) (j2 % 900);
                    j2 /= 900;
                }
                for (int i8 = 4; i8 >= 0; i8--) {
                    sb.append(cArr[i8]);
                }
                i5 += 6;
            }
        } else {
            i5 = i2;
        }
        while (i5 < i2 + i3) {
            sb.append((char) (bArr[i5] & 255));
            i5++;
        }
    }

    public static String e(String str, Compaction compaction, Charset charset, boolean z) throws WriterException {
        ECIInput bVar;
        CharacterSetECI characterSetECI;
        if (charset == null && !z) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (str.charAt(i2) > 255) {
                    throw new WriterException("Non-encodable character detected: " + str.charAt(i2) + " (Unicode: " + ((int) str.charAt(i2)) + "). Consider specifying EncodeHintType.PDF417_AUTO_ECI and/or EncodeTypeHint.CHARACTER_SET.");
                }
            }
        }
        StringBuilder sb = new StringBuilder(str.length());
        a aVar = null;
        if (z) {
            bVar = new qp5(str, charset, -1);
        } else {
            bVar = new b(str, aVar);
            if (charset == null) {
                charset = f18635a;
            } else if (!f18635a.equals(charset) && (characterSetECI = CharacterSetECI.getCharacterSetECI(charset)) != null) {
                i(characterSetECI.getValue(), sb);
            }
        }
        int length = bVar.length();
        int i3 = a.f43750a[compaction.ordinal()];
        if (i3 == 1) {
            h(bVar, 0, length, sb, 0);
        } else if (i3 != 2) {
            if (i3 != 3) {
                int i4 = 0;
                int iH = 0;
                int i5 = 0;
                while (i4 < length) {
                    while (i4 < length && bVar.b(i4)) {
                        i(bVar.c(i4), sb);
                        i4++;
                    }
                    if (i4 >= length) {
                        break;
                    }
                    int iB = b(bVar, i4);
                    if (iB >= 13) {
                        sb.append((char) 902);
                        g(bVar, i4, iB, sb);
                        i4 += iB;
                        iH = 0;
                        i5 = 2;
                    } else {
                        int iC = c(bVar, i4);
                        if (iC >= 5 || iB == length) {
                            if (i5 != 0) {
                                sb.append((char) 900);
                                iH = 0;
                                i5 = 0;
                            }
                            iH = h(bVar, i4, iC, sb, iH);
                            i4 += iC;
                        } else {
                            int iA = a(bVar, i4, z ? null : charset);
                            if (iA == 0) {
                                iA = 1;
                            }
                            byte[] bytes = z ? null : bVar.subSequence(i4, i4 + iA).toString().getBytes(charset);
                            if ((!(bytes == null && iA == 1) && (bytes == null || bytes.length != 1)) || i5 != 0) {
                                if (z) {
                                    f(bVar, i4, i4 + iA, i5, sb);
                                } else {
                                    d(bytes, 0, bytes.length, i5, sb);
                                }
                                iH = 0;
                                i5 = 1;
                            } else if (z) {
                                f(bVar, i4, 1, 0, sb);
                            } else {
                                d(bytes, 0, 1, 0, sb);
                            }
                            i4 += iA;
                        }
                    }
                }
            } else {
                sb.append((char) 902);
                g(bVar, 0, length, sb);
            }
        } else if (z) {
            f(bVar, 0, bVar.length(), 0, sb);
        } else {
            byte[] bytes2 = bVar.toString().getBytes(charset);
            d(bytes2, 0, bytes2.length, 1, sb);
        }
        return sb.toString();
    }

    public static void f(ECIInput eCIInput, int i2, int i3, int i4, StringBuilder sb) throws WriterException {
        int iMin = Math.min(i3 + i2, eCIInput.length());
        int i5 = i2;
        while (true) {
            if (i5 >= iMin || !eCIInput.b(i5)) {
                int i6 = i5;
                while (i6 < iMin && !eCIInput.b(i6)) {
                    i6++;
                }
                int i7 = i6 - i5;
                if (i7 <= 0) {
                    return;
                }
                d(p(eCIInput, i5, i6), 0, i7, i5 == i2 ? i4 : 1, sb);
                i5 = i6;
            } else {
                i(eCIInput.c(i5), sb);
                i5++;
            }
        }
    }

    public static void g(ECIInput eCIInput, int i2, int i3, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i3 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i4 = 0;
        while (i4 < i3) {
            sb2.setLength(0);
            int iMin = Math.min(44, i3 - i4);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("1");
            int i5 = i2 + i4;
            sb3.append((Object) eCIInput.subSequence(i5, i5 + iMin));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                bigInteger = bigInteger.divide(bigIntegerValueOf);
            } while (!bigInteger.equals(bigIntegerValueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i4 += iMin;
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x000f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x010c A[EDGE_INSN: B:83:0x010c->B:60:0x010c BREAK  A[LOOP:0: B:3:0x000f->B:101:0x000f], SYNTHETIC] */
    public static int h(ECIInput eCIInput, int i2, int i3, StringBuilder sb, int i4) throws WriterException {
        StringBuilder sb2 = new StringBuilder(i3);
        int i5 = i4;
        int i6 = 0;
        while (true) {
            int i7 = i2 + i6;
            if (!eCIInput.b(i7)) {
                char cCharAt = eCIInput.charAt(i7);
                if (i5 == 0) {
                    if (k(cCharAt)) {
                        if (cCharAt == ' ') {
                            sb2.append((char) 26);
                        } else {
                            sb2.append((char) (cCharAt - 'A'));
                        }
                    } else if (j(cCharAt)) {
                        sb2.append((char) 27);
                        i5 = 1;
                    } else if (m(cCharAt)) {
                        sb2.append(l82.n);
                        i5 = 2;
                    } else {
                        sb2.append(l82.o);
                        sb2.append((char) f18640d[cCharAt]);
                    }
                    i6++;
                    if (i6 >= i3) {
                        break;
                        break;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (n(cCharAt)) {
                                sb2.append((char) f18640d[cCharAt]);
                            } else {
                                sb2.append(l82.o);
                                i5 = 0;
                            }
                        } else if (m(cCharAt)) {
                            sb2.append((char) f18639c[cCharAt]);
                        } else if (k(cCharAt)) {
                            sb2.append(l82.n);
                            i5 = 0;
                        } else if (j(cCharAt)) {
                            sb2.append((char) 27);
                            i5 = 1;
                        } else {
                            int i8 = i7 + 1;
                            if (i8 >= i3 || eCIInput.b(i8) || !n(eCIInput.charAt(i8))) {
                                sb2.append(l82.o);
                                sb2.append((char) f18640d[cCharAt]);
                            } else {
                                sb2.append((char) 25);
                                i5 = 3;
                            }
                        }
                    } else if (j(cCharAt)) {
                        if (cCharAt == ' ') {
                            sb2.append((char) 26);
                        } else {
                            sb2.append((char) (cCharAt - 'a'));
                        }
                    } else if (k(cCharAt)) {
                        sb2.append((char) 27);
                        sb2.append((char) (cCharAt - 'A'));
                    } else if (m(cCharAt)) {
                        sb2.append(l82.n);
                        i5 = 2;
                    } else {
                        sb2.append(l82.o);
                        sb2.append((char) f18640d[cCharAt]);
                    }
                    i6++;
                    if (i6 >= i3) {
                        break;
                    }
                }
            } else {
                i(eCIInput.c(i7), sb);
                i6++;
            }
        }
        int length = sb2.length();
        char cCharAt2 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            if (i9 % 2 != 0) {
                cCharAt2 = (char) ((cCharAt2 * l82.p) + sb2.charAt(i9));
                sb.append(cCharAt2);
            } else {
                cCharAt2 = sb2.charAt(i9);
            }
        }
        if (length % 2 != 0) {
            sb.append((char) ((cCharAt2 * l82.p) + 29));
        }
        return i5;
    }

    public static void i(int i2, StringBuilder sb) throws WriterException {
        if (i2 >= 0 && i2 < 900) {
            sb.append((char) 927);
            sb.append((char) i2);
            return;
        }
        if (i2 < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i2 / 900) - 1));
            sb.append((char) (i2 % 900));
        } else if (i2 < 811800) {
            sb.append((char) 925);
            sb.append((char) (810900 - i2));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i2);
        }
    }

    public static boolean j(char c2) {
        return c2 == ' ' || (c2 >= 'a' && c2 <= 'z');
    }

    public static boolean k(char c2) {
        return c2 == ' ' || (c2 >= 'A' && c2 <= 'Z');
    }

    public static boolean l(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean m(char c2) {
        return f18639c[c2] != -1;
    }

    public static boolean n(char c2) {
        return f18640d[c2] != -1;
    }

    public static boolean o(char c2) {
        return c2 == '\t' || c2 == '\n' || c2 == '\r' || (c2 >= ' ' && c2 <= '~');
    }

    public static byte[] p(ECIInput eCIInput, int i2, int i3) {
        byte[] bArr = new byte[i3 - i2];
        for (int i4 = i2; i4 < i3; i4++) {
            bArr[i4 - i2] = (byte) (eCIInput.charAt(i4) & 255);
        }
        return bArr;
    }
}
