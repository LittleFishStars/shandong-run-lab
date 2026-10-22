package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.jyc;
import com.zj.adlib.n5d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class m1 extends zzed implements zzfp {
    private static final m1 zza;
    private int zzd;
    private String zze = "";
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        m1 m1Var = new m1();
        zza = m1Var;
        zzed.zzU(m1.class, m1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new m1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new n5d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
