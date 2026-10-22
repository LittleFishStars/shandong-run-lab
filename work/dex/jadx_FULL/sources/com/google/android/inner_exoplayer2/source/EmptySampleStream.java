package com.google.android.inner_exoplayer2.source;

import com.google.android.inner_exoplayer2.FormatHolder;
import com.google.android.inner_exoplayer2.decoder.DecoderInputBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class EmptySampleStream implements SampleStream {
    @Override // com.google.android.inner_exoplayer2.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.inner_exoplayer2.source.SampleStream
    public void maybeThrowError() {
    }

    @Override // com.google.android.inner_exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        decoderInputBuffer.setFlags(4);
        return -4;
    }

    @Override // com.google.android.inner_exoplayer2.source.SampleStream
    public int skipData(long j) {
        return 0;
    }
}
