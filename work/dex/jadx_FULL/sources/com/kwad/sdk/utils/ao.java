package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class ao {
    private static String bpE;
    private static boolean bpF;

    public static String dx(Context context) {
        Cursor cursorQuery;
        if (!TextUtils.isEmpty(bpE) || bpF || !bd.Wb()) {
            return bpE;
        }
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
            try {
                bpE = j(cursorQuery);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
        bpF = TextUtils.isEmpty(bpE);
        return bpE;
    }

    public static boolean dy(Context context) {
        Cursor cursorQuery;
        boolean zK = false;
        if (!bd.Wb()) {
            return false;
        }
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
            try {
                zK = k(cursorQuery);
            } catch (Throwable unused) {
                try {
                    com.kwad.sdk.core.d.c.e("MiMarketHelper", "isSupportMiMarket2 failed");
                } catch (Throwable th) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
                    throw th;
                }
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
        if (!zK && bd.Wb()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "is Miui but not support MiMarket2.0");
        }
        return zK;
    }

    public static boolean hP(String str) {
        return str.startsWith("market://details") || str.startsWith("mimarket://details");
    }

    private static String j(Cursor cursor) {
        int columnIndex;
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "cursor is null");
            return "";
        }
        cursor.moveToFirst();
        int columnIndex2 = cursor.getColumnIndex("support");
        return ((columnIndex2 <= 0 || cursor.getInt(columnIndex2) != 0) && (columnIndex = cursor.getColumnIndex("detailStyle")) > 0) ? cursor.getString(columnIndex) : "";
    }

    private static boolean k(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "isSupportMiMarket2: cursor is null");
            return false;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("support");
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex).equals("true");
        }
        return false;
    }
}
