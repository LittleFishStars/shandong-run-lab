package com.zj.adlib;

import com.google.android.exoplayer2.source.dash.DashSegmentIndex;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ri8 implements DashSegmentIndex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ka7 f44464a;

    public ri8(ka7 ka7Var) {
        this.f44464a = ka7Var;
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
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public ka7 d(long j) {
        return this.f44464a;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long e(long j, long j2) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long f() {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long g(long j) {
        return 1L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getTimeUs(long j) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long h(long j, long j2) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long i(long j, long j2) {
        return 1L;
    }
}
