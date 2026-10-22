package cj.mobile.wm;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dex17 implements j {
    public static final dex17 dexa = new dex17();

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // cj.mobile.wm.j
    public <T> T dexa(dex11 dex11Var, Type type, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        if (!(type instanceof GenericArrayType)) {
            return (T) dex11Var.dexb(obj);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        if (genericComponentType instanceof TypeVariable) {
            genericComponentType = ((TypeVariable) genericComponentType).getBounds()[0];
        }
        ArrayList arrayList = new ArrayList();
        dex11Var.dexa(genericComponentType, (Collection) arrayList);
        if (!(genericComponentType instanceof Class)) {
            return (T) arrayList.toArray();
        }
        T t = (T) ((Object[]) Array.newInstance((Class<?>) genericComponentType, arrayList.size()));
        arrayList.toArray((Object[]) t);
        return t;
    }
}
