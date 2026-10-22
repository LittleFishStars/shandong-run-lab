package com.ipd.dsp.internal.z;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.ipd.dsp.internal.d0.o;
import com.ipd.dsp.internal.f.m;
import com.ipd.dsp.internal.q.m0;
import com.ipd.dsp.internal.q.n;
import com.ipd.dsp.internal.q.q;
import com.ipd.dsp.internal.q.r;
import com.ipd.dsp.internal.q.t;
import com.ipd.dsp.internal.q.x;
import com.ipd.dsp.internal.z.a;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    public static final int F = -1;
    public static final int G = 2;
    public static final int H = 4;
    public static final int I = 8;
    public static final int J = 16;
    public static final int K = 32;
    public static final int L = 64;
    public static final int M = 128;
    public static final int N = 256;
    public static final int O = 512;
    public static final int P = 1024;
    public static final int Q = 2048;
    public static final int R = 4096;
    public static final int S = 8192;
    public static final int T = 16384;
    public static final int U = 32768;
    public static final int V = 65536;
    public static final int W = 131072;
    public static final int X = 262144;
    public static final int Y = 524288;
    public static final int Z = 1048576;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean E;
    public int f;

    @Nullable
    public Drawable j;
    public int k;

    @Nullable
    public Drawable l;
    public int m;
    public boolean r;

    @Nullable
    public Drawable t;
    public int u;
    public boolean y;

    @Nullable
    public Resources.Theme z;
    public float g = 1.0f;

    @NonNull
    public com.ipd.dsp.internal.i.j h = com.ipd.dsp.internal.i.j.e;

    @NonNull
    public com.ipd.dsp.internal.b.e i = com.ipd.dsp.internal.b.e.NORMAL;
    public boolean n = true;
    public int o = -1;
    public int p = -1;

    @NonNull
    public com.ipd.dsp.internal.f.f q = com.ipd.dsp.internal.c0.c.a();
    public boolean s = true;

    @NonNull
    public com.ipd.dsp.internal.f.i v = new com.ipd.dsp.internal.f.i();

    @NonNull
    public Map<Class<?>, m<?>> w = new com.ipd.dsp.internal.d0.b();

    @NonNull
    public Class<?> x = Object.class;
    public boolean D = true;

    public static boolean a(int i, int i2) {
        return (i & i2) != 0;
    }

    public final boolean A() {
        return this.B;
    }

    public final boolean B() {
        return this.A;
    }

    public final boolean C() {
        return d(4);
    }

    public final boolean D() {
        return this.y;
    }

    public final boolean E() {
        return this.n;
    }

    public final boolean F() {
        return d(8);
    }

    public boolean G() {
        return this.D;
    }

    public final boolean H() {
        return d(256);
    }

    public final boolean I() {
        return this.s;
    }

    public final boolean J() {
        return this.r;
    }

    public final boolean K() {
        return d(2048);
    }

    public final boolean L() {
        return o.b(this.p, this.o);
    }

    @NonNull
    public T M() {
        this.y = true;
        return (T) R();
    }

    @NonNull
    @CheckResult
    public T N() {
        return (T) b(q.e, new com.ipd.dsp.internal.q.m());
    }

    @NonNull
    @CheckResult
    public T O() {
        return (T) a(q.d, new n());
    }

    @NonNull
    @CheckResult
    public T P() {
        return (T) b(q.e, new com.ipd.dsp.internal.q.o());
    }

    @NonNull
    @CheckResult
    public T Q() {
        return (T) a(q.c, new x());
    }

    public final T R() {
        return this;
    }

    @NonNull
    public final T S() {
        if (this.y) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return (T) R();
    }

    @NonNull
    @CheckResult
    public T a(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        if (this.A) {
            return (T) mo997clone().a(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.g = f;
        this.f |= 2;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T b(@Nullable Drawable drawable) {
        if (this.A) {
            return (T) mo997clone().b(drawable);
        }
        this.j = drawable;
        int i = this.f | 16;
        this.k = 0;
        this.f = i & (-33);
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T c(boolean z) {
        if (this.A) {
            return (T) mo997clone().c(z);
        }
        this.E = z;
        this.f |= 1048576;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T d(boolean z) {
        if (this.A) {
            return (T) mo997clone().d(z);
        }
        this.B = z;
        this.f |= 262144;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T e(int i) {
        return (T) b(i, i);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return b((a<?>) obj);
        }
        return false;
    }

    @NonNull
    @CheckResult
    public T f(@DrawableRes int i) {
        if (this.A) {
            return (T) mo997clone().f(i);
        }
        this.m = i;
        int i2 = this.f | 128;
        this.l = null;
        this.f = i2 & (-65);
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T g(@IntRange(from = 0) int i) {
        return (T) a((com.ipd.dsp.internal.f.h<Integer>) com.ipd.dsp.internal.o.b.b, Integer.valueOf(i));
    }

    @NonNull
    @CheckResult
    public T h() {
        return (T) c(q.c, new x());
    }

    public int hashCode() {
        return o.a(this.z, o.a(this.q, o.a(this.x, o.a(this.w, o.a(this.v, o.a(this.i, o.a(this.h, o.a(this.C, o.a(this.B, o.a(this.s, o.a(this.r, o.a(this.p, o.a(this.o, o.a(this.n, o.a(this.t, o.a(this.u, o.a(this.l, o.a(this.m, o.a(this.j, o.a(this.k, o.a(this.g)))))))))))))))))))));
    }

    @NonNull
    public final com.ipd.dsp.internal.i.j i() {
        return this.h;
    }

    public final int j() {
        return this.k;
    }

    @Nullable
    public final Drawable k() {
        return this.j;
    }

    @Nullable
    public final Drawable l() {
        return this.t;
    }

    public final int m() {
        return this.u;
    }

    public final boolean n() {
        return this.C;
    }

    @NonNull
    public final com.ipd.dsp.internal.f.i o() {
        return this.v;
    }

    public final int p() {
        return this.o;
    }

    public final int q() {
        return this.p;
    }

    @Nullable
    public final Drawable r() {
        return this.l;
    }

    public final int s() {
        return this.m;
    }

    @NonNull
    public final com.ipd.dsp.internal.b.e t() {
        return this.i;
    }

    @NonNull
    public final Class<?> u() {
        return this.x;
    }

    @NonNull
    public final com.ipd.dsp.internal.f.f v() {
        return this.q;
    }

    public final float w() {
        return this.g;
    }

    @Nullable
    public final Resources.Theme x() {
        return this.z;
    }

    @NonNull
    public final Map<Class<?>, m<?>> y() {
        return this.w;
    }

    public final boolean z() {
        return this.E;
    }

    @Override // 
    @CheckResult
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public T mo997clone() {
        try {
            T t = (T) super.clone();
            com.ipd.dsp.internal.f.i iVar = new com.ipd.dsp.internal.f.i();
            t.v = iVar;
            iVar.a(this.v);
            com.ipd.dsp.internal.d0.b bVar = new com.ipd.dsp.internal.d0.b();
            t.w = bVar;
            bVar.putAll(this.w);
            t.y = false;
            t.A = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    @CheckResult
    public T e() {
        return (T) a((com.ipd.dsp.internal.f.h<Boolean>) r.k, Boolean.FALSE);
    }

    @NonNull
    @CheckResult
    public T g() {
        if (this.A) {
            return (T) mo997clone().g();
        }
        this.w.clear();
        int i = this.f;
        this.r = false;
        this.s = false;
        this.f = (i & (-133121)) | 65536;
        this.D = true;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T c(@Nullable Drawable drawable) {
        if (this.A) {
            return (T) mo997clone().c(drawable);
        }
        this.t = drawable;
        int i = this.f | 8192;
        this.u = 0;
        this.f = i & (-16385);
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T d(@Nullable Drawable drawable) {
        if (this.A) {
            return (T) mo997clone().d(drawable);
        }
        this.l = drawable;
        int i = this.f | 64;
        this.m = 0;
        this.f = i & (-129);
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T a(boolean z) {
        if (this.A) {
            return (T) mo997clone().a(z);
        }
        this.C = z;
        this.f |= 524288;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T b(@DrawableRes int i) {
        if (this.A) {
            return (T) mo997clone().b(i);
        }
        this.k = i;
        int i2 = this.f | 32;
        this.j = null;
        this.f = i2 & (-17);
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T f() {
        return (T) a((com.ipd.dsp.internal.f.h<Boolean>) com.ipd.dsp.internal.u.i.b, Boolean.TRUE);
    }

    @NonNull
    @CheckResult
    public T a(@NonNull com.ipd.dsp.internal.i.j jVar) {
        if (this.A) {
            return (T) mo997clone().a(jVar);
        }
        this.h = (com.ipd.dsp.internal.i.j) com.ipd.dsp.internal.d0.m.a(jVar);
        this.f |= 4;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T c(@DrawableRes int i) {
        if (this.A) {
            return (T) mo997clone().c(i);
        }
        this.u = i;
        int i2 = this.f | 16384;
        this.t = null;
        this.f = i2 & (-8193);
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T d() {
        return (T) d(q.d, new com.ipd.dsp.internal.q.o());
    }

    @NonNull
    @CheckResult
    public final T d(@NonNull q qVar, @NonNull m<Bitmap> mVar) {
        if (this.A) {
            return (T) mo997clone().d(qVar, mVar);
        }
        a(qVar);
        return (T) b(mVar);
    }

    @NonNull
    @CheckResult
    public T b(boolean z) {
        if (this.A) {
            return (T) mo997clone().b(true);
        }
        this.n = !z;
        this.f |= 256;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull com.ipd.dsp.internal.b.e eVar) {
        if (this.A) {
            return (T) mo997clone().a(eVar);
        }
        this.i = (com.ipd.dsp.internal.b.e) com.ipd.dsp.internal.d0.m.a(eVar);
        this.f |= 8;
        return (T) S();
    }

    public final boolean d(int i) {
        return a(this.f, i);
    }

    @NonNull
    @CheckResult
    public T b(int i, int i2) {
        if (this.A) {
            return (T) mo997clone().b(i, i2);
        }
        this.p = i;
        this.o = i2;
        this.f |= 512;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T c() {
        return (T) c(q.d, new n());
    }

    @NonNull
    public final T c(@NonNull q qVar, @NonNull m<Bitmap> mVar) {
        return (T) a(qVar, mVar, true);
    }

    @NonNull
    @CheckResult
    public T a(@Nullable Resources.Theme theme) {
        if (this.A) {
            return (T) mo997clone().a(theme);
        }
        this.z = theme;
        if (theme != null) {
            this.f |= 32768;
            return (T) a((com.ipd.dsp.internal.f.h<Resources.Theme>) com.ipd.dsp.internal.s.g.b, theme);
        }
        this.f &= -32769;
        return (T) a(com.ipd.dsp.internal.s.g.b);
    }

    @NonNull
    @CheckResult
    public T b() {
        return (T) d(q.e, new com.ipd.dsp.internal.q.m());
    }

    @NonNull
    public final T b(@NonNull q qVar, @NonNull m<Bitmap> mVar) {
        if (this.A) {
            return (T) mo997clone().b(qVar, mVar);
        }
        a(qVar);
        return (T) a(mVar, false);
    }

    @NonNull
    @CheckResult
    public T a(@NonNull com.ipd.dsp.internal.f.f fVar) {
        if (this.A) {
            return (T) mo997clone().a(fVar);
        }
        this.q = (com.ipd.dsp.internal.f.f) com.ipd.dsp.internal.d0.m.a(fVar);
        this.f |= 1024;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T b(@NonNull m<Bitmap> mVar) {
        return (T) a(mVar, true);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public T b(@NonNull m<Bitmap>... mVarArr) {
        return (T) a((m<Bitmap>) new com.ipd.dsp.internal.f.g(mVarArr), true);
    }

    @NonNull
    @CheckResult
    public <Y> T b(@NonNull Class<Y> cls, @NonNull m<Y> mVar) {
        return (T) a((Class) cls, (m) mVar, true);
    }

    @NonNull
    @CheckResult
    public <Y> T a(@NonNull com.ipd.dsp.internal.f.h<Y> hVar, @NonNull Y y) {
        if (this.A) {
            return (T) mo997clone().a(hVar, y);
        }
        com.ipd.dsp.internal.d0.m.a(hVar);
        com.ipd.dsp.internal.d0.m.a(y);
        this.v.a(hVar, y);
        return (T) S();
    }

    public final boolean b(a<?> aVar) {
        return Float.compare(aVar.g, this.g) == 0 && this.k == aVar.k && o.b(this.j, aVar.j) && this.m == aVar.m && o.b(this.l, aVar.l) && this.u == aVar.u && o.b(this.t, aVar.t) && this.n == aVar.n && this.o == aVar.o && this.p == aVar.p && this.r == aVar.r && this.s == aVar.s && this.B == aVar.B && this.C == aVar.C && this.h.equals(aVar.h) && this.i == aVar.i && this.v.equals(aVar.v) && this.w.equals(aVar.w) && this.x.equals(aVar.x) && o.b(this.q, aVar.q) && o.b(this.z, aVar.z);
    }

    public T a(@NonNull com.ipd.dsp.internal.f.h<?> hVar) {
        if (this.A) {
            return (T) mo997clone().a(hVar);
        }
        this.v.b(hVar);
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull Class<?> cls) {
        if (this.A) {
            return (T) mo997clone().a(cls);
        }
        this.x = (Class) com.ipd.dsp.internal.d0.m.a(cls);
        this.f |= 4096;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull Bitmap.CompressFormat compressFormat) {
        return (T) a((com.ipd.dsp.internal.f.h<Bitmap.CompressFormat>) com.ipd.dsp.internal.q.e.c, (Bitmap.CompressFormat) com.ipd.dsp.internal.d0.m.a(compressFormat));
    }

    @NonNull
    @CheckResult
    public T a(@IntRange(from = 0, to = 100) int i) {
        return (T) a((com.ipd.dsp.internal.f.h<Integer>) com.ipd.dsp.internal.q.e.b, Integer.valueOf(i));
    }

    @NonNull
    @CheckResult
    public T a(@IntRange(from = 0) long j) {
        return (T) a((com.ipd.dsp.internal.f.h<Long>) m0.g, Long.valueOf(j));
    }

    @NonNull
    @CheckResult
    public T a(@NonNull com.ipd.dsp.internal.f.b bVar) {
        com.ipd.dsp.internal.d0.m.a(bVar);
        return (T) a((com.ipd.dsp.internal.f.h<com.ipd.dsp.internal.f.b>) r.g, bVar).a(com.ipd.dsp.internal.u.i.f38551a, bVar);
    }

    @NonNull
    @CheckResult
    public T a(@NonNull q qVar) {
        return (T) a((com.ipd.dsp.internal.f.h<q>) q.h, (q) com.ipd.dsp.internal.d0.m.a(qVar));
    }

    @NonNull
    public final T a(@NonNull q qVar, @NonNull m<Bitmap> mVar) {
        return (T) a(qVar, mVar, false);
    }

    @NonNull
    public final T a(@NonNull q qVar, @NonNull m<Bitmap> mVar, boolean z) {
        T t;
        if (z) {
            t = (T) d(qVar, mVar);
        } else {
            t = (T) b(qVar, mVar);
        }
        t.D = true;
        return t;
    }

    @NonNull
    @CheckResult
    public T a(@NonNull m<Bitmap>... mVarArr) {
        if (mVarArr.length > 1) {
            return (T) a((m<Bitmap>) new com.ipd.dsp.internal.f.g(mVarArr), true);
        }
        if (mVarArr.length == 1) {
            return (T) b(mVarArr[0]);
        }
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull m<Bitmap> mVar) {
        return (T) a(mVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T a(@NonNull m<Bitmap> mVar, boolean z) {
        if (this.A) {
            return (T) mo997clone().a(mVar, z);
        }
        t tVar = new t(mVar, z);
        a(Bitmap.class, mVar, z);
        a(Drawable.class, tVar, z);
        a(BitmapDrawable.class, tVar.a(), z);
        a(com.ipd.dsp.internal.u.c.class, new com.ipd.dsp.internal.u.f(mVar), z);
        return (T) S();
    }

    @NonNull
    @CheckResult
    public <Y> T a(@NonNull Class<Y> cls, @NonNull m<Y> mVar) {
        return (T) a((Class) cls, (m) mVar, false);
    }

    @NonNull
    public <Y> T a(@NonNull Class<Y> cls, @NonNull m<Y> mVar, boolean z) {
        if (this.A) {
            return (T) mo997clone().a(cls, mVar, z);
        }
        com.ipd.dsp.internal.d0.m.a(cls);
        com.ipd.dsp.internal.d0.m.a(mVar);
        this.w.put(cls, mVar);
        int i = this.f;
        this.s = true;
        this.f = 67584 | i;
        this.D = false;
        if (z) {
            this.f = i | 198656;
            this.r = true;
        }
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull a<?> aVar) {
        if (this.A) {
            return (T) mo997clone().a(aVar);
        }
        if (a(aVar.f, 2)) {
            this.g = aVar.g;
        }
        if (a(aVar.f, 262144)) {
            this.B = aVar.B;
        }
        if (a(aVar.f, 1048576)) {
            this.E = aVar.E;
        }
        if (a(aVar.f, 4)) {
            this.h = aVar.h;
        }
        if (a(aVar.f, 8)) {
            this.i = aVar.i;
        }
        if (a(aVar.f, 16)) {
            this.j = aVar.j;
            this.k = 0;
            this.f &= -33;
        }
        if (a(aVar.f, 32)) {
            this.k = aVar.k;
            this.j = null;
            this.f &= -17;
        }
        if (a(aVar.f, 64)) {
            this.l = aVar.l;
            this.m = 0;
            this.f &= -129;
        }
        if (a(aVar.f, 128)) {
            this.m = aVar.m;
            this.l = null;
            this.f &= -65;
        }
        if (a(aVar.f, 256)) {
            this.n = aVar.n;
        }
        if (a(aVar.f, 512)) {
            this.p = aVar.p;
            this.o = aVar.o;
        }
        if (a(aVar.f, 1024)) {
            this.q = aVar.q;
        }
        if (a(aVar.f, 4096)) {
            this.x = aVar.x;
        }
        if (a(aVar.f, 8192)) {
            this.t = aVar.t;
            this.u = 0;
            this.f &= -16385;
        }
        if (a(aVar.f, 16384)) {
            this.u = aVar.u;
            this.t = null;
            this.f &= -8193;
        }
        if (a(aVar.f, 32768)) {
            this.z = aVar.z;
        }
        if (a(aVar.f, 65536)) {
            this.s = aVar.s;
        }
        if (a(aVar.f, 131072)) {
            this.r = aVar.r;
        }
        if (a(aVar.f, 2048)) {
            this.w.putAll(aVar.w);
            this.D = aVar.D;
        }
        if (a(aVar.f, 524288)) {
            this.C = aVar.C;
        }
        if (!this.s) {
            this.w.clear();
            int i = this.f;
            this.r = false;
            this.f = i & (-133121);
            this.D = true;
        }
        this.f |= aVar.f;
        this.v.a(aVar.v);
        return (T) S();
    }

    @NonNull
    public T a() {
        if (this.y && !this.A) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.A = true;
        return (T) M();
    }
}
