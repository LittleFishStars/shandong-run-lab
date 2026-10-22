package com.kwad.sdk.core.local;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.alibaba.android.arouter.utils.Consts;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.aw;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    public static LocalWriteResult a(Context context, String str, byte[] bArr, String str2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return b(context, str, bArr, str2);
        }
        return a(context, bArr, str2 + Consts.DOT + MimeTypeMap.getSingleton().getExtensionFromMimeType(str));
    }

    private static LocalWriteResult b(Context context, String str, byte[] bArr, String str2) throws Throwable {
        OutputStream outputStreamOpenOutputStream;
        LocalWriteResult localWriteResult = LocalWriteResult.FAIL;
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentValues contentValues = new ContentValues();
        ContentResolver contentResolver = context.getContentResolver();
        contentValues.put("_display_name", str2);
        contentValues.put(com.google.android.exoplayer2.offline.a.f3586e, str);
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
        contentValues.put("is_pending", (Integer) 1);
        Uri uriInsert = contentResolver.insert(uri, contentValues);
        if (uriInsert == null) {
            return localWriteResult;
        }
        OutputStream outputStream = null;
        try {
            outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
            try {
                try {
                    outputStreamOpenOutputStream.write(bArr);
                    outputStreamOpenOutputStream.flush();
                    outputStreamOpenOutputStream.close();
                } catch (Exception e) {
                    e = e;
                    c.printStackTraceOnly(e);
                }
            } catch (Throwable th) {
                th = th;
                outputStream = outputStreamOpenOutputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            outputStreamOpenOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamOpenOutputStream);
        contentValues.clear();
        contentValues.put("is_pending", (Integer) 0);
        contentResolver.update(uriInsert, contentValues, null, null);
        return LocalWriteResult.SUCCESS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private static LocalWriteResult a(Context context, byte[] bArr, String str) throws Throwable {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        LocalWriteResult localWriteResult;
        if (aw.aA(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), (String) str));
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        localWriteResult = LocalWriteResult.SUCCESS;
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                        str = fileOutputStream;
                    } catch (Exception e2) {
                        e = e2;
                        LocalWriteResult localWriteResult2 = LocalWriteResult.FAIL;
                        c.printStackTraceOnly(e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                        localWriteResult = localWriteResult2;
                        str = fileOutputStream;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                    throw th;
                }
            } catch (Exception e3) {
                fileOutputStream = null;
                e = e3;
            } catch (Throwable th3) {
                str = 0;
                th = th3;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                throw th;
            }
            return localWriteResult;
        }
        return LocalWriteResult.PERMISSION_DENIED;
    }
}
