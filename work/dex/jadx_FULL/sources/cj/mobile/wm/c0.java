package cj.mobile.wm;

import com.easyjson.JSON;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class c0 implements g0 {
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:27:0x004d A[PHI: r3
      0x004d: PHI (r3v2 java.util.Map) = (r3v1 java.util.Map), (r3v8 java.util.Map), (r3v8 java.util.Map), (r3v8 java.util.Map) binds: [B:17:0x0033, B:22:0x0041, B:24:0x0045, B:90:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // cj.mobile.wm.g0
    public void dexa(z zVar, Object obj, Object obj2, Type type) throws com.wangmai.insightvision.openadsdk.d.d {
        Map treeMap;
        boolean z;
        Object objDexb;
        Object objDexa;
        m0 m0Var = zVar.dexb;
        if (obj == null) {
            m0Var.dexa();
            return;
        }
        Map mapF = (Map) obj;
        Class<?> cls = mapF.getClass();
        boolean z2 = (cls == com.wangmai.insightvision.openadsdk.d.e.class || cls == HashMap.class || cls == LinkedHashMap.class) && mapF.containsKey(JSON.DEFAULT_TYPE_KEY);
        if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.k.y) == 0) {
            treeMap = mapF;
        } else {
            if (mapF instanceof com.wangmai.insightvision.openadsdk.d.e) {
                mapF = ((com.wangmai.insightvision.openadsdk.d.e) mapF).f();
            }
            if ((mapF instanceof SortedMap) || (mapF instanceof LinkedHashMap)) {
                treeMap = mapF;
            } else {
                try {
                    treeMap = new TreeMap(mapF);
                } catch (Exception unused) {
                    treeMap = mapF;
                }
            }
        }
        IdentityHashMap<Object, j0> identityHashMap = zVar.dexl;
        if (identityHashMap != null && identityHashMap.containsKey(obj)) {
            zVar.dexb(obj);
            return;
        }
        j0 j0Var = zVar.dexm;
        zVar.dexa(j0Var, obj, obj2, 0);
        try {
            m0Var.write(123);
            zVar.dexi();
            if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.n.y) == 0 || z2) {
                z = true;
            } else {
                m0Var.dexa(zVar.dexa.dexb, false);
                m0Var.dexa(obj.getClass().getName());
                z = false;
            }
            Class<?> cls2 = null;
            g0 g0Var = null;
            for (Map.Entry entry : treeMap.entrySet()) {
                Object value = entry.getValue();
                Object key = entry.getKey();
                if (zVar.dexa(obj, key) && zVar.dexa(obj, key, value) && ((objDexa = z.dexa(zVar, obj, (objDexb = zVar.dexb(obj, key, value)), value)) != null || (m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.c.y) != 0)) {
                    if (objDexb instanceof String) {
                        String str = (String) objDexb;
                        if (!z) {
                            m0Var.write(44);
                        }
                        if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.m.y) != 0) {
                            zVar.dexj();
                        }
                        m0Var.dexa(str, true);
                    } else {
                        if (!z) {
                            m0Var.write(44);
                        }
                        if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.u.y) == 0 || (objDexb instanceof Enum)) {
                            zVar.dexa(objDexb);
                        } else {
                            zVar.dexb(dex04.b(objDexb));
                        }
                        m0Var.write(58);
                    }
                    if (objDexa == null) {
                        m0Var.dexa();
                    } else {
                        Class<?> cls3 = objDexa.getClass();
                        if (cls3 == cls2) {
                            g0Var.dexa(zVar, objDexa, objDexb, null);
                        } else {
                            g0 g0VarDexa = zVar.dexa.dexa(cls3);
                            g0VarDexa.dexa(zVar, objDexa, objDexb, null);
                            g0Var = g0VarDexa;
                            cls2 = cls3;
                        }
                    }
                    z = false;
                }
            }
            zVar.dexm = j0Var;
            zVar.dexa();
            if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.m.y) != 0 && treeMap.size() > 0) {
                zVar.dexj();
            }
            m0Var.write(125);
        } catch (Throwable th) {
            zVar.dexm = j0Var;
            throw th;
        }
    }
}
