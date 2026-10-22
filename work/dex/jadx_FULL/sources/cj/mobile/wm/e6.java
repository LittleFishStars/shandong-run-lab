package cj.mobile.wm;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e6 implements a8<InputStream, Bitmap> {
    public final f6 dexa;
    public final s5 dexb;
    public final y4 dexc = new y4();
    public final m6<Bitmap> dexd;

    public e6(r3 r3Var, com.wangmai.insightvision.openadsdk.image.b.n.a aVar) {
        f6 f6Var = new f6(r3Var, aVar);
        this.dexa = f6Var;
        this.dexb = new s5();
        this.dexd = new m6<>(f6Var);
    }

    @Override // cj.mobile.wm.a8
    public t2<File, Bitmap> a() {
        return this.dexd;
    }

    @Override // cj.mobile.wm.a8
    public u2<Bitmap> c() {
        return this.dexb;
    }

    @Override // cj.mobile.wm.a8
    public q2<InputStream> d() {
        return this.dexc;
    }

    @Override // cj.mobile.wm.a8
    public t2<InputStream, Bitmap> f() {
        return this.dexa;
    }
}
