package com.byazt.oy;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.gqp.t;
import com.byazt.nr.m;
import com.byazt.nr.sp;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 706, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f28925a = 1;
    public static boolean c = false;
    public static t n = null;
    public static Context tt = null;
    public static boolean uj = false;
    public static String ve;

    public static String c() {
        if (TextUtils.isEmpty(ve)) {
            try {
                File file = new File(sp.c(getContext(), false, null), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                ve = file.getAbsolutePath();
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return ve;
    }

    public static Context getContext() {
        return tt;
    }

    public static int n() {
        return f28925a;
    }

    public static boolean tt() {
        return uj;
    }

    public static boolean uj() {
        return c;
    }

    public static t ve() {
        if (n == null) {
            t.c cVar = new t.c("v_config");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            n = cVar.c(10000L, timeUnit).tt(10000L, timeUnit).ve(10000L, timeUnit).c();
        }
        return n;
    }

    public static void c(Context context, String str) {
        tt = context.getApplicationContext();
        ve = str;
    }

    public static void c(boolean z) {
        uj = z;
    }

    public static void c(t tVar) {
        n = tVar;
    }
}
