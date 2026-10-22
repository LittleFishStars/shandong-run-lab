package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class em0 extends zzed<em0, p7d> implements zzfp {
    private static final em0 zza;
    private int zzd;
    private tzc zze;
    private zgd zzf;

    static {
        em0 em0Var = new em0();
        zza = em0Var;
        zzed.zzU(em0.class, em0Var);
    }

    public static p7d t() {
        return (p7d) zza.zzF();
    }

    public static /* synthetic */ void v(em0 em0Var, tzc tzcVar) {
        tzcVar.getClass();
        em0Var.zze = tzcVar;
        em0Var.zzd |= 1;
    }

    public static /* synthetic */ void w(em0 em0Var, zgd zgdVar) {
        zgdVar.getClass();
        em0Var.zzf = zgdVar;
        em0Var.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    @NonNull
    public final Object zzg(int i, @NonNull Object obj, @NonNull Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new em0();
        }
        q3d q3dVar = null;
        if (i2 == 4) {
            return new p7d(q3dVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
