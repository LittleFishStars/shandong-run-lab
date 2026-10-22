package com.google.zxing.oned;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.zj.adlib.xm1;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f32515a = 241;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f6748a = 103;
    public static final char b = 242;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int f6749b = 104;
    public static final char c = 243;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int f6750c = 105;
    public static final char d = 244;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final int f6751d = 101;
    public static final int e = 100;
    public static final int f = 99;
    public static final int g = 106;
    public static final int h = 102;
    public static final int i = 97;
    public static final int j = 96;
    public static final int k = 101;
    public static final int l = 100;

    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public static final class MinimalEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f32516a = 98;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final String f6752a = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fÿ";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final /* synthetic */ boolean f6753a = false;
        public static final String b = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007fÿ";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int[][] f6754a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Latch[][] f6755a;

        public enum Charset {
            A,
            B,
            C,
            NONE
        }

        public enum Latch {
            A,
            B,
            C,
            SHIFT,
            NONE
        }

        public MinimalEncoder() {
        }

        public static void b(Collection<int[]> collection, int i, int[] iArr, int[] iArr2, int i2) {
            collection.add(xm1.f20682a[i]);
            if (i2 != 0) {
                iArr2[0] = iArr2[0] + 1;
            }
            iArr[0] = iArr[0] + (i * iArr2[0]);
        }

        public static boolean f(char c) {
            return c >= '0' && c <= '9';
        }

        public final boolean c(CharSequence charSequence, Charset charset, int i) {
            int i2;
            char cCharAt = charSequence.charAt(i);
            int i3 = a.b[charset.ordinal()];
            if (i3 == 1) {
                return cCharAt == 241 || cCharAt == 242 || cCharAt == 243 || cCharAt == 244 || f6752a.indexOf(cCharAt) >= 0;
            }
            if (i3 == 2) {
                return cCharAt == 241 || cCharAt == 242 || cCharAt == 243 || cCharAt == 244 || b.indexOf(cCharAt) >= 0;
            }
            if (i3 != 3) {
                return false;
            }
            return cCharAt == 241 || ((i2 = i + 1) < charSequence.length() && f(cCharAt) && f(charSequence.charAt(i2)));
        }

        public final int d(CharSequence charSequence, Charset charset, int i) {
            int iD;
            int iD2;
            int i2 = this.f6754a[charset.ordinal()][i];
            if (i2 > 0) {
                return i2;
            }
            Latch latch = Latch.NONE;
            int i3 = i + 1;
            boolean z = i3 >= charSequence.length();
            Charset[] charsetArr = {Charset.A, Charset.B};
            int i4 = Integer.MAX_VALUE;
            for (int i5 = 0; i5 <= 1; i5++) {
                if (c(charSequence, charsetArr[i5], i)) {
                    Latch latchValueOf = Latch.NONE;
                    Charset charset2 = charsetArr[i5];
                    if (charset != charset2) {
                        latchValueOf = Latch.valueOf(charset2.toString());
                        iD2 = 2;
                    } else {
                        iD2 = 1;
                    }
                    if (!z) {
                        iD2 += d(charSequence, charsetArr[i5], i3);
                    }
                    if (iD2 < i4) {
                        latch = latchValueOf;
                        i4 = iD2;
                    }
                    if (charset == charsetArr[(i5 + 1) % 2]) {
                        Latch latch2 = Latch.SHIFT;
                        int iD3 = !z ? d(charSequence, charset, i3) + 2 : 2;
                        if (iD3 < i4) {
                            latch = latch2;
                            i4 = iD3;
                        }
                    }
                }
            }
            Charset charset3 = Charset.C;
            if (c(charSequence, charset3, i)) {
                Latch latch3 = Latch.NONE;
                if (charset != charset3) {
                    latch3 = Latch.C;
                    iD = 2;
                } else {
                    iD = 1;
                }
                int i6 = (charSequence.charAt(i) != 241 ? 2 : 1) + i;
                if (i6 < charSequence.length()) {
                    iD += d(charSequence, charset3, i6);
                }
                if (iD < i4) {
                    latch = latch3;
                    i4 = iD;
                }
            }
            if (i4 != Integer.MAX_VALUE) {
                this.f6754a[charset.ordinal()][i] = i4;
                this.f6755a[charset.ordinal()][i] = latch;
                return i4;
            }
            throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) charSequence.charAt(i)));
        }

        /* JADX WARN: Code duplicated, block: B:30:0x009a  */
        /* JADX WARN: Code duplicated, block: B:32:0x00a2  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a6  */
        /* JADX WARN: Code duplicated, block: B:35:0x00b7  */
        /* JADX WARN: Code duplicated, block: B:36:0x00b9  */
        /* JADX WARN: Code duplicated, block: B:38:0x00c0  */
        /* JADX WARN: Code duplicated, block: B:39:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:48:0x00d9  */
        /* JADX WARN: Code duplicated, block: B:49:0x00dc  */
        /* JADX WARN: Code duplicated, block: B:50:0x00df  */
        /* JADX WARN: Code duplicated, block: B:68:0x00f7 A[SYNTHETIC] */
        public final boolean[] e(String str) {
            Charset charset;
            int i;
            int i2 = 2;
            this.f6754a = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, str.length());
            this.f6755a = (Latch[][]) Array.newInstance((Class<?>) Latch.class, 4, str.length());
            Charset charset2 = Charset.NONE;
            d(str, charset2, 0);
            ArrayList arrayList = new ArrayList();
            int[] iArr = {0};
            int[] iArr2 = {1};
            int length = str.length();
            int i3 = 0;
            while (i3 < length) {
                Latch latch = this.f6755a[charset2.ordinal()][i3];
                int i4 = a.f32517a[latch.ordinal()];
                int iCharAt = 100;
                if (i4 == 1) {
                    charset = Charset.A;
                    b(arrayList, i3 == 0 ? 103 : 101, iArr, iArr2, i3);
                } else if (i4 != i2) {
                    if (i4 == 3) {
                        charset = Charset.C;
                        b(arrayList, i3 == 0 ? 105 : 99, iArr, iArr2, i3);
                    } else if (i4 == 4) {
                        b(arrayList, 98, iArr, iArr2, i3);
                    }
                    if (charset2 == Charset.C) {
                        switch (str.charAt(i3)) {
                            case 241:
                                iCharAt = 102;
                                break;
                            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE /* 242 */:
                                iCharAt = 97;
                                break;
                            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE /* 243 */:
                                iCharAt = 96;
                                break;
                            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE /* 244 */:
                                if ((charset2 == Charset.A && latch != Latch.SHIFT) || (charset2 == Charset.B && latch == Latch.SHIFT)) {
                                }
                                break;
                            default:
                                iCharAt = str.charAt(i3) - ' ';
                                break;
                        }
                        if (((charset2 != Charset.A && latch != Latch.SHIFT) || (charset2 == Charset.B && latch == Latch.SHIFT)) && iCharAt < 0) {
                        }
                        b(arrayList, iCharAt, iArr, iArr2, i3);
                    } else if (str.charAt(i3) == 241) {
                        b(arrayList, 102, iArr, iArr2, i3);
                    } else {
                        b(arrayList, Integer.parseInt(str.substring(i3, i3 + 2)), iArr, iArr2, i3);
                        i = i3 + 1;
                        if (i < length) {
                            i3 = i;
                        }
                    }
                    i3++;
                    i2 = 2;
                } else {
                    charset = Charset.B;
                    b(arrayList, i3 == 0 ? 104 : 100, iArr, iArr2, i3);
                }
                charset2 = charset;
                if (charset2 == Charset.C) {
                    switch (str.charAt(i3)) {
                        case 241:
                            iCharAt = 102;
                            break;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE /* 242 */:
                            iCharAt = 97;
                            break;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE /* 243 */:
                            iCharAt = 96;
                            break;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE /* 244 */:
                            iCharAt = charset2 == Charset.A ? 101 : 101;
                            break;
                        default:
                            iCharAt = str.charAt(i3) - ' ';
                            break;
                    }
                    iCharAt = charset2 != Charset.A ? iCharAt + 96 : iCharAt + 96;
                    b(arrayList, iCharAt, iArr, iArr2, i3);
                } else if (str.charAt(i3) == 241) {
                    b(arrayList, 102, iArr, iArr2, i3);
                } else {
                    b(arrayList, Integer.parseInt(str.substring(i3, i3 + 2)), iArr, iArr2, i3);
                    i = i3 + 1;
                    if (i < length) {
                        i3 = i;
                    }
                }
                i3++;
                i2 = 2;
            }
            this.f6754a = null;
            this.f6755a = null;
            return Code128Writer.j(arrayList, iArr[0]);
        }

        public /* synthetic */ MinimalEncoder(a aVar) {
            this();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32517a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[MinimalEncoder.Charset.values().length];
            b = iArr;
            try {
                iArr[MinimalEncoder.Charset.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[MinimalEncoder.Charset.B.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[MinimalEncoder.Charset.C.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[MinimalEncoder.Latch.values().length];
            f32517a = iArr2;
            try {
                iArr2[MinimalEncoder.Latch.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32517a[MinimalEncoder.Latch.B.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32517a[MinimalEncoder.Latch.C.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32517a[MinimalEncoder.Latch.SHIFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static int f(String str, Map<EncodeHintType, ?> map) {
        int length = str.length();
        if (length < 1 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i2 = -1;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.FORCE_CODE_SET;
            if (map.containsKey(encodeHintType)) {
                String string = map.get(encodeHintType).toString();
                string.hashCode();
                switch (string) {
                    case "A":
                        i2 = 101;
                        break;
                    case "B":
                        i2 = 100;
                        break;
                    case "C":
                        i2 = 99;
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported code set hint: " + string);
                }
            }
        }
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            switch (cCharAt) {
                case 241:
                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE /* 242 */:
                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE /* 243 */:
                case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE /* 244 */:
                    break;
                default:
                    if (cCharAt > 127) {
                        throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) cCharAt));
                    }
                    break;
            }
            switch (i2) {
                case 99:
                    if (cCharAt < '0' || ((cCharAt > '9' && cCharAt <= 127) || cCharAt == 242 || cCharAt == 243 || cCharAt == 244)) {
                        throw new IllegalArgumentException("Bad character in input for forced code set C: ASCII value=" + ((int) cCharAt));
                    }
                    break;
                    break;
                case 100:
                    if (cCharAt <= ' ') {
                        throw new IllegalArgumentException("Bad character in input for forced code set B: ASCII value=" + ((int) cCharAt));
                    }
                    break;
                    break;
                case 101:
                    if (cCharAt > '_' && cCharAt <= 127) {
                        throw new IllegalArgumentException("Bad character in input for forced code set A: ASCII value=" + ((int) cCharAt));
                    }
                    break;
                    break;
            }
        }
        return i2;
    }

    public static int g(CharSequence charSequence, int i2, int i3) {
        CType cTypeI;
        CType cTypeI2;
        char cCharAt;
        CType cTypeI3 = i(charSequence, i2);
        CType cType = CType.ONE_DIGIT;
        if (cTypeI3 == cType) {
            return i3 == 101 ? 101 : 100;
        }
        CType cType2 = CType.UNCODABLE;
        if (cTypeI3 == cType2) {
            return (i2 >= charSequence.length() || ((cCharAt = charSequence.charAt(i2)) >= ' ' && (i3 != 101 || (cCharAt >= '`' && (cCharAt < 241 || cCharAt > 244))))) ? 100 : 101;
        }
        if (i3 == 101 && cTypeI3 == CType.FNC_1) {
            return 101;
        }
        if (i3 == 99) {
            return 99;
        }
        if (i3 != 100) {
            if (cTypeI3 == CType.FNC_1) {
                cTypeI3 = i(charSequence, i2 + 1);
            }
            return cTypeI3 == CType.TWO_DIGITS ? 99 : 100;
        }
        CType cType3 = CType.FNC_1;
        if (cTypeI3 == cType3 || (cTypeI = i(charSequence, i2 + 2)) == cType2 || cTypeI == cType) {
            return 100;
        }
        if (cTypeI == cType3) {
            return i(charSequence, i2 + 3) == CType.TWO_DIGITS ? 99 : 100;
        }
        int i4 = i2 + 4;
        while (true) {
            cTypeI2 = i(charSequence, i4);
            if (cTypeI2 != CType.TWO_DIGITS) {
                break;
            }
            i4 += 2;
        }
        return cTypeI2 == CType.ONE_DIGIT ? 100 : 99;
    }

    public static boolean[] h(String str, int i2) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (i3 < length) {
            int iG = i2 == -1 ? g(str, i3, i5) : i2;
            int iCharAt = 100;
            if (iG == i5) {
                switch (str.charAt(i3)) {
                    case 241:
                        iCharAt = 102;
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE /* 242 */:
                        iCharAt = 97;
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE /* 243 */:
                        iCharAt = 96;
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE /* 244 */:
                        if (i5 == 101) {
                            iCharAt = 101;
                        }
                        break;
                    default:
                        if (i5 == 100) {
                            iCharAt = str.charAt(i3) - ' ';
                        } else if (i5 == 101) {
                            iCharAt = str.charAt(i3) - ' ';
                            if (iCharAt < 0) {
                                iCharAt += 96;
                            }
                        } else {
                            int i7 = i3 + 1;
                            if (i7 == length) {
                                throw new IllegalArgumentException("Bad number of characters for digit only encoding.");
                            }
                            iCharAt = Integer.parseInt(str.substring(i3, i3 + 2));
                            i3 = i7;
                        }
                        break;
                }
                i3++;
            } else {
                if (i5 == 0) {
                    iCharAt = iG != 100 ? iG != 101 ? 105 : 103 : 104;
                } else {
                    iCharAt = iG;
                }
                i5 = iG;
            }
            arrayList.add(xm1.f20682a[iCharAt]);
            i4 += iCharAt * i6;
            if (i3 != 0) {
                i6++;
            }
        }
        return j(arrayList, i4);
    }

    public static CType i(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        if (i2 >= length) {
            return CType.UNCODABLE;
        }
        char cCharAt = charSequence.charAt(i2);
        if (cCharAt == 241) {
            return CType.FNC_1;
        }
        if (cCharAt < '0' || cCharAt > '9') {
            return CType.UNCODABLE;
        }
        int i3 = i2 + 1;
        if (i3 >= length) {
            return CType.ONE_DIGIT;
        }
        char cCharAt2 = charSequence.charAt(i3);
        return (cCharAt2 < '0' || cCharAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
    }

    public static boolean[] j(Collection<int[]> collection, int i2) {
        int[][] iArr = xm1.f20682a;
        collection.add(iArr[i2 % 103]);
        collection.add(iArr[106]);
        int iAppendPattern = 0;
        int i3 = 0;
        for (int[] iArr2 : collection) {
            for (int i4 : iArr2) {
                i3 += i4;
            }
        }
        boolean[] zArr = new boolean[i3];
        Iterator<int[]> it = collection.iterator();
        while (it.hasNext()) {
            iAppendPattern += OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, it.next(), true);
        }
        return zArr;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] c(String str) {
        return encode(str, null);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001e  */
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str, Map<EncodeHintType, ?> map) {
        boolean z;
        int iF = f(str, map);
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CODE128_COMPACT;
            if (map.containsKey(encodeHintType) && Boolean.parseBoolean(map.get(encodeHintType).toString())) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        return z ? new MinimalEncoder(null).e(str) : h(str, iF);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public Collection<BarcodeFormat> getSupportedWriteFormats() {
        return Collections.singleton(BarcodeFormat.CODE_128);
    }
}
