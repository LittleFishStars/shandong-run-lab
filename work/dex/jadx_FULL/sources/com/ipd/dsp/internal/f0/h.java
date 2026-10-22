package com.ipd.dsp.internal.f0;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.Dsp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h {
    public static final String j = "1.08";

    @SuppressLint({"StaticFieldLeak"})
    public static volatile h k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.k0.b f38301a;
    public final com.ipd.dsp.internal.k0.a b;
    public final com.ipd.dsp.internal.h0.c c;
    public final com.ipd.dsp.internal.j0.a.b d;
    public final com.ipd.dsp.internal.n0.a.InterfaceC0905a e;
    public final com.ipd.dsp.internal.n0.e f;
    public final com.ipd.dsp.internal.l0.g g;
    public final Context h;

    @Nullable
    public d i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.ipd.dsp.internal.k0.b f38302a;
        public com.ipd.dsp.internal.k0.a b;
        public com.ipd.dsp.internal.h0.e c;
        public com.ipd.dsp.internal.j0.a.b d;
        public com.ipd.dsp.internal.n0.e e;
        public com.ipd.dsp.internal.l0.g f;
        public com.ipd.dsp.internal.n0.a.InterfaceC0905a g;
        public d h;
        public final Context i;

        public a(@NonNull Context context) {
            this.i = context.getApplicationContext();
        }

        public a a(com.ipd.dsp.internal.k0.b bVar) {
            this.f38302a = bVar;
            return this;
        }

        public a a(com.ipd.dsp.internal.k0.a aVar) {
            this.b = aVar;
            return this;
        }

        public a a(com.ipd.dsp.internal.h0.e eVar) {
            this.c = eVar;
            return this;
        }

        public a a(com.ipd.dsp.internal.j0.a.b bVar) {
            this.d = bVar;
            return this;
        }

        public a a(com.ipd.dsp.internal.n0.a.InterfaceC0905a interfaceC0905a) {
            this.g = interfaceC0905a;
            return this;
        }

        public a a(com.ipd.dsp.internal.n0.e eVar) {
            this.e = eVar;
            return this;
        }

        public a a(com.ipd.dsp.internal.l0.g gVar) {
            this.f = gVar;
            return this;
        }

        public a a(d dVar) {
            this.h = dVar;
            return this;
        }

        public h a() {
            if (this.f38302a == null) {
                this.f38302a = new com.ipd.dsp.internal.k0.b();
            }
            if (this.b == null) {
                this.b = new com.ipd.dsp.internal.k0.a();
            }
            if (this.c == null) {
                this.c = com.ipd.dsp.internal.g0.c.a(this.i);
            }
            if (this.d == null) {
                this.d = com.ipd.dsp.internal.g0.c.a();
            }
            if (this.g == null) {
                this.g = new com.ipd.dsp.internal.n0.b.a();
            }
            if (this.e == null) {
                this.e = new com.ipd.dsp.internal.n0.e();
            }
            if (this.f == null) {
                this.f = new com.ipd.dsp.internal.l0.g();
            }
            h hVar = new h(this.i, this.f38302a, this.b, this.c, this.d, this.g, this.e, this.f);
            hVar.a(this.h);
            com.ipd.dsp.internal.g0.c.a("OkDownload", "downloadStore[" + this.c + "] connectionFactory[" + this.d);
            return hVar;
        }
    }

    public h(Context context, com.ipd.dsp.internal.k0.b bVar, com.ipd.dsp.internal.k0.a aVar, com.ipd.dsp.internal.h0.e eVar, com.ipd.dsp.internal.j0.a.b bVar2, com.ipd.dsp.internal.n0.a.InterfaceC0905a interfaceC0905a, com.ipd.dsp.internal.n0.e eVar2, com.ipd.dsp.internal.l0.g gVar) {
        this.h = context;
        this.f38301a = bVar;
        this.b = aVar;
        this.c = eVar;
        this.d = bVar2;
        this.e = interfaceC0905a;
        this.f = eVar2;
        this.g = gVar;
        bVar.a(com.ipd.dsp.internal.g0.c.a(eVar));
    }

    public static h j() {
        if (k == null) {
            synchronized (h.class) {
                if (k == null) {
                    if (Dsp.getContext() == null) {
                        throw new IllegalStateException("context == null");
                    }
                    k = new a(Dsp.getContext()).a();
                }
            }
        }
        return k;
    }

    public com.ipd.dsp.internal.h0.c a() {
        return this.c;
    }

    public com.ipd.dsp.internal.k0.a b() {
        return this.b;
    }

    public com.ipd.dsp.internal.j0.a.b c() {
        return this.d;
    }

    public Context d() {
        return this.h;
    }

    public com.ipd.dsp.internal.k0.b e() {
        return this.f38301a;
    }

    public com.ipd.dsp.internal.l0.g f() {
        return this.g;
    }

    @Nullable
    public d g() {
        return this.i;
    }

    public com.ipd.dsp.internal.n0.a.InterfaceC0905a h() {
        return this.e;
    }

    public com.ipd.dsp.internal.n0.e i() {
        return this.f;
    }

    public void a(@Nullable d dVar) {
        this.i = dVar;
    }

    public static void a(@NonNull h hVar) {
        if (k == null) {
            synchronized (h.class) {
                if (k == null) {
                    k = hVar;
                } else {
                    throw new IllegalArgumentException("OkDownload must be null.");
                }
            }
            return;
        }
        throw new IllegalArgumentException("OkDownload must be null.");
    }
}
