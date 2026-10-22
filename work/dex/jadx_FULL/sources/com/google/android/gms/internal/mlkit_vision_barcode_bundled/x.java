package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.llc;
import com.zj.adlib.whc;
import com.zj.adlib.ykc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class x extends zzed implements zzfp {
    public static final llc zza;
    private static final x zzd;
    private int zze;
    private s1 zzj;
    private x zzk;
    private w1 zzl;
    private byte zzm = 2;
    private String zzf = "";
    private zzel zzg = zzed.zzO();
    private zzel zzh = zzed.zzO();
    private zzel zzi = zzed.zzO();

    static {
        x xVar = new x();
        zzd = xVar;
        zzed.zzU(x.class, xVar);
        zza = zzed.g(s1.v(), xVar, xVar, null, 12208774, zzho.zzk, x.class);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return zzed.zzR(zzd, "\u0001\u0007\u0000\u0001\u0002Ǵ\u0007\u0000\u0003\u0004\u0002Л\u0005Л\u0006\u001b\bᐉ\u0001\nဈ\u0000\u000bᐉ\u0002Ǵဉ\u0003", new Object[]{"zze", "zzg", g1.class, "zzi", g1.class, "zzh", t1.class, "zzj", "zzf", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new x();
        }
        whc whcVar = null;
        if (i2 == 4) {
            return new ykc(whcVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
