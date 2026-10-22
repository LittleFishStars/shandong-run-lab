package com.insightface.sdk.inspireface.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SDKUtils {
    public static void copyFilesFromAssets(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length > 0) {
                if (!new File(str2).mkdir()) {
                    Log.d("mkdir", "can't make folder");
                }
                for (String str3 : list) {
                    copyFilesFromAssets(context, str + WVNativeCallbackUtil.SEPERATER + str3, str2 + WVNativeCallbackUtil.SEPERATER + str3);
                }
                return;
            }
            InputStream inputStreamOpen = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i == -1) {
                    fileOutputStream.flush();
                    inputStreamOpen.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean cropperBitmap(Bitmap bitmap, int[] iArr, String str, String str2) {
        float width = 160 / bitmap.getWidth();
        float height = 192 / bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(width, height);
        matrix.setScale(-1.0f, 1.0f);
        int iMax = Math.max(0, iArr[0]);
        int iMax2 = Math.max(0, iArr[1]);
        int width2 = iArr[2] - iMax;
        int height2 = iArr[3] - iMax2;
        if (bitmap.getWidth() - width2 <= 0) {
            width2 = bitmap.getWidth();
        }
        int i = width2 - 1;
        if (bitmap.getHeight() - height2 <= 0) {
            height2 = bitmap.getHeight();
        }
        try {
            saveBitmap(str, str2, Bitmap.createBitmap(bitmap, iMax, iMax2, i, height2 - 1, matrix, true));
            return true;
        } catch (Exception unused) {
            Log.d("crop", LoginConstants.EXT);
            return false;
        }
    }

    public static Bitmap getImageFromAssetsFile(Context context, String str) {
        Bitmap bitmapDecodeStream = null;
        try {
            InputStream inputStreamOpen = context.getResources().getAssets().open(str);
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
            inputStreamOpen.close();
            return bitmapDecodeStream;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmapDecodeStream;
        }
    }

    public static void mkdirsFeaturesAssets(Context context, String str, String str2, String str3) {
        try {
            File file = new File(str);
            File file2 = new File(str + str2);
            File file3 = new File(str + str3);
            if (!file.mkdir()) {
                Log.d("mkdir", "can't make folder: " + file);
            }
            if (!file2.mkdir()) {
                Log.d("mkdir", "can't make folder: " + file2);
            }
            if (file3.mkdir()) {
                return;
            }
            Log.d("mkdir", "can't make folder: " + file3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String saveBitmap(String str, String str2, Bitmap bitmap) throws IOException {
        File file = new File(str, str2 + ".png");
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return file.getAbsolutePath();
    }
}
