package cj.mobile.wm;

import android.graphics.Bitmap;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a7 implements t2<q4, y6> {
    public static final dexb dexg = new dexb();
    public static final dexa dexh = new dexa();
    public final t2<q4, Bitmap> dexa;
    public final t2<InputStream, p6> dexb;
    public final r3 dexc;
    public final dexb dexd;
    public final dexa dexe;
    public String dexf;

    public static class dexa {
        public InputStream dexa(InputStream inputStream, byte[] bArr) {
            return new com.wangmai.insightvision.openadsdk.image.b.n.k.e.o(inputStream, bArr);
        }
    }

    public static class dexb {
        public com.wangmai.insightvision.openadsdk.image.b.n.k.e.l.a dexa(InputStream inputStream) {
            return new com.wangmai.insightvision.openadsdk.image.b.n.k.e.l(inputStream).e();
        }
    }

    public a7(t2<q4, Bitmap> t2Var, t2<InputStream, p6> t2Var2, r3 r3Var) {
        this(t2Var, t2Var2, r3Var, dexg, dexh);
    }

    public a7(t2<q4, Bitmap> t2Var, t2<InputStream, p6> t2Var2, r3 r3Var, dexb dexbVar, dexa dexaVar) {
        this.dexa = t2Var;
        this.dexb = t2Var2;
        this.dexc = r3Var;
        this.dexd = dexbVar;
        this.dexe = dexaVar;
    }

    private y6 dexa(q4 q4Var, int i, int i2, byte[] bArr) {
        return q4Var.dexb() != null ? dexb(q4Var, i, i2, bArr) : dexb(q4Var, i, i2);
    }

    private y6 dexa(InputStream inputStream, int i, int i2) {
        n3<p6> n3VarDexa = this.dexb.dexa(inputStream, i, i2);
        if (n3VarDexa == null) {
            return null;
        }
        p6 p6Var = n3VarDexa.get();
        return p6Var.dexc() > 1 ? new y6(null, n3VarDexa) : new y6(new t5(p6Var.dexb(), this.dexc), null);
    }

    private y6 dexb(q4 q4Var, int i, int i2) {
        n3<Bitmap> n3VarDexa = this.dexa.dexa(q4Var, i, i2);
        if (n3VarDexa != null) {
            return new y6(n3VarDexa, null);
        }
        return null;
    }

    private y6 dexb(q4 q4Var, int i, int i2, byte[] bArr) throws IOException {
        InputStream inputStreamDexa = this.dexe.dexa(q4Var.dexb(), bArr);
        inputStreamDexa.mark(2048);
        com.wangmai.insightvision.openadsdk.image.b.n.k.e.l.a aVarDexa = this.dexd.dexa(inputStreamDexa);
        inputStreamDexa.reset();
        y6 y6VarDexa = aVarDexa == com.wangmai.insightvision.openadsdk.image.b.n.k.e.l.a.a ? dexa(inputStreamDexa, i, i2) : null;
        return y6VarDexa == null ? dexb(new q4(inputStreamDexa, q4Var.dexa()), i, i2) : y6VarDexa;
    }

    @Override // cj.mobile.wm.t2
    public n3<y6> dexa(q4 q4Var, int i, int i2) {
        x8 x8VarDexb = x8.dexb();
        byte[] bArrDexa = x8VarDexb.dexa();
        try {
            y6 y6VarDexa = dexa(q4Var, i, i2, bArrDexa);
            x8VarDexb.dexa(bArrDexa);
            if (y6VarDexa != null) {
                return new z6(y6VarDexa);
            }
            return null;
        } catch (Throwable th) {
            x8VarDexb.dexa(bArrDexa);
            throw th;
        }
    }

    @Override // cj.mobile.wm.t2
    public String getId() {
        if (this.dexf == null) {
            this.dexf = this.dexb.getId() + this.dexa.getId();
        }
        return this.dexf;
    }
}
