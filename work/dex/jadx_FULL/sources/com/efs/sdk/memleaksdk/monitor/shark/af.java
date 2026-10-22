package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class af extends ae {
    @Override // com.efs.sdk.memleaksdk.monitor.shark.ae
    public boolean b() {
        ah.b bVar = ah.g;
        float deviceMemoryThreshold = a().getDeviceMemoryThreshold();
        float f = bVar.d;
        if (f < deviceMemoryThreshold) {
            g.c("UMonitor.PSS", String.format(Locale.US, "device memory threshold: %f, rate: %f", Float.valueOf(deviceMemoryThreshold), Float.valueOf(bVar.d)));
        } else if (f < 0.1f) {
            g.c("UMonitor.PSS", "mem info rate < 10%");
        } else if (f < 0.15f) {
            g.b("UMonitor.PSS", "mem info rate < 15%");
        } else if (f < 0.2f) {
            g.b("UMonitor.PSS", "mem info rate < 20%");
        } else if (f < 0.3f) {
            g.b("UMonitor.PSS", "mem info rate < 30%");
        }
        return false;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.ae
    public String d() {
        return "reason_physical_memory";
    }
}
