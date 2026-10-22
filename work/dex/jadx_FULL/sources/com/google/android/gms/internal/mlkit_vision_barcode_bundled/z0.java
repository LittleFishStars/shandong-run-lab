package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.d0d;
import com.zj.adlib.jyc;
import com.zj.adlib.zzc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class z0 extends zzed implements zzfp {
    private static final z0 zza;
    private int zzd;
    private String zze = "";
    private int zzf = 1;
    private boolean zzg;
    private int zzh;

    static {
        z0 z0Var = new z0();
        zza = z0Var;
        zzed.zzU(z0.class, z0Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", d0d.f41080a, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new z0();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new zzc(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
