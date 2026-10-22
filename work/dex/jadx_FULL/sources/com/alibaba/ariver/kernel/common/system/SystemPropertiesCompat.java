package com.alibaba.ariver.kernel.common.system;

import com.acse.ottn.p3;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SystemPropertiesCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24272a = "SystemPropertiesWrapper";
    private static Method b;
    private static Method c;
    private static Method d;

    static {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            b = ReflectUtils.getMethod(cls, p3.f, String.class);
            c = ReflectUtils.getMethod(cls, p3.f, String.class, String.class);
            d = ReflectUtils.getMethod(cls, "getBoolean", String.class, Boolean.TYPE);
        } catch (Throwable th) {
            RVLogger.e(f24272a, th);
        }
    }

    public static String get(String str) {
        Method method = b;
        if (method != null) {
            try {
                return (String) method.invoke(null, str);
            } catch (Throwable th) {
                RVLogger.e(f24272a, "fail get " + str, th);
            }
        }
        return null;
    }

    public static boolean getBoolean(String str, boolean z) {
        Method method = d;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(null, str, Boolean.valueOf(z))).booleanValue();
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    public static String get(String str, String str2) {
        Method method = c;
        if (method != null) {
            try {
                return (String) method.invoke(null, str, str2);
            } catch (Throwable th) {
                RVLogger.e(f24272a, "fail get " + str + ", return default: " + str2, th);
            }
        }
        return str2;
    }
}
