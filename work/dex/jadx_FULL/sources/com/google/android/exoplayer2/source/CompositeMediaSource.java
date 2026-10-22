package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.UnknownNull;
import com.zj.adlib.az4;
import com.zj.adlib.gj9;
import com.zj.adlib.oh5;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class CompositeMediaSource<T> extends BaseMediaSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Handler f30813a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TransferListener f3642a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<T, b<T>> f3643a = new HashMap<>();

    public final class a implements MediaSourceEventListener, DrmSessionEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DrmSessionEventListener.a f30814a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public MediaSourceEventListener.a f3645a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @UnknownNull
        public final T f3646a;

        public a(T t) {
            this.f3645a = CompositeMediaSource.this.createEventDispatcher(null);
            this.f30814a = CompositeMediaSource.this.createDrmEventDispatcher(null);
            this.f3646a = t;
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void I(int i, @Nullable MediaSource.a aVar) {
            if (b(i, aVar)) {
                this.f30814a.j();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void J(int i, @Nullable MediaSource.a aVar, oh5 oh5Var) {
            if (b(i, aVar)) {
                this.f3645a.j(g(oh5Var));
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void O(int i, @Nullable MediaSource.a aVar) {
            if (b(i, aVar)) {
                this.f30814a.i();
            }
        }

        public final boolean b(int i, @Nullable MediaSource.a aVar) {
            MediaSource.a mediaPeriodIdForChildMediaPeriodId;
            if (aVar != null) {
                mediaPeriodIdForChildMediaPeriodId = CompositeMediaSource.this.getMediaPeriodIdForChildMediaPeriodId(this.f3646a, aVar);
                if (mediaPeriodIdForChildMediaPeriodId == null) {
                    return false;
                }
            } else {
                mediaPeriodIdForChildMediaPeriodId = null;
            }
            int windowIndexForChildWindowIndex = CompositeMediaSource.this.getWindowIndexForChildWindowIndex(this.f3646a, i);
            MediaSourceEventListener.a aVar2 = this.f3645a;
            if (aVar2.f30822a != windowIndexForChildWindowIndex || !gj9.c(aVar2.f3675a, mediaPeriodIdForChildMediaPeriodId)) {
                this.f3645a = CompositeMediaSource.this.createEventDispatcher(windowIndexForChildWindowIndex, mediaPeriodIdForChildMediaPeriodId, 0L);
            }
            DrmSessionEventListener.a aVar3 = this.f30814a;
            if (aVar3.f30595a == windowIndexForChildWindowIndex && gj9.c(aVar3.f2667a, mediaPeriodIdForChildMediaPeriodId)) {
                return true;
            }
            this.f30814a = CompositeMediaSource.this.createDrmEventDispatcher(windowIndexForChildWindowIndex, mediaPeriodIdForChildMediaPeriodId);
            return true;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void e(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var) {
            if (b(i, aVar)) {
                this.f3645a.v(az4Var, g(oh5Var));
            }
        }

        public final oh5 g(oh5 oh5Var) {
            long mediaTimeForChildMediaTime = CompositeMediaSource.this.getMediaTimeForChildMediaTime(this.f3646a, oh5Var.f18631a);
            long mediaTimeForChildMediaTime2 = CompositeMediaSource.this.getMediaTimeForChildMediaTime(this.f3646a, oh5Var.f18634b);
            return (mediaTimeForChildMediaTime == oh5Var.f18631a && mediaTimeForChildMediaTime2 == oh5Var.f18634b) ? oh5Var : new oh5(oh5Var.f43748a, oh5Var.b, oh5Var.f18632a, oh5Var.c, oh5Var.f18633a, mediaTimeForChildMediaTime, mediaTimeForChildMediaTime2);
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void k(int i, @Nullable MediaSource.a aVar) {
            if (b(i, aVar)) {
                this.f30814a.m();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void l(int i, @Nullable MediaSource.a aVar, oh5 oh5Var) {
            if (b(i, aVar)) {
                this.f3645a.E(g(oh5Var));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void m(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var) {
            if (b(i, aVar)) {
                this.f3645a.B(az4Var, g(oh5Var));
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void n(int i, @Nullable MediaSource.a aVar, Exception exc) {
            if (b(i, aVar)) {
                this.f30814a.l(exc);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void o(int i, @Nullable MediaSource.a aVar) {
            if (b(i, aVar)) {
                this.f30814a.h();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void v(int i, @Nullable MediaSource.a aVar, int i2) {
            if (b(i, aVar)) {
                this.f30814a.k(i2);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void w(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var) {
            if (b(i, aVar)) {
                this.f3645a.s(az4Var, g(oh5Var));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void y(int i, @Nullable MediaSource.a aVar, az4 az4Var, oh5 oh5Var, IOException iOException, boolean z) {
            if (b(i, aVar)) {
                this.f3645a.y(az4Var, g(oh5Var), iOException, z);
            }
        }
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CompositeMediaSource<T>.a f30815a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MediaSource.MediaSourceCaller f3647a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MediaSource f3648a;

        public b(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, CompositeMediaSource<T>.a aVar) {
            this.f3648a = mediaSource;
            this.f3647a = mediaSourceCaller;
            this.f30815a = aVar;
        }
    }

    public final void disableChildSource(@UnknownNull T t) {
        b bVar = (b) sb0.g(this.f3643a.get(t));
        bVar.f3648a.B(bVar.f3647a);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @CallSuper
    public void disableInternal() {
        for (b<T> bVar : this.f3643a.values()) {
            bVar.f3648a.B(bVar.f3647a);
        }
    }

    public final void enableChildSource(@UnknownNull T t) {
        b bVar = (b) sb0.g(this.f3643a.get(t));
        bVar.f3648a.H(bVar.f3647a);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @CallSuper
    public void enableInternal() {
        for (b<T> bVar : this.f3643a.values()) {
            bVar.f3648a.H(bVar.f3647a);
        }
    }

    @Nullable
    public MediaSource.a getMediaPeriodIdForChildMediaPeriodId(@UnknownNull T t, MediaSource.a aVar) {
        return aVar;
    }

    public long getMediaTimeForChildMediaTime(@UnknownNull T t, long j) {
        return j;
    }

    public int getWindowIndexForChildWindowIndex(@UnknownNull T t, int i) {
        return i;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    @CallSuper
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Iterator<b<T>> it = this.f3643a.values().iterator();
        while (it.hasNext()) {
            it.next().f3648a.maybeThrowSourceInfoRefreshError();
        }
    }

    /* JADX INFO: renamed from: onChildSourceInfoRefreshed, reason: merged with bridge method [inline-methods] */
    public abstract void Q(@UnknownNull T t, MediaSource mediaSource, Timeline timeline);

    public final void prepareChildSource(@UnknownNull final T t, MediaSource mediaSource) {
        sb0.a(!this.f3643a.containsKey(t));
        MediaSource.MediaSourceCaller mediaSourceCaller = new MediaSource.MediaSourceCaller() { // from class: com.zj.adlib.vr1
            @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
            public final void r(MediaSource mediaSource2, Timeline timeline) {
                this.f45425a.Q(t, mediaSource2, timeline);
            }
        };
        a aVar = new a(t);
        this.f3643a.put(t, new b<>(mediaSource, mediaSourceCaller, aVar));
        mediaSource.C((Handler) sb0.g(this.f30813a), aVar);
        mediaSource.t((Handler) sb0.g(this.f30813a), aVar);
        mediaSource.x(mediaSourceCaller, this.f3642a, getPlayerId());
        if (isEnabled()) {
            return;
        }
        mediaSource.B(mediaSourceCaller);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @CallSuper
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.f3642a = transferListener;
        this.f30813a = gj9.y();
    }

    public final void releaseChildSource(@UnknownNull T t) {
        b bVar = (b) sb0.g(this.f3643a.remove(t));
        bVar.f3648a.L(bVar.f3647a);
        bVar.f3648a.G(bVar.f30815a);
        bVar.f3648a.g(bVar.f30815a);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @CallSuper
    public void releaseSourceInternal() {
        for (b<T> bVar : this.f3643a.values()) {
            bVar.f3648a.L(bVar.f3647a);
            bVar.f3648a.G(bVar.f30815a);
            bVar.f3648a.g(bVar.f30815a);
        }
        this.f3643a.clear();
    }
}
