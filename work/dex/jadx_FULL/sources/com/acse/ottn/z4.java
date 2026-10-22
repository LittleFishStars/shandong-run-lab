package com.acse.ottn;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class z4 extends w4 {
    public static final int o = 0;
    public static final int p = 1;
    public static final int q = 2;
    public static final int r = 4;
    public static final int s = 8;
    public static final int t = 16;
    public static final int u = 32;
    public static final int v = 64;
    public static final int w = 128;
    public static final int x = 256;
    public static final int y = 512;
    public static final int z = 511;
    public final m b;
    public final WeakReference<View> c;
    public long d;
    public Interpolator h;
    public boolean e = false;
    public long f = 0;
    public boolean g = false;
    public boolean i = false;
    public j.a j = null;
    public b k = new b(this, null);
    public ArrayList<c> l = new ArrayList<>();
    public Runnable m = new a();
    public HashMap<j, d> n = new HashMap<>();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z4.this.e();
        }
    }

    public class b implements j.a, t4.g {
        public b() {
        }

        @Override // com.acse.ottn.j.a
        public void a(j jVar) {
            if (z4.this.j != null) {
                z4.this.j.a(jVar);
            }
        }

        @Override // com.acse.ottn.j.a
        public void b(j jVar) {
            if (z4.this.j != null) {
                z4.this.j.b(jVar);
            }
            z4.this.n.remove(jVar);
            if (z4.this.n.isEmpty()) {
                z4.this.j = null;
            }
        }

        @Override // com.acse.ottn.j.a
        public void c(j jVar) {
            if (z4.this.j != null) {
                z4.this.j.c(jVar);
            }
        }

        @Override // com.acse.ottn.j.a
        public void d(j jVar) {
            if (z4.this.j != null) {
                z4.this.j.d(jVar);
            }
        }

        public /* synthetic */ b(z4 z4Var, a aVar) {
            this();
        }

        @Override // com.acse.ottn.t4.g
        public void a(t4 t4Var) {
            View view;
            float fU = t4Var.u();
            d dVar = (d) z4.this.n.get(t4Var);
            if ((dVar.f23319a & 511) != 0 && (view = (View) z4.this.c.get()) != null) {
                view.invalidate();
            }
            ArrayList<c> arrayList = dVar.b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    c cVar = arrayList.get(i);
                    z4.this.c(cVar.f23318a, cVar.b + (cVar.c * fU));
                }
            }
            View view2 = (View) z4.this.c.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23318a;
        public float b;
        public float c;

        public c(int i, float f, float f2) {
            this.f23318a = i;
            this.b = f;
            this.c = f2;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23319a;
        public ArrayList<c> b;

        public d(int i, ArrayList<c> arrayList) {
            this.f23319a = i;
            this.b = arrayList;
        }

        public boolean a(int i) {
            ArrayList<c> arrayList;
            if ((this.f23319a & i) != 0 && (arrayList = this.b) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.b.get(i2).f23318a == i) {
                        this.b.remove(i2);
                        this.f23319a = (~i) & this.f23319a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public z4(View view) {
        this.c = new WeakReference<>(view);
        this.b = m.a(view);
    }

    @Override // com.acse.ottn.w4
    public w4 e(float f) {
        a(32, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 f(float f) {
        b(32, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 g(float f) {
        a(64, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 h(float f) {
        b(64, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 i(float f) {
        a(4, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 j(float f) {
        b(4, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 k(float f) {
        a(8, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 l(float f) {
        b(8, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 m(float f) {
        a(1, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 n(float f) {
        b(1, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 o(float f) {
        a(2, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 p(float f) {
        b(2, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 q(float f) {
        a(128, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 r(float f) {
        b(128, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 s(float f) {
        a(256, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 t(float f) {
        b(256, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public long b() {
        return this.e ? this.d : new t4().c();
    }

    @Override // com.acse.ottn.w4
    public long c() {
        if (this.g) {
            return this.f;
        }
        return 0L;
    }

    @Override // com.acse.ottn.w4
    public void d() {
        e();
    }

    public final void e() {
        t4 t4VarA = t4.a(1.0f);
        ArrayList arrayList = (ArrayList) this.l.clone();
        this.l.clear();
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i |= ((c) arrayList.get(i2)).f23318a;
        }
        this.n.put(t4VarA, new d(i, arrayList));
        t4VarA.a((t4.g) this.k);
        t4VarA.a((j.a) this.k);
        if (this.g) {
            t4VarA.b(this.f);
        }
        if (this.e) {
            t4VarA.a(this.d);
        }
        if (this.i) {
            t4VarA.a(this.h);
        }
        t4VarA.k();
    }

    @Override // com.acse.ottn.w4
    public w4 d(float f) {
        b(16, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 a(long j) {
        if (j >= 0) {
            this.e = true;
            this.d = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
    }

    @Override // com.acse.ottn.w4
    public w4 c(float f) {
        a(16, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 b(long j) {
        if (j >= 0) {
            this.g = true;
            this.f = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
    }

    public final void c(int i, float f) {
        if (i == 1) {
            this.b.i(f);
            return;
        }
        if (i == 2) {
            this.b.j(f);
            return;
        }
        if (i == 4) {
            this.b.g(f);
            return;
        }
        if (i == 8) {
            this.b.h(f);
            return;
        }
        if (i == 16) {
            this.b.d(f);
            return;
        }
        if (i == 32) {
            this.b.e(f);
            return;
        }
        if (i == 64) {
            this.b.f(f);
            return;
        }
        if (i == 128) {
            this.b.k(f);
        } else if (i == 256) {
            this.b.l(f);
        } else {
            if (i != 512) {
                return;
            }
            this.b.a(f);
        }
    }

    @Override // com.acse.ottn.w4
    public w4 a(Interpolator interpolator) {
        this.i = true;
        this.h = interpolator;
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 b(float f) {
        b(512, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 a(j.a aVar) {
        this.j = aVar;
        return this;
    }

    public final void b(int i, float f) {
        a(i, a(i), f);
    }

    @Override // com.acse.ottn.w4
    public void a() {
        if (this.n.size() > 0) {
            Iterator it = ((HashMap) this.n.clone()).keySet().iterator();
            while (it.hasNext()) {
                ((j) it.next()).cancel();
            }
        }
        this.l.clear();
        View view = this.c.get();
        if (view != null) {
            view.removeCallbacks(this.m);
        }
    }

    @Override // com.acse.ottn.w4
    public w4 a(float f) {
        a(512, f);
        return this;
    }

    public final void a(int i, float f) {
        float fA = a(i);
        a(i, fA, f - fA);
    }

    public final void a(int i, float f, float f2) {
        j next;
        if (this.n.size() > 0) {
            Iterator<j> it = this.n.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                d dVar = this.n.get(next);
                if (dVar.a(i) && dVar.f23319a == 0) {
                    break;
                }
            }
            if (next != null) {
                next.cancel();
            }
        }
        this.l.add(new c(i, f, f2));
        View view = this.c.get();
        if (view != null) {
            view.removeCallbacks(this.m);
            view.post(this.m);
        }
    }

    public final float a(int i) {
        if (i == 1) {
            return this.b.k();
        }
        if (i == 2) {
            return this.b.l();
        }
        if (i == 4) {
            return this.b.g();
        }
        if (i == 8) {
            return this.b.h();
        }
        if (i == 16) {
            return this.b.d();
        }
        if (i == 32) {
            return this.b.e();
        }
        if (i == 64) {
            return this.b.f();
        }
        if (i == 128) {
            return this.b.m();
        }
        if (i == 256) {
            return this.b.n();
        }
        if (i != 512) {
            return 0.0f;
        }
        return this.b.a();
    }
}
