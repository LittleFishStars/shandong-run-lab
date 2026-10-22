package com.heytap.mcssdk.a;

import com.alibaba.ariver.resource.parser.a.e;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.zj.adlib.aq6;
import com.zj.adlib.xs8;
import java.math.BigInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class a extends b {
    private static final int m = 6;
    private static final int n = 3;
    private static final int o = 4;
    private static final int s = 63;
    private final byte[] t;
    private final byte[] u;
    private final byte[] v;
    private final int w;
    private final int x;
    private int y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f32604a = {13, 10};
    private static final byte[] p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, aq6.f40585a, 121, 122, e.i, e.j, e.k, e.l, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, com.google.android.exoplayer2.text.cea.a.l, 47};
    private static final byte[] q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, aq6.f40585a, 121, 122, e.i, e.j, e.k, e.l, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, com.google.android.exoplayer2.text.cea.a.n, 95};
    private static final byte[] r = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, com.google.common.base.a.p, com.google.common.base.a.q, com.google.common.base.a.r, 17, com.google.common.base.a.u, 19, com.google.common.base.a.x, com.google.common.base.a.y, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.B, com.google.common.base.a.C, -1, -1, -1, -1, 63, -1, com.google.common.base.a.D, com.google.common.base.a.E, com.google.common.base.a.F, com.google.common.base.a.G, com.google.common.base.a.H, 31, 32, com.google.android.exoplayer2.text.cea.a.e, 34, 35, 36, com.google.android.exoplayer2.text.cea.a.g, com.google.android.exoplayer2.text.cea.a.h, com.google.android.exoplayer2.text.cea.a.i, MaterialProgressDrawable.c, com.google.android.exoplayer2.text.cea.a.j, 42, com.google.android.exoplayer2.text.cea.a.l, com.google.android.exoplayer2.text.cea.a.m, com.google.android.exoplayer2.text.cea.a.n, com.google.android.exoplayer2.text.cea.a.o, 47, e.i, e.j, e.k, e.l};

    public a() {
        this(0);
    }

    public a(int i) {
        this(i, f32604a);
    }

    public a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0045  */
    public a(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.u = r;
        if (bArr == null) {
            this.x = 4;
            this.v = null;
        } else {
            if (l(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + xs8.t(bArr) + "]");
            }
            if (i > 0) {
                this.x = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.v = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.x = 4;
                this.v = null;
            }
        }
        this.w = this.x - 1;
        this.t = z ? q : p;
    }

    public a(boolean z) {
        this(76, f32604a, z);
    }

    public static boolean a(byte b) {
        if (b == 61) {
            return true;
        }
        if (b < 0) {
            return false;
        }
        byte[] bArr = r;
        return b < bArr.length && bArr[b] != -1;
    }

    public static boolean a(String str) {
        return b(xs8.k(str));
    }

    public static boolean a(byte[] bArr) {
        return b(bArr);
    }

    public static byte[] a(BigInteger bigInteger) {
        if (bigInteger != null) {
            return a(b(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    public static byte[] a(byte[] bArr, boolean z) {
        return a(bArr, z, false);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2) {
        return a(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = z ? new a(z2) : new a(0, f32604a, z2);
        long jM = aVar.m(bArr);
        if (jM <= i) {
            return aVar.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + jM + ") than the specified maximum size of " + i);
    }

    public static boolean b(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!a(bArr[i]) && !b.c(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static byte[] b(String str) {
        return new a().c(str);
    }

    public static byte[] b(BigInteger bigInteger) {
        int iBitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == iBitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i = 0;
        }
        int i2 = iBitLength / 8;
        int i3 = i2 - length;
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i, bArr, i3, length);
        return bArr;
    }

    public static byte[] c(byte[] bArr) {
        return a(bArr, false);
    }

    public static String d(byte[] bArr) {
        return xs8.t(a(bArr, false));
    }

    public static byte[] e(byte[] bArr) {
        return a(bArr, false, true);
    }

    public static String f(byte[] bArr) {
        return xs8.t(a(bArr, false, true));
    }

    public static byte[] g(byte[] bArr) {
        return a(bArr, true);
    }

    public static byte[] h(byte[] bArr) {
        return new a().decode(bArr);
    }

    public static BigInteger i(byte[] bArr) {
        return new BigInteger(1, h(bArr));
    }

    @Override // com.heytap.mcssdk.a.b
    public void a(byte[] bArr, int i, int i2) {
        if (this.j) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                a(this.x);
                int i4 = (this.l + 1) % 3;
                this.l = i4;
                int i5 = i + 1;
                int i6 = bArr[i];
                if (i6 < 0) {
                    i6 += 256;
                }
                int i7 = (this.y << 8) + i6;
                this.y = i7;
                if (i4 == 0) {
                    byte[] bArr2 = this.h;
                    int i8 = this.i;
                    int i9 = i8 + 1;
                    byte[] bArr3 = this.t;
                    bArr2[i8] = bArr3[(i7 >> 18) & 63];
                    int i10 = i9 + 1;
                    bArr2[i9] = bArr3[(i7 >> 12) & 63];
                    int i11 = i10 + 1;
                    bArr2[i10] = bArr3[(i7 >> 6) & 63];
                    int i12 = i11 + 1;
                    this.i = i12;
                    bArr2[i11] = bArr3[i7 & 63];
                    int i13 = this.k + 4;
                    this.k = i13;
                    int i14 = this.g;
                    if (i14 > 0 && i14 <= i13) {
                        byte[] bArr4 = this.v;
                        System.arraycopy(bArr4, 0, bArr2, i12, bArr4.length);
                        this.i += this.v.length;
                        this.k = 0;
                    }
                }
                i3++;
                i = i5;
            }
            return;
        }
        this.j = true;
        if (this.l == 0 && this.g == 0) {
            return;
        }
        a(this.x);
        int i15 = this.i;
        int i16 = this.l;
        if (i16 == 1) {
            byte[] bArr5 = this.h;
            int i17 = i15 + 1;
            byte[] bArr6 = this.t;
            int i18 = this.y;
            bArr5[i15] = bArr6[(i18 >> 2) & 63];
            int i19 = i17 + 1;
            this.i = i19;
            bArr5[i17] = bArr6[(i18 << 4) & 63];
            if (bArr6 == p) {
                int i20 = i19 + 1;
                bArr5[i19] = 61;
                this.i = i20 + 1;
                bArr5[i20] = 61;
            }
        } else if (i16 == 2) {
            byte[] bArr7 = this.h;
            int i21 = i15 + 1;
            byte[] bArr8 = this.t;
            int i22 = this.y;
            bArr7[i15] = bArr8[(i22 >> 10) & 63];
            int i23 = i21 + 1;
            bArr7[i21] = bArr8[(i22 >> 4) & 63];
            int i24 = i23 + 1;
            this.i = i24;
            bArr7[i23] = bArr8[(i22 << 2) & 63];
            if (bArr8 == p) {
                this.i = i24 + 1;
                bArr7[i24] = 61;
            }
        }
        int i25 = this.k;
        int i26 = this.i;
        int i27 = i25 + (i26 - i15);
        this.k = i27;
        if (this.g <= 0 || i27 <= 0) {
            return;
        }
        byte[] bArr9 = this.v;
        System.arraycopy(bArr9, 0, this.h, i26, bArr9.length);
        this.i += this.v.length;
    }

    public boolean a() {
        return this.t == q;
    }

    @Override // com.heytap.mcssdk.a.b
    public void b(byte[] bArr, int i, int i2) {
        byte b;
        if (this.j) {
            return;
        }
        if (i2 < 0) {
            this.j = true;
        }
        int i3 = 0;
        while (i3 < i2) {
            a(this.w);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == 61) {
                this.j = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = r;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i5 = (this.l + 1) % 4;
                    this.l = i5;
                    int i6 = (this.y << 6) + b;
                    this.y = i6;
                    if (i5 == 0) {
                        byte[] bArr3 = this.h;
                        int i7 = this.i;
                        int i8 = i7 + 1;
                        bArr3[i7] = (byte) ((i6 >> 16) & 255);
                        int i9 = i8 + 1;
                        bArr3[i8] = (byte) ((i6 >> 8) & 255);
                        this.i = i9 + 1;
                        bArr3[i9] = (byte) (i6 & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!this.j || this.l == 0) {
            return;
        }
        a(this.w);
        int i10 = this.l;
        if (i10 == 2) {
            int i11 = this.y >> 4;
            this.y = i11;
            byte[] bArr4 = this.h;
            int i12 = this.i;
            this.i = i12 + 1;
            bArr4[i12] = (byte) (i11 & 255);
            return;
        }
        if (i10 != 3) {
            return;
        }
        int i13 = this.y >> 2;
        this.y = i13;
        byte[] bArr5 = this.h;
        int i14 = this.i;
        int i15 = i14 + 1;
        bArr5[i14] = (byte) ((i13 >> 8) & 255);
        this.i = i15 + 1;
        bArr5[i15] = (byte) (i13 & 255);
    }

    @Override // com.heytap.mcssdk.a.b
    public boolean b(byte b) {
        if (b < 0) {
            return false;
        }
        byte[] bArr = this.u;
        return b < bArr.length && bArr[b] != -1;
    }
}
