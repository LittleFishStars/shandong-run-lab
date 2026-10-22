package com.google.android.exoplayer2.source.ads;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.o;
import com.zj.adlib.az4;
import com.zj.adlib.da9;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.gk5;
import com.zj.adlib.j13;
import com.zj.adlib.oh5;
import com.zj.adlib.sb0;
import com.zj.adlib.w38;
import com.zj.adlib.yk3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ServerSideAdInsertionMediaSource extends BaseMediaSource implements MediaSource.MediaSourceCaller, MediaSourceEventListener, DrmSessionEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    public Handler f30845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSource f3792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final AdPlaybackStateUpdater f3793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public d f3794a;

    @Nullable
    public Timeline b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ListMultimap<Pair<Long, Object>, d> f3796a = ArrayListMultimap.create();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImmutableMap<Object, AdPlaybackState> f3795a = ImmutableMap.of();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final MediaSourceEventListener.a f3798b = createEventDispatcher(null);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final DrmSessionEventListener.a f3797b = createDrmEventDispatcher(null);

    public interface AdPlaybackStateUpdater {
        boolean a(Timeline timeline);
    }

    public static final class a implements MediaPeriod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30846a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DrmSessionEventListener.a f3799a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public MediaPeriod.Callback f3800a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MediaSource.a f3801a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MediaSourceEventListener.a f3802a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final d f3803a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean[] f3804a = new boolean[0];

        public a(d dVar, MediaSource.a aVar, MediaSourceEventListener.a aVar2, DrmSessionEventListener.a aVar3) {
            this.f3803a = dVar;
            this.f3801a = aVar;
            this.f3802a = aVar2;
            this.f3799a = aVar3;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long a(long j, w38 w38Var) {
            return this.f3803a.k(this, j, w38Var);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void c(MediaPeriod.Callback callback, long j) {
            this.f3800a = callback;
            this.f3803a.C(this, j);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean continueLoading(long j) {
            return this.f3803a.g(this, j);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void discardBuffer(long j, boolean z) {
            this.f3803a.i(this, j, z);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public ga9 e() {
            return this.f3803a.r();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long f(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            if (this.f3804a.length == 0) {
                this.f3804a = new boolean[sampleStreamArr.length];
            }
            return this.f3803a.J(this, exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getBufferedPositionUs() {
            return this.f3803a.l(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getNextLoadPositionUs() {
            return this.f3803a.o(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
            return this.f3803a.p(list);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean isLoading() {
            return this.f3803a.s(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void maybeThrowPrepareError() throws IOException {
            this.f3803a.x();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long readDiscontinuity() {
            return this.f3803a.E(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public void reevaluateBuffer(long j) {
            this.f3803a.F(this, j);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long seekToUs(long j) {
            return this.f3803a.I(this, j);
        }
    }

    public static final class b implements SampleStream {
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f30847a;

        public b(a aVar, int i) {
            this.f30847a = aVar;
            this.K = i;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int b(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i) {
            a aVar = this.f30847a;
            return aVar.f3803a.D(aVar, this.K, yk3Var, decoderInputBuffer, i);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return this.f30847a.f3803a.t(this.K);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            this.f30847a.f3803a.w(this.K);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            a aVar = this.f30847a;
            return aVar.f3803a.K(aVar, this.K, j);
        }
    }

    public static final class c extends ForwardingTimeline {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<Object, AdPlaybackState> f30848a;

        public c(Timeline timeline, ImmutableMap<Object, AdPlaybackState> immutableMap) {
            super(timeline);
            sb0.i(timeline.v() == 1);
            Timeline.b bVar = new Timeline.b();
            for (int i = 0; i < timeline.m(); i++) {
                timeline.k(i, bVar, true);
                sb0.i(immutableMap.containsKey(sb0.g(bVar.f2194b)));
            }
            this.f30848a = immutableMap;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.b k(int i, Timeline.b bVar, boolean z) {
            super.k(i, bVar, true);
            AdPlaybackState adPlaybackState = (AdPlaybackState) sb0.g(this.f30848a.get(bVar.f2194b));
            long j = bVar.f2190a;
            long jF = j == -9223372036854775807L ? adPlaybackState.b : com.google.android.exoplayer2.source.ads.a.f(j, -1, adPlaybackState);
            Timeline.b bVar2 = new Timeline.b();
            long jF2 = 0;
            for (int i2 = 0; i2 < i + 1; i2++) {
                this.b.k(i2, bVar2, true);
                AdPlaybackState adPlaybackState2 = (AdPlaybackState) sb0.g(this.f30848a.get(bVar2.f2194b));
                if (i2 == 0) {
                    jF2 = -com.google.android.exoplayer2.source.ads.a.f(-bVar2.s(), -1, adPlaybackState2);
                }
                if (i2 != i) {
                    jF2 += com.google.android.exoplayer2.source.ads.a.f(bVar2.f2190a, -1, adPlaybackState2);
                }
            }
            bVar.y(bVar.f2192a, bVar.f2194b, bVar.K, jF, jF2, adPlaybackState, bVar.f2193a);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.d u(int i, Timeline.d dVar, long j) {
            super.u(i, dVar, j);
            AdPlaybackState adPlaybackState = (AdPlaybackState) sb0.g(this.f30848a.get(sb0.g(k(dVar.K, new Timeline.b(), true).f2194b)));
            long jF = com.google.android.exoplayer2.source.ads.a.f(dVar.f, -1, adPlaybackState);
            if (dVar.f2209e == -9223372036854775807L) {
                long j2 = adPlaybackState.b;
                if (j2 != -9223372036854775807L) {
                    dVar.f2209e = j2 - jF;
                }
            } else {
                Timeline.b bVarJ = j(dVar.L, new Timeline.b());
                long j3 = bVarJ.f2190a;
                dVar.f2209e = j3 != -9223372036854775807L ? bVarJ.b + j3 : -9223372036854775807L;
            }
            dVar.f = jF;
            return dVar;
        }
    }

    public static final class d implements MediaPeriod.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaPeriod f30849a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public AdPlaybackState f3805a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public a f3806a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Object f3807a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f3810a;
        public boolean b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<a> f3808a = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Map<Long, Pair<az4, oh5>> f3809a = new HashMap();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ExoTrackSelection[] f3812a = new ExoTrackSelection[0];

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public SampleStream[] f3811a = new SampleStream[0];

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public oh5[] f3813a = new oh5[0];

        public d(MediaPeriod mediaPeriod, Object obj, AdPlaybackState adPlaybackState) {
            this.f30849a = mediaPeriod;
            this.f3807a = obj;
            this.f3805a = adPlaybackState;
        }

        public void A(az4 az4Var) {
            this.f3809a.remove(Long.valueOf(az4Var.f15414a));
        }

        public void B(az4 az4Var, oh5 oh5Var) {
            this.f3809a.put(Long.valueOf(az4Var.f15414a), Pair.create(az4Var, oh5Var));
        }

        public void C(a aVar, long j) {
            aVar.f30846a = j;
            if (this.f3810a) {
                if (this.b) {
                    ((MediaPeriod.Callback) sb0.g(aVar.f3800a)).h(aVar);
                }
            } else {
                this.f3810a = true;
                this.f30849a.c(this, com.google.android.exoplayer2.source.ads.a.g(j, aVar.f3801a, this.f3805a));
            }
        }

        public int D(a aVar, int i, yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i2) {
            int iB = ((SampleStream) gj9.k(this.f3811a[i])).b(yk3Var, decoderInputBuffer, i2 | 1 | 4);
            long jN = n(aVar, decoderInputBuffer.f30576a);
            if ((iB == -4 && jN == Long.MIN_VALUE) || (iB == -3 && l(aVar) == Long.MIN_VALUE && !decoderInputBuffer.f2589a)) {
                v(aVar, i);
                decoderInputBuffer.b();
                decoderInputBuffer.a(4);
                return -4;
            }
            if (iB == -4) {
                v(aVar, i);
                ((SampleStream) gj9.k(this.f3811a[i])).b(yk3Var, decoderInputBuffer, i2);
                decoderInputBuffer.f30576a = jN;
            }
            return iB;
        }

        public long E(a aVar) {
            if (!aVar.equals(this.f3808a.get(0))) {
                return -9223372036854775807L;
            }
            long discontinuity = this.f30849a.readDiscontinuity();
            if (discontinuity == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return com.google.android.exoplayer2.source.ads.a.d(discontinuity, aVar.f3801a, this.f3805a);
        }

        public void F(a aVar, long j) {
            this.f30849a.reevaluateBuffer(q(aVar, j));
        }

        public void G(MediaSource mediaSource) {
            mediaSource.j(this.f30849a);
        }

        public void H(a aVar) {
            if (aVar.equals(this.f3806a)) {
                this.f3806a = null;
                this.f3809a.clear();
            }
            this.f3808a.remove(aVar);
        }

        public long I(a aVar, long j) {
            return com.google.android.exoplayer2.source.ads.a.d(this.f30849a.seekToUs(com.google.android.exoplayer2.source.ads.a.g(j, aVar.f3801a, this.f3805a)), aVar.f3801a, this.f3805a);
        }

        public long J(a aVar, ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            aVar.f30846a = j;
            if (!aVar.equals(this.f3808a.get(0))) {
                for (int i = 0; i < exoTrackSelectionArr.length; i++) {
                    ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
                    boolean z = true;
                    if (exoTrackSelection != null) {
                        if (zArr[i] && sampleStreamArr[i] != null) {
                            z = false;
                        }
                        zArr2[i] = z;
                        if (z) {
                            sampleStreamArr[i] = gj9.c(this.f3812a[i], exoTrackSelection) ? new b(aVar, i) : new j13();
                        }
                    } else {
                        sampleStreamArr[i] = null;
                        zArr2[i] = true;
                    }
                }
                return j;
            }
            this.f3812a = (ExoTrackSelection[]) Arrays.copyOf(exoTrackSelectionArr, exoTrackSelectionArr.length);
            long jG = com.google.android.exoplayer2.source.ads.a.g(j, aVar.f3801a, this.f3805a);
            SampleStream[] sampleStreamArr2 = this.f3811a;
            SampleStream[] sampleStreamArr3 = sampleStreamArr2.length == 0 ? new SampleStream[exoTrackSelectionArr.length] : (SampleStream[]) Arrays.copyOf(sampleStreamArr2, sampleStreamArr2.length);
            long jF = this.f30849a.f(exoTrackSelectionArr, zArr, sampleStreamArr3, zArr2, jG);
            this.f3811a = (SampleStream[]) Arrays.copyOf(sampleStreamArr3, sampleStreamArr3.length);
            this.f3813a = (oh5[]) Arrays.copyOf(this.f3813a, sampleStreamArr3.length);
            for (int i2 = 0; i2 < sampleStreamArr3.length; i2++) {
                if (sampleStreamArr3[i2] == null) {
                    sampleStreamArr[i2] = null;
                    this.f3813a[i2] = null;
                } else if (sampleStreamArr[i2] == null || zArr2[i2]) {
                    sampleStreamArr[i2] = new b(aVar, i2);
                    this.f3813a[i2] = null;
                }
            }
            return com.google.android.exoplayer2.source.ads.a.d(jF, aVar.f3801a, this.f3805a);
        }

        public int K(a aVar, int i, long j) {
            return ((SampleStream) gj9.k(this.f3811a[i])).skipData(com.google.android.exoplayer2.source.ads.a.g(j, aVar.f3801a, this.f3805a));
        }

        public void L(AdPlaybackState adPlaybackState) {
            this.f3805a = adPlaybackState;
        }

        public void e(a aVar) {
            this.f3808a.add(aVar);
        }

        public boolean f(MediaSource.a aVar, long j) {
            a aVar2 = (a) o.w(this.f3808a);
            return com.google.android.exoplayer2.source.ads.a.g(j, aVar, this.f3805a) == com.google.android.exoplayer2.source.ads.a.g(ServerSideAdInsertionMediaSource.U(aVar2, this.f3805a), aVar2.f3801a, this.f3805a);
        }

        public boolean g(a aVar, long j) {
            a aVar2 = this.f3806a;
            if (aVar2 != null && !aVar.equals(aVar2)) {
                for (Pair<az4, oh5> pair : this.f3809a.values()) {
                    aVar2.f3802a.v((az4) pair.first, ServerSideAdInsertionMediaSource.S(aVar2, (oh5) pair.second, this.f3805a));
                    aVar.f3802a.B((az4) pair.first, ServerSideAdInsertionMediaSource.S(aVar, (oh5) pair.second, this.f3805a));
                }
            }
            this.f3806a = aVar;
            return this.f30849a.continueLoading(q(aVar, j));
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
        public void h(MediaPeriod mediaPeriod) {
            this.b = true;
            for (int i = 0; i < this.f3808a.size(); i++) {
                a aVar = this.f3808a.get(i);
                MediaPeriod.Callback callback = aVar.f3800a;
                if (callback != null) {
                    callback.h(aVar);
                }
            }
        }

        public void i(a aVar, long j, boolean z) {
            this.f30849a.discardBuffer(com.google.android.exoplayer2.source.ads.a.g(j, aVar.f3801a, this.f3805a), z);
        }

        public final int j(oh5 oh5Var) {
            String str;
            if (oh5Var.f18632a == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                ExoTrackSelection[] exoTrackSelectionArr = this.f3812a;
                if (i >= exoTrackSelectionArr.length) {
                    return -1;
                }
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
                if (exoTrackSelection != null) {
                    da9 da9VarD = exoTrackSelection.d();
                    boolean z = oh5Var.b == 0 && da9VarD.equals(r().b(0));
                    for (int i2 = 0; i2 < da9VarD.K; i2++) {
                        com.google.android.exoplayer2.d dVarC = da9VarD.c(i2);
                        if (dVarC.equals(oh5Var.f18632a) || (z && (str = dVarC.f) != null && str.equals(oh5Var.f18632a.f))) {
                            return i;
                        }
                    }
                }
                i++;
            }
        }

        public long k(a aVar, long j, w38 w38Var) {
            return com.google.android.exoplayer2.source.ads.a.d(this.f30849a.a(com.google.android.exoplayer2.source.ads.a.g(j, aVar.f3801a, this.f3805a), w38Var), aVar.f3801a, this.f3805a);
        }

        public long l(a aVar) {
            return n(aVar, this.f30849a.getBufferedPositionUs());
        }

        @Nullable
        public a m(@Nullable oh5 oh5Var) {
            if (oh5Var == null || oh5Var.f18631a == -9223372036854775807L) {
                return null;
            }
            for (int i = 0; i < this.f3808a.size(); i++) {
                a aVar = this.f3808a.get(i);
                long jD = com.google.android.exoplayer2.source.ads.a.d(gj9.Z0(oh5Var.f18631a), aVar.f3801a, this.f3805a);
                long jU = ServerSideAdInsertionMediaSource.U(aVar, this.f3805a);
                if (jD >= 0 && jD < jU) {
                    return aVar;
                }
            }
            return null;
        }

        public final long n(a aVar, long j) {
            if (j == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            long jD = com.google.android.exoplayer2.source.ads.a.d(j, aVar.f3801a, this.f3805a);
            if (jD >= ServerSideAdInsertionMediaSource.U(aVar, this.f3805a)) {
                return Long.MIN_VALUE;
            }
            return jD;
        }

        public long o(a aVar) {
            return n(aVar, this.f30849a.getNextLoadPositionUs());
        }

        public List<StreamKey> p(List<ExoTrackSelection> list) {
            return this.f30849a.getStreamKeys(list);
        }

        public final long q(a aVar, long j) {
            long j2 = aVar.f30846a;
            return j < j2 ? com.google.android.exoplayer2.source.ads.a.g(j2, aVar.f3801a, this.f3805a) - (aVar.f30846a - j) : com.google.android.exoplayer2.source.ads.a.g(j, aVar.f3801a, this.f3805a);
        }

        public ga9 r() {
            return this.f30849a.e();
        }

        public boolean s(a aVar) {
            return aVar.equals(this.f3806a) && this.f30849a.isLoading();
        }

        public boolean t(int i) {
            return ((SampleStream) gj9.k(this.f3811a[i])).isReady();
        }

        public boolean u() {
            return this.f3808a.isEmpty();
        }

        public final void v(a aVar, int i) {
            oh5 oh5Var;
            boolean[] zArr = aVar.f3804a;
            if (zArr[i] || (oh5Var = this.f3813a[i]) == null) {
                return;
            }
            zArr[i] = true;
            aVar.f3802a.j(ServerSideAdInsertionMediaSource.S(aVar, oh5Var, this.f3805a));
        }

        public void w(int i) throws IOException {
            ((SampleStream) gj9.k(this.f3811a[i])).maybeThrowError();
        }

        public void x() throws IOException {
            this.f30849a.maybeThrowPrepareError();
        }

        @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public void d(MediaPeriod mediaPeriod) {
            a aVar = this.f3806a;
            if (aVar == null) {
                return;
            }
            ((MediaPeriod.Callback) sb0.g(aVar.f3800a)).d(this.f3806a);
        }

        public void z(a aVar, oh5 oh5Var) {
            int iJ = j(oh5Var);
            if (iJ != -1) {
                this.f3813a[iJ] = oh5Var;
                aVar.f3804a[iJ] = true;
            }
        }
    }

    public ServerSideAdInsertionMediaSource(MediaSource mediaSource, @Nullable AdPlaybackStateUpdater adPlaybackStateUpdater) {
        this.f3792a = mediaSource;
        this.f3793a = adPlaybackStateUpdater;
    }

    public static oh5 S(a aVar, oh5 oh5Var, AdPlaybackState adPlaybackState) {
        return new oh5(oh5Var.f43748a, oh5Var.b, oh5Var.f18632a, oh5Var.c, oh5Var.f18633a, T(oh5Var.f18631a, aVar, adPlaybackState), T(oh5Var.f18634b, aVar, adPlaybackState));
    }

    public static long T(long j, a aVar, AdPlaybackState adPlaybackState) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long jZ0 = gj9.Z0(j);
        MediaSource.a aVar2 = aVar.f3801a;
        return gj9.H1(aVar2.c() ? com.google.android.exoplayer2.source.ads.a.e(jZ0, ((gk5) aVar2).f41928a, aVar2.b, adPlaybackState) : com.google.android.exoplayer2.source.ads.a.f(jZ0, -1, adPlaybackState));
    }

    public static long U(a aVar, AdPlaybackState adPlaybackState) {
        MediaSource.a aVar2 = aVar.f3801a;
        if (aVar2.c()) {
            AdPlaybackState.b bVarE = adPlaybackState.e(((gk5) aVar2).f41928a);
            if (bVarE.K == -1) {
                return 0L;
            }
            return bVarE.f3771a[aVar2.b];
        }
        int i = aVar2.c;
        if (i == -1) {
            return Long.MAX_VALUE;
        }
        long j = adPlaybackState.e(i).f3768a;
        if (j == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(ImmutableMap immutableMap) {
        AdPlaybackState adPlaybackState;
        for (d dVar : this.f3796a.values()) {
            AdPlaybackState adPlaybackState2 = (AdPlaybackState) immutableMap.get(dVar.f3807a);
            if (adPlaybackState2 != null) {
                dVar.L(adPlaybackState2);
            }
        }
        d dVar2 = this.f3794a;
        if (dVar2 != null && (adPlaybackState = (AdPlaybackState) immutableMap.get(dVar2.f3807a)) != null) {
            this.f3794a.L(adPlaybackState);
        }
        this.f3795a = immutableMap;
        if (this.b != null) {
            refreshSourceInfo(new c(this.b, immutableMap));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
        d dVar;
        Pair<Long, Object> pair = new Pair<>(Long.valueOf(((gk5) aVar).f16804a), ((gk5) aVar).f16805a);
        d dVar2 = this.f3794a;
        boolean z = false;
        if (dVar2 != null) {
            if (dVar2.f3807a.equals(((gk5) aVar).f16805a)) {
                dVar = this.f3794a;
                this.f3796a.put(pair, dVar);
                z = true;
            } else {
                this.f3794a.G(this.f3792a);
                dVar = null;
            }
            this.f3794a = null;
        } else {
            dVar = null;
        }
        if (dVar == null && ((dVar = (d) o.x(this.f3796a.get(pair), null)) == null || !dVar.f(aVar, j))) {
            AdPlaybackState adPlaybackState = (AdPlaybackState) sb0.g(this.f3795a.get(((gk5) aVar).f16805a));
            d dVar3 = new d(this.f3792a.F(new MediaSource.a(((gk5) aVar).f16805a, ((gk5) aVar).f16804a), allocator, com.google.android.exoplayer2.source.ads.a.g(j, aVar, adPlaybackState)), ((gk5) aVar).f16805a, adPlaybackState);
            this.f3796a.put(pair, dVar3);
            dVar = dVar3;
        }
        a aVar2 = new a(dVar, aVar, createEventDispatcher(aVar), createDrmEventDispatcher(aVar));
        dVar.e(aVar2);
        if (z && dVar.f3812a.length > 0) {
            aVar2.seekToUs(j);
        }
        return aVar2;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public void I(int i, @Nullable MediaSource.a aVar) {
        a aVarV = V(aVar, null, false);
        if (aVarV == null) {
            this.f3797b.j();
        } else {
            aVarV.f3799a.j();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void J(int i, @Nullable MediaSource.a aVar, oh5 oh5Var) {
        a aVarV = V(aVar, oh5Var, false);
        if (aVarV == null) {
            this.f3798b.j(oh5Var);
        } else {
            aVarV.f3803a.z(aVarV, oh5Var);
            aVarV.f3802a.j(S(aVarV, oh5Var, (AdPlaybackState) sb0.g(this.f3795a.get(((gk5) aVarV.f3801a).f16805a))));
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public void O(int i, @Nullable MediaSource.a aVar) {
        a aVarV = V(aVar, null, false);
        if (aVarV == null) {
            this.f3797b.i();
        } else {
            aVarV.f3799a.i();
        }
    }

    @Nullable
    public final a V(@Nullable MediaSource.a aVar, @Nullable oh5 oh5Var, boolean z) {
        if (aVar == null) {
            return null;
        }
        List<d> list = this.f3796a.get(new Pair<>(Long.valueOf(((gk5) aVar).f16804a), ((gk5) aVar).f16805a));
        if (list.isEmpty()) {
            return null;
        }
        if (z) {
            d dVar = (d) o.w(list);
            return dVar.f3806a != null ? dVar.f3806a : (a) o.w(dVar.f3808a);
        }
        for (int i = 0; i < list.size(); i++) {
            a aVarM = list.get(i).m(oh5Var);
            if (aVarM != null) {
                return aVarM;
            }
        }
        return (a) list.get(0).f3808a.get(0);
    }

    public final void X() {
        d dVar = this.f3794a;
        if (dVar != null) {
            dVar.G(this.f3792a);
            this.f3794a = null;
        }
    }

    public void Y(final ImmutableMap<Object, AdPlaybackState> immutableMap) {
        sb0.a(!immutableMap.isEmpty());
        Object objG = sb0.g(immutableMap.values().asList().get(0).f3766a);
        UnmodifiableIterator<Map.Entry<Object, AdPlaybackState>> it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, AdPlaybackState> next = it.next();
            Object key = next.getKey();
            AdPlaybackState value = next.getValue();
            sb0.a(gj9.c(objG, value.f3766a));
            AdPlaybackState adPlaybackState = this.f3795a.get(key);
            if (adPlaybackState != null) {
                for (int i = value.L; i < value.K; i++) {
                    AdPlaybackState.b bVarE = value.e(i);
                    sb0.a(bVarE.f3769a);
                    if (i < adPlaybackState.K) {
                        sb0.a(com.google.android.exoplayer2.source.ads.a.c(value, i) >= com.google.android.exoplayer2.source.ads.a.c(adPlaybackState, i));
                    }
                    if (bVarE.f3768a == Long.MIN_VALUE) {
                        sb0.a(com.google.android.exoplayer2.source.ads.a.c(value, i) == 0);
                    }
                }
            }
        }
        synchronized (this) {
            Handler handler = this.f30845a;
            if (handler == null) {
                this.f3795a = immutableMap;
            } else {
                handler.post(new Runnable() { // from class: com.zj.adlib.b68
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f40687a.W(immutableMap);
                    }
                });
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public g b() {
        return this.f3792a.b();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void disableInternal() {
        X();
        this.f3792a.B(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void e(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var) {
        a aVarV = V(aVar, oh5Var, true);
        if (aVarV == null) {
            this.f3798b.v(az4Var, oh5Var);
        } else {
            aVarV.f3803a.A(az4Var);
            aVarV.f3802a.v(az4Var, S(aVarV, oh5Var, (AdPlaybackState) sb0.g(this.f3795a.get(((gk5) aVarV.f3801a).f16805a))));
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void enableInternal() {
        this.f3792a.H(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void j(MediaPeriod mediaPeriod) {
        a aVar = (a) mediaPeriod;
        aVar.f3803a.H(aVar);
        if (aVar.f3803a.u()) {
            this.f3796a.remove(new Pair(Long.valueOf(((gk5) aVar.f3801a).f16804a), ((gk5) aVar.f3801a).f16805a), aVar.f3803a);
            if (this.f3796a.isEmpty()) {
                this.f3794a = aVar.f3803a;
            } else {
                aVar.f3803a.G(this.f3792a);
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public void k(int i, @Nullable MediaSource.a aVar) {
        a aVarV = V(aVar, null, false);
        if (aVarV == null) {
            this.f3797b.m();
        } else {
            aVarV.f3799a.m();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void l(int i, MediaSource.a aVar, oh5 oh5Var) {
        a aVarV = V(aVar, oh5Var, false);
        if (aVarV == null) {
            this.f3798b.E(oh5Var);
        } else {
            aVarV.f3802a.E(S(aVarV, oh5Var, (AdPlaybackState) sb0.g(this.f3795a.get(((gk5) aVarV.f3801a).f16805a))));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void m(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var) {
        a aVarV = V(aVar, oh5Var, true);
        if (aVarV == null) {
            this.f3798b.B(az4Var, oh5Var);
        } else {
            aVarV.f3803a.B(az4Var, oh5Var);
            aVarV.f3802a.B(az4Var, S(aVarV, oh5Var, (AdPlaybackState) sb0.g(this.f3795a.get(((gk5) aVarV.f3801a).f16805a))));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.f3792a.maybeThrowSourceInfoRefreshError();
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public void n(int i, @Nullable MediaSource.a aVar, Exception exc) {
        a aVarV = V(aVar, null, false);
        if (aVarV == null) {
            this.f3797b.l(exc);
        } else {
            aVarV.f3799a.l(exc);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public void o(int i, @Nullable MediaSource.a aVar) {
        a aVarV = V(aVar, null, false);
        if (aVarV == null) {
            this.f3797b.h();
        } else {
            aVarV.f3799a.h();
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        Handler handlerY = gj9.y();
        synchronized (this) {
            this.f30845a = handlerY;
        }
        this.f3792a.C(handlerY, this);
        this.f3792a.t(handlerY, this);
        this.f3792a.x(this, transferListener, getPlayerId());
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
    public void r(MediaSource mediaSource, Timeline timeline) {
        this.b = timeline;
        AdPlaybackStateUpdater adPlaybackStateUpdater = this.f3793a;
        if ((adPlaybackStateUpdater == null || !adPlaybackStateUpdater.a(timeline)) && !this.f3795a.isEmpty()) {
            refreshSourceInfo(new c(timeline, this.f3795a));
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        X();
        this.b = null;
        synchronized (this) {
            this.f30845a = null;
        }
        this.f3792a.L(this);
        this.f3792a.G(this);
        this.f3792a.g(this);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public void v(int i, @Nullable MediaSource.a aVar, int i2) {
        a aVarV = V(aVar, null, true);
        if (aVarV == null) {
            this.f3797b.k(i2);
        } else {
            aVarV.f3799a.k(i2);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void w(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var) {
        a aVarV = V(aVar, oh5Var, true);
        if (aVarV == null) {
            this.f3798b.s(az4Var, oh5Var);
        } else {
            aVarV.f3803a.A(az4Var);
            aVarV.f3802a.s(az4Var, S(aVarV, oh5Var, (AdPlaybackState) sb0.g(this.f3795a.get(((gk5) aVarV.f3801a).f16805a))));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void y(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var, IOException iOException, boolean z) {
        a aVarV = V(aVar, oh5Var, true);
        if (aVarV == null) {
            this.f3798b.y(az4Var, oh5Var, iOException, z);
            return;
        }
        if (z) {
            aVarV.f3803a.A(az4Var);
        }
        aVarV.f3802a.y(az4Var, S(aVarV, oh5Var, (AdPlaybackState) sb0.g(this.f3795a.get(((gk5) aVarV.f3801a).f16805a))), iOException, z);
    }
}
