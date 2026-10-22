package com.zj.adlib;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class mv9 {
    /* JADX WARN: Code duplicated, block: B:20:0x0035 A[PHI: r8
      0x0035: PHI (r8v3 android.database.Cursor) = (r8v2 android.database.Cursor), (r8v4 android.database.Cursor) binds: [B:19:0x0033, B:12:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x003d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    public static String a(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursorQuery;
        ?? r7 = 0;
        try {
            try {
                cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                            cursorQuery.close();
                            return string;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                th = th;
                r7 = context;
                if (r7 != 0) {
                    r7.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r7 != 0) {
                r7.close();
            }
            throw th;
        }
        return null;
    }

    public static String b(Context context, Uri uri) {
        return d(context, uri);
    }

    public static String c(Context context, String str) {
        if (j(str)) {
            try {
                return b(context, Uri.parse(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static String d(Context context, Uri uri) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            int columnIndex = cursorQuery.getColumnIndex("_display_name");
            if (columnIndex == -1) {
                cursorQuery.close();
                return "";
            }
            cursorQuery.moveToFirst();
            File file = new File(context.getFilesDir(), cursorQuery.getString(columnIndex));
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            int iMin = Math.min(inputStreamOpenInputStream.available(), 1048576);
            System.currentTimeMillis();
            byte[] bArr = new byte[iMin];
            while (true) {
                int i = inputStreamOpenInputStream.read(bArr);
                if (i == -1) {
                    cursorQuery.close();
                    inputStreamOpenInputStream.close();
                    fileOutputStream.close();
                    return file.getPath();
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return uri.toString();
        }
    }

    public static String e(Uri uri, Context context) {
        String[] strArr = {"_data"};
        Cursor cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            cursorQuery.moveToFirst();
            int columnIndex = cursorQuery.getColumnIndex(strArr[0]);
            if (columnIndex > -1) {
                String string = cursorQuery.getString(columnIndex);
                cursorQuery.close();
                return string;
            }
            cursorQuery.close();
        }
        return b(context, uri);
    }

    public static Uri f(Context context, File file) {
        try {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".FileProvider", file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean g(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean h(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean i(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean j(String str) {
        return str != null && (str.startsWith("file://") || str.startsWith("content:"));
    }
}
