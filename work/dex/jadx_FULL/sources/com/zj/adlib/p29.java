package com.zj.adlib;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.TelemetryLoggingClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class p29 {
    @NonNull
    @KeepForSdk
    public static TelemetryLoggingClient a(@NonNull Context context) {
        return b(context, q29.f44112a);
    }

    @NonNull
    @KeepForSdk
    public static TelemetryLoggingClient b(@NonNull Context context, @NonNull q29 q29Var) {
        return new z4c(context, q29Var);
    }
}
