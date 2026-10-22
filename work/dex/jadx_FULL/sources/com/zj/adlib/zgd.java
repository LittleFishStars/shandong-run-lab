package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class zgd extends zzed implements zzfp {
    private static final zgd zza;
    private int zzd;
    private String zze = "";
    private zzdb zzf;
    private String zzg;
    private zzdb zzh;
    private float zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;

    static {
        zgd zgdVar = new zgd();
        zza = zgdVar;
        zzed.zzU(zgd.class, zgdVar);
    }

    public zgd() {
        zzdb zzdbVar = zzdb.zzb;
        this.zzf = zzdbVar;
        this.zzg = "";
        this.zzh = zzdbVar;
        this.zzi = 0.25f;
        this.zzj = 0.25f;
        this.zzk = 0.5f;
        this.zzl = 0.85f;
        this.zzm = 1;
    }

    public static ydd t() {
        return (ydd) zza.zzF();
    }

    public static /* synthetic */ void v(zgd zgdVar, zzdb zzdbVar) {
        zzdbVar.getClass();
        zgdVar.zzd |= 2;
        zgdVar.zzf = zzdbVar;
    }

    public static /* synthetic */ void w(zgd zgdVar, zzdb zzdbVar) {
        zzdbVar.getClass();
        zgdVar.zzd |= 8;
        zgdVar.zzh = zzdbVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ည\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007ခ\u0006\bခ\u0007\tင\b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zgd();
        }
        xad xadVar = null;
        if (i2 == 4) {
            return new ydd(xadVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
