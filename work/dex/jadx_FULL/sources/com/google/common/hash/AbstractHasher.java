package com.google.common.hash;

import com.google.common.base.i;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@CanIgnoreReturnValue
@ElementTypesAreNonnullByDefault
abstract class AbstractHasher implements Hasher {
    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: A */
    public Hasher m(short s) {
        g((byte) s);
        g((byte) (s >>> 8));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: B */
    public Hasher a(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            d(charSequence.charAt(i));
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: n */
    public final Hasher b(boolean z) {
        return g(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.common.hash.Hasher
    public <T> Hasher o(@ParametricNullness T t, Funnel<? super T> funnel) {
        funnel.funnel(t, this);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: q */
    public Hasher h(byte[] bArr, int i, int i2) {
        i.f0(i, i + i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            g(bArr[i + i3]);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: s */
    public Hasher d(char c) {
        g((byte) c);
        g((byte) (c >>> '\b'));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: t */
    public Hasher c(byte[] bArr) {
        return h(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: u */
    public Hasher i(long j) {
        for (int i = 0; i < 64; i += 8) {
            g((byte) (j >>> i));
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: v */
    public final Hasher f(double d) {
        return i(Double.doubleToRawLongBits(d));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: w */
    public final Hasher l(float f) {
        return j(Float.floatToRawIntBits(f));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: x */
    public Hasher j(int i) {
        g((byte) i);
        g((byte) (i >>> 8));
        g((byte) (i >>> 16));
        g((byte) (i >>> 24));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: y */
    public Hasher k(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            h(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            e.d(byteBuffer, byteBuffer.limit());
        } else {
            for (int iRemaining = byteBuffer.remaining(); iRemaining > 0; iRemaining--) {
                g(byteBuffer.get());
            }
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: z */
    public Hasher e(CharSequence charSequence, Charset charset) {
        return c(charSequence.toString().getBytes(charset));
    }
}
