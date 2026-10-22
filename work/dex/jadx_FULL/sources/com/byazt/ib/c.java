package com.byazt.ib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.zj.adlib.sd6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1659, 20})
public class c {
    public static final ImageView.ScaleType c = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config tt = Bitmap.Config.ARGB_4444;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f28642a;
    public int n;
    public final int sp;
    public int uj;
    public final Bitmap.Config ve;
    public final ImageView.ScaleType x;
    public final int i = sd6.b;
    public final int da = 104857600;

    public c(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, int i3, int i4) {
        this.ve = config;
        this.uj = i;
        this.n = i2;
        this.x = scaleType;
        this.f28642a = i3;
        this.sp = i4;
        c(i, i2);
    }

    public static int c(int i, int i2, int i3, int i4, int i5, int i6) {
        double dMin = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        if (i5 > 0 && i6 > 0) {
            dMin = Math.max(dMin, Math.min(((double) Math.max(i, i2)) / ((double) Math.max(i5, i6)), ((double) Math.min(i, i2)) / ((double) Math.min(i5, i6))));
        }
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > dMin) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int c(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        }
        if (i2 == 0) {
            return i;
        }
        double d = ((double) i4) / ((double) i3);
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d2 = i2;
            return ((double) i) * d < d2 ? (int) (d2 / d) : i;
        }
        double d3 = i2;
        return ((double) i) * d > d3 ? (int) (d3 / d) : i;
    }

    public Bitmap c(byte[] bArr) {
        Bitmap bitmapDecodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.uj == 0 && this.n == 0) {
            options.inPreferredConfig = this.ve;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int iC = c(this.uj, this.n, i, i2, this.x);
            int iC2 = c(this.n, this.uj, i2, i, this.x);
            options.inJustDecodeBounds = false;
            options.inSampleSize = c(i, i2, iC, iC2, this.f28642a, this.sp);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iC || bitmapDecodeByteArray.getHeight() > iC2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iC, iC2, true);
                if (bitmapCreateScaledBitmap != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        if (bitmapDecodeByteArray != null && bitmapDecodeByteArray.getByteCount() > 104857600) {
            int width = bitmapDecodeByteArray.getWidth() / 2;
            int height = bitmapDecodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeByteArray, width, height, true);
                if (bitmapCreateScaledBitmap2 != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                return bitmapCreateScaledBitmap2;
            }
        }
        return bitmapDecodeByteArray;
    }

    private void c(int i, int i2) {
        if (i > 3840 && i2 > 3840) {
            if (i > i2) {
                this.uj = sd6.b;
                this.n = (i2 * sd6.b) / i;
                return;
            } else {
                this.uj = (i * sd6.b) / i2;
                this.n = sd6.b;
                return;
            }
        }
        if (i > 3840) {
            this.uj = sd6.b;
            this.n = (i2 * sd6.b) / i;
        } else if (i2 > 3840) {
            this.uj = (i * sd6.b) / i2;
            this.n = sd6.b;
        }
    }
}
