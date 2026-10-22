package com.zj.adlib;

import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class da9 implements Bundleable {
    public static final int N = 0;
    public static final int O = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<da9> f41142a = new Bundleable.Creator() { // from class: com.zj.adlib.ca9
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return da9.f(bundle);
        }
    };
    public static final String g = "TrackGroup";
    public final int K;
    public final int L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d[] f15955a;
    public final String f;

    public da9(d... dVarArr) {
        this("", dVarArr);
    }

    public static String e(int i) {
        return Integer.toString(i, 36);
    }

    public static /* synthetic */ da9 f(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(e(0));
        return new da9(bundle.getString(e(1), ""), (d[]) (parcelableArrayList == null ? ImmutableList.of() : a51.b(d.f30574a, parcelableArrayList)).toArray(new d[0]));
    }

    public static void g(String str, @Nullable String str2, @Nullable String str3, int i) {
        Log.e(g, "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + ")"));
    }

    public static String h(@Nullable String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    public static int i(int i) {
        return i | 16384;
    }

    @CheckResult
    public da9 b(String str) {
        return new da9(str, this.f15955a);
    }

    public d c(int i) {
        return this.f15955a[i];
    }

    public int d(d dVar) {
        int i = 0;
        while (true) {
            d[] dVarArr = this.f15955a;
            if (i >= dVarArr.length) {
                return -1;
            }
            if (dVar == dVarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || da9.class != obj.getClass()) {
            return false;
        }
        da9 da9Var = (da9) obj;
        return this.f.equals(da9Var.f) && Arrays.equals(this.f15955a, da9Var.f15955a);
    }

    public int hashCode() {
        if (this.M == 0) {
            this.M = ((527 + this.f.hashCode()) * 31) + Arrays.hashCode(this.f15955a);
        }
        return this.M;
    }

    public final void j() {
        String strH = h(this.f15955a[0].h);
        int i = i(this.f15955a[0].L);
        int i2 = 1;
        while (true) {
            d[] dVarArr = this.f15955a;
            if (i2 >= dVarArr.length) {
                return;
            }
            if (!strH.equals(h(dVarArr[i2].h))) {
                d[] dVarArr2 = this.f15955a;
                g("languages", dVarArr2[0].h, dVarArr2[i2].h, i2);
                return;
            } else {
                if (i != i(this.f15955a[i2].L)) {
                    g("role flags", Integer.toBinaryString(this.f15955a[0].L), Integer.toBinaryString(this.f15955a[i2].L), i2);
                    return;
                }
                i2++;
            }
        }
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(e(0), a51.d(Lists.t(this.f15955a)));
        bundle.putString(e(1), this.f);
        return bundle;
    }

    public da9(String str, d... dVarArr) {
        sb0.a(dVarArr.length > 0);
        this.f = str;
        this.f15955a = dVarArr;
        this.K = dVarArr.length;
        int iL = bp5.l(dVarArr[0].k);
        this.L = iL == -1 ? bp5.l(dVarArr[0].j) : iL;
        j();
    }
}
