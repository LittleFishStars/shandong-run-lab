package com.google.common.hash;

import com.google.common.base.i;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Immutable
@ElementTypesAreNonnullByDefault
abstract class AbstractHashFunction implements HashFunction {
    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr) {
        return hashBytes(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashInt(int i) {
        return newHasher(4).j(i).p();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashLong(long j) {
        return newHasher(8).i(j).p();
    }

    @Override // com.google.common.hash.HashFunction
    public <T> HashCode hashObject(@ParametricNullness T t, Funnel<? super T> funnel) {
        return newHasher().o(t, funnel).p();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return newHasher().e(charSequence, charset).p();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        return newHasher(charSequence.length() * 2).a(charSequence).p();
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher(int i) {
        i.k(i >= 0, "expectedInputSize must be >= 0 but was %s", i);
        return newHasher();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        i.f0(i, i + i2, bArr.length);
        return newHasher(i2).h(bArr, i, i2).p();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).k(byteBuffer).p();
    }
}
