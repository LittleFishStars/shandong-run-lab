package com.zj.adlib;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class uh9 {
    public uh9() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static File a(Uri uri) throws Throwable {
        Throwable th;
        InputStream inputStreamOpenInputStream;
        Log.d("UriUtils", "copyUri2Cache() called");
        try {
            inputStreamOpenInputStream = Utils.a().getContentResolver().openInputStream(uri);
            try {
                try {
                    File file = new File(Utils.a().getCacheDir(), "" + System.currentTimeMillis());
                    i.g1(file.getAbsolutePath(), inputStreamOpenInputStream);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return file;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            inputStreamOpenInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpenInputStream = null;
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
            }
            throw th;
        }
    }

    public static Uri b(File file) {
        if (!i.t0(file)) {
            return null;
        }
        return FileProvider.getUriForFile(Utils.a(), Utils.a().getPackageName() + ".utilcode.provider", file);
    }

    public static File c(Uri uri, String str, String[] strArr, String str2) {
        if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
            if (!TextUtils.isEmpty(uri.getLastPathSegment())) {
                return new File(uri.getLastPathSegment());
            }
        } else if ("com.tencent.mtt.fileprovider".equals(uri.getAuthority())) {
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path)) {
                return new File(Environment.getExternalStorageDirectory(), path.substring(10, path.length()));
            }
        } else if ("com.huawei.hidisk.fileprovider".equals(uri.getAuthority())) {
            String path2 = uri.getPath();
            if (!TextUtils.isEmpty(path2)) {
                return new File(path2.replace("/root", ""));
            }
        }
        Cursor cursorQuery = Utils.a().getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
        try {
            if (cursorQuery == null) {
                Log.d("UriUtils", uri.toString() + " parse failed(cursor is null). -> " + str2);
                return null;
            }
            if (!cursorQuery.moveToFirst()) {
                Log.d("UriUtils", uri.toString() + " parse failed(moveToFirst return false). -> " + str2);
                return null;
            }
            int columnIndex = cursorQuery.getColumnIndex("_data");
            if (columnIndex > -1) {
                return new File(cursorQuery.getString(columnIndex));
            }
            Log.d("UriUtils", uri.toString() + " parse failed(columnIndex: " + columnIndex + " is wrong). -> " + str2);
            return null;
        } catch (Exception unused) {
            Log.d("UriUtils", uri.toString() + " parse failed. -> " + str2);
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    public static Uri d(String str) {
        return Uri.parse("android.resource://" + Utils.a().getPackageName() + WVNativeCallbackUtil.SEPERATER + str);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static byte[] e(Uri uri) throws Throwable {
        Throwable th;
        InputStream inputStreamOpenInputStream;
        if (uri == null) {
            return null;
        }
        try {
            inputStreamOpenInputStream = Utils.a().getContentResolver().openInputStream(uri);
            try {
                try {
                    byte[] bArrM0 = i.m0(inputStreamOpenInputStream);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return bArrM0;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    Log.d("UriUtils", "uri to bytes failed.");
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            inputStreamOpenInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpenInputStream = null;
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
            }
            throw th;
        }
    }

    public static File f(Context context, Uri uri) {
        if (uri == null) {
            return null;
        }
        String strE = mv9.e(uri, context);
        return (strE == null || !new File(strE).exists()) ? a(uri) : new File(strE);
    }
}
