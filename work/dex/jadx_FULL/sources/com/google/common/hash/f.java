package com.google.common.hash;

import com.google.common.base.i;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public final class f extends AbstractHashFunction {
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Key f32144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Mac f6318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f6319a;
    public final String f;

    public static final class b extends AbstractByteHasher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Mac f32145a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f6320a;

        public final void C() {
            i.h0(!this.f6320a, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.Hasher
        public HashCode p() {
            C();
            this.f6320a = true;
            return HashCode.fromBytesNoCopy(this.f32145a.doFinal());
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte b) {
            C();
            this.f32145a.update(b);
        }

        public b(Mac mac) {
            this.f32145a = mac;
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte[] bArr) {
            C();
            this.f32145a.update(bArr);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte[] bArr, int i, int i2) {
            C();
            this.f32145a.update(bArr, i, i2);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(ByteBuffer byteBuffer) {
            C();
            i.E(byteBuffer);
            this.f32145a.update(byteBuffer);
        }
    }

    public f(String str, Key key, String str2) {
        Mac macA = a(str, key);
        this.f6318a = macA;
        this.f32144a = (Key) i.E(key);
        this.f = (String) i.E(str2);
        this.K = macA.getMacLength() * 8;
        this.f6319a = b(macA);
    }

    public static Mac a(String str, Key key) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(key);
            return mac;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static boolean b(Mac mac) {
        try {
            mac.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.K;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        if (this.f6319a) {
            try {
                return new b((Mac) this.f6318a.clone());
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new b(a(this.f6318a.getAlgorithm(), this.f32144a));
    }

    public String toString() {
        return this.f;
    }
}
