package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.bp5;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30771a = -1;
    public static final String d = "MediaCodecInfo";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final MediaCodecInfo.CodecCapabilities f3462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f3463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3464a;
    public final String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f3465b;
    public final String c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f3466c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final boolean f3467d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    @VisibleForTesting
    public c(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f3463a = (String) sb0.g(str);
        this.b = str2;
        this.c = str3;
        this.f3462a = codecCapabilities;
        this.f3467d = z;
        this.e = z2;
        this.f = z3;
        this.f3464a = z4;
        this.f3465b = z5;
        this.f3466c = z6;
        this.g = bp5.t(str2);
    }

    public static boolean A(String str) {
        return "audio/opus".equals(str);
    }

    public static boolean B(String str) {
        return gj9.c.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    public static boolean C(String str) {
        if (gj9.f41922a <= 22) {
            String str2 = gj9.c;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    public static boolean D(String str, int i) {
        if ("video/hevc".equals(str) && 2 == i) {
            String str2 = gj9.f16787a;
            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean E(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(gj9.f16787a)) ? false : true;
    }

    public static c F(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new c(str, str2, str3, codecCapabilities, z, z2, z3, (z4 || codecCapabilities == null || !j(codecCapabilities) || C(str)) ? false : true, codecCapabilities != null && v(codecCapabilities), z5 || (codecCapabilities != null && t(codecCapabilities)));
    }

    public static int a(String str, String str2, int i) {
        int i2;
        if (i > 1 || ((gj9.f41922a >= 26 && i > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i;
        }
        if ("audio/ac3".equals(str2)) {
            i2 = 6;
        } else {
            i2 = "audio/eac3".equals(str2) ? 16 : 30;
        }
        Log.n("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + "]");
        return i2;
    }

    @RequiresApi(21)
    public static Point c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(gj9.m(i, widthAlignment) * widthAlignment, gj9.m(i2, heightAlignment) * heightAlignment);
    }

    @RequiresApi(21)
    public static boolean d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d2) {
        Point pointC = c(videoCapabilities, i, i2);
        int i3 = pointC.x;
        int i4 = pointC.y;
        return (d2 == -1.0d || d2 < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d2));
    }

    public static MediaCodecInfo.CodecProfileLevel[] f(@Nullable MediaCodecInfo.CodecCapabilities codecCapabilities) {
        int i;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int iIntValue = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
        if (iIntValue >= 180000000) {
            i = 1024;
        } else if (iIntValue >= 120000000) {
            i = 512;
        } else if (iIntValue >= 60000000) {
            i = 256;
        } else if (iIntValue >= 30000000) {
            i = 128;
        } else if (iIntValue >= 18000000) {
            i = 64;
        } else if (iIntValue >= 12000000) {
            i = 32;
        } else if (iIntValue >= 7200000) {
            i = 16;
        } else if (iIntValue >= 3600000) {
            i = 8;
        } else if (iIntValue >= 1800000) {
            i = 4;
        } else {
            i = iIntValue >= 800000 ? 2 : 1;
        }
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    @RequiresApi(23)
    public static int h(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.getMaxSupportedInstances();
    }

    public static boolean j(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return gj9.f41922a >= 19 && k(codecCapabilities);
    }

    @RequiresApi(19)
    public static boolean k(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean t(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return gj9.f41922a >= 21 && u(codecCapabilities);
    }

    @RequiresApi(21)
    public static boolean u(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public static boolean v(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return gj9.f41922a >= 21 && w(codecCapabilities);
    }

    @RequiresApi(21)
    public static boolean w(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    @Nullable
    @RequiresApi(21)
    public Point b(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f3462a;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return c(videoCapabilities, i, i2);
    }

    public DecoderReuseEvaluation e(com.google.android.exoplayer2.d dVar, com.google.android.exoplayer2.d dVar2) {
        int i = !gj9.c(dVar.k, dVar2.k) ? 8 : 0;
        if (this.g) {
            if (dVar.S != dVar2.S) {
                i |= 1024;
            }
            if (!this.f3464a && (dVar.Q != dVar2.Q || dVar.R != dVar2.R)) {
                i |= 512;
            }
            if (!gj9.c(dVar.f2568a, dVar2.f2568a)) {
                i |= 2048;
            }
            if (B(this.f3463a) && !dVar.w(dVar2)) {
                i |= 2;
            }
            if (i == 0) {
                return new DecoderReuseEvaluation(this.f3463a, dVar, dVar2, dVar.w(dVar2) ? 3 : 2, 0);
            }
        } else {
            if (dVar.U != dVar2.U) {
                i |= 4096;
            }
            if (dVar.V != dVar2.V) {
                i |= 8192;
            }
            if (dVar.W != dVar2.W) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.b)) {
                Pair<Integer, Integer> pairR = MediaCodecUtil.r(dVar);
                Pair<Integer, Integer> pairR2 = MediaCodecUtil.r(dVar2);
                if (pairR != null && pairR2 != null) {
                    int iIntValue = ((Integer) pairR.first).intValue();
                    int iIntValue2 = ((Integer) pairR2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new DecoderReuseEvaluation(this.f3463a, dVar, dVar2, 3, 0);
                    }
                }
            }
            if (!dVar.w(dVar2)) {
                i |= 32;
            }
            if (A(this.b)) {
                i |= 2;
            }
            if (i == 0) {
                return new DecoderReuseEvaluation(this.f3463a, dVar, dVar2, 1, 0);
            }
        }
        return new DecoderReuseEvaluation(this.f3463a, dVar, dVar2, 0, i);
    }

    public int g() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        if (gj9.f41922a < 23 || (codecCapabilities = this.f3462a) == null) {
            return -1;
        }
        return h(codecCapabilities);
    }

    public MediaCodecInfo.CodecProfileLevel[] i() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f3462a;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @RequiresApi(21)
    public boolean l(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f3462a;
        if (codecCapabilities == null) {
            z("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            z("channelCount.aCaps");
            return false;
        }
        if (a(this.f3463a, this.b, audioCapabilities.getMaxInputChannelCount()) >= i) {
            return true;
        }
        z("channelCount.support, " + i);
        return false;
    }

    @RequiresApi(21)
    public boolean m(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f3462a;
        if (codecCapabilities == null) {
            z("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            z("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        }
        z("sampleRate.support, " + i);
        return false;
    }

    public final boolean n(com.google.android.exoplayer2.d dVar) {
        Pair<Integer, Integer> pairR;
        if (dVar.i == null || (pairR = MediaCodecUtil.r(dVar)) == null) {
            return true;
        }
        int iIntValue = ((Integer) pairR.first).intValue();
        int iIntValue2 = ((Integer) pairR.second).intValue();
        if ("video/dolby-vision".equals(dVar.k)) {
            if (!"video/avc".equals(this.b)) {
                iIntValue = "video/hevc".equals(this.b) ? 2 : 8;
            }
            iIntValue2 = 0;
        }
        if (!this.g && iIntValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrI = i();
        if (gj9.f41922a <= 23 && "video/x-vnd.on2.vp9".equals(this.b) && codecProfileLevelArrI.length == 0) {
            codecProfileLevelArrI = f(this.f3462a);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrI) {
            if (codecProfileLevel.profile == iIntValue && codecProfileLevel.level >= iIntValue2 && !D(this.b, iIntValue)) {
                return true;
            }
        }
        z("codec.profileLevel, " + dVar.i + ", " + this.c);
        return false;
    }

    public boolean o(com.google.android.exoplayer2.d dVar) throws MediaCodecUtil.DecoderQueryException {
        int i;
        if (!q(dVar) || !n(dVar)) {
            return false;
        }
        if (!this.g) {
            if (gj9.f41922a >= 21) {
                int i2 = dVar.V;
                if (i2 != -1 && !m(i2)) {
                    return false;
                }
                int i3 = dVar.U;
                if (i3 != -1 && !l(i3)) {
                    return false;
                }
            }
            return true;
        }
        int i4 = dVar.Q;
        if (i4 <= 0 || (i = dVar.R) <= 0) {
            return true;
        }
        if (gj9.f41922a >= 21) {
            return x(i4, i, dVar.f2564a);
        }
        boolean z = i4 * i <= MediaCodecUtil.O();
        if (!z) {
            z("legacyFrameSize, " + dVar.Q + "x" + dVar.R);
        }
        return z;
    }

    public boolean p() {
        if (gj9.f41922a >= 29 && "video/x-vnd.on2.vp9".equals(this.b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : i()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean q(com.google.android.exoplayer2.d dVar) {
        return this.b.equals(dVar.k) || this.b.equals(MediaCodecUtil.n(dVar));
    }

    public boolean r(com.google.android.exoplayer2.d dVar) {
        if (this.g) {
            return this.f3464a;
        }
        Pair<Integer, Integer> pairR = MediaCodecUtil.r(dVar);
        return pairR != null && ((Integer) pairR.first).intValue() == 42;
    }

    @Deprecated
    public boolean s(com.google.android.exoplayer2.d dVar, com.google.android.exoplayer2.d dVar2, boolean z) {
        if (!z && dVar.f2568a != null && dVar2.f2568a == null) {
            dVar2 = dVar2.b().J(dVar.f2568a).E();
        }
        int i = e(dVar, dVar2).f30578a;
        return i == 2 || i == 3;
    }

    public String toString() {
        return this.f3463a;
    }

    @RequiresApi(21)
    public boolean x(int i, int i2, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f3462a;
        if (codecCapabilities == null) {
            z("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            z("sizeAndRate.vCaps");
            return false;
        }
        if (d(videoCapabilities, i, i2, d2)) {
            return true;
        }
        if (i < i2 && E(this.f3463a) && d(videoCapabilities, i2, i, d2)) {
            y("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d2);
            return true;
        }
        z("sizeAndRate.support, " + i + "x" + i2 + "x" + d2);
        return false;
    }

    public final void y(String str) {
        Log.b("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.f3463a + ", " + this.b + "] [" + gj9.d + "]");
    }

    public final void z(String str) {
        Log.b("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f3463a + ", " + this.b + "] [" + gj9.d + "]");
    }
}
