package cj.mobile.wm;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o2 {
    public int dexa;
    public int dexb;
    public byte[] dexc;
    public int dexd;
    public int dexe;
    public int dexf;
    public int dexg;
    public int dexi;
    public int dexp;
    public int dexq;
    public int dexr;
    public int dexv;
    public int dexh = 12;
    public int dexj = 4096;
    public int[] dexk = new int[5003];
    public int[] dexl = new int[5003];
    public int dexm = 5003;
    public int dexn = 0;
    public boolean dexo = false;
    public int dexs = 0;
    public int dext = 0;
    public int[] dexu = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    public byte[] dexw = new byte[256];

    public o2(int i, int i2, byte[] bArr, int i3) {
        this.dexa = i;
        this.dexb = i2;
        this.dexc = bArr;
        this.dexd = Math.max(2, i3);
    }

    private int dexa() {
        int i = this.dexe;
        if (i == 0) {
            return -1;
        }
        this.dexe = i - 1;
        byte[] bArr = this.dexc;
        int i2 = this.dexf;
        this.dexf = i2 + 1;
        return bArr[i2] & 255;
    }

    public final int dexa(int i) {
        return (1 << i) - 1;
    }

    public void dexa(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.dexw;
        int i = this.dexv;
        int i2 = i + 1;
        this.dexv = i2;
        bArr[i] = b;
        if (i2 >= 254) {
            dexc(outputStream);
        }
    }

    public void dexa(int i, OutputStream outputStream) throws IOException {
        this.dexp = i;
        int i2 = 0;
        this.dexo = false;
        this.dexg = i;
        this.dexi = dexa(i);
        int i3 = 1 << (i - 1);
        this.dexq = i3;
        this.dexr = i3 + 1;
        this.dexn = i3 + 2;
        this.dexv = 0;
        int iDexa = dexa();
        for (int i4 = this.dexm; i4 < 65536; i4 *= 2) {
            i2++;
        }
        int i5 = 8 - i2;
        int i6 = this.dexm;
        dexb(i6);
        dexb(this.dexq, outputStream);
        while (true) {
            int iDexa2 = dexa();
            if (iDexa2 == -1) {
                dexb(iDexa, outputStream);
                dexb(this.dexr, outputStream);
                return;
            }
            int i7 = (iDexa2 << this.dexh) + iDexa;
            int i8 = (iDexa2 << i5) ^ iDexa;
            int i9 = this.dexk[i8];
            if (i9 == i7) {
                iDexa = this.dexl[i8];
            } else {
                if (i9 >= 0) {
                    int i10 = i6 - i8;
                    if (i8 == 0) {
                        i10 = 1;
                    }
                    while (true) {
                        i8 -= i10;
                        if (i8 < 0) {
                            i8 += i6;
                        }
                        int i11 = this.dexk[i8];
                        if (i11 == i7) {
                            iDexa = this.dexl[i8];
                        } else if (i11 < 0) {
                        }
                    }
                }
                dexb(iDexa, outputStream);
                int i12 = this.dexn;
                if (i12 < this.dexj) {
                    int[] iArr = this.dexl;
                    this.dexn = i12 + 1;
                    iArr[i8] = i12;
                    this.dexk[i8] = i7;
                } else {
                    dexa(outputStream);
                }
                iDexa = iDexa2;
            }
        }
    }

    public void dexa(OutputStream outputStream) throws IOException {
        dexb(this.dexm);
        int i = this.dexq;
        this.dexn = i + 2;
        this.dexo = true;
        dexb(i, outputStream);
    }

    public void dexb(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.dexk[i2] = -1;
        }
    }

    public void dexb(int i, OutputStream outputStream) throws IOException {
        int i2 = this.dexs;
        int[] iArr = this.dexu;
        int i3 = this.dext;
        int i4 = i2 & iArr[i3];
        this.dexs = i4;
        if (i3 > 0) {
            this.dexs = i4 | (i << i3);
        } else {
            this.dexs = i;
        }
        this.dext = i3 + this.dexg;
        while (this.dext >= 8) {
            dexa((byte) (this.dexs & 255), outputStream);
            this.dexs >>= 8;
            this.dext -= 8;
        }
        if (this.dexn > this.dexi || this.dexo) {
            if (this.dexo) {
                int i5 = this.dexp;
                this.dexg = i5;
                this.dexi = dexa(i5);
                this.dexo = false;
            } else {
                int i6 = this.dexg + 1;
                this.dexg = i6;
                this.dexi = i6 == this.dexh ? this.dexj : dexa(i6);
            }
        }
        if (i == this.dexr) {
            while (this.dext > 0) {
                dexa((byte) (this.dexs & 255), outputStream);
                this.dexs >>= 8;
                this.dext -= 8;
            }
            dexc(outputStream);
        }
    }

    public void dexb(OutputStream outputStream) throws IOException {
        outputStream.write(this.dexd);
        this.dexe = this.dexa * this.dexb;
        this.dexf = 0;
        dexa(this.dexd + 1, outputStream);
        outputStream.write(0);
    }

    public void dexc(OutputStream outputStream) throws IOException {
        int i = this.dexv;
        if (i > 0) {
            outputStream.write(i);
            outputStream.write(this.dexw, 0, this.dexv);
            this.dexv = 0;
        }
    }
}
