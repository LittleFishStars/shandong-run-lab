package com.acse.ottn;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class t4 extends j {
    public static ThreadLocal<f> A = new ThreadLocal<>();
    public static final ThreadLocal<ArrayList<t4>> B = new a();
    public static final ThreadLocal<ArrayList<t4>> C = new b();
    public static final ThreadLocal<ArrayList<t4>> D = new c();
    public static final ThreadLocal<ArrayList<t4>> E = new d();
    public static final ThreadLocal<ArrayList<t4>> F = new e();
    public static final Interpolator G = new AccelerateDecelerateInterpolator();
    public static final s4 H = new x1();
    public static final s4 I = new h1();
    public static long J = 10;
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = -1;
    public static final long u = 10;
    public static final int v = 0;
    public static final int w = 1;
    public static final int x = 0;
    public static final int y = 1;
    public static final int z = 2;
    public long b;
    public long h;
    public l3[] s;
    public HashMap<String, l3> t;
    public long c = -1;
    public boolean d = false;
    public int e = 0;
    public float f = 0.0f;
    public boolean g = false;
    public int i = 0;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public long m = 300;
    public long n = 0;
    public int o = 0;
    public int p = 1;
    public Interpolator q = G;
    public ArrayList<g> r = null;

    public class a extends ThreadLocal<ArrayList<t4>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<t4> initialValue() {
            return new ArrayList<>();
        }
    }

    public class b extends ThreadLocal<ArrayList<t4>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<t4> initialValue() {
            return new ArrayList<>();
        }
    }

    public class c extends ThreadLocal<ArrayList<t4>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<t4> initialValue() {
            return new ArrayList<>();
        }
    }

    public class d extends ThreadLocal<ArrayList<t4>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<t4> initialValue() {
            return new ArrayList<>();
        }
    }

    public class e extends ThreadLocal<ArrayList<t4>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<t4> initialValue() {
            return new ArrayList<>();
        }
    }

    public static class f extends Handler {
        public f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z;
            ArrayList arrayList = (ArrayList) t4.B.get();
            ArrayList arrayList2 = (ArrayList) t4.D.get();
            int i = message.what;
            if (i == 0) {
                ArrayList arrayList3 = (ArrayList) t4.C.get();
                z = arrayList.size() <= 0 && arrayList2.size() <= 0;
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        t4 t4Var = (t4) arrayList4.get(i2);
                        if (t4Var.n == 0) {
                            t4Var.G();
                        } else {
                            arrayList2.add(t4Var);
                        }
                    }
                }
            } else if (i != 1) {
                return;
            } else {
                z = true;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) t4.F.get();
            ArrayList arrayList6 = (ArrayList) t4.E.get();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                t4 t4Var2 = (t4) arrayList2.get(i3);
                if (t4Var2.d(jCurrentAnimationTimeMillis)) {
                    arrayList5.add(t4Var2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i4 = 0; i4 < size3; i4++) {
                    t4 t4Var3 = (t4) arrayList5.get(i4);
                    t4Var3.G();
                    t4Var3.j = true;
                    arrayList2.remove(t4Var3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i5 = 0;
            while (i5 < size4) {
                t4 t4Var4 = (t4) arrayList.get(i5);
                if (t4Var4.c(jCurrentAnimationTimeMillis)) {
                    arrayList6.add(t4Var4);
                }
                if (arrayList.size() == size4) {
                    i5++;
                } else {
                    size4--;
                    arrayList6.remove(t4Var4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i6 = 0; i6 < arrayList6.size(); i6++) {
                    ((t4) arrayList6.get(i6)).t();
                }
                arrayList6.clear();
            }
            if (z) {
                if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                    return;
                }
                sendEmptyMessageDelayed(1, Math.max(0L, t4.J - (AnimationUtils.currentAnimationTimeMillis() - jCurrentAnimationTimeMillis)));
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public interface g {
        void a(t4 t4Var);
    }

    public static void g(long j) {
        J = j;
    }

    public static void r() {
        B.get().clear();
        C.get().clear();
        D.get().clear();
    }

    public static int w() {
        return B.get().size();
    }

    public static long y() {
        return J;
    }

    public int A() {
        return this.o;
    }

    public int B() {
        return this.p;
    }

    public l3[] C() {
        return this.s;
    }

    public void D() {
        if (this.l) {
            return;
        }
        int length = this.s.length;
        for (int i = 0; i < length; i++) {
            this.s[i].d();
        }
        this.l = true;
    }

    public void E() {
        ArrayList<g> arrayList = this.r;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        this.r = null;
    }

    public void F() {
        this.d = !this.d;
        if (this.i != 1) {
            a(true);
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.b = jCurrentAnimationTimeMillis - (this.m - (jCurrentAnimationTimeMillis - this.b));
    }

    public final void G() {
        ArrayList<j.a> arrayList;
        D();
        B.get().add(this);
        if (this.n <= 0 || (arrayList = this.f23063a) == null) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) arrayList.clone();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            ((j.a) arrayList2.get(i)).a(this);
        }
    }

    @Override // com.acse.ottn.j
    public void cancel() {
        ArrayList<j.a> arrayList;
        if (this.i != 0 || C.get().contains(this) || D.get().contains(this)) {
            if (this.j && (arrayList = this.f23063a) != null) {
                Iterator it = ((ArrayList) arrayList.clone()).iterator();
                while (it.hasNext()) {
                    ((j.a) it.next()).d(this);
                }
            }
            t();
        }
    }

    public final boolean d(long j) {
        if (!this.g) {
            this.g = true;
            this.h = j;
            return false;
        }
        long j2 = j - this.h;
        long j3 = this.n;
        if (j2 <= j3) {
            return false;
        }
        this.b = j - (j2 - j3);
        this.i = 1;
        return true;
    }

    public void e(long j) {
        D();
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.i != 1) {
            this.c = j;
            this.i = 2;
        }
        this.b = jCurrentAnimationTimeMillis - j;
        c(jCurrentAnimationTimeMillis);
    }

    @Override // com.acse.ottn.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public t4 a(long j) {
        if (j >= 0) {
            this.m = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
    }

    @Override // com.acse.ottn.j
    public void k() {
        a(false);
    }

    @Override // com.acse.ottn.j
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public t4 clone() {
        t4 t4Var = (t4) super.clone();
        ArrayList<g> arrayList = this.r;
        if (arrayList != null) {
            t4Var.r = new ArrayList<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                t4Var.r.add(arrayList.get(i));
            }
        }
        t4Var.c = -1L;
        t4Var.d = false;
        t4Var.e = 0;
        t4Var.l = false;
        t4Var.i = 0;
        t4Var.g = false;
        l3[] l3VarArr = this.s;
        if (l3VarArr != null) {
            int length = l3VarArr.length;
            t4Var.s = new l3[length];
            t4Var.t = new HashMap<>(length);
            for (int i2 = 0; i2 < length; i2++) {
                l3 l3VarClone = l3VarArr[i2].clone();
                t4Var.s[i2] = l3VarClone;
                t4Var.t.put(l3VarClone.c(), l3VarClone);
            }
        }
        return t4Var;
    }

    public final void t() {
        ArrayList<j.a> arrayList;
        B.get().remove(this);
        C.get().remove(this);
        D.get().remove(this);
        this.i = 0;
        if (this.j && (arrayList = this.f23063a) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                ((j.a) arrayList2.get(i)).b(this);
            }
        }
        this.j = false;
        this.k = false;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.s != null) {
            for (int i = 0; i < this.s.length; i++) {
                str = str + "\n    " + this.s[i].toString();
            }
        }
        return str;
    }

    public float u() {
        return this.f;
    }

    public Object v() {
        l3[] l3VarArr = this.s;
        if (l3VarArr == null || l3VarArr.length <= 0) {
            return null;
        }
        return l3VarArr[0].b();
    }

    public long x() {
        if (!this.l || this.i == 0) {
            return 0L;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.b;
    }

    public Interpolator z() {
        return this.q;
    }

    public void b(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        l3[] l3VarArr = this.s;
        if (l3VarArr == null || l3VarArr.length == 0) {
            b(l3.a("", iArr));
        } else {
            l3VarArr[0].a(iArr);
        }
        this.l = false;
    }

    @Override // com.acse.ottn.j
    public long c() {
        return this.m;
    }

    @Override // com.acse.ottn.j
    public boolean g() {
        return this.k;
    }

    public boolean c(long j) {
        boolean z2 = true;
        if (this.i == 0) {
            this.i = 1;
            long j2 = this.c;
            if (j2 < 0) {
                this.b = j;
            } else {
                this.b = j - j2;
                this.c = -1L;
            }
        }
        int i = this.i;
        if (i != 1 && i != 2) {
            return false;
        }
        long j3 = this.m;
        float fMin = j3 > 0 ? (j - this.b) / j3 : 1.0f;
        if (fMin >= 1.0f) {
            int i2 = this.e;
            int i3 = this.o;
            if (i2 >= i3 && i3 != -1) {
                fMin = Math.min(fMin, 1.0f);
            } else {
                ArrayList<j.a> arrayList = this.f23063a;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        this.f23063a.get(i4).c(this);
                    }
                }
                if (this.p == 2) {
                    this.d = !this.d;
                }
                this.e += (int) fMin;
                fMin %= 1.0f;
                this.b += this.m;
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (this.d) {
            fMin = 1.0f - fMin;
        }
        a(fMin);
        return z2;
    }

    @Override // com.acse.ottn.j
    public boolean f() {
        return this.i == 1 || this.j;
    }

    public static t4 a(int... iArr) {
        t4 t4Var = new t4();
        t4Var.b(iArr);
        return t4Var;
    }

    public static t4 a(float... fArr) {
        t4 t4Var = new t4();
        t4Var.b(fArr);
        return t4Var;
    }

    public void b(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        l3[] l3VarArr = this.s;
        if (l3VarArr == null || l3VarArr.length == 0) {
            b(l3.a("", fArr));
        } else {
            l3VarArr[0].a(fArr);
        }
        this.l = false;
    }

    @Override // com.acse.ottn.j
    public long e() {
        return this.n;
    }

    public static t4 a(l3... l3VarArr) {
        t4 t4Var = new t4();
        t4Var.b(l3VarArr);
        return t4Var;
    }

    public static t4 a(s4 s4Var, Object... objArr) {
        t4 t4Var = new t4();
        t4Var.a(objArr);
        t4Var.a(s4Var);
        return t4Var;
    }

    public void b(l3... l3VarArr) {
        int length = l3VarArr.length;
        this.s = l3VarArr;
        this.t = new HashMap<>(length);
        for (l3 l3Var : l3VarArr) {
            this.t.put(l3Var.c(), l3Var);
        }
        this.l = false;
    }

    public void a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        l3[] l3VarArr = this.s;
        if (l3VarArr == null || l3VarArr.length == 0) {
            b(l3.a("", (s4) null, objArr));
        } else {
            l3VarArr[0].a(objArr);
        }
        this.l = false;
    }

    @Override // com.acse.ottn.j
    public void b(long j) {
        this.n = j;
    }

    public Object a(String str) {
        l3 l3Var = this.t.get(str);
        if (l3Var != null) {
            return l3Var.b();
        }
        return null;
    }

    public void b(int i) {
        this.p = i;
    }

    public void b(g gVar) {
        ArrayList<g> arrayList = this.r;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(gVar);
        if (this.r.size() == 0) {
            this.r = null;
        }
    }

    public void a(int i) {
        this.o = i;
    }

    public void a(g gVar) {
        if (this.r == null) {
            this.r = new ArrayList<>();
        }
        this.r.add(gVar);
    }

    @Override // com.acse.ottn.j
    public void b() {
        if (!B.get().contains(this) && !C.get().contains(this)) {
            this.g = false;
            G();
        } else if (!this.l) {
            D();
        }
        int i = this.o;
        if (i > 0 && (i & 1) == 1) {
            a(0.0f);
        } else {
            a(1.0f);
        }
        t();
    }

    @Override // com.acse.ottn.j
    public void a(Interpolator interpolator) {
        if (interpolator != null) {
            this.q = interpolator;
        } else {
            this.q = new LinearInterpolator();
        }
    }

    public void a(s4 s4Var) {
        l3[] l3VarArr;
        if (s4Var == null || (l3VarArr = this.s) == null || l3VarArr.length <= 0) {
            return;
        }
        l3VarArr[0].a(s4Var);
    }

    public final void a(boolean z2) {
        if (Looper.myLooper() != null) {
            this.d = z2;
            this.e = 0;
            this.i = 0;
            this.k = true;
            this.g = false;
            C.get().add(this);
            if (this.n == 0) {
                e(x());
                this.i = 0;
                this.j = true;
                ArrayList<j.a> arrayList = this.f23063a;
                if (arrayList != null) {
                    ArrayList arrayList2 = (ArrayList) arrayList.clone();
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        ((j.a) arrayList2.get(i)).a(this);
                    }
                }
            }
            f fVar = A.get();
            if (fVar == null) {
                fVar = new f(null);
                A.set(fVar);
            }
            fVar.sendEmptyMessage(0);
            return;
        }
        throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }

    public void a(float f2) {
        float interpolation = this.q.getInterpolation(f2);
        this.f = interpolation;
        int length = this.s.length;
        for (int i = 0; i < length; i++) {
            this.s[i].a(interpolation);
        }
        ArrayList<g> arrayList = this.r;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.r.get(i2).a(this);
            }
        }
    }
}
