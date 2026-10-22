package com.google.common.hash;

import com.google.common.base.i;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;
    private final int c;
    private final int d;
    private final long k0;
    private final long k1;

    public static final class a extends AbstractStreamingHasher {
        public static final int e = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f32137a;
        public long b;
        public final int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public long f6311c;
        public final int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public long f6312d;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public long f6313e;
        public long f;

        public a(int i, int i2, long j, long j2) {
            super(8);
            this.f6313e = 0L;
            this.f = 0L;
            this.c = i;
            this.d = i2;
            this.f32137a = 8317987319222330741L ^ j;
            this.b = 7237128888997146477L ^ j2;
            this.f6311c = 7816392313619706465L ^ j;
            this.f6312d = 8387220255154660723L ^ j2;
        }

        public final void F(long j) {
            this.f6312d ^= j;
            G(this.c);
            this.f32137a = j ^ this.f32137a;
        }

        public final void G(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.f32137a;
                long j2 = this.b;
                this.f32137a = j + j2;
                this.f6311c += this.f6312d;
                this.b = Long.rotateLeft(j2, 13);
                long jRotateLeft = Long.rotateLeft(this.f6312d, 16);
                long j3 = this.b;
                long j4 = this.f32137a;
                this.b = j3 ^ j4;
                this.f6312d = jRotateLeft ^ this.f6311c;
                long jRotateLeft2 = Long.rotateLeft(j4, 32);
                long j5 = this.f6311c;
                long j6 = this.b;
                this.f6311c = j5 + j6;
                this.f32137a = jRotateLeft2 + this.f6312d;
                this.b = Long.rotateLeft(j6, 17);
                long jRotateLeft3 = Long.rotateLeft(this.f6312d, 21);
                long j7 = this.b;
                long j8 = this.f6311c;
                this.b = j7 ^ j8;
                this.f6312d = jRotateLeft3 ^ this.f32137a;
                this.f6311c = Long.rotateLeft(j8, 32);
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long j = this.f ^ (this.f6313e << 56);
            this.f = j;
            F(j);
            this.f6311c ^= 255;
            G(this.d);
            return HashCode.fromLong(((this.f32137a ^ this.b) ^ this.f6311c) ^ this.f6312d);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void process(ByteBuffer byteBuffer) {
            this.f6313e += 8;
            F(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void processRemaining(ByteBuffer byteBuffer) {
            this.f6313e += (long) byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.f ^= (((long) byteBuffer.get()) & 255) << i;
                i += 8;
            }
        }
    }

    public SipHashFunction(int i, int i2, long j, long j2) {
        i.k(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        i.k(i2 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.c = i;
        this.d = i2;
        this.k0 = j;
        this.k1 = j2;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        return this.c == sipHashFunction.c && this.d == sipHashFunction.d && this.k0 == sipHashFunction.k0 && this.k1 == sipHashFunction.k1;
    }

    public int hashCode() {
        return (int) ((((long) ((SipHashFunction.class.hashCode() ^ this.c) ^ this.d)) ^ this.k0) ^ this.k1);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new a(this.c, this.d, this.k0, this.k1);
    }

    public String toString() {
        int i = this.c;
        int i2 = this.d;
        long j = this.k0;
        long j2 = this.k1;
        StringBuilder sb = new StringBuilder(81);
        sb.append("Hashing.sipHash");
        sb.append(i);
        sb.append(i2);
        sb.append("(");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(")");
        return sb.toString();
    }
}
