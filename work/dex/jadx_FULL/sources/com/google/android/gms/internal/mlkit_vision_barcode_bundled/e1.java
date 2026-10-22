package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.jyc;
import com.zj.adlib.m2d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e1 extends zzed implements zzfp {
    private static final e1 zza;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        e1 e1Var = new e1();
        zza = e1Var;
        zzed.zzU(e1.class, e1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0002\u0000\u0001\u0005\u0006\u0002\u0000\u0000\u0000\u0005ဇ\u0000\u0006ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new e1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new m2d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
