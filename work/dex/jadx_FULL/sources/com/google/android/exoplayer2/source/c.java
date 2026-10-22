package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.gk5;
import com.zj.adlib.sb0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Deprecated
public final class c extends CompositeMediaSource<Void> {
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f30855a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<MediaSource.a, MediaSource.a> f3834a;
    public final Map<MediaPeriod, MediaSource.a> b;

    public static final class a extends ForwardingTimeline {
        public a(Timeline timeline) {
            super(timeline);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int i(int i, int i2, boolean z) {
            int i3 = this.b.i(i, i2, z);
            return i3 == -1 ? e(z) : i3;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int r(int i, int i2, boolean z) {
            int iR = this.b.r(i, i2, z);
            return iR == -1 ? g(z) : iR;
        }
    }

    public static final class b extends AbstractConcatenatedTimeline {
        public final int O;
        public final int P;
        public final int Q;
        public final Timeline b;

        public b(Timeline timeline, int i) {
            super(false, new ShuffleOrder.b(i));
            this.b = timeline;
            int iM = timeline.m();
            this.O = iM;
            this.P = timeline.v();
            this.Q = i;
            if (iM > 0) {
                sb0.j(i <= Integer.MAX_VALUE / iM, "LoopingMediaSource contains too many periods");
            }
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByChildUid(Object obj) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByPeriodIndex(int i) {
            return i / this.O;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByWindowIndex(int i) {
            return i / this.P;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public Object getChildUidByChildIndex(int i) {
            return Integer.valueOf(i);
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getFirstPeriodIndexByChildIndex(int i) {
            return i * this.O;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getFirstWindowIndexByChildIndex(int i) {
            return i * this.P;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public Timeline getTimelineByChildIndex(int i) {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int m() {
            return this.O * this.Q;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int v() {
            return this.P * this.Q;
        }
    }

    public c(MediaSource mediaSource) {
        this(mediaSource, Integer.MAX_VALUE);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
        if (this.K == Integer.MAX_VALUE) {
            return this.f30855a.F(aVar, allocator, j);
        }
        MediaSource.a aVarA = aVar.a(AbstractConcatenatedTimeline.A(((gk5) aVar).f16805a));
        this.f3834a.put(aVarA, aVar);
        MaskingMediaPeriod maskingMediaPeriodF = this.f30855a.F(aVarA, allocator, j);
        this.b.put(maskingMediaPeriodF, aVarA);
        return maskingMediaPeriodF;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.g b() {
        return this.f30855a.b();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public boolean isSingleWindow() {
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void j(MediaPeriod mediaPeriod) {
        this.f30855a.j(mediaPeriod);
        MediaSource.a aVarRemove = this.b.remove(mediaPeriod);
        if (aVarRemove != null) {
            this.f3834a.remove(aVarRemove);
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.f30855a);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    @Nullable
    public Timeline q() {
        return this.K != Integer.MAX_VALUE ? new b(this.f30855a.U(), this.K) : new a(this.f30855a.U());
    }

    public c(MediaSource mediaSource, int i) {
        sb0.a(i > 0);
        this.f30855a = new d(mediaSource, false);
        this.K = i;
        this.f3834a = new HashMap();
        this.b = new HashMap();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    @Nullable
    public MediaSource.a getMediaPeriodIdForChildMediaPeriodId(Void r2, MediaSource.a aVar) {
        return this.K != Integer.MAX_VALUE ? this.f3834a.get(aVar) : aVar;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* JADX INFO: renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void Q(Void r1, MediaSource mediaSource, Timeline timeline) {
        refreshSourceInfo(this.K != Integer.MAX_VALUE ? new b(timeline, this.K) : new a(timeline));
    }
}
