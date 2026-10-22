package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.trackselection.c;
import com.google.common.base.e;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import com.zj.adlib.a51;
import com.zj.adlib.da9;
import com.zj.adlib.gj9;
import com.zj.adlib.sa9;
import com.zj.adlib.sb0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c implements Bundleable {
    public static final int A0 = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final Bundleable.Creator<c> f31049a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final c f4697a;
    public static final int a0 = 1;

    @Deprecated
    public static final c b;
    public static final int b0 = 2;
    public static final int c0 = 3;
    public static final int d0 = 4;
    public static final int e0 = 5;
    public static final int f0 = 6;
    public static final int g0 = 7;
    public static final int h0 = 8;
    public static final int i0 = 9;
    public static final int j0 = 10;
    public static final int k0 = 11;
    public static final int l0 = 12;
    public static final int m0 = 13;
    public static final int n0 = 14;
    public static final int o0 = 15;
    public static final int p0 = 16;
    public static final int q0 = 17;
    public static final int r0 = 18;
    public static final int s0 = 19;
    public static final int t0 = 20;
    public static final int u0 = 21;
    public static final int v0 = 22;
    public static final int w0 = 23;
    public static final int x0 = 24;
    public static final int y0 = 25;
    public static final int z0 = 26;
    public final int K;
    public final int L;
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
    public final int W;
    public final int X;
    public final int Y;
    public final int Z;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableList<String> f4698a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableMap<da9, sa9> f4699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableSet<Integer> f4700a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4701a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ImmutableList<String> f4702b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f4703b;
    public final ImmutableList<String> c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f4704c;
    public final ImmutableList<String> d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final boolean f4705d;

    static {
        c cVarB = new a().B();
        f4697a = cVarB;
        b = cVarB;
        f31049a = new Bundleable.Creator() { // from class: com.zj.adlib.ua9
            @Override // com.google.android.exoplayer2.Bundleable.Creator
            public final Bundleable a(Bundle bundle) {
                return c.b(bundle);
            }
        };
    }

    public c(a aVar) {
        this.K = aVar.f31050a;
        this.L = aVar.b;
        this.M = aVar.c;
        this.N = aVar.d;
        this.O = aVar.e;
        this.P = aVar.f;
        this.Q = aVar.g;
        this.R = aVar.h;
        this.S = aVar.i;
        this.T = aVar.j;
        this.f4701a = aVar.f4709a;
        this.f4698a = aVar.f4706a;
        this.U = aVar.k;
        this.f4702b = aVar.f4710b;
        this.V = aVar.l;
        this.W = aVar.m;
        this.X = aVar.n;
        this.c = aVar.f4712c;
        this.d = aVar.f4714d;
        this.Y = aVar.o;
        this.Z = aVar.p;
        this.f4703b = aVar.f4711b;
        this.f4704c = aVar.f4713c;
        this.f4705d = aVar.f4715d;
        this.f4699a = ImmutableMap.copyOf((Map) aVar.f4707a);
        this.f4700a = ImmutableSet.copyOf((Collection) aVar.f4708a);
    }

    public static c b(Bundle bundle) {
        return new a(bundle).B();
    }

    public static c c(Context context) {
        return new a(context).B();
    }

    public static String keyForField(int i) {
        return Integer.toString(i, 36);
    }

    public a a() {
        return new a(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.K == cVar.K && this.L == cVar.L && this.M == cVar.M && this.N == cVar.N && this.O == cVar.O && this.P == cVar.P && this.Q == cVar.Q && this.R == cVar.R && this.f4701a == cVar.f4701a && this.S == cVar.S && this.T == cVar.T && this.f4698a.equals(cVar.f4698a) && this.U == cVar.U && this.f4702b.equals(cVar.f4702b) && this.V == cVar.V && this.W == cVar.W && this.X == cVar.X && this.c.equals(cVar.c) && this.d.equals(cVar.d) && this.Y == cVar.Y && this.Z == cVar.Z && this.f4703b == cVar.f4703b && this.f4704c == cVar.f4704c && this.f4705d == cVar.f4705d && this.f4699a.equals(cVar.f4699a) && this.f4700a.equals(cVar.f4700a);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.K + 31) * 31) + this.L) * 31) + this.M) * 31) + this.N) * 31) + this.O) * 31) + this.P) * 31) + this.Q) * 31) + this.R) * 31) + (this.f4701a ? 1 : 0)) * 31) + this.S) * 31) + this.T) * 31) + this.f4698a.hashCode()) * 31) + this.U) * 31) + this.f4702b.hashCode()) * 31) + this.V) * 31) + this.W) * 31) + this.X) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.Y) * 31) + this.Z) * 31) + (this.f4703b ? 1 : 0)) * 31) + (this.f4704c ? 1 : 0)) * 31) + (this.f4705d ? 1 : 0)) * 31) + this.f4699a.hashCode()) * 31) + this.f4700a.hashCode();
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(keyForField(6), this.K);
        bundle.putInt(keyForField(7), this.L);
        bundle.putInt(keyForField(8), this.M);
        bundle.putInt(keyForField(9), this.N);
        bundle.putInt(keyForField(10), this.O);
        bundle.putInt(keyForField(11), this.P);
        bundle.putInt(keyForField(12), this.Q);
        bundle.putInt(keyForField(13), this.R);
        bundle.putInt(keyForField(14), this.S);
        bundle.putInt(keyForField(15), this.T);
        bundle.putBoolean(keyForField(16), this.f4701a);
        bundle.putStringArray(keyForField(17), (String[]) this.f4698a.toArray(new String[0]));
        bundle.putInt(keyForField(25), this.U);
        bundle.putStringArray(keyForField(1), (String[]) this.f4702b.toArray(new String[0]));
        bundle.putInt(keyForField(2), this.V);
        bundle.putInt(keyForField(18), this.W);
        bundle.putInt(keyForField(19), this.X);
        bundle.putStringArray(keyForField(20), (String[]) this.c.toArray(new String[0]));
        bundle.putStringArray(keyForField(3), (String[]) this.d.toArray(new String[0]));
        bundle.putInt(keyForField(4), this.Y);
        bundle.putInt(keyForField(26), this.Z);
        bundle.putBoolean(keyForField(5), this.f4703b);
        bundle.putBoolean(keyForField(21), this.f4704c);
        bundle.putBoolean(keyForField(22), this.f4705d);
        bundle.putParcelableArrayList(keyForField(23), a51.d(this.f4699a.values()));
        bundle.putIntArray(keyForField(24), Ints.B(this.f4700a));
        return bundle;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31050a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ImmutableList<String> f4706a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public HashMap<da9, sa9> f4707a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public HashSet<Integer> f4708a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4709a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public ImmutableList<String> f4710b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4711b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public ImmutableList<String> f4712c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f4713c;
        public int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public ImmutableList<String> f4714d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public boolean f4715d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;

        @Deprecated
        public a() {
            this.f31050a = Integer.MAX_VALUE;
            this.b = Integer.MAX_VALUE;
            this.c = Integer.MAX_VALUE;
            this.d = Integer.MAX_VALUE;
            this.i = Integer.MAX_VALUE;
            this.j = Integer.MAX_VALUE;
            this.f4709a = true;
            this.f4706a = ImmutableList.of();
            this.k = 0;
            this.f4710b = ImmutableList.of();
            this.l = 0;
            this.m = Integer.MAX_VALUE;
            this.n = Integer.MAX_VALUE;
            this.f4712c = ImmutableList.of();
            this.f4714d = ImmutableList.of();
            this.o = 0;
            this.p = 0;
            this.f4711b = false;
            this.f4713c = false;
            this.f4715d = false;
            this.f4707a = new HashMap<>();
            this.f4708a = new HashSet<>();
        }

        public static ImmutableList<String> I(String[] strArr) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (String str : (String[]) sb0.g(strArr)) {
                aVarBuilder.a(gj9.b1((String) sb0.g(str)));
            }
            return aVarBuilder.e();
        }

        public a A(sa9 sa9Var) {
            this.f4707a.put(sa9Var.f19559a, sa9Var);
            return this;
        }

        public c B() {
            return new c(this);
        }

        public a C(da9 da9Var) {
            this.f4707a.remove(da9Var);
            return this;
        }

        public a D() {
            this.f4707a.clear();
            return this;
        }

        public a E(int i) {
            Iterator<sa9> it = this.f4707a.values().iterator();
            while (it.hasNext()) {
                if (it.next().getType() == i) {
                    it.remove();
                }
            }
            return this;
        }

        public a F() {
            return R(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public a G() {
            return m0(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        @EnsuresNonNull({"preferredVideoMimeTypes", "preferredAudioLanguages", "preferredAudioMimeTypes", "preferredTextLanguages", "overrides", "disabledTrackTypes"})
        public final void H(c cVar) {
            this.f31050a = cVar.K;
            this.b = cVar.L;
            this.c = cVar.M;
            this.d = cVar.N;
            this.e = cVar.O;
            this.f = cVar.P;
            this.g = cVar.Q;
            this.h = cVar.R;
            this.i = cVar.S;
            this.j = cVar.T;
            this.f4709a = cVar.f4701a;
            this.f4706a = cVar.f4698a;
            this.k = cVar.U;
            this.f4710b = cVar.f4702b;
            this.l = cVar.V;
            this.m = cVar.W;
            this.n = cVar.X;
            this.f4712c = cVar.c;
            this.f4714d = cVar.d;
            this.o = cVar.Y;
            this.p = cVar.Z;
            this.f4711b = cVar.f4703b;
            this.f4713c = cVar.f4704c;
            this.f4715d = cVar.f4705d;
            this.f4708a = new HashSet<>(cVar.f4700a);
            this.f4707a = new HashMap<>(cVar.f4699a);
        }

        @Deprecated
        public a J(Set<Integer> set) {
            this.f4708a.clear();
            this.f4708a.addAll(set);
            return this;
        }

        public a K(boolean z) {
            this.f4715d = z;
            return this;
        }

        public a L(boolean z) {
            this.f4713c = z;
            return this;
        }

        public a M(int i) {
            this.p = i;
            return this;
        }

        public a N(int i) {
            this.n = i;
            return this;
        }

        public a O(int i) {
            this.m = i;
            return this;
        }

        public a P(int i) {
            this.d = i;
            return this;
        }

        public a Q(int i) {
            this.c = i;
            return this;
        }

        public a R(int i, int i2) {
            this.f31050a = i;
            this.b = i2;
            return this;
        }

        public a S() {
            return R(1279, 719);
        }

        public a T(int i) {
            this.h = i;
            return this;
        }

        public a U(int i) {
            this.g = i;
            return this;
        }

        public a V(int i, int i2) {
            this.e = i;
            this.f = i2;
            return this;
        }

        public a W(sa9 sa9Var) {
            E(sa9Var.getType());
            this.f4707a.put(sa9Var.f19559a, sa9Var);
            return this;
        }

        public a X(@Nullable String str) {
            return str == null ? Y(new String[0]) : Y(str);
        }

        public a Y(String... strArr) {
            this.f4710b = I(strArr);
            return this;
        }

        public a Z(@Nullable String str) {
            return str == null ? a0(new String[0]) : a0(str);
        }

        public a a0(String... strArr) {
            this.f4712c = ImmutableList.copyOf(strArr);
            return this;
        }

        public a b0(int i) {
            this.l = i;
            return this;
        }

        public a c0(@Nullable String str) {
            return str == null ? f0(new String[0]) : f0(str);
        }

        public a d0(Context context) {
            if (gj9.f41922a >= 19) {
                e0(context);
            }
            return this;
        }

        @RequiresApi(19)
        public final void e0(Context context) {
            CaptioningManager captioningManager;
            if ((gj9.f41922a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.o = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f4714d = ImmutableList.of(gj9.j0(locale));
                }
            }
        }

        public a f0(String... strArr) {
            this.f4714d = I(strArr);
            return this;
        }

        public a g0(int i) {
            this.o = i;
            return this;
        }

        public a h0(@Nullable String str) {
            return str == null ? i0(new String[0]) : i0(str);
        }

        public a i0(String... strArr) {
            this.f4706a = ImmutableList.copyOf(strArr);
            return this;
        }

        public a j0(int i) {
            this.k = i;
            return this;
        }

        public a k0(boolean z) {
            this.f4711b = z;
            return this;
        }

        public a l0(int i, boolean z) {
            if (z) {
                this.f4708a.add(Integer.valueOf(i));
            } else {
                this.f4708a.remove(Integer.valueOf(i));
            }
            return this;
        }

        public a m0(int i, int i2, boolean z) {
            this.i = i;
            this.j = i2;
            this.f4709a = z;
            return this;
        }

        public a n0(Context context, boolean z) {
            Point pointW = gj9.W(context);
            return m0(pointW.x, pointW.y, z);
        }

        public a set(c cVar) {
            H(cVar);
            return this;
        }

        public a(Context context) {
            this();
            d0(context);
            n0(context, true);
        }

        public a(c cVar) {
            H(cVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Bundle bundle) {
            ImmutableList immutableListB;
            String strKeyForField = c.keyForField(6);
            c cVar = c.f4697a;
            this.f31050a = bundle.getInt(strKeyForField, cVar.K);
            this.b = bundle.getInt(c.keyForField(7), cVar.L);
            this.c = bundle.getInt(c.keyForField(8), cVar.M);
            this.d = bundle.getInt(c.keyForField(9), cVar.N);
            this.e = bundle.getInt(c.keyForField(10), cVar.O);
            this.f = bundle.getInt(c.keyForField(11), cVar.P);
            this.g = bundle.getInt(c.keyForField(12), cVar.Q);
            this.h = bundle.getInt(c.keyForField(13), cVar.R);
            this.i = bundle.getInt(c.keyForField(14), cVar.S);
            this.j = bundle.getInt(c.keyForField(15), cVar.T);
            this.f4709a = bundle.getBoolean(c.keyForField(16), cVar.f4701a);
            this.f4706a = ImmutableList.copyOf((String[]) e.a(bundle.getStringArray(c.keyForField(17)), new String[0]));
            this.k = bundle.getInt(c.keyForField(25), cVar.U);
            this.f4710b = I((String[]) e.a(bundle.getStringArray(c.keyForField(1)), new String[0]));
            this.l = bundle.getInt(c.keyForField(2), cVar.V);
            this.m = bundle.getInt(c.keyForField(18), cVar.W);
            this.n = bundle.getInt(c.keyForField(19), cVar.X);
            this.f4712c = ImmutableList.copyOf((String[]) e.a(bundle.getStringArray(c.keyForField(20)), new String[0]));
            this.f4714d = I((String[]) e.a(bundle.getStringArray(c.keyForField(3)), new String[0]));
            this.o = bundle.getInt(c.keyForField(4), cVar.Y);
            this.p = bundle.getInt(c.keyForField(26), cVar.Z);
            this.f4711b = bundle.getBoolean(c.keyForField(5), cVar.f4703b);
            this.f4713c = bundle.getBoolean(c.keyForField(21), cVar.f4704c);
            this.f4715d = bundle.getBoolean(c.keyForField(22), cVar.f4705d);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(c.keyForField(23));
            if (parcelableArrayList == null) {
                immutableListB = ImmutableList.of();
            } else {
                immutableListB = a51.b(sa9.f44652a, parcelableArrayList);
            }
            this.f4707a = new HashMap<>();
            for (int i = 0; i < immutableListB.size(); i++) {
                sa9 sa9Var = (sa9) immutableListB.get(i);
                this.f4707a.put(sa9Var.f19559a, sa9Var);
            }
            int[] iArr = (int[]) e.a(bundle.getIntArray(c.keyForField(24)), new int[0]);
            this.f4708a = new HashSet<>();
            for (int i2 : iArr) {
                this.f4708a.add(Integer.valueOf(i2));
            }
        }
    }
}
