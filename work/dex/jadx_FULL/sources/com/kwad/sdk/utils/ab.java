package com.kwad.sdk.utils;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.kwad.sdk.liteapi.oaid.helpers.OaidJavaCalls;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class ab {
    private static final Map<Class<?>, Class<?>> PRIMITIVE_MAP;
    private static Method sForNameMethod;
    private static Method sGetDeclaredMethod;
    private static Method sGetFieldMethod;
    private static Map<String, Method> sMethodCache;
    private static final HashMap<Class<?>, Class<?>> sPrimitiveToWrapperMap;

    public static class a<T> {
        public final Class<? extends T> aUM;
        public final T obj;
    }

    static {
        HashMap map = new HashMap();
        PRIMITIVE_MAP = map;
        sMethodCache = new HashMap();
        HashMap<Class<?>, Class<?>> map2 = new HashMap<>();
        sPrimitiveToWrapperMap = map2;
        Class<?> cls = Boolean.TYPE;
        map.put(Boolean.class, cls);
        map.put(Byte.class, Byte.TYPE);
        map.put(Character.class, Character.TYPE);
        map.put(Short.class, Short.TYPE);
        Class<?> cls2 = Integer.TYPE;
        map.put(Integer.class, cls2);
        Class<?> cls3 = Float.TYPE;
        map.put(Float.class, cls3);
        Class<?> cls4 = Long.TYPE;
        map.put(Long.class, cls4);
        map.put(Double.class, Double.TYPE);
        map.put(cls, cls);
        Class cls5 = Byte.TYPE;
        map.put(cls5, cls5);
        Class cls6 = Character.TYPE;
        map.put(cls6, cls6);
        Class cls7 = Short.TYPE;
        map.put(cls7, cls7);
        map.put(cls2, cls2);
        map.put(cls3, cls3);
        map.put(cls4, cls4);
        Class cls8 = Double.TYPE;
        map.put(cls8, cls8);
        map2.put(cls, Boolean.class);
        map2.put(Byte.TYPE, Byte.class);
        map2.put(Character.TYPE, Character.class);
        map2.put(Short.TYPE, Short.class);
        map2.put(cls2, Integer.class);
        map2.put(cls4, Long.class);
        map2.put(Double.TYPE, Double.class);
        map2.put(cls3, Float.class);
        map2.put(Void.TYPE, Void.class);
        try {
            sForNameMethod = Class.class.getDeclaredMethod("forName", String.class);
            sGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            sGetFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static Application HD() {
        try {
            return (Application) Class.forName(ProcessUtils.ACTIVITY_THREAD).getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static boolean UQ() {
        return (sForNameMethod == null || sGetDeclaredMethod == null || sGetFieldMethod == null) ? false : true;
    }

    public static void a(Object obj, String str, Object obj2) {
        try {
            b(obj, str, obj2);
        } catch (Throwable th) {
            wrapToRuntime(th);
        }
    }

    public static <T> T au(String str, String str2) {
        try {
            return (T) av(str, str2);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    private static <T> T av(String str, String str2) {
        return (T) d(Class.forName(str), str2);
    }

    public static void b(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException {
        Class<?> superclass = obj.getClass();
        Field declaredField = null;
        while (declaredField == null) {
            try {
                declaredField = superclass.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
            }
            if (superclass == null) {
                throw new NoSuchFieldException();
            }
        }
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public static <T> T c(Class<?> cls, String str) {
        try {
            return (T) d(cls, str);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    @Deprecated
    public static <T> T callMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) callMethodOrThrow(obj, str, objArr);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    public static <T> T callMethodOrThrow(Object obj, String str, Object... objArr) {
        return (T) getAccessibleMethod(obj.getClass(), str, getParameterTypes(objArr)).invoke(obj, getParameters(objArr));
    }

    @Deprecated
    public static <T> T callStaticMethod(Class<?> cls, String str, Object... objArr) {
        try {
            return (T) callStaticMethodOrThrow(cls, str, objArr);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    private static <T> T callStaticMethodOrThrow(Class<?> cls, String str, Object... objArr) {
        return (T) getAccessibleMethod(cls, str, getParameterTypes(objArr)).invoke(null, getParameters(objArr));
    }

    public static boolean classExists(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    private static <T> T d(Class<?> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return (T) declaredField.get(null);
    }

    private static Method e(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method declaredMethod;
        String key = getKey(cls, str, clsArr);
        synchronized (sMethodCache) {
            declaredMethod = sMethodCache.get(key);
        }
        if (declaredMethod != null) {
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            com.kwad.sdk.core.d.c.d(OaidJavaCalls.TAG, "in new get method from cache: key：" + key + " method:" + declaredMethod.getName());
            return declaredMethod;
        }
        while (cls != null) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                synchronized (sMethodCache) {
                    sMethodCache.put(key, declaredMethod);
                    com.kwad.sdk.core.d.c.d(OaidJavaCalls.TAG, "in new get method:" + declaredMethod.getName());
                }
                return declaredMethod;
            }
            cls = cls.getSuperclass();
        }
        throw new NoSuchMethodException();
    }

    public static <T> T f(Object obj, String str) throws NoSuchFieldException {
        Class<?> superclass = obj.getClass();
        Field declaredField = null;
        while (declaredField == null) {
            try {
                declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
            }
            if (superclass == null) {
                throw new NoSuchFieldException();
            }
        }
        declaredField.setAccessible(true);
        return (T) declaredField.get(obj);
    }

    private static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method declaredMethod;
        String key = getKey(cls, str, clsArr);
        synchronized (sMethodCache) {
            declaredMethod = sMethodCache.get(key);
        }
        if (declaredMethod != null) {
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            com.kwad.sdk.core.d.c.d(OaidJavaCalls.TAG, "in new get method from cache: key：" + key + " method:" + declaredMethod.getName());
            return declaredMethod;
        }
        while (cls != null) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (declaredMethod == null) {
                try {
                    for (Method method : cls.getDeclaredMethods()) {
                        if (method != null && TextUtils.equals(method.getName(), str)) {
                            Class<?>[] parameterTypes = method.getParameterTypes();
                            if (clsArr != null && parameterTypes != null && clsArr.length == parameterTypes.length) {
                                boolean z = true;
                                for (int i = 0; i < clsArr.length; i++) {
                                    if (!isAssignableFrom(clsArr[i], parameterTypes[i])) {
                                        z = false;
                                    }
                                }
                                if (z) {
                                    declaredMethod = method;
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                synchronized (sMethodCache) {
                    sMethodCache.put(key, declaredMethod);
                    com.kwad.sdk.core.d.c.d(OaidJavaCalls.TAG, "in new get method:" + declaredMethod.getName());
                }
                return declaredMethod;
            }
            cls = cls.getSuperclass();
        }
        throw new NoSuchMethodException();
    }

    public static <T> T getField(Object obj, String str) {
        try {
            return (T) f(obj, str);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    private static String getKey(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString());
        sb.append("#");
        sb.append(str);
        sb.append("#");
        sb.append(cls.getClassLoader() != null ? Integer.valueOf(cls.getClassLoader().hashCode()) : "");
        if (clsArr == null || clsArr.length <= 0) {
            sb.append(Void.class.toString());
        } else {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.toString());
                sb.append("#");
            }
        }
        return sb.toString();
    }

    @Deprecated
    private static Class<?>[] getParameterTypes(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = (obj == null || !(obj instanceof a)) ? obj == null ? null : obj.getClass() : ((a) obj).aUM;
        }
        return clsArr;
    }

    private static Object[] getParameters(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof a)) {
                objArr2[i] = obj;
            } else {
                objArr2[i] = ((a) obj).obj;
            }
        }
        return objArr2;
    }

    public static <T> T hK(String str) {
        try {
            return (T) j(Class.forName(str));
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    public static <T> T i(Class<?> cls) {
        try {
            return (T) j(cls);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    private static boolean isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            cls = sPrimitiveToWrapperMap.get(cls);
        }
        if (cls2.isPrimitive() && !cls.isPrimitive()) {
            cls2 = sPrimitiveToWrapperMap.get(cls2);
        }
        return cls2.isAssignableFrom(cls);
    }

    private static <T> T j(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors == null || declaredConstructors.length == 0) {
            throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
        }
        Constructor<?> constructor = declaredConstructors[0];
        constructor.setAccessible(true);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length == 0) {
            return (T) constructor.newInstance(new Object[0]);
        }
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            objArr[i] = k(parameterTypes[i]);
        }
        return (T) constructor.newInstance(objArr);
    }

    private static Object k(Class<?> cls) {
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls) || Byte.TYPE.equals(cls) || Byte.class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return 0;
        }
        if (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) {
            return Boolean.FALSE;
        }
        return (Character.TYPE.equals(cls) || Character.class.equals(cls)) ? (char) 0 : null;
    }

    public static <T> T newInstance(String str, Object... objArr) {
        try {
            return (T) newInstanceOrThrow(str, objArr);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    private static <T> T newInstanceOrThrow(Class<?> cls, Object... objArr) {
        return (T) cls.getConstructor(getParameterTypes(objArr)).newInstance(getParameters(objArr));
    }

    private static void wrapToRuntime(Throwable th) {
        if (!com.kwad.library.a.a.pe.booleanValue()) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        } else {
            if (!(th instanceof RuntimeException)) {
                throw new RuntimeException(th);
            }
            throw ((RuntimeException) th);
        }
    }

    public static void a(Field field, Object obj, Object obj2) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static <T> T newInstanceOrThrow(String str, Object... objArr) {
        return (T) newInstanceOrThrow(Class.forName(str), getParameters(objArr));
    }

    public static Object a(Field field, Object obj) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            return field.get(obj);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    public static <T> T f(Object obj, String str, Object... objArr) {
        return (T) e(obj.getClass(), str, getParameterTypes(objArr)).invoke(obj, getParameters(objArr));
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        try {
            return (T) callStaticMethodOrThrow(Class.forName(str), str2, objArr);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    public static Class<?> a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    public static <T> T a(Class<?> cls, Object... objArr) {
        try {
            return (T) newInstanceOrThrow(cls, objArr);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    @Nullable
    public static Method a(@NonNull String str, @NonNull String str2, Class[] clsArr) {
        Method method = null;
        if (!UQ()) {
            return null;
        }
        try {
            Method method2 = (Method) sGetDeclaredMethod.invoke((Class) sForNameMethod.invoke(null, str), str2, clsArr);
            try {
                method2.setAccessible(true);
                return method2;
            } catch (Throwable th) {
                th = th;
                method = method2;
                wrapToRuntime(th);
                th.printStackTrace();
                return method;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Object a(@NonNull Object obj, @NonNull String str, @NonNull String str2) {
        try {
            Method methodA = a(str, str2, (Class[]) null);
            if (methodA != null) {
                return methodA.invoke(obj, null);
            }
            return null;
        } catch (Throwable th) {
            wrapToRuntime(th);
            th.printStackTrace();
            return null;
        }
    }

    public static Object a(@NonNull String str, @NonNull String str2, Class[] clsArr, Object... objArr) {
        try {
            Method methodA = a(str, str2, clsArr);
            if (methodA != null) {
                return methodA.invoke(null, objArr);
            }
            return null;
        } catch (Throwable th) {
            wrapToRuntime(th);
            th.printStackTrace();
            return null;
        }
    }
}
