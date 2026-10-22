package cj.mobile.wm;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class z7<A, T, Z, R> implements e8<A, T, Z, R>, Cloneable {
    public final e8<A, T, Z, R> dexa;
    public t2<File, Z> dexb;
    public t2<T, Z> dexc;
    public u2<Z> dexd;
    public h7<Z, R> dexe;
    public q2<T> dexf;

    public z7(e8<A, T, Z, R> e8Var) {
        this.dexa = e8Var;
    }

    @Override // cj.mobile.wm.a8
    public t2<File, Z> a() {
        t2<File, Z> t2Var = this.dexb;
        return t2Var != null ? t2Var : this.dexa.a();
    }

    @Override // cj.mobile.wm.e8
    public v4<A, T> b() {
        return this.dexa.b();
    }

    @Override // cj.mobile.wm.a8
    public u2<Z> c() {
        u2<Z> u2Var = this.dexd;
        return u2Var != null ? u2Var : this.dexa.c();
    }

    @Override // cj.mobile.wm.a8
    public q2<T> d() {
        q2<T> q2Var = this.dexf;
        return q2Var != null ? q2Var : this.dexa.d();
    }

    /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
    public z7<A, T, Z, R> clone() {
        try {
            return (z7) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void dexa(q2<T> q2Var) {
        this.dexf = q2Var;
    }

    public void dexa(t2<T, Z> t2Var) {
        this.dexc = t2Var;
    }

    @Override // cj.mobile.wm.e8
    public h7<Z, R> e() {
        h7<Z, R> h7Var = this.dexe;
        return h7Var != null ? h7Var : this.dexa.e();
    }

    @Override // cj.mobile.wm.a8
    public t2<T, Z> f() {
        t2<T, Z> t2Var = this.dexc;
        return t2Var != null ? t2Var : this.dexa.f();
    }
}
