package com.google.android.exoplayer2.analytics;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.MediaSource;
import com.zj.adlib.az4;
import com.zj.adlib.gj9;
import com.zj.adlib.gk5;
import com.zj.adlib.hp9;
import com.zj.adlib.oh5;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class PlaybackStatsListener implements AnalyticsListener, PlaybackSessionManager.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.b f2231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PlaybackSessionManager f2232a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Callback f2233a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f2234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.d f2235a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hp9 f2236a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Exception f2237a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public String f2238a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, a> f2239a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2240a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.d f2241b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Map<String, AnalyticsListener.a> f2242b;
    public long c;
    public int k0;
    public int l0;

    public interface Callback {
        void a(AnalyticsListener.a aVar, d dVar);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f30517a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f2243a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f2244a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public com.google.android.exoplayer2.d f2245a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<d.c> f2246a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f2247a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long[] f2248a = new long[16];
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f2249b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public com.google.android.exoplayer2.d f2250b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final List<long[]> f2251b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final boolean f2252b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public long f2253c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public final List<d.b> f2254c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f2255c;
        public int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public long f2256d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public final List<d.b> f2257d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public boolean f2258d;
        public int e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public long f2259e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public final List<d.a> f2260e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public boolean f2261e;
        public int f;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        public long f2262f;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        public final List<d.a> f2263f;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        public boolean f2264f;
        public int g;

        /* JADX INFO: renamed from: g, reason: collision with other field name */
        public long f2265g;

        /* JADX INFO: renamed from: g, reason: collision with other field name */
        public boolean f2266g;
        public int h;

        /* JADX INFO: renamed from: h, reason: collision with other field name */
        public long f2267h;

        /* JADX INFO: renamed from: h, reason: collision with other field name */
        public boolean f2268h;
        public long i;

        /* JADX INFO: renamed from: i, reason: collision with other field name */
        public boolean f2269i;
        public long j;

        /* JADX INFO: renamed from: j, reason: collision with other field name */
        public boolean f2270j;
        public long k;
        public long l;
        public long m;
        public long n;
        public long o;
        public long p;
        public long q;
        public long r;

        public a(boolean z, AnalyticsListener.a aVar) {
            this.f2247a = z;
            this.f2246a = z ? new ArrayList<>() : Collections.emptyList();
            this.f2251b = z ? new ArrayList<>() : Collections.emptyList();
            this.f2254c = z ? new ArrayList<>() : Collections.emptyList();
            this.f2257d = z ? new ArrayList<>() : Collections.emptyList();
            this.f2260e = z ? new ArrayList<>() : Collections.emptyList();
            this.f2263f = z ? new ArrayList<>() : Collections.emptyList();
            boolean z2 = false;
            this.h = 0;
            this.o = aVar.f2224a;
            this.f2244a = -9223372036854775807L;
            this.f2249b = -9223372036854775807L;
            MediaSource.a aVar2 = aVar.f2226a;
            if (aVar2 != null && aVar2.c()) {
                z2 = true;
            }
            this.f2252b = z2;
            this.f2256d = -1L;
            this.f2253c = -1L;
            this.e = -1;
            this.f30517a = 1.0f;
        }

        public static boolean c(int i, int i2) {
            return ((i != 1 && i != 2 && i != 14) || i2 == 1 || i2 == 2 || i2 == 14 || i2 == 3 || i2 == 4 || i2 == 9 || i2 == 11) ? false : true;
        }

        public static boolean d(int i) {
            return i == 4 || i == 7;
        }

        public static boolean e(int i) {
            return i == 3 || i == 4 || i == 9;
        }

        public static boolean f(int i) {
            return i == 6 || i == 7 || i == 10;
        }

        public d a(boolean z) {
            long[] jArr;
            List<long[]> list;
            long[] jArr2 = this.f2248a;
            List<long[]> list2 = this.f2251b;
            if (z) {
                jArr = jArr2;
                list = list2;
            } else {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long[] jArrCopyOf = Arrays.copyOf(this.f2248a, 16);
                long jMax = Math.max(0L, jElapsedRealtime - this.o);
                int i = this.h;
                jArrCopyOf[i] = jArrCopyOf[i] + jMax;
                j(jElapsedRealtime);
                h(jElapsedRealtime);
                g(jElapsedRealtime);
                ArrayList arrayList = new ArrayList(this.f2251b);
                if (this.f2247a && this.h == 3) {
                    arrayList.add(b(jElapsedRealtime));
                }
                jArr = jArrCopyOf;
                list = arrayList;
            }
            int i2 = (this.f2261e || !this.f2255c) ? 1 : 0;
            long j = i2 != 0 ? -9223372036854775807L : jArr[2];
            int i3 = jArr[1] > 0 ? 1 : 0;
            List arrayList2 = z ? this.f2254c : new ArrayList(this.f2254c);
            List arrayList3 = z ? this.f2257d : new ArrayList(this.f2257d);
            List arrayList4 = z ? this.f2246a : new ArrayList(this.f2246a);
            long j2 = this.f2244a;
            boolean z2 = this.f2266g;
            int i4 = !this.f2255c ? 1 : 0;
            boolean z3 = this.f2258d;
            int i5 = i2 ^ 1;
            int i6 = this.f2243a;
            int i7 = this.b;
            int i8 = this.c;
            int i9 = this.d;
            long j3 = this.f2249b;
            boolean z4 = this.f2252b;
            long[] jArr3 = jArr;
            long j4 = this.f2259e;
            long j5 = this.f2262f;
            long j6 = this.f2265g;
            long j7 = this.f2267h;
            long j8 = this.i;
            long j9 = this.j;
            int i10 = this.e;
            int i11 = i10 == -1 ? 0 : 1;
            long j10 = this.f2253c;
            int i12 = j10 == -1 ? 0 : 1;
            long j11 = this.f2256d;
            int i13 = j11 == -1 ? 0 : 1;
            long j12 = this.k;
            long j13 = this.l;
            long j14 = this.m;
            long j15 = this.n;
            int i14 = this.f;
            return new d(1, jArr3, arrayList4, list, j2, z2 ? 1 : 0, i4, z3 ? 1 : 0, i3, j, i5, i6, i7, i8, i9, j3, z4 ? 1 : 0, arrayList2, arrayList3, j4, j5, j6, j7, j8, j9, i11, i12, i10, j10, i13, j11, j12, j13, j14, j15, i14 > 0 ? 1 : 0, i14, this.g, this.f2260e, this.f2263f);
        }

        public final long[] b(long j) {
            List<long[]> list = this.f2251b;
            long[] jArr = list.get(list.size() - 1);
            return new long[]{j, jArr[1] + ((long) ((j - jArr[0]) * this.f30517a))};
        }

        public final void g(long j) {
            com.google.android.exoplayer2.d dVar;
            int i;
            if (this.h == 3 && (dVar = this.f2250b) != null && (i = dVar.O) != -1) {
                long j2 = (long) ((j - this.r) * this.f30517a);
                this.i += j2;
                this.j += j2 * ((long) i);
            }
            this.r = j;
        }

        public final void h(long j) {
            com.google.android.exoplayer2.d dVar;
            if (this.h == 3 && (dVar = this.f2245a) != null) {
                long j2 = (long) ((j - this.q) * this.f30517a);
                int i = dVar.R;
                if (i != -1) {
                    this.f2259e += j2;
                    this.f2262f += ((long) i) * j2;
                }
                int i2 = dVar.O;
                if (i2 != -1) {
                    this.f2265g += j2;
                    this.f2267h += j2 * ((long) i2);
                }
            }
            this.q = j;
        }

        public final void i(AnalyticsListener.a aVar, @Nullable com.google.android.exoplayer2.d dVar) {
            int i;
            if (gj9.c(this.f2250b, dVar)) {
                return;
            }
            g(aVar.f2224a);
            if (dVar != null && this.f2256d == -1 && (i = dVar.O) != -1) {
                this.f2256d = i;
            }
            this.f2250b = dVar;
            if (this.f2247a) {
                this.f2257d.add(new d.b(aVar, dVar));
            }
        }

        public final void j(long j) {
            if (f(this.h)) {
                long j2 = j - this.p;
                long j3 = this.f2249b;
                if (j3 == -9223372036854775807L || j2 > j3) {
                    this.f2249b = j2;
                }
            }
        }

        public final void k(long j, long j2) {
            if (this.f2247a) {
                if (this.h != 3) {
                    if (j2 == -9223372036854775807L) {
                        return;
                    }
                    if (!this.f2251b.isEmpty()) {
                        List<long[]> list = this.f2251b;
                        long j3 = list.get(list.size() - 1)[1];
                        if (j3 != j2) {
                            this.f2251b.add(new long[]{j, j3});
                        }
                    }
                }
                if (j2 != -9223372036854775807L) {
                    this.f2251b.add(new long[]{j, j2});
                } else {
                    if (this.f2251b.isEmpty()) {
                        return;
                    }
                    this.f2251b.add(b(j));
                }
            }
        }

        public final void l(AnalyticsListener.a aVar, @Nullable com.google.android.exoplayer2.d dVar) {
            int i;
            int i2;
            if (gj9.c(this.f2245a, dVar)) {
                return;
            }
            h(aVar.f2224a);
            if (dVar != null) {
                if (this.e == -1 && (i2 = dVar.R) != -1) {
                    this.e = i2;
                }
                if (this.f2253c == -1 && (i = dVar.O) != -1) {
                    this.f2253c = i;
                }
            }
            this.f2245a = dVar;
            if (this.f2247a) {
                this.f2254c.add(new d.b(aVar, dVar));
            }
        }

        public void m(Player player, AnalyticsListener.a aVar, boolean z, long j, boolean z2, int i, boolean z3, boolean z4, @Nullable PlaybackException playbackException, @Nullable Exception exc, long j2, long j3, @Nullable com.google.android.exoplayer2.d dVar, @Nullable com.google.android.exoplayer2.d dVar2, @Nullable hp9 hp9Var) {
            if (j != -9223372036854775807L) {
                k(aVar.f2224a, j);
                this.f2264f = true;
            }
            if (player.getPlaybackState() != 2) {
                this.f2264f = false;
            }
            int playbackState = player.getPlaybackState();
            if (playbackState == 1 || playbackState == 4 || z2) {
                this.f2268h = false;
            }
            if (playbackException != null) {
                this.f2269i = true;
                this.f++;
                if (this.f2247a) {
                    this.f2260e.add(new d.a(aVar, playbackException));
                }
            } else if (player.f() == null) {
                this.f2269i = false;
            }
            if (this.f2266g && !this.f2268h) {
                p pVarS = player.s();
                if (!pVarS.e(2)) {
                    l(aVar, null);
                }
                if (!pVarS.e(1)) {
                    i(aVar, null);
                }
            }
            if (dVar != null) {
                l(aVar, dVar);
            }
            if (dVar2 != null) {
                i(aVar, dVar2);
            }
            com.google.android.exoplayer2.d dVar3 = this.f2245a;
            if (dVar3 != null && dVar3.R == -1 && hp9Var != null) {
                l(aVar, dVar3.b().j0(hp9Var.K).Q(hp9Var.L).E());
            }
            if (z4) {
                this.f2270j = true;
            }
            if (z3) {
                this.n++;
            }
            this.m += (long) i;
            this.k += j2;
            this.l += j3;
            if (exc != null) {
                this.g++;
                if (this.f2247a) {
                    this.f2263f.add(new d.a(aVar, exc));
                }
            }
            int iQ = q(player);
            float f = player.b().f3399a;
            if (this.h != iQ || this.f30517a != f) {
                k(aVar.f2224a, z ? aVar.f2227b : -9223372036854775807L);
                h(aVar.f2224a);
                g(aVar.f2224a);
            }
            this.f30517a = f;
            if (this.h != iQ) {
                r(iQ, aVar);
            }
        }

        public void n(AnalyticsListener.a aVar, boolean z, long j) {
            int i = 11;
            if (this.h != 11 && !z) {
                i = 15;
            }
            k(aVar.f2224a, j);
            h(aVar.f2224a);
            g(aVar.f2224a);
            r(i, aVar);
        }

        public void o() {
            this.f2266g = true;
        }

        public void p() {
            this.f2268h = true;
            this.f2264f = false;
        }

        public final int q(Player player) {
            int playbackState = player.getPlaybackState();
            if (this.f2264f && this.f2266g) {
                return 5;
            }
            if (this.f2269i) {
                return 13;
            }
            if (!this.f2266g) {
                return this.f2270j ? 1 : 0;
            }
            if (this.f2268h) {
                return 14;
            }
            if (playbackState == 4) {
                return 11;
            }
            if (playbackState != 2) {
                if (playbackState == 3) {
                    if (player.getPlayWhenReady()) {
                        return player.getPlaybackSuppressionReason() != 0 ? 9 : 3;
                    }
                    return 4;
                }
                if (playbackState != 1 || this.h == 0) {
                    return this.h;
                }
                return 12;
            }
            int i = this.h;
            if (i == 0 || i == 1 || i == 2 || i == 14) {
                return 2;
            }
            if (player.getPlayWhenReady()) {
                return player.getPlaybackSuppressionReason() != 0 ? 10 : 6;
            }
            return 7;
        }

        public final void r(int i, AnalyticsListener.a aVar) {
            sb0.a(aVar.f2224a >= this.o);
            long j = aVar.f2224a;
            long j2 = j - this.o;
            long[] jArr = this.f2248a;
            int i2 = this.h;
            jArr[i2] = jArr[i2] + j2;
            if (this.f2244a == -9223372036854775807L) {
                this.f2244a = j;
            }
            this.f2261e |= c(i2, i);
            this.f2255c |= e(i);
            this.f2258d |= i == 11;
            if (!d(this.h) && d(i)) {
                this.f2243a++;
            }
            if (i == 5) {
                this.c++;
            }
            if (!f(this.h) && f(i)) {
                this.d++;
                this.p = aVar.f2224a;
            }
            if (f(this.h) && this.h != 7 && i == 7) {
                this.b++;
            }
            j(aVar.f2224a);
            this.h = i;
            this.o = aVar.f2224a;
            if (this.f2247a) {
                this.f2246a.add(new d.c(aVar, i));
            }
        }
    }

    public PlaybackStatsListener(boolean z, @Nullable Callback callback) {
        this.f2233a = callback;
        this.f2240a = z;
        b bVar = new b();
        this.f2232a = bVar;
        this.f2239a = new HashMap();
        this.f2242b = new HashMap();
        this.f2234a = d.f30525a;
        this.f2231a = new Timeline.b();
        this.f2236a = hp9.f17050a;
        bVar.b(this);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void B(AnalyticsListener.a aVar, String str) {
        ((a) sb0.g(this.f2239a.get(str))).o();
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void F(AnalyticsListener.a aVar, oh5 oh5Var) {
        int i = oh5Var.b;
        if (i == 2 || i == 0) {
            this.f2235a = oh5Var.f18632a;
        } else if (i == 1) {
            this.f2241b = oh5Var.f18632a;
        }
    }

    public final Pair<AnalyticsListener.a, Boolean> G0(AnalyticsListener.b bVar, String str) {
        MediaSource.a aVar;
        AnalyticsListener.a aVar2 = null;
        boolean zG = false;
        for (int i = 0; i < bVar.e(); i++) {
            AnalyticsListener.a aVarD = bVar.d(bVar.c(i));
            boolean zG2 = this.f2232a.g(aVarD, str);
            if (aVar2 == null || ((zG2 && !zG) || (zG2 == zG && aVarD.f2224a > aVar2.f2224a))) {
                aVar2 = aVarD;
                zG = zG2;
            }
        }
        sb0.g(aVar2);
        if (!zG && (aVar = aVar2.f2226a) != null && aVar.c()) {
            long jI = aVar2.f2225a.l(((gk5) aVar2.f2226a).f16805a, this.f2231a).i(((gk5) aVar2.f2226a).f41928a);
            if (jI == Long.MIN_VALUE) {
                jI = this.f2231a.f2190a;
            }
            long jS = jI + this.f2231a.s();
            long j = aVar2.f2224a;
            Timeline timeline = aVar2.f2225a;
            int i2 = aVar2.f30514a;
            MediaSource.a aVar3 = aVar2.f2226a;
            AnalyticsListener.a aVar4 = new AnalyticsListener.a(j, timeline, i2, new MediaSource.a(((gk5) aVar3).f16805a, ((gk5) aVar3).f16804a, ((gk5) aVar3).f41928a), gj9.H1(jS), aVar2.f2225a, aVar2.b, aVar2.f2229b, aVar2.c, aVar2.d);
            zG = this.f2232a.g(aVar4, str);
            aVar2 = aVar4;
        }
        return Pair.create(aVar2, Boolean.valueOf(zG));
    }

    public d H0() {
        int i = 1;
        d[] dVarArr = new d[this.f2239a.size() + 1];
        dVarArr[0] = this.f2234a;
        Iterator<a> it = this.f2239a.values().iterator();
        while (it.hasNext()) {
            dVarArr[i] = it.next().a(false);
            i++;
        }
        return d.W(dVarArr);
    }

    @Nullable
    public d I0() {
        String activeSessionId = this.f2232a.getActiveSessionId();
        a aVar = activeSessionId == null ? null : this.f2239a.get(activeSessionId);
        if (aVar == null) {
            return null;
        }
        return aVar.a(false);
    }

    public final boolean J0(AnalyticsListener.b bVar, String str, int i) {
        return bVar.a(i) && this.f2232a.g(bVar.d(i), str);
    }

    public final void K0(AnalyticsListener.b bVar) {
        for (int i = 0; i < bVar.e(); i++) {
            int iC = bVar.c(i);
            AnalyticsListener.a aVarD = bVar.d(iC);
            if (iC == 0) {
                this.f2232a.f(aVarD);
            } else if (iC == 11) {
                this.f2232a.d(aVarD, this.k0);
            } else {
                this.f2232a.c(aVarD);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void W(AnalyticsListener.a aVar, int i, long j) {
        this.l0 = i;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void b(AnalyticsListener.a aVar, String str) {
        this.f2239a.put(str, new a(this.f2240a, aVar));
        this.f2242b.put(str, aVar);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void b0(AnalyticsListener.a aVar, hp9 hp9Var) {
        this.f2236a = hp9Var;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void h(AnalyticsListener.a aVar, az4 az4Var, oh5 oh5Var, IOException iOException, boolean z) {
        this.f2237a = iOException;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void k0(AnalyticsListener.a aVar, String str, boolean z) {
        a aVar2 = (a) sb0.g(this.f2239a.remove(str));
        AnalyticsListener.a aVar3 = (AnalyticsListener.a) sb0.g(this.f2242b.remove(str));
        aVar2.n(aVar, z, str.equals(this.f2238a) ? this.f30516a : -9223372036854775807L);
        d dVarA = aVar2.a(true);
        this.f2234a = d.W(this.f2234a, dVarA);
        Callback callback = this.f2233a;
        if (callback != null) {
            callback.a(aVar3, dVarA);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void m0(AnalyticsListener.a aVar, Exception exc) {
        this.f2237a = exc;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void t(AnalyticsListener.a aVar, int i, long j, long j2) {
        this.b = i;
        this.c = j;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void v0(Player player, AnalyticsListener.b bVar) {
        if (bVar.e() == 0) {
            return;
        }
        K0(bVar);
        for (String str : this.f2239a.keySet()) {
            Pair<AnalyticsListener.a, Boolean> pairG0 = G0(bVar, str);
            a aVar = this.f2239a.get(str);
            boolean zJ0 = J0(bVar, str, 11);
            boolean zJ1 = J0(bVar, str, 1018);
            boolean zJ2 = J0(bVar, str, 1011);
            boolean zJ3 = J0(bVar, str, 1000);
            boolean zJ4 = J0(bVar, str, 10);
            boolean z = J0(bVar, str, 1003) || J0(bVar, str, 1024);
            boolean zJ5 = J0(bVar, str, 1006);
            boolean zJ6 = J0(bVar, str, 1004);
            aVar.m(player, (AnalyticsListener.a) pairG0.first, ((Boolean) pairG0.second).booleanValue(), str.equals(this.f2238a) ? this.f30516a : -9223372036854775807L, zJ0, zJ1 ? this.l0 : 0, zJ2, zJ3, zJ4 ? player.f() : null, z ? this.f2237a : null, zJ5 ? this.b : 0L, zJ5 ? this.c : 0L, zJ6 ? this.f2235a : null, zJ6 ? this.f2241b : null, J0(bVar, str, 25) ? this.f2236a : null);
        }
        this.f2235a = null;
        this.f2241b = null;
        this.f2238a = null;
        if (bVar.a(1028)) {
            this.f2232a.a(bVar.d(1028));
        }
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void w0(AnalyticsListener.a aVar, String str, String str2) {
        ((a) sb0.g(this.f2239a.get(str))).p();
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void y0(AnalyticsListener.a aVar, Player.d dVar, Player.d dVar2, int i) {
        if (this.f2238a == null) {
            this.f2238a = this.f2232a.getActiveSessionId();
            this.f30516a = dVar.f2167a;
        }
        this.k0 = i;
    }
}
