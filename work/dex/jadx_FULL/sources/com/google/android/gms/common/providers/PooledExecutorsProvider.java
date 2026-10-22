package com.google.android.gms.common.providers;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
@Deprecated
public class PooledExecutorsProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PooledExecutorFactory f31314a;

    public interface PooledExecutorFactory {
        @NonNull
        @KeepForSdk
        @Deprecated
        ScheduledExecutorService a();
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static synchronized PooledExecutorFactory a() {
        if (f31314a == null) {
            f31314a = new a();
        }
        return f31314a;
    }
}
