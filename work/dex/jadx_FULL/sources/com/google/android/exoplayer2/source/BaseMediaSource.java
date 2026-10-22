package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.at6;
import com.zj.adlib.sb0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseMediaSource implements MediaSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Looper f30810a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Timeline f3627a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public at6 f3630a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<MediaSource.MediaSourceCaller> f3631a = new ArrayList<>(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashSet<MediaSource.MediaSourceCaller> f3632a = new HashSet<>(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSourceEventListener.a f3629a = new MediaSourceEventListener.a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionEventListener.a f3628a = new DrmSessionEventListener.a();

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void B(MediaSource.MediaSourceCaller mediaSourceCaller) {
        boolean z = !this.f3632a.isEmpty();
        this.f3632a.remove(mediaSourceCaller);
        if (z && this.f3632a.isEmpty()) {
            disableInternal();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void C(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        sb0.g(handler);
        sb0.g(mediaSourceEventListener);
        this.f3629a.g(handler, mediaSourceEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void G(MediaSourceEventListener mediaSourceEventListener) {
        this.f3629a.C(mediaSourceEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void H(MediaSource.MediaSourceCaller mediaSourceCaller) {
        sb0.g(this.f30810a);
        boolean zIsEmpty = this.f3632a.isEmpty();
        this.f3632a.add(mediaSourceCaller);
        if (zIsEmpty) {
            enableInternal();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void L(MediaSource.MediaSourceCaller mediaSourceCaller) {
        this.f3631a.remove(mediaSourceCaller);
        if (!this.f3631a.isEmpty()) {
            B(mediaSourceCaller);
            return;
        }
        this.f30810a = null;
        this.f3627a = null;
        this.f3630a = null;
        this.f3632a.clear();
        releaseSourceInternal();
    }

    public final DrmSessionEventListener.a createDrmEventDispatcher(@Nullable MediaSource.a aVar) {
        return this.f3628a.u(0, aVar);
    }

    public final MediaSourceEventListener.a createEventDispatcher(@Nullable MediaSource.a aVar) {
        return this.f3629a.F(0, aVar, 0L);
    }

    public void disableInternal() {
    }

    public void enableInternal() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void g(DrmSessionEventListener drmSessionEventListener) {
        this.f3628a.t(drmSessionEventListener);
    }

    public final at6 getPlayerId() {
        return (at6) sb0.k(this.f3630a);
    }

    public final boolean isEnabled() {
        return !this.f3632a.isEmpty();
    }

    public abstract void prepareSourceInternal(@Nullable TransferListener transferListener);

    public final void refreshSourceInfo(Timeline timeline) {
        this.f3627a = timeline;
        Iterator<MediaSource.MediaSourceCaller> it = this.f3631a.iterator();
        while (it.hasNext()) {
            it.next().r(this, timeline);
        }
    }

    public abstract void releaseSourceInternal();

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void t(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        sb0.g(handler);
        sb0.g(drmSessionEventListener);
        this.f3628a.g(handler, drmSessionEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void x(MediaSource.MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener, at6 at6Var) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f30810a;
        sb0.a(looper == null || looper == looperMyLooper);
        this.f3630a = at6Var;
        Timeline timeline = this.f3627a;
        this.f3631a.add(mediaSourceCaller);
        if (this.f30810a == null) {
            this.f30810a = looperMyLooper;
            this.f3632a.add(mediaSourceCaller);
            prepareSourceInternal(transferListener);
        } else if (timeline != null) {
            H(mediaSourceCaller);
            mediaSourceCaller.r(this, timeline);
        }
    }

    public final DrmSessionEventListener.a createDrmEventDispatcher(int i, @Nullable MediaSource.a aVar) {
        return this.f3628a.u(i, aVar);
    }

    public final MediaSourceEventListener.a createEventDispatcher(MediaSource.a aVar, long j) {
        sb0.g(aVar);
        return this.f3629a.F(0, aVar, j);
    }

    public final MediaSourceEventListener.a createEventDispatcher(int i, @Nullable MediaSource.a aVar, long j) {
        return this.f3629a.F(i, aVar, j);
    }
}
