package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.audio.a;
import com.zj.adlib.gj9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements Bundleable {
    public static final int P = 0;
    public static final int Q = 1;
    public static final int R = 2;
    public static final int S = 3;
    public static final int T = 4;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public d f2471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final a f2470a = new e().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<a> f30557a = new Bundleable.Creator() { // from class: com.zj.adlib.ne0
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return a.d(bundle);
        }
    };

    @RequiresApi(29)
    public static final class b {
        @DoNotInline
        public static void a(AudioAttributes.Builder builder, int i) {
            builder.setAllowedCapturePolicy(i);
        }
    }

    @RequiresApi(32)
    public static final class c {
        @DoNotInline
        public static void a(AudioAttributes.Builder builder, int i) {
            builder.setSpatializationBehavior(i);
        }
    }

    @RequiresApi(21)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioAttributes f30558a;

        public d(a aVar) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(aVar.K).setFlags(aVar.L).setUsage(aVar.M);
            int i = gj9.f41922a;
            if (i >= 29) {
                b.a(usage, aVar.N);
            }
            if (i >= 32) {
                c.a(usage, aVar.O);
            }
            this.f30558a = usage.build();
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30559a = 0;
        public int b = 0;
        public int c = 1;
        public int d = 1;
        public int e = 0;

        public a a() {
            return new a(this.f30559a, this.b, this.c, this.d, this.e);
        }

        public e b(int i) {
            this.d = i;
            return this;
        }

        public e c(int i) {
            this.f30559a = i;
            return this;
        }

        public e d(int i) {
            this.b = i;
            return this;
        }

        public e e(int i) {
            this.e = i;
            return this;
        }

        public e f(int i) {
            this.c = i;
            return this;
        }
    }

    public static String c(int i) {
        return Integer.toString(i, 36);
    }

    public static /* synthetic */ a d(Bundle bundle) {
        e eVar = new e();
        if (bundle.containsKey(c(0))) {
            eVar.c(bundle.getInt(c(0)));
        }
        if (bundle.containsKey(c(1))) {
            eVar.d(bundle.getInt(c(1)));
        }
        if (bundle.containsKey(c(2))) {
            eVar.f(bundle.getInt(c(2)));
        }
        if (bundle.containsKey(c(3))) {
            eVar.b(bundle.getInt(c(3)));
        }
        if (bundle.containsKey(c(4))) {
            eVar.e(bundle.getInt(c(4)));
        }
        return eVar.a();
    }

    @RequiresApi(21)
    public d b() {
        if (this.f2471a == null) {
            this.f2471a = new d();
        }
        return this.f2471a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.K == aVar.K && this.L == aVar.L && this.M == aVar.M && this.N == aVar.N && this.O == aVar.O;
    }

    public int hashCode() {
        return ((((((((527 + this.K) * 31) + this.L) * 31) + this.M) * 31) + this.N) * 31) + this.O;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), this.K);
        bundle.putInt(c(1), this.L);
        bundle.putInt(c(2), this.M);
        bundle.putInt(c(3), this.N);
        bundle.putInt(c(4), this.O);
        return bundle;
    }

    public a(int i, int i2, int i3, int i4, int i5) {
        this.K = i;
        this.L = i2;
        this.M = i3;
        this.N = i4;
        this.O = i5;
    }
}
