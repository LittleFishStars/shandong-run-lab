package com.byazt.rk;

import com.byazt.ks.a;
import com.byazt.ks.n;
import com.byazt.ks.sp;
import com.byazt.ks.uj;
import com.byazt.ks.ve;
import com.byazt.ks.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 973, 13})
public class tt {
    public static final Map<Class, c> c;

    static {
        HashMap map = new HashMap();
        c = map;
        a aVar = new a();
        x xVar = new x();
        sp spVar = new sp();
        com.byazt.ks.tt ttVar = new com.byazt.ks.tt();
        uj ujVar = new uj();
        n nVar = new n();
        com.byazt.ks.c cVar = new com.byazt.ks.c();
        ve veVar = new ve();
        map.put(Integer.class, aVar);
        map.put(Integer.TYPE, aVar);
        map.put(Short.class, xVar);
        map.put(Short.TYPE, xVar);
        map.put(Long.class, spVar);
        map.put(Long.TYPE, spVar);
        map.put(Byte.class, ttVar);
        map.put(Byte.TYPE, ttVar);
        map.put(Double.class, ujVar);
        map.put(Double.TYPE, ujVar);
        map.put(Float.class, nVar);
        map.put(Float.TYPE, nVar);
        map.put(Boolean.class, cVar);
        map.put(Boolean.TYPE, cVar);
        map.put(Character.class, veVar);
        map.put(Character.TYPE, veVar);
    }

    public static void c(Object obj, Field field, Object obj2) {
        Object objC;
        if (field == null || obj2 == null) {
            return;
        }
        Class<?> type = field.getType();
        try {
            objC = type.getConstructor(new Class[0]).newInstance(obj2);
        } catch (Throwable unused) {
            objC = c(type, obj2);
        }
        try {
            field.setAccessible(true);
            field.set(obj, objC);
        } catch (Throwable unused2) {
        }
    }

    public static void c(Object obj, Map<String, Object> map, Field field, String str) {
        Object obj2;
        if (field == null || (obj2 = map.get(str)) == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(obj, obj2);
        } catch (Throwable unused) {
            c(obj, field, obj2);
        }
    }

    public static Object c(Class cls, Object obj) {
        String strValueOf = String.valueOf(obj);
        if (String.class.equals(cls)) {
            return strValueOf;
        }
        c cVar = c.get(cls);
        return cVar == null ? obj : cVar.c(cls, strValueOf);
    }
}
