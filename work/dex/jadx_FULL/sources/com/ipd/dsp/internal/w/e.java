package com.ipd.dsp.internal.w;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.ipd.dsp.Dsp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38580a = "ConnectivityMonitor";
    public static final String b = "android.permission.ACCESS_NETWORK_STATE";

    @Override // com.ipd.dsp.internal.w.c
    @NonNull
    public b a(@NonNull Context context, @NonNull b.a aVar) {
        boolean z = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new d(context, aVar) : new l();
    }
}
