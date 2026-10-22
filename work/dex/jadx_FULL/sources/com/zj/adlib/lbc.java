package com.zj.adlib;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class lbc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    @GuardedBy("DynamiteLoaderV2ClassLoader.class")
    public static volatile ClassLoader f43034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @GuardedBy("DynamiteLoaderV2ClassLoader.class")
    public static volatile Thread f17919a;

    @Nullable
    public static synchronized ClassLoader a() {
        if (f43034a == null) {
            f43034a = b();
        }
        return f43034a;
    }

    @Nullable
    public static synchronized ClassLoader b() {
        ClassLoader contextClassLoader = null;
        if (f17919a == null) {
            f17919a = c();
            if (f17919a == null) {
                return null;
            }
        }
        synchronized (f17919a) {
            try {
                contextClassLoader = f17919a.getContextClassLoader();
            } catch (SecurityException e) {
                Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + e.getMessage());
            }
        }
        return contextClassLoader;
    }

    @Nullable
    public static synchronized Thread c() {
        SecurityException e;
        Thread g7cVar;
        Thread thread;
        ThreadGroup threadGroup;
        ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
        if (threadGroup2 == null) {
            return null;
        }
        synchronized (Void.class) {
            try {
                int iActiveGroupCount = threadGroup2.activeGroupCount();
                ThreadGroup[] threadGroupArr = new ThreadGroup[iActiveGroupCount];
                threadGroup2.enumerate(threadGroupArr);
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= iActiveGroupCount) {
                        threadGroup = null;
                        break;
                    }
                    threadGroup = threadGroupArr[i2];
                    if ("dynamiteLoader".equals(threadGroup.getName())) {
                        break;
                    }
                    i2++;
                }
                if (threadGroup == null) {
                    threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                }
                int iActiveCount = threadGroup.activeCount();
                Thread[] threadArr = new Thread[iActiveCount];
                threadGroup.enumerate(threadArr);
                while (true) {
                    if (i >= iActiveCount) {
                        thread = null;
                        break;
                    }
                    thread = threadArr[i];
                    if ("GmsDynamite".equals(thread.getName())) {
                        break;
                    }
                    i++;
                }
                if (thread == null) {
                    try {
                        g7cVar = new g7c(threadGroup, "GmsDynamite");
                        try {
                            g7cVar.setContextClassLoader(null);
                            g7cVar.start();
                        } catch (SecurityException e2) {
                            e = e2;
                            Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e.getMessage());
                        }
                    } catch (SecurityException e3) {
                        e = e3;
                        g7cVar = thread;
                    }
                    thread = g7cVar;
                }
            } catch (SecurityException e4) {
                e = e4;
                g7cVar = null;
            }
        }
        return thread;
    }
}
