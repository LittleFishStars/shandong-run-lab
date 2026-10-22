package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.jyc;
import com.zj.adlib.s4d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j1 extends zzed implements zzfp {
    private static final j1 zza;
    private int zzd;
    private int zze;

    static {
        j1 j1Var = new j1();
        zza = j1Var;
        zzed.zzU(j1.class, j1Var);
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
            return new j1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new s4d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
