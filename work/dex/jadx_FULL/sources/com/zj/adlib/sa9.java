package com.zj.adlib;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class sa9 implements Bundleable {
    public static final int K = 0;
    public static final int L = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<sa9> f44652a = new Bundleable.Creator() { // from class: com.zj.adlib.ra9
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return sa9.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableList<Integer> f19558a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final da9 f19559a;

    public sa9(da9 da9Var, int i) {
        this(da9Var, ImmutableList.of(Integer.valueOf(i)));
    }

    public static String b(int i) {
        return Integer.toString(i, 36);
    }

    public static /* synthetic */ sa9 c(Bundle bundle) {
        return new sa9((da9) da9.f41142a.a((Bundle) sb0.g(bundle.getBundle(b(0)))), Ints.c((int[]) sb0.g(bundle.getIntArray(b(1)))));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || sa9.class != obj.getClass()) {
            return false;
        }
        sa9 sa9Var = (sa9) obj;
        return this.f19559a.equals(sa9Var.f19559a) && this.f19558a.equals(sa9Var.f19558a);
    }

    public int getType() {
        return this.f19559a.L;
    }

    public int hashCode() {
        return this.f19559a.hashCode() + (this.f19558a.hashCode() * 31);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBundle(b(0), this.f19559a.toBundle());
        bundle.putIntArray(b(1), Ints.B(this.f19558a));
        return bundle;
    }

    public sa9(da9 da9Var, List<Integer> list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= da9Var.K)) {
            throw new IndexOutOfBoundsException();
        }
        this.f19559a = da9Var;
        this.f19558a = ImmutableList.copyOf((Collection) list);
    }
}
