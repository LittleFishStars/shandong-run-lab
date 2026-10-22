package com.kc.aw.lib.utils;

import android.os.Handler;
import android.os.Looper;
import com.kc.aw._jf;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _d {
    public static final _b _a = new _b(TimeUnit.SECONDS, new LinkedBlockingQueue(60), new _a(), new ThreadPoolExecutor.DiscardOldestPolicy());
    public static final Handler _b = new Handler(Looper.getMainLooper());

    @Keep
    public final class _a implements ThreadFactory {
        public final AtomicInteger _a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sb_a = _jf._a("IO-Thread-");
            sb_a.append(this._a.getAndIncrement());
            return new Thread(runnable, sb_a.toString());
        }
    }

    @Keep
    public final class _b extends ThreadPoolExecutor {
        public _b(TimeUnit timeUnit, LinkedBlockingQueue linkedBlockingQueue, _a _aVar, ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy) {
            super(4, 8, 60L, timeUnit, linkedBlockingQueue, _aVar, discardOldestPolicy);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public final void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            allowCoreThreadTimeOut(true);
        }
    }

    @Keep
    public static final class _c implements Runnable {
        public final Runnable _a;

        public _c(Runnable runnable) {
            this._a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable runnable = this._a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception e) {
                    Logger.e(e.getMessage());
                }
            }
        }
    }

    public static void _a(Runnable runnable) {
        if (runnable != null) {
            _b.removeCallbacks(runnable);
        }
    }

    public static void _b(Runnable runnable) {
        _a.execute(new _c(runnable));
    }

    public static void _c(Runnable runnable) {
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            _b.post(new _c(runnable));
            return;
        }
        try {
            runnable.run();
        } catch (Exception e) {
            Logger.e(e.getMessage());
        }
    }
}
