package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class p60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f43911a = 4.0d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f18782a = "AnimatedGifEncoder";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f18783a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f18784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OutputStream f18785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f18788a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public byte[] f18791b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public byte[] f18793c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f18795e;
    public int h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer f18786a = null;
    public int f = -1;
    public int g = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18787a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f18789a = new boolean[256];
    public int i = 7;
    public int j = 256;
    public int k = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f18790b = false;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f18792c = true;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f18794d = false;
    public int l = 10;

    public boolean a(@Nullable Bitmap im) {
        return b(im, 0, 0);
    }

    public boolean b(@Nullable Bitmap im, int x, int y) {
        if (im == null || !this.f18787a) {
            return false;
        }
        try {
            if (this.f18794d) {
                j(this.c, this.d);
            } else {
                j(im.getWidth(), im.getHeight());
            }
            this.f18784a = im;
            f();
            c();
            if (this.f18792c) {
                t();
                v();
                if (this.f >= 0) {
                    u();
                }
            }
            r();
            s(x, y);
            if (!this.f18792c) {
                v();
            }
            w();
            this.f18792c = false;
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public final void c() {
        byte[] bArr = this.f18788a;
        int length = bArr.length;
        int i = length / 3;
        this.f18791b = new byte[i];
        ky5 ky5Var = new ky5(bArr, length, this.l, this.j);
        this.f18793c = ky5Var.e();
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.f18793c;
            if (i2 >= bArr2.length) {
                break;
            }
            byte b = bArr2[i2];
            int i3 = i2 + 2;
            bArr2[i2] = bArr2[i3];
            bArr2[i3] = b;
            this.f18789a[i2 / 3] = false;
            i2 += 3;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            byte[] bArr3 = this.f18788a;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int iD = ky5Var.d(bArr3[i5] & 255, bArr3[i6] & 255, bArr3[i7] & 255);
            this.f18789a[iD] = true;
            this.f18791b[i4] = (byte) iD;
            i4++;
            i5 = i7 + 1;
        }
        this.f18788a = null;
        this.h = 8;
        Integer num = this.f18786a;
        if (num != null) {
            this.e = d(num.intValue());
        } else if (this.f18795e) {
            this.e = d(0);
        }
    }

    public final int d(int color) {
        if (this.f18793c == null) {
            return -1;
        }
        int iRed = Color.red(color);
        int iGreen = Color.green(color);
        int iBlue = Color.blue(color);
        int i = this.j;
        int i2 = i * i * i;
        int length = this.f18793c.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            byte[] bArr = this.f18793c;
            int i5 = i3 + 1;
            int i6 = iRed - (bArr[i3] & 255);
            int i7 = i5 + 1;
            int i8 = iGreen - (bArr[i5] & 255);
            int i9 = iBlue - (bArr[i7] & 255);
            int i10 = (i6 * i6) + (i8 * i8) + (i9 * i9);
            int i11 = i7 / 3;
            if (this.f18789a[i11] && i10 < i2) {
                i2 = i10;
                i4 = i11;
            }
            i3 = i7 + 1;
        }
        return i4;
    }

    public boolean e() {
        boolean z;
        if (!this.f18787a) {
            return false;
        }
        this.f18787a = false;
        try {
            this.f18785a.write(59);
            this.f18785a.flush();
            if (this.f18790b) {
                this.f18785a.close();
            }
            z = true;
        } catch (IOException unused) {
            z = false;
        }
        this.e = 0;
        this.f18785a = null;
        this.f18784a = null;
        this.f18788a = null;
        this.f18791b = null;
        this.f18793c = null;
        this.f18790b = false;
        this.f18792c = true;
        return z;
    }

    public final void f() {
        int width = this.f18784a.getWidth();
        int height = this.f18784a.getHeight();
        int i = this.f18783a;
        if (width != i || height != this.b) {
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(this.f18784a, i, this.b, false);
            new Canvas(bitmapCreateScaledBitmap).drawBitmap(bitmapCreateScaledBitmap, 0.0f, 0.0f, (Paint) null);
            this.f18784a = bitmapCreateScaledBitmap;
        }
        int i2 = this.f18783a;
        int i3 = this.b;
        int i4 = i2 * i3;
        int[] iArr = new int[i4];
        this.f18784a.getPixels(iArr, 0, i2, 0, 0, i2, i3);
        this.f18788a = new byte[i4 * 3];
        this.f18795e = false;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i4) {
            int i8 = iArr[i5];
            if (i8 == 0) {
                i6++;
            }
            byte[] bArr = this.f18788a;
            int i9 = i7 + 1;
            bArr[i7] = (byte) (i8 & 255);
            int i10 = i9 + 1;
            bArr[i9] = (byte) ((i8 >> 8) & 255);
            bArr[i10] = (byte) ((i8 >> 16) & 255);
            i5++;
            i7 = i10 + 1;
        }
        double d = ((double) (i6 * 100)) / ((double) i4);
        this.f18795e = d > 4.0d;
        if (Log.isLoggable(f18782a, 3)) {
            Log.d(f18782a, "got pixels for frame with " + d + "% transparent pixels");
        }
    }

    public void g(int ms) {
        this.g = Math.round(ms / 10.0f);
    }

    public void h(int code) {
        if (code >= 0) {
            this.k = code;
        }
    }

    public void i(float fps) {
        if (fps != 0.0f) {
            this.g = Math.round(100.0f / fps);
        }
    }

    public final void j(int w, int h) {
        this.f18783a = w;
        this.b = h;
    }

    public void k(int size) {
        this.i = size;
        int iPow = (int) Math.pow(2.0d, size + 1);
        this.j = iPow;
        this.f18789a = new boolean[iPow];
    }

    public void l(int quality) {
        if (quality < 1) {
            quality = 1;
        }
        this.l = quality;
    }

    public void m(int iter) {
        if (iter >= 0) {
            this.f = iter;
        }
    }

    public void n(int w, int h) {
        if (this.f18787a) {
            return;
        }
        this.c = w;
        this.d = h;
        if (w < 1) {
            this.c = 320;
        }
        if (h < 1) {
            this.d = 240;
        }
        this.f18794d = true;
    }

    public void o(int color) {
        this.f18786a = Integer.valueOf(color);
    }

    public boolean p(@Nullable OutputStream os) {
        boolean z = false;
        if (os == null) {
            return false;
        }
        this.f18790b = false;
        this.f18785a = os;
        try {
            y("GIF89a");
            z = true;
        } catch (IOException unused) {
        }
        this.f18787a = z;
        return z;
    }

    public boolean q(@NonNull String file) {
        boolean zP;
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            this.f18785a = bufferedOutputStream;
            zP = p(bufferedOutputStream);
            this.f18790b = true;
        } catch (IOException unused) {
            zP = false;
        }
        this.f18787a = zP;
        return zP;
    }

    public final void r() throws IOException {
        int i;
        int i2;
        this.f18785a.write(33);
        this.f18785a.write(249);
        this.f18785a.write(4);
        if (this.f18786a != null || this.f18795e) {
            i = 1;
            i2 = 2;
        } else {
            i = 0;
            i2 = 0;
        }
        int i3 = this.k;
        if (i3 >= 0) {
            i2 = i3 & 7;
        }
        this.f18785a.write(i | (i2 << 2) | 0 | 0);
        x(this.g);
        this.f18785a.write(this.e);
        this.f18785a.write(0);
    }

    public final void s(int x, int y) throws IOException {
        this.f18785a.write(44);
        x(x);
        x(y);
        x(this.f18783a);
        x(this.b);
        if (this.f18792c) {
            this.f18785a.write(0);
        } else {
            this.f18785a.write(this.i | 128);
        }
    }

    public final void t() throws IOException {
        x(this.f18783a);
        x(this.b);
        this.f18785a.write(this.i | 240);
        this.f18785a.write(0);
        this.f18785a.write(0);
    }

    public final void u() throws IOException {
        this.f18785a.write(33);
        this.f18785a.write(255);
        this.f18785a.write(11);
        y("NETSCAPE2.0");
        this.f18785a.write(3);
        this.f18785a.write(1);
        x(this.f);
        this.f18785a.write(0);
    }

    public final void v() throws IOException {
        OutputStream outputStream = this.f18785a;
        byte[] bArr = this.f18793c;
        outputStream.write(bArr, 0, bArr.length);
        int length = (this.j * 3) - this.f18793c.length;
        for (int i = 0; i < length; i++) {
            this.f18785a.write(0);
        }
    }

    public final void w() throws IOException {
        new qv4(this.f18783a, this.b, this.f18791b, this.h).f(this.f18785a);
    }

    public final void x(int value) throws IOException {
        this.f18785a.write(value & 255);
        this.f18785a.write((value >> 8) & 255);
    }

    public final void y(String s) throws IOException {
        for (int i = 0; i < s.length(); i++) {
            this.f18785a.write((byte) s.charAt(i));
        }
    }
}
