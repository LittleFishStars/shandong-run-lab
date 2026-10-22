package com.zj.adlib;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.google.android.exoplayer2.Bundleable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class hp9 implements Bundleable {
    public static final int N = 0;
    public static final int O = 0;
    public static final int P = 0;
    public static final int Q = 0;
    public static final int R = 1;
    public static final int S = 2;
    public static final int T = 3;
    public static final float b = 1.0f;

    @IntRange(from = 0)
    public final int K;

    @IntRange(from = 0)
    public final int L;

    @IntRange(from = 0, to = 359)
    public final int M;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false)
    public final float f17051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final hp9 f17050a = new hp9(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<hp9> f42177a = new Bundleable.Creator() { // from class: com.zj.adlib.gp9
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return hp9.c(bundle);
        }
    };

    public hp9(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        this(i, i2, 0, 1.0f);
    }

    public static String b(int i) {
        return Integer.toString(i, 36);
    }

    public static /* synthetic */ hp9 c(Bundle bundle) {
        return new hp9(bundle.getInt(b(0), 0), bundle.getInt(b(1), 0), bundle.getInt(b(2), 0), bundle.getFloat(b(3), 1.0f));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hp9)) {
            return false;
        }
        hp9 hp9Var = (hp9) obj;
        return this.K == hp9Var.K && this.L == hp9Var.L && this.M == hp9Var.M && this.f17051a == hp9Var.f17051a;
    }

    public int hashCode() {
        return ((((((217 + this.K) * 31) + this.L) * 31) + this.M) * 31) + Float.floatToRawIntBits(this.f17051a);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(b(0), this.K);
        bundle.putInt(b(1), this.L);
        bundle.putInt(b(2), this.M);
        bundle.putFloat(b(3), this.f17051a);
        return bundle;
    }

    public hp9(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0, to = 359) int i3, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false) float f) {
        this.K = i;
        this.L = i2;
        this.M = i3;
        this.f17051a = f;
    }
}
