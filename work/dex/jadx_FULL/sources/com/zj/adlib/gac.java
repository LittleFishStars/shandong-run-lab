package com.zj.adlib;

import android.os.SystemClock;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class gac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzbf f41860a;

    static {
        zzbf eacVar;
        try {
            SystemClock.elapsedRealtimeNanos();
            eacVar = new cac();
        } catch (Throwable unused) {
            SystemClock.elapsedRealtime();
            eacVar = new eac();
        }
        f41860a = eacVar;
    }

    public static zzbf a() {
        return f41860a;
    }
}
