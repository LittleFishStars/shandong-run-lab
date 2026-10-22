package com.kwad.sdk.crash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.crash.handler.AnrHandler;
import com.kwad.sdk.crash.handler.NativeCrashHandler;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    private static volatile boolean bdw = false;
    private static volatile boolean bdx = false;
    private static volatile boolean bdy = false;
    private static Handler aqd = new Handler(Looper.getMainLooper());
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);
    private static final String[] bdz = {"c++_shared", "plt-base", "plt-unwind", "exception-handler"};
    private static boolean bdA = false;
    private static boolean bdB = false;

    public static boolean PO() {
        if (ISLOADED.get()) {
            return true;
        }
        try {
            for (String str : bdz) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "loadExceptionLibSo load " + str);
                System.loadLibrary(str);
            }
            ISLOADED.set(true);
            return true;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "loadExceptionLibSo fail\n" + Log.getStackTraceString(th));
            ISLOADED.set(false);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void PP() {
        com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "ExceptionSoLoadHelper.init onLoad：enableAnrReport:" + bdA + " *enableNativeReport" + bdB);
        if (bdA) {
            PQ();
        }
        if (bdB) {
            b(false, "/sdcard/");
        }
    }

    private static void PQ() {
        AnrHandler.getInstance().init(com.kwad.sdk.crash.a.a.Qo(), new f() { // from class: com.kwad.sdk.crash.b.5
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                e.Qd().b(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.6
            @Override // com.kwad.sdk.crash.report.e
            public final File PZ() {
                return new File(com.kwad.sdk.crash.a.a.Qm(), "anr_log/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                if (exceptionMessage == null || TextUtils.isEmpty(exceptionMessage.mCrashDetail) || !com.kwad.sdk.crash.b.a.gr(exceptionMessage.mCrashDetail)) {
                    return;
                }
                com.kwad.sdk.core.d.c.e("AnrAndNativeExceptionCollector", "ANR true upload:" + exceptionMessage.mCrashDetail);
                a(exceptionMessage, 3, countDownLatch);
            }
        });
    }

    private static synchronized void PR() {
        if (!bdw) {
            bdw = true;
            i.schedule(new Runnable() { // from class: com.kwad.sdk.crash.b.8
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        b.PT();
                    } catch (Throwable unused) {
                    }
                }
            }, d.bee, TimeUnit.SECONDS);
        }
    }

    public static synchronized void PS() {
        if (!bdx) {
            bdx = true;
            i.schedule(new Runnable() { // from class: com.kwad.sdk.crash.b.9
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        b.PU();
                    } catch (Throwable unused) {
                    }
                }
            }, d.bee, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void PT() {
        PV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void PU() {
        if (bdA) {
            PW();
        }
        if (bdB) {
            PX();
        }
    }

    private static void PV() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportJavaException");
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(com.kwad.sdk.crash.handler.c.Qs().getUploader());
        fVar.D(com.kwad.sdk.crash.a.a.Qn());
    }

    private static void PW() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportAnrException");
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(AnrHandler.getInstance().getUploader());
        bVar.D(com.kwad.sdk.crash.a.a.Qo());
    }

    private static void PX() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportNativeException");
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(NativeCrashHandler.getInstance().getUploader());
        gVar.D(com.kwad.sdk.crash.a.a.Qp());
    }

    public static void a(@NonNull c cVar) {
        if (cVar.context == null || bdy) {
            return;
        }
        bdy = true;
        try {
            com.kwad.sdk.crash.utils.e.init(cVar.context);
            com.kwad.sdk.crash.a.a.init(cVar.context, cVar.bdP);
            e.Qd().a(cVar);
            cv(cVar.context);
            PR();
        } catch (Throwable unused) {
        }
    }

    public static void b(c cVar) {
        bdA = cVar.bdA;
        bdB = cVar.bdB;
        if (cu(cVar.context)) {
            return;
        }
        if (bdA || bdB) {
            g.a(cVar, new g.a() { // from class: com.kwad.sdk.crash.b.1
                @Override // com.kwad.sdk.crash.g.a
                public final void PY() {
                    GlobalThreadPools.Oi().execute(new Runnable() { // from class: com.kwad.sdk.crash.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                b.PP();
                                b.PS();
                            } catch (Throwable th) {
                                ServiceProvider.reportSdkCaughtException(th);
                            }
                        }
                    });
                }

                @Override // com.kwad.sdk.crash.g.a
                public final void rc() {
                    com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "ExceptionSoLoadHelper.init fail");
                }
            });
        }
    }

    private static boolean cu(Context context) {
        return context == null || ai.dq(context) >= 3;
    }

    private static void cv(Context context) {
        com.kwad.sdk.crash.handler.c.Qs().init(com.kwad.sdk.crash.a.a.Qn(), new f() { // from class: com.kwad.sdk.crash.b.3
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                e.Qd().b(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.4
            @Override // com.kwad.sdk.crash.report.e
            public final File PZ() {
                return new File(com.kwad.sdk.crash.a.a.Qm(), "java_crash/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                a(exceptionMessage, 1, countDownLatch);
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.handler.d(context));
    }

    public static void u(@NonNull final Throwable th) {
        i.execute(new Runnable() { // from class: com.kwad.sdk.crash.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.kwad.sdk.crash.b.a.v(th)) {
                        com.kwad.sdk.crash.handler.a.handleCaughtException(th);
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                }
            }
        });
    }

    private static void b(boolean z, String str) {
        if (com.kwad.sdk.crash.a.a.A(com.kwad.sdk.crash.a.a.Qp())) {
            NativeCrashHandler.getInstance().init(com.kwad.sdk.crash.a.a.Qp(), false, str, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.7
                @Override // com.kwad.sdk.crash.report.e
                public final File PZ() {
                    return new File(com.kwad.sdk.crash.a.a.Qm(), "native_crash_log/upload");
                }

                @Override // com.kwad.sdk.crash.report.e
                public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                    try {
                        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "Native upload");
                        if (exceptionMessage == null) {
                            com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "Native upload but msg is null");
                            return;
                        }
                        if (com.kwad.sdk.crash.b.a.gq(exceptionMessage.mThreadName) || com.kwad.sdk.crash.b.a.gr(exceptionMessage.mCrashDetail)) {
                            com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "true upload msg:" + exceptionMessage.mCrashDetail);
                            a(exceptionMessage, 4, countDownLatch);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
