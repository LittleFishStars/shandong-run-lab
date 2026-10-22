package com.zj.adlib;

import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_vision_barcode.zzux;
import com.google.android.gms.internal.mlkit_vision_barcode.zzuy;
import com.google.android.gms.internal.mlkit_vision_barcode.zzuz;
import com.google.android.gms.internal.mlkit_vision_barcode.zzva;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzve;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvh;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvj;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.barcode.common.internal.BarcodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class aed implements BarcodeSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzvj f40519a;

    public aed(zzvj zzvjVar) {
        this.f40519a = zzvjVar;
    }

    @Nullable
    public static Barcode.a p(@Nullable zzuy zzuyVar) {
        if (zzuyVar == null) {
            return null;
        }
        return new Barcode.a(zzuyVar.zzf(), zzuyVar.zzd(), zzuyVar.zza(), zzuyVar.zzb(), zzuyVar.zzc(), zzuyVar.zze(), zzuyVar.zzh(), zzuyVar.zzg());
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final String a() {
        return this.f40519a.zzm();
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final String b() {
        return this.f40519a.zzl();
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.h c() {
        zzvh zzvhVarZzj = this.f40519a.zzj();
        if (zzvhVarZzj != null) {
            return new Barcode.h(zzvhVarZzj.zza(), zzvhVarZzj.zzb());
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.Phone d() {
        zzvf zzvfVarZzh = this.f40519a.zzh();
        if (zzvfVarZzh != null) {
            return new Barcode.Phone(zzvfVarZzh.zzb(), zzvfVarZzh.zza());
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final byte[] e() {
        return this.f40519a.zzn();
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.e f() {
        zzvd zzvdVarZzg = this.f40519a.zzg();
        if (zzvdVarZzg != null) {
            return new Barcode.e(zzvdVarZzg.zza(), zzvdVarZzg.zzb());
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.b g() {
        zzuz zzuzVarZzc = this.f40519a.zzc();
        if (zzuzVarZzc != null) {
            return new Barcode.b(zzuzVarZzc.zzg(), zzuzVarZzc.zzc(), zzuzVarZzc.zzd(), zzuzVarZzc.zze(), zzuzVarZzc.zzf(), p(zzuzVarZzc.zzb()), p(zzuzVarZzc.zza()));
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final int getFormat() {
        return this.f40519a.zza();
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.c h() {
        zzva zzvaVarZzd = this.f40519a.zzd();
        if (zzvaVarZzd == null) {
            return null;
        }
        zzve zzveVarZza = zzvaVarZzd.zza();
        Barcode.f fVar = zzveVarZza != null ? new Barcode.f(zzveVarZza.zzb(), zzveVarZza.zzf(), zzveVarZza.zze(), zzveVarZza.zza(), zzveVarZza.zzd(), zzveVarZza.zzc(), zzveVarZza.zzg()) : null;
        String strZzb = zzvaVarZzd.zzb();
        String strZzc = zzvaVarZzd.zzc();
        zzvf[] zzvfVarArrZzf = zzvaVarZzd.zzf();
        ArrayList arrayList = new ArrayList();
        if (zzvfVarArrZzf != null) {
            for (zzvf zzvfVar : zzvfVarArrZzf) {
                if (zzvfVar != null) {
                    arrayList.add(new Barcode.Phone(zzvfVar.zzb(), zzvfVar.zza()));
                }
            }
        }
        zzvc[] zzvcVarArrZze = zzvaVarZzd.zze();
        ArrayList arrayList2 = new ArrayList();
        if (zzvcVarArrZze != null) {
            for (zzvc zzvcVar : zzvcVarArrZze) {
                if (zzvcVar != null) {
                    arrayList2.add(new Barcode.Email(zzvcVar.zza(), zzvcVar.zzb(), zzvcVar.zzd(), zzvcVar.zzc()));
                }
            }
        }
        List listAsList = zzvaVarZzd.zzg() != null ? Arrays.asList((String[]) yw6.l(zzvaVarZzd.zzg())) : new ArrayList();
        zzux[] zzuxVarArrZzd = zzvaVarZzd.zzd();
        ArrayList arrayList3 = new ArrayList();
        if (zzuxVarArrZzd != null) {
            for (zzux zzuxVar : zzuxVarArrZzd) {
                if (zzuxVar != null) {
                    arrayList3.add(new Barcode.Address(zzuxVar.zza(), zzuxVar.zzb()));
                }
            }
        }
        return new Barcode.c(fVar, strZzb, strZzc, arrayList, arrayList2, listAsList, arrayList3);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Rect i() {
        Point[] pointArrZzo = this.f40519a.zzo();
        if (pointArrZzo == null) {
            return null;
        }
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        for (Point point : pointArrZzo) {
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
        }
        return new Rect(iMin, iMin2, iMax, iMax2);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.WiFi j() {
        zzvi zzviVarZzk = this.f40519a.zzk();
        if (zzviVarZzk != null) {
            return new Barcode.WiFi(zzviVarZzk.zzc(), zzviVarZzk.zzb(), zzviVarZzk.zza());
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.Email k() {
        zzvc zzvcVarZzf = this.f40519a.zzf();
        if (zzvcVarZzf == null) {
            return null;
        }
        return new Barcode.Email(zzvcVarZzf.zza(), zzvcVarZzf.zzb(), zzvcVarZzf.zzd(), zzvcVarZzf.zzc());
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final int l() {
        return this.f40519a.zzb();
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.g m() {
        zzvg zzvgVarZzi = this.f40519a.zzi();
        if (zzvgVarZzi != null) {
            return new Barcode.g(zzvgVarZzi.zza(), zzvgVarZzi.zzb());
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.d n() {
        zzvb zzvbVarZze = this.f40519a.zze();
        if (zzvbVarZze != null) {
            return new Barcode.d(zzvbVarZze.zzf(), zzvbVarZze.zzh(), zzvbVarZze.zzn(), zzvbVarZze.zzl(), zzvbVarZze.zzi(), zzvbVarZze.zzc(), zzvbVarZze.zza(), zzvbVarZze.zzb(), zzvbVarZze.zzd(), zzvbVarZze.zzm(), zzvbVarZze.zzj(), zzvbVarZze.zzg(), zzvbVarZze.zze(), zzvbVarZze.zzk());
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Point[] o() {
        return this.f40519a.zzo();
    }
}
