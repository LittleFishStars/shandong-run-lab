package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Log {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31159a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public static boolean f5275a = true;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = Integer.MAX_VALUE;

    @GuardedBy("lock")
    public static int f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f5274a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public static Logger f5273a = Logger.f31160a;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public interface Logger {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Logger f31160a = new a();

        public class a implements Logger {
            @Override // com.google.android.exoplayer2.util.Log.Logger
            public void d(String str, String str2) {
                android.util.Log.d(str, str2);
            }

            @Override // com.google.android.exoplayer2.util.Log.Logger
            public void e(String str, String str2) {
                android.util.Log.e(str, str2);
            }

            @Override // com.google.android.exoplayer2.util.Log.Logger
            public void i(String str, String str2) {
                android.util.Log.i(str, str2);
            }

            @Override // com.google.android.exoplayer2.util.Log.Logger
            public void w(String str, String str2) {
                android.util.Log.w(str, str2);
            }
        }

        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void w(String str, String str2);
    }

    @Pure
    public static String a(String str, @Nullable Throwable th) {
        String strG = g(th);
        if (TextUtils.isEmpty(strG)) {
            return str;
        }
        return str + "\n  " + strG.replace("\n", "\n  ") + '\n';
    }

    @Pure
    public static void b(@Size(max = 23) String str, String str2) {
        synchronized (f5274a) {
            if (f == 0) {
                f5273a.d(str, str2);
            }
        }
    }

    @Pure
    public static void c(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        b(str, a(str2, th));
    }

    @Pure
    public static void d(@Size(max = 23) String str, String str2) {
        synchronized (f5274a) {
            if (f <= 3) {
                f5273a.e(str, str2);
            }
        }
    }

    @Pure
    public static void e(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        d(str, a(str2, th));
    }

    @Pure
    public static int f() {
        int i;
        synchronized (f5274a) {
            i = f;
        }
        return i;
    }

    @Nullable
    @Pure
    public static String g(@Nullable Throwable th) {
        synchronized (f5274a) {
            try {
                if (th == null) {
                    return null;
                }
                if (j(th)) {
                    return "UnknownHostException (no network)";
                }
                if (f5275a) {
                    return android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
                }
                return th.getMessage();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Pure
    public static void h(@Size(max = 23) String str, String str2) {
        synchronized (f5274a) {
            if (f <= 1) {
                f5273a.i(str, str2);
            }
        }
    }

    @Pure
    public static void i(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        h(str, a(str2, th));
    }

    @Pure
    public static boolean j(@Nullable Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void k(int i) {
        synchronized (f5274a) {
            f = i;
        }
    }

    public static void l(boolean z) {
        synchronized (f5274a) {
            f5275a = z;
        }
    }

    public static void m(Logger logger) {
        synchronized (f5274a) {
            f5273a = logger;
        }
    }

    @Pure
    public static void n(@Size(max = 23) String str, String str2) {
        synchronized (f5274a) {
            if (f <= 2) {
                f5273a.w(str, str2);
            }
        }
    }

    @Pure
    public static void o(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        n(str, a(str2, th));
    }
}
