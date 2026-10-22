package com.byazt.bt;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 274, 46})
public final class n {
    public static Method c;
    public static Method tt;
    public static Method ve;

    static {
        try {
            c = Class.class.getDeclaredMethod("forName", String.class);
            tt = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            ve = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException | NullPointerException unused) {
        }
    }

    public static Object c(Object obj, String str, String str2, Object obj2) {
        try {
            Field fieldC = c(str, str2);
            if (fieldC == null) {
                return obj2;
            }
            fieldC.setAccessible(true);
            return fieldC.get(obj);
        } catch (IllegalAccessException unused) {
            return obj2;
        }
    }

    public static Field c(String str, String str2) {
        if (!c()) {
            return null;
        }
        try {
            Field field = (Field) ve.invoke((Class) c.invoke(null, str), str2);
            try {
                field.setAccessible(true);
            } catch (Throwable unused) {
            }
            return field;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static boolean c() {
        return (c == null || tt == null || ve == null) ? false : true;
    }
}
