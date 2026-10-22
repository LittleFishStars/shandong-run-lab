package com.baidu.sec.privacy.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f26815a;
    public static Context b;

    public c(Context context) {
        b = context;
    }

    public static c a(Context context) {
        if (f26815a == null) {
            synchronized (c.class) {
                f26815a = new c(context);
            }
        }
        return f26815a;
    }

    public PackageInfo a(String str, int i) throws PackageManager.NameNotFoundException {
        try {
            if (com.baidu.sec.privacy.d.a.b(19)) {
                return b.getPackageManager().getPackageInfo(str, i);
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return null;
        }
    }
}
