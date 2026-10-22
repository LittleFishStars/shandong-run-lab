package com.czhj.wire.okio;

import java.io.IOException;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DeflaterSink implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSink f29527a;
    private final Deflater b;
    private boolean c;

    public DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f29527a = bufferedSink;
        this.b = deflater;
    }

    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.buffer(sink), deflater);
    }

    private void a(boolean z) throws IOException {
        Segment segmentA;
        Buffer buffer = this.f29527a.buffer();
        while (true) {
            segmentA = buffer.a(1);
            Deflater deflater = this.b;
            byte[] bArr = segmentA.c;
            int i = segmentA.e;
            int i2 = 8192 - i;
            int iDeflate = z ? deflater.deflate(bArr, i, i2, 2) : deflater.deflate(bArr, i, i2);
            if (iDeflate > 0) {
                segmentA.e += iDeflate;
                buffer.c += (long) iDeflate;
                this.f29527a.emitCompleteSegments();
            } else if (this.b.needsInput()) {
                break;
            }
        }
        if (segmentA.d == segmentA.e) {
            buffer.b = segmentA.pop();
            SegmentPool.a(segmentA);
        }
    }

    public void a() throws IOException {
        this.b.finish();
        a(false);
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.c) {
            return;
        }
        a();
        th = null;
        try {
            this.b.end();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        try {
            this.f29527a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.c = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.f29527a.flush();
    }

    @Override // com.czhj.wire.okio.Sink
    public Timeout timeout() {
        return this.f29527a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f29527a + ")";
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        Util.checkOffsetAndCount(buffer.c, 0L, j);
        while (j > 0) {
            Segment segment = buffer.b;
            int iMin = (int) Math.min(j, segment.e - segment.d);
            this.b.setInput(segment.c, segment.d, iMin);
            a(false);
            long j2 = iMin;
            buffer.c -= j2;
            int i = segment.d + iMin;
            segment.d = i;
            if (i == segment.e) {
                buffer.b = segment.pop();
                SegmentPool.a(segment);
            }
            j -= j2;
        }
    }
}
