package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.g5d;
import com.zj.adlib.jyc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class l1 extends zzed implements zzfp {
    private static final l1 zza;
    private int zzd;
    private zzel zze = zzed.zzO();
    private m1 zzf;
    private w0 zzg;

    static {
        l1 l1Var = new l1();
        zza = l1Var;
        zzed.zzU(l1.class, l1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzd", "zze", q1.class, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new l1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new g5d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
