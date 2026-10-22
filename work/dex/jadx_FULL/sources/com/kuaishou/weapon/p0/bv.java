package com.kuaishou.weapon.p0;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class bv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f40069a = c.b("Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n", 2);
    private static String b = c.b(b, 2);
    private static String b = c.b(b, 2);

    public static String a(Context context) {
        String str = TextUtils.isEmpty(d(context)) ? "0" : "1";
        String strC = c(context);
        if (TextUtils.isEmpty(strC)) {
            return "0" + str;
        }
        String str2 = "1" + str;
        b(context, strC);
        return str2;
    }

    public static String b(Context context) {
        String strC = c(context);
        String strD = d(context);
        if (!TextUtils.isEmpty(strC) && TextUtils.equals(strC, strD)) {
            return strC;
        }
        if (!TextUtils.isEmpty(strC)) {
            b(context, strC);
            return strC;
        }
        if (TextUtils.isEmpty(strD)) {
            return "";
        }
        a(context, strD);
        return strD;
    }

    public static String c(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), f40069a);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return dd.a(context).e();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Context context, String str) {
        try {
            if (Settings.System.canWrite(context.getApplicationContext())) {
                Settings.System.putString(context.getContentResolver(), f40069a, str);
            }
        } catch (Exception unused) {
        }
    }

    public static void b(Context context, String str) {
        dd.a(context).d(str);
    }
}
