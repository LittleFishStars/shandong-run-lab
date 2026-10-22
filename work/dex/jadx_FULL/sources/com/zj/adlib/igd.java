package com.zj.adlib;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.mlkit_vision_common.zziv;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class igd {
    @WorkerThread
    public static void a(bfd bfdVar, int i, int i2, long j, int i3, int i4, int i5, int i6) {
        bfdVar.c(c(i, i2, j, i3, i4, i5, i6), zziv.INPUT_IMAGE_CONSTRUCTION);
    }

    @WorkerThread
    public static void b(bfd bfdVar, int i, int i2, long j, int i3, int i4, int i5, int i6) {
        bfdVar.c(c(i, i2, j, i3, i4, i5, i6), zziv.ODML_IMAGE);
    }

    public static fgd c(int i, int i2, long j, int i3, int i4, int i5, int i6) {
        return new fgd(i, i2, i5, i3, i4, SystemClock.elapsedRealtime() - j, i6);
    }
}
