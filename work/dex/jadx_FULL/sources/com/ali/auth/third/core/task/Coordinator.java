package com.ali.auth.third.core.task;

import android.annotation.TargetApi;
import android.os.Looper;
import android.os.Process;
import com.zj.adlib.dv9;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Coordinator {
    public static final int QUEUE_PRIORITY_NORMAL = 30;
    protected static final String TAG = "Coordinator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadFactory f23438a;
    static b b;
    protected static final BlockingQueue<Runnable> mPoolWorkQueue;

    public static class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "login#" + runnable.getClass().getName());
        }
    }

    public static class b extends ThreadPoolExecutor {
        public b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
            super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
            allowCoreThreadTimeOut(true);
        }

        public void a(Runnable runnable, int i) {
            if (runnable instanceof f) {
                super.execute(runnable);
                return;
            }
            f fVar = new f(runnable);
            if (i < 1) {
                i = 1;
            }
            fVar.b = i;
            super.execute(fVar);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        @TargetApi(11)
        public void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void beforeExecute(Thread thread, Runnable runnable) {
            StringBuilder sb;
            super.beforeExecute(thread, runnable);
            if (runnable instanceof f) {
                sb = new StringBuilder();
                runnable = ((f) runnable).f23439a;
            } else {
                sb = new StringBuilder();
            }
            sb.append(runnable);
            sb.append("");
            thread.setName(sb.toString());
        }
    }

    public static class c implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            char c;
            Object[] array = Coordinator.mPoolWorkQueue.toArray();
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (Object obj : array) {
                if (obj.getClass().isAnonymousClass()) {
                    sb.append(Coordinator.getOuterClass(obj));
                    c = '~';
                } else {
                    sb.append(obj);
                    c = dv9.b;
                }
                sb.append(c);
                sb.append(' ');
            }
            sb.append(']');
            throw new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + threadPoolExecutor.toString() + " in " + sb.toString());
        }
    }

    public static class d<Runnable> implements Comparator<Runnable> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public int compare(Runnable runnable, Runnable runnable2) {
            if (!(runnable instanceof f) || !(runnable2 instanceof f)) {
                return 0;
            }
            f fVar = (f) runnable;
            f fVar2 = (f) runnable2;
            if (fVar.a() > fVar2.a()) {
                return 1;
            }
            return fVar.a() < fVar2.a() ? -1 : 0;
        }
    }

    public interface e {
        int a();
    }

    public static class f implements Runnable, e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f23439a;
        int b = 30;

        public f(Runnable runnable) {
            this.f23439a = runnable;
        }

        @Override // com.ali.auth.third.core.task.Coordinator.e
        public int a() {
            Runnable runnable = this.f23439a;
            return runnable instanceof e ? ((e) runnable).a() : this.b;
        }

        @Override // java.lang.Runnable
        public void run() {
            Coordinator.runWithTiming(this.f23439a);
        }
    }

    static {
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(100, new d());
        mPoolWorkQueue = priorityBlockingQueue;
        a aVar = new a();
        f23438a = aVar;
        b = new b(8, 128, 10L, TimeUnit.SECONDS, priorityBlockingQueue, aVar, new c());
    }

    public static void execute(Runnable runnable) {
        b.a(runnable, 30);
    }

    public static void execute(Runnable runnable, int i) {
        b.a(runnable, i);
    }

    public static ThreadPoolExecutor getDefaultThreadPoolExecutor() {
        return b;
    }

    public static Object getOuterClass(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("this$0");
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e2) {
            e2.printStackTrace();
            return obj;
        }
    }

    public static void runWithTiming(Runnable runnable) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Process.setThreadPriority(10);
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
