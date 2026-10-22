package com.alibaba.triver.embed.video.video;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.fl.saas.common.util.FileTypeUtils;
import com.google.android.exoplayer2.util.FileTypes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24900a = "a";

    public static void a(Context context, String str, long j, long j2) {
        a(context, str, j, 0, 0, j2);
    }

    private static String b(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("jpg") && !lowerCase.endsWith(AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG)) {
            if (lowerCase.endsWith("png")) {
                return "image/png";
            }
            if (lowerCase.endsWith(FileTypeUtils.FILE_TYPE_GIF)) {
                return "image/gif";
            }
        }
        return "image/jpeg";
    }

    private static String c(String str) {
        String lowerCase = str.toLowerCase();
        return (lowerCase.endsWith("mp4") || lowerCase.endsWith("mpeg4") || !lowerCase.endsWith("3gp")) ? "video/mp4" : "video/3gp";
    }

    private static String d(String str) {
        String lowerCase = str.toLowerCase();
        return (lowerCase.endsWith("mp4") || lowerCase.endsWith("mpeg4") || !lowerCase.endsWith("3gp")) ? ".mp4" : FileTypes.f5253q;
    }

    private static boolean e(String str) {
        boolean zExists = new File(str).exists();
        RVLogger.e(f24900a, "文件不存在 path = " + str);
        return zExists;
    }

    public static void a(Context context, String str) {
        if (e(str)) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(new File(str)));
            context.sendBroadcast(intent);
        }
    }

    private static ContentValues a(String str, long j) {
        ContentValues contentValues = new ContentValues();
        File file = new File(str);
        long jA = a(j);
        contentValues.put("title", file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("date_modified", Long.valueOf(jA));
        contentValues.put("date_added", Long.valueOf(jA));
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        return contentValues;
    }

    public static void a(Context context, String str, long j, int i, int i2, long j2) {
        if (e(str)) {
            long jA = a(j);
            String strA = a(context, str, jA);
            if (!TextUtils.isEmpty(strA)) {
                str = strA;
            }
            ContentValues contentValuesA = a(str, jA);
            contentValuesA.put("datetaken", Long.valueOf(jA));
            if (j2 > 0) {
                contentValuesA.put("duration", Long.valueOf(j2));
            }
            if (i > 0) {
                contentValuesA.put("width", Integer.valueOf(i));
            }
            if (i2 > 0) {
                contentValuesA.put("height", Integer.valueOf(i2));
            }
            contentValuesA.put(com.google.android.exoplayer2.offline.a.f3586e, c(str));
            context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValuesA);
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(str)));
        }
    }

    private static String a(Context context, String str, long j) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), context.getPackageName());
        if (!file.exists() && !file.mkdir()) {
            return "";
        }
        File file2 = new File(file, j + d(str));
        try {
            a(str, file2.getPath());
        } catch (IOException e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
        return file2.getAbsolutePath();
    }

    private static void a(String str, String str2) throws IOException {
        if (new File(str).exists()) {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, i);
                    }
                }
            } catch (Exception e) {
                RVLogger.w(Log.getStackTraceString(e));
            } finally {
                fileInputStream.close();
                fileOutputStream.close();
            }
        }
    }

    private static boolean a(String str) {
        return str.toLowerCase().contains("dcim") || str.toLowerCase().contains(h.d);
    }

    private static long a(long j) {
        return j <= 0 ? System.currentTimeMillis() : j;
    }
}
