package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.p;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import com.zj.adlib.a51;
import com.zj.adlib.da9;
import com.zj.adlib.sb0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class p implements Bundleable {
    public static final int K = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableList<a> f3611a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final p f3610a = new p(ImmutableList.of());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<p> f30804a = new Bundleable.Creator() { // from class: com.zj.adlib.za9
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return p.k(bundle);
        }
    };

    public static final class a implements Bundleable {
        public static final int L = 0;
        public static final int M = 1;
        public static final int N = 3;
        public static final int O = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Bundleable.Creator<a> f30805a = new Bundleable.Creator() { // from class: com.zj.adlib.bb9
            @Override // com.google.android.exoplayer2.Bundleable.Creator
            public final Bundleable a(Bundle bundle) {
                return p.a.m(bundle);
            }
        };
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final da9 f3612a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f3613a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f3614a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean[] f3615a;

        public a(da9 da9Var, boolean z, int[] iArr, boolean[] zArr) {
            int i = da9Var.K;
            this.K = i;
            boolean z2 = false;
            sb0.a(i == iArr.length && i == zArr.length);
            this.f3612a = da9Var;
            if (z && i > 1) {
                z2 = true;
            }
            this.f3613a = z2;
            this.f3614a = (int[]) iArr.clone();
            this.f3615a = (boolean[]) zArr.clone();
        }

        public static String l(int i) {
            return Integer.toString(i, 36);
        }

        public static /* synthetic */ a m(Bundle bundle) {
            da9 da9Var = (da9) da9.f41142a.a((Bundle) sb0.g(bundle.getBundle(l(0))));
            return new a(da9Var, bundle.getBoolean(l(4), false), (int[]) com.google.common.base.e.a(bundle.getIntArray(l(1)), new int[da9Var.K]), (boolean[]) com.google.common.base.e.a(bundle.getBooleanArray(l(3)), new boolean[da9Var.K]));
        }

        public da9 b() {
            return this.f3612a;
        }

        public d c(int i) {
            return this.f3612a.c(i);
        }

        public int d(int i) {
            return this.f3614a[i];
        }

        public boolean e() {
            return this.f3613a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3613a == aVar.f3613a && this.f3612a.equals(aVar.f3612a) && Arrays.equals(this.f3614a, aVar.f3614a) && Arrays.equals(this.f3615a, aVar.f3615a);
        }

        public boolean f() {
            return Booleans.f(this.f3615a, true);
        }

        public boolean g() {
            return h(false);
        }

        public int getType() {
            return this.f3612a.L;
        }

        public boolean h(boolean z) {
            for (int i = 0; i < this.f3614a.length; i++) {
                if (k(i, z)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f3612a.hashCode() * 31) + (this.f3613a ? 1 : 0)) * 31) + Arrays.hashCode(this.f3614a)) * 31) + Arrays.hashCode(this.f3615a);
        }

        public boolean i(int i) {
            return this.f3615a[i];
        }

        public boolean j(int i) {
            return k(i, false);
        }

        public boolean k(int i, boolean z) {
            int i2 = this.f3614a[i];
            return i2 == 4 || (z && i2 == 3);
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(l(0), this.f3612a.toBundle());
            bundle.putIntArray(l(1), this.f3614a);
            bundle.putBooleanArray(l(3), this.f3615a);
            bundle.putBoolean(l(4), this.f3613a);
            return bundle;
        }
    }

    public p(List<a> list) {
        this.f3611a = ImmutableList.copyOf((Collection) list);
    }

    public static String j(int i) {
        return Integer.toString(i, 36);
    }

    public static /* synthetic */ p k(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(j(0));
        return new p(parcelableArrayList == null ? ImmutableList.of() : a51.b(a.f30805a, parcelableArrayList));
    }

    public boolean b(int i) {
        for (int i2 = 0; i2 < this.f3611a.size(); i2++) {
            if (this.f3611a.get(i2).getType() == i) {
                return true;
            }
        }
        return false;
    }

    public ImmutableList<a> c() {
        return this.f3611a;
    }

    public boolean d() {
        return this.f3611a.isEmpty();
    }

    public boolean e(int i) {
        for (int i2 = 0; i2 < this.f3611a.size(); i2++) {
            a aVar = this.f3611a.get(i2);
            if (aVar.f() && aVar.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        return this.f3611a.equals(((p) obj).f3611a);
    }

    public boolean f(int i) {
        return g(i, false);
    }

    public boolean g(int i, boolean z) {
        for (int i2 = 0; i2 < this.f3611a.size(); i2++) {
            if (this.f3611a.get(i2).getType() == i && this.f3611a.get(i2).h(z)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean h(int i) {
        return i(i, false);
    }

    public int hashCode() {
        return this.f3611a.hashCode();
    }

    @Deprecated
    public boolean i(int i, boolean z) {
        return !b(i) || g(i, z);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(j(0), a51.d(this.f3611a));
        return bundle;
    }
}
