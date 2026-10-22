package com.google.android.exoplayer2.analytics;

import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.a;
import com.google.common.base.g;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.o;
import com.zj.adlib.az4;
import com.zj.adlib.gj9;
import com.zj.adlib.gk5;
import com.zj.adlib.hp9;
import com.zj.adlib.oh5;
import com.zj.adlib.p82;
import com.zj.adlib.sb0;
import com.zj.adlib.xy1;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a implements AnalyticsCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<AnalyticsListener.a> f30518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Player f2271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.b f2272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.d f2273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final C0674a f2274a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f2275a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HandlerWrapper f2276a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ListenerSet<AnalyticsListener> f2277a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2278a;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.analytics.a$a, reason: collision with other inner class name */
    public static final class C0674a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Timeline.b f30519a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public MediaSource.a f2279a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ImmutableList<MediaSource.a> f2280a = ImmutableList.of();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ImmutableMap<MediaSource.a, Timeline> f2281a = ImmutableMap.of();
        public MediaSource.a b;
        public MediaSource.a c;

        public C0674a(Timeline.b bVar) {
            this.f30519a = bVar;
        }

        @Nullable
        public static MediaSource.a c(Player player, ImmutableList<MediaSource.a> immutableList, @Nullable MediaSource.a aVar, Timeline.b bVar) {
            Timeline timelineA0 = player.a0();
            int currentPeriodIndex = player.getCurrentPeriodIndex();
            Object objS = timelineA0.w() ? null : timelineA0.s(currentPeriodIndex);
            int iG = (player.isPlayingAd() || timelineA0.w()) ? -1 : timelineA0.j(currentPeriodIndex, bVar).g(gj9.Z0(player.getCurrentPosition()) - bVar.s());
            for (int i = 0; i < immutableList.size(); i++) {
                MediaSource.a aVar2 = immutableList.get(i);
                if (i(aVar2, objS, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), iG)) {
                    return aVar2;
                }
            }
            if (immutableList.isEmpty() && aVar != null) {
                if (i(aVar, objS, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), iG)) {
                    return aVar;
                }
            }
            return null;
        }

        public static boolean i(MediaSource.a aVar, @Nullable Object obj, boolean z, int i, int i2, int i3) {
            if (((gk5) aVar).f16805a.equals(obj)) {
                return (z && ((gk5) aVar).f41928a == i && aVar.b == i2) || (!z && ((gk5) aVar).f41928a == -1 && aVar.c == i3);
            }
            return false;
        }

        public final void b(ImmutableMap.b<MediaSource.a, Timeline> bVar, @Nullable MediaSource.a aVar, Timeline timeline) {
            if (aVar == null) {
                return;
            }
            if (timeline.f(((gk5) aVar).f16805a) != -1) {
                bVar.f(aVar, timeline);
                return;
            }
            Timeline timeline2 = this.f2281a.get(aVar);
            if (timeline2 != null) {
                bVar.f(aVar, timeline2);
            }
        }

        @Nullable
        public MediaSource.a d() {
            return this.f2279a;
        }

        @Nullable
        public MediaSource.a e() {
            if (this.f2280a.isEmpty()) {
                return null;
            }
            return (MediaSource.a) o.w(this.f2280a);
        }

        @Nullable
        public Timeline f(MediaSource.a aVar) {
            return this.f2281a.get(aVar);
        }

        @Nullable
        public MediaSource.a g() {
            return this.b;
        }

        @Nullable
        public MediaSource.a h() {
            return this.c;
        }

        public void j(Player player) {
            this.f2279a = c(player, this.f2280a, this.b, this.f30519a);
        }

        public void k(List<MediaSource.a> list, @Nullable MediaSource.a aVar, Player player) {
            this.f2280a = ImmutableList.copyOf((Collection) list);
            if (!list.isEmpty()) {
                this.b = list.get(0);
                this.c = (MediaSource.a) sb0.g(aVar);
            }
            if (this.f2279a == null) {
                this.f2279a = c(player, this.f2280a, this.b, this.f30519a);
            }
            m(player.a0());
        }

        public void l(Player player) {
            this.f2279a = c(player, this.f2280a, this.b, this.f30519a);
            m(player.a0());
        }

        public final void m(Timeline timeline) {
            ImmutableMap.b<MediaSource.a, Timeline> bVarBuilder = ImmutableMap.builder();
            if (this.f2280a.isEmpty()) {
                b(bVarBuilder, this.b, timeline);
                if (!g.a(this.c, this.b)) {
                    b(bVarBuilder, this.c, timeline);
                }
                if (!g.a(this.f2279a, this.b) && !g.a(this.f2279a, this.c)) {
                    b(bVarBuilder, this.f2279a, timeline);
                }
            } else {
                for (int i = 0; i < this.f2280a.size(); i++) {
                    b(bVarBuilder, this.f2280a.get(i), timeline);
                }
                if (!this.f2280a.contains(this.f2279a)) {
                    b(bVarBuilder, this.f2279a, timeline);
                }
            }
            this.f2281a = bVarBuilder.b();
        }
    }

    public a(Clock clock) {
        this.f2275a = (Clock) sb0.g(clock);
        this.f2277a = new ListenerSet<>(gj9.Y(), clock, new ListenerSet.IterationFinishedEvent() { // from class: com.zj.adlib.qc2
            @Override // com.google.android.exoplayer2.util.ListenerSet.IterationFinishedEvent
            public final void a(Object obj, a aVar) {
                com.google.android.exoplayer2.analytics.a.k1((AnalyticsListener) obj, aVar);
            }
        });
        Timeline.b bVar = new Timeline.b();
        this.f2272a = bVar;
        this.f2273a = new Timeline.d();
        this.f2274a = new C0674a(bVar);
        this.f30518a = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A2(Player player, AnalyticsListener analyticsListener, com.google.android.exoplayer2.util.a aVar) {
        analyticsListener.v0(player, new AnalyticsListener.b(aVar, this.f30518a));
    }

    public static /* synthetic */ void H1(AnalyticsListener.a aVar, int i, AnalyticsListener analyticsListener) {
        analyticsListener.C(aVar);
        analyticsListener.D0(aVar, i);
    }

    public static /* synthetic */ void L1(AnalyticsListener.a aVar, boolean z, AnalyticsListener analyticsListener) {
        analyticsListener.D(aVar, z);
        analyticsListener.e0(aVar, z);
    }

    public static /* synthetic */ void d2(AnalyticsListener.a aVar, int i, Player.d dVar, Player.d dVar2, AnalyticsListener analyticsListener) {
        analyticsListener.X(aVar, i);
        analyticsListener.y0(aVar, dVar, dVar2, i);
    }

    public static /* synthetic */ void k1(AnalyticsListener analyticsListener, com.google.android.exoplayer2.util.a aVar) {
    }

    public static /* synthetic */ void o1(AnalyticsListener.a aVar, String str, long j, long j2, AnalyticsListener analyticsListener) {
        analyticsListener.x(aVar, str, j);
        analyticsListener.q0(aVar, str, j2, j);
        analyticsListener.r(aVar, 1, str, j);
    }

    public static /* synthetic */ void q1(AnalyticsListener.a aVar, p82 p82Var, AnalyticsListener analyticsListener) {
        analyticsListener.p0(aVar, p82Var);
        analyticsListener.B0(aVar, 1, p82Var);
    }

    public static /* synthetic */ void r1(AnalyticsListener.a aVar, p82 p82Var, AnalyticsListener analyticsListener) {
        analyticsListener.j0(aVar, p82Var);
        analyticsListener.i(aVar, 1, p82Var);
    }

    public static /* synthetic */ void r2(AnalyticsListener.a aVar, String str, long j, long j2, AnalyticsListener analyticsListener) {
        analyticsListener.S(aVar, str, j);
        analyticsListener.g(aVar, str, j2, j);
        analyticsListener.r(aVar, 2, str, j);
    }

    public static /* synthetic */ void s1(AnalyticsListener.a aVar, com.google.android.exoplayer2.d dVar, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.E0(aVar, dVar);
        analyticsListener.a(aVar, dVar, decoderReuseEvaluation);
        analyticsListener.c0(aVar, 1, dVar);
    }

    public static /* synthetic */ void t2(AnalyticsListener.a aVar, p82 p82Var, AnalyticsListener analyticsListener) {
        analyticsListener.U(aVar, p82Var);
        analyticsListener.B0(aVar, 2, p82Var);
    }

    public static /* synthetic */ void u2(AnalyticsListener.a aVar, p82 p82Var, AnalyticsListener analyticsListener) {
        analyticsListener.o(aVar, p82Var);
        analyticsListener.i(aVar, 2, p82Var);
    }

    public static /* synthetic */ void w2(AnalyticsListener.a aVar, com.google.android.exoplayer2.d dVar, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.H(aVar, dVar);
        analyticsListener.y(aVar, dVar, decoderReuseEvaluation);
        analyticsListener.c0(aVar, 2, dVar);
    }

    public static /* synthetic */ void x2(AnalyticsListener.a aVar, hp9 hp9Var, AnalyticsListener analyticsListener) {
        analyticsListener.b0(aVar, hp9Var);
        analyticsListener.N(aVar, hp9Var.K, hp9Var.L, hp9Var.M, hp9Var.f17051a);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void A(final DeviceInfo deviceInfo) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 29, new ListenerSet.Event() { // from class: com.zj.adlib.r92
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).c(aVarGenerateCurrentPlayerMediaPeriodEventTime, deviceInfo);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void B(final com.google.android.exoplayer2.audio.a aVar) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 20, new ListenerSet.Event() { // from class: com.zj.adlib.cb2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).a0(aVarI1, aVar);
            }
        });
    }

    public final void B2() {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 1028, new ListenerSet.Event() { // from class: com.zj.adlib.wa2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).Z(aVarGenerateCurrentPlayerMediaPeriodEventTime);
            }
        });
        this.f2277a.k();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void C(final Player.d dVar, final Player.d dVar2, final int i) {
        if (i == 1) {
            this.f2278a = false;
        }
        this.f2274a.j((Player) sb0.g(this.f2271a));
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 11, new ListenerSet.Event() { // from class: com.zj.adlib.ud2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                com.google.android.exoplayer2.analytics.a.d2(aVarGenerateCurrentPlayerMediaPeriodEventTime, i, dVar, dVar2, (AnalyticsListener) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void E(final Player.b bVar) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 13, new ListenerSet.Event() { // from class: com.zj.adlib.cc2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).v(aVarGenerateCurrentPlayerMediaPeriodEventTime, bVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void F(@Nullable final com.google.android.exoplayer2.g gVar, final int i) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 1, new ListenerSet.Event() { // from class: com.zj.adlib.na2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).d(aVarGenerateCurrentPlayerMediaPeriodEventTime, gVar, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void G(final p pVar) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 2, new ListenerSet.Event() { // from class: com.zj.adlib.ua2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).V(aVarGenerateCurrentPlayerMediaPeriodEventTime, pVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void H(@Nullable final PlaybackException playbackException) {
        final AnalyticsListener.a aVarJ1 = j1(playbackException);
        sendEvent(aVarJ1, 10, new ListenerSet.Event() { // from class: com.zj.adlib.c92
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).J(aVarJ1, playbackException);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void I(int i, @Nullable MediaSource.a aVar) {
        final AnalyticsListener.a aVarG1 = g1(i, aVar);
        sendEvent(aVarG1, 1025, new ListenerSet.Event() { // from class: com.zj.adlib.dd2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).Q(aVarG1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void J(int i, @Nullable MediaSource.a aVar, final oh5 oh5Var) {
        final AnalyticsListener.a aVarG1 = g1(i, aVar);
        sendEvent(aVarG1, 1004, new ListenerSet.Event() { // from class: com.zj.adlib.gb2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).F(aVarG1, oh5Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    @CallSuper
    public void N(final Player player, Looper looper) {
        sb0.i(this.f2271a == null || this.f2274a.f2280a.isEmpty());
        this.f2271a = (Player) sb0.g(player);
        this.f2276a = this.f2275a.a(looper, null);
        this.f2277a = this.f2277a.f(looper, new ListenerSet.IterationFinishedEvent() { // from class: com.zj.adlib.ia2
            @Override // com.google.android.exoplayer2.util.ListenerSet.IterationFinishedEvent
            public final void a(Object obj, a aVar) {
                this.f17174a.A2(player, (AnalyticsListener) obj, aVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void O(int i, @Nullable MediaSource.a aVar) {
        final AnalyticsListener.a aVarG1 = g1(i, aVar);
        sendEvent(aVarG1, 1026, new ListenerSet.Event() { // from class: com.zj.adlib.ab2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).x0(aVarG1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void a(final com.google.android.exoplayer2.d dVar, @Nullable final DecoderReuseEvaluation decoderReuseEvaluation) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 1017, new ListenerSet.Event() { // from class: com.zj.adlib.yc2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                com.google.android.exoplayer2.analytics.a.w2(aVarI1, dVar, decoderReuseEvaluation, (AnalyticsListener) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void b(final Metadata metadata) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 28, new ListenerSet.Event() { // from class: com.zj.adlib.v82
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).m(aVarGenerateCurrentPlayerMediaPeriodEventTime, metadata);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void c(final p82 p82Var) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 1015, new ListenerSet.Event() { // from class: com.zj.adlib.m92
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                com.google.android.exoplayer2.analytics.a.u2(aVarI1, p82Var, (AnalyticsListener) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void d(final com.google.android.exoplayer2.d dVar, @Nullable final DecoderReuseEvaluation decoderReuseEvaluation) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 1009, new ListenerSet.Event() { // from class: com.zj.adlib.ub2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                com.google.android.exoplayer2.analytics.a.s1(aVarI1, dVar, decoderReuseEvaluation, (AnalyticsListener) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void e(int i, @Nullable MediaSource.a aVar, final az4 az4Var, final oh5 oh5Var) {
        final AnalyticsListener.a aVarG1 = g1(i, aVar);
        sendEvent(aVarG1, 1001, new ListenerSet.Event() { // from class: com.zj.adlib.wd2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).s0(aVarG1, az4Var, oh5Var);
            }
        });
    }

    public final AnalyticsListener.a e1(@Nullable MediaSource.a aVar) {
        sb0.g(this.f2271a);
        Timeline timelineF = aVar == null ? null : this.f2274a.f(aVar);
        if (aVar != null && timelineF != null) {
            return generateEventTime(timelineF, timelineF.l(((gk5) aVar).f16805a, this.f2272a).K, aVar);
        }
        int currentMediaItemIndex = this.f2271a.getCurrentMediaItemIndex();
        Timeline timelineA0 = this.f2271a.a0();
        if (!(currentMediaItemIndex < timelineA0.v())) {
            timelineA0 = Timeline.f2189a;
        }
        return generateEventTime(timelineA0, currentMediaItemIndex, null);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void f(final p82 p82Var) {
        final AnalyticsListener.a aVarH1 = h1();
        sendEvent(aVarH1, 1013, new ListenerSet.Event() { // from class: com.zj.adlib.uc2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                com.google.android.exoplayer2.analytics.a.q1(aVarH1, p82Var, (AnalyticsListener) obj);
            }
        });
    }

    public final AnalyticsListener.a f1() {
        return e1(this.f2274a.e());
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void g(final j jVar) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 12, new ListenerSet.Event() { // from class: com.zj.adlib.id2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).P(aVarGenerateCurrentPlayerMediaPeriodEventTime, jVar);
            }
        });
    }

    public final AnalyticsListener.a g1(int i, @Nullable MediaSource.a aVar) {
        sb0.g(this.f2271a);
        if (aVar != null) {
            return this.f2274a.f(aVar) != null ? e1(aVar) : generateEventTime(Timeline.f2189a, i, aVar);
        }
        Timeline timelineA0 = this.f2271a.a0();
        if (!(i < timelineA0.v())) {
            timelineA0 = Timeline.f2189a;
        }
        return generateEventTime(timelineA0, i, null);
    }

    public final AnalyticsListener.a generateCurrentPlayerMediaPeriodEventTime() {
        return e1(this.f2274a.d());
    }

    @RequiresNonNull({AliyunLogCommon.Product.VIDEO_PLAYER})
    public final AnalyticsListener.a generateEventTime(Timeline timeline, int i, @Nullable MediaSource.a aVar) {
        long contentPosition;
        MediaSource.a aVar2 = timeline.w() ? null : aVar;
        long jElapsedRealtime = this.f2275a.elapsedRealtime();
        boolean z = timeline.equals(this.f2271a.a0()) && i == this.f2271a.getCurrentMediaItemIndex();
        long jE = 0;
        if (aVar2 == null || !aVar2.c()) {
            if (z) {
                contentPosition = this.f2271a.getContentPosition();
            } else if (!timeline.w()) {
                jE = timeline.t(i, this.f2273a).e();
            }
            return new AnalyticsListener.a(jElapsedRealtime, timeline, i, aVar2, contentPosition, this.f2271a.a0(), this.f2271a.getCurrentMediaItemIndex(), this.f2274a.d(), this.f2271a.getCurrentPosition(), this.f2271a.getTotalBufferedDuration());
        }
        if (z && this.f2271a.getCurrentAdGroupIndex() == ((gk5) aVar2).f41928a && this.f2271a.getCurrentAdIndexInAdGroup() == aVar2.b) {
            jE = this.f2271a.getCurrentPosition();
        }
        contentPosition = jE;
        return new AnalyticsListener.a(jElapsedRealtime, timeline, i, aVar2, contentPosition, this.f2271a.a0(), this.f2271a.getCurrentMediaItemIndex(), this.f2274a.d(), this.f2271a.getCurrentPosition(), this.f2271a.getTotalBufferedDuration());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void h(final p82 p82Var) {
        final AnalyticsListener.a aVarH1 = h1();
        sendEvent(aVarH1, 1020, new ListenerSet.Event() { // from class: com.zj.adlib.sb2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                com.google.android.exoplayer2.analytics.a.t2(aVarH1, p82Var, (AnalyticsListener) obj);
            }
        });
    }

    public final AnalyticsListener.a h1() {
        return e1(this.f2274a.g());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void i(final p82 p82Var) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 1007, new ListenerSet.Event() { // from class: com.zj.adlib.yb2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                com.google.android.exoplayer2.analytics.a.r1(aVarI1, p82Var, (AnalyticsListener) obj);
            }
        });
    }

    public final AnalyticsListener.a i1() {
        return e1(this.f2274a.h());
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void j(final xy1 xy1Var) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 27, new ListenerSet.Event() { // from class: com.zj.adlib.mc2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).l0(aVarGenerateCurrentPlayerMediaPeriodEventTime, xy1Var);
            }
        });
    }

    public final AnalyticsListener.a j1(@Nullable PlaybackException playbackException) {
        gk5 gk5Var;
        return (!(playbackException instanceof ExoPlaybackException) || (gk5Var = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? generateCurrentPlayerMediaPeriodEventTime() : e1(new MediaSource.a(gk5Var));
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void k(int i, @Nullable MediaSource.a aVar) {
        final AnalyticsListener.a aVarG1 = g1(i, aVar);
        sendEvent(aVarG1, 1027, new ListenerSet.Event() { // from class: com.zj.adlib.pa2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).u(aVarG1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void l(int i, @Nullable MediaSource.a aVar, final oh5 oh5Var) {
        final AnalyticsListener.a aVarG1 = g1(i, aVar);
        sendEvent(aVarG1, 1005, new ListenerSet.Event() { // from class: com.zj.adlib.wb2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).M(aVarG1, oh5Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void m(int i, @Nullable MediaSource.a aVar, final az4 az4Var, final oh5 oh5Var) {
        final AnalyticsListener.a aVarG1 = g1(i, aVar);
        sendEvent(aVarG1, 1000, new ListenerSet.Event() { // from class: com.zj.adlib.kd2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).E(aVarG1, az4Var, oh5Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void n(int i, @Nullable MediaSource.a aVar, final Exception exc) {
        final AnalyticsListener.a aVarG1 = g1(i, aVar);
        sendEvent(aVarG1, 1024, new ListenerSet.Event() { // from class: com.zj.adlib.md2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).m0(aVarG1, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void notifySeekStarted() {
        if (this.f2278a) {
            return;
        }
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        this.f2278a = true;
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, -1, new ListenerSet.Event() { // from class: com.zj.adlib.de2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).G(aVarGenerateCurrentPlayerMediaPeriodEventTime);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void o(int i, @Nullable MediaSource.a aVar) {
        final AnalyticsListener.a aVarG1 = g1(i, aVar);
        sendEvent(aVarG1, 1023, new ListenerSet.Event() { // from class: com.zj.adlib.ga2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).C0(aVarG1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioCodecError(final Exception exc) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 1029, new ListenerSet.Event() { // from class: com.zj.adlib.sc2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).L(aVarI1, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioDecoderInitialized(final String str, final long j, final long j2) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 1008, new ListenerSet.Event() { // from class: com.zj.adlib.y92
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                com.google.android.exoplayer2.analytics.a.o1(aVarI1, str, j2, j, (AnalyticsListener) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioDecoderReleased(final String str) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 1012, new ListenerSet.Event() { // from class: com.zj.adlib.ka2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).n0(aVarI1, str);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioPositionAdvancing(final long j) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 1010, new ListenerSet.Event() { // from class: com.zj.adlib.ma2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).t0(aVarI1, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onAudioSessionIdChanged(final int i) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 21, new ListenerSet.Event() { // from class: com.zj.adlib.aa2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).I(aVarI1, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioSinkError(final Exception exc) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 1014, new ListenerSet.Event() { // from class: com.zj.adlib.eb2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).F0(aVarI1, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioUnderrun(final int i, final long j, final long j2) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 1011, new ListenerSet.Event() { // from class: com.zj.adlib.jb2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).l(aVarI1, i, j, j2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener
    public final void onBandwidthSample(final int i, final long j, final long j2) {
        final AnalyticsListener.a aVarF1 = f1();
        sendEvent(aVarF1, 1006, new ListenerSet.Event() { // from class: com.zj.adlib.wc2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).t(aVarF1, i, j, j2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onCues(final List<Cue> list) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 27, new ListenerSet.Event() { // from class: com.zj.adlib.sd2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).z(aVarGenerateCurrentPlayerMediaPeriodEventTime, list);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onDeviceVolumeChanged(final int i, final boolean z) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 30, new ListenerSet.Event() { // from class: com.zj.adlib.i92
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).f(aVarGenerateCurrentPlayerMediaPeriodEventTime, i, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onDroppedFrames(final int i, final long j) {
        final AnalyticsListener.a aVarH1 = h1();
        sendEvent(aVarH1, 1018, new ListenerSet.Event() { // from class: com.zj.adlib.qb2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).W(aVarH1, i, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onIsLoadingChanged(final boolean z) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 3, new ListenerSet.Event() { // from class: com.zj.adlib.gd2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                com.google.android.exoplayer2.analytics.a.L1(aVarGenerateCurrentPlayerMediaPeriodEventTime, z, (AnalyticsListener) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onIsPlayingChanged(final boolean z) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 7, new ListenerSet.Event() { // from class: com.zj.adlib.ya2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).r0(aVarGenerateCurrentPlayerMediaPeriodEventTime, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onLoadingChanged(boolean z) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onMaxSeekToPreviousPositionChanged(final long j) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 18, new ListenerSet.Event() { // from class: com.zj.adlib.ca2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).e(aVarGenerateCurrentPlayerMediaPeriodEventTime, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlayWhenReadyChanged(final boolean z, final int i) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 5, new ListenerSet.Event() { // from class: com.zj.adlib.hc2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).n(aVarGenerateCurrentPlayerMediaPeriodEventTime, z, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlaybackStateChanged(final int i) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 4, new ListenerSet.Event() { // from class: com.zj.adlib.bd2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).A0(aVarGenerateCurrentPlayerMediaPeriodEventTime, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlaybackSuppressionReasonChanged(final int i) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 6, new ListenerSet.Event() { // from class: com.zj.adlib.lb2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).K(aVarGenerateCurrentPlayerMediaPeriodEventTime, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlayerError(final PlaybackException playbackException) {
        final AnalyticsListener.a aVarJ1 = j1(playbackException);
        sendEvent(aVarJ1, 10, new ListenerSet.Event() { // from class: com.zj.adlib.t92
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).A(aVarJ1, playbackException);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlayerStateChanged(final boolean z, final int i) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, -1, new ListenerSet.Event() { // from class: com.zj.adlib.ob2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).O(aVarGenerateCurrentPlayerMediaPeriodEventTime, z, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPositionDiscontinuity(int i) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onRenderedFirstFrame() {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onRenderedFirstFrame(final Object obj, final long j) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 26, new ListenerSet.Event() { // from class: com.zj.adlib.k92
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj2) {
                ((AnalyticsListener) obj2).g0(aVarI1, obj, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onRepeatModeChanged(final int i) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 8, new ListenerSet.Event() { // from class: com.zj.adlib.ac2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).z0(aVarGenerateCurrentPlayerMediaPeriodEventTime, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onSeekBackIncrementChanged(final long j) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 16, new ListenerSet.Event() { // from class: com.zj.adlib.ib2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).p(aVarGenerateCurrentPlayerMediaPeriodEventTime, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onSeekForwardIncrementChanged(final long j) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 17, new ListenerSet.Event() { // from class: com.zj.adlib.q92
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).i0(aVarGenerateCurrentPlayerMediaPeriodEventTime, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onSeekProcessed() {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, -1, new ListenerSet.Event() { // from class: com.zj.adlib.qd2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).f0(aVarGenerateCurrentPlayerMediaPeriodEventTime);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onShuffleModeEnabledChanged(final boolean z) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 9, new ListenerSet.Event() { // from class: com.zj.adlib.g92
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).h0(aVarGenerateCurrentPlayerMediaPeriodEventTime, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onSkipSilenceEnabledChanged(final boolean z) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 23, new ListenerSet.Event() { // from class: com.zj.adlib.w92
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).s(aVarI1, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onSurfaceSizeChanged(final int i, final int i2) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 24, new ListenerSet.Event() { // from class: com.zj.adlib.ec2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).d0(aVarI1, i, i2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onVideoCodecError(final Exception exc) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 1030, new ListenerSet.Event() { // from class: com.zj.adlib.zd2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).q(aVarI1, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onVideoDecoderInitialized(final String str, final long j, final long j2) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 1016, new ListenerSet.Event() { // from class: com.zj.adlib.a92
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                com.google.android.exoplayer2.analytics.a.r2(aVarI1, str, j2, j, (AnalyticsListener) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onVideoDecoderReleased(final String str) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 1019, new ListenerSet.Event() { // from class: com.zj.adlib.e92
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).o0(aVarI1, str);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onVideoFrameProcessingOffset(final long j, final int i) {
        final AnalyticsListener.a aVarH1 = h1();
        sendEvent(aVarH1, 1021, new ListenerSet.Event() { // from class: com.zj.adlib.be2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).Y(aVarH1, j, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onVideoSizeChanged(final hp9 hp9Var) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 25, new ListenerSet.Event() { // from class: com.zj.adlib.sa2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                com.google.android.exoplayer2.analytics.a.x2(aVarI1, hp9Var, (AnalyticsListener) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onVolumeChanged(final float f) {
        final AnalyticsListener.a aVarI1 = i1();
        sendEvent(aVarI1, 22, new ListenerSet.Event() { // from class: com.zj.adlib.fc2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).w(aVarI1, f);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    @CallSuper
    public void p(AnalyticsListener analyticsListener) {
        sb0.g(analyticsListener);
        this.f2277a.c(analyticsListener);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void q(final com.google.android.exoplayer2.trackselection.c cVar) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 19, new ListenerSet.Event() { // from class: com.zj.adlib.x82
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).k(aVarGenerateCurrentPlayerMediaPeriodEventTime, cVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void r(Timeline timeline, final int i) {
        this.f2274a.l((Player) sb0.g(this.f2271a));
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 0, new ListenerSet.Event() { // from class: com.zj.adlib.od2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).R(aVarGenerateCurrentPlayerMediaPeriodEventTime, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    @CallSuper
    public void release() {
        ((HandlerWrapper) sb0.k(this.f2276a)).post(new Runnable() { // from class: com.zj.adlib.o92
            @Override // java.lang.Runnable
            public final void run() {
                this.f43698a.B2();
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void s(List<MediaSource.a> list, @Nullable MediaSource.a aVar) {
        this.f2274a.k(list, aVar, (Player) sb0.g(this.f2271a));
    }

    public final void sendEvent(AnalyticsListener.a aVar, int i, ListenerSet.Event<AnalyticsListener> event) {
        this.f30518a.put(i, aVar);
        this.f2277a.m(i, event);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void t(Player player, Player.c cVar) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    @CallSuper
    public void u(AnalyticsListener analyticsListener) {
        this.f2277a.l(analyticsListener);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void v(int i, @Nullable MediaSource.a aVar, final int i2) {
        final AnalyticsListener.a aVarG1 = g1(i, aVar);
        sendEvent(aVarG1, 1022, new ListenerSet.Event() { // from class: com.zj.adlib.ad2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                com.google.android.exoplayer2.analytics.a.H1(aVarG1, i2, (AnalyticsListener) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void w(int i, @Nullable MediaSource.a aVar, final az4 az4Var, final oh5 oh5Var) {
        final AnalyticsListener.a aVarG1 = g1(i, aVar);
        sendEvent(aVarG1, 1002, new ListenerSet.Event() { // from class: com.zj.adlib.ea2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).T(aVarG1, az4Var, oh5Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void x(final MediaMetadata mediaMetadata) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 14, new ListenerSet.Event() { // from class: com.zj.adlib.xd2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).j(aVarGenerateCurrentPlayerMediaPeriodEventTime, mediaMetadata);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void y(int i, @Nullable MediaSource.a aVar, final az4 az4Var, final oh5 oh5Var, final IOException iOException, final boolean z) {
        final AnalyticsListener.a aVarG1 = g1(i, aVar);
        sendEvent(aVarG1, 1003, new ListenerSet.Event() { // from class: com.zj.adlib.oc2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).h(aVarG1, az4Var, oh5Var, iOException, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void z(final MediaMetadata mediaMetadata) {
        final AnalyticsListener.a aVarGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(aVarGenerateCurrentPlayerMediaPeriodEventTime, 15, new ListenerSet.Event() { // from class: com.zj.adlib.kc2
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).u0(aVarGenerateCurrentPlayerMediaPeriodEventTime, mediaMetadata);
            }
        });
    }
}
