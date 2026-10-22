package com.alibaba.ariver.kernel.common.utils;

import android.os.Trace;
import android.util.Log;
import com.alibaba.ariver.kernel.common.RVProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVTraceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24285a = "RVTraceUtils";
    private static boolean b = RVKernelUtils.isDebug();
    private static final long c = 4096;
    public static boolean isOpenSystemTrace = false;
    public static boolean isPerfTestMode = false;

    private static void a(String str, String str2) {
        if (b || !isPerfTestMode) {
            RVLogger.debug(str, str2);
        } else {
            b(str, str2);
        }
    }

    public static void asyncTraceBegin(RVTracePhase rVTracePhase) {
        try {
            RVPhaseRecorder rVPhaseRecorder = (RVPhaseRecorder) RVProxy.get(RVPhaseRecorder.class);
            if (rVPhaseRecorder != null) {
                rVPhaseRecorder.startPhase(rVTracePhase);
            }
        } catch (Throwable th) {
            RVLogger.e("phase recorder start exception", th);
        }
        if (a()) {
            try {
                asyncTraceBegin(rVTracePhase.phaseName, rVTracePhase.cookie);
            } catch (Throwable th2) {
                a(f24285a, th2.toString());
            }
        }
    }

    public static void asyncTraceEnd(RVTracePhase rVTracePhase) {
        try {
            RVPhaseRecorder rVPhaseRecorder = (RVPhaseRecorder) RVProxy.get(RVPhaseRecorder.class);
            if (rVPhaseRecorder != null) {
                rVPhaseRecorder.stopPhase(rVTracePhase);
            }
        } catch (Throwable th) {
            RVLogger.e("phase recorder start exception", th);
        }
        if (a()) {
            try {
                asyncTraceEnd(rVTracePhase.phaseName, rVTracePhase.cookie);
            } catch (Throwable th2) {
                a(f24285a, th2.toString());
            }
        }
    }

    private static void b(String str, String str2) {
        try {
            String name = Thread.currentThread().getName();
            StringBuilder sb = new StringBuilder(91);
            sb.append(name);
            sb.append(']');
            sb.append(str2);
            ReflectUtils.invokeStaticMethod(Log.class, "d", new Class[]{String.class, String.class}, new Object[]{str, sb.toString()});
        } catch (Throwable unused) {
        }
    }

    public static void traceBeginSection(String str) {
        if (a()) {
            try {
                if (str.length() > 127) {
                    str = str.substring(0, 127);
                }
                Trace.beginSection(str);
                a(f24285a, "traceBeginSection: " + str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void traceEndSection(String str) {
        if (a()) {
            try {
                Trace.endSection();
                a(f24285a, "traceEndSection: " + str);
            } catch (Throwable unused) {
            }
        }
    }

    private static boolean a() {
        return b || (isPerfTestMode && isOpenSystemTrace);
    }

    public static void asyncTraceBegin(String str, int i) {
        if (a()) {
            try {
                ReflectUtils.invokeStaticMethod(Trace.class, "asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE}, new Object[]{4096L, str, Integer.valueOf(i)});
                a(f24285a, "asyncTraceBegin: " + str);
            } catch (Exception e) {
                a(f24285a, e.toString());
            }
        }
    }

    public static void asyncTraceEnd(String str, int i) {
        if (a()) {
            try {
                ReflectUtils.invokeStaticMethod(Trace.class, "asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE}, new Object[]{4096L, str, Integer.valueOf(i)});
            } catch (Exception e) {
                a(f24285a, e.toString());
            }
        }
    }
}
