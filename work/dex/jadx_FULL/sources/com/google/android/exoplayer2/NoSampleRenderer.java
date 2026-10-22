package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.MediaClock;
import com.zj.adlib.at6;
import com.zj.adlib.sb0;
import com.zj.adlib.ue7;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class NoSampleRenderer implements Renderer, RendererCapabilities {
    public int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public SampleStream f30497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ue7 f2162a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2163a;

    @Override // com.google.android.exoplayer2.Renderer
    public final RendererCapabilities a() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Renderer
    @Nullable
    public MediaClock d() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void disable() {
        sb0.i(this.L == 1);
        this.L = 0;
        this.f30497a = null;
        this.f2163a = false;
        onDisabled();
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int e(d dVar) throws ExoPlaybackException {
        return RendererCapabilities.create(0);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void f(d[] dVarArr, SampleStream sampleStream, long j, long j2) throws ExoPlaybackException {
        sb0.i(!this.f2163a);
        this.f30497a = sampleStream;
        onRendererOffsetChanged(j2);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void g(int i, at6 at6Var) {
        this.K = i;
    }

    @Nullable
    public final ue7 getConfiguration() {
        return this.f2162a;
    }

    public final int getIndex() {
        return this.K;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public long getReadingPositionUs() {
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final int getState() {
        return this.L;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public final int getTrackType() {
        return -2;
    }

    @Override // com.google.android.exoplayer2.Renderer
    @Nullable
    public final SampleStream h() {
        return this.f30497a;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void i(ue7 ue7Var, d[] dVarArr, SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3) throws ExoPlaybackException {
        sb0.i(this.L == 0);
        this.f2162a = ue7Var;
        this.L = 1;
        onEnabled(z);
        f(dVarArr, sampleStream, j2, j3);
        onPositionReset(j, z);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.f2163a;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void maybeThrowStreamError() throws IOException {
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean z) throws ExoPlaybackException {
    }

    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
    }

    public void onRendererOffsetChanged(long j) throws ExoPlaybackException {
    }

    public void onReset() {
    }

    public void onStarted() throws ExoPlaybackException {
    }

    public void onStopped() {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void reset() {
        sb0.i(this.L == 0);
        onReset();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long j) throws ExoPlaybackException {
        this.f2163a = false;
        onPositionReset(j, false);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setCurrentStreamFinal() {
        this.f2163a = true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void start() throws ExoPlaybackException {
        sb0.i(this.L == 1);
        this.L = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void stop() {
        sb0.i(this.L == 2);
        this.L = 1;
        onStopped();
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }
}
