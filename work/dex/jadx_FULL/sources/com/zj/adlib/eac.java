package com.zj.adlib;

import android.os.SystemClock;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbf;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class eac extends zzbf {
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbf
    public final long a() {
        return TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
    }
}
