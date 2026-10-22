package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class wy3 {

    @VisibleForTesting
    public static int b = 31;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45711a = 1;

    @NonNull
    @CanIgnoreReturnValue
    @KeepForSdk
    public wy3 a(@Nullable Object obj) {
        this.f45711a = (b * this.f45711a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    @KeepForSdk
    public int b() {
        return this.f45711a;
    }

    @NonNull
    @CanIgnoreReturnValue
    public final wy3 c(boolean z) {
        this.f45711a = (b * this.f45711a) + (z ? 1 : 0);
        return this;
    }
}
