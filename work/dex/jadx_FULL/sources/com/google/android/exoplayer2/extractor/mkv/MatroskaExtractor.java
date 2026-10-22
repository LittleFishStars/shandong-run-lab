package com.google.android.exoplayer2.extractor.mkv;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.alibaba.ariver.resource.parser.a.e;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.UnsignedBytes;
import com.zj.adlib.bp2;
import com.zj.adlib.bp5;
import com.zj.adlib.cl8;
import com.zj.adlib.gj9;
import com.zj.adlib.iv6;
import com.zj.adlib.kw5;
import com.zj.adlib.om6;
import com.zj.adlib.q25;
import com.zj.adlib.ri0;
import com.zj.adlib.sb0;
import com.zj.adlib.tn1;
import com.zj.adlib.tz3;
import com.zj.adlib.yl9;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class MatroskaExtractor implements Extractor {
    public static final int A = 17026;

    /* JADX INFO: renamed from: A, reason: collision with other field name */
    public static final String f2790A = "A_MS/ACM";
    public static final int A0 = 20530;
    public static final int A1 = 18;
    public static final int B = 17029;

    /* JADX INFO: renamed from: B, reason: collision with other field name */
    public static final String f2791B = "A_PCM/INT/LIT";
    public static final int B0 = 20532;
    public static final int B1 = 65534;
    public static final int C = 408125543;

    /* JADX INFO: renamed from: C, reason: collision with other field name */
    public static final String f2792C = "A_PCM/INT/BIG";
    public static final int C0 = 16980;
    public static final int C1 = 1;
    public static final int D = 357149030;

    /* JADX INFO: renamed from: D, reason: collision with other field name */
    public static final String f2793D = "A_PCM/FLOAT/IEEE";
    public static final int D0 = 16981;
    public static final int E = 290298740;

    /* JADX INFO: renamed from: E, reason: collision with other field name */
    public static final String f2794E = "S_TEXT/UTF8";
    public static final int E0 = 20533;
    public static final int F = 19899;

    /* JADX INFO: renamed from: F, reason: collision with other field name */
    public static final String f2795F = "S_TEXT/ASS";
    public static final int F0 = 18401;
    public static final int G = 21419;

    /* JADX INFO: renamed from: G, reason: collision with other field name */
    public static final String f2796G = "S_TEXT/WEBVTT";
    public static final int G0 = 18402;
    public static final int H = 21420;

    /* JADX INFO: renamed from: H, reason: collision with other field name */
    public static final String f2797H = "S_VOBSUB";
    public static final int H0 = 18407;
    public static final int I = 357149030;

    /* JADX INFO: renamed from: I, reason: collision with other field name */
    public static final String f2798I = "S_HDMV/PGS";
    public static final int I0 = 18408;
    public static final int J = 2807729;

    /* JADX INFO: renamed from: J, reason: collision with other field name */
    public static final String f2799J = "S_DVBSUB";
    public static final int J0 = 475249515;
    public static final int K = 17545;

    /* JADX INFO: renamed from: K, reason: collision with other field name */
    public static final String f2800K = "%02d:%02d:%02d,%03d";
    public static final int K0 = 187;
    public static final int L = 524531317;

    /* JADX INFO: renamed from: L, reason: collision with other field name */
    public static final String f2801L = "%01d:%02d:%02d:%02d";
    public static final int L0 = 179;
    public static final int M = 231;

    /* JADX INFO: renamed from: M, reason: collision with other field name */
    public static final String f2802M = "%02d:%02d:%02d.%03d";
    public static final int M0 = 183;
    public static final int N = 163;
    public static final int N0 = 241;
    public static final int O = 160;
    public static final int O0 = 2274716;
    public static final int P = 161;
    public static final int P0 = 30320;
    public static final int Q = 155;
    public static final int Q0 = 30321;
    public static final int R = 30113;
    public static final int R0 = 30322;
    public static final int S = 166;
    public static final int S0 = 30323;
    public static final int T = 238;
    public static final int T0 = 30324;
    public static final int U = 165;
    public static final int U0 = 30325;
    public static final int V = 251;
    public static final int V0 = 21432;
    public static final int W = 374648427;
    public static final int W0 = 21936;
    public static final int X = 174;
    public static final int X0 = 21945;
    public static final int Y = 215;
    public static final int Y0 = 21946;
    public static final int Z = 131;
    public static final int Z0 = 21947;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f2803a = "MatroskaExtractor";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Map<String, Integer> f2804a;
    public static final int a0 = 136;
    public static final int a1 = 21948;
    public static final String b = "matroska";
    public static final int b0 = 21930;
    public static final int b1 = 21949;
    public static final String c = "webm";
    public static final int c0 = 2352003;
    public static final int c1 = 21968;
    public static final String d = "V_VP8";
    public static final int d0 = 21998;
    public static final int d1 = 21969;
    public static final String e = "V_VP9";
    public static final int e0 = 16868;
    public static final int e1 = 21970;
    public static final String f = "V_AV1";
    public static final int f0 = 16871;
    public static final int f1 = 21971;
    public static final String g = "V_MPEG2";
    public static final int g0 = 16877;
    public static final int g1 = 21972;
    public static final String h = "V_MPEG4/ISO/SP";
    public static final int h0 = 21358;
    public static final int h1 = 21973;
    public static final String i = "V_MPEG4/ISO/ASP";
    public static final int i0 = 134;
    public static final int i1 = 21974;
    public static final String j = "V_MPEG4/ISO/AP";
    public static final int j0 = 25506;
    public static final int j1 = 21975;
    public static final String k = "V_MPEG4/ISO/AVC";
    public static final int k0 = 22186;
    public static final int k1 = 21976;
    public static final String l = "V_MPEGH/ISO/HEVC";
    public static final int l0 = 22203;
    public static final int l1 = 21977;
    public static final long m = 1000;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public static final String f2810m = "V_MS/VFW/FOURCC";
    public static final int m0 = 30114;
    public static final int m1 = 21978;
    public static final long n = 10000;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public static final String f2811n = "V_THEORA";
    public static final int n0 = 224;
    public static final int n1 = 4;
    public static final long o = 1000;

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    public static final String f2812o = "A_VORBIS";
    public static final int o0 = 176;
    public static final int o1 = 1685480259;
    public static final int p = 1;

    /* JADX INFO: renamed from: p, reason: collision with other field name */
    public static final String f2813p = "A_OPUS";
    public static final int p0 = 186;
    public static final int p1 = 1685485123;
    public static final int q = -1;

    /* JADX INFO: renamed from: q, reason: collision with other field name */
    public static final String f2814q = "A_AAC";
    public static final int q0 = 21680;
    public static final int q1 = 0;
    public static final int r = 0;

    /* JADX INFO: renamed from: r, reason: collision with other field name */
    public static final String f2815r = "A_MPEG/L2";
    public static final int r0 = 21690;
    public static final int r1 = 1;
    public static final int s = 1;

    /* JADX INFO: renamed from: s, reason: collision with other field name */
    public static final String f2816s = "A_MPEG/L3";
    public static final int s0 = 21682;
    public static final int s1 = 2;
    public static final int t = 2;

    /* JADX INFO: renamed from: t, reason: collision with other field name */
    public static final String f2817t = "A_AC3";
    public static final int t0 = 225;
    public static final int t1 = 3;
    public static final int u = 8192;

    /* JADX INFO: renamed from: u, reason: collision with other field name */
    public static final String f2818u = "A_EAC3";
    public static final int u0 = 159;
    public static final int u1 = 1482049860;
    public static final int v = 5760;

    /* JADX INFO: renamed from: v, reason: collision with other field name */
    public static final String f2819v = "A_TRUEHD";
    public static final int v0 = 25188;
    public static final int v1 = 859189832;
    public static final int w = 8;

    /* JADX INFO: renamed from: w, reason: collision with other field name */
    public static final String f2820w = "A_DTS";
    public static final int w0 = 181;
    public static final int w1 = 826496599;
    public static final int x = 2;

    /* JADX INFO: renamed from: x, reason: collision with other field name */
    public static final String f2821x = "A_DTS/EXPRESS";
    public static final int x0 = 28032;
    public static final int x1 = 19;
    public static final int y = 440786851;

    /* JADX INFO: renamed from: y, reason: collision with other field name */
    public static final String f2822y = "A_DTS/LOSSLESS";
    public static final int y0 = 25152;
    public static final int y1 = 21;
    public static final int z = 17143;

    /* JADX INFO: renamed from: z, reason: collision with other field name */
    public static final String f2823z = "A_FLAC";
    public static final int z0 = 20529;
    public static final int z1 = 25;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte f2824a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2825a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseArray<c> f2826a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f2827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EbmlReader f2828a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public c f2829a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f2830a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public q25 f2831a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final yl9 f2832a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f2833a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f2835a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f2836b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final om6 f2837b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public q25 f2838b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2839b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f2840c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final om6 f2841c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2842c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f2843d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f2844d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final om6 f2845d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f2846d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f2847e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public long f2848e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final om6 f2849e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f2850e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public int f2851f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public long f2852f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public final om6 f2853f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f2854f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public int f2855g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public long f2856g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public final om6 f2857g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f2858g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public int f2859h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public long f2860h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public final om6 f2861h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f2862h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public int f2863i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public long f2864i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public final om6 f2865i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f2866i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public int f2867j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public long f2868j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public final om6 f2869j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f2870j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public int f2871k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public long f2872k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public int f2873l;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public long f2874l;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public int f2875m;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public int f2876n;

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    public int f2877o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorsFactory f30659a = new ExtractorsFactory() { // from class: com.zj.adlib.ye5
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return MatroskaExtractor.q();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f2806a = {e.j, 10, e.i, e.i, 58, e.i, e.i, 58, e.i, e.i, com.google.android.exoplayer2.text.cea.a.m, e.i, e.i, e.i, 32, com.google.android.exoplayer2.text.cea.a.n, com.google.android.exoplayer2.text.cea.a.n, 62, 32, e.i, e.i, 58, e.i, e.i, 58, e.i, e.i, com.google.android.exoplayer2.text.cea.a.m, e.i, e.i, e.i, 10};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final byte[] f2807b = gj9.z0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final byte[] f2808c = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, e.i, 58, e.i, e.i, 58, e.i, e.i, 58, e.i, e.i, com.google.android.exoplayer2.text.cea.a.m, e.i, 58, e.i, e.i, 58, e.i, e.i, 58, e.i, e.i, com.google.android.exoplayer2.text.cea.a.m};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final byte[] f2809d = {87, 69, 66, 86, 84, 84, 10, 10, e.i, e.i, 58, e.i, e.i, 58, e.i, e.i, com.google.android.exoplayer2.text.cea.a.o, e.i, e.i, e.i, 32, com.google.android.exoplayer2.text.cea.a.n, com.google.android.exoplayer2.text.cea.a.n, 62, 32, e.i, e.i, 58, e.i, e.i, 58, e.i, e.i, com.google.android.exoplayer2.text.cea.a.o, e.i, e.i, e.i, 10};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final UUID f2805a = new UUID(72057594037932032L, -9223371306706625679L);

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public final class b implements EbmlProcessor {
        public b() {
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void a(int i, int i2, ExtractorInput extractorInput) throws IOException {
            MatroskaExtractor.this.binaryElement(i, i2, extractorInput);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void endMasterElement(int i) throws ParserException {
            MatroskaExtractor.this.endMasterElement(i);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void floatElement(int i, double d) throws ParserException {
            MatroskaExtractor.this.floatElement(i, d);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public int getElementType(int i) {
            return MatroskaExtractor.this.getElementType(i);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void integerElement(int i, long j) throws ParserException {
            MatroskaExtractor.this.integerElement(i, j);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public boolean isLevel1Element(int i) {
            return MatroskaExtractor.this.isLevel1Element(i);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void startMasterElement(int i, long j, long j2) throws ParserException {
            MatroskaExtractor.this.startMasterElement(i, j, j2);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void stringElement(int i, String str) throws ParserException {
            MatroskaExtractor.this.stringElement(i, str);
        }
    }

    public static final class c {
        public static final int v = 0;
        public static final int w = 50000;
        public static final int x = 1000;
        public static final int y = 200;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f2878a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public DrmInitData f2880a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TrackOutput.a f2881a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TrackOutput f2882a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public i f2883a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f2884a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f2885a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public byte[] f2886a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int f2887b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public String f2889b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public byte[] f2891b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public int f2892c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f2894c;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public int f2896d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public byte[] f2898d;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public int f2899e;
        public int u;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        public int f2900f = -1;

        /* JADX INFO: renamed from: g, reason: collision with other field name */
        public int f2901g = -1;

        /* JADX INFO: renamed from: h, reason: collision with other field name */
        public int f2902h = -1;

        /* JADX INFO: renamed from: i, reason: collision with other field name */
        public int f2903i = -1;

        /* JADX INFO: renamed from: j, reason: collision with other field name */
        public int f2904j = 0;

        /* JADX INFO: renamed from: k, reason: collision with other field name */
        public int f2905k = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f30661a = 0.0f;
        public float b = 0.0f;
        public float c = 0.0f;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public byte[] f2895c = null;

        /* JADX INFO: renamed from: l, reason: collision with other field name */
        public int f2906l = -1;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f2890b = false;

        /* JADX INFO: renamed from: m, reason: collision with other field name */
        public int f2907m = -1;
        public int n = -1;
        public int o = -1;
        public int p = 1000;
        public int q = 200;
        public float d = -1.0f;
        public float e = -1.0f;
        public float f = -1.0f;
        public float g = -1.0f;
        public float h = -1.0f;
        public float i = -1.0f;
        public float j = -1.0f;
        public float k = -1.0f;
        public float l = -1.0f;
        public float m = -1.0f;
        public int r = 1;
        public int s = -1;
        public int t = 8000;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f2879a = 0;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f2888b = 0;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public boolean f2897d = true;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public String f2893c = "eng";

        public static Pair<String, List<byte[]>> k(om6 om6Var) throws ParserException {
            try {
                om6Var.T(16);
                long jV = om6Var.v();
                if (jV == 1482049860) {
                    return new Pair<>("video/divx", null);
                }
                if (jV == 859189832) {
                    return new Pair<>("video/3gpp", null);
                }
                if (jV != 826496599) {
                    Log.n(MatroskaExtractor.f2803a, "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair<>("video/x-unknown", null);
                }
                byte[] bArrD = om6Var.d();
                for (int iE = om6Var.e() + 20; iE < bArrD.length - 4; iE++) {
                    if (bArrD[iE] == 0 && bArrD[iE + 1] == 0 && bArrD[iE + 2] == 1 && bArrD[iE + 3] == 15) {
                        return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrD, iE, bArrD.length)));
                    }
                }
                throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing FourCC private data", null);
            }
        }

        public static boolean l(om6 om6Var) throws ParserException {
            try {
                int iY = om6Var.y();
                if (iY == 1) {
                    return true;
                }
                if (iY != 65534) {
                    return false;
                }
                om6Var.S(24);
                return om6Var.z() == MatroskaExtractor.f2805a.getMostSignificantBits() && om6Var.z() == MatroskaExtractor.f2805a.getLeastSignificantBits();
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing MS/ACM codec private", null);
            }
        }

        public static List<byte[]> m(byte[] bArr) throws ParserException {
            int i;
            int i2;
            try {
                if (bArr[0] != 2) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                int i3 = 0;
                int i4 = 1;
                while (true) {
                    i = bArr[i4];
                    if ((i & 255) != 255) {
                        break;
                    }
                    i3 += 255;
                    i4++;
                }
                int i5 = i4 + 1;
                int i6 = i3 + (i & 255);
                int i7 = 0;
                while (true) {
                    i2 = bArr[i5];
                    if ((i2 & 255) != 255) {
                        break;
                    }
                    i7 += 255;
                    i5++;
                }
                int i8 = i5 + 1;
                int i9 = i7 + (i2 & 255);
                if (bArr[i8] != 1) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i8, bArr2, 0, i6);
                int i10 = i8 + i6;
                if (bArr[i10] != 3) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                int i11 = i10 + i9;
                if (bArr[i11] != 5) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i11];
                System.arraycopy(bArr, i11, bArr3, 0, bArr.length - i11);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
            }
        }

        @EnsuresNonNull({com.alibaba.ariver.remotedebug.b.c.g})
        public final void f() {
            sb0.g(this.f2882a);
        }

        @EnsuresNonNull({"codecPrivate"})
        public final byte[] g(String str) throws ParserException {
            byte[] bArr = this.f2891b;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.createForMalformedContainer("Missing CodecPrivate for codec " + str, null);
        }

        @Nullable
        public final byte[] h() {
            if (this.d == -1.0f || this.e == -1.0f || this.f == -1.0f || this.g == -1.0f || this.h == -1.0f || this.i == -1.0f || this.j == -1.0f || this.k == -1.0f || this.l == -1.0f || this.m == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.d * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.e * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.f * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.g * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.h * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.i * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.j * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.k * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.l + 0.5f));
            byteBufferOrder.putShort((short) (this.m + 0.5f));
            byteBufferOrder.putShort((short) this.p);
            byteBufferOrder.putShort((short) this.q);
            return bArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:152:0x029d A[PHI: r1
          0x029d: PHI (r1v110 int) = (r1v77 int), (r1v108 int), (r1v114 int) binds: [B:191:0x03cc, B:157:0x02ac, B:150:0x027d] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:202:0x0417  */
        /* JADX WARN: Code duplicated, block: B:207:0x0430  */
        /* JADX WARN: Code duplicated, block: B:208:0x0432  */
        /* JADX WARN: Code duplicated, block: B:211:0x043f  */
        /* JADX WARN: Code duplicated, block: B:212:0x0451  */
        /* JADX WARN: Code duplicated, block: B:214:0x0457  */
        /* JADX WARN: Code duplicated, block: B:216:0x045b  */
        /* JADX WARN: Code duplicated, block: B:218:0x0460  */
        /* JADX WARN: Code duplicated, block: B:221:0x0468  */
        /* JADX WARN: Code duplicated, block: B:223:0x046d  */
        /* JADX WARN: Code duplicated, block: B:226:0x0472  */
        /* JADX WARN: Code duplicated, block: B:229:0x0480  */
        /* JADX WARN: Code duplicated, block: B:232:0x0486  */
        /* JADX WARN: Code duplicated, block: B:235:0x0499  */
        /* JADX WARN: Code duplicated, block: B:240:0x04b9  */
        /* JADX WARN: Code duplicated, block: B:246:0x04d2  */
        /* JADX WARN: Code duplicated, block: B:247:0x04d4  */
        /* JADX WARN: Code duplicated, block: B:249:0x04de  */
        /* JADX WARN: Code duplicated, block: B:250:0x04e1  */
        /* JADX WARN: Code duplicated, block: B:252:0x04eb  */
        /* JADX WARN: Code duplicated, block: B:258:0x0503  */
        /* JADX WARN: Code duplicated, block: B:260:0x052a  */
        /* JADX WARN: Code duplicated, block: B:262:0x0530  */
        /* JADX WARN: Code duplicated, block: B:278:0x055b  */
        /* JADX WARN: Code duplicated, block: B:4:0x0015  */
        @EnsuresNonNull({"this.output"})
        @RequiresNonNull({"codecId"})
        public void i(ExtractorOutput extractorOutput, int i) throws ParserException {
            byte b;
            List<byte[]> listSingletonList;
            int iN0;
            String str;
            List<byte[]> list;
            String str2;
            int i2;
            int i3;
            byte[] bArr;
            String str3;
            int i4;
            d.b bVar;
            int i5;
            int iIntValue;
            int i6;
            float f;
            int i7;
            int i8;
            int i9;
            bp2 bp2VarA;
            String str4 = this.f2889b;
            str4.hashCode();
            switch (str4) {
                case "V_MPEG4/ISO/AP":
                    b = 0;
                    break;
                case "V_MPEG4/ISO/SP":
                    b = 1;
                    break;
                case "A_MS/ACM":
                    b = 2;
                    break;
                case "A_TRUEHD":
                    b = 3;
                    break;
                case "A_VORBIS":
                    b = 4;
                    break;
                case "A_MPEG/L2":
                    b = 5;
                    break;
                case "A_MPEG/L3":
                    b = 6;
                    break;
                case "V_MS/VFW/FOURCC":
                    b = 7;
                    break;
                case "S_DVBSUB":
                    b = 8;
                    break;
                case "V_MPEG4/ISO/ASP":
                    b = 9;
                    break;
                case "V_MPEG4/ISO/AVC":
                    b = 10;
                    break;
                case "S_VOBSUB":
                    b = 11;
                    break;
                case "A_DTS/LOSSLESS":
                    b = 12;
                    break;
                case "A_AAC":
                    b = 13;
                    break;
                case "A_AC3":
                    b = com.google.common.base.a.p;
                    break;
                case "A_DTS":
                    b = com.google.common.base.a.q;
                    break;
                case "V_AV1":
                    b = 16;
                    break;
                case "V_VP8":
                    b = 17;
                    break;
                case "V_VP9":
                    b = com.google.common.base.a.u;
                    break;
                case "S_HDMV/PGS":
                    b = 19;
                    break;
                case "V_THEORA":
                    b = com.google.common.base.a.x;
                    break;
                case "A_DTS/EXPRESS":
                    b = com.google.common.base.a.y;
                    break;
                case "A_PCM/FLOAT/IEEE":
                    b = com.google.common.base.a.z;
                    break;
                case "A_PCM/INT/BIG":
                    b = com.google.common.base.a.A;
                    break;
                case "A_PCM/INT/LIT":
                    b = com.google.common.base.a.B;
                    break;
                case "S_TEXT/ASS":
                    b = com.google.common.base.a.C;
                    break;
                case "V_MPEGH/ISO/HEVC":
                    b = com.google.common.base.a.D;
                    break;
                case "S_TEXT/WEBVTT":
                    b = com.google.common.base.a.E;
                    break;
                case "S_TEXT/UTF8":
                    b = com.google.common.base.a.F;
                    break;
                case "V_MPEG2":
                    b = com.google.common.base.a.G;
                    break;
                case "A_EAC3":
                    b = com.google.common.base.a.H;
                    break;
                case "A_FLAC":
                    b = 31;
                    break;
                case "A_OPUS":
                    b = 32;
                    break;
                default:
                    b = -1;
                    break;
            }
            int i10 = 4096;
            String str5 = "audio/raw";
            switch (b) {
                case 0:
                case 1:
                case 9:
                    byte[] bArr2 = this.f2891b;
                    listSingletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                    str5 = "video/mp4v-es";
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null && (bp2VarA = bp2.a(new om6(bArr))) != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i11 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i12 = i4 | i11;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    } else if (bp5.t(str3)) {
                        if (this.f2904j == 0) {
                            i8 = this.f2902h;
                            iIntValue = -1;
                            if (i8 == -1) {
                                i8 = this.f2900f;
                            }
                            this.f2902h = i8;
                            i9 = this.f2903i;
                            if (i9 == -1) {
                                i9 = this.f2901g;
                            }
                            this.f2903i = i9;
                        } else {
                            iIntValue = -1;
                        }
                        i6 = this.f2902h;
                        if (i6 != iIntValue || (i7 = this.f2903i) == iIntValue) {
                            f = -1.0f;
                        } else {
                            f = (this.f2901g * i6) / (this.f2900f * i7);
                        }
                        tn1 tn1Var = this.f2890b ? new tn1(this.f2907m, this.o, this.n, h()) : null;
                        if (this.f2884a != null && MatroskaExtractor.f2804a.containsKey(this.f2884a)) {
                            iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                        }
                        if (this.f2905k == 0 && Float.compare(this.f30661a, 0.0f) == 0 && Float.compare(this.b, 0.0f) == 0) {
                            if (Float.compare(this.c, 0.0f) == 0) {
                                iIntValue = 0;
                            } else if (Float.compare(this.b, 90.0f) == 0) {
                                iIntValue = 90;
                            } else if (Float.compare(this.b, -180.0f) != 0 || Float.compare(this.b, 180.0f) == 0) {
                                iIntValue = 180;
                            } else if (Float.compare(this.b, -90.0f) == 0) {
                                iIntValue = 270;
                            }
                        }
                        bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3) && !"text/x-ssa".equals(str3) && !"text/vtt".equals(str3) && !"application/vobsub".equals(str3) && !"application/pgs".equals(str3) && !"application/dvbsubs".equals(str3)) {
                            throw ParserException.createForMalformedContainer("Unexpected MIME type.", null);
                        }
                        i5 = 3;
                    }
                    if (this.f2884a != null && !MatroskaExtractor.f2804a.containsKey(this.f2884a)) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i12).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB;
                    trackOutputB.f(dVarE);
                    return;
                case 2:
                    if (l(new om6(g(this.f2889b)))) {
                        iN0 = gj9.n0(this.s);
                        if (iN0 == 0) {
                            Log.n(MatroskaExtractor.f2803a, "Unsupported PCM bit depth: " + this.s + ". Setting mimeType to audio/x-unknown");
                        } else {
                            i2 = iN0;
                            listSingletonList = null;
                            str = null;
                        }
                        i3 = -1;
                        bArr = this.f2898d;
                        if (bArr != null) {
                            str = bp2VarA.f15608a;
                            str5 = "video/dolby-vision";
                        }
                        str3 = str5;
                        int i13 = (this.f2897d ? 1 : 0) | 0;
                        if (this.f2894c) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i14 = i4 | i13;
                        bVar = new d.b();
                        if (bp5.p(str3)) {
                            if (bp5.t(str3)) {
                                if (this.f2904j == 0) {
                                    i8 = this.f2902h;
                                    iIntValue = -1;
                                    if (i8 == -1) {
                                        i8 = this.f2900f;
                                    }
                                    this.f2902h = i8;
                                    i9 = this.f2903i;
                                    if (i9 == -1) {
                                        i9 = this.f2901g;
                                    }
                                    this.f2903i = i9;
                                } else {
                                    iIntValue = -1;
                                }
                                i6 = this.f2902h;
                                if (i6 != iIntValue) {
                                    f = -1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                if (this.f2890b) {
                                }
                                if (this.f2884a != null) {
                                    iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                                }
                                if (this.f2905k == 0) {
                                    if (Float.compare(this.c, 0.0f) == 0) {
                                        iIntValue = 0;
                                    } else if (Float.compare(this.b, 90.0f) == 0) {
                                        iIntValue = 90;
                                    } else if (Float.compare(this.b, -180.0f) != 0) {
                                        iIntValue = 180;
                                    } else {
                                        iIntValue = 180;
                                    }
                                }
                                bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                                i5 = 2;
                            } else {
                                if ("application/x-subrip".equals(str3)) {
                                }
                                i5 = 3;
                            }
                            break;
                        } else {
                            bVar.H(this.r).f0(this.t).Y(i2);
                            i5 = 1;
                        }
                        if (this.f2884a != null) {
                            bVar.U(this.f2884a);
                        }
                        d dVarE2 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i14).T(listSingletonList).I(str).M(this.f2880a).E();
                        TrackOutput trackOutputB2 = extractorOutput.b(this.f2878a, i5);
                        this.f2882a = trackOutputB2;
                        trackOutputB2.f(dVarE2);
                        return;
                    }
                    Log.n(MatroskaExtractor.f2803a, "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                    listSingletonList = null;
                    str = null;
                    str5 = "audio/x-unknown";
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i15 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i16 = i4 | i15;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE3 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i16).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB3 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB3;
                    trackOutputB3.f(dVarE3);
                    return;
                case 3:
                    this.f2883a = new i();
                    str5 = "audio/true-hd";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i17 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i18 = i4 | i17;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE4 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i18).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB4 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB4;
                    trackOutputB4.f(dVarE4);
                    return;
                case 4:
                    listSingletonList = m(g(this.f2889b));
                    str5 = "audio/vorbis";
                    i10 = 8192;
                    str = null;
                    i3 = i10;
                    i2 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i19 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i110 = i4 | i19;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE5 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i110).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB5 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB5;
                    trackOutputB5.f(dVarE5);
                    return;
                case 5:
                    str5 = "audio/mpeg-L2";
                    listSingletonList = null;
                    str = null;
                    i3 = i10;
                    i2 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i111 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i112 = i4 | i111;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE6 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i112).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB6 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB6;
                    trackOutputB6.f(dVarE6);
                    return;
                case 6:
                    str5 = "audio/mpeg";
                    listSingletonList = null;
                    str = null;
                    i3 = i10;
                    i2 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i113 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i114 = i4 | i113;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE7 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i114).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB7 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB7;
                    trackOutputB7.f(dVarE7);
                    return;
                case 7:
                    Pair<String, List<byte[]>> pairK = k(new om6(g(this.f2889b)));
                    str5 = (String) pairK.first;
                    listSingletonList = (List) pairK.second;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i115 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i116 = i4 | i115;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE8 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i116).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB8 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB8;
                    trackOutputB8.f(dVarE8);
                    return;
                case 8:
                    byte[] bArr3 = new byte[4];
                    System.arraycopy(g(this.f2889b), 0, bArr3, 0, 4);
                    listSingletonList = ImmutableList.of(bArr3);
                    str5 = "application/dvbsubs";
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i117 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i118 = i4 | i117;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE9 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i118).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB9 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB9;
                    trackOutputB9.f(dVarE9);
                    return;
                case 10:
                    ri0 ri0VarB = ri0.b(new om6(g(this.f2889b)));
                    list = ri0VarB.f19329a;
                    this.u = ri0VarB.f19327a;
                    str2 = ri0VarB.f19328a;
                    str5 = "video/avc";
                    i2 = -1;
                    i3 = -1;
                    List<byte[]> list2 = list;
                    str = str2;
                    listSingletonList = list2;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i119 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i1110 = i4 | i119;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE10 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i1110).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB10 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB10;
                    trackOutputB10.f(dVarE10);
                    return;
                case 11:
                    listSingletonList = ImmutableList.of(g(this.f2889b));
                    str = null;
                    str5 = "application/vobsub";
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1111 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i1112 = i4 | i1111;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE11 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i1112).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB11 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB11;
                    trackOutputB11.f(dVarE11);
                    return;
                case 12:
                    str5 = "audio/vnd.dts.hd";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1113 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i1114 = i4 | i1113;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE12 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i1114).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB12 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB12;
                    trackOutputB12.f(dVarE12);
                    return;
                case 13:
                    listSingletonList = Collections.singletonList(g(this.f2889b));
                    AacUtil.b bVarF = AacUtil.f(this.f2891b);
                    this.t = bVarF.f30530a;
                    this.r = bVarF.b;
                    str = bVarF.f2344a;
                    str5 = "audio/mp4a-latm";
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1115 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i1116 = i4 | i1115;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE13 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i1116).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB13 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB13;
                    trackOutputB13.f(dVarE13);
                    return;
                case 14:
                    str5 = "audio/ac3";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1117 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i1118 = i4 | i1117;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE14 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i1118).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB14 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB14;
                    trackOutputB14.f(dVarE14);
                    return;
                case 15:
                case 21:
                    str5 = "audio/vnd.dts";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1119 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i11110 = i4 | i1119;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE15 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i11110).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB15 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB15;
                    trackOutputB15.f(dVarE15);
                    return;
                case 16:
                    str5 = "video/av01";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i11111 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i11112 = i4 | i11111;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE16 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i11112).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB16 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB16;
                    trackOutputB16.f(dVarE16);
                    return;
                case 17:
                    str5 = "video/x-vnd.on2.vp8";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i11113 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i11114 = i4 | i11113;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE17 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i11114).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB17 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB17;
                    trackOutputB17.f(dVarE17);
                    return;
                case 18:
                    str5 = "video/x-vnd.on2.vp9";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i11115 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i11116 = i4 | i11115;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE18 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i11116).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB18 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB18;
                    trackOutputB18.f(dVarE18);
                    return;
                case 19:
                    listSingletonList = null;
                    str = null;
                    str5 = "application/pgs";
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i11117 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i11118 = i4 | i11117;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE19 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i11118).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB19 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB19;
                    trackOutputB19.f(dVarE19);
                    return;
                case 20:
                    str5 = "video/x-unknown";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i11119 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i111110 = i4 | i11119;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE110 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i111110).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB110 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB110;
                    trackOutputB110.f(dVarE110);
                    return;
                case 22:
                    if (this.s == 32) {
                        listSingletonList = null;
                        str = null;
                        i2 = 4;
                    } else {
                        Log.n(MatroskaExtractor.f2803a, "Unsupported floating point PCM bit depth: " + this.s + ". Setting mimeType to audio/x-unknown");
                        listSingletonList = null;
                        str = null;
                        str5 = "audio/x-unknown";
                        i2 = -1;
                    }
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i111111 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i111112 = i4 | i111111;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE111 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i111112).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB111 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB111;
                    trackOutputB111.f(dVarE111);
                    return;
                case 23:
                    int i20 = this.s;
                    if (i20 == 8) {
                        listSingletonList = null;
                        str = null;
                        i2 = 3;
                    } else if (i20 == 16) {
                        iN0 = 268435456;
                        i2 = iN0;
                        listSingletonList = null;
                        str = null;
                    } else {
                        Log.n(MatroskaExtractor.f2803a, "Unsupported big endian PCM bit depth: " + this.s + ". Setting mimeType to audio/x-unknown");
                        listSingletonList = null;
                        str = null;
                        str5 = "audio/x-unknown";
                        i2 = -1;
                    }
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i111113 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i111114 = i4 | i111113;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE112 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i111114).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB112 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB112;
                    trackOutputB112.f(dVarE112);
                    return;
                case 24:
                    iN0 = gj9.n0(this.s);
                    if (iN0 == 0) {
                        Log.n(MatroskaExtractor.f2803a, "Unsupported little endian PCM bit depth: " + this.s + ". Setting mimeType to audio/x-unknown");
                        listSingletonList = null;
                        str = null;
                        str5 = "audio/x-unknown";
                        i2 = -1;
                    } else {
                        i2 = iN0;
                        listSingletonList = null;
                        str = null;
                    }
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i111115 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i111116 = i4 | i111115;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE113 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i111116).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB113 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB113;
                    trackOutputB113.f(dVarE113);
                    return;
                case 25:
                    listSingletonList = ImmutableList.of(MatroskaExtractor.f2807b, g(this.f2889b));
                    str = null;
                    str5 = "text/x-ssa";
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i111117 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i111118 = i4 | i111117;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE114 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i111118).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB114 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB114;
                    trackOutputB114.f(dVarE114);
                    return;
                case 26:
                    tz3 tz3VarA = tz3.a(new om6(g(this.f2889b)));
                    list = tz3VarA.f19923a;
                    this.u = tz3VarA.f19921a;
                    str2 = tz3VarA.f19922a;
                    str5 = "video/hevc";
                    i2 = -1;
                    i3 = -1;
                    List<byte[]> list3 = list;
                    str = str2;
                    listSingletonList = list3;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i111119 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i1111110 = i4 | i111119;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE115 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i1111110).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB115 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB115;
                    trackOutputB115.f(dVarE115);
                    return;
                case 27:
                    listSingletonList = null;
                    str = null;
                    str5 = "text/vtt";
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1111111 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i1111112 = i4 | i1111111;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE116 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i1111112).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB116 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB116;
                    trackOutputB116.f(dVarE116);
                    return;
                case 28:
                    str5 = "application/x-subrip";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1111113 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i1111114 = i4 | i1111113;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE117 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i1111114).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB117 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB117;
                    trackOutputB117.f(dVarE117);
                    return;
                case 29:
                    str5 = "video/mpeg2";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1111115 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i1111116 = i4 | i1111115;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE118 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i1111116).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB118 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB118;
                    trackOutputB118.f(dVarE118);
                    return;
                case 30:
                    str5 = "audio/eac3";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1111117 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i1111118 = i4 | i1111117;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE119 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i1111118).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB119 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB119;
                    trackOutputB119.f(dVarE119);
                    return;
                case 31:
                    listSingletonList = Collections.singletonList(g(this.f2889b));
                    str5 = "audio/flac";
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1111119 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i11111110 = i4 | i1111119;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE1110 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i11111110).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB1110 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB1110;
                    trackOutputB1110.f(dVarE1110);
                    return;
                case 32:
                    listSingletonList = new ArrayList<>(3);
                    listSingletonList.add(g(this.f2889b));
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    listSingletonList.add(byteBufferAllocate.order(byteOrder).putLong(this.f2879a).array());
                    listSingletonList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.f2888b).array());
                    str5 = "audio/opus";
                    i10 = MatroskaExtractor.v;
                    str = null;
                    i3 = i10;
                    i2 = -1;
                    bArr = this.f2898d;
                    if (bArr != null) {
                        str = bp2VarA.f15608a;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i11111111 = (this.f2897d ? 1 : 0) | 0;
                    if (this.f2894c) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i11111112 = i4 | i11111111;
                    bVar = new d.b();
                    if (bp5.p(str3)) {
                        if (bp5.t(str3)) {
                            if (this.f2904j == 0) {
                                i8 = this.f2902h;
                                iIntValue = -1;
                                if (i8 == -1) {
                                    i8 = this.f2900f;
                                }
                                this.f2902h = i8;
                                i9 = this.f2903i;
                                if (i9 == -1) {
                                    i9 = this.f2901g;
                                }
                                this.f2903i = i9;
                            } else {
                                iIntValue = -1;
                            }
                            i6 = this.f2902h;
                            if (i6 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.f2890b) {
                            }
                            if (this.f2884a != null) {
                                iIntValue = ((Integer) MatroskaExtractor.f2804a.get(this.f2884a)).intValue();
                            }
                            if (this.f2905k == 0) {
                                if (Float.compare(this.c, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.b, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.b, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            bVar.j0(this.f2900f).Q(this.f2901g).a0(f).d0(iIntValue).b0(this.f2895c).h0(this.f2906l).J(tn1Var);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        bVar.H(this.r).f0(this.t).Y(i2);
                        i5 = 1;
                    }
                    if (this.f2884a != null) {
                        bVar.U(this.f2884a);
                    }
                    d dVarE1111 = bVar.R(i).e0(str3).W(i3).V(this.f2893c).g0(i11111112).T(listSingletonList).I(str).M(this.f2880a).E();
                    TrackOutput trackOutputB1111 = extractorOutput.b(this.f2878a, i5);
                    this.f2882a = trackOutputB1111;
                    trackOutputB1111.f(dVarE1111);
                    return;
                default:
                    throw ParserException.createForMalformedContainer("Unrecognized codec identifier.", null);
            }
        }

        @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g})
        public void j() {
            i iVar = this.f2883a;
            if (iVar != null) {
                iVar.a(this.f2882a, this.f2881a);
            }
        }

        public void n() {
            i iVar = this.f2883a;
            if (iVar != null) {
                iVar.b();
            }
        }

        public final boolean o(boolean z) {
            if (MatroskaExtractor.f2813p.equals(this.f2889b)) {
                return z;
            }
            return this.f2896d > 0;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        f2804a = Collections.unmodifiableMap(map);
    }

    public MatroskaExtractor() {
        this(0);
    }

    public static int[] m(@Nullable int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        return iArr.length >= i2 ? iArr : new int[Math.max(iArr.length * 2, i2)];
    }

    public static byte[] o(long j2, String str, long j3) {
        sb0.a(j2 != -9223372036854775807L);
        int i2 = (int) (j2 / 3600000000L);
        long j4 = j2 - ((((long) i2) * 3600) * 1000000);
        int i3 = (int) (j4 / 60000000);
        long j5 = j4 - ((((long) i3) * 60) * 1000000);
        int i4 = (int) (j5 / 1000000);
        return gj9.z0(String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j5 - (((long) i4) * 1000000)) / j3))));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean p(String str) {
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals(j)) {
                    b2 = 0;
                }
                break;
            case -2095575984:
                if (str.equals(h)) {
                    b2 = 1;
                }
                break;
            case -1985379776:
                if (str.equals(f2790A)) {
                    b2 = 2;
                }
                break;
            case -1784763192:
                if (str.equals(f2819v)) {
                    b2 = 3;
                }
                break;
            case -1730367663:
                if (str.equals(f2812o)) {
                    b2 = 4;
                }
                break;
            case -1482641358:
                if (str.equals(f2815r)) {
                    b2 = 5;
                }
                break;
            case -1482641357:
                if (str.equals(f2816s)) {
                    b2 = 6;
                }
                break;
            case -1373388978:
                if (str.equals(f2810m)) {
                    b2 = 7;
                }
                break;
            case -933872740:
                if (str.equals(f2799J)) {
                    b2 = 8;
                }
                break;
            case -538363189:
                if (str.equals(i)) {
                    b2 = 9;
                }
                break;
            case -538363109:
                if (str.equals(k)) {
                    b2 = 10;
                }
                break;
            case -425012669:
                if (str.equals(f2797H)) {
                    b2 = 11;
                }
                break;
            case -356037306:
                if (str.equals(f2822y)) {
                    b2 = 12;
                }
                break;
            case 62923557:
                if (str.equals(f2814q)) {
                    b2 = 13;
                }
                break;
            case 62923603:
                if (str.equals(f2817t)) {
                    b2 = com.google.common.base.a.p;
                }
                break;
            case 62927045:
                if (str.equals(f2820w)) {
                    b2 = com.google.common.base.a.q;
                }
                break;
            case 82318131:
                if (str.equals(f)) {
                    b2 = com.google.common.base.a.r;
                }
                break;
            case 82338133:
                if (str.equals(d)) {
                    b2 = 17;
                }
                break;
            case 82338134:
                if (str.equals(e)) {
                    b2 = com.google.common.base.a.u;
                }
                break;
            case 99146302:
                if (str.equals(f2798I)) {
                    b2 = 19;
                }
                break;
            case 444813526:
                if (str.equals(f2811n)) {
                    b2 = com.google.common.base.a.x;
                }
                break;
            case 542569478:
                if (str.equals(f2821x)) {
                    b2 = com.google.common.base.a.y;
                }
                break;
            case 635596514:
                if (str.equals(f2793D)) {
                    b2 = com.google.common.base.a.z;
                }
                break;
            case 725948237:
                if (str.equals(f2792C)) {
                    b2 = com.google.common.base.a.A;
                }
                break;
            case 725957860:
                if (str.equals(f2791B)) {
                    b2 = com.google.common.base.a.B;
                }
                break;
            case 738597099:
                if (str.equals(f2795F)) {
                    b2 = com.google.common.base.a.C;
                }
                break;
            case 855502857:
                if (str.equals(l)) {
                    b2 = com.google.common.base.a.D;
                }
                break;
            case 1045209816:
                if (str.equals(f2796G)) {
                    b2 = com.google.common.base.a.E;
                }
                break;
            case 1422270023:
                if (str.equals(f2794E)) {
                    b2 = com.google.common.base.a.F;
                }
                break;
            case 1809237540:
                if (str.equals(g)) {
                    b2 = com.google.common.base.a.G;
                }
                break;
            case 1950749482:
                if (str.equals(f2818u)) {
                    b2 = com.google.common.base.a.H;
                }
                break;
            case 1950789798:
                if (str.equals(f2823z)) {
                    b2 = 31;
                }
                break;
            case 1951062397:
                if (str.equals(f2813p)) {
                    b2 = 32;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                return true;
            default:
                return false;
        }
    }

    public static /* synthetic */ Extractor[] q() {
        return new Extractor[]{new MatroskaExtractor()};
    }

    public static void v(String str, long j2, byte[] bArr) {
        byte[] bArrO;
        int i2;
        str.hashCode();
        switch (str) {
            case "S_TEXT/ASS":
                bArrO = o(j2, f2801L, 10000L);
                i2 = 21;
                break;
            case "S_TEXT/WEBVTT":
                bArrO = o(j2, f2802M, 1000L);
                i2 = 25;
                break;
            case "S_TEXT/UTF8":
                bArrO = o(j2, f2800K, 1000L);
                i2 = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(bArrO, 0, bArr, i2, bArrO.length);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void b(ExtractorOutput extractorOutput) {
        this.f2827a = extractorOutput;
    }

    /* JADX WARN: Code duplicated, block: B:97:0x0288  */
    @CallSuper
    public void binaryElement(int i2, int i3, ExtractorInput extractorInput) throws IOException {
        c cVar;
        int i4;
        c cVar2;
        long j2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = 0;
        int i10 = 1;
        if (i2 != 161 && i2 != 163) {
            if (i2 == 165) {
                if (this.f2847e != 2) {
                    return;
                }
                handleBlockAdditionalData(this.f2826a.get(this.f2859h), this.f2871k, extractorInput, i3);
                return;
            }
            if (i2 == 16877) {
                handleBlockAddIDExtraData(getCurrentTrack(i2), extractorInput, i3);
                return;
            }
            if (i2 == 16981) {
                i(i2);
                byte[] bArr = new byte[i3];
                this.f2829a.f2886a = bArr;
                extractorInput.readFully(bArr, 0, i3);
                return;
            }
            if (i2 == 18402) {
                byte[] bArr2 = new byte[i3];
                extractorInput.readFully(bArr2, 0, i3);
                getCurrentTrack(i2).f2881a = new TrackOutput.a(1, bArr2, 0, 0);
                return;
            }
            if (i2 == 21419) {
                Arrays.fill(this.f2849e.d(), (byte) 0);
                extractorInput.readFully(this.f2849e.d(), 4 - i3, i3);
                this.f2849e.S(0);
                this.f2843d = (int) this.f2849e.I();
                return;
            }
            if (i2 == 25506) {
                i(i2);
                byte[] bArr3 = new byte[i3];
                this.f2829a.f2891b = bArr3;
                extractorInput.readFully(bArr3, 0, i3);
                return;
            }
            if (i2 != 30322) {
                throw ParserException.createForMalformedContainer("Unexpected id: " + i2, null);
            }
            i(i2);
            byte[] bArr4 = new byte[i3];
            this.f2829a.f2895c = bArr4;
            extractorInput.readFully(bArr4, 0, i3);
            return;
        }
        if (this.f2847e == 0) {
            this.f2859h = (int) this.f2832a.d(extractorInput, false, true, 8);
            this.f2863i = this.f2832a.b();
            this.f2872k = -9223372036854775807L;
            this.f2847e = 1;
            this.f2841c.O(0);
        }
        c cVar3 = this.f2826a.get(this.f2859h);
        if (cVar3 == null) {
            extractorInput.skipFully(i3 - this.f2863i);
            this.f2847e = 0;
            return;
        }
        cVar3.f();
        if (this.f2847e == 1) {
            s(extractorInput, 3);
            int i11 = (this.f2841c.d()[2] & 6) >> 1;
            byte b2 = 255;
            if (i11 == 0) {
                this.f2855g = 1;
                int[] iArrM = m(this.f2835a, 1);
                this.f2835a = iArrM;
                iArrM[0] = (i3 - this.f2863i) - 3;
            } else {
                int i12 = 4;
                s(extractorInput, 4);
                int i13 = (this.f2841c.d()[3] & 255) + 1;
                this.f2855g = i13;
                int[] iArrM2 = m(this.f2835a, i13);
                this.f2835a = iArrM2;
                if (i11 == 2) {
                    int i14 = (i3 - this.f2863i) - 4;
                    int i15 = this.f2855g;
                    Arrays.fill(iArrM2, 0, i15, i14 / i15);
                } else {
                    if (i11 == 1) {
                        int i16 = 0;
                        int i17 = 0;
                        while (true) {
                            i5 = this.f2855g;
                            if (i16 >= i5 - 1) {
                                break;
                            }
                            this.f2835a[i16] = 0;
                            do {
                                i12++;
                                s(extractorInput, i12);
                                i6 = this.f2841c.d()[i12 - 1] & 255;
                                int[] iArr = this.f2835a;
                                i7 = iArr[i16] + i6;
                                iArr[i16] = i7;
                            } while (i6 == 255);
                            i17 += i7;
                            i16++;
                        }
                        this.f2835a[i5 - 1] = ((i3 - this.f2863i) - i12) - i17;
                    } else {
                        if (i11 != 3) {
                            throw ParserException.createForMalformedContainer("Unexpected lacing value: " + i11, null);
                        }
                        int i18 = 0;
                        int i19 = 0;
                        while (true) {
                            int i20 = this.f2855g;
                            if (i18 >= i20 - 1) {
                                cVar2 = cVar3;
                                this.f2835a[i20 - 1] = ((i3 - this.f2863i) - i12) - i19;
                                break;
                            }
                            this.f2835a[i18] = i9;
                            i12++;
                            s(extractorInput, i12);
                            int i21 = i12 - 1;
                            if (this.f2841c.d()[i21] == 0) {
                                throw ParserException.createForMalformedContainer("No valid varint length mask found", null);
                            }
                            int i22 = i9;
                            while (true) {
                                if (i22 >= 8) {
                                    j2 = 0;
                                    break;
                                }
                                int i23 = i10 << (7 - i22);
                                if ((this.f2841c.d()[i21] & i23) != 0) {
                                    int i24 = i12 + i22;
                                    s(extractorInput, i24);
                                    j2 = (~i23) & this.f2841c.d()[i21] & b2;
                                    int i25 = i21 + 1;
                                    while (i25 < i24) {
                                        j2 = (j2 << 8) | ((long) (this.f2841c.d()[i25] & b2));
                                        i25++;
                                        i24 = i24;
                                        b2 = 255;
                                    }
                                    int i26 = i24;
                                    if (i18 > 0) {
                                        j2 -= (1 << ((i22 * 7) + 6)) - 1;
                                    }
                                    i12 = i26;
                                    break;
                                }
                                i22++;
                                i10 = 1;
                                b2 = 255;
                            }
                            if (j2 < -2147483648L || j2 > 2147483647L) {
                                throw ParserException.createForMalformedContainer("EBML lacing sample size out of range.", null);
                            }
                            int i27 = (int) j2;
                            int[] iArr2 = this.f2835a;
                            if (i18 != 0) {
                                i27 += iArr2[i18 - 1];
                            }
                            iArr2[i18] = i27;
                            i19 += i27;
                            i18++;
                            cVar3 = cVar3;
                            i9 = 0;
                            i10 = 1;
                            b2 = 255;
                        }
                    }
                    this.f2868j = this.f2864i + u((this.f2841c.d()[0] << 8) | (this.f2841c.d()[1] & 255));
                    cVar = cVar2;
                    if (cVar.f2887b != 2 || (i2 == 163 && (this.f2841c.d()[2] & UnsignedBytes.f32243a) == 128)) {
                        i8 = 1;
                    } else {
                        i8 = 0;
                    }
                    this.f2867j = i8;
                    this.f2847e = 2;
                    this.f2851f = 0;
                    i4 = 163;
                }
            }
            cVar2 = cVar3;
            this.f2868j = this.f2864i + u((this.f2841c.d()[0] << 8) | (this.f2841c.d()[1] & 255));
            cVar = cVar2;
            if (cVar.f2887b != 2) {
                i8 = 1;
            } else {
                i8 = 1;
            }
            this.f2867j = i8;
            this.f2847e = 2;
            this.f2851f = 0;
            i4 = 163;
        } else {
            cVar = cVar3;
            i4 = 163;
        }
        if (i2 == i4) {
            while (true) {
                int i28 = this.f2851f;
                if (i28 >= this.f2855g) {
                    this.f2847e = 0;
                    return;
                }
                l(cVar, ((long) ((this.f2851f * cVar.f2892c) / 1000)) + this.f2868j, this.f2867j, w(extractorInput, cVar, this.f2835a[i28], false), 0);
                this.f2851f++;
            }
        } else {
            while (true) {
                int i29 = this.f2851f;
                if (i29 >= this.f2855g) {
                    return;
                }
                int[] iArr3 = this.f2835a;
                iArr3[i29] = w(extractorInput, cVar, iArr3[i29], true);
                this.f2851f++;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        this.f2850e = false;
        boolean zA = true;
        while (zA && !this.f2850e) {
            zA = this.f2828a.a(extractorInput);
            if (zA && r(iv6Var, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (zA) {
            return 0;
        }
        for (int i2 = 0; i2 < this.f2826a.size(); i2++) {
            c cVarValueAt = this.f2826a.valueAt(i2);
            cVarValueAt.f();
            cVarValueAt.j();
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final boolean d(ExtractorInput extractorInput) throws IOException {
        return new cl8().b(extractorInput);
    }

    @CallSuper
    public void endMasterElement(int i2) throws ParserException {
        j();
        if (i2 == 160) {
            if (this.f2847e != 2) {
                return;
            }
            c cVar = this.f2826a.get(this.f2859h);
            cVar.f();
            if (this.f2874l > 0 && f2813p.equals(cVar.f2889b)) {
                this.f2869j.P(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f2874l).array());
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.f2855g; i4++) {
                i3 += this.f2835a[i4];
            }
            int i5 = 0;
            while (i5 < this.f2855g) {
                long j2 = this.f2868j + ((long) ((cVar.f2892c * i5) / 1000));
                int i6 = this.f2867j;
                if (i5 == 0 && !this.f2854f) {
                    i6 |= 1;
                }
                int i7 = this.f2835a[i5];
                int i8 = i3 - i7;
                l(cVar, j2, i6, i7, i8);
                i5++;
                i3 = i8;
            }
            this.f2847e = 0;
            return;
        }
        if (i2 == 174) {
            c cVar2 = (c) sb0.k(this.f2829a);
            String str = cVar2.f2889b;
            if (str == null) {
                throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", null);
            }
            if (p(str)) {
                cVar2.i(this.f2827a, cVar2.f2878a);
                this.f2826a.put(cVar2.f2878a, cVar2);
            }
            this.f2829a = null;
            return;
        }
        if (i2 == 19899) {
            int i9 = this.f2843d;
            if (i9 != -1) {
                long j3 = this.f2852f;
                if (j3 != -1) {
                    if (i9 == 475249515) {
                        this.f2856g = j3;
                        return;
                    }
                    return;
                }
            }
            throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i2 == 25152) {
            i(i2);
            c cVar3 = this.f2829a;
            if (cVar3.f2885a) {
                if (cVar3.f2881a == null) {
                    throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                cVar3.f2880a = new DrmInitData(new DrmInitData.SchemeData(C.f1996a, "video/webm", this.f2829a.f2881a.f2706a));
                return;
            }
            return;
        }
        if (i2 == 28032) {
            i(i2);
            c cVar4 = this.f2829a;
            if (cVar4.f2885a && cVar4.f2886a != null) {
                throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i2 == 357149030) {
            if (this.f2840c == -9223372036854775807L) {
                this.f2840c = 1000000L;
            }
            long j4 = this.f2844d;
            if (j4 != -9223372036854775807L) {
                this.f2848e = u(j4);
                return;
            }
            return;
        }
        if (i2 == 374648427) {
            if (this.f2826a.size() == 0) {
                throw ParserException.createForMalformedContainer("No valid tracks were found", null);
            }
            this.f2827a.endTracks();
        } else {
            if (i2 != 475249515) {
                return;
            }
            if (!this.f2839b) {
                this.f2827a.d(k(this.f2831a, this.f2838b));
                this.f2839b = true;
            }
            this.f2831a = null;
            this.f2838b = null;
        }
    }

    @CallSuper
    public void floatElement(int i2, double d2) throws ParserException {
        if (i2 == 181) {
            getCurrentTrack(i2).t = (int) d2;
        }
        if (i2 == 17545) {
            this.f2844d = (long) d2;
            return;
        }
        switch (i2) {
            case d1 /* 21969 */:
                getCurrentTrack(i2).d = (float) d2;
                break;
            case e1 /* 21970 */:
                getCurrentTrack(i2).e = (float) d2;
                break;
            case f1 /* 21971 */:
                getCurrentTrack(i2).f = (float) d2;
                break;
            case g1 /* 21972 */:
                getCurrentTrack(i2).g = (float) d2;
                break;
            case h1 /* 21973 */:
                getCurrentTrack(i2).h = (float) d2;
                break;
            case i1 /* 21974 */:
                getCurrentTrack(i2).i = (float) d2;
                break;
            case j1 /* 21975 */:
                getCurrentTrack(i2).j = (float) d2;
                break;
            case k1 /* 21976 */:
                getCurrentTrack(i2).k = (float) d2;
                break;
            case l1 /* 21977 */:
                getCurrentTrack(i2).l = (float) d2;
                break;
            case m1 /* 21978 */:
                getCurrentTrack(i2).m = (float) d2;
                break;
            default:
                switch (i2) {
                    case S0 /* 30323 */:
                        getCurrentTrack(i2).f30661a = (float) d2;
                        break;
                    case T0 /* 30324 */:
                        getCurrentTrack(i2).b = (float) d2;
                        break;
                    case U0 /* 30325 */:
                        getCurrentTrack(i2).c = (float) d2;
                        break;
                }
                break;
        }
    }

    public c getCurrentTrack(int i2) throws ParserException {
        i(i2);
        return this.f2829a;
    }

    @CallSuper
    public int getElementType(int i2) {
        switch (i2) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case T /* 238 */:
            case 241:
            case 251:
            case f0 /* 16871 */:
            case C0 /* 16980 */:
            case B /* 17029 */:
            case z /* 17143 */:
            case F0 /* 18401 */:
            case I0 /* 18408 */:
            case z0 /* 20529 */:
            case A0 /* 20530 */:
            case H /* 21420 */:
            case V0 /* 21432 */:
            case q0 /* 21680 */:
            case s0 /* 21682 */:
            case r0 /* 21690 */:
            case b0 /* 21930 */:
            case X0 /* 21945 */:
            case Y0 /* 21946 */:
            case Z0 /* 21947 */:
            case a1 /* 21948 */:
            case b1 /* 21949 */:
            case d0 /* 21998 */:
            case k0 /* 22186 */:
            case l0 /* 22203 */:
            case v0 /* 25188 */:
            case m0 /* 30114 */:
            case Q0 /* 30321 */:
            case c0 /* 2352003 */:
            case J /* 2807729 */:
                return 2;
            case 134:
            case A /* 17026 */:
            case h0 /* 21358 */:
            case O0 /* 2274716 */:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case e0 /* 16868 */:
            case H0 /* 18407 */:
            case F /* 19899 */:
            case B0 /* 20532 */:
            case E0 /* 20533 */:
            case W0 /* 21936 */:
            case c1 /* 21968 */:
            case y0 /* 25152 */:
            case x0 /* 28032 */:
            case R /* 30113 */:
            case P0 /* 30320 */:
            case E /* 290298740 */:
            case 357149030:
            case W /* 374648427 */:
            case C /* 408125543 */:
            case 440786851:
            case J0 /* 475249515 */:
            case L /* 524531317 */:
                return 1;
            case 161:
            case 163:
            case 165:
            case g0 /* 16877 */:
            case D0 /* 16981 */:
            case G0 /* 18402 */:
            case G /* 21419 */:
            case j0 /* 25506 */:
            case R0 /* 30322 */:
                return 4;
            case 181:
            case K /* 17545 */:
            case d1 /* 21969 */:
            case e1 /* 21970 */:
            case f1 /* 21971 */:
            case g1 /* 21972 */:
            case h1 /* 21973 */:
            case i1 /* 21974 */:
            case j1 /* 21975 */:
            case k1 /* 21976 */:
            case l1 /* 21977 */:
            case m1 /* 21978 */:
            case S0 /* 30323 */:
            case T0 /* 30324 */:
            case U0 /* 30325 */:
                return 5;
            default:
                return 0;
        }
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    public final void h(int i2) throws ParserException {
        if (this.f2831a == null || this.f2838b == null) {
            throw ParserException.createForMalformedContainer("Element " + i2 + " must be in a Cues", null);
        }
    }

    public void handleBlockAddIDExtraData(c cVar, ExtractorInput extractorInput, int i2) throws IOException {
        if (cVar.f2899e != 1685485123 && cVar.f2899e != 1685480259) {
            extractorInput.skipFully(i2);
            return;
        }
        byte[] bArr = new byte[i2];
        cVar.f2898d = bArr;
        extractorInput.readFully(bArr, 0, i2);
    }

    public void handleBlockAdditionalData(c cVar, int i2, ExtractorInput extractorInput, int i3) throws IOException {
        if (i2 != 4 || !e.equals(cVar.f2889b)) {
            extractorInput.skipFully(i3);
        } else {
            this.f2869j.O(i3);
            extractorInput.readFully(this.f2869j.d(), 0, i3);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    public final void i(int i2) throws ParserException {
        if (this.f2829a != null) {
            return;
        }
        throw ParserException.createForMalformedContainer("Element " + i2 + " must be in a TrackEntry", null);
    }

    @CallSuper
    public void integerElement(int i2, long j2) throws ParserException {
        if (i2 == 20529) {
            if (j2 == 0) {
                return;
            }
            throw ParserException.createForMalformedContainer("ContentEncodingOrder " + j2 + " not supported", null);
        }
        if (i2 == 20530) {
            if (j2 == 1) {
                return;
            }
            throw ParserException.createForMalformedContainer("ContentEncodingScope " + j2 + " not supported", null);
        }
        switch (i2) {
            case 131:
                getCurrentTrack(i2).f2887b = (int) j2;
                return;
            case 136:
                getCurrentTrack(i2).f2897d = j2 == 1;
                return;
            case 155:
                this.f2872k = u(j2);
                return;
            case 159:
                getCurrentTrack(i2).r = (int) j2;
                return;
            case 176:
                getCurrentTrack(i2).f2900f = (int) j2;
                return;
            case 179:
                h(i2);
                this.f2831a.a(u(j2));
                return;
            case 186:
                getCurrentTrack(i2).f2901g = (int) j2;
                return;
            case 215:
                getCurrentTrack(i2).f2878a = (int) j2;
                return;
            case 231:
                this.f2864i = u(j2);
                return;
            case T /* 238 */:
                this.f2871k = (int) j2;
                return;
            case 241:
                if (this.f2846d) {
                    return;
                }
                h(i2);
                this.f2838b.a(j2);
                this.f2846d = true;
                return;
            case 251:
                this.f2854f = true;
                return;
            case f0 /* 16871 */:
                getCurrentTrack(i2).f2899e = (int) j2;
                return;
            case C0 /* 16980 */:
                if (j2 == 3) {
                    return;
                }
                throw ParserException.createForMalformedContainer("ContentCompAlgo " + j2 + " not supported", null);
            case B /* 17029 */:
                if (j2 < 1 || j2 > 2) {
                    throw ParserException.createForMalformedContainer("DocTypeReadVersion " + j2 + " not supported", null);
                }
                return;
            case z /* 17143 */:
                if (j2 == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer("EBMLReadVersion " + j2 + " not supported", null);
            case F0 /* 18401 */:
                if (j2 == 5) {
                    return;
                }
                throw ParserException.createForMalformedContainer("ContentEncAlgo " + j2 + " not supported", null);
            case I0 /* 18408 */:
                if (j2 == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer("AESSettingsCipherMode " + j2 + " not supported", null);
            case H /* 21420 */:
                this.f2852f = j2 + this.f2836b;
                return;
            case V0 /* 21432 */:
                int i3 = (int) j2;
                i(i2);
                if (i3 == 0) {
                    this.f2829a.f2906l = 0;
                    return;
                }
                if (i3 == 1) {
                    this.f2829a.f2906l = 2;
                    return;
                } else if (i3 == 3) {
                    this.f2829a.f2906l = 1;
                    return;
                } else {
                    if (i3 != 15) {
                        return;
                    }
                    this.f2829a.f2906l = 3;
                    return;
                }
            case q0 /* 21680 */:
                getCurrentTrack(i2).f2902h = (int) j2;
                return;
            case s0 /* 21682 */:
                getCurrentTrack(i2).f2904j = (int) j2;
                return;
            case r0 /* 21690 */:
                getCurrentTrack(i2).f2903i = (int) j2;
                return;
            case b0 /* 21930 */:
                getCurrentTrack(i2).f2894c = j2 == 1;
                return;
            case d0 /* 21998 */:
                getCurrentTrack(i2).f2896d = (int) j2;
                return;
            case k0 /* 22186 */:
                getCurrentTrack(i2).f2879a = j2;
                return;
            case l0 /* 22203 */:
                getCurrentTrack(i2).f2888b = j2;
                return;
            case v0 /* 25188 */:
                getCurrentTrack(i2).s = (int) j2;
                return;
            case m0 /* 30114 */:
                this.f2874l = j2;
                return;
            case Q0 /* 30321 */:
                i(i2);
                int i4 = (int) j2;
                if (i4 == 0) {
                    this.f2829a.f2905k = 0;
                    return;
                }
                if (i4 == 1) {
                    this.f2829a.f2905k = 1;
                    return;
                } else if (i4 == 2) {
                    this.f2829a.f2905k = 2;
                    return;
                } else {
                    if (i4 != 3) {
                        return;
                    }
                    this.f2829a.f2905k = 3;
                    return;
                }
            case c0 /* 2352003 */:
                getCurrentTrack(i2).f2892c = (int) j2;
                return;
            case J /* 2807729 */:
                this.f2840c = j2;
                return;
            default:
                switch (i2) {
                    case X0 /* 21945 */:
                        i(i2);
                        int i5 = (int) j2;
                        if (i5 == 1) {
                            this.f2829a.o = 2;
                            return;
                        } else {
                            if (i5 != 2) {
                                return;
                            }
                            this.f2829a.o = 1;
                            return;
                        }
                    case Y0 /* 21946 */:
                        i(i2);
                        int iC = tn1.c((int) j2);
                        if (iC != -1) {
                            this.f2829a.n = iC;
                            return;
                        }
                        return;
                    case Z0 /* 21947 */:
                        i(i2);
                        this.f2829a.f2890b = true;
                        int iB = tn1.b((int) j2);
                        if (iB != -1) {
                            this.f2829a.f2907m = iB;
                            return;
                        }
                        return;
                    case a1 /* 21948 */:
                        getCurrentTrack(i2).p = (int) j2;
                        return;
                    case b1 /* 21949 */:
                        getCurrentTrack(i2).q = (int) j2;
                        return;
                    default:
                        return;
                }
        }
    }

    @CallSuper
    public boolean isLevel1Element(int i2) {
        return i2 == 357149030 || i2 == 524531317 || i2 == 475249515 || i2 == 374648427;
    }

    @EnsuresNonNull({"extractorOutput"})
    public final void j() {
        sb0.k(this.f2827a);
    }

    public final SeekMap k(@Nullable q25 q25Var, @Nullable q25 q25Var2) {
        int i2;
        if (this.f2836b == -1 || this.f2848e == -9223372036854775807L || q25Var == null || q25Var.c() == 0 || q25Var2 == null || q25Var2.c() != q25Var.c()) {
            return new SeekMap.b(this.f2848e);
        }
        int iC = q25Var.c();
        int[] iArrCopyOf = new int[iC];
        long[] jArrCopyOf = new long[iC];
        long[] jArrCopyOf2 = new long[iC];
        long[] jArrCopyOf3 = new long[iC];
        int i3 = 0;
        for (int i4 = 0; i4 < iC; i4++) {
            jArrCopyOf3[i4] = q25Var.b(i4);
            jArrCopyOf[i4] = this.f2836b + q25Var2.b(i4);
        }
        while (true) {
            i2 = iC - 1;
            if (i3 >= i2) {
                break;
            }
            int i5 = i3 + 1;
            iArrCopyOf[i3] = (int) (jArrCopyOf[i5] - jArrCopyOf[i3]);
            jArrCopyOf2[i3] = jArrCopyOf3[i5] - jArrCopyOf3[i3];
            i3 = i5;
        }
        iArrCopyOf[i2] = (int) ((this.f2836b + this.f2825a) - jArrCopyOf[i2]);
        long j2 = this.f2848e - jArrCopyOf3[i2];
        jArrCopyOf2[i2] = j2;
        if (j2 <= 0) {
            Log.n(f2803a, "Discarding last cue point with unexpected duration: " + j2);
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i2);
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
            jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i2);
        }
        return new com.google.android.exoplayer2.extractor.b(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
    }

    @RequiresNonNull({"#1.output"})
    public final void l(c cVar, long j2, int i2, int i3, int i4) {
        i iVar = cVar.f2883a;
        if (iVar != null) {
            iVar.c(cVar.f2882a, j2, i2, i3, i4, cVar.f2881a);
        } else {
            if (f2794E.equals(cVar.f2889b) || f2795F.equals(cVar.f2889b) || f2796G.equals(cVar.f2889b)) {
                if (this.f2855g > 1) {
                    Log.n(f2803a, "Skipping subtitle sample in laced block.");
                } else {
                    long j3 = this.f2872k;
                    if (j3 == -9223372036854775807L) {
                        Log.n(f2803a, "Skipping subtitle sample with no duration.");
                    } else {
                        v(cVar.f2889b, j3, this.f2857g.d());
                        for (int iE = this.f2857g.e(); iE < this.f2857g.f(); iE++) {
                            if (this.f2857g.d()[iE] == 0) {
                                this.f2857g.R(iE);
                                break;
                            }
                        }
                        TrackOutput trackOutput = cVar.f2882a;
                        om6 om6Var = this.f2857g;
                        trackOutput.c(om6Var, om6Var.f());
                        i3 += this.f2857g.f();
                    }
                }
            }
            if ((268435456 & i2) != 0) {
                if (this.f2855g > 1) {
                    this.f2869j.O(0);
                } else {
                    int iF = this.f2869j.f();
                    cVar.f2882a.a(this.f2869j, iF, 2);
                    i3 += iF;
                }
            }
            cVar.f2882a.e(j2, i2, i3, i4, cVar.f2881a);
        }
        this.f2850e = true;
    }

    public final int n() {
        int i2 = this.f2875m;
        t();
        return i2;
    }

    public final boolean r(iv6 iv6Var, long j2) {
        if (this.f2842c) {
            this.f2860h = j2;
            iv6Var.f42452a = this.f2856g;
            this.f2842c = false;
            return true;
        }
        if (this.f2839b) {
            long j3 = this.f2860h;
            if (j3 != -1) {
                iv6Var.f42452a = j3;
                this.f2860h = -1L;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void release() {
    }

    public final void s(ExtractorInput extractorInput, int i2) throws IOException {
        if (this.f2841c.f() >= i2) {
            return;
        }
        if (this.f2841c.b() < i2) {
            om6 om6Var = this.f2841c;
            om6Var.c(Math.max(om6Var.b() * 2, i2));
        }
        extractorInput.readFully(this.f2841c.d(), this.f2841c.f(), i2 - this.f2841c.f());
        this.f2841c.R(i2);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    @CallSuper
    public void seek(long j2, long j3) {
        this.f2864i = -9223372036854775807L;
        this.f2847e = 0;
        this.f2828a.reset();
        this.f2832a.e();
        t();
        for (int i2 = 0; i2 < this.f2826a.size(); i2++) {
            this.f2826a.valueAt(i2).n();
        }
    }

    @CallSuper
    public void startMasterElement(int i2, long j2, long j3) throws ParserException {
        j();
        if (i2 == 160) {
            this.f2854f = false;
            this.f2874l = 0L;
            return;
        }
        if (i2 == 174) {
            this.f2829a = new c();
            return;
        }
        if (i2 == 187) {
            this.f2846d = false;
            return;
        }
        if (i2 == 19899) {
            this.f2843d = -1;
            this.f2852f = -1L;
            return;
        }
        if (i2 == 20533) {
            getCurrentTrack(i2).f2885a = true;
            return;
        }
        if (i2 == 21968) {
            getCurrentTrack(i2).f2890b = true;
            return;
        }
        if (i2 == 408125543) {
            long j4 = this.f2836b;
            if (j4 != -1 && j4 != j2) {
                throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", null);
            }
            this.f2836b = j2;
            this.f2825a = j3;
            return;
        }
        if (i2 == 475249515) {
            this.f2831a = new q25();
            this.f2838b = new q25();
        } else if (i2 == 524531317 && !this.f2839b) {
            if (this.f2834a && this.f2856g != -1) {
                this.f2842c = true;
            } else {
                this.f2827a.d(new SeekMap.b(this.f2848e));
                this.f2839b = true;
            }
        }
    }

    @CallSuper
    public void stringElement(int i2, String str) throws ParserException {
        if (i2 == 134) {
            getCurrentTrack(i2).f2889b = str;
            return;
        }
        if (i2 != 17026) {
            if (i2 == 21358) {
                getCurrentTrack(i2).f2884a = str;
                return;
            } else {
                if (i2 != 2274716) {
                    return;
                }
                getCurrentTrack(i2).f2893c = str;
                return;
            }
        }
        if (c.equals(str) || b.equals(str)) {
            return;
        }
        throw ParserException.createForMalformedContainer("DocType " + str + " not supported", null);
    }

    public final void t() {
        this.f2873l = 0;
        this.f2875m = 0;
        this.f2876n = 0;
        this.f2858g = false;
        this.f2862h = false;
        this.f2866i = false;
        this.f2877o = 0;
        this.f2824a = (byte) 0;
        this.f2870j = false;
        this.f2853f.O(0);
    }

    public final long u(long j2) throws ParserException {
        long j3 = this.f2840c;
        if (j3 != -9223372036854775807L) {
            return gj9.o1(j2, j3, 1000L);
        }
        throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @RequiresNonNull({"#2.output"})
    public final int w(ExtractorInput extractorInput, c cVar, int i2, boolean z2) throws IOException {
        int i3;
        if (f2794E.equals(cVar.f2889b)) {
            x(extractorInput, f2806a, i2);
            return n();
        }
        if (f2795F.equals(cVar.f2889b)) {
            x(extractorInput, f2808c, i2);
            return n();
        }
        if (f2796G.equals(cVar.f2889b)) {
            x(extractorInput, f2809d, i2);
            return n();
        }
        TrackOutput trackOutput = cVar.f2882a;
        if (!this.f2858g) {
            if (cVar.f2885a) {
                this.f2867j &= -1073741825;
                if (!this.f2862h) {
                    extractorInput.readFully(this.f2841c.d(), 0, 1);
                    this.f2873l++;
                    if ((this.f2841c.d()[0] & UnsignedBytes.f32243a) == 128) {
                        throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", null);
                    }
                    this.f2824a = this.f2841c.d()[0];
                    this.f2862h = true;
                }
                byte b2 = this.f2824a;
                if ((b2 & 1) == 1) {
                    boolean z3 = (b2 & 2) == 2;
                    this.f2867j |= 1073741824;
                    if (!this.f2870j) {
                        extractorInput.readFully(this.f2861h.d(), 0, 8);
                        this.f2873l += 8;
                        this.f2870j = true;
                        this.f2841c.d()[0] = (byte) ((z3 ? 128 : 0) | 8);
                        this.f2841c.S(0);
                        trackOutput.a(this.f2841c, 1, 1);
                        this.f2875m++;
                        this.f2861h.S(0);
                        trackOutput.a(this.f2861h, 8, 1);
                        this.f2875m += 8;
                    }
                    if (z3) {
                        if (!this.f2866i) {
                            extractorInput.readFully(this.f2841c.d(), 0, 1);
                            this.f2873l++;
                            this.f2841c.S(0);
                            this.f2877o = this.f2841c.G();
                            this.f2866i = true;
                        }
                        int i4 = this.f2877o * 4;
                        this.f2841c.O(i4);
                        extractorInput.readFully(this.f2841c.d(), 0, i4);
                        this.f2873l += i4;
                        short s2 = (short) ((this.f2877o / 2) + 1);
                        int i5 = (s2 * 6) + 2;
                        ByteBuffer byteBuffer = this.f2833a;
                        if (byteBuffer == null || byteBuffer.capacity() < i5) {
                            this.f2833a = ByteBuffer.allocate(i5);
                        }
                        this.f2833a.position(0);
                        this.f2833a.putShort(s2);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            i3 = this.f2877o;
                            if (i6 >= i3) {
                                break;
                            }
                            int iK = this.f2841c.K();
                            if (i6 % 2 == 0) {
                                this.f2833a.putShort((short) (iK - i7));
                            } else {
                                this.f2833a.putInt(iK - i7);
                            }
                            i6++;
                            i7 = iK;
                        }
                        int i8 = (i2 - this.f2873l) - i7;
                        if (i3 % 2 == 1) {
                            this.f2833a.putInt(i8);
                        } else {
                            this.f2833a.putShort((short) i8);
                            this.f2833a.putInt(0);
                        }
                        this.f2865i.Q(this.f2833a.array(), i5);
                        trackOutput.a(this.f2865i, i5, 1);
                        this.f2875m += i5;
                    }
                }
            } else {
                byte[] bArr = cVar.f2886a;
                if (bArr != null) {
                    this.f2853f.Q(bArr, bArr.length);
                }
            }
            if (cVar.o(z2)) {
                this.f2867j |= 268435456;
                this.f2869j.O(0);
                int iF = (this.f2853f.f() + i2) - this.f2873l;
                this.f2841c.O(4);
                this.f2841c.d()[0] = (byte) ((iF >> 24) & 255);
                this.f2841c.d()[1] = (byte) ((iF >> 16) & 255);
                this.f2841c.d()[2] = (byte) ((iF >> 8) & 255);
                this.f2841c.d()[3] = (byte) (iF & 255);
                trackOutput.a(this.f2841c, 4, 2);
                this.f2875m += 4;
            }
            this.f2858g = true;
        }
        int iF2 = i2 + this.f2853f.f();
        if (!k.equals(cVar.f2889b) && !l.equals(cVar.f2889b)) {
            if (cVar.f2883a != null) {
                sb0.i(this.f2853f.f() == 0);
                cVar.f2883a.d(extractorInput);
            }
            while (true) {
                int i9 = this.f2873l;
                if (i9 >= iF2) {
                    break;
                }
                int iY = y(extractorInput, trackOutput, iF2 - i9);
                this.f2873l += iY;
                this.f2875m += iY;
            }
        } else {
            byte[] bArrD = this.f2837b.d();
            bArrD[0] = 0;
            bArrD[1] = 0;
            bArrD[2] = 0;
            int i10 = cVar.u;
            int i11 = 4 - i10;
            while (this.f2873l < iF2) {
                int i12 = this.f2876n;
                if (i12 == 0) {
                    z(extractorInput, bArrD, i11, i10);
                    this.f2873l += i10;
                    this.f2837b.S(0);
                    this.f2876n = this.f2837b.K();
                    this.f2830a.S(0);
                    trackOutput.c(this.f2830a, 4);
                    this.f2875m += 4;
                } else {
                    int iY2 = y(extractorInput, trackOutput, i12);
                    this.f2873l += iY2;
                    this.f2875m += iY2;
                    this.f2876n -= iY2;
                }
            }
        }
        if (f2812o.equals(cVar.f2889b)) {
            this.f2845d.S(0);
            trackOutput.c(this.f2845d, 4);
            this.f2875m += 4;
        }
        return n();
    }

    public final void x(ExtractorInput extractorInput, byte[] bArr, int i2) throws IOException {
        int length = bArr.length + i2;
        if (this.f2857g.b() < length) {
            this.f2857g.P(Arrays.copyOf(bArr, length + i2));
        } else {
            System.arraycopy(bArr, 0, this.f2857g.d(), 0, bArr.length);
        }
        extractorInput.readFully(this.f2857g.d(), bArr.length, i2);
        this.f2857g.S(0);
        this.f2857g.R(length);
    }

    public final int y(ExtractorInput extractorInput, TrackOutput trackOutput, int i2) throws IOException {
        int iA = this.f2853f.a();
        if (iA <= 0) {
            return trackOutput.b(extractorInput, i2, false);
        }
        int iMin = Math.min(i2, iA);
        trackOutput.c(this.f2853f, iMin);
        return iMin;
    }

    public final void z(ExtractorInput extractorInput, byte[] bArr, int i2, int i3) throws IOException {
        int iMin = Math.min(i3, this.f2853f.a());
        extractorInput.readFully(bArr, i2 + iMin, i3 - iMin);
        if (iMin > 0) {
            this.f2853f.k(bArr, i2, iMin);
        }
    }

    public MatroskaExtractor(int i2) {
        this(new com.google.android.exoplayer2.extractor.mkv.a(), i2);
    }

    public MatroskaExtractor(EbmlReader ebmlReader, int i2) {
        this.f2836b = -1L;
        this.f2840c = -9223372036854775807L;
        this.f2844d = -9223372036854775807L;
        this.f2848e = -9223372036854775807L;
        this.f2856g = -1L;
        this.f2860h = -1L;
        this.f2864i = -9223372036854775807L;
        this.f2828a = ebmlReader;
        ebmlReader.b(new b());
        this.f2834a = (i2 & 1) == 0;
        this.f2832a = new yl9();
        this.f2826a = new SparseArray<>();
        this.f2841c = new om6(4);
        this.f2845d = new om6(ByteBuffer.allocate(4).putInt(-1).array());
        this.f2849e = new om6(4);
        this.f2830a = new om6(kw5.f17801a);
        this.f2837b = new om6(4);
        this.f2853f = new om6();
        this.f2857g = new om6();
        this.f2861h = new om6(8);
        this.f2865i = new om6();
        this.f2869j = new om6();
        this.f2835a = new int[1];
    }
}
