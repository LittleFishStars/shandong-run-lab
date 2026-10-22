package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ky5 {
    public static final int A = 8;
    public static final int B = 256;
    public static final int C = 18;
    public static final int D = 262144;
    public static final int h = 499;
    public static final int i = 491;
    public static final int j = 487;
    public static final int k = 503;
    public static final int l = 1509;
    public static final int m = 4;
    public static final int n = 100;
    public static final int o = 16;
    public static final int p = 65536;
    public static final int q = 10;
    public static final int r = 1024;
    public static final int s = 10;
    public static final int t = 64;
    public static final int u = 65536;
    public static final int v = 6;
    public static final int w = 64;
    public static final int x = 30;
    public static final int y = 10;
    public static final int z = 1024;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f42945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f17824a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f17825a = new int[256];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[][] f17826a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int[] f17827b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int[] f17828c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int[] f17829d;
    public int e;
    public int f;
    public int g;

    public ky5(byte[] thepic, int len, int sample, int palSize) {
        this.f17824a = thepic;
        this.f = len;
        this.g = sample;
        this.f42945a = palSize;
        this.b = palSize - 1;
        int i2 = palSize >> 3;
        this.c = i2;
        this.d = i2 * 64;
        this.f17827b = new int[palSize];
        this.f17828c = new int[palSize];
        this.f17829d = new int[i2];
        this.f17826a = new int[palSize][];
        int i3 = 0;
        while (true) {
            int i4 = this.f42945a;
            if (i3 >= i4) {
                return;
            }
            this.f17826a[i3] = new int[]{i, i, i, 0};
            int i5 = (i3 << 12) / i4;
            this.f17828c[i3] = 65536 / i4;
            this.f17827b[i3] = 0;
            i3++;
        }
    }

    public byte[] a() {
        int i2 = this.f42945a;
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < this.f42945a; i3++) {
            iArr[this.f17826a[i3][3]] = i3;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.f42945a) {
            int i6 = i5 + 1;
            int[] iArr2 = this.f17826a[iArr[i4]];
            bArr[i5] = (byte) iArr2[0];
            int i7 = i6 + 1;
            bArr[i6] = (byte) iArr2[1];
            bArr[i7] = (byte) iArr2[2];
            i4++;
            i5 = i7 + 1;
        }
        return bArr;
    }

    public void alterneigh(int rad, int i2, int b, int g, int r2) {
        int i3 = i2 - rad;
        if (i3 < -1) {
            i3 = -1;
        }
        int i4 = i2 + rad;
        int i5 = this.f42945a;
        if (i4 > i5) {
            i4 = i5;
        }
        int i6 = i2 + 1;
        int i7 = i2 - 1;
        int i8 = 1;
        while (true) {
            if (i6 >= i4 && i7 <= i3) {
                return;
            }
            i8++;
            int i9 = this.f17829d[i8];
            if (i6 < i4) {
                int i10 = i6 + 1;
                int[] iArr = this.f17826a[i6];
                try {
                    int i11 = iArr[0];
                    iArr[0] = i11 - (((i11 - b) * i9) / 262144);
                    int i12 = iArr[1];
                    iArr[1] = i12 - (((i12 - g) * i9) / 262144);
                    int i13 = iArr[2];
                    iArr[2] = i13 - (((i13 - r2) * i9) / 262144);
                } catch (Exception unused) {
                }
                i6 = i10;
            }
            if (i7 > i3) {
                int i14 = i7 - 1;
                int[] iArr2 = this.f17826a[i7];
                try {
                    int i15 = iArr2[0];
                    iArr2[0] = i15 - (((i15 - b) * i9) / 262144);
                    int i16 = iArr2[1];
                    iArr2[1] = i16 - (((i16 - g) * i9) / 262144);
                    int i17 = iArr2[2];
                    iArr2[2] = i17 - ((i9 * (i17 - r2)) / 262144);
                } catch (Exception unused2) {
                }
                i7 = i14;
            }
        }
    }

    public void altersingle(int alpha, int i2, int b, int g, int r2) {
        int[] iArr = this.f17826a[i2];
        int i3 = iArr[0];
        iArr[0] = i3 - (((i3 - b) * alpha) / 1024);
        int i4 = iArr[1];
        iArr[1] = i4 - (((i4 - g) * alpha) / 1024);
        int i5 = iArr[2];
        iArr[2] = i5 - ((alpha * (i5 - r2)) / 1024);
    }

    public void b() {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < this.f42945a) {
            int[] iArr = this.f17826a[i2];
            int i5 = iArr[1];
            int i6 = i2 + 1;
            int i7 = i2;
            for (int i8 = i6; i8 < this.f42945a; i8++) {
                int i9 = this.f17826a[i8][1];
                if (i9 < i5) {
                    i7 = i8;
                    i5 = i9;
                }
            }
            int[] iArr2 = this.f17826a[i7];
            if (i2 != i7) {
                int i10 = iArr2[0];
                iArr2[0] = iArr[0];
                iArr[0] = i10;
                int i11 = iArr2[1];
                iArr2[1] = iArr[1];
                iArr[1] = i11;
                int i12 = iArr2[2];
                iArr2[2] = iArr[2];
                iArr[2] = i12;
                int i13 = iArr2[3];
                iArr2[3] = iArr[3];
                iArr[3] = i13;
            }
            if (i5 != i3) {
                this.f17825a[i3] = (i4 + i2) >> 1;
                while (true) {
                    i3++;
                    if (i3 >= i5) {
                        break;
                    } else {
                        this.f17825a[i3] = i2;
                    }
                }
                i4 = i2;
                i3 = i5;
            }
            i2 = i6;
        }
        this.f17825a[i3] = (i4 + this.b) >> 1;
        for (int i14 = i3 + 1; i14 < 256; i14++) {
            this.f17825a[i14] = this.b;
        }
    }

    public void c() {
        int i2;
        int i3 = this.f;
        int i4 = 1509;
        if (i3 < 1509) {
            this.g = 1;
        }
        int i5 = this.g;
        this.e = ((i5 - 1) / 3) + 30;
        byte[] bArr = this.f17824a;
        int i6 = i3 / (i5 * 3);
        int i7 = i6 / 100;
        int i8 = this.d;
        int i9 = i8 >> 6;
        if (i9 <= 1) {
            i9 = 0;
        }
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = i9 * i9;
            this.f17829d[i10] = 1024 * (((i11 - (i10 * i10)) * 256) / i11);
        }
        int i12 = this.f;
        if (i12 < 1509) {
            i2 = 3;
        } else {
            if (i12 % 499 != 0) {
                i4 = 1497;
            } else if (i12 % i != 0) {
                i4 = 1473;
            } else if (i12 % j != 0) {
                i4 = 1461;
            }
            i2 = i4;
        }
        int i13 = i8;
        int i14 = i9;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1024;
        int i18 = i7;
        while (i15 < i6) {
            int i19 = (bArr[i16 + 0] & 255) << 4;
            int i20 = (bArr[i16 + 1] & 255) << 4;
            int i21 = (bArr[i16 + 2] & 255) << 4;
            int iContest = contest(i19, i20, i21);
            int i22 = i15;
            altersingle(i17, iContest, i19, i20, i21);
            if (i14 != 0) {
                alterneigh(i14, iContest, i19, i20, i21);
            }
            int i23 = i16 + i2;
            if (i23 >= i3) {
                i23 -= this.f;
            }
            i16 = i23;
            i15 = i22 + 1;
            if (i18 == 0) {
                i18 = 1;
            }
            if (i15 % i18 == 0) {
                i17 -= i17 / this.e;
                i13 -= i13 / 30;
                int i24 = i13 >> 6;
                i14 = i24 <= 1 ? 0 : i24;
                for (int i25 = 0; i25 < i14; i25++) {
                    int i26 = i14 * i14;
                    this.f17829d[i25] = (((i26 - (i25 * i25)) * 256) / i26) * i17;
                }
            }
        }
    }

    public int contest(int b, int g, int r2) {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        int i4 = -1;
        int i5 = Integer.MAX_VALUE;
        for (int i6 = 0; i6 < this.f42945a; i6++) {
            int[] iArr = this.f17826a[i6];
            int i7 = iArr[0] - b;
            if (i7 < 0) {
                i7 = -i7;
            }
            int i8 = iArr[1] - g;
            if (i8 < 0) {
                i8 = -i8;
            }
            int i9 = i7 + i8;
            int i10 = iArr[2] - r2;
            if (i10 < 0) {
                i10 = -i10;
            }
            int i11 = i9 + i10;
            if (i11 < i2) {
                i3 = i6;
                i2 = i11;
            }
            int[] iArr2 = this.f17827b;
            int i12 = i11 - (iArr2[i6] >> 12);
            if (i12 < i5) {
                i4 = i6;
                i5 = i12;
            }
            int[] iArr3 = this.f17828c;
            int i13 = iArr3[i6];
            int i14 = i13 >> 10;
            iArr3[i6] = i13 - i14;
            iArr2[i6] = iArr2[i6] + (i14 << 10);
        }
        int[] iArr4 = this.f17828c;
        iArr4[i3] = iArr4[i3] + 64;
        int[] iArr5 = this.f17827b;
        iArr5[i3] = iArr5[i3] - 65536;
        return i4;
    }

    public int d(int b, int g, int r2) {
        int i2 = this.f17825a[g];
        int i3 = i2 - 1;
        int i4 = 1000;
        int i5 = -1;
        while (true) {
            int i6 = this.f42945a;
            if (i2 >= i6 && i3 < 0) {
                return i5;
            }
            if (i2 < i6) {
                int[] iArr = this.f17826a[i2];
                int i7 = iArr[1] - g;
                if (i7 >= i4) {
                    i2 = i6;
                } else {
                    i2++;
                    if (i7 < 0) {
                        i7 = -i7;
                    }
                    int i8 = iArr[0] - b;
                    if (i8 < 0) {
                        i8 = -i8;
                    }
                    int i9 = i7 + i8;
                    if (i9 < i4) {
                        int i10 = iArr[2] - r2;
                        if (i10 < 0) {
                            i10 = -i10;
                        }
                        int i11 = i9 + i10;
                        if (i11 < i4) {
                            i5 = iArr[3];
                            i4 = i11;
                        }
                    }
                }
            }
            if (i3 >= 0) {
                int[] iArr2 = this.f17826a[i3];
                int i12 = g - iArr2[1];
                if (i12 >= i4) {
                    i3 = -1;
                } else {
                    i3--;
                    if (i12 < 0) {
                        i12 = -i12;
                    }
                    int i13 = iArr2[0] - b;
                    if (i13 < 0) {
                        i13 = -i13;
                    }
                    int i14 = i12 + i13;
                    if (i14 < i4) {
                        int i15 = iArr2[2] - r2;
                        if (i15 < 0) {
                            i15 = -i15;
                        }
                        int i16 = i15 + i14;
                        if (i16 < i4) {
                            i5 = iArr2[3];
                            i4 = i16;
                        }
                    }
                }
            }
        }
    }

    public byte[] e() {
        c();
        f();
        b();
        return a();
    }

    public void f() {
        for (int i2 = 0; i2 < this.f42945a; i2++) {
            int[] iArr = this.f17826a[i2];
            iArr[0] = iArr[0] >> 4;
            iArr[1] = iArr[1] >> 4;
            iArr[2] = iArr[2] >> 4;
            iArr[3] = i2;
        }
    }
}
