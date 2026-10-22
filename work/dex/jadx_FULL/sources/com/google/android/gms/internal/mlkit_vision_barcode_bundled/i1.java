package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.h4d;
import com.zj.adlib.jyc;
import com.zj.adlib.l4d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i1 extends zzed implements zzfp {
    private static final i1 zza;
    private int zzd;
    private int zze;
    private int zzf = 100;
    private int zzg;

    static {
        i1 i1Var = new i1();
        zza = i1Var;
        zzed.zzU(i1.class, i1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", h4d.f42054a, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new i1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new l4d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
