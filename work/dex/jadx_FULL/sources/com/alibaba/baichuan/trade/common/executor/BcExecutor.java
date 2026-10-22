package com.alibaba.baichuan.trade.common.executor;

import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BcExecutor implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24542a = "BcExecutor";
    private static volatile int b;
    private static Handler c = new Handler(Looper.getMainLooper());
    private static BcExecutor d = new BcExecutor(ExecutorType.UI);
    private static Map<ExecutorType, BcExecutor> e = new ConcurrentHashMap();
    private ExecutorType f;
    private ExecutorService g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24544a;
        int b;
        int c;
        long d = 1;
        int e = 100;
        ExecutorService f;
        String g;
    }

    public static class b implements ThreadFactory {
        private static final AtomicInteger b = new AtomicInteger(1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f24545a;
        private String d;
        private final AtomicInteger c = new AtomicInteger(1);
        private final String e = "-pool-" + b.getAndIncrement();

        public b(int i, String str) {
            this.f24545a = i;
            this.d = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "bc-" + this.d + this.e + "-thread-" + this.c.getAndIncrement());
            int i = this.f24545a;
            if (i <= 0 || i > 10) {
                this.f24545a = 10;
            }
            thread.setPriority(this.f24545a);
            return thread;
        }
    }

    private static int a() {
        File[] fileArrListFiles;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            File file = new File("/sys/devices/system/cpu/");
            final Pattern patternCompile = Pattern.compile("cpu[0-9]+");
            fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: com.alibaba.baichuan.trade.common.executor.BcExecutor.1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file2, String str) {
                    return patternCompile.matcher(str).matches();
                }
            });
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        } catch (Throwable th) {
            try {
                String str = f24542a;
                if (Log.isLoggable(str, 6)) {
                    Log.e(str, "Failed to calculate accurate cpu count", th);
                }
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                fileArrListFiles = null;
            } catch (Throwable th2) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                throw th2;
            }
        }
        return Math.max(1, fileArrListFiles != null ? fileArrListFiles.length : 0);
    }

    public static int calculateBestThreadCount() {
        if (b == 0) {
            b = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        return b;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (ExecutorType.UI.equals(this.f)) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                runnable.run();
                return;
            } else {
                c.post(runnable);
                return;
            }
        }
        ExecutorService executorService = this.g;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }

    public BcExecutor() {
    }

    public BcExecutor(ExecutorType executorType) {
        this.f = executorType;
    }

    private BcExecutor(String str, int i, int i2, long j, int i3, ExecutorService executorService, int i4) {
        int i5;
        int i6;
        if (executorService == null) {
            b = calculateBestThreadCount();
            if (i == 0 || i2 == 0) {
                i5 = b;
                i6 = b;
            } else {
                i5 = i;
                i6 = i2;
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i5, i6, j, TimeUnit.SECONDS, new ArrayBlockingQueue(i3), new b(i4, str), new ThreadPoolExecutor.CallerRunsPolicy());
            if (0 != j) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            this.g = threadPoolExecutor;
            return;
        }
        this.g = executorService;
    }
}
