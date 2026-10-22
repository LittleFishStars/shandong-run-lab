package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.DeviceInfo;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DeviceInfo implements Bundleable {
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 0;
    public static final int Q = 1;
    public static final int R = 2;
    public final int K;
    public final int L;
    public final int M;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final DeviceInfo f2034a = new DeviceInfo(0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<DeviceInfo> f30480a = new Bundleable.Creator() { // from class: com.zj.adlib.zl2
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return DeviceInfo.c(bundle);
        }
    };

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackType {
    }

    public DeviceInfo(int i, int i2, int i3) {
        this.K = i;
        this.L = i2;
        this.M = i3;
    }

    public static String b(int i) {
        return Integer.toString(i, 36);
    }

    public static /* synthetic */ DeviceInfo c(Bundle bundle) {
        return new DeviceInfo(bundle.getInt(b(0), 0), bundle.getInt(b(1), 0), bundle.getInt(b(2), 0));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return this.K == deviceInfo.K && this.L == deviceInfo.L && this.M == deviceInfo.M;
    }

    public int hashCode() {
        return ((((527 + this.K) * 31) + this.L) * 31) + this.M;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(b(0), this.K);
        bundle.putInt(b(1), this.L);
        bundle.putInt(b(2), this.M);
        return bundle;
    }
}
