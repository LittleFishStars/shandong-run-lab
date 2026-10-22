package com.kc.cw.ad.c.f;

import android.content.Context;
import com.kc.cw.ad.d.b.f;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f38745a;
    private static Class<?> b;
    private static Method c;
    private static Method d;
    private static Method e;
    private static Method f;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            f38745a = cls.newInstance();
            c = b.getMethod("getUDID", Context.class);
            d = b.getMethod("getOAID", Context.class);
            e = b.getMethod("getVAID", Context.class);
            f = b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            f.a(com.alipay.sdk.m.o0.b.f25481a, "reflect exception!", e2);
        }
    }

    public static String a(Context context) {
        return a(context, d);
    }

    private static String a(Context context, Method method) {
        Object obj = f38745a;
        if (obj != null && method != null) {
            try {
                Object objInvoke = method.invoke(obj, context);
                if (objInvoke != null) {
                    return (String) objInvoke;
                }
                return null;
            } catch (Exception e2) {
                f.a(com.alipay.sdk.m.o0.b.f25481a, "invoke exception!", e2);
            }
        }
        return null;
    }

    public static boolean a() {
        return (b == null || f38745a == null) ? false : true;
    }
}
