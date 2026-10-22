package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class TimeoutFuture<V> extends FluentFuture.TrustedFuture<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public ListenableFuture<V> f32400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public ScheduledFuture<?> f6573a;

    public static final class TimeoutFutureException extends TimeoutException {
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }

        private TimeoutFutureException(String str) {
            super(str);
        }
    }

    public static final class b<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public TimeoutFuture<V> f32401a;

        public b(TimeoutFuture<V> timeoutFuture) {
            this.f32401a = timeoutFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture<? extends V> listenableFuture;
            TimeoutFuture<V> timeoutFuture = this.f32401a;
            if (timeoutFuture == null || (listenableFuture = timeoutFuture.f32400a) == null) {
                return;
            }
            this.f32401a = null;
            if (listenableFuture.isDone()) {
                timeoutFuture.setFuture(listenableFuture);
                return;
            }
            try {
                ScheduledFuture scheduledFuture = timeoutFuture.f6573a;
                timeoutFuture.f6573a = null;
                String string = "Timed out";
                if (scheduledFuture != null) {
                    try {
                        long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                        if (jAbs > 10) {
                            StringBuilder sb = new StringBuilder("Timed out".length() + 66);
                            sb.append("Timed out");
                            sb.append(" (timeout delayed by ");
                            sb.append(jAbs);
                            sb.append(" ms after scheduled time)");
                            string = sb.toString();
                        }
                    } catch (Throwable th) {
                        timeoutFuture.setException(new TimeoutFutureException(string));
                        throw th;
                    }
                }
                String strValueOf = String.valueOf(string);
                String strValueOf2 = String.valueOf(listenableFuture);
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 2 + strValueOf2.length());
                sb2.append(strValueOf);
                sb2.append(": ");
                sb2.append(strValueOf2);
                timeoutFuture.setException(new TimeoutFutureException(sb2.toString()));
                listenableFuture.cancel(true);
            } catch (Throwable th2) {
                listenableFuture.cancel(true);
                throw th2;
            }
        }
    }

    public TimeoutFuture(ListenableFuture<V> listenableFuture) {
        this.f32400a = (ListenableFuture) com.google.common.base.i.E(listenableFuture);
    }

    public static <V> ListenableFuture<V> L(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TimeoutFuture timeoutFuture = new TimeoutFuture(listenableFuture);
        b bVar = new b(timeoutFuture);
        timeoutFuture.f6573a = scheduledExecutorService.schedule(bVar, j, timeUnit);
        listenableFuture.addListener(bVar, j.c());
        return timeoutFuture;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        x(this.f32400a);
        ScheduledFuture<?> scheduledFuture = this.f6573a;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f32400a = null;
        this.f6573a = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public String pendingToString() {
        ListenableFuture<V> listenableFuture = this.f32400a;
        ScheduledFuture<?> scheduledFuture = this.f6573a;
        if (listenableFuture == null) {
            return null;
        }
        String strValueOf = String.valueOf(listenableFuture);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 14);
        sb.append("inputFuture=[");
        sb.append(strValueOf);
        sb.append("]");
        String string = sb.toString();
        if (scheduledFuture == null) {
            return string;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return string;
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 43);
        sb2.append(strValueOf2);
        sb2.append(", remaining delay=[");
        sb2.append(delay);
        sb2.append(" ms]");
        return sb2.toString();
    }
}
