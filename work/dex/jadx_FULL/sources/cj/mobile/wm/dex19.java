package cj.mobile.wm;

import com.easyjson.JSON;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dex19 implements j {
    public static dex19 dexa = new dex19();

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:39:0x00a8 A[Catch: all -> 0x0148, TRY_LEAVE, TryCatch #0 {all -> 0x0148, blocks: (B:9:0x0042, B:11:0x0048, B:16:0x0055, B:18:0x0059, B:20:0x005d, B:22:0x0066, B:24:0x006e, B:26:0x0075, B:28:0x0081, B:29:0x0083, B:37:0x00a1, B:39:0x00a8, B:42:0x00b1, B:43:0x00b8, B:30:0x0087, B:33:0x0090, B:36:0x0096, B:44:0x00b9, B:45:0x00d3, B:46:0x00d4, B:50:0x00de, B:52:0x00e8, B:54:0x00f0, B:56:0x00fc, B:59:0x0103, B:60:0x0106, B:62:0x0111, B:64:0x011c, B:65:0x011f, B:67:0x0128, B:69:0x012e, B:70:0x0147), top: B:74:0x0042 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00b1 A[Catch: all -> 0x0148, TRY_ENTER, TryCatch #0 {all -> 0x0148, blocks: (B:9:0x0042, B:11:0x0048, B:16:0x0055, B:18:0x0059, B:20:0x005d, B:22:0x0066, B:24:0x006e, B:26:0x0075, B:28:0x0081, B:29:0x0083, B:37:0x00a1, B:39:0x00a8, B:42:0x00b1, B:43:0x00b8, B:30:0x0087, B:33:0x0090, B:36:0x0096, B:44:0x00b9, B:45:0x00d3, B:46:0x00d4, B:50:0x00de, B:52:0x00e8, B:54:0x00f0, B:56:0x00fc, B:59:0x0103, B:60:0x0106, B:62:0x0111, B:64:0x011c, B:65:0x011f, B:67:0x0128, B:69:0x012e, B:70:0x0147), top: B:74:0x0042 }] */
    public static Object dexa(dex11 dex11Var, Map<Object, Object> map, Type type, Type type2, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        Object obj2;
        dex20 dex20Var;
        dex13 dex13Var = dex11Var.dexe;
        int i = dex13Var.dexa;
        int i2 = 16;
        if (i != 12 && i != 16) {
            throw new com.wangmai.insightvision.openadsdk.d.d("syntax error, expect {, actual " + dex14.dexa(i));
        }
        j jVarDexa = dex11Var.dexb.dexa(type);
        j jVarDexa2 = dex11Var.dexb.dexa(type2);
        dex13Var.dexk();
        dex20 dex20Var2 = dex11Var.dexf;
        while (true) {
            try {
                int i3 = dex13Var.dexa;
                if (i3 == 13) {
                    dex13Var.dexb(i2);
                    dex11Var.dexa(dex20Var2);
                    return map;
                }
                if (i3 == 4 && dex13Var.dexh == 4) {
                    if (dex13Var.dexq.startsWith("$ref", dex13Var.dexk + 1) && !dex13Var.dexa(com.wangmai.insightvision.openadsdk.d.i.d.p)) {
                        dex13Var.dexa(com.google.common.net.c.b);
                        if (dex13Var.dexa != 4) {
                            throw new com.wangmai.insightvision.openadsdk.d.d("illegal ref, " + dex14.dexa(i3));
                        }
                        String strDext = dex13Var.dext();
                        if (!"..".equals(strDext)) {
                            if ("$".equals(strDext)) {
                                dex20Var = dex20Var2;
                                while (true) {
                                    dex20 dex20Var3 = dex20Var.dexb;
                                    if (dex20Var3 == null) {
                                        break;
                                    }
                                    dex20Var = dex20Var3;
                                }
                            } else {
                                dex11Var.dexa(new dex11.dexa(dex20Var2, strDext));
                                dex11Var.dexj = 1;
                                obj2 = null;
                            }
                            dex13Var.dexb(13);
                            if (dex13Var.dexa == 13) {
                                throw new com.wangmai.insightvision.openadsdk.d.d("illegal ref");
                            }
                            dex13Var.dexb(16);
                            dex11Var.dexa(dex20Var2);
                            return obj2;
                        }
                        dex20Var = dex20Var2.dexb;
                        obj2 = dex20Var.dexa;
                        dex13Var.dexb(13);
                        if (dex13Var.dexa == 13) {
                            throw new com.wangmai.insightvision.openadsdk.d.d("illegal ref");
                        }
                        dex13Var.dexb(16);
                        dex11Var.dexa(dex20Var2);
                        return obj2;
                    }
                }
                if (map.size() == 0 && i3 == 4 && JSON.DEFAULT_TYPE_KEY.equals(dex13Var.dext()) && !dex13Var.dexa(com.wangmai.insightvision.openadsdk.d.i.d.p)) {
                    dex13Var.dexa(com.google.common.net.c.b);
                    dex13Var.dexb(16);
                    if (dex13Var.dexa == 13) {
                        dex13Var.dexk();
                        dex11Var.dexa(dex20Var2);
                        return map;
                    }
                    dex13Var.dexk();
                }
                Object objDexa = jVarDexa.dexa(dex11Var, type, null);
                if (dex13Var.dexa != 17) {
                    throw new com.wangmai.insightvision.openadsdk.d.d("syntax error, expect :, actual " + dex13Var.dexa);
                }
                dex13Var.dexk();
                Object objDexa2 = jVarDexa2.dexa(dex11Var, type2, objDexa);
                if (dex11Var.dexj == 1) {
                    dex11Var.dexa(map, objDexa);
                }
                map.put(objDexa, objDexa2);
                if (dex13Var.dexa == 16) {
                    dex13Var.dexk();
                }
                i2 = 16;
            } catch (Throwable th) {
                dex11Var.dexa(dex20Var2);
                throw th;
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public static Map dexa(dex11 dex11Var, Map<String, Object> map, Type type, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        String strDexb;
        dex13 dex13Var = dex11Var.dexe;
        if (dex13Var.dexa != 12) {
            throw new com.wangmai.insightvision.openadsdk.d.d("syntax error, expect {, actual " + dex13Var.dexa);
        }
        dex20 dex20Var = dex11Var.dexf;
        while (true) {
            try {
                dex13Var.dexs();
                char c = dex13Var.dexd;
                if (c == ',') {
                    dex13Var.dexi();
                } else {
                    if (c == '\"') {
                        strDexb = dex13Var.dexa(dex11Var.dexa, '\"');
                        dex13Var.dexs();
                        if (dex13Var.dexd != ':') {
                            throw new com.wangmai.insightvision.openadsdk.d.d("syntax error, " + dex13Var.dexd());
                        }
                    } else {
                        if (c == '}') {
                            dex13Var.dexi();
                            dex13Var.dexh = 0;
                            dex13Var.dexb(16);
                            dex11Var.dexa(dex20Var);
                            return map;
                        }
                        if (c == '\'') {
                            strDexb = dex13Var.dexa(dex11Var.dexa, '\'');
                            dex13Var.dexs();
                            if (dex13Var.dexd != ':') {
                                throw new com.wangmai.insightvision.openadsdk.d.d("syntax error, " + dex13Var.dexd());
                            }
                        } else {
                            strDexb = dex13Var.dexb(dex11Var.dexa);
                            dex13Var.dexs();
                            char c2 = dex13Var.dexd;
                            if (c2 != ':') {
                                throw new com.wangmai.insightvision.openadsdk.d.d("expect ':' at " + dex13Var.dexb + ", actual " + c2);
                            }
                        }
                    }
                    dex13Var.dexi();
                    dex13Var.dexs();
                    dex13Var.dexh = 0;
                    Object objDexa = null;
                    if (strDexb != JSON.DEFAULT_TYPE_KEY || dex13Var.dexa(com.wangmai.insightvision.openadsdk.d.i.d.p)) {
                        dex13Var.dexk();
                        dex11Var.dexa(dex20Var);
                        if (dex13Var.dexa == 8) {
                            dex13Var.dexk();
                        } else {
                            objDexa = dex11Var.dexa(type, strDexb);
                        }
                        map.put(strDexb, objDexa);
                        if (dex11Var.dexj == 1) {
                            dex11Var.dexa(map, strDexb);
                        }
                        dex11Var.dexa(dex20Var, objDexa, strDexb);
                        int i = dex13Var.dexa;
                        if (i != 20 && i != 15) {
                            if (i == 13) {
                                dex13Var.dexk();
                                dex11Var.dexa(dex20Var);
                                return map;
                            }
                        }
                        dex11Var.dexa(dex20Var);
                        return map;
                    }
                    Class<?> clsDexa = dex11Var.dexb.dexa(dex13Var.dexa(dex11Var.dexa, '\"'), (Class<?>) null, dex13Var.dexc);
                    if (clsDexa != map.getClass()) {
                        j jVarDexa = dex11Var.dexb.dexa((Type) clsDexa);
                        dex13Var.dexb(16);
                        dex11Var.dexj = 2;
                        if (dex20Var != null && !(obj instanceof Integer)) {
                            dex11Var.dexh();
                        }
                        Map map2 = (Map) jVarDexa.dexa(dex11Var, clsDexa, obj);
                        dex11Var.dexa(dex20Var);
                        return map2;
                    }
                    dex13Var.dexb(16);
                    if (dex13Var.dexa == 13) {
                        dex13Var.dexb(16);
                        dex11Var.dexa(dex20Var);
                        return map;
                    }
                }
            } catch (Throwable th) {
                dex11Var.dexa(dex20Var);
                throw th;
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.j
    public <T> T dexa(dex11 dex11Var, Type type, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        if (type == com.wangmai.insightvision.openadsdk.d.e.class && dex11Var.dexm == null) {
            return (T) dex11Var.dexf();
        }
        dex13 dex13Var = dex11Var.dexe;
        if (dex13Var.dexa == 8) {
            dex13Var.dexb(16);
            return null;
        }
        Map<?, ?> mapDexa = dexa(type);
        dex20 dex20Var = dex11Var.dexf;
        try {
            dex11Var.dexa(dex20Var, mapDexa, obj);
            if (!(type instanceof ParameterizedType)) {
                return (T) dex11Var.dexb(mapDexa, obj);
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            return String.class == type2 ? (T) dexa(dex11Var, mapDexa, type3, obj) : (T) dexa(dex11Var, mapDexa, type2, type3, obj);
        } finally {
            dex11Var.dexa(dex20Var);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public Map<?, ?> dexa(Type type) throws com.wangmai.insightvision.openadsdk.d.d {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type == com.wangmai.insightvision.openadsdk.d.e.class) {
            return new com.wangmai.insightvision.openadsdk.d.e();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return EnumMap.class.equals(rawType) ? new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]) : dexa(rawType);
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new com.wangmai.insightvision.openadsdk.d.d("unsupport type " + type);
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e) {
            throw new com.wangmai.insightvision.openadsdk.d.d("unsupport type " + type, e);
        }
    }
}
