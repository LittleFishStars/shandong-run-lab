package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RequiresApi;
import com.google.errorprone.annotations.InlineMe;
import com.zj.adlib.gj9;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class C {
    public static final int A = 16;
    public static final int A0 = 134217728;
    public static final int A1 = 2;
    public static final int A2 = 4;
    public static final int B = 15;
    public static final int B0 = 268435456;
    public static final int B1 = 3;
    public static final int B2 = 3;
    public static final int C = 1073741824;
    public static final int C0 = 536870912;
    public static final int C1 = 4;
    public static final int C2 = 2;
    public static final int D = 5;
    public static final int D0 = 1073741824;
    public static final int D1 = 10000;
    public static final int D2 = 1;
    public static final int E = 6;
    public static final int E0 = Integer.MIN_VALUE;
    public static final int E1 = 65536;
    public static final int E2 = 0;
    public static final int F = 18;
    public static final int F0 = -1;
    public static final int F1 = 0;
    public static final int G = 17;
    public static final int G0 = 0;
    public static final int G1 = 1;
    public static final int H = 7;
    public static final int H0 = 1;
    public static final int H1 = 2;
    public static final int I = 8;
    public static final int I0 = 1;
    public static final int I1 = 3;
    public static final int J = 14;
    public static final int J0 = 2;
    public static final int J1 = 1;
    public static final int K = 0;
    public static final int K0 = 1;
    public static final int K1 = 2;
    public static final int L = 1;
    public static final int L0 = Integer.MIN_VALUE;
    public static final int L1 = 6;
    public static final int M = 4;
    public static final int M0 = 0;
    public static final int M1 = 3;
    public static final int N = 8;
    public static final int N0 = 1;
    public static final int N1 = 6;
    public static final int O = 3;
    public static final int O0 = 2;
    public static final int O1 = 7;
    public static final int P = 5;
    public static final int P0 = 4;
    public static final int P1 = 2;
    public static final int Q = 2;
    public static final int Q0 = 0;
    public static final int Q1 = 1;
    public static final int R = 1;

    @Deprecated
    public static final int R0 = 0;
    public static final int R1 = 0;
    public static final int S = 0;
    public static final int S0 = 1;
    public static final int S1 = 1;
    public static final int T = 3;

    @Deprecated
    public static final int T0 = 1;
    public static final int T1 = 2;
    public static final int U = 3;
    public static final int U0 = 2;
    public static final int U1 = 3;

    @Deprecated
    public static final int V = 3;

    @Deprecated
    public static final int V0 = 2;
    public static final int V1 = 0;
    public static final int W = 2;
    public static final int W0 = 3;
    public static final int W1 = -1000;

    @Deprecated
    public static final int X = 2;

    @Deprecated
    public static final int X0 = 3;
    public static final int X1 = 0;
    public static final int Y = 4;
    public static final int Y0 = 4;
    public static final int Y1 = 1;

    @Deprecated
    public static final int Z = 4;

    @Deprecated
    public static final int Z0 = 4;
    public static final int Z1 = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f30477a = -3.4028235E38f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f1993a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f1994a = Long.MIN_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Deprecated
    public static final String f1995a = "US-ASCII";
    public static final int a0 = 1;
    public static final int a1 = -1;
    public static final int a2 = 3;
    public static final int b = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final long f1997b = -9223372036854775807L;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Deprecated
    public static final String f1998b = "UTF-8";

    @Deprecated
    public static final int b0 = 1;
    public static final int b1 = -2;
    public static final int b2 = 4;
    public static final int c = -2147483647;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final long f2000c = 1000;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Deprecated
    public static final String f2001c = "ISO-8859-1";
    public static final int c0 = 0;
    public static final int c1 = -3;
    public static final int c2 = 5;
    public static final int d = -1;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final long f2003d = 1000000;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Deprecated
    public static final String f2004d = "UTF-16";

    @Deprecated
    public static final int d0 = 0;
    public static final int d1 = -4;
    public static final int d2 = 9;
    public static final int e = -1;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final long f2006e = 1000000000;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @Deprecated
    public static final String f2007e = "UTF-16LE";
    public static final int e0 = 1;
    public static final int e1 = -5;
    public static final int e2 = 10;
    public static final int f = 8;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final long f2009f = 5000;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final String f2010f = "serif";
    public static final int f0 = 4;
    public static final int f1 = 0;
    public static final int f2 = 6;
    public static final int g = 4;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final long f2011g = 15000;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final String f2012g = "sans-serif";
    public static final int g0 = 11;
    public static final int g1 = 1;
    public static final int g2 = 7;
    public static final int h = 0;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final long f2013h = 3000;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final String f2014h = "ssai";
    public static final int h0 = 12;
    public static final int h1 = 2;
    public static final int h2 = 8;
    public static final int i = 1;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final String f2015i = "und";
    public static final int i0 = 13;
    public static final int i1 = 3;
    public static final int i2 = 0;
    public static final int j = 2;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final String f2016j = "cenc";
    public static final int j0 = 16;
    public static final int j1 = 4;
    public static final int j2 = 1;
    public static final int k = 10000;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public static final String f2017k = "cbc1";
    public static final int k0 = 14;
    public static final int k1 = 5;
    public static final int k2 = 2;
    public static final int l = 0;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public static final String f2018l = "cens";
    public static final int l0 = 1;
    public static final int l1 = 6;
    public static final int l2 = 1;
    public static final int m = 1;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public static final String f2019m = "cbcs";
    public static final int m0 = 5;
    public static final int m1 = 7;
    public static final int m2 = 2;
    public static final int n = 2;
    public static final int n0 = 9;
    public static final int n1 = 10000;
    public static final int n2 = 4;
    public static final int o = 0;
    public static final int o0 = 8;
    public static final int o1 = -2;
    public static final int o2 = 8;
    public static final int p = 0;
    public static final int p0 = 7;
    public static final int p1 = -1;
    public static final int p2 = 16;
    public static final int q = 3;
    public static final int q0 = 10;
    public static final int q1 = 0;
    public static final int q2 = 32;
    public static final int r = 2;
    public static final int r0 = 6;
    public static final int r1 = 1;
    public static final int r2 = 64;
    public static final int s = 268435456;
    public static final int s0 = 0;
    public static final int s1 = 2;
    public static final int s2 = 128;
    public static final int t = 536870912;
    public static final int t0 = 2;
    public static final int t1 = 3;
    public static final int t2 = 256;
    public static final int u = 805306368;
    public static final int u0 = 3;
    public static final int u1 = 4;
    public static final int u2 = 512;
    public static final int v = 4;
    public static final int v0 = 1;
    public static final int v1 = 5;
    public static final int v2 = 1024;
    public static final int w = 9;
    public static final int w0 = 3;
    public static final int w1 = 6;
    public static final int w2 = 2048;
    public static final int x = 10;
    public static final int x0 = 2;
    public static final int x1 = 10000;
    public static final int x2 = 4096;
    public static final int y = 11;
    public static final int y0 = 1;
    public static final int y1 = 0;
    public static final int y2 = 8192;
    public static final int z = 12;
    public static final int z0 = 4;
    public static final int z1 = 1;
    public static final int z2 = 16384;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final UUID f1996a = new UUID(0, 0);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final UUID f1999b = new UUID(1186680826959645954L, -5988876978535335093L);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final UUID f2002c = new UUID(-2129748144642739255L, 8654423357094679310L);

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final UUID f2005d = new UUID(-1301668207276963122L, -6645017420763422227L);

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final UUID f2008e = new UUID(-7348484286925749626L, -6083546864340672619L);

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioAllowedCapturePolicy {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioContentType {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioFlags {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioUsage {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface BufferFlags {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorRange {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorSpace {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorTransfer {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ContentType {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CryptoMode {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CryptoType {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DataType {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Encoding {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FormatSupport {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface NetworkType {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PcmEncoding {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Projection {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RoleFlags {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectionFlags {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectionReason {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SpatializationBehavior {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StereoMode {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @SuppressLint({"UniqueConstants"})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TrackType {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoChangeFrameRateStrategy {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoOutputMode {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @SuppressLint({"UniqueConstants"})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoScalingMode {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface WakeMode {
    }

    @InlineMe(imports = {"com.google.android.exoplayer2.util.Util"}, replacement = "Util.generateAudioSessionIdV21(context)")
    @RequiresApi(21)
    @Deprecated
    public static int a(Context context) {
        return gj9.K(context);
    }

    @InlineMe(imports = {"com.google.android.exoplayer2.util.Util"}, replacement = "Util.getErrorCodeForMediaDrmErrorCode(mediaDrmErrorCode)")
    @Deprecated
    public static int b(int i3) {
        return gj9.f0(i3);
    }

    @InlineMe(imports = {"com.google.android.exoplayer2.util.Util"}, replacement = "Util.getFormatSupportString(formatSupport)")
    @Deprecated
    public static String c(int i3) {
        return gj9.h0(i3);
    }

    @InlineMe(imports = {"com.google.android.exoplayer2.util.Util"}, replacement = "Util.msToUs(timeMs)")
    @Deprecated
    public static long d(long j3) {
        return gj9.Z0(j3);
    }

    @InlineMe(imports = {"com.google.android.exoplayer2.util.Util"}, replacement = "Util.usToMs(timeUs)")
    @Deprecated
    public static long e(long j3) {
        return gj9.H1(j3);
    }
}
