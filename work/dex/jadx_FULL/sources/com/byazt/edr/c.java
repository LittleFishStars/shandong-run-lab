package com.byazt.edr;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1066, 20})
public class c {
    public static Map<String, Field> c = new HashMap();
    public static Map<String, Method> tt = new HashMap();
    public static Map<String, Constructor> ve = new HashMap();
    public static Map<String, Class> uj = new HashMap();

    static {
        try {
            FieldUtils.writeField(tt.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e);
        }
    }

    public static Field c(Class<?> cls, String str) {
        Field field;
        String strTt = tt(cls, str);
        synchronized (c) {
            field = c.get(strTt);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field fieldC = tt.c(cls, str);
            if (fieldC != null) {
                synchronized (c) {
                    c.put(strTt, fieldC);
                }
            }
            return fieldC;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    private static String tt(Class<?> cls, String str) {
        return cls.getName() + "#" + str;
    }

    private static String tt(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append("#");
        sb.append(str);
        if (clsArr == null || clsArr.length <= 0) {
            sb.append(Void.class.getName());
        } else {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.getName());
                sb.append("#");
            }
        }
        return sb.toString();
    }

    public static Method c(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String strTt = tt(cls, str, clsArr);
        synchronized (tt) {
            method = tt.get(strTt);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method methodC = tt.c(cls, str, clsArr);
            if (methodC != null) {
                synchronized (tt) {
                    tt.put(strTt, methodC);
                }
            }
            return methodC;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static Constructor c(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String strTt = tt(cls, "clinit", clsArr);
        synchronized (ve) {
            constructor = ve.get(strTt);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor constructorC = tt.c(cls, clsArr);
            if (constructorC != null) {
                synchronized (ve) {
                    ve.put(strTt, constructorC);
                }
            }
            return constructorC;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }
}
