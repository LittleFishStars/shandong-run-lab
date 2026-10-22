package com.google.android.exoplayer2.analytics;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.b;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Supplier;
import com.zj.adlib.gj9;
import com.zj.adlib.gk5;
import com.zj.adlib.sb0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements PlaybackSessionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30520a = 12;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.b f2283a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.d f2284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Timeline f2285a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PlaybackSessionManager.Listener f2286a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Supplier<String> f2287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public String f2288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<String, a> f2289a;
    public static final Supplier<String> b = new Supplier() { // from class: com.zj.adlib.qh2
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return b.k();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Random f2282a = new Random();

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30521a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f2290a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public MediaSource.a f2292a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f2293a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f2294a;
        public boolean b;

        public a(String str, @Nullable int i, MediaSource.a aVar) {
            this.f2293a = str;
            this.f30521a = i;
            this.f2290a = aVar == null ? -1L : ((gk5) aVar).f16804a;
            if (aVar == null || !aVar.c()) {
                return;
            }
            this.f2292a = aVar;
        }

        public boolean i(int i, @Nullable MediaSource.a aVar) {
            if (aVar == null) {
                return i == this.f30521a;
            }
            MediaSource.a aVar2 = this.f2292a;
            if (aVar2 == null) {
                return !aVar.c() && ((gk5) aVar).f16804a == this.f2290a;
            }
            return ((gk5) aVar).f16804a == ((gk5) aVar2).f16804a && ((gk5) aVar).f41928a == ((gk5) aVar2).f41928a && aVar.b == aVar2.b;
        }

        public boolean j(AnalyticsListener.a aVar) {
            long j = this.f2290a;
            if (j == -1) {
                return false;
            }
            MediaSource.a aVar2 = aVar.f2226a;
            if (aVar2 == null) {
                return this.f30521a != aVar.f30514a;
            }
            if (((gk5) aVar2).f16804a > j) {
                return true;
            }
            if (this.f2292a == null) {
                return false;
            }
            int iF = aVar.f2225a.f(((gk5) aVar2).f16805a);
            int iF2 = aVar.f2225a.f(((gk5) this.f2292a).f16805a);
            MediaSource.a aVar3 = aVar.f2226a;
            if (((gk5) aVar3).f16804a < ((gk5) this.f2292a).f16804a || iF < iF2) {
                return false;
            }
            if (iF > iF2) {
                return true;
            }
            if (!aVar3.c()) {
                int i = aVar.f2226a.c;
                return i == -1 || i > ((gk5) this.f2292a).f41928a;
            }
            MediaSource.a aVar4 = aVar.f2226a;
            int i2 = ((gk5) aVar4).f41928a;
            int i3 = aVar4.b;
            MediaSource.a aVar5 = this.f2292a;
            int i4 = ((gk5) aVar5).f41928a;
            return i2 > i4 || (i2 == i4 && i3 > aVar5.b);
        }

        public void k(int i, @Nullable MediaSource.a aVar) {
            if (this.f2290a == -1 && i == this.f30521a && aVar != null) {
                this.f2290a = ((gk5) aVar).f16804a;
            }
        }

        public final int l(Timeline timeline, Timeline timeline2, int i) {
            if (i >= timeline.v()) {
                if (i < timeline2.v()) {
                    return i;
                }
                return -1;
            }
            timeline.t(i, b.this.f2284a);
            for (int i2 = b.this.f2284a.K; i2 <= b.this.f2284a.L; i2++) {
                int iF = timeline2.f(timeline.s(i2));
                if (iF != -1) {
                    return timeline2.j(iF, b.this.f2283a).K;
                }
            }
            return -1;
        }

        public boolean m(Timeline timeline, Timeline timeline2) {
            int iL = l(timeline, timeline2, this.f30521a);
            this.f30521a = iL;
            if (iL == -1) {
                return false;
            }
            MediaSource.a aVar = this.f2292a;
            return aVar == null || timeline2.f(((gk5) aVar).f16805a) != -1;
        }
    }

    public b() {
        this(b);
    }

    public static String k() {
        byte[] bArr = new byte[12];
        f2282a.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized void a(AnalyticsListener.a aVar) {
        PlaybackSessionManager.Listener listener;
        this.f2288a = null;
        Iterator<a> it = this.f2289a.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            it.remove();
            if (next.f2294a && (listener = this.f2286a) != null) {
                listener.k0(aVar, next.f2293a, false);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public void b(PlaybackSessionManager.Listener listener) {
        this.f2286a = listener;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00d9  */
    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized void c(AnalyticsListener.a aVar) {
        AnalyticsListener.a aVar2;
        a aVar3;
        sb0.g(this.f2286a);
        if (aVar.f2225a.w()) {
            return;
        }
        a aVar4 = this.f2289a.get(this.f2288a);
        if (aVar.f2226a != null && aVar4 != null) {
            boolean z = false;
            if (aVar4.f2290a != -1 ? ((gk5) aVar.f2226a).f16804a < aVar4.f2290a : aVar4.f30521a != aVar.f30514a) {
                z = true;
            }
            if (z) {
                return;
            }
        }
        a aVarL = l(aVar.f30514a, aVar.f2226a);
        if (this.f2288a == null) {
            this.f2288a = aVarL.f2293a;
        }
        MediaSource.a aVar5 = aVar.f2226a;
        if (aVar5 != null && aVar5.c()) {
            MediaSource.a aVar6 = aVar.f2226a;
            MediaSource.a aVar7 = new MediaSource.a(((gk5) aVar6).f16805a, ((gk5) aVar6).f16804a, ((gk5) aVar6).f41928a);
            a aVarL2 = l(aVar.f30514a, aVar7);
            if (!aVarL2.f2294a) {
                aVarL2.f2294a = true;
                aVar.f2225a.l(((gk5) aVar.f2226a).f16805a, this.f2283a);
                this.f2286a.b(new AnalyticsListener.a(aVar.f2224a, aVar.f2225a, aVar.f30514a, aVar7, Math.max(0L, gj9.H1(this.f2283a.i(((gk5) aVar.f2226a).f41928a)) + this.f2283a.r()), aVar.f2228b, aVar.b, aVar.f2229b, aVar.c, aVar.d), aVarL2.f2293a);
            }
        }
        if (aVarL.f2294a) {
            aVar2 = aVar;
            aVar3 = aVarL;
        } else {
            aVar3 = aVarL;
            aVar3.f2294a = true;
            aVar2 = aVar;
            this.f2286a.b(aVar2, aVar3.f2293a);
        }
        if (aVar3.f2293a.equals(this.f2288a) && !aVar3.b) {
            aVar3.b = true;
            this.f2286a.B(aVar2, aVar3.f2293a);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized void d(AnalyticsListener.a aVar, int i) {
        sb0.g(this.f2286a);
        boolean z = i == 0;
        Iterator<a> it = this.f2289a.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.j(aVar)) {
                it.remove();
                if (next.f2294a) {
                    boolean zEquals = next.f2293a.equals(this.f2288a);
                    boolean z2 = z && zEquals && next.b;
                    if (zEquals) {
                        this.f2288a = null;
                    }
                    this.f2286a.k0(aVar, next.f2293a, z2);
                }
            }
        }
        m(aVar);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized String e(Timeline timeline, MediaSource.a aVar) {
        return l(timeline.l(((gk5) aVar).f16805a, this.f2283a).K, aVar).f2293a;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized void f(AnalyticsListener.a aVar) {
        sb0.g(this.f2286a);
        Timeline timeline = this.f2285a;
        this.f2285a = aVar.f2225a;
        Iterator<a> it = this.f2289a.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.m(timeline, this.f2285a) || next.j(aVar)) {
                it.remove();
                if (next.f2294a) {
                    if (next.f2293a.equals(this.f2288a)) {
                        this.f2288a = null;
                    }
                    this.f2286a.k0(aVar, next.f2293a, false);
                }
            }
        }
        m(aVar);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized boolean g(AnalyticsListener.a aVar, String str) {
        a aVar2 = this.f2289a.get(str);
        if (aVar2 == null) {
            return false;
        }
        aVar2.k(aVar.f30514a, aVar.f2226a);
        return aVar2.i(aVar.f30514a, aVar.f2226a);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    @Nullable
    public synchronized String getActiveSessionId() {
        return this.f2288a;
    }

    public final a l(int i, @Nullable MediaSource.a aVar) {
        a aVar2 = null;
        long j = Long.MAX_VALUE;
        for (a aVar3 : this.f2289a.values()) {
            aVar3.k(i, aVar);
            if (aVar3.i(i, aVar)) {
                long j2 = aVar3.f2290a;
                if (j2 == -1 || j2 < j) {
                    aVar2 = aVar3;
                    j = j2;
                } else if (j2 == j && ((a) gj9.k(aVar2)).f2292a != null && aVar3.f2292a != null) {
                    aVar2 = aVar3;
                }
            }
        }
        if (aVar2 != null) {
            return aVar2;
        }
        String str = this.f2287a.get();
        a aVar4 = new a(str, i, aVar);
        this.f2289a.put(str, aVar4);
        return aVar4;
    }

    @RequiresNonNull({ServiceSpecificExtraArgs.CastExtraArgs.f31291a})
    public final void m(AnalyticsListener.a aVar) {
        if (aVar.f2225a.w()) {
            this.f2288a = null;
            return;
        }
        a aVar2 = this.f2289a.get(this.f2288a);
        a aVarL = l(aVar.f30514a, aVar.f2226a);
        this.f2288a = aVarL.f2293a;
        c(aVar);
        MediaSource.a aVar3 = aVar.f2226a;
        if (aVar3 == null || !aVar3.c()) {
            return;
        }
        if (aVar2 != null && aVar2.f2290a == ((gk5) aVar.f2226a).f16804a && aVar2.f2292a != null && ((gk5) aVar2.f2292a).f41928a == ((gk5) aVar.f2226a).f41928a && aVar2.f2292a.b == aVar.f2226a.b) {
            return;
        }
        MediaSource.a aVar4 = aVar.f2226a;
        this.f2286a.w0(aVar, l(aVar.f30514a, new MediaSource.a(((gk5) aVar4).f16805a, ((gk5) aVar4).f16804a)).f2293a, aVarL.f2293a);
    }

    public b(Supplier<String> supplier) {
        this.f2287a = supplier;
        this.f2284a = new Timeline.d();
        this.f2283a = new Timeline.b();
        this.f2289a = new HashMap<>();
        this.f2285a = Timeline.f2189a;
    }
}
