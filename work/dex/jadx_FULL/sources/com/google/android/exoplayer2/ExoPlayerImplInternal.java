package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.zj.adlib.at6;
import com.zj.adlib.fk5;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.gk5;
import com.zj.adlib.hk5;
import com.zj.adlib.rs6;
import com.zj.adlib.sb0;
import com.zj.adlib.ue7;
import com.zj.adlib.w38;
import com.zj.adlib.wa9;
import com.zj.adlib.y99;
import com.zj.adlib.z39;
import com.zj.adlib.za3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList.MediaSourceListInfoRefreshListener, DefaultMediaClock.PlaybackParametersListener, PlayerMessage.Sender {
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 3;
    public static final int R = 4;
    public static final int S = 5;
    public static final int T = 6;
    public static final int U = 7;
    public static final int V = 8;
    public static final int W = 9;
    public static final int X = 10;
    public static final int Y = 11;
    public static final int Z = 12;
    public static final int a0 = 13;
    public static final int b0 = 14;
    public static final int c0 = 15;
    public static final int d0 = 16;
    public static final int e0 = 17;
    public static final long f = 4000;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final String f2056f = "ExoPlayerImplInternal";
    public static final int f0 = 18;
    public static final int g0 = 19;
    public static final int h0 = 20;
    public static final int i0 = 21;
    public static final int j0 = 22;
    public static final int k0 = 23;
    public static final int l0 = 24;
    public static final int m0 = 25;
    public static final int n0 = 10;
    public static final int o0 = 1000;
    public int K;
    public int L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30483a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HandlerThread f2057a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Looper f2058a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DefaultMediaClock f2059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ExoPlaybackException f2060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PlaybackInfoUpdateListener f2061a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f2062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public g f2063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LivePlaybackSpeedControl f2064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadControl f2065a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSourceList f2066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.b f2067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.d f2068a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final h f2069a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TrackSelector f2070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BandwidthMeter f2071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f2072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HandlerWrapper f2073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public rs6 f2074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public w38 f2075a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final wa9 f2076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<d> f2077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set<Renderer> f2078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Renderer[] f2080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RendererCapabilities[] f2081a;
    public final long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2082b;
    public long c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2083c;
    public long d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f2084d;
    public long e = -9223372036854775807L;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f2085e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f2086f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;

    public interface PlaybackInfoUpdateListener {
        void a(e eVar);
    }

    public class a implements Renderer.WakeupListener {
        public a() {
        }

        @Override // com.google.android.exoplayer2.Renderer.WakeupListener
        public void onSleep() {
            ExoPlayerImplInternal.this.i = true;
        }

        @Override // com.google.android.exoplayer2.Renderer.WakeupListener
        public void onWakeup() {
            ExoPlayerImplInternal.this.f2073a.sendEmptyMessage(2);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30485a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f2087a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ShuffleOrder f2088a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<MediaSourceList.c> f2089a;

        public /* synthetic */ b(List list, ShuffleOrder shuffleOrder, int i, long j, a aVar) {
            this(list, shuffleOrder, i, j);
        }

        public b(List<MediaSourceList.c> list, ShuffleOrder shuffleOrder, int i, long j) {
            this.f2089a = list;
            this.f2088a = shuffleOrder;
            this.f30485a = i;
            this.f2087a = j;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30486a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ShuffleOrder f2090a;
        public final int b;
        public final int c;

        public c(int i, int i2, int i3, ShuffleOrder shuffleOrder) {
            this.f30486a = i;
            this.b = i2;
            this.c = i3;
            this.f2090a = shuffleOrder;
        }
    }

    public static final class d implements Comparable<d> {
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30487a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final PlayerMessage f2091a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Object f2092a;

        public d(PlayerMessage playerMessage) {
            this.f2091a = playerMessage;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.f2092a;
            if ((obj == null) != (dVar.f2092a == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.K - dVar.K;
            return i != 0 ? i : gj9.q(this.f30487a, dVar.f30487a);
        }

        public void b(int i, long j, Object obj) {
            this.K = i;
            this.f30487a = j;
            this.f2092a = obj;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30488a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public rs6 f2093a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f2094a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f2095b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f2096c;

        public e(rs6 rs6Var) {
            this.f2093a = rs6Var;
        }

        public void b(int i) {
            this.f2094a |= i > 0;
            this.f30488a += i;
        }

        public void c(int i) {
            this.f2094a = true;
            this.f2096c = true;
            this.c = i;
        }

        public void d(rs6 rs6Var) {
            this.f2094a |= this.f2093a != rs6Var;
            this.f2093a = rs6Var;
        }

        public void e(int i) {
            if (this.f2095b && this.b != 5) {
                sb0.a(i == 5);
                return;
            }
            this.f2094a = true;
            this.f2095b = true;
            this.b = i;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30489a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MediaSource.a f2097a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f2098a;
        public final long b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final boolean f2099b;
        public final boolean c;

        public f(MediaSource.a aVar, long j, long j2, boolean z, boolean z2, boolean z3) {
            this.f2097a = aVar;
            this.f30489a = j;
            this.b = j2;
            this.f2098a = z;
            this.f2099b = z2;
            this.c = z3;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30490a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f2100a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Timeline f2101a;

        public g(Timeline timeline, int i, long j) {
            this.f2101a = timeline;
            this.f30490a = i;
            this.f2100a = j;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, wa9 wa9Var, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i, boolean z, AnalyticsCollector analyticsCollector, w38 w38Var, LivePlaybackSpeedControl livePlaybackSpeedControl, long j, boolean z2, Looper looper, Clock clock, PlaybackInfoUpdateListener playbackInfoUpdateListener, at6 at6Var) {
        this.f2061a = playbackInfoUpdateListener;
        this.f2080a = rendererArr;
        this.f2070a = trackSelector;
        this.f2076a = wa9Var;
        this.f2065a = loadControl;
        this.f2071a = bandwidthMeter;
        this.K = i;
        this.g = z;
        this.f2075a = w38Var;
        this.f2064a = livePlaybackSpeedControl;
        this.b = j;
        this.d = j;
        this.f2083c = z2;
        this.f2072a = clock;
        this.f30483a = loadControl.getBackBufferDurationUs();
        this.f2079a = loadControl.retainBackBufferFromKeyframe();
        rs6 rs6VarJ = rs6.j(wa9Var);
        this.f2074a = rs6VarJ;
        this.f2062a = new e(rs6VarJ);
        this.f2081a = new RendererCapabilities[rendererArr.length];
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            rendererArr[i2].g(i2, at6Var);
            this.f2081a[i2] = rendererArr[i2].a();
        }
        this.f2059a = new DefaultMediaClock(this, clock);
        this.f2077a = new ArrayList<>();
        this.f2078a = Sets.z();
        this.f2068a = new Timeline.d();
        this.f2067a = new Timeline.b();
        trackSelector.b(this, bandwidthMeter);
        this.k = true;
        Handler handler = new Handler(looper);
        this.f2069a = new h(analyticsCollector, handler);
        this.f2066a = new MediaSourceList(this, analyticsCollector, handler, at6Var);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f2057a = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f2058a = looper2;
        this.f2073a = clock.a(looper2, this);
    }

    public static boolean N(boolean z, MediaSource.a aVar, long j, MediaSource.a aVar2, Timeline.b bVar, long j2) {
        if (z || j != j2 || !((gk5) aVar).f16805a.equals(((gk5) aVar2).f16805a)) {
            return false;
        }
        if (aVar.c() && bVar.v(((gk5) aVar).f41928a)) {
            return (bVar.k(((gk5) aVar).f41928a, aVar.b) == 4 || bVar.k(((gk5) aVar).f41928a, aVar.b) == 2) ? false : true;
        }
        return aVar2.c() && bVar.v(((gk5) aVar2).f41928a);
    }

    public static boolean P(Renderer renderer) {
        return renderer.getState() != 0;
    }

    public static boolean R(rs6 rs6Var, Timeline.b bVar) {
        MediaSource.a aVar = rs6Var.f19410a;
        Timeline timeline = rs6Var.f19408a;
        return timeline.w() || timeline.l(((gk5) aVar).f16805a, bVar).f2193a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean S() {
        return Boolean.valueOf(this.f2082b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(PlayerMessage playerMessage) {
        try {
            l(playerMessage);
        } catch (ExoPlaybackException e2) {
            Log.e(f2056f, "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    public static void t0(Timeline timeline, d dVar, Timeline.d dVar2, Timeline.b bVar) {
        int i = timeline.t(timeline.l(dVar.f2092a, bVar).K, dVar2).L;
        Object obj = timeline.k(i, bVar, true).f2194b;
        long j = bVar.f2190a;
        dVar.b(i, j != -9223372036854775807L ? j - 1 : Long.MAX_VALUE, obj);
    }

    public static boolean u0(d dVar, Timeline timeline, Timeline timeline2, int i, boolean z, Timeline.d dVar2, Timeline.b bVar) {
        Object obj = dVar.f2092a;
        if (obj == null) {
            Pair<Object, Long> pairX0 = x0(timeline, new g(dVar.f2091a.j(), dVar.f2091a.f(), dVar.f2091a.h() == Long.MIN_VALUE ? -9223372036854775807L : gj9.Z0(dVar.f2091a.h())), false, i, z, dVar2, bVar);
            if (pairX0 == null) {
                return false;
            }
            dVar.b(timeline.f(pairX0.first), ((Long) pairX0.second).longValue(), pairX0.first);
            if (dVar.f2091a.h() == Long.MIN_VALUE) {
                t0(timeline, dVar, dVar2, bVar);
            }
            return true;
        }
        int iF = timeline.f(obj);
        if (iF == -1) {
            return false;
        }
        if (dVar.f2091a.h() == Long.MIN_VALUE) {
            t0(timeline, dVar, dVar2, bVar);
            return true;
        }
        dVar.K = iF;
        timeline2.l(dVar.f2092a, bVar);
        if (bVar.f2193a && timeline2.t(bVar.K, dVar2).K == timeline2.f(dVar.f2092a)) {
            Pair<Object, Long> pairP = timeline.p(dVar2, bVar, timeline.l(dVar.f2092a, bVar).K, dVar.f30487a + bVar.s());
            dVar.b(timeline.f(pairP.first), ((Long) pairP.second).longValue(), pairP.first);
        }
        return true;
    }

    public static com.google.android.exoplayer2.d[] w(ExoTrackSelection exoTrackSelection) {
        int length = exoTrackSelection != null ? exoTrackSelection.length() : 0;
        com.google.android.exoplayer2.d[] dVarArr = new com.google.android.exoplayer2.d[length];
        for (int i = 0; i < length; i++) {
            dVarArr[i] = exoTrackSelection.e(i);
        }
        return dVarArr;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0157  */
    /* JADX WARN: Code duplicated, block: B:51:0x0175  */
    /* JADX WARN: Code duplicated, block: B:59:0x018b  */
    /* JADX WARN: Code duplicated, block: B:68:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:72:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:75:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:78:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:80:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:81:0x01de  */
    public static f w0(Timeline timeline, rs6 rs6Var, @Nullable g gVar, h hVar, int i, boolean z, Timeline.d dVar, Timeline.b bVar) {
        MediaSource.a aVar;
        int i2;
        MediaSource.a aVar2;
        int i3;
        long jLongValue;
        boolean z2;
        boolean z3;
        boolean z4;
        int iE;
        int iE2;
        boolean z5;
        long j;
        MediaSource.a aVarC;
        int i4;
        boolean z6;
        boolean z7;
        MediaSource.a aVar3;
        int i5;
        int iE3;
        boolean z8;
        boolean z9;
        boolean z10;
        if (timeline.w()) {
            return new f(rs6.k(), 0L, -9223372036854775807L, false, true, false);
        }
        MediaSource.a aVar4 = rs6Var.f19410a;
        Object obj = ((gk5) aVar4).f16805a;
        boolean zR = R(rs6Var, bVar);
        long j2 = (rs6Var.f19410a.c() || zR) ? rs6Var.f19406a : rs6Var.e;
        if (gVar != null) {
            aVar = aVar4;
            i2 = -1;
            Pair<Object, Long> pairX0 = x0(timeline, gVar, true, i, z, dVar, bVar);
            if (pairX0 == null) {
                iE3 = timeline.e(z);
                jLongValue = j2;
                z8 = false;
                z9 = false;
                z10 = true;
            } else {
                if (gVar.f2100a == -9223372036854775807L) {
                    iE3 = timeline.l(pairX0.first, bVar).K;
                    jLongValue = j2;
                    z8 = false;
                } else {
                    obj = pairX0.first;
                    jLongValue = ((Long) pairX0.second).longValue();
                    iE3 = -1;
                    z8 = true;
                }
                z9 = rs6Var.f44526a == 4;
                z10 = false;
            }
            z4 = z8;
            z2 = z9;
            z3 = z10;
            i3 = iE3;
        } else {
            aVar = aVar4;
            i2 = -1;
            if (!rs6Var.f19408a.w()) {
                if (timeline.f(obj) == -1) {
                    Object objY0 = y0(dVar, bVar, i, z, obj, rs6Var.f19408a, timeline);
                    if (objY0 == null) {
                        iE2 = timeline.e(z);
                        z5 = true;
                    } else {
                        iE2 = timeline.l(objY0, bVar).K;
                        z5 = false;
                    }
                    i3 = iE2;
                    z3 = z5;
                    jLongValue = j2;
                    z2 = false;
                    z4 = false;
                } else if (j2 == -9223372036854775807L) {
                    iE = timeline.l(obj, bVar).K;
                } else if (zR) {
                    aVar2 = aVar;
                    rs6Var.f19408a.l(((gk5) aVar2).f16805a, bVar);
                    if (rs6Var.f19408a.t(bVar.K, dVar).K == rs6Var.f19408a.f(((gk5) aVar2).f16805a)) {
                        Pair<Object, Long> pairP = timeline.p(dVar, bVar, timeline.l(obj, bVar).K, j2 + bVar.s());
                        obj = pairP.first;
                        jLongValue = ((Long) pairP.second).longValue();
                    } else {
                        jLongValue = j2;
                    }
                    i3 = -1;
                    z2 = false;
                    z3 = false;
                    z4 = true;
                } else {
                    aVar2 = aVar;
                    i3 = -1;
                    jLongValue = j2;
                    z2 = false;
                    z3 = false;
                    z4 = false;
                }
                if (i3 != i2) {
                    Pair<Object, Long> pairP2 = timeline.p(dVar, bVar, i3, -9223372036854775807L);
                    obj = pairP2.first;
                    jLongValue = ((Long) pairP2.second).longValue();
                    j = -9223372036854775807L;
                } else {
                    j = jLongValue;
                }
                aVarC = hVar.C(timeline, obj, jLongValue);
                i4 = aVarC.c;
                if (i4 != i2 || ((i5 = aVar2.c) != i2 && i4 >= i5)) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = (((gk5) aVar2).f16805a.equals(obj) || aVar2.c() || aVarC.c() || !z6) ? false : true;
                aVar3 = aVar2;
                boolean zN = N(zR, aVar2, j2, aVarC, timeline.l(obj, bVar), j);
                if (z7 || zN) {
                    aVarC = aVar3;
                }
                if (aVarC.c()) {
                    if (aVarC.equals(aVar3)) {
                        jLongValue = rs6Var.e;
                    } else {
                        timeline.l(((gk5) aVarC).f16805a, bVar);
                        if (aVarC.b == bVar.p(((gk5) aVarC).f41928a)) {
                            jLongValue = bVar.j();
                        } else {
                            jLongValue = 0;
                        }
                    }
                }
                return new f(aVarC, jLongValue, j, z2, z3, z4);
            }
            iE = timeline.e(z);
            i3 = iE;
            jLongValue = j2;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        aVar2 = aVar;
        if (i3 != i2) {
            Pair<Object, Long> pairP3 = timeline.p(dVar, bVar, i3, -9223372036854775807L);
            obj = pairP3.first;
            jLongValue = ((Long) pairP3.second).longValue();
            j = -9223372036854775807L;
        } else {
            j = jLongValue;
        }
        aVarC = hVar.C(timeline, obj, jLongValue);
        i4 = aVarC.c;
        if (i4 != i2) {
            z6 = true;
        } else {
            z6 = true;
        }
        if (((gk5) aVar2).f16805a.equals(obj)) {
        }
        aVar3 = aVar2;
        boolean zN2 = N(zR, aVar2, j2, aVarC, timeline.l(obj, bVar), j);
        if (z7) {
            aVarC = aVar3;
        } else {
            aVarC = aVar3;
        }
        if (aVarC.c()) {
            if (aVarC.equals(aVar3)) {
                jLongValue = rs6Var.e;
            } else {
                timeline.l(((gk5) aVarC).f16805a, bVar);
                if (aVarC.b == bVar.p(((gk5) aVarC).f41928a)) {
                    jLongValue = bVar.j();
                } else {
                    jLongValue = 0;
                }
            }
        }
        return new f(aVarC, jLongValue, j, z2, z3, z4);
    }

    @Nullable
    public static Pair<Object, Long> x0(Timeline timeline, g gVar, boolean z, int i, boolean z2, Timeline.d dVar, Timeline.b bVar) {
        Object objY0;
        Timeline timeline2 = gVar.f2101a;
        if (timeline.w()) {
            return null;
        }
        Timeline timeline3 = timeline2.w() ? timeline : timeline2;
        try {
            Pair<Object, Long> pairP = timeline3.p(dVar, bVar, gVar.f30490a, gVar.f2100a);
            if (timeline.equals(timeline3)) {
                return pairP;
            }
            if (timeline.f(pairP.first) != -1) {
                return (timeline3.l(pairP.first, bVar).f2193a && timeline3.t(bVar.K, dVar).K == timeline3.f(pairP.first)) ? timeline.p(dVar, bVar, timeline.l(pairP.first, bVar).K, gVar.f2100a) : pairP;
            }
            if (z && (objY0 = y0(dVar, bVar, i, z2, pairP.first, timeline3, timeline)) != null) {
                return timeline.p(dVar, bVar, timeline.l(objY0, bVar).K, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    @Nullable
    public static Object y0(Timeline.d dVar, Timeline.b bVar, int i, boolean z, Object obj, Timeline timeline, Timeline timeline2) {
        int iF = timeline.f(obj);
        int iM = timeline.m();
        int iH = iF;
        int iF2 = -1;
        for (int i2 = 0; i2 < iM && iF2 == -1; i2++) {
            iH = timeline.h(iH, bVar, dVar, i, z);
            if (iH == -1) {
                break;
            }
            iF2 = timeline2.f(timeline.s(iH));
        }
        if (iF2 == -1) {
            return null;
        }
        return timeline2.s(iF2);
    }

    public Looper A() {
        return this.f2058a;
    }

    public void A0(Timeline timeline, int i, long j) {
        this.f2073a.b(3, new g(timeline, i, j)).sendToTarget();
    }

    public final long B() {
        return C(this.f2074a.f19418c);
    }

    public final void B0(boolean z) throws ExoPlaybackException {
        MediaSource.a aVar = this.f2069a.p().f16545a.f16997a;
        long jE0 = E0(aVar, this.f2074a.e, true, false);
        if (jE0 != this.f2074a.e) {
            rs6 rs6Var = this.f2074a;
            this.f2074a = K(aVar, jE0, rs6Var.f19406a, rs6Var.f19415b, z, 5);
        }
    }

    public final long C(long j) {
        fk5 fk5VarJ = this.f2069a.j();
        if (fk5VarJ == null) {
            return 0L;
        }
        return Math.max(0L, j - fk5VarJ.y(this.c));
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00ac A[Catch: all -> 0x0148, TryCatch #1 {all -> 0x0148, blocks: (B:22:0x00a2, B:24:0x00ac, B:27:0x00b2, B:29:0x00b8, B:30:0x00bb, B:32:0x00c1, B:34:0x00cb, B:36:0x00d3, B:40:0x00db, B:42:0x00e5, B:44:0x00f5, B:48:0x00ff, B:52:0x0111, B:56:0x011a), top: B:74:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x00af  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b2 A[Catch: all -> 0x0148, TryCatch #1 {all -> 0x0148, blocks: (B:22:0x00a2, B:24:0x00ac, B:27:0x00b2, B:29:0x00b8, B:30:0x00bb, B:32:0x00c1, B:34:0x00cb, B:36:0x00d3, B:40:0x00db, B:42:0x00e5, B:44:0x00f5, B:48:0x00ff, B:52:0x0111, B:56:0x011a), top: B:74:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00b8 A[Catch: all -> 0x0148, TryCatch #1 {all -> 0x0148, blocks: (B:22:0x00a2, B:24:0x00ac, B:27:0x00b2, B:29:0x00b8, B:30:0x00bb, B:32:0x00c1, B:34:0x00cb, B:36:0x00d3, B:40:0x00db, B:42:0x00e5, B:44:0x00f5, B:48:0x00ff, B:52:0x0111, B:56:0x011a), top: B:74:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00c1 A[Catch: all -> 0x0148, TryCatch #1 {all -> 0x0148, blocks: (B:22:0x00a2, B:24:0x00ac, B:27:0x00b2, B:29:0x00b8, B:30:0x00bb, B:32:0x00c1, B:34:0x00cb, B:36:0x00d3, B:40:0x00db, B:42:0x00e5, B:44:0x00f5, B:48:0x00ff, B:52:0x0111, B:56:0x011a), top: B:74:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00cb A[Catch: all -> 0x0148, TryCatch #1 {all -> 0x0148, blocks: (B:22:0x00a2, B:24:0x00ac, B:27:0x00b2, B:29:0x00b8, B:30:0x00bb, B:32:0x00c1, B:34:0x00cb, B:36:0x00d3, B:40:0x00db, B:42:0x00e5, B:44:0x00f5, B:48:0x00ff, B:52:0x0111, B:56:0x011a), top: B:74:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:51:0x0110  */
    /* JADX WARN: Code duplicated, block: B:54:0x0117  */
    /* JADX WARN: Code duplicated, block: B:55:0x0119  */
    /* JADX WARN: Code duplicated, block: B:60:0x0123  */
    public final void C0(g gVar) throws Throwable {
        long jLongValue;
        long j;
        boolean z;
        MediaSource.a aVar;
        long j2;
        long j3;
        long j4;
        long jA;
        boolean z2;
        long jD0;
        boolean z3;
        long j5;
        fk5 fk5VarP;
        rs6 rs6Var;
        int i;
        this.f2062a.b(1);
        Pair<Object, Long> pairX0 = x0(this.f2074a.f19408a, gVar, true, this.K, this.g, this.f2068a, this.f2067a);
        try {
            if (pairX0 != null) {
                Object obj = pairX0.first;
                jLongValue = ((Long) pairX0.second).longValue();
                long j6 = gVar.f2100a == -9223372036854775807L ? -9223372036854775807L : jLongValue;
                MediaSource.a aVarC = this.f2069a.C(this.f2074a.f19408a, obj, jLongValue);
                if (aVarC.c()) {
                    this.f2074a.f19408a.l(((gk5) aVarC).f16805a, this.f2067a);
                    j2 = this.f2067a.p(((gk5) aVarC).f41928a) == aVarC.b ? this.f2067a.j() : 0L;
                    j3 = j6;
                    aVar = aVarC;
                    z = true;
                } else {
                    j = j6;
                    z = gVar.f2100a == -9223372036854775807L;
                    aVar = aVarC;
                }
                if (this.f2074a.f19408a.w()) {
                    if (pairX0 == null) {
                        if (this.f2074a.f44526a != 1) {
                            d1(4);
                        }
                        q0(false, true, false, true);
                    } else {
                        if (aVar.equals(this.f2074a.f19410a)) {
                            fk5VarP = this.f2069a.p();
                            if (fk5VarP == null && fk5VarP.f16548a && j2 != 0) {
                                jA = fk5VarP.f16541a.a(j2, this.f2075a);
                            } else {
                                jA = j2;
                            }
                            if (gj9.H1(jA) == gj9.H1(this.f2074a.e) && ((i = (rs6Var = this.f2074a).f44526a) == 2 || i == 3)) {
                                long j7 = rs6Var.e;
                                this.f2074a = K(aVar, j7, j3, j7, z, 2);
                                return;
                            }
                        } else {
                            jA = j2;
                        }
                        if (this.f2074a.f44526a == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        jD0 = D0(aVar, jA, z2);
                        z3 = (j2 != jD0) | z;
                        try {
                            rs6 rs6Var2 = this.f2074a;
                            Timeline timeline = rs6Var2.f19408a;
                            r1(timeline, aVar, timeline, rs6Var2.f19410a, j3);
                            z = z3;
                            j5 = jD0;
                        } catch (Throwable th) {
                            th = th;
                            z = z3;
                            j4 = jD0;
                            this.f2074a = K(aVar, j4, j3, j4, z, 2);
                            throw th;
                        }
                    }
                    this.f2074a = K(aVar, j5, j3, j5, z, 2);
                    return;
                }
                this.f2063a = gVar;
                j5 = j2;
                this.f2074a = K(aVar, j5, j3, j5, z, 2);
                return;
            }
            Pair<MediaSource.a, Long> pairZ = z(this.f2074a.f19408a);
            aVar = (MediaSource.a) pairZ.first;
            jLongValue = ((Long) pairZ.second).longValue();
            z = !this.f2074a.f19408a.w();
            j = -9223372036854775807L;
            if (this.f2074a.f19408a.w()) {
                if (pairX0 == null) {
                    if (this.f2074a.f44526a != 1) {
                        d1(4);
                    }
                    q0(false, true, false, true);
                } else {
                    if (aVar.equals(this.f2074a.f19410a)) {
                        fk5VarP = this.f2069a.p();
                        if (fk5VarP == null) {
                            jA = j2;
                        } else {
                            jA = j2;
                        }
                        if (gj9.H1(jA) == gj9.H1(this.f2074a.e)) {
                            long j8 = rs6Var.e;
                            this.f2074a = K(aVar, j8, j3, j8, z, 2);
                            return;
                        }
                    } else {
                        jA = j2;
                    }
                    if (this.f2074a.f44526a == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    jD0 = D0(aVar, jA, z2);
                    z3 = (j2 != jD0) | z;
                    rs6 rs6Var3 = this.f2074a;
                    Timeline timeline2 = rs6Var3.f19408a;
                    r1(timeline2, aVar, timeline2, rs6Var3.f19410a, j3);
                    z = z3;
                    j5 = jD0;
                }
                this.f2074a = K(aVar, j5, j3, j5, z, 2);
                return;
            }
            this.f2063a = gVar;
            j5 = j2;
            this.f2074a = K(aVar, j5, j3, j5, z, 2);
            return;
        } catch (Throwable th2) {
            th = th2;
            j4 = j2;
        }
        j2 = jLongValue;
        j3 = j;
    }

    public final void D(MediaPeriod mediaPeriod) {
        if (this.f2069a.v(mediaPeriod)) {
            this.f2069a.y(this.c);
            U();
        }
    }

    public final long D0(MediaSource.a aVar, long j, boolean z) throws ExoPlaybackException {
        return E0(aVar, j, this.f2069a.p() != this.f2069a.q(), z);
    }

    public final void E(IOException iOException, int i) {
        ExoPlaybackException exoPlaybackExceptionCreateForSource = ExoPlaybackException.createForSource(iOException, i);
        fk5 fk5VarP = this.f2069a.p();
        if (fk5VarP != null) {
            exoPlaybackExceptionCreateForSource = exoPlaybackExceptionCreateForSource.copyWithMediaPeriodId(fk5VarP.f16545a.f16997a);
        }
        Log.e(f2056f, "Playback error", exoPlaybackExceptionCreateForSource);
        l1(false, false);
        this.f2074a = this.f2074a.e(exoPlaybackExceptionCreateForSource);
    }

    public final long E0(MediaSource.a aVar, long j, boolean z, boolean z2) throws ExoPlaybackException {
        m1();
        this.f2085e = false;
        if (z2 || this.f2074a.f44526a == 3) {
            d1(2);
        }
        fk5 fk5VarP = this.f2069a.p();
        fk5 fk5VarJ = fk5VarP;
        while (fk5VarJ != null && !aVar.equals(fk5VarJ.f16545a.f16997a)) {
            fk5VarJ = fk5VarJ.j();
        }
        if (z || fk5VarP != fk5VarJ || (fk5VarJ != null && fk5VarJ.z(j) < 0)) {
            for (Renderer renderer : this.f2080a) {
                m(renderer);
            }
            if (fk5VarJ != null) {
                while (this.f2069a.p() != fk5VarJ) {
                    this.f2069a.b();
                }
                this.f2069a.z(fk5VarJ);
                fk5VarJ.x(1000000000000L);
                p();
            }
        }
        if (fk5VarJ != null) {
            this.f2069a.z(fk5VarJ);
            if (!fk5VarJ.f16548a) {
                fk5VarJ.f16545a = fk5VarJ.f16545a.b(j);
            } else if (fk5VarJ.b) {
                long jSeekToUs = fk5VarJ.f16541a.seekToUs(j);
                fk5VarJ.f16541a.discardBuffer(jSeekToUs - this.f30483a, this.f2079a);
                j = jSeekToUs;
            }
            s0(j);
            U();
        } else {
            this.f2069a.f();
            s0(j);
        }
        F(false);
        this.f2073a.sendEmptyMessage(2);
        return j;
    }

    public final void F(boolean z) {
        fk5 fk5VarJ = this.f2069a.j();
        MediaSource.a aVar = fk5VarJ == null ? this.f2074a.f19410a : fk5VarJ.f16545a.f16997a;
        boolean z2 = !this.f2074a.f19416b.equals(aVar);
        if (z2) {
            this.f2074a = this.f2074a.b(aVar);
        }
        rs6 rs6Var = this.f2074a;
        rs6Var.f19418c = fk5VarJ == null ? rs6Var.e : fk5VarJ.i();
        this.f2074a.d = B();
        if ((z2 || z) && fk5VarJ != null && fk5VarJ.f16548a) {
            o1(fk5VarJ.n(), fk5VarJ.o());
        }
    }

    public final void F0(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.h() == -9223372036854775807L) {
            G0(playerMessage);
            return;
        }
        if (this.f2074a.f19408a.w()) {
            this.f2077a.add(new d(playerMessage));
            return;
        }
        d dVar = new d(playerMessage);
        Timeline timeline = this.f2074a.f19408a;
        if (!u0(dVar, timeline, timeline, this.K, this.g, this.f2068a, this.f2067a)) {
            playerMessage.l(false);
        } else {
            this.f2077a.add(dVar);
            Collections.sort(this.f2077a);
        }
    }

    public final void G(Timeline timeline, boolean z) throws Throwable {
        int i;
        int i2;
        boolean z2;
        f fVarW0 = w0(timeline, this.f2074a, this.f2063a, this.f2069a, this.K, this.g, this.f2068a, this.f2067a);
        MediaSource.a aVar = fVarW0.f2097a;
        long j = fVarW0.b;
        boolean z3 = fVarW0.f2098a;
        long jD0 = fVarW0.f30489a;
        boolean z4 = (this.f2074a.f19410a.equals(aVar) && jD0 == this.f2074a.e) ? false : true;
        g gVar = null;
        try {
            if (fVarW0.f2099b) {
                if (this.f2074a.f44526a != 1) {
                    d1(4);
                }
                q0(false, false, false, true);
            }
            try {
                if (z4) {
                    i2 = 4;
                    z2 = false;
                    if (!timeline.w()) {
                        for (fk5 fk5VarP = this.f2069a.p(); fk5VarP != null; fk5VarP = fk5VarP.j()) {
                            if (fk5VarP.f16545a.f16997a.equals(aVar)) {
                                fk5VarP.f16545a = this.f2069a.r(timeline, fk5VarP.f16545a);
                                fk5VarP.A();
                            }
                        }
                        jD0 = D0(aVar, jD0, z3);
                    }
                } else {
                    try {
                        i2 = 4;
                        z2 = false;
                        if (!this.f2069a.G(timeline, this.c, y())) {
                            B0(false);
                        }
                    } catch (Throwable th) {
                        th = th;
                        i = 4;
                        rs6 rs6Var = this.f2074a;
                        g gVar2 = gVar;
                        r1(timeline, aVar, rs6Var.f19408a, rs6Var.f19410a, fVarW0.c ? jD0 : -9223372036854775807L);
                        if (z4 || j != this.f2074a.f19406a) {
                            rs6 rs6Var2 = this.f2074a;
                            Object obj = ((gk5) rs6Var2.f19410a).f16805a;
                            Timeline timeline2 = rs6Var2.f19408a;
                            this.f2074a = K(aVar, jD0, j, this.f2074a.f19415b, z4 && z && !timeline2.w() && !timeline2.l(obj, this.f2067a).f2193a, timeline.f(obj) == -1 ? i : 3);
                        }
                        r0();
                        v0(timeline, this.f2074a.f19408a);
                        this.f2074a = this.f2074a.i(timeline);
                        if (!timeline.w()) {
                            this.f2063a = gVar2;
                        }
                        F(false);
                        throw th;
                    }
                }
                rs6 rs6Var3 = this.f2074a;
                r1(timeline, aVar, rs6Var3.f19408a, rs6Var3.f19410a, fVarW0.c ? jD0 : -9223372036854775807L);
                if (z4 || j != this.f2074a.f19406a) {
                    rs6 rs6Var4 = this.f2074a;
                    Object obj2 = ((gk5) rs6Var4.f19410a).f16805a;
                    Timeline timeline3 = rs6Var4.f19408a;
                    this.f2074a = K(aVar, jD0, j, this.f2074a.f19415b, (!z4 || !z || timeline3.w() || timeline3.l(obj2, this.f2067a).f2193a) ? z2 : true, timeline.f(obj2) == -1 ? i2 : 3);
                }
                r0();
                v0(timeline, this.f2074a.f19408a);
                this.f2074a = this.f2074a.i(timeline);
                if (!timeline.w()) {
                    this.f2063a = null;
                }
                F(z2);
            } catch (Throwable th2) {
                th = th2;
                gVar = null;
            }
        } catch (Throwable th3) {
            th = th3;
            i = 4;
        }
    }

    public final void G0(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.e() != this.f2058a) {
            this.f2073a.b(15, playerMessage).sendToTarget();
            return;
        }
        l(playerMessage);
        int i = this.f2074a.f44526a;
        if (i == 3 || i == 2) {
            this.f2073a.sendEmptyMessage(2);
        }
    }

    public final void H(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.f2069a.v(mediaPeriod)) {
            fk5 fk5VarJ = this.f2069a.j();
            fk5VarJ.p(this.f2059a.b().f3399a, this.f2074a.f19408a);
            o1(fk5VarJ.n(), fk5VarJ.o());
            if (fk5VarJ == this.f2069a.p()) {
                s0(fk5VarJ.f16545a.f42145a);
                p();
                rs6 rs6Var = this.f2074a;
                MediaSource.a aVar = rs6Var.f19410a;
                long j = fk5VarJ.f16545a.f42145a;
                this.f2074a = K(aVar, j, rs6Var.f19406a, j, false, 5);
            }
            U();
        }
    }

    public final void H0(final PlayerMessage playerMessage) {
        Looper looperE = playerMessage.e();
        if (looperE.getThread().isAlive()) {
            this.f2072a.a(looperE, null).post(new Runnable() { // from class: com.zj.adlib.ya3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45986a.T(playerMessage);
                }
            });
        } else {
            Log.n("TAG", "Trying to send message on a dead thread.");
            playerMessage.l(false);
        }
    }

    public final void I(j jVar, float f2, boolean z, boolean z2) throws ExoPlaybackException {
        if (z) {
            if (z2) {
                this.f2062a.b(1);
            }
            this.f2074a = this.f2074a.f(jVar);
        }
        s1(jVar.f3399a);
        for (Renderer renderer : this.f2080a) {
            if (renderer != null) {
                renderer.setPlaybackSpeed(f2, jVar.f3399a);
            }
        }
    }

    public final void I0(long j) {
        for (Renderer renderer : this.f2080a) {
            if (renderer.h() != null) {
                J0(renderer, j);
            }
        }
    }

    public final void J(j jVar, boolean z) throws ExoPlaybackException {
        I(jVar, jVar.f3399a, true, z);
    }

    public final void J0(Renderer renderer, long j) {
        renderer.setCurrentStreamFinal();
        if (renderer instanceof z39) {
            ((z39) renderer).r(j);
        }
    }

    @CheckResult
    public final rs6 K(MediaSource.a aVar, long j, long j2, long j3, boolean z, int i) {
        List<Metadata> listOf;
        ga9 ga9Var;
        wa9 wa9Var;
        this.k = (!this.k && j == this.f2074a.e && aVar.equals(this.f2074a.f19410a)) ? false : true;
        r0();
        rs6 rs6Var = this.f2074a;
        ga9 ga9Var2 = rs6Var.f19411a;
        wa9 wa9Var2 = rs6Var.f19412a;
        List<Metadata> list = rs6Var.f19413a;
        if (this.f2066a.t()) {
            fk5 fk5VarP = this.f2069a.p();
            ga9 ga9VarN = fk5VarP == null ? ga9.f16735a : fk5VarP.n();
            wa9 wa9VarO = fk5VarP == null ? this.f2076a : fk5VarP.o();
            ImmutableList<Metadata> immutableListU = u(wa9VarO.f20399a);
            if (fk5VarP != null) {
                hk5 hk5Var = fk5VarP.f16545a;
                if (hk5Var.b != j2) {
                    fk5VarP.f16545a = hk5Var.a(j2);
                }
            }
            ga9Var = ga9VarN;
            wa9Var = wa9VarO;
            listOf = immutableListU;
        } else if (aVar.equals(this.f2074a.f19410a)) {
            listOf = list;
            ga9Var = ga9Var2;
            wa9Var = wa9Var2;
        } else {
            ga9Var = ga9.f16735a;
            wa9Var = this.f2076a;
            listOf = ImmutableList.of();
        }
        if (z) {
            this.f2062a.e(i);
        }
        return this.f2074a.c(aVar, j, j2, j3, B(), ga9Var, wa9Var, listOf);
    }

    public synchronized boolean K0(boolean z) {
        if (!this.f2082b && this.f2057a.isAlive()) {
            if (z) {
                this.f2073a.d(13, 1, 0).sendToTarget();
                return true;
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.f2073a.e(13, 0, 0, atomicBoolean).sendToTarget();
            t1(new za3(atomicBoolean), this.d);
            return atomicBoolean.get();
        }
        return true;
    }

    public final boolean L(Renderer renderer, fk5 fk5Var) {
        fk5 fk5VarJ = fk5Var.j();
        return fk5Var.f16545a.f16998a && fk5VarJ.f16548a && ((renderer instanceof z39) || (renderer instanceof com.google.android.exoplayer2.metadata.a) || renderer.getReadingPositionUs() >= fk5VarJ.m());
    }

    public final void L0(boolean z, @Nullable AtomicBoolean atomicBoolean) {
        if (this.h != z) {
            this.h = z;
            if (!z) {
                for (Renderer renderer : this.f2080a) {
                    if (!P(renderer) && this.f2078a.remove(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    public final boolean M() {
        fk5 fk5VarQ = this.f2069a.q();
        if (!fk5VarQ.f16548a) {
            return false;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.f2080a;
            if (i >= rendererArr.length) {
                return true;
            }
            Renderer renderer = rendererArr[i];
            SampleStream sampleStream = fk5VarQ.f16550a[i];
            if (renderer.h() != sampleStream || (sampleStream != null && !renderer.hasReadStreamToEnd() && !L(renderer, fk5VarQ))) {
                return false;
            }
            i++;
        }
    }

    public final void M0(b bVar) throws Throwable {
        this.f2062a.b(1);
        if (bVar.f30485a != -1) {
            this.f2063a = new g(new k(bVar.f2089a, bVar.f2088a), bVar.f30485a, bVar.f2087a);
        }
        G(this.f2066a.E(bVar.f2089a, bVar.f2088a), false);
    }

    public void N0(List<MediaSourceList.c> list, int i, long j, ShuffleOrder shuffleOrder) {
        this.f2073a.b(17, new b(list, shuffleOrder, i, j, null)).sendToTarget();
    }

    public final boolean O() {
        fk5 fk5VarJ = this.f2069a.j();
        return (fk5VarJ == null || fk5VarJ.k() == Long.MIN_VALUE) ? false : true;
    }

    public final void O0(boolean z) {
        if (z == this.j) {
            return;
        }
        this.j = z;
        if (z || !this.f2074a.f19419c) {
            return;
        }
        this.f2073a.sendEmptyMessage(2);
    }

    public void P0(boolean z) {
        this.f2073a.d(23, z ? 1 : 0, 0).sendToTarget();
    }

    public final boolean Q() {
        fk5 fk5VarP = this.f2069a.p();
        long j = fk5VarP.f16545a.d;
        return fk5VarP.f16548a && (j == -9223372036854775807L || this.f2074a.e < j || !g1());
    }

    public final void Q0(boolean z) throws ExoPlaybackException {
        this.f2083c = z;
        r0();
        if (!this.f2084d || this.f2069a.q() == this.f2069a.p()) {
            return;
        }
        B0(true);
        F(false);
    }

    public void R0(boolean z, int i) {
        this.f2073a.d(1, z ? 1 : 0, i).sendToTarget();
    }

    public final void S0(boolean z, int i, boolean z2, int i2) throws ExoPlaybackException {
        this.f2062a.b(z2 ? 1 : 0);
        this.f2062a.c(i2);
        this.f2074a = this.f2074a.d(z, i);
        this.f2085e = false;
        f0(z);
        if (!g1()) {
            m1();
            q1();
            return;
        }
        int i3 = this.f2074a.f44526a;
        if (i3 == 3) {
            j1();
            this.f2073a.sendEmptyMessage(2);
        } else if (i3 == 2) {
            this.f2073a.sendEmptyMessage(2);
        }
    }

    public void T0(j jVar) {
        this.f2073a.b(4, jVar).sendToTarget();
    }

    public final void U() {
        boolean zF1 = f1();
        this.f2086f = zF1;
        if (zF1) {
            this.f2069a.j().d(this.c);
        }
        n1();
    }

    public final void U0(j jVar) throws ExoPlaybackException {
        this.f2059a.c(jVar);
        J(this.f2059a.b(), true);
    }

    public final void V() {
        this.f2062a.d(this.f2074a);
        if (this.f2062a.f2094a) {
            this.f2061a.a(this.f2062a);
            this.f2062a = new e(this.f2074a);
        }
    }

    public void V0(int i) {
        this.f2073a.d(11, i, 0).sendToTarget();
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0045, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0074, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void W(long j, long j2) throws ExoPlaybackException {
        if (this.f2077a.isEmpty() || this.f2074a.f19410a.c()) {
            return;
        }
        if (this.k) {
            j--;
            this.k = false;
        }
        rs6 rs6Var = this.f2074a;
        int iF = rs6Var.f19408a.f(((gk5) rs6Var.f19410a).f16805a);
        int iMin = Math.min(this.M, this.f2077a.size());
        if (iMin > 0) {
            d dVar = this.f2077a.get(iMin - 1);
            while (dVar != null) {
                int i = dVar.K;
                if (i <= iF && (i != iF || dVar.f30487a <= j)) {
                    break;
                }
                iMin--;
                dVar = iMin > 0 ? this.f2077a.get(iMin - 1) : null;
            }
            if (iMin < this.f2077a.size()) {
                d dVar2 = this.f2077a.get(iMin);
                while (dVar2 != null && dVar2.f2092a != null) {
                    int i2 = dVar2.K;
                    if (i2 >= iF && (i2 != iF || dVar2.f30487a > j)) {
                        break;
                    }
                    iMin++;
                    dVar2 = iMin < this.f2077a.size() ? this.f2077a.get(iMin) : null;
                }
                while (dVar2 != null && dVar2.f2092a != null && dVar2.K == iF) {
                    long j3 = dVar2.f30487a;
                    if (j3 <= j || j3 > j2) {
                        break;
                    }
                    try {
                        G0(dVar2.f2091a);
                        if (dVar2.f2091a.d() || dVar2.f2091a.k()) {
                            this.f2077a.remove(iMin);
                        } else {
                            iMin++;
                        }
                        dVar2 = iMin < this.f2077a.size() ? this.f2077a.get(iMin) : null;
                    } catch (Throwable th) {
                        if (dVar2.f2091a.d() || dVar2.f2091a.k()) {
                            this.f2077a.remove(iMin);
                        }
                        throw th;
                    }
                }
                this.M = iMin;
            }
        }
    }

    public final void W0(int i) throws ExoPlaybackException {
        this.K = i;
        if (!this.f2069a.H(this.f2074a.f19408a, i)) {
            B0(true);
        }
        F(false);
    }

    public final void X() throws ExoPlaybackException {
        hk5 hk5VarO;
        this.f2069a.y(this.c);
        if (this.f2069a.E() && (hk5VarO = this.f2069a.o(this.c, this.f2074a)) != null) {
            fk5 fk5VarG = this.f2069a.g(this.f2081a, this.f2070a, this.f2065a.b(), this.f2066a, hk5VarO, this.f2076a);
            fk5VarG.f16541a.c(this, hk5VarO.f42145a);
            if (this.f2069a.p() == fk5VarG) {
                s0(hk5VarO.f42145a);
            }
            F(false);
        }
        if (!this.f2086f) {
            U();
        } else {
            this.f2086f = O();
            n1();
        }
    }

    public void X0(w38 w38Var) {
        this.f2073a.b(5, w38Var).sendToTarget();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    public final void Y() throws ExoPlaybackException {
        boolean z;
        boolean z2 = false;
        while (e1()) {
            if (z2) {
                V();
            }
            fk5 fk5Var = (fk5) sb0.g(this.f2069a.b());
            if (((gk5) this.f2074a.f19410a).f16805a.equals(((gk5) fk5Var.f16545a.f16997a).f16805a)) {
                MediaSource.a aVar = this.f2074a.f19410a;
                if (((gk5) aVar).f41928a == -1) {
                    MediaSource.a aVar2 = fk5Var.f16545a.f16997a;
                    if (((gk5) aVar2).f41928a != -1 || aVar.c == aVar2.c) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            hk5 hk5Var = fk5Var.f16545a;
            MediaSource.a aVar3 = hk5Var.f16997a;
            long j = hk5Var.f42145a;
            this.f2074a = K(aVar3, j, hk5Var.b, j, !z, 0);
            r0();
            q1();
            z2 = true;
        }
    }

    public final void Y0(w38 w38Var) {
        this.f2075a = w38Var;
    }

    public final void Z() {
        fk5 fk5VarQ = this.f2069a.q();
        if (fk5VarQ == null) {
            return;
        }
        int i = 0;
        if (fk5VarQ.j() != null && !this.f2084d) {
            if (M()) {
                if (fk5VarQ.j().f16548a || this.c >= fk5VarQ.j().m()) {
                    wa9 wa9VarO = fk5VarQ.o();
                    fk5 fk5VarC = this.f2069a.c();
                    wa9 wa9VarO2 = fk5VarC.o();
                    Timeline timeline = this.f2074a.f19408a;
                    r1(timeline, fk5VarC.f16545a.f16997a, timeline, fk5VarQ.f16545a.f16997a, -9223372036854775807L);
                    if (fk5VarC.f16548a && fk5VarC.f16541a.readDiscontinuity() != -9223372036854775807L) {
                        I0(fk5VarC.m());
                        return;
                    }
                    for (int i2 = 0; i2 < this.f2080a.length; i2++) {
                        boolean zC = wa9VarO.c(i2);
                        boolean zC2 = wa9VarO2.c(i2);
                        if (zC && !this.f2080a[i2].isCurrentStreamFinal()) {
                            boolean z = this.f2081a[i2].getTrackType() == -2;
                            ue7 ue7Var = wa9VarO.f20400a[i2];
                            ue7 ue7Var2 = wa9VarO2.f20400a[i2];
                            if (!zC2 || !ue7Var2.equals(ue7Var) || z) {
                                J0(this.f2080a[i2], fk5VarC.m());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!fk5VarQ.f16545a.f17001d && !this.f2084d) {
            return;
        }
        while (true) {
            Renderer[] rendererArr = this.f2080a;
            if (i >= rendererArr.length) {
                return;
            }
            Renderer renderer = rendererArr[i];
            SampleStream sampleStream = fk5VarQ.f16550a[i];
            if (sampleStream != null && renderer.h() == sampleStream && renderer.hasReadStreamToEnd()) {
                long j = fk5VarQ.f16545a.d;
                J0(renderer, (j == -9223372036854775807L || j == Long.MIN_VALUE) ? -9223372036854775807L : fk5VarQ.l() + fk5VarQ.f16545a.d);
            }
            i++;
        }
    }

    public void Z0(boolean z) {
        this.f2073a.d(12, z ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Sender
    public synchronized void a(PlayerMessage playerMessage) {
        if (!this.f2082b && this.f2057a.isAlive()) {
            this.f2073a.b(14, playerMessage).sendToTarget();
            return;
        }
        Log.n(f2056f, "Ignoring messages sent after release.");
        playerMessage.l(false);
    }

    public final void a0() throws ExoPlaybackException {
        fk5 fk5VarQ = this.f2069a.q();
        if (fk5VarQ == null || this.f2069a.p() == fk5VarQ || fk5VarQ.c || !o0()) {
            return;
        }
        p();
    }

    public final void a1(boolean z) throws ExoPlaybackException {
        this.g = z;
        if (!this.f2069a.I(this.f2074a.f19408a, z)) {
            B0(true);
        }
        F(false);
    }

    public final void b0() throws Throwable {
        G(this.f2066a.j(), true);
    }

    public void b1(ShuffleOrder shuffleOrder) {
        this.f2073a.b(21, shuffleOrder).sendToTarget();
    }

    public final void c0(c cVar) throws Throwable {
        this.f2062a.b(1);
        G(this.f2066a.x(cVar.f30486a, cVar.b, cVar.c, cVar.f2090a), false);
    }

    public final void c1(ShuffleOrder shuffleOrder) throws Throwable {
        this.f2062a.b(1);
        G(this.f2066a.F(shuffleOrder), false);
    }

    public void d0(int i, int i2, int i3, ShuffleOrder shuffleOrder) {
        this.f2073a.b(19, new c(i, i2, i3, shuffleOrder)).sendToTarget();
    }

    public final void d1(int i) {
        rs6 rs6Var = this.f2074a;
        if (rs6Var.f44526a != i) {
            if (i != 2) {
                this.e = -9223372036854775807L;
            }
            this.f2074a = rs6Var.g(i);
        }
    }

    public final void e0() {
        for (fk5 fk5VarP = this.f2069a.p(); fk5VarP != null; fk5VarP = fk5VarP.j()) {
            for (ExoTrackSelection exoTrackSelection : fk5VarP.o().f20399a) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onDiscontinuity();
                }
            }
        }
    }

    public final boolean e1() {
        fk5 fk5VarP;
        fk5 fk5VarJ;
        return g1() && !this.f2084d && (fk5VarP = this.f2069a.p()) != null && (fk5VarJ = fk5VarP.j()) != null && this.c >= fk5VarJ.m() && fk5VarJ.c;
    }

    public final void f0(boolean z) {
        for (fk5 fk5VarP = this.f2069a.p(); fk5VarP != null; fk5VarP = fk5VarP.j()) {
            for (ExoTrackSelection exoTrackSelection : fk5VarP.o().f20399a) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlayWhenReadyChanged(z);
                }
            }
        }
    }

    public final boolean f1() {
        if (!O()) {
            return false;
        }
        fk5 fk5VarJ = this.f2069a.j();
        return this.f2065a.shouldContinueLoading(fk5VarJ == this.f2069a.p() ? fk5VarJ.y(this.c) : fk5VarJ.y(this.c) - fk5VarJ.f16545a.f42145a, C(fk5VarJ.k()), this.f2059a.b().f3399a);
    }

    @Override // com.google.android.exoplayer2.DefaultMediaClock.PlaybackParametersListener
    public void g(j jVar) {
        this.f2073a.b(16, jVar).sendToTarget();
    }

    public final void g0() {
        for (fk5 fk5VarP = this.f2069a.p(); fk5VarP != null; fk5VarP = fk5VarP.j()) {
            for (ExoTrackSelection exoTrackSelection : fk5VarP.o().f20399a) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onRebuffer();
                }
            }
        }
    }

    public final boolean g1() {
        rs6 rs6Var = this.f2074a;
        return rs6Var.f19417b && rs6Var.b == 0;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void h(MediaPeriod mediaPeriod) {
        this.f2073a.b(8, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public void d(MediaPeriod mediaPeriod) {
        this.f2073a.b(9, mediaPeriod).sendToTarget();
    }

    public final boolean h1(boolean z) {
        if (this.L == 0) {
            return Q();
        }
        if (!z) {
            return false;
        }
        rs6 rs6Var = this.f2074a;
        if (!rs6Var.f19414a) {
            return true;
        }
        long targetLiveOffsetUs = i1(rs6Var.f19408a, this.f2069a.p().f16545a.f16997a) ? this.f2064a.getTargetLiveOffsetUs() : -9223372036854775807L;
        fk5 fk5VarJ = this.f2069a.j();
        return (fk5VarJ.q() && fk5VarJ.f16545a.f17001d) || (fk5VarJ.f16545a.f16997a.c() && !fk5VarJ.f16548a) || this.f2065a.shouldStartPlayback(B(), this.f2059a.b().f3399a, this.f2085e, targetLiveOffsetUs);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        int i;
        fk5 fk5VarQ;
        int i2 = 1000;
        try {
            switch (message.what) {
                case 0:
                    j0();
                    break;
                case 1:
                    S0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    n();
                    break;
                case 3:
                    C0((g) message.obj);
                    break;
                case 4:
                    U0((j) message.obj);
                    break;
                case 5:
                    Y0((w38) message.obj);
                    break;
                case 6:
                    l1(false, true);
                    break;
                case 7:
                    l0();
                    return true;
                case 8:
                    H((MediaPeriod) message.obj);
                    break;
                case 9:
                    D((MediaPeriod) message.obj);
                    break;
                case 10:
                    p0();
                    break;
                case 11:
                    W0(message.arg1);
                    break;
                case 12:
                    a1(message.arg1 != 0);
                    break;
                case 13:
                    L0(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    F0((PlayerMessage) message.obj);
                    break;
                case 15:
                    H0((PlayerMessage) message.obj);
                    break;
                case 16:
                    J((j) message.obj, false);
                    break;
                case 17:
                    M0((b) message.obj);
                    break;
                case 18:
                    i((b) message.obj, message.arg1);
                    break;
                case 19:
                    c0((c) message.obj);
                    break;
                case 20:
                    m0(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    c1((ShuffleOrder) message.obj);
                    break;
                case 22:
                    b0();
                    break;
                case 23:
                    Q0(message.arg1 != 0);
                    break;
                case 24:
                    O0(message.arg1 == 1);
                    break;
                case 25:
                    k();
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e2) {
            e = e2;
            if (e.type == 1 && (fk5VarQ = this.f2069a.q()) != null) {
                e = e.copyWithMediaPeriodId(fk5VarQ.f16545a.f16997a);
            }
            if (e.isRecoverable && this.f2060a == null) {
                Log.o(f2056f, "Recoverable renderer error", e);
                this.f2060a = e;
                HandlerWrapper handlerWrapper = this.f2073a;
                handlerWrapper.c(handlerWrapper.b(25, e));
            } else {
                ExoPlaybackException exoPlaybackException = this.f2060a;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.f2060a;
                }
                Log.e(f2056f, "Playback error", e);
                l1(true, false);
                this.f2074a = this.f2074a.e(e);
            }
        } catch (ParserException e3) {
            int i3 = e3.dataType;
            if (i3 == 1) {
                i = e3.contentIsMalformed ? 3001 : 3003;
            } else {
                if (i3 == 4) {
                    i = e3.contentIsMalformed ? 3002 : 3004;
                }
                E(e3, i2);
            }
            i2 = i;
            E(e3, i2);
        } catch (DrmSession.DrmSessionException e4) {
            E(e4, e4.errorCode);
        } catch (BehindLiveWindowException e5) {
            E(e5, 1002);
        } catch (DataSourceException e6) {
            E(e6, e6.reason);
        } catch (IOException e7) {
            E(e7, 2000);
        } catch (RuntimeException e8) {
            ExoPlaybackException exoPlaybackExceptionCreateForUnexpected = ExoPlaybackException.createForUnexpected(e8, ((e8 instanceof IllegalStateException) || (e8 instanceof IllegalArgumentException)) ? 1004 : 1000);
            Log.e(f2056f, "Playback error", exoPlaybackExceptionCreateForUnexpected);
            l1(true, false);
            this.f2074a = this.f2074a.e(exoPlaybackExceptionCreateForUnexpected);
        }
        V();
        return true;
    }

    public final void i(b bVar, int i) throws Throwable {
        this.f2062a.b(1);
        MediaSourceList mediaSourceList = this.f2066a;
        if (i == -1) {
            i = mediaSourceList.r();
        }
        G(mediaSourceList.f(i, bVar.f2089a, bVar.f2088a), false);
    }

    public void i0() {
        this.f2073a.a(0).sendToTarget();
    }

    public final boolean i1(Timeline timeline, MediaSource.a aVar) {
        if (aVar.c() || timeline.w()) {
            return false;
        }
        timeline.t(timeline.l(((gk5) aVar).f16805a, this.f2067a).K, this.f2068a);
        if (!this.f2068a.k()) {
            return false;
        }
        Timeline.d dVar = this.f2068a;
        return dVar.f2204b && dVar.f2202b != -9223372036854775807L;
    }

    public void j(int i, List<MediaSourceList.c> list, ShuffleOrder shuffleOrder) {
        this.f2073a.e(18, i, 0, new b(list, shuffleOrder, -1, -9223372036854775807L, null)).sendToTarget();
    }

    public final void j0() {
        this.f2062a.b(1);
        q0(false, false, false, true);
        this.f2065a.onPrepared();
        d1(this.f2074a.f19408a.w() ? 4 : 2);
        this.f2066a.y(this.f2071a.b());
        this.f2073a.sendEmptyMessage(2);
    }

    public final void j1() throws ExoPlaybackException {
        this.f2085e = false;
        this.f2059a.g();
        for (Renderer renderer : this.f2080a) {
            if (P(renderer)) {
                renderer.start();
            }
        }
    }

    public final void k() throws ExoPlaybackException {
        B0(true);
    }

    public synchronized boolean k0() {
        if (!this.f2082b && this.f2057a.isAlive()) {
            this.f2073a.sendEmptyMessage(7);
            t1(new Supplier() { // from class: com.zj.adlib.xa3
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return this.f45775a.S();
                }
            }, this.b);
            return this.f2082b;
        }
        return true;
    }

    public void k1() {
        this.f2073a.a(6).sendToTarget();
    }

    public final void l(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.k()) {
            return;
        }
        try {
            playerMessage.i().handleMessage(playerMessage.getType(), playerMessage.g());
        } finally {
            playerMessage.l(true);
        }
    }

    public final void l0() {
        q0(true, false, true, false);
        this.f2065a.onReleased();
        d1(1);
        this.f2057a.quit();
        synchronized (this) {
            this.f2082b = true;
            notifyAll();
        }
    }

    public final void l1(boolean z, boolean z2) {
        q0(z || !this.h, false, true, false);
        this.f2062a.b(z2 ? 1 : 0);
        this.f2065a.onStopped();
        d1(1);
    }

    public final void m(Renderer renderer) throws ExoPlaybackException {
        if (P(renderer)) {
            this.f2059a.a(renderer);
            r(renderer);
            renderer.disable();
            this.L--;
        }
    }

    public final void m0(int i, int i2, ShuffleOrder shuffleOrder) throws Throwable {
        this.f2062a.b(1);
        G(this.f2066a.C(i, i2, shuffleOrder), false);
    }

    public final void m1() throws ExoPlaybackException {
        this.f2059a.h();
        for (Renderer renderer : this.f2080a) {
            if (P(renderer)) {
                r(renderer);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x017d  */
    public final void n() throws ExoPlaybackException, IOException {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        long jUptimeMillis = this.f2072a.uptimeMillis();
        this.f2073a.removeMessages(2);
        p1();
        int i2 = this.f2074a.f44526a;
        if (i2 == 1 || i2 == 4) {
            return;
        }
        fk5 fk5VarP = this.f2069a.p();
        if (fk5VarP == null) {
            z0(jUptimeMillis, 10L);
            return;
        }
        y99.a("doSomeWork");
        q1();
        if (fk5VarP.f16548a) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            fk5VarP.f16541a.discardBuffer(this.f2074a.e - this.f30483a, this.f2079a);
            z = true;
            z2 = true;
            int i3 = 0;
            while (true) {
                Renderer[] rendererArr = this.f2080a;
                if (i3 >= rendererArr.length) {
                    break;
                }
                Renderer renderer = rendererArr[i3];
                if (P(renderer)) {
                    renderer.render(this.c, jElapsedRealtime);
                    z = z && renderer.isEnded();
                    boolean z4 = fk5VarP.f16550a[i3] != renderer.h();
                    boolean z5 = z4 || (!z4 && renderer.hasReadStreamToEnd()) || renderer.isReady() || renderer.isEnded();
                    z2 = z2 && z5;
                    if (!z5) {
                        renderer.maybeThrowStreamError();
                    }
                }
                i3++;
            }
        } else {
            fk5VarP.f16541a.maybeThrowPrepareError();
            z = true;
            z2 = true;
        }
        long j = fk5VarP.f16545a.d;
        boolean z6 = z && fk5VarP.f16548a && (j == -9223372036854775807L || j <= this.f2074a.e);
        if (z6 && this.f2084d) {
            this.f2084d = false;
            S0(false, this.f2074a.b, false, 5);
        }
        if (z6 && fk5VarP.f16545a.f17001d) {
            d1(4);
            m1();
        } else if (this.f2074a.f44526a == 2 && h1(z2)) {
            d1(3);
            this.f2060a = null;
            if (g1()) {
                j1();
            }
        } else if (this.f2074a.f44526a == 3 && (this.L != 0 ? !z2 : !Q())) {
            this.f2085e = g1();
            d1(2);
            if (this.f2085e) {
                g0();
                this.f2064a.notifyRebuffer();
            }
            m1();
        }
        if (this.f2074a.f44526a == 2) {
            int i4 = 0;
            while (true) {
                Renderer[] rendererArr2 = this.f2080a;
                if (i4 >= rendererArr2.length) {
                    break;
                }
                if (P(rendererArr2[i4]) && this.f2080a[i4].h() == fk5VarP.f16550a[i4]) {
                    this.f2080a[i4].maybeThrowStreamError();
                }
                i4++;
            }
            rs6 rs6Var = this.f2074a;
            if (rs6Var.f19414a || rs6Var.d >= 500000 || !O()) {
                z3 = false;
            } else {
                z3 = true;
            }
        } else {
            z3 = false;
        }
        if (!z3) {
            this.e = -9223372036854775807L;
        } else if (this.e == -9223372036854775807L) {
            this.e = this.f2072a.elapsedRealtime();
        } else if (this.f2072a.elapsedRealtime() - this.e >= f) {
            throw new IllegalStateException("Playback stuck buffering and not loading");
        }
        boolean z7 = g1() && this.f2074a.f44526a == 3;
        boolean z8 = this.j && this.i && z7;
        rs6 rs6Var2 = this.f2074a;
        if (rs6Var2.f19419c != z8) {
            this.f2074a = rs6Var2.h(z8);
        }
        this.i = false;
        if (z8 || (i = this.f2074a.f44526a) == 4) {
            return;
        }
        if (z7 || i == 2) {
            z0(jUptimeMillis, 10L);
        } else if (i == 3 && this.L != 0) {
            z0(jUptimeMillis, 1000L);
        }
        y99.c();
    }

    public void n0(int i, int i2, ShuffleOrder shuffleOrder) {
        this.f2073a.e(20, i, i2, shuffleOrder).sendToTarget();
    }

    public final void n1() {
        fk5 fk5VarJ = this.f2069a.j();
        boolean z = this.f2086f || (fk5VarJ != null && fk5VarJ.f16541a.isLoading());
        rs6 rs6Var = this.f2074a;
        if (z != rs6Var.f19414a) {
            this.f2074a = rs6Var.a(z);
        }
    }

    public final void o(int i, boolean z) throws ExoPlaybackException {
        Renderer renderer = this.f2080a[i];
        if (P(renderer)) {
            return;
        }
        fk5 fk5VarQ = this.f2069a.q();
        boolean z2 = fk5VarQ == this.f2069a.p();
        wa9 wa9VarO = fk5VarQ.o();
        ue7 ue7Var = wa9VarO.f20400a[i];
        com.google.android.exoplayer2.d[] dVarArrW = w(wa9VarO.f20399a[i]);
        boolean z3 = g1() && this.f2074a.f44526a == 3;
        boolean z4 = !z && z3;
        this.L++;
        this.f2078a.add(renderer);
        renderer.i(ue7Var, dVarArrW, fk5VarQ.f16550a[i], this.c, z4, z2, fk5VarQ.m(), fk5VarQ.l());
        renderer.handleMessage(11, new a());
        this.f2059a.d(renderer);
        if (z3) {
            renderer.start();
        }
    }

    public final boolean o0() throws ExoPlaybackException {
        fk5 fk5VarQ = this.f2069a.q();
        wa9 wa9VarO = fk5VarQ.o();
        int i = 0;
        boolean z = false;
        while (true) {
            Renderer[] rendererArr = this.f2080a;
            if (i >= rendererArr.length) {
                return !z;
            }
            Renderer renderer = rendererArr[i];
            if (P(renderer)) {
                boolean z2 = renderer.h() != fk5VarQ.f16550a[i];
                if (!wa9VarO.c(i) || z2) {
                    if (!renderer.isCurrentStreamFinal()) {
                        renderer.f(w(wa9VarO.f20399a[i]), fk5VarQ.f16550a[i], fk5VarQ.m(), fk5VarQ.l());
                    } else if (renderer.isEnded()) {
                        m(renderer);
                    } else {
                        z = true;
                    }
                }
            }
            i++;
        }
    }

    public final void o1(ga9 ga9Var, wa9 wa9Var) {
        this.f2065a.a(this.f2080a, ga9Var, wa9Var.f20399a);
    }

    @Override // com.google.android.exoplayer2.MediaSourceList.MediaSourceListInfoRefreshListener
    public void onPlaylistUpdateRequested() {
        this.f2073a.sendEmptyMessage(22);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.f2073a.sendEmptyMessage(10);
    }

    public final void p() throws ExoPlaybackException {
        q(new boolean[this.f2080a.length]);
    }

    public final void p0() throws ExoPlaybackException {
        float f2 = this.f2059a.b().f3399a;
        fk5 fk5VarQ = this.f2069a.q();
        boolean z = true;
        for (fk5 fk5VarP = this.f2069a.p(); fk5VarP != null && fk5VarP.f16548a; fk5VarP = fk5VarP.j()) {
            wa9 wa9VarV = fk5VarP.v(f2, this.f2074a.f19408a);
            if (!wa9VarV.a(fk5VarP.o())) {
                if (z) {
                    fk5 fk5VarP2 = this.f2069a.p();
                    boolean z2 = this.f2069a.z(fk5VarP2);
                    boolean[] zArr = new boolean[this.f2080a.length];
                    long jB = fk5VarP2.b(wa9VarV, this.f2074a.e, z2, zArr);
                    rs6 rs6Var = this.f2074a;
                    boolean z3 = (rs6Var.f44526a == 4 || jB == rs6Var.e) ? false : true;
                    rs6 rs6Var2 = this.f2074a;
                    this.f2074a = K(rs6Var2.f19410a, jB, rs6Var2.f19406a, rs6Var2.f19415b, z3, 5);
                    if (z3) {
                        s0(jB);
                    }
                    boolean[] zArr2 = new boolean[this.f2080a.length];
                    int i = 0;
                    while (true) {
                        Renderer[] rendererArr = this.f2080a;
                        if (i >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i];
                        boolean zP = P(renderer);
                        zArr2[i] = zP;
                        SampleStream sampleStream = fk5VarP2.f16550a[i];
                        if (zP) {
                            if (sampleStream != renderer.h()) {
                                m(renderer);
                            } else if (zArr[i]) {
                                renderer.resetPosition(this.c);
                            }
                        }
                        i++;
                    }
                    q(zArr2);
                } else {
                    this.f2069a.z(fk5VarP);
                    if (fk5VarP.f16548a) {
                        fk5VarP.a(wa9VarV, Math.max(fk5VarP.f16545a.f42145a, fk5VarP.y(this.c)), false);
                    }
                }
                F(true);
                if (this.f2074a.f44526a != 4) {
                    U();
                    q1();
                    this.f2073a.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (fk5VarP == fk5VarQ) {
                z = false;
            }
        }
    }

    public final void p1() throws ExoPlaybackException, IOException {
        if (this.f2074a.f19408a.w() || !this.f2066a.t()) {
            return;
        }
        X();
        Z();
        a0();
        Y();
    }

    public final void q(boolean[] zArr) throws ExoPlaybackException {
        fk5 fk5VarQ = this.f2069a.q();
        wa9 wa9VarO = fk5VarQ.o();
        for (int i = 0; i < this.f2080a.length; i++) {
            if (!wa9VarO.c(i) && this.f2078a.remove(this.f2080a[i])) {
                this.f2080a[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.f2080a.length; i2++) {
            if (wa9VarO.c(i2)) {
                o(i2, zArr[i2]);
            }
        }
        fk5VarQ.c = true;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a2 A[PHI: r4 r5 r7
      0x00a2: PHI (r4v3 com.google.android.exoplayer2.source.MediaSource$a) = (r4v2 com.google.android.exoplayer2.source.MediaSource$a), (r4v9 com.google.android.exoplayer2.source.MediaSource$a) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r5v2 long) = (r5v1 long), (r5v5 long) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r7v3 long) = (r7v2 long), (r7v5 long) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    public final void q0(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        this.f2073a.removeMessages(2);
        this.f2060a = null;
        this.f2085e = false;
        this.f2059a.h();
        this.c = 1000000000000L;
        for (Renderer renderer : this.f2080a) {
            try {
                m(renderer);
            } catch (ExoPlaybackException | RuntimeException e2) {
                Log.e(f2056f, "Disable failed.", e2);
            }
        }
        if (z) {
            for (Renderer renderer2 : this.f2080a) {
                if (this.f2078a.remove(renderer2)) {
                    try {
                        renderer2.reset();
                    } catch (RuntimeException e3) {
                        Log.e(f2056f, "Reset failed.", e3);
                    }
                }
            }
        }
        this.L = 0;
        rs6 rs6Var = this.f2074a;
        MediaSource.a aVar = rs6Var.f19410a;
        long jLongValue = rs6Var.e;
        long j = (this.f2074a.f19410a.c() || R(this.f2074a, this.f2067a)) ? this.f2074a.f19406a : this.f2074a.e;
        if (z2) {
            this.f2063a = null;
            Pair<MediaSource.a, Long> pairZ = z(this.f2074a.f19408a);
            aVar = (MediaSource.a) pairZ.first;
            jLongValue = ((Long) pairZ.second).longValue();
            j = -9223372036854775807L;
            if (aVar.equals(this.f2074a.f19410a)) {
                z5 = false;
            } else {
                z5 = true;
            }
        } else {
            z5 = false;
        }
        MediaSource.a aVar2 = aVar;
        long j2 = jLongValue;
        this.f2069a.f();
        this.f2086f = false;
        rs6 rs6Var2 = this.f2074a;
        Timeline timeline = rs6Var2.f19408a;
        int i = rs6Var2.f44526a;
        ExoPlaybackException exoPlaybackException = z4 ? null : rs6Var2.f19407a;
        ga9 ga9Var = z5 ? ga9.f16735a : rs6Var2.f19411a;
        wa9 wa9Var = z5 ? this.f2076a : rs6Var2.f19412a;
        List listOf = z5 ? ImmutableList.of() : rs6Var2.f19413a;
        rs6 rs6Var3 = this.f2074a;
        this.f2074a = new rs6(timeline, aVar2, j, j2, i, exoPlaybackException, false, ga9Var, wa9Var, listOf, aVar2, rs6Var3.f19417b, rs6Var3.b, rs6Var3.f19409a, j2, 0L, j2, false);
        if (z3) {
            this.f2066a.A();
        }
    }

    public final void q1() throws ExoPlaybackException {
        fk5 fk5VarP = this.f2069a.p();
        if (fk5VarP == null) {
            return;
        }
        long discontinuity = fk5VarP.f16548a ? fk5VarP.f16541a.readDiscontinuity() : -9223372036854775807L;
        if (discontinuity != -9223372036854775807L) {
            s0(discontinuity);
            if (discontinuity != this.f2074a.e) {
                rs6 rs6Var = this.f2074a;
                this.f2074a = K(rs6Var.f19410a, discontinuity, rs6Var.f19406a, discontinuity, true, 5);
            }
        } else {
            long jI = this.f2059a.i(fk5VarP != this.f2069a.q());
            this.c = jI;
            long jY = fk5VarP.y(jI);
            W(this.f2074a.e, jY);
            this.f2074a.e = jY;
        }
        this.f2074a.f19418c = this.f2069a.j().i();
        this.f2074a.d = B();
        rs6 rs6Var2 = this.f2074a;
        if (rs6Var2.f19417b && rs6Var2.f44526a == 3 && i1(rs6Var2.f19408a, rs6Var2.f19410a) && this.f2074a.f19409a.f3399a == 1.0f) {
            float adjustedPlaybackSpeed = this.f2064a.getAdjustedPlaybackSpeed(v(), B());
            if (this.f2059a.b().f3399a != adjustedPlaybackSpeed) {
                this.f2059a.c(this.f2074a.f19409a.e(adjustedPlaybackSpeed));
                I(this.f2074a.f19409a, this.f2059a.b().f3399a, false, false);
            }
        }
    }

    public final void r(Renderer renderer) throws ExoPlaybackException {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    public final void r0() {
        fk5 fk5VarP = this.f2069a.p();
        this.f2084d = fk5VarP != null && fk5VarP.f16545a.f17000c && this.f2083c;
    }

    public final void r1(Timeline timeline, MediaSource.a aVar, Timeline timeline2, MediaSource.a aVar2, long j) {
        if (!i1(timeline, aVar)) {
            j jVar = aVar.c() ? j.f3398a : this.f2074a.f19409a;
            if (this.f2059a.b().equals(jVar)) {
                return;
            }
            this.f2059a.c(jVar);
            return;
        }
        timeline.t(timeline.l(((gk5) aVar).f16805a, this.f2067a).K, this.f2068a);
        this.f2064a.a((com.google.android.exoplayer2.g.C0682g) gj9.k(this.f2068a.f2198a));
        if (j != -9223372036854775807L) {
            this.f2064a.setTargetLiveOffsetOverrideUs(x(timeline, ((gk5) aVar).f16805a, j));
            return;
        }
        if (gj9.c(!timeline2.w() ? timeline2.t(timeline2.l(((gk5) aVar2).f16805a, this.f2067a).K, this.f2068a).f2200a : null, this.f2068a.f2200a)) {
            return;
        }
        this.f2064a.setTargetLiveOffsetOverrideUs(-9223372036854775807L);
    }

    public void s(long j) {
        this.d = j;
    }

    public final void s0(long j) throws ExoPlaybackException {
        fk5 fk5VarP = this.f2069a.p();
        long jZ = fk5VarP == null ? j + 1000000000000L : fk5VarP.z(j);
        this.c = jZ;
        this.f2059a.e(jZ);
        for (Renderer renderer : this.f2080a) {
            if (P(renderer)) {
                renderer.resetPosition(this.c);
            }
        }
        e0();
    }

    public final void s1(float f2) {
        for (fk5 fk5VarP = this.f2069a.p(); fk5VarP != null; fk5VarP = fk5VarP.j()) {
            for (ExoTrackSelection exoTrackSelection : fk5VarP.o().f20399a) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlaybackSpeed(f2);
                }
            }
        }
    }

    public void t(boolean z) {
        this.f2073a.d(24, z ? 1 : 0, 0).sendToTarget();
    }

    public final synchronized void t1(Supplier<Boolean> supplier, long j) {
        long jElapsedRealtime = this.f2072a.elapsedRealtime() + j;
        boolean z = false;
        while (!supplier.get().booleanValue() && j > 0) {
            try {
                this.f2072a.onThreadBlocked();
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = jElapsedRealtime - this.f2072a.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final ImmutableList<Metadata> u(ExoTrackSelection[] exoTrackSelectionArr) {
        ImmutableList.a aVar = new ImmutableList.a();
        boolean z = false;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                Metadata metadata = exoTrackSelection.e(0).f2567a;
                if (metadata == null) {
                    aVar.a(new Metadata(new Metadata.Entry[0]));
                } else {
                    aVar.a(metadata);
                    z = true;
                }
            }
        }
        return z ? aVar.e() : ImmutableList.of();
    }

    public final long v() {
        rs6 rs6Var = this.f2074a;
        return x(rs6Var.f19408a, ((gk5) rs6Var.f19410a).f16805a, rs6Var.e);
    }

    public final void v0(Timeline timeline, Timeline timeline2) {
        if (timeline.w() && timeline2.w()) {
            return;
        }
        for (int size = this.f2077a.size() - 1; size >= 0; size--) {
            if (!u0(this.f2077a.get(size), timeline, timeline2, this.K, this.g, this.f2068a, this.f2067a)) {
                this.f2077a.get(size).f2091a.l(false);
                this.f2077a.remove(size);
            }
        }
        Collections.sort(this.f2077a);
    }

    public final long x(Timeline timeline, Object obj, long j) {
        timeline.t(timeline.l(obj, this.f2067a).K, this.f2068a);
        Timeline.d dVar = this.f2068a;
        if (dVar.f2202b != -9223372036854775807L && dVar.k()) {
            Timeline.d dVar2 = this.f2068a;
            if (dVar2.f2204b) {
                return gj9.Z0(dVar2.d() - this.f2068a.f2202b) - (j + this.f2067a.s());
            }
        }
        return -9223372036854775807L;
    }

    public final long y() {
        fk5 fk5VarQ = this.f2069a.q();
        if (fk5VarQ == null) {
            return 0L;
        }
        long jL = fk5VarQ.l();
        if (!fk5VarQ.f16548a) {
            return jL;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.f2080a;
            if (i >= rendererArr.length) {
                return jL;
            }
            if (P(rendererArr[i]) && this.f2080a[i].h() == fk5VarQ.f16550a[i]) {
                long readingPositionUs = this.f2080a[i].getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jL = Math.max(readingPositionUs, jL);
            }
            i++;
        }
    }

    public final Pair<MediaSource.a, Long> z(Timeline timeline) {
        if (timeline.w()) {
            return Pair.create(rs6.k(), 0L);
        }
        Pair<Object, Long> pairP = timeline.p(this.f2068a, this.f2067a, timeline.e(this.g), -9223372036854775807L);
        MediaSource.a aVarC = this.f2069a.C(timeline, pairP.first, 0L);
        long jLongValue = ((Long) pairP.second).longValue();
        if (aVarC.c()) {
            timeline.l(((gk5) aVarC).f16805a, this.f2067a);
            jLongValue = aVarC.b == this.f2067a.p(((gk5) aVarC).f41928a) ? this.f2067a.j() : 0L;
        }
        return Pair.create(aVarC, Long.valueOf(jLongValue));
    }

    public final void z0(long j, long j2) {
        this.f2073a.sendEmptyMessageAtTime(2, j + j2);
    }
}
