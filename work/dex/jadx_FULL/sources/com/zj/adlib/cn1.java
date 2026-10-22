package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.king.zxing.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class cn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41002a = 450;
    public static final int b = 800;

    public cn1() {
        throw new AssertionError();
    }

    public static String A(String str, Map<DecodeHintType, ?> map) {
        ug7 ug7VarC = C(str, map);
        if (ug7VarC != null) {
            return ug7VarC.g();
        }
        return null;
    }

    public static ug7 B(String str, int i, int i2, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        boolean z;
        ug7 ug7VarD = null;
        try {
            d57 d57Var = new d57();
            b87 b87VarU = u(c(str, i, i2));
            if (b87VarU != null) {
                boolean z2 = false;
                try {
                    ug7VarD = d57Var.d(new jv0(new r34(b87VarU)), map);
                    z = false;
                } catch (Exception unused) {
                    z = true;
                }
                if (z) {
                    try {
                        ug7VarD = d57Var.d(new jv0(new r34(b87VarU.f())), map);
                        z = false;
                    } catch (Exception unused2) {
                        z = true;
                    }
                }
                if (z) {
                    try {
                        ug7VarD = d57Var.d(new jv0(new nu3(b87VarU)), map);
                    } catch (Exception unused3) {
                        z2 = true;
                    }
                } else {
                    z2 = z;
                }
                if (z2 && b87VarU.h()) {
                    try {
                        ug7VarD = d57Var.d(new jv0(new r34(b87VarU.i())), map);
                    } catch (Exception unused4) {
                    }
                }
                d57Var.reset();
            }
        } catch (Exception e) {
            u15.z(e.getMessage());
        }
        return ug7VarD;
    }

    public static ug7 C(String str, Map<DecodeHintType, ?> map) {
        return B(str, 450, 800, map);
    }

    public static Bitmap a(Bitmap bitmap, String str, int i, @ColorInt int i2, int i3) {
        if (bitmap == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height + i + (i3 * 2), Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(i);
            textPaint.setColor(i2);
            textPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(str, width / 2, height + (i / 2) + i3, textPaint);
            canvas.save();
            canvas.restore();
            return bitmapCreateBitmap;
        } catch (Exception e) {
            u15.z(e.getMessage());
            return null;
        }
    }

    public static Bitmap b(Bitmap bitmap, Bitmap bitmap2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        if (width2 == 0 || height2 == 0) {
            return bitmap;
        }
        float f2 = (width * f) / width2;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.scale(f2, f2, width / 2, height / 2);
            canvas.drawBitmap(bitmap2, (width - width2) / 2, (height - height2) / 2, (Paint) null);
            canvas.save();
            canvas.restore();
            return bitmapCreateBitmap;
        } catch (Exception e) {
            u15.z(e.getMessage());
            return null;
        }
    }

    public static Bitmap c(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        float f = options.outWidth;
        float f2 = options.outHeight;
        float f3 = i;
        float f4 = i2;
        int iMax = Math.max(f > f3 ? (int) (f / f3) : 1, f2 > f4 ? (int) (f2 / f4) : 1);
        options.inSampleSize = iMax > 0 ? iMax : 1;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap d(String str, int i, int i2) {
        return h(str, BarcodeFormat.CODE_128, i, i2, null);
    }

    public static Bitmap e(String str, int i, int i2, boolean z) {
        return k(str, BarcodeFormat.CODE_128, i, i2, null, z, 40, -16777216);
    }

    public static Bitmap f(String str, int i, int i2, boolean z, @ColorInt int i3) {
        return k(str, BarcodeFormat.CODE_128, i, i2, null, z, 40, i3);
    }

    public static Bitmap g(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return h(str, barcodeFormat, i, i2, null);
    }

    public static Bitmap h(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        return k(str, barcodeFormat, i, i2, map, false, 40, -16777216);
    }

    public static Bitmap i(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map, boolean z) {
        return k(str, barcodeFormat, i, i2, map, z, 40, -16777216);
    }

    public static Bitmap j(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map, boolean z, @ColorInt int i3) {
        return k(str, barcodeFormat, i, i2, map, z, 40, i3);
    }

    public static Bitmap k(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map, boolean z, int i3, @ColorInt int i4) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            tv0 tv0VarA = new ht5().a(str, barcodeFormat, i, i2, map);
            int iT = tv0VarA.t();
            int iO = tv0VarA.o();
            int[] iArr = new int[iT * iO];
            for (int i5 = 0; i5 < iO; i5++) {
                int i6 = i5 * iT;
                for (int i7 = 0; i7 < iT; i7++) {
                    iArr[i6 + i7] = tv0VarA.k(i7, i5) ? i4 : -1;
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iT, iO, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, iT, 0, 0, iT, iO);
            return z ? a(bitmapCreateBitmap, str, i3, i4, i3 / 2) : bitmapCreateBitmap;
        } catch (WriterException e) {
            u15.z(e.getMessage());
            return null;
        }
    }

    public static Bitmap l(String str, BarcodeFormat barcodeFormat, int i, int i2, boolean z, @ColorInt int i3) {
        return k(str, barcodeFormat, i, i2, null, z, 40, i3);
    }

    public static Bitmap m(String str, int i) {
        return o(str, i, null);
    }

    public static Bitmap n(String str, int i, int i2) {
        return t(str, i, null, i2);
    }

    public static Bitmap o(String str, int i, Bitmap bitmap) {
        return t(str, i, bitmap, -16777216);
    }

    public static Bitmap p(String str, int i, Bitmap bitmap, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        HashMap map = new HashMap();
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        map.put(EncodeHintType.MARGIN, 1);
        return r(str, i, bitmap, f, map);
    }

    public static Bitmap q(String str, int i, Bitmap bitmap, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f, int i2) {
        HashMap map = new HashMap();
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        map.put(EncodeHintType.MARGIN, 1);
        return s(str, i, bitmap, f, map, i2);
    }

    public static Bitmap r(String str, int i, Bitmap bitmap, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f, Map<EncodeHintType, ?> map) {
        return s(str, i, bitmap, f, map, -16777216);
    }

    public static Bitmap s(String str, int i, Bitmap bitmap, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f, Map<EncodeHintType, ?> map, int i2) {
        try {
            tv0 tv0VarA = new e57().a(str, BarcodeFormat.QR_CODE, i, i, map);
            int[] iArr = new int[i * i];
            for (int i3 = 0; i3 < i; i3++) {
                for (int i4 = 0; i4 < i; i4++) {
                    if (tv0VarA.k(i4, i3)) {
                        iArr[(i3 * i) + i4] = i2;
                    } else {
                        iArr[(i3 * i) + i4] = -1;
                    }
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, i, 0, 0, i, i);
            return bitmap != null ? b(bitmapCreateBitmap, bitmap, f) : bitmapCreateBitmap;
        } catch (WriterException e) {
            u15.z(e.getMessage());
            return null;
        }
    }

    public static Bitmap t(String str, int i, Bitmap bitmap, int i2) {
        return q(str, i, bitmap, 0.2f, i2);
    }

    public static b87 u(@NonNull Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        return new b87(width, height, iArr);
    }

    public static String v(String str) {
        HashMap map = new HashMap();
        Vector vector = new Vector();
        vector.addAll(c.c);
        vector.addAll(c.d);
        vector.addAll(c.e);
        vector.addAll(c.f);
        vector.addAll(c.g);
        map.put(DecodeHintType.CHARACTER_SET, "utf-8");
        map.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        map.put(DecodeHintType.POSSIBLE_FORMATS, vector);
        return w(str, map);
    }

    public static String w(String str, Map<DecodeHintType, Object> map) {
        ug7 ug7VarY = y(str, map);
        if (ug7VarY != null) {
            return ug7VarY.g();
        }
        return null;
    }

    public static ug7 x(String str, int i, int i2, Map<DecodeHintType, Object> map) throws NotFoundException {
        boolean z;
        ug7 ug7VarC = null;
        try {
            ft5 ft5Var = new ft5();
            ft5Var.e(map);
            b87 b87VarU = u(c(str, i, i2));
            if (b87VarU != null) {
                boolean z2 = false;
                try {
                    ug7VarC = ft5Var.c(new jv0(new r34(b87VarU)));
                    z = false;
                } catch (Exception unused) {
                    z = true;
                }
                if (z) {
                    try {
                        ug7VarC = ft5Var.c(new jv0(new r34(b87VarU.f())));
                        z = false;
                    } catch (Exception unused2) {
                        z = true;
                    }
                }
                if (z) {
                    try {
                        ug7VarC = ft5Var.c(new jv0(new nu3(b87VarU)));
                    } catch (Exception unused3) {
                        z2 = true;
                    }
                } else {
                    z2 = z;
                }
                if (z2 && b87VarU.h()) {
                    try {
                        ug7VarC = ft5Var.c(new jv0(new r34(b87VarU.i())));
                    } catch (Exception unused4) {
                    }
                }
                ft5Var.reset();
            }
        } catch (Exception e) {
            u15.z(e.getMessage());
        }
        return ug7VarC;
    }

    public static ug7 y(String str, Map<DecodeHintType, Object> map) {
        return x(str, 450, 800, map);
    }

    public static String z(String str) {
        HashMap map = new HashMap();
        map.put(DecodeHintType.CHARACTER_SET, "utf-8");
        map.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        return A(str, map);
    }
}
