package cj.mobile.wm;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f7 implements h7<y6, j6> {
    public final h7<Bitmap, a6> dexa;

    public f7(h7<Bitmap, a6> h7Var) {
        this.dexa = h7Var;
    }

    @Override // cj.mobile.wm.h7
    public n3<j6> dexa(n3<y6> n3Var) {
        y6 y6Var = n3Var.get();
        n3<Bitmap> n3VarDexa = y6Var.dexa();
        return n3VarDexa != null ? this.dexa.dexa(n3VarDexa) : y6Var.dexb();
    }

    @Override // cj.mobile.wm.h7
    public String getId() {
        return "GifBitmapWrapperDrawableTranscoder.com.youku.insightvision.sdk.openadsdk.image.glide.load.resource.transcode";
    }
}
