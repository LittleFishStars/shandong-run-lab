package com.baidu.mshield.b.b;

import android.content.Context;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.utility.c;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {
    public static synchronized String a(Context context) {
        Object objInvoke;
        Method declaredMethod;
        try {
            Method declaredMethod2 = F.class.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod2.setAccessible(true);
            objInvoke = declaredMethod2.invoke(null, new Object[0]);
            declaredMethod = F.class.getDeclaredMethod("gzd", Context.class);
            declaredMethod.setAccessible(true);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
        return (String) declaredMethod.invoke(objInvoke, context);
    }

    public static String b(Context context) {
        try {
            Method declaredMethod = c.class.getDeclaredMethod("loadExternalDeviceId", Context.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, context);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public static String c(Context context) {
        try {
            Method declaredMethod = c.class.getDeclaredMethod("loadSettingDeviceId", Context.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, context);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }
}
