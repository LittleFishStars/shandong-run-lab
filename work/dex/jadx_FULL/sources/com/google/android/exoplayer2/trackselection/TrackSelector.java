package com.google.android.exoplayer2.trackselection;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.zj.adlib.ga9;
import com.zj.adlib.sb0;
import com.zj.adlib.wa9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class TrackSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public InvalidationListener f31043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public BandwidthMeter f4683a;

    public interface InvalidationListener {
        void onTrackSelectionsInvalidated();
    }

    public c a() {
        return c.f4697a;
    }

    @CallSuper
    public void b(InvalidationListener invalidationListener, BandwidthMeter bandwidthMeter) {
        this.f31043a = invalidationListener;
        this.f4683a = bandwidthMeter;
    }

    public boolean c() {
        return false;
    }

    public abstract void d(@Nullable Object obj);

    @CallSuper
    public void e() {
        this.f31043a = null;
        this.f4683a = null;
    }

    public abstract wa9 f(RendererCapabilities[] rendererCapabilitiesArr, ga9 ga9Var, MediaSource.a aVar, Timeline timeline) throws ExoPlaybackException;

    public void g(com.google.android.exoplayer2.audio.a aVar) {
    }

    public final BandwidthMeter getBandwidthMeter() {
        return (BandwidthMeter) sb0.k(this.f4683a);
    }

    public void h(c cVar) {
    }

    public final void invalidate() {
        InvalidationListener invalidationListener = this.f31043a;
        if (invalidationListener != null) {
            invalidationListener.onTrackSelectionsInvalidated();
        }
    }
}
