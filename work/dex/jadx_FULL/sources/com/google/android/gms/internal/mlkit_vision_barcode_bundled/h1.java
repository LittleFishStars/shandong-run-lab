package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.a4d;
import com.zj.adlib.jyc;
import com.zj.adlib.l3d;
import com.zj.adlib.w3d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h1 extends zzed implements zzfp {
    private static final h1 zza;
    private int zzd;
    private boolean zzf;
    private int zzg;
    private boolean zzj;
    private int zzm;
    private int zzn;
    private boolean zzo;
    private int zze = -1;
    private zzdb zzh = zzdb.zzb;
    private String zzi = "";
    private boolean zzk = true;
    private boolean zzl = true;

    static {
        h1 h1Var = new h1();
        zza = h1Var;
        zzed.zzU(h1.class, h1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzeh zzehVar = a4d.f40452a;
            return zzed.zzR(zza, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003᠌\u0002\u0004ည\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\t᠌\b\n᠌\t\u000bဇ\n", new Object[]{"zzd", "zze", "zzf", "zzg", w3d.f45520a, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzehVar, "zzn", zzehVar, "zzo"});
        }
        if (i2 == 3) {
            return new h1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new l3d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
