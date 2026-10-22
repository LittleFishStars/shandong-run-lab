package cj.mobile.wm;

import com.zj.adlib.ky5;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p2 {
    public int dexa;
    public byte[] dexb;
    public int dexc;
    public int dexd;
    public int[] dexf = new int[256];
    public int[] dexg = new int[256];
    public int[] dexh = new int[256];
    public int[] dexi = new int[32];
    public int[][] dexe = new int[256][];

    public p2(byte[] bArr, int i, int i2) {
        this.dexb = bArr;
        this.dexc = i;
        this.dexd = i2;
        for (int i3 = 0; i3 < 256; i3++) {
            this.dexe[i3] = new int[]{i, i, i, 0};
            int i4 = (i3 << 12) / 256;
            this.dexh[i3] = 256;
            this.dexg[i3] = 0;
        }
    }

    public int dexa(int i, int i2, int i3) {
        int i4 = Integer.MAX_VALUE;
        int i5 = -1;
        int i6 = -1;
        int i7 = Integer.MAX_VALUE;
        for (int i8 = 0; i8 < 256; i8++) {
            int[] iArr = this.dexe[i8];
            int i9 = iArr[0] - i;
            if (i9 < 0) {
                i9 = -i9;
            }
            int i10 = iArr[1] - i2;
            if (i10 < 0) {
                i10 = -i10;
            }
            int i11 = i9 + i10;
            int i12 = iArr[2] - i3;
            if (i12 < 0) {
                i12 = -i12;
            }
            int i13 = i11 + i12;
            if (i13 < i4) {
                i6 = i8;
                i4 = i13;
            }
            int[] iArr2 = this.dexg;
            int i14 = i13 - (iArr2[i8] >> 12);
            if (i14 < i7) {
                i5 = i8;
                i7 = i14;
            }
            int[] iArr3 = this.dexh;
            int i15 = iArr3[i8];
            int i16 = i15 >> 10;
            iArr3[i8] = i15 - i16;
            iArr2[i8] = iArr2[i8] + (i16 << 10);
        }
        int[] iArr4 = this.dexh;
        iArr4[i6] = iArr4[i6] + 64;
        int[] iArr5 = this.dexg;
        iArr5[i6] = iArr5[i6] - 65536;
        return i5;
    }

    public void dexa(int i, int i2, int i3, int i4, int i5) {
        int i6 = i2 - i;
        if (i6 < -1) {
            i6 = -1;
        }
        int i7 = i2 + i;
        if (i7 > 256) {
            i7 = 256;
        }
        int i8 = i2 + 1;
        int i9 = i2 - 1;
        int i10 = 1;
        while (true) {
            if (i8 >= i7 && i9 <= i6) {
                return;
            }
            i10++;
            int i11 = this.dexi[i10];
            if (i8 < i7) {
                int i12 = i8 + 1;
                int[] iArr = this.dexe[i8];
                try {
                    int i13 = iArr[0];
                    iArr[0] = i13 - (((i13 - i3) * i11) / 262144);
                    int i14 = iArr[1];
                    iArr[1] = i14 - (((i14 - i4) * i11) / 262144);
                    int i15 = iArr[2];
                    iArr[2] = i15 - (((i15 - i5) * i11) / 262144);
                } catch (Exception unused) {
                }
                i8 = i12;
            }
            if (i9 > i6) {
                int i16 = i9 - 1;
                int[] iArr2 = this.dexe[i9];
                try {
                    int i17 = iArr2[0];
                    iArr2[0] = i17 - (((i17 - i3) * i11) / 262144);
                    int i18 = iArr2[1];
                    iArr2[1] = i18 - (((i18 - i4) * i11) / 262144);
                    int i19 = iArr2[2];
                    iArr2[2] = i19 - ((i11 * (i19 - i5)) / 262144);
                } catch (Exception unused2) {
                }
                i9 = i16;
            }
        }
    }

    public byte[] dexa() {
        byte[] bArr = new byte[768];
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            iArr[this.dexe[i][3]] = i;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < 256) {
            int i4 = i3 + 1;
            int[] iArr2 = this.dexe[iArr[i2]];
            bArr[i3] = (byte) iArr2[0];
            int i5 = i4 + 1;
            bArr[i4] = (byte) iArr2[1];
            bArr[i5] = (byte) iArr2[2];
            i2++;
            i3 = i5 + 1;
        }
        return bArr;
    }

    public int dexb(int i, int i2, int i3) {
        int i4 = this.dexf[i2];
        int i5 = i4 - 1;
        int i6 = 1000;
        int i7 = -1;
        while (true) {
            if (i4 >= 256 && i5 < 0) {
                return i7;
            }
            if (i4 < 256) {
                int[] iArr = this.dexe[i4];
                int i8 = iArr[1] - i2;
                if (i8 >= i6) {
                    i4 = 256;
                } else {
                    i4++;
                    if (i8 < 0) {
                        i8 = -i8;
                    }
                    int i9 = iArr[0] - i;
                    if (i9 < 0) {
                        i9 = -i9;
                    }
                    int i10 = i8 + i9;
                    if (i10 < i6) {
                        int i11 = iArr[2] - i3;
                        if (i11 < 0) {
                            i11 = -i11;
                        }
                        int i12 = i10 + i11;
                        if (i12 < i6) {
                            i7 = iArr[3];
                            i6 = i12;
                        }
                    }
                }
            }
            if (i5 >= 0) {
                int[] iArr2 = this.dexe[i5];
                int i13 = i2 - iArr2[1];
                if (i13 >= i6) {
                    i5 = -1;
                } else {
                    i5--;
                    if (i13 < 0) {
                        i13 = -i13;
                    }
                    int i14 = iArr2[0] - i;
                    if (i14 < 0) {
                        i14 = -i14;
                    }
                    int i15 = i13 + i14;
                    if (i15 < i6) {
                        int i16 = iArr2[2] - i3;
                        if (i16 < 0) {
                            i16 = -i16;
                        }
                        int i17 = i16 + i15;
                        if (i17 < i6) {
                            i7 = iArr2[3];
                            i6 = i17;
                        }
                    }
                }
            }
        }
    }

    public void dexb() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < 256) {
            int[] iArr = this.dexe[i];
            int i4 = iArr[1];
            int i5 = i + 1;
            int i6 = i;
            for (int i7 = i5; i7 < 256; i7++) {
                int i8 = this.dexe[i7][1];
                if (i8 < i4) {
                    i6 = i7;
                    i4 = i8;
                }
            }
            int[] iArr2 = this.dexe[i6];
            if (i != i6) {
                int i9 = iArr2[0];
                iArr2[0] = iArr[0];
                iArr[0] = i9;
                int i10 = iArr2[1];
                iArr2[1] = iArr[1];
                iArr[1] = i10;
                int i11 = iArr2[2];
                iArr2[2] = iArr[2];
                iArr[2] = i11;
                int i12 = iArr2[3];
                iArr2[3] = iArr[3];
                iArr[3] = i12;
            }
            if (i4 != i2) {
                this.dexf[i2] = (i3 + i) >> 1;
                while (true) {
                    i2++;
                    if (i2 >= i4) {
                        break;
                    } else {
                        this.dexf[i2] = i;
                    }
                }
                i3 = i;
                i2 = i4;
            }
            i = i5;
        }
        this.dexf[i2] = (i3 + 255) >> 1;
        for (int i13 = i2 + 1; i13 < 256; i13++) {
            this.dexf[i13] = 255;
        }
    }

    public void dexb(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.dexe[i2];
        int i6 = iArr[0];
        iArr[0] = i6 - (((i6 - i3) * i) / 1024);
        int i7 = iArr[1];
        iArr[1] = i7 - (((i7 - i4) * i) / 1024);
        int i8 = iArr[2];
        iArr[2] = i8 - ((i * (i8 - i5)) / 1024);
    }

    public void dexc() {
        int i;
        int i2 = this.dexc;
        int i3 = 1509;
        if (i2 < 1509) {
            this.dexd = 1;
        }
        int i4 = this.dexd;
        this.dexa = ((i4 - 1) / 3) + 30;
        byte[] bArr = this.dexb;
        int i5 = i2 / (i4 * 3);
        int i6 = i5 / 100;
        for (int i7 = 0; i7 < 32; i7++) {
            this.dexi[i7] = 1024 * (((1024 - (i7 * i7)) * 256) / 1024);
        }
        int i8 = this.dexc;
        if (i8 < 1509) {
            i = 3;
        } else {
            if (i8 % 499 != 0) {
                i3 = 1497;
            } else if (i8 % ky5.i != 0) {
                i3 = 1473;
            } else if (i8 % ky5.j != 0) {
                i3 = 1461;
            }
            i = i3;
        }
        int i9 = 2048;
        int i10 = i6;
        int i11 = 1024;
        int i12 = 32;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i5) {
            int i15 = (bArr[i14 + 0] & 255) << 4;
            int i16 = (bArr[i14 + 1] & 255) << 4;
            int i17 = (bArr[i14 + 2] & 255) << 4;
            int iDexa = dexa(i15, i16, i17);
            int i18 = i13;
            dexb(i11, iDexa, i15, i16, i17);
            if (i12 != 0) {
                dexa(i12, iDexa, i15, i16, i17);
            }
            int i19 = i14 + i;
            if (i19 >= i2) {
                i19 -= this.dexc;
            }
            i14 = i19;
            i13 = i18 + 1;
            if (i10 == 0) {
                i10 = 1;
            }
            if (i13 % i10 == 0) {
                i11 -= i11 / this.dexa;
                i9 -= i9 / 30;
                int i20 = i9 >> 6;
                if (i20 <= 1) {
                    i20 = 0;
                }
                for (int i21 = 0; i21 < i20; i21++) {
                    int i22 = i20 * i20;
                    this.dexi[i21] = (((i22 - (i21 * i21)) * 256) / i22) * i11;
                }
                i12 = i20;
            }
        }
    }

    public byte[] dexd() {
        dexc();
        dexe();
        dexb();
        return dexa();
    }

    public void dexe() {
        for (int i = 0; i < 256; i++) {
            int[] iArr = this.dexe[i];
            iArr[0] = iArr[0] >> 4;
            iArr[1] = iArr[1] >> 4;
            iArr[2] = iArr[2] >> 4;
            iArr[3] = i;
        }
    }
}
