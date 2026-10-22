package com.byazt.oep;

import com.bytedance.pangle.log.ZeusLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1674, 20})
public class c {
    public static Method c;
    public static Method tt;
    public static Method uj;
    public static Method ve;

    static {
        try {
            c = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            tt = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            ve = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            uj = Class.class.getDeclaredMethod("forName", String.class);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
        }
    }

    public static Field c(Class<?> cls, String str) {
        Throwable th;
        Field field;
        Method method = c;
        Field field2 = null;
        if (method != null) {
            try {
                field = (Field) method.invoke(cls, str);
                if (field != null) {
                    try {
                        field.setAccessible(true);
                    } catch (Throwable th2) {
                        th = th2;
                        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                field = null;
            }
            field2 = field;
        }
        return field2 != null ? field2 : com.byazt.edr.c.c(cls, str);
    }

    public static Method c(Class<?> cls, String str, Class<?>... clsArr) {
        Throwable th;
        Method method;
        Method method2 = tt;
        Method method3 = null;
        if (method2 != null) {
            try {
                method = (Method) method2.invoke(cls, str, clsArr);
                if (method != null) {
                    try {
                        method.setAccessible(true);
                    } catch (Throwable th2) {
                        th = th2;
                        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                method = null;
            }
            method3 = method;
        }
        return method3 != null ? method3 : com.byazt.edr.c.c(cls, str, clsArr);
    }

    public static Constructor c(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        Method method = ve;
        if (method != null) {
            try {
                constructor = (Constructor) method.invoke(cls, clsArr);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("DoubleReflector");
                Object[] objArr = new Object[2];
                objArr[0] = cls.getName();
                objArr[1] = Integer.valueOf(clsArr != null ? clsArr.length : 0);
                sb.append(String.format("getConstructor %s<init>%s failed !!!", objArr));
                ZeusLogger.w(ZeusLogger.TAG, sb.toString(), th);
                constructor = null;
            }
        } else {
            constructor = null;
        }
        return constructor != null ? constructor : com.byazt.edr.c.c(cls, clsArr);
    }
}
