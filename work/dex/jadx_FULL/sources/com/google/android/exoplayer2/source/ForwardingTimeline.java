package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class ForwardingTimeline extends Timeline {
    public final Timeline b;

    public ForwardingTimeline(Timeline timeline) {
        this.b = timeline;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int e(boolean z) {
        return this.b.e(z);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int f(Object obj) {
        return this.b.f(obj);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int g(boolean z) {
        return this.b.g(z);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int i(int i, int i2, boolean z) {
        return this.b.i(i, i2, z);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.b k(int i, Timeline.b bVar, boolean z) {
        return this.b.k(i, bVar, z);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int m() {
        return this.b.m();
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int r(int i, int i2, boolean z) {
        return this.b.r(i, i2, z);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Object s(int i) {
        return this.b.s(i);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.d u(int i, Timeline.d dVar, long j) {
        return this.b.u(i, dVar, j);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int v() {
        return this.b.v();
    }
}
