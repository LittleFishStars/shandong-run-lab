package com.czhj.wire.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alipay.sdk.m.o.b;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AsyncTimeout extends Timeout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static AsyncTimeout f29518a = null;
    private static final int b = 65536;
    private static final long c;
    private static final long d;
    private boolean e;
    private AsyncTimeout f;
    private long g;

    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.timedOut();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        AsyncTimeout asyncTimeoutA = AsyncTimeout.a();
                        if (asyncTimeoutA != null) {
                            if (asyncTimeoutA == AsyncTimeout.f29518a) {
                                AsyncTimeout.f29518a = null;
                                return;
                            }
                        }
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        c = millis;
        d = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    private long a(long j) {
        return this.g - j;
    }

    public static AsyncTimeout a() throws InterruptedException {
        AsyncTimeout asyncTimeout = f29518a.f;
        long jNanoTime = System.nanoTime();
        if (asyncTimeout == null) {
            AsyncTimeout.class.wait(c);
            if (f29518a.f != null || System.nanoTime() - jNanoTime < d) {
                return null;
            }
            return f29518a;
        }
        long jA = asyncTimeout.a(jNanoTime);
        if (jA > 0) {
            long j = jA / 1000000;
            AsyncTimeout.class.wait(j, (int) (jA - (1000000 * j)));
            return null;
        }
        f29518a.f = asyncTimeout.f;
        asyncTimeout.f = null;
        return asyncTimeout;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005a A[Catch: all -> 0x0067, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x0016, B:10:0x0022, B:11:0x002b, B:16:0x003a, B:17:0x0040, B:19:0x0044, B:22:0x004d, B:23:0x0050, B:25:0x005a, B:15:0x0034, B:28:0x0061, B:29:0x0066), top: B:33:0x0003 }] */
    private static synchronized void a(AsyncTimeout asyncTimeout, long j, boolean z) {
        AsyncTimeout asyncTimeout2;
        AsyncTimeout asyncTimeout3;
        if (f29518a == null) {
            f29518a = new AsyncTimeout();
            new Watchdog().start();
        }
        long jNanoTime = System.nanoTime();
        if (j == 0 || !z) {
            if (j == 0) {
                if (!z) {
                    throw new AssertionError();
                }
                asyncTimeout.g = asyncTimeout.deadlineNanoTime();
            }
            long jA = asyncTimeout.a(jNanoTime);
            asyncTimeout2 = f29518a;
            while (true) {
                asyncTimeout3 = asyncTimeout2.f;
                if (asyncTimeout3 != null || jA < asyncTimeout3.a(jNanoTime)) {
                    break;
                    break;
                }
                asyncTimeout2 = asyncTimeout2.f;
            }
            asyncTimeout.f = asyncTimeout2.f;
            asyncTimeout2.f = asyncTimeout;
            if (asyncTimeout2 == f29518a) {
                AsyncTimeout.class.notify();
            }
        } else {
            j = Math.min(j, asyncTimeout.deadlineNanoTime() - jNanoTime);
        }
        asyncTimeout.g = j + jNanoTime;
        long jA2 = asyncTimeout.a(jNanoTime);
        asyncTimeout2 = f29518a;
        while (true) {
            asyncTimeout3 = asyncTimeout2.f;
            if (asyncTimeout3 != null) {
                break;
            } else {
                asyncTimeout2 = asyncTimeout2.f;
            }
        }
        asyncTimeout.f = asyncTimeout2.f;
        asyncTimeout2.f = asyncTimeout;
        if (asyncTimeout2 == f29518a) {
            AsyncTimeout.class.notify();
        }
    }

    private static synchronized boolean a(AsyncTimeout asyncTimeout) {
        AsyncTimeout asyncTimeout2 = f29518a;
        while (asyncTimeout2 != null) {
            AsyncTimeout asyncTimeout3 = asyncTimeout2.f;
            if (asyncTimeout3 == asyncTimeout) {
                asyncTimeout2.f = asyncTimeout.f;
                asyncTimeout.f = null;
                return false;
            }
            asyncTimeout2 = asyncTimeout3;
        }
        return true;
    }

    public final IOException a(IOException iOException) throws IOException {
        return !exit() ? iOException : newTimeoutException(iOException);
    }

    public final void a(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    public final void enter() {
        if (this.e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            this.e = true;
            a(this, jTimeoutNanos, zHasDeadline);
        }
    }

    public final boolean exit() {
        if (!this.e) {
            return false;
        }
        this.e = false;
        return a(this);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException(b.r0);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(final Sink sink) {
        return new Sink() { // from class: com.czhj.wire.okio.AsyncTimeout.1
            @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.close();
                        AsyncTimeout.this.a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.a(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.a(false);
                    throw th;
                }
            }

            @Override // com.czhj.wire.okio.Sink, java.io.Flushable
            public void flush() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.flush();
                        AsyncTimeout.this.a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.a(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.a(false);
                    throw th;
                }
            }

            @Override // com.czhj.wire.okio.Sink
            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ")";
            }

            @Override // com.czhj.wire.okio.Sink
            public void write(Buffer buffer, long j) throws IOException {
                Util.checkOffsetAndCount(buffer.c, 0L, j);
                while (true) {
                    long j2 = 0;
                    if (j <= 0) {
                        return;
                    }
                    Segment segment = buffer.b;
                    while (j2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                        j2 += (long) (segment.e - segment.d);
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        segment = segment.h;
                    }
                    AsyncTimeout.this.enter();
                    try {
                        try {
                            sink.write(buffer, j2);
                            j -= j2;
                            AsyncTimeout.this.a(true);
                        } catch (IOException e) {
                            throw AsyncTimeout.this.a(e);
                        }
                    } catch (Throwable th) {
                        AsyncTimeout.this.a(false);
                        throw th;
                    }
                }
            }
        };
    }

    public final Source source(final Source source) {
        return new Source() { // from class: com.czhj.wire.okio.AsyncTimeout.2
            @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        source.close();
                        AsyncTimeout.this.a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.a(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.a(false);
                    throw th;
                }
            }

            @Override // com.czhj.wire.okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        long j2 = source.read(buffer, j);
                        AsyncTimeout.this.a(true);
                        return j2;
                    } catch (IOException e) {
                        throw AsyncTimeout.this.a(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.a(false);
                    throw th;
                }
            }

            @Override // com.czhj.wire.okio.Source
            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ")";
            }
        };
    }

    public void timedOut() {
    }
}
