package cj.mobile.wm;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c2<ModelType, DataType, ResourceType> extends b2<ModelType, DataType, ResourceType, ResourceType> {
    public final v4<ModelType, DataType> dex04;
    public final Class<DataType> dex05;
    public final Class<ResourceType> dex06;
    public final f2.dexd dex07;

    public c2(Context context, d2 d2Var, Class<ModelType> cls, v4<ModelType, DataType> v4Var, Class<DataType> cls2, Class<ResourceType> cls3, w7 w7Var, q7 q7Var, f2.dexd dexdVar) {
        super(context, cls, dexa(d2Var, v4Var, cls2, cls3, j7.dexa()), cls3, d2Var, w7Var, q7Var);
        this.dex04 = v4Var;
        this.dex05 = cls2;
        this.dex06 = cls3;
        this.dex07 = dexdVar;
    }

    public static <A, T, Z, R> e8<A, T, Z, R> dexa(d2 d2Var, v4<A, T> v4Var, Class<T> cls, Class<Z> cls2, h7<Z, R> h7Var) {
        return new d8(v4Var, h7Var, d2Var.dexa(cls, cls2));
    }
}
