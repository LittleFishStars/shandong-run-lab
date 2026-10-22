package cj.mobile.wm;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class s6 implements v2<p6> {
    public final v2<Bitmap> dexa;
    public final r3 dexb;

    public s6(v2<Bitmap> v2Var, r3 r3Var) {
        this.dexa = v2Var;
        this.dexb = r3Var;
    }

    @Override // cj.mobile.wm.v2
    public n3<p6> dexa(n3<p6> n3Var, int i, int i2) {
        p6 p6Var = n3Var.get();
        Bitmap bitmapDexb = n3Var.get().dexb();
        Bitmap bitmap = this.dexa.dexa(new t5(bitmapDexb, this.dexb), i, i2).get();
        return !bitmap.equals(bitmapDexb) ? new r6(new p6(p6Var, bitmap, this.dexa)) : n3Var;
    }

    @Override // cj.mobile.wm.v2
    public String getId() {
        return this.dexa.getId();
    }
}
