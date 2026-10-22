package com.baidu.mshield.x6.e;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f f26764a;
    public final Context b;
    public final Runnable c = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f fVar = f.this;
                fVar.a(fVar.b);
            } catch (Throwable th) {
                com.baidu.mshield.x6.f.f.b(th);
            }
        }
    }

    public f(Context context) {
        this.b = context;
    }

    public static f b(Context context) {
        if (f26764a == null) {
            synchronized (f.class) {
                if (f26764a == null) {
                    f26764a = new f(context);
                }
            }
        }
        return f26764a;
    }

    public synchronized void a(long j) {
        try {
            com.baidu.mshield.b.c.a.a("startCheckDelayTime=" + j);
            com.baidu.mshield.x6.f.c.b().postDelayed(this.c, j);
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public final void a(Context context) {
        try {
            if (com.baidu.mshield.b.a.d.b(context)) {
                com.baidu.mshield.b.c.a.a(" doDelayWork ");
                com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
                if (!com.baidu.mshield.x6.f.f.c().equals(bVar.c())) {
                    h.a(context).a(1, true);
                }
                if (bVar.n() || h.b) {
                    return;
                }
                h.a(context).a(4);
            }
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }
}
