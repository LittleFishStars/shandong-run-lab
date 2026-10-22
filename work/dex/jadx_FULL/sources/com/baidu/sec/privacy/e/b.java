package com.baidu.sec.privacy.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.sec.privacy.f.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f26814a;
    public static Context b;

    public b(Context context) {
        b = context;
    }

    public static b a(Context context) {
        if (f26814a == null) {
            synchronized (b.class) {
                f26814a = new b(context);
            }
        }
        return f26814a;
    }

    @SuppressLint({"MissingPermission"})
    public NetworkInfo a() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) b.getSystemService("connectivity");
            if (e.a(b, new String[]{"android.permission.ACCESS_NETWORK_STATE"})) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return null;
        }
    }
}
