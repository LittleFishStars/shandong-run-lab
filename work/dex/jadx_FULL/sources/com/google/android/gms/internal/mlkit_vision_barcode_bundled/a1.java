package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.jyc;
import com.zj.adlib.k0d;
import com.zj.adlib.o0d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a1 extends zzed implements zzfp {
    private static final a1 zza;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh = 2;

    static {
        a1 a1Var = new a1();
        zza = a1Var;
        zzed.zzU(a1.class, a1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzd", "zze", o0d.f43644a, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new a1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new k0d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
