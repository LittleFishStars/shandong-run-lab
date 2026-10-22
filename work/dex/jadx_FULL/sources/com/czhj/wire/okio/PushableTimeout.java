package com.czhj.wire.okio;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class PushableTimeout extends Timeout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Timeout f29544a;
    private boolean b;
    private long c;
    private long d;

    public void a() {
        this.f29544a.timeout(this.d, TimeUnit.NANOSECONDS);
        if (this.b) {
            this.f29544a.deadlineNanoTime(this.c);
        } else {
            this.f29544a.clearDeadline();
        }
    }

    public void a(Timeout timeout) {
        long jDeadlineNanoTime;
        this.f29544a = timeout;
        boolean zHasDeadline = timeout.hasDeadline();
        this.b = zHasDeadline;
        this.c = zHasDeadline ? timeout.deadlineNanoTime() : -1L;
        long jTimeoutNanos = timeout.timeoutNanos();
        this.d = jTimeoutNanos;
        timeout.timeout(Timeout.a(jTimeoutNanos, timeoutNanos()), TimeUnit.NANOSECONDS);
        if (this.b && hasDeadline()) {
            jDeadlineNanoTime = Math.min(deadlineNanoTime(), this.c);
        } else if (!hasDeadline()) {
            return;
        } else {
            jDeadlineNanoTime = deadlineNanoTime();
        }
        timeout.deadlineNanoTime(jDeadlineNanoTime);
    }
}
