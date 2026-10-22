package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.o;
import com.zj.adlib.bp5;
import com.zj.adlib.gj9;
import com.zj.adlib.rh9;
import com.zj.adlib.sb0;
import com.zj.adlib.u15;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    public static final String A = "#EXT-X-START";
    public static final String B = "#EXT-X-ENDLIST";
    public static final String C = "#EXT-X-KEY";
    public static final String D = "#EXT-X-SESSION-KEY";
    public static final String E = "#EXT-X-BYTERANGE";
    public static final String F = "#EXT-X-GAP";
    public static final String G = "#EXT-X-SKIP";
    public static final String H = "#EXT-X-PRELOAD-HINT";
    public static final String I = "#EXT-X-RENDITION-REPORT";
    public static final String J = "AUDIO";
    public static final String K = "VIDEO";
    public static final String L = "SUBTITLES";
    public static final String M = "CLOSED-CAPTIONS";
    public static final String N = "PART";
    public static final String O = "MAP";
    public static final String P = "NONE";
    public static final String Q = "AES-128";
    public static final String R = "SAMPLE-AES";
    public static final String S = "SAMPLE-AES-CENC";
    public static final String T = "SAMPLE-AES-CTR";
    public static final String U = "com.microsoft.playready";
    public static final String V = "identity";
    public static final String W = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    public static final String X = "com.widevine";
    public static final String Y = "YES";
    public static final String Z = "NO";
    public static final String a0 = "CLOSED-CAPTIONS=NONE";
    public static final String f = "HlsPlaylistParser";
    public static final String g = "#EXTM3U";
    public static final String h = "#EXT";
    public static final String i = "#EXT-X-VERSION";
    public static final String j = "#EXT-X-PLAYLIST-TYPE";
    public static final String k = "#EXT-X-DEFINE";
    public static final String l = "#EXT-X-SERVER-CONTROL";
    public static final String m = "#EXT-X-STREAM-INF";
    public static final String n = "#EXT-X-PART-INF";
    public static final String o = "#EXT-X-PART";
    public static final String p = "#EXT-X-I-FRAME-STREAM-INF";
    public static final String q = "#EXT-X-I-FRAMES-ONLY";
    public static final String r = "#EXT-X-MEDIA";
    public static final String s = "#EXT-X-TARGETDURATION";
    public static final String t = "#EXT-X-DISCONTINUITY";
    public static final String u = "#EXT-X-DISCONTINUITY-SEQUENCE";
    public static final String v = "#EXT-X-PROGRAM-DATE-TIME";
    public static final String w = "#EXT-X-MAP";
    public static final String x = "#EXT-X-INDEPENDENT-SEGMENTS";
    public static final String y = "#EXTINF";
    public static final String z = "#EXT-X-MEDIA-SEQUENCE";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final HlsMediaPlaylist f4236a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f4237a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f30929a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    public static final Pattern b = Pattern.compile("VIDEO=\"(.+?)\"");
    public static final Pattern c = Pattern.compile("AUDIO=\"(.+?)\"");
    public static final Pattern d = Pattern.compile("SUBTITLES=\"(.+?)\"");
    public static final Pattern e = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final Pattern f4215f = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final Pattern f4216g = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final Pattern f4217h = Pattern.compile("CODECS=\"(.+?)\"");

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final Pattern f4218i = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final Pattern f4219j = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public static final Pattern f4220k = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public static final Pattern f4221l = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public static final Pattern f4222m = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public static final Pattern f4223n = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    public static final Pattern f4224o = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* JADX INFO: renamed from: p, reason: collision with other field name */
    public static final Pattern f4225p = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: q, reason: collision with other field name */
    public static final Pattern f4226q = b("CAN-SKIP-DATERANGES");

    /* JADX INFO: renamed from: r, reason: collision with other field name */
    public static final Pattern f4227r = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");

    /* JADX INFO: renamed from: s, reason: collision with other field name */
    public static final Pattern f4228s = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: t, reason: collision with other field name */
    public static final Pattern f4229t = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: u, reason: collision with other field name */
    public static final Pattern f4230u = b("CAN-BLOCK-RELOAD");

    /* JADX INFO: renamed from: v, reason: collision with other field name */
    public static final Pattern f4231v = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* JADX INFO: renamed from: w, reason: collision with other field name */
    public static final Pattern f4232w = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: x, reason: collision with other field name */
    public static final Pattern f4233x = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");

    /* JADX INFO: renamed from: y, reason: collision with other field name */
    public static final Pattern f4234y = Pattern.compile("LAST-MSN=(\\d+)\\b");

    /* JADX INFO: renamed from: z, reason: collision with other field name */
    public static final Pattern f4235z = Pattern.compile("LAST-PART=(\\d+)\\b");

    /* JADX INFO: renamed from: A, reason: collision with other field name */
    public static final Pattern f4189A = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");

    /* JADX INFO: renamed from: B, reason: collision with other field name */
    public static final Pattern f4190B = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");

    /* JADX INFO: renamed from: C, reason: collision with other field name */
    public static final Pattern f4191C = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");

    /* JADX INFO: renamed from: D, reason: collision with other field name */
    public static final Pattern f4192D = Pattern.compile("BYTERANGE-START=(\\d+)\\b");

    /* JADX INFO: renamed from: E, reason: collision with other field name */
    public static final Pattern f4193E = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");

    /* JADX INFO: renamed from: F, reason: collision with other field name */
    public static final Pattern f4194F = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");

    /* JADX INFO: renamed from: G, reason: collision with other field name */
    public static final Pattern f4195G = Pattern.compile("KEYFORMAT=\"(.+?)\"");

    /* JADX INFO: renamed from: H, reason: collision with other field name */
    public static final Pattern f4196H = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");

    /* JADX INFO: renamed from: I, reason: collision with other field name */
    public static final Pattern f4197I = Pattern.compile("URI=\"(.+?)\"");

    /* JADX INFO: renamed from: J, reason: collision with other field name */
    public static final Pattern f4198J = Pattern.compile("IV=([^,.*]+)");

    /* JADX INFO: renamed from: K, reason: collision with other field name */
    public static final Pattern f4199K = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");

    /* JADX INFO: renamed from: L, reason: collision with other field name */
    public static final Pattern f4200L = Pattern.compile("TYPE=(PART|MAP)");

    /* JADX INFO: renamed from: M, reason: collision with other field name */
    public static final Pattern f4201M = Pattern.compile("LANGUAGE=\"(.+?)\"");

    /* JADX INFO: renamed from: N, reason: collision with other field name */
    public static final Pattern f4202N = Pattern.compile("NAME=\"(.+?)\"");

    /* JADX INFO: renamed from: O, reason: collision with other field name */
    public static final Pattern f4203O = Pattern.compile("GROUP-ID=\"(.+?)\"");

    /* JADX INFO: renamed from: P, reason: collision with other field name */
    public static final Pattern f4204P = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");

    /* JADX INFO: renamed from: Q, reason: collision with other field name */
    public static final Pattern f4205Q = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");

    /* JADX INFO: renamed from: R, reason: collision with other field name */
    public static final Pattern f4206R = b("AUTOSELECT");

    /* JADX INFO: renamed from: S, reason: collision with other field name */
    public static final Pattern f4207S = b("DEFAULT");

    /* JADX INFO: renamed from: T, reason: collision with other field name */
    public static final Pattern f4208T = b("FORCED");

    /* JADX INFO: renamed from: U, reason: collision with other field name */
    public static final Pattern f4209U = b("INDEPENDENT");

    /* JADX INFO: renamed from: V, reason: collision with other field name */
    public static final Pattern f4210V = b("GAP");

    /* JADX INFO: renamed from: W, reason: collision with other field name */
    public static final Pattern f4211W = b("PRECISE");

    /* JADX INFO: renamed from: X, reason: collision with other field name */
    public static final Pattern f4212X = Pattern.compile("VALUE=\"(.+?)\"");

    /* JADX INFO: renamed from: Y, reason: collision with other field name */
    public static final Pattern f4213Y = Pattern.compile("IMPORT=\"(.+?)\"");

    /* JADX INFO: renamed from: Z, reason: collision with other field name */
    public static final Pattern f4214Z = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    public static final class DeltaUpdateException extends IOException {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedReader f30930a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public String f4238a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Queue<String> f4239a;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.f4239a = queue;
            this.f30930a = bufferedReader;
        }

        @EnsuresNonNullIf(expression = {"next"}, result = true)
        public boolean a() throws IOException {
            String strTrim;
            if (this.f4238a != null) {
                return true;
            }
            if (!this.f4239a.isEmpty()) {
                this.f4238a = (String) sb0.g(this.f4239a.poll());
                return true;
            }
            do {
                String line = this.f30930a.readLine();
                this.f4238a = line;
                if (line == null) {
                    return false;
                }
                strTrim = line.trim();
                this.f4238a = strTrim;
            } while (strTrim.isEmpty());
            return true;
        }

        public String b() throws IOException {
            if (!a()) {
                throw new NoSuchElementException();
            }
            String str = this.f4238a;
            this.f4238a = null;
            return str;
        }
    }

    public HlsPlaylistParser() {
        this(c.f4262a, null);
    }

    public static String A(String str, Map<String, String> map) {
        Matcher matcher = f4214Z.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (map.containsKey(strGroup)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(strGroup)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static int B(BufferedReader bufferedReader, boolean z2, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !gj9.K0(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    public static boolean a(BufferedReader bufferedReader) throws IOException {
        int i2 = bufferedReader.read();
        if (i2 == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            i2 = bufferedReader.read();
        }
        int iB = B(bufferedReader, true, i2);
        for (int i3 = 0; i3 < 7; i3++) {
            if (iB != g.charAt(i3)) {
                return false;
            }
            iB = bufferedReader.read();
        }
        return gj9.K0(B(bufferedReader, false, iB));
    }

    public static Pattern b(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }

    public static DrmInitData c(@Nullable String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i2 = 0; i2 < schemeDataArr.length; i2++) {
            schemeDataArr2[i2] = schemeDataArr[i2].copyWithData(null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    @Nullable
    public static String d(long j2, @Nullable String str, @Nullable String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j2);
    }

    @Nullable
    public static c.b e(ArrayList<c.b> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.b bVar = arrayList.get(i2);
            if (str.equals(bVar.b)) {
                return bVar;
            }
        }
        return null;
    }

    @Nullable
    public static c.b f(ArrayList<c.b> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.b bVar = arrayList.get(i2);
            if (str.equals(bVar.c)) {
                return bVar;
            }
        }
        return null;
    }

    @Nullable
    public static c.b g(ArrayList<c.b> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.b bVar = arrayList.get(i2);
            if (str.equals(bVar.f4270a)) {
                return bVar;
            }
        }
        return null;
    }

    public static double i(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(y(str, pattern, Collections.emptyMap()));
    }

    @Nullable
    public static DrmInitData.SchemeData j(String str, String str2, Map<String, String> map) throws ParserException {
        String strT = t(str, f4196H, "1", map);
        if (W.equals(str2)) {
            String strY = y(str, f4197I, map);
            return new DrmInitData.SchemeData(C.f2005d, "video/mp4", Base64.decode(strY.substring(strY.indexOf(44)), 0));
        }
        if (X.equals(str2)) {
            return new DrmInitData.SchemeData(C.f2005d, LiveConfigKey.HLS, gj9.z0(str));
        }
        if (!U.equals(str2) || !"1".equals(strT)) {
            return null;
        }
        String strY2 = y(str, f4197I, map);
        byte[] bArrDecode = Base64.decode(strY2.substring(strY2.indexOf(44)), 0);
        UUID uuid = C.f2008e;
        return new DrmInitData.SchemeData(uuid, "video/mp4", com.google.android.exoplayer2.extractor.mp4.c.a(uuid, bArrDecode));
    }

    public static String k(String str) {
        return (S.equals(str) || T.equals(str)) ? "cenc" : "cbcs";
    }

    public static int l(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(y(str, pattern, Collections.emptyMap()));
    }

    public static long m(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(y(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static HlsMediaPlaylist n(c cVar, @Nullable HlsMediaPlaylist hlsMediaPlaylist, a aVar, String str) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        boolean z2;
        int i2;
        HlsMediaPlaylist.b bVar;
        String strU;
        long j2;
        long j3;
        long j4;
        long j5;
        boolean z3;
        Object drmInitData;
        cVar = cVar;
        hlsMediaPlaylist = hlsMediaPlaylist;
        boolean z4 = ((HlsPlaylist) cVar).f4188a;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        HlsMediaPlaylist.f fVar = new HlsMediaPlaylist.f(-9223372036854775807L, false, -9223372036854775807L, -9223372036854775807L, false);
        TreeMap treeMap = new TreeMap();
        boolean z5 = false;
        String str3 = "";
        boolean z6 = z4;
        HlsMediaPlaylist.f fVarX = fVar;
        int i3 = 0;
        boolean zP = false;
        boolean z7 = false;
        int i4 = 0;
        boolean z8 = false;
        boolean z9 = false;
        int i5 = 0;
        boolean z10 = false;
        String strT = str3;
        String strY = null;
        long jI = -9223372036854775807L;
        long jZ0 = 0;
        long j6 = 0;
        int iL = 1;
        long jL = -9223372036854775807L;
        long jI2 = -9223372036854775807L;
        DrmInitData drmInitDataC = null;
        long j7 = 0;
        Object obj = null;
        long j8 = 0;
        long j9 = -1;
        String str4 = null;
        String strK = null;
        long j10 = 0;
        long jM = 0;
        HlsMediaPlaylist.d dVar = null;
        long jZ = 0;
        long j11 = 0;
        ArrayList arrayList7 = arrayList4;
        HlsMediaPlaylist.b bVar2 = null;
        while (aVar.a()) {
            String strB = aVar.b();
            if (strB.startsWith(h)) {
                arrayList6.add(strB);
            }
            if (strB.startsWith(j)) {
                String strY2 = y(strB, f4224o, map);
                if ("VOD".equals(strY2)) {
                    i3 = 1;
                } else if ("EVENT".equals(strY2)) {
                    i3 = 2;
                }
            } else if (strB.equals(q)) {
                z10 = true;
            } else if (strB.startsWith(A)) {
                jI = (long) (i(strB, f4189A) * 1000000.0d);
                zP = p(strB, f4211W, z5);
            } else if (strB.startsWith(l)) {
                fVarX = x(strB);
            } else if (strB.startsWith(n)) {
                jI2 = (long) (i(strB, f4222m) * 1000000.0d);
            } else if (strB.startsWith(w)) {
                String strY3 = y(strB, f4197I, map);
                String strU2 = u(strB, f4191C, map);
                if (strU2 != null) {
                    String[] strArrU1 = gj9.u1(strU2, "@");
                    j9 = Long.parseLong(strArrU1[z5 ? 1 : 0]);
                    if (strArrU1.length > 1) {
                        j7 = Long.parseLong(strArrU1[1]);
                    }
                }
                if (j9 == -1) {
                    j7 = 0;
                }
                String str5 = str4;
                if (strY != null && str5 == null) {
                    throw ParserException.createForMalformedManifest("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                }
                dVar = new HlsMediaPlaylist.d(strY3, j7, j9, strY, str5);
                if (j9 != -1) {
                    j7 += j9;
                }
                str4 = str5;
                j9 = -1;
            } else {
                String str6 = str4;
                if (strB.startsWith(s)) {
                    jL = 1000000 * ((long) l(strB, f4220k));
                } else {
                    if (strB.startsWith(z)) {
                        jM = m(strB, f4231v);
                        str4 = str6;
                        j6 = jM;
                    } else if (strB.startsWith(i)) {
                        iL = l(strB, f4223n);
                    } else {
                        if (strB.startsWith(k)) {
                            String strU3 = u(strB, f4213Y, map);
                            if (strU3 != null) {
                                String str7 = cVar.f4264a.get(strU3);
                                if (str7 != null) {
                                    map.put(strU3, str7);
                                }
                            } else {
                                map.put(y(strB, f4202N, map), y(strB, f4212X, map));
                            }
                            arrayList = arrayList7;
                            arrayList2 = arrayList6;
                            str2 = strK;
                            z2 = false;
                            i2 = i3;
                        } else if (strB.startsWith(y)) {
                            jZ = z(strB, f4232w);
                            strT = t(strB, f4233x, str3, map);
                        } else {
                            String str8 = str3;
                            if (strB.startsWith(G)) {
                                int iL2 = l(strB, f4227r);
                                sb0.i(hlsMediaPlaylist != null && arrayList3.isEmpty());
                                int i6 = (int) (j6 - ((HlsMediaPlaylist) gj9.k(hlsMediaPlaylist)).f4171c);
                                int i7 = iL2 + i6;
                                if (i6 < 0 || i7 > hlsMediaPlaylist.f4169b.size()) {
                                    throw new DeltaUpdateException();
                                }
                                str3 = str8;
                                String str9 = str6;
                                long j12 = j10;
                                while (i6 < i7) {
                                    HlsMediaPlaylist.d dVarB = hlsMediaPlaylist.f4169b.get(i6);
                                    ArrayList arrayList8 = arrayList7;
                                    ArrayList arrayList9 = arrayList6;
                                    if (j6 != hlsMediaPlaylist.f4171c) {
                                        dVarB = dVarB.b(j12, (hlsMediaPlaylist.b - i4) + dVarB.K);
                                    }
                                    arrayList3.add(dVarB);
                                    j12 += ((HlsMediaPlaylist.e) dVarB).f30926a;
                                    long j13 = dVarB.d;
                                    if (j13 != -1) {
                                        j7 = dVarB.c + j13;
                                    }
                                    int i8 = dVarB.K;
                                    HlsMediaPlaylist.d dVar2 = ((HlsMediaPlaylist.e) dVarB).f4183a;
                                    DrmInitData drmInitData2 = ((HlsMediaPlaylist.e) dVarB).f4182a;
                                    String str10 = dVarB.g;
                                    String str11 = dVarB.h;
                                    if (str11 == null || !str11.equals(Long.toHexString(jM))) {
                                        str9 = dVarB.h;
                                    }
                                    jM++;
                                    i6++;
                                    hlsMediaPlaylist = hlsMediaPlaylist;
                                    obj = drmInitData2;
                                    strY = str10;
                                    j8 = j12;
                                    i7 = i7;
                                    i5 = i8;
                                    dVar = dVar2;
                                    arrayList7 = arrayList8;
                                    arrayList6 = arrayList9;
                                }
                                cVar = cVar;
                                hlsMediaPlaylist = hlsMediaPlaylist;
                                j10 = j12;
                                str4 = str9;
                            } else {
                                ArrayList arrayList10 = arrayList7;
                                arrayList2 = arrayList6;
                                str3 = str8;
                                if (strB.startsWith(C)) {
                                    String strY4 = y(strB, f4194F, map);
                                    String strT2 = t(strB, f4195G, V, map);
                                    if ("NONE".equals(strY4)) {
                                        treeMap.clear();
                                        strU = null;
                                        strY = null;
                                    } else {
                                        strU = u(strB, f4198J, map);
                                        if (V.equals(strT2)) {
                                            if (Q.equals(strY4)) {
                                                strY = y(strB, f4197I, map);
                                            }
                                            str4 = strU;
                                        } else {
                                            String str12 = strK;
                                            strK = str12 == null ? k(strY4) : str12;
                                            DrmInitData.SchemeData schemeDataJ = j(strB, strT2, map);
                                            if (schemeDataJ != null) {
                                                treeMap.put(strT2, schemeDataJ);
                                                strY = null;
                                            }
                                            str4 = strU;
                                        }
                                        strY = null;
                                        str4 = strU;
                                    }
                                    obj = strY;
                                    str4 = strU;
                                } else {
                                    String str13 = strK;
                                    if (strB.startsWith(E)) {
                                        String[] strArrU2 = gj9.u1(y(strB, f4190B, map), "@");
                                        j9 = Long.parseLong(strArrU2[0]);
                                        if (strArrU2.length > 1) {
                                            j7 = Long.parseLong(strArrU2[1]);
                                        }
                                    } else if (strB.startsWith(u)) {
                                        i4 = Integer.parseInt(strB.substring(strB.indexOf(58) + 1));
                                        cVar = cVar;
                                        hlsMediaPlaylist = hlsMediaPlaylist;
                                        strK = str13;
                                        str4 = str6;
                                        arrayList7 = arrayList10;
                                        arrayList6 = arrayList2;
                                        z5 = false;
                                        z7 = true;
                                    } else if (strB.equals(t)) {
                                        i5++;
                                    } else {
                                        if (strB.startsWith(v)) {
                                            if (jZ0 == 0) {
                                                jZ0 = gj9.Z0(gj9.h1(strB.substring(strB.indexOf(58) + 1))) - j10;
                                            } else {
                                                i2 = i3;
                                                str2 = str13;
                                            }
                                        } else if (strB.equals(F)) {
                                            cVar = cVar;
                                            hlsMediaPlaylist = hlsMediaPlaylist;
                                            strK = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z5 = false;
                                            z9 = true;
                                        } else if (strB.equals(x)) {
                                            cVar = cVar;
                                            hlsMediaPlaylist = hlsMediaPlaylist;
                                            strK = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z5 = false;
                                            z6 = true;
                                        } else if (strB.equals(B)) {
                                            cVar = cVar;
                                            hlsMediaPlaylist = hlsMediaPlaylist;
                                            strK = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z5 = false;
                                            z8 = true;
                                        } else if (strB.startsWith(I)) {
                                            i2 = i3;
                                            str2 = str13;
                                            arrayList5.add(new HlsMediaPlaylist.c(Uri.parse(rh9.e(str, y(strB, f4197I, map))), s(strB, f4234y, -1L), r(strB, f4235z, -1)));
                                        } else {
                                            i2 = i3;
                                            str2 = str13;
                                            if (!strB.startsWith(H)) {
                                                jM = jM;
                                                if (strB.startsWith(o)) {
                                                    String strD = d(jM, strY, str6);
                                                    String strY5 = y(strB, f4197I, map);
                                                    long jI3 = (long) (i(strB, f4221l) * 1000000.0d);
                                                    HlsMediaPlaylist.b bVar3 = bVar2;
                                                    boolean zP2 = p(strB, f4209U, false) | (z6 && arrayList10.isEmpty());
                                                    boolean zP3 = p(strB, f4210V, false);
                                                    String strU4 = u(strB, f4191C, map);
                                                    if (strU4 != null) {
                                                        String[] strArrU3 = gj9.u1(strU4, "@");
                                                        j3 = Long.parseLong(strArrU3[0]);
                                                        if (strArrU3.length > 1) {
                                                            j11 = Long.parseLong(strArrU3[1]);
                                                        }
                                                        j2 = -1;
                                                    } else {
                                                        j2 = -1;
                                                        j3 = -1;
                                                    }
                                                    if (j3 == j2) {
                                                        j11 = 0;
                                                    }
                                                    if (obj == null && !treeMap.isEmpty()) {
                                                        DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        DrmInitData drmInitData3 = new DrmInitData(str2, schemeDataArr);
                                                        if (drmInitDataC == null) {
                                                            drmInitDataC = c(str2, schemeDataArr);
                                                        }
                                                        obj = drmInitData3;
                                                    }
                                                    arrayList10.add(new HlsMediaPlaylist.b(strY5, dVar, jI3, i5, j8, obj, strY, strD, j11, j3, zP3, zP2, false));
                                                    j8 += jI3;
                                                    if (j3 != j2) {
                                                        j11 += j3;
                                                    }
                                                    cVar = cVar;
                                                    hlsMediaPlaylist = hlsMediaPlaylist;
                                                    str4 = str6;
                                                    i3 = i2;
                                                    bVar2 = bVar3;
                                                    jM = jM;
                                                    strK = str2;
                                                    arrayList7 = arrayList10;
                                                    arrayList6 = arrayList2;
                                                } else {
                                                    bVar = bVar2;
                                                    arrayList = arrayList10;
                                                    if (strB.startsWith("#")) {
                                                        z2 = false;
                                                        cVar = cVar;
                                                        str4 = str6;
                                                        i3 = i2;
                                                        bVar2 = bVar;
                                                        jM = jM;
                                                        strK = str2;
                                                        arrayList7 = arrayList;
                                                        arrayList6 = arrayList2;
                                                        z5 = z2;
                                                        hlsMediaPlaylist = hlsMediaPlaylist;
                                                    } else {
                                                        String strD2 = d(jM, strY, str6);
                                                        long j14 = jM + 1;
                                                        String strA = A(strB, map);
                                                        HlsMediaPlaylist.d dVar3 = (HlsMediaPlaylist.d) map2.get(strA);
                                                        if (j9 == -1) {
                                                            j4 = 0;
                                                        } else {
                                                            if (z10 && dVar == null && dVar3 == null) {
                                                                dVar3 = new HlsMediaPlaylist.d(strA, 0L, j7, null, null);
                                                                map2.put(strA, dVar3);
                                                            }
                                                            j4 = j7;
                                                        }
                                                        if (obj != null || treeMap.isEmpty()) {
                                                            j5 = j14;
                                                            z3 = false;
                                                            drmInitData = obj;
                                                        } else {
                                                            j5 = j14;
                                                            z3 = false;
                                                            DrmInitData.SchemeData[] schemeDataArr2 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                            drmInitData = new DrmInitData(str2, schemeDataArr2);
                                                            if (drmInitDataC == null) {
                                                                drmInitDataC = c(str2, schemeDataArr2);
                                                            }
                                                        }
                                                        arrayList3.add(new HlsMediaPlaylist.d(strA, dVar != null ? dVar : dVar3, strT, jZ, i5, j10, drmInitData, strY, strD2, j4, j9, z9, arrayList));
                                                        j8 = j10 + jZ;
                                                        arrayList7 = new ArrayList();
                                                        if (j9 != -1) {
                                                            j4 += j9;
                                                        }
                                                        j7 = j4;
                                                        cVar = cVar;
                                                        z9 = z3;
                                                        str4 = str6;
                                                        obj = drmInitData;
                                                        strT = str3;
                                                        j10 = j8;
                                                        i3 = i2;
                                                        bVar2 = bVar;
                                                        arrayList6 = arrayList2;
                                                        j9 = -1;
                                                        jZ = 0;
                                                        strK = str2;
                                                        jM = j5;
                                                        hlsMediaPlaylist = hlsMediaPlaylist;
                                                        z5 = z9;
                                                    }
                                                }
                                            } else if (bVar2 == null && N.equals(y(strB, f4200L, map))) {
                                                String strY6 = y(strB, f4197I, map);
                                                long jS = s(strB, f4192D, -1L);
                                                long jS2 = s(strB, f4193E, -1L);
                                                long j15 = jM;
                                                String strD3 = d(j15, strY, str6);
                                                if (obj == null && !treeMap.isEmpty()) {
                                                    DrmInitData.SchemeData[] schemeDataArr3 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                    DrmInitData drmInitData4 = new DrmInitData(str2, schemeDataArr3);
                                                    if (drmInitDataC == null) {
                                                        drmInitDataC = c(str2, schemeDataArr3);
                                                    }
                                                    obj = drmInitData4;
                                                }
                                                if (jS == -1 || jS2 != -1) {
                                                    bVar2 = new HlsMediaPlaylist.b(strY6, dVar, 0L, i5, j8, obj, strY, strD3, jS != -1 ? jS : 0L, jS2, false, false, true);
                                                }
                                                cVar = cVar;
                                                hlsMediaPlaylist = hlsMediaPlaylist;
                                                jM = j15;
                                                str4 = str6;
                                                arrayList7 = arrayList10;
                                                i3 = i2;
                                                arrayList6 = arrayList2;
                                                strK = str2;
                                            }
                                        }
                                        arrayList = arrayList10;
                                        z2 = false;
                                    }
                                    strK = str13;
                                    str4 = str6;
                                }
                                arrayList7 = arrayList10;
                                arrayList6 = arrayList2;
                            }
                        }
                        bVar = bVar2;
                        cVar = cVar;
                        str4 = str6;
                        i3 = i2;
                        bVar2 = bVar;
                        jM = jM;
                        strK = str2;
                        arrayList7 = arrayList;
                        arrayList6 = arrayList2;
                        z5 = z2;
                        hlsMediaPlaylist = hlsMediaPlaylist;
                    }
                    z5 = false;
                }
                str4 = str6;
                z5 = false;
            }
        }
        int i9 = i3;
        HlsMediaPlaylist.b bVar4 = bVar2;
        ArrayList arrayList11 = arrayList7;
        ArrayList arrayList12 = arrayList6;
        Object[] objArr = z5 ? 1 : 0;
        HashMap map3 = new HashMap();
        for (int i10 = objArr == true ? 1 : 0; i10 < arrayList5.size(); i10++) {
            HlsMediaPlaylist.c cVar2 = (HlsMediaPlaylist.c) arrayList5.get(i10);
            long size = cVar2.f4180a;
            if (size == -1) {
                size = (j6 + ((long) arrayList3.size())) - (arrayList11.isEmpty() ? 1L : 0L);
            }
            int size2 = cVar2.f30924a;
            if (size2 == -1 && jI2 != -9223372036854775807L) {
                size2 = (arrayList11.isEmpty() ? ((HlsMediaPlaylist.d) o.w(arrayList3)).f30925a : arrayList11).size() - 1;
            }
            Uri uri = cVar2.f4181a;
            map3.put(uri, new HlsMediaPlaylist.c(uri, size, size2));
        }
        if (bVar4 != null) {
            arrayList11.add(bVar4);
        }
        return new HlsMediaPlaylist(i9, str, arrayList12, jI, zP, jZ0, z7, i4, j6, iL, jL, jI2, z6, z8, jZ0 != 0, drmInitDataC, arrayList3, arrayList11, fVarX, map3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:79:0x0326  */
    public static c o(a aVar, String str) throws IOException {
        ArrayList arrayList;
        String strG;
        int i2;
        String str2;
        String strG2;
        int i3;
        int i4;
        Uri uriF;
        HashMap map;
        int i5;
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            String str3 = "application/x-mpegURL";
            if (!aVar.a()) {
                HashMap map4 = map2;
                ArrayList arrayList10 = arrayList7;
                ArrayList arrayList11 = arrayList3;
                ArrayList arrayList12 = arrayList4;
                ArrayList arrayList13 = arrayList5;
                ArrayList arrayList14 = arrayList6;
                ArrayList arrayList15 = arrayList9;
                boolean z4 = z2;
                ArrayList arrayList16 = arrayList8;
                ArrayList arrayList17 = new ArrayList();
                HashSet hashSet = new HashSet();
                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                    c.b bVar = (c.b) arrayList2.get(i6);
                    if (hashSet.add(bVar.f30936a)) {
                        sb0.i(bVar.f4269a.f2567a == null);
                        arrayList17.add(bVar.a(bVar.f4269a.b().X(new Metadata(new HlsTrackMetadataEntry(null, null, (List) sb0.g((ArrayList) map4.get(bVar.f30936a))))).E()));
                    }
                }
                Uri uri = null;
                ArrayList arrayList18 = null;
                d dVarE = null;
                int i7 = 0;
                while (i7 < arrayList10.size()) {
                    ArrayList arrayList19 = arrayList10;
                    String str4 = (String) arrayList19.get(i7);
                    String strY = y(str4, f4203O, map3);
                    String strY2 = y(str4, f4202N, map3);
                    d.b bVarV = new d.b().S(strY + u15.f19942b + strY2).U(strY2).K(str3).g0(w(str4)).c0(v(str4, map3)).V(u(str4, f4201M, map3));
                    String strU = u(str4, f4197I, map3);
                    Uri uriF2 = strU == null ? uri : rh9.f(str, strU);
                    arrayList10 = arrayList19;
                    String str5 = str3;
                    Metadata metadata = new Metadata(new HlsTrackMetadataEntry(strY, strY2, Collections.emptyList()));
                    String strY3 = y(str4, f4199K, map3);
                    strY3.hashCode();
                    switch (strY3) {
                        case "SUBTITLES":
                            dVarE = dVarE;
                            arrayList12 = arrayList12;
                            arrayList = arrayList11;
                            c.b bVarF = f(arrayList2, strY);
                            if (bVarF != null) {
                                String strT = gj9.T(bVarF.f4269a.i, 3);
                                bVarV.I(strT);
                                strG = bp5.g(strT);
                            } else {
                                strG = null;
                            }
                            if (strG == null) {
                                strG = "text/vtt";
                            }
                            bVarV.e0(strG).X(metadata);
                            if (uriF2 != null) {
                                c.a aVar2 = new c.a(uriF2, bVarV.E(), strY, strY2);
                                arrayList13 = arrayList13;
                                arrayList13.add(aVar2);
                                break;
                            } else {
                                arrayList13 = arrayList13;
                                Log.n(f, "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                                break;
                            }
                            break;
                        case "CLOSED-CAPTIONS":
                            dVarE = dVarE;
                            arrayList12 = arrayList12;
                            arrayList = arrayList11;
                            String strY4 = y(str4, f4205Q, map3);
                            if (strY4.startsWith("CC")) {
                                i2 = Integer.parseInt(strY4.substring(2));
                                str2 = "application/cea-608";
                            } else {
                                i2 = Integer.parseInt(strY4.substring(7));
                                str2 = "application/cea-708";
                            }
                            if (arrayList18 == null) {
                                arrayList18 = new ArrayList();
                            }
                            bVarV.e0(str2).F(i2);
                            arrayList18.add(bVarV.E());
                            arrayList13 = arrayList13;
                            break;
                        case "AUDIO":
                            arrayList = arrayList11;
                            c.b bVarE = e(arrayList2, strY);
                            if (bVarE != null) {
                                String strT2 = gj9.T(bVarE.f4269a.i, 1);
                                bVarV.I(strT2);
                                strG2 = bp5.g(strT2);
                            } else {
                                strG2 = null;
                            }
                            String strU2 = u(str4, f4216g, map3);
                            if (strU2 != null) {
                                bVarV.H(Integer.parseInt(gj9.v1(strU2, WVNativeCallbackUtil.SEPERATER)[0]));
                                if ("audio/eac3".equals(strG2) && strU2.endsWith("/JOC")) {
                                    bVarV.I("ec+3");
                                    strG2 = "audio/eac3-joc";
                                }
                            }
                            bVarV.e0(strG2);
                            if (uriF2 != null) {
                                bVarV.X(metadata);
                                arrayList12 = arrayList12;
                                arrayList12.add(new c.a(uriF2, bVarV.E(), strY, strY2));
                            } else {
                                arrayList12 = arrayList12;
                                if (bVarE != null) {
                                    dVarE = bVarV.E();
                                }
                            }
                            arrayList13 = arrayList13;
                            break;
                        case "VIDEO":
                            c.b bVarG = g(arrayList2, strY);
                            if (bVarG != null) {
                                d dVar = bVarG.f4269a;
                                String strT3 = gj9.T(dVar.i, 2);
                                bVarV.I(strT3).e0(bp5.g(strT3)).j0(dVar.Q).Q(dVar.R).P(dVar.f2564a);
                            }
                            if (uriF2 != null) {
                                bVarV.X(metadata);
                                arrayList = arrayList11;
                                arrayList.add(new c.a(uriF2, bVarV.E(), strY, strY2));
                            }
                        default:
                            arrayList = arrayList11;
                            break;
                    }
                    i7++;
                    arrayList13 = arrayList13;
                    arrayList12 = arrayList12;
                    arrayList11 = arrayList;
                    str3 = str5;
                    dVarE = dVarE;
                    uri = null;
                }
                return new c(str, arrayList15, arrayList17, arrayList11, arrayList12, arrayList13, arrayList14, dVarE, z3 ? Collections.emptyList() : arrayList18, z4, map3, arrayList16);
            }
            String strB = aVar.b();
            if (strB.startsWith(h)) {
                arrayList9.add(strB);
            }
            boolean zStartsWith = strB.startsWith(p);
            boolean z5 = z2;
            if (strB.startsWith(k)) {
                map3.put(y(strB, f4202N, map3), y(strB, f4212X, map3));
            } else {
                if (strB.equals(x)) {
                    map = map2;
                    arrayList4 = arrayList4;
                    arrayList5 = arrayList5;
                    z2 = true;
                } else if (strB.startsWith(r)) {
                    arrayList7.add(strB);
                } else if (strB.startsWith(D)) {
                    DrmInitData.SchemeData schemeDataJ = j(strB, t(strB, f4195G, V, map3), map3);
                    if (schemeDataJ != null) {
                        arrayList8.add(new DrmInitData(k(y(strB, f4194F, map3)), schemeDataJ));
                    }
                } else if (strB.startsWith(m) || zStartsWith) {
                    boolean zContains = z3 | strB.contains(a0);
                    int i8 = zStartsWith ? 16384 : 0;
                    int iL = l(strB, f4215f);
                    int iR = r(strB, f30929a, -1);
                    String strU3 = u(strB, f4217h, map3);
                    String strU4 = u(strB, f4218i, map3);
                    if (strU4 != null) {
                        String[] strArrU1 = gj9.u1(strU4, "x");
                        int i9 = Integer.parseInt(strArrU1[0]);
                        int i10 = Integer.parseInt(strArrU1[1]);
                        if (i9 <= 0 || i10 <= 0) {
                            i10 = -1;
                            i5 = -1;
                        } else {
                            i5 = i9;
                        }
                        i4 = i10;
                        i3 = i5;
                    } else {
                        i3 = -1;
                        i4 = -1;
                    }
                    String strU5 = u(strB, f4219j, map3);
                    float f2 = strU5 != null ? Float.parseFloat(strU5) : -1.0f;
                    String strU6 = u(strB, b, map3);
                    String strU7 = u(strB, c, map3);
                    HashMap map5 = map2;
                    String strU8 = u(strB, d, map3);
                    String strU9 = u(strB, e, map3);
                    if (zStartsWith) {
                        uriF = rh9.f(str, y(strB, f4197I, map3));
                    } else {
                        if (!aVar.a()) {
                            throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
                        }
                        uriF = rh9.f(str, A(aVar.b(), map3));
                    }
                    arrayList2.add(new c.b(uriF, new d.b().R(arrayList2.size()).K("application/x-mpegURL").I(strU3).G(iR).Z(iL).j0(i3).Q(i4).P(f2).c0(i8).E(), strU6, strU7, strU8, strU9));
                    map = map5;
                    ArrayList arrayList20 = (ArrayList) map.get(uriF);
                    if (arrayList20 == null) {
                        arrayList20 = new ArrayList();
                        map.put(uriF, arrayList20);
                    }
                    arrayList20.add(new HlsTrackMetadataEntry.VariantInfo(iR, iL, strU6, strU7, strU8, strU9));
                    z2 = z5;
                    z3 = zContains;
                }
                map2 = map;
                arrayList8 = arrayList8;
                arrayList6 = arrayList6;
                arrayList9 = arrayList9;
                arrayList5 = arrayList5;
                arrayList4 = arrayList4;
                arrayList3 = arrayList3;
                arrayList7 = arrayList7;
            }
            map = map2;
            arrayList4 = arrayList4;
            arrayList5 = arrayList5;
            z2 = z5;
            map2 = map;
            arrayList8 = arrayList8;
            arrayList6 = arrayList6;
            arrayList9 = arrayList9;
            arrayList5 = arrayList5;
            arrayList4 = arrayList4;
            arrayList3 = arrayList3;
            arrayList7 = arrayList7;
        }
    }

    public static boolean p(String str, Pattern pattern, boolean z2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z2;
    }

    public static double q(String str, Pattern pattern, double d2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) sb0.g(matcher.group(1))) : d2;
    }

    public static int r(String str, Pattern pattern, int i2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) sb0.g(matcher.group(1))) : i2;
    }

    public static long s(String str, Pattern pattern, long j2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) sb0.g(matcher.group(1))) : j2;
    }

    public static String t(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) sb0.g(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : A(str2, map);
    }

    @Nullable
    public static String u(String str, Pattern pattern, Map<String, String> map) {
        return t(str, pattern, null, map);
    }

    public static int v(String str, Map<String, String> map) {
        String strU = u(str, f4204P, map);
        if (TextUtils.isEmpty(strU)) {
            return 0;
        }
        String[] strArrU1 = gj9.u1(strU, ",");
        int i2 = gj9.u(strArrU1, "public.accessibility.describes-video") ? 512 : 0;
        if (gj9.u(strArrU1, "public.accessibility.transcribes-spoken-dialog")) {
            i2 |= 4096;
        }
        if (gj9.u(strArrU1, "public.accessibility.describes-music-and-sound")) {
            i2 |= 1024;
        }
        return gj9.u(strArrU1, "public.easy-to-read") ? i2 | 8192 : i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static int w(String str) {
        boolean zP = p(str, f4207S, false);
        ?? r0 = zP;
        if (p(str, f4208T, false)) {
            r0 = (zP ? 1 : 0) | 2;
        }
        return p(str, f4206R, false) ? r0 | 4 : r0;
    }

    public static HlsMediaPlaylist.f x(String str) {
        double dQ = q(str, f4225p, -9.223372036854776E18d);
        long j2 = dQ == -9.223372036854776E18d ? -9223372036854775807L : (long) (dQ * 1000000.0d);
        boolean zP = p(str, f4226q, false);
        double dQ2 = q(str, f4228s, -9.223372036854776E18d);
        long j3 = dQ2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (dQ2 * 1000000.0d);
        double dQ3 = q(str, f4229t, -9.223372036854776E18d);
        return new HlsMediaPlaylist.f(j2, zP, j3, dQ3 != -9.223372036854776E18d ? (long) (dQ3 * 1000000.0d) : -9223372036854775807L, p(str, f4230u, false));
    }

    public static String y(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String strU = u(str, pattern, map);
        if (strU != null) {
            return strU;
        }
        throw ParserException.createForMalformedManifest("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    public static long z(String str, Pattern pattern) throws ParserException {
        return new BigDecimal(y(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
    }

    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public HlsPlaylist parse(Uri uri, InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (!a(bufferedReader)) {
                throw ParserException.createForMalformedManifest("Input does not start with the #EXTM3U header.", null);
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    gj9.p(bufferedReader);
                    throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", null);
                }
                String strTrim = line.trim();
                if (!strTrim.isEmpty()) {
                    if (strTrim.startsWith(m)) {
                        arrayDeque.add(strTrim);
                        c cVarO = o(new a(arrayDeque, bufferedReader), uri.toString());
                        gj9.p(bufferedReader);
                        return cVarO;
                    }
                    if (!strTrim.startsWith(s) && !strTrim.startsWith(z) && !strTrim.startsWith(y) && !strTrim.startsWith(C) && !strTrim.startsWith(E) && !strTrim.equals(t) && !strTrim.equals(u) && !strTrim.equals(B)) {
                        arrayDeque.add(strTrim);
                    }
                    arrayDeque.add(strTrim);
                    HlsMediaPlaylist hlsMediaPlaylistN = n(this.f4237a, this.f4236a, new a(arrayDeque, bufferedReader), uri.toString());
                    gj9.p(bufferedReader);
                    return hlsMediaPlaylistN;
                }
            }
        } catch (Throwable th) {
            gj9.p(bufferedReader);
            throw th;
        }
    }

    public HlsPlaylistParser(c cVar, @Nullable HlsMediaPlaylist hlsMediaPlaylist) {
        this.f4237a = cVar;
        this.f4236a = hlsMediaPlaylist;
    }
}
