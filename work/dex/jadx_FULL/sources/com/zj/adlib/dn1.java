package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.blankj.utilcode.util.ImageUtils;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.king.zxing.c;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J`\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007J2\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0007J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0004H\u0002¨\u0006 "}, d2 = {"Lcom/zj/adlib/dn1;", "", "", "content", "", "codeSizePix", "Landroid/graphics/Bitmap;", "e", "codeColor", "bgColor", "Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;", "errorCorrectionLevel", "codeMargin", "logo", "logoSize", "", "logoScale", "f", "src", "a", "path", "i", "bitmap", "j", "contrast", "brightness", y6b.g, "d", "threshold", "c", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class dn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final dn1 f41231a = new dn1();

    @JvmStatic
    public static final Bitmap a(Bitmap src, Bitmap logo, int logoSize, float logoScale) {
        if (src == null) {
            return null;
        }
        if (logo == null) {
            return src;
        }
        int width = src.getWidth();
        int height = src.getHeight();
        int width2 = logo.getWidth();
        int height2 = logo.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        if (width2 == 0 || height2 == 0) {
            return src;
        }
        float f = width;
        float f2 = width2;
        float f3 = ((f * 1.0f) / 5) / f2;
        if (logoSize > 0) {
            float f4 = logoSize;
            if (f4 < f / 4.0f) {
                f3 = (((f4 * 1.0f) / f) * f) / f2;
            }
        }
        double d = logoScale;
        boolean z = false;
        if (0.01d <= d && d <= 0.25d) {
            z = true;
        }
        if (z) {
            f3 = (f * logoScale) / f2;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        try {
            Intrinsics.checkNotNull(bitmapCreateBitmap);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawBitmap(src, 0.0f, 0.0f, (Paint) null);
            canvas.scale(f3, f3, width / 2, height / 2);
            canvas.drawBitmap(logo, (width - width2) / 2, (height - height2) / 2, (Paint) null);
            canvas.save();
            canvas.restore();
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    public static /* synthetic */ Bitmap b(Bitmap bitmap, Bitmap bitmap2, int i, float f, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            f = 0.25f;
        }
        return a(bitmap, bitmap2, i, f);
    }

    @JvmStatic
    @Nullable
    public static final Bitmap e(@Nullable String content, int codeSizePix) {
        return g(content, codeSizePix, Color.parseColor("#2C3E50"), 0, null, 0, null, 0, 0.0f, 496, null);
    }

    @JvmStatic
    @Nullable
    public static final Bitmap f(@Nullable String content, int codeSizePix, int codeColor, int bgColor, @NotNull ErrorCorrectionLevel errorCorrectionLevel, int codeMargin, @Nullable Bitmap logo, int logoSize, float logoScale) {
        Intrinsics.checkNotNullParameter(errorCorrectionLevel, "errorCorrectionLevel");
        try {
            HashMap map = new HashMap();
            map.put(EncodeHintType.CHARACTER_SET, "utf-8");
            map.put(EncodeHintType.ERROR_CORRECTION, errorCorrectionLevel);
            map.put(EncodeHintType.MARGIN, String.valueOf(codeMargin));
            tv0 tv0VarA = new e57().a(content, BarcodeFormat.QR_CODE, codeSizePix, codeSizePix, map);
            int[] iArr = new int[codeSizePix * codeSizePix];
            for (int i = 0; i < codeSizePix; i++) {
                for (int i2 = 0; i2 < codeSizePix; i2++) {
                    if (tv0VarA.k(i2, i)) {
                        iArr[(i * codeSizePix) + i2] = codeColor;
                    } else {
                        iArr[(i * codeSizePix) + i2] = bgColor;
                    }
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(codeSizePix, codeSizePix, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(codeSizePix… Bitmap.Config.ARGB_8888)");
            bitmapCreateBitmap.setPixels(iArr, 0, codeSizePix, 0, 0, codeSizePix, codeSizePix);
            return logo == null ? bitmapCreateBitmap : a(bitmapCreateBitmap, logo, logoSize, logoScale);
        } catch (WriterException e) {
            u15.z(e.getMessage());
            return null;
        }
    }

    public static /* synthetic */ Bitmap g(String str, int i, int i2, int i3, ErrorCorrectionLevel errorCorrectionLevel, int i4, Bitmap bitmap, int i5, float f, int i6, Object obj) {
        return f(str, i, i2, i3, (i6 & 16) != 0 ? ErrorCorrectionLevel.H : errorCorrectionLevel, (i6 & 32) != 0 ? 0 : i4, (i6 & 64) != 0 ? null : bitmap, (i6 & 128) != 0 ? 0 : i5, (i6 & 256) != 0 ? 0.25f : f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Boolean, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    @JvmStatic
    @Nullable
    public static final String i(@NotNull String path) throws Throwable {
        String str;
        Throwable th;
        ?? r5;
        String absolutePath;
        Intrinsics.checkNotNullParameter(path, "path");
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(path);
        ?? r6 = 0;
        String strG = null;
        r6 = 0;
        if (bitmapDecodeFile == null) {
            return null;
        }
        try {
            try {
                int width = bitmapDecodeFile.getWidth();
                int height = bitmapDecodeFile.getHeight();
                if (width != 0 && height != 0) {
                    Bitmap bitmapJ = f41231a.j(bitmapDecodeFile);
                    HashMap map = new HashMap();
                    Vector vector = new Vector();
                    vector.addAll(c.c);
                    vector.addAll(c.d);
                    vector.addAll(c.e);
                    vector.addAll(c.f);
                    vector.addAll(c.g);
                    map.put(DecodeHintType.CHARACTER_SET, "utf-8");
                    DecodeHintType decodeHintType = DecodeHintType.TRY_HARDER;
                    ?? file = Boolean.TRUE;
                    Intrinsics.checkNotNullExpressionValue((Object) file, "TRUE");
                    map.put(decodeHintType, file);
                    map.put(DecodeHintType.POSSIBLE_FORMATS, vector);
                    try {
                        if (Intrinsics.areEqual(bitmapJ, bitmapDecodeFile)) {
                            absolutePath = path;
                            file = 0;
                        } else {
                            try {
                                String strH = en6.h();
                                if (strH == null) {
                                    strH = en6.F();
                                }
                                File file2 = new File(strH);
                                if (!file2.exists()) {
                                    file2.mkdirs();
                                }
                                file = new File(file2, "temp_qr_" + System.currentTimeMillis() + FileTypes.F);
                                try {
                                    if (ImageUtils.w0(bitmapJ, file, Bitmap.CompressFormat.JPEG, 90, false)) {
                                        absolutePath = file.getAbsolutePath();
                                        Intrinsics.checkNotNullExpressionValue(absolutePath, "tempFile.absolutePath");
                                        try {
                                            u15.a("保存预处理后的图片到临时文件: " + absolutePath);
                                            file = file;
                                        } catch (Exception e) {
                                            e = e;
                                            try {
                                                u15.z("保存临时文件失败: " + e.getMessage());
                                                file = file;
                                            } catch (Exception e2) {
                                                e = e2;
                                                str = strG;
                                                r6 = file;
                                                u15.z("二维码解析异常: " + e.getMessage());
                                                bitmapDecodeFile.recycle();
                                                if (r6 != 0) {
                                                    try {
                                                        if (r6.exists()) {
                                                            r6.delete();
                                                            u15.a("删除临时文件: " + r6.getAbsolutePath());
                                                        }
                                                    } catch (Exception e3) {
                                                        u15.z("删除临时文件失败: " + e3.getMessage());
                                                    }
                                                }
                                                return str;
                                            }
                                        }
                                    } else {
                                        absolutePath = path;
                                        file = file;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    absolutePath = path;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                absolutePath = path;
                                file = 0;
                            }
                        }
                        strG = cn1.B(absolutePath, bitmapJ.getWidth(), bitmapJ.getHeight(), map).g();
                        if (strG == null || strG.length() == 0) {
                            u15.a("预处理后无法识别，尝试使用原图");
                            strG = cn1.B(path, width, height, map).g();
                        }
                        if (!Intrinsics.areEqual(bitmapJ, bitmapDecodeFile)) {
                            bitmapJ.recycle();
                        }
                        bitmapDecodeFile.recycle();
                        if (file == 0) {
                            return strG;
                        }
                        try {
                            if (!file.exists()) {
                                return strG;
                            }
                            file.delete();
                            u15.a("删除临时文件: " + file.getAbsolutePath());
                            return strG;
                        } catch (Exception e6) {
                            u15.z("删除临时文件失败: " + e6.getMessage());
                            return strG;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r5 = file;
                        bitmapDecodeFile.recycle();
                        if (r5 == 0) {
                            throw th;
                        }
                        try {
                            if (!r5.exists()) {
                                throw th;
                            }
                            r5.delete();
                            u15.a("删除临时文件: " + r5.getAbsolutePath());
                            throw th;
                        } catch (Exception e7) {
                            u15.z("删除临时文件失败: " + e7.getMessage());
                            throw th;
                        }
                    }
                }
                bitmapDecodeFile.recycle();
                return null;
            } catch (Throwable th3) {
                th = th3;
                r5 = r6;
            }
        } catch (Exception e8) {
            e = e8;
            str = null;
        }
    }

    public final Bitmap c(Bitmap bitmap, int threshold) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            int i4 = ((int) (((((double) ((i3 >> 16) & 255)) * 0.299d) + (((double) ((i3 >> 8) & 255)) * 0.587d)) + (((double) (i3 & 255)) * 0.114d))) > threshold ? 255 : 0;
            iArr[i2] = Color.argb(255, i4, i4, i4);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, heig… Bitmap.Config.ARGB_8888)");
        bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmapCreateBitmap;
    }

    public final Bitmap d(Bitmap bitmap) {
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(bitmap.widt… Bitmap.Config.ARGB_8888)");
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    public final Bitmap h(Bitmap bitmap, float contrast, float brightness) {
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{contrast, 0.0f, 0.0f, 0.0f, brightness, 0.0f, contrast, 0.0f, 0.0f, brightness, 0.0f, 0.0f, contrast, 0.0f, brightness, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(bitmap.widt… Bitmap.Config.ARGB_8888)");
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    public final Bitmap j(Bitmap bitmap) {
        Bitmap bitmapC;
        try {
            if (bitmap.getWidth() > 2000 || bitmap.getHeight() > 2000) {
                bitmapC = ImageUtils.C(bitmap, 2000, 2000, true);
                Intrinsics.checkNotNullExpressionValue(bitmapC, "compressBySampleSize(pro…, maxSize, maxSize, true)");
            } else {
                bitmapC = bitmap;
            }
            return c(d(h(bitmapC, 1.5f, 20.0f)), 128);
        } catch (Exception e) {
            u15.z("图像预处理失败: " + e.getMessage());
            return bitmap;
        }
    }
}
