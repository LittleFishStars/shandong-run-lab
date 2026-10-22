package com.google.android.exoplayer2.trackselection;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.o;
import com.zj.adlib.da9;
import com.zj.adlib.gj9;
import com.zj.adlib.yh3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a extends BaseTrackSelection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31044a = "AdaptiveTrackSelection";
    public static final float d = 0.7f;
    public static final float e = 0.75f;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final long f4684e = 1000;
    public static final int j = 10000;
    public static final int k = 25000;
    public static final int l = 25000;
    public static final int m = 1279;
    public static final int n = 719;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float f4685a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f4686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaChunk f4687a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BandwidthMeter f4688a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f4689a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableList<C0697a> f4690a;
    public final float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f4691b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final long f4692c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f4693d;
    public final int f;
    public final int g;
    public int h;
    public int i;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.trackselection.a$a, reason: collision with other inner class name */
    public static final class C0697a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f31045a;
        public final long b;

        public C0697a(long j, long j2) {
            this.f31045a = j;
            this.b = j2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0697a)) {
                return false;
            }
            C0697a c0697a = (C0697a) obj;
            return this.f31045a == c0697a.f31045a && this.b == c0697a.b;
        }

        public int hashCode() {
            return (((int) this.f31045a) * 31) + ((int) this.b);
        }
    }

    public static class b implements ExoTrackSelection.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f31046a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f4694a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Clock f4695a;
        public final float b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final int f4696b;
        public final int c;
        public final int d;
        public final int e;

        public b() {
            this(10000, 25000, 25000, 0.7f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection.Factory
        public final ExoTrackSelection[] a(ExoTrackSelection.a[] aVarArr, BandwidthMeter bandwidthMeter, MediaSource.a aVar, Timeline timeline) {
            ImmutableList immutableListL = a.l(aVarArr);
            ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[aVarArr.length];
            for (int i = 0; i < aVarArr.length; i++) {
                ExoTrackSelection.a aVar2 = aVarArr[i];
                if (aVar2 != null) {
                    int[] iArr = aVar2.f4676a;
                    if (iArr.length != 0) {
                        exoTrackSelectionArr[i] = iArr.length == 1 ? new yh3(aVar2.f4675a, iArr[0], aVar2.f4674a) : createAdaptiveTrackSelection(aVar2.f4675a, iArr, aVar2.f4674a, bandwidthMeter, (ImmutableList) immutableListL.get(i));
                    }
                }
            }
            return exoTrackSelectionArr;
        }

        public a createAdaptiveTrackSelection(da9 da9Var, int[] iArr, int i, BandwidthMeter bandwidthMeter, ImmutableList<C0697a> immutableList) {
            return new a(da9Var, iArr, i, bandwidthMeter, this.f4694a, this.f4696b, this.c, this.d, this.e, this.f31046a, this.b, immutableList, this.f4695a);
        }

        public b(int i, int i2, int i3, float f) {
            this(i, i2, i3, 1279, 719, f, 0.75f, Clock.f31152a);
        }

        public b(int i, int i2, int i3, int i4, int i5, float f) {
            this(i, i2, i3, i4, i5, f, 0.75f, Clock.f31152a);
        }

        public b(int i, int i2, int i3, float f, float f2, Clock clock) {
            this(i, i2, i3, 1279, 719, f, f2, clock);
        }

        public b(int i, int i2, int i3, int i4, int i5, float f, float f2, Clock clock) {
            this.f4694a = i;
            this.f4696b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f31046a = f;
            this.b = f2;
            this.f4695a = clock;
        }
    }

    public a(da9 da9Var, int[] iArr, BandwidthMeter bandwidthMeter) {
        this(da9Var, iArr, 0, bandwidthMeter, 10000L, 25000L, 25000L, 1279, 719, 0.7f, 0.75f, ImmutableList.of(), Clock.f31152a);
    }

    public static void j(List<ImmutableList.a<C0697a>> list, long[] jArr) {
        long j2 = 0;
        for (long j3 : jArr) {
            j2 += j3;
        }
        for (int i = 0; i < list.size(); i++) {
            ImmutableList.a<C0697a> aVar = list.get(i);
            if (aVar != null) {
                aVar.a(new C0697a(j2, jArr[i]));
            }
        }
    }

    public static ImmutableList<ImmutableList<C0697a>> l(ExoTrackSelection.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (ExoTrackSelection.a aVar : aVarArr) {
            if (aVar == null || aVar.f4676a.length <= 1) {
                arrayList.add(null);
            } else {
                ImmutableList.a aVarBuilder = ImmutableList.builder();
                aVarBuilder.a(new C0697a(0L, 0L));
                arrayList.add(aVarBuilder);
            }
        }
        long[][] jArrP = p(aVarArr);
        int[] iArr = new int[jArrP.length];
        long[] jArr = new long[jArrP.length];
        for (int i = 0; i < jArrP.length; i++) {
            long[] jArr2 = jArrP[i];
            jArr[i] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        j(arrayList, jArr);
        ImmutableList<Integer> immutableListQ = q(jArrP);
        for (int i2 = 0; i2 < immutableListQ.size(); i2++) {
            int iIntValue = immutableListQ.get(i2).intValue();
            int i3 = iArr[iIntValue] + 1;
            iArr[iIntValue] = i3;
            jArr[iIntValue] = jArrP[iIntValue][i3];
            j(arrayList, jArr);
        }
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            if (arrayList.get(i4) != null) {
                jArr[i4] = jArr[i4] * 2;
            }
        }
        j(arrayList, jArr);
        ImmutableList.a aVarBuilder2 = ImmutableList.builder();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            ImmutableList.a aVar2 = (ImmutableList.a) arrayList.get(i5);
            aVarBuilder2.a(aVar2 == null ? ImmutableList.of() : aVar2.e());
        }
        return aVarBuilder2.e();
    }

    public static long[][] p(ExoTrackSelection.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        for (int i = 0; i < aVarArr.length; i++) {
            ExoTrackSelection.a aVar = aVarArr[i];
            if (aVar == null) {
                jArr[i] = new long[0];
            } else {
                jArr[i] = new long[aVar.f4676a.length];
                int i2 = 0;
                while (true) {
                    int[] iArr = aVar.f4676a;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    jArr[i][i2] = aVar.f4675a.c(iArr[i2]).O;
                    i2++;
                }
                Arrays.sort(jArr[i]);
            }
        }
        return jArr;
    }

    public static ImmutableList<Integer> q(long[][] jArr) {
        Multimap multimapA = MultimapBuilder.h().a().a();
        for (int i = 0; i < jArr.length; i++) {
            long[] jArr2 = jArr[i];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i2 = 0;
                while (true) {
                    long[] jArr3 = jArr[i];
                    int length2 = jArr3.length;
                    double dLog = AudioStats.AUDIO_AMPLITUDE_NONE;
                    if (i2 >= length2) {
                        break;
                    }
                    long j2 = jArr3[i2];
                    if (j2 != -1) {
                        dLog = Math.log(j2);
                    }
                    dArr[i2] = dLog;
                    i2++;
                }
                int i3 = length - 1;
                double d2 = dArr[i3] - dArr[0];
                int i4 = 0;
                while (i4 < i3) {
                    double d3 = dArr[i4];
                    i4++;
                    multimapA.put(Double.valueOf(d2 == AudioStats.AUDIO_AMPLITUDE_NONE ? 1.0d : (((d3 + dArr[i4]) * 0.5d) - dArr[0]) / d2), Integer.valueOf(i));
                }
            }
        }
        return ImmutableList.copyOf(multimapA.values());
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void c(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long jElapsedRealtime = this.f4689a.elapsedRealtime();
        long jO = o(mediaChunkIteratorArr, list);
        int i = this.i;
        if (i == 0) {
            this.i = 1;
            this.h = k(jElapsedRealtime, jO);
            return;
        }
        int i2 = this.h;
        int iB = list.isEmpty() ? -1 : b(((Chunk) ((MediaChunk) o.w(list))).f3837a);
        if (iB != -1) {
            i = ((Chunk) ((MediaChunk) o.w(list))).b;
            i2 = iB;
        }
        int iK = k(jElapsedRealtime, jO);
        if (!isBlacklisted(i2, jElapsedRealtime)) {
            d dVarE = e(i2);
            d dVarE2 = e(iK);
            long jS = s(j4, jO);
            int i3 = dVarE2.O;
            int i4 = dVarE.O;
            if ((i3 > i4 && j3 < jS) || (i3 < i4 && j3 >= this.f4691b)) {
                iK = i2;
            }
        }
        if (iK != i2) {
            i = 3;
        }
        this.i = i;
        this.h = iK;
    }

    public boolean canSelectFormat(d dVar, int i, long j2) {
        return ((long) i) <= j2;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    @CallSuper
    public void disable() {
        this.f4687a = null;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    @CallSuper
    public void enable() {
        this.f4693d = -9223372036854775807L;
        this.f4687a = null;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int evaluateQueueSize(long j2, List<? extends MediaChunk> list) {
        int i;
        int i2;
        long jElapsedRealtime = this.f4689a.elapsedRealtime();
        if (!shouldEvaluateQueueSize(jElapsedRealtime, list)) {
            return list.size();
        }
        this.f4693d = jElapsedRealtime;
        this.f4687a = list.isEmpty() ? null : (MediaChunk) o.w(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long jQ0 = gj9.q0(((Chunk) list.get(size - 1)).f3841b - j2, this.c);
        long minDurationToRetainAfterDiscardUs = getMinDurationToRetainAfterDiscardUs();
        if (jQ0 < minDurationToRetainAfterDiscardUs) {
            return size;
        }
        d dVarE = e(k(jElapsedRealtime, n(list)));
        for (int i3 = 0; i3 < size; i3++) {
            MediaChunk mediaChunk = list.get(i3);
            d dVar = ((Chunk) mediaChunk).f3837a;
            if (gj9.q0(((Chunk) mediaChunk).f3841b - j2, this.c) >= minDurationToRetainAfterDiscardUs && dVar.O < dVarE.O && (i = dVar.R) != -1 && i <= this.g && (i2 = dVar.Q) != -1 && i2 <= this.f && i < dVarE.R) {
                return i3;
            }
        }
        return size;
    }

    public long getMinDurationToRetainAfterDiscardUs() {
        return this.f4692c;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int getSelectedIndex() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    @Nullable
    public Object getSelectionData() {
        return null;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int getSelectionReason() {
        return this.i;
    }

    public final int k(long j2, long j3) {
        long jM = m(j3);
        int i = 0;
        for (int i2 = 0; i2 < ((BaseTrackSelection) this).c; i2++) {
            if (j2 == Long.MIN_VALUE || !isBlacklisted(i2, j2)) {
                d dVarE = e(i2);
                if (canSelectFormat(dVarE, dVarE.O, jM)) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    public final long m(long j2) {
        long jR = r(j2);
        if (this.f4690a.isEmpty()) {
            return jR;
        }
        int i = 1;
        while (i < this.f4690a.size() - 1 && this.f4690a.get(i).f31045a < jR) {
            i++;
        }
        C0697a c0697a = this.f4690a.get(i - 1);
        C0697a c0697a2 = this.f4690a.get(i);
        long j3 = c0697a.f31045a;
        float f = (jR - j3) / (c0697a2.f31045a - j3);
        long j4 = c0697a.b;
        return j4 + ((long) (f * (c0697a2.b - j4)));
    }

    public final long n(List<? extends MediaChunk> list) {
        if (list.isEmpty()) {
            return -9223372036854775807L;
        }
        MediaChunk mediaChunk = (MediaChunk) o.w(list);
        long j2 = ((Chunk) mediaChunk).f3841b;
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j3 = mediaChunk.c;
        if (j3 != -9223372036854775807L) {
            return j3 - j2;
        }
        return -9223372036854775807L;
    }

    public final long o(MediaChunkIterator[] mediaChunkIteratorArr, List<? extends MediaChunk> list) {
        int i = this.h;
        if (i < mediaChunkIteratorArr.length && mediaChunkIteratorArr[i].next()) {
            MediaChunkIterator mediaChunkIterator = mediaChunkIteratorArr[this.h];
            return mediaChunkIterator.getChunkEndTimeUs() - mediaChunkIterator.getChunkStartTimeUs();
        }
        for (MediaChunkIterator mediaChunkIterator2 : mediaChunkIteratorArr) {
            if (mediaChunkIterator2.next()) {
                return mediaChunkIterator2.getChunkEndTimeUs() - mediaChunkIterator2.getChunkStartTimeUs();
            }
        }
        return n(list);
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void onPlaybackSpeed(float f) {
        this.c = f;
    }

    public final long r(long j2) {
        long bitrateEstimate = (long) (this.f4688a.getBitrateEstimate() * this.f4685a);
        long timeToFirstByteEstimateUs = this.f4688a.getTimeToFirstByteEstimateUs();
        if (timeToFirstByteEstimateUs == -9223372036854775807L || j2 == -9223372036854775807L) {
            return (long) (bitrateEstimate / this.c);
        }
        float f = j2;
        return (long) ((bitrateEstimate * Math.max((f / this.c) - timeToFirstByteEstimateUs, 0.0f)) / f);
    }

    public final long s(long j2, long j3) {
        if (j2 == -9223372036854775807L) {
            return this.f4686a;
        }
        if (j3 != -9223372036854775807L) {
            j2 -= j3;
        }
        return Math.min((long) (j2 * this.b), this.f4686a);
    }

    public boolean shouldEvaluateQueueSize(long j2, List<? extends MediaChunk> list) {
        long j3 = this.f4693d;
        return j3 == -9223372036854775807L || j2 - j3 >= 1000 || !(list.isEmpty() || ((MediaChunk) o.w(list)).equals(this.f4687a));
    }

    public a(da9 da9Var, int[] iArr, int i, BandwidthMeter bandwidthMeter, long j2, long j3, long j4, int i2, int i3, float f, float f2, List<C0697a> list, Clock clock) {
        long j5;
        super(da9Var, iArr, i);
        if (j4 < j2) {
            Log.n(f31044a, "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j5 = j2;
        } else {
            j5 = j4;
        }
        this.f4688a = bandwidthMeter;
        this.f4686a = j2 * 1000;
        this.f4691b = j3 * 1000;
        this.f4692c = j5 * 1000;
        this.f = i2;
        this.g = i3;
        this.f4685a = f;
        this.b = f2;
        this.f4690a = ImmutableList.copyOf((Collection) list);
        this.f4689a = clock;
        this.c = 1.0f;
        this.i = 0;
        this.f4693d = -9223372036854775807L;
    }
}
