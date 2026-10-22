package com.baidu.a.a.a.a;

import android.content.Context;
import com.baidu.b.c;
import com.baidu.b.f;
import com.baidu.b.g;
import com.baidu.b.h;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f26236a;
    private final Context b;
    private h c;
    private g d;
    private c e;
    private h.a f;
    private h.a g;
    private long h;

    private a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.e = new c();
        this.c = new h(applicationContext, new com.baidu.b.e.a(applicationContext), this.e);
        this.d = new g(applicationContext, this.e);
    }

    private h.a a() {
        h.a aVar = this.g;
        if (aVar != null) {
            return aVar;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - this.h) > 3600000) {
            this.g = b();
            this.h = jCurrentTimeMillis;
        }
        h.a aVar2 = this.g;
        if (aVar2 != null) {
            return aVar2;
        }
        if (this.f == null) {
            this.g = d(null);
        }
        return this.g;
    }

    public static String a(Context context) {
        String strB;
        synchronized (a.class) {
            strB = b(context).a().b();
        }
        return strB;
    }

    public static void a(String str) {
        h.b(str);
    }

    public static a b(Context context) {
        a aVar;
        synchronized (f.class) {
            if (f26236a == null) {
                f26236a = new a(context);
            }
            aVar = f26236a;
        }
        return aVar;
    }

    private h.a b() {
        return b((String) null);
    }

    private h.a b(String str) {
        h.a aVarA = this.c.a();
        return aVarA == null ? c(str) : aVarA;
    }

    private h.a c(String str) {
        f fVarA = this.d.a(str);
        if (fVarA != null) {
            return this.c.a(fVarA);
        }
        return null;
    }

    private h.a d(String str) {
        return this.c.c(str);
    }
}
