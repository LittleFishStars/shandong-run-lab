package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.e7d;
import com.zj.adlib.i7d;
import com.zj.adlib.jyc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class r1 extends zzed implements zzfp {
    private static final r1 zza;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        r1 r1Var = new r1();
        zza = r1Var;
        zzed.zzU(r1.class, r1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", "zzf", e7d.f41367a});
        }
        if (i2 == 3) {
            return new r1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new i7d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
