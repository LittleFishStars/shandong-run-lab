package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.util.Log;
import com.google.common.base.Predicate;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.zj.adlib.a51;
import com.zj.adlib.c49;
import com.zj.adlib.da9;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.ls1;
import com.zj.adlib.sa9;
import com.zj.adlib.sb0;
import com.zj.adlib.ue7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DefaultTrackSelector extends MappingTrackSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f31027a = 0.98f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f4650a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f4652a = "DefaultTrackSelector";
    public static final int b = 1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f4654b = "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.";
    public static final int c = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Context f4655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public com.google.android.exoplayer2.audio.a f4656a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public d f4657a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @GuardedBy("lock")
    public g f4658a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExoTrackSelection.Factory f4659a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f4660a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Ordering<Integer> f4651a = Ordering.from(new Comparator() { // from class: com.zj.adlib.hj2
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return DefaultTrackSelector.M((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Ordering<Integer> f4653b = Ordering.from(new Comparator() { // from class: com.zj.adlib.jj2
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return DefaultTrackSelector.N((Integer) obj, (Integer) obj2);
        }
    });

    public static abstract class TrackInfo<T extends TrackInfo<T>> {
        public final int K;
        public final int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.d f31028a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final da9 f4662a;

        public interface Factory<T extends TrackInfo<T>> {
            List<T> a(int i, da9 da9Var, int[] iArr);
        }

        public TrackInfo(int i, da9 da9Var, int i2) {
            this.K = i;
            this.f4662a = da9Var;
            this.L = i2;
            this.f31028a = da9Var.c(i2);
        }

        public abstract int a();

        public abstract boolean b(T t);
    }

    public static final class b extends TrackInfo<b> implements Comparable<b> {
        public final int M;
        public final int N;
        public final int O;
        public final int P;
        public final int Q;
        public final int R;
        public final int S;
        public final int T;
        public final int U;
        public final int V;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f31029a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f4663a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;

        @Nullable
        public final String f;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        public final boolean f4664f;

        public b(int i, da9 da9Var, int i2, d dVar, int i3, boolean z, Predicate<com.google.android.exoplayer2.d> predicate) {
            int i4;
            int formatLanguageScore;
            int formatLanguageScore2;
            super(i, da9Var, i2);
            this.f31029a = dVar;
            this.f = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(((TrackInfo) this).f31028a.h);
            this.b = DefaultTrackSelector.isSupported(i3, false);
            int i5 = 0;
            while (true) {
                i4 = Integer.MAX_VALUE;
                if (i5 >= ((com.google.android.exoplayer2.trackselection.c) dVar).f4702b.size()) {
                    formatLanguageScore = 0;
                    i5 = Integer.MAX_VALUE;
                    break;
                } else {
                    formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(((TrackInfo) this).f31028a, ((com.google.android.exoplayer2.trackselection.c) dVar).f4702b.get(i5), false);
                    if (formatLanguageScore > 0) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            this.O = i5;
            this.N = formatLanguageScore;
            this.P = DefaultTrackSelector.F(((TrackInfo) this).f31028a.L, dVar.V);
            com.google.android.exoplayer2.d dVar2 = ((TrackInfo) this).f31028a;
            int i6 = dVar2.L;
            this.c = i6 == 0 || (i6 & 1) != 0;
            this.d = (dVar2.K & 1) != 0;
            int i7 = dVar2.U;
            this.S = i7;
            this.T = dVar2.V;
            int i8 = dVar2.O;
            this.U = i8;
            this.f4663a = (i8 == -1 || i8 <= dVar.X) && (i7 == -1 || i7 <= dVar.W) && predicate.apply(dVar2);
            String[] strArrT0 = gj9.t0();
            int i9 = 0;
            while (true) {
                if (i9 >= strArrT0.length) {
                    formatLanguageScore2 = 0;
                    i9 = Integer.MAX_VALUE;
                    break;
                } else {
                    formatLanguageScore2 = DefaultTrackSelector.getFormatLanguageScore(((TrackInfo) this).f31028a, strArrT0[i9], false);
                    if (formatLanguageScore2 > 0) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            this.Q = i9;
            this.R = formatLanguageScore2;
            for (int i10 = 0; i10 < ((com.google.android.exoplayer2.trackselection.c) dVar).c.size(); i10++) {
                String str = ((TrackInfo) this).f31028a.k;
                if (str != null && str.equals(((com.google.android.exoplayer2.trackselection.c) dVar).c.get(i10))) {
                    i4 = i10;
                    break;
                }
            }
            this.V = i4;
            this.e = RendererCapabilities.getDecoderSupport(i3) == 128;
            this.f4664f = RendererCapabilities.getHardwareAccelerationSupport(i3) == 64;
            this.M = f(i3, z);
        }

        public static int c(List<b> list, List<b> list2) {
            return ((b) Collections.max(list)).compareTo((b) Collections.max(list2));
        }

        public static ImmutableList<b> e(int i, da9 da9Var, d dVar, int[] iArr, boolean z, Predicate<com.google.android.exoplayer2.d> predicate) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i2 = 0; i2 < da9Var.K; i2++) {
                aVarBuilder.a(new b(i, da9Var, i2, dVar, iArr[i2], z, predicate));
            }
            return aVarBuilder.e();
        }

        @Override // com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TrackInfo
        public int a() {
            return this.M;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            Ordering orderingReverse = (this.f4663a && this.b) ? DefaultTrackSelector.f4651a : DefaultTrackSelector.f4651a.reverse();
            ComparisonChain comparisonChainJ = ComparisonChain.n().k(this.b, bVar.b).j(Integer.valueOf(this.O), Integer.valueOf(bVar.O), Ordering.natural().reverse()).f(this.N, bVar.N).f(this.P, bVar.P).k(this.d, bVar.d).k(this.c, bVar.c).j(Integer.valueOf(this.Q), Integer.valueOf(bVar.Q), Ordering.natural().reverse()).f(this.R, bVar.R).k(this.f4663a, bVar.f4663a).j(Integer.valueOf(this.V), Integer.valueOf(bVar.V), Ordering.natural().reverse()).j(Integer.valueOf(this.U), Integer.valueOf(bVar.U), ((com.google.android.exoplayer2.trackselection.c) this.f31029a).f4704c ? DefaultTrackSelector.f4651a.reverse() : DefaultTrackSelector.f4653b).k(this.e, bVar.e).k(this.f4664f, bVar.f4664f).j(Integer.valueOf(this.S), Integer.valueOf(bVar.S), orderingReverse).j(Integer.valueOf(this.T), Integer.valueOf(bVar.T), orderingReverse);
            Integer numValueOf = Integer.valueOf(this.U);
            Integer numValueOf2 = Integer.valueOf(bVar.U);
            if (!gj9.c(this.f, bVar.f)) {
                orderingReverse = DefaultTrackSelector.f4653b;
            }
            return comparisonChainJ.j(numValueOf, numValueOf2, orderingReverse).m();
        }

        public final int f(int i, boolean z) {
            if (!DefaultTrackSelector.isSupported(i, this.f31029a.o)) {
                return 0;
            }
            if (!this.f4663a && !this.f31029a.i) {
                return 0;
            }
            if (DefaultTrackSelector.isSupported(i, false) && this.f4663a && ((TrackInfo) this).f31028a.O != -1) {
                d dVar = this.f31029a;
                if (!((com.google.android.exoplayer2.trackselection.c) dVar).f4705d && !((com.google.android.exoplayer2.trackselection.c) dVar).f4704c && (dVar.q || !z)) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TrackInfo
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean b(b bVar) {
            int i;
            String str;
            int i2;
            d dVar = this.f31029a;
            if ((dVar.l || ((i2 = ((TrackInfo) this).f31028a.U) != -1 && i2 == ((TrackInfo) bVar).f31028a.U)) && (dVar.j || ((str = ((TrackInfo) this).f31028a.k) != null && TextUtils.equals(str, ((TrackInfo) bVar).f31028a.k)))) {
                d dVar2 = this.f31029a;
                if ((dVar2.k || ((i = ((TrackInfo) this).f31028a.V) != -1 && i == ((TrackInfo) bVar).f31028a.V)) && (dVar2.m || (this.e == bVar.e && this.f4664f == bVar.f4664f))) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f31030a;
        public final boolean b;

        public c(com.google.android.exoplayer2.d dVar, int i) {
            this.f31030a = (dVar.K & 1) != 0;
            this.b = DefaultTrackSelector.isSupported(i, false);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return ComparisonChain.n().k(this.b, cVar.b).k(this.f31030a, cVar.f31030a).m();
        }
    }

    public static final class d extends com.google.android.exoplayer2.trackselection.c implements Bundleable {
        public static final int B0 = 1000;
        public static final int C0 = 1001;
        public static final int D0 = 1002;
        public static final int E0 = 1003;
        public static final int F0 = 1004;
        public static final int G0 = 1005;
        public static final int H0 = 1006;
        public static final int I0 = 1007;
        public static final int J0 = 1008;
        public static final int K0 = 1009;
        public static final int L0 = 1010;
        public static final int M0 = 1011;
        public static final int N0 = 1012;
        public static final int O0 = 1013;
        public static final int P0 = 1014;
        public static final int Q0 = 1015;
        public static final int R0 = 1016;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f31031a;
        public static final Bundleable.Creator<d> b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Deprecated
        public static final d f4665b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SparseArray<Map<ga9, f>> f4666a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SparseBooleanArray f4667a;
        public final boolean e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        public final boolean i;
        public final boolean j;
        public final boolean k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        public final boolean o;
        public final boolean p;
        public final boolean q;

        public static final class a extends com.google.android.exoplayer2.trackselection.c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final SparseArray<Map<ga9, f>> f31032a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final SparseBooleanArray f4668a;
            public boolean e;
            public boolean f;
            public boolean g;
            public boolean h;
            public boolean i;
            public boolean j;
            public boolean k;
            public boolean l;
            public boolean m;
            public boolean n;
            public boolean o;
            public boolean p;
            public boolean q;

            public static SparseArray<Map<ga9, f>> N0(SparseArray<Map<ga9, f>> sparseArray) {
                SparseArray<Map<ga9, f>> sparseArray2 = new SparseArray<>();
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), new HashMap(sparseArray.valueAt(i)));
                }
                return sparseArray2;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: A1, reason: merged with bridge method [inline-methods] */
            public a h0(@Nullable String str) {
                super.h0(str);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: B1, reason: merged with bridge method [inline-methods] */
            public a i0(String... strArr) {
                super.i0(strArr);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: C1, reason: merged with bridge method [inline-methods] */
            public a j0(int i) {
                super.j0(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
            public a A(sa9 sa9Var) {
                super.A(sa9Var);
                return this;
            }

            public a D1(int i, boolean z) {
                if (this.f4668a.get(i) == z) {
                    return this;
                }
                if (z) {
                    this.f4668a.put(i, true);
                } else {
                    this.f4668a.delete(i);
                }
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
            public d B() {
                return new d(this);
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: E1, reason: merged with bridge method [inline-methods] */
            public a k0(boolean z) {
                super.k0(z);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
            public a C(da9 da9Var) {
                super.C(da9Var);
                return this;
            }

            @Deprecated
            public a F1(int i, ga9 ga9Var, @Nullable f fVar) {
                Map<ga9, f> map = this.f31032a.get(i);
                if (map == null) {
                    map = new HashMap<>();
                    this.f31032a.put(i, map);
                }
                if (map.containsKey(ga9Var) && gj9.c(map.get(ga9Var), fVar)) {
                    return this;
                }
                map.put(ga9Var, fVar);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
            public a D() {
                super.D();
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void G1(Bundle bundle) {
                int[] intArray = bundle.getIntArray(com.google.android.exoplayer2.trackselection.c.keyForField(1010));
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(com.google.android.exoplayer2.trackselection.c.keyForField(1011));
                ImmutableList immutableListOf = parcelableArrayList == null ? ImmutableList.of() : a51.b(ga9.f41859a, parcelableArrayList);
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(com.google.android.exoplayer2.trackselection.c.keyForField(1012));
                SparseArray sparseArray = sparseParcelableArray == null ? new SparseArray() : a51.c(f.f31034a, sparseParcelableArray);
                if (intArray == null || intArray.length != immutableListOf.size()) {
                    return;
                }
                for (int i = 0; i < intArray.length; i++) {
                    F1(intArray[i], (ga9) immutableListOf.get(i), (f) sparseArray.get(i));
                }
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
            public a E(int i) {
                super.E(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: H1, reason: merged with bridge method [inline-methods] */
            public a l0(int i, boolean z) {
                super.l0(i, z);
                return this;
            }

            @Deprecated
            public a I0(int i, ga9 ga9Var) {
                Map<ga9, f> map = this.f31032a.get(i);
                if (map != null && map.containsKey(ga9Var)) {
                    map.remove(ga9Var);
                    if (map.isEmpty()) {
                        this.f31032a.remove(i);
                    }
                }
                return this;
            }

            public a I1(boolean z) {
                this.p = z;
                return this;
            }

            @Deprecated
            public a J0() {
                if (this.f31032a.size() == 0) {
                    return this;
                }
                this.f31032a.clear();
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
            public a m0(int i, int i2, boolean z) {
                super.m0(i, i2, z);
                return this;
            }

            @Deprecated
            public a K0(int i) {
                Map<ga9, f> map = this.f31032a.get(i);
                if (map != null && !map.isEmpty()) {
                    this.f31032a.remove(i);
                }
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
            public a n0(Context context, boolean z) {
                super.n0(context, z);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
            public a F() {
                super.F();
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
            public a G() {
                super.G();
                return this;
            }

            public final void O0() {
                this.e = true;
                this.f = false;
                this.g = true;
                this.h = false;
                this.i = true;
                this.j = false;
                this.k = false;
                this.l = false;
                this.m = false;
                this.n = true;
                this.o = true;
                this.p = false;
                this.q = true;
            }

            public final SparseBooleanArray P0(@Nullable int[] iArr) {
                if (iArr == null) {
                    return new SparseBooleanArray();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
                for (int i : iArr) {
                    sparseBooleanArray.append(i, true);
                }
                return sparseBooleanArray;
            }

            public a Q0(boolean z) {
                this.l = z;
                return this;
            }

            public a R0(boolean z) {
                this.m = z;
                return this;
            }

            public a S0(boolean z) {
                this.j = z;
                return this;
            }

            public a T0(boolean z) {
                this.k = z;
                return this;
            }

            public a U0(boolean z) {
                this.q = z;
                return this;
            }

            public a V0(boolean z) {
                this.h = z;
                return this;
            }

            public a W0(boolean z) {
                this.f = z;
                return this;
            }

            public a X0(boolean z) {
                this.g = z;
                return this;
            }

            public a Y0(boolean z) {
                this.n = z;
                return this;
            }

            @Deprecated
            public a Z0(int i) {
                return M(i);
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            @Deprecated
            /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
            public a J(Set<Integer> set) {
                super.J(set);
                return this;
            }

            public a b1(boolean z) {
                this.i = z;
                return this;
            }

            public a c1(boolean z) {
                this.o = z;
                return this;
            }

            public a d1(boolean z) {
                this.e = z;
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: e1, reason: merged with bridge method [inline-methods] */
            public a K(boolean z) {
                super.K(z);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] */
            public a L(boolean z) {
                super.L(z);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: g1, reason: merged with bridge method [inline-methods] */
            public a M(int i) {
                super.M(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] */
            public a N(int i) {
                super.N(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: i1, reason: merged with bridge method [inline-methods] */
            public a O(int i) {
                super.O(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: j1, reason: merged with bridge method [inline-methods] */
            public a P(int i) {
                super.P(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: k1, reason: merged with bridge method [inline-methods] */
            public a Q(int i) {
                super.Q(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: l1, reason: merged with bridge method [inline-methods] */
            public a R(int i, int i2) {
                super.R(i, i2);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: m1, reason: merged with bridge method [inline-methods] */
            public a S() {
                super.S();
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
            public a T(int i) {
                super.T(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: o1, reason: merged with bridge method [inline-methods] */
            public a U(int i) {
                super.U(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: p1, reason: merged with bridge method [inline-methods] */
            public a V(int i, int i2) {
                super.V(i, i2);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: q1, reason: merged with bridge method [inline-methods] */
            public a W(sa9 sa9Var) {
                super.W(sa9Var);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: r1, reason: merged with bridge method [inline-methods] */
            public a X(@Nullable String str) {
                super.X(str);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: s1, reason: merged with bridge method [inline-methods] */
            public a Y(String... strArr) {
                super.Y(strArr);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: t1, reason: merged with bridge method [inline-methods] */
            public a Z(@Nullable String str) {
                super.Z(str);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: u1, reason: merged with bridge method [inline-methods] */
            public a a0(String... strArr) {
                super.a0(strArr);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: v1, reason: merged with bridge method [inline-methods] */
            public a b0(int i) {
                super.b0(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: w1, reason: merged with bridge method [inline-methods] */
            public a c0(@Nullable String str) {
                super.c0(str);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: x1, reason: merged with bridge method [inline-methods] */
            public a d0(Context context) {
                super.d0(context);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: y1, reason: merged with bridge method [inline-methods] */
            public a f0(String... strArr) {
                super.f0(strArr);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            /* JADX INFO: renamed from: z1, reason: merged with bridge method [inline-methods] */
            public a g0(int i) {
                super.g0(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.c.a
            public a set(com.google.android.exoplayer2.trackselection.c cVar) {
                super.set(cVar);
                return this;
            }

            @Deprecated
            public a() {
                this.f31032a = new SparseArray<>();
                this.f4668a = new SparseBooleanArray();
                O0();
            }

            public a(Context context) {
                super(context);
                this.f31032a = new SparseArray<>();
                this.f4668a = new SparseBooleanArray();
                O0();
            }

            public a(d dVar) {
                super(dVar);
                this.e = dVar.e;
                this.f = dVar.f;
                this.g = dVar.g;
                this.h = dVar.h;
                this.i = dVar.i;
                this.j = dVar.j;
                this.k = dVar.k;
                this.l = dVar.l;
                this.m = dVar.m;
                this.n = dVar.n;
                this.o = dVar.o;
                this.p = dVar.p;
                this.q = dVar.q;
                this.f31032a = N0(dVar.f4666a);
                this.f4668a = dVar.f4667a.clone();
            }

            public a(Bundle bundle) {
                super(bundle);
                O0();
                d dVar = d.f31031a;
                d1(bundle.getBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1000), dVar.e));
                W0(bundle.getBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1001), dVar.f));
                X0(bundle.getBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1002), dVar.g));
                V0(bundle.getBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1014), dVar.h));
                b1(bundle.getBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1003), dVar.i));
                S0(bundle.getBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1004), dVar.j));
                T0(bundle.getBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1005), dVar.k));
                Q0(bundle.getBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1006), dVar.l));
                R0(bundle.getBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1015), dVar.m));
                Y0(bundle.getBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1016), dVar.n));
                c1(bundle.getBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1007), dVar.o));
                I1(bundle.getBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1008), dVar.p));
                U0(bundle.getBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1009), dVar.q));
                this.f31032a = new SparseArray<>();
                G1(bundle);
                this.f4668a = P0(bundle.getIntArray(com.google.android.exoplayer2.trackselection.c.keyForField(1013)));
            }
        }

        static {
            d dVarB = new a().B();
            f31031a = dVarB;
            f4665b = dVarB;
            b = new Bundleable.Creator() { // from class: com.zj.adlib.tj2
                @Override // com.google.android.exoplayer2.Bundleable.Creator
                public final Bundleable a(Bundle bundle) {
                    return DefaultTrackSelector.d.p(bundle);
                }
            };
        }

        public static boolean g(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        public static boolean h(SparseArray<Map<ga9, f>> sparseArray, SparseArray<Map<ga9, f>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (iIndexOfKey < 0 || !i(sparseArray.valueAt(i), sparseArray2.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        public static boolean i(Map<ga9, f> map, Map<ga9, f> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry<ga9, f> entry : map.entrySet()) {
                ga9 key = entry.getKey();
                if (!map2.containsKey(key) || !gj9.c(entry.getValue(), map2.get(key))) {
                    return false;
                }
            }
            return true;
        }

        public static d k(Context context) {
            return new a(context).B();
        }

        public static int[] l(SparseBooleanArray sparseBooleanArray) {
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i = 0; i < sparseBooleanArray.size(); i++) {
                iArr[i] = sparseBooleanArray.keyAt(i);
            }
            return iArr;
        }

        public static /* synthetic */ d p(Bundle bundle) {
            return new a(bundle).B();
        }

        public static void q(Bundle bundle, SparseArray<Map<ga9, f>> sparseArray) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray2 = new SparseArray();
            for (int i = 0; i < sparseArray.size(); i++) {
                int iKeyAt = sparseArray.keyAt(i);
                for (Map.Entry<ga9, f> entry : sparseArray.valueAt(i).entrySet()) {
                    f value = entry.getValue();
                    if (value != null) {
                        sparseArray2.put(arrayList2.size(), value);
                    }
                    arrayList2.add(entry.getKey());
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
                bundle.putIntArray(com.google.android.exoplayer2.trackselection.c.keyForField(1010), Ints.B(arrayList));
                bundle.putParcelableArrayList(com.google.android.exoplayer2.trackselection.c.keyForField(1011), a51.d(arrayList2));
                bundle.putSparseParcelableArray(com.google.android.exoplayer2.trackselection.c.keyForField(1012), a51.f(sparseArray2));
            }
        }

        @Override // com.google.android.exoplayer2.trackselection.c
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return super.equals(dVar) && this.e == dVar.e && this.f == dVar.f && this.g == dVar.g && this.h == dVar.h && this.i == dVar.i && this.j == dVar.j && this.k == dVar.k && this.l == dVar.l && this.m == dVar.m && this.n == dVar.n && this.o == dVar.o && this.p == dVar.p && this.q == dVar.q && g(this.f4667a, dVar.f4667a) && h(this.f4666a, dVar.f4666a);
        }

        @Override // com.google.android.exoplayer2.trackselection.c
        public int hashCode() {
            return ((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.j ? 1 : 0)) * 31) + (this.k ? 1 : 0)) * 31) + (this.l ? 1 : 0)) * 31) + (this.m ? 1 : 0)) * 31) + (this.n ? 1 : 0)) * 31) + (this.o ? 1 : 0)) * 31) + (this.p ? 1 : 0)) * 31) + (this.q ? 1 : 0);
        }

        @Override // com.google.android.exoplayer2.trackselection.c
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a();
        }

        public boolean m(int i) {
            return this.f4667a.get(i);
        }

        @Nullable
        @Deprecated
        public f n(int i, ga9 ga9Var) {
            Map<ga9, f> map = this.f4666a.get(i);
            if (map != null) {
                return map.get(ga9Var);
            }
            return null;
        }

        @Deprecated
        public boolean o(int i, ga9 ga9Var) {
            Map<ga9, f> map = this.f4666a.get(i);
            return map != null && map.containsKey(ga9Var);
        }

        @Override // com.google.android.exoplayer2.trackselection.c, com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1000), this.e);
            bundle.putBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1001), this.f);
            bundle.putBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1002), this.g);
            bundle.putBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1014), this.h);
            bundle.putBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1003), this.i);
            bundle.putBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1004), this.j);
            bundle.putBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1005), this.k);
            bundle.putBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1006), this.l);
            bundle.putBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1015), this.m);
            bundle.putBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1016), this.n);
            bundle.putBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1007), this.o);
            bundle.putBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1008), this.p);
            bundle.putBoolean(com.google.android.exoplayer2.trackselection.c.keyForField(1009), this.q);
            q(bundle, this.f4666a);
            bundle.putIntArray(com.google.android.exoplayer2.trackselection.c.keyForField(1013), l(this.f4667a));
            return bundle;
        }

        public d(a aVar) {
            super(aVar);
            this.e = aVar.e;
            this.f = aVar.f;
            this.g = aVar.g;
            this.h = aVar.h;
            this.i = aVar.i;
            this.j = aVar.j;
            this.k = aVar.k;
            this.l = aVar.l;
            this.m = aVar.m;
            this.n = aVar.n;
            this.o = aVar.o;
            this.p = aVar.p;
            this.q = aVar.q;
            this.f4666a = aVar.f31032a;
            this.f4667a = aVar.f4668a;
        }
    }

    @Deprecated
    public static final class e extends com.google.android.exoplayer2.trackselection.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d.a f31033a;

        @Deprecated
        public e() {
            this.f31033a = new d.a();
        }

        public e A0(boolean z) {
            this.f31033a.S0(z);
            return this;
        }

        public e B0(boolean z) {
            this.f31033a.T0(z);
            return this;
        }

        public e C0(boolean z) {
            this.f31033a.U0(z);
            return this;
        }

        public e D0(boolean z) {
            this.f31033a.V0(z);
            return this;
        }

        public e E0(boolean z) {
            this.f31033a.W0(z);
            return this;
        }

        public e F0(boolean z) {
            this.f31033a.X0(z);
            return this;
        }

        @Deprecated
        public e G0(int i) {
            this.f31033a.Z0(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        @Deprecated
        /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
        public e J(Set<Integer> set) {
            this.f31033a.J(set);
            return this;
        }

        public e I0(boolean z) {
            this.f31033a.b1(z);
            return this;
        }

        public e J0(boolean z) {
            this.f31033a.c1(z);
            return this;
        }

        public e K0(boolean z) {
            this.f31033a.d1(z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
        public e K(boolean z) {
            this.f31033a.K(z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
        public e L(boolean z) {
            this.f31033a.L(z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
        public e M(int i) {
            this.f31033a.M(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
        public e N(int i) {
            this.f31033a.N(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
        public e O(int i) {
            this.f31033a.O(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
        public e P(int i) {
            this.f31033a.P(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
        public e Q(int i) {
            this.f31033a.Q(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
        public e R(int i, int i2) {
            this.f31033a.R(i, i2);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
        public e S() {
            this.f31033a.S();
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
        public e T(int i) {
            this.f31033a.T(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
        public e U(int i) {
            this.f31033a.U(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
        public e V(int i, int i2) {
            this.f31033a.V(i, i2);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
        public e W(sa9 sa9Var) {
            this.f31033a.W(sa9Var);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
        public e X(@Nullable String str) {
            this.f31033a.X(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
        public e Y(String... strArr) {
            this.f31033a.Y(strArr);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
        public e Z(@Nullable String str) {
            this.f31033a.Z(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
        public e a0(String... strArr) {
            this.f31033a.a0(strArr);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
        public e b0(int i) {
            this.f31033a.b0(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: d1, reason: merged with bridge method [inline-methods] */
        public e c0(@Nullable String str) {
            this.f31033a.c0(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: e1, reason: merged with bridge method [inline-methods] */
        public e d0(Context context) {
            this.f31033a.d0(context);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] */
        public e f0(String... strArr) {
            this.f31033a.f0(strArr);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: g1, reason: merged with bridge method [inline-methods] */
        public e g0(int i) {
            this.f31033a.g0(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] */
        public e h0(@Nullable String str) {
            this.f31033a.h0(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: i1, reason: merged with bridge method [inline-methods] */
        public e i0(String... strArr) {
            this.f31033a.i0(strArr);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: j1, reason: merged with bridge method [inline-methods] */
        public e j0(int i) {
            this.f31033a.j0(i);
            return this;
        }

        public e k1(int i, boolean z) {
            this.f31033a.D1(i, z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: l1, reason: merged with bridge method [inline-methods] */
        public e k0(boolean z) {
            this.f31033a.k0(z);
            return this;
        }

        @Deprecated
        public e m1(int i, ga9 ga9Var, @Nullable f fVar) {
            this.f31033a.F1(i, ga9Var, fVar);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
        public e l0(int i, boolean z) {
            this.f31033a.l0(i, z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
        public e A(sa9 sa9Var) {
            this.f31033a.A(sa9Var);
            return this;
        }

        public e o1(boolean z) {
            this.f31033a.I1(z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
        public d B() {
            return this.f31033a.B();
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: p1, reason: merged with bridge method [inline-methods] */
        public e m0(int i, int i2, boolean z) {
            this.f31033a.m0(i, i2, z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
        public e C(da9 da9Var) {
            this.f31033a.C(da9Var);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: q1, reason: merged with bridge method [inline-methods] */
        public e n0(Context context, boolean z) {
            this.f31033a.n0(context, z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
        public e D() {
            this.f31033a.D();
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
        public e E(int i) {
            this.f31033a.E(i);
            return this;
        }

        @Deprecated
        public e t0(int i, ga9 ga9Var) {
            this.f31033a.I0(i, ga9Var);
            return this;
        }

        @Deprecated
        public e u0() {
            this.f31033a.J0();
            return this;
        }

        @Deprecated
        public e v0(int i) {
            this.f31033a.K0(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
        public e F() {
            this.f31033a.F();
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
        public e G() {
            this.f31033a.G();
            return this;
        }

        public e y0(boolean z) {
            this.f31033a.Q0(z);
            return this;
        }

        public e z0(boolean z) {
            this.f31033a.R0(z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.c.a
        public e set(com.google.android.exoplayer2.trackselection.c cVar) {
            this.f31033a.set(cVar);
            return this;
        }

        public e(Context context) {
            this.f31033a = new d.a(context);
        }
    }

    public static final class f implements Bundleable {
        public static final int N = 0;
        public static final int O = 1;
        public static final int P = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Bundleable.Creator<f> f31034a = new Bundleable.Creator() { // from class: com.zj.adlib.vj2
            @Override // com.google.android.exoplayer2.Bundleable.Creator
            public final Bundleable a(Bundle bundle) {
                return DefaultTrackSelector.f.d(bundle);
            }
        };
        public final int K;
        public final int L;
        public final int M;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f4669a;

        public f(int i, int... iArr) {
            this(i, iArr, 0);
        }

        public static String c(int i) {
            return Integer.toString(i, 36);
        }

        public static /* synthetic */ f d(Bundle bundle) {
            boolean z = false;
            int i = bundle.getInt(c(0), -1);
            int[] intArray = bundle.getIntArray(c(1));
            int i2 = bundle.getInt(c(2), -1);
            if (i >= 0 && i2 >= 0) {
                z = true;
            }
            sb0.a(z);
            sb0.g(intArray);
            return new f(i, intArray, i2);
        }

        public boolean b(int i) {
            for (int i2 : this.f4669a) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.K == fVar.K && Arrays.equals(this.f4669a, fVar.f4669a) && this.M == fVar.M;
        }

        public int hashCode() {
            return (((this.K * 31) + Arrays.hashCode(this.f4669a)) * 31) + this.M;
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(c(0), this.K);
            bundle.putIntArray(c(1), this.f4669a);
            bundle.putInt(c(2), this.M);
            return bundle;
        }

        public f(int i, int[] iArr, int i2) {
            this.K = i;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f4669a = iArrCopyOf;
            this.L = iArr.length;
            this.M = i2;
            Arrays.sort(iArrCopyOf);
        }
    }

    @RequiresApi(32)
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Spatializer.OnSpatializerStateChangedListener f31035a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Spatializer f4670a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Handler f4671a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f4672a;

        public class a implements Spatializer.OnSpatializerStateChangedListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DefaultTrackSelector f31036a;

            public a(g gVar, DefaultTrackSelector defaultTrackSelector) {
                this.f31036a = defaultTrackSelector;
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
                this.f31036a.P();
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
                this.f31036a.P();
            }
        }

        public g(Spatializer spatializer) {
            this.f4670a = spatializer;
            this.f4672a = spatializer.getImmersiveAudioLevel() != 0;
        }

        @Nullable
        public static g g(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return null;
            }
            return new g(audioManager.getSpatializer());
        }

        public boolean a(com.google.android.exoplayer2.audio.a aVar, com.google.android.exoplayer2.d dVar) {
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(gj9.N(("audio/eac3-joc".equals(dVar.k) && dVar.U == 16) ? 12 : dVar.U));
            int i = dVar.V;
            if (i != -1) {
                channelMask.setSampleRate(i);
            }
            return this.f4670a.canBeSpatialized(aVar.b().f30558a, channelMask.build());
        }

        public void b(DefaultTrackSelector defaultTrackSelector, Looper looper) {
            if (this.f31035a == null && this.f4671a == null) {
                this.f31035a = new a(this, defaultTrackSelector);
                Handler handler = new Handler(looper);
                this.f4671a = handler;
                Spatializer spatializer = this.f4670a;
                Objects.requireNonNull(handler);
                spatializer.addOnSpatializerStateChangedListener(new ls1(handler), this.f31035a);
            }
        }

        public boolean c() {
            return this.f4670a.isAvailable();
        }

        public boolean d() {
            return this.f4670a.isEnabled();
        }

        public boolean e() {
            return this.f4672a;
        }

        public void f() {
            Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.f31035a;
            if (onSpatializerStateChangedListener == null || this.f4671a == null) {
                return;
            }
            this.f4670a.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
            ((Handler) gj9.k(this.f4671a)).removeCallbacksAndMessages(null);
            this.f4671a = null;
            this.f31035a = null;
        }
    }

    public static final class h extends TrackInfo<h> implements Comparable<h> {
        public final int M;
        public final int N;
        public final int O;
        public final int P;
        public final int Q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f31037a;
        public final boolean b;
        public final boolean c;
        public final boolean d;

        public h(int i, da9 da9Var, int i2, d dVar, int i3, @Nullable String str) {
            int formatLanguageScore;
            super(i, da9Var, i2);
            int i4 = 0;
            this.f31037a = DefaultTrackSelector.isSupported(i3, false);
            int i5 = ((TrackInfo) this).f31028a.K & (~dVar.Z);
            this.b = (i5 & 1) != 0;
            this.c = (i5 & 2) != 0;
            ImmutableList<String> immutableListOf = ((com.google.android.exoplayer2.trackselection.c) dVar).d.isEmpty() ? ImmutableList.of("") : ((com.google.android.exoplayer2.trackselection.c) dVar).d;
            int i6 = 0;
            while (true) {
                if (i6 >= immutableListOf.size()) {
                    i6 = Integer.MAX_VALUE;
                    formatLanguageScore = 0;
                    break;
                } else {
                    formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(((TrackInfo) this).f31028a, immutableListOf.get(i6), ((com.google.android.exoplayer2.trackselection.c) dVar).f4703b);
                    if (formatLanguageScore > 0) {
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            this.N = i6;
            this.O = formatLanguageScore;
            int iF = DefaultTrackSelector.F(((TrackInfo) this).f31028a.L, dVar.Y);
            this.P = iF;
            this.d = (((TrackInfo) this).f31028a.L & 1088) != 0;
            int formatLanguageScore2 = DefaultTrackSelector.getFormatLanguageScore(((TrackInfo) this).f31028a, str, DefaultTrackSelector.normalizeUndeterminedLanguageToNull(str) == null);
            this.Q = formatLanguageScore2;
            boolean z = formatLanguageScore > 0 || (((com.google.android.exoplayer2.trackselection.c) dVar).d.isEmpty() && iF > 0) || this.b || (this.c && formatLanguageScore2 > 0);
            if (DefaultTrackSelector.isSupported(i3, dVar.o) && z) {
                i4 = 1;
            }
            this.M = i4;
        }

        public static int c(List<h> list, List<h> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        public static ImmutableList<h> e(int i, da9 da9Var, d dVar, int[] iArr, @Nullable String str) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i2 = 0; i2 < da9Var.K; i2++) {
                aVarBuilder.a(new h(i, da9Var, i2, dVar, iArr[i2], str));
            }
            return aVarBuilder.e();
        }

        @Override // com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TrackInfo
        public int a() {
            return this.M;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(h hVar) {
            ComparisonChain comparisonChainF = ComparisonChain.n().k(this.f31037a, hVar.f31037a).j(Integer.valueOf(this.N), Integer.valueOf(hVar.N), Ordering.natural().reverse()).f(this.O, hVar.O).f(this.P, hVar.P).k(this.b, hVar.b).j(Boolean.valueOf(this.c), Boolean.valueOf(hVar.c), this.O == 0 ? Ordering.natural() : Ordering.natural().reverse()).f(this.Q, hVar.Q);
            if (this.P == 0) {
                comparisonChainF = comparisonChainF.l(this.d, hVar.d);
            }
            return comparisonChainF.m();
        }

        @Override // com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TrackInfo
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean b(h hVar) {
            return false;
        }
    }

    public static final class i extends TrackInfo<i> {
        public final int M;
        public final int N;
        public final int O;
        public final int P;
        public final int Q;
        public final int R;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f31038a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f4673a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final boolean g;

        /* JADX WARN: Code duplicated, block: B:31:0x004b  */
        /* JADX WARN: Code duplicated, block: B:51:0x0079  */
        public i(int i, da9 da9Var, int i2, d dVar, int i3, int i4, boolean z) {
            boolean z2;
            boolean z3;
            com.google.android.exoplayer2.d dVar2;
            int i5;
            int i6;
            int i7;
            com.google.android.exoplayer2.d dVar3;
            int i8;
            int i9;
            int i10;
            super(i, da9Var, i2);
            this.f31038a = dVar;
            int i11 = dVar.g ? 24 : 16;
            this.e = dVar.f && (i4 & i11) != 0;
            if (!z || (((i8 = (dVar3 = ((TrackInfo) this).f31028a).Q) != -1 && i8 > dVar.K) || ((i9 = dVar3.R) != -1 && i9 > dVar.L))) {
                z2 = false;
            } else {
                float f = dVar3.f2564a;
                if ((f == -1.0f || f <= dVar.M) && ((i10 = dVar3.O) == -1 || i10 <= dVar.N)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            this.f4673a = z2;
            if (!z || (((i5 = (dVar2 = ((TrackInfo) this).f31028a).Q) != -1 && i5 < dVar.O) || ((i6 = dVar2.R) != -1 && i6 < dVar.P))) {
                z3 = false;
            } else {
                float f2 = dVar2.f2564a;
                if ((f2 == -1.0f || f2 >= dVar.Q) && ((i7 = dVar2.O) == -1 || i7 >= dVar.R)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            this.b = z3;
            this.c = DefaultTrackSelector.isSupported(i3, false);
            com.google.android.exoplayer2.d dVar4 = ((TrackInfo) this).f31028a;
            this.M = dVar4.O;
            this.N = dVar4.v();
            this.P = DefaultTrackSelector.F(((TrackInfo) this).f31028a.L, dVar.U);
            int i12 = ((TrackInfo) this).f31028a.L;
            this.d = i12 == 0 || (i12 & 1) != 0;
            int i13 = 0;
            while (true) {
                if (i13 >= ((com.google.android.exoplayer2.trackselection.c) dVar).f4698a.size()) {
                    i13 = Integer.MAX_VALUE;
                    break;
                }
                String str = ((TrackInfo) this).f31028a.k;
                if (str != null && str.equals(((com.google.android.exoplayer2.trackselection.c) dVar).f4698a.get(i13))) {
                    break;
                } else {
                    i13++;
                }
            }
            this.O = i13;
            this.f = RendererCapabilities.getDecoderSupport(i3) == 128;
            this.g = RendererCapabilities.getHardwareAccelerationSupport(i3) == 64;
            this.R = DefaultTrackSelector.G(((TrackInfo) this).f31028a.k);
            this.Q = i(i3, i11);
        }

        public static int e(i iVar, i iVar2) {
            ComparisonChain comparisonChainK = ComparisonChain.n().k(iVar.c, iVar2.c).f(iVar.P, iVar2.P).k(iVar.d, iVar2.d).k(iVar.f4673a, iVar2.f4673a).k(iVar.b, iVar2.b).j(Integer.valueOf(iVar.O), Integer.valueOf(iVar2.O), Ordering.natural().reverse()).k(iVar.f, iVar2.f).k(iVar.g, iVar2.g);
            if (iVar.f && iVar.g) {
                comparisonChainK = comparisonChainK.f(iVar.R, iVar2.R);
            }
            return comparisonChainK.m();
        }

        public static int f(i iVar, i iVar2) {
            Ordering orderingReverse = (iVar.f4673a && iVar.c) ? DefaultTrackSelector.f4651a : DefaultTrackSelector.f4651a.reverse();
            return ComparisonChain.n().j(Integer.valueOf(iVar.M), Integer.valueOf(iVar2.M), ((com.google.android.exoplayer2.trackselection.c) iVar.f31038a).f4704c ? DefaultTrackSelector.f4651a.reverse() : DefaultTrackSelector.f4653b).j(Integer.valueOf(iVar.N), Integer.valueOf(iVar2.N), orderingReverse).j(Integer.valueOf(iVar.M), Integer.valueOf(iVar2.M), orderingReverse).m();
        }

        public static int g(List<i> list, List<i> list2) {
            return ComparisonChain.n().j((i) Collections.max(list, new Comparator() { // from class: com.zj.adlib.wj2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DefaultTrackSelector.i.e((DefaultTrackSelector.i) obj, (DefaultTrackSelector.i) obj2);
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: com.zj.adlib.wj2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DefaultTrackSelector.i.e((DefaultTrackSelector.i) obj, (DefaultTrackSelector.i) obj2);
                }
            }), new Comparator() { // from class: com.zj.adlib.wj2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DefaultTrackSelector.i.e((DefaultTrackSelector.i) obj, (DefaultTrackSelector.i) obj2);
                }
            }).f(list.size(), list2.size()).j((i) Collections.max(list, new Comparator() { // from class: com.zj.adlib.xj2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DefaultTrackSelector.i.f((DefaultTrackSelector.i) obj, (DefaultTrackSelector.i) obj2);
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: com.zj.adlib.xj2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DefaultTrackSelector.i.f((DefaultTrackSelector.i) obj, (DefaultTrackSelector.i) obj2);
                }
            }), new Comparator() { // from class: com.zj.adlib.xj2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DefaultTrackSelector.i.f((DefaultTrackSelector.i) obj, (DefaultTrackSelector.i) obj2);
                }
            }).m();
        }

        public static ImmutableList<i> h(int i, da9 da9Var, d dVar, int[] iArr, int i2) {
            int iC = DefaultTrackSelector.C(da9Var, dVar.S, dVar.T, ((com.google.android.exoplayer2.trackselection.c) dVar).f4701a);
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i3 = 0; i3 < da9Var.K; i3++) {
                int iV = da9Var.c(i3).v();
                aVarBuilder.a(new i(i, da9Var, i3, dVar, iArr[i3], i2, iC == Integer.MAX_VALUE || (iV != -1 && iV <= iC)));
            }
            return aVarBuilder.e();
        }

        @Override // com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TrackInfo
        public int a() {
            return this.Q;
        }

        public final int i(int i, int i2) {
            if ((((TrackInfo) this).f31028a.L & 16384) != 0 || !DefaultTrackSelector.isSupported(i, this.f31038a.o)) {
                return 0;
            }
            if (!this.f4673a && !this.f31038a.e) {
                return 0;
            }
            if (DefaultTrackSelector.isSupported(i, false) && this.b && this.f4673a && ((TrackInfo) this).f31028a.O != -1) {
                d dVar = this.f31038a;
                if (!((com.google.android.exoplayer2.trackselection.c) dVar).f4705d && !((com.google.android.exoplayer2.trackselection.c) dVar).f4704c && (i & i2) != 0) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TrackInfo
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean b(i iVar) {
            return (this.e || gj9.c(((TrackInfo) this).f31028a.k, ((TrackInfo) iVar).f31028a.k)) && (this.f31038a.h || (this.f == iVar.f && this.g == iVar.g));
        }
    }

    @Deprecated
    public DefaultTrackSelector() {
        this(d.f31031a, new com.google.android.exoplayer2.trackselection.a.b());
    }

    public static void B(ga9 ga9Var, com.google.android.exoplayer2.trackselection.c cVar, Map<Integer, sa9> map) {
        sa9 sa9Var;
        for (int i2 = 0; i2 < ga9Var.K; i2++) {
            sa9 sa9Var2 = cVar.f4699a.get(ga9Var.b(i2));
            if (sa9Var2 != null && ((sa9Var = map.get(Integer.valueOf(sa9Var2.getType()))) == null || (sa9Var.f19558a.isEmpty() && !sa9Var2.f19558a.isEmpty()))) {
                map.put(Integer.valueOf(sa9Var2.getType()), sa9Var2);
            }
        }
    }

    public static int C(da9 da9Var, int i2, int i3, boolean z) {
        int i4;
        int i5 = Integer.MAX_VALUE;
        if (i2 != Integer.MAX_VALUE && i3 != Integer.MAX_VALUE) {
            for (int i6 = 0; i6 < da9Var.K; i6++) {
                com.google.android.exoplayer2.d dVarC = da9Var.c(i6);
                int i7 = dVarC.Q;
                if (i7 > 0 && (i4 = dVarC.R) > 0) {
                    Point pointD = D(z, i2, i3, i7, i4);
                    int i8 = dVarC.Q;
                    int i9 = dVarC.R;
                    int i10 = i8 * i9;
                    if (i8 >= ((int) (pointD.x * 0.98f)) && i9 >= ((int) (pointD.y * 0.98f)) && i10 < i5) {
                        i5 = i10;
                    }
                }
            }
        }
        return i5;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0010  */
    public static Point D(boolean z, int i2, int i3, int i4, int i5) {
        if (z) {
            if ((i4 > i5) == (i2 > i3)) {
                i3 = i2;
                i2 = i3;
            }
        } else {
            i3 = i2;
            i2 = i3;
        }
        int i6 = i4 * i2;
        int i7 = i5 * i3;
        return i6 >= i7 ? new Point(i3, gj9.m(i7, i4)) : new Point(gj9.m(i6, i5), i2);
    }

    public static int F(int i2, int i3) {
        if (i2 == 0 || i2 != i3) {
            return Integer.bitCount(i2 & i3);
        }
        return Integer.MAX_VALUE;
    }

    public static int G(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
            case "video/av01":
                return 4;
            case "video/hevc":
                return 3;
            case "video/avc":
                return 1;
            case "video/x-vnd.on2.vp9":
                return 2;
            default:
                return 0;
        }
    }

    public static boolean I(com.google.android.exoplayer2.d dVar) {
        String str = dVar.k;
        if (str == null) {
            return false;
        }
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
            case "audio/ac3":
            case "audio/ac4":
            case "audio/eac3":
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List J(d dVar, boolean z, int i2, da9 da9Var, int[] iArr) {
        return b.e(i2, da9Var, dVar, iArr, z, new Predicate() { // from class: com.zj.adlib.kj2
            @Override // com.google.common.base.Predicate
            public final boolean apply(Object obj) {
                return this.f42831a.H((d) obj);
            }
        });
    }

    public static /* synthetic */ List K(d dVar, String str, int i2, da9 da9Var, int[] iArr) {
        return h.e(i2, da9Var, dVar, iArr, str);
    }

    public static /* synthetic */ List L(d dVar, int[] iArr, int i2, da9 da9Var, int[] iArr2) {
        return i.h(i2, da9Var, dVar, iArr2, iArr[i2]);
    }

    public static /* synthetic */ int M(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    public static /* synthetic */ int N(Integer num, Integer num2) {
        return 0;
    }

    public static void O(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, ue7[] ue7VarArr, ExoTrackSelection[] exoTrackSelectionArr) {
        boolean z;
        boolean z2 = false;
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            if (i4 >= mappedTrackInfo.d()) {
                z = true;
                break;
            }
            int iG = mappedTrackInfo.g(i4);
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i4];
            if ((iG == 1 || iG == 2) && exoTrackSelection != null && Q(iArr[i4], mappedTrackInfo.h(i4), exoTrackSelection)) {
                if (iG == 1) {
                    if (i3 != -1) {
                        z = false;
                        break;
                    }
                    i3 = i4;
                } else {
                    if (i2 != -1) {
                        z = false;
                        break;
                    }
                    i2 = i4;
                }
            }
            i4++;
        }
        if (i3 != -1 && i2 != -1) {
            z2 = true;
        }
        if (z && z2) {
            ue7 ue7Var = new ue7(true);
            ue7VarArr[i3] = ue7Var;
            ue7VarArr[i2] = ue7Var;
        }
    }

    public static boolean Q(int[][] iArr, ga9 ga9Var, ExoTrackSelection exoTrackSelection) {
        if (exoTrackSelection == null) {
            return false;
        }
        int iC = ga9Var.c(exoTrackSelection.d());
        for (int i2 = 0; i2 < exoTrackSelection.length(); i2++) {
            if (RendererCapabilities.getTunnelingSupport(iArr[iC][exoTrackSelection.getIndexInTrackGroup(i2)]) != 32) {
                return false;
            }
        }
        return true;
    }

    public static int getFormatLanguageScore(com.google.android.exoplayer2.d dVar, @Nullable String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(dVar.h)) {
            return 4;
        }
        String strNormalizeUndeterminedLanguageToNull = normalizeUndeterminedLanguageToNull(str);
        String strNormalizeUndeterminedLanguageToNull2 = normalizeUndeterminedLanguageToNull(dVar.h);
        if (strNormalizeUndeterminedLanguageToNull2 == null || strNormalizeUndeterminedLanguageToNull == null) {
            return (z && strNormalizeUndeterminedLanguageToNull2 == null) ? 1 : 0;
        }
        if (strNormalizeUndeterminedLanguageToNull2.startsWith(strNormalizeUndeterminedLanguageToNull) || strNormalizeUndeterminedLanguageToNull.startsWith(strNormalizeUndeterminedLanguageToNull2)) {
            return 3;
        }
        return gj9.v1(strNormalizeUndeterminedLanguageToNull2, c49.f40900a)[0].equals(gj9.v1(strNormalizeUndeterminedLanguageToNull, c49.f40900a)[0]) ? 2 : 0;
    }

    public static boolean isSupported(int i2, boolean z) {
        int formatSupport = RendererCapabilities.getFormatSupport(i2);
        return formatSupport == 4 || (z && formatSupport == 3);
    }

    @Nullable
    public static String normalizeUndeterminedLanguageToNull(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static void y(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, d dVar, ExoTrackSelection.a[] aVarArr) {
        int iD = mappedTrackInfo.d();
        for (int i2 = 0; i2 < iD; i2++) {
            ga9 ga9VarH = mappedTrackInfo.h(i2);
            if (dVar.o(i2, ga9VarH)) {
                f fVarN = dVar.n(i2, ga9VarH);
                aVarArr[i2] = (fVarN == null || fVarN.f4669a.length == 0) ? null : new ExoTrackSelection.a(ga9VarH.b(fVarN.K), fVarN.f4669a, fVarN.M);
            }
        }
    }

    public static void z(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, com.google.android.exoplayer2.trackselection.c cVar, ExoTrackSelection.a[] aVarArr) {
        int iD = mappedTrackInfo.d();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < iD; i2++) {
            B(mappedTrackInfo.h(i2), cVar, map);
        }
        B(mappedTrackInfo.k(), cVar, map);
        for (int i3 = 0; i3 < iD; i3++) {
            sa9 sa9Var = (sa9) map.get(Integer.valueOf(mappedTrackInfo.g(i3)));
            if (sa9Var != null) {
                aVarArr[i3] = (sa9Var.f19558a.isEmpty() || mappedTrackInfo.h(i3).c(sa9Var.f19559a) == -1) ? null : new ExoTrackSelection.a(sa9Var.f19559a, Ints.B(sa9Var.f19558a));
            }
        }
    }

    public d.a A() {
        return a().a();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public d a() {
        d dVar;
        synchronized (this.f4660a) {
            dVar = this.f4657a;
        }
        return dVar;
    }

    public final boolean H(com.google.android.exoplayer2.d dVar) {
        boolean z;
        g gVar;
        g gVar2;
        synchronized (this.f4660a) {
            z = !this.f4657a.n || this.f4661a || dVar.U <= 2 || (I(dVar) && (gj9.f41922a < 32 || (gVar2 = this.f4658a) == null || !gVar2.e())) || (gj9.f41922a >= 32 && (gVar = this.f4658a) != null && gVar.e() && this.f4658a.c() && this.f4658a.d() && this.f4658a.a(this.f4656a, dVar));
        }
        return z;
    }

    public final void P() {
        boolean z;
        g gVar;
        synchronized (this.f4660a) {
            z = this.f4657a.n && !this.f4661a && gj9.f41922a >= 32 && (gVar = this.f4658a) != null && gVar.e();
        }
        if (z) {
            invalidate();
        }
    }

    @Nullable
    public final <T extends TrackInfo<T>> Pair<ExoTrackSelection.a, Integer> R(int i2, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, TrackInfo.Factory<T> factory, Comparator<List<T>> comparator) {
        int i3;
        RandomAccess randomAccessOf;
        ArrayList arrayList = new ArrayList();
        int iD = mappedTrackInfo.d();
        int i4 = 0;
        while (i4 < iD) {
            if (i2 == mappedTrackInfo.g(i4)) {
                ga9 ga9VarH = mappedTrackInfo.h(i4);
                for (int i5 = 0; i5 < ga9VarH.K; i5++) {
                    da9 da9VarB = ga9VarH.b(i5);
                    List<T> listA = factory.a(i4, da9VarB, iArr[i4][i5]);
                    boolean[] zArr = new boolean[da9VarB.K];
                    int i6 = 0;
                    while (i6 < da9VarB.K) {
                        T t = listA.get(i6);
                        int iA = t.a();
                        if (zArr[i6] || iA == 0) {
                            i3 = iD;
                        } else {
                            if (iA == 1) {
                                randomAccessOf = ImmutableList.of(t);
                                i3 = iD;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(t);
                                int i7 = i6 + 1;
                                while (i7 < da9VarB.K) {
                                    T t2 = listA.get(i7);
                                    int i8 = iD;
                                    if (t2.a() == 2 && t.b(t2)) {
                                        arrayList2.add(t2);
                                        zArr[i7] = true;
                                    }
                                    i7++;
                                    iD = i8;
                                }
                                i3 = iD;
                                randomAccessOf = arrayList2;
                            }
                            arrayList.add(randomAccessOf);
                        }
                        i6++;
                        iD = i3;
                    }
                }
            }
            i4++;
            iD = iD;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i9 = 0; i9 < list.size(); i9++) {
            iArr2[i9] = ((TrackInfo) list.get(i9)).L;
        }
        TrackInfo trackInfo = (TrackInfo) list.get(0);
        return Pair.create(new ExoTrackSelection.a(trackInfo.f4662a, iArr2), Integer.valueOf(trackInfo.K));
    }

    public void S(d.a aVar) {
        U(aVar.B());
    }

    @Deprecated
    public void T(e eVar) {
        U(eVar.B());
    }

    public final void U(d dVar) {
        boolean z;
        sb0.g(dVar);
        synchronized (this.f4660a) {
            z = !this.f4657a.equals(dVar);
            this.f4657a = dVar;
        }
        if (z) {
            if (dVar.n && this.f4655a == null) {
                Log.n(f4652a, f4654b);
            }
            invalidate();
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public boolean c() {
        return true;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public void e() {
        g gVar;
        synchronized (this.f4660a) {
            if (gj9.f41922a >= 32 && (gVar = this.f4658a) != null) {
                gVar.f();
            }
        }
        super.e();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public void g(com.google.android.exoplayer2.audio.a aVar) {
        boolean z;
        synchronized (this.f4660a) {
            z = !this.f4656a.equals(aVar);
            this.f4656a = aVar;
        }
        if (z) {
            P();
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public void h(com.google.android.exoplayer2.trackselection.c cVar) {
        if (cVar instanceof d) {
            U((d) cVar);
        }
        U(new d.a().set(cVar).B());
    }

    public ExoTrackSelection.a[] selectAllTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, d dVar) throws ExoPlaybackException {
        String str;
        int iD = mappedTrackInfo.d();
        ExoTrackSelection.a[] aVarArr = new ExoTrackSelection.a[iD];
        Pair<ExoTrackSelection.a, Integer> pairSelectVideoTrack = selectVideoTrack(mappedTrackInfo, iArr, iArr2, dVar);
        if (pairSelectVideoTrack != null) {
            aVarArr[((Integer) pairSelectVideoTrack.second).intValue()] = (ExoTrackSelection.a) pairSelectVideoTrack.first;
        }
        Pair<ExoTrackSelection.a, Integer> pairSelectAudioTrack = selectAudioTrack(mappedTrackInfo, iArr, iArr2, dVar);
        if (pairSelectAudioTrack != null) {
            aVarArr[((Integer) pairSelectAudioTrack.second).intValue()] = (ExoTrackSelection.a) pairSelectAudioTrack.first;
        }
        if (pairSelectAudioTrack == null) {
            str = null;
        } else {
            Object obj = pairSelectAudioTrack.first;
            str = ((ExoTrackSelection.a) obj).f4675a.c(((ExoTrackSelection.a) obj).f4676a[0]).h;
        }
        Pair<ExoTrackSelection.a, Integer> pairSelectTextTrack = selectTextTrack(mappedTrackInfo, iArr, dVar, str);
        if (pairSelectTextTrack != null) {
            aVarArr[((Integer) pairSelectTextTrack.second).intValue()] = (ExoTrackSelection.a) pairSelectTextTrack.first;
        }
        for (int i2 = 0; i2 < iD; i2++) {
            int iG = mappedTrackInfo.g(i2);
            if (iG != 2 && iG != 1 && iG != 3) {
                aVarArr[i2] = selectOtherTrack(iG, mappedTrackInfo.h(i2), iArr[i2], dVar);
            }
        }
        return aVarArr;
    }

    @Nullable
    public Pair<ExoTrackSelection.a, Integer> selectAudioTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, final d dVar) throws ExoPlaybackException {
        final boolean z = false;
        for (int i2 = 0; i2 < mappedTrackInfo.d(); i2++) {
            if (2 == mappedTrackInfo.g(i2) && mappedTrackInfo.h(i2).K > 0) {
                z = true;
                break;
            }
        }
        return R(1, mappedTrackInfo, iArr, new TrackInfo.Factory() { // from class: com.zj.adlib.pj2
            @Override // com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TrackInfo.Factory
            public final List a(int i3, da9 da9Var, int[] iArr3) {
                return this.f18856a.J(dVar, z, i3, da9Var, iArr3);
            }
        }, new Comparator() { // from class: com.zj.adlib.rj2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return DefaultTrackSelector.b.c((List) obj, (List) obj2);
            }
        });
    }

    @Nullable
    public ExoTrackSelection.a selectOtherTrack(int i2, ga9 ga9Var, int[][] iArr, d dVar) throws ExoPlaybackException {
        da9 da9Var = null;
        c cVar = null;
        int i3 = 0;
        for (int i4 = 0; i4 < ga9Var.K; i4++) {
            da9 da9VarB = ga9Var.b(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < da9VarB.K; i5++) {
                if (isSupported(iArr2[i5], dVar.o)) {
                    c cVar2 = new c(da9VarB.c(i5), iArr2[i5]);
                    if (cVar == null || cVar2.compareTo(cVar) > 0) {
                        da9Var = da9VarB;
                        i3 = i5;
                        cVar = cVar2;
                    }
                }
            }
        }
        if (da9Var == null) {
            return null;
        }
        return new ExoTrackSelection.a(da9Var, i3);
    }

    @Nullable
    public Pair<ExoTrackSelection.a, Integer> selectTextTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, final d dVar, @Nullable final String str) throws ExoPlaybackException {
        return R(3, mappedTrackInfo, iArr, new TrackInfo.Factory() { // from class: com.zj.adlib.ej2
            @Override // com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TrackInfo.Factory
            public final List a(int i2, da9 da9Var, int[] iArr2) {
                return DefaultTrackSelector.K(dVar, str, i2, da9Var, iArr2);
            }
        }, new Comparator() { // from class: com.zj.adlib.fj2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return DefaultTrackSelector.h.c((List) obj, (List) obj2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.trackselection.MappingTrackSelector
    public final Pair<ue7[], ExoTrackSelection[]> selectTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.a aVar, Timeline timeline) throws ExoPlaybackException {
        d dVar;
        g gVar;
        synchronized (this.f4660a) {
            dVar = this.f4657a;
            if (dVar.n && gj9.f41922a >= 32 && (gVar = this.f4658a) != null) {
                gVar.b(this, (Looper) sb0.k(Looper.myLooper()));
            }
        }
        int iD = mappedTrackInfo.d();
        ExoTrackSelection.a[] aVarArrSelectAllTracks = selectAllTracks(mappedTrackInfo, iArr, iArr2, dVar);
        z(mappedTrackInfo, dVar, aVarArrSelectAllTracks);
        y(mappedTrackInfo, dVar, aVarArrSelectAllTracks);
        for (int i2 = 0; i2 < iD; i2++) {
            int iG = mappedTrackInfo.g(i2);
            if (dVar.m(i2) || ((com.google.android.exoplayer2.trackselection.c) dVar).f4700a.contains(Integer.valueOf(iG))) {
                aVarArrSelectAllTracks[i2] = null;
            }
        }
        ExoTrackSelection[] exoTrackSelectionArrA = this.f4659a.a(aVarArrSelectAllTracks, getBandwidthMeter(), aVar, timeline);
        ue7[] ue7VarArr = new ue7[iD];
        for (int i3 = 0; i3 < iD; i3++) {
            boolean z = true;
            if ((dVar.m(i3) || ((com.google.android.exoplayer2.trackselection.c) dVar).f4700a.contains(Integer.valueOf(mappedTrackInfo.g(i3)))) || (mappedTrackInfo.g(i3) != -2 && exoTrackSelectionArrA[i3] == null)) {
                z = false;
            }
            ue7VarArr[i3] = z ? ue7.f45130a : null;
        }
        if (dVar.p) {
            O(mappedTrackInfo, iArr, ue7VarArr, exoTrackSelectionArrA);
        }
        return Pair.create(ue7VarArr, exoTrackSelectionArrA);
    }

    @Nullable
    public Pair<ExoTrackSelection.a, Integer> selectVideoTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, final int[] iArr2, final d dVar) throws ExoPlaybackException {
        return R(2, mappedTrackInfo, iArr, new TrackInfo.Factory() { // from class: com.zj.adlib.mj2
            @Override // com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TrackInfo.Factory
            public final List a(int i2, da9 da9Var, int[] iArr3) {
                return DefaultTrackSelector.L(dVar, iArr2, i2, da9Var, iArr3);
            }
        }, new Comparator() { // from class: com.zj.adlib.nj2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return DefaultTrackSelector.i.g((List) obj, (List) obj2);
            }
        });
    }

    public DefaultTrackSelector(Context context) {
        this(context, new com.google.android.exoplayer2.trackselection.a.b());
    }

    public DefaultTrackSelector(Context context, ExoTrackSelection.Factory factory) {
        this(context, d.k(context), factory);
    }

    public DefaultTrackSelector(Context context, com.google.android.exoplayer2.trackselection.c cVar) {
        this(context, cVar, new com.google.android.exoplayer2.trackselection.a.b());
    }

    @Deprecated
    public DefaultTrackSelector(com.google.android.exoplayer2.trackselection.c cVar, ExoTrackSelection.Factory factory) {
        this(cVar, factory, (Context) null);
    }

    public DefaultTrackSelector(Context context, com.google.android.exoplayer2.trackselection.c cVar, ExoTrackSelection.Factory factory) {
        this(cVar, factory, context);
    }

    public DefaultTrackSelector(com.google.android.exoplayer2.trackselection.c cVar, ExoTrackSelection.Factory factory, @Nullable Context context) {
        this.f4660a = new Object();
        this.f4655a = context != null ? context.getApplicationContext() : null;
        this.f4659a = factory;
        if (cVar instanceof d) {
            this.f4657a = (d) cVar;
        } else {
            this.f4657a = (context == null ? d.f31031a : d.k(context)).a().set(cVar).B();
        }
        this.f4656a = com.google.android.exoplayer2.audio.a.f2470a;
        boolean z = context != null && gj9.O0(context);
        this.f4661a = z;
        if (!z && context != null && gj9.f41922a >= 32) {
            this.f4658a = g.g(context);
        }
        if (this.f4657a.n && context == null) {
            Log.n(f4652a, f4654b);
        }
    }
}
