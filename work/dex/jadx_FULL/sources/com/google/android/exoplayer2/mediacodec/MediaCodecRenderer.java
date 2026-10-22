package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.util.Log;
import com.ipd.dsp.internal.q.u;
import com.zj.adlib.aq6;
import com.zj.adlib.at6;
import com.zj.adlib.gj9;
import com.zj.adlib.gm3;
import com.zj.adlib.kw5;
import com.zj.adlib.p82;
import com.zj.adlib.sb0;
import com.zj.adlib.x79;
import com.zj.adlib.xs0;
import com.zj.adlib.y51;
import com.zj.adlib.y99;
import com.zj.adlib.yk3;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class MediaCodecRenderer extends BaseRenderer {
    public static final int U = 10;
    public static final int V = 0;
    public static final int W = 1;
    public static final int X = 2;
    public static final int Y = 0;
    public static final int Z = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f30763a = {0, 0, 1, 103, 66, u.n7, 11, u.A7, com.google.android.exoplayer2.text.cea.a.g, -112, 0, 0, 1, 104, u.y7, com.google.common.base.a.q, 19, 32, 0, 0, 1, 101, -120, -124, 13, u.y7, 113, com.google.common.base.a.B, -96, 0, 47, -65, com.google.common.base.a.F, com.alibaba.ariver.resource.parser.a.e.j, u.q7, com.google.android.exoplayer2.text.cea.a.i, 93, aq6.f40585a};
    public static final int a0 = 2;
    public static final int b0 = 0;
    public static final int c0 = 1;
    public static final int d0 = 2;
    public static final float e = -1.0f;
    public static final int e0 = 3;
    public static final String f = "MediaCodecRenderer";
    public static final int f0 = 0;
    public static final int g0 = 1;
    public static final int h0 = 2;
    public static final int i0 = 32;
    public static final long j = 1000;
    public boolean A;
    public boolean B;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float f3410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaCodec.BufferInfo f3411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaCrypto f3412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaFormat f3413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ExoPlaybackException f3414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.d f3415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DecoderInputBuffer f3416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DrmSession f3417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaCodecAdapter.Factory f3418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaCodecAdapter f3419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DecoderInitializationException f3420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaCodecSelector f3421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public c f3422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public p82 f3423a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final x79<com.google.android.exoplayer2.d> f3424a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xs0 f3425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public y51 f3426a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ByteBuffer f3427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ArrayDeque<c> f3428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<Long> f3429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long[] f3430a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.d f3431b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final DecoderInputBuffer f3432b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public DrmSession f3433b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long[] f3434b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.d f3435c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final DecoderInputBuffer f3436c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f3437c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final long[] f3438c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f3439d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f3440d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public long f3441e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f3442e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public long f3443f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f3444f;
    public long g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f3445g;
    public long h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f3446h;
    public long i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f3447i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f3448j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    @RequiresApi(31)
    public static final class a {
        @DoNotInline
        public static void a(MediaCodecAdapter.a aVar, at6 at6Var) {
            LogSessionId logSessionIdA = at6Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            aVar.f3406a.setString("log-session-id", logSessionIdA.getStringId());
        }
    }

    public MediaCodecRenderer(int i, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z, float f2) {
        super(i);
        this.f3418a = factory;
        this.f3421a = (MediaCodecSelector) sb0.g(mediaCodecSelector);
        this.f3437c = z;
        this.f3410a = f2;
        this.f3416a = DecoderInputBuffer.n();
        this.f3432b = new DecoderInputBuffer(0);
        this.f3436c = new DecoderInputBuffer(2);
        xs0 xs0Var = new xs0();
        this.f3425a = xs0Var;
        this.f3424a = new x79<>();
        this.f3429a = new ArrayList<>();
        this.f3411a = new MediaCodec.BufferInfo();
        this.b = 1.0f;
        this.c = 1.0f;
        this.f3439d = -9223372036854775807L;
        this.f3430a = new long[10];
        this.f3434b = new long[10];
        this.f3438c = new long[10];
        this.h = -9223372036854775807L;
        this.i = -9223372036854775807L;
        xs0Var.k(0);
        ((DecoderInputBuffer) xs0Var).f2588a.order(ByteOrder.nativeOrder());
        this.d = -1.0f;
        this.N = 0;
        this.Q = 0;
        this.O = -1;
        this.P = -1;
        this.f3441e = -9223372036854775807L;
        this.f3443f = -9223372036854775807L;
        this.g = -9223372036854775807L;
        this.R = 0;
        this.S = 0;
    }

    private boolean B() throws ExoPlaybackException {
        int i;
        if (this.f3419a == null || (i = this.R) == 2 || this.y) {
            return false;
        }
        if (i == 0 && shouldReinitCodec()) {
            x();
        }
        if (this.O < 0) {
            int iDequeueInputBufferIndex = this.f3419a.dequeueInputBufferIndex();
            this.O = iDequeueInputBufferIndex;
            if (iDequeueInputBufferIndex < 0) {
                return false;
            }
            this.f3432b.f2588a = this.f3419a.getInputBuffer(iDequeueInputBufferIndex);
            this.f3432b.b();
        }
        if (this.R == 1) {
            if (!this.o) {
                this.w = true;
                this.f3419a.queueInputBuffer(this.O, 0, 0, 0L, 4);
                R();
            }
            this.R = 2;
            return false;
        }
        if (this.m) {
            this.m = false;
            ByteBuffer byteBuffer = this.f3432b.f2588a;
            byte[] bArr = f30763a;
            byteBuffer.put(bArr);
            this.f3419a.queueInputBuffer(this.O, 0, bArr.length, 0L, 0);
            R();
            this.v = true;
            return true;
        }
        if (this.Q == 1) {
            for (int i2 = 0; i2 < this.f3435c.f2569a.size(); i2++) {
                this.f3432b.f2588a.put(this.f3435c.f2569a.get(i2));
            }
            this.Q = 2;
        }
        int iPosition = this.f3432b.f2588a.position();
        yk3 formatHolder = getFormatHolder();
        try {
            int source = readSource(formatHolder, this.f3432b, 0);
            if (hasReadStreamToEnd()) {
                this.g = this.f3443f;
            }
            if (source == -3) {
                return false;
            }
            if (source == -5) {
                if (this.Q == 2) {
                    this.f3432b.b();
                    this.Q = 1;
                }
                onInputFormatChanged(formatHolder);
                return true;
            }
            if (this.f3432b.f()) {
                if (this.Q == 2) {
                    this.f3432b.b();
                    this.Q = 1;
                }
                this.y = true;
                if (!this.v) {
                    N();
                    return false;
                }
                try {
                    if (!this.o) {
                        this.w = true;
                        this.f3419a.queueInputBuffer(this.O, 0, 0, 0L, 4);
                        R();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e2) {
                    throw createRendererException(e2, this.f3415a, gj9.f0(e2.getErrorCode()));
                }
            }
            if (!this.v && !this.f3432b.h()) {
                this.f3432b.b();
                if (this.Q == 2) {
                    this.Q = 1;
                }
                return true;
            }
            boolean zM = this.f3432b.m();
            if (zM) {
                this.f3432b.f2587a.b(iPosition);
            }
            if (this.f3444f && !zM) {
                kw5.b(this.f3432b.f2588a);
                if (this.f3432b.f2588a.position() == 0) {
                    return true;
                }
                this.f3444f = false;
            }
            DecoderInputBuffer decoderInputBuffer = this.f3432b;
            long jD = decoderInputBuffer.f30576a;
            y51 y51Var = this.f3426a;
            if (y51Var != null) {
                jD = y51Var.d(this.f3415a, decoderInputBuffer);
                this.f3443f = Math.max(this.f3443f, this.f3426a.b(this.f3415a));
            }
            long j2 = jD;
            if (this.f3432b.e()) {
                this.f3429a.add(Long.valueOf(j2));
            }
            if (this.A) {
                this.f3424a.a(j2, this.f3415a);
                this.A = false;
            }
            this.f3443f = Math.max(this.f3443f, j2);
            this.f3432b.l();
            if (this.f3432b.d()) {
                handleInputBufferSupplementalData(this.f3432b);
            }
            onQueueInputBuffer(this.f3432b);
            try {
                if (zM) {
                    this.f3419a.b(this.O, 0, this.f3432b.f2587a, j2, 0);
                } else {
                    this.f3419a.queueInputBuffer(this.O, 0, this.f3432b.f2588a.limit(), j2, 0);
                }
                R();
                this.v = true;
                this.Q = 0;
                this.f3423a.c++;
                return true;
            } catch (MediaCodec.CryptoException e3) {
                throw createRendererException(e3, this.f3415a, gj9.f0(e3.getErrorCode()));
            }
        } catch (DecoderInputBuffer.InsufficientCapacityException e4) {
            onCodecError(e4);
            P(0);
            C();
            return true;
        }
    }

    public static boolean J(IllegalStateException illegalStateException) {
        if (gj9.f41922a >= 21 && K(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    @RequiresApi(21)
    public static boolean K(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    @RequiresApi(21)
    public static boolean L(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    @TargetApi(23)
    private void N() throws ExoPlaybackException {
        int i = this.S;
        if (i == 1) {
            C();
            return;
        }
        if (i == 2) {
            C();
            Y();
        } else if (i == 3) {
            Q();
        } else {
            this.z = true;
            renderToEndOfStream();
        }
    }

    private void V(@Nullable DrmSession drmSession) {
        DrmSession.e(this.f3433b, drmSession);
        this.f3433b = drmSession;
    }

    public static boolean n(String str, com.google.android.exoplayer2.d dVar) {
        return gj9.f41922a < 21 && dVar.f2569a.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    public static boolean o(String str) {
        if (gj9.f41922a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(gj9.b)) {
            String str2 = gj9.f16787a;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    public static boolean p(String str) {
        int i = gj9.f41922a;
        if (i > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i <= 19) {
                String str2 = gj9.f16787a;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean q(String str) {
        return gj9.f41922a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    public static boolean r(c cVar) {
        String str = cVar.f3463a;
        int i = gj9.f41922a;
        return (i <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str))) || ("Amazon".equals(gj9.b) && "AFTS".equals(gj9.c) && cVar.f3466c));
    }

    public static boolean s(String str) {
        int i = gj9.f41922a;
        return i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i == 19 && gj9.c.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    public static boolean supportsFormatDrm(com.google.android.exoplayer2.d dVar) {
        int i = dVar.a0;
        return i == 0 || i == 2;
    }

    public static boolean t(String str, com.google.android.exoplayer2.d dVar) {
        return gj9.f41922a <= 18 && dVar.U == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    public static boolean u(String str) {
        return gj9.f41922a == 29 && "c2.android.aac.decoder".equals(str);
    }

    public final boolean A(c cVar, com.google.android.exoplayer2.d dVar, @Nullable DrmSession drmSession, @Nullable DrmSession drmSession2) throws ExoPlaybackException {
        gm3 gm3VarE;
        if (drmSession == drmSession2) {
            return false;
        }
        if (drmSession2 == null || drmSession == null || gj9.f41922a < 23) {
            return true;
        }
        UUID uuid = C.f2008e;
        if (uuid.equals(drmSession.getSchemeUuid()) || uuid.equals(drmSession2.getSchemeUuid()) || (gm3VarE = E(drmSession2)) == null) {
            return true;
        }
        return !cVar.f3466c && (gm3VarE.f16822a ? false : drmSession2.requiresSecureDecoder(dVar.k));
    }

    public final void C() {
        try {
            this.f3419a.flush();
        } finally {
            resetCodecStateForFlush();
        }
    }

    public final List<c> D(boolean z) throws MediaCodecUtil.DecoderQueryException {
        List<c> decoderInfos = getDecoderInfos(this.f3421a, this.f3415a, z);
        if (decoderInfos.isEmpty() && z) {
            decoderInfos = getDecoderInfos(this.f3421a, this.f3415a, false);
            if (!decoderInfos.isEmpty()) {
                Log.n(f, "Drm session requires secure decoder for " + this.f3415a.k + ", but no secure decoder available. Trying to proceed with " + decoderInfos + Consts.DOT);
            }
        }
        return decoderInfos;
    }

    @Nullable
    public final gm3 E(DrmSession drmSession) throws ExoPlaybackException {
        CryptoConfig cryptoConfigB = drmSession.b();
        if (cryptoConfigB == null || (cryptoConfigB instanceof gm3)) {
            return (gm3) cryptoConfigB;
        }
        throw createRendererException(new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + cryptoConfigB), this.f3415a, 6001);
    }

    public final boolean F() {
        return this.P >= 0;
    }

    public final void G(com.google.android.exoplayer2.d dVar) {
        v();
        String str = dVar.k;
        if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
            this.f3425a.v(32);
        } else {
            this.f3425a.v(1);
        }
        this.r = true;
    }

    public final void H(c cVar, MediaCrypto mediaCrypto) throws Exception {
        String str = cVar.f3463a;
        int i = gj9.f41922a;
        float codecOperatingRateV23 = i < 23 ? -1.0f : getCodecOperatingRateV23(this.c, this.f3415a, getStreamFormats());
        float f2 = codecOperatingRateV23 > this.f3410a ? codecOperatingRateV23 : -1.0f;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        MediaCodecAdapter.a mediaCodecConfiguration = getMediaCodecConfiguration(cVar, this.f3415a, mediaCrypto, f2);
        if (i >= 31) {
            a.a(mediaCodecConfiguration, getPlayerId());
        }
        try {
            y99.a("createCodec:" + str);
            this.f3419a = this.f3418a.a(mediaCodecConfiguration);
            y99.c();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.f3422a = cVar;
            this.d = f2;
            this.f3435c = this.f3415a;
            this.N = m(str);
            this.f3444f = n(str, this.f3435c);
            this.f3445g = s(str);
            this.f3446h = u(str);
            this.f3447i = p(str);
            this.f3448j = q(str);
            this.k = o(str);
            this.l = t(str, this.f3435c);
            this.o = r(cVar) || getCodecNeedsEosPropagation();
            if (this.f3419a.needsReconfiguration()) {
                this.u = true;
                this.Q = 1;
                this.m = this.N != 0;
            }
            if ("c2.android.mp3.decoder".equals(cVar.f3463a)) {
                this.f3426a = new y51();
            }
            if (getState() == 2) {
                this.f3441e = SystemClock.elapsedRealtime() + 1000;
            }
            this.f3423a.f43924a++;
            onCodecInitialized(str, mediaCodecConfiguration, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
        } catch (Throwable th) {
            y99.c();
            throw th;
        }
    }

    public final boolean I(long j2) {
        int size = this.f3429a.size();
        for (int i = 0; i < size; i++) {
            if (this.f3429a.get(i).longValue() == j2) {
                this.f3429a.remove(i);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x009c  */
    /* JADX WARN: Code duplicated, block: B:34:0x009f  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0049 A[SYNTHETIC] */
    public final void M(MediaCrypto mediaCrypto, boolean z) throws DecoderInitializationException {
        DecoderInitializationException decoderInitializationException;
        DecoderInitializationException decoderInitializationException2;
        if (this.f3428a == null) {
            try {
                List<c> listD = D(z);
                ArrayDeque<c> arrayDeque = new ArrayDeque<>();
                this.f3428a = arrayDeque;
                if (this.f3437c) {
                    arrayDeque.addAll(listD);
                } else if (!listD.isEmpty()) {
                    this.f3428a.add(listD.get(0));
                }
                this.f3420a = null;
            } catch (MediaCodecUtil.DecoderQueryException e2) {
                throw new DecoderInitializationException(this.f3415a, e2, z, -49998);
            }
        }
        if (this.f3428a.isEmpty()) {
            throw new DecoderInitializationException(this.f3415a, (Throwable) null, z, -49999);
        }
        c cVarPeekFirst = this.f3428a.peekFirst();
        while (this.f3419a == null) {
            c cVarPeekFirst2 = this.f3428a.peekFirst();
            if (!shouldInitCodec(cVarPeekFirst2)) {
                return;
            }
            try {
                H(cVarPeekFirst2, mediaCrypto);
            } catch (Exception e3) {
                if (cVarPeekFirst2 != cVarPeekFirst) {
                    throw e3;
                }
                try {
                    Log.n(f, "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                    Thread.sleep(50L);
                    H(cVarPeekFirst2, mediaCrypto);
                } catch (Exception e4) {
                    Log.o(f, "Failed to initialize decoder: " + cVarPeekFirst2, e4);
                    this.f3428a.removeFirst();
                    decoderInitializationException = new DecoderInitializationException(this.f3415a, e4, z, cVarPeekFirst2);
                    onCodecError(decoderInitializationException);
                    decoderInitializationException2 = this.f3420a;
                    if (decoderInitializationException2 == null) {
                        this.f3420a = decoderInitializationException;
                    } else {
                        this.f3420a = decoderInitializationException2.copyWithFallbackException(decoderInitializationException);
                    }
                    if (!this.f3428a.isEmpty()) {
                        throw this.f3420a;
                    }
                }
                Log.o(f, "Failed to initialize decoder: " + cVarPeekFirst2, e4);
                this.f3428a.removeFirst();
                decoderInitializationException = new DecoderInitializationException(this.f3415a, e4, z, cVarPeekFirst2);
                onCodecError(decoderInitializationException);
                decoderInitializationException2 = this.f3420a;
                if (decoderInitializationException2 == null) {
                    this.f3420a = decoderInitializationException;
                } else {
                    this.f3420a = decoderInitializationException2.copyWithFallbackException(decoderInitializationException);
                }
                if (!this.f3428a.isEmpty()) {
                    throw this.f3420a;
                }
            }
        }
        this.f3428a = null;
    }

    public final void O() {
        this.x = true;
        MediaFormat outputFormat = this.f3419a.getOutputFormat();
        if (this.N != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.n = true;
            return;
        }
        if (this.l) {
            outputFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT, 1);
        }
        this.f3413a = outputFormat;
        this.f3442e = true;
    }

    public final boolean P(int i) throws ExoPlaybackException {
        yk3 formatHolder = getFormatHolder();
        this.f3416a.b();
        int source = readSource(formatHolder, this.f3416a, i | 4);
        if (source == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (source != -4 || !this.f3416a.f()) {
            return false;
        }
        this.y = true;
        N();
        return false;
    }

    public final void Q() throws ExoPlaybackException {
        releaseCodec();
        maybeInitCodecOrBypass();
    }

    public final void R() {
        this.O = -1;
        this.f3432b.f2588a = null;
    }

    public final void S() {
        this.P = -1;
        this.f3427a = null;
    }

    public final void T(@Nullable DrmSession drmSession) {
        DrmSession.e(this.f3417a, drmSession);
        this.f3417a = drmSession;
    }

    public void U(long j2) {
        this.f3439d = j2;
    }

    public final boolean W(long j2) {
        return this.f3439d == -9223372036854775807L || SystemClock.elapsedRealtime() - j2 < this.f3439d;
    }

    public final boolean X(com.google.android.exoplayer2.d dVar) throws ExoPlaybackException {
        if (gj9.f41922a >= 23 && this.f3419a != null && this.S != 3 && getState() != 0) {
            float codecOperatingRateV23 = getCodecOperatingRateV23(this.c, dVar, getStreamFormats());
            float f2 = this.d;
            if (f2 == codecOperatingRateV23) {
                return true;
            }
            if (codecOperatingRateV23 == -1.0f) {
                x();
                return false;
            }
            if (f2 == -1.0f && codecOperatingRateV23 <= this.f3410a) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", codecOperatingRateV23);
            this.f3419a.setParameters(bundle);
            this.d = codecOperatingRateV23;
        }
        return true;
    }

    @RequiresApi(23)
    public final void Y() throws ExoPlaybackException {
        try {
            this.f3412a.setMediaDrmSession(E(this.f3433b).f16823a);
            T(this.f3433b);
            this.R = 0;
            this.S = 0;
        } catch (MediaCryptoException e2) {
            throw createRendererException(e2, this.f3415a, 6006);
        }
    }

    public DecoderReuseEvaluation canReuseCodec(c cVar, com.google.android.exoplayer2.d dVar, com.google.android.exoplayer2.d dVar2) {
        return new DecoderReuseEvaluation(cVar.f3463a, dVar, dVar2, 0, 1);
    }

    public MediaCodecDecoderException createDecoderException(Throwable th, @Nullable c cVar) {
        return new MediaCodecDecoderException(th, cVar);
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int e(com.google.android.exoplayer2.d dVar) throws ExoPlaybackException {
        try {
            return supportsFormat(this.f3421a, dVar);
        } catch (MediaCodecUtil.DecoderQueryException e2) {
            throw createRendererException(e2, dVar, 4002);
        }
    }

    public final boolean flushOrReinitializeCodec() throws ExoPlaybackException {
        boolean zFlushOrReleaseCodec = flushOrReleaseCodec();
        if (zFlushOrReleaseCodec) {
            maybeInitCodecOrBypass();
        }
        return zFlushOrReleaseCodec;
    }

    public boolean flushOrReleaseCodec() {
        if (this.f3419a == null) {
            return false;
        }
        int i = this.S;
        if (i == 3 || this.f3445g || ((this.f3446h && !this.x) || (this.f3447i && this.w))) {
            releaseCodec();
            return true;
        }
        if (i == 2) {
            int i2 = gj9.f41922a;
            sb0.i(i2 >= 23);
            if (i2 >= 23) {
                try {
                    Y();
                } catch (ExoPlaybackException e2) {
                    Log.o(f, "Failed to update the DRM session, releasing the codec instead.", e2);
                    releaseCodec();
                    return true;
                }
            }
        }
        C();
        return false;
    }

    @Nullable
    public final MediaCodecAdapter getCodec() {
        return this.f3419a;
    }

    @Nullable
    public final c getCodecInfo() {
        return this.f3422a;
    }

    public boolean getCodecNeedsEosPropagation() {
        return false;
    }

    public float getCodecOperatingRate() {
        return this.d;
    }

    public float getCodecOperatingRateV23(float f2, com.google.android.exoplayer2.d dVar, com.google.android.exoplayer2.d[] dVarArr) {
        return -1.0f;
    }

    @Nullable
    public final MediaFormat getCodecOutputMediaFormat() {
        return this.f3413a;
    }

    public abstract List<c> getDecoderInfos(MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.d dVar, boolean z) throws MediaCodecUtil.DecoderQueryException;

    public abstract MediaCodecAdapter.a getMediaCodecConfiguration(c cVar, com.google.android.exoplayer2.d dVar, @Nullable MediaCrypto mediaCrypto, float f2);

    public final long getOutputStreamOffsetUs() {
        return this.i;
    }

    public float getPlaybackSpeed() {
        return this.b;
    }

    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.z;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.f3415a != null && (isSourceReady() || F() || (this.f3441e != -9223372036854775807L && SystemClock.elapsedRealtime() < this.f3441e));
    }

    public final void k() throws ExoPlaybackException {
        sb0.i(!this.y);
        yk3 formatHolder = getFormatHolder();
        this.f3436c.b();
        do {
            this.f3436c.b();
            int source = readSource(formatHolder, this.f3436c, 0);
            if (source == -5) {
                onInputFormatChanged(formatHolder);
                return;
            }
            if (source != -4) {
                if (source != -3) {
                    throw new IllegalStateException();
                }
                return;
            } else {
                if (this.f3436c.f()) {
                    this.y = true;
                    return;
                }
                if (this.A) {
                    com.google.android.exoplayer2.d dVar = (com.google.android.exoplayer2.d) sb0.g(this.f3415a);
                    this.f3431b = dVar;
                    onOutputFormatChanged(dVar, null);
                    this.A = false;
                }
                this.f3436c.l();
            }
        } while (this.f3425a.p(this.f3436c));
        this.s = true;
    }

    public final boolean l(long j2, long j3) throws ExoPlaybackException {
        boolean z;
        sb0.i(!this.z);
        if (this.f3425a.u()) {
            xs0 xs0Var = this.f3425a;
            if (!processOutputBuffer(j2, j3, null, ((DecoderInputBuffer) xs0Var).f2588a, this.P, 0, xs0Var.t(), this.f3425a.r(), this.f3425a.e(), this.f3425a.f(), this.f3431b)) {
                return false;
            }
            onProcessedOutputBuffer(this.f3425a.s());
            this.f3425a.b();
            z = false;
        } else {
            z = false;
        }
        if (this.y) {
            this.z = true;
            return z;
        }
        if (this.s) {
            sb0.i(this.f3425a.p(this.f3436c));
            this.s = z;
        }
        if (this.t) {
            if (this.f3425a.u()) {
                return true;
            }
            v();
            this.t = z;
            maybeInitCodecOrBypass();
            if (!this.r) {
                return z;
            }
        }
        k();
        if (this.f3425a.u()) {
            this.f3425a.l();
        }
        if (this.f3425a.u() || this.y || this.t) {
            return true;
        }
        return z;
    }

    public final int m(String str) {
        int i = gj9.f41922a;
        if (i <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = gj9.c;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = gj9.f16787a;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    public final void maybeInitCodecOrBypass() throws ExoPlaybackException {
        com.google.android.exoplayer2.d dVar;
        if (this.f3419a != null || this.r || (dVar = this.f3415a) == null) {
            return;
        }
        if (this.f3433b == null && shouldUseBypass(dVar)) {
            G(this.f3415a);
            return;
        }
        T(this.f3433b);
        String str = this.f3415a.k;
        DrmSession drmSession = this.f3417a;
        if (drmSession != null) {
            if (this.f3412a == null) {
                gm3 gm3VarE = E(drmSession);
                if (gm3VarE != null) {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(gm3VarE.f41937a, gm3VarE.f16823a);
                        this.f3412a = mediaCrypto;
                        this.f3440d = !gm3VarE.f16822a && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e2) {
                        throw createRendererException(e2, this.f3415a, 6006);
                    }
                } else if (this.f3417a.c() == null) {
                    return;
                }
            }
            if (gm3.b) {
                int state = this.f3417a.getState();
                if (state == 1) {
                    DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) sb0.g(this.f3417a.c());
                    throw createRendererException(drmSessionException, this.f3415a, drmSessionException.errorCode);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            M(this.f3412a, this.f3440d);
        } catch (DecoderInitializationException e3) {
            throw createRendererException(e3, this.f3415a, 4001);
        }
    }

    public void onCodecError(Exception exc) {
    }

    public void onCodecInitialized(String str, MediaCodecAdapter.a aVar, long j2, long j3) {
    }

    public void onCodecReleased(String str) {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.f3415a = null;
        this.h = -9223372036854775807L;
        this.i = -9223372036854775807L;
        this.T = 0;
        flushOrReleaseCodec();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        this.f3423a = new p82();
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ce  */
    @Nullable
    @CallSuper
    public DecoderReuseEvaluation onInputFormatChanged(yk3 yk3Var) throws ExoPlaybackException {
        int i;
        boolean z = true;
        this.A = true;
        com.google.android.exoplayer2.d dVar = (com.google.android.exoplayer2.d) sb0.g(yk3Var.f46052a);
        if (dVar.k == null) {
            throw createRendererException(new IllegalArgumentException(), dVar, 4005);
        }
        V(yk3Var.f20874a);
        this.f3415a = dVar;
        if (this.r) {
            this.t = true;
            return null;
        }
        MediaCodecAdapter mediaCodecAdapter = this.f3419a;
        if (mediaCodecAdapter == null) {
            this.f3428a = null;
            maybeInitCodecOrBypass();
            return null;
        }
        c cVar = this.f3422a;
        com.google.android.exoplayer2.d dVar2 = this.f3435c;
        if (A(cVar, dVar, this.f3417a, this.f3433b)) {
            x();
            return new DecoderReuseEvaluation(cVar.f3463a, dVar2, dVar, 0, 128);
        }
        boolean z2 = this.f3433b != this.f3417a;
        sb0.i(!z2 || gj9.f41922a >= 23);
        DecoderReuseEvaluation decoderReuseEvaluationCanReuseCodec = canReuseCodec(cVar, dVar2, dVar);
        int i2 = decoderReuseEvaluationCanReuseCodec.f30578a;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException();
                    }
                    if (X(dVar)) {
                        this.f3435c = dVar;
                        if (z2 && !y()) {
                            i = 2;
                        }
                    } else {
                        i = 16;
                    }
                } else if (X(dVar)) {
                    this.u = true;
                    this.Q = 1;
                    int i3 = this.N;
                    if (i3 != 2 && (i3 != 1 || dVar.Q != dVar2.Q || dVar.R != dVar2.R)) {
                        z = false;
                    }
                    this.m = z;
                    this.f3435c = dVar;
                    if (z2 && !y()) {
                        i = 2;
                    }
                } else {
                    i = 16;
                }
            } else if (X(dVar)) {
                this.f3435c = dVar;
                if (!z2 ? !w() : !y()) {
                    i = 2;
                }
            } else {
                i = 16;
            }
            return (decoderReuseEvaluationCanReuseCodec.f30578a != 0 || (this.f3419a == mediaCodecAdapter && this.S != 3)) ? decoderReuseEvaluationCanReuseCodec : new DecoderReuseEvaluation(cVar.f3463a, dVar2, dVar, 0, i);
        }
        x();
        i = 0;
        if (decoderReuseEvaluationCanReuseCodec.f30578a != 0) {
        }
    }

    public void onOutputFormatChanged(com.google.android.exoplayer2.d dVar, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j2, boolean z) throws ExoPlaybackException {
        this.y = false;
        this.z = false;
        this.B = false;
        if (this.r) {
            this.f3425a.b();
            this.f3436c.b();
            this.s = false;
        } else {
            flushOrReinitializeCodec();
        }
        if (this.f3424a.l() > 0) {
            this.A = true;
        }
        this.f3424a.c();
        int i = this.T;
        if (i != 0) {
            this.i = this.f3434b[i - 1];
            this.h = this.f3430a[i - 1];
            this.T = 0;
        }
    }

    @CallSuper
    public void onProcessedOutputBuffer(long j2) {
        while (true) {
            int i = this.T;
            if (i == 0 || j2 < this.f3438c[0]) {
                return;
            }
            long[] jArr = this.f3430a;
            this.h = jArr[0];
            this.i = this.f3434b[0];
            int i2 = i - 1;
            this.T = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.f3434b;
            System.arraycopy(jArr2, 1, jArr2, 0, this.T);
            long[] jArr3 = this.f3438c;
            System.arraycopy(jArr3, 1, jArr3, 0, this.T);
            onProcessedStreamChange();
        }
    }

    public void onProcessedStreamChange() {
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onReset() {
        try {
            v();
            releaseCodec();
        } finally {
            V(null);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(com.google.android.exoplayer2.d[] dVarArr, long j2, long j3) throws ExoPlaybackException {
        if (this.i == -9223372036854775807L) {
            sb0.i(this.h == -9223372036854775807L);
            this.h = j2;
            this.i = j3;
            return;
        }
        int i = this.T;
        if (i == this.f3434b.length) {
            Log.n(f, "Too many stream changes, so dropping offset: " + this.f3434b[this.T - 1]);
        } else {
            this.T = i + 1;
        }
        long[] jArr = this.f3430a;
        int i2 = this.T;
        jArr[i2 - 1] = j2;
        this.f3434b[i2 - 1] = j3;
        this.f3438c[i2 - 1] = this.f3443f;
    }

    public abstract boolean processOutputBuffer(long j2, long j3, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j4, boolean z, boolean z2, com.google.android.exoplayer2.d dVar) throws ExoPlaybackException;

    /* JADX WARN: Multi-variable type inference failed */
    public void releaseCodec() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.f3419a;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
                this.f3423a.b++;
                onCodecReleased(this.f3422a.f3463a);
            }
            this.f3419a = null;
            try {
                MediaCrypto mediaCrypto = this.f3412a;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
                this.f3412a = null;
                T(null);
                resetCodecStateForRelease();
            }
        } catch (Throwable th) {
            this.f3419a = null;
            try {
                MediaCrypto mediaCrypto2 = this.f3412a;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
                this.f3412a = null;
                T(null);
                resetCodecStateForRelease();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j2, long j3) throws ExoPlaybackException {
        boolean z = false;
        if (this.B) {
            this.B = false;
            N();
        }
        ExoPlaybackException exoPlaybackException = this.f3414a;
        if (exoPlaybackException != null) {
            this.f3414a = null;
            throw exoPlaybackException;
        }
        try {
            if (this.z) {
                renderToEndOfStream();
                return;
            }
            if (this.f3415a != null || P(2)) {
                maybeInitCodecOrBypass();
                if (this.r) {
                    y99.a("bypassRender");
                    while (l(j2, j3)) {
                    }
                    y99.c();
                } else if (this.f3419a != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    y99.a("drainAndFeed");
                    while (z(j2, j3) && W(jElapsedRealtime)) {
                    }
                    while (B() && W(jElapsedRealtime)) {
                    }
                    y99.c();
                } else {
                    this.f3423a.d += skipSource(j2);
                    P(1);
                }
                this.f3423a.c();
            }
        } catch (IllegalStateException e2) {
            if (!J(e2)) {
                throw e2;
            }
            onCodecError(e2);
            if (gj9.f41922a >= 21 && L(e2)) {
                z = true;
            }
            if (z) {
                releaseCodec();
            }
            throw createRendererException(createDecoderException(e2, getCodecInfo()), this.f3415a, z, 4003);
        }
    }

    public void renderToEndOfStream() throws ExoPlaybackException {
    }

    @CallSuper
    public void resetCodecStateForFlush() {
        R();
        S();
        this.f3441e = -9223372036854775807L;
        this.w = false;
        this.v = false;
        this.m = false;
        this.n = false;
        this.p = false;
        this.q = false;
        this.f3429a.clear();
        this.f3443f = -9223372036854775807L;
        this.g = -9223372036854775807L;
        y51 y51Var = this.f3426a;
        if (y51Var != null) {
            y51Var.c();
        }
        this.R = 0;
        this.S = 0;
        this.Q = this.u ? 1 : 0;
    }

    @CallSuper
    public void resetCodecStateForRelease() {
        resetCodecStateForFlush();
        this.f3414a = null;
        this.f3426a = null;
        this.f3428a = null;
        this.f3422a = null;
        this.f3435c = null;
        this.f3413a = null;
        this.f3442e = false;
        this.x = false;
        this.d = -1.0f;
        this.N = 0;
        this.f3444f = false;
        this.f3445g = false;
        this.f3446h = false;
        this.f3447i = false;
        this.f3448j = false;
        this.k = false;
        this.l = false;
        this.o = false;
        this.u = false;
        this.Q = 0;
        this.f3440d = false;
    }

    public final void setPendingOutputEndOfStream() {
        this.B = true;
    }

    public final void setPendingPlaybackException(ExoPlaybackException exoPlaybackException) {
        this.f3414a = exoPlaybackException;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void setPlaybackSpeed(float f2, float f3) throws ExoPlaybackException {
        this.b = f2;
        this.c = f3;
        X(this.f3435c);
    }

    public boolean shouldInitCodec(c cVar) {
        return true;
    }

    public boolean shouldReinitCodec() {
        return false;
    }

    public boolean shouldUseBypass(com.google.android.exoplayer2.d dVar) {
        return false;
    }

    public abstract int supportsFormat(MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.d dVar) throws MediaCodecUtil.DecoderQueryException;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.RendererCapabilities
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public final boolean updateCodecOperatingRate() throws ExoPlaybackException {
        return X(this.f3435c);
    }

    public final void updateOutputFormatForTime(long j2) throws ExoPlaybackException {
        boolean z;
        com.google.android.exoplayer2.d dVarJ = this.f3424a.j(j2);
        if (dVarJ == null && this.f3442e) {
            dVarJ = this.f3424a.i();
        }
        if (dVarJ != null) {
            this.f3431b = dVarJ;
            z = true;
        } else {
            z = false;
        }
        if (z || (this.f3442e && this.f3431b != null)) {
            onOutputFormatChanged(this.f3431b, this.f3413a);
            this.f3442e = false;
        }
    }

    public final void v() {
        this.t = false;
        this.f3425a.b();
        this.f3436c.b();
        this.s = false;
        this.r = false;
    }

    public final boolean w() {
        if (this.v) {
            this.R = 1;
            if (this.f3445g || this.f3447i) {
                this.S = 3;
                return false;
            }
            this.S = 1;
        }
        return true;
    }

    public final void x() throws ExoPlaybackException {
        if (!this.v) {
            Q();
        } else {
            this.R = 1;
            this.S = 3;
        }
    }

    @TargetApi(23)
    public final boolean y() throws ExoPlaybackException {
        if (this.v) {
            this.R = 1;
            if (this.f3445g || this.f3447i) {
                this.S = 3;
                return false;
            }
            this.S = 2;
        } else {
            Y();
        }
        return true;
    }

    public final boolean z(long j2, long j3) throws ExoPlaybackException {
        boolean z;
        boolean zProcessOutputBuffer;
        int iDequeueOutputBufferIndex;
        if (!F()) {
            if (this.f3448j && this.w) {
                try {
                    iDequeueOutputBufferIndex = this.f3419a.dequeueOutputBufferIndex(this.f3411a);
                } catch (IllegalStateException unused) {
                    N();
                    if (this.z) {
                        releaseCodec();
                    }
                    return false;
                }
            } else {
                iDequeueOutputBufferIndex = this.f3419a.dequeueOutputBufferIndex(this.f3411a);
            }
            if (iDequeueOutputBufferIndex < 0) {
                if (iDequeueOutputBufferIndex == -2) {
                    O();
                    return true;
                }
                if (this.o && (this.y || this.R == 2)) {
                    N();
                }
                return false;
            }
            if (this.n) {
                this.n = false;
                this.f3419a.releaseOutputBuffer(iDequeueOutputBufferIndex, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.f3411a;
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                N();
                return false;
            }
            this.P = iDequeueOutputBufferIndex;
            ByteBuffer outputBuffer = this.f3419a.getOutputBuffer(iDequeueOutputBufferIndex);
            this.f3427a = outputBuffer;
            if (outputBuffer != null) {
                outputBuffer.position(this.f3411a.offset);
                ByteBuffer byteBuffer = this.f3427a;
                MediaCodec.BufferInfo bufferInfo2 = this.f3411a;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            if (this.k) {
                MediaCodec.BufferInfo bufferInfo3 = this.f3411a;
                if (bufferInfo3.presentationTimeUs == 0 && (bufferInfo3.flags & 4) != 0) {
                    long j4 = this.f3443f;
                    if (j4 != -9223372036854775807L) {
                        bufferInfo3.presentationTimeUs = j4;
                    }
                }
            }
            this.p = I(this.f3411a.presentationTimeUs);
            long j5 = this.g;
            long j6 = this.f3411a.presentationTimeUs;
            this.q = j5 == j6;
            updateOutputFormatForTime(j6);
        }
        if (this.f3448j && this.w) {
            try {
                MediaCodecAdapter mediaCodecAdapter = this.f3419a;
                ByteBuffer byteBuffer2 = this.f3427a;
                int i = this.P;
                MediaCodec.BufferInfo bufferInfo4 = this.f3411a;
                z = false;
                try {
                    zProcessOutputBuffer = processOutputBuffer(j2, j3, mediaCodecAdapter, byteBuffer2, i, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.p, this.q, this.f3431b);
                } catch (IllegalStateException unused2) {
                    N();
                    if (this.z) {
                        releaseCodec();
                    }
                    return z;
                }
            } catch (IllegalStateException unused3) {
                z = false;
            }
        } else {
            z = false;
            MediaCodecAdapter mediaCodecAdapter2 = this.f3419a;
            ByteBuffer byteBuffer3 = this.f3427a;
            int i2 = this.P;
            MediaCodec.BufferInfo bufferInfo5 = this.f3411a;
            zProcessOutputBuffer = processOutputBuffer(j2, j3, mediaCodecAdapter2, byteBuffer3, i2, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.p, this.q, this.f3431b);
        }
        if (zProcessOutputBuffer) {
            onProcessedOutputBuffer(this.f3411a.presentationTimeUs);
            boolean z2 = (this.f3411a.flags & 4) != 0 ? true : z;
            S();
            if (!z2) {
                return true;
            }
            N();
        }
        return z;
    }

    public static class DecoderInitializationException extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;

        @Nullable
        public final c codecInfo;

        @Nullable
        public final String diagnosticInfo;

        @Nullable
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(com.google.android.exoplayer2.d dVar, @Nullable Throwable th, boolean z, int i) {
            this("Decoder init failed: [" + i + "], " + dVar, th, dVar.k, z, null, buildCustomDiagnosticInfo(i), null);
        }

        private static String buildCustomDiagnosticInfo(int i) {
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @CheckResult
        public DecoderInitializationException copyWithFallbackException(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, decoderInitializationException);
        }

        @Nullable
        @RequiresApi(21)
        private static String getDiagnosticInfoV21(@Nullable Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        public DecoderInitializationException(com.google.android.exoplayer2.d dVar, @Nullable Throwable th, boolean z, c cVar) {
            this("Decoder init failed: " + cVar.f3463a + ", " + dVar, th, dVar.k, z, cVar, gj9.f41922a >= 21 ? getDiagnosticInfoV21(th) : null, null);
        }

        private DecoderInitializationException(String str, @Nullable Throwable th, String str2, boolean z, @Nullable c cVar, @Nullable String str3, @Nullable DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z;
            this.codecInfo = cVar;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }
    }
}
