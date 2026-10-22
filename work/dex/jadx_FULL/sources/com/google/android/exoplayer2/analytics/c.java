package com.google.android.exoplayer2.analytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.zj.adlib.ab3;
import com.zj.adlib.az4;
import com.zj.adlib.c49;
import com.zj.adlib.gj9;
import com.zj.adlib.gk5;
import com.zj.adlib.hp9;
import com.zj.adlib.oh5;
import com.zj.adlib.p82;
import com.zj.adlib.sb0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(31)
public final class c implements AnalyticsListener, PlaybackSessionManager.Listener {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2295a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public PlaybackMetrics.Builder f2296a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PlaybackSession f2297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public PlaybackException f2298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PlaybackSessionManager f2301a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public b f2302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.d f2303a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public String f2304a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2306a;

    @Nullable
    public b b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.d f2307b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2309b;

    @Nullable
    public b c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.d f2310c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2311c;
    public int k0;
    public int n0;
    public int o0;
    public int p0;
    public int q0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.d f2300a = new Timeline.d();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.b f2299a = new Timeline.b();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final HashMap<String, Long> f2308b = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<String, Long> f2305a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30522a = SystemClock.elapsedRealtime();
    public int l0 = 0;
    public int m0 = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30523a;
        public final int b;

        public a(int i, int i2) {
            this.f30523a = i;
            this.b = i2;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30524a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final com.google.android.exoplayer2.d f2312a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f2313a;

        public b(com.google.android.exoplayer2.d dVar, int i, String str) {
            this.f2312a = dVar;
            this.f30524a = i;
            this.f2313a = str;
        }
    }

    public c(Context context, PlaybackSession playbackSession) {
        this.f2295a = context.getApplicationContext();
        this.f2297a = playbackSession;
        com.google.android.exoplayer2.analytics.b bVar = new com.google.android.exoplayer2.analytics.b();
        this.f2301a = bVar;
        bVar.b(this);
    }

    @Nullable
    public static c H0(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new c(context, mediaMetricsManager.createPlaybackSession());
    }

    @SuppressLint({"SwitchIntDef"})
    public static int J0(int i) {
        switch (gj9.f0(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    @Nullable
    public static DrmInitData K0(ImmutableList<p.a> immutableList) {
        DrmInitData drmInitData;
        UnmodifiableIterator<p.a> it = immutableList.iterator();
        while (it.hasNext()) {
            p.a next = it.next();
            for (int i = 0; i < next.K; i++) {
                if (next.i(i) && (drmInitData = next.c(i).f2566a) != null) {
                    return drmInitData;
                }
            }
        }
        return null;
    }

    public static int L0(DrmInitData drmInitData) {
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            UUID uuid = drmInitData.get(i).uuid;
            if (uuid.equals(C.f2005d)) {
                return 3;
            }
            if (uuid.equals(C.f2008e)) {
                return 2;
            }
            if (uuid.equals(C.f2002c)) {
                return 6;
            }
        }
        return 1;
    }

    public static a M0(PlaybackException playbackException, Context context, boolean z) {
        int i;
        boolean z2;
        if (playbackException.errorCode == 1001) {
            return new a(20, 0);
        }
        if (playbackException instanceof ExoPlaybackException) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
            z2 = exoPlaybackException.type == 1;
            i = exoPlaybackException.rendererFormatSupport;
        } else {
            i = 0;
            z2 = false;
        }
        Throwable th = (Throwable) sb0.g(playbackException.getCause());
        if (!(th instanceof IOException)) {
            if (z2 && (i == 0 || i == 1)) {
                return new a(35, 0);
            }
            if (z2 && i == 3) {
                return new a(15, 0);
            }
            if (z2 && i == 2) {
                return new a(23, 0);
            }
            if (th instanceof MediaCodecRenderer.DecoderInitializationException) {
                return new a(13, gj9.g0(((MediaCodecRenderer.DecoderInitializationException) th).diagnosticInfo));
            }
            if (th instanceof MediaCodecDecoderException) {
                return new a(14, gj9.g0(((MediaCodecDecoderException) th).diagnosticInfo));
            }
            if (th instanceof OutOfMemoryError) {
                return new a(14, 0);
            }
            if (th instanceof AudioSink.InitializationException) {
                return new a(17, ((AudioSink.InitializationException) th).audioTrackState);
            }
            if (th instanceof AudioSink.WriteException) {
                return new a(18, ((AudioSink.WriteException) th).errorCode);
            }
            if (gj9.f41922a < 16 || !(th instanceof MediaCodec.CryptoException)) {
                return new a(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th).getErrorCode();
            return new a(J0(errorCode), errorCode);
        }
        if (th instanceof HttpDataSource.InvalidResponseCodeException) {
            return new a(5, ((HttpDataSource.InvalidResponseCodeException) th).responseCode);
        }
        if ((th instanceof HttpDataSource.InvalidContentTypeException) || (th instanceof ParserException)) {
            return new a(z ? 10 : 11, 0);
        }
        if ((th instanceof HttpDataSource.HttpDataSourceException) || (th instanceof UdpDataSource.UdpDataSourceException)) {
            if (NetworkTypeObserver.d(context).f() == 1) {
                return new a(3, 0);
            }
            Throwable cause = th.getCause();
            if (cause instanceof UnknownHostException) {
                return new a(6, 0);
            }
            if (cause instanceof SocketTimeoutException) {
                return new a(7, 0);
            }
            return ((th instanceof HttpDataSource.HttpDataSourceException) && ((HttpDataSource.HttpDataSourceException) th).type == 1) ? new a(4, 0) : new a(8, 0);
        }
        if (playbackException.errorCode == 1002) {
            return new a(21, 0);
        }
        if (!(th instanceof DrmSession.DrmSessionException)) {
            if (!(th instanceof FileDataSource.FileDataSourceException) || !(th.getCause() instanceof FileNotFoundException)) {
                return new a(9, 0);
            }
            Throwable cause2 = ((Throwable) sb0.g(th.getCause())).getCause();
            return (gj9.f41922a >= 21 && (cause2 instanceof ErrnoException) && ((ErrnoException) cause2).errno == OsConstants.EACCES) ? new a(32, 0) : new a(31, 0);
        }
        Throwable th2 = (Throwable) sb0.g(th.getCause());
        int i2 = gj9.f41922a;
        if (i2 >= 21 && (th2 instanceof MediaDrm.MediaDrmStateException)) {
            int iG0 = gj9.g0(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo());
            return new a(J0(iG0), iG0);
        }
        if (i2 >= 23 && (th2 instanceof MediaDrmResetException)) {
            return new a(27, 0);
        }
        if (i2 >= 18 && (th2 instanceof NotProvisionedException)) {
            return new a(24, 0);
        }
        if (i2 >= 18 && (th2 instanceof DeniedByServerException)) {
            return new a(29, 0);
        }
        if (th2 instanceof UnsupportedDrmException) {
            return new a(23, 0);
        }
        return th2 instanceof DefaultDrmSessionManager.MissingSchemeDataException ? new a(28, 0) : new a(30, 0);
    }

    public static Pair<String, String> N0(String str) {
        String[] strArrU1 = gj9.u1(str, c49.f40900a);
        return Pair.create(strArrU1[0], strArrU1.length >= 2 ? strArrU1[1] : null);
    }

    public static int P0(Context context) {
        switch (NetworkTypeObserver.d(context).f()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
            case 8:
            default:
                return 1;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
        }
    }

    public static int Q0(g gVar) {
        g.h hVar = gVar.f3327a;
        if (hVar == null) {
            return 0;
        }
        int iF0 = gj9.F0(hVar.f30751a, hVar.f3371a);
        if (iF0 == 0) {
            return 3;
        }
        if (iF0 != 1) {
            return iF0 != 2 ? 1 : 4;
        }
        return 5;
    }

    public static int R0(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 1 : 4;
        }
        return 3;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void A(AnalyticsListener.a aVar, PlaybackException playbackException) {
        this.f2298a = playbackException;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void B(AnalyticsListener.a aVar, String str) {
        MediaSource.a aVar2 = aVar.f2226a;
        if (aVar2 == null || !aVar2.c()) {
            I0();
            this.f2304a = str;
            this.f2296a = new PlaybackMetrics.Builder().setPlayerName("ExoPlayerLib").setPlayerVersion(ab3.b);
            a1(aVar.f2225a, aVar.f2226a);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void F(AnalyticsListener.a aVar, oh5 oh5Var) {
        if (aVar.f2226a == null) {
            return;
        }
        b bVar = new b((com.google.android.exoplayer2.d) sb0.g(oh5Var.f18632a), oh5Var.c, this.f2301a.e(aVar.f2225a, (MediaSource.a) sb0.g(aVar.f2226a)));
        int i = oh5Var.b;
        if (i != 0) {
            if (i == 1) {
                this.b = bVar;
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.c = bVar;
                return;
            }
        }
        this.f2302a = bVar;
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    public final boolean G0(@Nullable b bVar) {
        return bVar != null && bVar.f2313a.equals(this.f2301a.getActiveSessionId());
    }

    public final void I0() {
        PlaybackMetrics.Builder builder = this.f2296a;
        if (builder != null && this.f2311c) {
            builder.setAudioUnderrunCount(this.q0);
            this.f2296a.setVideoFramesDropped(this.o0);
            this.f2296a.setVideoFramesPlayed(this.p0);
            Long l = this.f2305a.get(this.f2304a);
            this.f2296a.setNetworkTransferDurationMillis(l == null ? 0L : l.longValue());
            Long l2 = this.f2308b.get(this.f2304a);
            this.f2296a.setNetworkBytesRead(l2 == null ? 0L : l2.longValue());
            this.f2296a.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            this.f2297a.reportPlaybackMetrics(this.f2296a.build());
        }
        this.f2296a = null;
        this.f2304a = null;
        this.q0 = 0;
        this.o0 = 0;
        this.p0 = 0;
        this.f2303a = null;
        this.f2307b = null;
        this.f2310c = null;
        this.f2311c = false;
    }

    public LogSessionId O0() {
        return this.f2297a.getSessionId();
    }

    public final void S0(AnalyticsListener.b bVar) {
        for (int i = 0; i < bVar.e(); i++) {
            int iC = bVar.c(i);
            AnalyticsListener.a aVarD = bVar.d(iC);
            if (iC == 0) {
                this.f2301a.f(aVarD);
            } else if (iC == 11) {
                this.f2301a.d(aVarD, this.k0);
            } else {
                this.f2301a.c(aVarD);
            }
        }
    }

    public final void T0(long j) {
        int iP0 = P0(this.f2295a);
        if (iP0 != this.m0) {
            this.m0 = iP0;
            this.f2297a.reportNetworkEvent(new NetworkEvent.Builder().setNetworkType(iP0).setTimeSinceCreatedMillis(j - this.f30522a).build());
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void U(AnalyticsListener.a aVar, p82 p82Var) {
        this.o0 += p82Var.g;
        this.p0 += p82Var.e;
    }

    public final void U0(long j) {
        PlaybackException playbackException = this.f2298a;
        if (playbackException == null) {
            return;
        }
        a aVarM0 = M0(playbackException, this.f2295a, this.n0 == 4);
        this.f2297a.reportPlaybackErrorEvent(new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(j - this.f30522a).setErrorCode(aVarM0.f30523a).setSubErrorCode(aVarM0.b).setException(playbackException).build());
        this.f2311c = true;
        this.f2298a = null;
    }

    public final void V0(Player player, AnalyticsListener.b bVar, long j) {
        if (player.getPlaybackState() != 2) {
            this.f2306a = false;
        }
        if (player.f() == null) {
            this.f2309b = false;
        } else if (bVar.a(10)) {
            this.f2309b = true;
        }
        int iD1 = d1(player);
        if (this.l0 != iD1) {
            this.l0 = iD1;
            this.f2311c = true;
            this.f2297a.reportPlaybackStateEvent(new PlaybackStateEvent.Builder().setState(this.l0).setTimeSinceCreatedMillis(j - this.f30522a).build());
        }
    }

    public final void W0(Player player, AnalyticsListener.b bVar, long j) {
        if (bVar.a(2)) {
            p pVarS = player.s();
            boolean zE = pVarS.e(2);
            boolean zE2 = pVarS.e(1);
            boolean zE3 = pVarS.e(3);
            if (zE || zE2 || zE3) {
                if (!zE) {
                    b1(j, null, 0);
                }
                if (!zE2) {
                    X0(j, null, 0);
                }
                if (!zE3) {
                    Z0(j, null, 0);
                }
            }
        }
        if (G0(this.f2302a)) {
            b bVar2 = this.f2302a;
            com.google.android.exoplayer2.d dVar = bVar2.f2312a;
            if (dVar.R != -1) {
                b1(j, dVar, bVar2.f30524a);
                this.f2302a = null;
            }
        }
        if (G0(this.b)) {
            b bVar3 = this.b;
            X0(j, bVar3.f2312a, bVar3.f30524a);
            this.b = null;
        }
        if (G0(this.c)) {
            b bVar4 = this.c;
            Z0(j, bVar4.f2312a, bVar4.f30524a);
            this.c = null;
        }
    }

    public final void X0(long j, @Nullable com.google.android.exoplayer2.d dVar, int i) {
        if (gj9.c(this.f2307b, dVar)) {
            return;
        }
        if (this.f2307b == null && i == 0) {
            i = 1;
        }
        this.f2307b = dVar;
        c1(0, j, dVar, i);
    }

    public final void Y0(Player player, AnalyticsListener.b bVar) {
        DrmInitData drmInitDataK0;
        if (bVar.a(0)) {
            AnalyticsListener.a aVarD = bVar.d(0);
            if (this.f2296a != null) {
                a1(aVarD.f2225a, aVarD.f2226a);
            }
        }
        if (bVar.a(2) && this.f2296a != null && (drmInitDataK0 = K0(player.s().c())) != null) {
            ((PlaybackMetrics.Builder) gj9.k(this.f2296a)).setDrmType(L0(drmInitDataK0));
        }
        if (bVar.a(1011)) {
            this.q0++;
        }
    }

    public final void Z0(long j, @Nullable com.google.android.exoplayer2.d dVar, int i) {
        if (gj9.c(this.f2310c, dVar)) {
            return;
        }
        if (this.f2310c == null && i == 0) {
            i = 1;
        }
        this.f2310c = dVar;
        c1(2, j, dVar, i);
    }

    @RequiresNonNull({"metricsBuilder"})
    public final void a1(Timeline timeline, @Nullable MediaSource.a aVar) {
        int iF;
        PlaybackMetrics.Builder builder = this.f2296a;
        if (aVar == null || (iF = timeline.f(((gk5) aVar).f16805a)) == -1) {
            return;
        }
        timeline.j(iF, this.f2299a);
        timeline.t(this.f2299a.K, this.f2300a);
        builder.setStreamType(Q0(this.f2300a.f2199a));
        Timeline.d dVar = this.f2300a;
        if (dVar.f2209e != -9223372036854775807L && !dVar.f2208d && !dVar.f2204b && !dVar.k()) {
            builder.setMediaDurationMillis(this.f2300a.g());
        }
        builder.setPlaybackType(this.f2300a.k() ? 2 : 1);
        this.f2311c = true;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void b(AnalyticsListener.a aVar, String str) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void b0(AnalyticsListener.a aVar, hp9 hp9Var) {
        b bVar = this.f2302a;
        if (bVar != null) {
            com.google.android.exoplayer2.d dVar = bVar.f2312a;
            if (dVar.R == -1) {
                this.f2302a = new b(dVar.b().j0(hp9Var.K).Q(hp9Var.L).E(), bVar.f30524a, bVar.f2313a);
            }
        }
    }

    public final void b1(long j, @Nullable com.google.android.exoplayer2.d dVar, int i) {
        if (gj9.c(this.f2303a, dVar)) {
            return;
        }
        if (this.f2303a == null && i == 0) {
            i = 1;
        }
        this.f2303a = dVar;
        c1(1, j, dVar, i);
    }

    public final void c1(int i, long j, @Nullable com.google.android.exoplayer2.d dVar, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i).setTimeSinceCreatedMillis(j - this.f30522a);
        if (dVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(R0(i2));
            String str = dVar.j;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = dVar.k;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = dVar.i;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i3 = dVar.O;
            if (i3 != -1) {
                timeSinceCreatedMillis.setBitrate(i3);
            }
            int i4 = dVar.Q;
            if (i4 != -1) {
                timeSinceCreatedMillis.setWidth(i4);
            }
            int i5 = dVar.R;
            if (i5 != -1) {
                timeSinceCreatedMillis.setHeight(i5);
            }
            int i6 = dVar.U;
            if (i6 != -1) {
                timeSinceCreatedMillis.setChannelCount(i6);
            }
            int i7 = dVar.V;
            if (i7 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i7);
            }
            String str4 = dVar.h;
            if (str4 != null) {
                Pair<String, String> pairN0 = N0(str4);
                timeSinceCreatedMillis.setLanguage((String) pairN0.first);
                Object obj = pairN0.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f = dVar.f2564a;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.f2311c = true;
        this.f2297a.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    public final int d1(Player player) {
        int playbackState = player.getPlaybackState();
        if (this.f2306a) {
            return 5;
        }
        if (this.f2309b) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            int i = this.l0;
            if (i == 0 || i == 2) {
                return 2;
            }
            if (player.getPlayWhenReady()) {
                return player.getPlaybackSuppressionReason() != 0 ? 10 : 6;
            }
            return 7;
        }
        if (playbackState == 3) {
            if (player.getPlayWhenReady()) {
                return player.getPlaybackSuppressionReason() != 0 ? 9 : 3;
            }
            return 4;
        }
        if (playbackState != 1 || this.l0 == 0) {
            return this.l0;
        }
        return 12;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void h(AnalyticsListener.a aVar, az4 az4Var, oh5 oh5Var, IOException iOException, boolean z) {
        this.n0 = oh5Var.f43748a;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void k0(AnalyticsListener.a aVar, String str, boolean z) {
        MediaSource.a aVar2 = aVar.f2226a;
        if ((aVar2 == null || !aVar2.c()) && str.equals(this.f2304a)) {
            I0();
        }
        this.f2305a.remove(str);
        this.f2308b.remove(str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void t(AnalyticsListener.a aVar, int i, long j, long j2) {
        MediaSource.a aVar2 = aVar.f2226a;
        if (aVar2 != null) {
            String strE = this.f2301a.e(aVar.f2225a, (MediaSource.a) sb0.g(aVar2));
            Long l = this.f2308b.get(strE);
            Long l2 = this.f2305a.get(strE);
            this.f2308b.put(strE, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            this.f2305a.put(strE, Long.valueOf((l2 != null ? l2.longValue() : 0L) + ((long) i)));
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void v0(Player player, AnalyticsListener.b bVar) {
        if (bVar.e() == 0) {
            return;
        }
        S0(bVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Y0(player, bVar);
        U0(jElapsedRealtime);
        W0(player, bVar, jElapsedRealtime);
        T0(jElapsedRealtime);
        V0(player, bVar, jElapsedRealtime);
        if (bVar.a(1028)) {
            this.f2301a.a(bVar.d(1028));
        }
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void w0(AnalyticsListener.a aVar, String str, String str2) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void y0(AnalyticsListener.a aVar, Player.d dVar, Player.d dVar2, int i) {
        if (i == 1) {
            this.f2306a = true;
        }
        this.k0 = i;
    }
}
