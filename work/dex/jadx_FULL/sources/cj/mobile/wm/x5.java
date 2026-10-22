package cj.mobile.wm;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class x5 implements a8<ParcelFileDescriptor, Bitmap> {
    public final t2<File, Bitmap> dexa;
    public final y5 dexb;
    public final s5 dexc = new s5();
    public final q2<ParcelFileDescriptor> dexd = n5.dexa();

    public x5(r3 r3Var, com.wangmai.insightvision.openadsdk.image.b.n.a aVar) {
        this.dexa = new m6(new f6(r3Var, aVar));
        this.dexb = new y5(r3Var, aVar);
    }

    @Override // cj.mobile.wm.a8
    public t2<File, Bitmap> a() {
        return this.dexa;
    }

    @Override // cj.mobile.wm.a8
    public u2<Bitmap> c() {
        return this.dexc;
    }

    @Override // cj.mobile.wm.a8
    public q2<ParcelFileDescriptor> d() {
        return this.dexd;
    }

    @Override // cj.mobile.wm.a8
    public t2<ParcelFileDescriptor, Bitmap> f() {
        return this.dexb;
    }
}
