package cj.mobile.wm;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class t implements g0, j {
    public static final t dexa = new t();

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, com.wangmai.insightvision.openadsdk.d.b, java.util.Collection] */
    @Override // cj.mobile.wm.j
    public <T> T dexa(dex11 dex11Var, Type type, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        Collection collection;
        if (dex11Var.dexe.dexu() == 8) {
            dex11Var.dexe.dexb(16);
            return null;
        }
        if (type == com.wangmai.insightvision.openadsdk.d.b.class) {
            ?? r4 = (T) new com.wangmai.insightvision.openadsdk.d.b();
            dex11Var.dexb((Collection) r4);
            return r4;
        }
        Type rawType = type;
        while (!(rawType instanceof Class)) {
            if (!(rawType instanceof ParameterizedType)) {
                throw new com.wangmai.insightvision.openadsdk.d.d("TODO");
            }
            rawType = ((ParameterizedType) rawType).getRawType();
        }
        Class cls = (Class) rawType;
        if (cls == AbstractCollection.class || cls == Collection.class) {
            collection = (T) new ArrayList();
        } else if (cls.isAssignableFrom(HashSet.class)) {
            collection = (T) new HashSet();
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            collection = (T) new LinkedHashSet();
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            collection = (T) new TreeSet();
        } else if (cls.isAssignableFrom(ArrayList.class)) {
            collection = (T) new ArrayList();
        } else if (cls.isAssignableFrom(EnumSet.class)) {
            collection = (T) EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        } else {
            try {
                collection = (T) ((Collection) cls.newInstance());
            } catch (Exception unused) {
                throw new com.wangmai.insightvision.openadsdk.d.d("create instane error, class " + cls.getName());
            }
        }
        dex11Var.dexa(q0.dexb(type), collection, obj);
        return (T) collection;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.g0
    public void dexa(z zVar, Object obj, Object obj2, Type type) throws com.wangmai.insightvision.openadsdk.d.d {
        String str;
        m0 m0Var = zVar.dexb;
        if (obj == null) {
            if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.f.y) != 0) {
                m0Var.write("[]");
                return;
            } else {
                m0Var.dexa();
                return;
            }
        }
        int i = m0Var.dexc;
        com.wangmai.insightvision.openadsdk.d.j.a0 a0Var = com.wangmai.insightvision.openadsdk.d.j.a0.n;
        Type typeDexb = (i & a0Var.y) != 0 ? q0.dexb(type) : null;
        Collection collection = (Collection) obj;
        j0 j0Var = zVar.dexm;
        int i2 = 0;
        zVar.dexa(j0Var, obj, obj2, 0);
        if ((m0Var.dexc & a0Var.y) != 0) {
            if (HashSet.class != collection.getClass()) {
                str = TreeSet.class == collection.getClass() ? "TreeSet" : "Set";
            }
            m0Var.append((CharSequence) str);
        }
        try {
            m0Var.write(91);
            for (Object obj3 : collection) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    m0Var.write(44);
                }
                if (obj3 == null) {
                    m0Var.dexa();
                } else {
                    Class<?> cls = obj3.getClass();
                    if (cls == Integer.class) {
                        m0Var.dexb(((Integer) obj3).intValue());
                    } else if (cls == Long.class) {
                        m0Var.dexa(((Long) obj3).longValue());
                        if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.n.y) != 0) {
                            m0Var.write(76);
                        }
                    } else {
                        zVar.dexa.dexa(cls).dexa(zVar, obj3, Integer.valueOf(i3 - 1), typeDexb);
                    }
                }
                i2 = i3;
            }
            m0Var.write(93);
        } finally {
            zVar.dexm = j0Var;
        }
    }
}
