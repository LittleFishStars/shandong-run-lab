package com.zj.adlib;

import android.app.Application;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class k13 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Application f42718a;

    static {
        Application application;
        Application application2 = null;
        try {
            try {
                application = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, new Object[0]);
                if (application == null) {
                    try {
                        throw new IllegalStateException("Static initialization of Applications must be on main thread.");
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        try {
                            application = (Application) Class.forName(ProcessUtils.ACTIVITY_THREAD).getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                            e.printStackTrace();
                        }
                        f42718a = application;
                    }
                }
            } catch (Throwable th) {
                th = th;
                application2 = application;
                f42718a = application2;
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            application = null;
        } catch (Throwable th2) {
            th = th2;
            f42718a = application2;
            throw th;
        }
        f42718a = application;
    }

    public static Application a() {
        return f42718a;
    }
}
