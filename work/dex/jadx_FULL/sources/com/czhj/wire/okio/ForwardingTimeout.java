package com.czhj.wire.okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ForwardingTimeout extends Timeout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Timeout f29530a;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f29530a = timeout;
    }

    @Override // com.czhj.wire.okio.Timeout
    public Timeout clearDeadline() {
        return this.f29530a.clearDeadline();
    }

    @Override // com.czhj.wire.okio.Timeout
    public Timeout clearTimeout() {
        return this.f29530a.clearTimeout();
    }

    @Override // com.czhj.wire.okio.Timeout
    public long deadlineNanoTime() {
        return this.f29530a.deadlineNanoTime();
    }

    @Override // com.czhj.wire.okio.Timeout
    public Timeout deadlineNanoTime(long j) {
        return this.f29530a.deadlineNanoTime(j);
    }

    public final Timeout delegate() {
        return this.f29530a;
    }

    @Override // com.czhj.wire.okio.Timeout
    public boolean hasDeadline() {
        return this.f29530a.hasDeadline();
    }

    public final ForwardingTimeout setDelegate(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f29530a = timeout;
        return this;
    }

    @Override // com.czhj.wire.okio.Timeout
    public void throwIfReached() throws IOException {
        this.f29530a.throwIfReached();
    }

    @Override // com.czhj.wire.okio.Timeout
    public Timeout timeout(long j, TimeUnit timeUnit) {
        return this.f29530a.timeout(j, timeUnit);
    }

    @Override // com.czhj.wire.okio.Timeout
    public long timeoutNanos() {
        return this.f29530a.timeoutNanos();
    }
}
