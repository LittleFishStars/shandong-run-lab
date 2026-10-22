package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.ifc;
import com.zj.adlib.pfc;
import com.zj.adlib.qdc;
import com.zj.adlib.sfc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g extends zzed implements zzfp {
    private static final g zza;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        g gVar = new g();
        zza = gVar;
        zzed.zzU(g.class, gVar);
    }

    public static g u() {
        return zza;
    }

    public final String v() {
        return this.zzf;
    }

    public final int w() {
        int iA = sfc.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", pfc.f43975a, "zzf"});
        }
        if (i2 == 3) {
            return new g();
        }
        qdc qdcVar = null;
        if (i2 == 4) {
            return new ifc(qdcVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
