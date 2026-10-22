package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.o;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class o extends Rating {
    public static final int Q = 3;
    public static final int R = 1;
    public static final int S = 2;
    public static final Bundleable.Creator<o> b = new Bundleable.Creator() { // from class: com.zj.adlib.l69
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return o.f(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f30783a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f3488b;

    public o() {
        this.f30783a = false;
        this.f3488b = false;
    }

    public static String d(int i) {
        return Integer.toString(i, 36);
    }

    public static o f(Bundle bundle) {
        sb0.a(bundle.getInt(d(0), -1) == 3);
        return bundle.getBoolean(d(1), false) ? new o(bundle.getBoolean(d(2), false)) : new o();
    }

    @Override // com.google.android.exoplayer2.Rating
    public boolean c() {
        return this.f30783a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f3488b == oVar.f3488b && this.f30783a == oVar.f30783a;
    }

    public boolean g() {
        return this.f3488b;
    }

    public int hashCode() {
        return com.google.common.base.g.b(Boolean.valueOf(this.f30783a), Boolean.valueOf(this.f3488b));
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(d(0), 3);
        bundle.putBoolean(d(1), this.f30783a);
        bundle.putBoolean(d(2), this.f3488b);
        return bundle;
    }

    public o(boolean z) {
        this.f30783a = true;
        this.f3488b = z;
    }
}
