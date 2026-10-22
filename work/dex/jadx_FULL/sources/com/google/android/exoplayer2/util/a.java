package com.google.android.exoplayer2.util;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f31170a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseBooleanArray f31171a = new SparseBooleanArray();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f5294a;

        public b a(int i) {
            sb0.i(!this.f5294a);
            this.f31171a.append(i, true);
            return this;
        }

        public b b(a aVar) {
            for (int i = 0; i < aVar.d(); i++) {
                a(aVar.c(i));
            }
            return this;
        }

        public b c(int... iArr) {
            for (int i : iArr) {
                a(i);
            }
            return this;
        }

        public b d(int i, boolean z) {
            return z ? a(i) : this;
        }

        public a e() {
            sb0.i(!this.f5294a);
            this.f5294a = true;
            return new a(this.f31171a);
        }

        public b f(int i) {
            sb0.i(!this.f5294a);
            this.f31171a.delete(i);
            return this;
        }

        public b g(int... iArr) {
            for (int i : iArr) {
                f(i);
            }
            return this;
        }

        public b h(int i, boolean z) {
            return z ? f(i) : this;
        }
    }

    public boolean a(int i) {
        return this.f31170a.get(i);
    }

    public boolean b(int... iArr) {
        for (int i : iArr) {
            if (a(i)) {
                return true;
            }
        }
        return false;
    }

    public int c(int i) {
        sb0.c(i, 0, d());
        return this.f31170a.keyAt(i);
    }

    public int d() {
        return this.f31170a.size();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (gj9.f41922a >= 24) {
            return this.f31170a.equals(aVar.f31170a);
        }
        if (d() != aVar.d()) {
            return false;
        }
        for (int i = 0; i < d(); i++) {
            if (c(i) != aVar.c(i)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (gj9.f41922a >= 24) {
            return this.f31170a.hashCode();
        }
        int iD = d();
        for (int i = 0; i < d(); i++) {
            iD = (iD * 31) + c(i);
        }
        return iD;
    }

    public a(SparseBooleanArray sparseBooleanArray) {
        this.f31170a = sparseBooleanArray;
    }
}
