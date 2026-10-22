package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.llc;
import com.zj.adlib.ord;
import com.zj.adlib.rsd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class v1 extends zzed implements zzfp {
    public static final llc zza;
    private static final v1 zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private s1 zzh;
    private byte zzi = 2;

    static {
        v1 v1Var = new v1();
        zzd = v1Var;
        zzed.zzU(v1.class, v1Var);
        zza = zzed.g(s1.v(), v1Var, v1Var, null, 13258261, zzho.zzk, v1.class);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzed.zzR(zzd, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔅ\u0000\u0002ᔅ\u0001\u0003ᐉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new v1();
        }
        ord ordVar = null;
        if (i2 == 4) {
            return new rsd(ordVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
