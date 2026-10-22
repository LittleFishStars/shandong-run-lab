package com.aliyun.common.crash;

import android.os.Process;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class AlivcExceptionHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private volatile boolean mIsRegister = false;
    private volatile boolean mIsCrashing = false;

    private String dumpCrashStack(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        do {
            th.printStackTrace(printWriter);
            th = th.getCause();
        } while (th != null);
        printWriter.close();
        return stringWriter.toString();
    }

    private static native void nativeOnCrashCallback(int i, long j, String str, String str2);

    public void register() {
        if (this.mIsRegister) {
            return;
        }
        this.mIsRegister = true;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void unRegister() {
        if (this.mIsRegister) {
            this.mIsRegister = false;
            if (Thread.getDefaultUncaughtExceptionHandler() == this) {
                Thread.setDefaultUncaughtExceptionHandler(this.mDefaultHandler);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
        if (this.mIsCrashing) {
            return;
        }
        this.mIsCrashing = true;
        if (this.mIsRegister) {
            try {
                nativeOnCrashCallback(Process.myPid(), thread.getId(), thread.getName(), dumpCrashStack(th));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }
}
