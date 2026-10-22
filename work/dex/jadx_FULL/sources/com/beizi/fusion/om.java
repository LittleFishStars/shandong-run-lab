package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class om {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f27620a;

    public enum a {
        LOG_LEVEL_ERROR(2),
        LOG_LEVEL_WARN(4),
        LOG_LEVEL_DEBUG(8),
        LOG_LEVEL_STACK(16),
        LOG_LEVEL_RENDER(32),
        LOG_LEVEL_ALL(268435455);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27621a;

        a(int i) {
            this.f27621a = i;
        }

        public int b() {
            return this.f27621a;
        }
    }

    public static void a(Context context) {
        ll.a().a(context, "Scope_LogConfig.properties");
        int iB = ll.a().b();
        if (iB > 0) {
            if (iB > 5) {
                f27620a = a.LOG_LEVEL_ALL.b();
            } else {
                f27620a = 1 << iB;
            }
        }
    }

    public static void b(String str, String str2) {
        if (a(a.LOG_LEVEL_ERROR)) {
            Log.e("biz_beizi_adn_log", c(str, str2));
        }
    }

    private static String c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "biz_beizi_adn_log";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        return String.format("tag: %s msg: %s", str, str2);
    }

    public static void d(String str, String str2) {
        Log.i("biz_beizi_adn_log", c(str, str2));
    }

    public static void e(String str, String str2) {
        if (a(a.LOG_LEVEL_RENDER)) {
            Log.e("biz_beizi_adn_log", c(str, str2));
        }
    }

    public static void f(String str, String str2) {
        if (a(a.LOG_LEVEL_RENDER)) {
            Log.d("biz_beizi_adn_log", c(str, str2));
        }
    }

    public static boolean a(a aVar) {
        int i = f27620a;
        return i != 0 && i >= aVar.b();
    }

    public static void a(Throwable th) {
        if (!a(a.LOG_LEVEL_STACK) || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void a(String str, String str2) {
        if (a(a.LOG_LEVEL_DEBUG)) {
            Log.d("biz_beizi_adn_log", c(str, str2));
        }
    }
}
