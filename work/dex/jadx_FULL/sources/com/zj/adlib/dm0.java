package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class dm0 extends zzed<dm0, t3d> implements zzfp {
    private static final dm0 zza;
    private int zzd;
    private int zzf;
    private byte zzi = 2;
    private zzel zze = zzed.zzO();
    private String zzg = "";
    private zzdb zzh = zzdb.zzb;

    static {
        dm0 dm0Var = new dm0();
        zza = dm0Var;
        zzed.zzU(dm0.class, dm0Var);
    }

    public static dm0 u(byte[] bArr, qjc qjcVar) throws zzeo {
        return (dm0) zzed.zzK(zza, bArr, qjcVar);
    }

    @NonNull
    public final List v() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    @NonNull
    public final Object zzg(int i, @NonNull Object obj, @NonNull Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0002\u0001Л\u0002ᴌ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzd", "zze", nec.class, "zzf", z8c.f46211a, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new dm0();
        }
        a7c a7cVar = null;
        if (i2 == 4) {
            return new t3d(a7cVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
