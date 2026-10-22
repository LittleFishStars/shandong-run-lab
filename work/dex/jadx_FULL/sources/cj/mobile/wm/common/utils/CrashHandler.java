package cj.mobile.wm.common.utils;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import cj.mobile.wm.dexc;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final String TAG = dexc.dexa("ybe}dsbti");
    public static final CrashHandler crashHandler = new CrashHandler();
    public Context applicationContext;
    public Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
    public String reportUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void doHandleException(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        String string = stringWriter.toString();
        reportCrash(string);
        writeCrashToFile(string);
    }

    public static void filterStackTrace(Throwable th) {
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null) {
                return;
            }
            Package r1 = CrashHandler.class.getPackage();
            ArrayList arrayList = new ArrayList();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (r1 != null && !stackTraceElement.getClassName().contains(r1.getName())) {
                    arrayList.add(stackTraceElement);
                }
            }
            if (th.getCause() != null) {
                filterStackTrace(th.getCause());
            }
            th.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
        } catch (Throwable th2) {
            Log.e(TAG, dexc.dexa("gjmufsTubdlUsbdf!gbjm!") + Log.getStackTraceString(th2));
        }
    }

    public static CrashHandler getInstance() {
        return crashHandler;
    }

    private String getLogFilePath(String str) {
        String logsDirPath = ConstantInfo.getLogsDirPath(this.applicationContext);
        if (TextUtils.isEmpty(logsDirPath)) {
            return "";
        }
        File file = new File(logsDirPath);
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath() + File.separator + str;
    }

    private boolean handleException(final Throwable th) {
        if (th == null) {
            return false;
        }
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: cj.mobile.wm.common.utils.CrashHandler.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                CrashHandler.this.doHandleException(th);
                Looper.loop();
            }
        });
        try {
            Thread.sleep(1000L);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean needHandleException(Throwable th) {
        boolean z = false;
        try {
            filterStackTrace(th);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (stackTraceElement.getClassName().contains(dexc.dexa("dpn/xbohnbj")) && !stackTraceElement.getClassName().contains(CrashHandler.class.getSimpleName())) {
                    z = true;
                    break;
                }
            }
            return (z || th.getCause() == null) ? z : needHandleException(th.getCause());
        } catch (Throwable th2) {
            Log.e(TAG, dexc.dexa("offeIboemf!gbjm!") + Log.getStackTraceString(th2));
            return false;
        }
    }

    private void reportCrash(String str) {
        Log.e(TAG, dexc.dexa("dsbti///"));
        ReportUtils.exReport(this.applicationContext, 999999, dexc.dexa("浪组潃湹"), str);
    }

    private void writeCrashToFile(String str) {
        try {
            if (this.applicationContext != null) {
                String str2 = new SimpleDateFormat(dexc.dexa("zzzz.NN.ee")).format(new Date(System.currentTimeMillis()));
                String str3 = new SimpleDateFormat(dexc.dexa("zzzz.NN.ee!II;NN;TT")).format(new Date(System.currentTimeMillis()));
                File file = new File(getLogFilePath(dexc.dexa("dsbti`") + str2 + dexc.dexa("/usbdf")));
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(str3);
                bufferedWriter.write("\r\n");
                bufferedWriter.write(dexc.dexa("..................dsbti......................"));
                bufferedWriter.write("\r\n");
                bufferedWriter.write(str);
                bufferedWriter.write("\r\n");
                bufferedWriter.write(dexc.dexa("...................foe......................."));
                bufferedWriter.newLine();
                bufferedWriter.close();
                fileWriter.close();
                Log.e(TAG, dexc.dexa("xsjufMph!pl"));
            }
        } catch (Throwable th) {
            Log.e(TAG, dexc.dexa("xsjufMph!gbjm!") + Log.getStackTraceString(th));
        }
    }

    public void init(Context context) {
        this.applicationContext = context.getApplicationContext();
        this.defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void setReportUrl(String str) {
        this.reportUrl = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (needHandleException(th)) {
            try {
                handleException(th);
            } catch (Throwable th2) {
                DebugLog.release_e(TAG, dexc.dexa("iboemfFydfqujpo!gbjm!") + Log.getStackTraceString(th2));
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.defaultUncaughtExceptionHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }
}
