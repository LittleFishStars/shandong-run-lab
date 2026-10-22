package com.kc.bw.common.utils;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final String TAG = dexg.dexa("ybe}dsbti");
    public static final CrashHandler crashHandler = new CrashHandler();
    public Context applicationContext;
    public Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
    public String reportUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void doHandleException(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        do {
            th.printStackTrace(printWriter);
            th = th.getCause();
        } while (th != null);
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
            Log.e(TAG, dexg.dexa("gjmufsTubdlUsbdf!gbjm!") + Log.getStackTraceString(th2));
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

    private boolean handleException(Throwable th) {
        if (th == null) {
            return false;
        }
        ThreadUtils.runOnThreadPool(new Runnable(this, th) { // from class: com.kc.bw.common.utils.CrashHandler.1
            public final CrashHandler this$0;
            public final Throwable val$th;

            {
                this.this$0 = this;
                this.val$th = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                this.this$0.doHandleException(this.val$th);
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
                if (stackTraceElement.getClassName().contains(dexg.dexa("dpn/xbohnbj")) && !stackTraceElement.getClassName().contains(CrashHandler.class.getSimpleName())) {
                    z = true;
                    break;
                }
            }
            return (z || th.getCause() == null) ? z : needHandleException(th.getCause());
        } catch (Throwable th2) {
            Log.e(TAG, dexg.dexa("offeIboemf!gbjm!") + Log.getStackTraceString(th2));
            return false;
        }
    }

    private void reportCrash(String str) {
        Log.e(TAG, dexg.dexa("dsbti///"));
        ReportUtils.exReport(this.applicationContext, 999999, dexg.dexa("浪组潃湹"), str);
    }

    private void writeCrashToFile(String str) {
        try {
            if (this.applicationContext != null) {
                String str2 = new SimpleDateFormat(dexg.dexa("zzzz.NN.ee")).format(new Date(System.currentTimeMillis()));
                String str3 = new SimpleDateFormat(dexg.dexa("zzzz.NN.ee!II;NN;TT")).format(new Date(System.currentTimeMillis()));
                File file = new File(getLogFilePath(dexg.dexa("dsbti`") + str2 + dexg.dexa("/usbdf")));
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(str3);
                bufferedWriter.write("\r\n");
                bufferedWriter.write(dexg.dexa("..................dsbti......................"));
                bufferedWriter.write("\r\n");
                bufferedWriter.write(str);
                bufferedWriter.write("\r\n");
                bufferedWriter.write(dexg.dexa("...................foe......................."));
                bufferedWriter.newLine();
                bufferedWriter.close();
                fileWriter.close();
                Log.e(TAG, dexg.dexa("xsjufMph!pl"));
            }
        } catch (Throwable th) {
            Log.e(TAG, dexg.dexa("xsjufMph!gbjm!") + Log.getStackTraceString(th));
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
                DebugLog.release_e(TAG, dexg.dexa("iboemfFydfqujpo!gbjm!") + Log.getStackTraceString(th2));
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
