package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.y;
import com.zj.adlib.c25;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f extends d {
    private ExceptionMessage a(@NonNull File file, File file2, String str) {
        String strY;
        JavaExceptionMessage javaExceptionMessage;
        Exception e;
        JavaExceptionMessage javaExceptionMessage2 = null;
        try {
            strY = y.Y(file);
        } catch (Exception e2) {
            this.mErrorMessage += e2 + "\n";
            strY = null;
        }
        if (strY != null) {
            try {
                javaExceptionMessage = new JavaExceptionMessage();
                try {
                    javaExceptionMessage.parseJson(new JSONObject(strY));
                } catch (Exception e3) {
                    e = e3;
                    this.mErrorMessage += e + "\n";
                }
            } catch (Exception e4) {
                javaExceptionMessage = null;
                e = e4;
            }
            javaExceptionMessage2 = javaExceptionMessage;
        }
        if (javaExceptionMessage2 == null) {
            javaExceptionMessage2 = new JavaExceptionMessage();
            if (!TextUtils.isEmpty(strY)) {
                javaExceptionMessage2.mCrashDetail = strY;
                com.kwad.sdk.core.d.c.w("ExceptionJavaCrashReporter", "message.mCrashDetail:" + javaExceptionMessage2.mCrashDetail);
            }
        }
        try {
            javaExceptionMessage2.mLogUUID = com.kwad.sdk.crash.utils.g.gI(file.getName());
            javaExceptionMessage2.toString();
            b(new File(str + ".jtrace"), javaExceptionMessage2);
            a(file2, javaExceptionMessage2);
            com.kwad.sdk.crash.utils.g.a(file, javaExceptionMessage2.toString());
            com.kwad.sdk.crash.utils.g.d(file2, file);
            file.renameTo(file2);
            javaExceptionMessage2.mDumpsys = y.Y(new File(str + ".minfo"));
        } catch (Throwable th) {
            this.mErrorMessage += th + "\n";
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            javaExceptionMessage2.mErrorMessage += this.mErrorMessage;
        }
        return javaExceptionMessage2;
    }

    private static void b(File file, ExceptionMessage exceptionMessage) throws Throwable {
        String line;
        String str;
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader = null;
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(new FileReader(file));
                    try {
                        ThreadInfo threadInfo = new ThreadInfo();
                        while (true) {
                            line = bufferedReader3.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.isEmpty()) {
                                arrayList.add(threadInfo);
                                threadInfo = new ThreadInfo();
                            } else if (line.startsWith("at ") || line.startsWith("(no ")) {
                                if (threadInfo.mTrace == null) {
                                    str = line;
                                } else {
                                    str = threadInfo.mTrace + line;
                                }
                                threadInfo.mTrace = str;
                                threadInfo.mTrace += "#";
                            } else {
                                threadInfo.mName = line;
                            }
                        }
                        memoryInfo.mJavaThreads = arrayList;
                        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader3);
                        bufferedReader = line;
                    } catch (IOException e) {
                        e = e;
                        bufferedReader2 = bufferedReader3;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        bufferedReader = bufferedReader2;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e3);
        }
    }

    @Override // com.kwad.sdk.crash.report.d
    public final void D(File file) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "reportException dir =" + file);
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.f.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.getName().endsWith(".dump");
            }
        });
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                a(file2, (CountDownLatch) null);
            }
        }
    }

    @Override // com.kwad.sdk.crash.report.d
    public final ExceptionMessage a(@NonNull File file, File file2, File file3, File file4, File file5) {
        return null;
    }

    @Override // com.kwad.sdk.crash.report.d
    public final void a(File file, @Nullable CountDownLatch countDownLatch) {
        String strGI = com.kwad.sdk.crash.utils.g.gI(file.getPath());
        File file2 = new File(strGI + ".msg");
        File file3 = new File(strGI + c25.n);
        File file4 = new File(strGI + ".blog");
        File file5 = new File(strGI + ".jtrace");
        File file6 = new File(strGI + ".minfo");
        ArrayList arrayList = new ArrayList();
        try {
            ExceptionMessage exceptionMessageA = a(file, file3, strGI);
            if (exceptionMessageA == null) {
                try {
                    y.delete(file.getPath());
                    y.delete(file3.getPath());
                    y.delete(file4.getPath());
                    y.delete(file2.getPath());
                    y.delete(file5.getPath());
                    y.delete(file6.getPath());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        y.delete(((File) it.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    return;
                }
            }
            com.kwad.sdk.core.d.c.d("ExceptionJavaCrashReporter", "message.mCrashSource=" + exceptionMessageA.mCrashSource);
            if (exceptionMessageA.mCrashSource == 2) {
                try {
                    y.delete(file.getPath());
                    y.delete(file3.getPath());
                    y.delete(file4.getPath());
                    y.delete(file2.getPath());
                    y.delete(file5.getPath());
                    y.delete(file6.getPath());
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        y.delete(((File) it2.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    return;
                }
            }
            this.mUploader.a(exceptionMessageA, countDownLatch);
            com.kwad.sdk.core.d.c.d("ExceptionJavaCrashReporter", " java crash 不上传文件");
            try {
                y.delete(file.getPath());
                y.delete(file3.getPath());
                y.delete(file4.getPath());
                y.delete(file2.getPath());
                y.delete(file5.getPath());
                y.delete(file6.getPath());
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    y.delete(((File) it3.next()).getPath());
                }
                com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
            } catch (Throwable th3) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th3);
            }
        } catch (Throwable th4) {
            try {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th4);
                com.kwad.sdk.crash.utils.g.x(th4);
            } finally {
                try {
                    y.delete(file.getPath());
                    y.delete(file3.getPath());
                    y.delete(file4.getPath());
                    y.delete(file2.getPath());
                    y.delete(file5.getPath());
                    y.delete(file6.getPath());
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        y.delete(((File) it4.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th5) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th5);
                }
            }
        }
    }
}
