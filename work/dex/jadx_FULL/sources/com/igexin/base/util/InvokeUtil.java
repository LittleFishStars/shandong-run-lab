package com.igexin.base.util;

import android.content.Context;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class InvokeUtil {
    private static Context appContext;

    public static Context findAppContext() {
        Context context = appContext;
        if (context != null) {
            return context;
        }
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Context context2 = (Context) cls.getMethod("getApplication", new Class[0]).invoke(cls.getDeclaredMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]).invoke(null, new Object[0]), new Object[0]);
            appContext = context2;
            return context2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
