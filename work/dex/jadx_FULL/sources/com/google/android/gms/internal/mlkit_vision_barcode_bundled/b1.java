package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.d1d;
import com.zj.adlib.jyc;
import com.zj.adlib.z0d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b1 extends zzed implements zzfp {
    private static final b1 zza;
    private int zzd;
    private int zze;
    private int zzf;
    private zzel zzg = zzed.zzO();
    private int zzh;

    static {
        b1 b1Var = new b1();
        zza = b1Var;
        zzed.zzU(b1.class, b1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002င\u0001\u0003\u001a\u0004င\u0002", new Object[]{"zzd", "zze", d1d.f41090a, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new b1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new z0d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
