package com.efs.sdk.memleaksdk.monitor;

import com.efs.sdk.memleaksdk.monitor.shark.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class UMonitorJNI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f29635a;

    static {
        boolean z;
        try {
            System.loadLibrary("umonitor");
            z = true;
        } catch (Throwable th) {
            g.b("UMonitor.JNI", "loadLibrary failed", th);
            z = false;
        }
        f29635a = z;
    }

    public static native void exit();

    public static native void init();

    public static native void initStrip();

    public static native void initStripPath(String str, String str2);

    public static native boolean resumeVM(int i);

    public static native int suspendVM();
}
