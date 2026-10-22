package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.bp5;
import com.zj.adlib.gj9;
import com.zj.adlib.tn1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SuppressLint({"InlinedApi"})
public final class MediaCodecUtil {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f3449a = "MediaCodecUtil";
    public static final String b = "avc1";
    public static final String c = "avc2";
    public static final String d = "vp09";
    public static final String e = "hev1";
    public static final String f = "hvc1";
    public static final String g = "av01";
    public static final String h = "mp4a";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f3451a = Pattern.compile("^\\D?(\\d+)$");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("MediaCodecUtil.class")
    public static final HashMap<b, List<com.google.android.exoplayer2.mediacodec.c>> f3450a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f30765a = -1;

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    public interface MediaCodecListCompat {
        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i);

        boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    public interface ScoreProvider<T> {
        int getScore(T t);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f30766a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f3452a;
        public final boolean b;

        public b(String str, boolean z, boolean z2) {
            this.f30766a = str;
            this.f3452a = z;
            this.b = z2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return TextUtils.equals(this.f30766a, bVar.f30766a) && this.f3452a == bVar.f3452a && this.b == bVar.b;
        }

        public int hashCode() {
            return ((((this.f30766a.hashCode() + 31) * 31) + (this.f3452a ? 1231 : 1237)) * 31) + (this.b ? 1231 : 1237);
        }
    }

    public static final class c implements MediaCodecListCompat {
        public c() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public MediaCodecInfo getCodecInfoAt(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            return false;
        }
    }

    @RequiresApi(21)
    public static final class d implements MediaCodecListCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30767a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public MediaCodecInfo[] f3453a;

        public d(boolean z, boolean z2) {
            this.f30767a = (z || z2) ? 1 : 0;
        }

        @EnsuresNonNull({"mediaCodecInfos"})
        public final void a() {
            if (this.f3453a == null) {
                this.f3453a = new MediaCodecList(this.f30767a).getCodecInfos();
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int getCodecCount() {
            a();
            return this.f3453a.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public MediaCodecInfo getCodecInfoAt(int i) {
            a();
            return this.f3453a[i];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            return true;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public static Integer A(@Nullable String str) {
        if (str == null) {
            return null;
        }
        byte b2 = -1;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    b2 = 0;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    b2 = 1;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    b2 = 2;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    b2 = 3;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    b2 = 4;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    b2 = 5;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    b2 = 6;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    b2 = 7;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    b2 = 8;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    b2 = 9;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    b2 = 10;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    b2 = 11;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    b2 = 12;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    b2 = 13;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    b2 = com.google.common.base.a.p;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    b2 = com.google.common.base.a.q;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    b2 = 16;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    b2 = 17;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    b2 = com.google.common.base.a.u;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    b2 = 19;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    b2 = com.google.common.base.a.x;
                }
                break;
            case 2312899:
                if (str.equals("L153")) {
                    b2 = com.google.common.base.a.y;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    b2 = com.google.common.base.a.z;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    b2 = com.google.common.base.a.A;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    b2 = com.google.common.base.a.B;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    b2 = com.google.common.base.a.C;
                }
                break;
        }
        switch (b2) {
            case 0:
                return 2;
            case 1:
                return 8;
            case 2:
                return 32;
            case 3:
                return 128;
            case 4:
                return 512;
            case 5:
                return 1;
            case 6:
                return 4;
            case 7:
                return 16;
            case 8:
                return 64;
            case 9:
                return 256;
            case 10:
                return 2048;
            case 11:
                return 8192;
            case 12:
                return 32768;
            case 13:
                return 131072;
            case 14:
                return 524288;
            case 15:
                return 2097152;
            case 16:
                return 8388608;
            case 17:
                return 33554432;
            case 18:
                return 1024;
            case 19:
                return 4096;
            case 20:
                return 16384;
            case 21:
                return 65536;
            case 22:
                return 262144;
            case 23:
                return 1048576;
            case 24:
                return 4194304;
            case 25:
                return 16777216;
            default:
                return null;
        }
    }

    public static boolean B(MediaCodecInfo mediaCodecInfo) {
        return gj9.f41922a >= 29 && C(mediaCodecInfo);
    }

    @RequiresApi(29)
    public static boolean C(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    public static boolean D(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i = gj9.f41922a;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = gj9.f16787a;
            if ("a70".equals(str3) || ("Xiaomi".equals(gj9.b) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = gj9.f16787a;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = gj9.f16787a;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(gj9.b))) {
            String str6 = gj9.f16787a;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(gj9.b)) {
            String str7 = gj9.f16787a;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i <= 19 && gj9.f16787a.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return (i <= 23 && "audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static boolean E(MediaCodecInfo mediaCodecInfo, String str) {
        return gj9.f41922a >= 29 ? F(mediaCodecInfo) : !G(mediaCodecInfo, str);
    }

    @RequiresApi(29)
    public static boolean F(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    public static boolean G(MediaCodecInfo mediaCodecInfo, String str) {
        if (gj9.f41922a >= 29) {
            return H(mediaCodecInfo);
        }
        if (bp5.p(str)) {
            return true;
        }
        String strG = com.google.common.base.a.g(mediaCodecInfo.getName());
        if (strG.startsWith("arc.")) {
            return false;
        }
        if (strG.startsWith("omx.google.") || strG.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strG.startsWith("omx.sec.") && strG.contains(".sw.")) || strG.equals("omx.qcom.video.decoder.hevcswvdec") || strG.startsWith("c2.android.") || strG.startsWith("c2.google.")) {
            return true;
        }
        return (strG.startsWith("omx.") || strG.startsWith("c2.")) ? false : true;
    }

    @RequiresApi(29)
    public static boolean H(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    public static boolean I(MediaCodecInfo mediaCodecInfo) {
        if (gj9.f41922a >= 29) {
            return J(mediaCodecInfo);
        }
        String strG = com.google.common.base.a.g(mediaCodecInfo.getName());
        return (strG.startsWith("omx.google.") || strG.startsWith("c2.android.") || strG.startsWith("c2.google.")) ? false : true;
    }

    @RequiresApi(29)
    public static boolean J(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    public static /* synthetic */ int K(com.google.android.exoplayer2.mediacodec.c cVar) {
        String str = cVar.f3463a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (gj9.f41922a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    public static /* synthetic */ int L(com.google.android.exoplayer2.mediacodec.c cVar) {
        return cVar.f3463a.startsWith("OMX.google") ? 1 : 0;
    }

    public static /* synthetic */ int M(com.google.android.exoplayer2.d dVar, com.google.android.exoplayer2.mediacodec.c cVar) {
        try {
            return cVar.o(dVar) ? 1 : 0;
        } catch (DecoderQueryException unused) {
            return -1;
        }
    }

    public static /* synthetic */ int N(ScoreProvider scoreProvider, Object obj, Object obj2) {
        return scoreProvider.getScore(obj2) - scoreProvider.getScore(obj);
    }

    public static int O() throws DecoderQueryException {
        if (f30765a == -1) {
            int iMax = 0;
            com.google.android.exoplayer2.mediacodec.c cVarS = s("video/avc", false, false);
            if (cVarS != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrI = cVarS.i();
                int length = codecProfileLevelArrI.length;
                int iMax2 = 0;
                while (iMax < length) {
                    iMax2 = Math.max(h(codecProfileLevelArrI[iMax].level), iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, gj9.f41922a >= 21 ? 345600 : 172800);
            }
            f30765a = iMax;
        }
        return f30765a;
    }

    public static int P(int i) {
        int i2 = 17;
        if (i != 17) {
            i2 = 20;
            if (i != 20) {
                i2 = 23;
                if (i != 23) {
                    i2 = 29;
                    if (i != 29) {
                        i2 = 39;
                        if (i != 39) {
                            i2 = 42;
                            if (i != 42) {
                                switch (i) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    public static <T> void Q(List<T> list, final ScoreProvider<T> scoreProvider) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.exoplayer2.mediacodec.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MediaCodecUtil.N(scoreProvider, obj, obj2);
            }
        });
    }

    public static int R(int i) {
        if (i == 10) {
            return 1;
        }
        if (i == 11) {
            return 2;
        }
        if (i == 20) {
            return 4;
        }
        if (i == 21) {
            return 8;
        }
        if (i == 30) {
            return 16;
        }
        if (i == 31) {
            return 32;
        }
        if (i == 40) {
            return 64;
        }
        if (i == 41) {
            return 128;
        }
        if (i == 50) {
            return 256;
        }
        if (i == 51) {
            return 512;
        }
        switch (i) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    public static int S(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? -1 : 8;
        }
        return 4;
    }

    public static void T(String str, boolean z, boolean z2) {
        try {
            t(str, z, z2);
        } catch (DecoderQueryException e2) {
            Log.e(f3449a, "Codec warming failed", e2);
        }
    }

    public static void e(String str, List<com.google.android.exoplayer2.mediacodec.c> list) {
        if ("audio/raw".equals(str)) {
            if (gj9.f41922a < 26 && gj9.f16787a.equals("R9") && list.size() == 1 && list.get(0).f3463a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(com.google.android.exoplayer2.mediacodec.c.F("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            Q(list, new ScoreProvider() { // from class: com.google.android.exoplayer2.mediacodec.e
                @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.ScoreProvider
                public final int getScore(Object obj) {
                    return MediaCodecUtil.K((c) obj);
                }
            });
        }
        int i = gj9.f41922a;
        if (i < 21 && list.size() > 1) {
            String str2 = list.get(0).f3463a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                Q(list, new ScoreProvider() { // from class: com.google.android.exoplayer2.mediacodec.f
                    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.ScoreProvider
                    public final int getScore(Object obj) {
                        return MediaCodecUtil.L((c) obj);
                    }
                });
            }
        }
        if (i >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).f3463a)) {
            return;
        }
        list.add(list.remove(0));
    }

    public static int f(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    public static int g(int i) {
        switch (i) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    public static int h(int i) {
        if (i == 1 || i == 2) {
            return 25344;
        }
        switch (i) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    public static int i(int i) {
        if (i == 66) {
            return 1;
        }
        if (i == 77) {
            return 2;
        }
        if (i == 88) {
            return 4;
        }
        if (i == 100) {
            return 8;
        }
        if (i == 110) {
            return 16;
        }
        if (i != 122) {
            return i != 244 ? -1 : 64;
        }
        return 32;
    }

    @VisibleForTesting
    public static synchronized void j() {
        f3450a.clear();
    }

    @Nullable
    public static Integer k(@Nullable String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "01":
                return 1;
            case "02":
                return 2;
            case "03":
                return 4;
            case "04":
                return 8;
            case "05":
                return 16;
            case "06":
                return 32;
            case "07":
                return 64;
            case "08":
                return 128;
            case "09":
                return 256;
            case "10":
                return 512;
            case "11":
                return 1024;
            case "12":
                return 2048;
            case "13":
                return 4096;
            default:
                return null;
        }
    }

    @Nullable
    public static Integer l(@Nullable String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "00":
                return 1;
            case "01":
                return 2;
            case "02":
                return 4;
            case "03":
                return 8;
            case "04":
                return 16;
            case "05":
                return 32;
            case "06":
                return 64;
            case "07":
                return 128;
            case "08":
                return 256;
            case "09":
                return 512;
            default:
                return null;
        }
    }

    @Nullable
    public static Pair<Integer, Integer> m(String str, String[] strArr) {
        int iP;
        if (strArr.length != 3) {
            Log.n(f3449a, "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(bp5.h(Integer.parseInt(strArr[1], 16))) && (iP = P(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair<>(Integer.valueOf(iP), 0);
            }
        } catch (NumberFormatException unused) {
            Log.n(f3449a, "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    @Nullable
    public static String n(com.google.android.exoplayer2.d dVar) {
        Pair<Integer, Integer> pairR;
        if ("audio/eac3-joc".equals(dVar.k)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(dVar.k) || (pairR = r(dVar)) == null) {
            return null;
        }
        int iIntValue = ((Integer) pairR.first).intValue();
        if (iIntValue == 16 || iIntValue == 256) {
            return "video/hevc";
        }
        if (iIntValue == 512) {
            return "video/avc";
        }
        return null;
    }

    @Nullable
    public static Pair<Integer, Integer> o(String str, String[] strArr, @Nullable tn1 tn1Var) {
        int i;
        if (strArr.length < 4) {
            Log.n(f3449a, "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        int i2 = 1;
        try {
            int i3 = Integer.parseInt(strArr[1]);
            int i4 = Integer.parseInt(strArr[2].substring(0, 2));
            int i5 = Integer.parseInt(strArr[3]);
            if (i3 != 0) {
                Log.n(f3449a, "Unknown AV1 profile: " + i3);
                return null;
            }
            if (i5 != 8 && i5 != 10) {
                Log.n(f3449a, "Unknown AV1 bit depth: " + i5);
                return null;
            }
            if (i5 != 8) {
                i2 = (tn1Var == null || !(tn1Var.f19867a != null || (i = tn1Var.M) == 7 || i == 6)) ? 2 : 4096;
            }
            int iF = f(i4);
            if (iF != -1) {
                return new Pair<>(Integer.valueOf(i2), Integer.valueOf(iF));
            }
            Log.n(f3449a, "Unknown AV1 level: " + i4);
            return null;
        } catch (NumberFormatException unused) {
            Log.n(f3449a, "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    @Nullable
    public static Pair<Integer, Integer> p(String str, String[] strArr) {
        int i;
        int i2;
        if (strArr.length < 2) {
            Log.n(f3449a, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i2 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i = Integer.parseInt(strArr[1].substring(4), 16);
            } else {
                if (strArr.length < 3) {
                    Log.n(f3449a, "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                int i3 = Integer.parseInt(strArr[1]);
                i = Integer.parseInt(strArr[2]);
                i2 = i3;
            }
            int i4 = i(i2);
            if (i4 == -1) {
                Log.n(f3449a, "Unknown AVC profile: " + i2);
                return null;
            }
            int iG = g(i);
            if (iG != -1) {
                return new Pair<>(Integer.valueOf(i4), Integer.valueOf(iG));
            }
            Log.n(f3449a, "Unknown AVC level: " + i);
            return null;
        } catch (NumberFormatException unused) {
            Log.n(f3449a, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    @Nullable
    public static String q(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    @Nullable
    public static Pair<Integer, Integer> r(com.google.android.exoplayer2.d dVar) {
        String str = dVar.i;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        if ("video/dolby-vision".equals(dVar.k)) {
            return x(dVar.i, strArrSplit);
        }
        byte b2 = 0;
        String str2 = strArrSplit[0];
        str2.hashCode();
        switch (str2.hashCode()) {
            case 3004662:
                if (!str2.equals(g)) {
                    b2 = -1;
                }
                break;
            case 3006243:
                b2 = !str2.equals("avc1") ? (byte) -1 : (byte) 1;
                break;
            case 3006244:
                b2 = !str2.equals(c) ? (byte) -1 : (byte) 2;
                break;
            case 3199032:
                b2 = !str2.equals("hev1") ? (byte) -1 : (byte) 3;
                break;
            case 3214780:
                b2 = !str2.equals("hvc1") ? (byte) -1 : (byte) 4;
                break;
            case 3356560:
                b2 = !str2.equals("mp4a") ? (byte) -1 : (byte) 5;
                break;
            case 3624515:
                b2 = !str2.equals(d) ? (byte) -1 : (byte) 6;
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
                return o(dVar.i, strArrSplit, dVar.f2568a);
            case 1:
            case 2:
                return p(dVar.i, strArrSplit);
            case 3:
            case 4:
                return y(dVar.i, strArrSplit);
            case 5:
                return m(dVar.i, strArrSplit);
            case 6:
                return z(dVar.i, strArrSplit);
            default:
                return null;
        }
    }

    @Nullable
    public static com.google.android.exoplayer2.mediacodec.c s(String str, boolean z, boolean z2) throws DecoderQueryException {
        List<com.google.android.exoplayer2.mediacodec.c> listT = t(str, z, z2);
        if (listT.isEmpty()) {
            return null;
        }
        return listT.get(0);
    }

    public static synchronized List<com.google.android.exoplayer2.mediacodec.c> t(String str, boolean z, boolean z2) throws DecoderQueryException {
        b bVar = new b(str, z, z2);
        HashMap<b, List<com.google.android.exoplayer2.mediacodec.c>> map = f3450a;
        List<com.google.android.exoplayer2.mediacodec.c> list = map.get(bVar);
        if (list != null) {
            return list;
        }
        int i = gj9.f41922a;
        ArrayList<com.google.android.exoplayer2.mediacodec.c> arrayListU = u(bVar, i >= 21 ? new d(z, z2) : new c());
        if (z && arrayListU.isEmpty() && 21 <= i && i <= 23) {
            arrayListU = u(bVar, new c());
            if (!arrayListU.isEmpty()) {
                Log.n(f3449a, "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + arrayListU.get(0).f3463a);
            }
        }
        e(str, arrayListU);
        ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) arrayListU);
        map.put(bVar, immutableListCopyOf);
        return immutableListCopyOf;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0081  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:57:0x0101 A[Catch: Exception -> 0x014f, TRY_ENTER, TryCatch #1 {Exception -> 0x014f, blocks: (B:3:0x0008, B:5:0x001b, B:60:0x0120, B:8:0x002d, B:11:0x0038, B:54:0x00f9, B:57:0x0101, B:59:0x0107, B:61:0x012a, B:62:0x014d), top: B:69:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    /* JADX WARN: Code duplicated, block: B:81:0x012a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public static ArrayList<com.google.android.exoplayer2.mediacodec.c> u(b bVar, MediaCodecListCompat mediaCodecListCompat) throws DecoderQueryException {
        String strQ;
        String str;
        String str2;
        int i;
        boolean z;
        int i2;
        b bVar2 = bVar;
        try {
            ArrayList<com.google.android.exoplayer2.mediacodec.c> arrayList = new ArrayList<>();
            String str3 = bVar2.f30766a;
            int codecCount = mediaCodecListCompat.getCodecCount();
            boolean zSecureDecodersExplicit = mediaCodecListCompat.secureDecodersExplicit();
            int i3 = 0;
            while (i3 < codecCount) {
                MediaCodecInfo codecInfoAt = mediaCodecListCompat.getCodecInfoAt(i3);
                if (B(codecInfoAt)) {
                    i = i3;
                    z = zSecureDecodersExplicit;
                    i2 = codecCount;
                } else {
                    String name = codecInfoAt.getName();
                    if (D(codecInfoAt, name, zSecureDecodersExplicit, str3) && (strQ = q(codecInfoAt, name, str3)) != null) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(strQ);
                            boolean zIsFeatureSupported = mediaCodecListCompat.isFeatureSupported("tunneled-playback", strQ, capabilitiesForType);
                            boolean zIsFeatureRequired = mediaCodecListCompat.isFeatureRequired("tunneled-playback", strQ, capabilitiesForType);
                            boolean z2 = bVar2.b;
                            if ((z2 || !zIsFeatureRequired) && (!z2 || zIsFeatureSupported)) {
                                boolean zIsFeatureSupported2 = mediaCodecListCompat.isFeatureSupported("secure-playback", strQ, capabilitiesForType);
                                boolean zIsFeatureRequired2 = mediaCodecListCompat.isFeatureRequired("secure-playback", strQ, capabilitiesForType);
                                boolean z3 = bVar2.f3452a;
                                if ((z3 || !zIsFeatureRequired2) && (!z3 || zIsFeatureSupported2)) {
                                    boolean zE = E(codecInfoAt, str3);
                                    boolean zG = G(codecInfoAt, str3);
                                    boolean zI = I(codecInfoAt);
                                    if (zSecureDecodersExplicit && bVar2.f3452a == zIsFeatureSupported2) {
                                        str = strQ;
                                        i = i3;
                                        z = zSecureDecodersExplicit;
                                        i2 = codecCount;
                                        arrayList.add(com.google.android.exoplayer2.mediacodec.c.F(name, str3, strQ, capabilitiesForType, zE, zG, zI, false, false));
                                    } else if (zSecureDecodersExplicit) {
                                        str = strQ;
                                        i = i3;
                                        z = zSecureDecodersExplicit;
                                        i2 = codecCount;
                                        if (!z) {
                                            continue;
                                        }
                                    } else {
                                        try {
                                            if (bVar2.f3452a) {
                                                str = strQ;
                                                i = i3;
                                                z = zSecureDecodersExplicit;
                                                i2 = codecCount;
                                                if (!z && zIsFeatureSupported2) {
                                                    StringBuilder sb = new StringBuilder();
                                                    try {
                                                        sb.append(name);
                                                        sb.append(".secure");
                                                        str2 = name;
                                                        try {
                                                            arrayList.add(com.google.android.exoplayer2.mediacodec.c.F(sb.toString(), str3, str, capabilitiesForType, zE, zG, zI, false, true));
                                                            return arrayList;
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            if (gj9.f41922a <= 23 || arrayList.isEmpty()) {
                                                                Log.d(f3449a, "Failed to query codec " + str2 + " (" + str + ")");
                                                                throw e;
                                                            }
                                                            Log.d(f3449a, "Skipping codec " + str2 + " (failed to query capabilities)");
                                                            i3 = i + 1;
                                                            bVar2 = bVar;
                                                            codecCount = i2;
                                                            zSecureDecodersExplicit = z;
                                                        }
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        str2 = name;
                                                    }
                                                }
                                            } else {
                                                str = strQ;
                                                i = i3;
                                                z = zSecureDecodersExplicit;
                                                i2 = codecCount;
                                                try {
                                                    arrayList.add(com.google.android.exoplayer2.mediacodec.c.F(name, str3, strQ, capabilitiesForType, zE, zG, zI, false, false));
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    str2 = name;
                                                    if (gj9.f41922a <= 23) {
                                                    }
                                                    Log.d(f3449a, "Failed to query codec " + str2 + " (" + str + ")");
                                                    throw e;
                                                }
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            str = strQ;
                                            i = i3;
                                            z = zSecureDecodersExplicit;
                                            i2 = codecCount;
                                            str2 = name;
                                            if (gj9.f41922a <= 23) {
                                            }
                                            Log.d(f3449a, "Failed to query codec " + str2 + " (" + str + ")");
                                            throw e;
                                        }
                                    }
                                } else {
                                    i = i3;
                                    z = zSecureDecodersExplicit;
                                    i2 = codecCount;
                                }
                            } else {
                                i = i3;
                                z = zSecureDecodersExplicit;
                                i2 = codecCount;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str = strQ;
                            str2 = name;
                            i = i3;
                            z = zSecureDecodersExplicit;
                            i2 = codecCount;
                        }
                    } else {
                        i = i3;
                        z = zSecureDecodersExplicit;
                        i2 = codecCount;
                    }
                }
                i3 = i + 1;
                bVar2 = bVar;
                codecCount = i2;
                zSecureDecodersExplicit = z;
            }
            return arrayList;
        } catch (Exception e7) {
            throw new DecoderQueryException(e7);
        }
    }

    @CheckResult
    public static List<com.google.android.exoplayer2.mediacodec.c> v(List<com.google.android.exoplayer2.mediacodec.c> list, final com.google.android.exoplayer2.d dVar) {
        ArrayList arrayList = new ArrayList(list);
        Q(arrayList, new ScoreProvider() { // from class: com.google.android.exoplayer2.mediacodec.g
            @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.ScoreProvider
            public final int getScore(Object obj) {
                return MediaCodecUtil.M(dVar, (c) obj);
            }
        });
        return arrayList;
    }

    @Nullable
    public static com.google.android.exoplayer2.mediacodec.c w() throws DecoderQueryException {
        return s("audio/raw", false, false);
    }

    @Nullable
    public static Pair<Integer, Integer> x(String str, String[] strArr) {
        if (strArr.length < 3) {
            Log.n(f3449a, "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = f3451a.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.n(f3449a, "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer numL = l(strGroup);
        if (numL == null) {
            Log.n(f3449a, "Unknown Dolby Vision profile string: " + strGroup);
            return null;
        }
        String str2 = strArr[2];
        Integer numK = k(str2);
        if (numK != null) {
            return new Pair<>(numL, numK);
        }
        Log.n(f3449a, "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    @Nullable
    public static Pair<Integer, Integer> y(String str, String[] strArr) {
        if (strArr.length < 4) {
            Log.n(f3449a, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i = 1;
        Matcher matcher = f3451a.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.n(f3449a, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        if (!"1".equals(strGroup)) {
            if (!"2".equals(strGroup)) {
                Log.n(f3449a, "Unknown HEVC profile string: " + strGroup);
                return null;
            }
            i = 2;
        }
        String str2 = strArr[3];
        Integer numA = A(str2);
        if (numA != null) {
            return new Pair<>(Integer.valueOf(i), numA);
        }
        Log.n(f3449a, "Unknown HEVC level string: " + str2);
        return null;
    }

    @Nullable
    public static Pair<Integer, Integer> z(String str, String[] strArr) {
        if (strArr.length < 3) {
            Log.n(f3449a, "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int i = Integer.parseInt(strArr[1]);
            int i2 = Integer.parseInt(strArr[2]);
            int iS = S(i);
            if (iS == -1) {
                Log.n(f3449a, "Unknown VP9 profile: " + i);
                return null;
            }
            int iR = R(i2);
            if (iR != -1) {
                return new Pair<>(Integer.valueOf(iS), Integer.valueOf(iR));
            }
            Log.n(f3449a, "Unknown VP9 level: " + i2);
            return null;
        } catch (NumberFormatException unused) {
            Log.n(f3449a, "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }
}
