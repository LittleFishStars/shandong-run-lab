package com.aliyun.svideosdk.common.b.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import com.aliyun.common.utils.d;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25628a = "com.aliyun.svideosdk.common.b.c.a";

    private boolean a(String str, String str2, Bitmap bitmap) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        try {
            return d.a(bitmap, str2, options.outMimeType);
        } catch (IOException e) {
            Log.e(f25628a, "generate image file failed", e);
        } finally {
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    public Bitmap a(String str, int i, int i2, int i3, int i4, int i5, int i6, Bitmap.Config config) {
        int i7;
        float f;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Canvas canvas = new Canvas();
        float f2 = i3;
        float f3 = (i * 1.0f) / f2;
        float f4 = i4;
        float f5 = (i2 * 1.0f) / f4;
        if (f3 > f5) {
            i7 = (int) (f2 * f5);
            f = f4 * f5;
        } else {
            i7 = (int) (f2 * f3);
            f = f4 * f3;
        }
        int i8 = (int) f;
        options.inSampleSize = (int) (1.0f / Math.min(f3, f5));
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        if (bitmapDecodeFile == null) {
            Log.e(f25628a, "invalid input path");
            return null;
        }
        if (i7 <= 0 || i8 <= 0) {
            return null;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeFile, i7, i8, false);
        if (bitmapCreateScaledBitmap == bitmapDecodeFile) {
            bitmapDecodeFile = null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
        bitmapCreateBitmap.eraseColor(i6);
        canvas.setBitmap(bitmapCreateBitmap);
        canvas.drawBitmap(bitmapCreateScaledBitmap, (i - i7) / 2, (i2 - i8) / 2, (Paint) null);
        if (bitmapDecodeFile != null) {
            bitmapDecodeFile.recycle();
        }
        bitmapCreateScaledBitmap.recycle();
        return i5 != 0 ? d.a(bitmapCreateBitmap, i5) : bitmapCreateBitmap;
    }

    public Bitmap a(String str, Rect rect, int i, int i2, int i3, Bitmap.Config config) {
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        if ((i * 1.0f) / i2 != (rect.width() * 1.0f) / rect.height()) {
            Log.w("AliYunLog", "Cutting area and the output ratio is inconsistent， pictures will be tensile deformation.");
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = config;
        BitmapFactory.decodeFile(str, options);
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (rect.width() <= 0 || rect.height() <= 0) {
            rect.left = 0;
            rect.right = i4;
            rect.top = 0;
            rect.bottom = i5;
        }
        options.inJustDecodeBounds = false;
        Bitmap bitmapCreateScaledBitmap = null;
        try {
            bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(str, true);
        } catch (IOException e) {
            Log.e(f25628a, "generate crop image file failed", e);
            bitmapRegionDecoderNewInstance = null;
        }
        if (bitmapRegionDecoderNewInstance != null) {
            Bitmap bitmapDecodeRegion = bitmapRegionDecoderNewInstance.decodeRegion(rect, options);
            if (bitmapDecodeRegion == null) {
                Log.e(f25628a, "invalid input path");
                bitmapRegionDecoderNewInstance.recycle();
                return null;
            }
            Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeRegion, i, i2, false);
            if (bitmapCreateScaledBitmap2 != bitmapDecodeRegion) {
                bitmapDecodeRegion.recycle();
            }
            bitmapRegionDecoderNewInstance.recycle();
            return i3 != 0 ? d.a(bitmapCreateScaledBitmap2, i3) : bitmapCreateScaledBitmap2;
        }
        Bitmap bitmapA = d.a(str, options);
        if (bitmapA == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapA, rect.left, rect.top, rect.width(), rect.height());
        if (bitmapCreateBitmap == bitmapA) {
            bitmapA = null;
        }
        if (bitmapCreateBitmap != null && (bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, i, i2, false)) != bitmapCreateBitmap) {
            bitmapCreateBitmap.recycle();
        }
        if (bitmapA != null) {
            bitmapA.recycle();
        }
        return i3 != 0 ? d.a(bitmapCreateScaledBitmap, i3) : bitmapCreateScaledBitmap;
    }

    public boolean a(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, Bitmap.Config config) {
        return a(str, str2, a(str, i, i2, i3, i4, i6, i5, config));
    }

    public boolean a(String str, String str2, Rect rect, int i, int i2, int i3, Bitmap.Config config) {
        return a(str, str2, a(str, rect, i, i2, i3, config));
    }
}
