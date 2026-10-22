package com.bytedance.sdk.openadsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.byazt.bog.a;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@com.byazt.zqa.c(c = {0, 80, 81, 82, 1297})
public class TTAppContextHolder {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context c;

    @com.byazt.zqa.c(c = {0, 80, 81, 82, 1446})
    public static class c {

        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application c;

        static {
            try {
                Object objTt = tt();
                c = (Application) objTt.getClass().getMethod("getApplication", new Class[0]).invoke(objTt, new Object[0]);
                a.uj("MyApplication", "application get success");
            } catch (Throwable th) {
                a.n("MyApplication", "application get failed", th);
            }
        }

        public static Application c() {
            return c;
        }

        private static Object tt() {
            try {
                Method method = Class.forName(ProcessUtils.ACTIVITY_THREAD).getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                a.n("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static Context getContext() {
        if (c == null) {
            setContext(null);
        }
        return c;
    }

    public static synchronized void setContext(Context context) {
        if (c == null) {
            if (context != null) {
                c = context.getApplicationContext();
            } else if (c.c() != null) {
                try {
                    Application applicationC = c.c();
                    c = applicationC;
                    if (applicationC != null) {
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
