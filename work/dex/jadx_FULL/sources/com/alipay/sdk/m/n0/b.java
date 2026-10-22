package com.alipay.sdk.m.n0;

import android.content.Context;
import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25471a = "OpenIdHelper";
    public static Method b;

    public static String a(Context context) {
        f fVarA = f.a();
        return fVarA.a(context.getApplicationContext(), fVarA.c);
    }

    public static void a(boolean z) {
        f.a();
        f.a(z);
    }

    public static final boolean a() {
        Context context = null;
        try {
            if (b == null) {
                Method method = Class.forName(ProcessUtils.ACTIVITY_THREAD).getMethod("currentApplication", new Class[0]);
                b = method;
                method.setAccessible(true);
            }
            context = (Context) b.invoke(null, new Object[0]);
        } catch (Exception e) {
            Log.e(f25471a, "ActivityThread:currentApplication --> " + e.toString());
        }
        if (context == null) {
            return false;
        }
        return f.a().a(context, false);
    }

    public static String b(Context context) {
        f fVarA = f.a();
        return fVarA.a(context.getApplicationContext(), fVarA.b);
    }

    public static String c(Context context) {
        f fVarA = f.a();
        return fVarA.a(context.getApplicationContext(), fVarA.f25474a);
    }

    public static String d(Context context) {
        f fVarA = f.a();
        return fVarA.a(context.getApplicationContext(), fVarA.d);
    }
}
