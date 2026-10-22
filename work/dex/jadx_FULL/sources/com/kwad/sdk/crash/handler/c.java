package com.kwad.sdk.crash.handler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.zj.adlib.c25;
import com.zj.adlib.c49;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c extends b {

    public static class a {
        private static final c bev = new c(0);
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public static c Qs() {
        return a.bev;
    }

    public final void a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) throws Throwable {
        a(th, exceptionMessage, context, ((f) ServiceProvider.get(f.class)).Fu());
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final int getCrashType() {
        return 1;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, com.kwad.sdk.crash.f fVar, e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.e.Qd().isDebug()) {
            b.initBackupDir(new File("sdcard/kwad_ex/java_crash/dump"));
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(getUploader());
        for (File file : fileArr) {
            fVar.a(file, countDownLatch);
        }
    }

    private c() {
    }

    private void a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context, boolean z) throws Throwable {
        boolean z2;
        int andIncrement = this.mIndex.getAndIncrement();
        File file = this.mDumpDir;
        File file2 = this.mLogcatFile;
        File file3 = this.mJavaTraceFile;
        File file4 = this.mMemoryInfoFile;
        e uploader = getUploader();
        try {
            exceptionMessage.mCrashDetail = th.toString();
            if (this.mLogDir.exists() || this.mLogDir.mkdirs()) {
                z2 = true;
            } else {
                exceptionMessage.mErrorMessage += "create " + Qs().mLogDir.getPath() + " failed!\n";
                z2 = false;
            }
            if (file == null || andIncrement != 0) {
                try {
                    file = new File(this.mLogDir, b.FILE_NAME_BASE + c49.f40900a + andIncrement + ".dump");
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        exceptionMessage.mErrorMessage += th;
                        try {
                            if (z2) {
                                if (uploader != null) {
                                    if (z) {
                                        reportException(new File[]{file}, new CountDownLatch(1));
                                    }
                                }
                            }
                            return;
                        } catch (Throwable th3) {
                            if (uploader != null) {
                                try {
                                    return;
                                } catch (Exception unused) {
                                    return;
                                }
                            }
                            return;
                        }
                    } finally {
                        try {
                            String string = exceptionMessage.toJson().toString();
                            if (z2) {
                                g.a(file, string);
                                g.H(file3);
                                g.F(file2);
                                if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                                    backupLogFiles(this.mLogDir);
                                }
                                if (uploader != null) {
                                    exceptionMessage.toString();
                                    if (z) {
                                        CountDownLatch countDownLatch = new CountDownLatch(1);
                                        reportException(new File[]{file}, countDownLatch);
                                        try {
                                            countDownLatch.await(5L, TimeUnit.SECONDS);
                                        } catch (InterruptedException unused2) {
                                        }
                                    } else {
                                        uploadRemainingExceptions();
                                    }
                                }
                                g.I(file4);
                            } else if (uploader != null) {
                                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                                CountDownLatch countDownLatch2 = z ? new CountDownLatch(1) : null;
                                uploader.a(exceptionMessage, countDownLatch2);
                                exceptionMessage.toString();
                                if (countDownLatch2 != null) {
                                    try {
                                        countDownLatch2.await(5L, TimeUnit.SECONDS);
                                    } catch (InterruptedException unused3) {
                                    }
                                }
                            }
                            com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                        } catch (Throwable th4) {
                            if (uploader != null) {
                                try {
                                    g.x(th4);
                                } catch (Exception unused4) {
                                }
                            }
                        }
                    }
                }
            }
            if (file2 == null || andIncrement != 0) {
                file2 = new File(this.mLogDir, b.FILE_NAME_BASE + c49.f40900a + andIncrement + c25.n);
            }
            if (file3 == null || andIncrement != 0) {
                file3 = new File(this.mLogDir, b.FILE_NAME_BASE + c49.f40900a + andIncrement + ".jtrace");
            }
            if (file4 == null || andIncrement != 0) {
                file4 = new File(this.mLogDir, b.FILE_NAME_BASE + c49.f40900a + andIncrement + ".minfo");
            }
            g.b(th, exceptionMessage, context);
            g.a(exceptionMessage, getCrashType());
            com.kwad.sdk.crash.f fVar = this.mExceptionListener;
            if (fVar != null) {
                fVar.a(getCrashType(), exceptionMessage);
            }
            try {
                String string2 = exceptionMessage.toJson().toString();
                if (z2) {
                    g.a(file, string2);
                    g.H(file3);
                    g.F(file2);
                    if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                        backupLogFiles(this.mLogDir);
                    }
                    if (uploader != null) {
                        exceptionMessage.toString();
                        if (z) {
                            CountDownLatch countDownLatch3 = new CountDownLatch(1);
                            reportException(new File[]{file}, countDownLatch3);
                            try {
                                countDownLatch3.await(5L, TimeUnit.SECONDS);
                            } catch (InterruptedException unused5) {
                            }
                        } else {
                            uploadRemainingExceptions();
                        }
                    }
                    g.I(file4);
                } else if (uploader != null) {
                    com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                    CountDownLatch countDownLatch4 = z ? new CountDownLatch(1) : null;
                    uploader.a(exceptionMessage, countDownLatch4);
                    exceptionMessage.toString();
                    if (countDownLatch4 != null) {
                        try {
                            countDownLatch4.await(5L, TimeUnit.SECONDS);
                        } catch (InterruptedException unused6) {
                        }
                    }
                }
                com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
            } catch (Throwable th5) {
                if (uploader != null) {
                    try {
                        g.x(th5);
                    } catch (Exception unused7) {
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            z2 = true;
        }
    }
}
