package com.zj.adlib;

import androidx.annotation.IntRange;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class xs0 extends DecoderInputBuffer {
    public static final int S = 32;

    @VisibleForTesting
    public static final int T = 3072000;
    public int Q;
    public int R;
    public long b;

    public xs0() {
        super(2);
        this.R = 32;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer, com.google.android.exoplayer2.decoder.Buffer
    public void b() {
        super.b();
        this.Q = 0;
    }

    public boolean p(DecoderInputBuffer decoderInputBuffer) {
        sb0.a(!decoderInputBuffer.m());
        sb0.a(!decoderInputBuffer.d());
        sb0.a(!decoderInputBuffer.f());
        if (!q(decoderInputBuffer)) {
            return false;
        }
        int i = this.Q;
        this.Q = i + 1;
        if (i == 0) {
            ((DecoderInputBuffer) this).f30576a = decoderInputBuffer.f30576a;
            if (decoderInputBuffer.h()) {
                i(1);
            }
        }
        if (decoderInputBuffer.e()) {
            i(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = decoderInputBuffer.f2588a;
        if (byteBuffer != null) {
            k(byteBuffer.remaining());
            ((DecoderInputBuffer) this).f2588a.put(byteBuffer);
        }
        this.b = decoderInputBuffer.f30576a;
        return true;
    }

    public final boolean q(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (!u()) {
            return true;
        }
        if (this.Q >= this.R || decoderInputBuffer.e() != e()) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.f2588a;
        return byteBuffer2 == null || (byteBuffer = ((DecoderInputBuffer) this).f2588a) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    public long r() {
        return ((DecoderInputBuffer) this).f30576a;
    }

    public long s() {
        return this.b;
    }

    public int t() {
        return this.Q;
    }

    public boolean u() {
        return this.Q > 0;
    }

    public void v(@IntRange(from = 1) int i) {
        sb0.a(i > 0);
        this.R = i;
    }
}
