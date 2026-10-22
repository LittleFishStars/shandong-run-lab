package com.kc.dw.core.utils;

import android.os.Build;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f39362a;
    public static final int b;
    public static final int c;
    public static final BlockingQueue<Runnable> d;

    @Keep
    public static class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    @Keep
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static f0 f39363a = new f0();
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        b = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        c = "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) ? 15 : (iAvailableProcessors * 3) + 1;
        d = new LinkedBlockingQueue(8);
    }

    public f0() {
        a();
    }

    public final void a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(b, c, 10L, TimeUnit.SECONDS, d, new a());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f39362a = threadPoolExecutor;
    }

    public boolean a(Runnable runnable) {
        try {
            f39362a.execute(runnable);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
