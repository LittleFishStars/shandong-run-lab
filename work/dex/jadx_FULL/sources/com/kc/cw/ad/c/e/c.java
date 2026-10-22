package com.kc.cw.ad.c.e;

import android.content.Context;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f38740a;

    public static String a(Context context) {
        d dVarA = d.a();
        return dVarA.a(context.getApplicationContext(), dVarA.b);
    }

    public static final boolean a() {
        Context context = null;
        try {
            if (f38740a == null) {
                Method method = Class.forName(ProcessUtils.ACTIVITY_THREAD).getMethod("currentApplication", new Class[0]);
                f38740a = method;
                method.setAccessible(true);
            }
            context = (Context) f38740a.invoke(null, new Object[0]);
        } catch (Exception unused) {
        }
        if (context == null) {
            return false;
        }
        return d.a().a(context, false);
    }
}
