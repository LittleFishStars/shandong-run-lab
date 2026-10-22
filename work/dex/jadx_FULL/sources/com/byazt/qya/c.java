package com.byazt.qya;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 689, 20})
public class c {
    public static Map<String, Field> c = new HashMap();

    public static Field c(Class<?> cls, String str) {
        Field field;
        String strTt = tt(cls, str);
        synchronized (c) {
            field = c.get(strTt);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                synchronized (c) {
                    continue;
                    c.put(strTt, declaredField);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static String tt(Class<?> cls, String str) {
        return cls.toString() + "#" + str;
    }

    public static Object c(Field field, Object obj) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static Object c(Object obj, String str) throws IllegalAccessException {
        Field fieldC = c(obj.getClass(), str);
        if (fieldC != null) {
            return c(fieldC, obj);
        }
        return null;
    }
}
