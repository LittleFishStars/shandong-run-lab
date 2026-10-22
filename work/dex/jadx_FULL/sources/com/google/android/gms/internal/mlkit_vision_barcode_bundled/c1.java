package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.j1d;
import com.zj.adlib.jyc;
import com.zj.adlib.q1d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c1 extends zzed implements zzfp {
    private static final c1 zza;
    private int zzd;
    private int zze;
    private long zzf;

    static {
        c1 c1Var = new c1();
        zza = c1Var;
        zzed.zzU(c1.class, c1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", q1d.f44107a, "zzf"});
        }
        if (i2 == 3) {
            return new c1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new j1d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
