package com.baidu.mshield.x6.e;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h f26767a = null;
    public static volatile boolean b = false;
    public static volatile boolean c = false;
    public static int d;
    public Context e;

    public class a extends com.baidu.mshield.x6.f.m.a {
        public final /* synthetic */ int b;

        public a(int i) {
            this.b = i;
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.c(h.this.e, this.b).b();
        }
    }

    public class b extends com.baidu.mshield.x6.f.m.a {
        public b() {
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.d(h.this.e).a();
        }
    }

    public class c extends com.baidu.mshield.x6.f.m.a {
        public final /* synthetic */ int b;

        public c(int i) {
            this.b = i;
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.e(h.this.e, this.b).a();
        }
    }

    public class d extends com.baidu.mshield.x6.f.m.a {
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public d(int i, int i2) {
            this.b = i;
            this.c = i2;
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.e(h.this.e, this.b, this.c).a();
        }
    }

    public class e extends com.baidu.mshield.x6.f.m.a {
        public e() {
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.b(h.this.e).a();
        }
    }

    public h(Context context) {
        this.e = context;
    }

    public void b() {
        try {
            com.baidu.mshield.x6.f.m.c.b().a(new b());
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public static synchronized h a(Context context) {
        if (f26767a == null) {
            f26767a = new h(context);
        }
        return f26767a;
    }

    public void a(int i, boolean z) {
        try {
            if (c) {
                return;
            }
            c = true;
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.e);
            if (!z && com.baidu.mshield.x6.f.f.c().equals(bVar.c())) {
                c = false;
            } else {
                com.baidu.mshield.x6.f.m.c.b().a(new a(i));
            }
        } catch (Throwable th) {
            c = false;
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public void a(int i) {
        try {
            com.baidu.mshield.x6.f.m.c.b().a(new c(i));
            a(5, false);
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public void a(int i, int i2) {
        try {
            com.baidu.mshield.x6.f.m.c.b().a(new d(i, i2));
            a(5, false);
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public void a() {
        try {
            com.baidu.mshield.x6.f.m.c.b().a(new e());
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }
}
