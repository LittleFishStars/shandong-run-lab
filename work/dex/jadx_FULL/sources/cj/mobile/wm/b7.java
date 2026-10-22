package cj.mobile.wm;

import android.graphics.Bitmap;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b7 implements u2<y6> {
    public final u2<Bitmap> dexa;
    public final u2<p6> dexb;
    public String dexc;

    public b7(u2<Bitmap> u2Var, u2<p6> u2Var2) {
        this.dexa = u2Var;
        this.dexb = u2Var2;
    }

    @Override // cj.mobile.wm.q2
    public boolean dexa(n3<y6> n3Var, OutputStream outputStream) {
        y6 y6Var = n3Var.get();
        n3<Bitmap> n3VarDexa = y6Var.dexa();
        return n3VarDexa != null ? this.dexa.dexa(n3VarDexa, outputStream) : this.dexb.dexa(y6Var.dexb(), outputStream);
    }

    @Override // cj.mobile.wm.q2
    public String getId() {
        if (this.dexc == null) {
            this.dexc = this.dexa.getId() + this.dexb.getId();
        }
        return this.dexc;
    }
}
