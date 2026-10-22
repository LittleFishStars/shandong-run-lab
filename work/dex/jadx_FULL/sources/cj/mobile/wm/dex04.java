package cj.mobile.wm;

import com.easyjson.JSON;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class dex04 implements dex06, dex05 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TimeZone f22670a = TimeZone.getDefault();
    public static Locale b = Locale.getDefault();
    public static int c = ((com.wangmai.insightvision.openadsdk.d.i.d.h.t | 0) | com.wangmai.insightvision.openadsdk.d.i.d.j.t) | com.wangmai.insightvision.openadsdk.d.i.d.i.t;
    public static String d = "yyyy-MM-dd HH:mm:ss";
    public static int e = (((com.wangmai.insightvision.openadsdk.d.j.a0.a.y | 0) | com.wangmai.insightvision.openadsdk.d.j.a0.j.y) | com.wangmai.insightvision.openadsdk.d.j.a0.d.y) | com.wangmai.insightvision.openadsdk.d.j.a0.k.y;

    public static final Object a(Object obj) {
        return a(obj, k0.dexd);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public static Object a(Object obj, k0 k0Var) throws com.wangmai.insightvision.openadsdk.d.d {
        if (obj == null) {
            return null;
        }
        if (obj instanceof dex04) {
            return (dex04) obj;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            int size = map.size();
            com.wangmai.insightvision.openadsdk.d.e eVar = new com.wangmai.insightvision.openadsdk.d.e(map instanceof LinkedHashMap ? new LinkedHashMap(size) : map instanceof TreeMap ? new TreeMap() : new HashMap(size));
            for (Map.Entry entry : map.entrySet()) {
                eVar.a(q0.dexm(entry.getKey()), a(entry.getValue()));
            }
            return eVar;
        }
        if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            com.wangmai.insightvision.openadsdk.d.b bVar = new com.wangmai.insightvision.openadsdk.d.b(collection.size());
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                bVar.add(a(it.next()));
            }
            return bVar;
        }
        Class<?> cls = obj.getClass();
        if (cls.isEnum()) {
            return ((Enum) obj).name();
        }
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            com.wangmai.insightvision.openadsdk.d.b bVar2 = new com.wangmai.insightvision.openadsdk.d.b(length);
            for (int i = 0; i < length; i++) {
                bVar2.add(a(Array.get(obj, i)));
            }
            return bVar2;
        }
        if (a.dexa(cls)) {
            return obj;
        }
        g0 g0VarDexa = k0Var.dexa(cls);
        if (!(g0VarDexa instanceof a0)) {
            return null;
        }
        a0 a0Var = (a0) g0VarDexa;
        com.wangmai.insightvision.openadsdk.d.e eVar2 = new com.wangmai.insightvision.openadsdk.d.e();
        try {
            for (Map.Entry<String, Object> entry2 : a0Var.dexa(obj).entrySet()) {
                eVar2.a(entry2.getKey(), a(entry2.getValue()));
            }
            return eVar2;
        } catch (Exception e2) {
            throw new com.wangmai.insightvision.openadsdk.d.d("toJSON error", e2);
        }
    }

    public static final Object a(String str) {
        return a(str, c);
    }

    public static final Object a(String str, int i) {
        if (str == null) {
            return null;
        }
        dex11 dex11Var = new dex11(str, a.dexg, i);
        Object objDexb = dex11Var.dexb((Object) null);
        dex11Var.dexa(objDexb);
        dex11Var.close();
        return objDexb;
    }

    public static final <T> T a(String str, Class<T> cls) {
        return (T) a(str, cls, new com.wangmai.insightvision.openadsdk.d.i.d[0]);
    }

    public static final <T> T a(String str, Class<T> cls, com.wangmai.insightvision.openadsdk.d.i.d... dVarArr) {
        return (T) a(str, cls, a.dexg, c, dVarArr);
    }

    public static final <T> T a(String str, Type type, a aVar, int i, com.wangmai.insightvision.openadsdk.d.i.d... dVarArr) {
        return (T) a(str, type, aVar, (k) null, i, dVarArr);
    }

    public static final <T> T a(String str, Type type, a aVar, k kVar, int i, com.wangmai.insightvision.openadsdk.d.i.d... dVarArr) {
        if (str == null) {
            return null;
        }
        for (com.wangmai.insightvision.openadsdk.d.i.d dVar : dVarArr) {
            i |= dVar.t;
        }
        dex11 dex11Var = new dex11(str, aVar, i);
        if (kVar instanceof g) {
            dex11Var.dexc().add((g) kVar);
        }
        if (kVar instanceof f) {
            dex11Var.dexb().add((f) kVar);
        }
        if (kVar instanceof i) {
            dex11Var.dexm = (i) kVar;
        }
        T t = (T) dex11Var.dexa(type);
        dex11Var.dexa(t);
        dex11Var.close();
        return t;
    }

    public static String a(Object obj, k0 k0Var, l0[] l0VarArr, String str, int i, com.wangmai.insightvision.openadsdk.d.j.a0... a0VarArr) {
        m0 m0Var = new m0(null, i, a0VarArr);
        try {
            z zVar = new z(m0Var, k0Var);
            for (com.wangmai.insightvision.openadsdk.d.j.a0 a0Var : a0VarArr) {
                zVar.dexa(a0Var, true);
            }
            if (str != null && str.length() != 0) {
                zVar.dexa(str);
                zVar.dexa(com.wangmai.insightvision.openadsdk.d.j.a0.q, true);
            }
            if (l0VarArr != null) {
                for (l0 l0Var : l0VarArr) {
                    if (l0Var != null) {
                        if (l0Var instanceof i0) {
                            zVar.dexg().add((i0) l0Var);
                        }
                        if (l0Var instanceof e0) {
                            zVar.dexe().add((e0) l0Var);
                        }
                        if (l0Var instanceof o) {
                            zVar.dexh().add((o) l0Var);
                        }
                        if (l0Var instanceof h0) {
                            zVar.dexf().add((h0) l0Var);
                        }
                        if (l0Var instanceof q) {
                            zVar.dexc().add((q) l0Var);
                        }
                        if (l0Var instanceof l) {
                            zVar.dexb().add((l) l0Var);
                        }
                    }
                }
            }
            zVar.dexa(obj);
            return m0Var.toString();
        } finally {
            m0Var.close();
        }
    }

    public static final com.wangmai.insightvision.openadsdk.d.e b(String str) {
        Object objA = a(str);
        if ((objA instanceof com.wangmai.insightvision.openadsdk.d.e) || objA == null) {
            return (com.wangmai.insightvision.openadsdk.d.e) objA;
        }
        com.wangmai.insightvision.openadsdk.d.e eVar = (com.wangmai.insightvision.openadsdk.d.e) a(objA);
        if ((c & com.wangmai.insightvision.openadsdk.d.i.d.r.t) != 0) {
            eVar.a(JSON.DEFAULT_TYPE_KEY, objA.getClass().getName());
        }
        return eVar;
    }

    public static final String b(Object obj) {
        return a(obj, k0.dexd, (l0[]) null, (String) null, e, new com.wangmai.insightvision.openadsdk.d.j.a0[0]);
    }

    @Override // cj.mobile.wm.dex05
    public String a() {
        m0 m0Var = new m0(null, e, com.wangmai.insightvision.openadsdk.d.j.a0.w);
        try {
            new z(m0Var, k0.dexd).dexa(this);
            return m0Var.toString();
        } finally {
            m0Var.close();
        }
    }

    @Override // cj.mobile.wm.dex06
    public void a(Appendable appendable) {
        m0 m0Var = new m0(null, e, com.wangmai.insightvision.openadsdk.d.j.a0.w);
        try {
            try {
                new z(m0Var, k0.dexd).dexa(this);
                appendable.append(m0Var.toString());
                m0Var.close();
            } catch (IOException e2) {
                throw new com.wangmai.insightvision.openadsdk.d.d(e2.getMessage(), e2);
            }
        } catch (Throwable th) {
            m0Var.close();
            throw th;
        }
    }

    public String toString() {
        return a();
    }
}
