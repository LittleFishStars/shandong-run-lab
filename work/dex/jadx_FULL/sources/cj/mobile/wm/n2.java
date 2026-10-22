package cj.mobile.wm;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import com.zj.adlib.p60;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n2 {
    public int dexa;
    public int dexb;
    public int dexd;
    public OutputStream dexh;
    public Bitmap dexi;
    public byte[] dexj;
    public byte[] dexk;
    public int dexl;
    public byte[] dexm;
    public boolean dexu;
    public Integer dexc = null;
    public int dexe = -1;
    public int dexf = 0;
    public boolean dexg = false;
    public boolean[] dexn = new boolean[256];
    public int dexo = 7;
    public int dexp = -1;
    public boolean dexq = false;
    public boolean dexr = true;
    public boolean dexs = false;
    public int dext = 10;

    private void dexa(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.dexh.write((byte) str.charAt(i));
        }
    }

    private int dexb(int i) {
        if (this.dexm == null) {
            return -1;
        }
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        int length = this.dexm.length;
        int i2 = 0;
        int i3 = 16777216;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.dexm;
            int i5 = i2 + 1;
            int i6 = iRed - (bArr[i2] & 255);
            int i7 = i5 + 1;
            int i8 = iGreen - (bArr[i5] & 255);
            int i9 = iBlue - (bArr[i7] & 255);
            int i10 = (i6 * i6) + (i8 * i8) + (i9 * i9);
            int i11 = i7 / 3;
            if (this.dexn[i11] && i10 < i3) {
                i3 = i10;
                i4 = i11;
            }
            i2 = i7 + 1;
        }
        return i4;
    }

    private void dexb() {
        byte[] bArr = this.dexj;
        int length = bArr.length;
        int i = length / 3;
        this.dexk = new byte[i];
        p2 p2Var = new p2(bArr, length, this.dext);
        this.dexm = p2Var.dexd();
        int iIntValue = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.dexm;
            if (i2 >= bArr2.length) {
                break;
            }
            byte b = bArr2[i2];
            int i3 = i2 + 2;
            bArr2[i2] = bArr2[i3];
            bArr2[i3] = b;
            this.dexn[i2 / 3] = false;
            i2 += 3;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            byte[] bArr3 = this.dexj;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int iDexb = p2Var.dexb(bArr3[i5] & 255, bArr3[i6] & 255, bArr3[i7] & 255);
            this.dexn[iDexb] = true;
            this.dexk[i4] = (byte) iDexb;
            i4++;
            i5 = i7 + 1;
        }
        this.dexj = null;
        this.dexl = 8;
        this.dexo = 7;
        Integer num = this.dexc;
        if (num != null) {
            iIntValue = num.intValue();
        } else if (!this.dexu) {
            return;
        }
        this.dexd = dexb(iIntValue);
    }

    private void dexc() {
        int width = this.dexi.getWidth();
        int height = this.dexi.getHeight();
        int i = this.dexa;
        if (width != i || height != this.dexb) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, this.dexb, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
            this.dexi = bitmapCreateBitmap;
        }
        int i2 = width * height;
        int[] iArr = new int[i2];
        this.dexi.getPixels(iArr, 0, width, 0, 0, width, height);
        this.dexj = new byte[i2 * 3];
        this.dexu = false;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            int i6 = iArr[i3];
            if (i6 == 0) {
                i4++;
            }
            byte[] bArr = this.dexj;
            int i7 = i5 + 1;
            bArr[i5] = (byte) (i6 & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((i6 >> 8) & 255);
            bArr[i8] = (byte) ((i6 >> 16) & 255);
            i3++;
            i5 = i8 + 1;
        }
        double d = ((double) (i4 * 100)) / ((double) i2);
        this.dexu = d > 4.0d;
        if (Log.isLoggable(p60.f18782a, 3)) {
            f1.dexa(p60.f18782a, "got pixels for frame with " + d + "% transparent pixels");
        }
    }

    private void dexc(int i) throws IOException {
        this.dexh.write(i & 255);
        this.dexh.write((i >> 8) & 255);
    }

    private void dexd() throws IOException {
        int i;
        int i2;
        this.dexh.write(33);
        this.dexh.write(249);
        this.dexh.write(4);
        if (this.dexc != null || this.dexu) {
            i = 1;
            i2 = 2;
        } else {
            i = 0;
            i2 = 0;
        }
        int i3 = this.dexp;
        if (i3 >= 0) {
            i2 = i3 & 7;
        }
        this.dexh.write(i | (i2 << 2) | 0 | 0);
        dexc(this.dexf);
        this.dexh.write(this.dexd);
        this.dexh.write(0);
    }

    private void dexe() throws IOException {
        this.dexh.write(44);
        dexc(0);
        dexc(0);
        dexc(this.dexa);
        dexc(this.dexb);
        if (this.dexr) {
            this.dexh.write(0);
        } else {
            this.dexh.write(this.dexo | 128);
        }
    }

    private void dexf() throws IOException {
        dexc(this.dexa);
        dexc(this.dexb);
        this.dexh.write(this.dexo | 240);
        this.dexh.write(0);
        this.dexh.write(0);
    }

    private void dexg() throws IOException {
        this.dexh.write(33);
        this.dexh.write(255);
        this.dexh.write(11);
        dexa("NETSCAPE2.0");
        this.dexh.write(3);
        this.dexh.write(1);
        dexc(this.dexe);
        this.dexh.write(0);
    }

    private void dexh() throws IOException {
        OutputStream outputStream = this.dexh;
        byte[] bArr = this.dexm;
        outputStream.write(bArr, 0, bArr.length);
        int length = 768 - this.dexm.length;
        for (int i = 0; i < length; i++) {
            this.dexh.write(0);
        }
    }

    private void dexi() throws IOException {
        new o2(this.dexa, this.dexb, this.dexk, this.dexl).dexb(this.dexh);
    }

    public void dexa(int i) {
        this.dexf = Math.round(i / 10.0f);
    }

    public void dexa(int i, int i2) {
        if (!this.dexg || this.dexr) {
            this.dexa = i;
            this.dexb = i2;
            if (i < 1) {
                this.dexa = 320;
            }
            if (i2 < 1) {
                this.dexb = 240;
            }
            this.dexs = true;
        }
    }

    public boolean dexa() {
        boolean z;
        if (!this.dexg) {
            return false;
        }
        this.dexg = false;
        try {
            this.dexh.write(59);
            this.dexh.flush();
            if (this.dexq) {
                this.dexh.close();
            }
            z = true;
        } catch (IOException unused) {
            z = false;
        }
        this.dexd = 0;
        this.dexh = null;
        this.dexi = null;
        this.dexj = null;
        this.dexk = null;
        this.dexm = null;
        this.dexq = false;
        this.dexr = true;
        return z;
    }

    public boolean dexa(Bitmap bitmap) {
        if (bitmap == null || !this.dexg) {
            return false;
        }
        try {
            if (!this.dexs) {
                dexa(bitmap.getWidth(), bitmap.getHeight());
            }
            this.dexi = bitmap;
            dexc();
            dexb();
            if (this.dexr) {
                dexf();
                dexh();
                if (this.dexe >= 0) {
                    dexg();
                }
            }
            dexd();
            dexe();
            if (!this.dexr) {
                dexh();
            }
            dexi();
            this.dexr = false;
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean dexa(OutputStream outputStream) {
        boolean z = false;
        if (outputStream == null) {
            return false;
        }
        this.dexq = false;
        this.dexh = outputStream;
        try {
            dexa("GIF89a");
            z = true;
        } catch (IOException unused) {
        }
        this.dexg = z;
        return z;
    }
}
