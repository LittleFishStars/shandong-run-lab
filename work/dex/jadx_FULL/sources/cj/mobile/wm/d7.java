package cj.mobile.wm;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d7 implements v2<y6> {
    public final v2<Bitmap> dexa;
    public final v2<p6> dexb;

    public d7(r3 r3Var, v2<Bitmap> v2Var) {
        this(v2Var, new s6(v2Var, r3Var));
    }

    public d7(v2<Bitmap> v2Var, v2<p6> v2Var2) {
        this.dexa = v2Var;
        this.dexb = v2Var2;
    }

    @Override // cj.mobile.wm.v2
    public n3<y6> dexa(n3<y6> n3Var, int i, int i2) {
        v2<p6> v2Var;
        v2<Bitmap> v2Var2;
        n3<Bitmap> n3VarDexa = n3Var.get().dexa();
        n3<p6> n3VarDexb = n3Var.get().dexb();
        if (n3VarDexa != null && (v2Var2 = this.dexa) != null) {
            n3<Bitmap> n3VarDexa2 = v2Var2.dexa(n3VarDexa, i, i2);
            return !n3VarDexa.equals(n3VarDexa2) ? new z6(new y6(n3VarDexa2, n3Var.get().dexb())) : n3Var;
        }
        if (n3VarDexb == null || (v2Var = this.dexb) == null) {
            return n3Var;
        }
        n3<p6> n3VarDexa3 = v2Var.dexa(n3VarDexb, i, i2);
        return !n3VarDexb.equals(n3VarDexa3) ? new z6(new y6(n3Var.get().dexa(), n3VarDexa3)) : n3Var;
    }

    @Override // cj.mobile.wm.v2
    public String getId() {
        return this.dexa.getId();
    }
}
