package com.czhj.wire.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class GzipSource implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte f29532a = 1;
    private static final byte b = 2;
    private static final byte c = 3;
    private static final byte d = 4;
    private static final byte e = 0;
    private static final byte f = 1;
    private static final byte g = 2;
    private static final byte h = 3;
    private final BufferedSource j;
    private final Inflater k;
    private final InflaterSource l;
    private int i = 0;
    private final CRC32 m = new CRC32();

    public GzipSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.k = inflater;
        BufferedSource bufferedSourceBuffer = Okio.buffer(source);
        this.j = bufferedSourceBuffer;
        this.l = new InflaterSource(bufferedSourceBuffer, inflater);
    }

    private void a() throws IOException {
        this.j.require(10L);
        byte b2 = this.j.buffer().getByte(3L);
        boolean z = ((b2 >> 1) & 1) == 1;
        if (z) {
            a(this.j.buffer(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.j.readShort());
        this.j.skip(8L);
        if (((b2 >> 2) & 1) == 1) {
            this.j.require(2L);
            if (z) {
                a(this.j.buffer(), 0L, 2L);
            }
            long shortLe = this.j.buffer().readShortLe() & 65535;
            this.j.require(shortLe);
            if (z) {
                a(this.j.buffer(), 0L, shortLe);
            }
            this.j.skip(shortLe);
        }
        if (((b2 >> 3) & 1) == 1) {
            long jIndexOf = this.j.indexOf((byte) 0);
            if (jIndexOf == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.j.buffer(), 0L, jIndexOf + 1);
            }
            this.j.skip(jIndexOf + 1);
        }
        if (((b2 >> 4) & 1) == 1) {
            long jIndexOf2 = this.j.indexOf((byte) 0);
            if (jIndexOf2 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.j.buffer(), 0L, jIndexOf2 + 1);
            }
            this.j.skip(jIndexOf2 + 1);
        }
        if (z) {
            a("FHCRC", this.j.readShortLe(), (short) this.m.getValue());
            this.m.reset();
        }
    }

    private void a(Buffer buffer, long j, long j2) {
        Segment segment = buffer.b;
        while (true) {
            int i = segment.e;
            int i2 = segment.d;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            segment = segment.h;
        }
        while (j2 > 0) {
            int i3 = (int) (((long) segment.d) + j);
            int iMin = (int) Math.min(segment.e - i3, j2);
            this.m.update(segment.c, i3, iMin);
            j2 -= (long) iMin;
            segment = segment.h;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    private void b() throws IOException {
        a("CRC", this.j.readIntLe(), (int) this.m.getValue());
        a("ISIZE", this.j.readIntLe(), (int) this.k.getBytesWritten());
    }

    @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.l.close();
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.i == 0) {
            a();
            this.i = 1;
        }
        if (this.i == 1) {
            long j2 = buffer.c;
            long j3 = this.l.read(buffer, j);
            if (j3 != -1) {
                a(buffer, j2, j3);
                return j3;
            }
            this.i = 2;
        }
        if (this.i == 2) {
            b();
            this.i = 3;
            if (!this.j.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // com.czhj.wire.okio.Source
    public Timeout timeout() {
        return this.j.timeout();
    }
}
