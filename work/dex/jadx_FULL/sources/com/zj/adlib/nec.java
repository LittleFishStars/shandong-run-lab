package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.g;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzej;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class nec extends zzed implements zzfp {
    private static final nec zza;
    private int zzd;
    private int zze;
    private zzdb zzf;
    private String zzg;
    private int zzh;
    private gpd zzi;
    private bvd zzj;
    private g zzk;
    private v8c zzl;
    private z9c zzm;
    private g9c zzn;
    private c8c zzo;
    private pld zzp;
    private srd zzq;
    private zad zzr;
    private zzel zzs;
    private zzej zzt;
    private String zzu;
    private zzel zzv;
    private boolean zzw;
    private double zzx;
    private zzdb zzy;
    private byte zzz = 2;

    static {
        nec necVar = new nec();
        zza = necVar;
        zzed.zzU(nec.class, necVar);
    }

    public nec() {
        zzdb zzdbVar = zzdb.zzb;
        this.zzf = zzdbVar;
        this.zzg = "";
        this.zzs = zzed.zzO();
        this.zzt = zzed.zzN();
        this.zzu = "";
        this.zzv = zzed.zzO();
        this.zzw = true;
        this.zzy = zzdbVar;
    }

    public static /* synthetic */ void I(nec necVar, int i, l8c l8cVar) {
        l8cVar.getClass();
        zzel zzelVar = necVar.zzs;
        if (!zzelVar.r()) {
            necVar.zzs = zzed.zzP(zzelVar);
        }
        necVar.zzs.set(i, l8cVar);
    }

    public final bvd A() {
        bvd bvdVar = this.zzj;
        return bvdVar == null ? bvd.u() : bvdVar;
    }

    public final c8c B() {
        c8c c8cVar = this.zzo;
        return c8cVar == null ? c8c.w() : c8cVar;
    }

    public final v8c C() {
        v8c v8cVar = this.zzl;
        return v8cVar == null ? v8c.u() : v8cVar;
    }

    public final g9c D() {
        g9c g9cVar = this.zzn;
        return g9cVar == null ? g9c.u() : g9cVar;
    }

    public final z9c E() {
        z9c z9cVar = this.zzm;
        return z9cVar == null ? z9c.u() : z9cVar;
    }

    public final zzdb F() {
        return this.zzf;
    }

    public final String G() {
        return this.zzg;
    }

    public final List H() {
        return this.zzs;
    }

    public final boolean J() {
        return (this.zzd & 2048) != 0;
    }

    public final boolean K() {
        return (this.zzd & 16) != 0;
    }

    public final boolean L() {
        return (this.zzd & 4096) != 0;
    }

    public final boolean M() {
        return (this.zzd & 32) != 0;
    }

    public final boolean N() {
        return (this.zzd & 1024) != 0;
    }

    public final boolean O() {
        return (this.zzd & 64) != 0;
    }

    public final boolean P() {
        return (this.zzd & 128) != 0;
    }

    public final boolean Q() {
        return (this.zzd & 512) != 0;
    }

    public final boolean R() {
        return (this.zzd & 256) != 0;
    }

    public final int S() {
        int iA = goc.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    public final int t() {
        int iA = wzc.a(this.zzh);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    public final int u() {
        return this.zzs.size();
    }

    public final g v() {
        g gVar = this.zzk;
        return gVar == null ? g.u() : gVar;
    }

    public final pld x() {
        pld pldVar = this.zzp;
        return pldVar == null ? pld.w() : pldVar;
    }

    public final gpd y() {
        gpd gpdVar = this.zzi;
        return gpdVar == null ? gpd.v() : gpdVar;
    }

    public final srd z() {
        srd srdVar = this.zzq;
        return srdVar == null ? srd.u() : srdVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzz);
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0003\u000b\u0001ᴌ\u0000\u0002ᔊ\u0001\u0003ᔈ\u0002\u0004ᴌ\u0003\u0005ᐉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bᐉ\u0007\tᐉ\b\nᐉ\t\u000bЛ\fဈ\u000e\rЛ\u000eည\u0011\u000fᐉ\n\u0010ဉ\u000b\u0011ဉ\f\u0012\u0016\u0013ဉ\r\u0014ဇ\u000f\u0015က\u0010", new Object[]{"zzd", "zze", vkc.f45377a, "zzf", "zzg", "zzh", cwc.f41058a, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzs", l8c.class, "zzu", "zzv", l8c.class, "zzy", "zzo", "zzp", "zzq", "zzt", "zzr", "zzw", "zzx"});
        }
        if (i2 == 3) {
            return new nec();
        }
        a7c a7cVar = null;
        if (i2 == 4) {
            return new hbc(a7cVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzz = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
