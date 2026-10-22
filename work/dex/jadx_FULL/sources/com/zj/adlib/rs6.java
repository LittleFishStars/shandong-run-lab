package com.zj.adlib;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class rs6 {
    public static final MediaSource.a c = new MediaSource.a(new Object());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44526a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f19406a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ExoPlaybackException f19407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline f19408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final j f19409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSource.a f19410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ga9 f19411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final wa9 f19412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<Metadata> f19413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f19414a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f19415b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final MediaSource.a f19416b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f19417b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public volatile long f19418c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f19419c;
    public volatile long d;
    public volatile long e;

    public rs6(Timeline timeline, MediaSource.a aVar, long j, long j2, int i, @Nullable ExoPlaybackException exoPlaybackException, boolean z, ga9 ga9Var, wa9 wa9Var, List<Metadata> list, MediaSource.a aVar2, boolean z2, int i2, j jVar, long j3, long j4, long j5, boolean z3) {
        this.f19408a = timeline;
        this.f19410a = aVar;
        this.f19406a = j;
        this.f19415b = j2;
        this.f44526a = i;
        this.f19407a = exoPlaybackException;
        this.f19414a = z;
        this.f19411a = ga9Var;
        this.f19412a = wa9Var;
        this.f19413a = list;
        this.f19416b = aVar2;
        this.f19417b = z2;
        this.b = i2;
        this.f19409a = jVar;
        this.f19418c = j3;
        this.d = j4;
        this.e = j5;
        this.f19419c = z3;
    }

    public static rs6 j(wa9 wa9Var) {
        Timeline timeline = Timeline.f2189a;
        MediaSource.a aVar = c;
        return new rs6(timeline, aVar, -9223372036854775807L, 0L, 1, null, false, ga9.f16735a, wa9Var, ImmutableList.of(), aVar, false, 0, j.f3398a, 0L, 0L, 0L, false);
    }

    public static MediaSource.a k() {
        return c;
    }

    @CheckResult
    public rs6 a(boolean z) {
        return new rs6(this.f19408a, this.f19410a, this.f19406a, this.f19415b, this.f44526a, this.f19407a, z, this.f19411a, this.f19412a, this.f19413a, this.f19416b, this.f19417b, this.b, this.f19409a, this.f19418c, this.d, this.e, this.f19419c);
    }

    @CheckResult
    public rs6 b(MediaSource.a aVar) {
        return new rs6(this.f19408a, this.f19410a, this.f19406a, this.f19415b, this.f44526a, this.f19407a, this.f19414a, this.f19411a, this.f19412a, this.f19413a, aVar, this.f19417b, this.b, this.f19409a, this.f19418c, this.d, this.e, this.f19419c);
    }

    @CheckResult
    public rs6 c(MediaSource.a aVar, long j, long j2, long j3, long j4, ga9 ga9Var, wa9 wa9Var, List<Metadata> list) {
        return new rs6(this.f19408a, aVar, j2, j3, this.f44526a, this.f19407a, this.f19414a, ga9Var, wa9Var, list, this.f19416b, this.f19417b, this.b, this.f19409a, this.f19418c, j4, j, this.f19419c);
    }

    @CheckResult
    public rs6 d(boolean z, int i) {
        return new rs6(this.f19408a, this.f19410a, this.f19406a, this.f19415b, this.f44526a, this.f19407a, this.f19414a, this.f19411a, this.f19412a, this.f19413a, this.f19416b, z, i, this.f19409a, this.f19418c, this.d, this.e, this.f19419c);
    }

    @CheckResult
    public rs6 e(@Nullable ExoPlaybackException exoPlaybackException) {
        return new rs6(this.f19408a, this.f19410a, this.f19406a, this.f19415b, this.f44526a, exoPlaybackException, this.f19414a, this.f19411a, this.f19412a, this.f19413a, this.f19416b, this.f19417b, this.b, this.f19409a, this.f19418c, this.d, this.e, this.f19419c);
    }

    @CheckResult
    public rs6 f(j jVar) {
        return new rs6(this.f19408a, this.f19410a, this.f19406a, this.f19415b, this.f44526a, this.f19407a, this.f19414a, this.f19411a, this.f19412a, this.f19413a, this.f19416b, this.f19417b, this.b, jVar, this.f19418c, this.d, this.e, this.f19419c);
    }

    @CheckResult
    public rs6 g(int i) {
        return new rs6(this.f19408a, this.f19410a, this.f19406a, this.f19415b, i, this.f19407a, this.f19414a, this.f19411a, this.f19412a, this.f19413a, this.f19416b, this.f19417b, this.b, this.f19409a, this.f19418c, this.d, this.e, this.f19419c);
    }

    @CheckResult
    public rs6 h(boolean z) {
        return new rs6(this.f19408a, this.f19410a, this.f19406a, this.f19415b, this.f44526a, this.f19407a, this.f19414a, this.f19411a, this.f19412a, this.f19413a, this.f19416b, this.f19417b, this.b, this.f19409a, this.f19418c, this.d, this.e, z);
    }

    @CheckResult
    public rs6 i(Timeline timeline) {
        return new rs6(timeline, this.f19410a, this.f19406a, this.f19415b, this.f44526a, this.f19407a, this.f19414a, this.f19411a, this.f19412a, this.f19413a, this.f19416b, this.f19417b, this.b, this.f19409a, this.f19418c, this.d, this.e, this.f19419c);
    }
}
