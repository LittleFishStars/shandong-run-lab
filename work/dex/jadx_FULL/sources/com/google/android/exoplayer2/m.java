package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.m;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class m extends Rating {
    public static final int R = 2;
    public static final int S = 5;
    public static final int T = 1;
    public static final int U = 2;
    public static final Bundleable.Creator<m> b = new Bundleable.Creator() { // from class: com.zj.adlib.qp8
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return m.f(bundle);
        }
    };

    @IntRange(from = 1)
    public final int Q;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final float f3404b;

    public m(@IntRange(from = 1) int i) {
        sb0.b(i > 0, "maxStars must be a positive integer");
        this.Q = i;
        this.f3404b = -1.0f;
    }

    public static String d(int i) {
        return Integer.toString(i, 36);
    }

    public static m f(Bundle bundle) {
        sb0.a(bundle.getInt(d(0), -1) == 2);
        int i = bundle.getInt(d(1), 5);
        float f = bundle.getFloat(d(2), -1.0f);
        return f == -1.0f ? new m(i) : new m(i, f);
    }

    @Override // com.google.android.exoplayer2.Rating
    public boolean c() {
        return this.f3404b != -1.0f;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.Q == mVar.Q && this.f3404b == mVar.f3404b;
    }

    @IntRange(from = 1)
    public int g() {
        return this.Q;
    }

    public float h() {
        return this.f3404b;
    }

    public int hashCode() {
        return com.google.common.base.g.b(Integer.valueOf(this.Q), Float.valueOf(this.f3404b));
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(d(0), 2);
        bundle.putInt(d(1), this.Q);
        bundle.putFloat(d(2), this.f3404b);
        return bundle;
    }

    public m(@IntRange(from = 1) int i, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE) float f) {
        sb0.b(i > 0, "maxStars must be a positive integer");
        sb0.b(f >= 0.0f && f <= ((float) i), "starRating is out of range [0, maxStars]");
        this.Q = i;
        this.f3404b = f;
    }
}
