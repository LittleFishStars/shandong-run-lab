package com.byazt.ym;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.vb.n;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 13})
public class tt {
    public static String c(Context context, String str, n nVar) {
        if (TextUtils.isEmpty(str)) {
            return "sql is null";
        }
        try {
            c.c(context).c().c(nVar, Uri.decode(str));
            return "execSql ok";
        } catch (Throwable th) {
            return "exec sql exception:" + th.getMessage();
        }
    }

    public static int delete(Context context, String str, String str2, String[] strArr, n nVar) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return c.c(context).c().delete(nVar, str, str2, strArr);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static void insert(Context context, String str, ContentValues contentValues, n nVar) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            c.c(context).c().insert(nVar, str, (String) null, contentValues);
        } catch (Throwable unused) {
        }
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, n nVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return c.c(context).c().query(nVar, str, strArr, str2, strArr2, null, null, str5);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr, n nVar) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                return c.c(context).c().update(nVar, str, contentValues, str2, strArr);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static void insert(Context context, String str, List<com.byazt.vb.tt> list, n nVar) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            c.c(context).c().insert(nVar, str, (String) null, list);
        } catch (Throwable unused) {
        }
    }
}
