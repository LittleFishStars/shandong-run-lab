package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.m7d;
import com.zj.adlib.wad;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class t1 extends zzed implements zzfp {
    private static final t1 zza;
    private int zzd;
    private zzel zze = zzed.zzO();
    private String zzf = "";

    static {
        t1 t1Var = new t1();
        zza = t1Var;
        zzed.zzU(t1.class, t1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001a\u0002ဈ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new t1();
        }
        m7d m7dVar = null;
        if (i2 == 4) {
            return new wad(m7dVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
