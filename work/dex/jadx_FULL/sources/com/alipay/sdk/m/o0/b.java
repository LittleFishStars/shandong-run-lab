package com.alipay.sdk.m.o0;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25481a = "IdentifierManager";
    public static Object b;
    public static Class<?> c;
    public static Method d;
    public static Method e;
    public static Method f;
    public static Method g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            c = cls;
            b = cls.newInstance();
            d = c.getMethod("getUDID", Context.class);
            e = c.getMethod("getOAID", Context.class);
            f = c.getMethod("getVAID", Context.class);
            g = c.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e(f25481a, "reflect exception!", e2);
        }
    }

    public static boolean a() {
        return (c == null || b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, e);
    }

    public static String c(Context context) {
        return a(context, d);
    }

    public static String d(Context context) {
        return a(context, f);
    }

    public static String a(Context context) {
        return a(context, g);
    }

    public static String a(Context context, Method method) {
        Object obj = b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception e2) {
            Log.e(f25481a, "invoke exception!", e2);
            return null;
        }
    }
}
