package cj.mobile.wm;

import android.content.res.Resources;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g7 implements h7<Bitmap, a6> {
    public final Resources dexa;
    public final r3 dexb;

    public g7(Resources resources, r3 r3Var) {
        this.dexa = resources;
        this.dexb = r3Var;
    }

    @Override // cj.mobile.wm.h7
    public n3<a6> dexa(n3<Bitmap> n3Var) {
        return new b6(new a6(this.dexa, n3Var.get()), this.dexb);
    }

    @Override // cj.mobile.wm.h7
    public String getId() {
        return "GlideBitmapDrawableTranscoder.com.youku.insightvision.sdk.openadsdk.image.glide.load.resource.transcode";
    }
}
