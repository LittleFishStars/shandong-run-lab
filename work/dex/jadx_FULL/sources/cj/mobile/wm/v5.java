package cj.mobile.wm;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class v5 extends u5 {
    public v5(r3 r3Var) {
        super(r3Var);
    }

    @Override // cj.mobile.wm.u5
    public Bitmap dexa(r3 r3Var, Bitmap bitmap, int i, int i2) {
        Bitmap bitmapDexa = r3Var.dexa(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        Bitmap bitmapDexa2 = g6.dexa(bitmapDexa, bitmap, i, i2);
        if (bitmapDexa != null && bitmapDexa != bitmapDexa2 && !r3Var.a(bitmapDexa)) {
            bitmapDexa.recycle();
        }
        return bitmapDexa2;
    }

    @Override // cj.mobile.wm.v2
    public String getId() {
        return "CenterCrop.com.youku.insightvision.sdk.openadsdk.image.glide.load.resource.bitmap";
    }
}
