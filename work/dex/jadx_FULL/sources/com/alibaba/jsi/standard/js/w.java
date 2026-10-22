package com.alibaba.jsi.standard.js;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class w implements b {
    public static final int n = 0;
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 4;
    public static final int r = 0;
    public static final int s = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24588a;
    com.alibaba.jsi.standard.b t;
    long u;

    public w(com.alibaba.jsi.standard.b bVar) {
        this.f24588a = false;
        this.t = null;
        this.u = 0L;
    }

    @Override // com.alibaba.jsi.standard.js.b
    public void a() {
        long j = this.u;
        if (j != 0 && !this.f24588a) {
            Bridge.nativeDelete(j, 1);
            this.u = 0L;
            com.alibaba.jsi.standard.d.b(this.t, this);
            this.t = null;
        }
        this.f24588a = true;
    }

    public String a_(com.alibaba.jsi.standard.b bVar) {
        long j = this.u;
        if (j == 0) {
            return null;
        }
        Object objCmd = Bridge.cmd(bVar, 50, j);
        if (objCmd instanceof String) {
            return (String) objCmd;
        }
        return null;
    }

    public boolean a_() {
        return false;
    }

    public w b(com.alibaba.jsi.standard.b bVar) {
        long j = this.u;
        if (j == 0) {
            return null;
        }
        Object objCmd = Bridge.cmd(bVar, 51, j);
        if (objCmd instanceof w) {
            return (w) objCmd;
        }
        return null;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean d_() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public o e_() {
        return null;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public z m(com.alibaba.jsi.standard.b bVar) {
        return new z(bVar, this, false);
    }

    public w n(com.alibaba.jsi.standard.b bVar) {
        return this;
    }

    public boolean n() {
        return false;
    }

    public boolean o() {
        return false;
    }

    public boolean o(com.alibaba.jsi.standard.b bVar) {
        return false;
    }

    public x p(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 750, this.u);
        if (objCmd == null || !(objCmd instanceof Long)) {
            return null;
        }
        return new x((Long) objCmd);
    }

    public boolean p() {
        return false;
    }

    public final z q(com.alibaba.jsi.standard.b bVar) {
        Object objCmd;
        t();
        long j = this.u;
        if (j == 0 || (objCmd = Bridge.cmd(bVar, 53, j)) == null || !(objCmd instanceof w)) {
            return null;
        }
        return new z(bVar, (w) objCmd, true);
    }

    public boolean q() {
        return false;
    }

    public final w r(com.alibaba.jsi.standard.b bVar) {
        Object objCmd;
        t();
        long j = this.u;
        if (j == 0 || (objCmd = Bridge.cmd(bVar, 54, j)) == null || !(objCmd instanceof w)) {
            return null;
        }
        return (w) objCmd;
    }

    public boolean r() {
        return false;
    }

    public boolean s() {
        return false;
    }

    public final boolean s(com.alibaba.jsi.standard.b bVar) {
        t();
        long j = this.u;
        return j == 0 || Bridge.cmd(bVar, 55, j) != null;
    }

    public final void t() {
        if (this.f24588a) {
            throw new RuntimeException("JSValue has been deleted: " + this);
        }
    }

    public boolean u() {
        return false;
    }

    @Deprecated
    public x v() {
        return p(this.t);
    }

    public w(com.alibaba.jsi.standard.b bVar, long j) {
        this.f24588a = false;
        this.t = bVar;
        this.u = j;
        if (j != 0) {
            com.alibaba.jsi.standard.d.a(bVar, this);
        }
    }

    public boolean a(w wVar) {
        long j = this.u;
        if (j != 0) {
            long j2 = wVar.u;
            if (j2 != 0 && Bridge.cmd((com.alibaba.jsi.standard.b) null, 52, j, j2) != null) {
                return true;
            }
        }
        return false;
    }
}
