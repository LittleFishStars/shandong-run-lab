package cj.mobile.wm;

import android.graphics.Bitmap;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f6 implements t2<InputStream, Bitmap> {
    public final w5 dexa;
    public r3 dexb;
    public com.wangmai.insightvision.openadsdk.image.b.n.a dexc;
    public String dexd;

    public f6(r3 r3Var, com.wangmai.insightvision.openadsdk.image.b.n.a aVar) {
        this(w5.dexc, r3Var, aVar);
    }

    public f6(w5 w5Var, r3 r3Var, com.wangmai.insightvision.openadsdk.image.b.n.a aVar) {
        this.dexa = w5Var;
        this.dexb = r3Var;
        this.dexc = aVar;
    }

    @Override // cj.mobile.wm.t2
    public n3<Bitmap> dexa(InputStream inputStream, int i, int i2) {
        return t5.dexa(this.dexa.dexa(inputStream, this.dexb, i, i2, this.dexc), this.dexb);
    }

    @Override // cj.mobile.wm.t2
    public String getId() {
        if (this.dexd == null) {
            this.dexd = "StreamBitmapDecoder.com.youku.insightvision.sdk.openadsdk.image.glide.load.resource.bitmap" + this.dexa.getId() + this.dexc.name();
        }
        return this.dexd;
    }
}
