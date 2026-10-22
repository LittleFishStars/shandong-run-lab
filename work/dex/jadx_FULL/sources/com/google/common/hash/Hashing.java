package com.google.common.hash;

import com.aliyun.openapiutil.Client;
import com.google.common.annotations.Beta;
import com.google.common.base.i;
import com.google.errorprone.annotations.Immutable;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.annotation.CheckForNull;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public final class Hashing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32125a = (int) System.currentTimeMillis();

    @Immutable
    public enum ChecksumType implements ImmutableSupplier<Checksum> {
        CRC_32("Hashing.crc32()") { // from class: com.google.common.hash.Hashing.ChecksumType.1
            @Override // com.google.common.base.Supplier
            public Checksum get() {
                return new CRC32();
            }
        },
        ADLER_32("Hashing.adler32()") { // from class: com.google.common.hash.Hashing.ChecksumType.2
            @Override // com.google.common.base.Supplier
            public Checksum get() {
                return new Adler32();
            }
        };

        public final HashFunction hashFunction;

        ChecksumType(String str) {
            this.hashFunction = new ChecksumHashFunction(this, 32, str);
        }
    }

    public static final class b extends AbstractCompositeHashFunction {
        @Override // com.google.common.hash.AbstractCompositeHashFunction
        public HashCode b(Hasher[] hasherArr) {
            byte[] bArr = new byte[bits() / 8];
            int iWriteBytesTo = 0;
            for (Hasher hasher : hasherArr) {
                HashCode hashCodeP = hasher.p();
                iWriteBytesTo += hashCodeP.writeBytesTo(bArr, iWriteBytesTo, hashCodeP.bits() / 8);
            }
            return HashCode.fromBytesNoCopy(bArr);
        }

        @Override // com.google.common.hash.HashFunction
        public int bits() {
            int iBits = 0;
            for (HashFunction hashFunction : this.f6297a) {
                iBits += hashFunction.bits();
            }
            return iBits;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof b) {
                return Arrays.equals(this.f6297a, ((b) obj).f6297a);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f6297a);
        }

        public b(HashFunction... hashFunctionArr) {
            super(hashFunctionArr);
            for (HashFunction hashFunction : hashFunctionArr) {
                i.o(hashFunction.bits() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", hashFunction.bits(), hashFunction);
            }
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f32126a;

        public c(long j) {
            this.f32126a = j;
        }

        public double a() {
            long j = (this.f32126a * 2862933555777941757L) + 1;
            this.f32126a = j;
            return ((double) (((int) (j >>> 33)) + 1)) / 2.147483648E9d;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashFunction f32127a = new MessageDigestHashFunction("MD5", "Hashing.md5()");
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashFunction f32128a = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashFunction f32129a = new MessageDigestHashFunction(Client.HASH_SHA256, "Hashing.sha256()");
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashFunction f32130a = new MessageDigestHashFunction("SHA-384", "Hashing.sha384()");
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashFunction f32131a = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
    }

    public static HashFunction A() {
        return Murmur3_32HashFunction.MURMUR3_32_FIXED;
    }

    public static HashFunction B(int i) {
        return new Murmur3_32HashFunction(i, true);
    }

    @Deprecated
    public static HashFunction C() {
        return e.f32128a;
    }

    public static HashFunction D() {
        return f.f32129a;
    }

    public static HashFunction E() {
        return g.f32130a;
    }

    public static HashFunction F() {
        return h.f32131a;
    }

    public static HashFunction G() {
        return SipHashFunction.SIP_HASH_24;
    }

    public static HashFunction H(long j, long j2) {
        return new SipHashFunction(2, 4, j, j2);
    }

    public static HashFunction a() {
        return ChecksumType.ADLER_32.hashFunction;
    }

    public static int b(int i) {
        i.e(i > 0, "Number of bits must be positive");
        return (i + 31) & (-32);
    }

    public static HashCode c(Iterable<HashCode> iterable) {
        Iterator<HashCode> it = iterable.iterator();
        i.e(it.hasNext(), "Must be at least 1 hash code to combine.");
        int iBits = it.next().bits() / 8;
        byte[] bArr = new byte[iBits];
        Iterator<HashCode> it2 = iterable.iterator();
        while (it2.hasNext()) {
            byte[] bArrAsBytes = it2.next().asBytes();
            i.e(bArrAsBytes.length == iBits, "All hashcodes must have the same bit length.");
            for (int i = 0; i < bArrAsBytes.length; i++) {
                bArr[i] = (byte) ((bArr[i] * com.google.android.exoplayer2.text.cea.a.g) ^ bArrAsBytes[i]);
            }
        }
        return HashCode.fromBytesNoCopy(bArr);
    }

    public static HashCode d(Iterable<HashCode> iterable) {
        Iterator<HashCode> it = iterable.iterator();
        i.e(it.hasNext(), "Must be at least 1 hash code to combine.");
        int iBits = it.next().bits() / 8;
        byte[] bArr = new byte[iBits];
        Iterator<HashCode> it2 = iterable.iterator();
        while (it2.hasNext()) {
            byte[] bArrAsBytes = it2.next().asBytes();
            i.e(bArrAsBytes.length == iBits, "All hashcodes must have the same bit length.");
            for (int i = 0; i < bArrAsBytes.length; i++) {
                bArr[i] = (byte) (bArr[i] + bArrAsBytes[i]);
            }
        }
        return HashCode.fromBytesNoCopy(bArr);
    }

    public static HashFunction e(HashFunction hashFunction, HashFunction hashFunction2, HashFunction... hashFunctionArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(hashFunction);
        arrayList.add(hashFunction2);
        arrayList.addAll(Arrays.asList(hashFunctionArr));
        return new b((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }

    public static HashFunction f(Iterable<HashFunction> iterable) {
        i.E(iterable);
        ArrayList arrayList = new ArrayList();
        Iterator<HashFunction> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        i.k(arrayList.size() > 0, "number of hash functions (%s) must be > 0", arrayList.size());
        return new b((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }

    public static int g(long j, int i) {
        int i2 = 0;
        i.k(i > 0, "buckets must be positive: %s", i);
        c cVar = new c(j);
        while (true) {
            int iA = (int) (((double) (i2 + 1)) / cVar.a());
            if (iA < 0 || iA >= i) {
                break;
            }
            i2 = iA;
        }
        return i2;
    }

    public static int h(HashCode hashCode, int i) {
        return g(hashCode.padToLong(), i);
    }

    public static HashFunction i() {
        return ChecksumType.CRC_32.hashFunction;
    }

    public static HashFunction j() {
        return com.google.common.hash.a.f32139a;
    }

    public static HashFunction k() {
        return com.google.common.hash.b.f6317a;
    }

    public static HashFunction l(int i) {
        int iB = b(i);
        if (iB == 32) {
            return Murmur3_32HashFunction.GOOD_FAST_HASH_32;
        }
        if (iB <= 128) {
            return Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        }
        int i2 = (iB + 127) / 128;
        HashFunction[] hashFunctionArr = new HashFunction[i2];
        hashFunctionArr[0] = Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        int i3 = f32125a;
        for (int i4 = 1; i4 < i2; i4++) {
            i3 += 1500450271;
            hashFunctionArr[i4] = x(i3);
        }
        return new b(hashFunctionArr);
    }

    public static HashFunction m(Key key) {
        return new com.google.common.hash.f("HmacMD5", key, u("hmacMd5", key));
    }

    public static HashFunction n(byte[] bArr) {
        return m(new SecretKeySpec((byte[]) i.E(bArr), "HmacMD5"));
    }

    public static HashFunction o(Key key) {
        return new com.google.common.hash.f("HmacSHA1", key, u("hmacSha1", key));
    }

    public static HashFunction p(byte[] bArr) {
        return o(new SecretKeySpec((byte[]) i.E(bArr), "HmacSHA1"));
    }

    public static HashFunction q(Key key) {
        return new com.google.common.hash.f("HmacSHA256", key, u("hmacSha256", key));
    }

    public static HashFunction r(byte[] bArr) {
        return q(new SecretKeySpec((byte[]) i.E(bArr), "HmacSHA256"));
    }

    public static HashFunction s(Key key) {
        return new com.google.common.hash.f("HmacSHA512", key, u("hmacSha512", key));
    }

    public static HashFunction t(byte[] bArr) {
        return s(new SecretKeySpec((byte[]) i.E(bArr), "HmacSHA512"));
    }

    public static String u(String str, Key key) {
        return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", str, key.getAlgorithm(), key.getFormat());
    }

    @Deprecated
    public static HashFunction v() {
        return d.f32127a;
    }

    public static HashFunction w() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }

    public static HashFunction x(int i) {
        return new Murmur3_128HashFunction(i);
    }

    @Deprecated
    public static HashFunction y() {
        return Murmur3_32HashFunction.MURMUR3_32;
    }

    @Deprecated
    public static HashFunction z(int i) {
        return new Murmur3_32HashFunction(i, false);
    }
}
