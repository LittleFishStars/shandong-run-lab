package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.zj.adlib.gv2;
import com.zj.adlib.q82;
import com.zj.adlib.rh6;
import java.math.BigInteger;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class DecodedBitStreamParser {
    public static final int A = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32529a = 900;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final BigInteger[] f6776a;
    public static final int b = 901;
    public static final int c = 902;
    public static final int d = 924;
    public static final int e = 925;
    public static final int f = 926;
    public static final int g = 927;
    public static final int h = 928;
    public static final int i = 923;
    public static final int j = 922;
    public static final int k = 913;
    public static final int l = 15;
    public static final int m = 0;
    public static final int n = 1;
    public static final int o = 2;
    public static final int p = 3;
    public static final int q = 4;
    public static final int r = 5;
    public static final int s = 6;
    public static final int t = 25;
    public static final int u = 27;
    public static final int v = 27;
    public static final int w = 28;
    public static final int x = 28;
    public static final int y = 29;
    public static final int z = 29;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final char[] f6775a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final char[] f6777b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32530a;

        static {
            int[] iArr = new int[Mode.values().length];
            f32530a = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32530a[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32530a[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32530a[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32530a[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32530a[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f6776a = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i2 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f6776a;
            if (i2 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i2] = bigIntegerArr2[i2 - 1].multiply(bigIntegerValueOf);
            i2++;
        }
    }

    public static int a(int i2, int[] iArr, int i3, gv2 gv2Var) throws FormatException {
        int i4;
        int i5;
        boolean z2 = false;
        while (i3 < iArr[0] && !z2) {
            while (true) {
                i4 = iArr[0];
                if (i3 >= i4 || iArr[i3] != 927) {
                    break;
                }
                int i6 = i3 + 1;
                gv2Var.f(iArr[i6]);
                i3 = i6 + 1;
            }
            if (i3 >= i4 || iArr[i3] >= 900) {
                z2 = true;
            } else {
                long j2 = 0;
                int i7 = 0;
                while (true) {
                    i5 = i3 + 1;
                    j2 = (j2 * 900) + ((long) iArr[i3]);
                    i7++;
                    if (i7 >= 5 || i5 >= iArr[0] || iArr[i5] >= 900) {
                        break;
                    }
                    i3 = i5;
                }
                if (i7 != 5 || (i2 != 924 && (i5 >= iArr[0] || iArr[i5] >= 900))) {
                    i5 -= i7;
                    while (i5 < iArr[0] && !z2) {
                        int i8 = i5 + 1;
                        int i9 = iArr[i5];
                        if (i9 < 900) {
                            gv2Var.a((byte) i9);
                            i5 = i8;
                        } else if (i9 == 927) {
                            gv2Var.f(iArr[i8]);
                            i5 = i8 + 1;
                        } else {
                            i5 = i8 - 1;
                            z2 = true;
                        }
                    }
                } else {
                    for (int i10 = 0; i10 < 6; i10++) {
                        gv2Var.a((byte) (j2 >> ((5 - i10) * 8)));
                    }
                }
                i3 = i5;
            }
        }
        return i3;
    }

    public static q82 b(int[] iArr, String str) throws FormatException {
        int i2;
        gv2 gv2Var = new gv2(iArr.length * 2);
        int iG = g(iArr, 1, gv2Var);
        rh6 rh6Var = new rh6();
        while (iG < iArr[0]) {
            int i3 = iG + 1;
            int i4 = iArr[iG];
            if (i4 != 913) {
                switch (i4) {
                    case 900:
                        iG = g(iArr, i3, gv2Var);
                        continue;
                    case 901:
                        break;
                    case 902:
                        iG = f(iArr, i3, gv2Var);
                        continue;
                    default:
                        switch (i4) {
                            case 922:
                            case 923:
                                throw FormatException.getFormatInstance();
                            case 924:
                                break;
                            case 925:
                                i2 = i3 + 1;
                                iG = i2;
                                break;
                            case 926:
                                i2 = i3 + 2;
                                iG = i2;
                                break;
                            case 927:
                                iG = i3 + 1;
                                gv2Var.f(iArr[i3]);
                                break;
                            case 928:
                                iG = d(iArr, i3, rh6Var);
                                break;
                            default:
                                iG = g(iArr, i3 - 1, gv2Var);
                                break;
                        }
                        break;
                }
                iG = a(i4, iArr, i3, gv2Var);
            } else {
                iG = i3 + 1;
                gv2Var.b((char) iArr[i3]);
            }
        }
        if (gv2Var.h() && rh6Var.c() == null) {
            throw FormatException.getFormatInstance();
        }
        q82 q82Var = new q82(null, gv2Var.toString(), null, str);
        q82Var.p(rh6Var);
        return q82Var;
    }

    public static String c(int[] iArr, int i2) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i3 = 0; i3 < i2; i3++) {
            bigIntegerAdd = bigIntegerAdd.add(f6776a[(i2 - i3) - 1].multiply(BigInteger.valueOf(iArr[i3])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    public static int d(int[] iArr, int i2, rh6 rh6Var) throws FormatException {
        int i3;
        if (i2 + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i4 = 0;
        while (i4 < 2) {
            iArr2[i4] = iArr[i2];
            i4++;
            i2++;
        }
        String strC = c(iArr2, 2);
        if (strC.isEmpty()) {
            rh6Var.t(0);
        } else {
            try {
                rh6Var.t(Integer.parseInt(strC));
            } catch (NumberFormatException unused) {
                throw FormatException.getFormatInstance();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (i2 < iArr[0] && i2 < iArr.length && (i3 = iArr[i2]) != 922 && i3 != 923) {
            sb.append(String.format("%03d", Integer.valueOf(i3)));
            i2++;
        }
        if (sb.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        rh6Var.n(sb.toString());
        int i5 = iArr[i2] == 923 ? i2 + 1 : -1;
        while (i2 < iArr[0]) {
            int i6 = iArr[i2];
            if (i6 == 922) {
                i2++;
                rh6Var.q(true);
            } else {
                if (i6 != 923) {
                    throw FormatException.getFormatInstance();
                }
                int i7 = i2 + 1;
                switch (iArr[i7]) {
                    case 0:
                        gv2 gv2Var = new gv2();
                        i2 = g(iArr, i7 + 1, gv2Var);
                        rh6Var.o(gv2Var.toString());
                        break;
                    case 1:
                        gv2 gv2Var2 = new gv2();
                        i2 = f(iArr, i7 + 1, gv2Var2);
                        rh6Var.s(Integer.parseInt(gv2Var2.toString()));
                        break;
                    case 2:
                        gv2 gv2Var3 = new gv2();
                        i2 = f(iArr, i7 + 1, gv2Var3);
                        rh6Var.v(Long.parseLong(gv2Var3.toString()));
                        break;
                    case 3:
                        gv2 gv2Var4 = new gv2();
                        i2 = g(iArr, i7 + 1, gv2Var4);
                        rh6Var.u(gv2Var4.toString());
                        break;
                    case 4:
                        gv2 gv2Var5 = new gv2();
                        i2 = g(iArr, i7 + 1, gv2Var5);
                        rh6Var.l(gv2Var5.toString());
                        break;
                    case 5:
                        gv2 gv2Var6 = new gv2();
                        i2 = f(iArr, i7 + 1, gv2Var6);
                        rh6Var.p(Long.parseLong(gv2Var6.toString()));
                        break;
                    case 6:
                        gv2 gv2Var7 = new gv2();
                        i2 = f(iArr, i7 + 1, gv2Var7);
                        rh6Var.m(Integer.parseInt(gv2Var7.toString()));
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
            }
        }
        if (i5 != -1) {
            int i8 = i2 - i5;
            if (rh6Var.k()) {
                i8--;
            }
            rh6Var.r(Arrays.copyOfRange(iArr, i5, i8 + i5));
        }
        return i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:43:0x0093  */
    public static Mode e(int[] iArr, int[] iArr2, int i2, gv2 gv2Var, Mode mode) {
        Mode mode2;
        int i3;
        char c2;
        char c3;
        Mode mode3;
        Mode mode4 = mode;
        Mode mode5 = mode4;
        Mode mode6 = mode5;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = iArr[i4];
            char c4 = ' ';
            switch (a.f32530a[mode5.ordinal()]) {
                case 1:
                    if (i5 >= 26) {
                        if (i5 != 900) {
                            if (i5 != 913) {
                                switch (i5) {
                                    case 27:
                                        mode4 = Mode.LOWER;
                                        break;
                                    case 28:
                                        mode4 = Mode.MIXED;
                                        break;
                                    case 29:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c4 = 0;
                                        Mode mode7 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode7;
                                        break;
                                }
                                mode3 = mode6;
                                mode6 = mode5;
                                c3 = c4;
                            } else {
                                gv2Var.b((char) iArr2[i4]);
                            }
                            c4 = 0;
                            mode3 = mode6;
                            mode6 = mode5;
                            c3 = c4;
                        } else {
                            mode4 = Mode.ALPHA;
                        }
                        c4 = 0;
                        mode5 = mode4;
                        mode3 = mode6;
                        mode6 = mode5;
                        c3 = c4;
                    } else {
                        i3 = i5 + 65;
                        c2 = (char) i3;
                        Mode mode8 = mode6;
                        mode6 = mode5;
                        c3 = c2;
                        mode3 = mode8;
                    }
                    break;
                case 2:
                    if (i5 >= 26) {
                        if (i5 != 900) {
                            if (i5 != 913) {
                                switch (i5) {
                                    case 27:
                                        mode2 = Mode.ALPHA_SHIFT;
                                        c4 = 0;
                                        Mode mode9 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode9;
                                        break;
                                    case 28:
                                        mode4 = Mode.MIXED;
                                        break;
                                    case 29:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c4 = 0;
                                        Mode mode10 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode10;
                                        break;
                                }
                                mode3 = mode6;
                                mode6 = mode5;
                                c3 = c4;
                            } else {
                                gv2Var.b((char) iArr2[i4]);
                            }
                            c4 = 0;
                            mode3 = mode6;
                            mode6 = mode5;
                            c3 = c4;
                        } else {
                            mode4 = Mode.ALPHA;
                        }
                        c4 = 0;
                        mode5 = mode4;
                        mode3 = mode6;
                        mode6 = mode5;
                        c3 = c4;
                    } else {
                        i3 = i5 + 97;
                        c2 = (char) i3;
                        Mode mode11 = mode6;
                        mode6 = mode5;
                        c3 = c2;
                        mode3 = mode11;
                    }
                    break;
                case 3:
                    if (i5 >= 25) {
                        if (i5 == 900) {
                            mode4 = Mode.ALPHA;
                            c4 = 0;
                            mode5 = mode4;
                        } else {
                            if (i5 != 913) {
                                switch (i5) {
                                    case 25:
                                        mode4 = Mode.PUNCT;
                                        c4 = 0;
                                        mode5 = mode4;
                                        break;
                                    case 27:
                                        mode4 = Mode.LOWER;
                                        c4 = 0;
                                        mode5 = mode4;
                                        break;
                                    case 28:
                                        mode4 = Mode.ALPHA;
                                        c4 = 0;
                                        mode5 = mode4;
                                        break;
                                    case 29:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c4 = 0;
                                        Mode mode12 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode12;
                                        break;
                                }
                            } else {
                                gv2Var.b((char) iArr2[i4]);
                            }
                            c4 = 0;
                        }
                        mode3 = mode6;
                        mode6 = mode5;
                        c3 = c4;
                    } else {
                        c2 = f6777b[i5];
                        Mode mode13 = mode6;
                        mode6 = mode5;
                        c3 = c2;
                        mode3 = mode13;
                    }
                    break;
                case 4:
                    if (i5 >= 29) {
                        if (i5 == 29 || i5 == 900) {
                            mode4 = Mode.ALPHA;
                            mode5 = mode4;
                        } else if (i5 == 913) {
                            gv2Var.b((char) iArr2[i4]);
                        }
                        mode3 = mode6;
                        mode6 = mode5;
                        c3 = 0;
                    } else {
                        c2 = f6775a[i5];
                        Mode mode14 = mode6;
                        mode6 = mode5;
                        c3 = c2;
                        mode3 = mode14;
                    }
                    break;
                case 5:
                    if (i5 >= 26) {
                        if (i5 != 26) {
                            if (i5 == 900) {
                                mode5 = Mode.ALPHA;
                                c4 = 0;
                                mode3 = mode6;
                                mode6 = mode5;
                                c3 = c4;
                            } else {
                                c4 = 0;
                            }
                        }
                        mode5 = mode6;
                        mode3 = mode6;
                        mode6 = mode5;
                        c3 = c4;
                    } else {
                        c3 = (char) (i5 + 65);
                        mode3 = mode6;
                    }
                    break;
                case 6:
                    if (i5 < 29) {
                        c3 = f6775a[i5];
                    } else if (i5 == 29 || i5 == 900) {
                        mode5 = Mode.ALPHA;
                        mode3 = mode6;
                        mode6 = mode5;
                        c3 = 0;
                    } else {
                        if (i5 == 913) {
                            gv2Var.b((char) iArr2[i4]);
                        }
                        c3 = 0;
                    }
                    mode3 = mode6;
                    break;
                default:
                    mode3 = mode6;
                    mode6 = mode5;
                    c3 = 0;
                    break;
            }
            if (c3 != 0) {
                gv2Var.b(c3);
            }
            i4++;
            mode5 = mode6;
            mode6 = mode3;
        }
        return mode4;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0030  */
    public static int f(int[] iArr, int i2, gv2 gv2Var) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            int i4 = iArr[0];
            if (i2 < i4 && !z2) {
                int i5 = i2 + 1;
                int i6 = iArr[i2];
                if (i5 == i4) {
                    z2 = true;
                }
                if (i6 >= 900) {
                    if (i6 != 900 && i6 != 901 && i6 != 927 && i6 != 928) {
                        switch (i6) {
                            case 922:
                            case 923:
                            case 924:
                                i5--;
                                z2 = true;
                                break;
                        }
                    } else {
                        i5--;
                        z2 = true;
                    }
                } else {
                    iArr2[i3] = i6;
                    i3++;
                }
                if ((i3 % 15 == 0 || i6 == 902 || z2) && i3 > 0) {
                    gv2Var.d(c(iArr2, i3));
                    i3 = 0;
                }
                i2 = i5;
            }
        }
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0047 A[FALL_THROUGH] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1095)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public static int g(int[] r10, int r11, com.zj.adlib.gv2 r12) throws com.google.zxing.FormatException {
        /*
            r0 = 0
            r1 = r10[r0]
            int r2 = r1 - r11
            int r2 = r2 * 2
            int[] r2 = new int[r2]
            int r1 = r1 - r11
            int r1 = r1 * 2
            int[] r1 = new int[r1]
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            r4 = r0
            r5 = r4
        L12:
            r6 = r10[r0]
            if (r11 >= r6) goto L75
            if (r4 != 0) goto L75
            int r6 = r11 + 1
            r11 = r10[r11]
            r7 = 900(0x384, float:1.261E-42)
            if (r11 >= r7) goto L2d
            int r7 = r11 / 30
            r2[r5] = r7
            int r7 = r5 + 1
            int r11 = r11 % 30
            r2[r7] = r11
            int r5 = r5 + 2
            goto L3f
        L2d:
            r8 = 913(0x391, float:1.28E-42)
            if (r11 == r8) goto L6a
            r8 = 927(0x39f, float:1.299E-42)
            if (r11 == r8) goto L4b
            r8 = 928(0x3a0, float:1.3E-42)
            if (r11 == r8) goto L47
            switch(r11) {
                case 900: goto L41;
                case 901: goto L47;
                case 902: goto L47;
                default: goto L3c;
            }
        L3c:
            switch(r11) {
                case 922: goto L47;
                case 923: goto L47;
                case 924: goto L47;
                default: goto L3f;
            }
        L3f:
            r11 = r6
            goto L12
        L41:
            int r11 = r5 + 1
            r2[r5] = r7
            r5 = r11
            goto L3f
        L47:
            int r6 = r6 + (-1)
            r4 = 1
            goto L3f
        L4b:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r11 = e(r2, r1, r5, r12, r3)
            int r1 = r6 + 1
            r2 = r10[r6]
            r12.f(r2)
            r2 = r10[r0]
            int r3 = r2 - r1
            int r3 = r3 * 2
            int[] r3 = new int[r3]
            int r2 = r2 - r1
            int r2 = r2 * 2
            int[] r2 = new int[r2]
            r5 = r0
            r9 = r3
            r3 = r11
            r11 = r1
            r1 = r2
            r2 = r9
            goto L12
        L6a:
            r2[r5] = r8
            int r11 = r6 + 1
            r6 = r10[r6]
            r1[r5] = r6
            int r5 = r5 + 1
            goto L12
        L75:
            e(r2, r1, r5, r12, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.g(int[], int, com.zj.adlib.gv2):int");
    }
}
