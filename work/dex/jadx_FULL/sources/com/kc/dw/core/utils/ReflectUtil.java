package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ReflectUtil {
    public static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method getMethod(Class cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T> T getValue(Class cls, String str) {
        return (T) getValue(cls, str, null);
    }

    public static <T> T getValue(Class cls, String str, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return (T) declaredField.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void invokeMethod(Method method, Object obj, Object... objArr) {
        try {
            method.setAccessible(true);
            method.invoke(obj, objArr);
        } catch (Throwable unused) {
        }
    }

    public static void setValue(Class cls, String str, Object obj) {
        setValue(cls, str, null, obj);
    }

    public static void setValue(Class cls, String str, Object obj, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
