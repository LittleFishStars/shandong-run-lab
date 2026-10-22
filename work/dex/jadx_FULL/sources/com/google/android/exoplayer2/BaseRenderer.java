package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.MediaClock;
import com.zj.adlib.at6;
import com.zj.adlib.sb0;
import com.zj.adlib.ue7;
import com.zj.adlib.yk3;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseRenderer implements Renderer, RendererCapabilities {
    public final int K;
    public int L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30476a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public SampleStream f1986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public at6 f1987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ue7 f1988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public d[] f1991a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1992b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final yk3 f1989a = new yk3();
    public long c = Long.MIN_VALUE;

    public BaseRenderer(int i) {
        this.K = i;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final RendererCapabilities a() {
        return this;
    }

    public final ExoPlaybackException createRendererException(Throwable th, @Nullable d dVar, int i) {
        return createRendererException(th, dVar, false, i);
    }

    @Override // com.google.android.exoplayer2.Renderer
    @Nullable
    public MediaClock d() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void disable() {
        sb0.i(this.M == 1);
        this.f1989a.a();
        this.M = 0;
        this.f1986a = null;
        this.f1991a = null;
        this.f1990a = false;
        onDisabled();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void f(d[] dVarArr, SampleStream sampleStream, long j, long j2) throws ExoPlaybackException {
        sb0.i(!this.f1990a);
        this.f1986a = sampleStream;
        if (this.c == Long.MIN_VALUE) {
            this.c = j;
        }
        this.f1991a = dVarArr;
        this.f30476a = j2;
        onStreamChanged(dVarArr, j, j2);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void g(int i, at6 at6Var) {
        this.L = i;
        this.f1987a = at6Var;
    }

    public final ue7 getConfiguration() {
        return (ue7) sb0.g(this.f1988a);
    }

    public final yk3 getFormatHolder() {
        this.f1989a.a();
        return this.f1989a;
    }

    public final int getIndex() {
        return this.L;
    }

    public final long getLastResetPositionUs() {
        return this.b;
    }

    public final at6 getPlayerId() {
        return (at6) sb0.g(this.f1987a);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final long getReadingPositionUs() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final int getState() {
        return this.M;
    }

    public final d[] getStreamFormats() {
        return (d[]) sb0.g(this.f1991a);
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public final int getTrackType() {
        return this.K;
    }

    @Override // com.google.android.exoplayer2.Renderer
    @Nullable
    public final SampleStream h() {
        return this.f1986a;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        return this.c == Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void i(ue7 ue7Var, d[] dVarArr, SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3) throws ExoPlaybackException {
        sb0.i(this.M == 0);
        this.f1988a = ue7Var;
        this.M = 1;
        onEnabled(z, z2);
        f(dVarArr, sampleStream, j2, j3);
        j(j, z);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.f1990a;
    }

    public final boolean isSourceReady() {
        return hasReadStreamToEnd() ? this.f1990a : ((SampleStream) sb0.g(this.f1986a)).isReady();
    }

    public final void j(long j, boolean z) throws ExoPlaybackException {
        this.f1990a = false;
        this.b = j;
        this.c = j;
        onPositionReset(j, z);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void maybeThrowStreamError() throws IOException {
        ((SampleStream) sb0.g(this.f1986a)).maybeThrowError();
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
    }

    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
    }

    public void onReset() {
    }

    public void onStarted() throws ExoPlaybackException {
    }

    public void onStopped() {
    }

    public void onStreamChanged(d[] dVarArr, long j, long j2) throws ExoPlaybackException {
    }

    public final int readSource(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i) {
        int iB = ((SampleStream) sb0.g(this.f1986a)).b(yk3Var, decoderInputBuffer, i);
        if (iB == -4) {
            if (decoderInputBuffer.f()) {
                this.c = Long.MIN_VALUE;
                return this.f1990a ? -4 : -3;
            }
            long j = decoderInputBuffer.f30576a + this.f30476a;
            decoderInputBuffer.f30576a = j;
            this.c = Math.max(this.c, j);
        } else if (iB == -5) {
            d dVar = (d) sb0.g(yk3Var.f46052a);
            if (dVar.f2565a != Long.MAX_VALUE) {
                yk3Var.f46052a = dVar.b().i0(dVar.f2565a + this.f30476a).E();
            }
        }
        return iB;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void reset() {
        sb0.i(this.M == 0);
        this.f1989a.a();
        onReset();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long j) throws ExoPlaybackException {
        j(j, false);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setCurrentStreamFinal() {
        this.f1990a = true;
    }

    public int skipSource(long j) {
        return ((SampleStream) sb0.g(this.f1986a)).skipData(j - this.f30476a);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void start() throws ExoPlaybackException {
        sb0.i(this.M == 1);
        this.M = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void stop() {
        sb0.i(this.M == 2);
        this.M = 1;
        onStopped();
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }

    public final ExoPlaybackException createRendererException(Throwable th, @Nullable d dVar, boolean z, int i) {
        int formatSupport;
        if (dVar == null || this.f1992b) {
            formatSupport = 4;
        } else {
            this.f1992b = true;
            try {
                formatSupport = RendererCapabilities.getFormatSupport(e(dVar));
                this.f1992b = false;
            } catch (ExoPlaybackException unused) {
                this.f1992b = false;
                formatSupport = 4;
            } catch (Throwable th2) {
                this.f1992b = false;
                throw th2;
            }
        }
        return ExoPlaybackException.createForRenderer(th, getName(), getIndex(), dVar, formatSupport, z, i);
    }
}
