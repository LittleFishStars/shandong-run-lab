package com.alibaba.triver.embed.video.video;

import android.graphics.Bitmap;
import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.google.android.exoplayer2.util.FileTypes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24904a = ".jpeg";

    public static String a(Bitmap bitmap, String str) {
        if (bitmap == null) {
            return "";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, System.currentTimeMillis() + FileTypes.F);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
        return file2.getAbsolutePath();
    }

    public static String a(Bitmap bitmap, String str, String str2) {
        if (bitmap == null) {
            return "";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, str2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
        return file2.getAbsolutePath();
    }

    public static void a(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                a(file2);
            }
        }
        file.delete();
    }
}
