package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.hud;
import com.zj.adlib.sud;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class w1 extends zzed implements zzfp {
    private static final w1 zza;
    private int zzd;
    private a zze;

    static {
        w1 w1Var = new w1();
        zza = w1Var;
        zzed.zzU(w1.class, w1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0001\u0000\u0001\u000f\u000f\u0001\u0000\u0000\u0000\u000fဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new w1();
        }
        hud hudVar = null;
        if (i2 == 4) {
            return new sud(hudVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
