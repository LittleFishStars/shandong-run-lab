package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.efs.sdk.base.core.config.remote.RemoteConfig;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.i;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i extends Rating {
    public static final int Q = 1;
    public static final int R = 1;
    public static final Bundleable.Creator<i> b = new Bundleable.Creator() { // from class: com.zj.adlib.do6
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return i.f(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final float f3397b;

    public i() {
        this.f3397b = -1.0f;
    }

    public static String d(int i) {
        return Integer.toString(i, 36);
    }

    public static i f(Bundle bundle) {
        sb0.a(bundle.getInt(d(0), -1) == 1);
        float f = bundle.getFloat(d(1), -1.0f);
        return f == -1.0f ? new i() : new i(f);
    }

    @Override // com.google.android.exoplayer2.Rating
    public boolean c() {
        return this.f3397b != -1.0f;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof i) && this.f3397b == ((i) obj).f3397b;
    }

    public float g() {
        return this.f3397b;
    }

    public int hashCode() {
        return com.google.common.base.g.b(Float.valueOf(this.f3397b));
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(d(0), 1);
        bundle.putFloat(d(1), this.f3397b);
        return bundle;
    }

    public i(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = RemoteConfig.FULL_RATE) float f) {
        sb0.b(f >= 0.0f && f <= 100.0f, "percent must be in the range of [0, 100]");
        this.f3397b = f;
    }
}
