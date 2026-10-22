package com.google.android.exoplayer2.analytics;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.Cue;
import com.google.common.base.g;
import com.zj.adlib.az4;
import com.zj.adlib.hp9;
import com.zj.adlib.oh5;
import com.zj.adlib.p82;
import com.zj.adlib.sb0;
import com.zj.adlib.xy1;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface AnalyticsListener {
    public static final int A = 26;
    public static final int B = 28;
    public static final int C = 27;
    public static final int D = 29;
    public static final int E = 30;
    public static final int F = 1000;
    public static final int G = 1001;
    public static final int H = 1002;
    public static final int I = 1003;
    public static final int J = 1004;
    public static final int K = 1005;
    public static final int L = 1006;
    public static final int M = 1007;
    public static final int N = 1008;
    public static final int O = 1009;
    public static final int P = 1010;
    public static final int Q = 1011;
    public static final int R = 1012;
    public static final int S = 1013;
    public static final int T = 1014;
    public static final int U = 1015;
    public static final int V = 1016;
    public static final int W = 1017;
    public static final int X = 1018;
    public static final int Y = 1019;
    public static final int Z = 1020;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30513a = 0;
    public static final int a0 = 1021;
    public static final int b = 1;
    public static final int b0 = 1022;
    public static final int c = 2;
    public static final int c0 = 1023;
    public static final int d = 3;
    public static final int d0 = 1024;
    public static final int e = 4;
    public static final int e0 = 1025;
    public static final int f = 5;
    public static final int f0 = 1026;
    public static final int g = 6;
    public static final int g0 = 1027;
    public static final int h = 7;
    public static final int h0 = 1028;
    public static final int i = 8;
    public static final int i0 = 1029;
    public static final int j = 9;
    public static final int j0 = 1030;
    public static final int k = 10;
    public static final int l = 11;
    public static final int m = 12;
    public static final int n = 13;
    public static final int o = 14;
    public static final int p = 15;
    public static final int q = 16;
    public static final int r = 17;
    public static final int s = 18;
    public static final int t = 19;
    public static final int u = 20;
    public static final int v = 21;
    public static final int w = 22;
    public static final int x = 23;
    public static final int y = 24;
    public static final int z = 25;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface EventFlags {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30514a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f2224a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Timeline f2225a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final MediaSource.a f2226a;
        public final int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final long f2227b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final Timeline f2228b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public final MediaSource.a f2229b;
        public final long c;
        public final long d;

        public a(long j, Timeline timeline, int i, @Nullable MediaSource.a aVar, long j2, Timeline timeline2, int i2, @Nullable MediaSource.a aVar2, long j3, long j4) {
            this.f2224a = j;
            this.f2225a = timeline;
            this.f30514a = i;
            this.f2226a = aVar;
            this.f2227b = j2;
            this.f2228b = timeline2;
            this.b = i2;
            this.f2229b = aVar2;
            this.c = j3;
            this.d = j4;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2224a == aVar.f2224a && this.f30514a == aVar.f30514a && this.f2227b == aVar.f2227b && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && g.a(this.f2225a, aVar.f2225a) && g.a(this.f2226a, aVar.f2226a) && g.a(this.f2228b, aVar.f2228b) && g.a(this.f2229b, aVar.f2229b);
        }

        public int hashCode() {
            return g.b(Long.valueOf(this.f2224a), this.f2225a, Integer.valueOf(this.f30514a), this.f2226a, Long.valueOf(this.f2227b), this.f2228b, Integer.valueOf(this.b), this.f2229b, Long.valueOf(this.c), Long.valueOf(this.d));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<a> f30515a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final com.google.android.exoplayer2.util.a f2230a;

        public b(com.google.android.exoplayer2.util.a aVar, SparseArray<a> sparseArray) {
            this.f2230a = aVar;
            SparseArray<a> sparseArray2 = new SparseArray<>(aVar.d());
            for (int i = 0; i < aVar.d(); i++) {
                int iC = aVar.c(i);
                sparseArray2.append(iC, (a) sb0.g(sparseArray.get(iC)));
            }
            this.f30515a = sparseArray2;
        }

        public boolean a(int i) {
            return this.f2230a.a(i);
        }

        public boolean b(int... iArr) {
            return this.f2230a.b(iArr);
        }

        public int c(int i) {
            return this.f2230a.c(i);
        }

        public a d(int i) {
            return (a) sb0.g(this.f30515a.get(i));
        }

        public int e() {
            return this.f2230a.d();
        }
    }

    default void A(a aVar, PlaybackException playbackException) {
    }

    default void A0(a aVar, int i2) {
    }

    @Deprecated
    default void B0(a aVar, int i2, p82 p82Var) {
    }

    @Deprecated
    default void C(a aVar) {
    }

    default void C0(a aVar) {
    }

    @Deprecated
    default void D(a aVar, boolean z2) {
    }

    default void D0(a aVar, int i2) {
    }

    default void E(a aVar, az4 az4Var, oh5 oh5Var) {
    }

    @Deprecated
    default void E0(a aVar, com.google.android.exoplayer2.d dVar) {
    }

    default void F(a aVar, oh5 oh5Var) {
    }

    default void F0(a aVar, Exception exc) {
    }

    @Deprecated
    default void G(a aVar) {
    }

    @Deprecated
    default void H(a aVar, com.google.android.exoplayer2.d dVar) {
    }

    default void I(a aVar, int i2) {
    }

    default void J(a aVar, @Nullable PlaybackException playbackException) {
    }

    default void K(a aVar, int i2) {
    }

    default void L(a aVar, Exception exc) {
    }

    default void M(a aVar, oh5 oh5Var) {
    }

    @Deprecated
    default void N(a aVar, int i2, int i3, int i4, float f2) {
    }

    @Deprecated
    default void O(a aVar, boolean z2, int i2) {
    }

    default void P(a aVar, j jVar) {
    }

    default void Q(a aVar) {
    }

    default void R(a aVar, int i2) {
    }

    @Deprecated
    default void S(a aVar, String str, long j2) {
    }

    default void T(a aVar, az4 az4Var, oh5 oh5Var) {
    }

    default void U(a aVar, p82 p82Var) {
    }

    default void V(a aVar, p pVar) {
    }

    default void W(a aVar, int i2, long j2) {
    }

    @Deprecated
    default void X(a aVar, int i2) {
    }

    default void Y(a aVar, long j2, int i2) {
    }

    default void Z(a aVar) {
    }

    default void a(a aVar, com.google.android.exoplayer2.d dVar, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    default void a0(a aVar, com.google.android.exoplayer2.audio.a aVar2) {
    }

    default void b0(a aVar, hp9 hp9Var) {
    }

    default void c(a aVar, DeviceInfo deviceInfo) {
    }

    @Deprecated
    default void c0(a aVar, int i2, com.google.android.exoplayer2.d dVar) {
    }

    default void d(a aVar, @Nullable com.google.android.exoplayer2.g gVar, int i2) {
    }

    default void d0(a aVar, int i2, int i3) {
    }

    default void e(a aVar, long j2) {
    }

    default void e0(a aVar, boolean z2) {
    }

    default void f(a aVar, int i2, boolean z2) {
    }

    @Deprecated
    default void f0(a aVar) {
    }

    default void g(a aVar, String str, long j2, long j3) {
    }

    default void g0(a aVar, Object obj, long j2) {
    }

    default void h(a aVar, az4 az4Var, oh5 oh5Var, IOException iOException, boolean z2) {
    }

    default void h0(a aVar, boolean z2) {
    }

    @Deprecated
    default void i(a aVar, int i2, p82 p82Var) {
    }

    default void i0(a aVar, long j2) {
    }

    default void j(a aVar, MediaMetadata mediaMetadata) {
    }

    default void j0(a aVar, p82 p82Var) {
    }

    default void k(a aVar, com.google.android.exoplayer2.trackselection.c cVar) {
    }

    default void l(a aVar, int i2, long j2, long j3) {
    }

    default void l0(a aVar, xy1 xy1Var) {
    }

    default void m(a aVar, Metadata metadata) {
    }

    default void m0(a aVar, Exception exc) {
    }

    default void n(a aVar, boolean z2, int i2) {
    }

    default void n0(a aVar, String str) {
    }

    default void o(a aVar, p82 p82Var) {
    }

    default void o0(a aVar, String str) {
    }

    default void p(a aVar, long j2) {
    }

    default void p0(a aVar, p82 p82Var) {
    }

    default void q(a aVar, Exception exc) {
    }

    default void q0(a aVar, String str, long j2, long j3) {
    }

    @Deprecated
    default void r(a aVar, int i2, String str, long j2) {
    }

    default void r0(a aVar, boolean z2) {
    }

    default void s(a aVar, boolean z2) {
    }

    default void s0(a aVar, az4 az4Var, oh5 oh5Var) {
    }

    default void t(a aVar, int i2, long j2, long j3) {
    }

    default void t0(a aVar, long j2) {
    }

    default void u(a aVar) {
    }

    default void u0(a aVar, MediaMetadata mediaMetadata) {
    }

    default void v(a aVar, Player.b bVar) {
    }

    default void v0(Player player, b bVar) {
    }

    default void w(a aVar, float f2) {
    }

    @Deprecated
    default void x(a aVar, String str, long j2) {
    }

    default void x0(a aVar) {
    }

    default void y(a aVar, com.google.android.exoplayer2.d dVar, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    default void y0(a aVar, Player.d dVar, Player.d dVar2, int i2) {
    }

    @Deprecated
    default void z(a aVar, List<Cue> list) {
    }

    default void z0(a aVar, int i2) {
    }
}
