package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.zj.adlib.b1c;
import com.zj.adlib.e0c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class ActivityLifecycleObserver {
    @NonNull
    @KeepForSdk
    public static final ActivityLifecycleObserver a(@NonNull Activity activity) {
        return new b1c(e0c.k(activity));
    }

    @NonNull
    @KeepForSdk
    public abstract ActivityLifecycleObserver b(@NonNull Runnable runnable);
}
