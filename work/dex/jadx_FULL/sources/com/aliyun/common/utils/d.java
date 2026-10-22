package com.aliyun.common.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.zj.adlib.sw0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {
    public static Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (bitmapCreateBitmap.equals(bitmap)) {
            return bitmapCreateBitmap;
        }
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public static final Bitmap a(String str, BitmapFactory.Options options) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str = options != null ? BitmapFactory.decodeFile(str, options) : BitmapFactory.decodeFile(str);
            return str;
        } catch (Throwable th) {
            Log.e("AliYunLog", "load bmp failed!path[" + str + "]", th);
            return null;
        }
    }

    public static boolean a(Bitmap bitmap, String str, String str2) throws IOException {
        Bitmap.CompressFormat compressFormat;
        if (str == null || bitmap == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if (TextUtils.isEmpty(str2)) {
            str2 = AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG;
        }
        if (str.endsWith("jpg") || str.endsWith(AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG) || str2.endsWith("jpg") || str2.endsWith(AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG)) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        } else if (str.endsWith("png") || str2.endsWith("png")) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else {
            if (!str.endsWith("webp") && !str2.endsWith("webp")) {
                Log.e("AliYunLog", "not supported image format for '" + str + "'");
                fileOutputStream.flush();
                fileOutputStream.close();
                if (file.exists()) {
                    file.delete();
                }
                return false;
            }
            compressFormat = Bitmap.CompressFormat.WEBP;
        }
        bitmap.compress(compressFormat, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return true;
    }

    public static boolean a(String str, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            boolean zCompress = bitmap.compress(compressFormat, i, fileOutputStream);
            try {
                fileOutputStream.close();
                return zCompress;
            } catch (IOException unused) {
                return false;
            }
        } catch (FileNotFoundException e) {
            Log.e(sw0.f44798a, "unable to open output file", e);
            return false;
        }
    }
}
