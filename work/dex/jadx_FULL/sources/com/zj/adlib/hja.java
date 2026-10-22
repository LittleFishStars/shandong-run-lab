package com.zj.adlib;

import android.content.SharedPreferences;
import com.bwt.top.AdSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class hja {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static hja f42138a;

    public static hja c() {
        if (f42138a == null) {
            synchronized (hja.class) {
                if (f42138a == null) {
                    f42138a = new hja();
                }
            }
        }
        return f42138a;
    }

    public final SharedPreferences a(String str) {
        if (str == null) {
            return AdSdk.getInstance().getContext().getSharedPreferences("SP_com.bwt.top", 0);
        }
        return AdSdk.getInstance().getContext().getSharedPreferences("SP_com.bwt.top." + str, 0);
    }

    public void b(String str, String str2) {
        f(null, str, str2);
    }

    public String d(String str) {
        return e(null, str);
    }

    public String e(String str, String str2) {
        try {
            return a(str).getString(str2, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void f(String str, String str2, String str3) {
        try {
            a(str).edit().putString(str2, str3).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
