package com.czhj.wire.okio;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class PeekSource implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSource f29540a;
    private final Buffer b;
    private Segment c;
    private int d;
    private boolean e;
    private long f;

    public PeekSource(BufferedSource bufferedSource) {
        this.f29540a = bufferedSource;
        Buffer buffer = bufferedSource.buffer();
        this.b = buffer;
        Segment segment = buffer.b;
        this.c = segment;
        this.d = segment != null ? segment.d : -1;
    }

    @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.e = true;
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        Segment segment;
        Segment segment2;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.e) {
            throw new IllegalStateException("closed");
        }
        Segment segment3 = this.c;
        if (segment3 != null && (segment3 != (segment2 = this.b.b) || this.d != segment2.d)) {
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
        }
        if (j == 0) {
            return 0L;
        }
        if (!this.f29540a.request(this.f + 1)) {
            return -1L;
        }
        if (this.c == null && (segment = this.b.b) != null) {
            this.c = segment;
            this.d = segment.d;
        }
        long jMin = Math.min(j, this.b.c - this.f);
        this.b.copyTo(buffer, this.f, jMin);
        this.f += jMin;
        return jMin;
    }

    @Override // com.czhj.wire.okio.Source
    public Timeout timeout() {
        return this.f29540a.timeout();
    }
}
