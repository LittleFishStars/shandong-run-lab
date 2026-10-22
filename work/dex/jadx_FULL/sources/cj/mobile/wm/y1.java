package cj.mobile.wm;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class y1<ModelType> extends x1<ModelType, Bitmap> {
    public final v4<ModelType, InputStream> dex09;
    public final v4<ModelType, ParcelFileDescriptor> dex10;
    public final d2 dex11;
    public final f2.dexd dex12;

    public y1(b2<ModelType, ?, ?, ?> b2Var, v4<ModelType, InputStream> v4Var, v4<ModelType, ParcelFileDescriptor> v4Var2, f2.dexd dexdVar) {
        super(dexa(b2Var.dexc, v4Var, v4Var2, Bitmap.class, null), Bitmap.class, b2Var);
        this.dex09 = v4Var;
        this.dex10 = v4Var2;
        this.dex11 = b2Var.dexc;
        this.dex12 = dexdVar;
    }

    public static <A, R> d8<A, q4, Bitmap, R> dexa(d2 d2Var, v4<A, InputStream> v4Var, v4<A, ParcelFileDescriptor> v4Var2, Class<R> cls, h7<Bitmap, R> h7Var) {
        if (v4Var == null && v4Var2 == null) {
            return null;
        }
        if (h7Var == null) {
            h7Var = d2Var.dexb(Bitmap.class, cls);
        }
        return new d8<>(new p4(v4Var, v4Var2), h7Var, d2Var.dexa(q4.class, Bitmap.class));
    }
}
