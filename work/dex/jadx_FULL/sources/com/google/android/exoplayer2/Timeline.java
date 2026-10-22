package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.InlineMe;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.z41;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class Timeline implements Bundleable {
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Timeline f2189a = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<Timeline> f30507a = new Bundleable.Creator() { // from class: com.zj.adlib.z79
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return Timeline.b(bundle);
        }
    };

    public class a extends Timeline {
        @Override // com.google.android.exoplayer2.Timeline
        public int f(Object obj) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public b k(int i, b bVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int m() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object s(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public d u(int i, d dVar, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int v() {
            return 0;
        }
    }

    public static final class b implements Bundleable {
        public static final int L = 0;
        public static final int M = 1;
        public static final int N = 2;
        public static final int O = 3;
        public static final int P = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Bundleable.Creator<b> f30508a = new Bundleable.Creator() { // from class: com.zj.adlib.b89
            @Override // com.google.android.exoplayer2.Bundleable.Creator
            public final Bundleable a(Bundle bundle) {
                return Timeline.b.c(bundle);
            }
        };
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f2190a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public AdPlaybackState f2191a = AdPlaybackState.f3764a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Object f2192a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f2193a;
        public long b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public Object f2194b;

        public static b c(Bundle bundle) {
            int i = bundle.getInt(w(0), 0);
            long j = bundle.getLong(w(1), -9223372036854775807L);
            long j2 = bundle.getLong(w(2), 0L);
            boolean z = bundle.getBoolean(w(3));
            Bundle bundle2 = bundle.getBundle(w(4));
            AdPlaybackState adPlaybackState = bundle2 != null ? (AdPlaybackState) AdPlaybackState.f30839a.a(bundle2) : AdPlaybackState.f3764a;
            b bVar = new b();
            bVar.y(null, null, i, j, j2, adPlaybackState, z);
            return bVar;
        }

        public static String w(int i) {
            return Integer.toString(i, 36);
        }

        public int d(int i) {
            return this.f2191a.e(i).K;
        }

        public long e(int i, int i2) {
            AdPlaybackState.b bVarE = this.f2191a.e(i);
            if (bVarE.K != -1) {
                return bVarE.f3771a[i2];
            }
            return -9223372036854775807L;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return gj9.c(this.f2192a, bVar.f2192a) && gj9.c(this.f2194b, bVar.f2194b) && this.K == bVar.K && this.f2190a == bVar.f2190a && this.b == bVar.b && this.f2193a == bVar.f2193a && gj9.c(this.f2191a, bVar.f2191a);
        }

        public int f() {
            return this.f2191a.K;
        }

        public int g(long j) {
            return this.f2191a.f(j, this.f2190a);
        }

        public int h(long j) {
            return this.f2191a.g(j, this.f2190a);
        }

        public int hashCode() {
            Object obj = this.f2192a;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f2194b;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.K) * 31;
            long j = this.f2190a;
            int i = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.b;
            return ((((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.f2193a ? 1 : 0)) * 31) + this.f2191a.hashCode();
        }

        public long i(int i) {
            return this.f2191a.e(i).f3768a;
        }

        public long j() {
            return this.f2191a.f3765a;
        }

        public int k(int i, int i2) {
            AdPlaybackState.b bVarE = this.f2191a.e(i);
            if (bVarE.K != -1) {
                return bVarE.f3770a[i2];
            }
            return 0;
        }

        @Nullable
        public Object l() {
            return this.f2191a.f3766a;
        }

        public long m(int i) {
            return this.f2191a.e(i).b;
        }

        public long n() {
            return gj9.H1(this.f2190a);
        }

        public long o() {
            return this.f2190a;
        }

        public int p(int i) {
            return this.f2191a.e(i).e();
        }

        public int q(int i, int i2) {
            return this.f2191a.e(i).f(i2);
        }

        public long r() {
            return gj9.H1(this.b);
        }

        public long s() {
            return this.b;
        }

        public int t() {
            return this.f2191a.L;
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(w(0), this.K);
            bundle.putLong(w(1), this.f2190a);
            bundle.putLong(w(2), this.b);
            bundle.putBoolean(w(3), this.f2193a);
            bundle.putBundle(w(4), this.f2191a.toBundle());
            return bundle;
        }

        public boolean u(int i) {
            return !this.f2191a.e(i).g();
        }

        public boolean v(int i) {
            return this.f2191a.e(i).f3769a;
        }

        public b x(@Nullable Object obj, @Nullable Object obj2, int i, long j, long j2) {
            return y(obj, obj2, i, j, j2, AdPlaybackState.f3764a, false);
        }

        public b y(@Nullable Object obj, @Nullable Object obj2, int i, long j, long j2, AdPlaybackState adPlaybackState, boolean z) {
            this.f2192a = obj;
            this.f2194b = obj2;
            this.K = i;
            this.f2190a = j;
            this.b = j2;
            this.f2191a = adPlaybackState;
            this.f2193a = z;
            return this;
        }
    }

    public static final class c extends Timeline {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableList<d> f30509a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f2195a;
        public final ImmutableList<b> b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final int[] f2196b;

        public c(ImmutableList<d> immutableList, ImmutableList<b> immutableList2, int[] iArr) {
            sb0.a(immutableList.size() == iArr.length);
            this.f30509a = immutableList;
            this.b = immutableList2;
            this.f2195a = iArr;
            this.f2196b = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.f2196b[iArr[i]] = i;
            }
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int e(boolean z) {
            if (w()) {
                return -1;
            }
            if (z) {
                return this.f2195a[0];
            }
            return 0;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int f(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int g(boolean z) {
            if (w()) {
                return -1;
            }
            return z ? this.f2195a[v() - 1] : v() - 1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int i(int i, int i2, boolean z) {
            if (i2 == 1) {
                return i;
            }
            if (i != g(z)) {
                return z ? this.f2195a[this.f2196b[i] + 1] : i + 1;
            }
            if (i2 == 2) {
                return e(z);
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public b k(int i, b bVar, boolean z) {
            b bVar2 = this.b.get(i);
            bVar.y(bVar2.f2192a, bVar2.f2194b, bVar2.K, bVar2.f2190a, bVar2.b, bVar2.f2191a, bVar2.f2193a);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int m() {
            return this.b.size();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int r(int i, int i2, boolean z) {
            if (i2 == 1) {
                return i;
            }
            if (i != e(z)) {
                return z ? this.f2195a[this.f2196b[i] - 1] : i - 1;
            }
            if (i2 == 2) {
                return g(z);
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object s(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public d u(int i, d dVar, long j) {
            d dVar2 = this.f30509a.get(i);
            dVar.m(dVar2.f2200a, dVar2.f2199a, dVar2.f2205c, dVar2.f2197a, dVar2.f2202b, dVar2.c, dVar2.f2201a, dVar2.f2204b, dVar2.f2198a, dVar2.f2207d, dVar2.f2209e, dVar2.K, dVar2.L, dVar2.f);
            dVar.f2208d = dVar2.f2208d;
            return dVar;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int v() {
            return this.f30509a.size();
        }
    }

    public static final class d implements Bundleable {
        public static final int M = 1;
        public static final int N = 2;
        public static final int O = 3;
        public static final int P = 4;
        public static final int Q = 5;
        public static final int R = 6;
        public static final int S = 7;
        public static final int T = 8;
        public static final int U = 9;
        public static final int V = 10;
        public static final int W = 11;
        public static final int X = 12;
        public static final int Y = 13;
        public int K;
        public int L;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f2197a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public g.C0682g f2198a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f2201a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f2202b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        @Deprecated
        public Object f2203b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f2204b;
        public long c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        @Nullable
        public Object f2205c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        @Deprecated
        public boolean f2206c;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public long f2207d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public boolean f2208d;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public long f2209e;
        public long f;
        public static final Object d = new Object();
        public static final Object e = new Object();
        public static final g b = new g.c().D("com.google.android.exoplayer2.Timeline").L(Uri.EMPTY).a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Bundleable.Creator<d> f30510a = new Bundleable.Creator() { // from class: com.zj.adlib.d89
            @Override // com.google.android.exoplayer2.Bundleable.Creator
            public final Bundleable a(Bundle bundle) {
                return Timeline.d.c(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f2200a = d;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public g f2199a = b;

        public static d c(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(l(1));
            g gVar = bundle2 != null ? (g) g.f30740a.a(bundle2) : null;
            long j = bundle.getLong(l(2), -9223372036854775807L);
            long j2 = bundle.getLong(l(3), -9223372036854775807L);
            long j3 = bundle.getLong(l(4), -9223372036854775807L);
            boolean z = bundle.getBoolean(l(5), false);
            boolean z2 = bundle.getBoolean(l(6), false);
            Bundle bundle3 = bundle.getBundle(l(7));
            g.C0682g c0682g = bundle3 != null ? (g.C0682g) g.C0682g.f30749a.a(bundle3) : null;
            boolean z3 = bundle.getBoolean(l(8), false);
            long j4 = bundle.getLong(l(9), 0L);
            long j5 = bundle.getLong(l(10), -9223372036854775807L);
            int i = bundle.getInt(l(11), 0);
            int i2 = bundle.getInt(l(12), 0);
            long j6 = bundle.getLong(l(13), 0L);
            d dVar = new d();
            dVar.m(e, gVar, null, j, j2, j3, z, z2, c0682g, j4, j5, i, i2, j6);
            dVar.f2208d = z3;
            return dVar;
        }

        public static String l(int i) {
            return Integer.toString(i, 36);
        }

        public long d() {
            return gj9.m0(this.c);
        }

        public long e() {
            return gj9.H1(this.f2207d);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !d.class.equals(obj.getClass())) {
                return false;
            }
            d dVar = (d) obj;
            return gj9.c(this.f2200a, dVar.f2200a) && gj9.c(this.f2199a, dVar.f2199a) && gj9.c(this.f2205c, dVar.f2205c) && gj9.c(this.f2198a, dVar.f2198a) && this.f2197a == dVar.f2197a && this.f2202b == dVar.f2202b && this.c == dVar.c && this.f2201a == dVar.f2201a && this.f2204b == dVar.f2204b && this.f2208d == dVar.f2208d && this.f2207d == dVar.f2207d && this.f2209e == dVar.f2209e && this.K == dVar.K && this.L == dVar.L && this.f == dVar.f;
        }

        public long f() {
            return this.f2207d;
        }

        public long g() {
            return gj9.H1(this.f2209e);
        }

        public long h() {
            return this.f2209e;
        }

        public int hashCode() {
            int iHashCode = (((217 + this.f2200a.hashCode()) * 31) + this.f2199a.hashCode()) * 31;
            Object obj = this.f2205c;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            g.C0682g c0682g = this.f2198a;
            int iHashCode3 = (iHashCode2 + (c0682g != null ? c0682g.hashCode() : 0)) * 31;
            long j = this.f2197a;
            int i = (iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.f2202b;
            int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.c;
            int i3 = (((((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f2201a ? 1 : 0)) * 31) + (this.f2204b ? 1 : 0)) * 31) + (this.f2208d ? 1 : 0)) * 31;
            long j4 = this.f2207d;
            int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.f2209e;
            int i5 = (((((i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.K) * 31) + this.L) * 31;
            long j6 = this.f;
            return i5 + ((int) (j6 ^ (j6 >>> 32)));
        }

        public long i() {
            return gj9.H1(this.f);
        }

        public long j() {
            return this.f;
        }

        public boolean k() {
            sb0.i(this.f2206c == (this.f2198a != null));
            return this.f2198a != null;
        }

        public d m(Object obj, @Nullable g gVar, @Nullable Object obj2, long j, long j2, long j3, boolean z, boolean z2, @Nullable g.C0682g c0682g, long j4, long j5, int i, int i2, long j6) {
            g.h hVar;
            this.f2200a = obj;
            this.f2199a = gVar != null ? gVar : b;
            this.f2203b = (gVar == null || (hVar = gVar.f3327a) == null) ? null : hVar.f3370a;
            this.f2205c = obj2;
            this.f2197a = j;
            this.f2202b = j2;
            this.c = j3;
            this.f2201a = z;
            this.f2204b = z2;
            this.f2206c = c0682g != null;
            this.f2198a = c0682g;
            this.f2207d = j4;
            this.f2209e = j5;
            this.K = i;
            this.L = i2;
            this.f = j6;
            this.f2208d = false;
            return this;
        }

        public final Bundle n(boolean z) {
            Bundle bundle = new Bundle();
            bundle.putBundle(l(1), (z ? g.f3322a : this.f2199a).toBundle());
            bundle.putLong(l(2), this.f2197a);
            bundle.putLong(l(3), this.f2202b);
            bundle.putLong(l(4), this.c);
            bundle.putBoolean(l(5), this.f2201a);
            bundle.putBoolean(l(6), this.f2204b);
            g.C0682g c0682g = this.f2198a;
            if (c0682g != null) {
                bundle.putBundle(l(7), c0682g.toBundle());
            }
            bundle.putBoolean(l(8), this.f2208d);
            bundle.putLong(l(9), this.f2207d);
            bundle.putLong(l(10), this.f2209e);
            bundle.putInt(l(11), this.K);
            bundle.putInt(l(12), this.L);
            bundle.putLong(l(13), this.f);
            return bundle;
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            return n(false);
        }
    }

    public static Timeline b(Bundle bundle) {
        ImmutableList immutableListC = c(d.f30510a, z41.a(bundle, y(0)));
        ImmutableList immutableListC2 = c(b.f30508a, z41.a(bundle, y(1)));
        int[] intArray = bundle.getIntArray(y(2));
        if (intArray == null) {
            intArray = d(immutableListC.size());
        }
        return new c(immutableListC, immutableListC2, intArray);
    }

    public static <T extends Bundleable> ImmutableList<T> c(Bundleable.Creator<T> creator, @Nullable IBinder iBinder) {
        if (iBinder == null) {
            return ImmutableList.of();
        }
        ImmutableList.a aVar = new ImmutableList.a();
        ImmutableList<Bundle> list = BundleListRetriever.getList(iBinder);
        for (int i = 0; i < list.size(); i++) {
            aVar.a(creator.a(list.get(i)));
        }
        return aVar.e();
    }

    public static int[] d(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = i2;
        }
        return iArr;
    }

    public static String y(int i) {
        return Integer.toString(i, 36);
    }

    public int e(boolean z) {
        return w() ? -1 : 0;
    }

    public boolean equals(@Nullable Object obj) {
        int iG;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.v() != v() || timeline.m() != m()) {
            return false;
        }
        d dVar = new d();
        b bVar = new b();
        d dVar2 = new d();
        b bVar2 = new b();
        for (int i = 0; i < v(); i++) {
            if (!t(i, dVar).equals(timeline.t(i, dVar2))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < m(); i2++) {
            if (!k(i2, bVar, true).equals(timeline.k(i2, bVar2, true))) {
                return false;
            }
        }
        int iE = e(true);
        if (iE != timeline.e(true) || (iG = g(true)) != timeline.g(true)) {
            return false;
        }
        while (iE != iG) {
            int i3 = i(iE, 0, true);
            if (i3 != timeline.i(iE, 0, true)) {
                return false;
            }
            iE = i3;
        }
        return true;
    }

    public abstract int f(Object obj);

    public int g(boolean z) {
        if (w()) {
            return -1;
        }
        return v() - 1;
    }

    public final int h(int i, b bVar, d dVar, int i2, boolean z) {
        int i3 = j(i, bVar).K;
        if (t(i3, dVar).L != i) {
            return i + 1;
        }
        int i4 = i(i3, i2, z);
        if (i4 == -1) {
            return -1;
        }
        return t(i4, dVar).K;
    }

    public int hashCode() {
        d dVar = new d();
        b bVar = new b();
        int iV = 217 + v();
        for (int i = 0; i < v(); i++) {
            iV = (iV * 31) + t(i, dVar).hashCode();
        }
        int iM = (iV * 31) + m();
        for (int i2 = 0; i2 < m(); i2++) {
            iM = (iM * 31) + k(i2, bVar, true).hashCode();
        }
        int iE = e(true);
        while (iE != -1) {
            iM = (iM * 31) + iE;
            iE = i(iE, 0, true);
        }
        return iM;
    }

    public int i(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == g(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == g(z) ? e(z) : i + 1;
        }
        throw new IllegalStateException();
    }

    public final b j(int i, b bVar) {
        return k(i, bVar, false);
    }

    public abstract b k(int i, b bVar, boolean z);

    public b l(Object obj, b bVar) {
        return k(f(obj), bVar, true);
    }

    public abstract int m();

    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs)")
    @Deprecated
    public final Pair<Object, Long> n(d dVar, b bVar, int i, long j) {
        return p(dVar, bVar, i, j);
    }

    @Nullable
    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs, defaultPositionProjectionUs)")
    @Deprecated
    public final Pair<Object, Long> o(d dVar, b bVar, int i, long j, long j2) {
        return q(dVar, bVar, i, j, j2);
    }

    public final Pair<Object, Long> p(d dVar, b bVar, int i, long j) {
        return (Pair) sb0.g(q(dVar, bVar, i, j, 0L));
    }

    @Nullable
    public final Pair<Object, Long> q(d dVar, b bVar, int i, long j, long j2) {
        sb0.c(i, 0, v());
        u(i, dVar, j2);
        if (j == -9223372036854775807L) {
            j = dVar.f();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = dVar.K;
        j(i2, bVar);
        while (i2 < dVar.L && bVar.b != j) {
            int i3 = i2 + 1;
            if (j(i3, bVar).b > j) {
                break;
            }
            i2 = i3;
        }
        k(i2, bVar, true);
        long jMin = j - bVar.b;
        long j3 = bVar.f2190a;
        if (j3 != -9223372036854775807L) {
            jMin = Math.min(jMin, j3 - 1);
        }
        return Pair.create(sb0.g(bVar.f2194b), Long.valueOf(Math.max(0L, jMin)));
    }

    public int r(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == e(z)) {
                return -1;
            }
            return i - 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == e(z) ? g(z) : i - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object s(int i);

    public final d t(int i, d dVar) {
        return u(i, dVar, 0L);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public final Bundle toBundle() {
        return z(false);
    }

    public abstract d u(int i, d dVar, long j);

    public abstract int v();

    public final boolean w() {
        return v() == 0;
    }

    public final boolean x(int i, b bVar, d dVar, int i2, boolean z) {
        return h(i, bVar, dVar, i2, z) == -1;
    }

    public final Bundle z(boolean z) {
        ArrayList arrayList = new ArrayList();
        int iV = v();
        d dVar = new d();
        for (int i = 0; i < iV; i++) {
            arrayList.add(u(i, dVar, 0L).n(z));
        }
        ArrayList arrayList2 = new ArrayList();
        int iM = m();
        b bVar = new b();
        for (int i2 = 0; i2 < iM; i2++) {
            arrayList2.add(k(i2, bVar, false).toBundle());
        }
        int[] iArr = new int[iV];
        if (iV > 0) {
            iArr[0] = e(true);
        }
        for (int i3 = 1; i3 < iV; i3++) {
            iArr[i3] = i(iArr[i3 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        z41.c(bundle, y(0), new BundleListRetriever(arrayList));
        z41.c(bundle, y(1), new BundleListRetriever(arrayList2));
        bundle.putIntArray(y(2), iArr);
        return bundle;
    }
}
