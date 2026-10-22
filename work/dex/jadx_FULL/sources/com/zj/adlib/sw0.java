package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class sw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44798a = "BitmapUtil";

    public static Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static boolean b(Bitmap bmp, String outputPath, String srcMimeType) throws IOException {
        return c(bmp, outputPath, srcMimeType, 100);
    }

    public static boolean c(Bitmap bmp, String outputPath, String srcMimeType, int quality) throws IOException {
        if (outputPath == null || bmp == null) {
            return false;
        }
        File file = new File(outputPath);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if (TextUtils.isEmpty(srcMimeType)) {
            srcMimeType = AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG;
        }
        if (outputPath.endsWith("jpg") || outputPath.endsWith(AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG) || srcMimeType.endsWith("jpg") || srcMimeType.endsWith(AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG)) {
            bmp.compress(Bitmap.CompressFormat.JPEG, quality, fileOutputStream);
        } else if (outputPath.endsWith("png") || srcMimeType.endsWith("png")) {
            bmp.compress(Bitmap.CompressFormat.PNG, quality, fileOutputStream);
        } else {
            if (!outputPath.endsWith("webp") && !srcMimeType.endsWith("webp")) {
                Log.e(f44798a, "not supported image format for '" + outputPath + "'");
                fileOutputStream.flush();
                fileOutputStream.close();
                if (file.exists()) {
                    file.delete();
                }
                return false;
            }
            bmp.compress(Bitmap.CompressFormat.WEBP, quality, fileOutputStream);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        return true;
    }

    public static Bitmap d(Bitmap origin, float alpha) {
        if (origin == null) {
            return null;
        }
        int width = origin.getWidth();
        int height = origin.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(alpha);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false);
        if (bitmapCreateBitmap.equals(origin)) {
            return bitmapCreateBitmap;
        }
        origin.recycle();
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public static final Bitmap e(String str, BitmapFactory.Options options) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str = options != null ? BitmapFactory.decodeFile(str, options) : BitmapFactory.decodeFile(str);
            return str;
        } catch (Throwable th) {
            Log.e(f44798a, "load bmp failed!path[" + str + "]", th);
            return null;
        }
    }

    public static boolean f(String path, Bitmap bitmap, int w, int h, Bitmap.CompressFormat format, int quality) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(w / width, h / height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        boolean zG = g(path, bitmapCreateBitmap, format, quality);
        bitmapCreateBitmap.recycle();
        return zG;
    }

    public static boolean g(String path, Bitmap bitmap, Bitmap.CompressFormat format, int quality) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            boolean zCompress = bitmap.compress(format, quality, fileOutputStream);
            try {
                fileOutputStream.close();
                return zCompress;
            } catch (IOException unused) {
                return false;
            }
        } catch (FileNotFoundException e) {
            Log.e(f44798a, "unable to open output file", e);
            return false;
        }
    }
}
