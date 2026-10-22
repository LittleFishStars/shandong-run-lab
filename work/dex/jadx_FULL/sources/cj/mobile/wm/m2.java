package cj.mobile.wm;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m2 {
    public ByteBuffer dexb;
    public l2 dexc;
    public final byte[] dexa = new byte[256];
    public int dexd = 0;

    private int[] dexa(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.dexb.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                f1.dexa("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.dexc.dexb = 1;
        }
        return iArr;
    }

    private boolean dexc() {
        return this.dexc.dexb != 0;
    }

    private int dexd() {
        try {
            return this.dexb.get() & 255;
        } catch (Exception unused) {
            this.dexc.dexb = 1;
            return 0;
        }
    }

    private void dexe() {
        this.dexc.dexd.dexa = dexl();
        this.dexc.dexd.dexb = dexl();
        this.dexc.dexd.dexc = dexl();
        this.dexc.dexd.dexd = dexl();
        int iDexd = dexd();
        boolean z = (iDexd & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iDexd & 7) + 1);
        k2 k2Var = this.dexc.dexd;
        k2Var.dexe = (iDexd & 64) != 0;
        if (z) {
            k2Var.dexk = dexa(iPow);
        } else {
            k2Var.dexk = null;
        }
        this.dexc.dexd.dexj = this.dexb.position();
        dexo();
        if (dexc()) {
            return;
        }
        l2 l2Var = this.dexc;
        l2Var.dexc++;
        l2Var.dexe.add(l2Var.dexd);
    }

    private int dexf() {
        int iDexd = dexd();
        this.dexd = iDexd;
        int i = 0;
        if (iDexd > 0) {
            int i2 = 0;
            while (true) {
                try {
                    int i3 = this.dexd;
                    if (i >= i3) {
                        break;
                    }
                    i2 = i3 - i;
                    this.dexb.get(this.dexa, i, i2);
                    i += i2;
                } catch (Exception e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        f1.dexa("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.dexd, e);
                    }
                    this.dexc.dexb = 1;
                }
            }
        }
        return i;
    }

    private void dexg() {
        boolean z = false;
        while (!z && !dexc()) {
            int iDexd = dexd();
            if (iDexd == 33) {
                int iDexd2 = dexd();
                if (iDexd2 != 1) {
                    if (iDexd2 == 249) {
                        this.dexc.dexd = new k2();
                        dexh();
                    } else if (iDexd2 != 254 && iDexd2 == 255) {
                        dexf();
                        String str = "";
                        for (int i = 0; i < 11; i++) {
                            str = str + ((char) this.dexa[i]);
                        }
                        if (str.equals("NETSCAPE2.0")) {
                            dexk();
                        }
                    }
                }
                dexn();
            } else if (iDexd == 44) {
                l2 l2Var = this.dexc;
                if (l2Var.dexd == null) {
                    l2Var.dexd = new k2();
                }
                dexe();
            } else if (iDexd != 59) {
                this.dexc.dexb = 1;
            } else {
                z = true;
            }
        }
    }

    private void dexh() {
        dexd();
        int iDexd = dexd();
        k2 k2Var = this.dexc.dexd;
        int i = (iDexd & 28) >> 2;
        k2Var.dexg = i;
        if (i == 0) {
            k2Var.dexg = 1;
        }
        k2Var.dexf = (iDexd & 1) != 0;
        int iDexl = dexl();
        if (iDexl < 3) {
            iDexl = 10;
        }
        k2 k2Var2 = this.dexc.dexd;
        k2Var2.dexi = iDexl * 10;
        k2Var2.dexh = dexd();
        dexd();
    }

    private void dexi() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) dexd());
        }
        if (!str.startsWith("GIF")) {
            this.dexc.dexb = 1;
            return;
        }
        dexj();
        if (!this.dexc.dexh || dexc()) {
            return;
        }
        l2 l2Var = this.dexc;
        l2Var.dexa = dexa(l2Var.dexi);
        l2 l2Var2 = this.dexc;
        l2Var2.dexl = l2Var2.dexa[l2Var2.dexj];
    }

    private void dexj() {
        this.dexc.dexf = dexl();
        this.dexc.dexg = dexl();
        int iDexd = dexd();
        l2 l2Var = this.dexc;
        l2Var.dexh = (iDexd & 128) != 0;
        l2Var.dexi = 2 << (iDexd & 7);
        l2Var.dexj = dexd();
        this.dexc.dexk = dexd();
    }

    private void dexk() {
        do {
            dexf();
            byte[] bArr = this.dexa;
            if (bArr[0] == 1) {
                this.dexc.dexm = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.dexd <= 0) {
                return;
            }
        } while (!dexc());
    }

    private int dexl() {
        return this.dexb.getShort();
    }

    private void dexm() {
        this.dexb = null;
        Arrays.fill(this.dexa, (byte) 0);
        this.dexc = new l2();
        this.dexd = 0;
    }

    private void dexn() {
        int iDexd;
        do {
            iDexd = dexd();
            ByteBuffer byteBuffer = this.dexb;
            byteBuffer.position(byteBuffer.position() + iDexd);
        } while (iDexd > 0);
    }

    private void dexo() {
        dexd();
        dexn();
    }

    public m2 dexa(byte[] bArr) {
        dexm();
        if (bArr != null) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            this.dexb = byteBufferWrap;
            byteBufferWrap.rewind();
            this.dexb.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.dexb = null;
            this.dexc.dexb = 2;
        }
        return this;
    }

    public void dexa() {
        this.dexb = null;
        this.dexc = null;
    }

    public l2 dexb() {
        if (this.dexb == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (dexc()) {
            return this.dexc;
        }
        dexi();
        if (!dexc()) {
            dexg();
            l2 l2Var = this.dexc;
            if (l2Var.dexc < 0) {
                l2Var.dexb = 1;
            }
        }
        return this.dexc;
    }
}
