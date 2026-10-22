package com.kwad.sdk.crash.handler;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.y;
import com.zj.adlib.c25;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class b {
    private static final int REAL_TIME_UPLOAD_THRESHOLD = 2;
    public static final String TAG = "ANR_Native_ExceptionHandler";
    public static File sBackupDir;
    protected File mDumpDir;
    protected f mExceptionListener;
    protected AtomicInteger mIndex = new AtomicInteger();
    protected File mJavaTraceFile;
    protected File mLogDir;
    protected File mLogcatFile;
    protected File mMemoryInfoFile;
    protected File mMessageFile;
    protected e mUploader;
    public static final String FILE_NAME_BASE = getBaseDir();
    public static AtomicBoolean isExceptionHappened = new AtomicBoolean(false);
    public static String sCrashingPid = "#####";

    private static String getBaseDir() {
        try {
            Context context = com.kwad.sdk.crash.e.Qd().getContext();
            if (context == null) {
                com.kwad.sdk.core.d.c.e(TAG, "getBaseDir() but getInstance().getContext() is null");
                context = ab.HD();
            }
            if (context == null) {
                com.kwad.sdk.core.d.c.e(TAG, "getBaseDir() but context is null");
                return UUID.randomUUID().toString();
            }
            String processName = SystemUtil.getProcessName(context);
            if (TextUtils.isEmpty(processName) || SystemUtil.isInMainProcess(context)) {
                processName = "main";
            } else if (processName != null) {
                if (processName.startsWith(context.getPackageName() + u15.f19942b)) {
                    processName = processName.substring(context.getPackageName().length() + 1);
                }
            }
            return processName + c49.f40900a + Process.myPid() + c49.f40900a + UUID.randomUUID().toString();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.W(TAG, Log.getStackTraceString(th));
            return UUID.randomUUID().toString();
        }
    }

    public static void initBackupDir(File file) {
        sBackupDir = file;
        if (file.exists()) {
            return;
        }
        sBackupDir.mkdirs();
    }

    public void backupLogFiles(File file) throws Throwable {
        File file2 = sBackupDir;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            sBackupDir.mkdirs();
        }
        try {
            y.i(file.getParentFile().getParentFile(), sBackupDir);
        } catch (IOException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    public f getCrashListener() {
        return this.mExceptionListener;
    }

    public abstract int getCrashType();

    public final e getUploader() {
        return this.mUploader;
    }

    public void init(File file, f fVar, e eVar) {
        this.mLogDir = file;
        if (!file.exists()) {
            this.mLogDir.mkdirs();
        }
        File file2 = this.mLogDir;
        StringBuilder sb = new StringBuilder();
        String str = FILE_NAME_BASE;
        sb.append(str);
        sb.append(c49.f40900a);
        sb.append(this.mIndex);
        sb.append(".dump");
        this.mDumpDir = new File(file2, sb.toString());
        this.mLogcatFile = new File(this.mLogDir, str + c49.f40900a + this.mIndex + c25.n);
        this.mJavaTraceFile = new File(this.mLogDir, str + c49.f40900a + this.mIndex + ".jtrace");
        this.mMemoryInfoFile = new File(this.mLogDir, str + c49.f40900a + this.mIndex + ".minfo");
        this.mExceptionListener = fVar;
        this.mUploader = eVar;
    }

    public abstract void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void uploadRemainingExceptions() {
        File[] fileArrListFiles = this.mLogDir.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.handler.b.1
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return file.getName().endsWith(".dump");
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length <= 2) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(fileArrListFiles.length);
        reportException(fileArrListFiles, countDownLatch);
        try {
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
