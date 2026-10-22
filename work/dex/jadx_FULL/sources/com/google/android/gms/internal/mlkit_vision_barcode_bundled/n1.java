package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.jyc;
import com.zj.adlib.u5d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class n1 extends zzed implements zzfp {
    private static final n1 zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        n1 n1Var = new n1();
        zza = n1Var;
        zzed.zzU(n1.class, n1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new n1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new u5d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
