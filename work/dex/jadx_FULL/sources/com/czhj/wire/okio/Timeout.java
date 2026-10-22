package com.czhj.wire.okio;

import com.alipay.sdk.m.o.b;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Timeout {
    public static final Timeout NONE = new Timeout() { // from class: com.czhj.wire.okio.Timeout.1
        @Override // com.czhj.wire.okio.Timeout
        public Timeout deadlineNanoTime(long j) {
            return this;
        }

        @Override // com.czhj.wire.okio.Timeout
        public void throwIfReached() throws IOException {
        }

        @Override // com.czhj.wire.okio.Timeout
        public Timeout timeout(long j, TimeUnit timeUnit) {
            return this;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f29551a;
    private long b;
    private long c;

    public static long a(long j, long j2) {
        if (j == 0) {
            return j2;
        }
        return (j2 != 0 && j >= j2) ? j2 : j;
    }

    public Timeout clearDeadline() {
        this.f29551a = false;
        return this;
    }

    public Timeout clearTimeout() {
        this.c = 0L;
        return this;
    }

    public final Timeout deadline(long j, TimeUnit timeUnit) {
        if (j > 0) {
            if (timeUnit != null) {
                return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j));
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("duration <= 0: " + j);
    }

    public long deadlineNanoTime() {
        if (this.f29551a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public Timeout deadlineNanoTime(long j) {
        this.f29551a = true;
        this.b = j;
        return this;
    }

    public boolean hasDeadline() {
        return this.f29551a;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f29551a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public Timeout timeout(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.c = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public long timeoutNanos() {
        return this.c;
    }

    public final void waitUntilNotified(Object obj) throws InterruptedIOException {
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            long jNanoTime = 0;
            if (!zHasDeadline && jTimeoutNanos == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime2);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime2;
            }
            if (jTimeoutNanos > 0) {
                long j = jTimeoutNanos / 1000000;
                obj.wait(j, (int) (jTimeoutNanos - (1000000 * j)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jTimeoutNanos) {
                throw new InterruptedIOException(b.r0);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
