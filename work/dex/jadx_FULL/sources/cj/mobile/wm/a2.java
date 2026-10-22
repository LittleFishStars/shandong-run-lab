package cj.mobile.wm;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a2<ModelType> extends z1<ModelType> {
    public final v4<ModelType, InputStream> dex04;
    public final v4<ModelType, ParcelFileDescriptor> dex05;
    public final f2.dexd dex06;

    public a2(Class<ModelType> cls, v4<ModelType, InputStream> v4Var, v4<ModelType, ParcelFileDescriptor> v4Var2, Context context, d2 d2Var, w7 w7Var, q7 q7Var, f2.dexd dexdVar) {
        super(context, cls, dexa(d2Var, v4Var, v4Var2, y6.class, j6.class, null), d2Var, w7Var, q7Var);
        this.dex04 = v4Var;
        this.dex05 = v4Var2;
        this.dex06 = dexdVar;
    }

    public static <A, Z, R> d8<A, q4, Z, R> dexa(d2 d2Var, v4<A, InputStream> v4Var, v4<A, ParcelFileDescriptor> v4Var2, Class<Z> cls, Class<R> cls2, h7<Z, R> h7Var) {
        if (v4Var == null && v4Var2 == null) {
            return null;
        }
        if (h7Var == null) {
            h7Var = d2Var.dexb(cls, cls2);
        }
        return new d8<>(new p4(v4Var, v4Var2), h7Var, d2Var.dexa(q4.class, cls));
    }

    public y1<ModelType> dexe() {
        f2.dexd dexdVar = this.dex06;
        return (y1) dexdVar.dexa(new y1(this, this.dex04, this.dex05, dexdVar));
    }
}
