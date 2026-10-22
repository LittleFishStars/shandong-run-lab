package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_vision_barcode.zztp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class etd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static dtd f41526a;

    public static synchronized lsd a(zztp zztpVar) {
        if (f41526a == null) {
            f41526a = new dtd(null);
        }
        return (lsd) f41526a.a(zztpVar);
    }

    public static synchronized lsd b(String str) {
        return a(zztp.d(str).c());
    }
}
