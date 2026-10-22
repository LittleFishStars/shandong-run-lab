package com.czhj.wire.okio;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class ForwardingSource implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Source f29529a;

    public ForwardingSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f29529a = source;
    }

    @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29529a.close();
    }

    public final Source delegate() {
        return this.f29529a;
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        return this.f29529a.read(buffer, j);
    }

    @Override // com.czhj.wire.okio.Source
    public Timeout timeout() {
        return this.f29529a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f29529a.toString() + ")";
    }
}
