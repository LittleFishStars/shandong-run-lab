package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.gj9;
import com.zj.adlib.gk5;
import com.zj.adlib.sb0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends CompositeMediaSource<e> {
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 3;
    public static final int O = 4;
    public static final int P = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g f30850a = new com.google.android.exoplayer2.g.c().L(Uri.EMPTY).a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ShuffleOrder f3814a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final IdentityHashMap<MediaPeriod, e> f3815a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public final List<e> f3816a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<Object, e> f3817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public final Set<d> f3818a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3819a;

    @Nullable
    @GuardedBy("this")
    public Handler b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Set<e> f3820b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f3821b;
    public final List<e> c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Set<d> f3822c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3823c;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.b$b, reason: collision with other inner class name */
    public static final class C0687b extends AbstractConcatenatedTimeline {
        public final int O;
        public final int P;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<Object, Integer> f30851a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f3824a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Timeline[] f3825a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Object[] f3826a;
        public final int[] b;

        public C0687b(Collection<e> collection, ShuffleOrder shuffleOrder, boolean z) {
            super(z, shuffleOrder);
            int size = collection.size();
            this.f3824a = new int[size];
            this.b = new int[size];
            this.f3825a = new Timeline[size];
            this.f3826a = new Object[size];
            this.f30851a = new HashMap<>();
            int iV = 0;
            int iM = 0;
            int i = 0;
            for (e eVar : collection) {
                this.f3825a[i] = eVar.f3828a.U();
                this.b[i] = iV;
                this.f3824a[i] = iM;
                iV += this.f3825a[i].v();
                iM += this.f3825a[i].m();
                Object[] objArr = this.f3826a;
                Object obj = eVar.f3829a;
                objArr[i] = obj;
                this.f30851a.put(obj, Integer.valueOf(i));
                i++;
            }
            this.O = iV;
            this.P = iM;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByChildUid(Object obj) {
            Integer num = this.f30851a.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByPeriodIndex(int i) {
            return gj9.i(this.f3824a, i + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByWindowIndex(int i) {
            return gj9.i(this.b, i + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public Object getChildUidByChildIndex(int i) {
            return this.f3826a[i];
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getFirstPeriodIndexByChildIndex(int i) {
            return this.f3824a[i];
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getFirstWindowIndexByChildIndex(int i) {
            return this.b[i];
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public Timeline getTimelineByChildIndex(int i) {
            return this.f3825a[i];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int m() {
            return this.P;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int v() {
            return this.O;
        }
    }

    public static final class c extends BaseMediaSource {
        public c() {
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public MediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public com.google.android.exoplayer2.g b() {
            return b.f30850a;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public void j(MediaPeriod mediaPeriod) {
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public void maybeThrowSourceInfoRefreshError() {
        }

        @Override // com.google.android.exoplayer2.source.BaseMediaSource
        public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        }

        @Override // com.google.android.exoplayer2.source.BaseMediaSource
        public void releaseSourceInternal() {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f30852a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Runnable f3827a;

        public d(Handler handler, Runnable runnable) {
            this.f30852a = handler;
            this.f3827a = runnable;
        }

        public void a() {
            this.f30852a.post(this.f3827a);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30853a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final com.google.android.exoplayer2.source.d f3828a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f3831a;
        public int b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<MediaSource.a> f3830a = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Object f3829a = new Object();

        public e(MediaSource mediaSource, boolean z) {
            this.f3828a = new com.google.android.exoplayer2.source.d(mediaSource, z);
        }

        public void a(int i, int i2) {
            this.f30853a = i;
            this.b = i2;
            this.f3831a = false;
            this.f3830a.clear();
        }
    }

    public static final class f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30854a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final d f3832a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final T f3833a;

        public f(int i, T t, @Nullable d dVar) {
            this.f30854a = i;
            this.f3833a = t;
            this.f3832a = dVar;
        }
    }

    public b(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    public static Object l0(Object obj) {
        return AbstractConcatenatedTimeline.A(obj);
    }

    public static Object n0(Object obj) {
        return AbstractConcatenatedTimeline.B(obj);
    }

    public static Object o0(e eVar, Object obj) {
        return AbstractConcatenatedTimeline.C(eVar.f3829a, obj);
    }

    public synchronized void A0(int i, int i2) {
        C0(i, i2, null, null);
    }

    public synchronized void B0(int i, int i2, Handler handler, Runnable runnable) {
        C0(i, i2, handler, runnable);
    }

    @GuardedBy("this")
    public final void C0(int i, int i2, @Nullable Handler handler, @Nullable Runnable runnable) {
        sb0.a((handler == null) == (runnable == null));
        Handler handler2 = this.b;
        gj9.m1(this.f3816a, i, i2);
        if (handler2 != null) {
            handler2.obtainMessage(1, new f(i, Integer.valueOf(i2), h0(handler, runnable))).sendToTarget();
        } else {
            if (runnable == null || handler == null) {
                return;
            }
            handler.post(runnable);
        }
    }

    public final void D0() {
        E0(null);
    }

    public final void E0(@Nullable d dVar) {
        if (!this.f3823c) {
            p0().obtainMessage(4).sendToTarget();
            this.f3823c = true;
        }
        if (dVar != null) {
            this.f3822c.add(dVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
        Object objN0 = n0(((gk5) aVar).f16805a);
        MediaSource.a aVarA = aVar.a(l0(((gk5) aVar).f16805a));
        e eVar = this.f3817a.get(objN0);
        if (eVar == null) {
            eVar = new e(new c(), this.f3821b);
            eVar.f3831a = true;
            prepareChildSource(eVar, eVar.f3828a);
        }
        k0(eVar);
        eVar.f3830a.add(aVarA);
        MaskingMediaPeriod maskingMediaPeriodF = eVar.f3828a.F(aVarA, allocator, j);
        this.f3815a.put(maskingMediaPeriodF, eVar);
        i0();
        return maskingMediaPeriodF;
    }

    @GuardedBy("this")
    public final void F0(ShuffleOrder shuffleOrder, @Nullable Handler handler, @Nullable Runnable runnable) {
        sb0.a((handler == null) == (runnable == null));
        Handler handler2 = this.b;
        if (handler2 != null) {
            int iQ0 = q0();
            if (shuffleOrder.getLength() != iQ0) {
                shuffleOrder = shuffleOrder.c().b(0, iQ0);
            }
            handler2.obtainMessage(3, new f(0, shuffleOrder, h0(handler, runnable))).sendToTarget();
            return;
        }
        if (shuffleOrder.getLength() > 0) {
            shuffleOrder = shuffleOrder.c();
        }
        this.f3814a = shuffleOrder;
        if (runnable == null || handler == null) {
            return;
        }
        handler.post(runnable);
    }

    public synchronized void G0(ShuffleOrder shuffleOrder) {
        F0(shuffleOrder, null, null);
    }

    public synchronized void H0(ShuffleOrder shuffleOrder, Handler handler, Runnable runnable) {
        F0(shuffleOrder, handler, runnable);
    }

    public final void I0(e eVar, Timeline timeline) {
        if (eVar.f30853a + 1 < this.c.size()) {
            int iV = timeline.v() - (this.c.get(eVar.f30853a + 1).b - eVar.b);
            if (iV != 0) {
                g0(eVar.f30853a + 1, 0, iV);
            }
        }
        D0();
    }

    public final void J0() {
        this.f3823c = false;
        Set<d> set = this.f3822c;
        this.f3822c = new HashSet();
        refreshSourceInfo(new C0687b(this.c, this.f3814a, this.f3819a));
        p0().obtainMessage(5, set).sendToTarget();
    }

    public synchronized void T(int i, MediaSource mediaSource) {
        d0(i, Collections.singletonList(mediaSource), null, null);
    }

    public synchronized void U(int i, MediaSource mediaSource, Handler handler, Runnable runnable) {
        d0(i, Collections.singletonList(mediaSource), handler, runnable);
    }

    public synchronized void V(MediaSource mediaSource) {
        T(this.f3816a.size(), mediaSource);
    }

    public synchronized void W(MediaSource mediaSource, Handler handler, Runnable runnable) {
        U(this.f3816a.size(), mediaSource, handler, runnable);
    }

    public final void X(int i, e eVar) {
        if (i > 0) {
            e eVar2 = this.c.get(i - 1);
            eVar.a(i, eVar2.b + eVar2.f3828a.U().v());
        } else {
            eVar.a(i, 0);
        }
        g0(i, 1, eVar.f3828a.U().v());
        this.c.add(i, eVar);
        this.f3817a.put(eVar.f3829a, eVar);
        prepareChildSource(eVar, eVar.f3828a);
        if (isEnabled() && this.f3815a.isEmpty()) {
            this.f3820b.add(eVar);
        } else {
            disableChildSource(eVar);
        }
    }

    public synchronized void Y(int i, Collection<MediaSource> collection) {
        d0(i, collection, null, null);
    }

    public synchronized void Z(int i, Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        d0(i, collection, handler, runnable);
    }

    public synchronized void a0(Collection<MediaSource> collection) {
        d0(this.f3816a.size(), collection, null, null);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.g b() {
        return f30850a;
    }

    public synchronized void b0(Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        d0(this.f3816a.size(), collection, handler, runnable);
    }

    public final void c0(int i, Collection<e> collection) {
        Iterator<e> it = collection.iterator();
        while (it.hasNext()) {
            X(i, it.next());
            i++;
        }
    }

    @GuardedBy("this")
    public final void d0(int i, Collection<MediaSource> collection, @Nullable Handler handler, @Nullable Runnable runnable) {
        sb0.a((handler == null) == (runnable == null));
        Handler handler2 = this.b;
        Iterator<MediaSource> it = collection.iterator();
        while (it.hasNext()) {
            sb0.g(it.next());
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<MediaSource> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(new e(it2.next(), this.f3821b));
        }
        this.f3816a.addAll(i, arrayList);
        if (handler2 != null && !collection.isEmpty()) {
            handler2.obtainMessage(0, new f(i, arrayList, h0(handler, runnable))).sendToTarget();
        } else {
            if (runnable == null || handler == null) {
                return;
            }
            handler.post(runnable);
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void disableInternal() {
        super.disableInternal();
        this.f3820b.clear();
    }

    public synchronized void e0() {
        A0(0, q0());
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void enableInternal() {
    }

    public synchronized void f0(Handler handler, Runnable runnable) {
        B0(0, q0(), handler, runnable);
    }

    public final void g0(int i, int i2, int i3) {
        while (i < this.c.size()) {
            e eVar = this.c.get(i);
            eVar.f30853a += i2;
            eVar.b += i3;
            i++;
        }
    }

    @Nullable
    @GuardedBy("this")
    public final d h0(@Nullable Handler handler, @Nullable Runnable runnable) {
        if (handler == null || runnable == null) {
            return null;
        }
        d dVar = new d(handler, runnable);
        this.f3818a.add(dVar);
        return dVar;
    }

    public final void i0() {
        Iterator<e> it = this.f3820b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f3830a.isEmpty()) {
                disableChildSource(next);
                it.remove();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public boolean isSingleWindow() {
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void j(MediaPeriod mediaPeriod) {
        e eVar = (e) sb0.g(this.f3815a.remove(mediaPeriod));
        eVar.f3828a.j(mediaPeriod);
        eVar.f3830a.remove(((MaskingMediaPeriod) mediaPeriod).f3670a);
        if (!this.f3815a.isEmpty()) {
            i0();
        }
        s0(eVar);
    }

    public final synchronized void j0(Set<d> set) {
        Iterator<d> it = set.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f3818a.removeAll(set);
    }

    public final void k0(e eVar) {
        this.f3820b.add(eVar);
        enableChildSource(eVar);
    }

    public synchronized MediaSource m0(int i) {
        return this.f3816a.get(i).f3828a;
    }

    public final Handler p0() {
        return (Handler) sb0.g(this.b);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public synchronized void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        this.b = new Handler(new Handler.Callback() { // from class: com.zj.adlib.is1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f42433a.r0(message);
            }
        });
        if (this.f3816a.isEmpty()) {
            J0();
        } else {
            this.f3814a = this.f3814a.b(0, this.f3816a.size());
            c0(0, this.f3816a);
            D0();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public synchronized Timeline q() {
        return new C0687b(this.f3816a, this.f3814a.getLength() != this.f3816a.size() ? this.f3814a.c().b(0, this.f3816a.size()) : this.f3814a, this.f3819a);
    }

    public synchronized int q0() {
        return this.f3816a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean r0(Message message) {
        int i = message.what;
        if (i == 0) {
            f fVar = (f) gj9.k(message.obj);
            this.f3814a = this.f3814a.b(fVar.f30854a, ((Collection) fVar.f3833a).size());
            c0(fVar.f30854a, (Collection) fVar.f3833a);
            E0(fVar.f3832a);
        } else if (i == 1) {
            f fVar2 = (f) gj9.k(message.obj);
            int i2 = fVar2.f30854a;
            int iIntValue = ((Integer) fVar2.f3833a).intValue();
            if (i2 == 0 && iIntValue == this.f3814a.getLength()) {
                this.f3814a = this.f3814a.c();
            } else {
                this.f3814a = this.f3814a.a(i2, iIntValue);
            }
            for (int i3 = iIntValue - 1; i3 >= i2; i3--) {
                z0(i3);
            }
            E0(fVar2.f3832a);
        } else if (i == 2) {
            f fVar3 = (f) gj9.k(message.obj);
            ShuffleOrder shuffleOrder = this.f3814a;
            int i4 = fVar3.f30854a;
            ShuffleOrder shuffleOrderA = shuffleOrder.a(i4, i4 + 1);
            this.f3814a = shuffleOrderA;
            this.f3814a = shuffleOrderA.b(((Integer) fVar3.f3833a).intValue(), 1);
            v0(fVar3.f30854a, ((Integer) fVar3.f3833a).intValue());
            E0(fVar3.f3832a);
        } else if (i == 3) {
            f fVar4 = (f) gj9.k(message.obj);
            this.f3814a = (ShuffleOrder) fVar4.f3833a;
            E0(fVar4.f3832a);
        } else if (i == 4) {
            J0();
        } else {
            if (i != 5) {
                throw new IllegalStateException();
            }
            j0((Set) gj9.k(message.obj));
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public synchronized void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.c.clear();
        this.f3820b.clear();
        this.f3817a.clear();
        this.f3814a = this.f3814a.c();
        Handler handler = this.b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.b = null;
        }
        this.f3823c = false;
        this.f3822c.clear();
        j0(this.f3818a);
    }

    public final void s0(e eVar) {
        if (eVar.f3831a && eVar.f3830a.isEmpty()) {
            this.f3820b.remove(eVar);
            releaseChildSource(eVar);
        }
    }

    public synchronized void t0(int i, int i2) {
        w0(i, i2, null, null);
    }

    public synchronized void u0(int i, int i2, Handler handler, Runnable runnable) {
        w0(i, i2, handler, runnable);
    }

    public final void v0(int i, int i2) {
        int iMin = Math.min(i, i2);
        int iMax = Math.max(i, i2);
        int iV = this.c.get(iMin).b;
        List<e> list = this.c;
        list.add(i2, list.remove(i));
        while (iMin <= iMax) {
            e eVar = this.c.get(iMin);
            eVar.f30853a = iMin;
            eVar.b = iV;
            iV += eVar.f3828a.U().v();
            iMin++;
        }
    }

    @GuardedBy("this")
    public final void w0(int i, int i2, @Nullable Handler handler, @Nullable Runnable runnable) {
        sb0.a((handler == null) == (runnable == null));
        Handler handler2 = this.b;
        List<e> list = this.f3816a;
        list.add(i2, list.remove(i));
        if (handler2 != null) {
            handler2.obtainMessage(2, new f(i, Integer.valueOf(i2), h0(handler, runnable))).sendToTarget();
        } else {
            if (runnable == null || handler == null) {
                return;
            }
            handler.post(runnable);
        }
    }

    public synchronized MediaSource x0(int i) {
        MediaSource mediaSourceM0;
        mediaSourceM0 = m0(i);
        C0(i, i + 1, null, null);
        return mediaSourceM0;
    }

    public synchronized MediaSource y0(int i, Handler handler, Runnable runnable) {
        MediaSource mediaSourceM0;
        mediaSourceM0 = m0(i);
        C0(i, i + 1, handler, runnable);
        return mediaSourceM0;
    }

    public final void z0(int i) {
        e eVarRemove = this.c.remove(i);
        this.f3817a.remove(eVarRemove.f3829a);
        g0(i, -1, -eVarRemove.f3828a.U().v());
        eVarRemove.f3831a = true;
        s0(eVarRemove);
    }

    public b(boolean z, MediaSource... mediaSourceArr) {
        this(z, new ShuffleOrder.a(0), mediaSourceArr);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    @Nullable
    public MediaSource.a getMediaPeriodIdForChildMediaPeriodId(e eVar, MediaSource.a aVar) {
        for (int i = 0; i < eVar.f3830a.size(); i++) {
            if (((gk5) eVar.f3830a.get(i)).f16804a == ((gk5) aVar).f16804a) {
                return aVar.a(o0(eVar, ((gk5) aVar).f16805a));
            }
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public int getWindowIndexForChildWindowIndex(e eVar, int i) {
        return i + eVar.b;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* JADX INFO: renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void Q(e eVar, MediaSource mediaSource, Timeline timeline) {
        I0(eVar, timeline);
    }

    public b(boolean z, ShuffleOrder shuffleOrder, MediaSource... mediaSourceArr) {
        this(z, false, shuffleOrder, mediaSourceArr);
    }

    public b(boolean z, boolean z2, ShuffleOrder shuffleOrder, MediaSource... mediaSourceArr) {
        for (MediaSource mediaSource : mediaSourceArr) {
            sb0.g(mediaSource);
        }
        this.f3814a = shuffleOrder.getLength() > 0 ? shuffleOrder.c() : shuffleOrder;
        this.f3815a = new IdentityHashMap<>();
        this.f3817a = new HashMap();
        this.f3816a = new ArrayList();
        this.c = new ArrayList();
        this.f3822c = new HashSet();
        this.f3818a = new HashSet();
        this.f3820b = new HashSet();
        this.f3819a = z;
        this.f3821b = z2;
        a0(Arrays.asList(mediaSourceArr));
    }
}
