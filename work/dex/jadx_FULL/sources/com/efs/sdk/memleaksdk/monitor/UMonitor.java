package com.efs.sdk.memleaksdk.monitor;

import android.app.Application;
import android.os.Build;
import com.efs.sdk.memleaksdk.monitor.shark.f;
import com.efs.sdk.memleaksdk.monitor.shark.y;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class UMonitor {
    public static final String TAG = "UMonitor";
    private static Application sApp;

    public static Application getContext() {
        Application application = sApp;
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("UMonitor not init");
    }

    public static void init(Application application) {
        if (application != null) {
            sApp = application;
            f.a().a(application);
        }
    }

    public static void initJavaMonitor(UMonitorConfigJava uMonitorConfigJava) {
        y.b.a(uMonitorConfigJava);
    }

    public static boolean isNotSupport() {
        return Build.VERSION.SDK_INT > 34;
    }

    public static void startJavaMonitor(long j) {
        y.b.a(j);
    }

    public static void stopJavaMonitor() {
        y.b.c();
    }
}
