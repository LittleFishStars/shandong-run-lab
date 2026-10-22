package com.zj.adlib;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j13 implements SampleStream {
    @Override // com.google.android.exoplayer2.source.SampleStream
    public int b(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i) {
        decoderInputBuffer.i(4);
        return -4;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() {
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j) {
        return 0;
    }
}
