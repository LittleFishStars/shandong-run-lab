package com.czhj.wire.okio;

import com.airbnb.lottie.parser.moshi.a;
import com.alibaba.ariver.resource.parser.a.e;
import com.aliyun.openapiutil.Client;
import com.blankj.utilcode.util.ThreadUtils;
import com.google.common.primitives.UnsignedBytes;
import com.ipd.dsp.internal.q.u;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Buffer implements BufferedSink, BufferedSource, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f29522a = 65533;
    private static final byte[] d = {e.i, e.j, e.k, e.l, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, 97, 98, 99, 100, 101, 102};
    Segment b;
    long c;

    public static final class UnsafeCursor implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Segment f29525a;
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            this.f29525a = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i);
            }
            if (i > 8192) {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i);
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j = buffer.c;
            Segment segmentA = buffer.a(i);
            int i2 = 8192 - segmentA.e;
            segmentA.e = 8192;
            long j2 = i2;
            this.buffer.c = j + j2;
            this.f29525a = segmentA;
            this.offset = j;
            this.data = segmentA.c;
            this.start = 8192 - i2;
            this.end = 8192;
            return j2;
        }

        public final int next() {
            long j = this.offset;
            if (j != this.buffer.c) {
                return seek(j == -1 ? 0L : j + ((long) (this.end - this.start)));
            }
            throw new IllegalStateException();
        }

        public final long resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j2 = buffer.c;
            if (j <= j2) {
                if (j < 0) {
                    throw new IllegalArgumentException("newSize < 0: " + j);
                }
                long j3 = j2 - j;
                while (j3 > 0) {
                    Buffer buffer2 = this.buffer;
                    Segment segment = buffer2.b.i;
                    int i = segment.e;
                    long j4 = i - segment.d;
                    if (j4 > j3) {
                        segment.e = (int) (((long) i) - j3);
                        break;
                    }
                    buffer2.b = segment.pop();
                    SegmentPool.a(segment);
                    j3 -= j4;
                }
                this.f29525a = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                boolean z = true;
                while (j5 > 0) {
                    Segment segmentA = this.buffer.a(1);
                    int iMin = (int) Math.min(j5, 8192 - segmentA.e);
                    int i2 = segmentA.e + iMin;
                    segmentA.e = i2;
                    j5 -= (long) iMin;
                    if (z) {
                        this.f29525a = segmentA;
                        this.offset = j2;
                        this.data = segmentA.c;
                        this.start = i2 - iMin;
                        this.end = i2;
                        z = false;
                    }
                }
            }
            this.buffer.c = j;
            return j2;
        }

        public final int seek(long j) {
            if (j >= -1) {
                Buffer buffer = this.buffer;
                long j2 = buffer.c;
                if (j <= j2) {
                    if (j == -1 || j == j2) {
                        this.f29525a = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    Segment segment = buffer.b;
                    Segment segmentPush = this.f29525a;
                    long j3 = 0;
                    if (segmentPush != null) {
                        long j4 = this.offset - ((long) (this.start - segmentPush.d));
                        if (j4 > j) {
                            j2 = j4;
                            segmentPush = segment;
                            segment = segmentPush;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        segmentPush = segment;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            int i = segmentPush.e;
                            int i2 = segmentPush.d;
                            if (j < ((long) (i - i2)) + j3) {
                                break;
                            }
                            j3 += (long) (i - i2);
                            segmentPush = segmentPush.h;
                        }
                    } else {
                        while (j2 > j) {
                            segment = segment.i;
                            j2 -= (long) (segment.e - segment.d);
                        }
                        segmentPush = segment;
                        j3 = j2;
                    }
                    if (this.readWrite && segmentPush.f) {
                        Segment segmentB = segmentPush.b();
                        Buffer buffer2 = this.buffer;
                        if (buffer2.b == segmentPush) {
                            buffer2.b = segmentB;
                        }
                        segmentPush = segmentPush.push(segmentB);
                        segmentPush.i.pop();
                    }
                    this.f29525a = segmentPush;
                    this.offset = j;
                    this.data = segmentPush.c;
                    int i3 = segmentPush.d + ((int) (j - j3));
                    this.start = i3;
                    int i4 = segmentPush.e;
                    this.end = i4;
                    return i4 - i3;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.buffer.c)));
        }
    }

    private ByteString a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            Segment segment = this.b;
            if (segment != null) {
                byte[] bArr = segment.c;
                int i = segment.d;
                messageDigest.update(bArr, i, segment.e - i);
                Segment segment2 = this.b;
                while (true) {
                    segment2 = segment2.h;
                    if (segment2 == this.b) {
                        break;
                    }
                    byte[] bArr2 = segment2.c;
                    int i2 = segment2.d;
                    messageDigest.update(bArr2, i2, segment2.e - i2);
                }
            }
            return ByteString.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private ByteString a(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            Segment segment = this.b;
            if (segment != null) {
                byte[] bArr = segment.c;
                int i = segment.d;
                mac.update(bArr, i, segment.e - i);
                Segment segment2 = this.b;
                while (true) {
                    segment2 = segment2.h;
                    if (segment2 == this.b) {
                        break;
                    }
                    byte[] bArr2 = segment2.c;
                    int i2 = segment2.d;
                    mac.update(bArr2, i2, segment2.e - i2);
                }
            }
            return ByteString.of(mac.doFinal());
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private void a(InputStream inputStream, long j, boolean z) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            Segment segmentA = a(1);
            int i = inputStream.read(segmentA.c, segmentA.e, (int) Math.min(j, 8192 - segmentA.e));
            if (i == -1) {
                if (segmentA.d == segmentA.e) {
                    this.b = segmentA.pop();
                    SegmentPool.a(segmentA);
                }
                if (!z) {
                    throw new EOFException();
                }
                return;
            }
            segmentA.e += i;
            long j2 = i;
            this.c += j2;
            j -= j2;
        }
    }

    private boolean a(Segment segment, int i, ByteString byteString, int i2, int i3) {
        int i4 = segment.e;
        byte[] bArr = segment.c;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.h;
                byte[] bArr2 = segment.c;
                bArr = bArr2;
                i = segment.d;
                i4 = segment.e;
            }
            if (bArr[i] != byteString.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public int a(Options options, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        Segment segment;
        Segment segment2 = this.b;
        int i5 = -2;
        if (segment2 == null) {
            if (z) {
                return -2;
            }
            return options.indexOf(ByteString.EMPTY);
        }
        byte[] bArr = segment2.c;
        int i6 = segment2.d;
        int i7 = segment2.e;
        int[] iArr = options.b;
        Segment segment3 = segment2;
        int i8 = 0;
        int i9 = -1;
        loop0: while (true) {
            int i10 = i8 + 1;
            int i11 = iArr[i8];
            int i12 = i10 + 1;
            int i13 = iArr[i10];
            if (i13 != -1) {
                i9 = i13;
            }
            if (segment3 == null) {
                break;
            }
            if (i11 >= 0) {
                int i14 = i6 + 1;
                int i15 = bArr[i6] & 255;
                int i16 = i12 + i11;
                while (i12 != i16) {
                    if (i15 == iArr[i12]) {
                        i = iArr[i12 + i11];
                        if (i14 == i7) {
                            segment3 = segment3.h;
                            i2 = segment3.d;
                            bArr = segment3.c;
                            i7 = segment3.e;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        } else {
                            i2 = i14;
                        }
                    } else {
                        i12++;
                    }
                }
                return i9;
            }
            int i17 = i12 + (i11 * (-1));
            while (true) {
                int i18 = i6 + 1;
                int i19 = i12 + 1;
                if ((bArr[i6] & 255) != iArr[i12]) {
                    return i9;
                }
                boolean z2 = i19 == i17;
                if (i18 == i7) {
                    Segment segment4 = segment3.h;
                    i4 = segment4.d;
                    byte[] bArr2 = segment4.c;
                    i3 = segment4.e;
                    if (segment4 != segment2) {
                        segment = segment4;
                        bArr = bArr2;
                    } else {
                        if (!z2) {
                            break loop0;
                        }
                        bArr = bArr2;
                        segment = null;
                    }
                } else {
                    Segment segment5 = segment3;
                    i3 = i7;
                    i4 = i18;
                    segment = segment5;
                }
                if (z2) {
                    i = iArr[i19];
                    i2 = i4;
                    i7 = i3;
                    segment3 = segment;
                    break;
                }
                i6 = i4;
                i7 = i3;
                i12 = i19;
                segment3 = segment;
            }
            if (i >= 0) {
                return i;
            }
            i8 = -i;
            i6 = i2;
            i5 = -2;
        }
        return z ? i5 : i9;
    }

    public Segment a(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.b;
        if (segment != null) {
            Segment segment2 = segment.i;
            return (segment2.e + i > 8192 || !segment2.g) ? segment2.push(SegmentPool.a()) : segment2;
        }
        Segment segmentA = SegmentPool.a();
        this.b = segmentA;
        segmentA.i = segmentA;
        segmentA.h = segmentA;
        return segmentA;
    }

    public String a(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (getByte(j2) == 13) {
                String utf8 = readUtf8(j2);
                skip(2L);
                return utf8;
            }
        }
        String utf9 = readUtf8(j);
        skip(1L);
        return utf9;
    }

    public List<Integer> a() {
        if (this.b == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Segment segment = this.b;
        arrayList.add(Integer.valueOf(segment.e - segment.d));
        Segment segment2 = this.b;
        while (true) {
            segment2 = segment2.h;
            if (segment2 == this.b) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment2.e - segment2.d));
        }
    }

    @Override // com.czhj.wire.okio.BufferedSink, com.czhj.wire.okio.BufferedSource
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Buffer m182clone() {
        Buffer buffer = new Buffer();
        if (this.c == 0) {
            return buffer;
        }
        Segment segmentA = this.b.a();
        buffer.b = segmentA;
        segmentA.i = segmentA;
        segmentA.h = segmentA;
        Segment segment = this.b;
        while (true) {
            segment = segment.h;
            if (segment == this.b) {
                buffer.c = this.c;
                return buffer;
            }
            buffer.b.i.push(segment.a());
        }
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j = this.c;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.b.i;
        int i = segment.e;
        return (i >= 8192 || !segment.g) ? j : j - ((long) (i - segment.d));
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.c, j, j2);
        if (j2 == 0) {
            return this;
        }
        buffer.c += j2;
        Segment segment = this.b;
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
            Segment segmentA = segment.a();
            int i3 = (int) (((long) segmentA.d) + j);
            segmentA.d = i3;
            segmentA.e = Math.min(i3 + ((int) j2), segmentA.e);
            Segment segment2 = buffer.b;
            if (segment2 == null) {
                segmentA.i = segmentA;
                segmentA.h = segmentA;
                buffer.b = segmentA;
            } else {
                segment2.i.push(segmentA);
            }
            j2 -= (long) (segmentA.e - segmentA.d);
            segment = segment.h;
            j = 0;
        }
        return this;
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0L, this.c);
    }

    public final Buffer copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.c, j, j2);
        if (j2 == 0) {
            return this;
        }
        Segment segment = this.b;
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
            outputStream.write(segment.c, i3, iMin);
            j2 -= (long) iMin;
            segment = segment.h;
            j = 0;
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j = this.c;
        if (j != buffer.c) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        Segment segment = this.b;
        Segment segment2 = buffer.b;
        int i = segment.d;
        int i2 = segment2.d;
        while (j2 < this.c) {
            long jMin = Math.min(segment.e - i, segment2.e - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (segment.c[i] != segment2.c[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == segment.e) {
                segment = segment.h;
                i = segment.d;
            }
            if (i2 == segment2.e) {
                segment2 = segment2.h;
                i2 = segment2.d;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public boolean exhausted() {
        return this.c == 0;
    }

    @Override // com.czhj.wire.okio.BufferedSink, com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j) {
        int i;
        Util.checkOffsetAndCount(this.c, j, 1L);
        long j2 = this.c;
        if (j2 - j <= j) {
            long j3 = j - j2;
            Segment segment = this.b;
            do {
                segment = segment.i;
                int i2 = segment.e;
                i = segment.d;
                j3 += (long) (i2 - i);
            } while (j3 < 0);
            return segment.c[i + ((int) j3)];
        }
        Segment segment2 = this.b;
        while (true) {
            int i3 = segment2.e;
            int i4 = segment2.d;
            long j4 = i3 - i4;
            if (j < j4) {
                return segment2.c[i4 + ((int) j)];
            }
            j -= j4;
            segment2 = segment2.h;
        }
    }

    public int hashCode() {
        Segment segment = this.b;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.e;
            for (int i3 = segment.d; i3 < i2; i3++) {
                i = (i * 31) + segment.c[i3];
            }
            segment = segment.h;
        } while (segment != this.b);
        return i;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return a("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return a("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return a("HmacSHA512", byteString);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0L, Long.MAX_VALUE);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(byte b, long j, long j2) {
        Segment segment;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.c), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.c;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (segment = this.b) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                segment = segment.i;
                j4 -= (long) (segment.e - segment.d);
            }
        } else {
            while (true) {
                long j6 = ((long) (segment.e - segment.d)) + j3;
                if (j6 >= j) {
                    break;
                }
                segment = segment.h;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = segment.c;
            int iMin = (int) Math.min(segment.e, (((long) segment.d) + j5) - j4);
            for (int i = (int) ((((long) segment.d) + j7) - j4); i < iMin; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - segment.d)) + j4;
                }
            }
            j4 += (long) (segment.e - segment.d);
            segment = segment.h;
            j7 = j4;
        }
        return -1L;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(ByteString byteString, long j) throws IOException {
        if (byteString.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.b;
        long j3 = -1;
        if (segment == null) {
            return -1L;
        }
        long j4 = this.c;
        if (j4 - j < j) {
            while (j4 > j) {
                segment = segment.i;
                j4 -= (long) (segment.e - segment.d);
            }
        } else {
            while (true) {
                long j5 = ((long) (segment.e - segment.d)) + j2;
                if (j5 >= j) {
                    break;
                }
                segment = segment.h;
                j2 = j5;
            }
            j4 = j2;
        }
        byte b = byteString.getByte(0);
        int size = byteString.size();
        long j6 = 1 + (this.c - ((long) size));
        long j7 = j;
        Segment segment2 = segment;
        long j8 = j4;
        while (j8 < j6) {
            byte[] bArr = segment2.c;
            int iMin = (int) Math.min(segment2.e, (((long) segment2.d) + j6) - j8);
            int i = (int) ((((long) segment2.d) + j7) - j8);
            while (i < iMin) {
                if (bArr[i] == b) {
                    if (a(segment2, i + 1, byteString, 1, size)) {
                        return ((long) (i - segment2.d)) + j8;
                    }
                }
                i++;
                bArr = bArr;
            }
            j8 += (long) (segment2.e - segment2.d);
            segment2 = segment2.h;
            j7 = j8;
            j3 = -1;
        }
        return j3;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j) {
        int i;
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.b;
        if (segment == null) {
            return -1L;
        }
        long j3 = this.c;
        if (j3 - j < j) {
            while (j3 > j) {
                segment = segment.i;
                j3 -= (long) (segment.e - segment.d);
            }
        } else {
            while (true) {
                long j4 = ((long) (segment.e - segment.d)) + j2;
                if (j4 >= j) {
                    break;
                }
                segment = segment.h;
                j2 = j4;
            }
            j3 = j2;
        }
        if (byteString.size() == 2) {
            byte b = byteString.getByte(0);
            byte b2 = byteString.getByte(1);
            while (j3 < this.c) {
                byte[] bArr = segment.c;
                i = (int) ((((long) segment.d) + j) - j3);
                int i2 = segment.e;
                while (i < i2) {
                    byte b3 = bArr[i];
                    if (b3 == b || b3 == b2) {
                        return ((long) (i - segment.d)) + j3;
                    }
                    i++;
                }
                j3 += (long) (segment.e - segment.d);
                segment = segment.h;
                j = j3;
            }
            return -1L;
        }
        byte[] bArrA = byteString.a();
        while (j3 < this.c) {
            byte[] bArr2 = segment.c;
            i = (int) ((((long) segment.d) + j) - j3);
            int i3 = segment.e;
            while (i < i3) {
                byte b4 = bArr2[i];
                for (byte b5 : bArrA) {
                    if (b4 == b5) {
                        return ((long) (i - segment.d)) + j3;
                    }
                }
                i++;
            }
            j3 += (long) (segment.e - segment.d);
            segment = segment.h;
            j = j3;
        }
        return -1L;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: com.czhj.wire.okio.Buffer.2
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.c, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.c > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return Buffer.this.read(bArr, i, i2);
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return a("MD5");
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: com.czhj.wire.okio.Buffer.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                Buffer.this.writeByte((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                Buffer.this.write(bArr, i, i2);
            }
        };
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.c - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.b;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), segment.e - segment.d);
        byteBuffer.put(segment.c, segment.d, iMin);
        int i = segment.d + iMin;
        segment.d = i;
        this.c -= (long) iMin;
        if (i == segment.e) {
            this.b = segment.pop();
            SegmentPool.a(segment);
        }
        return iMin;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) {
        Util.checkOffsetAndCount(bArr.length, i, i2);
        Segment segment = this.b;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i2, segment.e - segment.d);
        System.arraycopy(segment.c, segment.d, bArr, i, iMin);
        int i3 = segment.d + iMin;
        segment.d = i3;
        this.c -= (long) iMin;
        if (i3 == segment.e) {
            this.b = segment.pop();
            SegmentPool.a(segment);
        }
        return iMin;
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        long j2 = this.c;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        buffer.write(this, j);
        return j;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long j = this.c;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte readByte() {
        long j = this.c;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.b;
        int i = segment.d;
        int i2 = segment.e;
        int i3 = i + 1;
        byte b = segment.c[i];
        this.c = j - 1;
        if (i3 == i2) {
            this.b = segment.pop();
            SegmentPool.a(segment);
        } else {
            segment.d = i3;
        }
        return b;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte[] readByteArray(long j) throws EOFException {
        Util.checkOffsetAndCount(this.c, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public ByteString readByteString(long j) throws EOFException {
        return new ByteString(readByteArray(j));
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readDecimalLong() {
        if (this.c == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i = 0;
        boolean z = false;
        long j = -7;
        long j2 = 0;
        boolean z2 = false;
        do {
            Segment segment = this.b;
            byte[] bArr = segment.c;
            int i2 = segment.d;
            int i3 = segment.e;
            while (i2 < i3) {
                byte b = bArr[i2];
                if (b >= 48 && b <= 57) {
                    int i4 = 48 - b;
                    if (j2 < a.b || (j2 == a.b && i4 < j)) {
                        Buffer bufferWriteByte = new Buffer().writeDecimalLong(j2).writeByte((int) b);
                        if (!z) {
                            bufferWriteByte.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + bufferWriteByte.readUtf8());
                    }
                    j2 = (j2 * 10) + ((long) i4);
                } else {
                    if (b != 45 || i != 0) {
                        if (i != 0) {
                            z2 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(b));
                    }
                    j--;
                    z = true;
                }
                i2++;
                i++;
            }
            if (i2 == i3) {
                this.b = segment.pop();
                SegmentPool.a(segment);
            } else {
                segment.d = i2;
            }
            if (z2) {
                break;
            }
        } while (this.b != null);
        this.c -= (long) i;
        return z ? j2 : -j2;
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        a(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream inputStream, long j) throws IOException {
        if (j >= 0) {
            a(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void readFully(Buffer buffer, long j) throws EOFException {
        long j2 = this.c;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new EOFException();
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        int i;
        int i2;
        if (this.c == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i3 = 0;
        boolean z = false;
        long j = 0;
        do {
            Segment segment = this.b;
            byte[] bArr = segment.c;
            int i4 = segment.d;
            int i5 = segment.e;
            while (i4 < i5) {
                byte b = bArr[i4];
                if (b < 48 || b > 57) {
                    if (b >= 97 && b <= 102) {
                        i = b - 97;
                    } else {
                        if (b < 65 || b > 70) {
                            if (i3 != 0) {
                                z = true;
                                break;
                            }
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                        }
                        i = b - 65;
                    }
                    i2 = i + 10;
                } else {
                    i2 = b - 48;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b).readUtf8());
                }
                j = (j << 4) | ((long) i2);
                i4++;
                i3++;
            }
            if (i4 == i5) {
                this.b = segment.pop();
                SegmentPool.a(segment);
            } else {
                segment.d = i4;
            }
            if (z) {
                break;
            }
        } while (this.b != null);
        this.c -= (long) i3;
        return j;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readInt() {
        long j = this.c;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.c);
        }
        Segment segment = this.b;
        int i = segment.d;
        int i2 = segment.e;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.c;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.c = j - 4;
        if (i8 == i2) {
            this.b = segment.pop();
            SegmentPool.a(segment);
        } else {
            segment.d = i8;
        }
        return i9;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readLong() {
        long j = this.c;
        if (j < 8) {
            throw new IllegalStateException("size < 8: " + this.c);
        }
        Segment segment = this.b;
        int i = segment.d;
        int i2 = segment.e;
        if (i2 - i < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = segment.c;
        int i3 = i + 1;
        long j2 = (((long) bArr[i]) & 255) << 56;
        int i4 = i3 + 1;
        long j3 = ((((long) bArr[i3]) & 255) << 48) | j2;
        int i5 = i4 + 1;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 40);
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24);
        int i8 = i7 + 1;
        long j6 = j5 | ((((long) bArr[i7]) & 255) << 16);
        int i9 = i8 + 1;
        long j7 = j6 | ((((long) bArr[i8]) & 255) << 8);
        int i10 = i9 + 1;
        long j8 = j7 | (((long) bArr[i9]) & 255);
        this.c = j - 8;
        if (i10 == i2) {
            this.b = segment.pop();
            SegmentPool.a(segment);
        } else {
            segment.d = i10;
        }
        return j8;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public short readShort() {
        long j = this.c;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.c);
        }
        Segment segment = this.b;
        int i = segment.d;
        int i2 = segment.e;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.c;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.c = j - 2;
        if (i4 == i2) {
            this.b = segment.pop();
            SegmentPool.a(segment);
        } else {
            segment.d = i4;
        }
        return (short) i5;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readString(long j, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.c, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        Segment segment = this.b;
        int i = segment.d;
        if (((long) i) + j > segment.e) {
            return new String(readByteArray(j), charset);
        }
        String str = new String(segment.c, i, (int) j, charset);
        int i2 = (int) (((long) segment.d) + j);
        segment.d = i2;
        this.c -= j;
        if (i2 == segment.e) {
            this.b = segment.pop();
            SegmentPool.a(segment);
        }
        return str;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.c, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.c, Util.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8(long j) throws EOFException {
        return readString(j, Util.UTF_8);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.c == 0) {
            throw new EOFException();
        }
        byte b = getByte(0L);
        if ((b & UnsignedBytes.f32243a) == 0) {
            i = b & 127;
            i3 = 0;
            i2 = 1;
        } else if ((b & 224) == 192) {
            i = b & 31;
            i2 = 2;
            i3 = 128;
        } else if ((b & 240) == 224) {
            i = b & com.google.common.base.a.q;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((b & ThreadUtils.d) != 240) {
                skip(1L);
                return f29522a;
            }
            i = b & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.c < j) {
            throw new EOFException("size < " + i2 + ": " + this.c + " (to read code point prefixed 0x" + Integer.toHexString(b) + ")");
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b2 = getByte(j2);
            if ((b2 & u.n7) != 128) {
                skip(j2);
                return f29522a;
            }
            i = (i << 6) | (b2 & 63);
        }
        skip(j);
        if (i > 1114111) {
            return f29522a;
        }
        return ((i < 55296 || i > 57343) && i >= i3) ? i : f29522a;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8Line() throws EOFException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return a(jIndexOf);
        }
        long j = this.c;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8LineStrict(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jIndexOf = indexOf((byte) 10, 0L, j2);
        if (jIndexOf != -1) {
            return a(jIndexOf);
        }
        if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
            return a(j2);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public boolean request(long j) {
        return this.c >= j;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void require(long j) throws EOFException {
        if (this.c < j) {
            throw new EOFException();
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int select(Options options) {
        int iA = a(options, false);
        if (iA == -1) {
            return -1;
        }
        try {
            skip(options.f29539a[iA].size());
            return iA;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public final ByteString sha1() {
        return a("SHA-1");
    }

    public final ByteString sha256() {
        return a(Client.HASH_SHA256);
    }

    public final ByteString sha512() {
        return a("SHA-512");
    }

    public final long size() {
        return this.c;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.b;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, segment.e - segment.d);
            long j2 = iMin;
            this.c -= j2;
            j -= j2;
            Segment segment2 = this.b;
            int i = segment2.d + iMin;
            segment2.d = i;
            if (i == segment2.e) {
                this.b = segment2.pop();
                SegmentPool.a(segment2);
            }
        }
    }

    public final ByteString snapshot() {
        long j = this.c;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.c);
    }

    public final ByteString snapshot(int i) {
        return i == 0 ? ByteString.EMPTY : new SegmentedByteString(this, i);
    }

    @Override // com.czhj.wire.okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            Segment segmentA = a(1);
            int iMin = Math.min(i, 8192 - segmentA.e);
            byteBuffer.get(segmentA.c, segmentA.e, iMin);
            i -= iMin;
            segmentA.e += iMin;
        }
        this.c += (long) iRemaining;
        return iRemaining;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.a(this);
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        Util.checkOffsetAndCount(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment segmentA = a(1);
            int iMin = Math.min(i3 - i, 8192 - segmentA.e);
            System.arraycopy(bArr, i, segmentA.c, segmentA.e, iMin);
            i += iMin;
            segmentA.e += iMin;
        }
        this.c += j;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long j2 = source.read(this, j);
            if (j2 == -1) {
                throw new EOFException();
            }
            j -= j2;
        }
        return this;
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        Util.checkOffsetAndCount(buffer.c, 0L, j);
        while (j > 0) {
            Segment segment = buffer.b;
            if (j < segment.e - segment.d) {
                Segment segment2 = this.b;
                Segment segment3 = segment2 != null ? segment2.i : null;
                if (segment3 != null && segment3.g) {
                    if ((((long) segment3.e) + j) - ((long) (segment3.f ? 0 : segment3.d)) <= 8192) {
                        segment.writeTo(segment3, (int) j);
                        buffer.c -= j;
                        this.c += j;
                        return;
                    }
                }
                buffer.b = segment.split((int) j);
            }
            Segment segment4 = buffer.b;
            long j2 = segment4.e - segment4.d;
            buffer.b = segment4.pop();
            Segment segment5 = this.b;
            if (segment5 == null) {
                this.b = segment4;
                segment4.i = segment4;
                segment4.h = segment4;
            } else {
                segment5.i.push(segment4).compact();
            }
            buffer.c -= j2;
            this.c += j2;
            j -= j2;
        }
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long j2 = source.read(this, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeByte(int i) {
        Segment segmentA = a(1);
        byte[] bArr = segmentA.c;
        int i2 = segmentA.e;
        segmentA.e = i2 + 1;
        bArr[i2] = (byte) i;
        this.c++;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        boolean z;
        if (j == 0) {
            return writeByte(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j < 100000000) {
            if (j < 10000) {
                if (j >= 100) {
                    i = j < 1000 ? 3 : 4;
                } else if (j >= 10) {
                    i = 2;
                }
            } else if (j < 1000000) {
                i = j < 100000 ? 5 : 6;
            } else {
                i = j < 10000000 ? 7 : 8;
            }
        } else if (j < 1000000000000L) {
            if (j < 10000000000L) {
                i = j < 1000000000 ? 9 : 10;
            } else {
                i = j < 100000000000L ? 11 : 12;
            }
        } else if (j < 1000000000000000L) {
            if (j < 10000000000000L) {
                i = 13;
            } else {
                i = j < 100000000000000L ? 14 : 15;
            }
        } else if (j < 100000000000000000L) {
            i = j < 10000000000000000L ? 16 : 17;
        } else {
            i = j < 1000000000000000000L ? 18 : 19;
        }
        if (z) {
            i++;
        }
        Segment segmentA = a(i);
        byte[] bArr = segmentA.c;
        int i2 = segmentA.e + i;
        while (j != 0) {
            i2--;
            bArr[i2] = d[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = com.google.android.exoplayer2.text.cea.a.n;
        }
        segmentA.e += i;
        this.c += (long) i;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment segmentA = a(iNumberOfTrailingZeros);
        byte[] bArr = segmentA.c;
        int i = segmentA.e;
        for (int i2 = (i + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = d[(int) (15 & j)];
            j >>>= 4;
        }
        segmentA.e += iNumberOfTrailingZeros;
        this.c += (long) iNumberOfTrailingZeros;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeInt(int i) {
        Segment segmentA = a(4);
        byte[] bArr = segmentA.c;
        int i2 = segmentA.e;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        segmentA.e = i5 + 1;
        this.c += 4;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeIntLe(int i) {
        return writeInt(Util.reverseBytesInt(i));
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeLong(long j) {
        Segment segmentA = a(8);
        byte[] bArr = segmentA.c;
        int i = segmentA.e;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        segmentA.e = i8 + 1;
        this.c += 8;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeLongLe(long j) {
        return writeLong(Util.reverseBytesLong(j));
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeShort(int i) {
        Segment segmentA = a(2);
        byte[] bArr = segmentA.c;
        int i2 = segmentA.e;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        segmentA.e = i3 + 1;
        this.c += 2;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeShortLe(int i) {
        return writeShort((int) Util.reverseBytesShort((short) i));
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeString(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 <= str.length()) {
            if (charset == null) {
                throw new IllegalArgumentException("charset == null");
            }
            if (charset.equals(Util.UTF_8)) {
                return writeUtf8(str, i, i2);
            }
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
        throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.c);
    }

    public final Buffer writeTo(OutputStream outputStream, long j) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.c, 0L, j);
        Segment segment = this.b;
        while (j > 0) {
            int iMin = (int) Math.min(j, segment.e - segment.d);
            outputStream.write(segment.c, segment.d, iMin);
            int i = segment.d + iMin;
            segment.d = i;
            long j2 = iMin;
            this.c -= j2;
            j -= j2;
            if (i == segment.e) {
                Segment segmentPop = segment.pop();
                this.b = segmentPop;
                SegmentPool.a(segment);
                segment = segmentPop;
            }
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeUtf8(String str, int i, int i2) {
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                Segment segmentA = a(1);
                byte[] bArr = segmentA.c;
                int i4 = segmentA.e - i;
                int iMin = Math.min(i2, 8192 - i4);
                int i5 = i + 1;
                bArr[i + i4] = (byte) cCharAt;
                while (i5 < iMin) {
                    char cCharAt2 = str.charAt(i5);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i5 + i4] = (byte) cCharAt2;
                    i5++;
                }
                int i6 = segmentA.e;
                int i7 = (i4 + i5) - i6;
                segmentA.e = i6 + i7;
                this.c += (long) i7;
                i = i5;
            } else {
                if (cCharAt < 2048) {
                    i3 = (cCharAt >> 6) | 192;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    writeByte((cCharAt >> '\f') | 224);
                    i3 = ((cCharAt >> 6) & 63) | 128;
                } else {
                    int i8 = i + 1;
                    char cCharAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        writeByte(63);
                        i = i8;
                    } else {
                        int i9 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        writeByte((i9 >> 18) | 240);
                        writeByte(((i9 >> 12) & 63) | 128);
                        writeByte(((i9 >> 6) & 63) | 128);
                        writeByte((i9 & 63) | 128);
                        i += 2;
                    }
                }
                writeByte(i3);
                writeByte((cCharAt & '?') | 128);
                i++;
            }
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i) {
        int i2;
        int i3;
        if (i >= 128) {
            if (i < 2048) {
                i3 = (i >> 6) | 192;
            } else {
                if (i < 65536) {
                    if (i < 55296 || i > 57343) {
                        i2 = (i >> 12) | 224;
                    } else {
                        writeByte(63);
                    }
                } else {
                    if (i > 1114111) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                    }
                    writeByte((i >> 18) | 240);
                    i2 = ((i >> 12) & 63) | 128;
                }
                writeByte(i2);
                i3 = ((i >> 6) & 63) | 128;
            }
            writeByte(i3);
            i = (i & 63) | 128;
            writeByte(i);
        } else {
            writeByte(i);
        }
        return this;
    }
}
