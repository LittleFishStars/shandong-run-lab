package com.google.android.exoplayer2;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.at6;
import com.zj.adlib.az4;
import com.zj.adlib.gj9;
import com.zj.adlib.gk5;
import com.zj.adlib.oh5;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class MediaSourceList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30493a = "MediaSourceList";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSourceListInfoRefreshListener f2141a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionEventListener.a f2142a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSourceEventListener.a f2143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TransferListener f2145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final at6 f2146a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<c, b> f2147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set<c> f2151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ShuffleOrder f2144a = new ShuffleOrder.a(0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final IdentityHashMap<MediaPeriod, c> f2148a = new IdentityHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<Object, c> f2150a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<c> f2149a = new ArrayList();

    public interface MediaSourceListInfoRefreshListener {
        void onPlaylistUpdateRequested();
    }

    public final class a implements MediaSourceEventListener, DrmSessionEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f30494a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public DrmSessionEventListener.a f2154a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public MediaSourceEventListener.a f2155a;

        public a(c cVar) {
            this.f2155a = MediaSourceList.this.f2143a;
            this.f2154a = MediaSourceList.this.f2142a;
            this.f30494a = cVar;
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void I(int i, @Nullable MediaSource.a aVar) {
            if (b(i, aVar)) {
                this.f2154a.j();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void J(int i, @Nullable MediaSource.a aVar, oh5 oh5Var) {
            if (b(i, aVar)) {
                this.f2155a.j(oh5Var);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void O(int i, @Nullable MediaSource.a aVar) {
            if (b(i, aVar)) {
                this.f2154a.i();
            }
        }

        public final boolean b(int i, @Nullable MediaSource.a aVar) {
            MediaSource.a aVarO;
            if (aVar != null) {
                aVarO = MediaSourceList.o(this.f30494a, aVar);
                if (aVarO == null) {
                    return false;
                }
            } else {
                aVarO = null;
            }
            int iS = MediaSourceList.s(this.f30494a, i);
            MediaSourceEventListener.a aVar2 = this.f2155a;
            if (aVar2.f30822a != iS || !gj9.c(aVar2.f3675a, aVarO)) {
                this.f2155a = MediaSourceList.this.f2143a.F(iS, aVarO, 0L);
            }
            DrmSessionEventListener.a aVar3 = this.f2154a;
            if (aVar3.f30595a == iS && gj9.c(aVar3.f2667a, aVarO)) {
                return true;
            }
            this.f2154a = MediaSourceList.this.f2142a.u(iS, aVarO);
            return true;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void e(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var) {
            if (b(i, aVar)) {
                this.f2155a.v(az4Var, oh5Var);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void k(int i, @Nullable MediaSource.a aVar) {
            if (b(i, aVar)) {
                this.f2154a.m();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void l(int i, @Nullable MediaSource.a aVar, oh5 oh5Var) {
            if (b(i, aVar)) {
                this.f2155a.E(oh5Var);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void m(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var) {
            if (b(i, aVar)) {
                this.f2155a.B(az4Var, oh5Var);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void n(int i, @Nullable MediaSource.a aVar, Exception exc) {
            if (b(i, aVar)) {
                this.f2154a.l(exc);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void o(int i, @Nullable MediaSource.a aVar) {
            if (b(i, aVar)) {
                this.f2154a.h();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void v(int i, @Nullable MediaSource.a aVar, int i2) {
            if (b(i, aVar)) {
                this.f2154a.k(i2);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void w(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var) {
            if (b(i, aVar)) {
                this.f2155a.s(az4Var, oh5Var);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void y(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var, IOException iOException, boolean z) {
            if (b(i, aVar)) {
                this.f2155a.y(az4Var, oh5Var, iOException, z);
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f30495a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MediaSource.MediaSourceCaller f2156a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MediaSource f2157a;

        public b(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, a aVar) {
            this.f2157a = mediaSource;
            this.f2156a = mediaSourceCaller;
            this.f30495a = aVar;
        }
    }

    public static final class c implements MediaSourceInfoHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30496a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final com.google.android.exoplayer2.source.d f2158a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f2161a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<MediaSource.a> f2160a = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Object f2159a = new Object();

        public c(MediaSource mediaSource, boolean z) {
            this.f2158a = new com.google.android.exoplayer2.source.d(mediaSource, z);
        }

        @Override // com.google.android.exoplayer2.MediaSourceInfoHolder
        public Timeline a() {
            return this.f2158a.U();
        }

        public void b(int i) {
            this.f30496a = i;
            this.f2161a = false;
            this.f2160a.clear();
        }

        @Override // com.google.android.exoplayer2.MediaSourceInfoHolder
        public Object getUid() {
            return this.f2159a;
        }
    }

    public MediaSourceList(MediaSourceListInfoRefreshListener mediaSourceListInfoRefreshListener, AnalyticsCollector analyticsCollector, Handler handler, at6 at6Var) {
        this.f2146a = at6Var;
        this.f2141a = mediaSourceListInfoRefreshListener;
        MediaSourceEventListener.a aVar = new MediaSourceEventListener.a();
        this.f2143a = aVar;
        DrmSessionEventListener.a aVar2 = new DrmSessionEventListener.a();
        this.f2142a = aVar2;
        this.f2147a = new HashMap<>();
        this.f2151a = new HashSet();
        aVar.g(handler, analyticsCollector);
        aVar2.g(handler, analyticsCollector);
    }

    public static Object n(Object obj) {
        return AbstractConcatenatedTimeline.A(obj);
    }

    @Nullable
    public static MediaSource.a o(c cVar, MediaSource.a aVar) {
        for (int i = 0; i < cVar.f2160a.size(); i++) {
            if (((gk5) cVar.f2160a.get(i)).f16804a == ((gk5) aVar).f16804a) {
                return aVar.a(q(cVar, ((gk5) aVar).f16805a));
            }
        }
        return null;
    }

    public static Object p(Object obj) {
        return AbstractConcatenatedTimeline.B(obj);
    }

    public static Object q(c cVar, Object obj) {
        return AbstractConcatenatedTimeline.C(cVar.f2159a, obj);
    }

    public static int s(c cVar, int i) {
        return i + cVar.f30496a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(MediaSource mediaSource, Timeline timeline) {
        this.f2141a.onPlaylistUpdateRequested();
    }

    public void A() {
        for (b bVar : this.f2147a.values()) {
            try {
                bVar.f2157a.L(bVar.f2156a);
            } catch (RuntimeException e) {
                Log.e(f30493a, "Failed to release child source.", e);
            }
            bVar.f2157a.G(bVar.f30495a);
            bVar.f2157a.g(bVar.f30495a);
        }
        this.f2147a.clear();
        this.f2151a.clear();
        this.f2152a = false;
    }

    public void B(MediaPeriod mediaPeriod) {
        c cVar = (c) sb0.g(this.f2148a.remove(mediaPeriod));
        cVar.f2158a.j(mediaPeriod);
        cVar.f2160a.remove(((MaskingMediaPeriod) mediaPeriod).f3670a);
        if (!this.f2148a.isEmpty()) {
            l();
        }
        v(cVar);
    }

    public Timeline C(int i, int i2, ShuffleOrder shuffleOrder) {
        sb0.a(i >= 0 && i <= i2 && i2 <= r());
        this.f2144a = shuffleOrder;
        D(i, i2);
        return j();
    }

    public final void D(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            c cVarRemove = this.f2149a.remove(i3);
            this.f2150a.remove(cVarRemove.f2159a);
            h(i3, -cVarRemove.f2158a.U().v());
            cVarRemove.f2161a = true;
            if (this.f2152a) {
                v(cVarRemove);
            }
        }
    }

    public Timeline E(List<c> list, ShuffleOrder shuffleOrder) {
        D(0, this.f2149a.size());
        return f(this.f2149a.size(), list, shuffleOrder);
    }

    public Timeline F(ShuffleOrder shuffleOrder) {
        int iR = r();
        if (shuffleOrder.getLength() != iR) {
            shuffleOrder = shuffleOrder.c().b(0, iR);
        }
        this.f2144a = shuffleOrder;
        return j();
    }

    public Timeline f(int i, List<c> list, ShuffleOrder shuffleOrder) {
        if (!list.isEmpty()) {
            this.f2144a = shuffleOrder;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                c cVar = list.get(i2 - i);
                if (i2 > 0) {
                    c cVar2 = this.f2149a.get(i2 - 1);
                    cVar.b(cVar2.f30496a + cVar2.f2158a.U().v());
                } else {
                    cVar.b(0);
                }
                h(i2, cVar.f2158a.U().v());
                this.f2149a.add(i2, cVar);
                this.f2150a.put(cVar.f2159a, cVar);
                if (this.f2152a) {
                    z(cVar);
                    if (this.f2148a.isEmpty()) {
                        this.f2151a.add(cVar);
                    } else {
                        k(cVar);
                    }
                }
            }
        }
        return j();
    }

    public Timeline g(@Nullable ShuffleOrder shuffleOrder) {
        if (shuffleOrder == null) {
            shuffleOrder = this.f2144a.c();
        }
        this.f2144a = shuffleOrder;
        D(0, r());
        return j();
    }

    public final void h(int i, int i2) {
        while (i < this.f2149a.size()) {
            this.f2149a.get(i).f30496a += i2;
            i++;
        }
    }

    public MediaPeriod i(MediaSource.a aVar, Allocator allocator, long j) {
        Object objP = p(((gk5) aVar).f16805a);
        MediaSource.a aVarA = aVar.a(n(((gk5) aVar).f16805a));
        c cVar = (c) sb0.g(this.f2150a.get(objP));
        m(cVar);
        cVar.f2160a.add(aVarA);
        MaskingMediaPeriod maskingMediaPeriodF = cVar.f2158a.F(aVarA, allocator, j);
        this.f2148a.put(maskingMediaPeriodF, cVar);
        l();
        return maskingMediaPeriodF;
    }

    public Timeline j() {
        if (this.f2149a.isEmpty()) {
            return Timeline.f2189a;
        }
        int iV = 0;
        for (int i = 0; i < this.f2149a.size(); i++) {
            c cVar = this.f2149a.get(i);
            cVar.f30496a = iV;
            iV += cVar.f2158a.U().v();
        }
        return new k(this.f2149a, this.f2144a);
    }

    public final void k(c cVar) {
        b bVar = this.f2147a.get(cVar);
        if (bVar != null) {
            bVar.f2157a.B(bVar.f2156a);
        }
    }

    public final void l() {
        Iterator<c> it = this.f2151a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f2160a.isEmpty()) {
                k(next);
                it.remove();
            }
        }
    }

    public final void m(c cVar) {
        this.f2151a.add(cVar);
        b bVar = this.f2147a.get(cVar);
        if (bVar != null) {
            bVar.f2157a.H(bVar.f2156a);
        }
    }

    public int r() {
        return this.f2149a.size();
    }

    public boolean t() {
        return this.f2152a;
    }

    public final void v(c cVar) {
        if (cVar.f2161a && cVar.f2160a.isEmpty()) {
            b bVar = (b) sb0.g(this.f2147a.remove(cVar));
            bVar.f2157a.L(bVar.f2156a);
            bVar.f2157a.G(bVar.f30495a);
            bVar.f2157a.g(bVar.f30495a);
            this.f2151a.remove(cVar);
        }
    }

    public Timeline w(int i, int i2, ShuffleOrder shuffleOrder) {
        return x(i, i + 1, i2, shuffleOrder);
    }

    public Timeline x(int i, int i2, int i3, ShuffleOrder shuffleOrder) {
        sb0.a(i >= 0 && i <= i2 && i2 <= r() && i3 >= 0);
        this.f2144a = shuffleOrder;
        if (i == i2 || i == i3) {
            return j();
        }
        int iMin = Math.min(i, i3);
        int iMax = Math.max(((i2 - i) + i3) - 1, i2 - 1);
        int iV = this.f2149a.get(iMin).f30496a;
        gj9.Y0(this.f2149a, i, i2, i3);
        while (iMin <= iMax) {
            c cVar = this.f2149a.get(iMin);
            cVar.f30496a = iV;
            iV += cVar.f2158a.U().v();
            iMin++;
        }
        return j();
    }

    public void y(@Nullable TransferListener transferListener) {
        sb0.i(!this.f2152a);
        this.f2145a = transferListener;
        for (int i = 0; i < this.f2149a.size(); i++) {
            c cVar = this.f2149a.get(i);
            z(cVar);
            this.f2151a.add(cVar);
        }
        this.f2152a = true;
    }

    public final void z(c cVar) {
        com.google.android.exoplayer2.source.d dVar = cVar.f2158a;
        MediaSource.MediaSourceCaller mediaSourceCaller = new MediaSource.MediaSourceCaller() { // from class: com.zj.adlib.ql5
            @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
            public final void r(MediaSource mediaSource, Timeline timeline) {
                this.f44239a.u(mediaSource, timeline);
            }
        };
        a aVar = new a(cVar);
        this.f2147a.put(cVar, new b(dVar, mediaSourceCaller, aVar));
        dVar.C(gj9.A(), aVar);
        dVar.t(gj9.A(), aVar);
        dVar.x(mediaSourceCaller, this.f2145a, this.f2146a);
    }
}
