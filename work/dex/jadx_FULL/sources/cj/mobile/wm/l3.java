package cj.mobile.wm;

import android.os.Looper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class l3<Z> implements n3<Z> {
    public final n3<Z> dexa;
    public final boolean dexb;
    public dexa dexc;
    public r2 dexd;
    public int dexe;
    public boolean dexf;

    public interface dexa {
        void dexa(r2 r2Var, l3<?> l3Var);
    }

    public l3(n3<Z> n3Var, boolean z) {
        if (n3Var == null) {
            throw new NullPointerException("Wrapped resource must not be null");
        }
        this.dexa = n3Var;
        this.dexb = z;
    }

    @Override // cj.mobile.wm.n3
    public void b() {
        if (this.dexe > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.dexf) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.dexf = true;
        this.dexa.b();
    }

    public void dexa() {
        if (this.dexf) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        this.dexe++;
    }

    public void dexa(r2 r2Var, dexa dexaVar) {
        this.dexd = r2Var;
        this.dexc = dexaVar;
    }

    public boolean dexb() {
        return this.dexb;
    }

    public void dexc() {
        if (this.dexe <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        int i = this.dexe - 1;
        this.dexe = i;
        if (i == 0) {
            this.dexc.dexa(this.dexd, this);
        }
    }

    @Override // cj.mobile.wm.n3
    public Z get() {
        return this.dexa.get();
    }

    @Override // cj.mobile.wm.n3
    public int getSize() {
        return this.dexa.getSize();
    }
}
