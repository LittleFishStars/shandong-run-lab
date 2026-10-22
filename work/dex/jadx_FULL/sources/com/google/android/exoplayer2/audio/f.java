package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.bp5;
import com.zj.adlib.fh5;
import com.zj.adlib.gj9;
import com.zj.adlib.pi0;
import com.zj.adlib.qe0;
import com.zj.adlib.sb0;
import com.zj.adlib.yk3;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class f extends MediaCodecRenderer implements MediaClock {
    public static final String g = "MediaCodecAudioRenderer";
    public static final String h = "v-bits-per-sample";
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f30565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Renderer.WakeupListener f2473a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AudioRendererEventListener.a f2474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AudioSink f2475a;

    @Nullable
    public com.google.android.exoplayer2.d d;
    public int j0;
    public long k;

    public final class b implements AudioSink.Listener {
        public b() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onAudioSinkError(Exception exc) {
            Log.e(f.g, "Audio sink error", exc);
            f.this.f2474a.l(exc);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onOffloadBufferEmptying() {
            if (f.this.f2473a != null) {
                f.this.f2473a.onWakeup();
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onOffloadBufferFull() {
            if (f.this.f2473a != null) {
                f.this.f2473a.onSleep();
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionAdvancing(long j) {
            f.this.f2474a.B(j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionDiscontinuity() {
            f.this.onPositionDiscontinuity();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onSkipSilenceEnabledChanged(boolean z) {
            f.this.f2474a.C(z);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onUnderrun(int i, long j, long j2) {
            f.this.f2474a.D(i, j, j2);
        }
    }

    public f(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, null, null);
    }

    public static boolean b0(String str) {
        if (gj9.f41922a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(gj9.b)) {
            String str2 = gj9.f16787a;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    public static boolean c0() {
        if (gj9.f41922a == 23) {
            String str = gj9.c;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static List<com.google.android.exoplayer2.mediacodec.c> f0(MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.d dVar, boolean z, AudioSink audioSink) throws MediaCodecUtil.DecoderQueryException {
        com.google.android.exoplayer2.mediacodec.c cVarW;
        String str = dVar.k;
        if (str == null) {
            return ImmutableList.of();
        }
        if (audioSink.a(dVar) && (cVarW = MediaCodecUtil.w()) != null) {
            return ImmutableList.of(cVarW);
        }
        List<com.google.android.exoplayer2.mediacodec.c> decoderInfos = mediaCodecSelector.getDecoderInfos(str, z, false);
        String strN = MediaCodecUtil.n(dVar);
        return strN == null ? ImmutableList.copyOf((Collection) decoderInfos) : ImmutableList.builder().c(decoderInfos).c(mediaCodecSelector.getDecoderInfos(strN, z, false)).e();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public com.google.android.exoplayer2.j b() {
        return this.f2475a.b();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void c(com.google.android.exoplayer2.j jVar) {
        this.f2475a.c(jVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public DecoderReuseEvaluation canReuseCodec(com.google.android.exoplayer2.mediacodec.c cVar, com.google.android.exoplayer2.d dVar, com.google.android.exoplayer2.d dVar2) {
        DecoderReuseEvaluation decoderReuseEvaluationE = cVar.e(dVar, dVar2);
        int i = decoderReuseEvaluationE.b;
        if (e0(cVar, dVar2) > this.j0) {
            i |= 64;
        }
        int i2 = i;
        return new DecoderReuseEvaluation(cVar.f3463a, dVar, dVar2, i2 != 0 ? 0 : decoderReuseEvaluationE.f30578a, i2);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    @Nullable
    public MediaClock d() {
        return this;
    }

    public void d0(boolean z) {
        this.G = z;
    }

    public final int e0(com.google.android.exoplayer2.mediacodec.c cVar, com.google.android.exoplayer2.d dVar) {
        int i;
        if (!"OMX.google.raw.decoder".equals(cVar.f3463a) || (i = gj9.f41922a) >= 24 || (i == 23 && gj9.O0(this.f30565a))) {
            return dVar.P;
        }
        return -1;
    }

    public final void g0() {
        long currentPositionUs = this.f2475a.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.E) {
                currentPositionUs = Math.max(this.k, currentPositionUs);
            }
            this.k = currentPositionUs;
            this.E = false;
        }
    }

    public int getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.c cVar, com.google.android.exoplayer2.d dVar, com.google.android.exoplayer2.d[] dVarArr) {
        int iE0 = e0(cVar, dVar);
        if (dVarArr.length == 1) {
            return iE0;
        }
        for (com.google.android.exoplayer2.d dVar2 : dVarArr) {
            if (cVar.e(dVar, dVar2).f30578a != 0) {
                iE0 = Math.max(iE0, e0(cVar, dVar2));
            }
        }
        return iE0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float getCodecOperatingRateV23(float f, com.google.android.exoplayer2.d dVar, com.google.android.exoplayer2.d[] dVarArr) {
        int iMax = -1;
        for (com.google.android.exoplayer2.d dVar2 : dVarArr) {
            int i = dVar2.V;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return f * iMax;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<com.google.android.exoplayer2.mediacodec.c> getDecoderInfos(MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.d dVar, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.v(f0(mediaCodecSelector, dVar, z, this.f2475a), dVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecAdapter.a getMediaCodecConfiguration(com.google.android.exoplayer2.mediacodec.c cVar, com.google.android.exoplayer2.d dVar, @Nullable MediaCrypto mediaCrypto, float f) {
        this.j0 = getCodecMaxInputSize(cVar, dVar, getStreamFormats());
        this.C = b0(cVar.f3463a);
        MediaFormat mediaFormat = getMediaFormat(dVar, cVar.c, this.j0, f);
        this.d = "audio/raw".equals(cVar.b) && !"audio/raw".equals(dVar.k) ? dVar : null;
        return MediaCodecAdapter.a.a(cVar, mediaFormat, dVar, mediaCrypto);
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat getMediaFormat(com.google.android.exoplayer2.d dVar, String str, int i, float f) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT, dVar.U);
        mediaFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE, dVar.V);
        fh5.j(mediaFormat, dVar.f2569a);
        fh5.e(mediaFormat, "max-input-size", i);
        int i2 = gj9.f41922a;
        if (i2 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f && !c0()) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (i2 <= 28 && "audio/ac4".equals(dVar.k)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i2 >= 24 && this.f2475a.f(gj9.o0(4, dVar.U, dVar.V)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i2 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return g;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (getState() == 2) {
            g0();
        }
        return this.k;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.f2475a.setVolume(((Float) obj).floatValue());
        }
        if (i == 3) {
            this.f2475a.j((com.google.android.exoplayer2.audio.a) obj);
            return;
        }
        if (i == 6) {
            this.f2475a.e((pi0) obj);
            return;
        }
        switch (i) {
            case 9:
                this.f2475a.setSkipSilenceEnabled(((Boolean) obj).booleanValue());
                break;
            case 10:
                this.f2475a.setAudioSessionId(((Integer) obj).intValue());
                break;
            case 11:
                this.f2473a = (Renderer.WakeupListener) obj;
                break;
            default:
                super.handleMessage(i, obj);
                break;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return super.isEnded() && this.f2475a.isEnded();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.f2475a.hasPendingData() || super.isReady();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecError(Exception exc) {
        Log.e(g, "Audio codec error", exc);
        this.f2474a.k(exc);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String str, MediaCodecAdapter.a aVar, long j, long j2) {
        this.f2474a.m(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecReleased(String str) {
        this.f2474a.n(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.F = true;
        try {
            this.f2475a.flush();
            try {
                super.onDisabled();
            } finally {
                this.f2474a.o(((MediaCodecRenderer) this).f3423a);
            }
        } catch (Throwable th) {
            try {
                super.onDisabled();
                throw th;
            } finally {
                this.f2474a.o(((MediaCodecRenderer) this).f3423a);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        this.f2474a.p(((MediaCodecRenderer) this).f3423a);
        if (getConfiguration().f20053a) {
            this.f2475a.enableTunnelingV21();
        } else {
            this.f2475a.disableTunneling();
        }
        this.f2475a.h(getPlayerId());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public DecoderReuseEvaluation onInputFormatChanged(yk3 yk3Var) throws ExoPlaybackException {
        DecoderReuseEvaluation decoderReuseEvaluationOnInputFormatChanged = super.onInputFormatChanged(yk3Var);
        this.f2474a.q(yk3Var.f46052a, decoderReuseEvaluationOnInputFormatChanged);
        return decoderReuseEvaluationOnInputFormatChanged;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(com.google.android.exoplayer2.d dVar, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
        int iN0;
        int i;
        com.google.android.exoplayer2.d dVar2 = this.d;
        int[] iArr = null;
        if (dVar2 != null) {
            dVar = dVar2;
        } else if (getCodec() != null) {
            if ("audio/raw".equals(dVar.k)) {
                iN0 = dVar.W;
            } else if (gj9.f41922a < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                iN0 = mediaFormat.containsKey(h) ? gj9.n0(mediaFormat.getInteger(h)) : 2;
            } else {
                iN0 = mediaFormat.getInteger("pcm-encoding");
            }
            com.google.android.exoplayer2.d dVarE = new com.google.android.exoplayer2.d.b().e0("audio/raw").Y(iN0).N(dVar.X).O(dVar.Y).H(mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT)).f0(mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE)).E();
            if (this.C && dVarE.U == 6 && (i = dVar.U) < 6) {
                iArr = new int[i];
                for (int i2 = 0; i2 < dVar.U; i2++) {
                    iArr[i2] = i2;
                }
            }
            dVar = dVarE;
        }
        try {
            this.f2475a.g(dVar, 0, iArr);
        } catch (AudioSink.ConfigurationException e) {
            throw createRendererException(e, e.format, 5001);
        }
    }

    @CallSuper
    public void onPositionDiscontinuity() {
        this.E = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        if (this.G) {
            this.f2475a.experimentalFlushWithoutAudioTrackRelease();
        } else {
            this.f2475a.flush();
        }
        this.k = j;
        this.D = true;
        this.E = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        this.f2475a.handleDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (!this.D || decoderInputBuffer.e()) {
            return;
        }
        if (Math.abs(decoderInputBuffer.f30576a - this.k) > 500000) {
            this.k = decoderInputBuffer.f30576a;
        }
        this.D = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onReset() {
        try {
            super.onReset();
        } finally {
            if (this.F) {
                this.F = false;
                this.f2475a.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        super.onStarted();
        this.f2475a.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        g0();
        this.f2475a.pause();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long j, long j2, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, com.google.android.exoplayer2.d dVar) throws ExoPlaybackException {
        sb0.g(byteBuffer);
        if (this.d != null && (i2 & 2) != 0) {
            ((MediaCodecAdapter) sb0.g(mediaCodecAdapter)).releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.releaseOutputBuffer(i, false);
            }
            ((MediaCodecRenderer) this).f3423a.f += i3;
            this.f2475a.handleDiscontinuity();
            return true;
        }
        try {
            if (!this.f2475a.handleBuffer(byteBuffer, j3, i3)) {
                return false;
            }
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.releaseOutputBuffer(i, false);
            }
            ((MediaCodecRenderer) this).f3423a.e += i3;
            return true;
        } catch (AudioSink.InitializationException e) {
            throw createRendererException(e, e.format, e.isRecoverable, 5001);
        } catch (AudioSink.WriteException e2) {
            throw createRendererException(e2, dVar, e2.isRecoverable, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void renderToEndOfStream() throws ExoPlaybackException {
        try {
            this.f2475a.playToEndOfStream();
        } catch (AudioSink.WriteException e) {
            throw createRendererException(e, e.format, e.isRecoverable, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean shouldUseBypass(com.google.android.exoplayer2.d dVar) {
        return this.f2475a.a(dVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.d dVar) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        if (!bp5.p(dVar.k)) {
            return RendererCapabilities.create(0);
        }
        int i = gj9.f41922a >= 21 ? 32 : 0;
        boolean z2 = true;
        boolean z3 = dVar.a0 != 0;
        boolean zSupportsFormatDrm = MediaCodecRenderer.supportsFormatDrm(dVar);
        int i2 = 8;
        if (zSupportsFormatDrm && this.f2475a.a(dVar) && (!z3 || MediaCodecUtil.w() != null)) {
            return RendererCapabilities.create(4, 8, i);
        }
        if ((!"audio/raw".equals(dVar.k) || this.f2475a.a(dVar)) && this.f2475a.a(gj9.o0(2, dVar.U, dVar.V))) {
            List<com.google.android.exoplayer2.mediacodec.c> listF0 = f0(mediaCodecSelector, dVar, false, this.f2475a);
            if (listF0.isEmpty()) {
                return RendererCapabilities.create(1);
            }
            if (!zSupportsFormatDrm) {
                return RendererCapabilities.create(2);
            }
            com.google.android.exoplayer2.mediacodec.c cVar = listF0.get(0);
            boolean zO = cVar.o(dVar);
            if (!zO) {
                int i3 = 1;
                while (true) {
                    if (i3 >= listF0.size()) {
                        z = true;
                        z2 = zO;
                        break;
                    }
                    com.google.android.exoplayer2.mediacodec.c cVar2 = listF0.get(i3);
                    if (cVar2.o(dVar)) {
                        z = false;
                        cVar = cVar2;
                        break;
                    }
                    i3++;
                }
            } else {
                z = true;
                z2 = zO;
                break;
            }
            int i4 = z2 ? 4 : 3;
            if (z2 && cVar.r(dVar)) {
                i2 = 16;
            }
            return RendererCapabilities.create(i4, i2, i, cVar.f3467d ? 64 : 0, z ? 128 : 0);
        }
        return RendererCapabilities.create(1);
    }

    public f(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
        this(context, mediaCodecSelector, handler, audioRendererEventListener, qe0.f19069a, new AudioProcessor[0]);
    }

    public f(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, qe0 qe0Var, AudioProcessor... audioProcessorArr) {
        this(context, mediaCodecSelector, handler, audioRendererEventListener, new DefaultAudioSink.c().g((qe0) com.google.common.base.e.a(qe0Var, qe0.f19069a)).i(audioProcessorArr).f());
    }

    public f(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        this(context, MediaCodecAdapter.Factory.f30761a, mediaCodecSelector, false, handler, audioRendererEventListener, audioSink);
    }

    public f(Context context, MediaCodecSelector mediaCodecSelector, boolean z, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        this(context, MediaCodecAdapter.Factory.f30761a, mediaCodecSelector, z, handler, audioRendererEventListener, audioSink);
    }

    public f(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(1, factory, mediaCodecSelector, z, 44100.0f);
        this.f30565a = context.getApplicationContext();
        this.f2475a = audioSink;
        this.f2474a = new AudioRendererEventListener.a(handler, audioRendererEventListener);
        audioSink.i(new b());
    }
}
