package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.decoder.b;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.gj9;
import com.zj.adlib.hp9;
import com.zj.adlib.p82;
import com.zj.adlib.sb0;
import com.zj.adlib.x79;
import com.zj.adlib.y99;
import com.zj.adlib.yk3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class DecoderVideoRenderer extends BaseRenderer {
    public static final int T = 0;
    public static final int U = 1;
    public static final int V = 2;
    public static final String f = "DecoderVideoRenderer";
    public final int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Surface f31174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f5298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Decoder<DecoderInputBuffer, ? extends b, ? extends DecoderException> f5299a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DecoderInputBuffer f5300a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f5301a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DrmSession f5302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public VideoDecoderOutputBufferRenderer f5303a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public VideoFrameMetadataListener f5304a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final VideoRendererEventListener.a f5305a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public hp9 f5306a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public p82 f5307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final x79<d> f5308a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Object f5309a;
    public d b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public DecoderInputBuffer f5310b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public DrmSession f5311b;
    public boolean c;
    public final long d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f5312d;
    public long e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f5313e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public long f5314f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f5315f;
    public long g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f5316g;
    public long h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f5317h;
    public long i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f5318i;

    public DecoderVideoRenderer(long j, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        super(2);
        this.d = j;
        this.N = i;
        this.f5314f = -9223372036854775807L;
        l();
        this.f5308a = new x79<>();
        this.f5300a = DecoderInputBuffer.n();
        this.f5305a = new VideoRendererEventListener.a(handler, videoRendererEventListener);
        this.P = 0;
        this.O = -1;
    }

    public static boolean p(long j) {
        return j < -30000;
    }

    public static boolean q(long j) {
        return j < -500000;
    }

    public final boolean A(long j, long j2) throws ExoPlaybackException, DecoderException {
        if (this.e == -9223372036854775807L) {
            this.e = j;
        }
        long j3 = ((DecoderOutputBuffer) this.f5301a).f30577a - j;
        if (!o()) {
            if (!p(j3)) {
                return false;
            }
            skipOutputBuffer(this.f5301a);
            return true;
        }
        long j4 = ((DecoderOutputBuffer) this.f5301a).f30577a - this.i;
        d dVarJ = this.f5308a.j(j4);
        if (dVarJ != null) {
            this.b = dVarJ;
        }
        long jElapsedRealtime = (SystemClock.elapsedRealtime() * 1000) - this.h;
        boolean z = getState() == 2;
        if ((this.f5315f ? !this.f5312d : z || this.f5313e) || (z && shouldForceRenderOutputBuffer(j3, jElapsedRealtime))) {
            renderOutputBuffer(this.f5301a, j4, this.b);
            return true;
        }
        if (!z || j == this.e || (shouldDropBuffersToKeyframe(j3, j2) && maybeDropBuffersToKeyframe(j))) {
            return false;
        }
        if (shouldDropOutputBuffer(j3, j2)) {
            dropOutputBuffer(this.f5301a);
            return true;
        }
        if (j3 < 30000) {
            renderOutputBuffer(this.f5301a, j4, this.b);
            return true;
        }
        return false;
    }

    public final void B(@Nullable DrmSession drmSession) {
        DrmSession.e(this.f5302a, drmSession);
        this.f5302a = drmSession;
    }

    public final void C() {
        this.f5314f = this.d > 0 ? SystemClock.elapsedRealtime() + this.d : -9223372036854775807L;
    }

    public final void D(@Nullable DrmSession drmSession) {
        DrmSession.e(this.f5311b, drmSession);
        this.f5311b = drmSession;
    }

    public DecoderReuseEvaluation canReuseDecoder(String str, d dVar, d dVar2) {
        return new DecoderReuseEvaluation(str, dVar, dVar2, 0, 1);
    }

    public abstract Decoder<DecoderInputBuffer, ? extends b, ? extends DecoderException> createDecoder(d dVar, @Nullable CryptoConfig cryptoConfig) throws DecoderException;

    public void dropOutputBuffer(b bVar) {
        updateDroppedBufferCounters(0, 1);
        bVar.j();
    }

    @CallSuper
    public void flushDecoder() throws ExoPlaybackException {
        this.S = 0;
        if (this.P != 0) {
            releaseDecoder();
            r();
            return;
        }
        this.f5310b = null;
        b bVar = this.f5301a;
        if (bVar != null) {
            bVar.j();
            this.f5301a = null;
        }
        this.f5299a.flush();
        this.c = false;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setOutput(obj);
        } else if (i == 7) {
            this.f5304a = (VideoFrameMetadataListener) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.f5318i;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (this.f5298a != null && ((isSourceReady() || this.f5301a != null) && (this.f5312d || !o()))) {
            this.f5314f = -9223372036854775807L;
            return true;
        }
        if (this.f5314f == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.f5314f) {
            return true;
        }
        this.f5314f = -9223372036854775807L;
        return false;
    }

    public final void k() {
        this.f5312d = false;
    }

    public final void l() {
        this.f5306a = null;
    }

    public final boolean m(long j, long j2) throws ExoPlaybackException, DecoderException {
        if (this.f5301a == null) {
            b bVarDequeueOutputBuffer = this.f5299a.dequeueOutputBuffer();
            this.f5301a = bVarDequeueOutputBuffer;
            if (bVarDequeueOutputBuffer == null) {
                return false;
            }
            p82 p82Var = this.f5307a;
            int i = p82Var.f;
            int i2 = bVarDequeueOutputBuffer.L;
            p82Var.f = i + i2;
            this.S -= i2;
        }
        if (!this.f5301a.f()) {
            boolean zA = A(j, j2);
            if (zA) {
                onProcessedOutputBuffer(((DecoderOutputBuffer) this.f5301a).f30577a);
                this.f5301a = null;
            }
            return zA;
        }
        if (this.P == 2) {
            releaseDecoder();
            r();
        } else {
            this.f5301a.j();
            this.f5301a = null;
            this.f5318i = true;
        }
        return false;
    }

    public boolean maybeDropBuffersToKeyframe(long j) throws ExoPlaybackException {
        int iSkipSource = skipSource(j);
        if (iSkipSource == 0) {
            return false;
        }
        this.f5307a.j++;
        updateDroppedBufferCounters(iSkipSource, this.S);
        flushDecoder();
        return true;
    }

    public final boolean n() throws ExoPlaybackException, DecoderException {
        Decoder<DecoderInputBuffer, ? extends b, ? extends DecoderException> decoder = this.f5299a;
        if (decoder == null || this.P == 2 || this.f5317h) {
            return false;
        }
        if (this.f5310b == null) {
            DecoderInputBuffer decoderInputBufferDequeueInputBuffer = decoder.dequeueInputBuffer();
            this.f5310b = decoderInputBufferDequeueInputBuffer;
            if (decoderInputBufferDequeueInputBuffer == null) {
                return false;
            }
        }
        if (this.P == 1) {
            this.f5310b.i(4);
            this.f5299a.queueInputBuffer(this.f5310b);
            this.f5310b = null;
            this.P = 2;
            return false;
        }
        yk3 formatHolder = getFormatHolder();
        int source = readSource(formatHolder, this.f5310b, 0);
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
        if (this.f5310b.f()) {
            this.f5317h = true;
            this.f5299a.queueInputBuffer(this.f5310b);
            this.f5310b = null;
            return false;
        }
        if (this.f5316g) {
            this.f5308a.a(this.f5310b.f30576a, this.f5298a);
            this.f5316g = false;
        }
        this.f5310b.l();
        DecoderInputBuffer decoderInputBuffer = this.f5310b;
        decoderInputBuffer.f2586a = this.f5298a;
        onQueueInputBuffer(decoderInputBuffer);
        this.f5299a.queueInputBuffer(this.f5310b);
        this.S++;
        this.c = true;
        this.f5307a.c++;
        this.f5310b = null;
        return true;
    }

    public final boolean o() {
        return this.O != -1;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.f5298a = null;
        l();
        k();
        try {
            D(null);
            releaseDecoder();
        } finally {
            this.f5305a.m(this.f5307a);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        p82 p82Var = new p82();
        this.f5307a = p82Var;
        this.f5305a.o(p82Var);
        this.f5313e = z2;
        this.f5315f = false;
    }

    @CallSuper
    public void onInputFormatChanged(yk3 yk3Var) throws ExoPlaybackException {
        this.f5316g = true;
        d dVar = (d) sb0.g(yk3Var.f46052a);
        D(yk3Var.f20874a);
        d dVar2 = this.f5298a;
        this.f5298a = dVar;
        Decoder<DecoderInputBuffer, ? extends b, ? extends DecoderException> decoder = this.f5299a;
        if (decoder == null) {
            r();
            this.f5305a.p(this.f5298a, null);
            return;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = this.f5311b != this.f5302a ? new DecoderReuseEvaluation(decoder.getName(), dVar2, dVar, 0, 128) : canReuseDecoder(decoder.getName(), dVar2, dVar);
        if (decoderReuseEvaluation.f30578a == 0) {
            if (this.c) {
                this.P = 1;
            } else {
                releaseDecoder();
                r();
            }
        }
        this.f5305a.p(this.f5298a, decoderReuseEvaluation);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        this.f5317h = false;
        this.f5318i = false;
        k();
        this.e = -9223372036854775807L;
        this.R = 0;
        if (this.f5299a != null) {
            flushDecoder();
        }
        if (z) {
            C();
        } else {
            this.f5314f = -9223372036854775807L;
        }
        this.f5308a.c();
    }

    @CallSuper
    public void onProcessedOutputBuffer(long j) {
        this.S--;
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        this.Q = 0;
        this.g = SystemClock.elapsedRealtime();
        this.h = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        this.f5314f = -9223372036854775807L;
        s();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(d[] dVarArr, long j, long j2) throws ExoPlaybackException {
        this.i = j2;
        super.onStreamChanged(dVarArr, j, j2);
    }

    public final void r() throws ExoPlaybackException {
        CryptoConfig cryptoConfigB;
        if (this.f5299a != null) {
            return;
        }
        B(this.f5311b);
        DrmSession drmSession = this.f5302a;
        if (drmSession != null) {
            cryptoConfigB = drmSession.b();
            if (cryptoConfigB == null && this.f5302a.c() == null) {
                return;
            }
        } else {
            cryptoConfigB = null;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f5299a = createDecoder(this.f5298a, cryptoConfigB);
            setDecoderOutputMode(this.O);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.f5305a.k(this.f5299a.getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.f5307a.f43924a++;
        } catch (DecoderException e) {
            Log.e(f, "Video codec error", e);
            this.f5305a.C(e);
            throw createRendererException(e, this.f5298a, 4001);
        } catch (OutOfMemoryError e2) {
            throw createRendererException(e2, this.f5298a, 4001);
        }
    }

    @CallSuper
    public void releaseDecoder() {
        this.f5310b = null;
        this.f5301a = null;
        this.P = 0;
        this.c = false;
        this.S = 0;
        Decoder<DecoderInputBuffer, ? extends b, ? extends DecoderException> decoder = this.f5299a;
        if (decoder != null) {
            this.f5307a.b++;
            decoder.release();
            this.f5305a.l(this.f5299a.getName());
            this.f5299a = null;
        }
        B(null);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        if (this.f5318i) {
            return;
        }
        if (this.f5298a == null) {
            yk3 formatHolder = getFormatHolder();
            this.f5300a.b();
            int source = readSource(formatHolder, this.f5300a, 2);
            if (source != -5) {
                if (source == -4) {
                    sb0.i(this.f5300a.f());
                    this.f5317h = true;
                    this.f5318i = true;
                    return;
                }
                return;
            }
            onInputFormatChanged(formatHolder);
        }
        r();
        if (this.f5299a != null) {
            try {
                y99.a("drainAndFeed");
                while (m(j, j2)) {
                }
                while (n()) {
                }
                y99.c();
                this.f5307a.c();
            } catch (DecoderException e) {
                Log.e(f, "Video codec error", e);
                this.f5305a.C(e);
                throw createRendererException(e, this.f5298a, 4003);
            }
        }
    }

    public void renderOutputBuffer(b bVar, long j, d dVar) throws DecoderException {
        VideoFrameMetadataListener videoFrameMetadataListener = this.f5304a;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.b(j, System.nanoTime(), dVar, null);
        }
        this.h = gj9.Z0(SystemClock.elapsedRealtime() * 1000);
        int i = bVar.N;
        boolean z = i == 1 && this.f31174a != null;
        boolean z2 = i == 0 && this.f5303a != null;
        if (!z2 && !z) {
            dropOutputBuffer(bVar);
            return;
        }
        u(bVar.O, bVar.P);
        if (z2) {
            this.f5303a.setOutputBuffer(bVar);
        } else {
            renderOutputBufferToSurface(bVar, this.f31174a);
        }
        this.R = 0;
        this.f5307a.e++;
        t();
    }

    public abstract void renderOutputBufferToSurface(b bVar, Surface surface) throws DecoderException;

    public final void s() {
        if (this.Q > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f5305a.n(this.Q, jElapsedRealtime - this.g);
            this.Q = 0;
            this.g = jElapsedRealtime;
        }
    }

    public abstract void setDecoderOutputMode(int i);

    public final void setOutput(@Nullable Object obj) {
        if (obj instanceof Surface) {
            this.f31174a = (Surface) obj;
            this.f5303a = null;
            this.O = 1;
        } else if (obj instanceof VideoDecoderOutputBufferRenderer) {
            this.f31174a = null;
            this.f5303a = (VideoDecoderOutputBufferRenderer) obj;
            this.O = 0;
        } else {
            this.f31174a = null;
            this.f5303a = null;
            this.O = -1;
            obj = null;
        }
        if (this.f5309a == obj) {
            if (obj != null) {
                z();
                return;
            }
            return;
        }
        this.f5309a = obj;
        if (obj == null) {
            y();
            return;
        }
        if (this.f5299a != null) {
            setDecoderOutputMode(this.O);
        }
        x();
    }

    public boolean shouldDropBuffersToKeyframe(long j, long j2) {
        return q(j);
    }

    public boolean shouldDropOutputBuffer(long j, long j2) {
        return p(j);
    }

    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return p(j) && j2 > 100000;
    }

    public void skipOutputBuffer(b bVar) {
        this.f5307a.f++;
        bVar.j();
    }

    public final void t() {
        this.f5315f = true;
        if (this.f5312d) {
            return;
        }
        this.f5312d = true;
        this.f5305a.A(this.f5309a);
    }

    public final void u(int i, int i2) {
        hp9 hp9Var = this.f5306a;
        if (hp9Var != null && hp9Var.K == i && hp9Var.L == i2) {
            return;
        }
        hp9 hp9Var2 = new hp9(i, i2);
        this.f5306a = hp9Var2;
        this.f5305a.D(hp9Var2);
    }

    public void updateDroppedBufferCounters(int i, int i2) {
        p82 p82Var = this.f5307a;
        p82Var.h += i;
        int i3 = i + i2;
        p82Var.g += i3;
        this.Q += i3;
        int i4 = this.R + i3;
        this.R = i4;
        p82Var.i = Math.max(i4, p82Var.i);
        int i5 = this.N;
        if (i5 <= 0 || this.Q < i5) {
            return;
        }
        s();
    }

    public final void v() {
        if (this.f5312d) {
            this.f5305a.A(this.f5309a);
        }
    }

    public final void w() {
        hp9 hp9Var = this.f5306a;
        if (hp9Var != null) {
            this.f5305a.D(hp9Var);
        }
    }

    public final void x() {
        w();
        k();
        if (getState() == 2) {
            C();
        }
    }

    public final void y() {
        l();
        k();
    }

    public final void z() {
        w();
        v();
    }
}
