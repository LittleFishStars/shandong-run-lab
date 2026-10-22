package com.aliyun.sls.android.producer.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Looper;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@SuppressLint({"PrivateApi"})
public final class ContextUtils {
    private static Class<?> sActivityThread;
    private static Application sApplication;

    static {
        try {
            sActivityThread = Class.forName(com.alibaba.ariver.kernel.common.utils.ProcessUtils.ACTIVITY_THREAD);
        } catch (Throwable unused) {
        }
    }

    private ContextUtils() {
    }

    @SuppressLint({"PrivateApi"})
    public static synchronized Object getActivityThread() {
        try {
            Class<?> cls = sActivityThread;
            if (cls == null) {
                return null;
            }
            Method method = cls.getMethod(com.alibaba.ariver.kernel.common.utils.ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]);
            method.setAccessible(true);
            int i = (Thread.currentThread().getId() > Looper.getMainLooper().getThread().getId() ? 1 : (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 0 : -1));
            return method.invoke(null, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static synchronized Application getApplication() {
        Application application = sApplication;
        if (application != null) {
            return application;
        }
        if (sActivityThread == null) {
            return null;
        }
        Object activityThread = getActivityThread();
        if (activityThread == null) {
            return null;
        }
        try {
            Method method = activityThread.getClass().getMethod("getApplication", new Class[0]);
            method.setAccessible(true);
            Application application2 = (Application) method.invoke(activityThread, null);
            sApplication = application2;
            return application2;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getActivityThread$0(final Object[] output, final Method currentActivityThreadMethod, final Object lock) {
        try {
            output[0] = currentActivityThreadMethod.invoke(null, new Object[0]);
        } catch (Throwable unused) {
        }
        try {
            lock.notify();
        } catch (Throwable unused2) {
        }
    }
}
