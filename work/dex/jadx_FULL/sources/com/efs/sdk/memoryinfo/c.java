package com.efs.sdk.memoryinfo;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import com.byazt.hv.TTDownloadField;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class c {
    final String activity;
    final String bg;
    final long n;
    final long o;
    final long p;
    final long q;
    final float r;
    final long s;
    final long t;

    public c(Context context) {
        Debug.MemoryInfo[] processMemoryInfo;
        Debug.MemoryInfo memoryInfo = null;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null && (processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})) != null && processMemoryInfo.length > 0) {
                memoryInfo = processMemoryInfo[0];
            }
        } catch (Throwable unused) {
        }
        if (memoryInfo == null) {
            memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
        }
        this.bg = UMMemoryMonitor.get().isForeground() ? "fg" : "bg";
        this.n = ((long) memoryInfo.getTotalPss()) * 1024;
        this.o = ((long) memoryInfo.dalvikPss) * 1024;
        this.p = ((long) memoryInfo.nativePss) * 1024;
        this.s = f.a(memoryInfo) * 1024;
        long jFreeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.q = jFreeMemory;
        long jMaxMemory = Runtime.getRuntime().maxMemory();
        if (jMaxMemory != 0) {
            this.r = (jFreeMemory * 1.0f) / jMaxMemory;
        } else {
            this.r = 1.0f;
        }
        this.t = f.a() * 1024;
        this.activity = UMMemoryMonitor.get().getCurrentActivity();
    }
}
