package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@CanIgnoreReturnValue
@Beta
@ElementTypesAreNonnullByDefault
public interface PrimitiveSink {
    PrimitiveSink a(CharSequence charSequence);

    PrimitiveSink b(boolean z);

    PrimitiveSink c(byte[] bArr);

    PrimitiveSink d(char c);

    PrimitiveSink e(CharSequence charSequence, Charset charset);

    PrimitiveSink f(double d);

    PrimitiveSink g(byte b);

    PrimitiveSink h(byte[] bArr, int i, int i2);

    PrimitiveSink i(long j);

    PrimitiveSink j(int i);

    PrimitiveSink k(ByteBuffer byteBuffer);

    PrimitiveSink l(float f);

    PrimitiveSink m(short s);
}
