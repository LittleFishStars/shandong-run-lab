package com.alipay.sdk.m.y;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25543a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";

    public static String a() {
        return com.alipay.sdk.m.n.a.b;
    }

    public static String b(Context context) {
        if (EnvUtils.isPreSandBox()) {
            return com.alipay.sdk.m.n.a.c;
        }
        if (EnvUtils.isNewSanBox()) {
            return com.alipay.sdk.m.n.a.d;
        }
        if (context == null) {
            return com.alipay.sdk.m.n.a.f25467a;
        }
        String str = com.alipay.sdk.m.n.a.f25467a;
        return TextUtils.isEmpty(str) ? com.alipay.sdk.m.n.a.f25467a : str;
    }

    public static String a(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(f25543a), null, null, null, null);
        String string = null;
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("url")) : null;
            cursorQuery.close();
        }
        return string;
    }
}
