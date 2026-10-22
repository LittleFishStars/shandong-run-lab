package com.zj.adlib;

import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.hzjizhun.admin.JZAdSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class eva {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static eva f41534a;

    public static eva e() {
        if (f41534a == null) {
            synchronized (eva.class) {
                if (f41534a == null) {
                    f41534a = new eva();
                }
            }
        }
        return f41534a;
    }

    public final SharedPreferences a(String str) {
        if (TextUtils.isEmpty(str)) {
            return JZAdSdk.getInstance().getContext().getSharedPreferences("SP_cn.hzjizhun.admin", 0);
        }
        return JZAdSdk.getInstance().getContext().getSharedPreferences("SP_cn.hzjizhun.admin." + str, 0);
    }

    public void b(String str, String str2) {
        h(null, str, str2);
    }

    public String c(String str) {
        return f(null, str);
    }

    public float d(String str) {
        try {
            return a("").getFloat(str, 0.0f);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public String f(String str, String str2) {
        try {
            return a(str).getString(str2, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void g(String str, float f) {
        try {
            a("").edit().putFloat(str, f).apply();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void h(String str, String str2, String str3) {
        try {
            a(str).edit().putString(str2, str3).apply();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
