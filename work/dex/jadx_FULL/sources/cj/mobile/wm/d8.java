package cj.mobile.wm;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d8<A, T, Z, R> implements e8<A, T, Z, R> {
    public final v4<A, T> dexa;
    public final h7<Z, R> dexb;
    public final a8<T, Z> dexc;

    public d8(v4<A, T> v4Var, h7<Z, R> h7Var, a8<T, Z> a8Var) {
        if (v4Var == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.dexa = v4Var;
        if (h7Var == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.dexb = h7Var;
        if (a8Var == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.dexc = a8Var;
    }

    @Override // cj.mobile.wm.a8
    public t2<File, Z> a() {
        return this.dexc.a();
    }

    @Override // cj.mobile.wm.e8
    public v4<A, T> b() {
        return this.dexa;
    }

    @Override // cj.mobile.wm.a8
    public u2<Z> c() {
        return this.dexc.c();
    }

    @Override // cj.mobile.wm.a8
    public q2<T> d() {
        return this.dexc.d();
    }

    @Override // cj.mobile.wm.e8
    public h7<Z, R> e() {
        return this.dexb;
    }

    @Override // cj.mobile.wm.a8
    public t2<T, Z> f() {
        return this.dexc.f();
    }
}
