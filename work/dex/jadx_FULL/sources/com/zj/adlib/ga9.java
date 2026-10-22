package com.zj.adlib;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ga9 implements Bundleable {
    public static final int M = 0;
    public static final String f = "TrackGroupArray";
    public final int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableList<da9> f16736a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ga9 f16735a = new ga9(new da9[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<ga9> f41859a = new Bundleable.Creator() { // from class: com.zj.adlib.fa9
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return ga9.f(bundle);
        }
    };

    public ga9(da9... da9VarArr) {
        this.f16736a = ImmutableList.copyOf(da9VarArr);
        this.K = da9VarArr.length;
        g();
    }

    public static String e(int i) {
        return Integer.toString(i, 36);
    }

    public static /* synthetic */ ga9 f(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(e(0));
        return parcelableArrayList == null ? new ga9(new da9[0]) : new ga9((da9[]) a51.b(da9.f41142a, parcelableArrayList).toArray(new da9[0]));
    }

    public da9 b(int i) {
        return this.f16736a.get(i);
    }

    public int c(da9 da9Var) {
        int iIndexOf = this.f16736a.indexOf(da9Var);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public boolean d() {
        return this.K == 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ga9.class != obj.getClass()) {
            return false;
        }
        ga9 ga9Var = (ga9) obj;
        return this.K == ga9Var.K && this.f16736a.equals(ga9Var.f16736a);
    }

    public final void g() {
        int i = 0;
        while (i < this.f16736a.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f16736a.size(); i3++) {
                if (this.f16736a.get(i).equals(this.f16736a.get(i3))) {
                    Log.e(f, "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public int hashCode() {
        if (this.L == 0) {
            this.L = this.f16736a.hashCode();
        }
        return this.L;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(e(0), a51.d(this.f16736a));
        return bundle;
    }
}
