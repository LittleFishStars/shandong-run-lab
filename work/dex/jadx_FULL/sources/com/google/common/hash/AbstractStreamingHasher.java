package com.google.common.hash;

import com.google.common.base.i;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@CanIgnoreReturnValue
@ElementTypesAreNonnullByDefault
abstract class AbstractStreamingHasher extends AbstractHasher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ByteBuffer f6300a;
    public final int b;

    public AbstractStreamingHasher(int i) {
        this(i, i);
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: A */
    public final Hasher m(short s) {
        this.f6300a.putShort(s);
        D();
        return this;
    }

    public final void C() {
        e.b(this.f6300a);
        while (this.f6300a.remaining() >= this.b) {
            process(this.f6300a);
        }
        this.f6300a.compact();
    }

    public final void D() {
        if (this.f6300a.remaining() < 8) {
            C();
        }
    }

    public final Hasher E(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f6300a.remaining()) {
            this.f6300a.put(byteBuffer);
            D();
            return this;
        }
        int iPosition = this.f32121a - this.f6300a.position();
        for (int i = 0; i < iPosition; i++) {
            this.f6300a.put(byteBuffer.get());
        }
        C();
        while (byteBuffer.remaining() >= this.b) {
            process(byteBuffer);
        }
        this.f6300a.put(byteBuffer);
        return this;
    }

    public abstract HashCode makeHash();

    @Override // com.google.common.hash.Hasher
    public final HashCode p() {
        C();
        e.b(this.f6300a);
        if (this.f6300a.remaining() > 0) {
            processRemaining(this.f6300a);
            ByteBuffer byteBuffer = this.f6300a;
            e.d(byteBuffer, byteBuffer.limit());
        }
        return makeHash();
    }

    public abstract void process(ByteBuffer byteBuffer);

    public void processRemaining(ByteBuffer byteBuffer) {
        e.d(byteBuffer, byteBuffer.limit());
        e.c(byteBuffer, this.b + 7);
        while (true) {
            int iPosition = byteBuffer.position();
            int i = this.b;
            if (iPosition >= i) {
                e.c(byteBuffer, i);
                e.b(byteBuffer);
                process(byteBuffer);
                return;
            }
            byteBuffer.putLong(0L);
        }
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: q */
    public final Hasher h(byte[] bArr, int i, int i2) {
        return E(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: r */
    public final Hasher g(byte b) {
        this.f6300a.put(b);
        D();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: s */
    public final Hasher d(char c) {
        this.f6300a.putChar(c);
        D();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: u */
    public final Hasher i(long j) {
        this.f6300a.putLong(j);
        D();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: x */
    public final Hasher j(int i) {
        this.f6300a.putInt(i);
        D();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: y */
    public final Hasher k(ByteBuffer byteBuffer) {
        ByteOrder byteOrderOrder = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return E(byteBuffer);
        } finally {
            byteBuffer.order(byteOrderOrder);
        }
    }

    public AbstractStreamingHasher(int i, int i2) {
        i.d(i2 % i == 0);
        this.f6300a = ByteBuffer.allocate(i2 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f32121a = i2;
        this.b = i;
    }
}
