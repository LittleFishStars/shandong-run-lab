package com.baidu.mshield.rp;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.utility.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {
    public static String a(Context context) {
        String str = "";
        try {
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
            String strM = aVarA.m();
            try {
                if (!TextUtils.isEmpty(strM)) {
                    aVarA.g("");
                }
                return c.a(context);
            } catch (Throwable th) {
                th = th;
                str = strM;
                com.baidu.mshield.utility.a.a(th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b(Context context) {
        String str = "";
        try {
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
            String strS = aVarA.s();
            try {
                if (!TextUtils.isEmpty(strS)) {
                    aVarA.k("");
                }
                return c.e(context);
            } catch (Throwable th) {
                th = th;
                str = strS;
                com.baidu.mshield.utility.a.a(th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(Context context) {
        String str = "";
        try {
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
            String strU = aVarA.u();
            try {
                if (!TextUtils.isEmpty(strU)) {
                    aVarA.l("");
                }
                return c.f(context);
            } catch (Throwable th) {
                th = th;
                str = strU;
                com.baidu.mshield.utility.a.a(th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
