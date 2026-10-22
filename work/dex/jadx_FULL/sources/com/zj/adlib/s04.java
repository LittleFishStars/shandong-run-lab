package com.zj.adlib;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.SampleQueueMappingException;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class s04 implements SampleStream {
    public final int K;
    public int L = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HlsSampleStreamWrapper f44577a;

    public s04(HlsSampleStreamWrapper hlsSampleStreamWrapper, int i) {
        this.f44577a = hlsSampleStreamWrapper;
        this.K = i;
    }

    public void a() {
        sb0.a(this.L == -1);
        this.L = this.f44577a.k(this.K);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int b(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i) {
        if (this.L == -3) {
            decoderInputBuffer.a(4);
            return -4;
        }
        if (c()) {
            return this.f44577a.U(this.L, yk3Var, decoderInputBuffer, i);
        }
        return -3;
    }

    public final boolean c() {
        int i = this.L;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }

    public void d() {
        if (this.L != -1) {
            this.f44577a.f0(this.K);
            this.L = -1;
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return this.L == -3 || (c() && this.f44577a.E(this.L));
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws IOException {
        int i = this.L;
        if (i == -2) {
            throw new SampleQueueMappingException(this.f44577a.e().b(this.K).c(0).k);
        }
        if (i == -1) {
            this.f44577a.I();
        } else if (i != -3) {
            this.f44577a.J(i);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j) {
        if (c()) {
            return this.f44577a.e0(this.L, j);
        }
        return 0;
    }
}
