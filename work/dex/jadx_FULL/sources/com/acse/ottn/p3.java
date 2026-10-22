package com.acse.ottn;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p3<T, V> extends k3<T, V> {
    public static final String f = "get";
    public static final String g = "is";
    public static final String h = "set";
    public Method c;
    public Method d;
    public Field e;

    public p3(Class<T> cls, Class<V> cls2, String str) {
        super(cls2, str);
        String str2 = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        String str3 = f + str2;
        try {
            try {
                this.d = cls.getMethod(str3, null);
            } catch (NoSuchMethodException unused) {
                String str4 = g + str2;
                try {
                    try {
                        try {
                            this.d = cls.getMethod(str4, null);
                        } catch (NoSuchFieldException unused2) {
                            throw new v2("No accessor method or field found for property with name " + str);
                        }
                    } catch (NoSuchMethodException unused3) {
                        Method declaredMethod = cls.getDeclaredMethod(str4, null);
                        this.d = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                } catch (NoSuchMethodException unused4) {
                    Field field = cls.getField(str);
                    this.e = field;
                    Class<?> type = field.getType();
                    if (a((Class) cls2, (Class) type)) {
                        return;
                    }
                    throw new v2("Underlying type (" + type + ") does not match Property type (" + cls2 + ")");
                }
            }
        } catch (NoSuchMethodException unused5) {
            Method declaredMethod2 = cls.getDeclaredMethod(str3, null);
            this.d = declaredMethod2;
            declaredMethod2.setAccessible(true);
        }
        Class<?> returnType = this.d.getReturnType();
        if (!a((Class) cls2, (Class) returnType)) {
            throw new v2("Underlying type (" + returnType + ") does not match Property type (" + cls2 + ")");
        }
        try {
            Method declaredMethod3 = cls.getDeclaredMethod(h + str2, returnType);
            this.c = declaredMethod3;
            declaredMethod3.setAccessible(true);
        } catch (NoSuchMethodException unused6) {
        }
    }

    public final boolean a(Class<V> cls, Class cls2) {
        if (cls2 == cls) {
            return true;
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        if (cls2 == Float.TYPE && cls == Float.class) {
            return true;
        }
        if (cls2 == Integer.TYPE && cls == Integer.class) {
            return true;
        }
        if (cls2 == Boolean.TYPE && cls == Boolean.class) {
            return true;
        }
        if (cls2 == Long.TYPE && cls == Long.class) {
            return true;
        }
        if (cls2 == Double.TYPE && cls == Double.class) {
            return true;
        }
        if (cls2 == Short.TYPE && cls == Short.class) {
            return true;
        }
        if (cls2 == Byte.TYPE && cls == Byte.class) {
            return true;
        }
        return cls2 == Character.TYPE && cls == Character.class;
    }

    @Override // com.acse.ottn.k3
    public boolean c() {
        return this.c == null && this.e == null;
    }

    @Override // com.acse.ottn.k3
    public void a(T t, V v) {
        Method method = this.c;
        if (method != null) {
            try {
                method.invoke(t, v);
                return;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        Field field = this.e;
        if (field != null) {
            try {
                field.set(t, v);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        } else {
            throw new UnsupportedOperationException("Property " + a() + " is read-only");
        }
    }

    @Override // com.acse.ottn.k3
    public V a(T t) {
        Method method = this.d;
        if (method != null) {
            try {
                return (V) method.invoke(t, null);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        Field field = this.e;
        if (field != null) {
            try {
                return (V) field.get(t);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        throw new AssertionError();
    }
}
