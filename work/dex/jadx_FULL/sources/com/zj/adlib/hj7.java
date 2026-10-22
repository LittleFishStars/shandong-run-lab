package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public final class hj7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static hj7 f42137a;
    public static final RootTelemetryConfiguration b = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public RootTelemetryConfiguration f16991a;

    @NonNull
    @KeepForSdk
    public static synchronized hj7 b() {
        if (f42137a == null) {
            f42137a = new hj7();
        }
        return f42137a;
    }

    @Nullable
    @KeepForSdk
    public RootTelemetryConfiguration a() {
        return this.f16991a;
    }

    @VisibleForTesting
    public final synchronized void c(@Nullable RootTelemetryConfiguration rootTelemetryConfiguration) {
        try {
            if (rootTelemetryConfiguration == null) {
                this.f16991a = b;
                return;
            }
            RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f16991a;
            if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.getVersion() < rootTelemetryConfiguration.getVersion()) {
                this.f16991a = rootTelemetryConfiguration;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
