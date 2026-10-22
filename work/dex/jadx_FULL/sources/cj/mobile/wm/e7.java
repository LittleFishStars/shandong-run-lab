package cj.mobile.wm;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e7 implements a8<q4, y6> {
    public final t2<File, y6> dexa;
    public final t2<q4, y6> dexb;
    public final u2<y6> dexc;
    public final q2<q4> dexd;

    public e7(a8<q4, Bitmap> a8Var, a8<InputStream, p6> a8Var2, r3 r3Var) {
        a7 a7Var = new a7(a8Var.f(), a8Var2.f(), r3Var);
        this.dexa = new m6(new c7(a7Var));
        this.dexb = a7Var;
        this.dexc = new b7(a8Var.c(), a8Var2.c());
        this.dexd = a8Var.d();
    }

    @Override // cj.mobile.wm.a8
    public t2<File, y6> a() {
        return this.dexa;
    }

    @Override // cj.mobile.wm.a8
    public u2<y6> c() {
        return this.dexc;
    }

    @Override // cj.mobile.wm.a8
    public q2<q4> d() {
        return this.dexd;
    }

    @Override // cj.mobile.wm.a8
    public t2<q4, y6> f() {
        return this.dexb;
    }
}
