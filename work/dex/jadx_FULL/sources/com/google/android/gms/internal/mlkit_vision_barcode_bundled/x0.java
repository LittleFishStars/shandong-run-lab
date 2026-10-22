package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.bzc;
import com.zj.adlib.jyc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class x0 extends zzed implements zzfp {
    private static final x0 zza;
    private int zzd;
    private int zze = -1;

    static {
        x0 x0Var = new x0();
        zza = x0Var;
        zzed.zzU(x0.class, x0Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new x0();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new bzc(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
