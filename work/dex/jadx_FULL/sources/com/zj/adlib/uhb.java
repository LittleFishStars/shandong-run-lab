package com.zj.adlib;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class uhb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f45150a = Charset.forName("UTF-8");
    public static final /* synthetic */ boolean d = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f20066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f20067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharsetEncoder f20068a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20069a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f20070a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ByteBuffer f20071b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f20072b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int[] f20073b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f20074c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f20075d;
    public int e;
    public int f;

    public uhb() {
        this.b = 1;
        this.f20070a = null;
        this.c = 0;
        this.f20069a = false;
        this.f20072b = false;
        this.f20073b = new int[16];
        this.e = 0;
        this.f = 0;
        this.f20074c = false;
        this.f20068a = f45150a.newEncoder();
        this.f20066a = 1024;
        this.f20067a = B(1024);
    }

    public static ByteBuffer B(int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        return byteBufferAllocate;
    }

    public static ByteBuffer o(ByteBuffer byteBuffer) {
        int iCapacity = byteBuffer.capacity();
        if (((-1073741824) & iCapacity) != 0) {
            throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
        }
        int i = iCapacity << 1;
        byteBuffer.position(0);
        ByteBuffer byteBufferB = B(i);
        byteBufferB.position(i - iCapacity);
        byteBufferB.put(byteBuffer);
        return byteBufferB;
    }

    public final int A() {
        return this.f20067a.capacity() - this.f20066a;
    }

    public final byte[] C(int i, int i2) {
        D();
        byte[] bArr = new byte[i2];
        this.f20067a.position(i);
        this.f20067a.get(bArr);
        return bArr;
    }

    public final void D() {
        if (!this.f20072b) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public final void E(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer byteBuffer = this.f20067a;
            int i3 = this.f20066a - 1;
            this.f20066a = i3;
            byteBuffer.put(i3, (byte) 0);
        }
    }

    public final void F() {
        if (this.f20069a) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public final void G(int i) {
        ByteBuffer byteBuffer = this.f20067a;
        int i2 = this.f20066a - 4;
        this.f20066a = i2;
        byteBuffer.putInt(i2, i);
    }

    public final void H(int i) {
        x(4, 0);
        G(i);
    }

    public final void I(int i) {
        this.f20070a[i] = A();
    }

    public final int a() {
        if (!this.f20069a) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.f20069a = false;
        G(this.f);
        return A();
    }

    public int b(CharSequence charSequence) {
        int length = (int) (charSequence.length() * this.f20068a.maxBytesPerChar());
        ByteBuffer byteBuffer = this.f20071b;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            this.f20071b = ByteBuffer.allocate(Math.max(128, length));
        }
        this.f20071b.clear();
        CoderResult coderResultEncode = this.f20068a.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), this.f20071b, true);
        if (coderResultEncode.isError()) {
            try {
                coderResultEncode.throwException();
            } catch (CharacterCodingException e) {
                throw new Error(e);
            }
        }
        this.f20071b.flip();
        return v(this.f20071b);
    }

    public final uhb c(ByteBuffer byteBuffer) {
        this.f20067a = byteBuffer;
        byteBuffer.clear();
        this.f20067a.order(ByteOrder.LITTLE_ENDIAN);
        this.b = 1;
        this.f20066a = this.f20067a.capacity();
        this.c = 0;
        this.f20069a = false;
        this.f20072b = false;
        this.f20075d = 0;
        this.e = 0;
        this.f = 0;
        return this;
    }

    public final void d(byte b) {
        x(1, 0);
        p(b);
    }

    public final void e(int i) {
        x(4, 0);
        if (!d && i > A()) {
            throw new AssertionError();
        }
        G((A() - i) + 4);
    }

    public final void f(int i, byte b) {
        if (this.f20074c || b != 0) {
            d(b);
            I(i);
        }
    }

    public final void g(int i, int i2) {
        if (this.f20074c || i2 != 0) {
            H(i2);
            I(i);
        }
    }

    public final void h(int i, int i2, int i3) {
        F();
        this.f = i2;
        int i4 = i * i2;
        x(4, i4);
        x(i3, i4);
        this.f20069a = true;
    }

    public final void i(int i, long j) {
        if (this.f20074c || j != 0) {
            s(j);
            I(i);
        }
    }

    public final void j(int i, short s) {
        if (this.f20074c || s != 0) {
            t(s);
            I(i);
        }
    }

    public final void k(long j) {
        ByteBuffer byteBuffer = this.f20067a;
        int i = this.f20066a - 8;
        this.f20066a = i;
        byteBuffer.putLong(i, j);
    }

    public final void l(short s) {
        ByteBuffer byteBuffer = this.f20067a;
        int i = this.f20066a - 2;
        this.f20066a = i;
        byteBuffer.putShort(i, s);
    }

    public final void m(boolean z) {
        if (this.f20074c || z) {
            y(z);
            I(0);
        }
    }

    public final int n() {
        int i;
        if (this.f20070a == null || !this.f20069a) {
            throw new AssertionError("FlatBuffers: endObject called without startObject");
        }
        H(0);
        int iA = A();
        for (int i2 = this.c - 1; i2 >= 0; i2--) {
            int i3 = this.f20070a[i2];
            t((short) (i3 != 0 ? iA - i3 : 0));
        }
        t((short) (iA - this.f20075d));
        t((short) ((this.c + 2) * 2));
        int i4 = 0;
        loop1: while (true) {
            if (i4 >= this.e) {
                i = 0;
                break;
            }
            int iCapacity = this.f20067a.capacity() - this.f20073b[i4];
            int i5 = this.f20066a;
            short s = this.f20067a.getShort(iCapacity);
            if (s == this.f20067a.getShort(i5)) {
                int i6 = 2;
                while (true) {
                    if (i6 >= s) {
                        i = this.f20073b[i4];
                        break loop1;
                    }
                    if (this.f20067a.getShort(iCapacity + i6) != this.f20067a.getShort(i5 + i6)) {
                        break;
                    }
                    i6 += 2;
                }
            }
            i4++;
        }
        if (i != 0) {
            int iCapacity2 = this.f20067a.capacity() - iA;
            this.f20066a = iCapacity2;
            this.f20067a.putInt(iCapacity2, i - iA);
        } else {
            int i7 = this.e;
            int[] iArr = this.f20073b;
            if (i7 == iArr.length) {
                this.f20073b = Arrays.copyOf(iArr, i7 * 2);
            }
            int[] iArr2 = this.f20073b;
            int i8 = this.e;
            this.e = i8 + 1;
            iArr2[i8] = A();
            ByteBuffer byteBuffer = this.f20067a;
            byteBuffer.putInt(byteBuffer.capacity() - iA, A() - iA);
        }
        this.f20069a = false;
        return iA;
    }

    public final void p(byte b) {
        ByteBuffer byteBuffer = this.f20067a;
        int i = this.f20066a - 1;
        this.f20066a = i;
        byteBuffer.put(i, b);
    }

    public final void q(int i) {
        F();
        int[] iArr = this.f20070a;
        if (iArr == null || iArr.length < i) {
            this.f20070a = new int[i];
        }
        this.c = i;
        Arrays.fill(this.f20070a, 0, i, 0);
        this.f20069a = true;
        this.f20075d = A();
    }

    public final void r(int i, int i2) {
        if (this.f20074c || i2 != 0) {
            e(i2);
            I(i);
        }
    }

    public final void s(long j) {
        x(8, 0);
        k(j);
    }

    public final void t(short s) {
        x(2, 0);
        l(s);
    }

    public final void u(boolean z) {
        ByteBuffer byteBuffer = this.f20067a;
        int i = this.f20066a - 1;
        this.f20066a = i;
        byteBuffer.put(i, z ? (byte) 1 : (byte) 0);
    }

    public final int v(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        d((byte) 0);
        h(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.f20067a;
        int i = this.f20066a - iRemaining;
        this.f20066a = i;
        byteBuffer2.position(i);
        this.f20067a.put(byteBuffer);
        return a();
    }

    public final void w(int i) {
        x(this.b, 4);
        e(i);
        this.f20067a.position(this.f20066a);
        this.f20072b = true;
    }

    public final void x(int i, int i2) {
        if (i > this.b) {
            this.b = i;
        }
        int i3 = ((~((this.f20067a.capacity() - this.f20066a) + i2)) + 1) & (i - 1);
        while (this.f20066a < i3 + i + i2) {
            int iCapacity = this.f20067a.capacity();
            ByteBuffer byteBufferO = o(this.f20067a);
            this.f20067a = byteBufferO;
            this.f20066a += byteBufferO.capacity() - iCapacity;
        }
        E(i3);
    }

    public final void y(boolean z) {
        x(1, 0);
        u(z);
    }

    public final byte[] z() {
        return C(this.f20066a, this.f20067a.capacity() - this.f20066a);
    }

    public uhb(ByteBuffer byteBuffer) {
        this.b = 1;
        this.f20070a = null;
        this.c = 0;
        this.f20069a = false;
        this.f20072b = false;
        this.f20073b = new int[16];
        this.e = 0;
        this.f = 0;
        this.f20074c = false;
        this.f20068a = f45150a.newEncoder();
        c(byteBuffer);
    }
}
