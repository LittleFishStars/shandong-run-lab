package com.bytedance.pangle.util;

import androidx.annotation.Keep;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public class FieldUtils {
    public static Map<String, Field> sFieldCache = new HashMap();

    public static Field getField(Class<?> cls, String str) {
        Field field;
        String key = getKey(cls, str);
        synchronized (sFieldCache) {
            field = sFieldCache.get(key);
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
                synchronized (sFieldCache) {
                    continue;
                    sFieldCache.put(key, declaredField);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static String getKey(Class<?> cls, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString());
        sb.append("#");
        sb.append(str);
        sb.append("#");
        sb.append(cls.getClassLoader() != null ? Integer.valueOf(cls.getClassLoader().hashCode()) : "");
        return sb.toString();
    }

    public static Object readField(Field field, Object obj) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static Object readStaticField(Field field) throws IllegalAccessException {
        return readField(field, (Object) null);
    }

    public static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        field.set(obj, obj2);
    }

    public static void writeStaticField(Field field, Object obj) throws IllegalAccessException {
        writeField(field, (Object) null, obj);
    }

    public static Object readStaticField(Class<?> cls, String str) throws IllegalAccessException {
        Field field = getField(cls, str);
        if (field != null) {
            return readStaticField(field);
        }
        return null;
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        Field field = getField(cls, str);
        if (field != null) {
            writeStaticField(field, obj);
        }
    }

    public static Object readField(Object obj, String str) throws IllegalAccessException {
        Field field = getField(obj.getClass(), str);
        if (field != null) {
            return readField(field, obj);
        }
        return null;
    }

    public static void writeField(Object obj, String str, Object obj2) throws IllegalAccessException {
        Field field = getField(obj.getClass(), str);
        if (field != null) {
            writeField(field, obj, obj2);
        }
    }
}
