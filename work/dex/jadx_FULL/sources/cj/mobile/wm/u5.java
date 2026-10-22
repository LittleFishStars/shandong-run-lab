package cj.mobile.wm;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class u5 implements v2<Bitmap> {
    public r3 dexa;

    public u5(r3 r3Var) {
        this.dexa = r3Var;
    }

    public abstract Bitmap dexa(r3 r3Var, Bitmap bitmap, int i, int i2);

    @Override // cj.mobile.wm.v2
    public final n3<Bitmap> dexa(n3<Bitmap> n3Var, int i, int i2) {
        if (e9.dexa(i, i2)) {
            Bitmap bitmap = n3Var.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap bitmapDexa = dexa(this.dexa, bitmap, i, i2);
            return bitmap.equals(bitmapDexa) ? n3Var : t5.dexa(bitmapDexa, this.dexa);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
