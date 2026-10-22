package com.beizi.fusion;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.beizi.fusion.c8;
import com.beizi.fusion.j;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class j implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27421a;
    private Thread.UncaughtExceptionHandler b;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Throwable f27422a;
        private final Context b;

        private a(Context context, Throwable th) {
            this.b = context;
            this.f27422a = th;
        }

        private boolean a(String str) {
            return str.contains("biz.beizi.adn") || str.contains("xyz.adscope.common");
        }

        private void b(String str) {
            if (TextUtils.isEmpty(str) || !a(str)) {
                return;
            }
            p0.a(this.b, j.a(m0.a()), "asnpCause", true);
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            String strA = a(this.f27422a);
            b(strA);
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strA2 = a();
            try {
                if (TextUtils.isEmpty(strA2)) {
                    return;
                }
                a(String.format(strA2, Thread.currentThread().getId() + "t" + nn.b(), Long.valueOf(jCurrentTimeMillis)), jCurrentTimeMillis, strA);
            } catch (IOException e) {
                om.a(e);
            }
        }

        private String a() {
            File fileA = c8.a(this.b);
            if (fileA == null) {
                return "";
            }
            String str = fileA.getPath() + "/AdScope/crash/log/";
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.mkdirs();
                } catch (Exception unused) {
                    return "";
                }
            }
            return str + "asnp_crash_%s_%d.trace";
        }

        private String a(Throwable th) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            return stringWriter.toString();
        }

        private void a(String str, long j, String str2) throws Throwable {
            c8.a(str, j, str2);
        }
    }

    public j(Context context) {
        this.f27421a = context.getApplicationContext();
    }

    private void b(Throwable th) {
        om.b("ASNPCrashHandler", "handle uncaught exception..." + th.getMessage());
        a(th);
    }

    public static boolean c(Context context) {
        return p0.b(context, a(m0.a()), "asnpCause");
    }

    public void a() {
        this.b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        b(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }

    private void a(Throwable th) {
        Thread thread = new Thread(new a(this.f27421a, th));
        thread.setPriority(10);
        thread.start();
        try {
            thread.join(1000L);
        } catch (InterruptedException e) {
            om.a(e);
        }
    }

    public static List b(Context context) throws Throwable {
        File[] fileArrListFiles;
        final File fileA = a(context);
        if (fileA == null || !fileA.exists() || (fileArrListFiles = fileA.listFiles(new FileFilter() { // from class: com.zj.adlib.pcb
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return j.b(file);
            }
        })) == null || fileArrListFiles.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : fileArrListFiles) {
            if (file.exists()) {
                String strB = c8.b(file);
                if (!TextUtils.isEmpty(strB)) {
                    arrayList.add(new h6(strB, a(file)));
                }
            }
        }
        Runnable runnable = new Runnable() { // from class: com.zj.adlib.ddb
            @Override // java.lang.Runnable
            public final void run() {
                c8.a(fileA, (Set) null);
            }
        };
        fb fbVar = (fb) cn.a().b(context);
        if (fbVar != null) {
            fbVar.a(runnable);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(String str) {
        return String.format("asnpCrash_%s", str);
    }

    private static File a(Context context) {
        File fileA = c8.a(context);
        if (fileA == null) {
            return null;
        }
        File file = new File(fileA.getPath() + "/AdScope/crash/log/");
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        return null;
    }

    private static String a(File file) {
        if (file == null) {
            return "";
        }
        String name = file.getName();
        return !TextUtils.isEmpty(name) ? name.substring(name.lastIndexOf(LoginConstants.UNDER_LINE) + 1, name.lastIndexOf(Consts.DOT)) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean b(File file) {
        String name = file.getName();
        return !TextUtils.isEmpty(name) && name.endsWith(".trace");
    }
}
