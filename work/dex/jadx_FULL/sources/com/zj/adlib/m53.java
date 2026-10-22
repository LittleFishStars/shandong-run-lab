package com.zj.adlib;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class m53 extends SimpleMetadataDecoder {
    public EventMessage b(om6 om6Var) {
        return new EventMessage((String) sb0.g(om6Var.A()), (String) sb0.g(om6Var.A()), om6Var.z(), om6Var.z(), Arrays.copyOfRange(om6Var.d(), om6Var.e(), om6Var.f()));
    }

    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    public Metadata decode(xn5 xn5Var, ByteBuffer byteBuffer) {
        return new Metadata(b(new om6(byteBuffer.array(), byteBuffer.limit())));
    }
}
