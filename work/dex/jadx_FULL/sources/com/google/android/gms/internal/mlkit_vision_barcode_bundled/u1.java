package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.fjd;
import com.zj.adlib.ygd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class u1 extends zzed implements zzfp {
    private static final u1 zza;
    private int zzd;
    private s1 zzj;
    private byte zzk = 2;
    private zzej zze = zzed.zzN();
    private zzei zzf = zzed.zzL();
    private boolean zzg = true;
    private String zzh = "";
    private String zzi = "";

    static {
        u1 u1Var = new u1();
        zza = u1Var;
        zzed.zzU(u1.class, u1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0006\u0000\u0001\u0001\u000f\u0006\u0000\u0002\u0001\u0001\u0016\u0002\u0013\u0003ဇ\u0000\u0004ဈ\u0001\u0005ဈ\u0002\u000fᐉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new u1();
        }
        ygd ygdVar = null;
        if (i2 == 4) {
            return new fjd(ygdVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
