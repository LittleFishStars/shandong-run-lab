package cj.mobile.wm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j8 implements g8, f8 {
    public f8 dexa;
    public f8 dexb;
    public g8 dexc;

    public j8(g8 g8Var) {
        this.dexc = g8Var;
    }

    private boolean dexa() {
        g8 g8Var = this.dexc;
        return g8Var == null || g8Var.dexc(this);
    }

    private boolean dexb() {
        g8 g8Var = this.dexc;
        return g8Var == null || g8Var.dexb(this);
    }

    private boolean dexc() {
        g8 g8Var = this.dexc;
        return g8Var != null && g8Var.f();
    }

    @Override // cj.mobile.wm.f8
    public void a() {
        this.dexa.a();
        this.dexb.a();
    }

    @Override // cj.mobile.wm.f8
    public void b() {
        this.dexa.b();
        this.dexb.b();
    }

    @Override // cj.mobile.wm.f8
    public boolean c() {
        return this.dexa.c() || this.dexb.c();
    }

    @Override // cj.mobile.wm.f8
    public void clear() {
        this.dexb.clear();
        this.dexa.clear();
    }

    @Override // cj.mobile.wm.f8
    public boolean d() {
        return this.dexa.d() || this.dexb.d();
    }

    @Override // cj.mobile.wm.g8
    public void dexa(f8 f8Var) {
        if (f8Var.equals(this.dexb)) {
            return;
        }
        g8 g8Var = this.dexc;
        if (g8Var != null) {
            g8Var.dexa(this);
        }
        if (this.dexb.d()) {
            return;
        }
        this.dexb.clear();
    }

    public void dexa(f8 f8Var, f8 f8Var2) {
        this.dexa = f8Var;
        this.dexb = f8Var2;
    }

    @Override // cj.mobile.wm.g8
    public boolean dexb(f8 f8Var) {
        return dexb() && (f8Var.equals(this.dexa) || !this.dexa.c());
    }

    @Override // cj.mobile.wm.g8
    public boolean dexc(f8 f8Var) {
        return dexa() && f8Var.equals(this.dexa) && !f();
    }

    @Override // cj.mobile.wm.f8
    public void e() {
        if (!this.dexb.isRunning()) {
            this.dexb.e();
        }
        if (this.dexa.isRunning()) {
            return;
        }
        this.dexa.e();
    }

    @Override // cj.mobile.wm.g8
    public boolean f() {
        return dexc() || c();
    }

    @Override // cj.mobile.wm.f8
    public boolean isCancelled() {
        return this.dexa.isCancelled();
    }

    @Override // cj.mobile.wm.f8
    public boolean isRunning() {
        return this.dexa.isRunning();
    }
}
