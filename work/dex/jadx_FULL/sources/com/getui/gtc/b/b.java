package com.getui.gtc.b;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {
    public static String a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            AccessibleObject.setAccessible(declaredConstructors, true);
            Constructor<?> constructor = declaredConstructors[0];
            Method declaredMethod = cls.getDeclaredMethod("getSdkVersion", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(constructor.newInstance(new Object[0]), new Object[0]);
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.d(" getSdkVersion error : " + th.toString());
            return null;
        }
    }

    public static int b(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            AccessibleObject.setAccessible(declaredConstructors, true);
            Constructor<?> constructor = declaredConstructors[0];
            Method declaredMethod = cls.getDeclaredMethod("getSdkId", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(constructor.newInstance(new Object[0]), new Object[0])).intValue();
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.d(" getSDKId error : " + th.toString());
            return 0;
        }
    }

    public static String c(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            AccessibleObject.setAccessible(declaredConstructors, true);
            Constructor<?> constructor = declaredConstructors[0];
            Method declaredMethod = cls.getDeclaredMethod("getSdkAppId", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(constructor.newInstance(new Object[0]), new Object[0]);
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.d(" getAppId error : " + th.toString());
            return null;
        }
    }
}
