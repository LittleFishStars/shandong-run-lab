package com.autonavi.base.ae.gmap.glyph;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ReflectUtil {
    public static Object getField(String str, Object obj, String str2) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        }
        if (str2 == null || str2.equals("")) {
            throw new IllegalArgumentException("fieldName 不能为空");
        }
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Object getInstance(String str, Object... objArr) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        }
        try {
            Class<?> cls = Class.forName(str);
            if (objArr == null) {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(new Object[0]);
            }
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(clsArr);
            declaredConstructor2.setAccessible(true);
            return declaredConstructor2.newInstance(objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Method getMethod(String str, String str2, Class... clsArr) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        }
        if (str2 == null || str2.equals("")) {
            throw new IllegalArgumentException("methodName不能为空");
        }
        try {
            return Class.forName(str).getDeclaredMethod(str2, clsArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Object invoke(String str, Object obj, String str2, Object... objArr) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        }
        if (str2 == null || str2.equals("")) {
            throw new IllegalArgumentException("methodName不能为空");
        }
        try {
            Class<?> cls = Class.forName(str);
            if (objArr == null) {
                Method declaredMethod = cls.getDeclaredMethod(str2, new Class[0]);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(obj, new Object[0]);
            }
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            Method declaredMethod2 = cls.getDeclaredMethod(str2, clsArr);
            declaredMethod2.setAccessible(true);
            return declaredMethod2.invoke(obj, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Object invokeMethod(Object obj, Method method, Object... objArr) {
        if (method == null) {
            throw new IllegalArgumentException("method 不能为空");
        }
        method.setAccessible(true);
        try {
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void setField(String str, Object obj, String str2, Object obj2) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        }
        if (str2 == null || str2.equals("")) {
            throw new IllegalArgumentException("fieldName 不能为空");
        }
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
