package com.alibaba.ariver.kernel.common.utils;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.api.extension.Extension;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ReflectUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Method> f24286a = new ConcurrentHashMap();

    private static boolean a(Class<?>[] clsArr, String[] strArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (!TextUtils.equals(clsArr[i].getName(), strArr != null ? strArr[i] : null)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Set<Class<? extends Extension>> collectExtensionPoint(Class<? extends Extension> cls, Set<Class<? extends Extension>> set) {
        Set<Class<? extends Extension>> linkedHashSet = set;
        if (set == null) {
            linkedHashSet = new LinkedHashSet();
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (Extension.class.isAssignableFrom(cls2)) {
                linkedHashSet.add(cls2);
            }
        }
        return Extension.class.isAssignableFrom(cls.getSuperclass()) ? collectExtensionPoint(cls.getSuperclass(), linkedHashSet) : linkedHashSet;
    }

    public static Method findMethod(Class cls, String str, String[] strArr) {
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str)) {
                if (method.getParameterTypes().length == (strArr != null ? strArr.length : 0) && a(method.getParameterTypes(), strArr)) {
                    return method;
                }
            }
        }
        return null;
    }

    public static Object getDefaultValue(Class<?> cls) {
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return Boolean.FALSE;
        }
        if (cls == Void.TYPE) {
            return null;
        }
        return (cls.isPrimitive() || Number.class.isAssignableFrom(cls)) ? 0 : null;
    }

    public static Object getField(Object obj, String str, Object obj2) throws NoSuchFieldException {
        Field declaredField = (obj instanceof Class ? (Class) obj : Class.forName(String.valueOf(obj))).getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj2);
    }

    public static Method getMethod(Class<?> cls, String str, Class... clsArr) {
        String strConcat = cls.getName().concat(Consts.DOT).concat(str);
        if (clsArr != null && clsArr.length > 0) {
            String strConcat2 = strConcat.concat("(");
            for (Class cls2 : clsArr) {
                strConcat2 = strConcat2.concat(cls2.getName()).concat(",");
            }
            strConcat = strConcat2.substring(0, strConcat2.length() - 1).concat(")");
        }
        Method method = null;
        try {
            Map<String, Method> map = f24286a;
            if (map.containsKey(strConcat)) {
                method = map.get(strConcat);
            }
        } catch (Throwable unused) {
        }
        if (method != null) {
            return method;
        }
        Method declaredMethod = clsArr == null ? cls.getDeclaredMethod(str, new Class[0]) : cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        f24286a.put(strConcat, declaredMethod);
        return declaredMethod;
    }

    public static Object invokeMethod(Object obj, String str) {
        return invokeMethod(obj.getClass(), obj, str, (Class[]) null, (Object[]) null);
    }

    public static Object invokeStaticMethod(Class cls, String str, Class[] clsArr, Object[] objArr) {
        return invokeMethod(cls, (Object) null, str, clsArr, objArr);
    }

    public static Object invokeStaticMethod(String str, String str2, Class[] clsArr, Object[] objArr) {
        return invokeMethod(Class.forName(str), (Object) null, str2, clsArr, objArr);
    }

    public static Object invokeMethod(String str, String str2) {
        return invokeMethod(Class.forName(str), (Object) null, str2, (Class[]) null, (Object[]) null);
    }

    public static Object invokeMethod(Class cls, String str) {
        return invokeMethod(cls, (Object) null, str, (Class[]) null, (Object[]) null);
    }

    public static Object invokeMethod(Class cls, String str, Class[] clsArr, Object[] objArr) {
        return invokeMethod(cls, (Object) null, str, clsArr, objArr);
    }

    public static Object invokeMethod(String str, Object obj, String str2, Class[] clsArr, Object[] objArr) {
        return invokeMethod(Class.forName(str), obj, str2, clsArr, objArr);
    }

    public static Object invokeMethod(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) {
        Method method = getMethod(cls, str, clsArr);
        if (objArr == null) {
            return method.invoke(obj, new Object[0]);
        }
        return method.invoke(obj, objArr);
    }
}
