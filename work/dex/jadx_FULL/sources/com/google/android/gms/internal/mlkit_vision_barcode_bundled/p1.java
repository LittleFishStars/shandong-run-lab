package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.jyc;
import com.zj.adlib.q6d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class p1 extends zzed implements zzfp {
    private static final p1 zza;
    private int zzd;
    private String zze = "";

    static {
        p1 p1Var = new p1();
        zza = p1Var;
        zzed.zzU(p1.class, p1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new p1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new q6d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
