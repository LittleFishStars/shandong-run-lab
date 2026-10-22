package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.jyc;
import com.zj.adlib.uyc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class w0 extends zzed implements zzfp {
    private static final w0 zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        w0 w0Var = new w0();
        zza = w0Var;
        zzed.zzU(w0.class, w0Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new w0();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new uyc(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
