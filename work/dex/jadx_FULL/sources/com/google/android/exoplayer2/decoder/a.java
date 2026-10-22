package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a extends DecoderOutputBuffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DecoderOutputBuffer.Owner<a> f30581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ByteBuffer f2603a;

    public a(DecoderOutputBuffer.Owner<a> owner) {
        this.f30581a = owner;
    }

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void b() {
        super.b();
        ByteBuffer byteBuffer = this.f2603a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderOutputBuffer
    public void j() {
        this.f30581a.a(this);
    }

    public ByteBuffer k(long j, int i) {
        ((DecoderOutputBuffer) this).f30577a = j;
        ByteBuffer byteBuffer = this.f2603a;
        if (byteBuffer == null || byteBuffer.capacity() < i) {
            this.f2603a = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        }
        this.f2603a.position(0);
        this.f2603a.limit(i);
        return this.f2603a;
    }
}
