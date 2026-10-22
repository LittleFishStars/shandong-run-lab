package cj.mobile.wm;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e2 {
    public final Context dexa;
    public g3 dexb;
    public r3 dexc;
    public f4 dexd;
    public ExecutorService dexe;
    public ExecutorService dexf;
    public com.wangmai.insightvision.openadsdk.image.b.n.a dexg;
    public y3.dexa dexh;

    public e2(Context context) {
        this.dexa = context.getApplicationContext();
    }

    public d2 dexa() {
        if (this.dexe == null) {
            this.dexe = new com.wangmai.insightvision.openadsdk.image.b.n.i.p.a(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.dexf == null) {
            this.dexf = new com.wangmai.insightvision.openadsdk.image.b.n.i.p.a(1);
        }
        g4 g4Var = new g4(this.dexa);
        if (this.dexc == null) {
            this.dexc = new u3(g4Var.dexa());
        }
        if (this.dexd == null) {
            this.dexd = new e4(g4Var.dexb());
        }
        if (this.dexh == null) {
            this.dexh = new d4(this.dexa);
        }
        if (this.dexb == null) {
            this.dexb = new g3(this.dexd, this.dexh, this.dexf, this.dexe);
        }
        if (this.dexg == null) {
            this.dexg = com.wangmai.insightvision.openadsdk.image.b.n.a.d;
        }
        return new d2(this.dexb, this.dexd, this.dexc, this.dexa, this.dexg);
    }
}
