package com.aliyun.vod.qupaiokhttp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class ClassTypeReflect {
    private static Type getGenericType(int i, Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (i >= actualTypeArguments.length || i < 0) {
            throw new RuntimeException("Index outof bounds");
        }
        Type type = actualTypeArguments[i];
        return !(type instanceof Class) ? Object.class : type;
    }

    public static Type getModelClazz(Class<?> cls) {
        return getGenericType(0, cls);
    }
}
