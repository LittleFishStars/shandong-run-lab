package cj.mobile.wm;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d6 implements a8<q4, Bitmap> {
    public final c6 dexa;
    public final t2<File, Bitmap> dexb;
    public final u2<Bitmap> dexc;
    public final r4 dexd;

    public d6(a8<InputStream, Bitmap> a8Var, a8<ParcelFileDescriptor, Bitmap> a8Var2) {
        this.dexc = a8Var.c();
        this.dexd = new r4(a8Var.d(), a8Var2.d());
        this.dexb = a8Var.a();
        this.dexa = new c6(a8Var.f(), a8Var2.f());
    }

    @Override // cj.mobile.wm.a8
    public t2<File, Bitmap> a() {
        return this.dexb;
    }

    @Override // cj.mobile.wm.a8
    public u2<Bitmap> c() {
        return this.dexc;
    }

    @Override // cj.mobile.wm.a8
    public q2<q4> d() {
        return this.dexd;
    }

    @Override // cj.mobile.wm.a8
    public t2<q4, Bitmap> f() {
        return this.dexa;
    }
}
