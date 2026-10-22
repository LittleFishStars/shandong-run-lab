package com.netease.nis.wrapper.plugin;

import android.content.Context;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
public final class b {
    private static int a(Class cls, String str, int i) {
        try {
            return a(cls, str).getInt(null);
        } catch (Throwable th) {
            return i;
        }
    }

    private static Object a(Context context, Class cls) {
        if (cls == null) {
            try {
                cls = Class.forName(a.auu.a.c("LwsQFw4aAWAEBBVPMgY6DAIMFQoxJhcRBAU="));
            } catch (Throwable th) {
                return null;
            }
        }
        Method method = cls.getMethod(a.auu.a.c("LRAGFwQdEQ8GAAwXGhE3MRwXBBIB"), new Class[0]);
        method.setAccessible(true);
        Object objInvoke = method.invoke(null, new Object[0]);
        if (objInvoke != null || context == null) {
            return objInvoke;
        }
        Field field = context.getClass().getField(a.auu.a.c("IykbBAUWAQ8VHw=="));
        field.setAccessible(true);
        Object obj = field.get(context);
        Field declaredField = obj.getClass().getDeclaredField(a.auu.a.c("IyQXEQgFDDocIA0TFgQq"));
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static Constructor a(Object obj, Class... clsArr) throws NoSuchMethodException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Constructor<?> declaredConstructor = superclass.getDeclaredConstructor(clsArr);
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                }
                return declaredConstructor;
            } catch (NoSuchMethodException e) {
            }
        }
        throw new NoSuchMethodException(a.auu.a.c("DQoaFhUBEC0RGxdBBAw6DVQVAAEEIwAAABMARQ==") + Arrays.asList(clsArr) + a.auu.a.c("bgsbEUEVCjsLEEUIHUU=") + obj.getClass());
    }

    private static Field a(Class cls, String str) throws NoSuchFieldException {
        for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException(a.auu.a.c("CAwRCQVT") + str + a.auu.a.c("bgsbEUEVCjsLEEUIHUU=") + cls);
    }

    public static Field a(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException(a.auu.a.c("CAwRCQVT") + str + a.auu.a.c("bgsbEUEVCjsLEEUIHUU=") + obj.getClass());
    }

    private static Method a(Class cls, String str, Class... clsArr) throws NoSuchMethodException {
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException(a.auu.a.c("AwAADQ4XRQ==") + str + a.auu.a.c("bhIdEQlTFS8XFQgEBwA8FlQ=") + Arrays.asList(clsArr) + a.auu.a.c("bgsbEUEVCjsLEEUIHUU=") + cls);
    }

    public static Method a(Object obj, String str, Class... clsArr) throws NoSuchMethodException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
            }
        }
        throw new NoSuchMethodException(a.auu.a.c("AwAADQ4XRQ==") + str + a.auu.a.c("bhIdEQlTFS8XFQgEBwA8FlQ=") + Arrays.asList(clsArr) + a.auu.a.c("bgsbEUEVCjsLEEUIHUU=") + obj.getClass());
    }

    private static void a(Object obj, String str, int i) throws IllegalAccessException, NoSuchFieldException {
        if (i <= 0) {
            return;
        }
        Field fieldA = a(obj, str);
        Object[] objArr = (Object[]) fieldA.get(obj);
        int length = objArr.length - i;
        if (length > 0) {
            Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), length);
            System.arraycopy(objArr, i, objArr2, 0, length);
            fieldA.set(obj, objArr2);
        }
    }

    private static void a(Object obj, String str, Object[] objArr) throws IllegalAccessException, NoSuchFieldException {
        Field fieldA = a(obj, str);
        Object[] objArr2 = (Object[]) fieldA.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        fieldA.set(obj, objArr3);
    }
}
