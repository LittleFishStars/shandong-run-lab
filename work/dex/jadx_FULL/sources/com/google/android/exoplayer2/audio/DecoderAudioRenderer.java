package com.google.android.exoplayer2.audio;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaClock;
import com.zj.adlib.bp5;
import com.zj.adlib.gj9;
import com.zj.adlib.p82;
import com.zj.adlib.pi0;
import com.zj.adlib.qe0;
import com.zj.adlib.sb0;
import com.zj.adlib.y99;
import com.zj.adlib.yk3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class DecoderAudioRenderer<T extends Decoder<DecoderInputBuffer, ? extends com.google.android.exoplayer2.decoder.a, ? extends DecoderException>> extends BaseRenderer implements MediaClock {
    public static final int Q = 0;
    public static final int R = 1;
    public static final int S = 2;
    public static final String f = "DecoderAudioRenderer";
    public int N;
    public int O;
    public int P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioRendererEventListener.a f30542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AudioSink f2388a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.d f2389a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public T f2390a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DecoderInputBuffer f2391a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.decoder.a f2392a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DrmSession f2393a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public p82 f2394a;

    @Nullable
    public DecoderInputBuffer b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public DrmSession f2395b;
    public boolean c;
    public long d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f2396d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f2397f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;

    public final class b implements AudioSink.Listener {
        public b() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onAudioSinkError(Exception exc) {
            Log.e(DecoderAudioRenderer.f, "Audio sink error", exc);
            DecoderAudioRenderer.this.f30542a.l(exc);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionAdvancing(long j) {
            DecoderAudioRenderer.this.f30542a.B(j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionDiscontinuity() {
            DecoderAudioRenderer.this.onPositionDiscontinuity();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onSkipSilenceEnabledChanged(boolean z) {
            DecoderAudioRenderer.this.f30542a.C(z);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onUnderrun(int i, long j, long j2) {
            DecoderAudioRenderer.this.f30542a.D(i, j, j2);
        }
    }

    public DecoderAudioRenderer() {
        this((Handler) null, (AudioRendererEventListener) null, new AudioProcessor[0]);
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public com.google.android.exoplayer2.j b() {
        return this.f2388a.b();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void c(com.google.android.exoplayer2.j jVar) {
        this.f2388a.c(jVar);
    }

    public DecoderReuseEvaluation canReuseDecoder(String str, com.google.android.exoplayer2.d dVar, com.google.android.exoplayer2.d dVar2) {
        return new DecoderReuseEvaluation(str, dVar, dVar2, 0, 1);
    }

    public abstract T createDecoder(com.google.android.exoplayer2.d dVar, @Nullable CryptoConfig cryptoConfig) throws DecoderException;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    @Nullable
    public MediaClock d() {
        return this;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int e(com.google.android.exoplayer2.d dVar) {
        if (!bp5.p(dVar.k)) {
            return RendererCapabilities.create(0);
        }
        int iSupportsFormatInternal = supportsFormatInternal(dVar);
        if (iSupportsFormatInternal <= 2) {
            return RendererCapabilities.create(iSupportsFormatInternal);
        }
        return RendererCapabilities.create(iSupportsFormatInternal, 8, gj9.f41922a >= 21 ? 32 : 0);
    }

    public final void flushDecoder() throws ExoPlaybackException {
        if (this.P != 0) {
            releaseDecoder();
            o();
            return;
        }
        this.b = null;
        com.google.android.exoplayer2.decoder.a aVar = this.f2392a;
        if (aVar != null) {
            aVar.j();
            this.f2392a = null;
        }
        this.f2390a.flush();
        this.e = false;
    }

    public abstract com.google.android.exoplayer2.d getOutputFormat(T t);

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (getState() == 2) {
            s();
        }
        return this.d;
    }

    public final int getSinkFormatSupport(com.google.android.exoplayer2.d dVar) {
        return this.f2388a.f(dVar);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.f2388a.setVolume(((Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            this.f2388a.j((com.google.android.exoplayer2.audio.a) obj);
            return;
        }
        if (i == 6) {
            this.f2388a.e((pi0) obj);
        } else if (i == 9) {
            this.f2388a.setSkipSilenceEnabled(((Boolean) obj).booleanValue());
        } else if (i != 10) {
            super.handleMessage(i, obj);
        } else {
            this.f2388a.setAudioSessionId(((Integer) obj).intValue());
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.j && this.f2388a.isEnded();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.f2388a.hasPendingData() || (this.f2389a != null && (isSourceReady() || this.f2392a != null));
    }

    public final boolean l() throws ExoPlaybackException, AudioSink.WriteException, AudioSink.InitializationException, AudioSink.ConfigurationException, DecoderException {
        if (this.f2392a == null) {
            com.google.android.exoplayer2.decoder.a aVar = (com.google.android.exoplayer2.decoder.a) this.f2390a.dequeueOutputBuffer();
            this.f2392a = aVar;
            if (aVar == null) {
                return false;
            }
            int i = aVar.L;
            if (i > 0) {
                this.f2394a.f += i;
                this.f2388a.handleDiscontinuity();
            }
            if (this.f2392a.g()) {
                this.f2388a.handleDiscontinuity();
            }
        }
        if (this.f2392a.f()) {
            if (this.P == 2) {
                releaseDecoder();
                o();
                this.f2397f = true;
            } else {
                this.f2392a.j();
                this.f2392a = null;
                try {
                    p();
                } catch (AudioSink.WriteException e) {
                    throw createRendererException(e, e.format, e.isRecoverable, 5002);
                }
            }
            return false;
        }
        if (this.f2397f) {
            this.f2388a.g(getOutputFormat(this.f2390a).b().N(this.N).O(this.O).E(), 0, null);
            this.f2397f = false;
        }
        AudioSink audioSink = this.f2388a;
        com.google.android.exoplayer2.decoder.a aVar2 = this.f2392a;
        if (!audioSink.handleBuffer(aVar2.f2603a, ((DecoderOutputBuffer) aVar2).f30577a, 1)) {
            return false;
        }
        this.f2394a.e++;
        this.f2392a.j();
        this.f2392a = null;
        return true;
    }

    public void m(boolean z) {
        this.c = z;
    }

    public final boolean n() throws ExoPlaybackException, DecoderException {
        T t = this.f2390a;
        if (t == null || this.P == 2 || this.i) {
            return false;
        }
        if (this.b == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) t.dequeueInputBuffer();
            this.b = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.P == 1) {
            this.b.i(4);
            this.f2390a.queueInputBuffer(this.b);
            this.b = null;
            this.P = 2;
            return false;
        }
        yk3 formatHolder = getFormatHolder();
        int source = readSource(formatHolder, this.b, 0);
        if (source == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (source != -4) {
            if (source == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        if (this.b.f()) {
            this.i = true;
            this.f2390a.queueInputBuffer(this.b);
            this.b = null;
            return false;
        }
        if (!this.f2396d) {
            this.f2396d = true;
            this.b.a(134217728);
        }
        this.b.l();
        DecoderInputBuffer decoderInputBuffer2 = this.b;
        decoderInputBuffer2.f2586a = this.f2389a;
        onQueueInputBuffer(decoderInputBuffer2);
        this.f2390a.queueInputBuffer(this.b);
        this.e = true;
        this.f2394a.c++;
        this.b = null;
        return true;
    }

    public final void o() throws ExoPlaybackException {
        CryptoConfig cryptoConfigB;
        if (this.f2390a != null) {
            return;
        }
        q(this.f2395b);
        DrmSession drmSession = this.f2393a;
        if (drmSession != null) {
            cryptoConfigB = drmSession.b();
            if (cryptoConfigB == null && this.f2393a.c() == null) {
                return;
            }
        } else {
            cryptoConfigB = null;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            y99.a("createAudioDecoder");
            this.f2390a = (T) createDecoder(this.f2389a, cryptoConfigB);
            y99.c();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.f30542a.m(this.f2390a.getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.f2394a.f43924a++;
        } catch (DecoderException e) {
            Log.e(f, "Audio codec error", e);
            this.f30542a.k(e);
            throw createRendererException(e, this.f2389a, 4001);
        } catch (OutOfMemoryError e2) {
            throw createRendererException(e2, this.f2389a, 4001);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.f2389a = null;
        this.f2397f = true;
        try {
            r(null);
            releaseDecoder();
            this.f2388a.reset();
        } finally {
            this.f30542a.o(this.f2394a);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        p82 p82Var = new p82();
        this.f2394a = p82Var;
        this.f30542a.p(p82Var);
        if (getConfiguration().f20053a) {
            this.f2388a.enableTunnelingV21();
        } else {
            this.f2388a.disableTunneling();
        }
        this.f2388a.h(getPlayerId());
    }

    public final void onInputFormatChanged(yk3 yk3Var) throws ExoPlaybackException {
        com.google.android.exoplayer2.d dVar = (com.google.android.exoplayer2.d) sb0.g(yk3Var.f46052a);
        r(yk3Var.f20874a);
        com.google.android.exoplayer2.d dVar2 = this.f2389a;
        this.f2389a = dVar;
        this.N = dVar.X;
        this.O = dVar.Y;
        T t = this.f2390a;
        if (t == null) {
            o();
            this.f30542a.q(this.f2389a, null);
            return;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = this.f2395b != this.f2393a ? new DecoderReuseEvaluation(t.getName(), dVar2, dVar, 0, 128) : canReuseDecoder(t.getName(), dVar2, dVar);
        if (decoderReuseEvaluation.f30578a == 0) {
            if (this.e) {
                this.P = 1;
            } else {
                releaseDecoder();
                o();
                this.f2397f = true;
            }
        }
        this.f30542a.q(this.f2389a, decoderReuseEvaluation);
    }

    @CallSuper
    public void onPositionDiscontinuity() {
        this.h = true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        if (this.c) {
            this.f2388a.experimentalFlushWithoutAudioTrackRelease();
        } else {
            this.f2388a.flush();
        }
        this.d = j;
        this.g = true;
        this.h = true;
        this.i = false;
        this.j = false;
        if (this.f2390a != null) {
            flushDecoder();
        }
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (!this.g || decoderInputBuffer.e()) {
            return;
        }
        if (Math.abs(decoderInputBuffer.f30576a - this.d) > 500000) {
            this.d = decoderInputBuffer.f30576a;
        }
        this.g = false;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        this.f2388a.play();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        s();
        this.f2388a.pause();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(com.google.android.exoplayer2.d[] dVarArr, long j, long j2) throws ExoPlaybackException {
        super.onStreamChanged(dVarArr, j, j2);
        this.f2396d = false;
    }

    public final void p() throws AudioSink.WriteException {
        this.j = true;
        this.f2388a.playToEndOfStream();
    }

    public final void q(@Nullable DrmSession drmSession) {
        DrmSession.e(this.f2393a, drmSession);
        this.f2393a = drmSession;
    }

    public final void r(@Nullable DrmSession drmSession) {
        DrmSession.e(this.f2395b, drmSession);
        this.f2395b = drmSession;
    }

    public final void releaseDecoder() {
        this.b = null;
        this.f2392a = null;
        this.P = 0;
        this.e = false;
        T t = this.f2390a;
        if (t != null) {
            this.f2394a.b++;
            t.release();
            this.f30542a.n(this.f2390a.getName());
            this.f2390a = null;
        }
        q(null);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        if (this.j) {
            try {
                this.f2388a.playToEndOfStream();
                return;
            } catch (AudioSink.WriteException e) {
                throw createRendererException(e, e.format, e.isRecoverable, 5002);
            }
        }
        if (this.f2389a == null) {
            yk3 formatHolder = getFormatHolder();
            this.f2391a.b();
            int source = readSource(formatHolder, this.f2391a, 2);
            if (source != -5) {
                if (source == -4) {
                    sb0.i(this.f2391a.f());
                    this.i = true;
                    try {
                        p();
                        return;
                    } catch (AudioSink.WriteException e2) {
                        throw createRendererException(e2, null, 5002);
                    }
                }
                return;
            }
            onInputFormatChanged(formatHolder);
        }
        o();
        if (this.f2390a != null) {
            try {
                y99.a("drainAndFeed");
                while (l()) {
                }
                while (n()) {
                }
                y99.c();
                this.f2394a.c();
            } catch (AudioSink.ConfigurationException e3) {
                throw createRendererException(e3, e3.format, 5001);
            } catch (AudioSink.InitializationException e4) {
                throw createRendererException(e4, e4.format, e4.isRecoverable, 5001);
            } catch (AudioSink.WriteException e5) {
                throw createRendererException(e5, e5.format, e5.isRecoverable, 5002);
            } catch (DecoderException e6) {
                Log.e(f, "Audio codec error", e6);
                this.f30542a.k(e6);
                throw createRendererException(e6, this.f2389a, 4003);
            }
        }
    }

    public final void s() {
        long currentPositionUs = this.f2388a.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.h) {
                currentPositionUs = Math.max(this.d, currentPositionUs);
            }
            this.d = currentPositionUs;
            this.h = false;
        }
    }

    public final boolean sinkSupportsFormat(com.google.android.exoplayer2.d dVar) {
        return this.f2388a.a(dVar);
    }

    public abstract int supportsFormatInternal(com.google.android.exoplayer2.d dVar);

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, null, audioProcessorArr);
    }

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, qe0 qe0Var, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, new DefaultAudioSink.c().g((qe0) com.google.common.base.e.a(qe0Var, qe0.f19069a)).i(audioProcessorArr).f());
    }

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(1);
        this.f30542a = new AudioRendererEventListener.a(handler, audioRendererEventListener);
        this.f2388a = audioSink;
        audioSink.i(new b());
        this.f2391a = DecoderInputBuffer.n();
        this.P = 0;
        this.f2397f = true;
    }
}
