package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class q extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Reader f32198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f6359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharBuffer f6360a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharsetEncoder f6361a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f6362a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f6363a;
    public boolean b;
    public boolean c;

    public q(Reader reader, Charset charset, int i) {
        this(reader, charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), i);
    }

    public static int a(Buffer buffer) {
        return buffer.capacity() - buffer.limit();
    }

    public static CharBuffer c(CharBuffer charBuffer) {
        CharBuffer charBufferWrap = CharBuffer.wrap(Arrays.copyOf(charBuffer.array(), charBuffer.capacity() * 2));
        j.e(charBufferWrap, charBuffer.position());
        j.c(charBufferWrap, charBuffer.limit());
        return charBufferWrap;
    }

    public final int b(byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, this.f6359a.remaining());
        this.f6359a.get(bArr, i, iMin);
        return iMin;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f32198a.close();
    }

    public final void g() throws IOException {
        if (a(this.f6360a) == 0) {
            if (this.f6360a.position() > 0) {
                j.b(this.f6360a.compact());
            } else {
                this.f6360a = c(this.f6360a);
            }
        }
        int iLimit = this.f6360a.limit();
        int i = this.f32198a.read(this.f6360a.array(), iLimit, a(this.f6360a));
        if (i == -1) {
            this.f6362a = true;
        } else {
            j.c(this.f6360a, iLimit + i);
        }
    }

    public final void h(boolean z) {
        j.b(this.f6359a);
        if (z && this.f6359a.remaining() == 0) {
            this.f6359a = ByteBuffer.allocate(this.f6359a.capacity() * 2);
        } else {
            this.b = true;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f6363a) == 1) {
            return UnsignedBytes.p(this.f6363a[0]);
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        CoderResult coderResultFlush;
        com.google.common.base.i.f0(i, i + i2, bArr.length);
        if (i2 == 0) {
            return 0;
        }
        boolean z = this.f6362a;
        int iB = 0;
        while (true) {
            if (this.b) {
                iB += b(bArr, i + iB, i2 - iB);
                if (iB == i2 || this.c) {
                    break;
                }
                this.b = false;
                j.a(this.f6359a);
            }
            while (true) {
                if (this.c) {
                    coderResultFlush = CoderResult.UNDERFLOW;
                } else {
                    coderResultFlush = z ? this.f6361a.flush(this.f6359a) : this.f6361a.encode(this.f6360a, this.f6359a, this.f6362a);
                }
                if (coderResultFlush.isOverflow()) {
                    h(true);
                    break;
                }
                if (coderResultFlush.isUnderflow()) {
                    if (z) {
                        this.c = true;
                        h(false);
                        break;
                    }
                    if (this.f6362a) {
                        z = true;
                    } else {
                        g();
                    }
                } else if (coderResultFlush.isError()) {
                    coderResultFlush.throwException();
                    return 0;
                }
            }
        }
        if (iB > 0) {
            return iB;
        }
        return -1;
    }

    public q(Reader reader, CharsetEncoder charsetEncoder, int i) {
        this.f6363a = new byte[1];
        this.f32198a = (Reader) com.google.common.base.i.E(reader);
        this.f6361a = (CharsetEncoder) com.google.common.base.i.E(charsetEncoder);
        com.google.common.base.i.k(i > 0, "bufferSize must be positive: %s", i);
        charsetEncoder.reset();
        CharBuffer charBufferAllocate = CharBuffer.allocate(i);
        this.f6360a = charBufferAllocate;
        j.b(charBufferAllocate);
        this.f6359a = ByteBuffer.allocate(i);
    }
}
