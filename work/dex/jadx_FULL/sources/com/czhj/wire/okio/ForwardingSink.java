package com.czhj.wire.okio;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class ForwardingSink implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Sink f29528a;

    public ForwardingSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f29528a = sink;
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29528a.close();
    }

    public final Sink delegate() {
        return this.f29528a;
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.f29528a.flush();
    }

    @Override // com.czhj.wire.okio.Sink
    public Timeout timeout() {
        return this.f29528a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f29528a.toString() + ")";
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        this.f29528a.write(buffer, j);
    }
}
