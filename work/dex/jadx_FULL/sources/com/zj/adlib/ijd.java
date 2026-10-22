package com.zj.adlib;

import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_vision_barcode.zzi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzm;
import com.google.android.gms.internal.mlkit_vision_barcode.zzn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzt;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.barcode.common.internal.BarcodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ijd implements BarcodeSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzu f42373a;

    public ijd(zzu zzuVar) {
        this.f42373a = zzuVar;
    }

    @Nullable
    public static Barcode.a p(@Nullable zzj zzjVar) {
        if (zzjVar == null) {
            return null;
        }
        return new Barcode.a(zzjVar.zza, zzjVar.zzb, zzjVar.zzc, zzjVar.zzd, zzjVar.zze, zzjVar.zzf, zzjVar.zzg, zzjVar.zzh);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final String a() {
        return this.f42373a.zzb;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final String b() {
        return this.f42373a.zzc;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.h c() {
        zzs zzsVar = this.f42373a.zzj;
        if (zzsVar != null) {
            return new Barcode.h(zzsVar.zza, zzsVar.zzb);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.Phone d() {
        zzq zzqVar = this.f42373a.zzg;
        if (zzqVar != null) {
            return new Barcode.Phone(zzqVar.zzb, zzqVar.zza);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final byte[] e() {
        return this.f42373a.zzo;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.e f() {
        zzo zzoVar = this.f42373a.zzk;
        if (zzoVar != null) {
            return new Barcode.e(zzoVar.zza, zzoVar.zzb);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.b g() {
        zzk zzkVar = this.f42373a.zzl;
        if (zzkVar == null) {
            return null;
        }
        return new Barcode.b(zzkVar.zza, zzkVar.zzb, zzkVar.zzc, zzkVar.zzd, zzkVar.zze, p(zzkVar.zzf), p(zzkVar.zzg));
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final int getFormat() {
        return this.f42373a.zza;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.c h() {
        zzl zzlVar = this.f42373a.zzm;
        if (zzlVar == null) {
            return null;
        }
        zzp zzpVar = zzlVar.zza;
        Barcode.f fVar = zzpVar != null ? new Barcode.f(zzpVar.zza, zzpVar.zzb, zzpVar.zzc, zzpVar.zzd, zzpVar.zze, zzpVar.zzf, zzpVar.zzg) : null;
        String str = zzlVar.zzb;
        String str2 = zzlVar.zzc;
        zzq[] zzqVarArr = zzlVar.zzd;
        ArrayList arrayList = new ArrayList();
        if (zzqVarArr != null) {
            for (zzq zzqVar : zzqVarArr) {
                if (zzqVar != null) {
                    arrayList.add(new Barcode.Phone(zzqVar.zzb, zzqVar.zza));
                }
            }
        }
        zzn[] zznVarArr = zzlVar.zze;
        ArrayList arrayList2 = new ArrayList();
        if (zznVarArr != null) {
            for (zzn zznVar : zznVarArr) {
                if (zznVar != null) {
                    arrayList2.add(new Barcode.Email(zznVar.zza, zznVar.zzb, zznVar.zzc, zznVar.zzd));
                }
            }
        }
        String[] strArr = zzlVar.zzf;
        List listAsList = strArr != null ? Arrays.asList(strArr) : new ArrayList();
        zzi[] zziVarArr = zzlVar.zzg;
        ArrayList arrayList3 = new ArrayList();
        if (zziVarArr != null) {
            for (zzi zziVar : zziVarArr) {
                if (zziVar != null) {
                    arrayList3.add(new Barcode.Address(zziVar.zza, zziVar.zzb));
                }
            }
        }
        return new Barcode.c(fVar, str, str2, arrayList, arrayList2, listAsList, arrayList3);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Rect i() {
        zzu zzuVar = this.f42373a;
        if (zzuVar.zze == null) {
            return null;
        }
        int i = 0;
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        while (true) {
            Point[] pointArr = zzuVar.zze;
            if (i >= pointArr.length) {
                return new Rect(iMin, iMin2, iMax, iMax2);
            }
            Point point = pointArr[i];
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
            i++;
        }
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.WiFi j() {
        zzt zztVar = this.f42373a.zzi;
        if (zztVar != null) {
            return new Barcode.WiFi(zztVar.zza, zztVar.zzb, zztVar.zzc);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.Email k() {
        zzn zznVar = this.f42373a.zzf;
        if (zznVar != null) {
            return new Barcode.Email(zznVar.zza, zznVar.zzb, zznVar.zzc, zznVar.zzd);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final int l() {
        return this.f42373a.zzd;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.g m() {
        zzr zzrVar = this.f42373a.zzh;
        if (zzrVar != null) {
            return new Barcode.g(zzrVar.zza, zzrVar.zzb);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Barcode.d n() {
        zzm zzmVar = this.f42373a.zzn;
        if (zzmVar == null) {
            return null;
        }
        return new Barcode.d(zzmVar.zza, zzmVar.zzb, zzmVar.zzc, zzmVar.zzd, zzmVar.zze, zzmVar.zzf, zzmVar.zzg, zzmVar.zzh, zzmVar.zzi, zzmVar.zzj, zzmVar.zzk, zzmVar.zzl, zzmVar.zzm, zzmVar.zzn);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    @Nullable
    public final Point[] o() {
        return this.f42373a.zze;
    }
}
