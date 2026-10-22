package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.fvd;
import com.zj.adlib.n7c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a extends zzed implements zzfp {
    private static final a zza;
    private int zzd;
    private b zze;
    private boolean zzf;

    static {
        a aVar = new a();
        zza = aVar;
        zzed.zzU(a.class, aVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new a();
        }
        fvd fvdVar = null;
        if (i2 == 4) {
            return new n7c(fvdVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
