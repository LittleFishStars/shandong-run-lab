package com.zj.adlib;

import com.google.android.exoplayer2.extractor.b;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g62 implements DashSegmentIndex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f41827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f16706a;

    public g62(b bVar, long j) {
        this.f16706a = bVar;
        this.f41827a = j;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public boolean a() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long b(long j, long j2) {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long c(long j, long j2) {
        return this.f16706a.b[(int) j];
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public ka7 d(long j) {
        b bVar = this.f16706a;
        int i = (int) j;
        return new ka7(null, bVar.f2735a[i], bVar.f2734a[i]);
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long e(long j, long j2) {
        return this.f16706a.b(j + this.f41827a);
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long f() {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long g(long j) {
        return this.f16706a.d;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getTimeUs(long j) {
        return this.f16706a.c[(int) j] - this.f41827a;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long h(long j, long j2) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long i(long j, long j2) {
        return this.f16706a.d;
    }
}
