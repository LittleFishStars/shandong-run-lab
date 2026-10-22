package com.baidu.mshield.x0.e;

import android.text.TextUtils;
import com.baidu.mshield.x0.d.d;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f26744a = new a();
    public Thread.UncaughtExceptionHandler b;
    public boolean c;
    public b d;

    public static a a() {
        return f26744a;
    }

    public synchronized void b() {
        try {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
            if (uncaughtExceptionHandler != null) {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                this.b = null;
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        b bVar;
        try {
            String strA = a(th);
            if (!TextUtils.isEmpty(strA) && ((strA.contains("mshield") || strA.contains("WebViewProvider") || strA.contains("createWebView")) && (bVar = this.d) != null)) {
                bVar.a(strA);
            }
        } catch (Throwable th2) {
            d.a(th2);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public synchronized void a(b bVar) {
        this.d = bVar;
        if (bVar == null) {
            return;
        }
        if (bVar.a()) {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public final String a(Throwable th) {
        PrintWriter printWriter;
        try {
            StringWriter stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
            try {
                th.printStackTrace(printWriter);
                String string = stringWriter.toString();
                printWriter.close();
                return string;
            } catch (Throwable unused) {
                if (printWriter == null) {
                    return "";
                }
                printWriter.close();
                return "";
            }
        } catch (Throwable unused2) {
            printWriter = null;
        }
    }
}
