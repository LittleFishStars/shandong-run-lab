package com.alibaba.alibclinkpartner.smartlink.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Class<?>> f23581a;
    private static final Map<String, Class<?>> b;
    private static final Map<String, Method> c;
    private static final Map<String, Field> d;

    static {
        HashMap map = new HashMap();
        f23581a = map;
        b = new HashMap();
        c = new HashMap();
        d = new HashMap();
        map.put("short", Short.TYPE);
        map.put("int", Integer.TYPE);
        map.put("long", Long.TYPE);
        map.put("double", Double.TYPE);
        map.put(TypedValues.Custom.S_FLOAT, Float.TYPE);
        map.put("char", Character.TYPE);
    }

    public static <T> T a(Class<T> cls, Class<?>[] clsArr, Object[] objArr) {
        if (clsArr != null) {
            try {
                if (clsArr.length != 0) {
                    return cls.getConstructor(clsArr).newInstance(objArr);
                }
            } catch (Exception e) {
                ALSLLogUtil.e("ALSLReflectionUtils", "newInstance", "reflection error , errmsg =" + e.toString());
                return null;
            }
        }
        return cls.newInstance();
    }

    public static Object a(String str, String str2, String[] strArr, Object obj, Object[] objArr) {
        try {
            Map<String, Class<?>> map = b;
            Class<?> cls = map.get(str);
            if (cls == null) {
                cls = Class.forName(str);
                map.put(str, cls);
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (strArr != null) {
                for (String str3 : strArr) {
                    stringBuffer.append(str3);
                }
            }
            String str4 = str + str2 + stringBuffer.toString();
            Map<String, Method> map2 = c;
            Method method = map2.get(str4);
            if (method != null) {
                return method.invoke(obj, objArr);
            }
            Method method2 = (strArr == null || strArr.length == 0) ? cls.getMethod(str2, new Class[0]) : cls.getMethod(str2, a(strArr));
            if (method2 == null) {
                return null;
            }
            map2.put(str4, method2);
            return method2.invoke(obj, objArr);
        } catch (Exception e) {
            ALSLLogUtil.e("ALSLReflectionUtils", BridgeDSL.INVOKE, "reflection error , errmsg =" + e.toString());
            return null;
        }
    }

    public static Object a(String str, String[] strArr, Object[] objArr) {
        try {
            return a(Class.forName(str), a(strArr), objArr);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            ALSLLogUtil.e("ALSLReflectionUtils", "newInstance", "reflection error , errmsg =" + e2.toString());
            return null;
        }
    }

    private static Class<?>[] a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        Class<?>[] clsArr = new Class[strArr.length];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (str.length() < 7) {
                clsArr[i] = f23581a.get(str);
            }
            if (clsArr[i] == null) {
                if (TypedValues.Custom.S_BOOLEAN.equals(str)) {
                    clsArr[i] = Boolean.TYPE;
                } else {
                    clsArr[i] = Class.forName(str);
                }
            }
        }
        return clsArr;
    }
}
