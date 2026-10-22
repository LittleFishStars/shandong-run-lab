package com.byazt.vm;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 499})
public final class yv implements nu {
    public static Object c;
    public static Class<?> tt;
    public static Method ve;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            tt = cls;
            c = cls.newInstance();
            ve = tt.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            com.byazt.yv.da.c("Api#static reflect exception! " + e.getMessage());
        }
    }

    public static boolean c() {
        return (tt == null || c == null || ve == null) ? false : true;
    }

    @Override // com.byazt.vm.nu
    public boolean tt(Context context) {
        return c();
    }

    @Override // com.byazt.vm.nu
    public nu.c ve(Context context) {
        try {
            nu.c cVar = new nu.c();
            cVar.tt = c(context, ve);
            return cVar;
        } catch (Exception e) {
            com.byazt.yv.da.c(e);
            return null;
        }
    }

    private static String c(Context context, Method method) {
        Object obj = c;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
