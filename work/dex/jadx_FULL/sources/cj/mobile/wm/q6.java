package cj.mobile.wm;

import android.content.Context;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class q6 implements a8<InputStream, p6> {
    public final w6 dexa;
    public final x6 dexb;
    public final y4 dexc;
    public final m6<p6> dexd;

    public q6(Context context, r3 r3Var) {
        w6 w6Var = new w6(context, r3Var);
        this.dexa = w6Var;
        this.dexd = new m6<>(w6Var);
        this.dexb = new x6(r3Var);
        this.dexc = new y4();
    }

    @Override // cj.mobile.wm.a8
    public t2<File, p6> a() {
        return this.dexd;
    }

    @Override // cj.mobile.wm.a8
    public u2<p6> c() {
        return this.dexb;
    }

    @Override // cj.mobile.wm.a8
    public q2<InputStream> d() {
        return this.dexc;
    }

    @Override // cj.mobile.wm.a8
    public t2<InputStream, p6> f() {
        return this.dexa;
    }
}
