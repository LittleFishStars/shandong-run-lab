package com.czhj.wire.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class RealBufferedSink implements BufferedSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f29545a;
    public final Buffer buffer = new Buffer();
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        if (sink == null) {
            throw new NullPointerException("sink == null");
        }
        this.sink = sink;
    }

    @Override // com.czhj.wire.okio.BufferedSink, com.czhj.wire.okio.BufferedSource
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f29545a) {
            return;
        }
        Buffer buffer = this.buffer;
        long j = buffer.c;
        if (j > 0) {
            this.sink.write(buffer, j);
        }
        th = null;
        try {
            this.sink.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.f29545a = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink emit() throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        long size = this.buffer.size();
        if (size > 0) {
            this.sink.write(this.buffer, size);
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink emitCompleteSegments() throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        long jCompleteSegmentByteCount = this.buffer.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            this.sink.write(this.buffer, jCompleteSegmentByteCount);
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink, com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.buffer;
        long j = buffer.c;
        if (j > 0) {
            this.sink.write(buffer, j);
        }
        this.sink.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f29545a;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: com.czhj.wire.okio.RealBufferedSink.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws Throwable {
                RealBufferedSink.this.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.f29545a) {
                    return;
                }
                realBufferedSink.flush();
            }

            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.f29545a) {
                    throw new IOException("closed");
                }
                realBufferedSink.buffer.writeByte((int) ((byte) i));
                RealBufferedSink.this.emitCompleteSegments();
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.f29545a) {
                    throw new IOException("closed");
                }
                realBufferedSink.buffer.write(bArr, i, i2);
                RealBufferedSink.this.emitCompleteSegments();
            }
        };
    }

    @Override // com.czhj.wire.okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ")";
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.buffer.write(byteBuffer);
        emitCompleteSegments();
        return iWrite;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(ByteString byteString) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(byteString);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long j2 = source.read(this.buffer, j);
            if (j2 == -1) {
                throw new EOFException();
            }
            j -= j2;
            emitCompleteSegments();
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(byte[] bArr) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(bArr);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i, int i2) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(bArr, i, i2);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(buffer, j);
        emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long j2 = source.read(this.buffer, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            emitCompleteSegments();
        }
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeByte(int i) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeByte(i);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeDecimalLong(long j) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeDecimalLong(j);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long j) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeHexadecimalUnsignedLong(j);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeInt(int i) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeInt(i);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeIntLe(int i) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeIntLe(i);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeLong(long j) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeLong(j);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeLongLe(long j) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeLongLe(j);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeShort(int i) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeShort(i);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeShortLe(int i) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeShortLe(i);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeString(String str, int i, int i2, Charset charset) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeString(str, i, i2, charset);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeString(String str, Charset charset) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeString(str, charset);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeUtf8(String str) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeUtf8(String str, int i, int i2) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str, i, i2);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeUtf8CodePoint(int i) throws IOException {
        if (this.f29545a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8CodePoint(i);
        return emitCompleteSegments();
    }
}
