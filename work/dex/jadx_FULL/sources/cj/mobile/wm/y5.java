package cj.mobile.wm;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class y5 implements t2<ParcelFileDescriptor, Bitmap> {
    public final h6 dexa;
    public final r3 dexb;
    public com.wangmai.insightvision.openadsdk.image.b.n.a dexc;

    public y5(h6 h6Var, r3 r3Var, com.wangmai.insightvision.openadsdk.image.b.n.a aVar) {
        this.dexa = h6Var;
        this.dexb = r3Var;
        this.dexc = aVar;
    }

    public y5(r3 r3Var, com.wangmai.insightvision.openadsdk.image.b.n.a aVar) {
        this(new h6(), r3Var, aVar);
    }

    @Override // cj.mobile.wm.t2
    public n3<Bitmap> dexa(ParcelFileDescriptor parcelFileDescriptor, int i, int i2) {
        return t5.dexa(this.dexa.dexa(parcelFileDescriptor, this.dexb, i, i2, this.dexc), this.dexb);
    }

    @Override // cj.mobile.wm.t2
    public String getId() {
        return "FileDescriptorBitmapDecoder.com.youku.insightvision.sdk.openadsdk.image.glide.load.data.bitmap";
    }
}
