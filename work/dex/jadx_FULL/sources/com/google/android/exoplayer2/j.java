package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.j;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j implements Bundleable {
    public static final int L = 0;
    public static final int M = 1;
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float f3399a;
    public final float b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final j f3398a = new j(1.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<j> f30757a = new Bundleable.Creator() { // from class: com.zj.adlib.ts6
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return j.d(bundle);
        }
    };

    public j(float f) {
        this(f, 1.0f);
    }

    public static String c(int i) {
        return Integer.toString(i, 36);
    }

    public static /* synthetic */ j d(Bundle bundle) {
        return new j(bundle.getFloat(c(0), 1.0f), bundle.getFloat(c(1), 1.0f));
    }

    public long b(long j) {
        return j * ((long) this.K);
    }

    @CheckResult
    public j e(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false) float f) {
        return new j(f, this.b);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f3399a == jVar.f3399a && this.b == jVar.b;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f3399a)) * 31) + Float.floatToRawIntBits(this.b);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putFloat(c(0), this.f3399a);
        bundle.putFloat(c(1), this.b);
        return bundle;
    }

    public String toString() {
        return gj9.H("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f3399a), Float.valueOf(this.b));
    }

    public j(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false) float f, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false) float f2) {
        sb0.a(f > 0.0f);
        sb0.a(f2 > 0.0f);
        this.f3399a = f;
        this.b = f2;
        this.K = Math.round(f * 1000.0f);
    }
}
