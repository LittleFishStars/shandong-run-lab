package com.czhj.wire.okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class SegmentedByteString extends ByteString {
    final transient byte[][] e;
    final transient int[] f;

    public SegmentedByteString(Buffer buffer, int i) {
        super(null);
        Util.checkOffsetAndCount(buffer.c, 0L, i);
        Segment segment = buffer.b;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = segment.e;
            int i6 = segment.d;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            segment = segment.h;
        }
        this.e = new byte[i4][];
        this.f = new int[i4 * 2];
        Segment segment2 = buffer.b;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.e;
            bArr[i7] = segment2.c;
            int i8 = segment2.e;
            int i9 = segment2.d;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            segment2.f = true;
            i7++;
            segment2 = segment2.h;
        }
    }

    private int a(int i) {
        int iBinarySearch = Arrays.binarySearch(this.f, 0, this.e.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    private ByteString b() {
        return new ByteString(toByteArray());
    }

    private Object writeReplace() {
        return b();
    }

    @Override // com.czhj.wire.okio.ByteString
    public void a(Buffer buffer) {
        int length = this.e.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            Segment segment = new Segment(this.e[i], i3, (i3 + i4) - i2, true, false);
            Segment segment2 = buffer.b;
            if (segment2 == null) {
                segment.i = segment;
                segment.h = segment;
                buffer.b = segment;
            } else {
                segment2.i.push(segment);
            }
            i++;
            i2 = i4;
        }
        buffer.c += (long) i2;
    }

    @Override // com.czhj.wire.okio.ByteString
    public byte[] a() {
        return toByteArray();
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.czhj.wire.okio.ByteString
    public String base64() {
        return b().base64();
    }

    @Override // com.czhj.wire.okio.ByteString
    public String base64Url() {
        return b().base64Url();
    }

    @Override // com.czhj.wire.okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.czhj.wire.okio.ByteString
    public byte getByte(int i) {
        Util.checkOffsetAndCount(this.f[this.e.length - 1], i, 1L);
        int iA = a(i);
        int i2 = iA == 0 ? 0 : this.f[iA - 1];
        int[] iArr = this.f;
        byte[][] bArr = this.e;
        return bArr[iA][(i - i2) + iArr[bArr.length + iA]];
    }

    @Override // com.czhj.wire.okio.ByteString
    public int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        int length = this.e.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.e[i2];
            int[] iArr = this.f;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.c = i3;
        return i3;
    }

    @Override // com.czhj.wire.okio.ByteString
    public String hex() {
        return b().hex();
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString hmacSha1(ByteString byteString) {
        return b().hmacSha1(byteString);
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString hmacSha256(ByteString byteString) {
        return b().hmacSha256(byteString);
    }

    @Override // com.czhj.wire.okio.ByteString
    public int indexOf(byte[] bArr, int i) {
        return b().indexOf(bArr, i);
    }

    @Override // com.czhj.wire.okio.ByteString
    public int lastIndexOf(byte[] bArr, int i) {
        return b().lastIndexOf(bArr, i);
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString md5() {
        return b().md5();
    }

    @Override // com.czhj.wire.okio.ByteString
    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int iA = a(i);
        while (i3 > 0) {
            int i4 = iA == 0 ? 0 : this.f[iA - 1];
            int iMin = Math.min(i3, ((this.f[iA] - i4) + i4) - i);
            int[] iArr = this.f;
            byte[][] bArr = this.e;
            if (!byteString.rangeEquals(i2, bArr[iA], (i - i4) + iArr[bArr.length + iA], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iA++;
        }
        return true;
    }

    @Override // com.czhj.wire.okio.ByteString
    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iA = a(i);
        while (i3 > 0) {
            int i4 = iA == 0 ? 0 : this.f[iA - 1];
            int iMin = Math.min(i3, ((this.f[iA] - i4) + i4) - i);
            int[] iArr = this.f;
            byte[][] bArr2 = this.e;
            if (!Util.arrayRangeEquals(bArr2[iA], (i - i4) + iArr[bArr2.length + iA], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iA++;
        }
        return true;
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString sha1() {
        return b().sha1();
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString sha256() {
        return b().sha256();
    }

    @Override // com.czhj.wire.okio.ByteString
    public int size() {
        return this.f[this.e.length - 1];
    }

    @Override // com.czhj.wire.okio.ByteString
    public String string(Charset charset) {
        return b().string(charset);
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString substring(int i) {
        return b().substring(i);
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString substring(int i, int i2) {
        return b().substring(i, i2);
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString toAsciiLowercase() {
        return b().toAsciiLowercase();
    }

    @Override // com.czhj.wire.okio.ByteString
    public ByteString toAsciiUppercase() {
        return b().toAsciiUppercase();
    }

    @Override // com.czhj.wire.okio.ByteString
    public byte[] toByteArray() {
        int[] iArr = this.f;
        byte[][] bArr = this.e;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.e[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.czhj.wire.okio.ByteString
    public String toString() {
        return b().toString();
    }

    @Override // com.czhj.wire.okio.ByteString
    public String utf8() {
        return b().utf8();
    }

    @Override // com.czhj.wire.okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.e.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            outputStream.write(this.e[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }
}
