package com.zj.adlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.hzjizhun.admin.base.ad.RcSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class alb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static alb f40551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SharedPreferences f15290a;

    public alb(Context context) {
        if (context == null) {
            return;
        }
        try {
            this.f15290a = context.getSharedPreferences("cn.hzjizhun.admin.basessave_data", 0);
        } catch (Throwable unused) {
        }
    }

    public static alb a() {
        if (f40551a == null) {
            synchronized (alb.class) {
                if (f40551a == null) {
                    f40551a = new alb(RcSdk.e());
                }
            }
        }
        return f40551a;
    }

    public static String b(String str) {
        SharedPreferences sharedPreferences;
        try {
            return (TextUtils.isEmpty(str) || (sharedPreferences = a().f15290a) == null) ? "" : sharedPreferences.getString(str, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void c(String str, String str2) {
        SharedPreferences sharedPreferences;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (sharedPreferences = a().f15290a) != null) {
                sharedPreferences.edit().putString(str, str2).apply();
            }
        } catch (Throwable unused) {
        }
    }
}
