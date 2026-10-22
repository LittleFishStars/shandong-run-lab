package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;
    static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    static final HashFunction GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.f32125a);

    public static final class a extends AbstractStreamingHasher {
        public static final long c = -8663945395140668459L;
        public static final int d = 16;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public static final long f6307d = 5545529020109919103L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f32135a;
        public long b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public int f6308c;

        public a(int i) {
            super(16);
            long j = i;
            this.f32135a = j;
            this.b = j;
            this.f6308c = 0;
        }

        public static long G(long j) {
            long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
            long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
            return j3 ^ (j3 >>> 33);
        }

        public static long H(long j) {
            return Long.rotateLeft(j * c, 31) * f6307d;
        }

        public static long I(long j) {
            return Long.rotateLeft(j * f6307d, 33) * c;
        }

        public final void F(long j, long j2) {
            long jH = H(j) ^ this.f32135a;
            this.f32135a = jH;
            long jRotateLeft = Long.rotateLeft(jH, 27);
            long j3 = this.b;
            this.f32135a = ((jRotateLeft + j3) * 5) + 1390208809;
            long jI = I(j2) ^ j3;
            this.b = jI;
            this.b = ((Long.rotateLeft(jI, 31) + this.f32135a) * 5) + 944331445;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long j = this.f32135a;
            int i = this.f6308c;
            long j2 = j ^ ((long) i);
            long j3 = this.b ^ ((long) i);
            long j4 = j2 + j3;
            this.f32135a = j4;
            this.b = j3 + j4;
            this.f32135a = G(j4);
            long jG = G(this.b);
            long j5 = this.f32135a + jG;
            this.f32135a = j5;
            this.b = jG + j5;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f32135a).putLong(this.b).array());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void process(ByteBuffer byteBuffer) {
            F(byteBuffer.getLong(), byteBuffer.getLong());
            this.f6308c += 16;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void processRemaining(ByteBuffer byteBuffer) {
            long jP;
            long jP2;
            long jP3;
            long jP4;
            long jP5;
            long jP6;
            long jP7;
            long jP8;
            long jP9;
            long jP10;
            long jP11;
            long jP12;
            long jP13;
            long jP14;
            this.f6308c += byteBuffer.remaining();
            long j = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    jP = 0;
                    jP7 = ((long) UnsignedBytes.p(byteBuffer.get(0))) ^ jP;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                case 2:
                    jP2 = 0;
                    jP = jP2 ^ (((long) UnsignedBytes.p(byteBuffer.get(1))) << 8);
                    jP7 = ((long) UnsignedBytes.p(byteBuffer.get(0))) ^ jP;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                case 3:
                    jP3 = 0;
                    jP2 = jP3 ^ (((long) UnsignedBytes.p(byteBuffer.get(2))) << 16);
                    jP = jP2 ^ (((long) UnsignedBytes.p(byteBuffer.get(1))) << 8);
                    jP7 = ((long) UnsignedBytes.p(byteBuffer.get(0))) ^ jP;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                case 4:
                    jP4 = 0;
                    jP3 = jP4 ^ (((long) UnsignedBytes.p(byteBuffer.get(3))) << 24);
                    jP2 = jP3 ^ (((long) UnsignedBytes.p(byteBuffer.get(2))) << 16);
                    jP = jP2 ^ (((long) UnsignedBytes.p(byteBuffer.get(1))) << 8);
                    jP7 = ((long) UnsignedBytes.p(byteBuffer.get(0))) ^ jP;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                case 5:
                    jP5 = 0;
                    jP4 = jP5 ^ (((long) UnsignedBytes.p(byteBuffer.get(4))) << 32);
                    jP3 = jP4 ^ (((long) UnsignedBytes.p(byteBuffer.get(3))) << 24);
                    jP2 = jP3 ^ (((long) UnsignedBytes.p(byteBuffer.get(2))) << 16);
                    jP = jP2 ^ (((long) UnsignedBytes.p(byteBuffer.get(1))) << 8);
                    jP7 = ((long) UnsignedBytes.p(byteBuffer.get(0))) ^ jP;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                case 6:
                    jP6 = 0;
                    jP5 = jP6 ^ (((long) UnsignedBytes.p(byteBuffer.get(5))) << 40);
                    jP4 = jP5 ^ (((long) UnsignedBytes.p(byteBuffer.get(4))) << 32);
                    jP3 = jP4 ^ (((long) UnsignedBytes.p(byteBuffer.get(3))) << 24);
                    jP2 = jP3 ^ (((long) UnsignedBytes.p(byteBuffer.get(2))) << 16);
                    jP = jP2 ^ (((long) UnsignedBytes.p(byteBuffer.get(1))) << 8);
                    jP7 = ((long) UnsignedBytes.p(byteBuffer.get(0))) ^ jP;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                case 7:
                    jP6 = (((long) UnsignedBytes.p(byteBuffer.get(6))) << 48) ^ 0;
                    jP5 = jP6 ^ (((long) UnsignedBytes.p(byteBuffer.get(5))) << 40);
                    jP4 = jP5 ^ (((long) UnsignedBytes.p(byteBuffer.get(4))) << 32);
                    jP3 = jP4 ^ (((long) UnsignedBytes.p(byteBuffer.get(3))) << 24);
                    jP2 = jP3 ^ (((long) UnsignedBytes.p(byteBuffer.get(2))) << 16);
                    jP = jP2 ^ (((long) UnsignedBytes.p(byteBuffer.get(1))) << 8);
                    jP7 = ((long) UnsignedBytes.p(byteBuffer.get(0))) ^ jP;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                case 8:
                    jP8 = 0;
                    jP7 = byteBuffer.getLong() ^ 0;
                    j = jP8;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                case 9:
                    jP9 = 0;
                    jP8 = jP9 ^ ((long) UnsignedBytes.p(byteBuffer.get(8)));
                    jP7 = byteBuffer.getLong() ^ 0;
                    j = jP8;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                case 10:
                    jP10 = 0;
                    jP9 = jP10 ^ (((long) UnsignedBytes.p(byteBuffer.get(9))) << 8);
                    jP8 = jP9 ^ ((long) UnsignedBytes.p(byteBuffer.get(8)));
                    jP7 = byteBuffer.getLong() ^ 0;
                    j = jP8;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                case 11:
                    jP11 = 0;
                    jP10 = jP11 ^ (((long) UnsignedBytes.p(byteBuffer.get(10))) << 16);
                    jP9 = jP10 ^ (((long) UnsignedBytes.p(byteBuffer.get(9))) << 8);
                    jP8 = jP9 ^ ((long) UnsignedBytes.p(byteBuffer.get(8)));
                    jP7 = byteBuffer.getLong() ^ 0;
                    j = jP8;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                case 12:
                    jP12 = 0;
                    jP11 = jP12 ^ (((long) UnsignedBytes.p(byteBuffer.get(11))) << 24);
                    jP10 = jP11 ^ (((long) UnsignedBytes.p(byteBuffer.get(10))) << 16);
                    jP9 = jP10 ^ (((long) UnsignedBytes.p(byteBuffer.get(9))) << 8);
                    jP8 = jP9 ^ ((long) UnsignedBytes.p(byteBuffer.get(8)));
                    jP7 = byteBuffer.getLong() ^ 0;
                    j = jP8;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                case 13:
                    jP13 = 0;
                    jP12 = jP13 ^ (((long) UnsignedBytes.p(byteBuffer.get(12))) << 32);
                    jP11 = jP12 ^ (((long) UnsignedBytes.p(byteBuffer.get(11))) << 24);
                    jP10 = jP11 ^ (((long) UnsignedBytes.p(byteBuffer.get(10))) << 16);
                    jP9 = jP10 ^ (((long) UnsignedBytes.p(byteBuffer.get(9))) << 8);
                    jP8 = jP9 ^ ((long) UnsignedBytes.p(byteBuffer.get(8)));
                    jP7 = byteBuffer.getLong() ^ 0;
                    j = jP8;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                case 14:
                    jP14 = 0;
                    jP13 = jP14 ^ (((long) UnsignedBytes.p(byteBuffer.get(13))) << 40);
                    jP12 = jP13 ^ (((long) UnsignedBytes.p(byteBuffer.get(12))) << 32);
                    jP11 = jP12 ^ (((long) UnsignedBytes.p(byteBuffer.get(11))) << 24);
                    jP10 = jP11 ^ (((long) UnsignedBytes.p(byteBuffer.get(10))) << 16);
                    jP9 = jP10 ^ (((long) UnsignedBytes.p(byteBuffer.get(9))) << 8);
                    jP8 = jP9 ^ ((long) UnsignedBytes.p(byteBuffer.get(8)));
                    jP7 = byteBuffer.getLong() ^ 0;
                    j = jP8;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                case 15:
                    jP14 = (((long) UnsignedBytes.p(byteBuffer.get(14))) << 48) ^ 0;
                    jP13 = jP14 ^ (((long) UnsignedBytes.p(byteBuffer.get(13))) << 40);
                    jP12 = jP13 ^ (((long) UnsignedBytes.p(byteBuffer.get(12))) << 32);
                    jP11 = jP12 ^ (((long) UnsignedBytes.p(byteBuffer.get(11))) << 24);
                    jP10 = jP11 ^ (((long) UnsignedBytes.p(byteBuffer.get(10))) << 16);
                    jP9 = jP10 ^ (((long) UnsignedBytes.p(byteBuffer.get(9))) << 8);
                    jP8 = jP9 ^ ((long) UnsignedBytes.p(byteBuffer.get(8)));
                    jP7 = byteBuffer.getLong() ^ 0;
                    j = jP8;
                    this.f32135a ^= H(jP7);
                    this.b ^= I(j);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }
    }

    public Murmur3_128HashFunction(int i) {
        this.seed = i;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 128;
    }

    public boolean equals(@CheckForNull Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        int i = this.seed;
        StringBuilder sb = new StringBuilder(32);
        sb.append("Hashing.murmur3_128(");
        sb.append(i);
        sb.append(")");
        return sb.toString();
    }
}
