package com.czhj.sdk.common.exceptions;

import android.os.Process;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String CRASH = "crash";
    private static CrashHandler gInstance;
    private final Set<CrashHandlerListener> crashHandlerListenerSet = new HashSet();
    private Thread.UncaughtExceptionHandler mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();

    public interface CrashHandlerListener {
        void reportCrash(String str);
    }

    private CrashHandler() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static synchronized CrashHandler getInstance() {
        if (gInstance == null) {
            synchronized (CrashHandler.class) {
                gInstance = new CrashHandler();
            }
        }
        return gInstance;
    }

    private boolean handleException(final Throwable th) {
        if (th == null) {
            return false;
        }
        new Thread(new Runnable() { // from class: com.czhj.sdk.common.exceptions.CrashHandler.1
            @Override // java.lang.Runnable
            public void run() {
                CrashHandler.this.writeCrash(th);
            }
        }).start();
        try {
            Thread.sleep(1000L);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeCrash(Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            while (true) {
                th = th.getCause();
                if (th == null) {
                    break;
                } else {
                    th.printStackTrace(printWriter);
                }
            }
            printWriter.close();
            String string = stringWriter.toString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            for (CrashHandlerListener crashHandlerListener : this.crashHandlerListenerSet) {
                if (crashHandlerListener != null) {
                    crashHandlerListener.reportCrash(string);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(CrashHandlerListener crashHandlerListener) {
        if (crashHandlerListener != null) {
            this.crashHandlerListenerSet.add(crashHandlerListener);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            handleException(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultCrashHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }
}
