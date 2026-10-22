package com.google.common.hash;

import com.google.common.base.i;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@CanIgnoreReturnValue
@ElementTypesAreNonnullByDefault
abstract class AbstractByteHasher extends AbstractHasher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f32117a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: A */
    public Hasher m(short s) {
        this.f32117a.putShort(s);
        return update(2);
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: q */
    public Hasher h(byte[] bArr, int i, int i2) {
        i.f0(i, i + i2, bArr.length);
        update(bArr, i, i2);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: r */
    public Hasher g(byte b) {
        update(b);
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: s */
    public Hasher d(char c) {
        this.f32117a.putChar(c);
        return update(2);
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: t */
    public Hasher c(byte[] bArr) {
        i.E(bArr);
        update(bArr);
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: u */
    public Hasher i(long j) {
        this.f32117a.putLong(j);
        return update(8);
    }

    public abstract void update(byte b);

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: x */
    public Hasher j(int i) {
        this.f32117a.putInt(i);
        return update(4);
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: y */
    public Hasher k(ByteBuffer byteBuffer) {
        update(byteBuffer);
        return this;
    }

    public void update(byte[] bArr, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            update(bArr[i3]);
        }
    }

    public void update(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            update(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            e.d(byteBuffer, byteBuffer.limit());
        } else {
            for (int iRemaining = byteBuffer.remaining(); iRemaining > 0; iRemaining--) {
                update(byteBuffer.get());
            }
        }
    }

    private Hasher update(int i) {
        try {
            update(this.f32117a.array(), 0, i);
            return this;
        } finally {
            e.a(this.f32117a);
        }
    }
}
