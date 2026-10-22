package cj.mobile.wm.okhttp.utils;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.OkHttp;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ThreadUtils {
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final int TASK_QUEUE_MAX_COUNT = 128;
    public static final int THREAD_KEEP_LIVE_TIME = 30;
    public static final ThreadPoolExecutor mThreadPoolExecutor;
    public static final String TAG = dexc.dexa("yy/y/i");
    public static Handler mMainHandler = new Handler(Looper.getMainLooper());

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = iAvailableProcessors;
        int iMax = Math.max(iAvailableProcessors, 5);
        CORE_POOL_SIZE = iMax;
        mThreadPoolExecutor = new ThreadPoolExecutor(iMax, iMax, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new WMCommonThreadFactory(dexc.dexa("nn.o")), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static boolean isUIThread(String str) {
        if (!OkHttp.enableThreadLog) {
            return Thread.currentThread() == Looper.getMainLooper().getThread();
        }
        Thread threadCurrentThread = Thread.currentThread();
        StringBuilder sb = new StringBuilder(dexc.dexa("䁑"));
        sb.append(threadCurrentThread.getName());
        sb.append(dexc.dexa("䁒"));
        sb.append(str);
        boolean z = threadCurrentThread == Looper.getMainLooper().getThread();
        if (z) {
            sb.append(dexc.dexa("���颍杩幼��詌"));
            Log.i(TAG, sb.toString());
        } else {
            sb.append(dexc.dexa("-���颍杩殑��詌"));
            Log.d(TAG, sb.toString());
        }
        return z;
    }

    public static <T> Future<T> runOnThreadPool(Callable<T> callable) {
        return mThreadPoolExecutor.submit(callable);
    }

    public static void runOnThreadPool(Runnable runnable) {
        mThreadPoolExecutor.execute(runnable);
    }

    public static void runOnUIThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            mMainHandler.post(new SafeRunnable(runnable));
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            Log.w(TAG, dexc.dexa("uisfbe!fodpvoufsfe!bo!fydfqujpo)nn.o*!") + Log.getStackTraceString(th));
        }
    }

    public static void runOnUIThreadByThreadPool(final Runnable runnable) {
        mThreadPoolExecutor.execute(new Runnable() { // from class: cj.mobile.wm.okhttp.utils.ThreadUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ThreadUtils.mMainHandler.post(new SafeRunnable(runnable));
            }
        });
    }
}
