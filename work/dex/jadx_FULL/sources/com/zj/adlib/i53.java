package com.zj.adlib;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import com.ipd.dsp.internal.d.a;
import com.ipd.dsp.internal.i.q;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class i53 implements AnalyticsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NumberFormat f42285a;
    public static final String b = "EventLogger";
    public static final int k0 = 3;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f17151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.b f17152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.d f17153a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f17154a;

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        f42285a = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public i53() {
        this(b);
    }

    public static String G0(int i) {
        if (i == 1) {
            return "USER_REQUEST";
        }
        if (i == 2) {
            return "AUDIO_FOCUS_LOSS";
        }
        if (i == 3) {
            return "AUDIO_BECOMING_NOISY";
        }
        if (i != 4) {
            return i != 5 ? "?" : "END_OF_MEDIA_ITEM";
        }
        return "REMOTE";
    }

    public static String H0(int i) {
        if (i != 0) {
            return i != 1 ? "?" : "TRANSIENT_AUDIO_FOCUS_LOSS";
        }
        return "NONE";
    }

    public static String I0(int i) {
        if (i == 0) {
            return "OFF";
        }
        if (i != 1) {
            return i != 2 ? "?" : "ALL";
        }
        return "ONE";
    }

    public static String J0(int i) {
        if (i == 1) {
            return RVScheduleType.IDLE;
        }
        if (i == 2) {
            return "BUFFERING";
        }
        if (i != 3) {
            return i != 4 ? "?" : "ENDED";
        }
        return "READY";
    }

    public static String K0(long j) {
        return j == -9223372036854775807L ? "?" : f42285a.format(j / 1000.0f);
    }

    public static String L0(int i) {
        if (i != 0) {
            return i != 1 ? "?" : "SOURCE_UPDATE";
        }
        return "PLAYLIST_CHANGED";
    }

    public static String M0(boolean z) {
        return z ? "[X]" : "[ ]";
    }

    public static String b(int i) {
        if (i == 0) {
            return "AUTO_TRANSITION";
        }
        if (i == 1) {
            return "SEEK";
        }
        if (i == 2) {
            return "SEEK_ADJUSTMENT";
        }
        if (i == 3) {
            return "SKIP";
        }
        if (i != 4) {
            return i != 5 ? "?" : "INTERNAL";
        }
        return a.B;
    }

    public static String w0(int i) {
        if (i == 0) {
            return "REPEAT";
        }
        if (i == 1) {
            return "AUTO";
        }
        if (i != 2) {
            return i != 3 ? "?" : "PLAYLIST_CHANGED";
        }
        return "SEEK";
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void A(AnalyticsListener.a aVar, PlaybackException playbackException) {
        Q0(aVar, "playerFailed", playbackException);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void A0(AnalyticsListener.a aVar, int i) {
        O0(aVar, "state", J0(i));
    }

    public final String B(AnalyticsListener.a aVar, String str, @Nullable String str2, @Nullable Throwable th) {
        String str3 = str + " [" + k0(aVar);
        if (th instanceof PlaybackException) {
            str3 = str3 + ", errorCode=" + ((PlaybackException) th).getErrorCodeName();
        }
        if (str2 != null) {
            str3 = str3 + ", " + str2;
        }
        String strG = Log.g(th);
        if (!TextUtils.isEmpty(strG)) {
            str3 = str3 + "\n  " + strG.replace("\n", "\n  ") + '\n';
        }
        return str3 + "]";
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void C0(AnalyticsListener.a aVar) {
        N0(aVar, "drmKeysLoaded");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void D0(AnalyticsListener.a aVar, int i) {
        O0(aVar, "drmSessionAcquired", "state=" + i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void E(AnalyticsListener.a aVar, az4 az4Var, oh5 oh5Var) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void F(AnalyticsListener.a aVar, oh5 oh5Var) {
        O0(aVar, "downstreamFormat", d.z(oh5Var.f18632a));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void I(AnalyticsListener.a aVar, int i) {
        O0(aVar, "audioSessionId", Integer.toString(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void K(AnalyticsListener.a aVar, int i) {
        O0(aVar, "playbackSuppressionReason", H0(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void M(AnalyticsListener.a aVar, oh5 oh5Var) {
        O0(aVar, "upstreamDiscarded", d.z(oh5Var.f18632a));
    }

    public final void N0(AnalyticsListener.a aVar, String str) {
        logd(B(aVar, str, null, null));
    }

    public final void O0(AnalyticsListener.a aVar, String str, String str2) {
        logd(B(aVar, str, str2, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void P(AnalyticsListener.a aVar, j jVar) {
        O0(aVar, "playbackParameters", jVar.toString());
    }

    public final void P0(AnalyticsListener.a aVar, String str, String str2, @Nullable Throwable th) {
        loge(B(aVar, str, str2, th));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void Q(AnalyticsListener.a aVar) {
        N0(aVar, "drmKeysRestored");
    }

    public final void Q0(AnalyticsListener.a aVar, String str, @Nullable Throwable th) {
        loge(B(aVar, str, null, th));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void R(AnalyticsListener.a aVar, int i) {
        int iM = aVar.f2225a.m();
        int iV = aVar.f2225a.v();
        logd("timeline [" + k0(aVar) + ", periodCount=" + iM + ", windowCount=" + iV + ", reason=" + L0(i));
        for (int i2 = 0; i2 < Math.min(iM, 3); i2++) {
            aVar.f2225a.j(i2, this.f17152a);
            logd("  period [" + K0(this.f17152a.n()) + "]");
        }
        if (iM > 3) {
            logd("  ...");
        }
        for (int i3 = 0; i3 < Math.min(iV, 3); i3++) {
            aVar.f2225a.t(i3, this.f17153a);
            logd("  window [" + K0(this.f17153a.g()) + ", seekable=" + this.f17153a.f2201a + ", dynamic=" + this.f17153a.f2204b + "]");
        }
        if (iV > 3) {
            logd("  ...");
        }
        logd("]");
    }

    public final void R0(AnalyticsListener.a aVar, String str, Exception exc) {
        P0(aVar, "internalError", str, exc);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void S(AnalyticsListener.a aVar, String str, long j) {
        O0(aVar, "videoDecoderInitialized", str);
    }

    public final void S0(Metadata metadata, String str) {
        for (int i = 0; i < metadata.length(); i++) {
            logd(str + metadata.get(i));
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void T(AnalyticsListener.a aVar, az4 az4Var, oh5 oh5Var) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void U(AnalyticsListener.a aVar, p82 p82Var) {
        N0(aVar, "videoDisabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void V(AnalyticsListener.a aVar, p pVar) {
        Metadata metadata;
        logd("tracks [" + k0(aVar));
        ImmutableList<p.a> immutableListC = pVar.c();
        for (int i = 0; i < immutableListC.size(); i++) {
            p.a aVar2 = immutableListC.get(i);
            logd("  group [");
            for (int i2 = 0; i2 < aVar2.K; i2++) {
                logd("    " + M0(aVar2.i(i2)) + " Track:" + i2 + ", " + d.z(aVar2.c(i2)) + ", supported=" + gj9.h0(aVar2.d(i2)));
            }
            logd("  ]");
        }
        boolean z = false;
        for (int i3 = 0; !z && i3 < immutableListC.size(); i3++) {
            p.a aVar3 = immutableListC.get(i3);
            for (int i4 = 0; !z && i4 < aVar3.K; i4++) {
                if (aVar3.i(i4) && (metadata = aVar3.c(i4).f2567a) != null && metadata.length() > 0) {
                    logd("  Metadata [");
                    S0(metadata, "    ");
                    logd("  ]");
                    z = true;
                }
            }
        }
        logd("]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void W(AnalyticsListener.a aVar, int i, long j) {
        O0(aVar, "droppedFrames", Integer.toString(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void a(AnalyticsListener.a aVar, d dVar, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        O0(aVar, "audioInputFormat", d.z(dVar));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void a0(AnalyticsListener.a aVar, com.google.android.exoplayer2.audio.a aVar2) {
        O0(aVar, "audioAttributes", aVar2.K + "," + aVar2.L + "," + aVar2.M + "," + aVar2.N);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void b0(AnalyticsListener.a aVar, hp9 hp9Var) {
        O0(aVar, "videoSize", hp9Var.K + ", " + hp9Var.L);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void d(AnalyticsListener.a aVar, @Nullable g gVar, int i) {
        logd("mediaItem [" + k0(aVar) + ", reason=" + w0(i) + "]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void d0(AnalyticsListener.a aVar, int i, int i2) {
        O0(aVar, "surfaceSize", i + ", " + i2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void e0(AnalyticsListener.a aVar, boolean z) {
        O0(aVar, "loading", Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void g0(AnalyticsListener.a aVar, Object obj, long j) {
        O0(aVar, "renderedFirstFrame", String.valueOf(obj));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void h(AnalyticsListener.a aVar, az4 az4Var, oh5 oh5Var, IOException iOException, boolean z) {
        R0(aVar, "loadError", iOException);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void h0(AnalyticsListener.a aVar, boolean z) {
        O0(aVar, "shuffleModeEnabled", Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void j0(AnalyticsListener.a aVar, p82 p82Var) {
        N0(aVar, "audioEnabled");
    }

    public final String k0(AnalyticsListener.a aVar) {
        String str = "window=" + aVar.f30514a;
        if (aVar.f2226a != null) {
            str = str + ", period=" + aVar.f2225a.f(((gk5) aVar.f2226a).f16805a);
            if (aVar.f2226a.c()) {
                str = (str + ", adGroup=" + ((gk5) aVar.f2226a).f41928a) + ", ad=" + aVar.f2226a.b;
            }
        }
        return "eventTime=" + K0(aVar.f2224a - this.f17151a) + ", mediaPos=" + K0(aVar.f2227b) + ", " + str;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void l(AnalyticsListener.a aVar, int i, long j, long j2) {
        P0(aVar, "audioTrackUnderrun", i + ", " + j + ", " + j2, null);
    }

    public void logd(String str) {
        Log.b(this.f17154a, str);
    }

    public void loge(String str) {
        Log.d(this.f17154a, str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void m(AnalyticsListener.a aVar, Metadata metadata) {
        logd("metadata [" + k0(aVar));
        S0(metadata, q.a.i);
        logd("]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void m0(AnalyticsListener.a aVar, Exception exc) {
        R0(aVar, "drmSessionManagerError", exc);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void n(AnalyticsListener.a aVar, boolean z, int i) {
        O0(aVar, "playWhenReady", z + ", " + G0(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void n0(AnalyticsListener.a aVar, String str) {
        O0(aVar, "audioDecoderReleased", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void o(AnalyticsListener.a aVar, p82 p82Var) {
        N0(aVar, "videoEnabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void o0(AnalyticsListener.a aVar, String str) {
        O0(aVar, "videoDecoderReleased", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void p0(AnalyticsListener.a aVar, p82 p82Var) {
        N0(aVar, "audioDisabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void r0(AnalyticsListener.a aVar, boolean z) {
        O0(aVar, "isPlaying", Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void s(AnalyticsListener.a aVar, boolean z) {
        O0(aVar, "skipSilenceEnabled", Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void s0(AnalyticsListener.a aVar, az4 az4Var, oh5 oh5Var) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void t(AnalyticsListener.a aVar, int i, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void u(AnalyticsListener.a aVar) {
        N0(aVar, "drmSessionReleased");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void w(AnalyticsListener.a aVar, float f) {
        O0(aVar, "volume", Float.toString(f));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void x(AnalyticsListener.a aVar, String str, long j) {
        O0(aVar, "audioDecoderInitialized", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void x0(AnalyticsListener.a aVar) {
        N0(aVar, "drmKeysRemoved");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void y(AnalyticsListener.a aVar, d dVar, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        O0(aVar, "videoInputFormat", d.z(dVar));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void y0(AnalyticsListener.a aVar, Player.d dVar, Player.d dVar2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("reason=");
        sb.append(b(i));
        sb.append(", PositionInfo:old [");
        sb.append("mediaItem=");
        sb.append(dVar.L);
        sb.append(", period=");
        sb.append(dVar.M);
        sb.append(", pos=");
        sb.append(dVar.f2167a);
        if (dVar.N != -1) {
            sb.append(", contentPos=");
            sb.append(dVar.b);
            sb.append(", adGroup=");
            sb.append(dVar.N);
            sb.append(", ad=");
            sb.append(dVar.O);
        }
        sb.append("], PositionInfo:new [");
        sb.append("mediaItem=");
        sb.append(dVar2.L);
        sb.append(", period=");
        sb.append(dVar2.M);
        sb.append(", pos=");
        sb.append(dVar2.f2167a);
        if (dVar2.N != -1) {
            sb.append(", contentPos=");
            sb.append(dVar2.b);
            sb.append(", adGroup=");
            sb.append(dVar2.N);
            sb.append(", ad=");
            sb.append(dVar2.O);
        }
        sb.append("]");
        O0(aVar, "positionDiscontinuity", sb.toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void z0(AnalyticsListener.a aVar, int i) {
        O0(aVar, "repeatMode", I0(i));
    }

    public i53(String str) {
        this.f17154a = str;
        this.f17153a = new Timeline.d();
        this.f17152a = new Timeline.b();
        this.f17151a = SystemClock.elapsedRealtime();
    }

    @Deprecated
    public i53(@Nullable MappingTrackSelector mappingTrackSelector) {
        this(b);
    }

    @Deprecated
    public i53(@Nullable MappingTrackSelector mappingTrackSelector, String str) {
        this(str);
    }
}
