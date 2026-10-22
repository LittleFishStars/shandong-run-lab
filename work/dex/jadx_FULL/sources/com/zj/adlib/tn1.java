package com.zj.adlib;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class tn1 implements Bundleable {
    public static final int O = 0;
    public static final int P = 1;
    public static final int Q = 2;
    public static final int R = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<tn1> f44960a = new Bundleable.Creator() { // from class: com.zj.adlib.sn1
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return tn1.e(bundle);
        }
    };
    public final int K;
    public final int L;
    public final int M;
    public int N;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final byte[] f19867a;

    public tn1(int i, int i2, int i3, @Nullable byte[] bArr) {
        this.K = i;
        this.L = i2;
        this.M = i3;
        this.f19867a = bArr;
    }

    @Pure
    public static int b(int i) {
        if (i == 1) {
            return 1;
        }
        if (i != 9) {
            return (i == 4 || i == 5 || i == 6 || i == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int c(int i) {
        if (i == 1) {
            return 3;
        }
        if (i == 16) {
            return 6;
        }
        if (i != 18) {
            return (i == 6 || i == 7) ? 3 : -1;
        }
        return 7;
    }

    public static String d(int i) {
        return Integer.toString(i, 36);
    }

    public static /* synthetic */ tn1 e(Bundle bundle) {
        return new tn1(bundle.getInt(d(0), -1), bundle.getInt(d(1), -1), bundle.getInt(d(2), -1), bundle.getByteArray(d(3)));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || tn1.class != obj.getClass()) {
            return false;
        }
        tn1 tn1Var = (tn1) obj;
        return this.K == tn1Var.K && this.L == tn1Var.L && this.M == tn1Var.M && Arrays.equals(this.f19867a, tn1Var.f19867a);
    }

    public int hashCode() {
        if (this.N == 0) {
            this.N = ((((((527 + this.K) * 31) + this.L) * 31) + this.M) * 31) + Arrays.hashCode(this.f19867a);
        }
        return this.N;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(d(0), this.K);
        bundle.putInt(d(1), this.L);
        bundle.putInt(d(2), this.M);
        bundle.putByteArray(d(3), this.f19867a);
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.K);
        sb.append(", ");
        sb.append(this.L);
        sb.append(", ");
        sb.append(this.M);
        sb.append(", ");
        sb.append(this.f19867a != null);
        sb.append(")");
        return sb.toString();
    }
}
