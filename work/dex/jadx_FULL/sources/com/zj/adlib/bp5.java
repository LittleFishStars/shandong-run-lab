package com.zj.adlib;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.common.math.c;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class bp5 {
    public static final String A = "video/mp42";
    public static final String A0 = "application/x-mp4-vtt";
    public static final String B = "video/mp43";
    public static final String B0 = "application/x-mp4-cea-608";
    public static final String C = "video/x-unknown";
    public static final String C0 = "application/x-rawcc";
    public static final String D = "audio/mp4";
    public static final String D0 = "application/vobsub";
    public static final String E = "audio/mp4a-latm";
    public static final String E0 = "application/pgs";
    public static final String F = "audio/x-matroska";
    public static final String F0 = "application/x-scte35";
    public static final String G = "audio/webm";
    public static final String G0 = "application/x-camera-motion";
    public static final String H = "audio/mpeg";
    public static final String H0 = "application/x-emsg";
    public static final String I = "audio/mpeg-L1";
    public static final String I0 = "application/dvbsubs";
    public static final String J = "audio/mpeg-L2";
    public static final String J0 = "application/x-exif";
    public static final String K = "audio/mha1";
    public static final String K0 = "application/x-icy";
    public static final String L = "audio/mhm1";
    public static final String L0 = "application/vnd.dvb.ait";
    public static final String M = "audio/raw";
    public static final String M0 = "application/x-rtsp";
    public static final String N = "audio/g711-alaw";
    public static final String N0 = "image/jpeg";
    public static final String O = "audio/g711-mlaw";
    public static final String O0 = "ec+3";
    public static final String P = "audio/ac3";
    public static final String Q = "audio/eac3";
    public static final String R = "audio/eac3-joc";
    public static final String S = "audio/ac4";
    public static final String T = "audio/true-hd";
    public static final String U = "audio/vnd.dts";
    public static final String V = "audio/vnd.dts.hd";
    public static final String W = "audio/vnd.dts.hd;profile=lbr";
    public static final String X = "audio/vnd.dts.uhd;profile=p2";
    public static final String Y = "audio/vorbis";
    public static final String Z = "audio/opus";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40802a = "video";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ArrayList<a> f15609a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f15610a = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");
    public static final String a0 = "audio/amr";
    public static final String b = "audio";
    public static final String b0 = "audio/3gpp";
    public static final String c = "text";
    public static final String c0 = "audio/amr-wb";
    public static final String d = "image";
    public static final String d0 = "audio/flac";
    public static final String e = "application";
    public static final String e0 = "audio/midi";
    public static final String f = "video/mp4";
    public static final String f0 = "audio/alac";
    public static final String g = "video/x-matroska";
    public static final String g0 = "audio/gsm";
    public static final String h = "video/webm";
    public static final String h0 = "audio/ogg";
    public static final String i = "video/3gpp";
    public static final String i0 = "audio/wav";
    public static final String j = "video/avc";
    public static final String j0 = "audio/x-unknown";
    public static final String k = "video/hevc";
    public static final String k0 = "text/vtt";
    public static final String l = "video/x-vnd.on2.vp8";
    public static final String l0 = "text/x-ssa";
    public static final String m = "video/x-vnd.on2.vp9";
    public static final String m0 = "text/x-exoplayer-cues";
    public static final String n = "video/av01";
    public static final String n0 = "text/x-unknown";
    public static final String o = "video/mp2t";
    public static final String o0 = "application/mp4";
    public static final String p = "video/mp4v-es";
    public static final String p0 = "application/webm";
    public static final String q = "video/mpeg";
    public static final String q0 = "application/x-matroska";
    public static final String r = "video/mp2p";
    public static final String r0 = "application/dash+xml";
    public static final String s = "video/mpeg2";
    public static final String s0 = "application/x-mpegURL";
    public static final String t = "video/wvc1";
    public static final String t0 = "application/vnd.ms-sstr+xml";
    public static final String u = "video/divx";
    public static final String u0 = "application/id3";
    public static final String v = "video/x-flv";
    public static final String v0 = "application/cea-608";
    public static final String w = "video/dolby-vision";
    public static final String w0 = "application/cea-708";
    public static final String x = "video/ogg";
    public static final String x0 = "application/x-subrip";
    public static final String y = "video/x-msvideo";
    public static final String y0 = "application/ttml+xml";
    public static final String z = "video/mjpeg";
    public static final String z0 = "application/x-quicktime-tx3g";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f40803a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f15611a;
        public final String b;

        public a(String str, String str2, int i) {
            this.f15611a = str;
            this.b = str2;
            this.f40803a = i;
        }
    }

    @VisibleForTesting
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f40804a;
        public final int b;

        public b(int i, int i2) {
            this.f40804a = i;
            this.b = i2;
        }

        public int a() {
            int i = this.b;
            if (i == 2) {
                return 10;
            }
            if (i == 5) {
                return 11;
            }
            if (i == 29) {
                return 12;
            }
            if (i == 42) {
                return 16;
            }
            if (i != 22) {
                return i != 23 ? 0 : 15;
            }
            return 1073741824;
        }
    }

    public static boolean a(@Nullable String str, @Nullable String str2) {
        b bVarI;
        int iA;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/eac3-joc":
            case "audio/mpeg-L1":
            case "audio/mpeg-L2":
            case "audio/ac3":
            case "audio/raw":
            case "audio/eac3":
            case "audio/flac":
            case "audio/mpeg":
            case "audio/g711-alaw":
            case "audio/g711-mlaw":
                return true;
            case "audio/mp4a-latm":
                return (str2 == null || (bVarI = i(str2)) == null || (iA = bVarI.a()) == 0 || iA == 16) ? false : true;
            default:
                return false;
        }
    }

    public static boolean b(@Nullable String str, String str2) {
        return d(str, str2) != null;
    }

    @Nullable
    public static String c(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : gj9.w1(str)) {
            String strG = g(str2);
            if (strG != null && p(strG)) {
                return strG;
            }
        }
        return null;
    }

    @Nullable
    public static String d(@Nullable String str, @Nullable String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String[] strArrW1 = gj9.w1(str);
        StringBuilder sb = new StringBuilder();
        for (String str3 : strArrW1) {
            if (str2.equals(g(str3))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str3);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    @Nullable
    public static String e(String str) {
        int size = f15609a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = f15609a.get(i2);
            if (str.startsWith(aVar.b)) {
                return aVar.f15611a;
            }
        }
        return null;
    }

    public static int f(String str, @Nullable String str2) {
        b bVarI;
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (bVarI = i(str2)) == null) {
                    return 0;
                }
                return bVarI.a();
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    @Nullable
    public static String g(@Nullable String str) {
        b bVarI;
        String strH = null;
        if (str == null) {
            return null;
        }
        String strG = com.google.common.base.a.g(str.trim());
        if (strG.startsWith("avc1") || strG.startsWith(VisualSampleEntry.TYPE4)) {
            return "video/avc";
        }
        if (strG.startsWith("hev1") || strG.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (strG.startsWith("dvav") || strG.startsWith("dva1") || strG.startsWith("dvhe") || strG.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (strG.startsWith(MediaCodecUtil.g)) {
            return "video/av01";
        }
        if (strG.startsWith("vp9") || strG.startsWith(MediaCodecUtil.d)) {
            return "video/x-vnd.on2.vp9";
        }
        if (strG.startsWith("vp8") || strG.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (strG.startsWith("mp4a")) {
            if (strG.startsWith("mp4a.") && (bVarI = i(strG)) != null) {
                strH = h(bVarI.f40804a);
            }
            return strH == null ? "audio/mp4a-latm" : strH;
        }
        if (strG.startsWith("mha1")) {
            return "audio/mha1";
        }
        if (strG.startsWith("mhm1")) {
            return "audio/mhm1";
        }
        if (strG.startsWith(AudioSampleEntry.TYPE8) || strG.startsWith(AC3SpecificBox.TYPE)) {
            return "audio/ac3";
        }
        if (strG.startsWith(AudioSampleEntry.TYPE9) || strG.startsWith(EC3SpecificBox.TYPE)) {
            return "audio/eac3";
        }
        if (strG.startsWith("ec+3")) {
            return "audio/eac3-joc";
        }
        if (strG.startsWith("ac-4") || strG.startsWith("dac4")) {
            return "audio/ac4";
        }
        if (strG.startsWith("dtsc")) {
            return "audio/vnd.dts";
        }
        if (strG.startsWith(AudioSampleEntry.TYPE13)) {
            return "audio/vnd.dts.hd;profile=lbr";
        }
        if (strG.startsWith(AudioSampleEntry.TYPE12) || strG.startsWith(AudioSampleEntry.TYPE11)) {
            return "audio/vnd.dts.hd";
        }
        if (strG.startsWith("dtsx")) {
            return "audio/vnd.dts.uhd;profile=p2";
        }
        if (strG.startsWith("opus")) {
            return "audio/opus";
        }
        if (strG.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        if (strG.startsWith("flac")) {
            return "audio/flac";
        }
        if (strG.startsWith("stpp")) {
            return "application/ttml+xml";
        }
        if (strG.startsWith("wvtt")) {
            return "text/vtt";
        }
        if (strG.contains("cea708")) {
            return "application/cea-708";
        }
        return (strG.contains("eia608") || strG.contains("cea608")) ? "application/cea-608" : e(strG);
    }

    @Nullable
    public static String h(int i2) {
        if (i2 == 32) {
            return "video/mp4v-es";
        }
        if (i2 == 33) {
            return "video/avc";
        }
        if (i2 == 35) {
            return "video/hevc";
        }
        if (i2 == 64) {
            return "audio/mp4a-latm";
        }
        if (i2 == 163) {
            return "video/wvc1";
        }
        if (i2 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i2 == 165) {
            return "audio/ac3";
        }
        if (i2 == 166) {
            return "audio/eac3";
        }
        switch (i2) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i2) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case c.f6376a /* 170 */:
                    case MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE /* 171 */:
                        return "audio/vnd.dts.hd";
                    case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT /* 173 */:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    @Nullable
    @VisibleForTesting
    public static b i(String str) {
        Matcher matcher = f15610a.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) sb0.g(matcher.group(1));
        String strGroup = matcher.group(2);
        try {
            return new b(Integer.parseInt(str2, 16), strGroup != null ? Integer.parseInt(strGroup) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public static String j(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : gj9.w1(str)) {
            String strG = g(str2);
            if (strG != null && s(strG)) {
                return strG;
            }
        }
        return null;
    }

    @Nullable
    public static String k(@Nullable String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    public static int l(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (p(str)) {
            return 1;
        }
        if (t(str)) {
            return 2;
        }
        if (s(str)) {
            return 3;
        }
        if (q(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        return m(str);
    }

    public static int m(String str) {
        int size = f15609a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = f15609a.get(i2);
            if (str.equals(aVar.f15611a)) {
                return aVar.f40803a;
            }
        }
        return -1;
    }

    public static int n(String str) {
        return l(g(str));
    }

    @Nullable
    public static String o(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : gj9.w1(str)) {
            String strG = g(str2);
            if (strG != null && t(strG)) {
                return strG;
            }
        }
        return null;
    }

    public static boolean p(@Nullable String str) {
        return "audio".equals(k(str));
    }

    public static boolean q(@Nullable String str) {
        return "image".equals(k(str));
    }

    public static boolean r(@Nullable String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm") || str.startsWith("video/x-matroska") || str.startsWith("audio/x-matroska") || str.startsWith("application/x-matroska");
    }

    public static boolean s(@Nullable String str) {
        return "text".equals(k(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean t(@Nullable String str) {
        return "video".equals(k(str));
    }

    public static String u(String str) {
        str.hashCode();
        switch (str) {
            case "audio/x-flac":
                return "audio/flac";
            case "audio/x-wav":
                return "audio/wav";
            case "audio/mp3":
                return "audio/mpeg";
            default:
                return str;
        }
    }

    public static void v(String str, String str2, int i2) {
        a aVar = new a(str, str2, i2);
        int size = f15609a.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList<a> arrayList = f15609a;
            if (str.equals(arrayList.get(i3).f15611a)) {
                arrayList.remove(i3);
                break;
            }
        }
        f15609a.add(aVar);
    }
}
