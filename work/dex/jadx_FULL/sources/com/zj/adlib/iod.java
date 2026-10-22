package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_common.zzpt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class iod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static god f42408a;

    public static synchronized hnd a(zzpt zzptVar) {
        if (f42408a == null) {
            f42408a = new god(null);
        }
        return (hnd) f42408a.a(zzptVar);
    }

    public static synchronized hnd b(String str) {
        return a(zzpt.d("common").c());
    }
}
