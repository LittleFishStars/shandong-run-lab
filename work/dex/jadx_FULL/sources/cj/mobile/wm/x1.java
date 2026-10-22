package cj.mobile.wm;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class x1<ModelType, TranscodeType> extends b2<ModelType, q4, Bitmap, TranscodeType> {
    public final r3 dex04;
    public w5 dex05;
    public com.wangmai.insightvision.openadsdk.image.b.n.a dex06;
    public t2<InputStream, Bitmap> dex07;
    public t2<ParcelFileDescriptor, Bitmap> dex08;

    public x1(e8<ModelType, q4, Bitmap, TranscodeType> e8Var, Class<TranscodeType> cls, b2<ModelType, ?, ?, ?> b2Var) {
        super(e8Var, cls, b2Var);
        this.dex05 = w5.dexc;
        r3 r3VarDexb = b2Var.dexc.dexb();
        this.dex04 = r3VarDexb;
        com.wangmai.insightvision.openadsdk.image.b.n.a aVarDexc = b2Var.dexc.dexc();
        this.dex06 = aVarDexc;
        this.dex07 = new f6(r3VarDexb, aVarDexc);
        this.dex08 = new y5(r3VarDexb, this.dex06);
    }

    @Override // cj.mobile.wm.b2
    /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
    public x1<ModelType, TranscodeType> dexa(int i, int i2) {
        super.dexa(i, i2);
        return this;
    }

    @Override // cj.mobile.wm.b2
    /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
    public x1<ModelType, TranscodeType> dexa(r2 r2Var) {
        super.dexa(r2Var);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cj.mobile.wm.b2
    /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
    public x1<ModelType, TranscodeType> dexa(t2<q4, Bitmap> t2Var) {
        super.dexa((t2) t2Var);
        return this;
    }

    @Override // cj.mobile.wm.b2
    /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
    public x1<ModelType, TranscodeType> dexa(com.wangmai.insightvision.openadsdk.image.b.n.i.b bVar) {
        super.dexa(bVar);
        return this;
    }

    @Override // cj.mobile.wm.b2
    /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
    public x1<ModelType, TranscodeType> dexa(boolean z) {
        super.dexa(z);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cj.mobile.wm.b2
    /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
    public x1<ModelType, TranscodeType> dexa(v2<Bitmap>... v2VarArr) {
        super.dexa((v2[]) v2VarArr);
        return this;
    }

    @Override // cj.mobile.wm.b2
    /* JADX INFO: renamed from: dexc, reason: merged with bridge method [inline-methods] */
    public x1<ModelType, TranscodeType> clone() {
        return (x1) super.clone();
    }
}
