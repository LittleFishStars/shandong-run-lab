package com.zj.adlib;

import android.content.Context;
import android.os.Looper;
import com.amap.api.col.p0003l.ff;
import com.amap.api.col.p0003l.go;
import com.amap.api.col.p0003l.it;
import com.amap.api.col.p0003l.z;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a7b extends v6b implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<Context> f40467a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ExecutorService f15170a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f15172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Set<Integer> f15169a = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ThreadFactory f15171a = new b();

    public class a extends it {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ r4b f15173a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f15174a;

        public a(r4b r4bVar, boolean z) {
            this.f15173a = r4bVar;
            this.f15174a = z;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            try {
                synchronized (Looper.getMainLooper()) {
                    y6b.e(this.f15173a);
                }
                if (this.f15174a) {
                    go.e(a7b.this.f15172a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f40469a = new AtomicInteger(1);

        public class a extends Thread {
            public a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new a(runnable, "pama#" + this.f40469a.getAndIncrement());
        }
    }

    public a7b(Context context) {
        this.f15172a = context;
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            ((v6b) this).f20187a = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                ((v6b) this).f20188a = true;
                return;
            }
            String string = defaultUncaughtExceptionHandler.toString();
            if (!string.startsWith("com.amap.apis.utils.core.dynamiccore") && (string.indexOf("com.amap.api") != -1 || string.indexOf("com.loc") != -1)) {
                ((v6b) this).f20188a = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                ((v6b) this).f20188a = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized a7b d(Context context, r4b r4bVar) throws ff {
        try {
            if (r4bVar == null) {
                throw new ff("sdk info is null");
            }
            if (r4bVar.a() == null || "".equals(r4bVar.a())) {
                throw new ff("sdk name is invalid");
            }
            try {
                if (!f15169a.add(Integer.valueOf(r4bVar.hashCode()))) {
                    return (a7b) v6b.f45297a;
                }
                v6b v6bVar = v6b.f45297a;
                if (v6bVar == null) {
                    v6b.f45297a = new a7b(context);
                } else {
                    v6bVar.f20188a = false;
                }
                v6b v6bVar2 = v6b.f45297a;
                v6bVar2.a(r4bVar, v6bVar2.f20188a);
                return (a7b) v6b.f45297a;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static void e(Context context) {
        if (context == null) {
            return;
        }
        try {
            f40467a = new WeakReference<>(context.getApplicationContext());
        } catch (Throwable unused) {
        }
    }

    public static void f(Context context, r4b r4bVar, String str, String str2, String str3) {
        go.h(context, r4bVar, str, 0, str2, str3);
    }

    public static void g(r4b r4bVar, String str, ff ffVar) {
        if (ffVar != null) {
            i(r4bVar, str, ffVar.c(), ffVar.d(), ffVar.e(), ffVar.b());
        }
    }

    public static void h(r4b r4bVar, String str, String str2, String str3, String str4) {
        i(r4bVar, str, str2, str3, "", str4);
    }

    public static void i(r4b r4bVar, String str, String str2, String str3, String str4, String str5) {
        try {
            if (v6b.f45297a != null) {
                v6b.f45297a.a(r4bVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void j() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        try {
            ExecutorService executorService = f15170a;
            if (executorService != null) {
                executorService.shutdown();
            }
            e9b.g();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (v6b.f45297a != null) {
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                v6b v6bVar = v6b.f45297a;
                if (defaultUncaughtExceptionHandler == v6bVar && (uncaughtExceptionHandler = v6bVar.f20187a) != null) {
                    Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                }
            }
            v6b.f45297a = null;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void k(Context context, r4b r4bVar, String str, String str2, String str3) {
        go.h(context, r4bVar, str, 1, str2, str3);
    }

    public static void l(r4b r4bVar, String str, String str2) {
        try {
            v6b v6bVar = v6b.f45297a;
            if (v6bVar != null) {
                v6bVar.a(r4bVar, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void m(Throwable th, String str, String str2) {
        try {
            v6b v6bVar = v6b.f45297a;
            if (v6bVar != null) {
                v6bVar.a(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void n() {
        WeakReference<Context> weakReference = f40467a;
        if (weakReference != null && weakReference.get() != null) {
            y6b.c(f40467a.get());
            return;
        }
        v6b v6bVar = v6b.f45297a;
        if (v6bVar != null) {
            v6bVar.a();
        }
    }

    @Deprecated
    public static synchronized ExecutorService o() {
        try {
            ExecutorService executorService = f15170a;
            if (executorService == null || executorService.isShutdown()) {
                f15170a = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), f15171a);
            }
        } catch (Throwable unused) {
        }
        return f15170a;
    }

    @Override // com.zj.adlib.v6b
    public final void a(r4b r4bVar, String str, String str2) {
        go.l(r4bVar, this.f15172a, str2, str);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        a(th, 0, null, null);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = ((v6b) this).f20187a;
        if (uncaughtExceptionHandler != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (Throwable unused) {
            }
            ((v6b) this).f20187a.uncaughtException(thread, th);
        }
    }

    @Override // com.zj.adlib.v6b
    public final void a(Throwable th, int i, String str, String str2) {
        go.k(this.f15172a, th, i, str, str2);
    }

    @Override // com.zj.adlib.v6b
    public final void a() {
        y6b.c(this.f15172a);
    }

    @Override // com.zj.adlib.v6b
    public final void a(r4b r4bVar, boolean z) {
        try {
            z.g().b(new a(r4bVar, z));
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
