package com.byazt.uy;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1180, 71})
public final class x {
    public static Context c = null;
    public static volatile int da = 0;

    @SuppressLint({"StaticFieldLeak"})
    public static com.byazt.rx.c n = null;
    public static volatile String sl = null;
    public static long tt = 0;
    public static boolean uj = false;
    public static String ve = "default";
    public static volatile ConcurrentHashMap<Integer, String> x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.byazt.rx.tt f29123a = new com.byazt.rx.tt();
    public static tt sp = new tt();
    public static com.byazt.rx.x i = null;

    public static long a() {
        return tt;
    }

    public static com.byazt.rx.c c() {
        return n;
    }

    public static int da() {
        return da;
    }

    public static ConcurrentHashMap<Integer, String> i() {
        return x;
    }

    public static com.byazt.rx.tt n() {
        return f29123a;
    }

    public static String sl() {
        return sl;
    }

    public static String sp() {
        return ve;
    }

    public static tt tt() {
        return sp;
    }

    public static Context uj() {
        return c;
    }

    public static com.byazt.rx.x ve() {
        if (i == null) {
            synchronized (x.class) {
                i = new com.byazt.rx.x(c);
            }
        }
        return i;
    }

    public static boolean x() {
        return uj;
    }

    public static void c(Context context, n nVar) {
        tt = System.currentTimeMillis();
        c = context;
        n = new com.byazt.rx.c(context, nVar);
    }
}
