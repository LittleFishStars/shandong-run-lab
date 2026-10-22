package com.google.android.exoplayer2.metadata;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.zj.adlib.sb0;
import com.zj.adlib.xn5;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class SimpleMetadataDecoder implements MetadataDecoder {
    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    @Nullable
    public final Metadata a(xn5 xn5Var) {
        ByteBuffer byteBuffer = (ByteBuffer) sb0.g(((DecoderInputBuffer) xn5Var).f2588a);
        sb0.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (xn5Var.e()) {
            return null;
        }
        return decode(xn5Var, byteBuffer);
    }

    @Nullable
    public abstract Metadata decode(xn5 xn5Var, ByteBuffer byteBuffer);
}
