package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class koc extends zzed implements zzfp {
    private static final koc zza;
    private zzel zzd = zzed.zzO();

    static {
        koc kocVar = new koc();
        zza = kocVar;
        zzed.zzU(koc.class, kocVar);
    }

    public static blc t() {
        return (blc) zza.zzF();
    }

    public static /* synthetic */ void v(koc kocVar, eec eecVar) {
        eecVar.getClass();
        zzel zzelVar = kocVar.zzd;
        if (!zzelVar.r()) {
            kocVar.zzd = zzed.zzP(zzelVar);
        }
        kocVar.zzd.add(eecVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", eec.class});
        }
        if (i2 == 3) {
            return new koc();
        }
        zhc zhcVar = null;
        if (i2 == 4) {
            return new blc(zhcVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
