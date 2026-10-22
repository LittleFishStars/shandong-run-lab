package com.alibaba.ariver.resource.prepare.controller;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class Timer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24455a = "AriverRes:Timer";
    private final TimeoutListener b;
    private final TimerExecutor c;
    private TimeoutRunnable d;

    public static class HandlerExecutor implements TimerExecutor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f24456a = new Handler(Looper.getMainLooper());

        @Override // com.alibaba.ariver.resource.prepare.controller.TimerExecutor
        public void postDelayed(Runnable runnable, long j) {
            this.f24456a.postDelayed(runnable, j);
        }

        @Override // com.alibaba.ariver.resource.prepare.controller.TimerExecutor
        public void removeCallbacks(Runnable runnable) {
            this.f24456a.removeCallbacks(runnable);
        }
    }

    public interface TimeoutListener {
        void onTimeout(long j);
    }

    public class TimeoutRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f24457a;
        private boolean b;

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f24457a;
            RVLogger.d(Timer.f24455a, "timer timeout on elapsed: " + jCurrentTimeMillis);
            if (this.b) {
                return;
            }
            if (Timer.this.b != null) {
                Timer.this.b.onTimeout(jCurrentTimeMillis);
            }
            Timer.this.d = null;
        }

        private TimeoutRunnable(long j) {
            this.b = false;
            this.f24457a = j;
        }
    }

    public Timer(TimeoutListener timeoutListener) {
        this(timeoutListener, new HandlerExecutor());
    }

    public synchronized void invalidTimeout() {
        TimeoutRunnable timeoutRunnable = this.d;
        if (timeoutRunnable != null) {
            timeoutRunnable.b = true;
            this.c.removeCallbacks(this.d);
        }
    }

    public synchronized void postTimeout(long j) {
        long jCurrentTimeMillis;
        TimeoutRunnable timeoutRunnable = this.d;
        if (timeoutRunnable != null) {
            timeoutRunnable.b = true;
            jCurrentTimeMillis = this.d.f24457a;
            this.c.removeCallbacks(this.d);
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        TimeoutRunnable timeoutRunnable2 = new TimeoutRunnable(jCurrentTimeMillis);
        this.d = timeoutRunnable2;
        this.c.postDelayed(timeoutRunnable2, j);
    }

    public Timer(TimeoutListener timeoutListener, TimerExecutor timerExecutor) {
        this.d = null;
        this.b = timeoutListener;
        this.c = timerExecutor;
    }
}
