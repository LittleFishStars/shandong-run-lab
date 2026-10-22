package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.jyc;
import com.zj.adlib.z4d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k1 extends zzed implements zzfp {
    private static final k1 zza;
    private int zzd;
    private String zze = "";
    private n1 zzf;

    static {
        k1 k1Var = new k1();
        zza = k1Var;
        zzed.zzU(k1.class, k1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new k1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new z4d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
