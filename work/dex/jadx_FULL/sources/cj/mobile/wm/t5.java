package cj.mobile.wm;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class t5 implements n3<Bitmap> {
    public final Bitmap dexa;
    public final r3 dexb;

    public t5(Bitmap bitmap, r3 r3Var) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (r3Var == null) {
            throw new NullPointerException("BitmapPool must not be null");
        }
        this.dexa = bitmap;
        this.dexb = r3Var;
    }

    public static t5 dexa(Bitmap bitmap, r3 r3Var) {
        if (bitmap == null) {
            return null;
        }
        return new t5(bitmap, r3Var);
    }

    @Override // cj.mobile.wm.n3
    public void b() {
        if (this.dexb.a(this.dexa)) {
            return;
        }
        this.dexa.recycle();
    }

    @Override // cj.mobile.wm.n3
    /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.dexa;
    }

    @Override // cj.mobile.wm.n3
    public int getSize() {
        return e9.dexa(this.dexa);
    }
}
