package com.autonavi.aps.amapapi.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class e {
    public static Object a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        Field field = cls.getField(str2);
        field.setAccessible(true);
        return field.get(cls);
    }

    public static int b(String str, String str2) throws Exception {
        return ((Integer) a(str, str2)).intValue();
    }

    public static int b(Object obj, String str, Object... objArr) throws Exception {
        return ((Integer) a(obj, str, objArr)).intValue();
    }

    public static Object a(Object obj, String str, Object... objArr) {
        try {
            return a(obj, obj.getClass(), str, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object a(String str, String str2, Object[] objArr, Class<?>[] clsArr) throws Exception {
        return a(Class.forName(str), str2, objArr, clsArr);
    }

    private static Object a(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws Exception {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(null, objArr);
    }

    public static Object a(Object obj, Class<?> cls, String str, Object... objArr) throws Exception {
        Class<?>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            Class<?> cls2 = objArr[i].getClass();
            clsArr[i] = cls2;
            if (cls2 == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
            if (clsArr[i] == Boolean.class) {
                clsArr[i] = Boolean.TYPE;
            }
            if (clsArr[i] == Double.class) {
                clsArr[i] = Double.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        try {
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable th) {
            try {
                if (th instanceof InvocationTargetException) {
                    b.a(th.getTargetException(), "Reflect", "invokeMethod ".concat(String.valueOf(str)));
                }
            } catch (Throwable unused) {
            }
            return null;
        }
    }
}
