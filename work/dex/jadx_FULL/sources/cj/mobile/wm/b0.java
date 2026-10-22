package cj.mobile.wm;

import java.lang.reflect.Type;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class b0 implements g0 {
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.g0
    public final void dexa(z zVar, Object obj, Object obj2, Type type) throws com.wangmai.insightvision.openadsdk.d.d {
        m0 m0Var = zVar.dexb;
        int i = 1;
        boolean z = (m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.n.y) != 0;
        Type typeDexb = z ? q0.dexb(type) : null;
        if (obj == null) {
            if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.f.y) != 0) {
                m0Var.write("[]");
                return;
            } else {
                m0Var.dexa();
                return;
            }
        }
        List list = (List) obj;
        int size = list.size();
        if (size == 0) {
            m0Var.append((CharSequence) "[]");
            return;
        }
        j0 j0Var = zVar.dexm;
        if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.o.y) == 0) {
            zVar.dexm = new j0(j0Var, obj, obj2, 0);
            if (zVar.dexl == null) {
                zVar.dexl = new IdentityHashMap<>();
            }
            zVar.dexl.put(obj, zVar.dexm);
        }
        try {
            if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.m.y) != 0) {
                m0Var.write(91);
                zVar.dexi();
                for (int i2 = 0; i2 < size; i2++) {
                    Object obj3 = list.get(i2);
                    if (i2 != 0) {
                        m0Var.write(44);
                    }
                    zVar.dexj();
                    if (obj3 != null) {
                        IdentityHashMap<Object, j0> identityHashMap = zVar.dexl;
                        if (identityHashMap == null || !identityHashMap.containsKey(obj3)) {
                            g0 g0VarDexa = zVar.dexa.dexa(obj3.getClass());
                            zVar.dexm = new j0(j0Var, obj, obj2, 0);
                            g0VarDexa.dexa(zVar, obj3, Integer.valueOf(i2), typeDexb);
                        } else {
                            zVar.dexb(obj3);
                        }
                    } else {
                        zVar.dexb.dexa();
                    }
                }
                zVar.dexa();
                zVar.dexj();
                m0Var.write(93);
                return;
            }
            int i3 = m0Var.dexb + 1;
            if (i3 > m0Var.dexa.length) {
                if (m0Var.dexd == null) {
                    m0Var.dexa(i3);
                } else {
                    m0Var.flush();
                    i3 = 1;
                }
            }
            m0Var.dexa[m0Var.dexb] = '[';
            m0Var.dexb = i3;
            for (int i4 = 0; i4 < list.size(); i4++) {
                Object obj4 = list.get(i4);
                if (i4 != 0) {
                    int i5 = m0Var.dexb + 1;
                    if (i5 > m0Var.dexa.length) {
                        if (m0Var.dexd == null) {
                            m0Var.dexa(i5);
                        } else {
                            m0Var.flush();
                            i5 = 1;
                        }
                    }
                    m0Var.dexa[m0Var.dexb] = ',';
                    m0Var.dexb = i5;
                }
                if (obj4 == null) {
                    m0Var.append((CharSequence) "null");
                } else {
                    Class<?> cls = obj4.getClass();
                    if (cls == Integer.class) {
                        m0Var.dexb(((Integer) obj4).intValue());
                    } else if (cls == Long.class) {
                        long jLongValue = ((Long) obj4).longValue();
                        if (z) {
                            m0Var.dexa(jLongValue);
                            m0Var.write(76);
                        } else {
                            m0Var.dexa(jLongValue);
                        }
                    } else if (cls == String.class) {
                        String str = (String) obj4;
                        if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.b.y) != 0) {
                            m0Var.dexb(str);
                        } else {
                            m0Var.dexa(str, (char) 0, true);
                        }
                    } else {
                        if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.o.y) == 0) {
                            zVar.dexm = new j0(j0Var, obj, obj2, 0);
                        }
                        IdentityHashMap<Object, j0> identityHashMap2 = zVar.dexl;
                        if (identityHashMap2 == null || !identityHashMap2.containsKey(obj4)) {
                            zVar.dexa.dexa(obj4.getClass()).dexa(zVar, obj4, Integer.valueOf(i4), typeDexb);
                        } else {
                            zVar.dexb(obj4);
                        }
                    }
                }
            }
            int i6 = m0Var.dexb + 1;
            if (i6 <= m0Var.dexa.length) {
                i = i6;
            } else if (m0Var.dexd == null) {
                m0Var.dexa(i6);
                i = i6;
            } else {
                m0Var.flush();
            }
            m0Var.dexa[m0Var.dexb] = ']';
            m0Var.dexb = i;
        } finally {
            zVar.dexm = j0Var;
        }
    }
}
