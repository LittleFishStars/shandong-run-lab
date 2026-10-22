package cj.mobile.wm;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class y6 {
    public final n3<p6> dexa;
    public final n3<Bitmap> dexb;

    public y6(n3<Bitmap> n3Var, n3<p6> n3Var2) {
        if (n3Var != null && n3Var2 != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        }
        if (n3Var == null && n3Var2 == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        }
        this.dexb = n3Var;
        this.dexa = n3Var2;
    }

    public n3<Bitmap> dexa() {
        return this.dexb;
    }

    public n3<p6> dexb() {
        return this.dexa;
    }

    public int dexc() {
        n3<Bitmap> n3Var = this.dexb;
        return n3Var != null ? n3Var.getSize() : this.dexa.getSize();
    }
}
