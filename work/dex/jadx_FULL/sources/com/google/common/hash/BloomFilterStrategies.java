package com.google.common.hash;

import com.google.common.base.i;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(@ParametricNullness T t, Funnel<? super T> funnel, int i, a aVar) {
            long jB = aVar.b();
            long jAsLong = Hashing.w().hashObject(t, funnel).asLong();
            int i2 = (int) jAsLong;
            int i3 = (int) (jAsLong >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                if (!aVar.d(((long) i5) % jB)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(@ParametricNullness T t, Funnel<? super T> funnel, int i, a aVar) {
            long jB = aVar.b();
            long jAsLong = Hashing.w().hashObject(t, funnel).asLong();
            int i2 = (int) jAsLong;
            int i3 = (int) (jAsLong >>> 32);
            boolean zF = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                zF |= aVar.f(((long) i5) % jB);
            }
            return zF;
        }
    },
    MURMUR128_MITZ_64 { // from class: com.google.common.hash.BloomFilterStrategies.2
        private long lowerEight(byte[] bArr) {
            return Longs.j(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.j(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(@ParametricNullness T t, Funnel<? super T> funnel, int i, a aVar) {
            long jB = aVar.b();
            byte[] bytesInternal = Hashing.w().hashObject(t, funnel).getBytesInternal();
            long jLowerEight = lowerEight(bytesInternal);
            long jUpperEight = upperEight(bytesInternal);
            for (int i2 = 0; i2 < i; i2++) {
                if (!aVar.d((Long.MAX_VALUE & jLowerEight) % jB)) {
                    return false;
                }
                jLowerEight += jUpperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(@ParametricNullness T t, Funnel<? super T> funnel, int i, a aVar) {
            long jB = aVar.b();
            byte[] bytesInternal = Hashing.w().hashObject(t, funnel).getBytesInternal();
            long jLowerEight = lowerEight(bytesInternal);
            long jUpperEight = upperEight(bytesInternal);
            boolean zF = false;
            for (int i2 = 0; i2 < i; i2++) {
                zF |= aVar.f((Long.MAX_VALUE & jLowerEight) % jB);
                jLowerEight += jUpperEight;
            }
            return zF;
        }
    };

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f32122a = 6;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final LongAddable f6301a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AtomicLongArray f6302a;

        public a(long j) {
            i.e(j > 0, "data length is zero!");
            this.f6302a = new AtomicLongArray(Ints.d(LongMath.g(j, 64L, RoundingMode.CEILING)));
            this.f6301a = LongAddables.a();
        }

        public static long[] g(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = atomicLongArray.get(i);
            }
            return jArr;
        }

        public long a() {
            return this.f6301a.sum();
        }

        public long b() {
            return ((long) this.f6302a.length()) * 64;
        }

        public a c() {
            return new a(g(this.f6302a));
        }

        public boolean d(long j) {
            return ((1 << ((int) j)) & this.f6302a.get((int) (j >>> 6))) != 0;
        }

        public void e(a aVar) {
            long j;
            long j2;
            boolean z;
            i.m(this.f6302a.length() == aVar.f6302a.length(), "BitArrays must be of equal length (%s != %s)", this.f6302a.length(), aVar.f6302a.length());
            for (int i = 0; i < this.f6302a.length(); i++) {
                long j3 = aVar.f6302a.get(i);
                while (true) {
                    j = this.f6302a.get(i);
                    j2 = j | j3;
                    if (j != j2) {
                        if (this.f6302a.compareAndSet(i, j, j2)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    this.f6301a.add(Long.bitCount(j2) - Long.bitCount(j));
                }
            }
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof a) {
                return Arrays.equals(g(this.f6302a), g(((a) obj).f6302a));
            }
            return false;
        }

        public boolean f(long j) {
            long j2;
            long j3;
            if (d(j)) {
                return false;
            }
            int i = (int) (j >>> 6);
            long j4 = 1 << ((int) j);
            do {
                j2 = this.f6302a.get(i);
                j3 = j2 | j4;
                if (j2 == j3) {
                    return false;
                }
            } while (!this.f6302a.compareAndSet(i, j2, j3));
            this.f6301a.increment();
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(g(this.f6302a));
        }

        public a(long[] jArr) {
            i.e(jArr.length > 0, "data length is zero!");
            this.f6302a = new AtomicLongArray(jArr);
            this.f6301a = LongAddables.a();
            long jBitCount = 0;
            for (long j : jArr) {
                jBitCount += (long) Long.bitCount(j);
            }
            this.f6301a.add(jBitCount);
        }
    }
}
