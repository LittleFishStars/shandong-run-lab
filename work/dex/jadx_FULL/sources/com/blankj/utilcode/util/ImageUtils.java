package com.blankj.utilcode.util;

import android.content.ContentValues;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.fl.saas.common.util.FileTypeUtils;
import com.zj.adlib.xd9;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ImageUtils {

    public enum ImageType {
        TYPE_JPG("jpg"),
        TYPE_PNG("png"),
        TYPE_GIF(FileTypeUtils.FILE_TYPE_GIF),
        TYPE_TIFF("tiff"),
        TYPE_BMP(FileTypeUtils.FILE_TYPE_BMP),
        TYPE_WEBP("webp"),
        TYPE_ICO("ico"),
        TYPE_UNKNOWN("unknown");

        String value;

        ImageType(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    public ImageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Bitmap A(Bitmap bitmap, int i) {
        return D(bitmap, i, false);
    }

    public static boolean A0(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i, boolean z) {
        return w0(bitmap, i.O(str), compressFormat, i, z);
    }

    public static Bitmap B(Bitmap bitmap, int i, int i2) {
        return C(bitmap, i, i2, false);
    }

    public static boolean B0(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, boolean z) {
        return A0(bitmap, str, compressFormat, 100, z);
    }

    public static Bitmap C(Bitmap bitmap, int i, int i2, boolean z) {
        if (k0(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        options.inSampleSize = t(options, i, i2);
        options.inJustDecodeBounds = false;
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    @Nullable
    public static File C0(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        return I0(bitmap, "", compressFormat, 100, false);
    }

    public static Bitmap D(Bitmap bitmap, int i, boolean z) {
        if (k0(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    @Nullable
    public static File D0(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        return I0(bitmap, "", compressFormat, i, false);
    }

    public static Bitmap E(Bitmap bitmap, float f, float f2) {
        return L0(bitmap, f, f2, false);
    }

    @Nullable
    public static File E0(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i, boolean z) {
        return I0(bitmap, "", compressFormat, i, z);
    }

    public static Bitmap F(Bitmap bitmap, float f, float f2, boolean z) {
        return L0(bitmap, f, f2, z);
    }

    @Nullable
    public static File F0(Bitmap bitmap, Bitmap.CompressFormat compressFormat, boolean z) {
        return I0(bitmap, "", compressFormat, 100, z);
    }

    public static Bitmap G(Bitmap bitmap, int i, int i2) {
        return N0(bitmap, i, i2, false);
    }

    @Nullable
    public static File G0(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return I0(bitmap, str, compressFormat, 100, false);
    }

    public static Bitmap H(Bitmap bitmap, int i, int i2, boolean z) {
        return N0(bitmap, i, i2, z);
    }

    @Nullable
    public static File H0(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i) {
        return I0(bitmap, str, compressFormat, i, false);
    }

    public static Bitmap I(@NonNull Bitmap bitmap, @ColorInt int i) {
        return J(bitmap, i, false);
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    public static File I0(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i, boolean z) throws Throwable {
        OutputStream outputStreamOpenOutputStream;
        if (TextUtils.isEmpty(str)) {
            str = Utils.a().getPackageName();
        }
        String str2 = System.currentTimeMillis() + LoginConstants.UNDER_LINE + i + Consts.DOT + (Bitmap.CompressFormat.JPEG.equals(compressFormat) ? "JPG" : compressFormat.name());
        OutputStream outputStream = null;
        if (Build.VERSION.SDK_INT < 29) {
            if (!i.u0("android.permission.WRITE_EXTERNAL_STORAGE")) {
                Log.e("ImageUtils", "save to album need storage permission");
                return null;
            }
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), str + WVNativeCallbackUtil.SEPERATER + str2);
            if (!w0(bitmap, file, compressFormat, i, z)) {
                return null;
            }
            i.I0(file);
            return file;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str2);
        contentValues.put(com.google.android.exoplayer2.offline.a.f3586e, "image/*");
        Uri uri = Environment.getExternalStorageState().equals("mounted") ? MediaStore.Images.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        contentValues.put("relative_path", Environment.DIRECTORY_DCIM + WVNativeCallbackUtil.SEPERATER + str);
        contentValues.put("is_pending", (Integer) 1);
        Uri uriInsert = Utils.a().getContentResolver().insert(uri, contentValues);
        if (uriInsert == null) {
            return null;
        }
        try {
            outputStreamOpenOutputStream = Utils.a().getContentResolver().openOutputStream(uriInsert);
            try {
                try {
                    bitmap.compress(compressFormat, i, outputStreamOpenOutputStream);
                    contentValues.clear();
                    contentValues.put("is_pending", (Integer) 0);
                    Utils.a().getContentResolver().update(uriInsert, contentValues, null, null);
                    File fileD1 = i.d1(uriInsert, Utils.a());
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return fileD1;
                } catch (Exception e2) {
                    e = e2;
                    Utils.a().getContentResolver().delete(uriInsert, null, null);
                    e.printStackTrace();
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                outputStream = outputStreamOpenOutputStream;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            outputStreamOpenOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    public static Bitmap J(@NonNull Bitmap bitmap, @ColorInt int i, boolean z) {
        if (k0(bitmap)) {
            return null;
        }
        if (!z) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        new Canvas(bitmap).drawColor(i, PorterDuff.Mode.DARKEN);
        return bitmap;
    }

    @Nullable
    public static File J0(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, boolean z) {
        return I0(bitmap, str, compressFormat, 100, z);
    }

    public static Bitmap K(@Nullable Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap K0(Bitmap bitmap, float f, float f2) {
        return L0(bitmap, f, f2, false);
    }

    public static byte[] L(@Nullable Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        return o(K(drawable));
    }

    public static Bitmap L0(Bitmap bitmap, float f, float f2, boolean z) {
        if (k0(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z && !bitmap.isRecycled() && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static byte[] M(Drawable drawable, Bitmap.CompressFormat compressFormat, int i) {
        if (drawable == null) {
            return null;
        }
        return p(K(drawable), compressFormat, i);
    }

    public static Bitmap M0(Bitmap bitmap, int i, int i2) {
        return N0(bitmap, i, i2, false);
    }

    public static Bitmap N(Bitmap bitmap, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false, to = 1.0d) float f, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false, to = 25.0d) float f2) {
        return P(bitmap, f, f2, false, false);
    }

    public static Bitmap N0(Bitmap bitmap, int i, int i2, boolean z) {
        if (k0(bitmap)) {
            return null;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        if (z && !bitmap.isRecycled() && bitmapCreateScaledBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateScaledBitmap;
    }

    public static Bitmap O(Bitmap bitmap, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false, to = 1.0d) float f, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false, to = 25.0d) float f2, boolean z) {
        return P(bitmap, f, f2, z, false);
    }

    public static Bitmap O0(Bitmap bitmap, float f, float f2) {
        return Q0(bitmap, f, f2, 0.0f, 0.0f, false);
    }

    public static Bitmap P(Bitmap bitmap, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false, to = 1.0d) float f, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false, to = 25.0d) float f2, boolean z, boolean z2) {
        if (k0(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(f, f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Paint paint = new Paint(3);
        Canvas canvas = new Canvas();
        paint.setColorFilter(new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
        canvas.scale(f, f);
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
        Bitmap bitmapR0 = r0(bitmapCreateBitmap, f2, z);
        if (f == 1.0f || z2) {
            if (z && !bitmap.isRecycled() && bitmapR0 != bitmap) {
                bitmap.recycle();
            }
            return bitmapR0;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapR0, width, height, true);
        if (!bitmapR0.isRecycled()) {
            bitmapR0.recycle();
        }
        if (z && !bitmap.isRecycled() && bitmapCreateScaledBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateScaledBitmap;
    }

    public static Bitmap P0(Bitmap bitmap, float f, float f2, float f3, float f4) {
        return Q0(bitmap, f, f2, f3, f4, false);
    }

    public static Bitmap Q(@DrawableRes int i) {
        Drawable drawable = ContextCompat.getDrawable(Utils.a(), i);
        if (drawable == null) {
            return null;
        }
        Canvas canvas = new Canvas();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap Q0(Bitmap bitmap, float f, float f2, float f3, float f4, boolean z) {
        if (k0(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setSkew(f, f2, f3, f4);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z && !bitmap.isRecycled() && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap R(@DrawableRes int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Resources resources = Utils.a().getResources();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = t(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static Bitmap R0(Bitmap bitmap, float f, float f2, boolean z) {
        return Q0(bitmap, f, f2, 0.0f, 0.0f, z);
    }

    public static Bitmap S(File file) {
        if (file == null) {
            return null;
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public static Bitmap S0(Bitmap bitmap, int i) {
        return T0(bitmap, i, false);
    }

    public static Bitmap T(File file, int i, int i2) {
        if (file == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        options.inSampleSize = t(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
    }

    public static Bitmap T0(Bitmap bitmap, int i, boolean z) {
        Bitmap bitmapCopy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        int i2 = i < 1 ? 1 : i;
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i3 = width * height;
        int[] iArr = new int[i3];
        bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2 + 1;
        int[] iArr2 = new int[i3];
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr6 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr6[i10] = i10 / i8;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i6, 3);
        int i11 = i2 + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            Bitmap bitmap2 = bitmapCopy;
            int i15 = height;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = -i2;
            int i25 = 0;
            while (i24 <= i2) {
                int i26 = i5;
                int[] iArr8 = iArr5;
                int i27 = iArr[i13 + Math.min(i4, Math.max(i24, 0))];
                int[] iArr9 = iArr7[i24 + i2];
                iArr9[0] = (i27 & xd9.p) >> 16;
                iArr9[1] = (i27 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i27 & 255;
                int iAbs = i11 - Math.abs(i24);
                int i28 = iArr9[0];
                i25 += i28 * iAbs;
                int i29 = iArr9[1];
                i16 += i29 * iAbs;
                int i30 = iArr9[2];
                i17 += iAbs * i30;
                if (i24 > 0) {
                    i21 += i28;
                    i22 += i29;
                    i23 += i30;
                } else {
                    i18 += i28;
                    i19 += i29;
                    i20 += i30;
                }
                i24++;
                i5 = i26;
                iArr5 = iArr8;
            }
            int i31 = i5;
            int[] iArr10 = iArr5;
            int i32 = i25;
            int i33 = i2;
            int i34 = 0;
            while (i34 < width) {
                iArr2[i13] = iArr6[i32];
                iArr3[i13] = iArr6[i16];
                iArr4[i13] = iArr6[i17];
                int i35 = i32 - i18;
                int i36 = i16 - i19;
                int i37 = i17 - i20;
                int[] iArr11 = iArr7[((i33 - i2) + i6) % i6];
                int i38 = i18 - iArr11[0];
                int i39 = i19 - iArr11[1];
                int i40 = i20 - iArr11[2];
                if (i12 == 0) {
                    iArr10[i34] = Math.min(i34 + i2 + 1, i4);
                }
                int i41 = iArr[i14 + iArr10[i34]];
                int i42 = (i41 & xd9.p) >> 16;
                iArr11[0] = i42;
                int i43 = (i41 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr11[1] = i43;
                int i44 = i41 & 255;
                iArr11[2] = i44;
                int i45 = i21 + i42;
                int i46 = i22 + i43;
                int i47 = i23 + i44;
                i32 = i35 + i45;
                i16 = i36 + i46;
                i17 = i37 + i47;
                i33 = (i33 + 1) % i6;
                int[] iArr12 = iArr7[i33 % i6];
                int i48 = iArr12[0];
                i18 = i38 + i48;
                int i49 = iArr12[1];
                i19 = i39 + i49;
                int i50 = iArr12[2];
                i20 = i40 + i50;
                i21 = i45 - i48;
                i22 = i46 - i49;
                i23 = i47 - i50;
                i13++;
                i34++;
                iArr6 = iArr6;
            }
            i14 += width;
            i12++;
            bitmapCopy = bitmap2;
            height = i15;
            i5 = i31;
            iArr5 = iArr10;
        }
        Bitmap bitmap3 = bitmapCopy;
        int i51 = i5;
        int[] iArr13 = iArr5;
        int i52 = height;
        int[] iArr14 = iArr6;
        int i53 = 0;
        while (i53 < width) {
            int i54 = -i2;
            int i55 = i6;
            int[] iArr15 = iArr;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = i54;
            int i64 = i54 * width;
            int i65 = 0;
            int i66 = 0;
            while (i63 <= i2) {
                int i67 = width;
                int iMax = Math.max(0, i64) + i53;
                int[] iArr16 = iArr7[i63 + i2];
                iArr16[0] = iArr2[iMax];
                iArr16[1] = iArr3[iMax];
                iArr16[2] = iArr4[iMax];
                int iAbs2 = i11 - Math.abs(i63);
                i65 += iArr2[iMax] * iAbs2;
                i66 += iArr3[iMax] * iAbs2;
                i56 += iArr4[iMax] * iAbs2;
                if (i63 > 0) {
                    i60 += iArr16[0];
                    i61 += iArr16[1];
                    i62 += iArr16[2];
                } else {
                    i57 += iArr16[0];
                    i58 += iArr16[1];
                    i59 += iArr16[2];
                }
                int i68 = i51;
                if (i63 < i68) {
                    i64 += i67;
                }
                i63++;
                i51 = i68;
                width = i67;
            }
            int i69 = width;
            int i70 = i51;
            int i71 = i53;
            int i72 = i2;
            int i73 = i52;
            int i74 = 0;
            while (i74 < i73) {
                iArr15[i71] = (iArr15[i71] & (-16777216)) | (iArr14[i65] << 16) | (iArr14[i66] << 8) | iArr14[i56];
                int i75 = i65 - i57;
                int i76 = i66 - i58;
                int i77 = i56 - i59;
                int[] iArr17 = iArr7[((i72 - i2) + i55) % i55];
                int i78 = i57 - iArr17[0];
                int i79 = i58 - iArr17[1];
                int i80 = i59 - iArr17[2];
                int i81 = i2;
                if (i53 == 0) {
                    iArr13[i74] = Math.min(i74 + i11, i70) * i69;
                }
                int i82 = iArr13[i74] + i53;
                int i83 = iArr2[i82];
                iArr17[0] = i83;
                int i84 = iArr3[i82];
                iArr17[1] = i84;
                int i85 = iArr4[i82];
                iArr17[2] = i85;
                int i86 = i60 + i83;
                int i87 = i61 + i84;
                int i88 = i62 + i85;
                i65 = i75 + i86;
                i66 = i76 + i87;
                i56 = i77 + i88;
                i72 = (i72 + 1) % i55;
                int[] iArr18 = iArr7[i72];
                int i89 = iArr18[0];
                i57 = i78 + i89;
                int i90 = iArr18[1];
                i58 = i79 + i90;
                int i91 = iArr18[2];
                i59 = i80 + i91;
                i60 = i86 - i89;
                i61 = i87 - i90;
                i62 = i88 - i91;
                i71 += i69;
                i74++;
                i2 = i81;
            }
            i53++;
            i51 = i70;
            i52 = i73;
            i6 = i55;
            iArr = iArr15;
            width = i69;
        }
        int i92 = width;
        bitmap3.setPixels(iArr, 0, i92, 0, 0, i92, i52);
        return bitmap3;
    }

    public static Bitmap U(FileDescriptor fileDescriptor) {
        if (fileDescriptor == null) {
            return null;
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    public static Bitmap U0(Bitmap bitmap) {
        return V0(bitmap, Boolean.FALSE);
    }

    public static Bitmap V(FileDescriptor fileDescriptor, int i, int i2) {
        if (fileDescriptor == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = t(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    public static Bitmap V0(Bitmap bitmap, Boolean bool) {
        if (k0(bitmap)) {
            return null;
        }
        Bitmap bitmapExtractAlpha = bitmap.extractAlpha();
        if (bool.booleanValue() && !bitmap.isRecycled() && bitmapExtractAlpha != bitmap) {
            bitmap.recycle();
        }
        return bitmapExtractAlpha;
    }

    public static Bitmap W(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return BitmapFactory.decodeStream(inputStream);
    }

    public static Bitmap W0(Bitmap bitmap) {
        return X0(bitmap, false);
    }

    public static Bitmap X(InputStream inputStream, int i, int i2) {
        if (inputStream == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        options.inSampleSize = t(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap X0(Bitmap bitmap, boolean z) {
        if (k0(bitmap)) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        if (z && !bitmap.isRecycled() && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap Y(String str) {
        if (i.C0(str)) {
            return null;
        }
        return BitmapFactory.decodeFile(str);
    }

    public static Bitmap Y0(Bitmap bitmap) {
        return a1(bitmap, 0, 0, false);
    }

    public static Bitmap Z(String str, int i, int i2) {
        if (i.C0(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = t(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap Z0(Bitmap bitmap, @IntRange(from = 0) int i, @ColorInt int i2) {
        return a1(bitmap, i, i2, false);
    }

    public static Bitmap a(Bitmap bitmap, @FloatRange(from = 1.0d) float f, @ColorInt int i, boolean z, float f2, boolean z2) {
        return b(bitmap, f, i, z, new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, z2);
    }

    public static Bitmap a0(byte[] bArr, int i) {
        if (bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, i, bArr.length);
    }

    public static Bitmap a1(Bitmap bitmap, @IntRange(from = 0) int i, @ColorInt int i2, boolean z) {
        if (k0(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMin = Math.min(width, height);
        Paint paint = new Paint(1);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        float f = iMin;
        float f2 = f / 2.0f;
        float f3 = width;
        float f4 = height;
        RectF rectF = new RectF(0.0f, 0.0f, f3, f4);
        rectF.inset((width - iMin) / 2.0f, (height - iMin) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.setTranslate(rectF.left, rectF.top);
        if (width != height) {
            matrix.preScale(f / f3, f / f4);
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (i > 0) {
            paint.setShader(null);
            paint.setColor(i2);
            paint.setStyle(Paint.Style.STROKE);
            float f5 = i;
            paint.setStrokeWidth(f5);
            canvas.drawCircle(f3 / 2.0f, f4 / 2.0f, f2 - (f5 / 2.0f), paint);
        }
        if (z && !bitmap.isRecycled() && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap b(Bitmap bitmap, @FloatRange(from = 1.0d) float f, @ColorInt int i, boolean z, float[] fArr, boolean z2) {
        if (k0(bitmap)) {
            return null;
        }
        if (!z2) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(1);
        paint.setColor(i);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f);
        if (z) {
            canvas.drawCircle(width / 2.0f, height / 2.0f, (Math.min(width, height) / 2.0f) - (f / 2.0f), paint);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            float f2 = f / 2.0f;
            rectF.inset(f2, f2);
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }
        return bitmap;
    }

    public static Bitmap b0(byte[] bArr, int i, int i2, int i3) {
        if (bArr.length == 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, i, bArr.length, options);
        options.inSampleSize = t(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, i, bArr.length, options);
    }

    public static Bitmap b1(Bitmap bitmap, boolean z) {
        return a1(bitmap, 0, 0, z);
    }

    public static Bitmap c(Bitmap bitmap, @FloatRange(from = 1.0d) float f, @ColorInt int i) {
        return a(bitmap, f, i, true, 0.0f, false);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x002c -> B:36:0x002f). Please report as a decompilation issue!!! */
    public static ImageType c0(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                if (file == null) {
                    return null;
                }
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        ImageType imageTypeD0 = d0(fileInputStream);
                        if (imageTypeD0 == null) {
                            fileInputStream.close();
                            return null;
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return imageTypeD0;
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public static Bitmap c1(Bitmap bitmap, float f) {
        return e1(bitmap, f, 0.0f, 0, false);
    }

    public static Bitmap d(Bitmap bitmap, @FloatRange(from = 1.0d) float f, @ColorInt int i, boolean z) {
        return a(bitmap, f, i, true, 0.0f, z);
    }

    public static ImageType d0(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[12];
            if (inputStream.read(bArr) != -1) {
                return f0(bArr);
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap d1(Bitmap bitmap, float f, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE) float f2, @ColorInt int i) {
        return e1(bitmap, f, f2, i, false);
    }

    public static Bitmap e(Bitmap bitmap, @FloatRange(from = 1.0d) float f, @ColorInt int i, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE) float f2) {
        return a(bitmap, f, i, false, f2, false);
    }

    public static ImageType e0(String str) {
        return c0(i.O(str));
    }

    public static Bitmap e1(Bitmap bitmap, float f, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE) float f2, @ColorInt int i, boolean z) {
        return h1(bitmap, new float[]{f, f, f, f, f, f, f, f}, f2, i, z);
    }

    public static Bitmap f(Bitmap bitmap, @FloatRange(from = 1.0d) float f, @ColorInt int i, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE) float f2, boolean z) {
        return a(bitmap, f, i, false, f2, z);
    }

    public static ImageType f0(byte[] bArr) {
        String upperCase = i.k(bArr).toUpperCase();
        if (upperCase.contains("FFD8FF")) {
            return ImageType.TYPE_JPG;
        }
        if (upperCase.contains("89504E47")) {
            return ImageType.TYPE_PNG;
        }
        if (upperCase.contains("47494638")) {
            return ImageType.TYPE_GIF;
        }
        if (upperCase.contains("49492A00") || upperCase.contains("4D4D002A")) {
            return ImageType.TYPE_TIFF;
        }
        if (upperCase.contains("424D")) {
            return ImageType.TYPE_BMP;
        }
        if (upperCase.startsWith("52494646") && upperCase.endsWith("57454250")) {
            return ImageType.TYPE_WEBP;
        }
        return (upperCase.contains("00000100") || upperCase.contains("00000200")) ? ImageType.TYPE_ICO : ImageType.TYPE_UNKNOWN;
    }

    public static Bitmap f1(Bitmap bitmap, float f, boolean z) {
        return e1(bitmap, f, 0.0f, 0, z);
    }

    public static Bitmap g(Bitmap bitmap, @FloatRange(from = 1.0d) float f, @ColorInt int i, float[] fArr) {
        return b(bitmap, f, i, false, fArr, false);
    }

    public static int g0(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Bitmap g1(Bitmap bitmap, float[] fArr, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE) float f, @ColorInt int i) {
        return h1(bitmap, fArr, f, i, false);
    }

    public static Bitmap h(Bitmap bitmap, @FloatRange(from = 1.0d) float f, @ColorInt int i, float[] fArr, boolean z) {
        return b(bitmap, f, i, false, fArr, z);
    }

    public static int[] h0(File file) {
        if (file == null) {
            return new int[]{0, 0};
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static Bitmap h1(Bitmap bitmap, float[] fArr, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE) float f, @ColorInt int i, boolean z) {
        if (k0(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Paint paint = new Paint(1);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        float f2 = f / 2.0f;
        rectF.inset(f2, f2);
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        if (f > 0.0f) {
            paint.setShader(null);
            paint.setColor(i);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(f);
            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawPath(path, paint);
        }
        if (z && !bitmap.isRecycled() && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap i(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3) {
        return j(bitmap, bitmap2, i, i2, i3, false);
    }

    public static int[] i0(String str) {
        return h0(i.O(str));
    }

    public static Bitmap i1(View view) {
        Bitmap bitmapCreateBitmap;
        if (view == null) {
            return null;
        }
        boolean zIsDrawingCacheEnabled = view.isDrawingCacheEnabled();
        boolean zWillNotCacheDrawing = view.willNotCacheDrawing();
        view.setDrawingCacheEnabled(true);
        view.setWillNotCacheDrawing(false);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null || drawingCache.isRecycled()) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache2 = view.getDrawingCache();
            if (drawingCache2 == null || drawingCache2.isRecycled()) {
                bitmapCreateBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.RGB_565);
                view.draw(new Canvas(bitmapCreateBitmap));
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(drawingCache2);
            }
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(drawingCache);
        }
        view.setWillNotCacheDrawing(zWillNotCacheDrawing);
        view.setDrawingCacheEnabled(zIsDrawingCacheEnabled);
        return bitmapCreateBitmap;
    }

    public static Bitmap j(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3, boolean z) {
        if (k0(bitmap)) {
            return null;
        }
        Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
        if (!k0(bitmap2)) {
            Paint paint = new Paint(1);
            Canvas canvas = new Canvas(bitmapCopy);
            paint.setAlpha(i3);
            canvas.drawBitmap(bitmap2, i, i2, paint);
        }
        if (z && !bitmap.isRecycled() && bitmapCopy != bitmap) {
            bitmap.recycle();
        }
        return bitmapCopy;
    }

    public static boolean j0(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == 66 && bArr[1] == 77;
    }

    public static Bitmap k(Bitmap bitmap, int i) {
        return l(bitmap, i, false);
    }

    public static boolean k0(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }

    public static Bitmap l(Bitmap bitmap, int i, boolean z) {
        if (k0(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, height - i, width, i, matrix, false);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(width, height + i, bitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        float f = height + 0;
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, f, (Paint) null);
        Paint paint = new Paint(1);
        paint.setShader(new LinearGradient(0.0f, height, 0.0f, bitmapCreateBitmap2.getHeight() + 0, 1895825407, 16777215, Shader.TileMode.MIRROR));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0.0f, f, width, bitmapCreateBitmap2.getHeight(), paint);
        if (!bitmapCreateBitmap.isRecycled()) {
            bitmapCreateBitmap.recycle();
        }
        if (z && !bitmap.isRecycled() && bitmapCreateBitmap2 != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap2;
    }

    public static boolean l0(byte[] bArr) {
        if (bArr.length < 6 || bArr[0] != 71 || bArr[1] != 73 || bArr[2] != 70 || bArr[3] != 56) {
            return false;
        }
        byte b = bArr[4];
        return (b == 55 || b == 57) && bArr[5] == 97;
    }

    public static Bitmap m(Bitmap bitmap, String str, float f, @ColorInt int i, float f2, float f3, boolean z) {
        if (k0(bitmap) || str == null) {
            return null;
        }
        Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
        Paint paint = new Paint(1);
        Canvas canvas = new Canvas(bitmapCopy);
        paint.setColor(i);
        paint.setTextSize(f);
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, f2, f3 + f, paint);
        if (z && !bitmap.isRecycled() && bitmapCopy != bitmap) {
            bitmap.recycle();
        }
        return bitmapCopy;
    }

    public static boolean m0(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return n0(file.getPath());
    }

    public static Bitmap n(Bitmap bitmap, String str, int i, @ColorInt int i2, float f, float f2) {
        return m(bitmap, str, i, i2, f, f2, false);
    }

    public static boolean n0(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return options.outWidth > 0 && options.outHeight > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static byte[] o(Bitmap bitmap) {
        return p(bitmap, Bitmap.CompressFormat.PNG, 100);
    }

    public static boolean o0(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == -1 && bArr[1] == -40;
    }

    public static byte[] p(@Nullable Bitmap bitmap, @NonNull Bitmap.CompressFormat compressFormat, int i) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean p0(byte[] bArr) {
        return bArr.length >= 8 && bArr[0] == -119 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71 && bArr[4] == 13 && bArr[5] == 10 && bArr[6] == 26 && bArr[7] == 10;
    }

    public static Drawable q(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(Utils.a().getResources(), bitmap);
    }

    @RequiresApi(17)
    public static Bitmap q0(Bitmap bitmap, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false, to = 25.0d) float f) {
        return r0(bitmap, f, false);
    }

    public static Bitmap r(@Nullable byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    @RequiresApi(17)
    public static Bitmap r0(Bitmap bitmap, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false, to = 25.0d) float f, boolean z) {
        if (!z) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        RenderScript renderScriptCreate = null;
        try {
            renderScriptCreate = RenderScript.create(Utils.a());
            renderScriptCreate.setMessageHandler(new RenderScript.RSMessageHandler());
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.setRadius(f);
            scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
            allocationCreateTyped.copyTo(bitmap);
            renderScriptCreate.destroy();
            return bitmap;
        } catch (Throwable th) {
            if (renderScriptCreate != null) {
                renderScriptCreate.destroy();
            }
            throw th;
        }
    }

    public static Drawable s(byte[] bArr) {
        return q(r(bArr));
    }

    public static Bitmap s0(Bitmap bitmap, int i, float f, float f2) {
        return t0(bitmap, i, f, f2, false);
    }

    public static int t(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        while (true) {
            if (i3 <= i2 && i4 <= i) {
                LogUtils.o("simpleSize:" + i5);
                return i5;
            }
            i3 >>= 1;
            i4 >>= 1;
            i5 <<= 1;
        }
    }

    public static Bitmap t0(Bitmap bitmap, int i, float f, float f2, boolean z) {
        if (k0(bitmap)) {
            return null;
        }
        if (i == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i, f, f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z && !bitmap.isRecycled() && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap u(Bitmap bitmap, int i, int i2, int i3, int i4) {
        return v(bitmap, i, i2, i3, i4, false);
    }

    public static boolean u0(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat) {
        return w0(bitmap, file, compressFormat, 100, false);
    }

    public static Bitmap v(Bitmap bitmap, int i, int i2, int i3, int i4, boolean z) {
        if (k0(bitmap)) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i, i2, i3, i4);
        if (z && !bitmap.isRecycled() && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static boolean v0(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i) {
        return w0(bitmap, file, compressFormat, i, false);
    }

    public static byte[] w(Bitmap bitmap, @IntRange(from = 0, to = 100) int i) {
        return x(bitmap, i, false);
    }

    public static boolean w0(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i, boolean z) throws Throwable {
        boolean zCompress = false;
        if (k0(bitmap)) {
            Log.e("ImageUtils", "bitmap is empty.");
            return false;
        }
        if (bitmap.isRecycled()) {
            Log.e("ImageUtils", "bitmap is recycled.");
            return false;
        }
        if (!i.q(file)) {
            Log.e("ImageUtils", "create or delete file <" + file + "> failed.");
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        zCompress = bitmap.compress(compressFormat, i, bufferedOutputStream2);
                        if (z && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                        bufferedOutputStream2.close();
                    } catch (IOException e) {
                        e = e;
                        bufferedOutputStream = bufferedOutputStream2;
                        e.printStackTrace();
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        return zCompress;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (IOException e4) {
                e = e4;
            }
            return zCompress;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] x(Bitmap bitmap, @IntRange(from = 0, to = 100) int i, boolean z) {
        if (k0(bitmap)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return byteArray;
    }

    public static boolean x0(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z) {
        return w0(bitmap, file, compressFormat, 100, z);
    }

    public static byte[] y(Bitmap bitmap, long j) {
        return z(bitmap, j, false);
    }

    public static boolean y0(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return A0(bitmap, str, compressFormat, 100, false);
    }

    public static byte[] z(Bitmap bitmap, long j, boolean z) {
        byte[] byteArray;
        int i = 0;
        if (k0(bitmap) || j <= 0) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (byteArrayOutputStream.size() <= j) {
            byteArray = byteArrayOutputStream.toByteArray();
        } else {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
            if (byteArrayOutputStream.size() >= j) {
                byteArray = byteArrayOutputStream.toByteArray();
            } else {
                int i3 = 0;
                while (i < i2) {
                    i3 = (i + i2) / 2;
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                    long size = byteArrayOutputStream.size();
                    if (size == j) {
                        break;
                    }
                    if (size > j) {
                        i2 = i3 - 1;
                    } else {
                        i = i3 + 1;
                    }
                }
                if (i2 == i3 - 1) {
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                }
                byteArray = byteArrayOutputStream.toByteArray();
            }
        }
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return byteArray;
    }

    public static boolean z0(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i) {
        return w0(bitmap, i.O(str), compressFormat, i, false);
    }
}
