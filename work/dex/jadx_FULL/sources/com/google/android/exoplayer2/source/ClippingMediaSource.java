package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ClippingMediaSource extends CompositeMediaSource<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.d f3633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public IllegalClippingException f3634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public a f3635a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSource f3636a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3637a;
    public final long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<com.google.android.exoplayer2.source.a> f3638b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f3639b;
    public long c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f3640c;
    public long d;

    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalClippingException(int i) {
            super("Illegal clipping: " + getReasonDescription(i));
            this.reason = i;
        }

        private static String getReasonDescription(int i) {
            if (i == 0) {
                return "invalid period count";
            }
            if (i != 1) {
                return i != 2 ? "unknown" : "start exceeds end";
            }
            return "not seekable to start";
        }
    }

    public static final class a extends ForwardingTimeline {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30812a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f3641a;
        public final long b;
        public final long c;

        public a(Timeline timeline, long j, long j2) throws IllegalClippingException {
            super(timeline);
            boolean z = false;
            if (timeline.m() != 1) {
                throw new IllegalClippingException(0);
            }
            Timeline.d dVarT = timeline.t(0, new Timeline.d());
            long jMax = Math.max(0L, j);
            if (!dVarT.f2208d && jMax != 0 && !dVarT.f2201a) {
                throw new IllegalClippingException(1);
            }
            long jMax2 = j2 == Long.MIN_VALUE ? dVarT.f2209e : Math.max(0L, j2);
            long j3 = dVarT.f2209e;
            if (j3 != -9223372036854775807L) {
                jMax2 = jMax2 > j3 ? j3 : jMax2;
                if (jMax > jMax2) {
                    throw new IllegalClippingException(2);
                }
            }
            this.f30812a = jMax;
            this.b = jMax2;
            this.c = jMax2 == -9223372036854775807L ? -9223372036854775807L : jMax2 - jMax;
            if (dVarT.f2204b && (jMax2 == -9223372036854775807L || (j3 != -9223372036854775807L && jMax2 == j3))) {
                z = true;
            }
            this.f3641a = z;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.b k(int i, Timeline.b bVar, boolean z) {
            super.b.k(0, bVar, z);
            long jS = bVar.s() - this.f30812a;
            long j = this.c;
            return bVar.x(bVar.f2192a, bVar.f2194b, 0, j == -9223372036854775807L ? -9223372036854775807L : j - jS, jS);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.d u(int i, Timeline.d dVar, long j) {
            super.b.u(0, dVar, 0L);
            long j2 = dVar.f;
            long j3 = this.f30812a;
            dVar.f = j2 + j3;
            dVar.f2209e = this.c;
            dVar.f2204b = this.f3641a;
            long j4 = dVar.f2207d;
            if (j4 != -9223372036854775807L) {
                long jMax = Math.max(j4, j3);
                dVar.f2207d = jMax;
                long j5 = this.b;
                if (j5 != -9223372036854775807L) {
                    jMax = Math.min(jMax, j5);
                }
                dVar.f2207d = jMax - this.f30812a;
            }
            long jH1 = gj9.H1(this.f30812a);
            long j6 = dVar.f2197a;
            if (j6 != -9223372036854775807L) {
                dVar.f2197a = j6 + jH1;
            }
            long j7 = dVar.f2202b;
            if (j7 != -9223372036854775807L) {
                dVar.f2202b = j7 + jH1;
            }
            return dVar;
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j, long j2) {
        this(mediaSource, j, j2, true, false, false);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
        com.google.android.exoplayer2.source.a aVar2 = new com.google.android.exoplayer2.source.a(this.f3636a.F(aVar, allocator, j), this.f3637a, this.c, this.d);
        this.f3638b.add(aVar2);
        return aVar2;
    }

    public final void R(Timeline timeline) {
        long j;
        long j2;
        timeline.t(0, this.f3633a);
        long j3 = this.f3633a.j();
        if (this.f3635a == null || this.f3638b.isEmpty() || this.f3639b) {
            long j4 = this.f30811a;
            long j5 = this.b;
            if (this.f3640c) {
                long jF = this.f3633a.f();
                j4 += jF;
                j5 += jF;
            }
            this.c = j3 + j4;
            this.d = this.b != Long.MIN_VALUE ? j3 + j5 : Long.MIN_VALUE;
            int size = this.f3638b.size();
            for (int i = 0; i < size; i++) {
                this.f3638b.get(i).l(this.c, this.d);
            }
            j = j4;
            j2 = j5;
        } else {
            long j6 = this.c - j3;
            j2 = this.b != Long.MIN_VALUE ? this.d - j3 : Long.MIN_VALUE;
            j = j6;
        }
        try {
            a aVar = new a(timeline, j, j2);
            this.f3635a = aVar;
            refreshSourceInfo(aVar);
        } catch (IllegalClippingException e) {
            this.f3634a = e;
            for (int i2 = 0; i2 < this.f3638b.size(); i2++) {
                this.f3638b.get(i2).j(this.f3634a);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.g b() {
        return this.f3636a.b();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void j(MediaPeriod mediaPeriod) {
        sb0.i(this.f3638b.remove(mediaPeriod));
        this.f3636a.j(((com.google.android.exoplayer2.source.a) mediaPeriod).f3759a);
        if (!this.f3638b.isEmpty() || this.f3639b) {
            return;
        }
        R(((ForwardingTimeline) ((a) sb0.g(this.f3635a))).b);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalClippingException illegalClippingException = this.f3634a;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.f3636a);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.f3634a = null;
        this.f3635a = null;
    }

    public ClippingMediaSource(MediaSource mediaSource, long j) {
        this(mediaSource, 0L, j, true, false, true);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* JADX INFO: renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void Q(Void r1, MediaSource mediaSource, Timeline timeline) {
        if (this.f3634a != null) {
            return;
        }
        R(timeline);
    }

    public ClippingMediaSource(MediaSource mediaSource, long j, long j2, boolean z, boolean z2, boolean z3) {
        sb0.a(j >= 0);
        this.f3636a = (MediaSource) sb0.g(mediaSource);
        this.f30811a = j;
        this.b = j2;
        this.f3637a = z;
        this.f3639b = z2;
        this.f3640c = z3;
        this.f3638b = new ArrayList<>();
        this.f3633a = new Timeline.d();
    }
}
