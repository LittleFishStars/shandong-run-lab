package com.zj.adlib;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.exoplayer2.offline.a;
import com.google.android.exoplayer2.util.FileTypes;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class wf3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45586a = "FileHelper";

    public static ContentValues a(File file, long timeMillis) {
        ContentValues contentValues = new ContentValues();
        String strJ = j(file, FileTypes.F);
        long j = timeMillis / 1000;
        contentValues.put("title", strJ);
        contentValues.put(a.f3586e, k(strJ));
        contentValues.put("date_added", Long.valueOf(j));
        contentValues.put("date_modified", Long.valueOf(j));
        contentValues.put("datetaken", Long.valueOf(timeMillis));
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("_display_name", strJ);
            contentValues.put("relative_path", Environment.DIRECTORY_DCIM + File.separator + Environment.DIRECTORY_PICTURES);
            contentValues.put("is_pending", (Integer) 1);
        }
        return contentValues;
    }

    public static ContentValues b(File file, long timeMillis) {
        ContentValues contentValues = new ContentValues();
        String strJ = j(file, ".mp4");
        long j = timeMillis / 1000;
        contentValues.put("title", strJ);
        contentValues.put(a.f3586e, l(strJ));
        contentValues.put("date_added", Long.valueOf(j));
        contentValues.put("date_modified", Long.valueOf(j));
        contentValues.put("datetaken", Long.valueOf(timeMillis));
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("_display_name", strJ);
            contentValues.put("relative_path", Environment.DIRECTORY_DCIM + File.separator + Environment.DIRECTORY_MOVIES);
            contentValues.put("is_pending", (Integer) 1);
        }
        return contentValues;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0091 A[Catch: IOException -> 0x008d, TRY_LEAVE, TryCatch #8 {IOException -> 0x008d, blocks: (B:42:0x0089, B:46:0x0091), top: B:68:0x0089 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00a4 A[Catch: IOException -> 0x00a0, TRY_LEAVE, TryCatch #6 {IOException -> 0x00a0, blocks: (B:52:0x009c, B:56:0x00a4), top: B:66:0x009c }] */
    public static boolean c(String sourcePath, String targetPath) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        Exception e;
        if (TextUtils.isEmpty(sourcePath) || TextUtils.isEmpty(targetPath)) {
            return false;
        }
        File file = new File(sourcePath);
        File file2 = new File(targetPath);
        if (sourcePath.equals(targetPath) && file2.exists()) {
            return false;
        }
        if (!file2.exists()) {
            new File(targetPath.substring(0, targetPath.lastIndexOf(WVNativeCallbackUtil.SEPERATER))).mkdirs();
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i == -1) {
                                try {
                                    bufferedOutputStream.close();
                                    bufferedInputStream.close();
                                    return true;
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    return true;
                                }
                            }
                            bufferedOutputStream.write(bArr, 0, i);
                            th = th;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            } else if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                return false;
                            }
                        } else if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e6) {
                bufferedOutputStream = null;
                e = e6;
            } catch (Throwable th3) {
                bufferedOutputStream = null;
                th = th3;
            }
        } catch (Exception e7) {
            bufferedOutputStream = null;
            e = e7;
            bufferedInputStream = null;
        } catch (Throwable th4) {
            bufferedOutputStream = null;
            th = th4;
            bufferedInputStream = null;
        }
    }

    public static boolean d(String oldPath, OutputStream out) throws Throwable {
        i4a.b(f45586a, "oldPath = " + oldPath);
        FileInputStream fileInputStream = null;
        try {
            try {
                if (!new File(oldPath).exists()) {
                    i4a.p(f45586a, String.format("文件(%s)不存在。", oldPath));
                    m(fileInputStream);
                    m(out);
                    return false;
                }
                FileInputStream fileInputStream2 = new FileInputStream(oldPath);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = fileInputStream2.read(bArr);
                        if (i == -1) {
                            out.flush();
                            m(fileInputStream2);
                            m(out);
                            return true;
                        }
                        out.write(bArr, 0, i);
                    }
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    i4a.b(f45586a, "复制单个文件操作出错");
                    e.printStackTrace();
                    m(fileInputStream);
                    m(out);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    m(fileInputStream);
                    m(out);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static String e(String filePath) {
        String name = new File(filePath).getName();
        int iLastIndexOf = name.lastIndexOf("?");
        if (iLastIndexOf > 0) {
            name = name.substring(0, iLastIndexOf);
        }
        int iLastIndexOf2 = name.lastIndexOf(Consts.DOT);
        return (iLastIndexOf2 == -1 || name.length() <= iLastIndexOf2) ? "" : name.substring(iLastIndexOf2);
    }

    public static Uri f() {
        return Build.VERSION.SDK_INT >= 29 ? MediaStore.Images.Media.getContentUri("external_primary") : MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    public static Uri g() {
        return Build.VERSION.SDK_INT >= 29 ? MediaStore.Video.Media.getContentUri("external_primary") : MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    public static boolean h(Context context, File mediaFile, boolean isImage) throws Throwable {
        boolean zD;
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriF = isImage ? f() : g();
        Uri uriInsert = contentResolver.insert(uriF, isImage ? a(mediaFile, jCurrentTimeMillis) : b(mediaFile, jCurrentTimeMillis));
        if (uriInsert == null) {
            i4a.p(f45586a, "MediaStore insert failed, collection=" + uriF);
            return false;
        }
        try {
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
            if (outputStreamOpenOutputStream == null) {
                return false;
            }
            zD = d(mediaFile.getAbsolutePath(), outputStreamOpenOutputStream);
        } catch (IOException e) {
            i4a.b(f45586a, "save to album failed");
            e.printStackTrace();
            zD = false;
        }
        if (!zD) {
            contentResolver.delete(uriInsert, null, null);
            return false;
        }
        if (Build.VERSION.SDK_INT < 29) {
            return true;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_pending", (Integer) 0);
        contentResolver.update(uriInsert, contentValues, null, null);
        return true;
    }

    public static boolean i(String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        return options.outWidth != -1;
    }

    public static String j(File file, String defaultSuffix) {
        String name = file.getName();
        if (TextUtils.isEmpty(name)) {
            return System.currentTimeMillis() + defaultSuffix;
        }
        if (name.contains(Consts.DOT)) {
            return name;
        }
        String strE = e(file.getAbsolutePath());
        if (TextUtils.isEmpty(strE)) {
            return name + defaultSuffix;
        }
        return name + strE;
    }

    public static String k(String displayName) {
        if (displayName.toLowerCase().endsWith(".png")) {
            return "image/png";
        }
        if (displayName.toLowerCase().endsWith(".gif")) {
            return "image/gif";
        }
        return displayName.toLowerCase().endsWith(".webp") ? "image/webp" : "image/jpeg";
    }

    public static String l(String displayName) {
        String lowerCase = displayName.toLowerCase();
        if (lowerCase.endsWith(".3gp")) {
            return "video/3gpp";
        }
        return lowerCase.endsWith(FileTypes.f5250n) ? "video/webm" : "video/mp4";
    }

    public static void m(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean n(String mediaFilePath, Context context) {
        if (context != null && !TextUtils.isEmpty(mediaFilePath)) {
            File file = new File(mediaFilePath);
            if (file.exists() && file.length() != 0) {
                return h(context, file, i(mediaFilePath));
            }
            i4a.b(f45586a, "file:" + mediaFilePath + " is not exists or empty!");
        }
        return false;
    }
}
