package com.byazt.pe;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.byazt.omf.gt;
import com.byazt.ue.n;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1306, 20})
public class c {
    private static ContentResolver c(Context context) {
        if (context == null) {
            try {
                context = gt.getContext();
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.getContentResolver();
    }

    public static int delete(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            ContentResolver contentResolverC = c(context);
            if (contentResolverC != null) {
                return contentResolverC.delete(c(Uri.parse(c(str) + str), str), str2, strArr);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static void insert(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverC = c(context);
            if (contentResolverC != null) {
                contentResolverC.insert(c(Uri.parse(c(str) + str), str), contentValues);
            }
        } catch (Throwable unused) {
        }
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ContentResolver contentResolverC = c(context);
            if (contentResolverC != null) {
                return contentResolverC.query(c(Uri.parse(c(str) + str), str), strArr, str2, strArr2, str5);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static boolean tt(String str) {
        return TextUtils.equals(str, "setting_global_info") || TextUtils.equals(str, "setting_base_info") || TextUtils.equals(str, "setting_rit");
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                ContentResolver contentResolverC = c(context);
                if (contentResolverC != null) {
                    return contentResolverC.update(c(Uri.parse(c(str) + str), str), contentValues, str2, strArr);
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    private static String c(String str) {
        return n.tt + "/t_db/" + (com.byazt.yws.tt.c(str) ? "ttopensdk2.db" : "ttopensdk.db") + WVNativeCallbackUtil.SEPERATER;
    }

    public static void c(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverC = c(context);
            if (contentResolverC != null) {
                contentResolverC.getType(c(Uri.parse(c(str2) + "unknown/execSQL?sql=" + Uri.encode(str)), str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static Uri c(Uri uri, String str) {
        if (uri == null) {
            return uri;
        }
        try {
            Uri.Builder builderBuildUpon = uri.buildUpon();
            builderBuildUpon.appendQueryParameter("layerType", tt(str) ? "1" : String.valueOf(com.byazt.xo.c.n()));
            return builderBuildUpon.build();
        } catch (Throwable unused) {
            return uri;
        }
    }
}
