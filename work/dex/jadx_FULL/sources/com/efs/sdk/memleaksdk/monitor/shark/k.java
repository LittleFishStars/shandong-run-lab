package com.efs.sdk.memleaksdk.monitor.shark;

import android.os.Build;
import com.efs.sdk.memleaksdk.monitor.UMonitor;
import com.efs.sdk.memleaksdk.monitor.UMonitorJNI;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f29877a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final k f29878a = new k(0);
    }

    public /* synthetic */ k(byte b) {
        this();
    }

    private void a() {
        if (!this.f29877a && UMonitorJNI.f29635a) {
            this.f29877a = true;
            UMonitorJNI.initStrip();
        }
    }

    private k() {
    }

    public synchronized boolean a(String str, String str2) {
        g.b("UMonitor.Strip", "path: " + str + "\nstrip: " + str2);
        if (!UMonitor.isNotSupport()) {
            a();
            boolean zA = false;
            if (!this.f29877a) {
                g.d("UMonitor.Strip", "dump failed caused by so not loaded!");
                return false;
            }
            try {
                UMonitorJNI.initStripPath(str, str2);
                zA = j.a.f29876a.a(str);
                g.b("UMonitor.Strip", "dump result " + zA);
            } catch (Exception e) {
                g.b("UMonitor.Strip", "dump failed caused by ", e);
            }
            return zA;
        }
        throw new UnsupportedOperationException("not supported! android sdk version: " + Build.VERSION.SDK_INT);
    }
}
