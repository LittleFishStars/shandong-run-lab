package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.v0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzei;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class tzc extends zzed implements zzfp {
    private static final tzc zza;
    private int zzd;
    private koc zzj;
    private v0 zzm;
    private String zze = "";
    private zzdb zzf = zzdb.zzb;
    private int zzg = 10;
    private float zzh = 0.5f;
    private float zzi = 0.05f;
    private zzei zzk = zzed.zzL();
    private int zzl = 1;
    private int zzn = 320;
    private int zzo = 4;
    private int zzp = 2;

    static {
        tzc tzcVar = new tzc();
        zza = tzcVar;
        zzed.zzU(tzc.class, tzcVar);
    }

    public static yvc t() {
        return (yvc) zza.zzF();
    }

    public static /* synthetic */ void v(tzc tzcVar, koc kocVar) {
        kocVar.getClass();
        tzcVar.zzj = kocVar;
        tzcVar.zzd |= 32;
    }

    public static /* synthetic */ void w(tzc tzcVar, zzdb zzdbVar) {
        zzdbVar.getClass();
        tzcVar.zzd |= 2;
        tzcVar.zzf = zzdbVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဋ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ဉ\u0005\u0007\u0013\bင\u0006\tဉ\u0007\nင\b\u000bင\t\fင\n", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
        }
        if (i2 == 3) {
            return new tzc();
        }
        asc ascVar = null;
        if (i2 == 4) {
            return new yvc(ascVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
