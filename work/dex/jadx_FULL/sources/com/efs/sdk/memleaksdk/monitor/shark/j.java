package com.efs.sdk.memleaksdk.monitor.shark;

import android.os.Build;
import android.os.Debug;
import com.efs.sdk.memleaksdk.monitor.UMonitor;
import com.efs.sdk.memleaksdk.monitor.UMonitorJNI;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f29875a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final j f29876a = new j(0);
    }

    public /* synthetic */ j(byte b) {
        this();
    }

    private void a() {
        if (!this.f29875a && UMonitorJNI.f29635a) {
            this.f29875a = true;
            UMonitorJNI.init();
        }
    }

    private j() {
    }

    public synchronized boolean a(String str) {
        g.b("UMonitor.Dump", "dump " + str);
        if (!UMonitor.isNotSupport()) {
            a();
            boolean zResumeVM = false;
            if (!this.f29875a) {
                g.d("UMonitor.Dump", "failed, so not load.");
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                g.b("UMonitor.Dump", "before suspend.");
                int iSuspendVM = UMonitorJNI.suspendVM();
                if (iSuspendVM == 0) {
                    Debug.dumpHprofData(str);
                    UMonitorJNI.exit();
                } else if (iSuspendVM > 0) {
                    zResumeVM = UMonitorJNI.resumeVM(iSuspendVM);
                    g.b("UMonitor.Dump", "dump hprof result: " + zResumeVM + ", from pid:" + iSuspendVM + " cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                }
            } catch (Throwable th) {
                g.b("UMonitor.Dump", "dump hprof failed.", th);
            }
            return zResumeVM;
        }
        throw new UnsupportedOperationException("not supported! android sdk version: " + Build.VERSION.SDK_INT);
    }
}
