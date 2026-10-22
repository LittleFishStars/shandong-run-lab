package com.byazt.ow;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 37, 20})
public class c extends tt {
    private c() {
    }

    public static c c() {
        if (tt.c != null) {
            return tt.c;
        }
        synchronized (c.class) {
            if (tt.c != null) {
                return tt.c;
            }
            c cVar = new c();
            tt.c = cVar;
            return cVar;
        }
    }

    public static List<String> tt(Class<?> cls) {
        if (!cls.isAnnotationPresent(com.byazt.ls.tt.class)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Field field : cls.getDeclaredFields()) {
            com.byazt.ls.c cVar = (com.byazt.ls.c) field.getAnnotation(com.byazt.ls.c.class);
            if (cVar != null && RVScheduleType.NORMAL.equals(cVar.tt())) {
                arrayList.add(cVar.c());
            }
        }
        return arrayList;
    }

    public com.byazt.kkb.c c(com.byazt.kkb.c cVar) {
        try {
            Class<?> cls = cVar.getClass();
            if (cls.isAnnotationPresent(com.byazt.ls.tt.class)) {
                return "SINGLETON".equals(((com.byazt.ls.tt) cls.getAnnotation(com.byazt.ls.tt.class)).c()) ? cVar : (com.byazt.kkb.c) cls.newInstance();
            }
            return (com.byazt.kkb.c) cls.newInstance();
        } catch (Throwable unused) {
            return cVar;
        }
    }

    public void c(Object obj, Map<String, Object> map) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(com.byazt.ls.tt.class)) {
            c(obj, map, cls);
        }
    }

    private static void c(Object obj, Map<String, Object> map, Class<?> cls) {
        com.byazt.ls.c cVar;
        for (Field field : c(cls)) {
            if (field != null && field.isAnnotationPresent(com.byazt.ls.c.class) && (cVar = (com.byazt.ls.c) field.getAnnotation(com.byazt.ls.c.class)) != null) {
                field.setAccessible(true);
                String strC = cVar.c();
                if (TextUtils.isEmpty(strC)) {
                    strC = com.byazt.ek.c.c(field.getName(), true);
                }
                if (!TextUtils.isEmpty(strC)) {
                    com.byazt.rk.tt.c(obj, map, field, strC);
                }
            }
        }
    }

    public static Field[] c(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null && cls != Object.class) {
            arrayList.addAll(new ArrayList(Arrays.asList(cls.getDeclaredFields())));
            cls = cls.getSuperclass();
        }
        return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
    }
}
