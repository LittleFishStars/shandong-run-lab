package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@CanIgnoreReturnValue
@Beta
@ElementTypesAreNonnullByDefault
public interface Hasher extends PrimitiveSink {
    @Override // com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    Hasher m(short s);

    @Override // com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    Hasher a(CharSequence charSequence);

    @Deprecated
    int hashCode();

    @Override // com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    Hasher b(boolean z);

    <T> Hasher o(@ParametricNullness T t, Funnel<? super T> funnel);

    HashCode p();

    @Override // com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    Hasher h(byte[] bArr, int i, int i2);

    @Override // com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    Hasher g(byte b);

    @Override // com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    Hasher d(char c);

    @Override // com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    Hasher c(byte[] bArr);

    @Override // com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    Hasher i(long j);

    @Override // com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    Hasher f(double d);

    @Override // com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    Hasher l(float f);

    @Override // com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    Hasher j(int i);

    @Override // com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    Hasher k(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.PrimitiveSink
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    Hasher e(CharSequence charSequence, Charset charset);
}
