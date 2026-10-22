package com.acse.ottn;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class x4 extends w4 {
    public static final int n = 0;
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 4;
    public static final int r = 8;
    public static final int s = 16;
    public static final int t = 32;
    public static final int u = 64;
    public static final int v = 128;
    public static final int w = 256;
    public static final int x = 512;
    public static final int y = 511;
    public final WeakReference<View> b;
    public long c;
    public Interpolator g;
    public boolean d = false;
    public long e = 0;
    public boolean f = false;
    public boolean h = false;
    public j.a i = null;
    public b j = new b(this, null);
    public ArrayList<c> k = new ArrayList<>();
    public Runnable l = new a();
    public HashMap<j, d> m = new HashMap<>();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x4.this.e();
        }
    }

    public class b implements j.a, t4.g {
        public b() {
        }

        @Override // com.acse.ottn.j.a
        public void a(j jVar) {
            if (x4.this.i != null) {
                x4.this.i.a(jVar);
            }
        }

        @Override // com.acse.ottn.j.a
        public void b(j jVar) {
            if (x4.this.i != null) {
                x4.this.i.b(jVar);
            }
            x4.this.m.remove(jVar);
            if (x4.this.m.isEmpty()) {
                x4.this.i = null;
            }
        }

        @Override // com.acse.ottn.j.a
        public void c(j jVar) {
            if (x4.this.i != null) {
                x4.this.i.c(jVar);
            }
        }

        @Override // com.acse.ottn.j.a
        public void d(j jVar) {
            if (x4.this.i != null) {
                x4.this.i.d(jVar);
            }
        }

        public /* synthetic */ b(x4 x4Var, a aVar) {
            this();
        }

        @Override // com.acse.ottn.t4.g
        public void a(t4 t4Var) {
            View view;
            float fU = t4Var.u();
            d dVar = (d) x4.this.m.get(t4Var);
            if ((dVar.f23300a & 511) != 0 && (view = (View) x4.this.b.get()) != null) {
                view.invalidate();
            }
            ArrayList<c> arrayList = dVar.b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    c cVar = arrayList.get(i);
                    x4.this.c(cVar.f23299a, cVar.b + (cVar.c * fU));
                }
            }
            View view2 = (View) x4.this.b.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23299a;
        public float b;
        public float c;

        public c(int i, float f, float f2) {
            this.f23299a = i;
            this.b = f;
            this.c = f2;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23300a;
        public ArrayList<c> b;

        public d(int i, ArrayList<c> arrayList) {
            this.f23300a = i;
            this.b = arrayList;
        }

        public boolean a(int i) {
            ArrayList<c> arrayList;
            if ((this.f23300a & i) != 0 && (arrayList = this.b) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.b.get(i2).f23299a == i) {
                        this.b.remove(i2);
                        this.f23300a = (~i) & this.f23300a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public x4(View view) {
        this.b = new WeakReference<>(view);
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
        return this.d ? this.c : new t4().c();
    }

    @Override // com.acse.ottn.w4
    public long c() {
        if (this.f) {
            return this.e;
        }
        return 0L;
    }

    @Override // com.acse.ottn.w4
    public void d() {
        e();
    }

    public final void e() {
        t4 t4VarA = t4.a(1.0f);
        ArrayList arrayList = (ArrayList) this.k.clone();
        this.k.clear();
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i |= ((c) arrayList.get(i2)).f23299a;
        }
        this.m.put(t4VarA, new d(i, arrayList));
        t4VarA.a((t4.g) this.j);
        t4VarA.a((j.a) this.j);
        if (this.f) {
            t4VarA.b(this.e);
        }
        if (this.d) {
            t4VarA.a(this.c);
        }
        if (this.h) {
            t4VarA.a(this.g);
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
            this.d = true;
            this.c = j;
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
            this.f = true;
            this.e = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
    }

    public final void c(int i, float f) {
        View view = this.b.get();
        if (view != null) {
            if (i == 1) {
                view.setTranslationX(f);
                return;
            }
            if (i == 2) {
                view.setTranslationY(f);
                return;
            }
            if (i == 4) {
                view.setScaleX(f);
                return;
            }
            if (i == 8) {
                view.setScaleY(f);
                return;
            }
            if (i == 16) {
                view.setRotation(f);
                return;
            }
            if (i == 32) {
                view.setRotationX(f);
                return;
            }
            if (i == 64) {
                view.setRotationY(f);
                return;
            }
            if (i == 128) {
                view.setX(f);
            } else if (i == 256) {
                view.setY(f);
            } else {
                if (i != 512) {
                    return;
                }
                view.setAlpha(f);
            }
        }
    }

    @Override // com.acse.ottn.w4
    public w4 a(Interpolator interpolator) {
        this.h = true;
        this.g = interpolator;
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 b(float f) {
        b(512, f);
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 a(j.a aVar) {
        this.i = aVar;
        return this;
    }

    public final void b(int i, float f) {
        a(i, a(i), f);
    }

    @Override // com.acse.ottn.w4
    public void a() {
        if (this.m.size() > 0) {
            Iterator it = ((HashMap) this.m.clone()).keySet().iterator();
            while (it.hasNext()) {
                ((j) it.next()).cancel();
            }
        }
        this.k.clear();
        View view = this.b.get();
        if (view != null) {
            view.removeCallbacks(this.l);
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
        if (this.m.size() > 0) {
            Iterator<j> it = this.m.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                d dVar = this.m.get(next);
                if (dVar.a(i) && dVar.f23300a == 0) {
                    break;
                }
            }
            if (next != null) {
                next.cancel();
            }
        }
        this.k.add(new c(i, f, f2));
        View view = this.b.get();
        if (view != null) {
            view.removeCallbacks(this.l);
            view.post(this.l);
        }
    }

    public final float a(int i) {
        View view = this.b.get();
        if (view == null) {
            return 0.0f;
        }
        if (i == 1) {
            return view.getTranslationX();
        }
        if (i == 2) {
            return view.getTranslationY();
        }
        if (i == 4) {
            return view.getScaleX();
        }
        if (i == 8) {
            return view.getScaleY();
        }
        if (i == 16) {
            return view.getRotation();
        }
        if (i == 32) {
            return view.getRotationX();
        }
        if (i == 64) {
            return view.getRotationY();
        }
        if (i == 128) {
            return view.getX();
        }
        if (i == 256) {
            return view.getY();
        }
        if (i != 512) {
            return 0.0f;
        }
        return view.getAlpha();
    }
}
