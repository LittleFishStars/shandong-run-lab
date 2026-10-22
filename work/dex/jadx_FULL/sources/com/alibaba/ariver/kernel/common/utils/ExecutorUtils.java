package com.alibaba.ariver.kernel.common.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExecutorUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f24278a = new Handler(Looper.getMainLooper());

    public static boolean currentThreadInArray(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            String currentScheduleType = getCurrentScheduleType();
            for (String str : strArr) {
                if (TextUtils.equals(str, currentScheduleType)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void execute(ExecutorType executorType, Runnable runnable) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(executorType).execute(runnable);
    }

    public static String getCurrentScheduleType() {
        return ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getCurrentScheduleType();
    }

    public static ScheduledThreadPoolExecutor getScheduledExecutor() {
        return ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getScheduledExecutor();
    }

    public static boolean isMainThread() {
        if (ProcessUtils.isInTestProcess()) {
            return "main".equals(Thread.currentThread().getName());
        }
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void postMain(Runnable runnable) {
        f24278a.post(runnable);
    }

    public static void removeOnMain(Runnable runnable) {
        f24278a.removeCallbacks(runnable);
    }

    public static void runNotOnMain(ExecutorType executorType, Runnable runnable) {
        if (isMainThread()) {
            execute(executorType, runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnMain(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            f24278a.post(runnable);
        }
    }

    public static void runOnMainAtFrontOfQueue(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            f24278a.postAtFrontOfQueue(runnable);
        }
    }

    public static void runOnMain(Runnable runnable, long j) {
        f24278a.postDelayed(runnable, j);
    }
}
