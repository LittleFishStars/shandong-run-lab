package com.google.android.exoplayer2.extractor.mp3;

import com.zj.adlib.hs5;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a extends com.google.android.exoplayer2.extractor.c implements Seeker {
    public a(long j, long j2, hs5.a aVar, boolean z) {
        super(j, j2, aVar.e, aVar.b, z);
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        return c(j);
    }
}
