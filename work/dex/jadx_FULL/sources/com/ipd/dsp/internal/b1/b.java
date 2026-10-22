package com.ipd.dsp.internal.b1;

import android.app.Activity;
import android.text.TextUtils;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.o;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class b {
    public static final String f = "Click";
    public com.ipd.dsp.internal.b1.a b;
    public e c;
    public com.ipd.dsp.internal.c1.a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f38208a = "";
    public boolean e = false;

    public static final class a extends b implements com.ipd.dsp.internal.c1.b.InterfaceC0865b {
        public static final String l = "开始下载";
        public static final String m = "下载中";
        public static final String n = "继续下载";
        public static final String o = "立即安装";
        public static final String p = "打开";
        public WeakReference<Activity> g;
        public com.ipd.dsp.internal.e1.d h;
        public com.ipd.dsp.internal.c1.b i;
        public c j;
        public com.ipd.dsp.internal.b1.a.b k;

        /* JADX INFO: renamed from: com.ipd.dsp.internal.b1.b$a$a, reason: collision with other inner class name */
        public class C0862a implements com.ipd.dsp.internal.c1.a.InterfaceC0864a {
            public C0862a() {
            }

            @Override // com.ipd.dsp.internal.c1.a.InterfaceC0864a
            public String a() {
                a aVar = a.this;
                aVar.e = false;
                aVar.g();
                a aVar2 = a.this;
                if (aVar2.b != null) {
                    if (a.p.equals(aVar2.f38208a)) {
                        k.a(b.f, "installed");
                        a aVar3 = a.this;
                        aVar3.b.a((com.ipd.dsp.internal.b1.a.b) null, aVar3.g != null ? (Activity) a.this.g.get() : null);
                    } else if (a.o.equals(a.this.f38208a)) {
                        k.a(b.f, "downloaded");
                        a aVar4 = a.this;
                        aVar4.b.a(aVar4.k);
                    } else if (a.m.equals(a.this.f38208a)) {
                        k.a(b.f, "downloading...");
                        try {
                            a.this.b.i(null);
                        } catch (Throwable th) {
                            k.e(b.f, "pauseError", th);
                        }
                        a.this.a(a.n);
                    } else if (a.n.equals(a.this.f38208a)) {
                        k.a(b.f, "paused...");
                        try {
                            a.this.b.j(null);
                        } catch (Throwable th2) {
                            k.e(b.f, "pauseError", th2);
                        }
                        a.this.a(a.m);
                    } else if (a.l.equals(a.this.f38208a)) {
                        a.this.b.k(null);
                        a.this.a(a.m);
                    }
                }
                return a.this.f38208a;
            }

            @Override // com.ipd.dsp.internal.c1.a.InterfaceC0864a
            public void b() {
                a aVar = a.this;
                aVar.e = false;
                aVar.j.onDownloadConfirmDialogDismiss();
                a.this.d = null;
            }

            @Override // com.ipd.dsp.internal.c1.a.InterfaceC0864a
            public boolean c() {
                return a.this.j.c();
            }
        }

        public a(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar) {
            super(dVar, bVar);
            this.k = new com.ipd.dsp.internal.b1.a.b() { // from class: com.zj.adlib.oma
                @Override // com.ipd.dsp.internal.b1.a.b
                public final void a(int i, boolean z, int i2, String str) {
                    this.f43780a.a(i, z, i2, str);
                }
            };
            this.h = dVar;
            this.b.a(this);
            g();
        }

        public void e() {
            com.ipd.dsp.internal.b1.a aVar = this.b;
            if (aVar != null) {
                aVar.g(null);
            }
        }

        public final void f() {
            c cVar = this.j;
            if (cVar == null) {
                this.e = false;
                return;
            }
            cVar.onDownloadConfirmDialogShow();
            WeakReference<Activity> weakReference = this.g;
            Activity activityB = weakReference != null ? weakReference.get() : com.ipd.dsp.internal.c2.f.a().b();
            if (activityB == null || activityB.isFinishing() || activityB.isDestroyed()) {
                k.f(b.f, "activity is not running");
                this.e = false;
            } else {
                com.ipd.dsp.internal.c1.a aVar = new com.ipd.dsp.internal.c1.a(activityB, this.h, this.f38208a, new C0862a());
                this.d = aVar;
                aVar.show();
            }
        }

        public final void g() {
            com.ipd.dsp.internal.b1.a aVar = this.b;
            if (aVar == null) {
                return;
            }
            if (aVar.d()) {
                a(p);
                return;
            }
            if (this.b.c() && this.b.e()) {
                a(o);
            } else {
                if (m.equals(this.f38208a) || n.equals(this.f38208a)) {
                    return;
                }
                a(l);
            }
        }

        @Override // com.ipd.dsp.internal.c1.b.InterfaceC0865b
        public void onFailure(String str) {
            a(l);
        }

        @Override // com.ipd.dsp.internal.c1.b.InterfaceC0865b
        public void onStart() {
        }

        @Override // com.ipd.dsp.internal.c1.b.InterfaceC0865b
        public void onSuccess() {
            a(o);
            this.b.a(this.k);
        }

        public final /* synthetic */ void a(int i, boolean z, int i2, String str) {
            if (z) {
                g();
            }
        }

        @Override // com.ipd.dsp.internal.b1.b
        public void b(final Runnable runnable, final boolean z) {
            com.ipd.dsp.internal.b1.a aVar = this.b;
            if (aVar != null) {
                com.ipd.dsp.internal.b1.a.b bVar = new com.ipd.dsp.internal.b1.a.b() { // from class: com.zj.adlib.nma
                    @Override // com.ipd.dsp.internal.b1.a.b
                    public final void a(int i, boolean z2, int i2, String str) {
                        this.f43561a.b(runnable, z, i, z2, i2, str);
                    }
                };
                WeakReference<Activity> weakReference = this.g;
                aVar.a(bVar, weakReference != null ? weakReference.get() : null);
            } else {
                this.e = false;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        @Override // com.ipd.dsp.internal.b1.b
        public void c() {
            super.c();
            com.ipd.dsp.internal.c1.b bVar = this.i;
            if (bVar != null) {
                bVar.d();
                this.i = null;
            }
            WeakReference<Activity> weakReference = this.g;
            if (weakReference != null) {
                weakReference.clear();
                this.g = null;
            }
            this.k = null;
            this.j = null;
            this.h = null;
        }

        public final boolean d() {
            com.ipd.dsp.internal.e1.d dVar = this.h;
            return dVar != null && dVar.w.f;
        }

        @Override // com.ipd.dsp.internal.b1.b
        public void a(Activity activity) {
            if (activity != null) {
                this.g = new WeakReference<>(activity);
            }
        }

        public void a(c cVar) {
            this.j = cVar;
        }

        public final /* synthetic */ void a(final Runnable runnable, boolean z, int i, boolean z2, int i2, String str) {
            com.ipd.dsp.internal.b1.a aVar = this.b;
            if (aVar == null) {
                this.e = false;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            if (!z2 && i2 != 4) {
                if (aVar.a()) {
                    if (!z && d()) {
                        f();
                        return;
                    }
                    if (this.b.e() && this.b.c()) {
                        k.a(b.f, "downloaded");
                        this.b.a(this.k);
                        this.e = false;
                        if (runnable != null) {
                            runnable.run();
                            return;
                        }
                        return;
                    }
                    if (m.equals(this.f38208a)) {
                        k.a(b.f, "downloading...");
                        this.e = false;
                        if (runnable != null) {
                            runnable.run();
                            return;
                        }
                        return;
                    }
                    this.b.k(null);
                    a(m);
                    this.e = false;
                    if (runnable != null) {
                        runnable.run();
                        return;
                    }
                    return;
                }
                this.b.g(new com.ipd.dsp.internal.b1.a.b() { // from class: com.zj.adlib.mma
                    @Override // com.ipd.dsp.internal.b1.a.b
                    public final void a(int i3, boolean z3, int i4, String str2) {
                        this.f43337a.a(runnable, i3, z3, i4, str2);
                    }
                });
                return;
            }
            this.e = false;
            if (runnable != null) {
                runnable.run();
            }
        }

        public final /* synthetic */ void b(final Runnable runnable, final boolean z, int i, boolean z2, int i2, String str) {
            com.ipd.dsp.internal.b1.a aVar = this.b;
            if (aVar == null) {
                this.e = false;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            if (!z2 && i2 != 4) {
                aVar.e(new com.ipd.dsp.internal.b1.a.b() { // from class: com.zj.adlib.pma
                    @Override // com.ipd.dsp.internal.b1.a.b
                    public final void a(int i3, boolean z3, int i4, String str2) {
                        this.f44017a.a(runnable, z, i3, z3, i4, str2);
                    }
                });
                return;
            }
            this.e = false;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.ipd.dsp.internal.b1.b
        public String b() {
            return TextUtils.isEmpty(this.f38208a) ? l : this.f38208a;
        }

        public final /* synthetic */ void a(Runnable runnable, int i, boolean z, int i2, String str) {
            this.e = false;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.ipd.dsp.internal.c1.b.InterfaceC0865b
        public void a(long j, long j2) {
            if (m.equals(this.f38208a)) {
                com.ipd.dsp.internal.c1.a aVar = this.d;
                if (aVar != null && aVar.isShowing()) {
                    this.d.a(o.a(j, j2));
                }
                e eVar = this.c;
                if (eVar != null) {
                    eVar.a(j, j2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.b1.b$b, reason: collision with other inner class name */
    public static class C0863b extends b {
        public C0863b(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar) {
            super(dVar, bVar);
        }

        public final /* synthetic */ void a(Runnable runnable, int i, boolean z, int i2, String str) {
            this.e = false;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.ipd.dsp.internal.b1.b
        public String b() {
            return "在浏览器中查看";
        }

        @Override // com.ipd.dsp.internal.b1.b
        public void b(final Runnable runnable, boolean z) {
            com.ipd.dsp.internal.b1.a aVar = this.b;
            if (aVar != null) {
                aVar.f(new com.ipd.dsp.internal.b1.a.b() { // from class: com.zj.adlib.sma
                    @Override // com.ipd.dsp.internal.b1.a.b
                    public final void a(int i, boolean z2, int i2, String str) {
                        this.f44720a.a(runnable, i, z2, i2, str);
                    }
                });
            }
        }
    }

    public interface c {
        boolean c();

        void onDownloadConfirmDialogDismiss();

        void onDownloadConfirmDialogShow();
    }

    public static class d extends b {
        public d(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar) {
            super(dVar, bVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Runnable runnable, int i, boolean z, int i2, String str) {
            this.e = false;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.ipd.dsp.internal.b1.b
        public String b() {
            return "查看详情";
        }

        @Override // com.ipd.dsp.internal.b1.b
        public void b(final Runnable runnable, boolean z) {
            com.ipd.dsp.internal.b1.a aVar = this.b;
            if (aVar != null) {
                aVar.g(new com.ipd.dsp.internal.b1.a.b() { // from class: com.zj.adlib.tma
                    @Override // com.ipd.dsp.internal.b1.a.b
                    public final void a(int i, boolean z2, int i2, String str) {
                        this.f44956a.a(runnable, i, z2, i2, str);
                    }
                });
            }
        }
    }

    public interface e {
        void a(long j, long j2);

        void c(String str);
    }

    public static class f extends b {
        public f(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar) {
            super(dVar, bVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Runnable runnable, int i, boolean z, int i2, String str) {
            this.e = false;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.ipd.dsp.internal.b1.b
        public String b() {
            return "查看详情";
        }

        @Override // com.ipd.dsp.internal.b1.b
        public void b(final Runnable runnable, boolean z) {
            com.ipd.dsp.internal.b1.a aVar = this.b;
            if (aVar != null) {
                aVar.h(new com.ipd.dsp.internal.b1.a.b() { // from class: com.zj.adlib.uma
                    @Override // com.ipd.dsp.internal.b1.a.b
                    public final void a(int i, boolean z2, int i2, String str) {
                        this.f45180a.a(runnable, i, z2, i2, str);
                    }
                });
            }
        }
    }

    public b(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar) {
        this.b = new com.ipd.dsp.internal.b1.a(dVar, bVar);
    }

    public final void a() {
        a((Runnable) null, false);
    }

    public void a(Activity activity) {
    }

    public abstract String b();

    public abstract void b(Runnable runnable, boolean z);

    public void c() {
        this.c = null;
        this.d = null;
        com.ipd.dsp.internal.b1.a aVar = this.b;
        if (aVar != null) {
            aVar.f();
            this.b = null;
        }
    }

    public final void a(boolean z) {
        a((Runnable) null, z);
    }

    public final void a(Runnable runnable) {
        a(runnable, false);
    }

    public final void a(Runnable runnable, boolean z) {
        if (this.e) {
            return;
        }
        this.e = true;
        b(runnable, z);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.f38208a)) {
            return;
        }
        this.f38208a = str;
        com.ipd.dsp.internal.c1.a aVar = this.d;
        if (aVar != null && aVar.isShowing()) {
            this.d.a(this.f38208a);
        }
        e eVar = this.c;
        if (eVar != null) {
            eVar.c(this.f38208a);
        }
    }

    public static b a(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar) {
        com.ipd.dsp.internal.e1.b bVar2;
        if (dVar == null || (bVar2 = dVar.r) == null || TextUtils.isEmpty(bVar2.f)) {
            return null;
        }
        String str = dVar.r.f;
        str.getClass();
        switch (str) {
            case "H5":
                if (dVar.r.g) {
                    return new C0863b(dVar, bVar);
                }
                return new d(dVar, bVar);
            case "App":
                return new a(dVar, bVar);
            case "Wechat_mini":
                return new f(dVar, bVar);
            default:
                return null;
        }
    }
}
