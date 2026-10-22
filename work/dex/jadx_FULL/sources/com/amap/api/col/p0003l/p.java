package com.amap.api.col.p0003l;

import android.content.Context;
import com.zj.adlib.l6b;
import com.zj.adlib.s4b;
import com.zj.adlib.t4b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static p f26042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1075a = l6b.d(s4b.v("RYW1hcF9kZXZpY2VfYWRpdQ"));

    public p(Context context) {
        this.f1074a = context.getApplicationContext();
    }

    public static p a(Context context) {
        if (f26042a == null) {
            synchronized (p.class) {
                if (f26042a == null) {
                    f26042a = new p(context);
                }
            }
        }
        return f26042a;
    }

    public final synchronized void b() {
        try {
            if (fj.D() == null) {
                fj.v(q.a());
            }
        } catch (Throwable unused) {
        }
    }

    public final void c(String str) {
        t4b.b(this.f1074a).d(this.f1075a);
        t4b.b(this.f1074a).g(str);
    }
}
