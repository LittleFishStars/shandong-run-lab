package cj.mobile.wm;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class z6 implements n3<y6> {
    public final y6 dexa;

    public z6(y6 y6Var) {
        if (y6Var == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.dexa = y6Var;
    }

    @Override // cj.mobile.wm.n3
    public void b() {
        n3<Bitmap> n3VarDexa = this.dexa.dexa();
        if (n3VarDexa != null) {
            n3VarDexa.b();
        }
        n3<p6> n3VarDexb = this.dexa.dexb();
        if (n3VarDexb != null) {
            n3VarDexb.b();
        }
    }

    @Override // cj.mobile.wm.n3
    /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
    public y6 get() {
        return this.dexa;
    }

    @Override // cj.mobile.wm.n3
    public int getSize() {
        return this.dexa.dexc();
    }
}
