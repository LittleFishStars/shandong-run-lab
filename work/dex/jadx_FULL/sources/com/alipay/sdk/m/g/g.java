package com.alipay.sdk.m.g;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g implements i, j {
    public static Object a(Field field, Object obj) throws IllegalAccessException {
        if (field == null || obj == null || "this$0".equals(field.getName())) {
            return null;
        }
        boolean zIsAccessible = field.isAccessible();
        field.setAccessible(true);
        Object obj2 = field.get(obj);
        if (obj2 == null) {
            return null;
        }
        field.setAccessible(zIsAccessible);
        return f.b(obj2);
    }

    @Override // com.alipay.sdk.m.g.j
    public Object a(Object obj) throws IllegalAccessException {
        TreeMap treeMap = new TreeMap();
        Class<?> superclass = obj.getClass();
        while (true) {
            Field[] declaredFields = superclass.getDeclaredFields();
            if (superclass.equals(Object.class)) {
                return treeMap;
            }
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    Object objA = a(field, obj);
                    if (objA != null) {
                        treeMap.put(field.getName(), objA);
                    }
                }
            }
            superclass = superclass.getSuperclass();
        }
    }

    @Override // com.alipay.sdk.m.g.i
    public Object a(Object obj, Type type) throws IllegalAccessException, InstantiationException {
        if (!obj.getClass().equals(org.json.alipay.b.class)) {
            return null;
        }
        org.json.alipay.b bVar = (org.json.alipay.b) obj;
        Class superclass = (Class) type;
        Object objNewInstance = superclass.newInstance();
        while (!superclass.equals(Object.class)) {
            Field[] declaredFields = superclass.getDeclaredFields();
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    String name = field.getName();
                    Type genericType = field.getGenericType();
                    if (bVar.b(name)) {
                        field.setAccessible(true);
                        field.set(objNewInstance, e.a(bVar.a(name), genericType));
                    }
                }
            }
            superclass = superclass.getSuperclass();
        }
        return objNewInstance;
    }

    @Override // com.alipay.sdk.m.g.i, com.alipay.sdk.m.g.j
    public boolean a(Class<?> cls) {
        return true;
    }
}
