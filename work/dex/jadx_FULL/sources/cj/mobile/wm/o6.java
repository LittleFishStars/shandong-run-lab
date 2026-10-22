package cj.mobile.wm;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o6 implements j2.dexa {
    public final r3 dexa;

    public o6(r3 r3Var) {
        this.dexa = r3Var;
    }

    @Override // cj.mobile.wm.j2.dexa
    public void a(Bitmap bitmap) {
        if (this.dexa.a(bitmap)) {
            return;
        }
        bitmap.recycle();
    }

    @Override // cj.mobile.wm.j2.dexa
    public Bitmap dexa(int i, int i2, Bitmap.Config config) {
        return this.dexa.dexb(i, i2, config);
    }
}
