package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.zj.adlib.df2;
import com.zj.adlib.gk5;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class MergingMediaSource extends CompositeMediaSource<Integer> {
    public static final int L = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g f30825a = new com.google.android.exoplayer2.g.c().D("MergingMediaSource").a();
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CompositeSequenceableLoaderFactory f3678a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public IllegalMergeException f3679a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Multimap<Object, com.google.android.exoplayer2.source.a> f3680a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<Object, Long> f3681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3682a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline[] f3683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSource[] f3684a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long[][] f3685a;
    public final ArrayList<MediaSource> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f3686b;

    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalMergeException(int i) {
            this.reason = i;
        }
    }

    public static final class a extends ForwardingTimeline {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f30826a;
        public final long[] b;

        public a(Timeline timeline, Map<Object, Long> map) {
            super(timeline);
            int iV = timeline.v();
            this.b = new long[timeline.v()];
            Timeline.d dVar = new Timeline.d();
            for (int i = 0; i < iV; i++) {
                this.b[i] = timeline.t(i, dVar).f2209e;
            }
            int iM = timeline.m();
            this.f30826a = new long[iM];
            Timeline.b bVar = new Timeline.b();
            for (int i2 = 0; i2 < iM; i2++) {
                timeline.k(i2, bVar, true);
                long jLongValue = ((Long) sb0.g(map.get(bVar.f2194b))).longValue();
                long[] jArr = this.f30826a;
                jLongValue = jLongValue == Long.MIN_VALUE ? bVar.f2190a : jLongValue;
                jArr[i2] = jLongValue;
                long j = bVar.f2190a;
                if (j != -9223372036854775807L) {
                    long[] jArr2 = this.b;
                    int i3 = bVar.K;
                    jArr2[i3] = jArr2[i3] - (j - jLongValue);
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.b k(int i, Timeline.b bVar, boolean z) {
            super.k(i, bVar, z);
            bVar.f2190a = this.f30826a[i];
            return bVar;
        }

        /* JADX WARN: Code duplicated, block: B:8:0x001e  */
        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.d u(int i, Timeline.d dVar, long j) {
            long jMin;
            super.u(i, dVar, j);
            long j2 = this.b[i];
            dVar.f2209e = j2;
            if (j2 != -9223372036854775807L) {
                long j3 = dVar.f2207d;
                if (j3 == -9223372036854775807L) {
                    jMin = dVar.f2207d;
                } else {
                    jMin = Math.min(j3, j2);
                }
            } else {
                jMin = dVar.f2207d;
            }
            dVar.f2207d = jMin;
            return dVar;
        }
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
        int length = this.f3684a.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        int iF = this.f3683a[0].f(((gk5) aVar).f16805a);
        for (int i = 0; i < length; i++) {
            mediaPeriodArr[i] = this.f3684a[i].F(aVar.a(this.f3683a[i].s(iF)), allocator, j - this.f3685a[iF][i]);
        }
        f fVar = new f(this.f3678a, this.f3685a[iF], mediaPeriodArr);
        if (!this.f3686b) {
            return fVar;
        }
        com.google.android.exoplayer2.source.a aVar2 = new com.google.android.exoplayer2.source.a(fVar, true, 0L, ((Long) sb0.g(this.f3681a.get(((gk5) aVar).f16805a))).longValue());
        this.f3680a.put(((gk5) aVar).f16805a, aVar2);
        return aVar2;
    }

    public final void R() {
        Timeline.b bVar = new Timeline.b();
        for (int i = 0; i < this.K; i++) {
            long j = -this.f3683a[0].j(i, bVar).s();
            int i2 = 1;
            while (true) {
                Timeline[] timelineArr = this.f3683a;
                if (i2 < timelineArr.length) {
                    this.f3685a[i][i2] = j - (-timelineArr[i2].j(i, bVar).s());
                    i2++;
                }
            }
        }
    }

    public final void S() {
        Timeline[] timelineArr;
        Timeline.b bVar = new Timeline.b();
        for (int i = 0; i < this.K; i++) {
            int i2 = 0;
            long j = Long.MIN_VALUE;
            while (true) {
                timelineArr = this.f3683a;
                if (i2 >= timelineArr.length) {
                    break;
                }
                long jO = timelineArr[i2].j(i, bVar).o();
                if (jO != -9223372036854775807L) {
                    long j2 = jO + this.f3685a[i][i2];
                    if (j == Long.MIN_VALUE || j2 < j) {
                        j = j2;
                    }
                }
                i2++;
            }
            Object objS = timelineArr[0].s(i);
            this.f3681a.put(objS, Long.valueOf(j));
            Iterator<com.google.android.exoplayer2.source.a> it = this.f3680a.get(objS).iterator();
            while (it.hasNext()) {
                it.next().l(0L, j);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.g b() {
        MediaSource[] mediaSourceArr = this.f3684a;
        return mediaSourceArr.length > 0 ? mediaSourceArr[0].b() : f30825a;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void j(MediaPeriod mediaPeriod) {
        if (this.f3686b) {
            com.google.android.exoplayer2.source.a aVar = (com.google.android.exoplayer2.source.a) mediaPeriod;
            for (Map.Entry<Object, com.google.android.exoplayer2.source.a> entry : this.f3680a.entries()) {
                if (entry.getValue().equals(aVar)) {
                    this.f3680a.remove(entry.getKey(), entry.getValue());
                    break;
                }
            }
            mediaPeriod = aVar.f3759a;
        }
        f fVar = (f) mediaPeriod;
        int i = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.f3684a;
            if (i >= mediaSourceArr.length) {
                return;
            }
            mediaSourceArr[i].j(fVar.b(i));
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalMergeException illegalMergeException = this.f3679a;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        for (int i = 0; i < this.f3684a.length; i++) {
            prepareChildSource(Integer.valueOf(i), this.f3684a[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        Arrays.fill(this.f3683a, (Object) null);
        this.K = -1;
        this.f3679a = null;
        this.b.clear();
        Collections.addAll(this.b, this.f3684a);
    }

    public MergingMediaSource(boolean z, MediaSource... mediaSourceArr) {
        this(z, false, mediaSourceArr);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    @Nullable
    public MediaSource.a getMediaPeriodIdForChildMediaPeriodId(Integer num, MediaSource.a aVar) {
        if (num.intValue() == 0) {
            return aVar;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* JADX INFO: renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void Q(Integer num, MediaSource mediaSource, Timeline timeline) {
        if (this.f3679a != null) {
            return;
        }
        if (this.K == -1) {
            this.K = timeline.m();
        } else if (timeline.m() != this.K) {
            this.f3679a = new IllegalMergeException(0);
            return;
        }
        if (this.f3685a.length == 0) {
            this.f3685a = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.K, this.f3683a.length);
        }
        this.b.remove(mediaSource);
        this.f3683a[num.intValue()] = timeline;
        if (this.b.isEmpty()) {
            if (this.f3682a) {
                R();
            }
            Timeline aVar = this.f3683a[0];
            if (this.f3686b) {
                S();
                aVar = new a(aVar, this.f3681a);
            }
            refreshSourceInfo(aVar);
        }
    }

    public MergingMediaSource(boolean z, boolean z2, MediaSource... mediaSourceArr) {
        this(z, z2, new df2(), mediaSourceArr);
    }

    public MergingMediaSource(boolean z, boolean z2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, MediaSource... mediaSourceArr) {
        this.f3682a = z;
        this.f3686b = z2;
        this.f3684a = mediaSourceArr;
        this.f3678a = compositeSequenceableLoaderFactory;
        this.b = new ArrayList<>(Arrays.asList(mediaSourceArr));
        this.K = -1;
        this.f3683a = new Timeline[mediaSourceArr.length];
        this.f3685a = new long[0][];
        this.f3681a = new HashMap();
        this.f3680a = MultimapBuilder.d().a().a();
    }
}
