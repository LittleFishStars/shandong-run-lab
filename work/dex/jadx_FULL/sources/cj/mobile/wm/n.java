package cj.mobile.wm;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.IdentityHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class n implements g0, j {
    public static final n dexa = new n();

    private <T> T dexa(dex11 dex11Var, Class<?> cls, com.wangmai.insightvision.openadsdk.d.b bVar) {
        if (bVar == null) {
            return null;
        }
        int size = bVar.size();
        T t = (T) Array.newInstance(cls, size);
        for (int i = 0; i < size; i++) {
            Object objDexa = bVar.get(i);
            if (objDexa == bVar) {
                Array.set(t, i, t);
            } else {
                if (!cls.isArray()) {
                    objDexa = q0.dexa(objDexa, (Class<Object>) cls, dex11Var.dexb);
                } else if (!cls.isInstance(objDexa)) {
                    objDexa = dexa(dex11Var, cls, (com.wangmai.insightvision.openadsdk.d.b) objDexa);
                }
                Array.set(t, i, objDexa);
            }
        }
        bVar.c(t);
        bVar.a(cls);
        return t;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // cj.mobile.wm.j
    public <T> T dexa(dex11 dex11Var, Type type, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        dex13 dex13Var = dex11Var.dexe;
        int iDexu = dex13Var.dexu();
        if (iDexu == 8) {
            dex13Var.dexb(16);
            return null;
        }
        if (type != char[].class) {
            if (iDexu == 4) {
                T t = (T) dex13Var.dexa();
                dex13Var.dexb(16);
                return t;
            }
            Class<?> componentType = ((Class) type).getComponentType();
            com.wangmai.insightvision.openadsdk.d.b bVar = new com.wangmai.insightvision.openadsdk.d.b();
            dex11Var.dexa((Type) componentType, (Collection) bVar, obj);
            return (T) dexa(dex11Var, componentType, bVar);
        }
        if (iDexu == 4) {
            String strDext = dex13Var.dext();
            dex13Var.dexb(16);
            return (T) strDext.toCharArray();
        }
        if (iDexu != 2) {
            return (T) dex04.b(dex11Var.dexe()).toCharArray();
        }
        Number numberDexf = dex13Var.dexf();
        dex13Var.dexb(16);
        return (T) numberDexf.toString().toCharArray();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.g0
    public final void dexa(z zVar, Object obj, Object obj2, Type type) throws com.wangmai.insightvision.openadsdk.d.d {
        m0 m0Var = zVar.dexb;
        Object[] objArr = (Object[]) obj;
        if (obj == null) {
            if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.f.y) != 0) {
                m0Var.write("[]");
                return;
            } else {
                m0Var.dexa();
                return;
            }
        }
        int length = objArr.length;
        int i = length - 1;
        if (i == -1) {
            m0Var.append((CharSequence) "[]");
            return;
        }
        j0 j0Var = zVar.dexm;
        int i2 = 0;
        zVar.dexa(j0Var, obj, obj2, 0);
        try {
            m0Var.write(91);
            if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.m.y) != 0) {
                zVar.dexi();
                zVar.dexj();
                while (i2 < length) {
                    if (i2 != 0) {
                        m0Var.write(44);
                        zVar.dexj();
                    }
                    zVar.dexa(objArr[i2]);
                    i2++;
                }
                zVar.dexa();
                zVar.dexj();
                m0Var.write(93);
                return;
            }
            Class<?> cls = null;
            g0 g0Var = null;
            while (i2 < i) {
                Object obj3 = objArr[i2];
                if (obj3 == null) {
                    m0Var.append((CharSequence) "null,");
                } else {
                    IdentityHashMap<Object, j0> identityHashMap = zVar.dexl;
                    if (identityHashMap == null || !identityHashMap.containsKey(obj3)) {
                        Class<?> cls2 = obj3.getClass();
                        if (cls2 == cls) {
                            g0Var.dexa(zVar, obj3, null, null);
                        } else {
                            g0 g0VarDexa = zVar.dexa.dexa(cls2);
                            g0VarDexa.dexa(zVar, obj3, null, null);
                            g0Var = g0VarDexa;
                            cls = cls2;
                        }
                    } else {
                        zVar.dexb(obj3);
                    }
                    m0Var.write(44);
                }
                i2++;
            }
            Object obj4 = objArr[i];
            if (obj4 == null) {
                m0Var.append((CharSequence) "null]");
            } else {
                IdentityHashMap<Object, j0> identityHashMap2 = zVar.dexl;
                if (identityHashMap2 == null || !identityHashMap2.containsKey(obj4)) {
                    zVar.dexb(obj4, Integer.valueOf(i));
                } else {
                    zVar.dexb(obj4);
                }
                m0Var.write(93);
            }
        } finally {
            zVar.dexm = j0Var;
        }
    }
}
