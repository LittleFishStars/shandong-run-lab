package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.c;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.bp5;
import com.zj.adlib.dx7;
import com.zj.adlib.fh5;
import com.zj.adlib.gj9;
import com.zj.adlib.hp9;
import com.zj.adlib.p82;
import com.zj.adlib.sb0;
import com.zj.adlib.y99;
import com.zj.adlib.yk3;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a extends MediaCodecRenderer {
    public static boolean K = false;
    public static boolean L = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f31183a = {1920, 1600, 1440, 1280, 960, 854, 640, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH};
    public static final float g = 1.5f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final String f5353g = "MediaCodecVideoRenderer";
    public static final String h = "crop-left";
    public static final String i = "crop-right";
    public static final String j = "crop-bottom";
    public static final String k = "crop-top";
    public static final long r = Long.MAX_VALUE;
    public final boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f5354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Surface f5355a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public PlaceholderSurface f5356a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public VideoFrameMetadataListener f5357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final VideoFrameReleaseHelper f5358a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final VideoRendererEventListener.a f5359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public C0705a f5360a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public b f5361a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public hp9 f5362a;
    public float f;
    public final int j0;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public final long f5363k;
    public int k0;
    public long l;
    public int l0;
    public long m;
    public int m0;
    public long n;
    public int n0;
    public long o;
    public int o0;
    public long p;
    public int p0;
    public long q;
    public int q0;
    public int r0;
    public int s0;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.video.a$a, reason: collision with other inner class name */
    public static final class C0705a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31184a;
        public final int b;
        public final int c;

        public C0705a(int i, int i2, int i3) {
            this.f31184a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    @RequiresApi(23)
    public final class b implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {
        public static final int K = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f31185a;

        public b(MediaCodecAdapter mediaCodecAdapter) {
            Handler handlerZ = gj9.z(this);
            this.f31185a = handlerZ;
            mediaCodecAdapter.a(this, handlerZ);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.OnFrameRenderedListener
        public void a(MediaCodecAdapter mediaCodecAdapter, long j, long j2) {
            if (gj9.f41922a >= 30) {
                b(j);
            } else {
                this.f31185a.sendMessageAtFrontOfQueue(Message.obtain(this.f31185a, 0, (int) (j >> 32), (int) j));
            }
        }

        public final void b(long j) {
            a aVar = a.this;
            if (this != aVar.f5361a) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                aVar.s0();
                return;
            }
            try {
                aVar.onProcessedTunneledBuffer(j);
            } catch (ExoPlaybackException e) {
                a.this.setPendingPlaybackException(e);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(gj9.D1(message.arg1, message.arg2));
            return true;
        }
    }

    public a(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
    }

    @RequiresApi(21)
    public static void d0(MediaFormat mediaFormat, int i2) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i2);
    }

    public static boolean e0() {
        return "NVIDIA".equals(gj9.b);
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1095)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public static boolean f0() {
        /*
            Method dump skipped, instruction units count: 3062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.a.f0():boolean");
    }

    public static int g0(c cVar, d dVar) {
        int iM;
        int iIntValue;
        int i2 = dVar.Q;
        int i3 = dVar.R;
        if (i2 == -1 || i3 == -1) {
            return -1;
        }
        String str = dVar.k;
        if ("video/dolby-vision".equals(str)) {
            Pair<Integer, Integer> pairR = MediaCodecUtil.r(dVar);
            str = (pairR == null || !((iIntValue = ((Integer) pairR.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? "video/hevc" : "video/avc";
        }
        str.hashCode();
        int i4 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/av01":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                iM = i2 * i3;
                i4 = 2;
                return (iM * 3) / (i4 * 2);
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                iM = i2 * i3;
                return (iM * 3) / (i4 * 2);
            case "video/avc":
                String str2 = gj9.c;
                if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(gj9.b) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && cVar.f3466c)))) {
                    return -1;
                }
                iM = gj9.m(i2, 16) * gj9.m(i3, 16) * 16 * 16;
                i4 = 2;
                return (iM * 3) / (i4 * 2);
            default:
                return -1;
        }
    }

    public static int getMaxInputSize(c cVar, d dVar) {
        if (dVar.P == -1) {
            return g0(cVar, dVar);
        }
        int size = dVar.f2569a.size();
        int length = 0;
        for (int i2 = 0; i2 < size; i2++) {
            length += dVar.f2569a.get(i2).length;
        }
        return dVar.P + length;
    }

    @Nullable
    public static Point h0(c cVar, d dVar) {
        int i2 = dVar.R;
        int i3 = dVar.Q;
        boolean z = i2 > i3;
        int i4 = z ? i2 : i3;
        if (z) {
            i2 = i3;
        }
        float f = i2 / i4;
        for (int i5 : f31183a) {
            int i6 = (int) (i5 * f);
            if (i5 <= i4 || i6 <= i2) {
                break;
            }
            if (gj9.f41922a >= 21) {
                int i7 = z ? i6 : i5;
                if (!z) {
                    i5 = i6;
                }
                Point pointB = cVar.b(i7, i5);
                if (cVar.x(pointB.x, pointB.y, dVar.f2564a)) {
                    return pointB;
                }
            } else {
                try {
                    int iM = gj9.m(i5, 16) * 16;
                    int iM2 = gj9.m(i6, 16) * 16;
                    if (iM * iM2 <= MediaCodecUtil.O()) {
                        int i8 = z ? iM2 : iM;
                        if (!z) {
                            iM = iM2;
                        }
                        return new Point(i8, iM);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    public static List<c> i0(MediaCodecSelector mediaCodecSelector, d dVar, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        String str = dVar.k;
        if (str == null) {
            return ImmutableList.of();
        }
        List<c> decoderInfos = mediaCodecSelector.getDecoderInfos(str, z, z2);
        String strN = MediaCodecUtil.n(dVar);
        if (strN == null) {
            return ImmutableList.copyOf((Collection) decoderInfos);
        }
        return ImmutableList.builder().c(decoderInfos).c(mediaCodecSelector.getDecoderInfos(strN, z, z2)).e();
    }

    public static boolean j0(long j2) {
        return j2 < -30000;
    }

    public static boolean k0(long j2) {
        return j2 < -500000;
    }

    @RequiresApi(29)
    public static void u0(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodecAdapter.setParameters(bundle);
    }

    public final void b0() {
        MediaCodecAdapter codec;
        this.G = false;
        if (gj9.f41922a < 23 || !this.J || (codec = getCodec()) == null) {
            return;
        }
        this.f5361a = new b(codec);
    }

    public final void c0() {
        this.f5362a = null;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public DecoderReuseEvaluation canReuseCodec(c cVar, d dVar, d dVar2) {
        DecoderReuseEvaluation decoderReuseEvaluationE = cVar.e(dVar, dVar2);
        int i2 = decoderReuseEvaluationE.b;
        int i3 = dVar2.Q;
        C0705a c0705a = this.f5360a;
        if (i3 > c0705a.f31184a || dVar2.R > c0705a.b) {
            i2 |= 256;
        }
        if (getMaxInputSize(cVar, dVar2) > this.f5360a.c) {
            i2 |= 64;
        }
        int i4 = i2;
        return new DecoderReuseEvaluation(cVar.f3463a, dVar, dVar2, i4 != 0 ? 0 : decoderReuseEvaluationE.f30578a, i4);
    }

    public boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (a.class) {
            if (!K) {
                L = f0();
                K = true;
            }
        }
        return L;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecDecoderException createDecoderException(Throwable th, @Nullable c cVar) {
        return new MediaCodecVideoDecoderException(th, cVar, this.f5355a);
    }

    public void dropOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i2, long j2) {
        y99.a("dropVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i2, false);
        y99.c();
        updateDroppedBufferCounters(0, 1);
    }

    public C0705a getCodecMaxValues(c cVar, d dVar, d[] dVarArr) {
        int iG0;
        int iMax = dVar.Q;
        int iMax2 = dVar.R;
        int maxInputSize = getMaxInputSize(cVar, dVar);
        if (dVarArr.length == 1) {
            if (maxInputSize != -1 && (iG0 = g0(cVar, dVar)) != -1) {
                maxInputSize = Math.min((int) (maxInputSize * 1.5f), iG0);
            }
            return new C0705a(iMax, iMax2, maxInputSize);
        }
        int length = dVarArr.length;
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            d dVarE = dVarArr[i2];
            if (dVar.f2568a != null && dVarE.f2568a == null) {
                dVarE = dVarE.b().J(dVar.f2568a).E();
            }
            if (cVar.e(dVar, dVarE).f30578a != 0) {
                int i3 = dVarE.Q;
                z |= i3 == -1 || dVarE.R == -1;
                iMax = Math.max(iMax, i3);
                iMax2 = Math.max(iMax2, dVarE.R);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(cVar, dVarE));
            }
        }
        if (z) {
            Log.n(f5353g, "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point pointH0 = h0(cVar, dVar);
            if (pointH0 != null) {
                iMax = Math.max(iMax, pointH0.x);
                iMax2 = Math.max(iMax2, pointH0.y);
                maxInputSize = Math.max(maxInputSize, g0(cVar, dVar.b().j0(iMax).Q(iMax2).E()));
                Log.n(f5353g, "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new C0705a(iMax, iMax2, maxInputSize);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean getCodecNeedsEosPropagation() {
        return this.J && gj9.f41922a < 23;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float getCodecOperatingRateV23(float f, d dVar, d[] dVarArr) {
        float fMax = -1.0f;
        for (d dVar2 : dVarArr) {
            float f2 = dVar2.f2564a;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<c> getDecoderInfos(MediaCodecSelector mediaCodecSelector, d dVar, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.v(i0(mediaCodecSelector, dVar, z, this.J), dVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(17)
    public MediaCodecAdapter.a getMediaCodecConfiguration(c cVar, d dVar, @Nullable MediaCrypto mediaCrypto, float f) {
        PlaceholderSurface placeholderSurface = this.f5356a;
        if (placeholderSurface != null && placeholderSurface.secure != cVar.f3466c) {
            t0();
        }
        String str = cVar.c;
        C0705a codecMaxValues = getCodecMaxValues(cVar, dVar, getStreamFormats());
        this.f5360a = codecMaxValues;
        MediaFormat mediaFormat = getMediaFormat(dVar, str, codecMaxValues, f, this.C, this.J ? this.s0 : 0);
        if (this.f5355a == null) {
            if (!w0(cVar)) {
                throw new IllegalStateException();
            }
            if (this.f5356a == null) {
                this.f5356a = PlaceholderSurface.newInstanceV17(this.f5354a, cVar.f3466c);
            }
            this.f5355a = this.f5356a;
        }
        return MediaCodecAdapter.a.b(cVar, mediaFormat, dVar, this.f5355a, mediaCrypto);
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    public MediaFormat getMediaFormat(d dVar, String str, C0705a c0705a, float f, boolean z, int i2) {
        Pair<Integer, Integer> pairR;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", dVar.Q);
        mediaFormat.setInteger("height", dVar.R);
        fh5.j(mediaFormat, dVar.f2569a);
        fh5.d(mediaFormat, "frame-rate", dVar.f2564a);
        fh5.e(mediaFormat, "rotation-degrees", dVar.S);
        fh5.c(mediaFormat, dVar.f2568a);
        if ("video/dolby-vision".equals(dVar.k) && (pairR = MediaCodecUtil.r(dVar)) != null) {
            fh5.e(mediaFormat, dx7.f41301a, ((Integer) pairR.first).intValue());
        }
        mediaFormat.setInteger("max-width", c0705a.f31184a);
        mediaFormat.setInteger("max-height", c0705a.b);
        fh5.e(mediaFormat, "max-input-size", c0705a.c);
        if (gj9.f41922a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i2 != 0) {
            d0(mediaFormat, i2);
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return f5353g;
    }

    public Surface getSurface() {
        return this.f5355a;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(29)
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.E) {
            ByteBuffer byteBuffer = (ByteBuffer) sb0.g(decoderInputBuffer.b);
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s == 60 && s2 == 1 && b3 == 4 && b4 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    u0(getCodec(), bArr);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i2, @Nullable Object obj) throws ExoPlaybackException {
        if (i2 == 1) {
            setOutput(obj);
            return;
        }
        if (i2 == 7) {
            this.f5357a = (VideoFrameMetadataListener) obj;
            return;
        }
        if (i2 == 10) {
            int iIntValue = ((Integer) obj).intValue();
            if (this.s0 != iIntValue) {
                this.s0 = iIntValue;
                if (this.J) {
                    releaseCodec();
                    return;
                }
                return;
            }
            return;
        }
        if (i2 != 4) {
            if (i2 != 5) {
                super.handleMessage(i2, obj);
                return;
            } else {
                this.f5358a.o(((Integer) obj).intValue());
                return;
            }
        }
        this.k0 = ((Integer) obj).intValue();
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.k0);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        PlaceholderSurface placeholderSurface;
        if (super.isReady() && (this.G || (((placeholderSurface = this.f5356a) != null && this.f5355a == placeholderSurface) || getCodec() == null || this.J))) {
            this.m = -9223372036854775807L;
            return true;
        }
        if (this.m == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.m) {
            return true;
        }
        this.m = -9223372036854775807L;
        return false;
    }

    public final void l0() {
        if (this.l0 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f5359a.n(this.l0, jElapsedRealtime - this.n);
            this.l0 = 0;
            this.n = jElapsedRealtime;
        }
    }

    public void m0() {
        this.I = true;
        if (this.G) {
            return;
        }
        this.G = true;
        this.f5359a.A(this.f5355a);
        this.F = true;
    }

    public boolean maybeDropBuffersToKeyframe(long j2, boolean z) throws ExoPlaybackException {
        int iSkipSource = skipSource(j2);
        if (iSkipSource == 0) {
            return false;
        }
        if (z) {
            p82 p82Var = ((MediaCodecRenderer) this).f3423a;
            p82Var.d += iSkipSource;
            p82Var.f += this.n0;
        } else {
            ((MediaCodecRenderer) this).f3423a.j++;
            updateDroppedBufferCounters(iSkipSource, this.n0);
        }
        flushOrReinitializeCodec();
        return true;
    }

    public final void n0() {
        int i2 = this.o0;
        if (i2 != 0) {
            this.f5359a.B(this.q, i2);
            this.q = 0L;
            this.o0 = 0;
        }
    }

    public final void o0() {
        int i2 = this.p0;
        if (i2 == -1 && this.q0 == -1) {
            return;
        }
        hp9 hp9Var = this.f5362a;
        if (hp9Var != null && hp9Var.K == i2 && hp9Var.L == this.q0 && hp9Var.M == this.r0 && hp9Var.f17051a == this.f) {
            return;
        }
        hp9 hp9Var2 = new hp9(this.p0, this.q0, this.r0, this.f);
        this.f5362a = hp9Var2;
        this.f5359a.D(hp9Var2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecError(Exception exc) {
        Log.e(f5353g, "Video codec error", exc);
        this.f5359a.C(exc);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String str, MediaCodecAdapter.a aVar, long j2, long j3) {
        this.f5359a.k(str, j2, j3);
        this.D = codecNeedsSetOutputSurfaceWorkaround(str);
        this.E = ((c) sb0.g(getCodecInfo())).p();
        if (gj9.f41922a < 23 || !this.J) {
            return;
        }
        this.f5361a = new b((MediaCodecAdapter) sb0.g(getCodec()));
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecReleased(String str) {
        this.f5359a.l(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        c0();
        b0();
        this.F = false;
        this.f5361a = null;
        try {
            super.onDisabled();
        } finally {
            this.f5359a.m(((MediaCodecRenderer) this).f3423a);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        boolean z3 = getConfiguration().f20053a;
        sb0.i((z3 && this.s0 == 0) ? false : true);
        if (this.J != z3) {
            this.J = z3;
            releaseCodec();
        }
        this.f5359a.o(((MediaCodecRenderer) this).f3423a);
        this.H = z2;
        this.I = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public DecoderReuseEvaluation onInputFormatChanged(yk3 yk3Var) throws ExoPlaybackException {
        DecoderReuseEvaluation decoderReuseEvaluationOnInputFormatChanged = super.onInputFormatChanged(yk3Var);
        this.f5359a.p(yk3Var.f46052a, decoderReuseEvaluationOnInputFormatChanged);
        return decoderReuseEvaluationOnInputFormatChanged;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(d dVar, @Nullable MediaFormat mediaFormat) {
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.k0);
        }
        if (this.J) {
            this.p0 = dVar.Q;
            this.q0 = dVar.R;
        } else {
            sb0.g(mediaFormat);
            boolean z = mediaFormat.containsKey(i) && mediaFormat.containsKey(h) && mediaFormat.containsKey(j) && mediaFormat.containsKey(k);
            this.p0 = z ? (mediaFormat.getInteger(i) - mediaFormat.getInteger(h)) + 1 : mediaFormat.getInteger("width");
            this.q0 = z ? (mediaFormat.getInteger(j) - mediaFormat.getInteger(k)) + 1 : mediaFormat.getInteger("height");
        }
        float f = dVar.f2571b;
        this.f = f;
        if (gj9.f41922a >= 21) {
            int i2 = dVar.S;
            if (i2 == 90 || i2 == 270) {
                int i3 = this.p0;
                this.p0 = this.q0;
                this.q0 = i3;
                this.f = 1.0f / f;
            }
        } else {
            this.r0 = dVar.S;
        }
        this.f5358a.g(dVar.f2564a);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j2, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j2, z);
        b0();
        this.f5358a.j();
        this.o = -9223372036854775807L;
        this.l = -9223372036854775807L;
        this.m0 = 0;
        if (z) {
            v0();
        } else {
            this.m = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void onProcessedOutputBuffer(long j2) {
        super.onProcessedOutputBuffer(j2);
        if (this.J) {
            return;
        }
        this.n0--;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        b0();
    }

    public void onProcessedTunneledBuffer(long j2) throws ExoPlaybackException {
        updateOutputFormatForTime(j2);
        o0();
        ((MediaCodecRenderer) this).f3423a.e++;
        m0();
        onProcessedOutputBuffer(j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z = this.J;
        if (!z) {
            this.n0++;
        }
        if (gj9.f41922a >= 23 || !z) {
            return;
        }
        onProcessedTunneledBuffer(decoderInputBuffer.f30576a);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    @TargetApi(17)
    public void onReset() {
        try {
            super.onReset();
        } finally {
            if (this.f5356a != null) {
                t0();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        super.onStarted();
        this.l0 = 0;
        this.n = SystemClock.elapsedRealtime();
        this.p = SystemClock.elapsedRealtime() * 1000;
        this.q = 0L;
        this.o0 = 0;
        this.f5358a.k();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        this.m = -9223372036854775807L;
        l0();
        n0();
        this.f5358a.l();
        super.onStopped();
    }

    public final void p0() {
        if (this.F) {
            this.f5359a.A(this.f5355a);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long j2, long j3, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z, boolean z2, d dVar) throws ExoPlaybackException {
        sb0.g(mediaCodecAdapter);
        if (this.l == -9223372036854775807L) {
            this.l = j2;
        }
        if (j4 != this.o) {
            this.f5358a.h(j4);
            this.o = j4;
        }
        long outputStreamOffsetUs = getOutputStreamOffsetUs();
        long j5 = j4 - outputStreamOffsetUs;
        if (z && !z2) {
            skipOutputBuffer(mediaCodecAdapter, i2, j5);
            return true;
        }
        double playbackSpeed = getPlaybackSpeed();
        boolean z3 = getState() == 2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j6 = (long) ((j4 - j2) / playbackSpeed);
        if (z3) {
            j6 -= jElapsedRealtime - j3;
        }
        if (this.f5355a == this.f5356a) {
            if (!j0(j6)) {
                return false;
            }
            skipOutputBuffer(mediaCodecAdapter, i2, j5);
            updateVideoFrameProcessingOffsetCounters(j6);
            return true;
        }
        if (this.m == -9223372036854775807L && j2 >= outputStreamOffsetUs && ((this.I ? !this.G : !(!z3 && !this.H)) || (z3 && shouldForceRenderOutputBuffer(j6, jElapsedRealtime - this.p)))) {
            long jNanoTime = System.nanoTime();
            r0(j5, jNanoTime, dVar);
            if (gj9.f41922a >= 21) {
                renderOutputBufferV21(mediaCodecAdapter, i2, j5, jNanoTime);
            } else {
                renderOutputBuffer(mediaCodecAdapter, i2, j5);
            }
            updateVideoFrameProcessingOffsetCounters(j6);
            return true;
        }
        if (z3 && j2 != this.l) {
            long jNanoTime2 = System.nanoTime();
            long jB = this.f5358a.b((j6 * 1000) + jNanoTime2);
            long j7 = (jB - jNanoTime2) / 1000;
            boolean z4 = this.m != -9223372036854775807L;
            if (shouldDropBuffersToKeyframe(j7, j3, z2) && maybeDropBuffersToKeyframe(j2, z4)) {
                return false;
            }
            if (shouldDropOutputBuffer(j7, j3, z2)) {
                if (z4) {
                    skipOutputBuffer(mediaCodecAdapter, i2, j5);
                } else {
                    dropOutputBuffer(mediaCodecAdapter, i2, j5);
                }
                updateVideoFrameProcessingOffsetCounters(j7);
                return true;
            }
            if (gj9.f41922a >= 21) {
                if (j7 < 50000) {
                    r0(j5, jB, dVar);
                    renderOutputBufferV21(mediaCodecAdapter, i2, j5, jB);
                    updateVideoFrameProcessingOffsetCounters(j7);
                    return true;
                }
            } else if (j7 < 30000) {
                if (j7 > 11000) {
                    try {
                        Thread.sleep((j7 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                r0(j5, jB, dVar);
                renderOutputBuffer(mediaCodecAdapter, i2, j5);
                updateVideoFrameProcessingOffsetCounters(j7);
                return true;
            }
        }
        return false;
    }

    public final void q0() {
        hp9 hp9Var = this.f5362a;
        if (hp9Var != null) {
            this.f5359a.D(hp9Var);
        }
    }

    public final void r0(long j2, long j3, d dVar) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.f5357a;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.b(j2, j3, dVar, getCodecOutputMediaFormat());
        }
    }

    public void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i2, long j2) {
        o0();
        y99.a("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i2, true);
        y99.c();
        this.p = SystemClock.elapsedRealtime() * 1000;
        ((MediaCodecRenderer) this).f3423a.e++;
        this.m0 = 0;
        m0();
    }

    @RequiresApi(21)
    public void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i2, long j2, long j3) {
        o0();
        y99.a("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i2, j3);
        y99.c();
        this.p = SystemClock.elapsedRealtime() * 1000;
        ((MediaCodecRenderer) this).f3423a.e++;
        this.m0 = 0;
        m0();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.n0 = 0;
    }

    public final void s0() {
        setPendingOutputEndOfStream();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.exoplayer2.video.VideoFrameReleaseHelper] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.video.a] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.google.android.exoplayer2.video.PlaceholderSurface] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setOutput(@Nullable Object obj) throws ExoPlaybackException {
        ?? NewInstanceV17;
        Surface surface;
        if (obj instanceof Surface) {
            surface = (Surface) obj;
        } else {
            NewInstanceV17 = 0;
        }
        if (NewInstanceV17 == 0) {
            PlaceholderSurface placeholderSurface = this.f5356a;
            if (placeholderSurface != null) {
                NewInstanceV17 = surface;
                NewInstanceV17 = placeholderSurface;
            } else {
                c codecInfo = getCodecInfo();
                if (codecInfo != null && w0(codecInfo)) {
                    NewInstanceV17 = surface;
                    NewInstanceV17 = PlaceholderSurface.newInstanceV17(this.f5354a, codecInfo.f3466c);
                    this.f5356a = NewInstanceV17;
                }
            }
        }
        NewInstanceV17 = surface;
        NewInstanceV17 = surface;
        NewInstanceV17 = surface;
        if (this.f5355a == NewInstanceV17) {
            if (NewInstanceV17 == 0 || NewInstanceV17 == this.f5356a) {
                return;
            }
            q0();
            p0();
            return;
        }
        this.f5355a = NewInstanceV17;
        this.f5358a.m(NewInstanceV17);
        this.F = false;
        int state = getState();
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            if (gj9.f41922a < 23 || NewInstanceV17 == 0 || this.D) {
                releaseCodec();
                maybeInitCodecOrBypass();
            } else {
                setOutputSurfaceV23(codec, NewInstanceV17);
            }
        }
        if (NewInstanceV17 == 0 || NewInstanceV17 == this.f5356a) {
            c0();
            b0();
            return;
        }
        q0();
        b0();
        if (state == 2) {
            v0();
        }
    }

    @RequiresApi(23)
    public void setOutputSurfaceV23(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        mediaCodecAdapter.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
        super.setPlaybackSpeed(f, f2);
        this.f5358a.i(f);
    }

    public boolean shouldDropBuffersToKeyframe(long j2, long j3, boolean z) {
        return k0(j2) && !z;
    }

    public boolean shouldDropOutputBuffer(long j2, long j3, boolean z) {
        return j0(j2) && !z;
    }

    public boolean shouldForceRenderOutputBuffer(long j2, long j3) {
        return j0(j2) && j3 > 100000;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean shouldInitCodec(c cVar) {
        return this.f5355a != null || w0(cVar);
    }

    public void skipOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i2, long j2) {
        y99.a("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i2, false);
        y99.c();
        ((MediaCodecRenderer) this).f3423a.f++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, d dVar) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        int i2 = 0;
        if (!bp5.t(dVar.k)) {
            return RendererCapabilities.create(0);
        }
        boolean z2 = dVar.f2566a != null;
        List<c> listI0 = i0(mediaCodecSelector, dVar, z2, false);
        if (z2 && listI0.isEmpty()) {
            listI0 = i0(mediaCodecSelector, dVar, false, false);
        }
        if (listI0.isEmpty()) {
            return RendererCapabilities.create(1);
        }
        if (!MediaCodecRenderer.supportsFormatDrm(dVar)) {
            return RendererCapabilities.create(2);
        }
        c cVar = listI0.get(0);
        boolean zO = cVar.o(dVar);
        if (!zO) {
            int i3 = 1;
            while (true) {
                if (i3 >= listI0.size()) {
                    z = true;
                    break;
                }
                c cVar2 = listI0.get(i3);
                if (cVar2.o(dVar)) {
                    z = false;
                    zO = true;
                    cVar = cVar2;
                    break;
                }
                i3++;
            }
        } else {
            z = true;
            break;
        }
        int i4 = zO ? 4 : 3;
        int i5 = cVar.r(dVar) ? 16 : 8;
        int i6 = cVar.f3467d ? 64 : 0;
        int i7 = z ? 128 : 0;
        if (zO) {
            List<c> listI1 = i0(mediaCodecSelector, dVar, z2, true);
            if (!listI1.isEmpty()) {
                c cVar3 = MediaCodecUtil.v(listI1, dVar).get(0);
                if (cVar3.o(dVar) && cVar3.r(dVar)) {
                    i2 = 32;
                }
            }
        }
        return RendererCapabilities.create(i4, i5, i2, i6, i7);
    }

    @RequiresApi(17)
    public final void t0() {
        Surface surface = this.f5355a;
        PlaceholderSurface placeholderSurface = this.f5356a;
        if (surface == placeholderSurface) {
            this.f5355a = null;
        }
        placeholderSurface.release();
        this.f5356a = null;
    }

    public void updateDroppedBufferCounters(int i2, int i3) {
        p82 p82Var = ((MediaCodecRenderer) this).f3423a;
        p82Var.h += i2;
        int i4 = i2 + i3;
        p82Var.g += i4;
        this.l0 += i4;
        int i5 = this.m0 + i4;
        this.m0 = i5;
        p82Var.i = Math.max(i5, p82Var.i);
        int i6 = this.j0;
        if (i6 <= 0 || this.l0 < i6) {
            return;
        }
        l0();
    }

    public void updateVideoFrameProcessingOffsetCounters(long j2) {
        ((MediaCodecRenderer) this).f3423a.a(j2);
        this.q += j2;
        this.o0++;
    }

    public final void v0() {
        this.m = this.f5363k > 0 ? SystemClock.elapsedRealtime() + this.f5363k : -9223372036854775807L;
    }

    public final boolean w0(c cVar) {
        return gj9.f41922a >= 23 && !this.J && !codecNeedsSetOutputSurfaceWorkaround(cVar.f3463a) && (!cVar.f3466c || PlaceholderSurface.isSecureSupported(this.f5354a));
    }

    public a(Context context, MediaCodecSelector mediaCodecSelector, long j2) {
        this(context, mediaCodecSelector, j2, null, null, 0);
    }

    public a(Context context, MediaCodecSelector mediaCodecSelector, long j2, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i2) {
        this(context, MediaCodecAdapter.Factory.f30761a, mediaCodecSelector, j2, false, handler, videoRendererEventListener, i2, 30.0f);
    }

    public a(Context context, MediaCodecSelector mediaCodecSelector, long j2, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i2) {
        this(context, MediaCodecAdapter.Factory.f30761a, mediaCodecSelector, j2, z, handler, videoRendererEventListener, i2, 30.0f);
    }

    public a(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j2, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i2) {
        this(context, factory, mediaCodecSelector, j2, z, handler, videoRendererEventListener, i2, 30.0f);
    }

    public a(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j2, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i2, float f) {
        super(2, factory, mediaCodecSelector, z, f);
        this.f5363k = j2;
        this.j0 = i2;
        Context applicationContext = context.getApplicationContext();
        this.f5354a = applicationContext;
        this.f5358a = new VideoFrameReleaseHelper(applicationContext);
        this.f5359a = new VideoRendererEventListener.a(handler, videoRendererEventListener);
        this.C = e0();
        this.m = -9223372036854775807L;
        this.p0 = -1;
        this.q0 = -1;
        this.f = -1.0f;
        this.k0 = 1;
        this.s0 = 0;
        c0();
    }
}
