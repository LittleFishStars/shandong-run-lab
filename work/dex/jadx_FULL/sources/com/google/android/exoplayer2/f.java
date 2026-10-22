package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.f;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f extends Rating {
    public static final int Q = 0;
    public static final int R = 1;
    public static final int S = 2;
    public static final Bundleable.Creator<f> b = new Bundleable.Creator() { // from class: com.zj.adlib.pz3
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return f.f(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f30739a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f3321b;

    public f() {
        this.f30739a = false;
        this.f3321b = false;
    }

    public static String d(int i) {
        return Integer.toString(i, 36);
    }

    public static f f(Bundle bundle) {
        sb0.a(bundle.getInt(d(0), -1) == 0);
        return bundle.getBoolean(d(1), false) ? new f(bundle.getBoolean(d(2), false)) : new f();
    }

    @Override // com.google.android.exoplayer2.Rating
    public boolean c() {
        return this.f30739a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f3321b == fVar.f3321b && this.f30739a == fVar.f30739a;
    }

    public boolean g() {
        return this.f3321b;
    }

    public int hashCode() {
        return com.google.common.base.g.b(Boolean.valueOf(this.f30739a), Boolean.valueOf(this.f3321b));
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(d(0), 0);
        bundle.putBoolean(d(1), this.f30739a);
        bundle.putBoolean(d(2), this.f3321b);
        return bundle;
    }

    public f(boolean z) {
        this.f30739a = true;
        this.f3321b = z;
    }
}
