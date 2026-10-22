package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzei;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class eec extends zzed implements zzfp {
    private static final eec zza;
    private int zzd;
    private zzei zze = zzed.zzL();
    private zzei zzf = zzed.zzL();
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    static {
        eec eecVar = new eec();
        zza = eecVar;
        zzed.zzU(eec.class, eecVar);
    }

    public static pbc t() {
        return (pbc) zza.zzF();
    }

    public static /* synthetic */ void v(eec eecVar, int i) {
        eecVar.zzd |= 2;
        eecVar.zzh = i;
    }

    public static /* synthetic */ void w(eec eecVar, float f) {
        zzei zzeiVar = eecVar.zze;
        if (!zzeiVar.r()) {
            eecVar.zze = zzed.zzM(zzeiVar);
        }
        eecVar.zze.S(f);
    }

    public static /* synthetic */ void x(eec eecVar, float f) {
        zzei zzeiVar = eecVar.zzf;
        if (!zzeiVar.r()) {
            eecVar.zzf = zzed.zzM(zzeiVar);
        }
        eecVar.zzf.S(f);
    }

    public static /* synthetic */ void y(eec eecVar, int i) {
        eecVar.zzd |= 1;
        eecVar.zzg = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001\u0013\u0002\u0013\u0003ဋ\u0000\u0004ဋ\u0001\u0005ဋ\u0002\u0006ဋ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new eec();
        }
        o6c o6cVar = null;
        if (i2 == 4) {
            return new pbc(o6cVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
