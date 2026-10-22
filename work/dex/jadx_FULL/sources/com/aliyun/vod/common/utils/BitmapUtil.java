package com.aliyun.vod.common.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BitmapUtil {
    private static final String TAG = "BitmapUtil";

    public static Bitmap drawableToBitmap(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static boolean writeBitmap(String str, Bitmap bitmap, int i, int i2, Bitmap.CompressFormat compressFormat, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(i / width, i2 / height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        boolean zWriteBitmap = writeBitmap(str, bitmapCreateBitmap, compressFormat, i3);
        bitmapCreateBitmap.recycle();
        return zWriteBitmap;
    }

    public static boolean writeBitmap(String str, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
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
            Log.e("BitmapUtil", "unable to open output file", e);
            return false;
        }
    }
}
