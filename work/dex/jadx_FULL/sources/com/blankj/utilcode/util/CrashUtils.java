package com.blankj.utilcode.util;

import androidx.annotation.NonNull;
import com.fl.saas.common.crash.CrashHandler;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class CrashUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f28132a = System.getProperty("file.separator");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Thread.UncaughtExceptionHandler f1262a = Thread.getDefaultUncaughtExceptionHandler();

    public interface OnCrashListener {
        void a(b bVar);
    }

    public class a implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnCrashListener f28133a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f1263a;

        public a(OnCrashListener onCrashListener, String str) {
            this.f28133a = onCrashListener;
            this.f1263a = str;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
            String str = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss").format(new Date());
            b bVar = new b(str, th);
            OnCrashListener onCrashListener = this.f28133a;
            if (onCrashListener != null) {
                onCrashListener.a(bVar);
            }
            i.h1(this.f1263a + str + CrashHandler.FILE_NAME_SUFFIX, bVar.toString(), true);
            if (CrashUtils.f1262a != null) {
                CrashUtils.f1262a.uncaughtException(thread, th);
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i.a f28134a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Throwable f1264a;

        public b(String str, Throwable th) {
            this.f1264a = th;
            i.a aVar = new i.a("Crash");
            this.f28134a = aVar;
            aVar.a("Time Of Crash", str);
        }

        public final void a(String str, String str2) {
            this.f28134a.b(str, str2);
        }

        public final void b(Map<String, String> map) {
            this.f28134a.c(map);
        }

        public final Throwable c() {
            return this.f1264a;
        }

        public String toString() {
            return this.f28134a.toString() + i.S(this.f1264a);
        }
    }

    public CrashUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Thread.UncaughtExceptionHandler b(String str, OnCrashListener onCrashListener) {
        return new a(onCrashListener, str);
    }

    public static void c() {
        f("");
    }

    public static void d(@NonNull File file) {
        g(file.getAbsolutePath(), null);
    }

    public static void e(@NonNull File file, OnCrashListener onCrashListener) {
        g(file.getAbsolutePath(), onCrashListener);
    }

    public static void f(String str) {
        g(str, null);
    }

    public static void g(String str, OnCrashListener onCrashListener) {
        if (!i.C0(str)) {
            String str2 = f28132a;
            if (!str.endsWith(str2)) {
                str = str + str2;
            }
        } else if (!i.z0() || Utils.a().getExternalFilesDir(null) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Utils.a().getFilesDir());
            String str3 = f28132a;
            sb.append(str3);
            sb.append("crash");
            sb.append(str3);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Utils.a().getExternalFilesDir(null));
            String str4 = f28132a;
            sb2.append(str4);
            sb2.append("crash");
            sb2.append(str4);
            str = sb2.toString();
        }
        Thread.setDefaultUncaughtExceptionHandler(b(str, onCrashListener));
    }

    public static void init(OnCrashListener onCrashListener) {
        g("", onCrashListener);
    }
}
