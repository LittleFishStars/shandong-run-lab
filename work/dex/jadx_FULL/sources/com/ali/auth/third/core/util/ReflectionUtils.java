package com.ali.auth.third.core.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ali.auth.third.core.trace.SDKLogger;
import com.alibaba.android.arouter.utils.Consts;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ReflectionUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Class<?>> f23452a;
    private static final String b;

    static {
        HashMap map = new HashMap();
        f23452a = map;
        b = ReflectionUtils.class.getSimpleName();
        map.put("short", Short.TYPE);
        map.put("int", Integer.TYPE);
        map.put("long", Long.TYPE);
        map.put("double", Double.TYPE);
        map.put(TypedValues.Custom.S_FLOAT, Float.TYPE);
        map.put("char", Character.TYPE);
        map.put(TypedValues.Custom.S_BOOLEAN, Boolean.TYPE);
    }

    public static Object invoke(String str, String str2, String[] strArr, Object obj, Object[] objArr) {
        try {
            Class<?> cls = Class.forName(str);
            return ((strArr == null || strArr.length == 0) ? cls.getMethod(str2, new Class[0]) : cls.getMethod(str2, toClasses(strArr))).invoke(obj, objArr);
        } catch (Exception e) {
            SDKLogger.e(b, "Fail to invoke the " + str + Consts.DOT + str2 + ", the error is " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Class<?> loadClassQuietly(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T> T newInstance(Class<T> cls, Class<?>[] clsArr, Object[] objArr) {
        if (clsArr != null) {
            try {
                if (clsArr.length != 0) {
                    return cls.getConstructor(clsArr).newInstance(objArr);
                }
            } catch (Exception e) {
                SDKLogger.e(b, "Fail to create the instance of type " + cls.getName() + ", the error is " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return cls.newInstance();
    }

    public static Object newInstance(String str, String[] strArr, Object[] objArr) {
        try {
            return newInstance(Class.forName(str), toClasses(strArr), objArr);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            SDKLogger.e(b, "Fail to create the instance of type " + str + ", the error is " + e2.getMessage());
            throw new RuntimeException(e2);
        }
    }

    public static Class<?>[] toClasses(String[] strArr) throws Exception {
        if (strArr == null) {
            return null;
        }
        Class<?>[] clsArr = new Class[strArr.length];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (str.length() < 8) {
                clsArr[i] = f23452a.get(str);
            }
            if (clsArr[i] == null) {
                clsArr[i] = Class.forName(str);
            }
        }
        return clsArr;
    }
}
