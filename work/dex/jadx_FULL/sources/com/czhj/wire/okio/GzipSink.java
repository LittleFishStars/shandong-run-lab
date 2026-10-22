package com.czhj.wire.okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class GzipSink implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSink f29531a;
    private final Deflater b;
    private final DeflaterSink c;
    private boolean d;
    private final CRC32 e = new CRC32();

    public GzipSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        Deflater deflater = new Deflater(-1, true);
        this.b = deflater;
        BufferedSink bufferedSinkBuffer = Okio.buffer(sink);
        this.f29531a = bufferedSinkBuffer;
        this.c = new DeflaterSink(bufferedSinkBuffer, deflater);
        a();
    }

    private void a() {
        Buffer buffer = this.f29531a.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    private void a(Buffer buffer, long j) {
        Segment segment = buffer.b;
        while (j > 0) {
            int iMin = (int) Math.min(j, segment.e - segment.d);
            this.e.update(segment.c, segment.d, iMin);
            j -= (long) iMin;
            segment = segment.h;
        }
    }

    private void b() throws IOException {
        this.f29531a.writeIntLe((int) this.e.getValue());
        this.f29531a.writeIntLe((int) this.b.getBytesRead());
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.d) {
            return;
        }
        this.c.a();
        b();
        th = null;
        try {
            this.b.end();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        try {
            this.f29531a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.d = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    public final Deflater deflater() {
        return this.b;
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.c.flush();
    }

    @Override // com.czhj.wire.okio.Sink
    public Timeout timeout() {
        return this.f29531a.timeout();
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return;
        }
        a(buffer, j);
        this.c.write(buffer, j);
    }
}
