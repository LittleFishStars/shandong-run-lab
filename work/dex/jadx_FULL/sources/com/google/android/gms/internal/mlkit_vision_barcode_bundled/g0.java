package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.rmc;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f31376a = new g0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ConcurrentMap f5805a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzgi f5804a = new c0();

    public static g0 a() {
        return f31376a;
    }

    public final zzgh b(Class cls) {
        rmc.c(cls, "messageType");
        zzgh zzghVarA = (zzgh) this.f5805a.get(cls);
        if (zzghVarA == null) {
            zzghVarA = this.f5804a.a(cls);
            rmc.c(cls, "messageType");
            rmc.c(zzghVarA, "schema");
            zzgh zzghVar = (zzgh) this.f5805a.putIfAbsent(cls, zzghVarA);
            if (zzghVar != null) {
                return zzghVar;
            }
        }
        return zzghVarA;
    }
}
