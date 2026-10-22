package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.a8c;
import com.zj.adlib.epd;
import com.zj.adlib.h8c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends zzed implements zzfp {
    private static final b zza;
    private int zzd;
    private int zze = 4369;
    private String zzf = "";

    static {
        b bVar = new b();
        zza = bVar;
        zzed.zzU(b.class, bVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", epd.f41495a, "zzf"});
        }
        if (i2 == 3) {
            return new b();
        }
        a8c a8cVar = null;
        if (i2 == 4) {
            return new h8c(a8cVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
