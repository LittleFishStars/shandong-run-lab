package com.google.android.exoplayer2.source;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.gj9;
import com.zj.adlib.gk5;
import com.zj.adlib.sb0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d extends CompositeMediaSource<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Timeline.b f30870a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.d f3889a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MaskingMediaPeriod f3890a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSource f3891a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f3892a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3893a;
    public boolean b;
    public boolean c;
    public boolean d;

    public static final class a extends ForwardingTimeline {
        public static final Object c = new Object();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Object f30871a;

        @Nullable
        public final Object b;

        public a(Timeline timeline, @Nullable Object obj, @Nullable Object obj2) {
            super(timeline);
            this.f30871a = obj;
            this.b = obj2;
        }

        public static a C(com.google.android.exoplayer2.g gVar) {
            return new a(new b(gVar), Timeline.d.d, c);
        }

        public static a D(Timeline timeline, @Nullable Object obj, @Nullable Object obj2) {
            return new a(timeline, obj, obj2);
        }

        public a B(Timeline timeline) {
            return new a(timeline, this.f30871a, this.b);
        }

        public Timeline E() {
            return super.b;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int f(Object obj) {
            Object obj2;
            Timeline timeline = super.b;
            if (c.equals(obj) && (obj2 = this.b) != null) {
                obj = obj2;
            }
            return timeline.f(obj);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.b k(int i, Timeline.b bVar, boolean z) {
            super.b.k(i, bVar, z);
            if (gj9.c(bVar.f2194b, this.b) && z) {
                bVar.f2194b = c;
            }
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Object s(int i) {
            Object objS = super.b.s(i);
            return gj9.c(objS, this.b) ? c : objS;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.d u(int i, Timeline.d dVar, long j) {
            super.b.u(i, dVar, j);
            if (gj9.c(dVar.f2200a, this.f30871a)) {
                dVar.f2200a = Timeline.d.d;
            }
            return dVar;
        }
    }

    @VisibleForTesting
    public static final class b extends Timeline {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.g f30872a;

        public b(com.google.android.exoplayer2.g gVar) {
            this.f30872a = gVar;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int f(Object obj) {
            return obj == a.c ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.b k(int i, Timeline.b bVar, boolean z) {
            bVar.y(z ? 0 : null, z ? a.c : null, 0, -9223372036854775807L, 0L, AdPlaybackState.f3764a, true);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int m() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object s(int i) {
            return a.c;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.d u(int i, Timeline.d dVar, long j) {
            dVar.m(Timeline.d.d, this.f30872a, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            dVar.f2208d = true;
            return dVar;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int v() {
            return 1;
        }
    }

    public d(MediaSource mediaSource, boolean z) {
        this.f3891a = mediaSource;
        this.f3893a = z && mediaSource.isSingleWindow();
        this.f3889a = new Timeline.d();
        this.f30870a = new Timeline.b();
        Timeline timelineQ = mediaSource.q();
        if (timelineQ == null) {
            this.f3892a = a.C(mediaSource.b());
        } else {
            this.f3892a = a.D(timelineQ, null, null);
            this.d = true;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public MaskingMediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(aVar, allocator, j);
        maskingMediaPeriod.n(this.f3891a);
        if (this.c) {
            maskingMediaPeriod.b(aVar.a(T(((gk5) aVar).f16805a)));
        } else {
            this.f3890a = maskingMediaPeriod;
            if (!this.b) {
                this.b = true;
                prepareChildSource(null, this.f3891a);
            }
        }
        return maskingMediaPeriod;
    }

    public final Object S(Object obj) {
        return (this.f3892a.b == null || !this.f3892a.b.equals(obj)) ? obj : a.c;
    }

    public final Object T(Object obj) {
        return (this.f3892a.b == null || !obj.equals(a.c)) ? obj : this.f3892a.b;
    }

    public Timeline U() {
        return this.f3892a;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    public final void V(long j) {
        MaskingMediaPeriod maskingMediaPeriod = this.f3890a;
        int iF = this.f3892a.f(((gk5) maskingMediaPeriod.f3670a).f16805a);
        if (iF == -1) {
            return;
        }
        long j2 = this.f3892a.j(iF, this.f30870a).f2190a;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        maskingMediaPeriod.l(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.g b() {
        return this.f3891a.b();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void j(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).m();
        if (mediaPeriod == this.f3890a) {
            this.f3890a = null;
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        if (this.f3893a) {
            return;
        }
        this.b = true;
        prepareChildSource(null, this.f3891a);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.c = false;
        this.b = false;
        super.releaseSourceInternal();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    @Nullable
    public MediaSource.a getMediaPeriodIdForChildMediaPeriodId(Void r1, MediaSource.a aVar) {
        return aVar.a(S(((gk5) aVar).f16805a));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0074  */
    /* JADX WARN: Code duplicated, block: B:30:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* JADX INFO: renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void Q(Void r13, MediaSource mediaSource, Timeline timeline) {
        long j;
        MediaSource.a aVarA;
        if (this.c) {
            this.f3892a = this.f3892a.B(timeline);
            MaskingMediaPeriod maskingMediaPeriod = this.f3890a;
            if (maskingMediaPeriod != null) {
                V(maskingMediaPeriod.g());
            }
        } else {
            if (!timeline.w()) {
                timeline.t(0, this.f3889a);
                long jF = this.f3889a.f();
                Object obj = this.f3889a.f2200a;
                MaskingMediaPeriod maskingMediaPeriod2 = this.f3890a;
                if (maskingMediaPeriod2 != null) {
                    long jI = maskingMediaPeriod2.i();
                    this.f3892a.l(((gk5) this.f3890a.f3670a).f16805a, this.f30870a);
                    long jS = this.f30870a.s() + jI;
                    if (jS != this.f3892a.t(0, this.f3889a).f()) {
                        j = jS;
                    } else {
                        j = jF;
                    }
                } else {
                    j = jF;
                }
                Pair<Object, Long> pairP = timeline.p(this.f3889a, this.f30870a, 0, j);
                Object obj2 = pairP.first;
                long jLongValue = ((Long) pairP.second).longValue();
                this.f3892a = this.d ? this.f3892a.B(timeline) : a.D(timeline, obj, obj2);
                MaskingMediaPeriod maskingMediaPeriod3 = this.f3890a;
                if (maskingMediaPeriod3 != null) {
                    V(jLongValue);
                    MediaSource.a aVar = maskingMediaPeriod3.f3670a;
                    aVarA = aVar.a(T(((gk5) aVar).f16805a));
                }
                this.d = true;
                this.c = true;
                refreshSourceInfo(this.f3892a);
                if (aVarA != null) {
                    ((MaskingMediaPeriod) sb0.g(this.f3890a)).b(aVarA);
                }
            }
            this.f3892a = this.d ? this.f3892a.B(timeline) : a.D(timeline, Timeline.d.d, a.c);
        }
        aVarA = null;
        this.d = true;
        this.c = true;
        refreshSourceInfo(this.f3892a);
        if (aVarA != null) {
            ((MaskingMediaPeriod) sb0.g(this.f3890a)).b(aVarA);
        }
    }
}
