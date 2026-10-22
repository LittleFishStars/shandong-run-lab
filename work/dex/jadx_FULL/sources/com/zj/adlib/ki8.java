package com.zj.adlib;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@VisibleForTesting(otherwise = 3)
public final class ki8 extends ForwardingTimeline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdPlaybackState f42828a;

    public ki8(Timeline timeline, AdPlaybackState adPlaybackState) {
        super(timeline);
        sb0.i(timeline.m() == 1);
        sb0.i(timeline.v() == 1);
        this.f42828a = adPlaybackState;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public Timeline.b k(int i, Timeline.b bVar, boolean z) {
        this.b.k(i, bVar, z);
        long j = bVar.f2190a;
        if (j == -9223372036854775807L) {
            j = this.f42828a.b;
        }
        bVar.y(bVar.f2192a, bVar.f2194b, bVar.K, j, bVar.s(), this.f42828a, bVar.f2193a);
        return bVar;
    }
}
