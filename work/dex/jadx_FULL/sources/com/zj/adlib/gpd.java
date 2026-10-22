package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.e;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.f;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.g;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class gpd extends zzed implements zzfp {
    private static final gpd zza;
    private int zzd;
    private f zze;
    private byte zzm = 2;
    private String zzf = "";
    private String zzg = "";
    private zzel zzh = zzed.zzO();
    private zzel zzi = zzed.zzO();
    private zzel zzj = zzed.zzO();
    private zzel zzk = zzed.zzO();
    private String zzl = "";

    static {
        gpd gpdVar = new gpd();
        zza = gpdVar;
        zzed.zzU(gpd.class, gpdVar);
    }

    public static gpd v() {
        return zza;
    }

    public final List A() {
        return this.zzh;
    }

    public final List B() {
        return this.zzj;
    }

    public final f t() {
        f fVar = this.zze;
        return fVar == null ? f.u() : fVar;
    }

    public final String w() {
        return this.zzf;
    }

    public final String x() {
        return this.zzg;
    }

    public final List y() {
        return this.zzk;
    }

    public final List z() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0004\u0001\u0001ဉ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004\u001b\u0005\u001b\u0006\u001a\u0007Л\bဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", g.class, "zzi", bvd.class, "zzj", "zzk", e.class, "zzl"});
        }
        if (i2 == 3) {
            return new gpd();
        }
        a7c a7cVar = null;
        if (i2 == 4) {
            return new nnd(a7cVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
